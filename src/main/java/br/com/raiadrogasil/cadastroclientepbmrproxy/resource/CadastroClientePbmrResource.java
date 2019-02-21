package br.com.raiadrogasil.cadastroclientepbmrproxy.resource;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.*;

import java.util.Map;

@RestController
@RequestMapping
@Api(value = "PBM", description = "Operações pertinentes a Cadastro cliente no PBM.")
public class CadastroClientePbmrResource {

    @Value("${portaltc.url.base}")
    private String baseUrl;

    @Value("${portaltc.url.gravar.cliente}")
    private String urlGravarCliente;

    @Value("${portaltc.url.get.cliente}")
    private String urlGetCliente;

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "Buscar dados do cliente a ser cadastrado.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente encontrado"),
            @ApiResponse(code = 500, message = "Argumentos invalidos"),
    })

    @GetMapping(path = "v1/pbms/clientes")
    private ResponseEntity getPbmsClientes(@Valid @NotNull(message = "Favor informar o campo medicoUf.")
                                                  @Min(value = 1, message = "ID do cliente deve ser informado")
                                                  @Positive(message = "idCliente deve ser maior que zero")
                                                  @Digits(integer = 20, fraction = 0, message = "idCliente deve conter apenas números")
                                                  @RequestParam Long idCliente) {
        ResponseEntity response =
                restTemplate.getForEntity(baseUrl + urlGetCliente, String.class, String.valueOf(idCliente));

        return ResponseEntity.ok(response.getBody());
    }

    @ApiOperation(value = "Cadastrar cliente no PBM.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Cliente cadastrado, porém so retorna o codigo"),
            @ApiResponse(code = 500, message = "Argumentos invalidos"),
    })
    @PostMapping(value = "v1/pbms/clientes")
    private ResponseEntity postPbmClientes(@RequestBody @Valid CadastroClientePbmrDto cadastroClientePbmrDto) {

        Map<String, String> map = new ObjectMapper().convertValue(cadastroClientePbmrDto, Map.class);

        ResponseEntity<String> response =
                restTemplate.postForEntity(baseUrl + urlGravarCliente, null, String.class, map);

        return ResponseEntity.noContent().build();
    }
}
