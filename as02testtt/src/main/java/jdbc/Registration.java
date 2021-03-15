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

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Registration() {
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

			String sql = "insert into students_reg(st_email, st_pass) values(?,?)";
			String sql_2 = "select * from students_reg where st_email=?";

			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wm2", "postgres", "root");
			
			PreparedStatement ps = conn.prepareStatement(sql);
			PreparedStatement ps_2 = conn.prepareStatement(sql_2);

			ps.setString(1, email);
			ps.setString(2, password);
			ps_2.setString(1, email);
			
			ResultSet rs = ps_2.executeQuery();
			while (rs.next()) {
				dbName = rs.getString("st_email");
			}

			if (email.equals(dbName)) {
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				ps.executeUpdate();
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {

			System.out.println("ERROR:");
			e.printStackTrace();
		}

	}

}
