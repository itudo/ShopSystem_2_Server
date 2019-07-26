var districts;

$(function() {
	$.post('houseType.action', function(data) {
		for (var i = 0; i < data.obj.length; i++) {
			$("#houseType_id").append( "<option value='" + data.obj[i].id + "'>" + data.obj[i].name + "</option>");
		}
	}, 'json');

	$.post('districtList.action', function(data) {
		districts = data.obj
		for (var i = 0; i < data.obj.length; i++) {
			$("#district_id").append( "<option value='" + data.obj[i].id + "'>" + data.obj[i].name + "</option>");
		}
		addStreet(0);
	}, 'json');
});

function onchangeDistrict(obj) {
	addStreet(obj.selectedIndex);
}

function addStreet(index) {
	var data = districts[index];
	$("#street_id").empty();
	for (var j = 0; j < data.streets.length; j++) {
		$("#street_id").append( "<option value='" + data.streets[j].id + "'>" + data.streets[j].name + "</option>");
	}
}

function addHouse(){
	$.ajax({
		url:"house_add.action",
		data:$("#House_add").serialize(),
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.code==1){
				alert("房屋发布成功");
				location.href="index.jsp";
			}else{
				alert(data.errorMsg);
			}
		}
	});
}
function updateHouse(){
	$.ajax({
		url:"house_update.action",
		data:$("#House_update").serialize(),
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.code==1){
				alert("房屋信息修改成功");
				location.href="index.jsp";
			}else{
				alert(data.errorMsg);
			}
		}
	});
}