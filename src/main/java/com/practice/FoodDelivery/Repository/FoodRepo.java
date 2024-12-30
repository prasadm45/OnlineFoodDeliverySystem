package com.practice.FoodDelivery.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.FoodDelivery.Entity.FoodEntity;

@Repository
public interface FoodRepo extends JpaRepository<FoodEntity, Long>{
	
	Page<FoodEntity> findAll(Pageable pageable);
	
	List<FoodEntity> findByAvailable(boolean available);
	
	@Query("SELECT f FROM FoodEntity f WHERE f.name LIKE %:name%")
	List<FoodEntity> searchByName(String name);

}
