
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: gl
  Date: 2017/4/3
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
        $(".delete").click(function () {
            var href=$(this).attr("href");
            $("form").attr("action",href).submit();
            return false;

        });
        $(function () {
//            alert("hello jQuery");
            $(".delete").click(function () {
                var href=$(this).attr("href");
                $("form").attr("action",href).submit();
                return false;
        })
    </script>
</head>
<body>

  <form action="" method="POST">
      <input type="hidden" name="_method" value="DELETE"/>
  </form>

  <c:if test="${empty requestScope.employees}">
      <%--没有任何员工消息--%>
  </c:if>
<c:if test="${!empty requestScope.employees}">
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th>ID</th>
            <th>LastName</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Department</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${requestScope.employees}" var="emp">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.lastName}</td>
                <td>${emp.email}</td>
                <td>${emp.gender==0?'female':'male'}</td>
                <%--<gender是否等于0，若是输出female，否则输出male--%>
                <td>${emp.department.departmentName}</td>
                <td><a href="">Edit</a></td>
                <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br><br>

<a href="emp">Add New Employee</a>
</body>
</html>
