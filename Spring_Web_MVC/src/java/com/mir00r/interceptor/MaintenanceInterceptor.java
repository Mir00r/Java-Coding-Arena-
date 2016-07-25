/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.interceptor;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Abdur Razzak <abdur.razzaq06@ail.com>
 */
public class MaintenanceInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //return super.preHandle(request, response, handler); //To change body of generated methods, choose Tools | Templates.
        
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(hour);

        if (hour >= 15 && hour <= 25) {
            response.getWriter().write("This servers is under Maintenance. "
                    + "Please Try After some Time. Sorry for this Inconvenience");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //super.postHandle(request, response, handler, modelAndView); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Request URL :: " + request.getRequestURL().toString()
                + "Sent to Handler :: Current Time = " + System.currentTimeMillis());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //  super.afterCompletion(request, response, handler, ex); //To change body of generated methods, choose Tools | Templates.

        System.out.println("Request URL :: " + request.getRequestURL().toString()
                + "End Time = " + System.currentTimeMillis());
    }

}
