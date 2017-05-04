
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<link href=webjars/bootstrap/3.3.7-1/css/bootstrap.min.css type="text/css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/resources/styles.css" type="text/css" rel="stylesheet"/>

	<title>Register</title>

</head>
<body>

<%---------------------
		NAVBAR
---------------------%>

<jsp:include page="fragment/navbar.jspf" />

<%--------------------
		CONTENT
---------------------%>

<div class="container">
	<div class="col-sm-6 col-md-4 col-md-offset-4">
		<form class="form-signin" method="post" action="register">
			<h2 class="form-signin-heading">Register</h2>
			<input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus />
			<input name="inputUsername" type="text" class="form-control" placeholder="Username" required autofocus />
			<input name="inputPassword" type="password" class="form-control" placeholder="Password" required />
			<button class="btn btn-lg btn-primary btn-block" type="submit" >Register</button>
		</form>
	</div>
</div>

<%--------------------
		FOOTER
---------------------%>

<jsp:include page="fragment/footer.jspf" />


<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>


