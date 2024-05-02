package com.pennant.EmployeeCrud.ServiceFactory;

import com.pennant.EmployeeCrud.Service.EmployeeCrudServiceImpl;
import com.pennant.EmployeeCrud.Service.IEmployeeCrudService;

public class EmployeeService {

	private static IEmployeeCrudService service=null;
	private EmployeeService()
	{
		
	}
	public static IEmployeeCrudService getService()
	{
		if(service!=null)
		{
			service= new EmployeeCrudServiceImpl();
		}
		return service;
	}

}
