function daifaqi(){
	
}

function biaodan1(obj){
	var t2 = obj.value
	 if(t2 =="��"){
		var t2 = getFormObj("��2");
		var td = t2.parentElement.parentElement;
		td.style.display = "";
	}else{
		var t2 = getFormObj("��2");
		var td = t2.parentElement.parentElement;
		td.style.display = "none";
	}
}
function biaodan2(obj) {
}

function setParentValue(userid, username,orgid,orgname,usermobile){
	alert("xxx");
	getTableFormObj("���ʽ#�û�ID",1).value = userid;
	getTableFormObj("���ʽ#�û�����",1).value = username;
	getTableFormObj("���ʽ#�绰",1).value = usermobile;	
}
function chang(){
	alert("xxx");
	var t1 = getTableFormObj("���ʽ#����",1).value;
	openSubWindow('/IGSYM0405.do' , 'newpage', '800', '600');
}






