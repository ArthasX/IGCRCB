/**
 * 功能：页面加载完成时初始化必要信息，隐藏表格式表单
 * 配置：
 */
function IncidentLoad(){
	if(document.readyState == "complete"){
		if(getTableFormObj("告警信息#告警ID",1)){
			if(getTableFormObj("告警信息#告警ID",1).value.trim() == ""){
				getFormObj("告警信息").parentElement.parentElement.style.display = "none";
			}
		}
	}else{
		setTimeout("IncidentLoad()", 100);
	}
}
IncidentLoad();

/**
 * 功能：校验流程发生时间需要早于系统当前时间
 * 配置：发生时间表单调用js
 * */
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