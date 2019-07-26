function register(){
	$.ajax({
		url : "user_register.action",
		data : $("#User_register").serialize(),
		dataType : "json",
		type : "post",
		success : function(data) {
			if (data.code == 1) {
				alert("恭喜用户: "+data.obj.username +" 注册成功")
				location.href = "login.jsp";
			} else {
				alert(data.errorMsg);
			}
		}
	});
}
function isUserExists(username){
	$.ajax({
		url : "user_isUserExists.action",
		data :"username=" + username,
		dataType : "json",
		type : "post",
		success : function(data) {
			if (data.code == 1) {
				alert("该用户名可以使用");
			} else {
				alert("该用户名已被使用,请重新填写");
			}
		}
	});
}

function checkPassword(){
	var password = $("#password").val();
	var repassword = $("#repassword").val();
	if(repassword != password){
		alert("两次密码不一致，请重写输入");
	}
	
	
}

