package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Cart;
import model.Order;
import model.OrderDetails;
import model.Product;
import model.User;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductService;


@Controller
public class ProductController {

	public ProductController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/listproduct", method=RequestMethod.GET)
	public String listProduct(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		ProductService productService = new ProductService();
		ArrayList<Product> productList = productService.getAllProduct();
		System.out.println(productList.toString()); 
		model.addAttribute("ProductList", productList);
		
		
		return "AllProduct";  //suffix will be automatically added to it
	}
	
	@RequestMapping(value="/addtocart", method=RequestMethod.GET)
	public String addToCart(HttpServletRequest request)
	{
		int productId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("curUser")!=null)
		{
			Product prod = new Product();
			
			ProductService prodService = new ProductService();
			prod= prodService.getProductById(productId);
			
			Cart cart = (Cart)session.getAttribute("curUserCart");
			cart.addCartItem(prod);
			session.setAttribute("curUserCart", cart);
			return "AllProduct"; 
		}
		else
		{
			return "CustomerLoginPage";
		}
		
		
	}
	
	@RequestMapping(value="/gotocart", method=RequestMethod.GET)
	public String goToCart(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		if(session.getAttribute("curUser")!=null)
		{
						
			return "Cart";
			
		}
		else
		{
			return "CustomerLoginPage";
		}
	}
	
	@RequestMapping(value="/quantityincdec", method=RequestMethod.GET)
	public String quantityincdec(HttpServletRequest request)
	{
		int productId = Integer.parseInt(request.getParameter("id"));
		String action = request.getParameter("id");
		
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("curUser")!=null)
		{
			Product prod = new Product();
			
			ProductService prodService = new ProductService();
			prod= prodService.getProductById(productId);
			
			Cart cart = (Cart)session.getAttribute("curUserCart");			
			cart.addCartItem(prod);
			session.setAttribute("curUserCart", cart);
			return "Cart";
		}
		else
		{
			return "CustomerLoginPage";
		}
		
		
	}
	
	@RequestMapping(value="/buynow", method=RequestMethod.GET)
	public String buynow(HttpServletRequest request)
	{
		
		
			return "OrderDetails";
		
		
		
	}
	
	@RequestMapping(value="/paymentpage", method=RequestMethod.GET)
	public String paymentPage(HttpServletRequest request)
	{
		
		
			return "PaymentPage";	
		
		
	}
	
	
	
	@RequestMapping(value="/confirmorder", method=RequestMethod.GET)
	public String confirmOrder(HttpServletRequest request, Model model)
	{
		
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("curUser");
		Cart cart =null;
		
		if(user!=null)
		{
			cart = (Cart)session.getAttribute("curUserCart");	
		}
		
		OrderService orderService = new OrderService();
		Order order = new Order();
		LocalDateTime now = LocalDateTime.now();  
		
		order.setStatus("Confirmed");		
		order.setCreateDateTime(now);		
		order.setUser(user);
		order.setCreateDateTime(now);
		order.setOrderAmount(cart.getTotalPrice());		
		int orderId=0;
		orderId=orderService.createOrder(order);
		
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		
		model.addAttribute("OrderNumber", orderId);
		
		ArrayList<Product> prodList= cart.getProductList();
		var productmap = cart.getProductMap();
		
		prodList.forEach(prod->{
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrder(order);
			orderDetails.setProduct(prod);
			orderDetails.setQuantity(productmap.get(prod.getProductId()));
			orderDetails.setProductPricePaid(productmap.get(prod.getProductId()) * prod.getPrice());
			orderDetails.setCreateDateTime(now);
			orderDetailsService.createOrderDetails(orderDetails);
			
		} );
		
		
		
		
			return "OrderConfirmation";	
		
		
	}
	
	
	
	
	
	
}
