package com.javatpoint.rest;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class HelloService{
	
	@Path("/hello")
	@GET
	public Response get() {
 		String output = "Saved ";
 		return Response.status(200).entity(output).build();
 	}
	
	
 	@POST
 	@Path("/submit")
 	@Consumes(MediaType.APPLICATION_JSON)
	public Response getMsg(EmployeeRequest e) {
 		
 		Manager.addEmployee(e.getName(),Integer.valueOf(e.getSalary()),e.getCity(),e.getState(),Integer.valueOf(e.getPincode()));
 		String output = "Saved ";
 		return Response.status(200).entity(output).build();
 	}
 	
 	@GET
 	@Path("/list")
 	@Produces(MediaType.TEXT_HTML)
 	public String listEmployees() {
 		List <Employee> Emp = Manager.listEmployees();
 		String list = "<table> <tr> <th>Name</th>  <th> Salary </th> <th> Address </th> <th> Pincode </th> <th> Deletions</th> </tr>";
 		StringBuilder str = new StringBuilder();
 		str.append(list);
 		for(Employee e : Emp) {
 			if(e.getAddress()!=null) {
 				String row = "<tr> <td>" + e.getName() + "</td> <td>" + e.getSalary() + "</td> <td>"
 					 + e.getAddress().getCity() + ", " + e.getAddress().getState() + "</td> <td>" +  e.getAddress().getPincode()
 					 + "</td><td> <input type=\"button\" name=\"del\" id=\"del\" value=\"Delete\" onclick=\"del("
 					 	+ e.getId() + ")\">";
 				str.append(row);
 			}
 			
 		}
 		str.append("</tr></table>");
 		return str.toString();
 	}
 	
 	@GET
 	@Path("/del/{id}")
 	@Produces(MediaType.TEXT_HTML)
 	public String delete(@PathParam("id") Integer id) {
 		Manager.deleteEmployee(id);
 		return listEmployees();
 	}
	
}