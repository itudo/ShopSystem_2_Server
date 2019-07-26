
// +----------------------------------------------------------------------
// | OnlineRetailers [ WE CAN DO IT JUST THINK IT ]
// +----------------------------------------------------------------------
// | Copyright (c) 2003-2023 www.yisu.cn All rights reserved.
// +----------------------------------------------------------------------
// | Licensed 亿速网络（http://www.yisu.cn）
// +----------------------------------------------------------------------
// | Author: 王强 <opjklu@126.com>
// +----------------------------------------------------------------------
/**
 * 
 */
$("#bannerBox").slide({
	mainCell : ".slideBanner",
	effect : "fold",
	interTime : 3500,
	delayTime : 500,
	autoPlay : true,
	autoPage : true,
	endFun : function(i, c, s) {
		$(window).resize(function() {
			var width = $(window).width();
			var height = $(window).height();
			s.find(".slideBanner,.slideBanner li").css({
				"width" : width,
				"height" : height
			});
		});
	}
});
$(function(){
	$('#code').keyup(function(){
		var code = $('#code').val();
		if(code.length == 4){
			$.get(checkCode, {code:code},function(data){
				if(data == 1){
					$('#check_code').val(1);
					layer.tips('√ 通过验证', '#code',{time: 60000});
				}else{
					$('#check_code').val(0);
					layer.tips('× 验证错误', '#code');
				}
			});
		}
	});
})

function check_login(){
	var account = $('#account').val();
	var password = $('#password').val();
	var code = $('#code').val();	//验证码
	var check_code = $('#check_code').val();	//验证码验证结果
	if(account == ''){
		layer.tips('请输入用户名', '#account');
		return false;
	}
	if(password == ''){
		layer.tips('请输入密码', '#password');
		return false;
	}
	if(code == ''){
		layer.tips('请输入验证码', '#code');
		return false;
	}
	if(check_code == 0){    //判断验证码正确，才允许提交
		layer.tips('验证码错误', '#code');
		return false;
	}
	return true;
}
