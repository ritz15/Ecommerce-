package com.demo.user.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;
import com.demo.user.service.SequenceGeneratorService;
import com.demo.user.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UserService userServ;
	@Autowired
	private SequenceGeneratorService service;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser( @RequestBody @Valid User user) throws UserAlreadyExistsException {
	
		user.setId(service.getSequenceNumber(User.SEQUENCE_NAME));
		User savedUser=userServ.saveUser(user);
		return  new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
		 
	} 
	@GetMapping("/getUsers")
	public ResponseEntity< List<User> >getAllUsers(){
		
		List<User> userList= userServ.getAllUsers();
		if(userList.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			
		return new ResponseEntity<List<User>> (userList,HttpStatus.OK);
		
	}
	@GetMapping ("/user/{id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int id) throws UserDoesntExistException {
		//return Optional.of(userServ.getUserById(id));
		
	Optional<User> userObj=userServ.getUserById(id);
		return  new ResponseEntity <Optional<User>> ( userObj,HttpStatus.OK);
		/*User user= userServ.getUserById(id); 
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user)); */
		
	} 
	@PutMapping("/user/{id}")
	public ResponseEntity<Void> update( @Valid @PathVariable int id ,@RequestBody User user)  throws UserAlreadyExistsException{
		userServ.update(id,user);
		return  new ResponseEntity<>(HttpStatus.OK);
	} 
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<String> delete (@PathVariable ("id") int id) throws UserDoesntExistException {
		userServ.deleteById(id);
		//return "Deleted";
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}  
	
	
}
