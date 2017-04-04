<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: gl
  Date: 2017/4/3
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--使用form标签 可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显--%>
 <form:form action="emp" method="POST" modelAttribute="employee">
     LastName:<form:input path="lastName"/>
     <%--path属性对应html表单标签的name 属性值--%>
     <br>
     Email:<form:input path="email"/>
     <br>
     <%
         Map<String,String>genders=new HashMap();
         genders.put("1","Male");
         genders.put("0","Female");

         request.setAttribute("genders",genders);
     %>
     Gender:<form:radiobuttons path="gender" items="${genders}" delimiter="<br>"/>
     <br>
     Department:<%--@elvariable id="departments" type="java.util.List"--%>
     <form:select path="department.id" items="${departments }"
                            itemLabel="department" itemValue="id">
     </form:select>
     <br>
     <input type="submit" value="提交"/>

 </form:form>
</body>
</html>
