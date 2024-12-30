package com.practice.FoodDelivery.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.practice.FoodDelivery.Entity.FoodEntity;
import com.practice.FoodDelivery.Repository.FoodRepo;

@Service
public class FoodService {

	@Autowired
	private FoodRepo foodRepo;

	public Page<FoodEntity> getAllFoodItemsPaginated(int page, int size) {
		// Create a Pageable object with page number and size
		PageRequest pageable = PageRequest.of(page, size);
		return foodRepo.findAll(pageable);
	}

	public List<FoodEntity> getAllFoodItems() {
		return foodRepo.findAll();
	}

	public FoodEntity getFoodItemById(Long id) {
		return foodRepo.findById(id).orElseThrow(() -> new RuntimeException("Food item not found"));
	}

	public FoodEntity addFoodItem(FoodEntity foodEntity) {
		return foodRepo.save(foodEntity);
	}

	public FoodEntity updateFoodItem(Long id, FoodEntity updatedEntity) {
		FoodEntity existingFoodItem = getFoodItemById(id);
		existingFoodItem.setName(updatedEntity.getName());
		existingFoodItem.setPrice(updatedEntity.getPrice());
		existingFoodItem.setAvailable(updatedEntity.getAvailable());

		return foodRepo.save(existingFoodItem);

	}

	public List<FoodEntity> getAvailableFoodItems() {
		return foodRepo.findByAvailable(true);
	}

	public List<FoodEntity> searchFoodItemsByName(String name) {
		return foodRepo.searchByName(name);
	}

	public void deleteFoodItem(Long id) {
		foodRepo.deleteById(id);
	}
}
