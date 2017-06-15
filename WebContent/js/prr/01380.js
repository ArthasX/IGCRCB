// 校验流程发生时间需要早于系统当前时间
function checkOccurrence(obj){
	var D = new Date();
	var yy=D.getYear();
	var mm=D.getMonth()+1;
	var dd=D.getDate();
	var hours = D.getHours();
	var minute = D.getMinutes();
	if(mm < 10){
		mm = "0" + mm.toString();
	}
	if(dd < 10){
		dd = "0" + dd.toString();
	}
	if(hours < 10){
		hours = "0" + hours.toString();
	}
	if(minute < 10){
		minute = "0" + minute.toString();
	}
	var nowTime = yy + "/" + mm + "/" + dd + " " + hours + ":" + minute;//获取系统当前时间
	var selectDate = obj.value;
	if(selectDate > nowTime){
		obj.value="";
		alert("发生时间需要早于当前时间！");
		return false;
	}
	return true;
}

function initPeople(){
	var img = document.getElementById("img01");
	if(img==null||img==""){
		var type=getFormObj("报告人姓名").type;
		if(type=="text"){
		  var a ="<img id=\"img01\" src=\"images/seek.gif\" border=\"0\" style=\"cursor: pointer;\" onclick=\"searchuser();\" />";
		  jQuery("#pidid0138001002").after(a);
		  }
	}
}
function searchuser(){	
	openSubWindow('/IGSYM1904_Disp.do?', '_blank','1000','600','center:1');
}
function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile){
	document.getElementById("pidid0138001002").value = username;
	document.getElementById("pidid0138001003").value = orgname;
	document.getElementById("pidid0138001004").value = usermobile;
	document.getElementById("pidid0138001005").value = useremail;
}