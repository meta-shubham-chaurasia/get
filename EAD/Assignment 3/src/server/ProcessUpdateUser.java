package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessUpdateUser
 */
@WebServlet("/ProcessUpdateUser")
public class ProcessUpdateUser extends HttpServlet {
	static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessUpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String first_name = request.getParameter("first-name");
		String last_name = request.getParameter("last-name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String organisation = request.getParameter("organisation");
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        	if(session.getAttribute("user")==null){
        		out.println("<script>window.location=\"login.html\"</script>");
        	}
        	String originalEmail = session.getAttribute("user").toString();
        	
        	// Register JDBC driver
        	;
            
            // Execute SQL query
            
            
            out.println("<html><body>");
          	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
                     
            String sql = "UPDATE USERS SET first_name='"+first_name+"', last_name='"+last_name+"', gender='"+gender+"', email='"+email+"', contact='"+contact+"', organisation='"+organisation+"' WHERE email='"+originalEmail+"'";
            
            int rs = Connect_db.getConnection().executeUpdate(sql);

            if(rs == 1) {
            	
				session.setAttribute("user", email);
            	
            	out.println("<script>swal('Update Successful', 'Your profile has been successfully updated', 'success')");
				out.println(".then(() => { window.location = '/EAD-4/home'; })</script>");
			} else {
				out.println("<script>swal('Update Unsuccessful', 'Something went wrong!', 'error')");
				out.println(".then(() => { window.location = '/EAD-4/home'; })</script>");
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