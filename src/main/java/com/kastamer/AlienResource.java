/*
 * Youtube Channel (Telusko) - Rest API | Web Service Tutorial
 * - 19. Spring Rest | Spring Boot Example
 * - 20. Spring JPA | REST
 * */
package com.kastamer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //DEFINE that THIS CLASS is TECHNICALLY now A CONTROLLER FOR the APP 'SpringBootRest'
public class AlienResource {

	//20) Spring JPA | REST
	@Autowired //This is a SPRING CODE FEATURE that HELP AlienRepositoryDAO OBJECT 'ard' do NO NEED to CREATE an INSTANCE
	AlienRepositoryDAO ard;
	
//	@RequestMapping("aliens") --> will WORK FINE as WELL
	//20) Spring JPA | REST
	@GetMapping("aliens")
	public List<Alien> getAliens() {
		// TODO Auto-generated method stub
//		List<Alien> aliens = new ArrayList<>(); --> COMMENTED DUE to PRACTICE of 20) Spring JPA | REST
		
		/* --> COMMENTED DUE to PRACTICE of 20) Spring JPA | REST
		Alien a1 = new Alien();
		a1.setAlId(0);
		a1.setAlName("Navin");
		a1.setAlPoints(70);
		
		Alien a2 = new Alien();
		a2.setAlId(102);
		a2.setAlName("Priya");
		a2.setAlPoints(80);
		
		aliens.add(a1);
		aliens.add(a2);
		*/
		
		//20) Spring JPA | REST
		List<Alien> aliens = (List<Alien>) ard.findAll();
		return aliens;
//		return (List<Alien>) ard.findAll();
	}
	
	@GetMapping("aliens/{alId}")
	private Optional<Alien> getAlien(@PathVariable int alId) {
		// TODO Auto-generated method stub
		return ard.findById(alId);
	}
	
	@PostMapping("alien")
	private String addAlien(@RequestBody Alien alPostObj) {
		// TODO Auto-generated method stub
//		System.out.println("Matching object: " + ard.findById(alPostObj.getAlId()).isEmpty());
		
		if (ard.findById(alPostObj.getAlId()).isEmpty()) {
			ard.save(alPostObj);
			
			System.out.println("\nSuccessfully inserting new Alien data");
			
			return "Successfully inserting new Alien data\n{\n"
					+ "    \"alId\": " + alPostObj.getAlId() + ",\n"
					+ "    \"alName\": \"" + alPostObj.getAlName() + "\",\n"
					+ "    \"alPoints\": " + alPostObj.getAlPoints() + "\n"
					+ "}";
		} else {
			System.out.println("\nInserted Alien data is already exist");
			
			return "Inserted Alien data is already exist\n{\n"
					+ "    \"alId\": " + alPostObj.getAlId() + ",\n"
					+ "    \"alName\": \"" + alPostObj.getAlName() + "\",\n"
					+ "    \"alPoints\": " + alPostObj.getAlPoints() + "\n"
					+ "}";
		}
		
//		ard.save(alPostObj);
		
//		System.out.println("Successfully insert Alien: " + alPostObj);
		
//		return alPostObj;
	}
	
	@DeleteMapping("alien/{alId}")
	private String deleteAlien(@PathVariable int alId) {
		// TODO Auto-generated method stub
		Alien alDelObj = ard.getById(alId);
		int alDelId = alDelObj.getAlId();
	
		ard.delete(alDelObj);
		
		try {
			System.out.println("\nDeleting Alien: " + alDelObj);
			
			return "Alien " + alDelId + " is deleted.";
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("\n" + e);
			
			return "Alien dengan id " + alDelId + " tidak ditemukan"; //e.toString();
		}
		
//		System.out.println("Deleting Alien (" + alDelObj + ")");
//		if (alDelId == 0) {
//			System.out.println("No Alien match! id=" + alDelId);
//		} else {
//			System.out.println("There is alien match! id=" + alDelObj);
//		}
	}
	
	@PutMapping("alien")
	public Alien postOrPutAlien(@RequestBody Alien alPutObj) {
		// TODO Auto-generated method stub
		System.out.println(alPutObj.toString());
		ard.save(alPutObj);
		
		return alPutObj;
	}
}
