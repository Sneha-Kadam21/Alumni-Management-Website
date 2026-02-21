package com.alumni.controller;
import com.alumni.dao.AlumniDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/list")






public class ListAlumniServlet extends HttpServlet{
	private AlumniDAO dao=new AlumniDAO();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try {
			request.setAttribute("alumniList", dao.selectAllAlumni());
			request.getRequestDispatcher("list.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
