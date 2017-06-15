/*
 * 报表：T-Q-3 信息科技外包情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_ND = "报送空表表格#报送空表";
var label_item5 = "填报内容#新增外包项目名称";
var label_item13 = "填报内容#外包范围";
var label_item19 = "填报内容#外包类型";
var label_item9 = "填报内容#内容描述";
var label_item10 = "填报内容#外包商情况#外包商名称";
var label_item11 = "填报内容#外包商情况#外包商国别";
var label_item12 = "填报内容#外包商性质";
var label_item13_2 = "填报内容#服务起始时间";
var label_item14 = "填报内容#服务终止时间";
var label_item15 = "填报内容#外包服务协议安全保密条款";
var label_item16 = "填报内容#知识产权保护条款";
var label_item17 = "填报内容#外包风险评估";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	
}
/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#服务开始时间
 */
function setItem13Disable(obj) {
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	if (obj.value != "" && obj_item14.value != "" && obj.value > obj_item14.value) {
		obj.value = "";
		alert("开始时间应在结束时间之前，请重新输入！");
	} 
}

/*
 *功能：根据填写的时间判断开始时间是否大于结束时间
 *配置：填报内容#服务终止时间
 */
function setItem14Disable(obj) {
	var obj_item13_2 = getTableFormObj(label_item13_2,obj.rownumber);

	if (obj.value != "" && obj_item13_2.value != "" && obj_item13_2.value > obj.value) {
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
	
	if (!checkEmptyReport()) {
		return true;
	}
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
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
	var obj_item13 = getTableFormObj(label_item13,obj.rownumber);
	var obj_item19 = getTableFormObj(label_item19,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber + "_1");
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber + "_1");
	var obj_item12 = getTableFormObj(label_item12,obj.rownumber);
	var obj_item13_2 = getTableFormObj(label_item13_2,obj.rownumber);
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	var obj_item15 = getTableFormObj(label_item15,obj.rownumber);
	var obj_item16 = getTableFormObj(label_item16,obj.rownumber);
	var obj_item17 = getTableFormObj(label_item17,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "无"){
	/*if (replaceAll(obj.value.trim()) == "") {
		errorObjs.push(getEditDiv(obj));
		if(a.indexOf("新增外包项目：名称不为“无”或空！\n")<0)
		a += "新增外包项目：名称不为“无”或空！\n";
		isValid = false;
	}*/
		if (obj_item13.value == "") {
			errorObjs.push(obj_item13.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包范围不能为空！\n";
			isValid = false;
		}
		if (obj_item19.value == "") {
			errorObjs.push(obj_item19.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包类型不能为空！\n";
			isValid = false;
		}
		if (replaceAll(obj_item9.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item9));
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项内容描述不能为空！\n";
			isValid = false;
		}
		if (obj_item10.value == "") {
			errorObjs.push(obj_item10);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包商名称不能为空！\n";
			isValid = false;
		}
		if (obj_item11.value == "") {
			errorObjs.push(obj_item11);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包商国别不能为空！\n";
			isValid = false;
		}
		if (obj_item12.value == "") {
			errorObjs.push(obj_item12.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包商性质不能为空！\n";
			isValid = false;
		}
		if (obj_item13_2.value == "") {
			errorObjs.push(obj_item13_2);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项服务开始时间不能为空！\n";
			isValid = false;
		}
		if (obj_item14.value == "") {
			errorObjs.push(obj_item14);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项服务结束时间不能为空！\n";
			isValid = false;
		}if (obj_item15.value == "") {
			errorObjs.push(obj_item15.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包服务协议安全保密条款不能为空！\n";
			isValid = false;
		}
		if (obj_item16.value == "") {
			errorObjs.push(obj_item16.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项知识产权保护条款不能为空！\n";
			isValid = false;
		}
		if (obj_item17.value == "") {
			errorObjs.push(obj_item17.parentElement);
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不为“无”或空，则此项外包风险评估不能为空！\n";
			isValid = false;
		}
	}else{
		if(obj_item13.value != "" || obj_item19.value != "" || replaceAll(obj_item9.value.trim()) != "" ||
				obj_item10.value != "" || obj_item11.value != "" || obj_item12.value != "" || obj_item13_2.value != ""||
				obj_item14.value != "" || obj_item15.value != "" || obj_item16.value != "" || obj_item17.value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "新增外包项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：名称不可以为“无”或空！\n";
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