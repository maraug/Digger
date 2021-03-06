<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

	<link href=webjars/bootstrap/3.3.7-1/css/bootstrap.min.css type="text/css" rel="stylesheet"/>
	<link href="${pageContext.request.contextPath}/resources/styles.css" type="text/css" rel="stylesheet"/>

	<title>Sign In</title>

</head>
<body>

<%---------------------
		NAVBAR
---------------------%>

<jsp:include page="fragment/navbar.jspf"/>

<%--------------------
		CONTENT
---------------------%>

<div class="container">
	<c:set var="admin" value="${pageContext.request.isUserInRole('ADMIN')}"/>
	<c:set var="votes" value="${discovery.upVote - discovery.downVote}"/>
	<div class="row bs-callout bs-callout-primary">
		<div class="col col-md-1 col-sm-2">
			<a href="vote?discovery_id=${discovery.id}&vote=UP_VOTE"
			   class="btn btn-block btn-primary btn-success"><span class="glyphicon glyphicon-arrow-up"></span></a>
			<div class="well well-sm centered text-center"><c:out value="${votes}"/></div>
			<a href="vote?discovery_id=${discovery.id}&vote=DOWN_VOTE"
			   class="btn btn-block btn-primary btn-warning"><span
					class="glyphicon glyphicon-arrow-down"></span></a>
		</div>
		<div class="col col-md-11 col-sm-10">
			<h3 class="centered"><a href="${discovery.url}"><c:out value="${discovery.name}"/></a></h3>
			<h6>
				<small>Added by: <c:out value="${discovery.user.username}"/>,
					on <fmt:formatDate value="${discovery.timestamp}" pattern="dd-MM-YYYY HH:mm:ss"/></small>
			</h6>
			<p><c:out value="${discovery.description}"/></p>
			<a href="${discovery.url}">
				<button class="btn btn-default btn-xs">Open page</button>
			</a>
		</div>
	</div>

	<c:if test="${not empty requestScope.comments}">
		<c:forEach var="comment" items="${requestScope.comments}">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<c:if test="${admin}">
									<a href="comment?comment_id=${comment.id}&action=delete"
									   class="btn btn-default btn-xs">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</a>
								</c:if>
									${comment.author.username} on <fmt:formatDate value="${comment.timestamp}"
									                                              pattern="dd-MM-YYYY HH:mm:ss"/>
							</h3>
						</div>
						<div class="panel-body">
								${comment.content}
						</div>

							<%--response div--%>
							<%--<div class="row">--%>
							<%--<div class="col-md-offset-1 col-md-11">--%>
							<%--<div class="panel panel-default">--%>
							<%--<div class="panel-heading">--%>
							<%--<h3 class="panel-title"> username / timestamp </h3>--%>
							<%--</div>--%>
							<%--<div class="panel-body">--%>
							<%--Comment content--%>
							<%--</div>--%>
							<%--</div>--%>
							<%--</div>--%>
							<%--</div>--%>

					</div>
				</div>
			</div>
		</c:forEach>
	</c:if>

	<div class="row">
		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-signin" method="post" action="comment">
						<input name="discoveryId" type="hidden" value="${discovery.id}">
						<textarea id="commentArea" name="comment" rows="5" class="form-control"
						          placeholder="Comment...."
						          required autofocus></textarea>
						<div class="text-center">
							<button type="button" class="btn btn-link" onclick="eraseText()">Clear</button>
							<button type="submit" class="btn btn-default">Add</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</div>

<%--------------------
		FOOTER
---------------------%>

<jsp:include page="fragment/footer.jspf"/>


<script>
    function eraseText() {
        document.getElementById("commentArea").value = "";
    }
</script>
<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</body>
</html>

