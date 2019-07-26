<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
</head>
<body>
<body class="easyui-layout">
	<%@ include file="../centerTop.jsp"%>
	<table id="dg" style="width: 700px; height: 250px" url=" " title=""
		singleSelect="true" fitColumns="true">
		<thead>
			<tr>
				<th field="goods_id" width="80">商品编号</th>
				<th field="goods_name" width="100">商品名称</th>
				<th field="goods_sale" width="100">销量</th>

				<th field="goods_price" width="100">价格</th>
				<th field="goods_pubtime" width="100">发布时间</th>
			</tr>
		</thead>
		<tbody>


		</tbody>
	</table>
	<script type="text/javascript">
		$('#dg').datagrid({
			url : 'admin/goodsOrderBySale.action',
			pagination : true,
			pageSize : 20,
			pageList : [ 20, 50, 100, 150, 200, 300 ],
			fiField : "goods_id",
			rownumbers : true,
			fit : true,
			nowrap : true,
			sortName : "goods_sale",
			sortOrder : "desc",
			singleselect : true,
			columns : [ [ {
				field : "goods_id",
				title : '商品编号',
				width : 100
			}, {
				field : "goods_name",
				title : '商品名称',
				width : 100
			}, {
				field : "goods_sale",
				title : '销量',
				width : 100,
				align : 'right'
			}, {
				field : "goods_pubtime",
				title : '发布日期',
				width : 100,
				align : 'right'
			}

			] ],
		})
	</script>
</body>
</html>