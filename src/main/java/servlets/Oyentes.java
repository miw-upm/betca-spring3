package servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@WebListener
public class Oyentes implements HttpSessionListener, ServletContextListener,
        ServletRequestListener {
    private Logger log = LogManager.getLogger(Oyentes.class);

    public void requestDestroyed(ServletRequestEvent sre) {
       log.info("requestDestroyed");
    }

    public void contextInitialized(ServletContextEvent sre) {
        log.info("contextInitialized");
    }

    public void sessionCreated(HttpSessionEvent sre) {
        log.info("sessionCreated");
    }

    public void sessionDestroyed(HttpSessionEvent sre) {
        log.info("sessionDestroyed");
    }

    public void contextDestroyed(ServletContextEvent sre) {
        log.info("contextDestroyed");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        log.info("requestInitialized");
    }

}
