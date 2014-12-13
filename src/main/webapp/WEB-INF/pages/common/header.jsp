<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>${param.title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- Bootstrap -->
  <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/resources/css/potali/potali.css"/>" rel="stylesheet">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
  <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media
     queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page
     via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<nav id="myNavbar" class="navbar navbar-default navbar-fixed-top" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">${param.title}</a>
    </div>
    <c:choose>
      <c:when test="<%=SecurityUtils.getSubject().isAuthenticated()%>">
        <c:url var="logOutAction" value="/logout"/>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                  ${param.name} <span class="caret"></span>
              </a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="${logOutAction}">Log Out</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </c:when>
      <c:otherwise>
        <c:url var="sso" value="/sso"/>
        <form class="navbar-form navbar-right" action="${sso}" role="search">
          <button type="submit" class="btn btn-default">
            SignIn with Google
          </button>
        </form>
      </c:otherwise>
    </c:choose>
  </div>
</nav>
</body>
</html>
