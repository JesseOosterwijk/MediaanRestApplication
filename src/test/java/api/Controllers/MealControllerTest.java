package api.Controllers;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import api.DAL.MealRepository;
import api.Entities.Meal;
import api.Models.MealModel;
import api.Service.MealService;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
class MealControllerTest {

	@InjectMocks
	MealController mealController;
	
	@Mock
	MealService mealService;
	
	@Mock
	MealRepository mealRepository;
	
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testAddMeal() {
		//fail("Not yet implemented");
		MealModel mealModel = new MealModel();
		mealModel.setName("Hamburger");
		mealModel.setPrice(1000);
		mealModel.setDescription("Damn, dit is erg lekker zeg!");
		
		Meal meal = new Meal();
		meal.setName("Hamburger");
		meal.setPrice(1000);
		
		ResponseEntity ok = new ResponseEntity(HttpStatus.OK);
		
		ResponseEntity real = mealController.addMeal(mealModel);
		
		assertEquals(ok, real);
		//verify(mealRepository, times(1)).save(any(Meal.class));
	}

}
