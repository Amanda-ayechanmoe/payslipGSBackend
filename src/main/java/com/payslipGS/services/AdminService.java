package com.payslipGS.services;
import java.util.List;

import com.payslipGS.entities.Admin;
public interface AdminService {

	public Boolean getAdminbyLogin(String username,String password);
}
