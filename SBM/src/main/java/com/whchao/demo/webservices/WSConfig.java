package com.whchao.demo.webservices;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WSConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.whchao.demo.webservices.type");
        return marshaller;
    }
    @Bean
    public WsClient wsClient(Jaxb2Marshaller marshaller) {
        WsClient client = new WsClient();
        client.setDefaultUri("http://localhost:8082/ws/countries.wsdl");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
