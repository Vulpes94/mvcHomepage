/**
 * 
 */

//유효성 검사
function registerForm(obj) {
	if (obj.password.value != obj.passwordCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		obj.password.focus();
		return false;
	}
	
	var check = false;
	var str = "";
	for (var i = 0; i < obj.interestValue.length; i++) {
		if (obj.interestValue[i].checked==true) {
			str +=obj.interestValue[i].value +",";
			check = true;
		}
	}
	
	if (check==false) {
		alert("하나라도 체크하세요");
		return false;
	}
	//alert(str);
	
	obj.interest.value=str;
}

// 아이디 체크
function idCheck(memberForm,root) {

	if (memberForm.id.value=="") {
		alert("아이디를 입력해주세요.");
		memberForm.id.focus();
		return;
	}
	
	
	url = root + "/member/idCheck.do?id=" +memberForm.id.value;
	//alert(url);
	
	window.open(url,"","width=250px,height=150px");
}

// 우편번호
function zipcodeRead(root) {
	var url = root + "/member/zipcode.do";
	//alert(url);
	
	window.open(url,"","width=400px,height=400px");
}

function sendAddress(zipcode,sido,gugun,dong,ri,bunji) {
	var address = sido+gugun+dong+ri+bunji;
	// alert(zipcode +"\n" +address);
	
	opener.memberForm.zipcode.value=zipcode;
	opener.memberForm.address.value=address;
	self.close();
}






