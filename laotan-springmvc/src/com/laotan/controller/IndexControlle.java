package com.laotan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexControlle {
	
	@RequestMapping(value="/index")
	@ResponseBody
	public String index(){
		return "/html/index.html";
	}

}
