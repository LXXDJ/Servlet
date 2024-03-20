package com.ohgiraffers.forward;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccessServlet extends HttpServlet {
    /* forward 받은 서블릿에서도 요청 방식이 get이면 doGet 메소드를, post이면 doPost 메소드 호출
    *  보내준 서블릿에서 request에 전달 정보를 담앗으므로 해당 서블릿에서 사용하기 위해 다시 request에서 꺼내옴 */

    /* forward 사용 시 전달한 request와 response의 모든 정보를 이용해 새로운 request와 response를 만들고
    *  그 정보를 이용해 다시 http 메소드에 맞는 서블릿의 doGet 혹은 doPost를 요청하는 방식
    *  깊은 복사를 이용해 값을 그대로 복사했기 때문에 내부에 존재하는 헤더정보나 인스턴스는 그대로 유지 */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = (String) request.getAttribute("userId");

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3 align=\"center\">")
                .append(userId)
                .append("님 환영합니다.</h3>")
                .append("</body>\n")
                .append("</html>");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.print(responseText);
        out.flush();
        out.close();
    }
}
