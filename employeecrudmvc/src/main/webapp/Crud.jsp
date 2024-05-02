<%@page
	import="com.pennant.EmployeeCrud.ServiceFactory.EmployeeCrudServiceFactory"%>
<%@page import="com.pennant.EmployeeCrud.DTO.EmployeeListDTO"%>
<%@page import="com.pennant.EmployeeCrud.DTO.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee CrudApp</title>
<style type="text/css">
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	padding: 12px;
	border: 1px solid #ddd;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f2f2f2;
}

header {
	background-color: rgb(3, 198, 252);
	display: flex;
	justify-content: space-between;
	padding: 10px 20px;
}
#form
{
	text-align: center;
	display: flex;
	flex-direction: row;
	width: auto;
	border:3px solid black;
	border-radius:10px;
	padding:20px;
	
}
.left_div
{
	display: flex;
	flex-direction: column;
	margin-left: 200px;
	margin-right: 600px;
}

.right_div{
	display: flex;
	flex-direction: column;
	
}
#logo-div {
	width: 30%;
}
</style>

</head>
<body>
	<header>
		<div id="logo-div">
			<img src="Pennantlogo.png" id="logo" alt="pennant logo">
		</div>
		<div align="center">
			<h1>Pennant Employee Crud</h1>
		</div>
		<div>
			<img src="crudphoto.png" id="logo" alt="crud logo">
		</div>
	</header>
	</br>
	<div>
			<form title="Employee Data">
			<div id="form">
				<div class="left_div">
					<label for="empid">Emp ID:</label> 
					<input type="number" name="empid" id="empid"> 
					<label for="empjob">Emp Job:</label>
					<input type="text" name="empjob" id="empjob">
					<label for="emphiredate">Hire Date:</label>
					<input type="date" name="emphiredate" id="emphiredate">
					<label for="commission">Emp Commission</label>
					<input type="number" name="commission" id="commission">
				</div>
				<div class="right_div">
					<label for="empname">Emp Name:</label>
					<input type="text" name="empname" id="empname">
					<label for="manager">Manger Id:</label>
					<input type="number" name="manager" id="manager">
					<label for="salary">Emp Salary:</label>
					<input type="number" name="salary" id="salary">
					<label for="deptno">Emp Dept:</label>
					<input type="number" name="deptno" id="deptno">
				</div>
				</div>
			</form>
	</div>
	</br>
	<div>
		<table>
			<tr>
				<th>empno</th>
				<th>empname</th>
				<th>job</th>
				<th>manager</th>
				<th>hiredate</th>
				<th>salary</th>
				<th>commission</th>
				<th>deptno</th>
			</tr>
			<%
			EmployeeListDTO employees = EmployeeCrudServiceFactory.getService().getEmployees();
			int count = 0;
			for (EmployeeDTO employee : employees) {
			%>
			<tr id=<%=count++%>>
				<td><%=employee.getEmpNo()%></td>
				<td><%=employee.getEmpName()%></td>
				<td><%=employee.getEmpJob()%></td>
				<td><%=employee.getEmpMgr()%></td>
				<td><%=employee.getEmpHireDate()%></td>
				<td><%=employee.getEmpSal()%></td>
				<td><%=employee.getEmpCommission()%></td>
				<td><%=employee.getEmpDeptno()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>