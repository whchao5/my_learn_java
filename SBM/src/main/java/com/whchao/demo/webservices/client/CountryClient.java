package com.whchao.demo.webservices.client;

import com.whchao.demo.webservices.service.GetCountryRequest;
import com.whchao.demo.webservices.service.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

//https://segmentfault.com/a/1190000017777211
//@Service
public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();

        request.setName(country);

        log.info("Requesting location for " + country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8082/ws/countries.wsdl", request);

        return response;
    }
}
