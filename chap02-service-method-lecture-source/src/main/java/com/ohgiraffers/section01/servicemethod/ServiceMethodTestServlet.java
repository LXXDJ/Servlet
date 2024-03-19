package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {
    /* 나중에 HTTP를 대체할 프로토콜이 존재한다면 HttpServletRequest는 다른 클래스로 대체되어야 한다.
     *  따라서 ServletRequest라는 추상화된 타입으로 사용하고 실제 인스턴스는 HttpServletRequest로 사용하여
     *  나중에 service method의 인자 타입은 변경하지 않고 다른 프로토콜을 사용하는 Request로 변경 가능(다형성) */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* 현재 사용되는 프로토콜은 HTTP 프로토콜로, HttpServletRequest 타입
        *  HttpServletRequest는 ServletRequest를 상속받아 구현하였으며, HTTP 프로토콜의 정보를 담고 있으므로
        *  실제 사용 시에는 다운 캐스팅해서 사용해야 한다. */
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;

        /* 요청받은 http 메소드가 어떤 메소드인지 판단 */
        String httpMethod = httpRequest.getMethod();
        /* 요청 내용 출력 */
        System.out.println("httpMethod : " + httpMethod);

        if("GET".equals(httpMethod)){
            /* GET 요청을 처리할 메소드. 요청,응답 정보 전달 */
            doGet(httpRequest, httpResponse);
        }else{
            /* POST 요청을 처리할 메소드. 요청,응답 정보 전달 */
            doPost(httpRequest, httpResponse);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메소드 호출");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메소드 호출");
    }
}