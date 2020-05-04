package com.payslipGS.services;

import java.util.List;

import com.payslipGS.entities.PaySlip;
import com.payslipGS.entities.User;

public interface PayslipService {
	
	public PaySlip create(PaySlip paySlip);
	public PaySlip getPayslipById(int id);
	public List<PaySlip> getPayslipbyUserid(int userId);
	public void deletePayslipbyUserId(List<PaySlip> paySlip);
	
}
