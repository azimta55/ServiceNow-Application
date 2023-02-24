package com.ServiceNow.ServiceNowClient;

import java.nio.charset.StandardCharsets;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ServiceNow.Model.Incident;
import com.ServiceNow.Response.IncidentResponse;

@Component
public class ServiceNowClient {

  private RestTemplate restTemplate;

  @Autowired
  public ServiceNowClient(RestTemplateBuilder restTemplateBuilder,
                          @Value("${servicenow.username}") String username,
                          @Value("${servicenow.password}") String password,
                          @Value("${servicenow.instanceUrl}") String instanceUrl) {
    String auth = username + ":" + password;
    byte[] encodedAuth = Base64.encodeBase64(
        auth.getBytes(StandardCharsets.US_ASCII));
    String authHeader = "Basic " + new String(encodedAuth);

    this.restTemplate = restTemplateBuilder
        .rootUri(instanceUrl)
        .defaultHeader(HttpHeaders.AUTHORIZATION, authHeader)
        .build();
  }

  public List<Incident> getIncidents() {
    ResponseEntity<IncidentResponse> response = this.restTemplate
        .getForEntity("/api/now/table/incident", IncidentResponse.class);
    return response.getBody().getResult();
  }
}
