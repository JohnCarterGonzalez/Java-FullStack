<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a New Dojo!</title>
</head>
<body>
	<div class="container">
		<h2>New Dojo</h2>
		<form:form action="/dojos" method="post" modelAttribute="dojo">
			<p>
				<form:label path="name">Title</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
</body>
</html>