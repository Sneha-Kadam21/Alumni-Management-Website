package com.alumni.controller;

import com.alumni.dao.AlumniDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/search")
public class SearchAlumniServlet extends HttpServlet {

    private AlumniDAO dao = new AlumniDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");
        String type = request.getParameter("type");

        try {
            request.setAttribute("alumniList", dao.searchAlumni(keyword, type));
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}