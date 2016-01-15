package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contexto
 */
@WebServlet("/ContextoGet")
public class ContextoGet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Parámetros</title> </head><body>");
        out.println("<p> Contexto Web: " + this.getServletContext().getAttribute("Web") + "</p>");
        out.println("<p> Contexto sesion: " + request.getSession().getAttribute("Sesion") + "</p>");
        out.println("<p> Contexto peticion: " + request.getAttribute("Peticion") + "</p>");
        out.println("</body></html>");
    }

}
