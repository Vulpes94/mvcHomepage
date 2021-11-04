<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script type="text/javascript" src="${root}/javascipt/member/registerScript.js"></script>
<link rel="stylesheet"  href="${root}/css/member/registerStyle.css">
</head>
<body>
	<a href="${root}/index.jsp">시작페이지</a>
	<div id="register">
		<div id="subject">  <!--  div1 -->
			<h4>회원가입(* 필수입력사항입니다.)</h4>
		</div>
	
		<form name="memberForm" id="form_style" 
			action="${root}/member/registerOk.do" 
			method="post"
			onsubmit="return registerForm(this)"> 
			<!-- div2 -->
			<div class="line">  <!-- 1행 -->
				<label class="title">아이디</label>  <!-- 1행 1열 -->
				
				<span class="content"> <!--  1행2열-->
					* <input type="text" name="id"/>
					<input type="button" value="아이디 중복" 
							onclick="idCheck(memberForm,'${root}')"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">비밀번호</label>
				<span class="content">
					* <input type="password" name="password" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">비밀번호확인</label>
				<span class="content">
					* <input type="password" name="passwordCheck"/>
				</span>
			</div>
	
			<div class="line">
				<label class="title">이름</label>
				<span class="content">
					* <input type="text" name="name"/>
				</span>
			</div>
			
			<div class="line">
				<label class="title">주민번호</label>
				<span class="content">
					* <input type="text" name="jumin1" size="11" maxlength="6" />
					- <input type="text" name="jumin2" size="12" maxlength="7" />
				</span>	
			</div>
			
			<div class="line">
				<label class="title">이메일</label>
				<span class="content">
					<input type="text" name="email" size="25" />
				</span>
			</div>
			
			<div class="line">
				<label class="title">우편번호</label>
				<span class="content">
					<input type="text" name="zipcode" />
					<input type="button" value="우편번호검색" 
							onclick="zipcodeRead('${root}')"/>
				</span>
		  	</div>
			
			<div class="line">
				<label class="title">주소</label>
				<span class="content">
					<input type="text" name="address" size="48" />
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
				</span>
			</div>
			
			<div class="line">
				<label class="title">메일수신</label>
				<span class="content">
					<input type="radio" name="mailing" value="yes" />yes
					<input type="radio" name="mailing" value="no" />no
				</span>
			</div>
			
			<div class="line">
				<label class="title">관심분야</label>
				<span class="content">
					<input type="checkbox" name="interestValue" value="경제"/> 경제 &nbsp;
					<input type="checkbox" name="interestValue" value="IT"/> IT &nbsp;
					<input type="checkbox" name="interestValue" value="음악"/> 음악 &nbsp;
					<input type="checkbox" name="interestValue" value="미술"/> 미술 &nbsp;
				</span>
				<input type="hidden" name="interest" />
			</div>
			
			<div class="line_btn">
				<input type="submit" value="가입"/>
				<input type="reset" value="취소"/>
			</div>
		</form>
	</div>
</body>
</html>
