<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<dt class="clearfix">
	<i class="fl"></i> <span class="fl">全部商品分类</span> <em class="fl"></em>
</dt>

<c:forEach items="${firstTypelist}" var="first">
	<dd class="menu">
		<div class="clearfix">
			<i class="fl menuItemBack1"></i> <span class="fl"><a href="#">${first.firsttype_name}</a></span>
			<em class="fr"></em>
		</div>
		<div class="i-mc">
		<c:forEach items="${first.secondType}" var="second">
			<dl class="classification2 clearfix">
				<dt class="fl">
						<a href="http://localhost:8762/service-user/secondType.action?firsttype_id=${first.firsttype_id}&secondtype_id=${second.secondtype_id }" >${second.secondtype_name} &nbsp;<b>&gt;</b></a>
				</dt>
				<dd class="fl clearfix">
				
					<c:forEach items="${second.thirdType}" var="third">
						<a href="http://localhost:8762/service-user/secondType.action?firsttype_id=${first.firsttype_id}&secondtype_id=${second.secondtype_id }&thirdtype_id=${third.thirdtype_id }" class="fl">
						
							${third.thirdtype_name} </a>
					</c:forEach>
				</dd>
			</dl>
			</c:forEach>
		</div>
	</dd>
</c:forEach>
