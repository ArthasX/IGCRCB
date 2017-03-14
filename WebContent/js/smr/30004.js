/*
 * 报表：T-A-5 数据中心变更报告表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];
var label_starttime = "计划变更开始时间";
var label_endtime = "计划变更结束时间";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
}

/*
* 功能：开始和结束时间前后校验
* 配置：计划变更开始时间
*/
function checkStartTime(obj){
	var obj_endtime=getFormObj(label_endtime);
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("变更开始时间应在变更结束时间之前，请重新输入！");
		obj.focus();
	}
}

/*
* 功能：开始和结束时间前后校验
* 配置：计划变更结束时间
*/
function checkEndTime(obj){
	var obj_starttime=getFormObj(label_starttime);
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("变更结束时间应在变更起始时间之后，请重新输入！");
		obj.focus();
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_starttime=getFormObj(label_starttime);
	var obj_endtime=getFormObj(label_endtime);
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "变更开始时间应在变更结束时间之前，请重新输入！\n";
		isValid = false;
	}
	
	if (!isValid && a > "") {
		for(var i=0 ;i<errorObjs.length;i++) {
			if (errorObjs[i].outerHTML.indexOf("TD") > -1) {
				errorObjs[i].style.color="red";
			} else {
				errorObjs[i].style.backgroundColor="red";
			}
		}
		alert(a);
		a = "";
		isValid = true;
		return false;
	}
	return isValid;
}