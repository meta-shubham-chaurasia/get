package server;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetail
 */
@WebServlet("/StudentDetail")
public class StudentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html><html><body>");
		out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
		String Firstname = request.getParameter("firstName");
		String Lastname = request.getParameter("lastName");
		String Fathername = request.getParameter("fatherName");
		String Email = request.getParameter("email_id");
		int age=Integer.parseInt(request.getParameter("age"));
		int cls=Integer.parseInt(request.getParameter("class"));
		try {

			ResultSet rs = Connect_db.getConnection().executeQuery("SELECT email from StudentDetail WHERE email='"+Email+"'");
			
			if(!rs.next()){
			
				int inserted = Connect_db.getConnection().executeUpdate("INSERT INTO studentDetail " + "VALUES (lower('"
						+ Firstname + "'),lower('" + Lastname + "'),'" + Fathername
						+ "', '" + Email + "', "+age+", "+cls+")");
				if(inserted==1){
					out.println("<script>swal('Details successfully added', '"+Email+" has been added to Student List', 'success')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				} else {
					out.println("<script>swal('Oops!', 'Something went wrong!', 'error')");
					out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
				}
			} else {
				out.println("<script>swal('"+Email+" already exists', 'Try with another email addredd!', 'error')");
				out.println(".then(() => { window.location = '/EAD-3/index.html'; })</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}