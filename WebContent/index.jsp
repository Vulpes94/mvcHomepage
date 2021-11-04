<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC HomePage</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	<h3>회원관리</h3>
	
	<c:if test="${id==null}">
		<a href="${root}/member/register.do">회원가입</a>&nbsp;&nbsp;
		<a href="${root}/member/login.do">로그인</a>
	</c:if>
	
	<c:if test="${id !=null}">
		<a href="${root}/member/logout.do">로그아웃</a>
		<a href="${root}/member/update.do">회원수정</a>
		<a href="${root}/member/delete.do">회원탈퇴</a>
		
		<c:if test="${memberLevel=='MA'}">
		  <h3>관리자 메뉴</h3>
		  <a href="">회원목록</a>
		</c:if>
	</c:if>
	<br />
	
	<h3>방명록</h3>
	<a href="${root}/guest/write.do">방명록 작성</a>
<!-- 	
	
	<h3>게시판</h3>
	
	<h3>파일 게시판</h3> -->
</body>
</html>