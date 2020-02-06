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
 * Servlet implementation class VehicleRegister
 */
@WebServlet("/VehicleRegister")
public class VehicleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("car-name");
		String vehicleType = request.getParameter("vehicle-type");
		String vehicleNumber = request.getParameter("vehicle-number");
		String employee_id = request.getParameter("employee-id");
		String identification = request.getParameter("identification");
		String registerId = request.getParameter("registerId");
		String pass_type = request.getParameter("pass-type");
		double price = Double.valueOf(request.getParameter("price"));
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String sql;
            sql = "SELECT vehicleId FROM USERS WHERE id='"+registerId+"'";
            ResultSet rs = Connect_db.getConnection().executeQuery(sql);
            
            out.println("<html><body>");
        	out.println("<script src='https://unpkg.com/sweetalert/dist/sweetalert.min.js'></script>");
        	
            if(rs.next()) {
				int vehicleId = rs.getInt("vehicleId");
				if(vehicleId==0){
					sql = "INSERT INTO VEHICLES(name,vehicle_type,vehicle_number,employee_id,identification,pass_type,price) ";
					sql += "VALUES ('"+name+"','"+vehicleType+"','"+vehicleNumber+"','"+employee_id+"','"+identification+"','"+pass_type+"',"+price+")";
					int rs2 = Connect_db.getConnection().executeUpdate(sql);
					
					if(rs2==1){
						sql = "SELECT id FROM VEHICLES WHERE vehicle_type='"+vehicleType+"' AND vehicle_number='"+vehicleNumber+"' AND employee_id='"+employee_id+"'";
						ResultSet rs3 = Connect_db.getConnection().executeQuery(sql);
						if(rs3.next()){
							vehicleId = rs3.getInt("id");
							sql = "UPDATE Users SET vehicleId="+vehicleId+" WHERE id="+registerId;
							Connect_db.getConnection().executeUpdate(sql);
							out.println("<script>swal('Vehicle Registered Successfully', 'Price: $ "+price+" for parking "+pass_type+"', 'success')");
							out.println(".then(() => { window.location = '/EAD-4/home'; })</script>");
						}
					}
				} else {
					out.println("<script>swal('Registration Unsuccessful', 'Another vehicle is already registered with registration ID " + registerId
							+ "!', 'error')");
					out.println(".then(() => { window.location = '/EAD-4/signup.html?registrationId="+registerId+"'; })</script>");
				}
			} else {
				out.println("<script>swal('Registration Unsuccessful', 'Registration ID " + registerId
						+ " is invalid!', 'error')");
				out.println(".then(() => { window.location = '/EAD-4/signup.html'; })</script>");
			}
            
        	
        	out.println("</body></html>");
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {            
            out.close();
        }
	}

}