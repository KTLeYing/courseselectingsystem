<html>
<body>
<h2>Hello World!</h2>
  <%
      request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
  %>
</body>
</html>
