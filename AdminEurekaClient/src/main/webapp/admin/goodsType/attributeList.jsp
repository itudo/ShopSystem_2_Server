<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</head>
</head>
<body class="easyui-layout">

	<table id="dg" style="width: 100%; height: 500px" singleSelect="true"
		fitColumns="true" toolbar="#tb">
		<thead>
			<tr>
				<th field="attribute_id" width="80" id="attribute_id">属性编号</th>
				<th field="attribute_name" width="100" id="attribute_name">属性值</th>

			</tr>
		</thead>
	</table>
	
	<div id="tb">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true"
			onclick="javascript:alert('Add')">修改</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-add" plain="true"
			onclick="javascript:alert('Cut')">添加</a><a href="#"
			class="easyui-linkbutton" iconCls="icon-remove" plain="true"
			onclick="javascript:alert('Remove')">删除</a> <a href="#"
			class="easyui-linkbutton" iconCls="icon-save" plain="true"
			onclick="javascript:alert('Save')">保存</a>
	</div>

	<script type="text/javascript">
		$('#dg')
				.datagrid(
						{
							url : 'admin/getAllAttribute.action',
							pageSize : 20,
							pagination : true,
							rownumbers : true,
							sortName : 'attribute_id',
							sortOrder : "desc",
							nowrap : true,
							view : detailview,
							columns : [ [ {
								field : "attribute_id",
								title : '属性编号',
								width : 100
							}, {
								field : "attribute_name",
								title : '属性名',
								width : 100,
								align : 'left'
							} ] ],
							detailFormatter : function(index, row) {
								return '<div style="padding:2px"><table class="ddv"></table></div>';
							},
							onExpandRow : function(index, row) {
								var ddv = $(this).datagrid('getRowDetail',
										index).find('table.ddv');
								ddv
										.datagrid({
											url : 'admin/getAttrvalue.action?attribute_id='
													+ row.attribute_id,
											fitColumns : true,
											singleSelect : true,
											rownumbers : true,
											pagination : true,
											sortName : 'attribute_id',
											sortOrder : "desc",
											loadMsg : '',
											height : 'auto',
											columns : [ [ {
												field : 'attrvalue_id',
												title : '属性值编号',
												width : 100
											}, {
												field : 'attrvalue_value',
												title : '属性值',
												width : 100
											}  ] ],
											onResize : function() {
												$('#dg').datagrid(
														'fixDetailRowHeight',
														index);
											},
											onLoadSuccess : function() {
												setTimeout(
														function() {
															$('#dg')
																	.datagrid(
																			'fixDetailRowHeight',
																			index);
														}, 0);
											}
										});
								$('#dg').datagrid('fixDetailRowHeight', index);
							}
						});
	</script>
</body>
</html>