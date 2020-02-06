package server;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	
            String sql;
            sql = "SELECT first_name, email FROM Users WHERE email=\""+email+"\"";
            ResultSet rs = Connect_db.getConnection().executeQuery(sql);
            
            out.println("<html><body>");
        	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        	
            if(rs.next()) {
            	String name = rs.getString("first_name");
				sql += " AND password=\"" + password + "\"";
				ResultSet rs2 = Connect_db.getConnection().executeQuery(sql);
				if (rs2.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("user", email);
					
					out.println("<script>swal('Login Successful', 'Welcome back "
							+ name + "', 'success')");
					out.println(".then(() => { window.location = '/EAD-4/home'; })</script>");
				} else {
					out.println("<script>swal('Login Unsuccessful', 'Check your password', 'error')");
					out.println(".then(() => { window.location = '/EAD-4/login.html'; })</script>");
				}
			} else {
				out.println("<script>swal('Login Unsuccessful', 'User " + email
						+ " not found!', 'error')");
				out.println(".then(() => { window.location = '/EAD-4/login.html'; })</script>");
			}
            
        	
        	out.println("</body></html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {            
            out.close();
        }
	}

}