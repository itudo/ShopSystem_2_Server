<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="header.jsp"%>
<script type="text/javascript">
	$(function() {
		var resfoodTreeData = [ {
			"id" : 1,
			"text" : "商品整理",
			"attributes" : {
				"url" : "<iframe width='100%'  height='100%' src='admin/goods/goodsView.jsp'   />"
			}
		} ];
		var resorderTreeData = [ {
			"id" : 1,
			"text" : "订单处理",
			"attributes" : {
				"url" : "<iframe width='100%'  height='100%' src='admin/order/orderShow.jsp'    />"
			}
		} ];
		var resuserTreeData = [ {
			"id" : 1,
			"text" : "客户浏览",
			"attributes" : {
				"url" : "<iframe width='100%'  height='100%' src='admin/user/userShow.jsp'   />"
			}
		} ];
		var databaseTreeData = [ {
			"id" : 1,
			"text" : "评论管理",
			"attributes" : {
				"url" : "<iframe width='100%'  height='100%' src='admin/review/reviewShow.jsp'   />"
			}
		} ];
		var websiteTreeData = [
				{
					"id" : 1,
					"text" : "分类管理",
					"attributes" : {
						"url" : "<iframe width='100%'  height='100%' src='admin/goodsType/goodsTypeList.jsp'   />"
					}
				},
				{
					"id" : 2,
					"text" : "属性管理",
					"attributes" : {
						"url" : "<iframe width='100%'  height='100%' src='admin/goodsType/attributeList.jsp'   />"
					}
				} ];
		showTree("resfoodTree", resfoodTreeData);
		showTree("resorderTree", resorderTreeData);
		showTree("resuserTree", resuserTreeData);
		showTree("databaseTree", databaseTreeData);
		showTree("websiteTree", websiteTreeData);
	});

	function showTree(treeId, treeData) {

		$("#" + treeId).tree({
			data : treeData,
			onClick : function(node) {
				if (node && node.attributes) {
					openTab(node);
				}
			}

		});
	}

	function openTab(node) {
		if ($("#mainTabs").tabs("exists", node.text)) { //判断选择的 节点是否已经在窗口上
			$("#mainTabs").tabs("select", node.text);//有则 选中  高亮显示 
		} else {
			$("#mainTabs").tabs("add", {//没有存在则  添加到 窗口上  
				title : node.text,
				closable : true,
				selected : true,
				content : node.attributes.url
			//显示内容 
			});
		}
	}
</script>


<body class="easyui-layout" style="width: 100%; height: 100%;">
	<!--easyui布局  -->
	<!--将布局分为五大板块 东 南 西 北  中间  -->
	<div data-options="region:'north'" style="height: 50px; align: center">
		<c:if test="${not empty admin}">
			<!-- admin不为空 -->
			<div id=" " class="wrap">
				<div class="search"  style="height: 50px; align: center">
					  您好 [ <a>${admin.admin_name }</a> ] ，欢迎回来！   
				</div>
			</div>
		</c:if>
	</div>
	<!-- <div data-options="region:'south',split:true" style="height: 50px;">south</div> -->
	<!-- <div data-options="region:'east',split:true" title="East"
		style="width: 200px;">east</div> -->
	<!-- west板块以树的形式来显示手风琴布局 -->
	<div data-options="region:'west',split:true" title="menus"
		style="width: 200px;">
		<div class="easyui-accordion" style="width: 500px; height: 300px;">
			<!-- 根目录 -->
			<div title="商品管理" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding: 10px;">
				<ul id="resfoodTree" class="easyui-tree">
					<!--子目录  树  -->

				</ul>
			</div>

			<div title="订单信息" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding: 10px;">
				<ul id="resorderTree" class="easyui-tree">
					<!--子目录  树  -->

				</ul>
			</div>

			<div title="用户管理" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding: 10px;">

				<ul id="resuserTree" class="easyui-tree">
					<!--子目录  树  -->

				</ul>
			</div>



			<div title="评论管理" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding: 10px;">
				<ul id="databaseTree" class="easyui-tree">
					<!--子目录  树  -->

				</ul>
			</div>

			<div title="商品分类" data-options="iconCls:'icon-ok'"
				style="overflow: auto; padding: 10px;">
				<ul id="websiteTree" class="easyui-tree">
					<!--子目录  树  -->

				</ul>
			</div>
		</div>
	</div>

	<div
		data-options="region:'center',title:'Main Title',iconCls:'icon-ok'  "
		style="width: 100%; height: 100%;">
		<div class="easyui-tabs" id="mainTabs"
			style="width: 100%; height: 100%;">
			<div title="欢迎您" style="padding: 10px">
				<%-- ShopSystem 欢迎您; 现在时刻：
				<%
				Date s = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
			%>
				<%=sdf.format(s)%> --%>

				<%@ include file="centerTop.jsp"%>
			</div>
		</div>

	</div>

</body>
</html>