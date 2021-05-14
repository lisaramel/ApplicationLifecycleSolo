package com.example.springdocker.repository;

import com.example.springdocker.model.Food;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Lisa Ramel
 * Date: 2021-05-14
 * Time: 13:13
 * Project: springdocker
 * Copywrite: MIT
 */
@DataMongoTest
class FoodRepositoryTest {

    @Autowired
    FoodRepository foodRepository;

    @Test
    void findFoodsByCanICookIt(){
        String expectedFood = "Pasta Carbonara";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = true;
        Food f = new Food();

        f.setCanICookIt(expectedCanICookIt);
        f.setDelicious(expectedDelicious);
        f.setName(expectedFood);

        foodRepository.save(f);

        boolean actual = f.isCanICookIt();
        assertEquals(true, actual);
    }

    @Test
    void foundNoFoodsByCanICookIt(){
        String expectedFood = "Pasta Carbonara";
        boolean expectedDelicious = true;
        boolean expectedCanICookIt = true;
        Food f = new Food();

        boolean actual = f.isCanICookIt();
        assertEquals(false, actual);
    }

}