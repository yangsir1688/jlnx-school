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
    <meta charset="utf-8" />
    <title></title>
    <script src="${pageContext.request.contextPath}/admin/resource/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>

</head>

<frameset rows="88,* 31" cols="*" frameborder="0" border="0" framespacing="0"  >
    <frame src="${pageContext.request.contextPath}/admin/top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />

    <frameset cols="187,*" frameborder="0" border="0" framespacing="0" >

        <frame src="${pageContext.request.contextPath}/admin/left.jsp" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="" name="rightFrame" id="rightFrame" title="rightFrame" />

    </frameset>
</frameset>

<div>
    <!--顶端的盒子-->

    <!--左侧的盒子-->

    <!--右侧的盒子-->
    <div></div>
</div>
</html>
