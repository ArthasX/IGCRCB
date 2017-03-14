function print(obj){
	//var name = getForm.Obj("文本框");
	//alert(obj.value);
}
function xiala(obj){
	var xiala = getFormObj("下拉框");
	var text = getFormObj("文本框");
	if(xiala.value == '是'){
		text.parentNode.parentNode.style.display = '';
	}else{
		text.parentNode.parentNode.style.display = 'none';
	}
}
function show_1(){
	var xiala = getFormObj("下拉框");
	var text = getFormObj("文本框");
	if(xiala.value == '否' || xiala.value == ''){
		text.parentNode.parentNode.style.display = 'none';
	}
}
var rowId;
function _type(obj){
	openSubWindow('/IGSYM0405.do' , 'newpage', '800', '600');
	rowId = obj.rownumber;
}

function setParamRoleUser(userid, username, html, orgid, orgname, usermobile, tag){
	getTableFormObj("表格#用户ID",rowId).value=userid;
	getTableFormObj("表格#用户名",rowId).value=username;
	getTableFormObj("表格#电话",rowId).value=orgid;
}