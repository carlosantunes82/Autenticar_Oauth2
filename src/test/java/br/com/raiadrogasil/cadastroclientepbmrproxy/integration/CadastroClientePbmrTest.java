package br.com.raiadrogasil.cadastroclientepbmrproxy.integration;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import br.com.raiadrogasil.cadastroclientepbmrproxy.resource.CadastroClientePbmrResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroClientePbmrTest {

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private TestRestTemplate restTemplateTest;

    @Test
    public void getPbmsClientes_comOK_retornarOk(){

        ResponseEntity responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.OK); // comportamento
        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any(), Mockito.anyString()))
                .thenReturn(responseEntity);

        ResponseEntity<String> response = restTemplateTest.getForEntity("/v1/pbms/clientes?idCliente=" + 1 , String.class); //

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void postPbmClientes_comOK_retornarOk(){

        ResponseEntity responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.OK); // comportamento

        Mockito.when(
                restTemplate.postForEntity(
                        Mockito.anyString(),
                        Mockito.any(),
                        Mockito.any(),
                        (Map<String, String>) Mockito.any())
        )
                .thenReturn(responseEntity);


        ResponseEntity<String> response = restTemplateTest.postForEntity("/v1/pbms/clientes", null, String.class, new HashMap()); //

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }




//    @Test
//    public void getPbmsClientes_comRetornoIntegracaoComErro_retornar_BAD_REQUEST(){
//
//        ResponseEntity responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.INTERNAL_SERVER_ERROR); // comportamento
//        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any(), Mockito.anyString()))
//                .thenReturn(responseEntity);
//
//        ResponseEntity<String> response = restTemplateTest.getForEntity("/v1/pbms/clientes?idCliente=" + 1 , String.class); //
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @Test
//    public void xxx() {
//        Mockito.when(restTemplate.getForEntity(Mockito.anyString(), Mockito.any(), Mockito.anyString()))
//                .thenThrow(IllegalAccessException.class);
//
//        ResponseEntity<String> response = restTemplateTest.getForEntity("/v1/pbms/clientes?idCliente=" + 1 , String.class); //
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
//    }


}


