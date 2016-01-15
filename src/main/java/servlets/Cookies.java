package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Cookies
 */
@WebServlet("/Cookies")
public class Cookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = null, mensaje;
        // Si existe parámetro se añade la cookie
        if (request.getParameter("name") != null) {
            Cookie c = new Cookie("name", request.getParameter("name"));
            c.setMaxAge(10); // 10 segundos
            response.addCookie(c);
        }
        // Se busca la cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    nombre = cookie.getValue();
                }
            }
        }

        if (nombre == null) {
            mensaje = "<p>Para identificarse, añadir: ?name=nombre...en la URL</p>";
        } else {
            mensaje = "<h2>Bienvenido/a " + nombre + "</h2>";
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cookies</title></head><body>");
        out.println(mensaje);
        out.println("<p>Ejemplo de cookies...</p></body></html>");
    }

}
