/*
 * 报表：T-B-10  数据管理情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item8 = "生产数据#内容";

var label_EG_YN_Item9 = "数据保存#表1#内容#1";
var label_R_Item10 = "数据保存#表1#内容#地点";
var label_EG_YN_Item9_2 = "数据保存#表2#内容#1";
var label_R_Item11 = "数据保存#表2#内容#存放机构名称";

var label_EG_YN_Item27 = "数据访问和使用控制#表4#内容#1";
var label_R_Item28 = "数据访问和使用控制#表4#内容#采用加密算法";

var label_EG_YN_Item38 = "数据访问和使用控制#表7#内容";
var label_EG_YN_Item38_2 = "数据访问和使用控制#表8#内容#1";
var label_R_Item39 = "数据访问和使用控制#表8#内容#回收方法";

var label_EG_YN_Item43 = "数据清理及销毁#表2#内容#1";
var label_R_Item44 = "数据清理及销毁#表2#内容#销毁机构名称";
/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	setEG_YN_Item9Disable(obj);
	setEG_YN_Item9_2Disable(obj);
	setEG_YN_Item27Disable(obj);
	setEG_YN_Item38Disable(obj);
	setEG_YN_Item43Disable(obj);
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：数据保存#表1#内容#1
 */
function setEG_YN_Item9Disable(obj) {
	var obj_item9 = getTableFormObjs(label_EG_YN_Item9)[0];
	var obj_R_Item10 = getTableFormObjs(label_R_Item10)[0];
	if (obj_item9.value.trim() == "否") {
		// 只读
		obj_R_Item10.readOnly = "readonly";
		// 清空
		obj_R_Item10.value = "";

	} else if (obj_item9.value.trim() == "是") {
		// 还原
		obj_R_Item10.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：数据保存#表2#内容#1
 */
function setEG_YN_Item9_2Disable(obj) {
	var obj_item9_2 = getTableFormObjs(label_EG_YN_Item9_2)[0];
	var obj_R_Item11 = getTableFormObjs(label_R_Item11)[0];
	if (obj_item9_2.value.trim() == "否") {
		// 只读
		obj_R_Item11.readOnly = "readonly";
		// 清空
		obj_R_Item11.value = "";

	} else if (obj_item9_2.value.trim() == "是") {
		// 还原
		obj_R_Item11.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：数据访问和使用控制#表4#内容#1
 */
function setEG_YN_Item27Disable(obj) {
	var obj_item27 = getTableFormObjs(label_EG_YN_Item27)[0];
	var obj_R_Item28 = getTableFormObjs(label_R_Item28)[0];
	if (obj_item27.value.trim() == "否") {
		// 只读
		obj_R_Item28.readOnly = "readonly";
		// 清空
		obj_R_Item28.value = "";

	} else if (obj_item27.value.trim() == "是") {
		// 还原
		obj_R_Item28.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：  1.数据访问和使用控制#表8#内容#1      (可能是模板的BUG，如不是同时配置至:2.数据访问和使用控制#表7#内容)
 */
function setEG_YN_Item38Disable(obj) {
	var obj_item38 = getTableFormObjs(label_EG_YN_Item38_2)[0];
	var obj_R_Item39 = getTableFormObjs(label_R_Item39)[0];
	if (obj_item38.value.trim() == "否") {
		// 只读
		obj_R_Item39.readOnly = "readonly";
		// 清空
		obj_R_Item39.value = "";

	} else if (obj_item38.value.trim() == "是") {
		// 还原
		obj_R_Item39.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：数据清理及销毁#表2#内容#1
 */
function setEG_YN_Item43Disable(obj) {
	var obj_item43 = getTableFormObjs(label_EG_YN_Item43)[0];
	var obj_R_Item44 = getTableFormObjs(label_R_Item44)[0];
	if (obj_item43.value.trim() == "否") {
		// 只读
		obj_R_Item44.readOnly = "readonly";
		// 清空
		obj_R_Item44.value = "";

	} else if (obj_item43.value.trim() == "是") {
		// 还原
		obj_R_Item44.readOnly = "";
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
	
	var obj_item8 = getTableFormObjs(label_item8);
	checkNumFloat(obj_item8[0],3);
	checkNumFloat(obj_item8[1],3);
	checkNumFloat(obj_item8[2],3);
	if(parseFloat(obj_item8[0].value) < 0){
		errorObjs.push(obj_item8[0]);
	 	a+="在线生产数据总量不可以小于0 ！\n";
	  	isValid=false;
	}
	if(parseFloat(obj_item8[1].value) < 0){
		errorObjs.push(obj_item8[1]);
	 	a+="在线总存储量不可以小于0 ！\n";
	  	isValid=false;
	}
	if(parseFloat(obj_item8[2].value) < 0){
		errorObjs.push(obj_item8[2]);
	 	a+="生产数据化变量不可以小于0 ！\n";
	  	isValid=false;
	}
	if( obj_item8[0].value > obj_item8[1].value){
		errorObjs.push(obj_item8[0]);
	 	a+="在线生产数据总量≤在线总存储容量校验出错！\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item9 = getTableFormObjs(label_EG_YN_Item9)[0];
	var obj_R_Item10 = getTableFormObjs(label_R_Item10)[0];
	if(obj_EG_YN_Item9.value == "是" && obj_R_Item10.value.trim() == ""){
		errorObjs.push(obj_R_Item10);
	 	a+="数据保存：异地保存 地点不能为空！\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item9_2 = getTableFormObjs(label_EG_YN_Item9_2)[0];
	var obj_R_Item11 = getTableFormObjs(label_R_Item11)[0];
	if(obj_EG_YN_Item9_2.value == "是" && obj_R_Item11.value.trim() == ""){
		errorObjs.push(obj_R_Item11);
	 	a+="数据保存：生产数据备份至外部机构或备份介质保存在外部机构 存放机构名称不能为空！\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item27 = getTableFormObjs(label_EG_YN_Item27)[0];
	var obj_R_Item28 = getTableFormObjs(label_R_Item28)[0];
	if(obj_EG_YN_Item27.value == "是" && obj_R_Item28.value.trim() == ""){
		errorObjs.push(obj_R_Item28);
	 	a+="采用加密算法不能为空！\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item38_2 = getTableFormObjs(label_EG_YN_Item38_2)[0];
	var obj_R_Item39 = getTableFormObjs(label_R_Item39)[0];
	if(obj_EG_YN_Item38_2.value == "是" && obj_R_Item39.value.trim() == ""){
		errorObjs.push(obj_R_Item39);
	 	a+="数据访问和使用控制：历史数据使用后数据回收方法不能为空！\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item43 = getTableFormObjs(label_EG_YN_Item43)[0];
	var obj_R_Item44 = getTableFormObjs(label_R_Item44)[0];
	if(obj_EG_YN_Item43.value == "是" && obj_R_Item44.value.trim() == ""){
		errorObjs.push(obj_R_Item44);
	 	a+="数据清理及销毁：销毁机构名称不能为空！\n";
	  	isValid=false;
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