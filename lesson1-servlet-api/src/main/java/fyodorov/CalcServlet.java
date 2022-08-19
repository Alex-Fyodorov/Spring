package fyodorov;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(urlPatterns = "/calc-servlet")
public class CalcServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int param1 = Integer.parseInt(request.getParameter("a"));
        int param2 = Integer.parseInt(request.getParameter("b"));

        int sum = param1 + param2;

        response.getWriter().println("<h1>" + String.format("%d + %d = %s", param1, param2, sum) + "</h1>");
    }
}
