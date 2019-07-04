package com.whchao.demo.webservices;

import com.whchao.demo.webservices.type.GetCountryRequest;
import com.whchao.demo.webservices.type.GetCountryResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class WsClient  extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String name) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);
        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8082/ws/countries.wsdl", request);
        return response;
    }

    public Object getCountryObject(String name) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);
        Object response =  getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8082/ws/countries.wsdl", request);


        System.out.println(response);
        return response;
    }
}
