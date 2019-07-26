<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<style type="text/css">
#p {
	display: inner;
	float: left;
	margin-left: 5px;
}

#p1 {
	display: inner; right;
	margin-left: 5px;
}
</style>
</head>
<body class="easyui-layout">


	<div id="p" class="easyui-panel" title="分类"
		style="width: 100%; height: 100%; padding: 10px; region: 'west'">
		<!-- 显示分类的树 -->
		<div
			style="float: left; width: 24%; height: 100%; overflow: scroll; border: solid gray 1px">

			<ul id="tt"></ul>
		</div>
		<!-- 显示商品信息的表格 -->
		<div id="p1" title="分类" style="width: 75%; height: 100%; float: right">

			<table class="easyui-datagrid" title="" id="dg"
				style="width: 100%; height: 100%; margin-right: 2px"
				data-options="singleSelect:true,toolbar:'#tb',onClickRow:onClickRow,collapsible:true,rownumbers:true,method:'get'">
				<thead>
					<tr>
						<th data-options="field:'goods_id',width:60">商品编号</th>
						<th data-options="field:'goods_name',width:130,editor:'textbox'">商品名称</th>
						<th
							data-options="field:'goods_desc',width:160,editor:'textbox',align:'center'">商品描述</th>
						<th
							data-options="field:'sale',width:80,align:'center',editor:'numberbox'">销量</th>
						<th
							data-options="field:'goods_pubtime',width:100,editor:'textbox'">发布日期</th>
						<th
							data-options="field:'goods_isnew',width:70,align:'center',editor:'numberbox'">是否新品1/0</th>
					</tr>
				</thead>
			</table>
			<!-- 表格工具栏 -->
			<div id="tb" style="height: auto">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-add',plain:true" onclick="append()">商品添加</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					data-options="iconCls:'icon-remove',plain:true"
					onclick="removeit()">删除</a> <a href="javascript:void(0)"
					class="easyui-linkbutton"
					data-options="iconCls:'icon-edit',plain:true"
					onclick="updateGoods()">修改</a>

			</div>
			<!--添加商品信息面板  -->
			<div id="addGoods" class="easyui-dialog" title="添加商品信息"
				style="width: 600px; height: 430px; text-align: center"
				data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
				<form id="ff" method="post"
					style="margin: center; padding-left: 50px">
					<table cellpadding="15">
						<tr>
							<td>商品名称：</td>
							<td><input class="easyui-textbox" type="text"
								name="goods_name" data-options="required:true"
								style="width: 300px"></input></td>
						</tr>
						<tr>
							<td>商品销量：</td>
							<td><input class="easyui-textbox" type="text"
								name="sale" style="width: 300px"
								data-options="required:true" value="0"> <br /></td>
						<tr>
							<td>新品1/0：</td>
							<td><input class="easyui-textbox" type="text"
								name="goods_isnew" style="width: 300px"
								data-options="required:true"></input> <br /></td>
						</tr>
						<tr>
							<td>商品详情：</td>
							<td><input class="easyui-textbox" name="goods_desc"
								data-options="multiline:true"
								style="height: 100px; width: 300px"></input> <br /></td>
						</tr>
						<tr>
							<td>商品分类：</td>
							<td><select class="easyui-combobox" name="firstType"
								id="firstType" style="width: 100px">
									<c:forEach items="${firstTypesList}" var="firstType">
										<option value="${firstType.firsttype_id }">${firstType.firsttype_name }</option>
									</c:forEach>
							</select> <input id="secondtype" class="easyui-combobox"
								name="secondtype_id" /> <input id="thirdtype"
								class="easyui-combobox" name="thirdtype_id" /></td>
						</tr>

					</table>
				</form>

				<div style="padding-left: 80px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitForm()">完成</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:void(0)" class="easyui-linkbutton"
						onclick="clearForm()">清空</a>
				</div>

			</div>
			<!-- 更新商品信息面板  -->
			<div id="updateGoods" class="easyui-dialog" title="修改商品信息"
				style="width: 600px; height: 420px; text-align: center"
				data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
				<table cellpadding="15" style="padding-left: 130px">
					<tr>
						<td><input type="hidden" id="goods_id" /></td>
					</tr>
					<tr>
						<td>商品名称：</td>
						<td><input type="text" id="goods_name" value=""
							style="width: 200px; height: 20px; border: solid gray 1px" /> <br />
							<br /></td>
					</tr>
					<tr>
						<td>商品详情：</td>
						<td><textarea rows="5" cols="30" id="goods_desc" value=""
								style="border: solid gray 1px"></textarea> <br /> <br /></td>
					</tr>
					<tr>
						<td>是否新品 1/0：</td>
						<td><input type="text" id="goods_isnew" value=""
							style="width: 200px; height: 20px; border: solid gray 1px" /> <br />
							<br /></td>
					</tr>
					<tr>
						<td>商品销量：</td>
						<td><input type="text" id="sale" value=""
							style="width: 200px; height: 20px; border: solid gray 1px" /> <br />
							<br /></td>
					</tr>
					<tr>
						<td></td>
						<td><div style="padding-left: 20px">
								<a href="javascript:void(0)" class="easyui-linkbutton"
									onclick="updateGoodsInfo()">确定修改</a>
							</div></td>
					</tr>
				</table>
			</div>
			<!-- 表格邮件菜单栏 -->
			<div id="mm" class="easyui-menu" style="width: 100px; display: none">
				<div iconCls="icon-add" onclick="addAttr()">添加属性</div>

			</div>
			<div id="mm1" class="easyui-menu" style="width: 100px; display: none">
				<div iconCls="icon-edit" onclick="editAttr()">修改属性</div>
				<div iconCls="icon-remove" onclick="deleteAttr()">删除属性</div>

			</div>
			<!--添加商品属性  -->
			<div id="addGoodsDetail" class="easyui-dialog" title="添加商品详情"
				style="width: 600px; height: 430px; text-align: center"
				data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
				<form id="addGoodsDetailForm"
					style="margin: center; padding-left: 150px">
					<table cellpadding="15">
						<tr>
							<td><input type="hidden" id="goodstype_id" /></td>
						</tr>

						<tr>
							<td><input type="hidden" id="goodsdetailId" /></td>
						</tr>
						<tr>
							<div id="attributeDiv" style="padding-right: 50px; width: 389"></div>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td><input name="goodsdetail_price" class="easyui-textbox"
								style="border: solid gray 1px; height: 30px; width: 200px"
								value="" data-options="multiline:true"></input></td>
						</tr>
						<tr>
							<td>商品数量：</td>
							<td><input name="goods_count" class="easyui-textbox"
								style="border: solid gray 1px; height: 30px; width: 200px"
								value="" data-options="multiline:true"></input></td>
						</tr>
						<tr>
							<td>选择图片：</td>
							<td><input class="easyui-filebox" style="width: 100%"
								name="image_name" data-options="prompt:'选择图片....'"></td>
						</tr>

					</table>
				</form>
				<div style="padding-left: 50px">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="addGoodsDetail()">完成</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="javascript:void(0)" class="easyui-linkbutton"
						onclick="clearGoodsDetailForm()">清空</a>
				</div>

			</div>
			<!--更新商品详情面板  -->
			<div id="updateGoodsDetail" class="easyui-dialog" title="修改商品详情"
				style="width: 600px; height: 420px; text-align: center"
				data-options="iconCls:'icon-add',resizable:true,modal:true,closed:true">
				<form id="updateGoodsDetailForm" method="post"
					enctype="multipart/form-data"
					style="margin: center; padding-left: 50px">
					<table cellpadding="15" style="padding-left: 130px">
						<tr>
							<td><input type="hidden" id="updategoods_id"
								name="updategoods_id" /></td>
						</tr>
						<tr>
							<td><input type="hidden" id="contact_id" name="contact_id" /></td>
						</tr>
						<tr>
							<td><input type="hidden" id="updategoodsdetail_id"
								name="updategoodsdetail_id" /></td>
						</tr>
						<tr>
							<div id="updateAttributeDiv" style="padding-left: 130px"></div>
						</tr>
						<tr>
							<td>商品价格：</td>
							<td><input type="text" name="goodsdetail_price"
								style="border: solid gray 1px; height: 30px; width: 200px"
								style="width: 300px" value=""></input></td>
						</tr>
						<tr>
							<td>商品数量：</td>
							<td><input type="text" name="goods_count"
								style="border: solid gray 1px; height: 30px; width: 200px"
								style="width: 300px" value=""></input></td>
						<tr>
							<td>选择图片：</td>
							<td><input class="easyui-filebox" style="width: 100%"
								name="image_name" data-options="prompt:'选择图片....'"></td>
						</tr>
						<tr>
							<td></td>
							<td><div style="padding-left: 20px">
									<a href="javascript:void(0)" class="easyui-linkbutton"
										onclick="updateGoodsDetailInfo()">确定修改</a>
								</div></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function() {
           /*树的显示  */   
			$("#tt").tree({
				url : 'admin/getAllType.action',
				loadFilter : function(data) {
					if (data.code == 1) {
						return data.rows;
					}
				}
			});

			$("#tt").tree({
				onClick : function(node) {
					var thirdid = -1 ;//取三级列表id
					if ($('#tt').tree('isLeaf', node.target)) {
						getTableData(node);
						$("#goodstype_id").val(node.id);
						thirdid = node.id ; 
					}
					$.ajax({
						url:'admin/getAttributeList.action?thirdtype_id='+thirdid,
						method:'post',
						dataType:'json',
						success:function(data){
							//显示属性列表
							var str = '';
							if(data.code==1){
								for(var i = 0; i < data.obj.length; i++){
									var attr = data.obj[i];
								 str += "<table cellpadding='15'><tr><td>"+attr.attribute_name+"：</td>"+
										"<td> <select style='border: solid gray 1px; height: 30px; width: 200px'"
											 +"name='attribute_value' style='width: 300px' value=''>";
											for(var j = 0 ; j < attr.attrvalue.length ; j++){
												var value = attr.attrvalue[j];
												str +="<option value='"+value.attrvalue_id+"'> "+value.attrvalue_value+"</option>" ;
											} 
											 str +="</select></td></tr></table>"; 
								}
								$("#updateAttributeDiv").html(str);
								$("#attributeDiv").html(str);
							}
						}
					})
				}
			}

			)
		})
		
		  var currentFatherRow = -1 ;//用于标记取到的父表格 的行索引
		  var currentChildRow = -1 ;//用于取到子表格的行索引
/* 树控制表格的显示 */
		function getTableData(node) {
			$('#dg').datagrid(
					{
						url : 'admin/getGoodsByThirdtype.action?thirdtype_id='
								+ node.id,
						method : 'get',
						dataType : 'json',
						pagination : true,
						pageSize : 100,
						pageList : [   100, 150, 200, 300 ],
						fiField : "goods_id",
						rownumbers : true,
						fit : true,
						nowrap : true,
						sortName : 'goods.goods_id',
						sortOrder : "desc",
						multiple : true,
						columns : [ [ {
							field : "goods_id",
							title : '商品编号',
							width : 60
						}, {
							field : "goods_name",
							title : '商品名称',
							width : 130
						}, {
							field : "goods_desc",
							title : '商品详情',
							width : 160,
							align : 'left'
						}, {
							field : "sale",
							title : '销量',
							width : 80,
							align : 'right'
						}, {
							field : "goods_pubtime",
							title : '发布日期',
							width : 100,
							align : 'center'
						}, {
							field : "goods_isnew",
							title : '是否新品',
							width : 70,
							align : 'center'
						} ] ],
						view : detailview,
						detailFormatter : function(index, row) {
							return '<div style="padding:3px"><table class="ddv" id="ddv-' + index + '"></table></div>';
						},
						onRowContextMenu: function (e, rowIndex, rowData) {     
							 $('#mm').menu('show', { left: e.pageX, top: e.pageY });
							 //alert(rowData.goods_id)
							 currentFatherRow = rowData.goods_id;
							  e.preventDefault();//则为屏蔽浏览器自带右键菜单。
							 
						},
						onExpandRow : function(index, row) {
							var ddv = $(this).datagrid('getRowDetail',
									index).find('table.ddv');
							//currentFatherRow = row.goods_id;
							ddv
									.datagrid({
										url : 'admin/getGoodsDetailByGoodsId.action?goods_id='
											+ row.goods_id,
									fitColumns : true,
									singleSelect : true,
									rownumbers : true,
									 
									pagination : true,
									sortName : 'goodsdetail_id',
									sortOrder : "desc",
									loadMsg : '',
									height : 'auto',
									columns : [ [ {
										field : 'goodsdetail_id',
										title : '详情编号',
										width : 60
									}, {
										field : 'attr_name',
										title : '属性',
										width : 120,
										align : 'center'
									}, {
										field : 'goods_count',
										title : '数量',
										width : 50
									}, {
										field : 'goodsdetail_price',
										title : '商品价格',
										width : 50
									} ,{
										field : 'image_path',
										title : '图片',
										width : 50,
										formatter:function(value,row,index){//使用formatter格式化刷子
											 if (row.images.length > 0){
												 if(row.images[0].image_path!= ''){
				                                        return  "<img style='width:24px;height:24px;' border='1' src='${basePath }/imgGoods/"
				                                        +row.images[0].image_path+"'/>" ;
												 } else{
				                                        return '';
				                                  }

											 }else {
				                                    return '';
				                             }


											 return ' ';
											 
										 }

									} , {
										field : 'contactStr',
										title : '关系编号',
										width : 50,
									} ] ],
									onResize : function() {
										$('#dg').datagrid(
												'fixDetailRowHeight',
												index);
									},
									onLoadSuccess : function(data) {
										$("#goodstype_id").val(data.code);
										 
										setTimeout(
												function() {
													$('#dg')
															.datagrid(
																	'fixDetailRowHeight',
																	index);
												}, 0);
									} ,
									onRowContextMenu: function (e, rowIndex, rowData) {     
										 $('#mm1').menu('show', { left: e.pageX, top: e.pageY });
										  e.preventDefault();//则为屏蔽浏览器自带右键菜单。
										  currentChildRow=rowData.goodsdetail_id;//取到当前点击的行id
										  $("#contact_id").val(rowData.contactStr)
										 
									}, 
									
									});
									$('#dg').datagrid('fixDetailRowHeight', index);
						}
					})
		}

		/* 表格工具栏的操作 */
		var editIndex = undefined;
		
		
		function endEditing() {
			if (editIndex == undefined) {
				return true;
			}
			if ($('#dg').datagrid('validateRow', editIndex)) {
				var ed = $('#dg').datagrid('getEditor',  editIndex);
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		
		
		/* 更新表格信息  */
		
		 //显示修改对话框
		function updateGoods(){
		//选取要修改的数据
		var rows=$("#dg").datagrid('getChecked');
		//判断有没有选择要修改的数据
		if(rows.length<=0){ //说明用户没有选择数据
			$.messager.show({
				title:'错误提示',
				msg:'请选择您要修改的数据...',
				timeout:2000,
				showType:'slide'
			});
			return;
		}
		//如果商品有选择数据，则选取用户选定的第一条要修改的数据，并将其原值显示在对话框中
		var goods_id=rows[0].goods_id;
		var goods_name=rows[0].goods_name;
		var goods_desc=rows[0].goods_desc;
		var goods_isnew=rows[0].goods_isnew;
		var sale=rows[0].sale;
		$("#goods_id").val(goods_id);
		$("#goods_name").val(goods_name);
		$("#goods_desc").val(goods_desc);
		$("#goods_isnew").val(goods_isnew);
		$("#sale").val(sale);
		$("#updateGoods").dialog('open');
		} 
		
		function  updateGoodsInfo(){
			 //修改
			var goods_id=$.trim( $("#goods_id").val() );
			var goods_name=$.trim( $("#goods_name").val() );
			var goods_desc=$.trim( $("#goods_desc").val() );
			var sale=$.trim( $("#sale").val() );
			var goods_isnew=$.trim( $("#goods_isnew").val() );
			if(goods_name =="" || goods_desc == "" || sale =="" ){
			return;
			}else if(goods_isnew==""  ){
			return;
			}else{
			$.post("admin/updateGoodsInfo.action",{'goods_id':goods_id,'goods_name':goods_name,'goods_desc':goods_desc,'goods_isnew':goods_isnew,'sale':sale},function(data){
			//alert(data.code)
			 
			if(data.code ==1){
			$.messager.show({
			title:'成功提示',
			msg:'商品信息修改成功....',
			timeout:2000,
			showType:'slide'
			});
			//关闭添加信息窗口
			$("#updateGoods").dialog('close');
			//刷新数据
			$("#dg").datagrid('load',{});
			}else{
			$.messager.alert('失败提示','商品信息修改失败...','error');
			$("#dg").datagrid('load',{});
			}
			});
			}
			 
		}
		
	 
		 /* 单击表格 操作 */
		function onClickRow(rowIndex, field, value) {
			if (editIndex != rowIndex){
				if (endEditing()){
					$('#dg').datagrid('selectRow', rowIndex)
							.datagrid('beginEdit', rowIndex);
					editIndex = rowIndex;
					 
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
				 
		}
		/* 添加商品信息*/
		function append() {
			$("#goods_name").val("");
			$("#goods_desc").val("");
			$("#addGoods").dialog('open'); 
		}
		
		/* 删除商品信息 */
		function removeit() {
			if (editIndex == undefined) {
				return
			}
			var rows = $("#dg").datagrid('getChecked'); //选取要删除的数据
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
								msg : '商品信息删除成功...',
								timeout : 2000,
								showType : 'slide'
							});
							//刷新数据
							$("#dg").datagrid('load', {});
						} else {
							$.messager.alert('失败提示', '商品信息删除失败...', 'error');
							$("#dg").datagrid('load', {});
						}
					});
				} else {
					return;
				}
			}); 
			editIndex = undefined;
		}
		
		/* 添加商品时的分类悬着操作  */
		$("#firstType")
		.combobox(
				{
					onSelect : function(record) {
						var firsttype_id = $('#firstType').combobox(
								'getValue');
						$
								.ajax({
									url : "admin/getSecondType.action",
									data : "firsttype_id="
											+ firsttype_id,
									dataType : "json",
									success : function(data) {
										var str = " ";
										if (data.code == 1) {

											/* $("#secondtype").combobox("loadData",data);   */
											$("#secondtype").html(str);
											$('#secondtype').combobox({
												textField : str
											});
											for (var i = 0; i < data.obj.length; i++) {
												var secondtype = data.obj[i];
												str += "<option value="+ secondtype.secondtype_id+">"
														+ secondtype.secondtype_name
														+ "</option>";
											}
											$("#secondtype").html(str);
											$('#secondtype').combobox({
												textField : str
											});
										}
									}
								});
					}
				});
/* 添加商品时的提交操作 */
function submitForm() {
	$('#ff').form('submit');
	
	var form = new FormData(document.getElementById("ff"));
	$
			.ajax({
				url : 'admin/addGoodsInfo.action',
				data : form,
				method : 'post',
				dataType : 'json',
				processData:false,
	            contentType:false,
				success : function(data) {
					if (data.code == 1) {
						$.messager.show({
							title:'成功提示',
							msg:'商品信息添加成功...',
							timeout:2000,
							showType:'slide'
							});	 
						$("#addGoods").dialog('close'); 
						$("#dg").datagrid('reload' );
						$('#ff').form('clear');
						 
					}

				}

			})
}
function clearForm() {
	$('#ff').form('clear');
	 
}
/* 二级表 查找三级表 */
$("#secondtype")
		.combobox(
				{
					onChange : function(newValue, oldValue) {
						$
								.ajax({
									url : "admin/getThirdTypeBySecondId.action",
									data : 'secondtype_id=' + newValue,
									dataType : 'json',
									method : 'get',
									success : function(data) {
										var str = " ";
										if (data.code == 1) {

											$("#thirdtype").html(str);
											$('#thirdtype').combobox({
												textField : str
											});
											for (var i = 0; i < data.obj.length; i++) {
												var thirdtype = data.obj[i];
												str += "<option value="+ thirdtype.thirdtype_id+">"
														+ thirdtype.thirdtype_name
														+ "</option>";
											}
											$("#thirdtype").html(str);
											$('#thirdtype').combobox({
												textField : str
											});
										}
									}
								})

					}
				})
/* 查找商品类型对象的属性  并打开 添加属性的面板  */
				function addAttr(){
	               var secondtype_id =  $.trim( $("#goodstype_id").val() );
	               $("#addGoodsDetail").dialog('open'); 
				}
				 
function addGoodsDetail(){
	var form = new FormData(document.getElementById("addGoodsDetailForm"));
	 $.ajax({
		 url:'admin/addGoodsDtail.action?goods_id=' + currentFatherRow ,
	     dataType:'json',
	     method:'post',
	     data:form,
	     processData:false,
         contentType:false,  
	     success:function(data){
	    	 if(data.code==1){
	    			 $.messager.show({
						title:'成功提示',
						msg:'商品详情添加成功...', 
						timeout:2000,
						showType:'slide'
						});	 
					$("#addGoodsDetail").dialog('close'); 
					$("#dg").datagrid('load', {});
					$('#addGoodsDetailForm').form('clear');
	    	 }
	     }
	 })
}		

	function editAttr(){
		 $("#updateGoodsDetail").dialog('open'); 
		 
	}
	
	function updateGoodsDetailInfo(){
		$("#updategoods_id").val(currentFatherRow);
		$("#updategoodsdetail_id").val(currentChildRow);
		/* //$('#updateGoodsDetailForm').form('submit'); */
		var form = new FormData(document.getElementById("updateGoodsDetailForm"));
		$.ajax({
			url: "admin/updateGoodsDetail.action",
			method:'post',
			data:form,
			processData:false,
	        contentType:false,  
		    success:function(data){
		    	 if(data.code==1){
		    			 $.messager.show({
							title:'成功提示',
							msg:'商品详情修改成功...', 
							timeout:2000,
							showType:'slide'
							});	 
						$("#updateGoodsDetail").dialog('close'); 
						$("#dg").datagrid('load', {});
						$('#updateGoodsDetailForm').form('clear');
		    	 }
		     }
			
		})
	}
	
	function deleteAttr(){
		//判断有没有选择要删除的数据
		if (currentChildRow <= 0) { //说明用户没有选择数据
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
				$.post("admin/delGoodsDetailInfo.action", {
					goodsdetail_id : currentChildRow
				}, function(data) {
					if (data.code == 1) {
						$.messager.show({
							title : '成功提示',
							msg : '商品信息删除成功...',
							timeout : 2000,
							showType : 'slide'
						});
						//刷新数据
						$("#dg").datagrid('load', {});
					} else {
						$.messager.alert('失败提示', '商品信息删除失败...', 'error');
						$("#dg").datagrid('load', {});
					}
				});
			} else {
				return;
			}
		});
	}
	
	
	

</script>
</body>

</html>