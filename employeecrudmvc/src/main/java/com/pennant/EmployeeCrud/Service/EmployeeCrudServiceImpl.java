package com.pennant.EmployeeCrud.Service;

import com.pennant.EmployeeCrud.DAO.EmployeeCrudDAOImpl;
import com.pennant.EmployeeCrud.DAO.IEmployeeCrudDAO;
import com.pennant.EmployeeCrud.DTO.EmployeeDTO;
import com.pennant.EmployeeCrud.DTO.EmployeeListDTO;

public class EmployeeCrudServiceImpl implements IEmployeeCrudService {

	private IEmployeeCrudDAO empDao = null;

	@Override
	public EmployeeListDTO addEmployee(EmployeeDTO employee) {
		empDao = new EmployeeCrudDAOImpl();
		return empDao.addEmployee(employee);
	}

	@Override
	public EmployeeListDTO editEmployee(EmployeeDTO employee) {
		empDao = new EmployeeCrudDAOImpl();
		return empDao.editEmployee(employee);
	}

	@Override
	public EmployeeListDTO deleteEmployee(Integer empId) {
		empDao = new EmployeeCrudDAOImpl();
		return empDao.deleteEmployee(empId);
	}

	@Override
	public EmployeeListDTO getEmployees() {
		empDao = new EmployeeCrudDAOImpl();
		return empDao.getEmployees();
	}

}
