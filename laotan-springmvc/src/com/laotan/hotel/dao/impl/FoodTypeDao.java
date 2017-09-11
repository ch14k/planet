package com.laotan.hotel.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.laotan.hotel.dao.IFoodTypeDao;
import com.laotan.hotel.entity.FoodType;
import com.laotan.hotel.util.JDBCUtils;



public class FoodTypeDao implements IFoodTypeDao {

	@Override
	public void save(FoodType foodType) {
		String sql = "insert into foodtype(typename) values(?)";
		try {
			JDBCUtils.getQueryRunner().update(sql, foodType.getTypeName());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * BeanListHandler将查询结果转化为pojo的集合
	 */
	@Override
	public List<FoodType> getAll() {
		String sql = "select * from foodtype";
		try {
			return JDBCUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * BeanHandler将查询结果转化为javabean
	 */
	@Override
	public FoodType getFoodTypeById(int id) {
		 String sql="select * from foodtype  where id=?";
		 try {
			return  JDBCUtils.getQueryRunner().query(sql, new BeanHandler<FoodType>(FoodType.class),id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		 
		 
	}

	@Override
	public void update(FoodType foodType) {
		 String sql="update  foodtype set typename=? where id=?";
		 try {
			JDBCUtils.getQueryRunner().update(sql, foodType.getTypeName(),foodType.getId());
		} catch (SQLException e) {
			 throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		 String sql="delete from foodtype where id=?";
		 try {
			JDBCUtils.getQueryRunner().update(sql, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> search(String keyword) {
		//select * from foodtype where like '%川%';
		  String sql="select * from foodtype  where typename like ?";
			try {
				return   JDBCUtils.getQueryRunner().query(sql, new BeanListHandler<FoodType>(FoodType.class), "%"+keyword+"%");
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
	
	}

}
