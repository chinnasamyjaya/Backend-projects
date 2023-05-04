package EmployeeMangement.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EmployeeMangement.EmployeeDAO.EmployeeDAO;
import EmployeeMangement.model.Employee;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private static String INSERT="/Employee.jsp";
    private static String Edit="/EditEmployee.jsp";
    private static String EmployeeList="/EmployeeList.jsp";
    
    private EmployeeDAO employeeDAO;
    
    public EmployeeServlet() throws ClassNotFoundException {
        super();
        // TODO Auto-generated constructor stub
        employeeDAO=new EmployeeDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String redirect="";
		String empId=request.getParameter("id");
		String action=request.getParameter("action");
		if(!((empId)==null)&& action.equalsIgnoreCase("insert"))
		{
			int id=Integer.parseInt(empId);
			Employee employee=new Employee();
			employee.setId(id);
			employee.setName(request.getParameter("name"));
			employee.setEmail(request.getParameter("email"));
			employee.setCountry(request.getParameter("country"));
			employee.setPassword(request.getParameter("password"));
			try {
				employeeDAO.InsertEmployee(employee);
			}catch(SQLException e) {
				e.printStackTrace(); 
			}
			try {
				request.setAttribute("employees", employeeDAO.GetEmployees());
				redirect = EmployeeList;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Record Added Successfully");

			}
		else if (action.equalsIgnoreCase("delete")) {
			String id = request.getParameter("id");
			int eid = Integer.parseInt(id);
			employeeDAO.DeleteEmployee(eid);
			redirect = EmployeeList;
			try {
				  request.setAttribute("employee", employeeDAO.GetEmployees());
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace(); 
			
			}
			System.out.println("Record Deleted Successfully");

		}
		else if (action.equalsIgnoreCase("editform")) {
			redirect = Edit;
		}
			else if (action.equalsIgnoreCase("edit")) {
				String id = request.getParameter("id");
				int eid = Integer.parseInt(id);
				Employee employee=new Employee();
				employee.setId(eid);
				employee.setName(request.getParameter("name"));
				employee.setEmail(request.getParameter("email"));
				employee.setCountry(request.getParameter("country"));
				employee.setPassword(request.getParameter("password"));
				employeeDAO.UpdateEmployee(employee);
				request.setAttribute("employee", employee);
				redirect = EmployeeList;
				System.out.println("Record Updated Successfully");

			}
		else if (action.equalsIgnoreCase("EmployeeList")) {
			redirect = EmployeeList;
			try {
				  request.setAttribute("employee", employeeDAO.GetEmployees());
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace(); 
			
			}

		}
		else {
			redirect = "Employee.jap";
		    }
		    RequestDispatcher rd = request.getRequestDispatcher(redirect);
		    rd.forward(request, response);
		}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}