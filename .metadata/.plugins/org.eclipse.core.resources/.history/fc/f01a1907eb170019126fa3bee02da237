<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<link rel="stylesheet" href="./goodsList_files/base.css">
<link rel="stylesheet" href="./goodsList_files/style.css">
<script src="./goodsList_files/saved_resource"></script>
<script src="./goodsList_files/layer.js"></script>
<script src="./goodsList_files/jquery.min.js"></script>
<script src="./goodsList_files/layer(1).js"></script>
<style type="text/css">
.easemobim-mobile-html {
	position: relative !important;
	width: 100% !important;
	height: 100% !important;
	padding: 0 !important;
	margin: 0 !important
}

.easemobim-mobile-body {
	position: absolute;
	top: 0 !important;
	left: 0 !important;
	width: 100% !important;
	height: 100% !important;
	overflow: hidden !important;
	padding: 0 !important;
	margin: 0 !important
}

.easemobim-mobile-body>* {
	display: none !important
}

.easemobim-mobile-body>.easemobim-chat-panel {
	display: block !important
}

.easemobim-chat-panel {
	z-index: 1000;
	overflow: hidden;
	position: fixed;
	border: none;
	width: 0;
	height: 0;
	-webkit-transition: all .01s;
	-moz-transition: all .01s;
	transition: all .01s;
	box-shadow: 0 4px 8px rgba(0, 0, 0, .2);
	border-radius: 4px
}

.easemobim-chat-panel.easemobim-minimized {
	border: none;
	box-shadow: none;
	height: 37px !important;
	width: 104px !important
}

.easemobim-chat-panel.easemobim-minimized.easemobim-has-prompt {
	width: 360px !important;
	height: 270px !important
}

.easemobim-chat-panel.easemobim-mobile {
	position: absolute !important;
	width: 100% !important;
	height: 100% !important;
	left: 0 !important;
	top: 0 !important;
	border-radius: 0;
	box-shadow: none
}

.easemobim-chat-panel.easemobim-mobile.easemobim-minimized {
	height: 0 !important;
	width: 0 !important
}

.easemobim-chat-panel.easemobim-hide {
	visibility: hidden;
	width: 1px !important;
	height: 1px !important;
	border: none
}

.easemobim-chat-panel.easemobim-dragging {
	display: none
}

.easemobim-iframe-shadow {
	left: auto;
	top: auto;
	display: none;
	cursor: move;
	z-index: 16777270;
	position: fixed;
	border: none;
	box-shadow: 0 4px 8px rgba(0, 0, 0, .2);
	border-radius: 4px;
	background-size: 100% 100%;
	background-repeat: no-repeat
}

.easemobim-iframe-shadow.easemobim-dragging {
	display: block
}

.easemobim-prompt-wrapper {
	display: none;
	z-index: 16777271;
	position: fixed;
	width: 30px;
	height: 30px;
	padding: 10px;
	top: 0;
	bottom: 0;
	margin: auto;
	left: 0;
	right: 0;
	color: #fff;
	background-color: #000;
	text-align: center;
	border-radius: 4px;
	-webkit-transition: all .5s;
	-moz-transition: all .5s;
	transition: all .5s;
	opacity: .7;
	-moz-box-sizing: content-box;
	box-sizing: content-box
}

.easemobim-prompt-wrapper>.loading {
	position: relative;
	width: 30px;
	height: 30px;
	display: inline-block;
	overflow: hidden;
	margin: 0;
	padding: 0;
	-webkit-animation: easemobim-loading-frame 1s linear infinite;
	-moz-animation: easemobim-loading-frame 1s linear infinite;
	animation: easemobim-loading-frame 1s linear infinite
}

@
-webkit-keyframes easemobim-loading-frame { 0%{
	-webkit-transform: rotate(0);
	transform: rotate(0)
}

to {
	-webkit-transform: rotate(1turn);
	transform: rotate(1turn)
}

}
@
-moz-keyframes easemobim-loading-frame { 0%{
	-moz-transform: rotate(0);
	transform: rotate(0)
}

to {
	-moz-transform: rotate(1turn);
	transform: rotate(1turn)
}

}
@
keyframes easemobim-loading-frame { 0%{
	-webkit-transform: rotate(0);
	-moz-transform: rotate(0);
	transform: rotate(0)
}

to {
	-webkit-transform: rotate(1turn);
	-moz-transform: rotate(1turn);
	transform: rotate(1turn)
}

}
.easemobim-pc-img-view {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	z-index: 16777270
}

.easemobim-pc-img-view>.shadow {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: #000
}

.easemobim-pc-img-view>img {
	max-width: 100%;
	max-height: 100%;
	position: absolute;
	margin: auto;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0
}
</style>
<link rel="stylesheet" href="./goodsList_files/layer.css"
	id="layui_layer_skinlayercss">
</head>

<div class="homeNavBar">
	<div class="w clearfix" style="z-index: 2;">
		<dl class="fl level paperone">
			<%@ include file="../left.jsp"%>
		</dl>
		<ul class="fr clearfix navitems-2016">

			<li class="fl"><a
				href="http://demo.shopsn.net/index.php/Home/Index/index">首页</a></li>
			<li class="fl"><a
				href="http://demo.shopsn.net/index.php/Home/LatestPromotion/index">最新促销</a>
			</li>
		</ul>
	</div>
</div>
<link rel="stylesheet" href="./goodsList_files/page.css">

<div class="paper-current-main w">
	当前位置：<span>${firstType.firsttype_name}&gt;${secondType.secondtype_name}</span>
</div>

<div class="product-location"></div>
<div class="productDeta-main w clearfix">
	<div class="productDetaLeft fl">
		<div class="secondTypeList">
		
		</div>
	<%-- 	<%@ include file="top10.jsp"%> --%>
	</div>

	<div class="productDetaRight fr">
		<div class="productDetagg">
			<a
				href="http://demo.shopsn.net/index.php/Home/Product/ProductList/cid/64.html"></a><img
				src="./goodsList_files/5b31ed78afd7e.jpg" alt="" width="970"
				height="110">
		</div>
		<div class="chooseCondition">
			
		 
		</div>
		<div class="sortCondition clearfix">
			<div class="fl" id="sortCondition">
				<span>排序：</span> <a href="javascript:;" class="active">销量</a> <a
					href="javascript:;">价格</a> <a href="javascript:;">评论数</a> <a
					href="javascript:;">上架时间</a>
			</div>
		</div>

		<ul class="productList1 clearfix productlist-error-xs">
			

				 <c:forEach items="${goodsList}" var="goods">
				 <li class="fl">
					 	<a href="javascript:;" class="data_curent" data-current-id="65" data-id="65">${attrvalue.attrvalue_value}</a>
				<div class="proPic-img">
					<a href="http://localhost:8762/service-user/goodsdetail.action?goods_id=${goods.goods_id}">
						<img src="http://localhost:8762/service-admin/imgGoods/${goods.goodsDetails[0].images[0].image_path }" width="190"
						height="190" style="margin-top: 10px">
					</a>
				</div>
				 <div class="pingJia clearfix">
				
					<i class="fl"></i> <i class="fl"></i> <i class="fl"></i> <i
						class="fl"></i> <i class="fl"></i>
					<div class="fr">
						商品销量 <b>${goods.goods_sale}</b>
					</div>
				
				</div>
				<div class="itemDescBack">
					<p class="proDesc">
						<a href="http://localhost:8762/service-user/goodsdetail.action?goods_id=${goods.goods_id}">${goods.goods_name}</a>
					</p>
					<span class="proPrice">￥<i>${goods.goodsDetails[0].goodsdetail_price }</i></span>
					<p class="addCart1">
						<a
							href="javascript:addCart(${goods.goodsDetails[0].goodsdetail_id})">加入购物车</a>
						<a href="javascript:addCollect(${goods.goods_id});">收藏</a>
					</p>
				</div>
				</li>
				</c:forEach>
			
			
		</ul>


		<div class="page" id="page">
			<div>
				共&nbsp;<b>2</b>&nbsp;条&nbsp;&nbsp;&nbsp;<b>1</b>/<b>1</b>
				页&nbsp;&nbsp;
			</div>
		</div>


		<div class="guessYouLike">
			<div class="guessYouLike1 clearfix">
				<h4 class="fl">猜你喜欢</h4>
				<span class="fr clearfix" id="exchange">换一换</span>
			</div>
			<ul class="guessYouLike2" id="guessYouLike2">
				<li class="fl">
					<div class="like2-img">
						<a
							href="http://demo.shopsn.net/index.php/Home/Goods/goodsDetails/id/3492.html"><img
							src="./goodsList_files/595b534ba306e.jpg" alt="" width="100"
							height="100"></a>
					</div>
					<p>惠氏启赋婴儿配方奶粉 1段 illuma）婴儿配方奶粉 1段 900克 白色</p> <span>(已有0人评论)</span>
					<i>￥100.00</i>
				</li>
				<li class="fl">
					<div class="like2-img">
						<a
							href="http://demo.shopsn.net/index.php/Home/Goods/goodsDetails/id/3366.html"><img
							src="./goodsList_files/5b32fe26c3a28.jpg" alt="" width="100"
							height="100"></a>
					</div>
					<p>荣耀 畅玩6X 畅玩6X 香槟金</p> <span>(已有0人评论)</span> <i>￥0.01</i>
				</li>
				<li class="fl">
					<div class="like2-img">
						<a
							href="http://demo.shopsn.net/index.php/Home/Goods/goodsDetails/id/3596.html"><img
							src="./goodsList_files/5b31eea998554.jpg" alt="" width="100"
							height="100"></a>
					</div>
					<p>小米（MI）小米电视3S 55英寸超高清超薄 110 台</p> <span>(已有0人评论)</span> <i>￥100.00</i>
				</li>
				<li class="fl">
					<div class="like2-img">
						<a
							href="http://demo.shopsn.net/index.php/Home/Goods/goodsDetails/id/3460.html"><img
							src="./goodsList_files/595b4131e0c92.jpg" alt="" width="100"
							height="100"></a>
					</div>
					<p>海飞丝 H&amp;S 洗护套装丝质柔滑去屑洗发水 H&amp;S 洗护套装丝质柔滑去屑洗发水 黑色</p> <span>(已有0人评论)</span>
					<i>￥100.00</i>
				</li>
				<li class="fl">
					<div class="like2-img">
						<a
							href="http://demo.shopsn.net/index.php/Home/Goods/goodsDetails/id/3464.html"><img
							src="./goodsList_files/595b487853117.jpg" alt="" width="100"
							height="100"></a>
					</div>
					<p>玖熙2017新款沙滩鞋欧美百搭时尚人字拖拖鞋 粉红</p> <span>(已有0人评论)</span> <i>￥29.00</i>
				</li>
			</ul>
		</div>
	</div>
</div>
</div>
<input type="hidden" name="current_cat" id="current_cat" value="">
<input type="hidden" name="third_cat" id="current_third_cat" value="64">
<input type="hidden" name="serch_kerword" id="serarch-title" value="">
<input type="hidden" name="serch_begin_price" id="ser-begin-price"
	value="">
<input type="hidden" name="serch_end_price" id="ser-end-price" value="">
<script src="./goodsList_files/header.js"></script>
<script src="./goodsList_files/expansion.js"></script>
<script src="./goodsList_files/offcePaper.js"></script>
<script>
function addCart(id){
	$.post("http://localhost:8762/service-user/addCart.action", { 'goodsdetail_id':id},function(data){
	    if (data.code == 1) {
	    	parent.layer.msg('添加成功', {icon: 1, time: 3000 });
	    	showCart();
	    }else{
	        parent.layer.msg('添加失败', {icon: 2, time: 2000 }); 
	    };
	});
}
function addCollect(id){
	$.post("http://localhost:8762/service-user/addCollect.action", { 'goods_id':id},function(data){
	    if (data.code == 1) {
	    	parent.layer.msg('收藏成功', {icon: 1, time: 3000 });
	    	showCart();
	    }else{
	        parent.layer.msg('收藏失败', {icon: 2, time: 2000 }); 
	    };
	});
}
        $(function(){
            $("#exchange").on('click',function(){
                var url = '/index.php/Home/Product/guess.html';
                $.ajax({
                    type:"get",
                    url:url,
                    error:function(){
                      alert("服务器忙，请联系管理员！")
                    },
                    success:function(data){
                        $("#guessYouLike2").html(data);
                    }
                })

            });

        });
        $(function(){
            var cid = "";
            //选中二级菜单
            var current_cat = $("#current_cat").val();

            if(current_cat){

                $(".all_cate").removeClass("active");
                $(".data_curent").each(function(i,v){
                  if($(v).attr("data-current-id")==current_cat){
                      $(this).addClass("active");
                      //$(v).children(":first").addClass("active");
                  }
                });
            }
            //选中第三级菜单的对应的选项
            var third_cat = $("#current_third_cat").val();
            if(third_cat){
                $(".third").each(function(i,v){
                    if(third_cat == $(v).attr("data-third-id")){
                        $(v).children(":first").css("color","red");
                        $(v).prev().attr("data","true");
                        $(v).parent().addClass("active");
                    }

                    $(".all_cate").removeClass("active");
                    $(".data_curent").each(function(i,v){
                        if($(v).attr("data-current-id")==third_cat){
                          $(this).addClass("active");
                            //$(v).children(":first").addClass("active");
                        }
                    });

               });
            }
            /**
             * 点击事件  选择类型
             */
             var change_type = $(".class-type dd");
             change_type.on('click','a',function() {
                 change_type.children('a').removeClass('active').eq($(this).index()).addClass('active');
                 var price = $(".class-price .active").text();
                 clickAjax(price);
                 return false;
             });

            /**
             *   点击事件  选择品牌
             *
             */

            var change_brand = $(".class-brand dd");
            change_brand.on('click','a',function(){
                change_brand.children('a').removeClass('active').eq($(this).index()).addClass('active');
                var price = $(".class-price .active").text();
                clickAjax(price);
                return false;
            });

            /**
             * 点击事件 选择价格
             */
            var change_price = $(".class-price .f2");
            change_price.on('click','a',function(){
                change_price.children('a').removeClass('active').eq($(this).index()).addClass('active');
                var price = $(".class-price .active").text();
                //清楚文本框的值，增强用户视觉效果
                $("#price_before").val('');
                $("#price_after").val('');
                clickAjax(price);
                return false;
            });

            /**
             * 点击事件 选择规格
             */
            var change_num = $(".class-num dd");
            change_num.on('click','a',function(){
                change_num.children('a').removeClass('active').eq($(this).index()).addClass('active');
                var price = $(".class-price .active").text();
                clickAjax(price);
                return false;
            });



            /**
             * 点击事件 选择价格搜索
             */
            $("#id-btn").on('click',function(){
                var begin_price = $("#price_before").val();
                var end_price = $("#price_after").val();
                //当文本框的为空时，点击按钮
                if(!(begin_price || end_price)) {
                    $(".class-price .f2").children('a').removeClass("active");
                    $("#id-all-price").addClass('active');
                    var price = $(".class-price .active").text();
                }else{
                    $(".class-price .f2").children('a').removeClass("active");
                    var price = begin_price+'-'+end_price;
                }

                clickAjax(price);
            });

            /**
             *点击事件  选择销量、价格、评论、上架时间
             * @param price
             */
            var sortCond =  $("#sortCondition");
            sortCond.on('click','a',function(){
                var cid =  "64";
                sortCond.find('a').removeClass('active').eq($(this).index()-1).addClass('active');
                var sortChoose = $("#sortCondition .active").text()                  ;
                clickAjax('',sortChoose,cid);
            });
            //点击封装ajax 函数
            function  clickAjax(price,sortChoose,cid1){
                //如果搜索
                var kerword = $("#serarch-title").val();
                var begin_price1 = $("#ser-begin-price").val();
                var end_price1 =  $("#ser-end-price").val();

                var cid = $(".class-type .active").attr("data-id");
                if(!cid){
                    cid = cid1;
                }
                var brand = $(".class-brand .active").attr("id-value");
                var num = $(".class-num .active").text();
                var price = price;
                if(price=="全部"){price = "all";}
                if(num=="全部"){num =  "all";}
                if(sortChoose){
                    var sortCond = sortChoose;
                }
                var url = "/index.php/Home/Product/productlist.html";
                var data = {cid:cid,brand:brand,price:price,goods_spec:num,sortCond:sortCond,keyword:kerword,begin_price:begin_price1,end_price:end_price1};
                $.getJSON(url,data,function(json){
                    if(json.data.length){
                        var data = json.data;//更新数据
                        var page_str = "";
                        for(i =0;i<data.length;i++){
                            page_str+= '<li class="fl">'+
                                    '<div class="proPic-img">'+
                                    '<a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">'+
                            '<img src="'+data[i].pic_url+'" width="190" height="190" style="margin-top:10px">'+
                            '</a>'+
                            '</div>'+
                            '<div class="pingJia clearfix">'+
                            '<i class="fl"></i>'+
                            '<i class="fl"></i>'+
                            '<i class="fl"></i>'+
                            '<i class="fl"></i>'+
                            '<i class="fl"></i>'+
                            '<div class="fr">'+
                            '商品销量 <b>'+data[i].sales_sum+'</b>'+
                            '</div>'+
                            '</div>'+
                            '<div class="itemDescBack">'+
                            '<p class="proDesc"><a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">'+data[i].title+'</a></p>'+
                            '<span class="proPrice">'+"￥"+data[i].price_market+'</span>'+
                            '<p class="addCart1">'+
                            '<a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">加入购物车</a>'+
                            '<a href="javascript:;">收藏</a>'+
                            '</p>'+
                            '</div>'+
                            '</li>';
                        }

                        $(".productList1").html(page_str);//更新内容

                        if(!json.page){
                            $("#page").html("");
                        }else{
                            $("#page").html(json.page);
                        }
                    }else{
                        $(".productlist-error-xs").html('<div class="product-list-not-error"><h1>亲，你访问的数据不存在</h1> </div>');
                    }
                });
            }
            //点击分页  页数 无刷新
            $("#page a").live("click",function(){
                var cid = $(".class-type .active").attr("data-id");
                var brand = $(".class-brand .active").attr("id-value");
                var num = $(".class-num .active").text();
                var price = $(".class-price .active").text();
                if(price=="全部"){price = "all";}
                if(num=="全部"){num =  "all";}
                var url=$(this).attr("href");
                var data = {cid:cid,brand:brand,price:price,num:num};
                $.getJSON(url,data,function(json){
                    $("html,body").animate({scrollTop:200},500);
                    var data = json.data;//更新数据
                    var page_str = "";
                    for(i =0;i<data.length;i++){
                        page_str+= '<li class="fl">'+
                                '<div class="proPic-img">'+
                                '<a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">'+
                        '<img src="'+data[i].pic_url+'" width="190" height="190" style="margin-top:10px">'+
                        '</a>'+
                        '</div>'+
                        '<div class="pingJia clearfix">'+
                        '<i class="fl"></i>'+
                        '<i class="fl"></i>'+
                        '<i class="fl"></i>'+
                        '<i class="fl"></i>'+
                        '<i class="fl"></i>'+
                        '<div class="fr">'+
                        '商品销量 <b>'+data[i].sales_sum+'</b>'+
                        '</div>'+
                        '</div>'+
                        '<div class="itemDescBack">'+
                       '<p class="proDesc"><a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">'+data[i].title+'</a></p>'+
                        '<span class="proPrice">'+"￥"+data[i].price_market+'</span>'+
                        '<p class="addCart1">'+
                       '<a href="/index.php/Home/Goods/goodsDetails/id/'+ data[i].id +'.html">加入购物车</a>'+
                        '<a href="javascript:;">收藏</a>'+
                        '</p>'+
                        '</div>'+
                        '</li>';
                    }

                    $(".productList1").html(page_str);//更新内容
                    $("#page").html(json.page);
                });
                return false;
            });
        });
    </script>

<ul class="home-tab">
	<li><em></em> <span>0 </span>
		<div class="userTips">
			<%@ include file="../userCenter/tip.jsp"%>
		</div> <%@ include file="../userCenter/bottom.jsp"%>