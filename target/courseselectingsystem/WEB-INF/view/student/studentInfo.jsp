<%--
  Created by IntelliJ IDEA.
  User: 21989
  Date: 2020/5/21
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<rapid:override name="head">
    <title>个人资料</title>
</rapid:override>
<rapid:override name="content">
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <table class="layui-table" style="margin:80px 400px; width:450px;">
        <colgroup>
            <col width="200">
            <col width="250">
        </colgroup>
        <tbody>
           <tr style="height: 40px">
               <td>学号</td>
               <td>${student.stuId}</td>
           </tr>
           <tr>
               <td>姓名</td>
               <td>${student.stuName}</td>
           </tr>
           <tr>
               <td>学院</td>
               <td>${student.insName}</td>
           </tr>
        </tbody>
    </table>
    <button class="layui-btn layui-btn-danger layui-btn-lg" onclick="change()" style="margin:0 550px;">
        修改密码
    </button>
    <script type="text/javascript">
        function change() {
            window.location.href="<%= basePath%>student/editStuPass";
        }
    </script>
</rapid:override>
<%@ include file="base.jsp" %>
