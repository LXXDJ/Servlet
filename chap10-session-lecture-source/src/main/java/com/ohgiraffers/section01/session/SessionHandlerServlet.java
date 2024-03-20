package com.ohgiraffers.section01.session;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        /* HttpSession은 직접 생성할 수 없고, request에 있는 getSession 메소드를 이용해 리턴받음 */
        HttpSession session = request.getSession();

        System.out.println("session id : " + session.getId());
        System.out.println("session default 유지시간 : " + session.getMaxInactiveInterval());   // 1800 : 30분
        
        session.setMaxInactiveInterval(60 * 10);    // 10분으로 변경

        System.out.println("session 변경후 유지시간 : " + session.getMaxInactiveInterval());   // 600

        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        response.sendRedirect("redirect");
    }
}
