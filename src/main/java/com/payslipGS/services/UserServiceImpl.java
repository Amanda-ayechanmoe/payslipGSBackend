package com.payslipGS.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payslipGS.dao.UserRepositroy;
import com.payslipGS.entities.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepositroy userRepo;
	
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		List<User> userList=userRepo.findAll();
		return userList;
	}

	@Override
	public void deleteUser(int userId) {
		userRepo.deleteById(userId);
	}

	@Override
	public User getUserbyId(int userId) {
		User user=userRepo.getOne(userId);
		return user;
	}

	@Override
	public User updateUser(int userId,User user) {
		User userUpdate=userRepo.getOne(userId);
		userUpdate.setName(user.getName());
		userUpdate.setAddress(user.getAddress());
		userUpdate.setDepartment(user.getDepartment());
		userUpdate.setJobTitle(user.getJobTitle());
		userUpdate.setBankAccount(user.getBankAccount());
		userUpdate.setDateOfBirth(user.getDateOfBirth());
		userUpdate.setStartDate(user.getStartDate());
		userUpdate.setUsername(user.getUsername());
		userUpdate.setPassword(user.getPassword());
		User updatedUser=userRepo.save(userUpdate);
		return updatedUser;
		
	}

	@Override
	public List<User> getUserbyLogin(String username, String password) {
		List<User> userList=userRepo.findUserbyLogin(username, password);
		/*
		 * int userId=0; for(int i=0;i<userList.size();i++) { User user=userList.get(i);
		 * userId=user.getUserId(); }
		 */
		return userList;
	}

}
