package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/helloServlet")// En 3.0 se utilizan anotaciones en lugar de XML
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Logger log = LogManager.getLogger(HelloServlet.class);


    @Override
    public void init() throws ServletException {
        log.info("Se instancia el servlet...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String web = "<html><head><title>Primer Servlet</title></head>"
                + "<body> <h1>Hola, soy el primer servlet.</h1>" + "</body></html>";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(web);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    public void destroy() {
        log.info("Se destruye el servlet...");
    }
}
