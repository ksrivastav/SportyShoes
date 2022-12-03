package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Brand;
import model.Cart;
import model.Order;
import model.OrderDetails;
import model.Product;
import model.ProductCategory;
import model.User;
import service.BrandService;
import service.OrderDetailsService;
import service.OrderService;
import service.ProductCategoryService;
import service.ProductService;
import service.UserService;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showHome(Model model)
	{
		/*
		ProductCategoryService prodCategoryService = new ProductCategoryService();
		ProductCategory prodCat = new ProductCategory();
		prodCat.setName("Cricket Shoes");
		prodCat.setDescription("Active wear, sports wear, running shoes");
		prodCategoryService.createProductCategory(prodCat);
		
		BrandService brandService = new BrandService();
		Brand brand = new Brand();
		brand.setName("Puma");
		LocalDateTime now = LocalDateTime.now();  
		brand.setCreateDateTime(now);		
		brand.setActiveFlag(true);		
		brandService.createBrand(brand);
		
		ProductService productService = new ProductService();
		Product product = new Product();
		product.setName("Puma");		  
		product.setCreateDateTime(now);		
		product.setBrand(brand);
		product.setColor("Black");
		product.setName("Puma AeroPunk");
		product.setPrice(20.00);
		product.setProductCategory(prodCat);
		product.setTag("running, cricket, active, sport");
		product.setImage("https://images.pexels.com/photos/2562992/pexels-photo-2562992.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
		productService.createProduct(product);
		
		/*
		RoleService roleService = new RoleService();
		Role role = new Role();
		role.setName("Admin");
		roleService.createRole(role);
		
		
		UserService userService = new UserService();
		User user = new User();
		user.setUserName("Kartikaya");
		user.setAddress("C 40 gamma 1 Noida");
		user.setEmail("kart.mcr@gmail.com");
		user.setPhoneNumber("98989977122");
		user.setPassword("easyjet");
		userService.createUser(user);
		
		UserRoles userRole = new UserRoles();
		UserRolesService  userRolesService = new UserRolesService();
		userRole.setRole(role);
		userRole.setUser(user);
		userRolesService.createUserRoles(userRole);
		*/
		/*
		UserService userService = new UserService();
		User userNew = userService.getAllUserByEmail("kart.mcr@gmail.com");
		
		OrderService orderService = new OrderService();
		Order order = new Order();
		order.setStatus("Delivered");		  
		order.setCreateDateTime(now);		
		order.setUser(userNew);
		order.setCreateDateTime(now);
		order.setOrderAmount(1290);		
		orderService.createOrder(order);
		
		OrderDetailsService orderDetailsService = new OrderDetailsService();
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setOrder(order);
		orderDetails.setProduct(product);
		orderDetails.setProductPricePaid(product.getPrice());
		orderDetails.setCreateDateTime(now);
		orderDetailsService.createOrderDetails(orderDetails);
		
		ArrayList<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
		orderDetailsList = orderDetailsService.getAllOrderDetails();
		
		System.out.println(orderDetailsList.toString());
		ArrayList<Order> orderList = orderService.getAllOrder();
		System.out.println(orderList.toString());
		
		ArrayList<Brand> brandList = brandService.getAllBrand();
		System.out.println(brandList.toString());
		
		Cart cart= new Cart();
		cart.setCurUser(userNew);
		cart.addCartItem(product);
		*/
		return "Home";  //suffix will be automatically added to it
	}
	
	@RequestMapping("/home")
	public void showHome1()
	{
		
		//System.out.println("Home1");  //suffix will be automatically added to it
	}

}
