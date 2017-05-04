
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<link href=webjars/bootstrap/3.3.7-1/css/bootstrap.min.css type="text/css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/resources/styles.css" type="text/css" rel="stylesheet"/>

	<title>Sign In</title>

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
	<div class="col-md-8 col-md-offset-2">
		<form class="form-signin" method="post" action="#">
			<h2 class="form-signin-heading">Add new discovery</h2>
			<input name="inputName" type="text" class="form-control" placeholder="Title"
			       required autofocus />
			<input name="inputUrl" type="url" class="form-control" placeholder="URL"
			       required autofocus />
			<textarea name="inputDescription" rows="5" class="form-control" placeholder="Description"
			          required autofocus></textarea>
			<input class="btn btn-lg btn-primary btn-block" type="submit"
			       value="Add" />
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