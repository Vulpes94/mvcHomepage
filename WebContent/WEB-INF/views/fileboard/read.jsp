<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 읽기</title>
<script type="text/javascript">
	function replyFun(root,boardNumber,groupNumber,sequenceNumber,sequenceLevel) {
		var url = root + "/fileboard/write.do?boardNumber=" + boardNumber;
		url += "&groupNumber=" + groupNumber;
		url += "&sequenceNumber=" + sequenceNumber;
		url += "&sequenceLevel=" + sequenceLevel;
		// alert(url);
		
		location.href=url;
	}
	
	function delFun(root,boardNumber,pageNumber) {
		var url = root + "/fileboard/delete.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
		// alert(url);
		
		location.href=url;
	}
	
	function upFun(root,boardNumber,pageNumber) {
		var url = root + "/fileboard/update.do?boardNumber=" + boardNumber + "&pageNumber=" + pageNumber;
		// alert(url);
		
		location.href=url;
	} 
</script>
</head>
<body>
	<c:set var="root" value="${pageContext.request.contextPath}" />
	
	<div align="center">
	  <table border="1">
		<tr>
			<td align="center" height="30" width="200">글번호</td>
			<td align="center" height="30" width="200">${boardDto.boardNumber}</td>
			
			<td align="center" height="30" width="200">조회수</td>
			<td align="center" height="30" width="200">${boardDto.readCount}</td>
		</tr>
		
		<tr>
			<td align="center" height="30" width="200">작성자</td>
			<td align="center" height="30" width="200">${boardDto.writer}</td>
			
			<td align="center" height="30" width="200">작성일</td>
			<td align="center" height="30" width="200">
				<fmt:formatDate value="${boardDto.writeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
		</tr>
		
		<tr>
			<td align="center" height="500" width="200">글내용</td>
			<td valign="top" height="500" colspan="3" style="white-space: pre;">${boardDto.content}</td>
		</tr>
			
			<c:if test="${boardDto.fileName != null}">
				<tr>
					<td align="center" height="30" width="200">파일명</td>
					<td colspan="3">
						<a href="${root}/fileboard/downLoad.do?boardNumber=${boardDto.boardNumber}">
							${boardDto.fileName}
						</a>	
					</td>
				</tr>
			</c:if>
			
		<tr>
			<td height="30" colspan="4" align="center">
				<input type="button" value="글수정" onclick="upFun('${root}','${boardDto.boardNumber}','${pageNumber}')"/>
				
				<input type="button" value="글삭제" onclick="delFun('${root}','${boardDto.boardNumber}','${pageNumber}')"/>
				
				<input type="button" value="답글" 
				onclick="replyFun('${root}','${boardDto.boardNumber}','${boardDto.groupNumber}','${boardDto.sequenceNumber}','${boardDto.sequenceLevel}')"/>
				
				<input type="button" value="글목록" onclick="location.href='${root}/fileboard/list.do?pageNumber=${pageNumber}'"/>
			</td>
		</tr>
	  </table>
	</div>
</body>
</html>