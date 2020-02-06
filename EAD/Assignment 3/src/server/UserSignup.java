package server;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserSignup
 */
@WebServlet("/UserSignup")
public class UserSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first_name = request.getParameter("first-name");
		String last_name = request.getParameter("last-name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = request.getParameter("contact");
		String organisation = request.getParameter("organisation");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	
            
            String validationSql = "SELECT * FROM USERS WHERE EMAIL='"+email+"'";
            ResultSet check = Connect_db.getConnection().executeQuery(validationSql);
            
            out.println("<html><body>");
          	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");

            
            if(!check.next()){
            
	            String sql = "INSERT INTO Users (first_name,last_name,gender,email,password,contact,organisation) ";
	            sql += "VALUES ('"+first_name+"','"+last_name+"','"+gender+"','"+email+"','"+password+"','"+contact+"','"+organisation+"')";
	            int rs = Connect_db.getConnection().executeUpdate(sql);

	            if(rs == 1) {
	            	String sqlForId = "SELECT id FROM USERS WHERE EMAIL='"+email+"'";
	            	ResultSet idResult = Connect_db.getConnection().executeQuery(sqlForId);
	            	idResult.next();
	            	
					HttpSession session = request.getSession();
					session.setAttribute("user", email);
	            	
	            	int id = idResult.getInt("id");
	            	out.println("<script>swal('Registration Successful', 'Your registration ID is "+id+"', 'success')");
					out.println(".then(() => { window.location = '/EAD-4/signup.html?registrationId="+id+"'; })</script>");
				} else {
					out.println("<script>swal('Registration Unsuccessful', 'Something went wrong!', 'error')");
					out.println(".then(() => { window.location = '/EAD-4/signup.html'; })</script>");
				}
            } else {
            	out.println("<script>swal('Registration Unsuccessful', '"+email+" is already registred. Try with another email or swith to login page.', 'error')");
				out.println(".then(() => { window.location = '/EAD-4/signup.html'; })</script>");
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