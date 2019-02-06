package br.com.raiadrogasil.cadastroclientepbmrproxy.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Context;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("validarDadosClientePbmr")
public class CadClientePbmrRestController {


    @GetMapping(path = "getDadosCadastraisCliente")
    public String teste3(@Context HttpServletRequest request){
        String teste = null;
        if(request != null){
            teste = request.getParameter("acao");
        }
        return  teste;
    }



}
