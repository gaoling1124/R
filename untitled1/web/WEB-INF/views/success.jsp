<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/3/21
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        h1{text-align:center;color: cornflowerblue }
        p{text-align:center;color: blue }
    </style>
</head>
<body >
    <h1>张杰么么哒</h1>
    <p>张杰最帅</p>
    time:${requestScope.time}
    <br><br>
    names:${requestScope.names}
    <br><br>

    request user:${requestScope.user}
    <br><br>
    session user:${sessionScope.user}
    <br><br>

    request school:${requestScope.school}
    <br><br>
    session school:${sessionScope.school}
    <br><br>

    user user:${requestScope.user}
    <br><br>


</body>
</html>


