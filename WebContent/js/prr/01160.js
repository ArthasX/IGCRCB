function print(obj){
	//var name = getForm.Obj("�ı���");
	//alert(obj.value);
}
function xiala(obj){
	var xiala = getFormObj("������");
	var text = getFormObj("�ı���");
	if(xiala.value == '��'){
		text.parentNode.parentNode.style.display = '';
	}else{
		text.parentNode.parentNode.style.display = 'none';
	}
}
function show_1(){
	var xiala = getFormObj("������");
	var text = getFormObj("�ı���");
	if(xiala.value == '��' || xiala.value == ''){
		text.parentNode.parentNode.style.display = 'none';
	}
}
var rowId;
function _type(obj){
	openSubWindow('/IGSYM0405.do' , 'newpage', '800', '600');
	rowId = obj.rownumber;
}

function setParamRoleUser(userid, username, html, orgid, orgname, usermobile, tag){
	getTableFormObj("���#�û�ID",rowId).value=userid;
	getTableFormObj("���#�û���",rowId).value=username;
	getTableFormObj("���#�绰",rowId).value=orgid;
}