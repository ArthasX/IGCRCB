/*
 * 报表：2014-T-Q-2 信息科技项目情况表 
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN00 = "报送空表表格#报送空表";
var label_YN01 = "本季度新增的重大项目#本季度新增的重大项目#项目名称";
var label_YN02 = "本季度新增的重大项目#本季度新增的重大项目#本季度实施情况";

var label_YN01_01 = "标题#填报部门";
var label_YN01_02 = "标题#填报人";
var label_YN01_03 = "标题#联系电话";
var label_YN01_04 = "标题#责任人";
var label_YN01_05 = "标题#填表日期";

var label_YN03_01_01 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#渠道管理#系统类别";
var label_YN03_01_02 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#客户管理#系统类别";
var label_YN03_01_03 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#产品管理#系统类别";
var label_YN03_01_04 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#财务管理#系统类别";
var label_YN03_01_05 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#决策支持#系统类别";
var label_YN03_01_06 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#共享支持#系统类别";
var label_YN03_01_07 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#基础设施#系统类别";
var label_YN03_01_08 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#其他#系统类别";

var label_YN03_02_01 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#渠道管理#子类别";
var label_YN03_02_02 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#客户管理#子类别";
var label_YN03_02_03 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#产品管理#子类别";
var label_YN03_02_04 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#财务管理#子类别";
var label_YN03_02_05 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#决策支持#子类别";
var label_YN03_02_06 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#共享支持#子类别";
var label_YN03_02_07 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#基础设施#子类别";
var label_YN03_02_08 = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#其他#子类别";

var label_YN04 = "本季度新增的重大项目#本季度新增的重大项目#合同金额";

var label_YN05_01 = "本季度新增的重大项目#本季度新增的重大项目#项目日期#计划上线日期#计划上线日期";
var label_YN05_02 = "本季度新增的重大项目#本季度新增的重大项目#项目日期#项目开始日期#项目开始日期";
var label_YN05_03 = "本季度新增的重大项目#本季度新增的重大项目#项目日期#实际完成日期#实际完成日期";

var label_YN06 = "本季度新增的重大项目#本季度新增的重大项目#实施模式";

var label_YN07 = "本季度新增的重大项目#本季度新增的重大项目#项目内容简述";

var label_YN08 = "本季度新增的重大项目#本季度新增的重大项目#备注";

/*
 * 功能：通过系统类别是否点击来决定子类别是否只读
 */
function setCheckBoxDisable(obj) {
	setCheckBoxDisable1(obj.parentElement.nextSibling);
	var label_obj = "本季度新增的重大项目#本季度新增的重大项目#渠道管理#" + obj.value + "#子类别";
	var checkBoxObj = getTableFormCheckBox(label_obj,
			obj.parentElement.nextSibling.rownumber);
	if (obj.parentElement.nextSibling.value != "") {
		disableTableCheckBox(checkBoxObj, false);
	} else {
		disableTableCheckBox(checkBoxObj, true);
	}
}

function setObj_YN03_02_08Disable(obj) {
	var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
			obj.parentElement.nextSibling.rownumber);
	if (obj.parentElement.nextSibling.value != "") {
		obj_YN03_02_08.readOnly = "";
	} else {
		obj_YN03_02_08.readOnly = "readonly";
		obj_YN03_02_08.value = "";
	}
	setCheckBoxDisable1(obj.parentElement.nextSibling);
}

/*
 * 功能：提交按钮校验
 * 
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
		if(errorObjs[i].previousSibling !=null){			
			errorObjs[i].previousSibling.style.color = "";
		}
	}
	errorObjs = [];
	var emptyObj = getTableFormObjs(label_YN00)[0];
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for ( var i = 0; i < obj_YN01Arr.length - 1; i++) {
		// 项目名称校验
		var obj_YN01 = obj_YN01Arr[i];
		if (obj_YN01.value != "" && obj_YN01.value != "无") {
			// 本季度实施情况校验
			var row = obj_YN01.rownumber.substring(0, obj_YN01.rownumber
					.indexOf("_"));
			var obj_YN02 = getTableFormObj(label_YN02, obj_YN01.rownumber);
			if (obj_YN02.value == "") {
				isValid = false;
				errorObjs.push(obj_YN02);
				a += "本季度重大项目" + row + "：本季度实施情况不能为空！\n";
			}
			// 系统类别校验
			var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_03 = getTableFormObj(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_04 = getTableFormObj(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_05 = getTableFormObj(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_06 = getTableFormObj(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_07 = getTableFormObj(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_08 = getTableFormObj(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			if (obj_YN03_01_01.value == "" && obj_YN03_01_02.value == ""
					&& obj_YN03_01_03.value == "" && obj_YN03_01_04.value == ""
					&& obj_YN03_01_05.value == "" && obj_YN03_01_06.value == ""
					&& obj_YN03_01_07.value == "" && obj_YN03_01_08.value == "") {
				isValid = false;
				errorObjs.push(obj_YN03_01_01);
				errorObjs.push(obj_YN03_01_02);
				errorObjs.push(obj_YN03_01_03);
				errorObjs.push(obj_YN03_01_04);
				errorObjs.push(obj_YN03_01_05);
				errorObjs.push(obj_YN03_01_06);
				errorObjs.push(obj_YN03_01_07);
				errorObjs.push(obj_YN03_01_08);
				obj_YN03_01_08.previousSibling.style.color = "red";
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项系统类别不能为空！\n";
			}else{
				//子类别校验
				var obj_YN03_02_01 = getTableFormObj(label_YN03_02_01,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_02 = getTableFormObj(label_YN03_02_02,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_03 = getTableFormObj(label_YN03_02_03,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_04 = getTableFormObj(label_YN03_02_04,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_05 = getTableFormObj(label_YN03_02_05,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_06 = getTableFormObj(label_YN03_02_06,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_07 = getTableFormObj(label_YN03_02_07,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
						obj_YN01.rownumber + "_1_1");
				if (obj_YN03_02_01.value == "" && obj_YN03_02_02.value == ""
						&& obj_YN03_02_03.value == "" && obj_YN03_02_04.value == ""
						&& obj_YN03_02_05.value == "" && obj_YN03_02_06.value == ""
						&& obj_YN03_02_07.value == "" && obj_YN03_02_08.value == "") {
					isValid = false;
					if(obj_YN03_01_01.value != "" && obj_YN03_02_01.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_01);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“渠道管理”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_02.value != "" && obj_YN03_02_02.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_02);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“客户管理”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_03.value != "" && obj_YN03_02_03.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_03);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“产品管理”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_04.value != "" && obj_YN03_02_04.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_04);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“财务管理”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_05.value != "" && obj_YN03_02_05.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_05);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“决策支持”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_06.value != "" && obj_YN03_02_06.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_06);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“共享支持”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_07.value != "" && obj_YN03_02_07.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_07);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“基础设施”时，其对应的子类型不能为空！\n";
					}
					if(obj_YN03_01_08.value != "" && obj_YN03_02_08.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_08);
						a += "本季度重大项目" + row + "：名称不为“无”或空，选择“其他”时，其对应的子类型不能为空！\n";
					}
				}
			}
			//合同金额校验
			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			if(obj_YN04.value == ""){
				isValid = false;
				errorObjs.push(obj_YN04);
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项合同金额不能为空！\n";
			}
			
			//项目日期校验
			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			if(obj_YN05_01.value ==""){
				isValid = false;
				errorObjs.push(obj_YN05_01);
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项计划上线日期不能为空！\n";
			}
			
			if(obj_YN05_02.value == ""){
				isValid = false;
				errorObjs.push(obj_YN05_02);
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项项目开始日期不能为空！\n";
			}
			if(obj_YN02.value == "完成" && obj_YN05_03.value == ""){
				isValid = false;
				errorObjs.push(obj_YN05_03);
				a += "本季度重大项目" + row + "：本季度实施情况为“已完成”，则此项实际完成时间不能为空！\n";
			}
			if(obj_YN05_03.value != "" &&obj_YN05_02.value != ""){
				
				if(obj_YN05_03.value<obj_YN05_02.value){
					isValid = false;
					errorObjs.push(obj_YN05_03);
					a += "本季度重大项目" + row + "：“实际完成日期”，应大于“计划上线日期”！\n";
				}
			}
			if(obj_YN05_01.value !="" && obj_YN05_02.value != ""){
				if(obj_YN05_01.value<obj_YN05_02.value){
					isValid = false;
					errorObjs.push(obj_YN05_01);
					a += "本季度重大项目" + row + "：“项目开始日期”，应小于“计划上线日期”！\n";
				}
			}
			//实施模式校验
			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			if(obj_YN06.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06);
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项实施模式不能为空！\n";
			}
			
			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber);
			if(obj_YN07.value == ""){
				isValid = false;
				errorObjs.push(obj_YN07.previousSibling);
				a += "本季度重大项目" + row + "：名称不为“无”或空，则此项项目内容描述不能为空！\n";
			}
		} else if (obj_YN01.value == "" &&emptyObj.value == "") {
			isValid = false;
			errorObjs.push(obj_YN01);
			a += "项目名称不能为空！\n";
		}
	}

	// 校验复选中其他是否有值
	for ( var i = 0; i < checkBoxValueObjs.length; i++) {
		var checkBoxObj = checkBoxValueObjs[i];
		if (checkBoxObj.checked) {
			var checkBoxObjValueObj = checkBoxObj.parentElement.nextSibling.nextSibling;
			if (checkBoxObjValueObj.value.indexOf("_cev_") < 0) {
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a += "其他项内容不能为空！\n";
				isValid = false;
			}
		}
	}
	
	if (emptyObj.value == "") {
		if (!isValid && a > "") {
			for ( var i = 0; i < errorObjs.length; i++) {
				if (errorObjs[i].previousSibling == null) {
					errorObjs[i].style.backgroundColor = "red";
				}else if(errorObjs[i].previousSibling.innerHTML.indexOf("其他")>-1){
					errorObjs[i].style.backgroundColor = "red";
				}  else {
					errorObjs[i].parentNode.style.color = "red";
				}
			}
			alert(a);
			a = "";
			isValid = true;
			return false;
		}
	} else if (emptyObj.value == "报送空表") {
		isValid = true;
		var obj_YN01_01 = getTableFormObj(label_YN01_01,"1");
		var obj_YN01_02 = getTableFormObj(label_YN01_02,"1");
		var obj_YN01_03 = getTableFormObj(label_YN01_03,"1");
		var obj_YN01_04 = getTableFormObj(label_YN01_04,"1");
		var obj_YN01_05 = getTableFormObj(label_YN01_05,"1");
		if(obj_YN01_01.value == ""){
			a += "填报部门内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_02.value == ""){
			a += "填报人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_03.value == ""){
			a += "联系电话内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_04.value == ""){
			a += "责任人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN01_05.value == ""){
			a += "填表日期内容不能为空！\n";
			isValid = false;
		}
		if(!isValid){
			alert(a);
			a="";
		}
	}
	return isValid;
}

/*
 * 功能：项目名称有值，则其他功能可填，否则只读 配置：本季度新增的重大项目#本季度新增的重大项目#项目名称
 */
function setOtherUnDisable(obj) {
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for ( var i = 0; i < obj_YN01Arr.length; i++) {
		if (obj_YN01Arr[i].value != "" && obj_YN01Arr[i].value != "无") {
			
			var obj_YN01 = obj_YN01Arr[i];
			var obj_YN02 = getTableFormCheckBox(label_YN02, obj_YN01.rownumber);
			disableTableCheckBox(obj_YN02, false);
			var obj_YN03_01_01 = getTableFormCheckBox(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_011 = getTableFormObj(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_01, false);
			var obj_YN03_01_02 = getTableFormCheckBox(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_021 = getTableFormObj(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_02, false);
			var obj_YN03_01_03 = getTableFormCheckBox(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_031 = getTableFormObj(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_03, false);
			var obj_YN03_01_04 = getTableFormCheckBox(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_041 = getTableFormObj(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_04, false);
			var obj_YN03_01_05 = getTableFormCheckBox(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_051 = getTableFormObj(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_05, false);
			var obj_YN03_01_06 = getTableFormCheckBox(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_061 = getTableFormObj(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_06, false);
			var obj_YN03_01_07 = getTableFormCheckBox(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_071 = getTableFormObj(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_07, false);
			var obj_YN03_01_08 = getTableFormCheckBox(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_081 = getTableFormObj(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_08, false);
			
			var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
					obj_YN01.rownumber + "_1_1");
		
			var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
					obj_YN01.rownumber + "_1_1");
			
			
			if (obj_YN03_01_011.value) {
				disableTableCheckBox(obj_YN03_02_01, false);
			} else {
				disableTableCheckBox(obj_YN03_02_01, true);
			}

			if (obj_YN03_01_021.value) {
				disableTableCheckBox(obj_YN03_02_02, false);
			} else {
				disableTableCheckBox(obj_YN03_02_02, true);
			}
			if (obj_YN03_01_031.value) {
				disableTableCheckBox(obj_YN03_02_03, false);
			} else {
				disableTableCheckBox(obj_YN03_02_03, true);
			}

			if (obj_YN03_01_041.value ) {
				disableTableCheckBox(obj_YN03_02_04, false);
			} else {
				disableTableCheckBox(obj_YN03_02_04, true);
			}

			if (obj_YN03_01_051.value ) {
				disableTableCheckBox(obj_YN03_02_05, false);
			} else {
				disableTableCheckBox(obj_YN03_02_05, true);
			}

			if (obj_YN03_01_061.value) {
				disableTableCheckBox(obj_YN03_02_06, false);
			} else {
				disableTableCheckBox(obj_YN03_02_06, true);
			}

			if (obj_YN03_01_071.value ) {
				disableTableCheckBox(obj_YN03_02_07, false);
			} else {
				disableTableCheckBox(obj_YN03_02_07, true);
			}

			if (obj_YN03_01_081.value) {
				obj_YN03_02_08.readOnly = "";
			} else {
				obj_YN03_02_08.readOnly = "readonly";
				
			}

			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			obj_YN04.readOnly = "";

			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			obj_YN05_01.onclick = click_columnshowDate;
			obj_YN05_02.onclick = click_columnshowDate;
			obj_YN05_03.onclick = click_columnshowDate;
			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			columnVallueRadio0(obj_YN06, true, false);

			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber).previousSibling;
			var obj_YN08 = getTableFormObj(label_YN08, obj_YN01.rownumber).previousSibling;
			obj_YN07.contentEditable = "true";
			obj_YN08.contentEditable = "true";
		} else {
			var obj_YN01 = obj_YN01Arr[i];
			var obj_YN02 = getTableFormCheckBox(label_YN02, obj_YN01.rownumber);
			disableTableCheckBox(obj_YN02, true);
			var obj_YN03_01_01 = getTableFormCheckBox(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_01, true);
			var obj_YN03_01_02 = getTableFormCheckBox(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_02, true);
			var obj_YN03_01_03 = getTableFormCheckBox(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_03, true);
			var obj_YN03_01_04 = getTableFormCheckBox(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_04, true);
			var obj_YN03_01_05 = getTableFormCheckBox(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_05, true);
			var obj_YN03_01_06 = getTableFormCheckBox(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_06, true);
			var obj_YN03_01_07 = getTableFormCheckBox(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_07, true);
			var obj_YN03_01_08 = getTableFormCheckBox(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_08, true);

			var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_01, true);
			var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_02, true);
			var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_03, true);
			var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_04, true);
			var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_05, true);
			var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_06, true);
			var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_07, true);
			var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
					obj_YN01.rownumber + "_1_1");
			obj_YN03_02_08.readOnly = "readonly";
			obj_YN03_02_08.value = "";

			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			obj_YN04.readOnly = "readonly";
			obj_YN04.value = "";

			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			obj_YN05_01.onclick = "";
			obj_YN05_02.onclick = "";
			obj_YN05_03.onclick = "";
			obj_YN05_01.value = "";
			obj_YN05_02.value = "";
			obj_YN05_03.value = "";

			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			columnVallueRadio0(obj_YN06, false, false);
			obj_YN06.value = "";

			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber).previousSibling;
			var obj_YN08 = getTableFormObj(label_YN08, obj_YN01.rownumber).previousSibling;
			obj_YN07.innerHTML = "";
			obj_YN08.innerHTML = "";
			obj_YN07.contentEditable = "false";
			obj_YN08.contentEditable = "false";
		}
	}

}
/*
 * 功能：点击系统类别，其他的checked置为false，子类别根据系统类别来决定是否为只读
 */
function setCheckBoxDisable1(obj_YN01) {
	var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_01) {
		obj_YN03_01_01.value = "";
		obj_YN03_01_01.previousSibling.firstChild.checked = false;
		var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_01, true);
	}

	var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_02) {
		obj_YN03_01_02.value = "";
		obj_YN03_01_02.previousSibling.firstChild.checked = false;
		var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_02, true);
	}

	var obj_YN03_01_03 = getTableFormObj(label_YN03_01_03, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_03) {
		obj_YN03_01_03.value = "";
		obj_YN03_01_03.previousSibling.firstChild.checked = false;
		var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_03, true);
	}

	var obj_YN03_01_04 = getTableFormObj(label_YN03_01_04, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_04) {
		obj_YN03_01_04.value = "";
		obj_YN03_01_04.previousSibling.firstChild.checked = false;
		var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_04, true);
	}

	var obj_YN03_01_05 = getTableFormObj(label_YN03_01_05, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_05) {
		obj_YN03_01_05.value = "";
		obj_YN03_01_05.previousSibling.firstChild.checked = false;
		var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_05, true);
	}

	var obj_YN03_01_06 = getTableFormObj(label_YN03_01_06, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_06) {
		obj_YN03_01_06.value = "";
		obj_YN03_01_06.previousSibling.firstChild.checked = false;
		var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_06, true);
	}

	var obj_YN03_01_07 = getTableFormObj(label_YN03_01_07, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_07) {
		obj_YN03_01_07.value = "";
		obj_YN03_01_07.previousSibling.firstChild.checked = false;
		var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_07, true);
	}

	var obj_YN03_01_08 = getTableFormObj(label_YN03_01_08, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_08) {
		obj_YN03_01_08.value = "";
		obj_YN03_01_08.previousSibling.firstChild.checked = false;
		var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
				obj_YN01.rownumber);
		obj_YN03_02_08.readOnly = "readonly";
		obj_YN03_02_08.value = "";
	}
}

/*
 * 功能：初始化
 */
function initSet() {
	setOtherUnDisable();
}

/*
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio0(obj, access, flag) {
	if (!access) {
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					if (!access) {
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setYN10_05Disable(this);
							};
						}
					}
				}
			}
		}
	}
}
/*
 * 功能：恢复日期输入
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * 功能：点击复选框复选框中的其他，将起放入数组中，在提交的时候校验其他的内容是否为空
 * 
 */
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj) {
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if (obj.checked) {
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	} else {
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for ( var i = 0; i < strs.length; i++) {
			if (strs[i].indexOf("_cev_") < 0) {
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);

	}
}