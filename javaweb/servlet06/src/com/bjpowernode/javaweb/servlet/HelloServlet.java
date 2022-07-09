package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    //通过无参构造方法创建对象
   /* public HelloServlet() {
    }*/
    //没有init方法，那么必然执行父类HttpServletde init方法。
    //Httpservlet类中没有init方法，会继续执行GenericServlet类中的init方法。

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<h1>hello servlet</h1>");
    }
}
