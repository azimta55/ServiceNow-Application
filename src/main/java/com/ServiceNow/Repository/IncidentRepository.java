package com.ServiceNow.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ServiceNow.Model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

}
