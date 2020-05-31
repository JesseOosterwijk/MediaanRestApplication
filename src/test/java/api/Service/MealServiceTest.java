package api.Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import api.Entities.Meal;

import api.DAL.MealRepository;

class MealServiceTest {

	
	MealService mealService;
	
	@Mock
	MealRepository mealRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
		mealService = new MealService(mealRepository);
	}
	
	//@Test
	//void testGetAllMealsNoneAvailable() {
	//	MockitoAnnotations.initMocks(this);
	//	mealService = new MealService(mealRepository);
	//	List<Meal> meals = new ArrayList<>();
	//	when(mealRepository.findAll()).thenReturn(meals);
	//	verify(mealRepository, times(1)).findAll();
	//}

}
