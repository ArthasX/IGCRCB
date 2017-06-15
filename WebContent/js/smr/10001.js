/**T-B-2 信息科技风险管理情况表——报表填报*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item55 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填报日期";
var label_TextField12 = "信息安全培训#内容";
var label_TextField12_GTZero = "信息安全培训#内容#本年度信息安全培训员工参与率";

var label_YN01_01 = "信息科技风险评估#内容#本年度是否以开展信息科技风险评估";
var label_YN01_01_GTZero = "信息科技风险评估#内容#如开展，全面评估";
var label_YN01_02_GTZero = "信息科技风险评估#内容#专项评估";
var label_YN02_01 = "信息科技风险监测#内容#是否建立信息科技风险监测关键风险点指标";
var label_YN02_01_GTZero = "信息科技风险监测#内容#报告期内关键风险点总数";


function initSet(){
	YN01(getTableFormObj(label_YN01_01, "1_1"));
	YN02(getTableFormObj(label_YN02_01, "1_1"));
}


/*
*功能：校验是否
*配置：   信息科技风险评估#内容#本年度是否以开展信息科技风险评估
*/

function YN01(objcld) {
	var obj = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_01_GTZero = getTableFormObj(label_YN01_01_GTZero, obj.rownumber);
	var obj_YN01_02_GTZero = getTableFormObj(label_YN01_02_GTZero, obj.rownumber);
	if (obj.value.trim() == "否") {
		// 只读
		obj_YN01_01_GTZero.onclick = "";
		obj_YN01_02_GTZero.onclick = "";
		// 清空
		obj_YN01_01_GTZero.value = "";
		obj_YN01_02_GTZero.value = "";
	} else if (obj.value.trim() == "是") {
		// 还原
		obj_YN01_01_GTZero.onclick = click_columnValueNumber;
		obj_YN01_02_GTZero.onclick = click_columnValueNumber;
	}
}

/*
*功能：校验是否
*配置：信息科技风险监测#内容#是否建立信息科技风险监测关键风险点指标
*/

function YN02(objcld) {
	var obj = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_01_GTZero = getTableFormObj(label_YN02_01_GTZero, obj.rownumber);
	if (obj.value.trim() == "否") {
		// 只读
		obj_YN02_01_GTZero.onclick = "";
		// 清空
		obj_YN02_01_GTZero.value = "";
	} else if (obj.value.trim() == "是") {
		// 还原
		obj_YN02_01_GTZero.onclick = click_columnValueNumber;
	}
}

function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	if (parseInt(getTableFormObj(label_TextField12_GTZero,"1_1").value.trim()) > 100) {
		errorObjs.push(getTableFormObj(label_TextField12_GTZero,"1_1"));
		a += "信息安全培训-本年度信息安全培训员工参与率<100出错！\n";
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

var click_columnValueNumber = function() {
	columnValueNumber(this);
};
