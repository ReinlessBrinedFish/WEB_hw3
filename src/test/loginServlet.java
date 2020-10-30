package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public loginServlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();

        if (name.trim().equals("admin") && password.trim().equals("123456")) {
            HttpSession session=request.getSession();
            session.setAttribute("name",name);
            session.setAttribute("password",password);
            // 置成功标志记录在session中
            session.setAttribute("login", 1);
            out.println("succeed");
//          request.getRequestDispatcher("/addServlet").forward(request, response);
        } else {
            out.println("fail");
//          request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
