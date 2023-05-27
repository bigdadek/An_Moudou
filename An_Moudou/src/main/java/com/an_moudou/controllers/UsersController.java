package com.an_moudou.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.an_moudou.entities.Users;
import com.an_moudou.services.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
	@Autowired
	private UsersService userService;
	
	@GetMapping("/users")
	public List<Users> getAllUsers(){
		return userService.getAll();
	}		
	
	@PostMapping("/user")
	public ResponseEntity<Users> createUsers(@RequestBody Users users) {
		Users createdUsers = userService.add(users); 
		//Users createdUsers = userrep.save(user); 
		 return ResponseEntity.ok(createdUsers);
	}		

	@GetMapping("/user/{id}")
	public Optional<Users> getUsersById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUsers(@PathVariable Long id, @RequestBody Users userDetails){
		Users updatedUsers = userService.update(userDetails);
		return ResponseEntity.ok(updatedUsers);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable Long id){
		userService.delete(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
