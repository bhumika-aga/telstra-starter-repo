package au.com.telstra.simcardactivator.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import au.com.telstra.simcardactivator.entity.ActuationResult;
import au.com.telstra.simcardactivator.entity.SimCard;

@Component
public class ResponseHandler {

    private final RestTemplate template;
    private final String apiUrl;

    public ResponseHandler(RestTemplateBuilder builder) {
        this.template = builder.build();
        this.apiUrl = "http://localhost:8444/actuate";
    }

    public ActuationResult actuate(SimCard simCard) {
        return template.postForObject(apiUrl, simCard, ActuationResult.class);
    }
}