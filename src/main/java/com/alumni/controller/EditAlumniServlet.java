package com.alumni.controller;

import com.alumni.dao.AlumniDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditAlumniServlet extends HttpServlet {

    private AlumniDAO dao = new AlumniDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("year", request.getParameter("year"));
        request.setAttribute("course", request.getParameter("course"));

        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int year = Integer.parseInt(request.getParameter("year"));
        String course = request.getParameter("course");

        try {
            dao.updateAlumni(id, name, email, year, course);
            response.sendRedirect("list");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}