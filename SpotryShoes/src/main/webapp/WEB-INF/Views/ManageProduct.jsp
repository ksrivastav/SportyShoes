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
<%@page import="service.ProductService"%> 
<%@page import ="java.util.ArrayList" %>
<%
	ProductService productService = new ProductService();
	ArrayList<Product> ProductList = productService.getAllProduct();

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
		<div class="card-header my-3">Manage Products</div>
		<div class="row">
			<%
			if (!ProductList.isEmpty()) {
				for (Product p : ProductList) {
			%>
			
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" width="200" height="200"  src="<%=p.getImage() %>"
						alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%=p.getName() %></h5>
						<h6 class="category">Brand: <%=p.getBrand().getName() %></h6>
						<h6 class="price">Price: $<%=p.getPrice() %></h6>
						<h6 class="category">Category: <%=p.getProductCategory().getName() %></h6>
						<div class="mt-3 d-flex justify-content-between">						
							<div class="form-group">								
								<a class="btn btn-dark" href="/SpotryShoes/editProduct?id=<%=p.getProductId()%>">Edit Product</a>
								
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