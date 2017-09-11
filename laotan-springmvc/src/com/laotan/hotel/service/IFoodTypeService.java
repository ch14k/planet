package com.laotan.hotel.service;

import java.util.List;

import com.laotan.hotel.entity.FoodType;

public interface IFoodTypeService {
	
	//业务逻辑层
	//添加菜系
	public abstract void addFoodtype(FoodType foodType);
    //查询所有的菜系
	public abstract List<FoodType> getAll(); 
	//根据id查找某个菜系
	public abstract FoodType getFoodTypeById(int id);
	//更新菜系
	public abstract void update(FoodType foodType);
	//删除菜系
	public abstract void delete(int id);
	//模糊查询
	public abstract List<FoodType> search(String keyword);
	
}
