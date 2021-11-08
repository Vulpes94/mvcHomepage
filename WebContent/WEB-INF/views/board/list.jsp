<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록보기</title>
<link rel="stylesheet" href="${root}/css/board/boardStyle.css" />
</head>
<body>
	<div align="center">
		<table>
		  <tr>
			<td width="645" height="20" bgcolor="#D1DBDB" align="right">
				<a href="${root}/board/write.do">글쓰기</a>
			</td>
		  </tr>
		</table>
		
		<c:if test="${count==0}">
		  <table>
			<tr>
				<td width="645" height="20" align="center">게시판에 저장된 글이 없습니다.</td>
			</tr>
		  </table>
		</c:if>
		
		<c:if test="${count > 0}">
		  <table border="1">
			<tr>
				<td width="30" height="20" align="center">번호</td>
				<td width="350" height="20" align="center">제목</td>
				<td width="70" height="20" align="center">작성자</td>
				<td width="110" height="20" align="center">작성일</td>
				<td width="50" height="20" align="center">조회수</td>
			</tr>
			
			<c:forEach var="boardDto" items="${boardList}">
			  <tr>
				<td width="30" height="20" align="center">${boardDto.boardNumber}</td>
				<td width="350" height="20" align="center">${boardDto.subject}</td>
				<td width="70" height="20" align="center">${boardDto.writer}</td>
				<td width="110" height="20" align="center">
					<fmt:formatDate value="${boardDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td width="50" height="20" align="center">${boardDto.readCount}</td>
			  </tr>
			</c:forEach>
		  </table>
		</c:if>
		<br /><br />
		
		<!-- 페이지 번호 -->
	</div>
</body>
</html>








