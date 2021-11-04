<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
<script type="text/javascript" src="${root}/javascipt/member/registerScript.js"></script>
<link rel="stylesheet"  href="${root}/css/member/registerStyle.css">
</head>
<body>
	<a href="${root}/index.jsp">시작페이지</a> <br /><br />	
	<div id="register">
		<form name="memberForm" id="form_style" 
			action="${root}/member/updateOk.do" 
			method="post"
			onsubmit="return registerForm(this)"> 
			<!-- div2 -->
			<div class="line">  <!-- 1행 --> 
				<input type="hidden" name="num" value="${memberDto.num}"/>
				
				<label class="title">아이디</label>  <!-- 1행 1열 -->
				
				<span class="content"> <!--  1행2열-->
					* <input type="text" name="id" value="${memberDto.id}" disabled="disabled"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">비밀번호</label>
				<span class="content">
					* <input type="password" name="password" value="${memberDto.password}"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">비밀번호확인</label>
				<span class="content">
					* <input type="password" name="passwordCheck" value="${memberDto.password}"/>
				</span>
			</div>
	
			<div class="line">
				<label class="title">이름</label>
				<span class="content">
					* <input type="text" name="name" value="${memberDto.name}" disabled="disabled"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">주민번호</label>
				<span class="content">
					* <input type="text" name="jumin1" size="11" maxlength="6" value="${memberDto.jumin1}" disabled="disabled" />
					- <input type="text" name="jumin2" size="12" maxlength="7" value="${memberDto.jumin2}" disabled="disabled"/>
				</span>	
			</div>
			
			<div class="line">
				<label class="title">이메일</label>
				<span class="content">
					<input type="text" name="email" size="25" value="${memberDto.email}" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">우편번호</label>
				<span class="content">
					<input type="text" name="zipcode"  value="${memberDto.zipcode}"/>
					<input type="button" value="우편번호검색" 
							onclick="zipcodeRead('${root}')"/>
				</span>
		  	</div>
			
			<div class="line">
				<label class="title">주소</label>
				<span class="content">
					<input type="text" name="address" size="48"  value="${memberDto.address}" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">직업</label>
				<span class="content">
					<select name="job">
						<option></option>
						<option value="회사원">회사원</option>
						<option value="학생">학생</option>
						<option value="전문직">전문직</option>
						<option value="기타">기타</option>
					</select>
					${memberDto.job}
					<script type="text/javascript">
						memberForm.job.value="${memberDto.job}";
					</script>
				</span>
			</div>
			
			<div class="line">
				<label class="title">메일수신</label>
				<span class="content">
					<input type="radio" name="mailing" value="yes" />yes
					<input type="radio" name="mailing" value="no" />no
					${memberDto.mailing}
					<script type="text/javascript">
						for (var i = 0; i < memberForm.mailing.length; i++) {
							if (memberForm.mailing[i].value == "${memberDto.mailing}") {
								memberForm.mailing[i].checked=true;
							}
						}
					</script>
				</span>
			</div>
			
			<div class="line">
				<label class="title">관심분야</label>
				<span class="content">
					<input type="checkbox" name="interestValue" value="경제"/> 경제 &nbsp;
					<input type="checkbox" name="interestValue" value="IT"/> IT &nbsp;
					<input type="checkbox" name="interestValue" value="음악"/> 음악 &nbsp;
					<input type="checkbox" name="interestValue" value="미술"/> 미술 &nbsp;
					${memberDto.interest}
					<c:forTokens var="interest" items="${memberDto.interest}" delims=",">
						<script type="text/javascript">
							for (var i = 0; i < memberForm.interestValue.length; i++) {
								if (memberForm.interestValue[i].value=="${interest}") {
									memberForm.interestValue[i].checked=true;
								}
							}
						</script>
					</c:forTokens>
				</span>
				<input type="hidden" name="interest" />
			</div>
			
			<div class="line_btn">
				<input type="submit" value="수정"/>
				<input type="reset" value="취소"/>
			</div>
		</form>
	</div>
</body>
</html>
