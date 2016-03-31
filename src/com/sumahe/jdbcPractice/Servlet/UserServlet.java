package com.sumahe.jdbcPractice.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sumahe.jdbcPractice.Bean.User;
import com.sumahe.jdbcPractice.dao.UserService;
import com.sumahe.jdbcPractice.dao.impl.copy.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		List<User> users = userService.getUser();
		request.setAttribute("userList", users);
		request.getRequestDispatcher("WEB-INF/lib/userList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		String code = request.getParameter("code");
		user.setCode(code);
		String name = request.getParameter("name");
		user.setName(name);
		String password = request.getParameter("password");
		user.setPassword(password);
		UserService userService = new UserServiceImpl();
		userService.save(user);
	}

}
