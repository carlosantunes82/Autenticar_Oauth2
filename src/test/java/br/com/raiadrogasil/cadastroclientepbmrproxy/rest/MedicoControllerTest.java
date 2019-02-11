package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.Medico;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void deveRetornarErroNaValidacaoDoCrmEUfAoConsultarMedico(){
        ResponseEntity<Map<String, String>> response = restTemplate.exchange("/medico/crm/-50/uf/TESTE",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, String>>() {});

        assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
        Map<String, String> responseBody = response.getBody();
        assertTrue(responseBody.containsKey("getMedicoPor.crm"));
        assertTrue(responseBody.containsKey("getMedicoPor.uf"));
    }

    @Test
    public void deveRetornarMedicoBuscado(){
        ResponseEntity<List<Medico>> response =
                restTemplate.exchange("/medico/crm/150/uf/SP",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Medico>>() {});

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        List<Medico> medicos = response.getBody();
        assertTrue(!medicos.isEmpty());
    }

    @Test
    public void deveRetornarMedicoInexistente(){
        ResponseEntity<String> response =
                restTemplate.exchange("/medico/crm/987654321/uf/SP",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<String>() {});

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

}
