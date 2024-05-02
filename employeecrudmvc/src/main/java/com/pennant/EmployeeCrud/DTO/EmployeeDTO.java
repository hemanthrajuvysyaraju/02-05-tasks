package com.pennant.EmployeeCrud.DTO;

import java.io.Serializable;
import java.sql.Date;

public class EmployeeDTO implements Serializable {
	private static final long serialVersionUID = 5768921313071127758L;
	private Integer empNo;
	private String empName;
	private String empJob;
	private Integer empMgr;
	private Date empHireDate;
	private Double empSal;
	private Double empCommission;
	private Integer empDeptno;
	public Integer getEmpNo() {
		return empNo;
	}
	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpJob() {
		return empJob;
	}
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}
	public Integer getEmpMgr() {
		return empMgr;
	}
	public void setEmpMgr(Integer empMgr) {
		this.empMgr = empMgr;
	}
	public Date getEmpHireDate() {
		return empHireDate;
	}
	public void setEmpHireDate(Date empHireDate) {
		this.empHireDate = empHireDate;
	}
	public Double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	public Double getEmpCommission() {
		return empCommission;
	}
	public void setEmpCommission(Double empCommission) {
		this.empCommission = empCommission;
	}
	public Integer getEmpDeptno() {
		return empDeptno;
	}
	public void setEmpDeptno(Integer empDeptno) {
		this.empDeptno = empDeptno;
	}
	
}
