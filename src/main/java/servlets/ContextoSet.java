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
@WebServlet("/ContextoSet")
public class ContextoSet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().setAttribute("Web", "Se comparte entre servlets");
        request.getSession().setAttribute("Sesion", "ya visto");
        request.setAttribute("Peticion", "Al dar la respuesta al cliente se pierde");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Parámetros</title> </head><body>");
        out.println("<p>Contextos almacenados</p></body></html>");
    }

}
