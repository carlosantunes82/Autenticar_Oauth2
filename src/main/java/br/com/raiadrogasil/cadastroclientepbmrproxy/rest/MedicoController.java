package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.Medico;
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
@RequestMapping("medico")
public class MedicoController {

    private final String TC_SERVICOS_URL;
    private RestTemplate restClient;

    public MedicoController(@Autowired RestTemplate restClient,
                            @Value("${terminalconsultaservicos.url}") String tcServicosUrl){
        this.restClient = restClient;
        this.TC_SERVICOS_URL = tcServicosUrl;
    }


    @RequestMapping("/crm/{crm}/uf/{uf}")
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
        return restClient.exchange(TC_SERVICOS_URL + "aderenciaTratamento/medico/{crm}/{uf}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Medico>>(){},
                variables);
    }

}
