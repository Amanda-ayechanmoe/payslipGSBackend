package com.payslipGS.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payslipGS.entities.PaySlip;


@Repository
public interface PayslipRepository extends JpaRepository<PaySlip, Integer>{

}
