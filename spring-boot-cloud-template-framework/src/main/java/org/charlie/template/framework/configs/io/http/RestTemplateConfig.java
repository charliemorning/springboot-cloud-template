package org.charlie.template.framework.configs.io.http;

import org.apache.http.impl.client.CloseableHttpClient;
import org.charlie.template.framework.interceptors.out.resttemplate.CustomClientHttpRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 * Rest template configure based on Apache HTTP Client.
 * <p>
 * Using the ClosableHttpClient bean from <class>org.charlie.template.framework.configs.io.http.ApacheHttpClientConfig</class>
 *
 * @author Charlie
 */
@Configuration
public class RestTemplateConfig {

    private final CloseableHttpClient httpClient;

    @Autowired
    public RestTemplateConfig(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    @Bean
    @ConditionalOnBean(CloseableHttpClient.class)
    public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setHttpClient(httpClient);
        return clientHttpRequestFactory;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .requestFactory(this::clientHttpRequestFactory)
                .errorHandler(new CustomClientErrorHandler()) // define your error handler yourself
                .interceptors(new CustomClientHttpRequestInterceptor())
                .build();
    }
}