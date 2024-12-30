package com.practice.FoodDelivery.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.FoodDelivery.Entity.FoodEntity;
import com.practice.FoodDelivery.Service.FoodService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/food-items")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@GetMapping("/paginated")
	public ResponseEntity<Page<FoodEntity>> getPaginatedFoodItems(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok(foodService.getAllFoodItemsPaginated(page, size));
	}

	@GetMapping
	public ResponseEntity<List<FoodEntity>> getAllFoodItems() {
		return ResponseEntity.ok(foodService.getAllFoodItems());
	}

	@GetMapping("/{id}")
	public ResponseEntity<FoodEntity> getFoodItemById(@PathVariable Long id) {
		return ResponseEntity.ok(foodService.getFoodItemById(id));
	}

	@PostMapping
	public ResponseEntity<FoodEntity> addFoodItem(@RequestBody FoodEntity foodEntity) {
		return ResponseEntity.ok(foodService.addFoodItem(foodEntity));
	}

	@PutMapping("/{id}")
	public ResponseEntity<FoodEntity> updateFoodItem(@PathVariable Long id, @RequestBody FoodEntity foodEntity) {
		return ResponseEntity.ok(foodService.updateFoodItem(id, foodEntity));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
		foodService.deleteFoodItem(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/available")
	public ResponseEntity<List<FoodEntity>> getAvailableFoodItems() {
		return ResponseEntity.ok(foodService.getAvailableFoodItems());
	}

	@GetMapping("/search")
	public ResponseEntity<List<FoodEntity>> searchFoodItems(@RequestParam String name) {
		return ResponseEntity.ok(foodService.searchFoodItemsByName(name));
	}

}
