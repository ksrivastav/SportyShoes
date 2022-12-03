<%-- <%@page import="cn.techtutorial.connection.DbCon"%>
<%@page import="cn.techtutorial.dao.OrderDao"%>

<%@page import="java.util.*"%>

<%-- 
<%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("person", auth);
}
OrderDao pd = new OrderDao(DbCon.getConnection());
List<Order> orderList = pd.getAllOrders();
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%> 
<%@page import="service.OrderService"%> 
<%@page import ="java.util.ArrayList" %>
<%
	ArrayList<Order> orderList = new ArrayList<Order>();
	OrderService orderService = new OrderService();		
	orderList = orderService.getAllOrder();

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
		<div class="card-header my-3">All Orders</div>
		<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">OrderId</th>
      <th scope="col">Price</th>
      <th scope="col">Status</th>
      <th scope="col">Order Create DateTime</th>
      <th scope="col">Order Update DateTime</th>
      <th scope="col">Customer Name</th>
      <th scope="col">Customer Email</th>
      <th scope="col">Customer Address</th>    
    </tr>
  </thead>
  <tbody>
  <%
			if (!orderList.isEmpty()) {
				for (Order p : orderList) {
			%>
    <tr>
      <td><%=p.getOrderId() %></td>
      <td> $<%=p.getOrderAmount() %></td>
      <td><%=p.getStatus() %></td>
      <td> <%=p.getCreateDateTime() %></td>
      <td><%=p.getUpdateDateTime() %></td>
      <td><%=p.getUser().getUserName() %></td>
      <td><%=p.getUser().getEmail() %>></td>
      <td><%=p.getUser().getAddress() %></td>
      <td></td>
    </tr>
    <%
			}
			} else {
			out.println("There is no proucts");
			}
			%>

    
  </tbody>
</table>
		
	</div>

<%--	<%@include file="/includes/footer.jsp"%> --%>
</body>
</html>