<%@page import="model.*"%> 

<% 
	User user =(User)session.getAttribute("curUser"); 
    Cart curUserCart = (Cart)session.getAttribute("curUserCart");
    int cartCount =0; 
    if(curUserCart!=null)
    	{
    			cartCount =curUserCart.getCartItemCount();
    	
    	}
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="/SpotryShoes/">Sporty Shoes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent"> 
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="/SpotryShoes/">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="/SpotryShoes/gotocart">Cart <span class="badge badge-danger"><%= cartCount %></span> </a></li>	
				
				<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a></li>
				<% if(user!= null){ %>
				<li class="nav-item"><a class="nav-link" href="log-out">Logout</a></li>			
				<%} 
				if(user== null){ %>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<%} %>
				
			</ul>
		</div>
	</div>
</nav>