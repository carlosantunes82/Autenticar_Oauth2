package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@RestController
@Validated
@RequestMapping("medico")
public class MedicoController {

    private RestTemplate restClient;

    public MedicoController(@Autowired RestTemplate restClient){
        this.restClient = restClient;
    }

    @RequestMapping("/crm/{crm}/uf/{uf}")
    public ResponseEntity getMedicoPor(@Positive(message = "CRM deve ser maior que zero")
                                   @NotNull(message = "CRM deve ser informado")
                                   @Digits(integer = 10, fraction = 0, message = "CRM deve conter apenas números")
                                   @PathVariable long crm,
                               @Size(min = 2, max = 2, message = "UF deve conter dois caractéres")
                                   @NotNull(message = "UF deve ser informado")
                                   @PathVariable String uf) throws URISyntaxException {

        Map<String, Object> variables = new HashMap<>();
        variables.put("crm", crm);
        variables.put("uf", uf);
        return restClient.getForEntity("http://192.1.1.70/terminalconsulta-servicos/aderenciaTratamento/medico/{crm}/{uf}",
                String.class,
                variables);
    }

}
