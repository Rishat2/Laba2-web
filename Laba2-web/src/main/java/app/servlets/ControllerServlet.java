package app.servlets;

import app.model.Model;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import java.io.IOException;
import java.util.Objects;
@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("views/form.jsp");
        requestDispatcher.forward(req, resp);
        //resp.sendRedirect("views/form.jsp");
        //PrintWriter out = resp.getWriter();
        //out.println("<html>");
        //out.println("hello");
        //out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (Objects.equals(req.getParameter("type"), "clear")){
            //req.getServletContext().setAttribute("List", null);
            Model.getInstance().getList().clear();
            getServletContext().setAttribute("List", null);
            doGet(req, resp);
        }
        if(req.getParameter("x")==null || req.getParameter("y")==null || req.getParameter("r")==null) {
            doGet(req, resp);
        }

        //resp.sendRedirect("https://www.google.com");
        //resp.getWriter().println("1");
        //Model model=Model.getInstance();
        //req.setAttribute("List",model.getList());
        RequestDispatcher requestDispatcher=req.getRequestDispatcher("/areaCheck");
        requestDispatcher.forward(req, resp);
        //resp.sendRedirect("/areaCheck");
    }
}


