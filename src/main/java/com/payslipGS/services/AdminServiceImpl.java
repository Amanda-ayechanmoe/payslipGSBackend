package com.payslipGS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payslipGS.dao.AdminRepository;
import com.payslipGS.entities.Admin;
import com.payslipGS.entities.User;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepo;

	@Override
	public Boolean getAdminbyLogin(String username, String password) {
		
		boolean isValidAdmin=true;
		List<Admin> adminList=adminRepo.findAdminbyLogin(username, password);
		int adminId=0; 
		for(int i=0;i<adminList.size();i++) { 
	    Admin admin=adminList.get(i); 
	    adminId=admin.getAdminId(); 
	    }
		if(adminId!=0) {
			isValidAdmin=true; }
		else { isValidAdmin=false; }
		 
		
		
		return isValidAdmin;
	}

}
