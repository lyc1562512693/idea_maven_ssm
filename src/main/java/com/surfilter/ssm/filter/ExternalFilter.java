package com.surfilter.ssm.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExternalFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;
        MyRequestWrapper rw = new MyRequestWrapper(req);
        byte[] bytes = new byte[1024];
        InputStream in = rw.getInputStream();
        int l = 0;
        while((l = in.read(bytes))!= -1){
            System.out.println(new String(bytes,0, l));
        }
        chain.doFilter(rw,res);
    }

    @Override
    public void destroy() {

    }
}
