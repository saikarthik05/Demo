package com.myproject.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import filtering.FilteringBean;

@RestController
public class FilteringController {

	@GetMapping("/Filtering")
	public FilteringBean retriveFilteringBean1() {
		
		return new FilteringBean("val1","val2","val3");
		
	}
}
