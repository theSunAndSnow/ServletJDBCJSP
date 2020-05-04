package com.theSunAndSnow.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebFilter("/student")
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {

            servletRequest.setCharacterEncoding("UTF-8");
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
