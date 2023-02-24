package com.ServiceNow.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceNow.Model.Incident;
import com.ServiceNow.Repository.IncidentRepository;
import com.ServiceNow.ServiceNowClient.ServiceNowClient;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {
  private ServiceNowClient serviceNowClient;
  private IncidentRepository incidentRepository;

  @Autowired
  public IncidentController(ServiceNowClient serviceNowClient, IncidentRepository incidentRepository) {
    this.serviceNowClient = serviceNowClient;
    this.incidentRepository = incidentRepository;
  }

  @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = "application/json")
  public List<Incident> getIncidents() {
    return this.incidentRepository.findAll();
  }

  @PostMapping
  public ResponseEntity<Incident> createIncident(@RequestBody Incident incident) {
    Incident savedIncident = this.incidentRepository.save(incident);
    return ResponseEntity.created(URI.create("/api/incidents/" + savedIncident.getId()))
        .body(savedIncident);
  }
}
