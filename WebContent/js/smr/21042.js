/*
 * 报表：2014-T-Q-03 部分重要信息系统运行情况表 
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN01 = "部分重要信息系统#组模式#系统类型#系统类型";
var label_YN05_04 = "部分重要信息系统#组模式#预期停止服务#内容#影响范围#分支机构数";
var label_YN01_01 = "部分重要信息系统#组模式#非预期停止服务#内容#停止服务原因";
var label_YN01_02 = "部分重要信息系统#组模式#非预期停止服务#内容#事件等级";
var label_YN01_03_01 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#起始时间#起始时间";
var label_YN01_03_02 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#起始时间#时";
var label_YN01_03_03 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#起始时间#分";
var label_YN01_04_01 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#结束时间#结束时间";
var label_YN01_04_02 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#结束时间#时";
var label_YN01_04_03 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#结束时间#分";
var label_YN01_05_01 = "部分重要信息系统#组模式#非预期停止服务#内容#业务中断的起止时间#中断时间共#中断时间共";
var label_YN01_04 = "部分重要信息系统#组模式#非预期停止服务#内容#影响范围#影响范围";
var label_YN04_04 = "部分重要信息系统#组模式#非预期停止服务#内容#影响范围#分支机构";
var label_YN01_06 = "部分重要信息系统#组模式#非预期停止服务#内容#概述";

var label_YN02_01 = "部分重要信息系统#组模式#预期停止服务#内容#停止服务原因";
var label_YN02_03_01 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#起始时间#起始时间";
var label_YN02_03_02 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#起始时间#时";
var label_YN02_03_03 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#起始时间#分";
var label_YN02_04_01 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#结束时间#结束时间";
var label_YN02_04_02 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#结束时间#时";
var label_YN02_04_03 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#结束时间#分";
var label_YN02_05_01 = "部分重要信息系统#组模式#预期停止服务#内容#业务中断的起止时间#中断时间共#中断时间共";
var label_YN02_04 = "部分重要信息系统#组模式#预期停止服务#内容#影响范围#影响范围1";
var label_YN06_04 = "部分重要信息系统#组模式#预期停止服务#内容#影响范围#分支机构数";
var label_YN02_06 = "部分重要信息系统#组模式#预期停止服务#内容#概述";

var label_YN03_01 = "部分重要信息系统#组模式#系统重要性能指标#3#1#1#1#公司账户";
var label_YN03_02 = "部分重要信息系统#组模式#系统重要性能指标#3#1#2#数量#个人账户";
/*
 *系统类型选择核心业务系统则系统可用率可填，否则只读 
 */
function checkSystemData(obj){
	if(obj){
		var inputObj = jQuery(obj.parentElement.parentElement).children()[8];
		var inputValue = getTableFormObj(label_YN01,inputObj.value);
		var obj_YN03_01 = getTableFormObj(label_YN03_01,inputObj.value+"_1_1_1_1");
		var obj_YN03_02 = getTableFormObj(label_YN03_02,inputObj.value+"_1_1_1_1");
		if(inputValue.value == "核心业务系统"){
			obj_YN03_01.readOnly = "";
			obj_YN03_02.readOnly = "";
		}else{
			obj_YN03_01.readOnly = "readonly";
			obj_YN03_02.readOnly = "readonly";
			obj_YN03_01.value = "";
			obj_YN03_02.value = "";
		}
	
	}else{
		var obj_YN01Arr = getTableFormObjs(label_YN01);
		for(var i = 0;i<obj_YN01Arr.length;i++){
			var obj_YN01Obj = obj_YN01Arr[i];
			var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN01Obj.rownumber+"_1_1_1_1");
			var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN01Obj.rownumber+"_1_1_1_1");
			if(obj_YN01Obj.value == "核心业务系统"){
				obj_YN03_01.readOnly = "";
				obj_YN03_02.readOnly = "";
			}else{
				obj_YN03_01.readOnly = "readonly";
				obj_YN03_02.readOnly = "readonly";
				obj_YN03_01.value = "";
				obj_YN03_02.value = "";
			}
			
		}
	}
	
}
/*
 * 功能：初始化
 */
function initSet(){
	var obj_YN02_04Arr = getTableFormObjs(label_YN02_04);
	for(var i = 0;i<obj_YN02_04Arr.length;i++){
		var obj_YN02_04 = obj_YN02_04Arr[i];
		var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN02_04.rownumber);
		if(obj_YN02_04.value == "分支机构"){
			
		}else{
			obj_YN06_04.readOnly = "readonly";
		}
	}
	var obj_YN01_04Arr = getTableFormObjs(label_YN01_04);
	for(var i = 0;i<obj_YN01_04Arr.length;i++){
		var obj_YN01_04 = obj_YN01_04Arr[i];
		var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN01_04.rownumber);
		if(obj_YN01_04.value == "分支机构"){
			
		}else{
			obj_YN04_04.readOnly = "readonly";
		}
	}
	checkSystemData(null);
}
/*
 * 校验小时是否输入正确
 */
function checkMinute(obj){
	if(parseInt(obj.value)>59){
		obj.value = "";
		alert("输入不合法，请输入小于60的整数！");
	}
}

/*
 * 校验小时是否输入正确
 */
function checkHour(obj){
	if(parseInt(obj.value)>23){
		obj.value = "";
		alert("输入不合法，请输入小于24的整数！");
	}
}
/*
 * 起始时间和结束时间校验
 */
function checkEndTime1(obj){
	var endId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))+1)+"_"+obj.rownumber;
	var endObj = document.getElementById(endId);
	if(obj.value !="" &&endObj.value !=""){
		if(obj.value>endObj.value){
			endObj.value = "";
			alert("业务中断的起止时间结束时间不应小于起始时间！");
		}
	}
}
/*
 * 起始时间和结束时间校验
 */
function checkStartTime1(obj){
	var startId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))-1)+"_"+obj.rownumber;
	var startObj = document.getElementById(startId);
	if(obj.value !="" &&startObj.value !=""){
		if(obj.value<startObj.value){
			obj.value = "";
			alert("业务中断的起止时间结束时间不应小于起始时间！");
		}
	}
}

/*
 * 起始时间和结束时间校验
 */
function checkEndTime(obj){
	var endId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))+2)+"_"+obj.rownumber;
	var endObj = document.getElementById(endId);
	if(obj.value !="" &&endObj.value !=""){
		if(obj.value>endObj.value){
			endObj.value = "";
			alert("业务中断的起止时间结束时间不应小于起始时间！");
		}
	}
}
/*
 * 起始时间和结束时间校验
 */
function checkStartTime(obj){
	var startId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))-2)+"_"+obj.rownumber;
	var startObj = document.getElementById(startId);
	if(obj.value !="" &&startObj.value !=""){
		if(obj.value<startObj.value){
			obj.value = "";
			alert("业务中断的起止时间结束时间不应小于起始时间！");
		}
	}
}
/*
 * 通过影响范围来决定范围个数是不是只读
 */
function setCountDisable(obj){
	var inputObj = obj.parentElement.parentElement.parentElement.nextSibling.firstChild.firstChild;
	if(obj.flag == "分支机构"){
		inputObj.readOnly = "";
	}else{
		inputObj.readOnly = "readonly";
		inputObj.value = "";
	}
}
/*
 *功能：判断表单内容是否大于100
 */
function checkPercent(obj){
	if(obj.value > 100){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
		alert("请按规范填写"+errorMessage+"，数值不能大于100\n");
	}
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
		alert("请按规范填写"+errorMessage+"，数值不能小于0\n");
	}
}

function delNull(){
//	var sbObj = getTableFormObjs(label_StopBecause);
//	for(var i = 0;i<sbObj.length;i++){
//		if(sbObj[i].previousSibling){
//			if(sbObj[i].previousSibling.innerHTML == "null"){
//				sbObj[i].previousSibling.innerHTML = "";
//			}
//		}
//	}
	
}

/*
 * 校验是否小于0
 * 
 */
function checkGreaterZero(obj){
	if(parseFloat(obj.value)<0){
		obj.value = "";
		alert("数值应该大于0，请重新输入！");
	}
}


function checkData(){
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//非预期
	var obj_YN01_01Arr = getTableFormObjs(label_YN01_01);
	for(var i = 0;i<obj_YN01_01Arr.length;i++){
		var obj_YN01_01 = obj_YN01_01Arr[i];
		if(obj_YN01_01.value != ""){
			var obj_YN01_02 = getTableFormObj(label_YN01_02,obj_YN01_01.rownumber);
			var obj_YN01_03_01 = getTableFormObj(label_YN01_03_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_03_02 = getTableFormObj(label_YN01_03_02,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_03_03 = getTableFormObj(label_YN01_03_03,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_01 = getTableFormObj(label_YN01_04_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_02 = getTableFormObj(label_YN01_04_02,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_03 = getTableFormObj(label_YN01_04_03,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_05_01 = getTableFormObj(label_YN01_05_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_01.rownumber+"_1");
			var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN01_01.rownumber+"_1");
			var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_01.rownumber);
			
			if(obj_YN01_02.value == ""){
				a +="非预期停止服务：事件等级 不能为空！\n";
				errorObjs.push(obj_YN01_02);
				isValid = false;
			}
			if(obj_YN01_03_01.value == ""){
				a +="非预期停止服务：业务中断的起止时间 起始时间 不能为空！\n";
				errorObjs.push(obj_YN01_03_01);
				isValid = false;
			}
			if(obj_YN01_03_02.value == ""){
				a +="非预期停止服务：业务中断的起止时间 起始时间 时 不能为空！\n";
				errorObjs.push(obj_YN01_03_02);
				isValid = false;
			}
			if(obj_YN01_03_03.value == ""){
				a +="非预期停止服务：业务中断的起止时间 起始时间 分 不能为空！\n";
				errorObjs.push(obj_YN01_03_03);
				isValid = false;
			}
			if(obj_YN01_04_01.value == ""){
				a +="非预期停止服务：业务中断的起止时间 结束时间 不能为空！\n";
				errorObjs.push(obj_YN01_04_01);
				isValid = false;
			}
			if(obj_YN01_04_02.value == ""){
				a +="非预期停止服务：业务中断的起止时间 结束时间 时 不能为空！\n";
				errorObjs.push(obj_YN01_04_02);
				isValid = false;
			}
			if(obj_YN01_04_03.value == ""){
				a +="非预期停止服务：业务中断的起止时间 结束时间 分 不能为空！\n";
				errorObjs.push(obj_YN01_04_03);
				isValid = false;
			}
			if(obj_YN01_05_01.value == ""){
				a +="非预期停止服务：业务中断的起止时间 中断时间不能为空！\n";
				errorObjs.push(obj_YN01_05_01);
				isValid = false;
			}
			if(obj_YN01_04.value == ""){
				a +="非预期停止服务：影响范围不能为空！\n";
				errorObjs.push(obj_YN01_04);
				isValid = false;
			}else if(obj_YN01_04.value == "分支机构" && obj_YN04_04.value == ""){
				a +="非预期停止服务：影响范围个数不能为空！\n";
				errorObjs.push(obj_YN04_04);
				isValid = false;
			}
			if(obj_YN01_06.value == ""){
				a +="非预期停止服务：概述不能为空！\n";
				errorObjs.push(obj_YN01_06);
				isValid = false;
			}
			
		}
	}
	//预期
	var obj_YN02_01Arr = getTableFormObjs(label_YN02_01);
	for(var i = 0;i<obj_YN02_01Arr.length;i++){
		var obj_YN02_01 = obj_YN02_01Arr[i];
		if(obj_YN02_01.value != ""){
			var obj_YN02_03_01 = getTableFormObj(label_YN02_03_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_03_03 = getTableFormObj(label_YN02_03_03,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_01 = getTableFormObj(label_YN02_04_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_03 = getTableFormObj(label_YN02_04_03,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_01.rownumber+"_1");
			var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN02_01.rownumber+"_1");
			var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02_01.rownumber);
			
			if(obj_YN02_03_01.value == ""){
				a +="预期停止服务：业务中断的起止时间 起始时间 不能为空！\n";
				errorObjs.push(obj_YN02_03_01);
				isValid = false;
			}
			if(obj_YN02_03_02.value == ""){
				a +="预期停止服务：业务中断的起止时间 起始时间 时 不能为空！\n";
				errorObjs.push(obj_YN02_03_02);
				isValid = false;
			}
			if(obj_YN02_03_03.value == ""){
				a +="预期停止服务：业务中断的起止时间 起始时间 分 不能为空！\n";
				errorObjs.push(obj_YN02_03_03);
				isValid = false;
			}
			if(obj_YN02_04_01.value == ""){
				a +="预期停止服务：业务中断的起止时间 结束时间 不能为空！\n";
				errorObjs.push(obj_YN02_04_01);
				isValid = false;
			}
			if(obj_YN02_04_02.value == ""){
				a +="预期停止服务：业务中断的起止时间 结束时间 时 不能为空！\n";
				errorObjs.push(obj_YN02_04_02);
				isValid = false;
			}
			if(obj_YN02_04_03.value == ""){
				a +="非预期停止服务：业务中断的起止时间 结束时间 分 不能为空！\n";
				errorObjs.push(obj_YN02_04_03);
				isValid = false;
			}
			if(obj_YN02_05_01.value == ""){
				a +="非预期停止服务：业务中断的起止时间 中断时间不能为空！\n";
				errorObjs.push(obj_YN02_05_01);
				isValid = false;
			}
			if(obj_YN02_04.value == ""){
				a +="预期停止服务：影响范围不能为空！\n";
				errorObjs.push(obj_YN02_04);
				isValid = false;
			}else if(obj_YN02_04.value == "分支机构" && obj_YN06_04.value == ""){
				a +="预期停止服务：影响范围个数不能为空！\n";
				errorObjs.push(obj_YN06_04);
				isValid = false;
			}
			if(obj_YN02_06.value == ""){
				a +="非预期停止服务：概述不能为空！\n";
				errorObjs.push(obj_YN02_06);
				isValid = false;
			}
			
		}
		
	}
	//校验是否选择了核心业务系统，选择了则校验必填
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for(var i = 0;i<obj_YN01Arr.length-1;i++){
		var obj_YN01Obj = obj_YN01Arr[i];
		var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN01Obj.rownumber+"_1_1_1_1");
		var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN01Obj.rownumber+"_1_1_1_1");
		if(obj_YN01Obj.value == "核心业务系统"){
			if(obj_YN03_01.value ==""){
				a +="核心业务系统账户数公司账户不能为空！\n";
				errorObjs.push(obj_YN03_01);
				isValid = false;
			}
			if(obj_YN03_02.value == ""){
				a +="核心业务系统账户数个人账户不能为空！\n";
				errorObjs.push(obj_YN03_02);
				isValid = false;
			}
		}
		
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("其他") > -1) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.outerHTML.indexOf("DIV") > -1){
				
				errorObjs[i].previousSibling.style.backgroundColor = "red";
				
			} else {
				errorObjs[i].parentNode.style.color = "red";
			}
		}
		alert(a);
		a = "";
		isValid = true;
		return false;
	}
	return isValid;
}
/*
 * 去掉审批节点的NULL
 */
jQuery(function(){
	if(jQuery("#pdid").val()+"003" != jQuery("#psdid").val()){
		jQuery("span:contains('null')").html("");
	}
});