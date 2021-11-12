<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />

	<a href="${root}/index.jsp">시작페이지</a>
	<br />
	<br />

	<div align="center">
		<h3>
			안녕하세요. ${id}(${memberLevel}) 님 <br /> 즐거운 시간 되세요.
		</h3>
	</div>
</body>
</html>