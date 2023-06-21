package com.example.webap;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SecondServlet", value = "/Second-servlet")
public class SecondServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter writer = response.getWriter();
        writer.println("This is to test the Second response");
        writer.flush();
    }

    public void destroy() {
    }
}