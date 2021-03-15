package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String dbName = null;
			String dbPassword = null;

			String dbFirstName = null;
			String dbLastName = null;
			String dbAge = null;
			String dbCity = null;
			String dbCountry = null;

			String sql = "select * from students_reg where st_email=? and st_pass=?";
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wm2", "postgres", "root");
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dbName = rs.getString("st_email");
				dbPassword = rs.getString("st_pass");
				dbFirstName = rs.getString("st_firstname");
				dbLastName = rs.getString("st_lastname");
				dbAge = rs.getString("st_age");
				dbCity = rs.getString("st_city");
				dbCountry = rs.getString("st_country");
			}

			if (email.equals(dbName) && password.equals(dbPassword)) {
				
				HttpSession httpSes = request.getSession();
				httpSes.setAttribute("email", dbName);
				httpSes.setAttribute("firstName", dbFirstName);
				httpSes.setAttribute("lastName", dbLastName);
				httpSes.setAttribute("age", dbAge);
				httpSes.setAttribute("city", dbCity);
				httpSes.setAttribute("country", dbCountry);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			} else {
				// response.sendRedirect("login.jsp");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR:");
			e.printStackTrace();
		}
	}

}
