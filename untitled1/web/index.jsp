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
