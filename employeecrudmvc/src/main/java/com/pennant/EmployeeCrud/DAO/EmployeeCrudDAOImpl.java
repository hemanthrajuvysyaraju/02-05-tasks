package com.pennant.EmployeeCrud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.pennant.EmployeeCrud.DTO.EmployeeDTO;
import com.pennant.EmployeeCrud.DTO.EmployeeListDTO;

import JDBCUTILITIES.JdbcUtil;

public class EmployeeCrudDAOImpl implements IEmployeeCrudDAO {

	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rs;
	private DataSource dataSource;

	@Override
	public EmployeeListDTO addEmployee(EmployeeDTO employee) {
		EmployeeListDTO employees = new EmployeeListDTO();
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement(
					"WITH InsertedData AS (INSERT INTO i213_empcrud VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING * )SELECT * FROM i213_empcrud UNION ALL SELECT * FROM InsertedData;");
			psmt.setInt(1, employee.getEmpNo());
			psmt.setString(2, employee.getEmpName());
			psmt.setString(3, employee.getEmpJob());
			psmt.setInt(4, employee.getEmpMgr());
			psmt.setDate(5, employee.getEmpHireDate());
			psmt.setDouble(6, employee.getEmpSal());
			psmt.setDouble(7, employee.getEmpCommission());
			psmt.setInt(8, employee.getEmpDeptno());
			rs = psmt.executeQuery();
			addEmployees(employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public EmployeeListDTO editEmployee(EmployeeDTO employee) {
		EmployeeListDTO employees = new EmployeeListDTO();
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement(
					"WITH UpdatedData AS (UPDATE i213_empcrud SET ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? WHERE empno=? RETURNING *)SELECT * FROM i213_empcrud  where empno not in(select empno from UpdatedData)UNION ALL SELECT * FROM UpdatedData;");
			psmt.setString(1, employee.getEmpName());
			psmt.setString(2, employee.getEmpJob());
			psmt.setInt(3, employee.getEmpMgr());
			psmt.setDate(4, employee.getEmpHireDate());
			psmt.setDouble(5, employee.getEmpSal());
			psmt.setDouble(6, employee.getEmpCommission());
			psmt.setInt(7, employee.getEmpDeptno());
			psmt.setInt(8, employee.getEmpNo());
			rs = psmt.executeQuery();
			addEmployees(employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public EmployeeListDTO deleteEmployee(Integer empId) {
		EmployeeListDTO employees = new EmployeeListDTO();
		con = JdbcUtil.getConnection();
		try {
			psmt = con.prepareStatement(
					"WITH deleted_row AS (DELETE FROM i213_empcrud WHERE empno = ? RETURNING empno)SELECT * FROM i213_empcrud WHERE empno NOT IN (SELECT empno FROM deleted_row);");
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			addEmployees(employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	@Override
	public EmployeeListDTO getEmployees() {
		EmployeeListDTO employees = new EmployeeListDTO();
		dataSource = JdbcUtil.getHikariConnection();
		try {
			con = dataSource.getConnection();
			psmt = con.prepareStatement("select * from i213_empcrud");
			rs = psmt.executeQuery();
			addEmployees(employees);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	private void addEmployees(EmployeeListDTO employees) {
		try {
			while (rs.next()) {
				EmployeeDTO employee = new EmployeeDTO();
				employee.setEmpNo(rs.getInt("empno"));
				employee.setEmpName(rs.getString("ename"));
				employee.setEmpJob(rs.getString("job"));
				employee.setEmpMgr(rs.getInt("mgr"));
				employee.setEmpHireDate(rs.getDate("hiredate"));
				employee.setEmpSal(rs.getDouble("sal"));
				employee.setEmpCommission(rs.getDouble("comm"));
				employee.setEmpDeptno(rs.getInt("deptno"));
				employees.add(employee);
			}
			// JdbcUtil.closeConnections(con, psmt, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
