<%@page import="com.pennant.shoppingcart.ServiceFactory.ServiceFactory"%>
<%@page import="com.pennant.shoppingcart.models.CustomerModel"%>
<%@page import="com.pennant.shoppingcart.models.CategoryModel"%>
<%@page import="com.pennant.shoppingcart.models.CategoryListModel"%>
<%@page import="com.pennant.shoppingcart.models.ProductModel"%>
<%@page import="com.pennant.shoppingcart.models.ProductListModel"%>
<%@page import="jakarta.servlet.http.Cookie"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.io.IOException"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pennantshopping</title>
<script type="text/javascript" src="jqueryscript.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="homepagestyle.css">
<link rel="stylesheet" href="checkout.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>



<body onload="loading()">
	<script type="text/javascript">
		
	</script>
	<header>
		<div id="logo-div">
			<img src="Pennantlogo.png" id="logo" alt="pennant logo">
		</div>
		<div>
			<h1>pennkart</h1>
		</div>
		<div id="customer">
			<div>
				welcome
				<%=session.getAttribute("username")%>
				<input type="text" id="custid"
					value=<%=session.getAttribute("id")%> name="id" hidden>
			</div>
			<div id="cart" style="cursor: pointer;">
				<h4 class="itemcounter"></h4>
				cart<i class="fa fa-shopping-cart"></i>
			</div>
		</div>
		
	</header>
	<div class="sorting-bar">
		<div>
			<p id="home" style="cursor:pointer">
				home
			</p>
		</div>
		<div>
			<label>category:</label> <select id="category" name="category">
				<option value="" disabled="disabled" selected hidden>
					categories</option>
				<%
				CategoryListModel categories = ServiceFactory.getCategoryImpl().getCategories();
				for (CategoryModel category : categories) {
				%>
				<option id="<%=category.getCat_id()%>"
					value="<%=category.getCat_id()%>"><%=category.getCat_name()%></option>
				<%
				}
				%>
			</select>
		</div>
		<div>
			<label>sort:</label> <select id="sort" name="sort">
				<option disabled="disabled" selected hidden>sort by</option>
			</select>
		</div>
	</div>
	<div style="background:">
		<div class="container">

			<div class="row">
				<div class="col-12 ">
					<div class="message-box">
						<div class="success-container">

							<br> <img
								src="https://cdn.dribbble.com/users/4358240/screenshots/14825308/media/84f51703b2bfc69f7e8bb066897e26e0.gif"
								alt="" style="height: 100px;"> <br>
							<div style="padding-left: 5%; padding-right: 5%">
								<hr
							</div>
							<br>
							<h1 class="monserrat-font" style="color: Grey">Thank you for
								your order</h1>
							<br>

							<div class="confirm-green-box">
								<br>
								<h5>ORDER CONFIRMATION</h5>
								<p>Your order #<%= session.getAttribute("order_id") %> has been sucessful!</p>
								<p>Thank you for choosing pennkart.</p>
							</div>

							<br>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>