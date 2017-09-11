package com.laotan.hotel.test;

import java.util.List;

import org.junit.Test;

import com.laotan.hotel.dao.IFoodTypeDao;
import com.laotan.hotel.dao.impl.FoodTypeDao;
import com.laotan.hotel.entity.FoodType;
import com.laotan.hotel.factory.BeanFactory;

public class TestDao {

	@Test
	public void test1() {
		FoodTypeDao dao = new FoodTypeDao();
		FoodType foodType = new FoodType();
		foodType.setTypeName("粤菜");
		dao.save(foodType);
	}

	@Test
	public void test2() {
		FoodTypeDao dao = new FoodTypeDao();
		List<FoodType> list = dao.getAll();
		for (FoodType foodType : list) {
			System.out.println(foodType.getTypeName());

		}

	}
	@Test
	public void test3() {
		FoodTypeDao dao = new FoodTypeDao();
		 FoodType foodType = dao.getFoodTypeById(1);
		 System.out.println(foodType.getTypeName());
		
	}
	@Test
	public void test4() {
		FoodTypeDao dao = new FoodTypeDao();
		FoodType foodType = new FoodType();
		foodType.setId(1);
		foodType.setTypeName("湘菜");
		dao.update(foodType);
		
	}
	@Test
	public void test5() {
		FoodTypeDao dao = new FoodTypeDao();
		List<FoodType> search = dao.search("湘菜");
		for (FoodType foodType : search) {
			
			System.out.println(foodType.getTypeName());
		}
	}
	@Test
	public void test6() {
		    IFoodTypeDao dao = BeanFactory.getInstance("foodTypeDao",IFoodTypeDao.class);	    
		    List<FoodType> search = dao.search("湘菜");
			for (FoodType foodType : search) {
				System.out.println(foodType.getTypeName());
			}
	}

}
