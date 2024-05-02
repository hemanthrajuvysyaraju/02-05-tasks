package com.pennant.EmployeeCrud.DAO;

import com.pennant.EmployeeCrud.DTO.EmployeeDTO;
import com.pennant.EmployeeCrud.DTO.EmployeeListDTO;

public interface IEmployeeCrudDAO {
	public EmployeeListDTO addEmployee(EmployeeDTO employee);
	public EmployeeListDTO editEmployee(EmployeeDTO employee);
	public EmployeeListDTO deleteEmployee(Integer empId);
	public EmployeeListDTO getEmployees();
}