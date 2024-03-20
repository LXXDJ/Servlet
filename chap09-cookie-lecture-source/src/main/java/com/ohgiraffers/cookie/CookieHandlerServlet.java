package com.ohgiraffers.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // sendRedirect는 기본적으로 get 방식
//        response.sendRedirect("redirect");

        /* [쿠키 사용순서]
        *  1. 쿠키 생성
        *  2. 생성한 쿠키의 만료 시간 설정
        *  3. 응답 헤더에 쿠키를 담는다
        *  4. 응답 보내기
        *
        *  쿠키 제약 사항
        *  이름은 ascii 문자만 사용. 한번 설정한 이름 변경 불가.
        *  이름에 공백, 일부 특수문자 사용불가 ([] () = , " \ ? @ : ;) */

        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        firstNameCookie.setMaxAge(60 * 60 * 24);    // 초단위설정(하루 만료로 설정) : 60초 * 60분 * 24시간
        lastNameCookie.setMaxAge(60 * 60 * 24);

        response.addCookie(firstNameCookie);
        response.addCookie(lastNameCookie);

        response.sendRedirect("redirect");
    }
}
