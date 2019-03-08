package br.com.raiadrogasil.cadastroclientepbmrproxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {


    @Value("${custom.rest.connection.connection-request-timeout}")
    public Integer connectionRequestTimeout;

    @Value("${custom.rest.connection.connect-timeout}")
    public Integer connectTimeout;

    @Value("${custom.rest.connection.read-timeout}")
    public Integer readTimeout;

    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);

        return new RestTemplate(factory);
    }
}