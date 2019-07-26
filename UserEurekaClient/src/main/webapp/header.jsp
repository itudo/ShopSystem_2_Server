<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<title>淘宝贝</title>
<link rel="stylesheet" href="index_files/base.css">
<link rel="stylesheet" href="index_files/style.css">
<script src="index_files/jquery.min.js"></script>
<script src="index_files/header.js"></script>
<script src="index_files/scroll.js"></script>
<script src="index_files/home.js"></script>
<script src="index_files/layer.js"></script><link rel="stylesheet" href="index_files/layer.css" id="layui_layer_skinlayercss">
<style type="text/css">.easemobim-mobile-html{position:relative!important;width:100%!important;height:100%!important;padding:0!important;margin:0!important}.easemobim-mobile-body{position:absolute;top:0!important;left:0!important;width:100%!important;height:100%!important;overflow:hidden!important;padding:0!important;margin:0!important}.easemobim-mobile-body>*{display:none!important}.easemobim-mobile-body>.easemobim-chat-panel{display:block!important}.easemobim-chat-panel{z-index:1000;overflow:hidden;position:fixed;border:none;width:0;height:0;-webkit-transition:all .01s;-moz-transition:all .01s;transition:all .01s;box-shadow:0 4px 8px rgba(0,0,0,.2);border-radius:4px}.easemobim-chat-panel.easemobim-minimized{border:none;box-shadow:none;height:37px!important;width:104px!important}.easemobim-chat-panel.easemobim-minimized.easemobim-has-prompt{width:360px!important;height:270px!important}.easemobim-chat-panel.easemobim-mobile{position:absolute!important;width:100%!important;height:100%!important;left:0!important;top:0!important;border-radius:0;box-shadow:none}.easemobim-chat-panel.easemobim-mobile.easemobim-minimized{height:0!important;width:0!important}.easemobim-chat-panel.easemobim-hide{visibility:hidden;width:1px!important;height:1px!important;border:none}.easemobim-chat-panel.easemobim-dragging{display:none}.easemobim-iframe-shadow{left:auto;top:auto;display:none;cursor:move;z-index:16777270;position:fixed;border:none;box-shadow:0 4px 8px rgba(0,0,0,.2);border-radius:4px;background-size:100% 100%;background-repeat:no-repeat}.easemobim-iframe-shadow.easemobim-dragging{display:block}.easemobim-prompt-wrapper{display:none;z-index:16777271;position:fixed;width:30px;height:30px;padding:10px;top:0;bottom:0;margin:auto;left:0;right:0;color:#fff;background-color:#000;text-align:center;border-radius:4px;-webkit-transition:all .5s;-moz-transition:all .5s;transition:all .5s;opacity:.7;-moz-box-sizing:content-box;box-sizing:content-box}.easemobim-prompt-wrapper>.loading{position:relative;width:30px;height:30px;display:inline-block;overflow:hidden;margin:0;padding:0;-webkit-animation:easemobim-loading-frame 1s linear infinite;-moz-animation:easemobim-loading-frame 1s linear infinite;animation:easemobim-loading-frame 1s linear infinite}@-webkit-keyframes easemobim-loading-frame{0%{-webkit-transform:rotate(0);transform:rotate(0)}to{-webkit-transform:rotate(1turn);transform:rotate(1turn)}}@-moz-keyframes easemobim-loading-frame{0%{-moz-transform:rotate(0);transform:rotate(0)}to{-moz-transform:rotate(1turn);transform:rotate(1turn)}}@keyframes easemobim-loading-frame{0%{-webkit-transform:rotate(0);-moz-transform:rotate(0);transform:rotate(0)}to{-webkit-transform:rotate(1turn);-moz-transform:rotate(1turn);transform:rotate(1turn)}}.easemobim-pc-img-view{display:none;position:fixed;top:0;left:0;width:100%;height:100%;z-index:16777270}.easemobim-pc-img-view>.shadow{position:fixed;top:0;left:0;width:100%;height:100%;background-color:#000}.easemobim-pc-img-view>img{max-width:100%;max-height:100%;position:absolute;margin:auto;top:0;right:0;bottom:0;left:0}</style></head>
<body>

<div class="top1">
<div class="header-2016">
<div class="w clearfix">

<ul class="fl" id="areaList">
</ul>

<ul class="fr clearfix nav-right">
<li class="fl clearfix">
<div id="loginUser">

</div>
</li>
<li class="fl">
|<a href="userCenter/user/myOrder.jsp">我的订单</a>|
</li>
<li class="fl customerService">
<a href="userCenter/user/balance.jsp">个人中心<i></i></a>
</li>
<li class="fl clearfix mobile">
<span class="fl">|</span>
<div class="mobile-phone fl">
<b></b>
<s></s>
</div>
<a href="javascript:;" class="fl">APP下载</a>
</li>
<li class="fl customerService">
|<a href="userCenter/">客户服务<i></i></a>|
</li>
<li class="fl customerService">
<a href="javascript:;">网站导航<i></i></a>

</li>
<li class="fl telephone"><em></em>400-800-900</li>
</ul>
</div>
</div>
</div>
<div class="home-section">


<div class="header-advertisement-one" style="height: 0px;">
<div class="advertisement">
<a data="" gg="" onclick="addAd(this)" target="_blank">
<img src="index_files/5b3329baa405f.jpg" width="100%" height="100"> </a>
<input type="button" class="advertisement_delete" id="advertisement_delete">
</div> <span class="home-delete-one">x</span>
</div>
<div class="header-advertisement" style="display: block;">
<span class="home-delete"></span>
</div> 
<div class="home-header">
<div class="home-header-main clearfix">

<a href="http://localhost:8762/service-user/index.jsp" class="logo fl">
<img style="max-width: 200px;" src="index_files/5b35ac047dc6f.jpg" alt="">
<h2>欢迎来到淘宝贝</h2>
</a>

<div class="home-search-parent fl">
<div class="home-search clearfix">
<form id="formsarch" action="http://localhost:8762/service-user/search.action" method="get">
<input type="text" class="fl input" name="search" id="pp">
<input type="submit" class="fl btn" id="search" value="搜 索">
<div class="gg"></div>
</form>
</div>
<dl class="home-hotsearch clearfix">
<dt class="fl">热门搜索：</dt>
<dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/31.html">冰箱</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/30.html">单反</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/29.html">电饭煲</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/28.html">空调</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/27.html">手机</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/26.html">笔记本</a></dd><dd class="fl"><a href="http://demo.shopsn.net/index.php/Home/Product/ProductList/id/25.html">电视机</a></dd> </dl>
</div>

<div class="home-shopping hover fl">
<div class="home-shopping-top clearfix">
<em class="fl"></em>
<span class="fl"><a href="http://localhost:8762/service-user/userCenter/user/cart.jsp">我的购物车</a></span>
<i class="fl"></i>
</div>
<div class="home-individual clearfix">
<span class="fl"></span><em class="fl" id="couts">1</em><i></i></div>
<dl class="home-shopping-up">

</dl>
</div>

<div class="fr home-code"></div>
</div>
</div>


<script>
function showCart() {
	$.getJSON("http://localhost:8762/service-user/getCart.action",function(data) {
		if(data.code==1) {
			var obj = data.obj;
			$("#couts").html(obj.length);
			var str = "";
			for(var i=0;i<obj.length;i++) {
				str+="<dd class='clearfix active'><a href='javscript:;' class='fl'><img src='http://localhost:8762/service-admin/imgGoods/"+obj[i].goodsDetail.images[0].image_path+"' alt=''>";
				str+="</a><a href='' class='fl con'>"+obj[i].goodsDetail.goods.goods_name+" </a><strong class='fl'><span>￥"+obj[i].goodsDetail.goodsdetail_price+"</span>";
				str+="x"+obj[i].goodsDetail.goods_count+"<br><a href='javascript:delCartDetail("+obj[0].cartdetail_id+");' class='dels' >删除</a></strong></dd>";
			}
			$(".home-shopping-up").html(str);
		}
	})
}
function delCartDetail(id){
	 $.getJSON("http://localhost:8762/service-user/delCartDetail.action",{"cartdetail_id":id},function(data) {
		 if(data.code==1) {
			 showCart();
		 }
	 })
}
$(function() {
	$.getJSON("http://localhost:8762/service-user/loginUser.action",function(data) {
		if(data.code==1) {
			$("#loginUser").append("<span class='fl'><span style='color:red;'>"+data.obj.user_name+"</span>&nbsp;欢迎来到淘宝贝！</span><a href='javascript:logout()' class='fl active'>【退出】</a>");
			showCart();
		} else {
			$("#loginUser").append("<a href='http://localhost:8762/service-user/userCenter/login.jsp' class='fl active'>【登录】</a><a href='http://localhost:8762/service-user/userCenter/reg.jsp' class='fl active'>【注册】</a></span>")
			$("#couts").html("0");
			$(".home-shopping-up").html("<dt id='cart_no'>购物车没有任何东西，赶紧选吧。</dt>")
		}
	});
}) 
function logout() {
	$.getJSON("http://localhost:8762/service-user/logout.action",function(data) {
		if(data.code==1) {
			$("#loginUser").html("");
			$("#loginUser").append("<a href='userCenter/login.jsp' class='fl active'>【登录】</a><a href='userCenter/reg.jsp' class='fl active'>【注册】</a></span>")
			$("#couts").html("0");
			$(".home-shopping-up").html("<dt id='cart_no'>购物车没有任何东西，赶紧选吧。</dt>")
		}
	})
}
        var _this = null;
        var clear = null;
        var timer = null;
        $('#pp').on('input',function(){
            _this = $(this);
            clearInterval(clear);
            clear = setTimeout(function(){
                var _url ="http://localhost:8762/service-user/search2.action";
                var _data = _this.val();
                 $.post(_url,{search:_data},function(data){
                    /* if(data.status==0){
                        	layer.msg(data.message);
                    } */
                    //alert(1)
                    if(data.code==1){
                        var _a=data.obj;
                        var _b="http://localhost:8762/service-user/goodsdetail.action"
                        var _html='';
                        for (var i in _a){
                            _html +='<div><a href="'+_b+'?goods_id='+_a[i].goods_id+'"> '+_a[i].goods_name+'</a></div>';
                        }
                    }
                    $('.gg').html(_html);
                    $('input[name="id"]').val(_a[0].id);
                    if(data.status==2){
                        $('.gg').html('');
                    }
                },'json') 
            },300); 
        }).on('keydown',function(ev){
        	//alert($(this).val())
            if(ev.keyCode == 13){
                if($(this).val() == ''){
                    alert('搜索不能为空！');
                }else{
                    clearTimeout(timer);
                    timer = setTimeout(function(){
                        $('#pp').parents('form').submit();
                    },800);
                }
                return false;
            }
            ev.stopPropagation();
        });
    </script>

<script>
        $('#new_cart_data').on('click','.dels',function(){
            var _url="/index.php/Home/Goods/dels.html";
            var _id=$(this).attr('data');
            $.post(_url,{id:_id},function(data){
                if(data.status==0){
                    layer.msg(data.message);
                }
            })
            var _count=parseInt($('#couts').html());
            $(this).parent().parent().remove('dd');
            $('#couts').html(_count-1);
        })
    </script>


<script>
        function addAd(ele){
            var _id=$(ele).attr('gg');
            var _reurl=$(ele).attr('data');
            var _locatUrl="/index.php/Home/Ad/addhit.html";
            $.post(_locatUrl, {id:_id},function(data){
                console.log(data.msg);
            },'JSON')
            window.location.href=_reurl;
        }
    </script>
<script>
       $("#formsarch").submit(function(){
           $("#ser-id").remove();
       });

   </script>