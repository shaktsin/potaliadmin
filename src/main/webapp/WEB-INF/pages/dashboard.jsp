<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

</head>
<body>
<jsp:include page="common/header.jsp">
  <jsp:param name="title" value="Hippo"/>
  <jsp:param name="name" value="${response.name}"/>
</jsp:include>

<jsp:include page="common/footer.jsp"/>
</body>
</html>
