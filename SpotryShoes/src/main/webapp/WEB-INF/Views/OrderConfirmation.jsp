<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="model.*"%> 
<%@page import="service.ProductService"%> 
<%@page import ="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import ="java.util.Hashtable"%>
<%@page import="java.text.DecimalFormat"%>

<%
	DecimalFormat dcf = new DecimalFormat("#.##");
	User user =(User)session.getAttribute("curUser"); 
	Cart curUserCart =null ;
	 ArrayList<Product> cartProductList=null;
	 Hashtable<Integer, Integer> productMap=null; 
	 double total=0;
	if(user!=null)
	{
		 curUserCart = (Cart)session.getAttribute("curUserCart");
	}

	int cartCount =0; 
	if(curUserCart!=null)
	{
			cartCount =curUserCart.getCartItemCount();
			cartProductList= curUserCart.getProductList();
			productMap= curUserCart.getProductMap();
			total= curUserCart.getTotalPrice();
	
	}
	
	 


%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
<title>Sporty Shoes Order Summary</title>
<style type="text/css">

.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
	<%@include file="/includes/head.jsp"%>

	<div class="container my-4">	
	<div class="d-flex py-3"><h3>Order Successful </h3>
	</div>
	<div class="container my-3">
		<div class="d-flex py-3"><h3>OrderNumber: ${OrderNumber} </h3></div>
		<div class="d-flex py-3"><h3>Total Price:$<%=total %> </h3></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th></th>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Quantity</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cartProductList != null) {
					for (Product p : cartProductList) {
				%>
				<tr>
					<td>
						<img class="card-img-top" width="50" height="50"  src="<%=p.getImage() %>alt="Card image cap">
					</td>
					<td><%=p.getName()%></td>
					<td><%=p.getProductCategory().getName()%></td>
					<td><%= dcf.format(p.getPrice())%></td>
					<td>
						<input type="text" name="quantity" class="form-control"  value="<%=productMap.get(p.getProductId())%>" readonly>						
					</td>
					
					
				</tr>
				<%
				}
					}%>

				
			</tbody>
		</table>
		<br>
		<div class="d-flex py-3"><h3>Deliver Details </h3></div>
		<br>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Customer Name</th>
					<th scope="col">Phone</th>
					<th scope="col">Address</th>
					<th scope="col">Email</th>					
				</tr>
			</thead>
			<tbody>
				
				<tr>
					<td><%= user.getUserName() %></td>
					<td><%= user.getPhoneNumber() %></td>
					<td><%= user.getAddress() %></td>
					<td><%= user.getEmail()%></td>
				</tr>

				
			</tbody>
		</table>
		
								<a class="btn btn-primary" href="/SpotryShoes/paymentpage">Confirm</a>
		
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>