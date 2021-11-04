<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
  <c:set var="root" value="${pageContext.request.contextPath}"/>
  
  <a href="${root}/index.jsp">시작페이지</a>
  <div>
    <form action="${root}/member/deleteOk.do" method="post">
    	<table>
    		<tr>
    			<td>회원 ID</td>
    			<td><input type="text" name="id" value="${id}" disabled="disabled"/></td>
    		</tr>
    		<tr>
    			<td>비밀번호</td>
    			<td><input type="password" name="password" /></td>
    		</tr>
    		
    		<tr>
    			<td colspan="2" align="center">
    				<input type="submit" value="회원탈퇴"/>
    				<input type="reset" value="취소"/>
    			</td>
    		</tr>
    	</table>
    </form>
  </div>
</body>
</html>