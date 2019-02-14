package br.com.raiadrogasil.cadastroclientepbmrproxy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${custom.rest.connection.connection-request-timeout}")
    public Integer connectionRequestTimeout;

    @Value("${custom.rest.connection.connect-timeout}")
    public Integer connectTimeout;

    @Value("${custom.rest.connection.read-timeout}")
    public Integer readTimeout;

    @Bean
//    @ConfigurationProperties(prefix = "custom.rest.connection")
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        factory.setConnectTimeout(connectTimeout);
        factory.setReadTimeout(readTimeout);

        return new RestTemplate(factory);
    }


//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
}
