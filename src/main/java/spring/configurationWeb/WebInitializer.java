package spring.configurationWeb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

    // Se configura el dispatcher
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Se crea un contexto basado en anotaciones
        AnnotationConfigWebApplicationContext annConWebAppCtx = new AnnotationConfigWebApplicationContext();

        // Se configura el paquete de los ficheros de configuración
        annConWebAppCtx.setConfigLocation("spring.configurationWeb");

        // Se configura el contexto utilizado en Securiry
        annConWebAppCtx.setServletContext(servletContext);

        // Se configura el servlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(annConWebAppCtx));

        // 1 es True
        servlet.setLoadOnStartup(1);

        // Se configura la ruta relativa del servlet
        servlet.addMapping("/api/v0/*");
    }

}
