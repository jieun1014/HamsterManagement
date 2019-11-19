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
import javax.sql.DataSource;

import com.hamsterLayer.serviceLayer.HamsterViewService;

public class HamsterViewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int hamsterNo = Integer.valueOf(request.getParameter("no"));
		
		Hamster hamster = new HamsterViewService().view(hamsterNo);
		request.setAttribute("view", hamster);
		
		ServletContext sc = this.getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/hamster/view.jsp");
		rd.forward(request, response);
		
	}
}
