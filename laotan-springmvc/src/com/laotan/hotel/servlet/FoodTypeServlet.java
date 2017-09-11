package com.laotan.hotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laotan.hotel.entity.FoodType;
import com.laotan.hotel.factory.BeanFactory;
import com.laotan.hotel.service.IFoodTypeService;

/**
 * 菜系管理 1.添加菜系 2.展示菜系 3.进入更新页面 4.更新菜系 5.删除菜系
 * 
 * @author Administrator
 *
 */
public class FoodTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IFoodTypeService foodTypeService = BeanFactory.getInstance("foodTypeService", IFoodTypeService.class);
	String url = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String method = request.getParameter("method");
		// 添加菜系
		if ("addFoodType".equals(method)) {
			addFoodType(request, response);
			// 菜系列表
		} else if ("FoodTypeList".equals(method)) {
			FoodTypeList(request, response);
			//进入更新页面
		}else if ("viewupdate".equals(method)) {
			Viewupdate(request,response);
			//进行更新操作
		}else if ("update".equals(method)) {
			update(request,response);
		}else if ("delete".equals(method)) {
			delete(request,response);
		}else if ("search".equals(method)) {
			search(request,response);
		}

	}

	public void addFoodType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String name = request.getParameter("name").trim();
			FoodType foodType = new FoodType();
			foodType.setTypeName(name);
			foodTypeService.addFoodtype(foodType);
			FoodTypeList(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "/error/error.jsp";
		}

		//request.getRequestDispatcher(url).forward(request, response);

	}

	public void FoodTypeList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<FoodType> allFoodType = foodTypeService.getAll();
			
			for (FoodType foodType : allFoodType) {
				System.out.println(foodType.getTypeName());
				
			}
			request.setAttribute("allFoodType", allFoodType);
			url = "/sys/foodtype/cuisineList.jsp";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			url = "/error/error.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

	public void Viewupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			String id = request.getParameter("id");
			FoodType foodType = foodTypeService.getFoodTypeById(Integer.parseInt(id));
			request.setAttribute("foodType", foodType);
		     url="/sys/foodtype/updateCuisine.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			url = "/error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}
	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
			String typename = request.getParameter("name");
			  String id = request.getParameter("cid");
			  FoodType foodType = new FoodType();
			  foodType.setId(Integer.parseInt(id));
			  foodType.setTypeName(typename);
			  foodTypeService.update(foodType);
			  FoodTypeList(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try {
			String id = request.getParameter("id");
			   foodTypeService.delete(Integer.parseInt(id));
			   FoodTypeList(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     String keyword = request.getParameter("keyword");	
		  System.out.println(keyword);
	     List<FoodType> list = foodTypeService.search(keyword);
		 request.setAttribute("allFoodType",list);
		 request.getRequestDispatcher("/sys/foodtype/cuisineList.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
