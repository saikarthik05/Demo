package com.myproject.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.sun.java.util.jar.pack.Package.Class.Method;

@RestController
public class HelloWorldController {
	
@RequestMapping(method=RequestMethod.GET, path="/greeting")
public String helloWorld() {
	return "hello guys";
	
	
}

@GetMapping(path="/alieans/{name}")
public HelloWorldBean helloWorldBean(@PathVariable String name) {
	String message= name.toString();
	 //return new HelloWorldBean(message);
	return new HelloWorldBean(String.format("Hi aliens,%s",name));
	
	
}
}
