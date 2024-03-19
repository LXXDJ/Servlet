package com.ohgiraffers.section03.status;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendError(404, "없는 페이지입니다. 경로를 확인해 주세요.");
        response.sendError(500, "서버 내부 오류입니다. 개발자 잘못입니다.");
    }
}
