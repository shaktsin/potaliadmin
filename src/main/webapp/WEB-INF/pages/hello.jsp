<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="com.potaliadmin.constants.model.ModelKeyConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<jsp:include page="common/header.jsp">
  <jsp:param name="title" value="storetry"/>
</jsp:include>

<div class="container">
  <div class="row">
    <div class="col-sm-6 col-md-4 col-md-offset-4">
      <div class="account-wall">
        <div id="my-tab-content" class="tab-content">
          <div class="tab-pane active" id="login">
            <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                 alt="">
            <form:form class="form-signin" action="/login" method="POST">
              <input type="text" name="login" class="form-control" placeholder="Login" required autofocus>
              <input type="password" name="password" class="form-control" placeholder="Password" required>
              <input type="submit" class="btn btn-lg btn-default btn-block" value="Sign In" />
            </form:form>
            <div id="tabs" data-tabs="tabs">
              <p class="text-center"><a href="#register" data-toggle="tab">Need an Account?</a></p>
            </div>
          </div>
          <div class="tab-pane" id="register">
            <form:form class="form-signin" action="/signUp" method="post">
              <input type="text" name="login" class="form-control" placeholder="Login ..." required autofocus>
              <input type="text" name="name" class="form-control" placeholder="Name ..." required>
              <input type="email" name="email" class="form-control" placeholder="Email Address ..." required>
              <input type="password" name="password" class="form-control" placeholder="Password ..." required>
              <input type="submit" class="btn btn-lg btn-default btn-block" value="Sign Up" />
            </form:form>
            <div id="tabs" data-tabs="tabs">
              <p class="text-center"><a href="#login" data-toggle="tab">Have an Account?</a></p>
            </div>
          </div>

        </div>
      </div>
    </div>
  </div>
  </div>

  </div>

</div>

<jsp:include page="common/footer.jsp"/>
</body>
</html>
