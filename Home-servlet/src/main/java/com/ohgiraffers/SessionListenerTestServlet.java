package com.ohgiraffers;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/session")
public class SessionListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("발급받은 session id : " + session.getId());

        session.setAttribute("username", "panda");
        session.setAttribute("age", 20);
        session.setAttribute("gender", "W");

        session.setAttribute("user", new UserDTO("panda", 20, "W"));
        session.setAttribute("username", "다람쥐");
        session.removeAttribute("gender");

        session.invalidate();
    }
}