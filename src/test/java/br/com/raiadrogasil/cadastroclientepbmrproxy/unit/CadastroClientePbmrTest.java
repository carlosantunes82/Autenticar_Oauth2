package br.com.raiadrogasil.cadastroclientepbmrproxy.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

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

        ResponseEntity<String> response = restTemplateTest.getForEntity("/v1/pbms/clientes?idCliente=" + 1 , String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

//    @Test
//    public void postPbmClientes_comOK_retornarOk(){
//
//        ResponseEntity responseEntity = new ResponseEntity<String>("sampleBodyString", HttpStatus.OK);
//
//        Mockito.when(
//                restTemplate.postForEntity(
//                        Mockito.anyString(),
//                        Mockito.any(),
//                        Mockito.any(),
//                        (Map<String, String>) Mockito.any())
//        )
//                .thenReturn(responseEntity);
//
////        headers = "content-type=application/x-www-form-urlencoded"
//
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
//        HttpEntity<CadastroClientePbmrDto> request = new HttpEntity<CadastroClientePbmrDto>(headers);
//
//        ResponseEntity<String> response = restTemplateTest.postForEntity("/v1/pbms/clientes", request, String.class, new HashMap());
//
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }

}


