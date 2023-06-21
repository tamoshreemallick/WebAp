package com.example.webap;

import java.io.*;

import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/Login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        BufferedReader credentialReader= Files.newBufferedReader(Paths.get("C:\\Users\\tamos\\Downloads\\WebAp\\data\\credentials.csv"));
        String line;
        List<Credential> credentialList=new ArrayList<>();
        while((line= credentialReader.readLine())!=null){
            String[] credentialData=line.split(",");
            credentialList.add(new Credential(credentialData[0], credentialData[1]));
        }
        Optional<Credential> matchedCredential=credentialList.stream().filter(credential ->credential.getUsername().equals(username)).findAny();
        PrintWriter writer=response.getWriter();
        if(matchedCredential.isPresent()){
            if(matchedCredential.get().getPassword().equals(password)){
                writer.println("<html><body><h1>Welcome "+username+" ! </h1></body></html>");
            }
            else{
                writer.println(("<html><body><h1>Incorrect Password</h1></body></html>"));
            }
        }

    }



        /*if (username.equals("tamoshree"))
        {
            if (password.equals("Neelu@99")){
                writer.println("Welcome Tamoshree");

            }
            else{
                writer.println("The password is incorrect");
            }
            writer.println();
        }
        else
        {
            writer.println("The username is incorrect");
        }


    }*/

    public void destroy() {
    }
}