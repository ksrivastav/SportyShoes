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
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/global.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    

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


	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price:$<%=total %> </h3> <a class="mx-3 btn btn-primary" href="/SpotryShoes/buynow">By Now</a></div>
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