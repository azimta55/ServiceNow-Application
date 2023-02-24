package com.ServiceNow.Model;

import javax.persistence.*;


@Entity
@Table(name = "incidents")
public class Incident {
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(name = "number")
	  private String number;

	  @Column(name = "short_description")
	  private String shortDescription;
	  
	  
	  

	public Incident(Long id, String number, String shortDescription) {
		super();
		this.id = id;
		this.number = number;
		this.shortDescription = shortDescription;
	}




	public Incident() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public String getShortDescription() {
		return shortDescription;
	}




	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	  
	  
	
	
	  
	  
	  

}
