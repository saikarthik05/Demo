package com.myproject.restfulwebservices.helloworld;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.myproject.restfulwebservices.users.Users;

@RestController
public class UserResourceController {
	@Autowired
	UserDaoService dao;

	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public List<Users> findall() {
		return dao.findall();

	}

	@RequestMapping(method = RequestMethod.POST, path = "/save")
	public ResponseEntity<Object> saveUsers(@Valid  @RequestBody Users user) {
		List<Users> usser = dao.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(usser.get(0).getId()).toUri();
		
	ResponseEntity<Object> response= 	ResponseEntity.created(location).build();
		return response;

	}

	@RequestMapping(method = RequestMethod.GET, path = "/findbyname/{name}")
	public Resource<Users> findbyname(@PathVariable String name) {
		Users us = new Users();
		List<Users> user=dao.findbyId(name);
		us = user.get(0);
		Resource<Users> resource = new Resource<Users>(us);
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findall());
		resource.add(linkTo.withRel("allUsersLink"));
		return resource;

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/deletebyname/{name}")
	
	public List<Users> deleteById(@PathVariable String name) {
		
		List<Users> usersLeft = dao.deleteById(name);
		return usersLeft;
	}

}
