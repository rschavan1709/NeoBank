package com.neosoft.controller;

import java.math.BigDecimal;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.validation.Valid;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Notifications;
import com.neosoft.model.User;
import com.neosoft.service.AdminServiceImpl;
import com.neosoft.service.NotificationsService;
import com.neosoft.utility.BaseResponse;
import com.neosoft.utility.NotificationInfo;

@RestController
@RequestMapping("/user")
public class AdminController {
	
	@Autowired
	AdminServiceImpl adminService;
	@Autowired
	BaseResponse<User> b;
	@Autowired
	BaseResponse<List<User>> b1;
	@Autowired
	BaseResponse<Void> b2;
	
	@Autowired
	NotificationInfo notificationInfo;
	
	@Autowired
	NotificationsService notificationsService;
	
	@PostMapping("/add")
	public BaseResponse<User> addUser(@RequestBody @Valid User user) {
		try {
		    Notifications notification=	notificationInfo.add();
		    notification.setUser(user);
		    notificationsService.add(notification);
			//User user1=adminService.add(user);
			 b.setDataT(user);
			 b.setStatusCode(201);
			 b.setMessage("User Added Successfully..");
			 return b;
		}
		catch(Exception e) {
			e.printStackTrace();
			 b.setStatusCode(500);
			 b.setMessage("User Not Added");
			 return b;
		}
	}
	
	@GetMapping("/getAll")
	public BaseResponse<List<User>> getAllUsers() {
		List<User> users=adminService.listAll();
		if(users.size()<=0) {
			b1.setStatusCode(404);
			b1.setMessage("List is Empty");
			return b1;
		}
		b1.setStatusCode(200);
		b1.setMessage("Read a List");
		b1.setDataT(users);
		return b1;
	}
	
	@GetMapping("/getByAccNo/{accNo}")
	public BaseResponse<User> getByAccNo(@PathVariable long accNo){
		BaseResponse<User> b=new BaseResponse<>();
		User user=adminService.getByAccNo(accNo);
		if(user==null) {
			b.setStatusCode(404);
			b.setMessage("User Not Found");
			return b;
		}
		b.setStatusCode(200);
		b.setMessage("User Found");
		b.setDataT(user);
		return b;
	}
	
	@DeleteMapping("/delete/{accNo}")
	public BaseResponse<Void> delete(@PathVariable long accNo) {
		try {
		adminService.deleteByAccNo(accNo);
		b2.setStatusCode(204);
		b2.setMessage("User Deleted Successfully..");
		return b2;
		}
		catch(Exception e) {
			e.printStackTrace();
			b2.setStatusCode(500);
			b2.setMessage("User Not Deleted");
			return b2;
		}
	}
	
	@PutMapping("/update/{accNo}")
	public BaseResponse<User> update(@PathVariable long accNo,@RequestBody  User user) {
		BaseResponse<User> b=new BaseResponse<>();
		try {
			User user2= adminService.update(accNo,user);
			b.setStatusCode(200);
			b.setMessage("User data updated successfully..");
			b.setDataT(user2);
			return b;
		}
		catch(Exception e) {
			e.printStackTrace();
			b.setStatusCode(500);
			b.setMessage("User data not updated");
			return b;
		}
	}
	
	@PutMapping("/deposit/{accNo}/{amt}")
	public void deposit(@PathVariable long accNo,@PathVariable BigDecimal amt)
	{
		adminService.deposit(accNo, amt);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
	
}
