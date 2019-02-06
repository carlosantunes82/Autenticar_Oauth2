package br.com.raiadrogasil.cadastroclientepbmrproxy.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CadastroPbmrConfiguration {

    @Bean
    public RestTemplate controiRestTemplate(){
        return new RestTemplate();
    }

}
