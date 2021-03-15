package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Info() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String age = request.getParameter("age");
			String city = request.getParameter("city");
			String country = request.getParameter("country");

			HttpSession httpSes = request.getSession();
			String email = (String) httpSes.getAttribute("email");
			String sql = "update students_reg set st_firstname=?,st_lastname=?,st_age=?,st_city=?,st_country=? where st_email=?";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wm2", "postgres", "root");
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, age);
			ps.setString(4, city);
			ps.setString(5, country);
			ps.setString(6, email);
			
			httpSes.setAttribute("firstName", firstName);
			httpSes.setAttribute("lastName", lastName);
			httpSes.setAttribute("age", age);
			httpSes.setAttribute("city", city);
			httpSes.setAttribute("country", country);
			ps.executeUpdate();

			request.getRequestDispatcher("home.jsp").forward(request, response);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR:");
			e.printStackTrace();
		}
	}

}