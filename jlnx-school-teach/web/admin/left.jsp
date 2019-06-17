<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/6/14
Time: 7:57
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/admin/resource/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/admin/resource/js/nav.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/resource/css/style.css"/>
</head>
<body>
<div class="left">
    <ul>
        <li>
            <span>管理信息</span>
            <ul class="wrap">
                <li>修改密码</li>
                <li>个人信息</li>
            </ul>
        </li>
        <li>
            <span>用户管理</span>
            <ul class="wrap">
                <li>
                    <a href="${pageContext.request.contextPath}/admin/addUser.jsp" target="rightFrame" >添加用户</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/userServlet?op=findAllUsers" target="rightFrame">查询用户</a>
                </li>
            </ul>
        </li>
        <li>
            <span>类别管理</span>
            <ul class="wrap">
                <li>添加类别</li>
                <li>查询类别</li>
            </ul>
        </li>
        <li>
            <span>内容管理</span>
            <ul class="wrap">
                <li>添加文章</li>
                <li>查询文章</li>
            </ul>
        </li>
    </ul>
</div>
</body>
</html>