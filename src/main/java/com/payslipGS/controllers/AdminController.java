package com.payslipGS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payslipGS.entities.Admin;
import com.payslipGS.entities.PaySlip;
import com.payslipGS.entities.User;
import com.payslipGS.services.AdminService;
import com.payslipGS.services.PayslipService;
import com.payslipGS.services.UserService;

@RestController
@RequestMapping("/api")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	PayslipService payslipService;
	
	@Autowired
	AdminService adminService;
	
	User user=new User();
	
	@PostMapping("adminLogin")
	public Boolean AdminLogin(@RequestBody Admin admin) {
		String username=admin.getUsername();
		String password=admin.getPassword();
		boolean isValidAdmin=adminService.getAdminbyLogin(username, password);
		return isValidAdmin;
	}
	
	@PostMapping("userRegister")
	public User createUser(@RequestBody User user) {
		return userService.save(user);
	}
	
	@GetMapping("userList")
	public List<User> findAll() {
		return userService.getAllUser();
	}
	
	@PutMapping("userUpdate/{userId}")
	public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
		return userService.updateUser(userId, user);
	}
	
	@DeleteMapping("userDelete/{userId}")
	public void deleteSaleOrder(@PathVariable Integer userId) {
		List<PaySlip> payslipList=payslipService.getPayslipbyUserid(userId);
		if(payslipList!=null && payslipList.size()>0) {
			payslipService.deletePayslipbyUserId(payslipList);
			
		}else {
			userService.deleteUser(userId);
			
		}
		//return userService.deleteUser(userId);
	}
	
	@GetMapping("getUser/{userId}")
	public User getUser(@PathVariable Integer userId) {
		return userService.getUserbyId(userId);
	}
	
	@GetMapping("Payslip/{userId}")
	public User issuePayslip(@PathVariable Integer userId) {
		user= userService.getUserbyId(userId);
		return user;
	}
	
	@PostMapping("Payslip")
	public PaySlip createPayslip(@RequestBody PaySlip payslip) {
		return payslipService.create(payslip);
	}
	
}
