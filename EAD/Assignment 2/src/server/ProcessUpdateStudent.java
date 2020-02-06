package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessUpdateStudent
 */
@WebServlet("/ProcessUpdateStudent")
public class ProcessUpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessUpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><body>");
		out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
		String Firstname = request.getParameter("firstName");
		String Lastname = request.getParameter("lastName");
		String Fathername = request.getParameter("fatherName");
		String Email = request.getParameter("email_id");
		String originalEmail = request.getParameter("originalEmail");
		int age=Integer.parseInt(request.getParameter("age"));
		int cls=Integer.parseInt(request.getParameter("class"));
		
		try {

			ResultSet rs = Connect_db.getConnection().executeQuery("SELECT email from StudentDetail WHERE email='"+Email+"'");
			
			if(originalEmail.equals(Email) || !rs.next()){
			
				int updated = Connect_db.getConnection().executeUpdate("UPDATE StudentDetail SET FirstName='"+Firstname+"', LastName='"+Lastname+"', FatherName='"+Fathername+"', Email='"+Email+"', age='"+age+"', class='"+cls+"' WHERE Email='"+originalEmail+"'");
				
				if(updated==1){
					out.println("<script>swal('Details successfully updated', 'Details of "+originalEmail+" has been added to Student List', 'success')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				} else {
					out.println("<script>swal('Oops!', 'Something went wrong!', 'error')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				}
			} else {
				out.println("<script>swal('"+Email+" already exists', 'Try with another email addres!', 'error')");
				out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}