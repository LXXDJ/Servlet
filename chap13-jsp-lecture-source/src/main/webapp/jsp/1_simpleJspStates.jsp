<%@ page import="java.util.PrimitiveIterator" %><%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-21
  Time: 오후 12:02
  To change this template use File | Settings | File Templates.
--%>
<!-- 지시자 태그 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- HTML 주석 : 콘솔창에서 확인가능 -->
    <%-- JSP 주석 : 콘솔창에서 확인불가 --%>

    <!-- 선언태그 -->
    <%!
        private String name;
        private int age;
    %>

    <!-- scriptlet 태그 -->
    <%
        // 자바주석과 동일
        // 간단한 자바 코드를 작성할 수 있는 부분
        name = "판다";
        age = 20;

        System.out.println("name : " + name);
        System.out.println("age : " + age);

        for(int i=0; i<name.length(); i++){
            System.out.println(name.charAt(i));
        }
    %>
    <!-- expression 태그 -->
    <!-- PrintWriter를 이용하여 브라우저에 값을 내보내 브라우저에서 보여지게 한다. -->
    name : <%= name %><br/>
    age : <%= age %>
</head>
<body>

</body>
</html>
