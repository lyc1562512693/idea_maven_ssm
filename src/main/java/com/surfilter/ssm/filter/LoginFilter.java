package com.surfilter.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.surfilter.ssm.constant.CommentConstant;

public class LoginFilter implements Filter{

	public void doFilter(){}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();
        //判断Session中是否有登录用户信息
        String toke = (String) session.getAttribute(CommentConstant.LONGIN_TOKE);
        if(!toke.isEmpty()){
            chain.doFilter(req, res);
        }else{
            //若没有则，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/user/toLogin");
        }
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
