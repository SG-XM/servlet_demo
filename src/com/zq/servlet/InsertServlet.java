package com.zq.servlet;

import com.zq.JDBCUtil;
import com.zq.service.MainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            new JDBCUtil();
            String json = new MainService().insert(req.getParameter("eid"), req.getParameter("name"), req.getParameter("job"), req.getParameter("dno")).toString();
            System.out.println(json);
            resp.getWriter().write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}