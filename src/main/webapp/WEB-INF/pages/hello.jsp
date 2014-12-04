<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Potali Admin</title>
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
      <a class="navbar-brand" href="#">Hippo</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <c:url var="loginAction" value="/login"/>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <form:form role="login" class="navbar-form navbar-right" action="${loginAction}">
        <div class="form-group">
          <input type="email" name="email" placeholder="Email" class="form-control">
        </div>
        <div class="form-group">
          <input type="password" name="password" placeholder="Password" class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Sign In</button>
      </form:form>
    </div>
  </div>
</nav>
<div class="container">
  <div class="row">
    <%--<div class="col-xs-12 col-sm-6 box">
      <c:url var="signAction" value="/signUp"/>
      <form:form class="form-horizontal form-potali" action="${signAction}" name="userSignUpRequest" autocomplete="false">
        <legend>Register</legend>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
          <input type="text" class="form-control" placeholder="Name" name="name">
        </div>
        <div class="input-group">
          <span class="input-group-addon">@</span>
          <input type="email" class="form-control" placeholder="Email" name="email" autocomplete="off">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
          <input type="password" class="form-control" placeholder="Password" name="password" autocomplete="off">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
          <input type="password" class="form-control" placeholder="Reconfirm Password" name="rePassword">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-earphone"></span></span>
          <input type="tel" class="form-control" placeholder="Phone" name="phone">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
          <input type="text" class="form-control" placeholder="Company" name="company">
        </div>
        <div class="input-group">
          <span class="input-group-addon"><span class="glyphicon glyphicon-th-large"></span></span>
          <input type="url" class="form-control" placeholder="Company's Url" name="url">
        </div>
        <hr>
        <button type="submit" class="btn btn-primary">Sign Up</button>
      </form:form>
    </div>--%>
    <div class="col-xs-12 col-sm-6">
      <h3>Hippo is under construction</h3>
    </div>
  </div>
  <hr>
  <div class="row">
    <div class="col-xs-12">
      <footer>
        <p>&copy; Copyright Potali.com</p>
      </footer>
    </div>
  </div>
</div>
</body>
</html>