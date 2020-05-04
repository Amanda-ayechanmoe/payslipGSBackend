package com.payslipGS.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "PAYSLIP")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class PaySlip {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PAYSLIPID")
	private Integer payslipId;

	@Column(name = "ISSUEDATE")
	private Date issueDate;

	@Column(name = "BASICPAY")
	private Float basicPay;

	@Column(name = "OVERTIME")
	private Float overTime;

	@Column(name = "BONUS")
	private Float bonus;

	@Column(name = "GROSSPAY")
	private Float grossPay;

	@Column(name = "TAX")
	private Float tax;

	@Column(name = "USERID")
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/*
	 * @ManyToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "USERID") private User user;
	 * 
	 * public User getUser() { return user; }
	 * 
	 * public void setUser(User user) { this.user = user; }
	 */

	public Integer getPayslipId() {
		return payslipId;
	}

	public void setPayslipId(Integer payslipId) {
		this.payslipId = payslipId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Float getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(Float basicPay) {
		this.basicPay = basicPay;
	}

	public Float getOverTime() {
		return overTime;
	}

	public void setOverTime(Float overTime) {
		this.overTime = overTime;
	}

	public Float getBonus() {
		return bonus;
	}

	public void setBonus(Float bonus) {
		this.bonus = bonus;
	}

	public Float getGrossPay() {
		return grossPay;
	}

	public void setGrossPay(Float grossPay) {
		this.grossPay = grossPay;
	}

	public Float getTax() {
		return tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	public Float getCpf() {
		return cpf;
	}

	public void setCpf(Float cpf) {
		this.cpf = cpf;
	}

	public Float getNetPay() {
		return netPay;
	}

	public void setNetPay(Float netPay) {
		this.netPay = netPay;
	}

	@Column(name = "CPF")
	private Float cpf;

	@Column(name = "NETPAY")
	private Float netPay;

}
