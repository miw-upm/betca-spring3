package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Parametros")
public class Parametros extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre, edad;
        String[] idiomas;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Parámetros</title> </head>");
        out.println("<p>Parámetros, añadir a la URL: ?nombre=uno&edad=2&idiomas=es&idiomas=en");

        nombre = request.getParameter("nombre");
        out.println("<h1>Nombre: " + nombre + "</h1>");
        edad = request.getParameter("edad");
        out.println("<h1>Edad: " + edad + "</h1>");

        idiomas = request.getParameterValues("idiomas");
        if (idiomas != null) {
            out.println("<h1>Idiomas: ");
            for (String item : idiomas) {
                out.println(item + " ");
            }
            out.println("</h1>");
        }
        out.println("</body></html>");
    }
}
