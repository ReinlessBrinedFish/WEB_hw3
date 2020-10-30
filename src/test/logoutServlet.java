package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import  java.io.PrintWriter;

@WebServlet(name = "logoutServlet", urlPatterns = {"/logoutServlet"})
public class logoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public logoutServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 清除当前session中的登录成功标志
        HttpSession session=request.getSession();
        PrintWriter out = response.getWriter();
        if (session.getAttribute("login") == null) {
            out.println("no login");
        } else {
            session.removeAttribute("login");
            session.invalidate();
            out.println("logout");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
