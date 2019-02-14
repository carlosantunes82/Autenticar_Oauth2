package br.com.raiadrogasil.cadastroclientepbmrproxy.resource;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping
public class CadastroClientePbmrResource {

    @Value("${portaltc.url.base}")
    private String baseUrl;

    @Value("${portaltc.url.gravar.cliente}")
    private String urlGravarCliente;

    @Value("${portaltc.url.get.cliente}")
    private String urlGetCliente;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(path = "v1/pbms/clientes")
    private ResponseEntity getPbmsClientes(@Valid @NotNull(message = "ID do cliente deve ser informado")
                                                          @RequestParam String idCliente) {
        ResponseEntity response =
                restTemplate.getForEntity(baseUrl + urlGetCliente , String.class, idCliente);

        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping("v1/pbms/clientes")
    @ResponseBody
    private ResponseEntity postsPbmClientes(@RequestBody @Valid CadastroClientePbmrDto cadastroClientePbmrDto) {

        Map<String, String> map =  new ObjectMapper().convertValue(cadastroClientePbmrDto, Map.class);

        ResponseEntity<String> response =
                restTemplate.getForEntity(baseUrl + urlGravarCliente, String.class, map );

        URI location = URI.create("");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity( responseHeaders, HttpStatus.CREATED);
//        return ResponseEntity.ok().build();
    }
}