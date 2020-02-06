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
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }
    

		// Open a connection
		
    
    @Override
    public void destroy() {
    	System.out.println("inside destroy");
    }

    private static String capitalize(String str){
    	if(str == null || str.isEmpty()) {
            return str;
        }
    	return str.substring(0, 1).toUpperCase() + str.substring(1);
    	
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			
			ResultSet students = Connect_db.getConnection().executeQuery("SELECT * FROM StudentDetail");
			out.println("<!DOCTYPE html><html><head><meta charset=\"ISO-8859-1\"><style>th, td{padding: 10px;}table{margin-left: auto;margin-right: auto;margin-top: 50px;}table, th, td{border: solid 1px black;}h1{text-align: center;}</style><title>Student's List</title></head><body><h1>Students List</h1><table><tr><th>First Name</th><th>Last Name</th><th>Father's Name</th><th>Email</th><th>Age</th><th>Class</th><th>Update Here</th></tr>");
			
			while(students.next()){
				out.println("<tr><td>"+capitalize(students.getString("FirstName")) +"</td><td>"+capitalize(students.getString("LastName"))+"</td><td>"+students.getString("FatherName")+"</td><td>"+students.getString("Email")+"</td><td>"+students.getString("age")+"</td><td>"+students.getString("class")+"</td><td><a href=\"/EAD-3/updateStudent?email="+students.getString("Email")+"\">Update >></a></td></tr>");
			}

			out.println("</tr></table></body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			out.close();
		}
	}

}