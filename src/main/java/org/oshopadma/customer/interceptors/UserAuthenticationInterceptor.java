package org.oshopadma.customer.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.oshopadma.customer.dao.UserDao;
import org.oshopadma.customer.domainparams.UserParamNames;
import org.oshopadma.customer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;

public class UserAuthenticationInterceptor extends CustomerHandler {
	
	@Autowired
	private UserDao userDao;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(UserParamNames.USER);
		if(handler instanceof HandlerMethod) {	
		HandlerMethod handlerMethod = (HandlerMethod)handler;		
		if(null == user) {
			if(handlerMethod.getMethodAnnotation(RequestMapping.class).value()[0].equals("/login")) {
				
			}else {
				
			}
		}		
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
