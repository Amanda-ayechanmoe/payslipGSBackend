package com.payslipGS.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.payslipGS.entities.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query(value="SELECT * FROM  ADMIN a where a.username = :username AND a.password=:password",nativeQuery=true) 
    List<Admin> findAdminbyLogin(@Param("username") String username, @Param("password") String password);

}
