package br.com.raiadrogasil.cadastroclientepbmrproxy.integration;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.MedicoDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.BasicJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicoResourceIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${terminalconsultaservicos.url.test}")
    private String urlBase;

    @Value("${url.base.autorizador}")
    private String urlAutorizador;

    @Test
    public void deveRetornarErroNaValidacaoDoCrmEUfAoConsultarMedico() throws UnknownHostException {

//        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity response = null;
        try {
            response = restTemplate.exchange(urlBase + "/v1/medico/crm/-50/uf/TESTE",
                    HttpMethod.GET,
                    buscarTokenParaAutenticacao(),
                    new ParameterizedTypeReference<Map<String, String>>() {});
        } catch (final HttpClientErrorException httpClientErrorException) {
            assertThat(httpClientErrorException.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        }
    }


    @Test
    public void deveRetornarMedicoInexistente(){
        ResponseEntity<String> response =
                restTemplate.exchange(urlBase + "/v1/medico/crm/987654321/uf/SP",
                        HttpMethod.GET,
                        buscarTokenParaAutenticacao(),
                        new ParameterizedTypeReference<String>() {});

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }


    @Test
    public void deveRetornarMedicoBuscado(){

        ResponseEntity<List<MedicoDto>> response =
                restTemplate.exchange(urlBase + "/v1/medico/crm/150/uf/SP",
                        HttpMethod.GET,
                        buscarTokenParaAutenticacao(),
                        new ParameterizedTypeReference<List<MedicoDto>>() {});

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        List<MedicoDto> medicos = response.getBody();
        assertTrue(!medicos.isEmpty());

//        medicos.forEach(medicoDto -> System.out.println(medicoDto.getNome()));
    }

    public HttpEntity<MultiValueMap<String, String>> buscarTokenParaAutenticacao(){

        // Headers
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headersAut = new HttpHeaders();
        headersAut.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headersAut.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headersAut.set(HttpHeaders.AUTHORIZATION, "Basic cmQ6YzJWamNtVjBYM0poYVdGZlpISnZaMkZ6YVd4Zk1qQXhPUT09");

        // Request
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("grant_type", "password");
        map.add("username", "RaiaDrogasil");
        map.add("password", "UmFpYWRyb2dhc2lsMjAxOQ==");
        HttpEntity<MultiValueMap<String, String>> requestAut = new HttpEntity<MultiValueMap<String, String>>(map, headersAut);

        ResponseEntity response = restTemplate.exchange(urlAutorizador , HttpMethod.POST, requestAut, String.class);

        Map<String, Object> jsonMap = null;
        JsonParser parser = JsonParserFactory.getJsonParser();
        jsonMap = parser.parseMap(response.getBody().toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " +  jsonMap.get("access_token").toString());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null, headers);

        return request;
    }
}
