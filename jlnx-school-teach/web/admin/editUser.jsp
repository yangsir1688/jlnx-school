<%--
  Created by IntelliJ IDEA.
  User: Mryang
  Date: 2019/6/16
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/admin/resource/css/style.css"/>
</head>
<body>
<div class="formbody">
    <div class="formtitle"><span>用户信息</span></div>
    <form action="${pageContext.request.contextPath}/userServlet?op=updateUser&id=${user.id}" method="post">

        <ul class="forminfo">
            <li>
                <label>姓名</label>
                <input class="dfinput" type="text" name="name" id="entityname"
                       class="dfinput" data-rule-required="true" value="${user.name}"/>
            </li>
            <li>
                <label>用户名</label>
                <input class="dfinput" type="text" name="username" id="entityusername"
                       class="dfinput" data-rule-required="true" value="${user.username}" />
            </li>
            <li>
                <label>密码</label><input class="dfinput" type="password" name="password" id="entitypassword"
                class="scinput" data-rule-required="true" value="${user.password}"/>
            </li>
            <li>
                <label>性别</label>
                <cite>
                    男：<input type="radio" name="sex" value="1"
                          <c:if test="${user.password == '男'}">checked="checked"</c:if> />
                    女：<input type="radio" name="sex" value="2"
                         <c:if test="${user.password == '女'}">checked="checked"</c:if>/>
                </cite>
            </li>
            <li>
                <label>邮件地址</label>
                <input class="dfinput" type="text" name="email" id="entityemail" value="${user.email}" class="scinput" data-rule-required="true"  data-rule-email="true"/>
            </li>

            <li>
                <label>是否禁用</label>
                <cite>
                    否：<input type="radio" name="isable" value="1"
                             <c:if test="${user.isable == '1' || empty user.isable}">checked="checked"</c:if> />
                    是：<input type="radio" name="isable" value="0"
                             <c:if test="${user.isable == '0'}">checked="checked"</c:if>/>
                </cite>
            </li>
            <li>
                <label>出生日期</label>
                <input class="dfinput" type="date" name="birthday" value="${user.birthday}" id="birthday" class="scinput" data-rule-required="true"  data-rule-email="true"/>
            </li>
            <%--<li>--%>
                <%--<label>创建时间</label>--%>
                <%--<input class="dfinput" type="date" name="createTime" id="createTime" class="scinput" data-rule-required="true"  data-rule-email="true"/>--%>
            <%--</li>--%>
            <%--<li><label>年龄</label><input class="dfinput" type="text" name="age" id="entityage" value="${entity.age}"--%>
            <%--class="scinput" data-rule-required="true" data-rule-digits="true"--%>
            <%--data-rule-max="130" data-rule-min="18" data-msg-max="年龄必须在18岁到130岁之间!"--%>
            <%--data-msg-min="年龄必须在18岁到130岁之间!"/></li>--%>






            <%--<li><label>用户角色</label><cite>管理员：<input type="radio" name="type" value="1"--%>
            <%--<c:if test="${entity.type == '1' || empty entity.type}">checked="checked"</c:if> />--%>
            <%--小区物业：<input type="radio" name="type" value="2"--%>
            <%--<c:if test="${entity.type == '2'}">checked="checked"</c:if>/>--%>
            <%--小区业主：<input type="radio" name="type" value="3"--%>
            <%--<c:if test="${entity.type == '3'}">checked="checked"</c:if>/></cite>--%>
            <%--</li>--%>
            <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>

        </ul>

    </form>
</div>
</body>
</html>
