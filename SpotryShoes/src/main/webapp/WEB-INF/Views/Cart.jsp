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
<title>Sporty Shoes Cart</title>
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
	<%@include file="/includes/navbar.jsp"%>

	<div class="container my-3">
		<div class="d-flex py-3"><h3>Total Price:$<%=total %> </h3> <a class="mx-3 btn btn-primary" href="/SpotryShoes/buynow">By Now</a></div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					<th scope="col">Buy Now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (cartProductList != null) {
					for (Product p : cartProductList) {
				%>
				<tr>
					<td><%=p.getName()%></td>
					<td><%=p.getProductCategory().getName()%></td>
					<td><%= dcf.format(p.getPrice())%></td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= p.getProductId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantityincdec?action=inc&id=<%=p.getProductId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=productMap.get(p.getProductId())%>" readonly> 
								<a class="btn btn-sm btn-decre" href="quantityincdec?action=dec&id=<%=p.getProductId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					
				</tr>

				<%
				}}%>
			</tbody>
		</table>
	</div>

	<%@include file="/includes/footer.jsp"%>
</body>
</html>