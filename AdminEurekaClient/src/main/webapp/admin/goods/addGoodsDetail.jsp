<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
</head>
<body>
	<div class="easyui-panel" title="New Topic" style="width: 400px">
		<table id="tt" class="easyui-treegrid"
			style="width: 600px; height: 400px"
			data-options="url:'get_data.php',idField:'id',treeField:'name'">
			<thead>
				<tr>
					<th data-options="field:'name',width:180">Task Name</th>
					<th data-options="field:'persons',width:60,align:'right'">Persons</th>
					<th data-options="field:'begin',width:80">Begin Date</th>
					<th data-options="field:'end',width:80">End Date</th>
				</tr>
			</thead>
		</table>
	</div>

	<script type="text/javascript">
		
	</script>
</body>
</html>