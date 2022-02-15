package com.traineeapp.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.traineeapp.model.persistance.user.User;
import com.traineeapp.model.exceptions.UserNotFoundException;
import com.traineeapp.model.service.UserService;
import com.traineeapp.model.service.UserServiceImpl;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	private UserService userService=new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			User user=userService.getUser(username, password);
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("traineecontroller.do?action=showall");
			
		}catch(UserNotFoundException ex) {
			response.sendRedirect("login.jsp?error=login failed!");
		}
		
	}

}