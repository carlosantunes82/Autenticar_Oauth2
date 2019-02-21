package br.com.raiadrogasil.cadastroclientepbmrproxy.resource;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.MedicoDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@Api(value = "PBM", description = "Operações pertinentes a busca de dados do Medico.")
public class MedicoResource {

    private final String TC_SERVICOS_URL;
    private RestTemplate restClient;

    public MedicoResource(@Autowired RestTemplate restClient,
                          @Value("${terminalconsultaservicos.url}") String tcServicosUrl){
        this.restClient = restClient;
        this.TC_SERVICOS_URL = tcServicosUrl;
    }

    @ApiOperation(value = "Buscar dados do medico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Medico encontrado"),
            @ApiResponse(code = 500, message = "Erro interno."),
    })
    @RequestMapping("v1/medico/crm/{crm}/uf/{uf}")
    public ResponseEntity getMedicoPor(
                               @Valid @Positive(message = "CRM deve ser maior que zero")
                                   @NotNull(message = "CRM deve ser informado")
                                   @Digits(integer = 10, fraction = 0, message = "CRM deve conter apenas números")
                                   @PathVariable long crm,
                               @Valid @Size(min = 2, max = 2, message = "UF deve conter dois caractéres")
                                   @NotNull(message = "UF deve ser informado")
                                   @PathVariable String uf) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("uf", uf);
        variables.put("crm", crm);
        ResponseEntity response = restClient.exchange(TC_SERVICOS_URL + "aderenciaTratamento/medico/{crm}/{uf}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MedicoDto>>(){},
                variables);

        return ResponseEntity.ok(response.getBody());
    }

}
