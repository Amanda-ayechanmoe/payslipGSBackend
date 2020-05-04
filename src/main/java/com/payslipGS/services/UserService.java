package com.payslipGS.services;

import java.util.List;

import com.payslipGS.entities.User;

public interface UserService {

	public User save(User user);
	public List<User> getAllUser();
	public void deleteUser(int userId);
	public User getUserbyId(int userId);
	public User updateUser(int userId,User user);
	public List<User> getUserbyLogin(String username,String password);
}
