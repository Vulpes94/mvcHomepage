<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>방명록 쓰기</title>
<link rel="stylesheet"href="${root}/css/guest/guestStyle.css">
<script type="text/javascript" src="${root}/javascipt/guest/write.js"></script>
</head>
<body>
<a style="color: blue;" href="${root}/index.jsp">시작페이지</a> <br /><br />
	<div align="center">
		<form class="form_style"
			action="${root}/guest/writeOk.do"
			method="post">
			<div class="title">
				<label>이름</label>
				<input type="text"name="name"size="10" style="margin-right: 10px"/>
				
				<label>비밀번호</label>
				<input type="password"name="password" />
			</div>
			
			<div class="content">
				<textarea rows="5" cols="55"name="message"></textarea>
			</div>
			
			<div class="title" style="text-align: right;">
				<input type="submit"value="확인"/>
				<input type="reset"value="취소"/>
			</div>
		</form>
		
		<c:if test="${guestList.size() > 0}">
		<c:forEach var="guestDto" items="${guestList}">
			<div class="form_style" style="height: 130px">
				<div class="disp" style="border-width: 1px">
					${guestDto.name}
					<fmt:formatDate value="${guestDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					
					
					<a href="javascript:updateCheck('${guestDto.num}','${root}')">수정</a>
					<a href="javascript:deleteCheck('${guestDto.num}','${root}')">삭제</a>
				</div>
				
				<div class="disp-content">${guestDto.message}</div>
			</div>
		</c:forEach>
	</c:if>
	</div>
</body>
</html>










