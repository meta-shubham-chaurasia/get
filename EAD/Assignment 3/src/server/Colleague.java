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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Colleague
 */
@WebServlet("/Colleague")
public class Colleague extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Colleague() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
        	if(session==null){
        		out.println("<script>window.location=\"login.html\"</script>");
        	}
        	
            String email = request.getParameter("email");
            
            String sql;
            sql = "SELECT * FROM Users WHERE email=\""+email+"\"";
            ResultSet rs = Connect_db.getConnection().executeQuery(sql);
            
            String doc = "<!DOCTYPE html><html lang=\"en\"><head> <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"/> <title>Colleague</title></head><body>";
        	
            
            if(rs.next()) {
            	int id = rs.getInt("id");
            	String first_name = rs.getString("first_name"), last_name=rs.getString("last_name");
            	String contact = rs.getString("contact"), organisation = rs.getString("organisation");
            	String gender = rs.getString("gender");
            	
            	doc += "<nav> <h1> Meta-Parking </h1> <form action='logout' method='get'> <button> Logout </button> </form> </nav> <h1 class=\"central-heading\">"
            	+ first_name+" "+last_name+"</h1> <table> <tr> <th>Registration Id: </th> <td>"
            	+ "<input type=\"tel\" value=\""+id+"\" disabled=\"disabled\" /></td></tr><tr> <th>Name: </th> <td>"
            	+ "<input type=\"text\" value=\""+first_name+" "+last_name+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Email: </th> <td>"
            	+ "<input type=\"email\" value=\""+email+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Contact No.: </th> <td>"
            	+ "<input type=\"tel\" value=\""+contact+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Gender: </th> <td>"
            	+ "<input type=\"text\" value=\""+gender+"\" disabled=\"disabled\"/> </td></tr><tr> <th>Organisation: </th> <td>"
            	+ "<input type=\"text\" value=\""+organisation+"\" disabled=\"disabled\"/> </td></tr></table>";	            	        
            } else {
            	doc += "<h1 class='central-heading' style='color: red'>User not found</h1>";
            }
            out.println(doc);
            out.println("<script src=\"scripts.js\"></script></body></html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {            
            out.close();
        }
	}

}