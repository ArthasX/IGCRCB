function daifaqi(){
	
}

function biaodan1(obj){
	var t2 = obj.value
	 if(t2 =="是"){
		var t2 = getFormObj("表单2");
		var td = t2.parentElement.parentElement;
		td.style.display = "";
	}else{
		var t2 = getFormObj("表单2");
		var td = t2.parentElement.parentElement;
		td.style.display = "none";
	}
}
function biaodan2(obj) {
}

function setParentValue(userid, username,orgid,orgname,usermobile){
	alert("xxx");
	getTableFormObj("表格式#用户ID",1).value = userid;
	getTableFormObj("表格式#用户名称",1).value = username;
	getTableFormObj("表格式#电话",1).value = usermobile;	
}
function chang(){
	alert("xxx");
	var t1 = getTableFormObj("表格式#下拉",1).value;
	openSubWindow('/IGSYM0405.do' , 'newpage', '800', '600');
}






