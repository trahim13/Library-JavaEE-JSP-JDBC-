/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.trahim.web.listeners;

import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        HashMap sessionMap = (HashMap) context.getAttribute("sessionMap");
        sessionMap.put(session.getId(), session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        ServletContext context = session.getServletContext();
        HashMap sessionMap = (HashMap) context.getAttribute("sessionMap");
        sessionMap.remove(session.getId());
    }
    
}
