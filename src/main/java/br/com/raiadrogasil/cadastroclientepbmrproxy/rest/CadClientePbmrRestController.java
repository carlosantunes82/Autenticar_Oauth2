package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.validation.Valid;
import javax.xml.ws.Response;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("validarDadosClientePbmr")
public class CadClientePbmrRestController {

    @Value("${portaltc.url.base}")
    private String baseUrl;

    @Value("${portaltc.url.gravar.cliente}")
    private String urlGravarCliente;

    @Value("${portaltc.url.get.cliente}")
    private String urlGetCliente;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(path = "getDadosCadastraisCliente")
    private ResponseEntity getDadosCadastraisCliente(@RequestParam Map<String, String> params) {

        ResponseEntity response =
                restTemplate.getForEntity(baseUrl + urlGetCliente , String.class, params);

        return ResponseEntity.ok(response.getBody());
    }

    @PostMapping(path = "gravarClientRaiaDrogasil")
    @ResponseBody
      private ResponseEntity<?> gravarClientRaiaDrogasil(@RequestBody @Valid CadastroClientePbmrDto cadastroClientePbmrDto) {

        Map<String, String> map =  new ObjectMapper().convertValue(cadastroClientePbmrDto, Map.class);

        ResponseEntity<String> response =
                restTemplate.getForEntity(baseUrl + urlGravarCliente, String.class, map );

        return ResponseEntity.ok().build();

    }



}