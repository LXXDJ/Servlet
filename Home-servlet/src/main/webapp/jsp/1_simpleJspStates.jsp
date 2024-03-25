<%--
  Created by IntelliJ IDEA.
  User: hi
  Date: 2024-03-25
  Time: 오전 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%!
        private String name;
        private int age;
    %>
    <%
        name = "판다";
        age = 20;

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        for(int i=0; i<name.length(); i++) System.out.println(name.charAt(i));
    %>

    name : <%=name%><br/>
    age: <%=age%>
</head>
<body>

</body>
</html>
