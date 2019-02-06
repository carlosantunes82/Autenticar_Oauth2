package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import br.com.raiadrogasil.cadastroclientepbmrproxy.dto.CadastroClientePbmrDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("validarDadosClientePbmr")
public class CadClientePbmrRestController {

    private static final String BASE_URL=
            "http://10.1.55.90:8080/tc-core-portlets_1.0/ValidarDadosClientePbmrServlet";

    private static String BASE_URL_GET_CLIENTE =
            BASE_URL + "?acao=getDadosCadastraisCliente&idCliente=";

    private static String BASE_URL_GRAVAR_CLIENTE =
            BASE_URL + "?acao=gravarClientRaiaDrogasil";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(path = "getDadosCadastraisCliente")
    private ResponseEntity getDadosCadastraisCliente(@Context HttpServletRequest request) {

        ResponseEntity<String> response =
                restTemplate.getForEntity(BASE_URL_GET_CLIENTE +  request.getParameter("idCliente"), String.class);

        return response;
    }

    @GetMapping(path = "gravarClientRaiaDrogasil")
    private ResponseEntity gravarClientRaiaDrogasil(@Context HttpServletRequest request) {

        CadastroClientePbmrDto cad = preencherCliente(request);

        ResponseEntity<String> response =
                restTemplate.getForEntity(BASE_URL_GRAVAR_CLIENTE
                        + "&idCliente=142272012&nome=JULIANO CELESTINO DA SILVA&cpf=33668637814&dataNascimento=14/01/1987&sexo=M&tipoLogradouro=&endereco=RUA QUIPA&numero=33&complemento=1&cep=05756440&bairro=JD UMARIZAL&cidade=SAO PAULO&uf=SP&dddTelefone=11&telefone=218885422&dddCelular=11&celular=99999999&email=teste@teste.com&medicoCrm=317700&medicoNome=ELIANE LIPKIN&medicoUf=RJ&contatoEmail=0&contatoCelular=0&contatoCorreio=0&contatoPermissao=0&cdProduto=8888&precoBruto=10&precoLiquido=10&isContatos=S&nrSequenciaEndereco=3"
                        , String.class);

        return response;
    }

    public CadastroClientePbmrDto preencherCliente(HttpServletRequest request){

        CadastroClientePbmrDto cad = new CadastroClientePbmrDto();
        cad.setAcao(request.getParameter("acao"));
        cad.setIdCliente(request.getParameter("idCliente"));
        cad.setNome(request.getParameter("nome"));
        cad.setCpf(request.getParameter("cpf"));
        cad.setDataNascimento(request.getParameter("dataNascimento"));
        cad.setSexo(request.getParameter("sexo"));
        cad.setTipoLogradouro(request.getParameter("tipoLogradouro"));
        cad.setEndereco(request.getParameter("endereco"));
        cad.setNumero(request.getParameter("numero"));
        cad.setComplemento(request.getParameter("complemento"));
        cad.setCep(request.getParameter("cep"));
        cad.setBairro(request.getParameter("bairro"));
        cad.setCidade(request.getParameter("cidade"));
        cad.setUf(request.getParameter("uf"));
        cad.setDddTelefone(request.getParameter("dddTelefone"));
        cad.setTelefone(request.getParameter("telefone"));
        cad.setDddCelular(request.getParameter("dddCelular"));
        cad.setCelular(request.getParameter("celular"));
        cad.setEmail(request.getParameter("email"));
        cad.setMedicoCrm(request.getParameter("medicoCrm"));
        cad.setMedicoNome(request.getParameter("medicoNome"));
        cad.setMedicoUf(request.getParameter("medicoUf"));
        cad.setContatoEmail(request.getParameter("contatoEmail"));
        cad.setContatoCelular(request.getParameter("contatoCelular"));
        cad.setContatoCorreio(request.getParameter("contatoCorreio"));
        cad.setContatoPermissao(request.getParameter("contatoPermissao"));
        cad.setCdProduto(request.getParameter("cdProduto"));
        cad.setPrecoBruto(request.getParameter("precoBruto"));
        cad.setPrecoLiquido(request.getParameter("precoLiquido"));
        cad.setIsContatos(request.getParameter("isContatos"));
        cad.setNrSequenciaEndereco(request.getParameter("nrSequenciaEndereco"));

        return cad;
    }
}