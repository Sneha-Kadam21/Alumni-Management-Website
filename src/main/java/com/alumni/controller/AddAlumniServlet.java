package com.alumni.controller;
import com.alumni.dao.AlumniDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/add")


public class AddAlumniServlet extends HttpServlet{
	private AlumniDAO dao =new AlumniDAO();
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int year=Integer.parseInt(request.getParameter("year"));
		String course=request.getParameter("course");
		
		try {
			dao.insertAlumni(name,email,year,course);
			response.sendRedirect("list");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
}
