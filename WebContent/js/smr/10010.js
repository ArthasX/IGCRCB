/*
 * 报表：T-B-11 信息科技应急管理情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_EG_YN_Item1 = "应急组织#明细项目#设立重要信息系统重大突发事件应急组织#内容#单选";
var label_R_item1 = "应急组织#明细项目#设立重要信息系统重大突发事件应急组织#内容#组织名称";

var label_EG_YN_Item2 = "应急组织#明细项目#一级分支机构应急管理组织设立及运作方式#内容#设立情况";
var label_R_item2 = "应急组织#明细项目#一级分支机构应急管理组织设立及运作方式#内容#运作方式";

var label_item1_GTZero = "信息科技突发事件#内容列#1#内容";
var label_item1_GTZero_2 = "应急预案与应急演练#内容列#1#内容";

/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	setEG_YN_Item1Disable(obj);
	setEG_YN_Item2Disable(obj);
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：应急组织#明细项目#设立重要信息系统重大突发事件应急组织#内容#单选
 */
function setEG_YN_Item1Disable(obj) {
	var obj_item1 = getTableFormObjs(label_EG_YN_Item1)[0];
	var obj_R_item1 = getTableFormObjs(label_R_item1)[0];
	if (obj_item1.value.trim() == "否") {
		// 只读
		obj_R_item1.readOnly = "readonly";
		// 清空
		obj_R_item1.value = "";

	} else if (obj_item1.value.trim() == "是") {
		// 还原
		obj_R_item1.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：应急组织#明细项目#一级分支机构应急管理组织设立及运作方式#内容#设立情况
 */
function setEG_YN_Item2Disable(obj) {
	var obj_item2 = getTableFormObjs(label_EG_YN_Item2)[0];
	var obj_R_item2 = getTableFormObjs(label_R_item2)[0];
	if (obj_item2.value.trim() == "未设立") {
		// 只读
		obj_R_item2.readOnly = "readonly";
		// 清空
		obj_R_item2.value = "";

	} else if (obj_item2.value.trim() == "已设立") {
		// 还原
		obj_R_item2.readOnly = "";
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
	
	var obj_EG_YN_Item1 = getTableFormObjs(label_EG_YN_Item1)[0];
	var obj_R_item1 = getTableFormObjs(label_R_item1)[0];
	if(obj_EG_YN_Item1.value == "是" && obj_R_item1.value.trim() == ""){
		errorObjs.push(obj_R_item1);
	 	a+="应急组织-组织名称：不能为空！\n";
	  	isValid=false;
	}
	
	var obj_EG_YN_Item2 = getTableFormObjs(label_EG_YN_Item2)[0];
	var obj_R_item2 = getTableFormObjs(label_R_item2)[0];
	if(obj_EG_YN_Item2.value == "已设立" && obj_R_item2.value.trim() == ""){
		errorObjs.push(obj_R_item2);
	 	a+="应急组织-运作方式不能为空！\n";
	  	isValid=false;
	}
	
	var obj_item1_GTZero = getTableFormObjs(label_item1_GTZero);
	if(parseInt(obj_item1_GTZero[0].value) > parseInt(obj_item1_GTZero[1].value )+ parseInt(obj_item1_GTZero[2].value) + 
			parseInt(obj_item1_GTZero[3].value) + parseInt(obj_item1_GTZero[4].value) ||
				parseInt(obj_item1_GTZero[0].value) < parseInt(obj_item1_GTZero[1].value) + parseInt(obj_item1_GTZero[2].value) +
						parseInt(obj_item1_GTZero[3].value) + parseInt(obj_item1_GTZero[4].value) ){
		errorObjs.push(obj_item1_GTZero[0]);
		 a+="信息科技突发事件-信息科技突发事件总数=I级+II级+III级+III级以下出错！\n";
		 isValid=false;
	}
	

	
	var obj_item1_GTZero_2 = getTableFormObjs(label_item1_GTZero_2);
	if(parseInt(obj_item1_GTZero_2[0].value) > parseInt(obj_item1_GTZero_2[1].value) + 
			parseInt(obj_item1_GTZero_2[2].value) + parseInt(obj_item1_GTZero_2[3].value) ||
				parseInt(obj_item1_GTZero_2[0].value) < parseInt(obj_item1_GTZero_2[1].value) +
						parseInt(obj_item1_GTZero_2[2].value) + parseInt(obj_item1_GTZero_2[3].value) ){
		errorObjs.push(obj_item1_GTZero_2[0]);
		 a+="应急预案与应急演练-本年应急演练次数=模拟演练+切换演练+其他出错！\n";
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