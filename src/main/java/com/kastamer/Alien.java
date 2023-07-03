/*
 * Youtube Channel (Telusko) - Rest API | Web Service Tutorial
 * - 5. How to create a Resource Class
 * - 19. Spring Rest | Spring Boot Example
 * - 20. Spring JPA | REST
 * */
package com.kastamer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

//import javax.xml.bind.annotation.XmlRootElement;

//@jakarta.xml.bind.annotation.XmlRootElement //DEFINING THIS CLASS to RETURN ITS OBJECT in XML FORMAT --> ARTEFACT from PROJECT 'DemoRestJersey'

//20) Spring JPA | REST
@Entity
@Table(name = "alien_rest3", schema = "public") //THIS is NOT WORKING with/without 'schema' for TABLE alien_rest
/* --> THIS is NOT WORKING for TABLE alien_rest
@SqlResultSetMapping(name = "AlienMapping", entities = @EntityResult(entityClass = Alien.class, 
		fields = {
				@FieldResult(name = "alId", column = "alId"),
				@FieldResult(name = "alName", column = "alName"),
				@FieldResult(name = "alPoints", column = "alPoints")
		})) */
public class Alien {

	@Id
	@Column(name = "alid") //THIS is NOT WORKING for TABLE alien_rest
	private int alId;
	@Column(name = "alname") //THIS is NOT WORKING for TABLE alien_rest
	private String alName;
	@Column(name = "alpoints") //THIS is NOT WORKING for TABLE alien_rest
	private int alPoints;
	
	public int getAlId() {
		return alId;
	}
	public void setAlId(int alId) {
		this.alId = alId;
	}
	public String getAlName() {
		return alName;
	}
	public void setAlName(String alName) {
		this.alName = alName;
	}
	public int getAlPoints() {
		return alPoints;
	}
	public void setAlPoints(int alPoints) {
		this.alPoints = alPoints;
	}
	
	@Override
	public String toString() {
		return "Alien [alName=" + alName + ", alPoints=" + alPoints + ", alId=" + alId + "]";
	}	
}
