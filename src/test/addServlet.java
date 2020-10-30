package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addServlet", urlPatterns = {"/addServlet/*"})
public class addServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public addServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<a  href='logoutServlet'>注销</a>");

        String url = request.getRequestURI();
        String[] list = url.split("/");
        out.println(url);
        if (list.length != 4){
            out.println("error");
        } else {
            //正则匹配所有整型数字
            String regex = "^a=(-?[0-9]+)&b=(-?[0-9]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher m = pattern.matcher(list[3]);

            out.println(list[3]);

            boolean flag = false;
            while (m.find()) {
                flag = true;
                Integer a = Integer.parseInt(m.group(1));
                Integer b = Integer.parseInt(m.group(2));
                request.getSession().setAttribute("a", a);
                request.getSession().setAttribute("b", b);
            }
            if (flag) {
                request.getRequestDispatcher("/doneServlet").forward(request, response);
            } else {
                out.println("no enough paras");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
