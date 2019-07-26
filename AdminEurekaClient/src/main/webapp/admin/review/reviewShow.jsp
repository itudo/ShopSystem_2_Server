<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
	$(function() {

		$('#reviewTable')
				.datagrid(
						{/*   信息的表格 */
							url : 'admin/selectReview.action',
							pagination : true,
							pageSize : 20,
							pageList : [ 20, 50, 100, 150, 200, 300 ],
							idField : "review_id",
							rownumbers : true,
							fit : true,
							nowrap : true,
							sortName : 'review_level',
							sortOrder : "desc",
							singleselect : false,
							fitColumns : "true",
							columns : [ [
									{
										field : "review_id",
										title : '编号',
										width : 150,
									},
									{
										field : "review_level",
										title : '星级',
										width : 100
									},
									{
										field : "user_name",
										title : '用户名',
										width : 100,
										formatter : function(value, row, index) {

											if (row.users) {
												return row.users.user_name;
											} else {
												return '';
											}
										}
									},
									{
										field : "review_content",
										title : '评论',
										width : 100,
										align : 'right'
									},
									{
										field : "review_image",
										title : '买家秀',
										width : 100,
										align : 'right',
										formatter : function(value, row, index) {

											if (row.review_image) {
												return "<img style='width:24px;height:24px;' border='1' src='http://localhost:8762/service-user/imgReview/"
                                     +row.review_image+"'/>";

											} else {
												return '';
											}
										}
									},
									{
										field : "review_date",
										title : '评论时间',
										width : 100,
										align : 'right'
									},
									{
										field : "goods_name",
										title : '商品名称',
										width : 100,
										align : 'right',
										formatter : function(value, row, index) {

											if (row.orderDetail.goodsDetail) {
												return row.orderDetail.goodsDetail.goods.goods_name;
											} else {
												return '';
											}
										}
									},
									{
										field : "goods_count",
										title : '购买数量',
										width : 100,
										align : 'right',
										formatter : function(value, row, index) {

											if (row.orderDetail) {
												return row.orderDetail.goods_count;
											} else {
												return '';
											}
										}
									} ] ]
						});
	});
</script>
<body class="easyui-layout">
	<div data-options="region:'center',title:'',iconCls:'icon-ok'  "
		style="width: 100%; height: 70%;">

		<table id="reviewTable"></table>
	</div>
</body>
</html>