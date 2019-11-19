package com.hamster.hamster;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.hamsterLayer.serviceLayer.HamsterEditService;
import com.hamsterLayer.serviceLayer.HamsterViewService;

public class HamsterEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int hamsterNo = Integer.valueOf(request.getParameter("no"));
		Hamster hamster = new HamsterViewService().view(hamsterNo);
		
		request.setAttribute("edit", hamster);
		
		ServletContext servletContext = this.getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/jsp/hamster/edit.jsp");
		requestDispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int no = Integer.valueOf(request.getParameter("no"));
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String species = request.getParameter("species");
		String birth_date = request.getParameter("birth_date");
		String color = request.getParameter("color");
		String status = request.getParameter("status");
		
		Hamster hamster = new Hamster(no, name, gender, species, birth_date, color, status);
		
		new HamsterEditService().edit(hamster);
		
		response.sendRedirect(this.getServletContext().getContextPath() +"/hamster/list");
	}
}
