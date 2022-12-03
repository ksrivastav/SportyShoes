<%-- <%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.ProductDao"%>

<%@page import="java.util.*"%>

<%-- 
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> ProductList = pd.getAllProducts();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%> 
<%@page import="service.UserService"%> 
<%@page import ="java.util.ArrayList" %>
<%
	
	UserService userService = new UserService();
	ArrayList<User> userList = userService.getAllUser();

%>
<!DOCTYPE html>
<html>
<head>
<%--<%@include file="/includes/head.jsp"%>--%>
<title>Sporty Shoes</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!userList.isEmpty()) {
				for (User userItem : userList) {
			%>
			
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" width="200" height="200"  src="https://images.pexels.com/photos/1520760/pexels-photo-1520760.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=userItem.getUserName() %></h5>
						<h6 class="category">Address: <%=userItem.getAddress() %></h6>
						<h6 class="price">Phone: <%=userItem.getPhoneNumber() %></h6>
						<h6 class="category">Email: <%=userItem.getEmail() %></h6>
						<div class="mt-3 d-flex justify-content-between">						
							<div class="form-group">								
								<a class="btn btn-dark" href="/SpotryShoes/editUser?id=<%=userItem.getUserId() %>">Edit User</a>
								
							</div>
					
							
								
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

		</div>
	</div>

<%--	<%@include file="/includes/footer.jsp"%> --%>
</body>
</html>