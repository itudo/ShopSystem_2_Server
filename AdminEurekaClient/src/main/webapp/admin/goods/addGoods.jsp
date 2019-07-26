<%@page import="java.util.List"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.w3c.dom.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="easyui-tabs" style="width: 100%; height: 100%" id="tt">
		<div title="填写商品信息1" style="padding: 10px" id="first">
			<div class="easyui-panel" title=" " fitColumns="true">
				<div style="padding: 10px 60px 160px 60px;">
					<form id="ff" method="post" enctype="multipart/form-data"
						style="margin: center; padding-left: 220px">
						<table cellpadding="15" width="1000px">


							<tr>
								<td>商品名称:</td>
								<td><input class="easyui-textbox" type="text"
									name="goods_name" data-options="required:true"
									style="width: 300px"></input></td>
							</tr>

							<tr>
								<td>商品销量:</td>
								<td><input class="easyui-textbox" type="text"
									name="goods_sale" style="width: 300px"
									data-options="required:true" value="0"></input></td>
							</tr>
							<tr>
								<td>新品1/0:</td>
								<td><input class="easyui-textbox" type="text"
									name="goods_isnew" style="width: 300px"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>商品详情:</td>
								<td><input class="easyui-textbox" name="goods_desc"
									data-options="multiline:true"
									style="height: 100px; width: 300px"></input></td>
							</tr>
							<tr>
								<td>商品分类:</td>
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
					<div style="padding-left: 380px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="submitForm()">下一步</a>&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="javascript:void(0)" class="easyui-linkbutton"
							onclick="clearForm()">清空</a>
					</div>
				</div>

			</div>

		</div>
		<!-- <div title="填写商品信息2" id="tabs2"></div>
		<div title="填写商品信息3"></div> -->
	</div>
	<script type="text/javascript">
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

		function submitForm() {
			var str = "";
			$('#tt')
					.tabs(
							'add',
							{
								title : '填写商品信息2',
								content : "<iframe width='100%'  height='100%' src='admin/goods/addGoodsDetail.jsp'   />",

							});
			$('#ff').form('submit');

			$
					.ajax({
						url : 'admin/addGoodsInfo.action',
						data : $("#ff").serialize(),
						method : 'post',
						dataType : 'json',
						success : function(data) {
							if (data.code != null) {

								$("#attribute").html(str);
								 
								alert("goods_id:" + data.code)
								$("#goods_id").value = data.code;
								for (var i = 0; i < data.obj.length; i++) {
									var attr = data.obj[i];
									// alert(attr.attrvalue.length)
									str += '<tr> <td>'
											+ attr.attribute_name
											+ ':</td>'
											+ ' <td><input class="easyui-combobox" type="text" name="attribute"  '
											 +' data-options="required:true">';

									for (var j = 0; j < attr.attrvalue.length; j++) {
										var value = attr.attrvalue[j];
										str += "<option value="+ value.attrvalue_id+">"
												+ value.attrvalue_value
												+ "</option>";
									}
									str += '</input></td> </tr>';
									 
								}
								$("#attribute").html(str);
								 
							}

						}

					})
		}
		function clearForm() {
			$('#ff').form('clear');
			$("#p").panel('close');
		}

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
	</script>
</body>
</html>