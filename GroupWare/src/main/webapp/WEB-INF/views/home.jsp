<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" contentType="text/html; charset=UTF-8"
	language="java"%>



<div class="inner cover">
	<h1 class="cover-heading">아이디 : ${id } 패스워드 : ${password }</h1>
	<a href="<c:url value="j_spring_security_logout" />" > Logout</a>
	<p class="lead">Cover is a one-page template for building simple
		and beautiful home pages. Download, edit the text, and add your own
		fullscreen background photo to make it your own.</p>
	<p class="lead">
		<a href="#" class="btn btn-lg btn-default">Learn more</a>
	</p>
</div>


