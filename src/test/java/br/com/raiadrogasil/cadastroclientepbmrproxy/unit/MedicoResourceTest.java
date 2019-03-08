package br.com.raiadrogasil.cadastroclientepbmrproxy.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MedicoResourceTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private TestRestTemplate restTemplateTest;

    @Test
    public void getMedicoPor_comOK_retornarOk(){

        ResponseEntity responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.OK); // comportamento
        Mockito.when(restTemplate.exchange(Mockito.anyString(), (HttpMethod) Mockito.any(), (HttpEntity) Mockito.any(), (ParameterizedTypeReference) Mockito.any(), (Map<String, ?>) Mockito.any()))
                .thenReturn(responseEntity);

        ResponseEntity<String> response = restTemplateTest.getForEntity("/v1/medico/crm/1/uf/sp" , String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}