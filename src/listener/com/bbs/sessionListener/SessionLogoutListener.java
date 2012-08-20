package com.bbs.sessionListener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.bbs.bean.User;

/**
 * Application Lifecycle Listener implementation class SessionLogoutListener
 *
 */
public class SessionLogoutListener implements HttpSessionListener {

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Session¥¥Ω®£°");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("Session ß–ß£°");
		ServletContext application=event.getSession().getServletContext();
        List<User> userGroup=(List)application.getAttribute("userGroup");
    	User user=(User)event.getSession().getAttribute("currentUser");
    	if(user!=null && userGroup!=null){
    	  userGroup.remove(user);
    	}
	}
}
