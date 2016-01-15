package servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.logging.log4j.LogManager;

@WebFilter(urlPatterns = {"/HolaMundo", "/Parametros"})
public class Filtro implements Filter {
    public void init(FilterConfig fConfig) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        long antes = System.currentTimeMillis();

        chain.doFilter(request, response);

        LogManager.getLogger(Filtro.class).info(
                "Tiempo de proceso(" + (System.currentTimeMillis() - antes) + " ms)");
    }
}
