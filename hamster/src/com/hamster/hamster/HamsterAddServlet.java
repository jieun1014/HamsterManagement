package com.hamster.hamster;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.hamsterLayer.serviceLayer.HamsterAddService;

public class HamsterAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/hamster/add.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String species = request.getParameter("species");
		String birth_date = request.getParameter("birth_date");
		String color = request.getParameter("color");
		String status = request.getParameter("status");

		Hamster hamster = new Hamster(name, gender, species, birth_date, color, status);

		new HamsterAddService().add(hamster);
		//regiInfo(hamster);

		response.sendRedirect(this.getServletContext().getContextPath() + "/hamster/list");
	}

}
