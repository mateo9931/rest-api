package edu.eci.ieti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.data.User;
import edu.eci.ieti.dto.UserDTO;
import edu.eci.ieti.service.UserService;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
	
	private final UserService userService;
	
	
	public UserController(@Autowired UserService userService) {
		 this.userService = userService;
	 }
	
	@GetMapping
    public ResponseEntity<List<User>> getAll() {
        userService.getAll();
        return new ResponseEntity<List<User>>(HttpStatus.OK);
        
    }
   
    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
    	try {
    		userService.findById(id);
			
		} catch (Exception e) {
			e.getCause();
		}
    	return new ResponseEntity<User>(HttpStatus.OK);
    	  
    }
   
   
    @PostMapping
    public ResponseEntity<User> create( @RequestBody User user ) {
    	try {
    		userService.create(user);
			
		} catch (Exception e) {
			e.getCause();
		}
		 return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
   
    @PutMapping( "/{id}" )	
    public ResponseEntity<User> update( @RequestBody UserDTO userDto, @PathVariable String id ) {
    	userService.update(userDto, id);
    	return new ResponseEntity<User>(HttpStatus.OK);
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
         userService.deleteById(id);  
         return new ResponseEntity<Boolean>(HttpStatus.OK);
    }


}
