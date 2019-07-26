$(function(){
	getHouseByPage(1,2);
});

function getHouseByPage(pages,pagesize){
	$.ajax({
		url:'house_list.action',
		type:'post',
		data:'pages=' + pages+ '&pagesize=' + pagesize,
		dataType:"html",
		success:function(data){
			$("#houseArea").html(data);
		}
	
	});
}

function add(){
	$.ajax({
		url:'toAdd.action',
		type:'post',
		dataType:"html",
		success:function(data){
			$("#houseArea").html(data);
		}
	
	});
}

function delHouse(id){
	$.ajax({
		url:'house_del.action',
		type:'post',
		data:'id=' + id,
		dataType:"json",
		success:function(data){
			if(data.code==1){
				alert("删除房屋信息成功");
				location.href='index.jsp';
			}else{
				alert("删除房屋信息失败");
			}
		}
	
	});
}

function update(id){
	$.ajax({
		url:'toUpdate.action',
		type:'post',
		data:'id=' + id,
		dataType:"html",
		success:function(data){
			$("#houseArea").html(data);
		}
	});
}
