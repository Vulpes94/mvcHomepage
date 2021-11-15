<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />

	<div align="center">
		<form action="${root}/fileboard/deleteOk.do" method="post">
			<input type="hidden" name="boardNumber" value="${boardNumber}" />
			<input type="hidden" name="pageNumber" value="${pageNumber}" />

			<table border="1">
				<tr>
					<td align="center" bgcolor="D1DBDB" width="300">비밀번호를 입력해주세요.</td>
				</tr>

				<tr>
					<td align="center" bgcolor="D1DBDB">
						<input type="password" name="password" />
					</td>
				</tr>

				<tr>
					<td align="center">
						<input type="submit" value="글삭제" />
						<input type="button" value="글목록" onclick="location.href='${root}/fileboard/list.do?pageNumber=${pageNumber}'" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>






