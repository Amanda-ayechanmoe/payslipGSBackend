package com.payslipGS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payslipGS.entities.PaySlip;
import com.payslipGS.entities.User;
import com.payslipGS.services.PayslipService;
import com.payslipGS.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	PayslipService payslipService;
	
	@PostMapping("userLogin")
	public List<User> UserLogin(@RequestBody User user) {
		String username=user.getUsername();
		String password=user.getPassword();
		List<User> userList=userService.getUserbyLogin(username, password);
		return userList;
	}
	
	@GetMapping("userHome/{userId}")
	public List<PaySlip> paySlipList(@PathVariable Integer userId) {
		List<PaySlip> payslipList=payslipService.getPayslipbyUserid(userId);
		return payslipList;
	}
	
	@GetMapping("getPayslip/{payslipId}")
	public PaySlip getPayslipbyId(@PathVariable Integer payslipId) {
		PaySlip payslip=payslipService.getPayslipById(payslipId);
		return payslip;
	}
		
	
	
}
