<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>
<style>
	a:hover {color: red}  
</style>
<script type="text/javascript">

function doSearch(value, name) {
	//alert('You input: ' + value + '(' + name + ')');
	var url = 'admin/showOrder.action'; //定义URL根据 搜索关键字的变化而改变
	var orderby = 'order_id';//当搜索关键字为销量时  使排序方式以 goods_sale 

	if (name == 'order_id') {
		url += '?' + name + "=" + value;
		//alert(url);
	} else if (name == 'order_status') {
		 if(value=="待付款"){
			value = 0;
		}else if(value=="待发货"){
			value = 1;
		}else if(value=="待收货"){
			value = 2;
		}else if(value=="待评价"){
			value = 3;
		} else if(value=="已完成"){
			value = 4;
		}  
		url += '?' + name + "=" + value;
	} else if (name == 'order_time') {
		url += '?' + name + "=" + value;
		//alert(url);
	} 

	$('#dg').datagrid({/*   信息的表格 */
		url : url,
		pagination : true,
		pageSize : 20,
		pageList : [ 20, 50, 100, 150, 200, 300 ],
		fiField : "order_id",
		rownumbers : true,
		fit : true,
		nowrap : true,
		sortName : orderby,
		sortOrder : "desc",
		singleselect : false,
	});
}
function updateStatus(value){
	$.ajax({
		url:'admin/updateOrderStatus.action?order_id='+value,
		dataType:'JSON',
		type:'POST',
		success:function(data){
			if(data.code==1){
				$.messager.show({
					title : '成功提示',
					msg : '商品发货成功...',
					timeout : 2000,
					showType : 'slide'
				});
				$('#dg').datagrid('load',{});//表格刷新
			}else{
				$.messager.alert('失败提示', '商品发货失败...', 'error');
			}
		},
		error:function(){
			$.messager.alert('失败提示', '商品发货失败...', 'error');
		}
	})
	
	}
	function mulUpdateStatus(){
 		$.messager.confirm("确认提示", "数据一旦修改，将不能恢复，您确定要修改选定数据吗?", function(rt) {
			if (rt) {
				var rows = $('#dg').datagrid('getSelections');
				var orderIdList = "";
				for (var i = 0; i < rows.length - 1; i++) {
					if(rows[i].order_status==1){
						orderIdList += rows[i].order_id + ",";
					}
				}
				if(rows[i].order_status==1){
					orderIdList += rows[i].order_id;
				}
				$.post("admin/mulUpdateStatus.action", {
					order_ids : orderIdList
				}, function(data) {
					if (data.code == 1) {
						$.messager.show({
							title : '成功提示',
							msg : '商品发货成功...',
							timeout : 2000,
							showType : 'slide'
						});
						//刷新数据
						$("#dg").datagrid('load', {});
					} else {
						$.messager.alert('失败提示', '商品发货失败...', 'error');
						$("#dg").datagrid('load', {});
					}
				});
			} else {
				return;
			}
		}); 
	}
	function mulDelOrder(){
 		$.messager.confirm("确认提示", "数据一旦删除，将不能恢复，您确定要删除选定数据吗?", function(rt) {
			if (rt) {
				var rows = $('#dg').datagrid('getSelections');
				var orderIdList = "";
				for (var i = 0; i < rows.length - 1; i++) {
						orderIdList += rows[i].order_id + ",";
				}
				orderIdList += rows[i].order_id;
				$.post("admin/mulDelOrder.action", {
					order_ids : orderIdList
				}, function(data) {
					if (data.code == 1) {
						$.messager.show({
							title : '成功提示',
							msg : '订单删除成功...',
							timeout : 2000,
							showType : 'slide'
						});
						//刷新数据
						$("#dg").datagrid('load', {});
					} else {
						$.messager.alert('失败提示', '订单删除失败...', 'error');
						$("#dg").datagrid('load', {});
					}
				});
			} else {
				return;
			}
		}); 
	}
	$(function() {

		$('#dg').datagrid(
				{/*   信息的表格 */
					url : 'admin/showOrder.action',
					pagination : true,
					pageSize : 20,
					pageList : [ 20, 50, 100, 150, 200, 300 ],
					idField : "order_id",
					rownumbers : true,
					fit : true,
					nowrap : true,
					sortName : 'order_id',
					sortOrder : "desc",
					singleselect : false,
					fitColumns : "true",
					striped : true,
					checkOnSelect : 'true',
					columns : [ [{
		                field : 'ck',
		                checkbox : true,
		                
		            },{
						field : "order_id",
						title : '订单编号',
						width : 150,
					}, {
						field : "to_userName",
						title : '收货人姓名',
						width : 100
					}, {
						field : "to_addr",
						title : '收货地址',
						width : 100,
						align : 'right'
					}, {
						field : "to_tel",
						title : '收货人电话',
						width : 100,
						align : 'right'
					}, {
						field : "order_status",
						title : '订单状态',
						width : 100,
						align : 'right',
						formatter: function(value,row,index){
                             
                            if(row.order_status == 0){
                                     return "<p style='color:red;'>待付款</p>";
						 	}else if(row.order_status == 1){
                                     return "<a style='color:orange;' href='javascript:void(0);' onclick='updateStatus("+row.order_id+")'>待发货</a>";
						 	}else if(row.order_status == 2){
                                     return "<p style='color:green;'>待收货</p>";
						 	}else if(row.order_status == 3){
                                return "<p style='color:blue;'>待评价</p>";
					 		}else if(row.order_status == 4){
                                return "已完成";
					 		}else{
                                     return "";
                            }
                        }
					}, {
						field : "order_totalmoney",
						title : '订单金额',
						width : 100,
						align : 'right'
					},{
						field : "order_time",
						title : '下单日期',
						width : 100,
						align : 'right'
					}] ],
					view: detailview,
					detailFormatter: function(rowIndex, rowData){
		                return '<div style="padding:2px"><table id="ddv-' + rowIndex + '"></table></div>';
					},
					//rowIndex:选中的行号 row：选中行的数据
	            onExpandRow:function(rowIndex,row){//注意3
	                $('#ddv-'+rowIndex).datagrid({
	                    url:'admin/showOrderDetail.action?order_id='+row.order_id,
	                    fitColumns:true,
	                    singleSelect:true,
	                    height:'auto',
	                    columns:[[
	                        {field:'orderdetail_id',title:'订单详情编号'},
	                        {field:'goods_name',title:'商品名称',
	                            formatter: function(value,row,index){
	                                if (row.goodsDetail.goods){
	                                    if(row.goodsDetail.goods.goods_name != '')
	                                        return row.goodsDetail.goods.goods_name;
	                                    else{
	                                        return '';
	                                    }
	                                } else {
	                                    return '';
	                                }
	                           }
	                        },
	                       
	                        {field:'goods_count',title:'所购商品数量'},
	                        {field:'goods_buyprice',title:'总价钱'},
	                        {field:'goodsDetail.goods.goods_pubtime',title:'商品发布时间',
	                        	formatter: function(value,row,index){
	                                if (row.goodsDetail.goods){
	                                    if(row.goodsDetail.goods.goods_pubtime != '')
	                                        return row.goodsDetail.goods.goods_pubtime;
	                                    else{
	                                        return '';
	                                    }
	                                } else {
	                                    return '';
	                                }
	                           }
	                        
	                        },
	                        {field:'goods_desc',title:'商品详情',width:50,
	                            formatter: function(value,row,index){
	                                if (row.goodsDetail.goods){
	                                    if(row.goodsDetail.goods.goods_desc != '')
	                                        return row.goodsDetail.goods.goods_desc;
	                                    else{
	                                        return '';
	                                    }
	                                } else {
	                                    return '';
	                                }
	                           }
	                        }
	                        ]]
					});
	            }
	});
});
</script>
<body class="easyui-layout">

	<div data-options="region:'center',title:'',iconCls:'icon-ok'  "
		style="width: 100%; height: 70%;">
		<input class="easyui-searchbox"
			data-options="prompt:'Please Input Value(时间格式：2018-8-23)',menu:'#mm',searcher:doSearch"
			style="width: 400px"></input>
			<div id="tb" style="height: auto">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true"
				onclick="mulDelOrder()">删除</a>
			<a href="javascript:void(0)"
				class="easyui-linkbutton"
				data-options="iconCls:'icon-edit',plain:true"
				onclick="mulUpdateStatus()">发货</a>
		</div>
			<!-- <input type="button" onclick="mulDelOrder()" value="删除">
			<input type="button" onclick="mulUpdateStatus()" value="发货"> -->
		<div id="mm">
			<div data-options="name:'all',iconCls:'icon-ok'">所有</div>
			<div data-options="name:'order_id'">订单号</div>
			<div data-options="name:'order_status' ">订单状态</div>
			<div data-options="name:'order_time'">下单日期</div>
			<!-- <div data-options="name:'startPubtime'">发布时间</div> -->
		</div>
		<br />
		<hr>
		<table>
				 <div id="dg" style="width:650px;height:250px"></div> 
		</table>
		 
	</div>
</body>
</html>