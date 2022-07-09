package com.bjpowernode.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    //art+enter
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //连接数据库
        Connection conn = null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/bjpowernode";
            String user ="root";
            String password = "root";
            conn = DriverManager.getConnection(url,user,password);
            //获取预编译的数据操作对象
            String sql = "select no,name from t_student";
            ps =conn.prepareStatement(sql);
            //执行SQL
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()){
                String no = rs.getString("no");
                String name = rs.getString("name");
                out.print(no + "," +name + "<br>");
            }
        } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
        }finally {
            //释放资源rs.notnull
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
