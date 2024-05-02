package com.pennnat.EmployeeCrud.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

import com.pennant.EmployeeCrud.DTO.EmployeeDTO;
import com.pennant.EmployeeCrud.DTO.EmployeeListDTO;
import com.pennant.EmployeeCrud.ServiceFactory.EmployeeService;
public class CrudContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getRequestURI().endsWith("add"))
		{
			int empno = Integer.parseInt(request.getParameter("empno"));
			String empname = request.getParameter("empname");
			String job = request.getParameter("job");
			int manager = Integer.parseInt(request.getParameter("mgr"));
			Date hiredate = Date.valueOf(request.getParameter("hiredate"));
			Double salary = Double.valueOf(request.getParameter("sal"));
			Double commission = Double.valueOf(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			EmployeeDTO employee = new EmployeeDTO();
			employee.setEmpNo(empno);
			employee.setEmpName(empname);
			employee.setEmpJob(job);
			employee.setEmpMgr(manager);
			employee.setEmpHireDate(hiredate);
			employee.setEmpSal(salary);
			employee.setEmpCommission(commission);
			employee.setEmpDeptno(deptno);
			EmployeeListDTO employees = EmployeeService.getService().addEmployee(employee);
			HttpSession hs = request.getSession(true);
			hs.setAttribute("employees", employees);
			RequestDispatcher rd = request.getRequestDispatcher("Crud.jsp");
			rd.forward(request, response);
		}
	
	}

}
