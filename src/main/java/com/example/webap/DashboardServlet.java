package com.example.webap;

/*import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DashboardServlet", value = "/Dashboard-servlet")
public class DashboardServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body><h1>Welcome " + request.getSession(false).getAttribute("username") + "</h1></body></html>");
        }
    }

    public void destroy() {
    }
}
