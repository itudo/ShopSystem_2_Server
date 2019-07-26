<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</head>
</head>
<body class="easyui-layout">
	<!-- <div id="btn">
		<button class="easyui-linkbutton" iconCls="icon-add" id="add">新建</button>
		<button class="easyui-linkbutton" iconCls="icon-edit" id="edit">修改</button>
		<button class="easyui-linkbutton" iconCls="icon-add" id="icon-remove">删除</button>
	</div> -->
	<div style="width: 100%; height: 100%; overflow: scroll;">
		<ul id="tt"></ul>
	</div>

	<div id="addFirsttype" class="easyui-dialog" title="增加一级列表"
		style="width: 600px; height: 420px; text-align: center"
		data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
		<table cellpadding="15" style="padding-left: 130px">
			<tr>
				<td><input name="goodsdetail_price" class="easyui-textbox"
					style=" height: 30px; width: 200px" value=""
					data-options="multiline:true"></input></td>
			</tr>
		</table>
	</div>


	<script type="text/javascript">
		$(function() {
			/*树的显示  */
			$("#tt").tree({
				url : 'admin/getAllType.action',
				animate : true,
				loadFilter : function(data) {
					if (data.code == 1) {
						return data.rows;
					}
				},

			/* onClick : function(node) {
				$(this).tree('beginEdit', node.target);
			} */
			});

		})
	</script>
</body>
</html>