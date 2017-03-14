/*
 * 报表：T-A-2 重大突发事件报告表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_qudaoguanli="系统类别#渠道管理#1";
var label_item8="系统类别#渠道管理#2";
var label_kehuguanli="系统类别#客户管理#1";
var label_item10="系统类别#客户管理#2";
var label_chanpinguanli="系统类别#产品管理#1";
var label_item12="系统类别#产品管理#2";
var label_caiwuguanli="系统类别#财务管理#1";
var label_item14="系统类别#财务管理#2";
var label_juecezhichi="系统类别#决策支持#1";
var label_item16="系统类别#决策支持#2";
var label_gongxiangzhichi="系统类别#共享支持#1";
var label_item18="系统类别#共享支持#2";
var label_jichusheshi="系统类别#基础设施#1";
var label_item89="系统类别#基础设施#2";
var label_qita="系统类别#其他#1#1";
var label_item7="系统类别#其他#1#2";
var label_item87="系统类别#其他#2";

var label_RadioButtonList="影响范围";
var label_S_item11="范围描述#分支机构名称";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1" );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, "1_1");
	var obj_item18 = getTableFormCheckBox(label_item18,"1_1" );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, "1_1");
	var obj_item89 = getTableFormCheckBox(label_item89,"1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item7 = getTableFormObj(label_item7,"1_1_1" );
	var obj_item87 = getTableFormObj(label_item87,"1_1" );
	
	if (obj_qudaoguanli.value=="渠道管理") {
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_kehuguanli.value=="客户管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_chanpinguanli.value=="产品管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_caiwuguanli.value=="财务管理") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_juecezhichi.value=="决策支持") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_gongxiangzhichi.value=="共享支持") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_jichusheshi.value=="基础设施") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_qita.value=="其他") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
	}
}

/*
* 功能：各系统类别相互制域处理
* 配置：系统类别#渠道管理#1
* 系统类别#客户管理#1
* 系统类别#产品管理#1
* 系统类别#财务管理#1
* 系统类别#决策支持#1
* 系统类别#共享支持#1
* 系统类别#基础设施#1
*/
function xitongleibie_click(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_item8,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_item10,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_item12,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_item14,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_item16,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_item18,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_item89,target.rownumber );
	var obj_qita = getTableFormObj(label_qita,target.rownumber+"_1" );
	var obj_item7 = getTableFormObj(label_item7,target.rownumber+"_1" );
	var obj_item87 = getTableFormObj(label_item87,target.rownumber );
	
	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	getEditDiv(obj_item87).innerHTML = "";
	getEditDiv(obj_item87).contentEditable=false;
	obj_item87.value="";
	obj_item7.value="";
	obj_item7.readOnly = "readonly";
	
	if (target.value=="渠道管理"){
		//指定复选框对象还原状态
		disableTableCheckBox(obj_item8,false);
		//设置其他无关单选框状态为非选中
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="客户管理"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="产品管理") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="财务管理") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="决策支持") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="共享支持") {
		disableTableCheckBox(obj_item18,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="基础设施") {
		disableTableCheckBox(obj_item89,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_qita);
	}
}

/*
* 功能：各系统类别相互制域处理(其他)
* 配置：系统类别#其他#1#1
*/
function xitongleibie_qita_click(obj) {
	
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item8 = getTableFormCheckBox(label_item8,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item10 = getTableFormCheckBox(label_item10,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item12 = getTableFormCheckBox(label_item12,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item14 = getTableFormCheckBox(label_item14,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item16 = getTableFormCheckBox(label_item16,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item18 = getTableFormCheckBox(label_item18,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_jichusheshi = getTableFormObj(label_jichusheshi,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item89 = getTableFormCheckBox(label_item89,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_qita = getTableFormObj(label_qita,target.rownumber);
	var obj_item7 = getTableFormObj(label_item7,target.rownumber);
	var obj_item87 = getTableFormObj(label_item87,target.rownumber.substring(0,target.rownumber.length-2));
	
	//设置系统类别的全部多选框为只读并清空值
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	getEditDiv(obj_item87).innerHTML = "";
	getEditDiv(obj_item87).contentEditable=false;
	obj_item87.value="";
	obj_item7.value="";
	obj_item7.readOnly = "readonly";

	if (target.value=="其他") {
		getEditDiv(obj_item87).contentEditable=true;
		obj_item7.readOnly = "";
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_gongxiangzhichi);
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1" );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, "1_1");
	var obj_item18 = getTableFormCheckBox(label_item18,"1_1" );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, "1_1");
	var obj_item89 = getTableFormCheckBox(label_item89,"1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item7 = getTableFormObj(label_item7,"1_1_1" );
	var obj_item87 = getTableFormObj(label_item87,"1_1" );
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var obj_RadioButtonList = getFormObj(label_RadioButtonList);
	var objs_label_S_item11 = getTableFormObjs(label_S_item11);
	if (obj_RadioButtonList.value=="全辖范围") {
		for ( var i = 0; i < objs_label_S_item11.length; i++) {
			// 过滤模版
			if ((objs_label_S_item11[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			if (objs_label_S_item11[i].value.trim()!="") {
				errorObjs.push(getEditDiv(objs_label_S_item11[i]));
				a += "影响范围选择全辖范围，则范围描述应该为空！\n";
				isValid = false;
			}
		}
	} else {
		for ( var i = 0; i < objs_label_S_item11.length; i++) {
			// 过滤模版
			if ((objs_label_S_item11[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			if (objs_label_S_item11[i].value.trim()=="") {
				errorObjs.push(getEditDiv(objs_label_S_item11[i]));
				a += "影响范围选择非全辖范围，则范围描述分支机构名称不能为空！\n";
				isValid = false;
			}
		}
	}
	
	if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
			obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_gongxiangzhichi.value=="" && 
			obj_jichusheshi.value=="" && obj_qita.value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		errorObjs.push(obj_kehuguanli.parentElement);
		errorObjs.push(obj_chanpinguanli.parentElement);
		errorObjs.push(obj_caiwuguanli.parentElement);
		errorObjs.push(obj_juecezhichi.parentElement);
		errorObjs.push(obj_gongxiangzhichi.parentElement);
		errorObjs.push(obj_jichusheshi.parentElement);
		errorObjs.push(obj_qita.parentElement);
		a += "系统类别不能为空！\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value != "" && getTarget(getTableFormObj(label_item8, "1_1")).value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		a += "系统类别选择“渠道管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_kehuguanli.value != "" && getTarget(getTableFormObj(label_item10, "1_1")).value=="") {
		errorObjs.push(obj_kehuguanli.parentElement);
		a += "系统类别选择“客户管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_chanpinguanli.value != "" && getTarget(getTableFormObj(label_item12, "1_1")).value=="") {
		errorObjs.push(obj_chanpinguanli.parentElement);
		a += "系统类别选择“产品管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_caiwuguanli.value != "" && getTarget(getTableFormObj(label_item14, "1_1")).value=="") {
		errorObjs.push(obj_caiwuguanli.parentElement);
		a += "系统类别选择“财务管理”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_juecezhichi.value != "" && getTarget(getTableFormObj(label_item16, "1_1")).value=="") {
		errorObjs.push(obj_juecezhichi.parentElement);
		a += "系统类别选择“决策支持”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_gongxiangzhichi.value != "" && getTarget(getTableFormObj(label_item18, "1_1")).value=="") {
		errorObjs.push(obj_gongxiangzhichi.parentElement);
		a += "系统类别选择“共享支持”时，其对应的子类型不能为空！\n";
		isValid = false;
	}
	if (obj_jichusheshi.value != "" && getTarget(getTableFormObj(label_item89, "1_1")).value=="") {
		errorObjs.push(obj_jichusheshi.parentElement);
		a += "系统类别选择“基础设施”时，其对应的子类型不能为空！\n";
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
