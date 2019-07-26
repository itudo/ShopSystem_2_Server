<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript">
	$(function() {

		$('#userTable').datagrid(
				{/*   信息的表格 */
					url : 'admin/selectAllUser.action',
					pagination : true,
					pageSize : 20,
					pageList : [ 20, 50, 100, 150, 200, 300 ],
					idField : "user_id",
					rownumbers : true,
					fit : true,
					nowrap : true,
					sortName : 'user_id',
					sortOrder : "desc",
					singleselect : false,
					fitColumns : "true",
					striped : true,
					checkOnSelect : 'true',
					columns : [ [{
						field : "user_id",
						title : '用户编号',
						width : 150,
					}, {
						field : "user_name",
						title : '用户姓名',
						width : 100
					}, {
						field : "user_sex",
						title : '用户性别',
						width : 100,
						align : 'right'
					}, {
						field : "user_tel",
						title : '用户电话',
						width : 100,
						align : 'right'
					}, {
						field : "user_email",
						title : '用户邮箱',
						width : 100,
						align : 'right',
					}, {
						field : "user_idcard",
						title : '用户身份证号',
						width : 100,
						align : 'right'
					}, {
						field : "user_level",
						title : '用户等级',
						width : 100,
						align : 'right'
					}] ]
			});
});
</script>
<body class="easyui-layout">
		<table id="userTable">
		</table>
</body>
</html>