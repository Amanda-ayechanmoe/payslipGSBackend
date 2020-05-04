package com.payslipGS.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payslipGS.dao.PayslipRepository;
import com.payslipGS.entities.PaySlip;
import com.payslipGS.entities.User;

@Service
public class PayslipServiceImpl implements PayslipService{

	@Autowired
	PayslipRepository payslipRepo;
	
	@Override
	public PaySlip create(PaySlip paySlip) {
		// TODO Auto-generated method stub
		return payslipRepo.save(paySlip);
	}

	@Override
	public PaySlip getPayslipById(int id) {
		PaySlip payslip=payslipRepo.getOne(id);
		return payslip;
	}

	
	/*
	 * @Override public User getUserbyPaySlip(PaySlip paySlip) { User int
	 * userId=paySlip.getUserId(); User user= return user; }
	 */
	 

	@Override
	public List<PaySlip> getPayslipbyUserid(int userId) {
		List<PaySlip> payslipList=payslipRepo.findAll();
		List<PaySlip> pList=new ArrayList<PaySlip>();
		for (int i=0;i<payslipList.size();i++) {
			PaySlip payslip=payslipList.get(i);
			int idUser=payslip.getUserId();
			if(idUser==userId) {
				pList.add(payslip);
			}
			
		}
		return pList;
	}

	@Override
	public void deletePayslipbyUserId(List<PaySlip> paySlip) {
		for (int i=0;i<paySlip.size();i++) {
			PaySlip payslip=paySlip.get(i);
			payslipRepo.deleteById(payslip.getPayslipId());;
		}
		
	}

	
	

}
