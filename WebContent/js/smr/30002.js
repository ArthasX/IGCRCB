/*
 * 报表：T-A-3 数据中心规划报告表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01="是否外包";
var label_YN01_01="外包范围";
var label_YN01_02="外包类型";
var label_YN01_03="外包商性质";
var label_zhandimianji ="基本信息#占地面积";
var label_jifangmianji ="基本信息#机房面积";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var obj_YN01=getFormObj(label_YN01);
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	if (obj_YN01.value=="否") {
		// 清空外包类型并设置为无效
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,true);
		// 清空外包范围并设置为无效
		clearNormalRadioValue(obj_YN01_01,true);
		// 清空外包商性质并设置为无效
		clearNormalRadioValue(obj_YN01_03,true);
	}
}

/*
* 功能：是否外包相互制域处理
* 配置：是否外包
*/
function shifouwaibao_click(obj){
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	
	if (obj.value=="否") {
		// 清空外包类型并设置为无效
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,true);
		// 清空外包范围并设置为无效
		clearNormalRadioValue(obj_YN01_01,true);
		// 清空外包商性质并设置为无效
		clearNormalRadioValue(obj_YN01_03,true);
	} else {
		//还原
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,false);
		clearNormalRadioValue(obj_YN01_01,false);
		clearNormalRadioValue(obj_YN01_03,false);
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_YN01=getFormObj(label_YN01);
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	var obj_zhandimianji=getTableFormObjs(label_zhandimianji)[0];
	var obj_jifangmianji=getTableFormObjs(label_jifangmianji)[0];
	
	// 小数位补零处理
	checkNumFloat(obj_zhandimianji,2);
	checkNumFloat(obj_jifangmianji,2);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];

	if (obj_YN01.value=="是") {
		if(obj_YN01_01.value=="") {
			errorObjs.push(obj_YN01_01.parentElement);
			a += "外包范围不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_02.value=="") {
			errorObjs.push(obj_YN01_02.parentElement);
			a += "外包类型不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_03.value=="") {
			errorObjs.push(obj_YN01_03.parentElement);
			a += "外包商性质不能为空！\n";
			isValid = false;
		}
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
