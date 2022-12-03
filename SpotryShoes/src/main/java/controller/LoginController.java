package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import model.Cart;
import model.User;
import model.UserRoles;
import service.UserRolesService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@RequestMapping(value="/customerlogin", method=RequestMethod.GET)
	public String customerLoginPage() 
	{
		
		return "CustomerLoginPage";
		
	}

		  //suffix will be automatically added to it
		
		@RequestMapping(value="/authenticateuser", method=RequestMethod.POST)
		public String customerLogin(HttpServletRequest request, HttpServletResponse response, Model model) 
		{
			String curEmail=request.getParameter("login-email");
			String curPassword = request.getParameter("login-password");
			UserService userService = new UserService();
			User user= userService.getAllUserByEmail(curEmail);
			UserRoles userRoles = new UserRoles();
			UserRolesService userRolesService= new UserRolesService();
			userRoles = userRolesService.getAllUserRolesByUserId(user.getUserId());
			
			if(userRoles.getRole().getName().equals("Customer") || userRoles.getRole().getName().equals("Admin"))
			{
				if(!curPassword.equals(user.getPassword()))
				{
					model.addAttribute("loginAdminError", "Login failed. Please try again");
					return "LoginPage";
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
					
					return "AllProduct";
					
				}
				
			}
			else
			{
				model.addAttribute("loginAdminError", "Login failed. Please try again");
				return "LoginPage";
			}
			
			
			
	}
	
		
		
		

	

}
