package com.myproject.restfulwebservices.helloworld;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import filtering.FilteringBean;

@RestController
public class FilteringController {

	@GetMapping("/Filtering")
	public FilteringBean retriveFilteringBean1() {
		
		FilteringBean someBean = new FilteringBean("karthik", "sravani", "bujji");
	/*	SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterOutAllExcept("field2","field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBean", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);*/
		
	
		
		return someBean;
		
	}
}
