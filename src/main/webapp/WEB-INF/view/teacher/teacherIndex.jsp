<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/5/21
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="head">
    <title>首页</title>
</rapid:override>
<rapid:override name="content">
    <%
        String path = request.getContextPath();
        String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
        System.out.println(request.getSession().getAttribute("teaid"));
    %>
    <div style="width:600px; height:450px; margin:100px 350px; border:3px solid gray;">
        <h2 style="text-align: center; margin-top: 25px; margin-bottom: 25px;">
            选课系统（教师版）
        </h2>
        <h3 style="margin-left:50px; margin-bottom: 10px;">
            1.登陆后请及时修改初始密码（个人资料）
        </h3>
        <h3 style="margin-left:50px; margin-bottom: 10px;">
            2.在（我的课程信息）中进行课程开设、已开设课程的查看、管理
        </h3>
    </div>
</rapid:override>
<%@ include file="base.jsp"%>
