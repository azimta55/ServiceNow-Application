package com.ServiceNow.Response;

import java.util.List;

import com.ServiceNow.Model.Incident;

public class IncidentResponse {
	  private List<Incident> result;

	  public List<Incident> getResult() {
	    return result;
	  }

	  public void setResult(List<Incident> result) {
	    this.result = result;
	  }
	}
