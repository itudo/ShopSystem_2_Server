<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</head>
<script type="text/javascript">
	var editFlag = undefined;

	function doSearch(value, name) {
		//alert('You input: ' + value + '(' + name + ')');
		var url = 'admin/searchGoods.action'; //定义URL根据 搜索关键字的变化而改变
		var orderby = 'goods_id';//当搜索关键字为销量时  使排序方式以 sale 

		if (name == 'goods_name') {
			url += '?' + name + "=" + value;
			//alert(url);
		} else if (name == 'sale') {
			url += '?' + name + "=" + value;
			orderby = 'sale';
		} else if (name == 'goods_isnew') {
			url += '?' + name + "=" + value;
		} else if (name == 'startPubtime') {
			url += '?' + name + "=" + value;
		} else {
			url += '';
		}

		$('#resfoodListTable').datagrid({/*   信息的表格 */
			url : url,
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 50, 100, 150, 200, 300 ],
			fiField : "goods_id",
			rownumbers : true,
			fit : true,
			nowrap : true,
			sortName : orderby,
			sortOrder : "desc",
			singleselect : true,
		})

	}

	$(function() {

		$('#resfoodListTable').datagrid(
				{/*   信息的表格 */
					url : 'admin/getAllGoods.action',
					pagination : true,
					pageSize : 20,
					pageList : [ 20, 50, 100, 150, 200, 300 ],
					fiField : "goods_id",
					rownumbers : true,
					fit : true,
					nowrap : true,
					sortName : 'goods_id',
					sortOrder : "desc",
					multiple : true,
					columns : [ [ {
						field : "goods_id",
						title : '商品编号',
						width : 100
					}, {
						field : "goods_name",
						title : '商品名称',
						width : 100
					}, {
						field : "goods_desc",
						title : '商品详情',
						width : 100,
						align : 'right'
					}, {
						field : "sale",
						title : '销量',
						width : 100,
						align : 'right'
					}, {
						field : "goods_pubtime",
						title : '发布日期',
						width : 100,
						align : 'right'
					}, {
						field : "goods_isnew",
						title : '是否新品',
						width : 100,
						align : 'right'
					} ] ],
					toolbar : [

							{
								text : "修改",
								iconCls : 'icon-edit',
								handler : function() {
									var rows = $('#resfoodListTable').datagrid(
											'getSelections');//选中一行进行编辑   得到选中的行 
									if (rows.length == 1) {
										//选中这一行 的话  触发该事件 
										//如果当前  的状态已经是  编辑状态时  退出编辑状态  
										if (editFlag != undefined) {
											$('#resfoodListTable').datagrid(
													'endEdit', editFlag);//结束编辑   传入之间  编辑的行 
										}

										if (editFlag == undefined) {

											var index = $("#resfoodListTable")
													.datagrid('getRowIndex',
															rows[0]);
											$("#resfoodListTable").datagrid(
													'beginEdit', index);
											editFlag = index;
										}
									}

								}
							},
							'-',
							{
								text : "保存",
								iconCls : 'icon-save',
								handler : function() {
									$('#resfoodListTable').datagrid('endEdit',
											editFlag);//会触发  onAfterEdit事件 在那里会更新 代码 
								}
							},
							'-',
							{
								text : "撤销",
								iconCls : 'icon-redo',
								handler : function() {
									editFlag = undefined;
									$('#resfoodListTable').datagrid(
											'rejectChanges');//会触发  onAfterEdit事件 在那里会更新 代码 
								}
							}, '-', {
								text : "删除",
								iconCls : 'icon-remove',
								handler : function() {
									delCustomer();
								}
							}, '-' ],
					columns : [ [

					{
						field : 'goods_id',
						title : '商品编号',
						checkbox : true,
						multiple : true,
						width : 100,
						sortable : true
					}, {
						field : 'goods_name',
						title : '商品名称',
						width : 200,
						editor : { //设置其为可编辑
							type : 'validatebox', //设置可编辑格式
							options : {
								required : true
							}
						//设置编辑格式
						}
					}, {
						field : 'goods_desc',
						title : '商品详情',
						width : 240,
						align : 'left',
						editor : { //设置其为可编辑
							type : 'validatebox', //设置可编辑格式
							options : {
								required : true
							}
						//设置编辑格式
						}
					}, {
						field : 'sale',
						title : '商品销量',
						width : 100,
						align : 'center',

					}, {
						field : 'goods_pubtime',
						title : '发布时间',
						width : 100,
						align : 'center',
						editor : { //设置其为可编辑
							type : 'validatebox', //设置可编辑格式
							options : {
								required : true
							}
						//设置编辑格式
						}
					}, {
						field : 'goods_isnew',
						title : '新品',
						width : 30,
						align : 'center',
						editor : { //设置其为可编辑
							type : 'validatebox', //设置可编辑格式
							options : {
								required : true
							}
						//设置编辑格式
						}
					} ] ],
					//当点击结束编辑时，会自动发出onAfterEdit事件  则这个事件处理代码被激活
					onAfterEdit : function(rowIndex, rowData, changes) {
						//在添加完endEdit后  保存时触发
						//
						editFlag = undefined; //重置
						//发请求
						$.ajax({
							url : 'admin/updateGoodsInfo.action',
							data : rowData,
							type : 'POST',
							complete : function(data) {
								if (data.code == 1) {
									alert("更新成功");
									$.messager.alter("提示", "成功", "info")
								}
							}
						});
					},
					onDblclickCell : function(rowIndex, field, value) {
						if (editFlag != undefined) {
							$("#resfoodListTable")
									.datagrid('endEdit', editFlag);
						}

						if (editFlag == undefined) {
							$("#resfoodListTable").datagrid('beginEdit',
									rowIndex);
							editFlag = rowIndex;
						}
					}

				});
	});

	function delCustomer() {
		var rows = $("#resfoodListTable").datagrid('getChecked'); //选取要删除的数据
		//判断有没有选择要删除的数据
		if (rows.length <= 0) { //说明用户没有选择数据
			$.messager.show({
				title : '错误提示',
				msg : '请选择您要删除的数据...',
				timeout : 2000,
				showType : 'slide'
			});
			return;
		}
		//如果用户有选择数据，警告用户小心操作
		$.messager.confirm("确认提示", "数据一旦删除，将不能恢复，您确定要删除选定数据吗?", function(rt) {
			if (rt) {
				//获取用户选中的所有数据的id in(1001,1002)
				var cid = "";
				for (var i = 0; i < rows.length - 1; i++) {
					cid += rows[i].goods_id + ",";
				}
				cid += rows[i].goods_id;
				$.post("admin/delGoodsInfo.action", {
					goods_id : cid
				}, function(data) {
					if (data.code == 1) {
						$.messager.show({
							title : '成功提示',
							msg : '用户信息删除成功...',
							timeout : 2000,
							showType : 'slide'
						});
						//刷新数据
						$("#resfoodListTable").datagrid('load', {});
					} else {
						$.messager.alert('失败提示', '用户信息删除失败...', 'error');
						$("#resfoodListTable").datagrid('load', {});
					}
				});
			} else {
				return;
			}
		});
	}
</script>
<body class="easyui-layout">

	<div data-options="region:'center',title:'',iconCls:'icon-ok'  "
		style="width: 100%; height: 70%;">

		<p></p>
		<input class="easyui-searchbox"
			data-options="prompt:'Please Input Value(时间格式：2018-8-23)',menu:'#mm',searcher:doSearch"
			style="width: 400px"></input>
		<div id="mm">
			<div data-options="name:'all',iconCls:'icon-ok'">所有</div>
			<div data-options="name:'goods_name' ">商品名称</div>
			<div data-options="name:'sale'">商品销量</div>
			<div data-options="name:'goods_isnew'">新品</div>
			<div data-options="name:'startPubtime'">发布时间</div>
		</div>
		<br />
		<hr>
		<table id="resfoodListTable" title="选择修改商品"
			data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json' ">
		</table>


	</div>
	<script>
		
	</script>
</body>
</html>