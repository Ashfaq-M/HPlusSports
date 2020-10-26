package com.test.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.DBConnection;

public class HomeServlet extends HttpServlet {

	Connection connection = null;

	// servlet lifecycle init, service and destroy methods

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("In doGet method");

		// forword the control to the index.html
		req.getRequestDispatcher("/html/index.html").forward(req, resp);

	}

	@Override
	public void init() throws ServletException {

		System.out.println("In init method");

		// initialize activity - set up DB Connection
		connection = DBConnection.getConnectionToDatabase();

	}

	@Override
	public void destroy() {

		System.out.println("In Destroy method");

		// clean up activity - close DB Connection object
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
