/*
 * Youtube Channel (Telusko) - Rest API | Web Service Tutorial
 * - 20. Spring JPA | REST
 * */
package com.kastamer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//public interface AlienRepositoryDAO extends CrudRepository<Alien, Integer>{
public interface AlienRepositoryDAO extends JpaRepository<Alien, Integer>{

	@Query(value = "select * from alien_rest", nativeQuery = true)
	List<Alien> ambilSemua();
}
