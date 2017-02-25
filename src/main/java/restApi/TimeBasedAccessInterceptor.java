package restApi;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        System.out.println(">>> interceptor...");
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (8 <= hour && hour < 21) {
            return true;
        }
        response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        return false;
    }
}
