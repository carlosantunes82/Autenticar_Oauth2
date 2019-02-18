package br.com.raiadrogasil.cadastroclientepbmrproxy.unit;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.MedicoDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroClientePbmIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${portaltc.url.base}")
    private String baseUrl;

    @Value("${portaltc.url.gravar.cliente}")
    private String urlGravarCliente;

    @Value("${portaltc.url.get.cliente}")
    private String urlGetCliente;

    @Test
    public void getPbmsClientes_comIdClienteNumerico_retornarOk(){

        String idCliente = "142272012";
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + urlGetCliente , String.class, idCliente);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

//    @Test
//    public void getPbmsClientes_comIdClienteAlfanumerico_retornar_INTERNAL_SERVER_ERROR(){
//
//        String idCliente = "142272012";
//        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + urlGetCliente , String.class, idCliente);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR );
//    }

//    @Test
//    public void getPbmsClientes_comIdClienteVazio_retornar_INTERNAL_SERVER_ERROR(){
//
//        String idCliente = "";
//        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + urlGetCliente , String.class, idCliente);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR );
//    }

    @Test
    public void postsPbmClientes_comDadosTelaCadastro_retornarOk(){

        CadastroClientePbmrDto cadastroClientePbmrDto = new CadastroClientePbmrDto();
        cadastroClientePbmrDto.setNome("Jose");
        cadastroClientePbmrDto.setCpf("21522954875");
        cadastroClientePbmrDto.setSexo("M");
        cadastroClientePbmrDto.setDddTelefone("11");
        cadastroClientePbmrDto.setTelefone("22223333");
        cadastroClientePbmrDto.setDddCelular("11");
        cadastroClientePbmrDto.setCelular("975202222");
        cadastroClientePbmrDto.setEmail("jose@gmail.com");
        cadastroClientePbmrDto.setEndereco("rua Emilio Souza");
        cadastroClientePbmrDto.setNumero(500);
        cadastroClientePbmrDto.setBairro("Vila Aricanduva");
        cadastroClientePbmrDto.setCidade("Sao paulo");
        cadastroClientePbmrDto.setCep("03516010");
        cadastroClientePbmrDto.setUf("SP");
        cadastroClientePbmrDto.setMedicoCrm(317700L);
        cadastroClientePbmrDto.setMedicoNome("Americo Aguiar");
        cadastroClientePbmrDto.setMedicoUf("RJ");

        Map<String, String> map =  new ObjectMapper().convertValue(cadastroClientePbmrDto, Map.class);
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + urlGravarCliente, String.class, map );
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}

