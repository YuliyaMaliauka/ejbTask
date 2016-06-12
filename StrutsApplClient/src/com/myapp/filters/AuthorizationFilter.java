/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author user
 */
public class AuthorizationFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        
        HttpSession session = req.getSession(false);

        if ((session == null) || (session.getAttribute("user") == null)) {
            String title = "Error page";
            PrintWriter out = res.getWriter();
            res.setContentType("text/html; charset=UTF-8");
            out.println("<HTML><HEAD><TITLE>"
                    + title + "</TITLE>"
                    + "</HEAD><BODY><H2>This page is EROR<H2>"
                    );
            out.close();

        } else {

            chain.doFilter(request, response);
        }

    }

    public void destroy() {
        //close any resources here
    }

}
