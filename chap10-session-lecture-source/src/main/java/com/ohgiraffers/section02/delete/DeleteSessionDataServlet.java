package com.ohgiraffers.section02.delete;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/delete")
public class DeleteSessionDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Enumeration<String> sessionNames = session.getAttributeNames();
        while(sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        /* [세션 데이터 지우는 방법]
        *  1. 설정한 만료 시간이 지나면 세션 만료
        *  2. removeAttribute()로 session의 Attribute를 지운다.
        *  3. invalidate()를 호출하면 세션의 모든 데이터가 제거된다. */
        System.out.println("==== 구분선 ====");
        session.removeAttribute("firstName");

        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }

        System.out.println("==== 구분선 ====");
        session.invalidate();

        // invalidate를 호출하면 세션 자체를 무효화 했기 때문에 이후 세션을 이용하는 것은 에러 발생
        // 즉, 세션 내 데이터를 지우는 것뿐 아니라 세션을 강제로 만료시킴
        sessionNames = session.getAttributeNames();
        while (sessionNames.hasMoreElements()){
            System.out.println(sessionNames.nextElement());
        }
    }
}
