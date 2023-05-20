<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2023/3/28
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增课程</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/addCourse" enctype="multipart/form-data" method="post">
        课程封面：<input type="file" name="imgFile"><br><br><br>
        课程名称：<input type="text" name="name"><br><br><br>
        课程学时：<input type="text" name="hours"><br><br><br>
        开设学院：<select name="school.name">
                    <option>计算机学院</option>
                    <option>外国语学院</option>
                </select><br><br><br>
        <input type="submit" value="添加">
    </form>

</div>

</body>
</html>
