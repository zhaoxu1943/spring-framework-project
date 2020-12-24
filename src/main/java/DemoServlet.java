import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaoxu
 * @className DemoServlet
 * @projectName spring-framework-project
 * @date 2020/12/24 10:12
 */
@WebServlet(urlPatterns = "/demo1")
//继承HttpServlet即成为Servlet
public class DemoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("wdnmd");
    }
}
