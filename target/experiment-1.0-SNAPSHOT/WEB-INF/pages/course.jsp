<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <style>
        header {
            background-color:black;
            color:white;
            text-align:right;
            padding:5px;
        }
    </style>
</head>
<body>

<header>
    用户：${username},&nbsp&nbsp&nbsp<a href="${pageContext.request.contextPath}/loginPage">登出</a>
</header>

<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>课程列表-显示所有课程</small>
                </h1>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/toAddCourse">新增课程</a>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th hidden="hidden">课程编号</th>
                    <th>课程封面</th>
                    <th>课程名称</th>
                    <th>课程学时</th>
                    <th>开设学院</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="course" items="${courses}">
                    <tr>
                        <td hidden="hidden">${course.id}</td>
                        <td><img src="${pageContext.request.contextPath}/showPicture/${course.picture}" width="100" height="100"></td>
                        <td>${course.name}</td>
                        <td>${course.hours}</td>
                        <td>${course.school.name}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/toUpdateCourse?id=${course.id}">更改</a> |
                            <a href="${pageContext.request.contextPath}/deleteCourse?id=${course.id}" onclick='return confirm("确定删除？")'>删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>

            </table>
        </div>
    </div>

</div>