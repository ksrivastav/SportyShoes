package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Cart;
import model.Order;
import model.Product;
import model.ProductCategory;
import model.User;
import model.UserRoles;
import service.OrderService;
import service.ProductCategoryService;
import service.ProductService;
import service.UserRolesService;
import service.UserService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

	public AdminController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/adminlogin", method=RequestMethod.GET)
	public String customerLoginPage() 
	{
		
		return "AdminLoginPage";
		
	}

		  //suffix will be automatically added to it
		
	@RequestMapping(value="/authenticateadmin", method=RequestMethod.POST)
	public String adminLogin(HttpServletRequest request, HttpServletResponse response, Model model) 
	{
		String curEmail=request.getParameter("login-email");
		String curPassword = request.getParameter("login-password");
		UserService userService = new UserService();
		User user= userService.getAllUserByEmail(curEmail);
		UserRoles userRoles = new UserRoles();
		UserRolesService userRolesService= new UserRolesService();
		userRoles = userRolesService.getAllUserRolesByUserId(user.getUserId());
		String roleUser= userRoles.getRole().getName();
		if(roleUser.equals("Admin"))
		{
			if(!curPassword.equals(user.getPassword()))
			{
				model.addAttribute("loginAdminError", "Login failed. Please try again");
				return "AdminLoginPage";
			}
			else
			{
				
				
				HttpSession session = request.getSession();
				session.setAttribute("currentMemberAccountEmail", curEmail);
				session.setAttribute("curPassword", curPassword);
				Cart cart = new Cart();
				cart.setCurUser(user);
				session.setAttribute("curUserCart",cart );				
				session.setAttribute("curUser", user);
				System.out.println("loggedin");
				
				return "AdminDashboard";
				
			}
			
		}
		else
		{
			model.addAttribute("loginAdminError", "Login failed. Please try again");
			return "AdminLoginPage";
		}
		
		
		
	}
	
	@RequestMapping(value="/manageProduct", method=RequestMethod.GET)
	public String manageProduct(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		ProductService productService = new ProductService();
		ArrayList<Product> productList = productService.getAllProduct();
		System.out.println(productList.toString()); 
		model.addAttribute("ProductList", productList);
		
		
		return "ManageProduct";  //suffix will be automatically added to it
	}
	
	
	@RequestMapping(value="/editProduct", method=RequestMethod.GET)
	public String editProduct(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		int productId = Integer.parseInt(request.getParameter("id"));
		
		ProductService productService = new ProductService();
		Product product = productService.getProductById(productId);
		System.out.println(product.toString()); 
		model.addAttribute("Product", product);
		
		model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());
		
		return "EditProduct";  //suffix will be automatically added to it
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public String updateProduct(HttpServletRequest request, HttpServletResponse response, Model model)
	{	
		int productId = Integer.parseInt(request.getParameter("productId"));	
		String productname = request.getParameter("productname");	
		String productColor = request.getParameter("productColor");	
		double productPrice = Double.parseDouble(request.getParameter("productPrice"));	
		String productImage = request.getParameter("productImage");	
		String productTag = request.getParameter("productTag");	
		int productCategoryId = Integer.parseInt(request.getParameter("productCategory"));	
			
		
		
		System.out.println(request.getParameterNames().toString());
		
		ProductCategory prodCat = new ProductCategory();
		ProductCategoryService prodCategoryService = new ProductCategoryService();
		prodCat = prodCategoryService.getProductCategoryById(productCategoryId);


		ProductService productService = new ProductService();
		System.out.println(request.getParameterNames().toString());
		Product product = productService.getProductById(productId);
		product.setColor(productColor);
		product.setImage(productImage);
		product.setImage(productImage);
		product.setName(productname);
		product.setPrice(productPrice);
		product.setProductCategory(prodCat);
		
		try
		{
			productId = productService.updateProduct(product);
			product = productService.getProductById(productId);
		}
		catch(Exception e)
		{
			model.addAttribute("ProductUpdateError", "Update failed. Please try again");
		}
		
		model.addAttribute("Product", product);		
		model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());		
		return "EditProduct";
	}
	
	@RequestMapping(value="/manageUsers", method=RequestMethod.GET)
	public String manageUsers(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		
		UserService userService = new UserService();
		ArrayList<User> userList = userService.getAllUser();
		System.out.println(userList.toString()); 
		model.addAttribute("UserList", userList);
		
		
		return "ManageUser";  //suffix will be automatically added to it
	}
	
	@RequestMapping(value="/editUser", method=RequestMethod.GET)
	public String editUser(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		int userId = Integer.parseInt(request.getParameter("id"));
		
		UserService userService = new UserService();
		User user = userService.getAllUserById(userId);
		System.out.println(user.toString()); 
		model.addAttribute("User", user);
		
		//model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());
		
		return "EditUser";  //suffix will be automatically added to it
	}
	
	@RequestMapping(value="/manageAdminAccount", method=RequestMethod.GET)
	public String manageAdminAccount(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("curUser");
		//int userId = Integer.parseInt(request.getParameter("id"));
		
		UserService userService = new UserService();		
		System.out.println(user.toString()); 
		model.addAttribute("User", user);
		
		//model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());
		
		return "EditUser";  //suffix will be automatically added to it
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(HttpServletRequest request, HttpServletResponse response, Model model)
	{	
		int userId = Integer.parseInt(request.getParameter("userId"));	
		String userName = request.getParameter("userName");	
		String userEmail = request.getParameter("userEmail");	
		String userAddress = request.getParameter("userAddress");	
		String userPhoneNumber = request.getParameter("userPhoneNumber");	
		String userPassword = request.getParameter("userPassword");	
		//int productCategoryId = Integer.parseInt(request.getParameter("productCategory"));	
			
		


		UserService userService = new UserService();
		System.out.println(request.getParameterNames().toString());
		User user =  userService.getAllUserById(userId);
		user.setUserName(userName);
		user.setPhoneNumber(userPhoneNumber);
		user.setAddress(userAddress);
		user.setEmail(userEmail);
		user.setPassword(userPassword);
		
		
		try
		{
			userId = userService.updateUser(user);
			user =  userService.getAllUserById(userId);
		}
		catch(Exception e)
		{
			model.addAttribute("ProductUpdateError", "Update failed. Please try again");
		}
		
		model.addAttribute("User", user);		
		//model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());		
		return "EditUser";
	}
	
	@RequestMapping(value="/purchaseReport", method=RequestMethod.GET)
	public String purchaseReport(HttpServletRequest request, HttpServletResponse response, Model model)
	{	
		ArrayList<Order> orderList = new ArrayList<Order>();
		OrderService orderService = new OrderService();		
		orderList = orderService.getAllOrder();
		
		model.addAttribute("orderList", orderList);		
		//model.addAttribute("curentproductId", product.getProductCategory().getProductCategoryid());		
		return "OrderReport";
	}
	
	
		
	
		
		
		

	

}
