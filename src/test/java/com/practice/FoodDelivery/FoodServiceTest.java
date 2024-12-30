package com.practice.FoodDelivery;

import com.practice.FoodDelivery.Entity.FoodEntity;
import com.practice.FoodDelivery.Repository.FoodRepo;
import com.practice.FoodDelivery.Service.FoodService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FoodServiceTest {

	@Mock
	private FoodRepo foodRepo;

	@InjectMocks
	private FoodService foodService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // Initialize mocks
	}

//	@Test
//	public void testGetAllFoodItems() {
//		// Mock data
//		FoodEntity food = new FoodEntity(1L, "Pizza", 9.99, true);
//		when(foodRepo.findAll()).thenReturn(List.of(food));
//
//		// Call service
//		List<FoodEntity> result = foodService.getAllFoodItems();
//
//		// Assertions
//		assertNotNull(result);
//		assertEquals(1, result.size());
//		assertEquals("Pizza", result.get(0).getName());
//	}

	
}
