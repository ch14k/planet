package com.laotan.hotel.dao;

import java.util.List;

import com.laotan.hotel.entity.FoodType;

public interface IFoodTypeDao {

	//保存菜系
	public abstract void save(FoodType foodType);
	
	//得到所有的菜系
	public abstract List<FoodType> getAll();
	//根据id查找某个菜系
	public abstract FoodType getFoodTypeById(int id);
	//更新菜系
	public abstract void update(FoodType foodType);
	//根据id删除菜系
	public abstract void delete(int id);
	//模糊查询
	public abstract List<FoodType> search(String keyword);
	
}
