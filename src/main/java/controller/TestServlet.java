package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset = utf-8");
        resp.setCharacterEncoding("UTF-8");

        String str = "Hello on CentOs from Jenkins(second commit)";

        req.setAttribute("hello", str);
        getServletContext().getRequestDispatcher("/jsp/hello.jsp").forward(req, resp);
    }
}
