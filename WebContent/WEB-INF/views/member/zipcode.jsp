<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호</title>
<script type="text/javascript" src="${root}/javascipt/member/registerScript.js"></script>
</head>
<body>
  <div align="center">
    <form action="${root}//member/zipcode.do" method="get">
	  <table>
		<tr>
		  <td>
			  <input type="text" name="dong" />
			  <input type="submit" value="검색" />
		    </td>
		 </tr>
		</table>
	  </form>
		
	  <table>
	    <c:choose>
		  <c:when test="${zipcodeList.size()==0}">
		    <tr>
			  <td>검색된 결과가 없습니다.</td>
			</tr>
		  </c:when>
		  
		  <c:when test="${zipcodeList.size()>0}">
			<tr>
			  <td>아래의 우편번호를 클릭하세요</td>
			</tr>
			<c:forEach var="zipcode" items="${zipcodeList}">
			  <tr>
			   <td>
				<a href="javascript:sendAddress('${zipcode.zipcode}','${zipcode.sido}','${zipcode.gugun}','${zipcode.dong}','${zipcode.ri}','${zipcode.bunji}')">								 
					${zipcode.zipcode} ${zipcode.sido} ${zipcode.gugun} ${zipcode.dong}
					${zipcode.ri} ${zipcode.bunji}
				</a>
				</td>
			  </tr>
			</c:forEach>
	    </c:when>
	  </c:choose>
    </table>
  </div>
</body>
</html>