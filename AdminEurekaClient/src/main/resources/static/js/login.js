function userLogin() {
	$.ajax({
		url : "user_login.action",
		data : $("#User_login").serialize(),
		dataType : "json",
		type : "post",
		success : function(data) {
			if (data.code == 1) {
				alert("登陆成功");
			} else {
				alert(data.errorMsg);
			}
		}
	});
}

function loginout() {
	$.ajax({
		url : "user_loginout.action",
		dataType : "json",
		type : "post",
		success : function(data) {
			if (data.code == 1) {
				location.href = "toList.action";
			}
		}
	});
}


