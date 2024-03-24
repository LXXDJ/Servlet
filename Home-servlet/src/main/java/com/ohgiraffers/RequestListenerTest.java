package com.ohgiraffers;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.ServletRequestAttributeListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListenerTest implements ServletRequestListener, ServletRequestAttributeListener {
    public RequestListenerTest() {
        System.out.println("request listener 인스턴스 생성");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("request 추가");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("request 삭제");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("request 수정");
        System.out.println(srae.getName() + " : " + srae.getValue());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request 소멸");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request 생성");
    }
}
