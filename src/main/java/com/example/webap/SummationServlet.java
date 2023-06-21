package com.example.webap;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "SummationServlet", value = "/Summation-servlet")
public class SummationServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
         //Extract user input
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        //Process data based on user input
        PrintWriter writer = response.getWriter();
        int sum=num1+num2;

        //Output


        //writer.println(+num1+num2);
        writer.println("<html><body><h1>The numbers you entered were "+num1+" and "+num2+" and their sum is "+sum+"</h1></body></html>");
        writer.flush();
    }

    public void destroy() {
    }
}
