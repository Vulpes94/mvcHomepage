/**
 * 
 */

function deleteCheck(num,root) {
	var url=root + "/guest/delete.do?num=" +num;
	// alert(url);
	
	var value = confirm("정말로 삭제 하시겠습니까?");
	if (value==true) {
		location.href=url;
	}else{
		alert("삭제되지 않았습니다.");
	}
}


function updateCheck(num,root) {
	var url = root + "/guest/update.do?num=" +num;
	//alert(url);
	
	location.href=url;
}









