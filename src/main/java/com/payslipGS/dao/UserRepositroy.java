package com.payslipGS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payslipGS.entities.User;

@Repository
public interface UserRepositroy extends JpaRepository<User, Integer>{

	@Query(value="SELECT * FROM USERINFO u where u.username = :username AND u.password=:password",nativeQuery=true) 
    List<User> findUserbyLogin(@Param("username") String username, @Param("password") String password);
}
