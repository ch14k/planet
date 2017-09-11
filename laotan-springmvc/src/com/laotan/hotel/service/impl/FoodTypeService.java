package com.laotan.hotel.service.impl;

import java.util.List;

import com.laotan.hotel.dao.IFoodTypeDao;
import com.laotan.hotel.entity.FoodType;
import com.laotan.hotel.factory.BeanFactory;
import com.laotan.hotel.service.IFoodTypeService;


public class FoodTypeService implements IFoodTypeService {

	private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodTypeDao", IFoodTypeDao.class);

	@Override
	public void addFoodtype(FoodType foodType) {
		foodTypeDao.save(foodType);
	}

	@Override
	public List<FoodType> getAll() {
		return foodTypeDao.getAll();
	}

	@Override
	public FoodType getFoodTypeById(int id) {

		return foodTypeDao.getFoodTypeById(id);
	}

	@Override
	public void update(FoodType foodType) {
		 foodTypeDao.update(foodType);
	}

	@Override
	public void delete(int id) {
		 foodTypeDao.delete(id);
		
	}

	@Override
	public List<FoodType> search(String keyword) { 
		return foodTypeDao.search(keyword);
	}

}
