package com.alumni.controller;

import com.alumni.dao.AlumniDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")

public class DeleteAlumniServlet extends HttpServlet{
	private AlumniDAO dao=new AlumniDAO();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		int id=Integer.parseInt(request.getParameter("id"));
		try {
			dao.deleteAlumni(id);
			response.sendRedirect("list");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
