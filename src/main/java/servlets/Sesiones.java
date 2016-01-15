package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Sesiones")
public class Sesiones extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Sesiones</title></head><body>");

        HttpSession session = request.getSession(true);
        if (session.isNew()) {
            out.println("<h1>Gracias por acceder al servidor</h1>");
            session.setAttribute("accesos", 1);
        } else {
            out.println("<h1>Gracias por volver</h1>");
            out.println("<p>Identificador de sesion: " + session.getId());
            out.println("<p>Fecha de creación: " + new Date(session.getCreationTime()));
            out.println("<p>Fecha del último acceso: " + new Date(session.getLastAccessedTime()));
            num = (Integer) session.getAttribute("accesos");
            out.println("<p>Accesos realizados: " + num);
            session.setAttribute("accesos", num + 1);
        }
        out.println("</body></html>");
    }

}
