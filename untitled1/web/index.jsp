<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/3/19
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style >
   a:hover {font-size: 150% }
   a:link.testAntPath {background-color: darkgray  }

</style>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="/springmvc/testSessionAttributes">Test Attributes</a>
  <br><br>

  <a href="/springmvc/testMap">Test Map</a>
  <br><br>

  <a href="/springmvc/testModelAndView">Test ModelAndView</a>
  <br><br>

  <a href="/springmvc/testServletAPI">Test ServletAPI</a>
  <br><br>

  <form action="springmvc/testPojo" method="post"  >
    username:<input type="text" name="username"/>
    <br><br>
    password:<input type="password " name="password"/>
    <br><br>
    email:<input type="text" name="email"/>
    <br><br>
    age:<input type="text" name="age"/>
    <br><br>
    city:<input type="text" name="address.city"/>
    <br><br>
    province:<input type="text" name="address.province"/>
    <br><br>
    <input type=submit value="确定"/>
  <br><br>
  </form>


  <a href="/springmvc/testCookieValue">Test CookieValue</a>
  <br><br>

  <a href="/springmvc/testRequestHeader">Test RequestHeader</a>
  <br><br>

  <a href="/springmvc/testRequestParam?username=atguigu&age=11">Test RequestParam</a>
  <br><br>

  <a href="/springmvc/testPathVariable/1 ">Test PathVariable</a>
  <br><br>


  <a class="testAntPath"  href="/springmvc/testAntPath/jason/abc">Test ParasAndHeaders</a>
  <br><br><br>

  <a href="springmvc/testParamsAndHeaders?username=atguigu&age=10">Test ParamsAndHeaders</a>
  <br><br><br>


  <form action="springmvc/testMethod" method="post">
       <input type=submit value="submit"/>
  </form>

  <a href="/springmvc/testMethod ">Test Method</a>
  <br><br><br>

  <a href="/springmvc/testRequestMapping ">Test RequestMapping</a>
  <br><br><br>

  <a href="helloworld">HelloWorld</a>

  </body>
</html>
