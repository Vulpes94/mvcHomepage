<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<link rel="stylesheet" href="${root}/css/fileboard/boardStyle.css">
</head>
<body>
	<h4>boardNumber: ${boardNumber}, 
			groupNumber: ${groupNumber}, 
			sequenceNumber: ${sequenceNumber}, 
			sequenceLevel: ${sequenceLevel}</h4>

	<div align="center">
		<form class="form_style" 
					action="${root}/fileboard/writeOk.do" 
					method="post" 
					enctype="multipart/form-data">
			<input type="hidden" name="boardNumber" value="${boardNumber}" />
			<input type="hidden" name="groupNumber" value="${groupNumber}" />
			<input type="hidden" name="sequenceNumber" value="${sequenceNumber}" />
			<input type="hidden" name="sequenceLevel" value="${sequenceLevel}" />


			<div style="width: 598px; height: 15px; border-width: 2px; text-align: right; padding: 15px 0px 0px 0px; border-bottom-width: 0px;">
				<a href="${root}/fileboard/list.do">글목록</a>
			</div>

			<div class="line">
				<label class="title">작성자</label>
				<span class="content">
					<input type="text" name="writer" />
				</span>
			</div>

			<div class="line">
				<label class="title">제목</label>
				<span class="content">
					<input type="text" size="50" name="subject" />
				</span>
			</div>

			<div class="line">
				<label class="title">이메일</label>
				<span class="content">
					<input type="text" size="50" name="email" />
				</span>
			</div>

			<div class="line" style="height: 230px;">
				<label class="title" style="height: 230px;">내용</label>
				<span class="content" style="height: 230px;">
					<textarea rows="14" cols="58" name="content"></textarea>
				</span>
			</div>

			<div class="line">
				<label class="title">비밀번호</label>
				<span class="content">
					<input type="password" name="password" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">파일명</label>
				<span class="content">
					<input type="file" name="file" size="40" />
				</span>
			</div>

			<div class="line" style="width: 598px; border-width: 2px; text-align: center;">
				<input type="submit" value="글쓰기" />
				<input type="reset" value="다시작성" />
				<input type="button" value="목록보기" onclick="location.href='${root}/fileboard/list.do'" />
			</div>
		</form>
	</div>
</body>
</html>