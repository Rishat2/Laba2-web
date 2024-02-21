package app.servlets;

import app.entities.Point;
import app.model.Model;

import app.model.Model;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/areaCheck")
public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out=resp.getWriter();
        Double x;
        Double y;
        int r;
        try {
            x = Double.parseDouble(req.getParameter("x"));
            y = Double.parseDouble(req.getParameter("y"));
            r = Integer.parseInt(req.getParameter("r"));
        }catch (Exception e){
            out.println("1");
            return;
        }
        if(x<-5 || x>3 || y<-5 || y>3 || r<1 || r>5){
            out.println("1");
            return;
        }
            x = (double) Math.round(x * 100) / 100;
            y = (double) Math.round(y * 100) / 100;
        Boolean t = false;

        if (x<=0) {
            if (y<=0) {
                if (x>=-r && y>=-r) {
                    t=true;
                }
            }
            else {
                if (Math.pow(r, 2)>=Math.pow(x, 2)+Math.pow(y, 2)) {
                    t=true;
                }
            }
        }
        else {
            if (x>=0 && y<=-x+Double.valueOf(r)/2 && y>=0){
                t=true;
            }
        }
        Point point=new Point(x, y, r, t);
        Model model=Model.getInstance();
        if (model.getList().size()==10) {
            model.getList().clear();
        }
        model.add(point);
        ServletContext context=getServletContext();
        context.setAttribute("List", model.getList());
        //out.println("<html>");
        out.println("<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"90%\">");
        out.println("<tr>\n" +
                "<td  width=\"50%\"></td>\n" +
                "<td>Attempt</td>\n" +
                "</tr>");
        out.println("<tr id=\"attempts\">\n" +
                "<td width=\"50%\">\n" +
                "X\n" +
                "<br>\n" +
                "Y\n" +
                "<br>\n" +
                "R\n" +
                "<br>\n" +
                "True\n" +
                "</td>\n" +
                "<td width=\"50%\">\n" +
                point.getX()+"\n" +
                "<br>\n" +
                point.getY()+"\n" +
                "<br>\n" +
                point.getR()+"\n" +
                "<br>\n" +
                point.getT()+"\n" +
                "</td>\n" +
                "</tr>");
        out.println("</table>");
        out.println("<div class='buttonClear'>\n" +
                "            <button class='button' onclick=\"location.href='/'\">Back to form</button>\n" +
                "        </div>");
        //out.println("<html>");
    }

    /*private String putAttempts(PrintWriter out, List<Point> list) {
        String answer="";
        for(int i=0;i<list.size();i++) {

            answer+="<tr id=\"attempts\">\n" +
                    "<td width=\"10%\">\n" +
                    list.get(i).getX()+"\n" +
                    "<br>\n" +
                    list.get(i).getY()+"\n" +
                    "<br>\n" +
                    list.get(i).getR()+"\n" +
                    "<br>\n" +
                    list.get(i).getT()+"\n" +
                    "</td>\n";
        }
        return answer;
    }*/


    /*@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doPost(req, resp);
    }*/
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //resp.sendRedirect(this.getServletContext().getContextPath());
        //doPost(req, resp);
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<areaCheck>");
        out.println("</html>");
        /*PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("get in check area");
        out.println("</html>");
        doPost(req, resp);*/
    }
}
