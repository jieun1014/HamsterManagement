package com.hamster.hamster;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hamsterLayer.serviceLayer.HamsterDeleteService;

public class HamsterDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int hamsterNo = Integer.valueOf(request.getParameter("no"));
		
		new HamsterDeleteService().remove(hamsterNo);
		
		response.sendRedirect(this.getServletContext().getContextPath() + "/hamster/list");
	}

}
