/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trahim.web.listeners;

import java.util.HashMap;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;


public class ContextListener implements ServletContextListener {
    
    private HashMap sessionMap = new HashMap<String, HttpSession>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("sessionMap", sessionMap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("sessionMap");
        sessionMap = null;
    }
}
