package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Food;
import com.example.springdocker.repository.AnimalRepository;
import com.example.springdocker.repository.FoodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by Lisa Ramel
 * Date: 2021-05-14
 * Time: 13:51
 * Project: springdocker
 * Copywrite: MIT
 */
@ExtendWith(MockitoExtension.class)
class FoodServiceTest {

    FoodService foodService;

    @Mock
    FoodRepository foodRepository;

    @BeforeEach
    public void init(){
        foodService = new FoodService(foodRepository);
    }

    @Test
    void getFoods() {
        Food mockFood = new Food();
        String expectedFood = "Sushi";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = false;

        mockFood.setName(expectedFood);
        mockFood.setDelicious(expectedDelicious);
        mockFood.setCanICookIt(expectedCanICookIt);

        when(foodRepository.findAll()).thenReturn(Arrays.asList(mockFood));

        List<Food> actual = foodService.getFoods();

        assertEquals(expectedFood, actual.get(0).getName());
        assertEquals(expectedDelicious, actual.get(0).isDelicious());
        assertEquals(1, actual.size());

        verify(foodRepository).findAll();
    }

    @Test
    void saveNewFood() {
        Food mockFood = new Food();
        String expectedFood = "Sushi";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = false;

        mockFood.setName(expectedFood);
        mockFood.setDelicious(expectedDelicious);
        mockFood.setCanICookIt(expectedCanICookIt);

        when(foodRepository.save(any())).thenReturn(mockFood);

        Food actual = foodService.saveNewFood(mockFood);

        assertEquals(expectedFood, actual.getName());
        assertTrue(mockFood.isDelicious());
        assertFalse(mockFood.isCanICookIt());
        verify(foodRepository).save(any());
    }

    @Test
    void getCookableFoods() {
        Food mockFood = new Food();
        String expectedFood = "Pancakes";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = true;

        mockFood.setName(expectedFood);
        mockFood.setDelicious(expectedDelicious);
        mockFood.setCanICookIt(expectedCanICookIt);

        when(foodRepository.findFoodByCanICookIt(expectedCanICookIt)).thenReturn(Arrays.asList(mockFood));

        List<String> actual = foodService.getCookableFoods();

        assertEquals(expectedFood, actual.get(0));
        assertEquals(1, actual.size());
    }
}