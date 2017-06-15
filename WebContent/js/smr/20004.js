/*
 * 报表：T-Q-5 电子银行信息科技风险监测表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "填报内容#网上银行#内容#安全事件名称";
var label_item6 = "填报内容#网上银行#内容#事件分类";
var label_item0 = "填报内容#网上银行#内容#发生时间#发生时间从";
var label_item2 = "填报内容#网上银行#内容#发生时间#发生时间到";
var label_item9_GTZero = "填报内容#网上银行#内容#次数";
var label_item10 = "填报内容#网上银行#内容#原因及处置措施";
var label_item11 = "填报内容#网上银行#内容#损失情况";
var label_cell2 = "填报内容#网上银行#内容#备注";

var label_item5_2 = "填报内容#银行卡#内容#安全事件名称";
var label_item14_2 = "填报内容#银行卡#内容#事件分类";
var label_item0_2 = "填报内容#银行卡#内容#发生时间#1";
var label_item2_2 = "填报内容#银行卡#内容#发生时间#2";
var label_item17_GTZero_2 = "填报内容#银行卡#内容#次数";
var label_item18_2 = "填报内容#银行卡#内容#原因及处置措施";
var label_item19_2 = "填报内容#银行卡#内容#损失情况";
var label_cell20_2 = "填报内容#银行卡#内容#备注";

var label_item21 = "填报内容#3#系统名称#名称";
var label_item5_3 = "填报内容#3#内容#安全事件名称";
var label_item13_3 = "填报内容#3#内容#事件分类";
var label_item0_3 = "填报内容#3#内容#发生时间#1";
var label_item2_3 = "填报内容#3#内容#发生时间#2";
var label_item9_GTZero_3 = "填报内容#3#内容#次数";
var label_item18_3 = "填报内容#3#内容#原因及处置措施";
var label_item19_3 = "填报内容#3#内容#损失情况";
var label_cell20_3 = "填报内容#3#内容#备注";
/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	
}
/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#网上银行#内容#发生时间#发生时间从    
 */
function setItem0Disable(obj) {
	var end = getTableFormObj(label_item2,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("开始时间应在结束时间之前，请重新输入！");
	} 
}

/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#网上银行#内容#发生时间#发生时间到
 */
function setItem2Disable(obj) {
	var start = getTableFormObj(label_item0,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("结束时间应在起始时间后，请重新输入！");
	} 
}

/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#银行卡#内容#发生时间#1
 */
function setItem0_2Disable(obj) {
	var end = getTableFormObj(label_item2_2,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("开始时间应在结束时间之前，请重新输入！");
	} 
}

/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#银行卡#内容#发生时间#2
 */
function setItem2_2Disable(obj) {
	var start = getTableFormObj(label_item0_2,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("结束时间应在起始时间之后，请重新输入！");
	} 
}

/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#3#内容#发生时间#1
 */
function setItem0_3Disable(obj) {
	var end = getTableFormObj(label_item2_3,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("开始时间应在结束时间之前，请重新输入！");
	} 
}
/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#3#内容#发生时间#2
 */
function setItem2_3Disable(obj) {
	var start = getTableFormObj(label_item0_3,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("结束时间应在起始时间之后，请重新输入！");
	} 
}

/*
* 功能：点击提交时进行的表单验证
* 配置：填报状态的“提交”按钮
*/
function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	
	var objs2 = getTableFormObjs(label_item5_2);
	for ( var i = 0; i < objs2.length; i++) {
		// 过滤模版
		if ((objs2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull2(objs2[i]);
	}
	
	var objs3 = getTableFormObjs(label_item5_3);
	for ( var i = 0; i < objs3.length; i++) {
		// 过滤模版
		if ((objs3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull3(objs3[i]);
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


/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull(obj) {
	var obj_item6 = getTableFormObj(label_item6,obj.rownumber);
	var obj_item0 = getTableFormObj(label_item0,obj.rownumber + "_1");
	var obj_item2 = getTableFormObj(label_item2,obj.rownumber + "_1");
	var obj_item9_GTZero = getTableFormObj(label_item9_GTZero,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber);
	var obj_cell2 = getTableFormObj(label_cell2,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "无"){
		if (obj_item6.value == "") {
			errorObjs.push(obj_item6.parentElement);
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项事件分类不能为空！\n";
			isValid = false;
		}
		if (obj_item0.value == "") {
			errorObjs.push(obj_item0);
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生开始时间不能为空！\n";
			isValid = false;
		}
		if (obj_item2.value == "") {
			errorObjs.push(obj_item2);
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生结束时间不能为空！\n";
			isValid = false;
		}
		if (obj_item9_GTZero.value == "") {
			errorObjs.push(obj_item9_GTZero);
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项次数不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item10.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item10));
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项原因及处置措施不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item11.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item11));
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项损失情况不能为空！\n";
			isValid = false;
		}
	}else{
		if(replaceAll(obj.value.trim()) != "" && obj_item6.value != "" ||
				obj_item0.value != "" || obj_item2.value != "" && obj_item9_GTZero.value != "" ||
				replaceAll(obj_item10.value.trim()) != "" || replaceAll(obj_item11.value.trim()) != "" ||
				replaceAll(obj_cell2.value.trim()) != ""
					){
			errorObjs.push(getEditDiv(obj));
			a += "1.网上银行 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项安全事件名称不能为空！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull2(obj) {
	
	var obj_item14_2 = getTableFormObj(label_item14_2,obj.rownumber);
	var obj_item0_2 = getTableFormObj(label_item0_2,obj.rownumber + "_1");
	var obj_item2_2 = getTableFormObj(label_item2_2,obj.rownumber + "_1");
	var obj_item17_GTZero_2 = getTableFormObj(label_item17_GTZero_2,obj.rownumber);
	var obj_item18_2 = getTableFormObj(label_item18_2,obj.rownumber);
	var obj_item19_2 = getTableFormObj(label_item19_2,obj.rownumber);
	var obj_cell20_2 = getTableFormObj(label_cell20_2,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "无"){
		if (obj_item14_2.value == "") {
			errorObjs.push(obj_item14_2.parentElement);
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项事件分类不能为空！\n";
			isValid = false;
		}
		if (obj_item0_2.value == "") {
			errorObjs.push(obj_item0_2);
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生开始时间不能为空！\n";
			isValid = false;
		}
		if (obj_item2_2.value == "") {
			errorObjs.push(obj_item2_2);
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生结束时间不能为空！\n";
			isValid = false;
		}
		if (obj_item17_GTZero_2.value == "") {
			errorObjs.push(obj_item17_GTZero_2);
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项次数不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item18_2.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item18_2));
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项原因及处置措施不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item19_2.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item19_2));
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项损失情况不能为空！\n";
			isValid = false;
		}
	}else{
		if(obj_item14_2.value != "" || obj_item0_2.value != "" || obj_item2_2.value != "" || obj_item17_GTZero_2.value != "" ||
				replaceAll(obj_item18_2.value.trim()) != "" || replaceAll(obj_item19_2.value.trim()) != "" ||
				replaceAll(obj_cell20_2.value.trim()) != ""){
			errorObjs.push(getEditDiv(obj));
			a += "2.银行卡 安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不可以为“无”或空！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull3(obj) {
	var obj_item21 = getTableFormObj(label_item21,obj.rownumber);
	var obj_item13_3 = getTableFormObj(label_item13_3,obj.rownumber);
	var obj_item0_3 = getTableFormObj(label_item0_3,obj.rownumber + "_1");
	var obj_item2_3 = getTableFormObj(label_item2_3,obj.rownumber + "_1");
	var obj_item9_GTZero_3 = getTableFormObj(label_item9_GTZero_3,obj.rownumber);
	var obj_item18_3 = getTableFormObj(label_item18_3,obj.rownumber);
	var obj_item19_3 = getTableFormObj(label_item19_3,obj.rownumber);
	var obj_cell20_3 = getTableFormObj(label_cell20_3,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "无"){
		
		if (obj_item21.value == "") {
			errorObjs.push(obj_item21.parentElement);
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项系统名称不能为空！\n";
			isValid = false;
		}
		if (obj_item13_3.value == "") {
			errorObjs.push(getEditDiv(obj_item13_3));
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项事件分类不能为空！\n";
			isValid = false;
		}
		if (obj_item0_3.value == "") {
			errorObjs.push(obj_item0_3);
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生开始时间不能为空！\n";
			isValid = false;
		}
		if (obj_item2_3.value == "") {
			errorObjs.push(obj_item2_3);
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项发生结束时间不能为空！\n";
			isValid = false;
		}
		if (obj_item9_GTZero_3.value == "") {
			errorObjs.push(obj_item9_GTZero_3);
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项次数不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item18_3.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item18_3));
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项原因及处置措施不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item19_3.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item19_3));
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项损失情况不能为空！\n";
			isValid = false;
		}
	}else{
		if( obj_item21.value != "" || obj_item13_3.value != "" ||
				obj_item0_3.value != "" || obj_item2_3.value != "" || obj_item9_GTZero_3.value != "" ||
				replaceAll(obj_item18_3.value.trim()) != "" || replaceAll(obj_item19_3.value.trim()) != "" ||
				replaceAll(obj_cell20_3.value.trim()) != ""){
			errorObjs.push(getEditDiv(obj));
			a += "3.安全事件"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项安全事件名称不能为空！\n";
			isValid = false;
		}
	}
}

/*
 *功能：回车行替换
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}