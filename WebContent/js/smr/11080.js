/*
 * 报表：T-B-10 重要信息系统基本情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

// 部分重要信息系统详细情况
var label_YN02_02_01 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#开发模式#开发模式";
var label_YN02_02_02 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#开发模式#外包商名称";
var label_YN02_03_01 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#运维模式#运维模式";
var label_YN02_03_02 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#运维模式#外包商名称";
var label_YN02_04_01 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#知识产权#知识产权";
var label_YN02_04_02 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#1#知识产权#他有方名称";

var label_YN03_03 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#2#托管于外部机构#托管于外部机构";
var label_YN03_04 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#2#托管于外部机构#托管机构名称";

var label_YN04_03 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#3#备份数据异地保存#备份数据异地保存";
var label_YN04_04 = "部分重要信息系统详细情况#框架#系统类别#1#系统类别#3#备份数据异地保存#保存地点";

var label_YN05_03 = "部分重要信息系统详细情况#框架#系统类别#2#11#本年度开展应急演练#本年度开展应急演练";
var label_YN05_04 = "部分重要信息系统详细情况#框架#系统类别#2#11#本年度开展应急演练#演练次数";

var label_YN03 = "部分重要信息系统详细情况#框架#系统名称";

var label_YN06_01_01 = "部分重要信息系统详细情况#框架#系统类别#2#11#灾备情况#灾备情况#同城异地灾备";
var label_YN06_02_01 = "部分重要信息系统详细情况#框架#系统类别#2#11#灾备情况#灾备情况#1#同城";
var label_YN06_02_02 = "部分重要信息系统详细情况#框架#系统类别#2#11#灾备情况#灾备情况#1#异地";

var label_YN01_01_01 = "重要信息系统基本情况#数量#项目内容#重要信息系统总数";

var label_YN01_02_01 = "重要信息系统基本情况#类别#项目内容#渠道管理类";
var label_YN01_02_02 = "重要信息系统基本情况#类别#项目内容#客户管理类";
var label_YN01_02_03 = "重要信息系统基本情况#类别#项目内容#产品管理类";
var label_YN01_02_04 = "重要信息系统基本情况#类别#项目内容#财务管理类";
var label_YN01_02_05 = "重要信息系统基本情况#类别#项目内容#决策支持类";
var label_YN01_02_06 = "重要信息系统基本情况#类别#项目内容#共享支持类";
var label_YN01_02_07 = "重要信息系统基本情况#类别#项目内容#其他";

var label_YN01_05_01 = "重要信息系统基本情况#开发模式#项目内容#自主研发";
var label_YN01_05_02 = "重要信息系统基本情况#开发模式#项目内容#整体外包";
var label_YN01_05_03 = "重要信息系统基本情况#开发模式#项目内容#部分外包";

var label_YN01_06_01 = "重要信息系统基本情况#运维模式#项目内容#自主运维";
var label_YN01_06_02 = "重要信息系统基本情况#运维模式#项目内容#整体外包";
var label_YN01_06_03 = "重要信息系统基本情况#运维模式#项目内容#部分外包";

var label_YN01_07_01 = "重要信息系统基本情况#知识产权#项目内容#自有";
var label_YN01_07_02 = "重要信息系统基本情况#知识产权#项目内容#共有";
var label_YN01_07_03 = "重要信息系统基本情况#知识产权#项目内容#他有";

var label_YN01_04_01 = "重要信息系统基本情况#灾备情况#项目内容#纳入灾备的重要信息系统数";
var label_YN01_04_02 = "重要信息系统基本情况#灾备情况#项目内容#其中，实现数据级灾备";
var label_YN01_04_03 = "重要信息系统基本情况#灾备情况#项目内容#实现系统级灾备";
var label_YN01_04_04 = "重要信息系统基本情况#灾备情况#项目内容#实现应用级灾备";
var label_YN01_04_05 = "重要信息系统基本情况#灾备情况#项目内容#仅纳入同城灾备";
var label_YN01_04_06 = "重要信息系统基本情况#灾备情况#项目内容#仅纳入异地灾备";
var label_YN01_04_07 = "重要信息系统基本情况#灾备情况#项目内容#纳入同城又纳入异地灾备";

var label_YN01_04_16 = "重要信息系统基本情况#灾备情况#项目内容#已制定应急预案的重要信息系统数";
var label_YN01_04_17 = "重要信息系统基本情况#灾备情况#项目内容#重要信息系统应急预案覆盖率";
var label_YN01_04_18 = "重要信息系统基本情况#灾备情况#项目内容#本年度已开展应急演练的重要信息系统数";
var label_YN01_04_19 = "重要信息系统基本情况#灾备情况#项目内容#本年度重要信息系统应急演练覆盖率";
/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#灾备情况#灾备情况#同城灾备#灾备级
 */
function setObj_YN06_02_01Or02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.value == "同城灾备") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN06_01_01 = getTableFormObj(label_YN06_01_01,rownumber);
			obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,obj_YN06_01_01.rownumber+"_1");
			obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,obj_YN06_01_01.rownumber+"_1");
			if(obj_YN06_01_01.value.indexOf("同")>-1){
				columnVallueRadio1(obj_YN06_02_01,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_01,false,false);
				obj_YN06_02_01.value = "";
			}
			if(obj_YN06_01_01.value.indexOf("异")>-1){
				columnVallueRadio1(obj_YN06_02_02,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_02,false,false);
				obj_YN06_02_02.value = "";
			}
		}
	}else{
		var obj_YN06_01_01Arr = getTableFormObjs(label_YN06_01_01);
		for ( var i = 0; i < obj_YN06_01_01Arr.length; i++) {
			obj_YN06_01_01 = obj_YN06_01_01Arr[i];
			obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,obj_YN06_01_01.rownumber+"_1");
			obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,obj_YN06_01_01.rownumber+"_1");
			if(obj_YN06_01_01.value.indexOf("同")>-1){
				columnVallueRadio1(obj_YN06_02_01,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_01,false,false);
				obj_YN06_02_01.value = "";
			}
			if(obj_YN06_01_01.value.indexOf("异")>-1){
				columnVallueRadio1(obj_YN06_02_02,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_02,false,false);
				obj_YN06_02_02.value = "";
			}
		}
	}
	
	
}


/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第四层#本年度开展应急演练#演练次数
 */
function setObj_YN05_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN05_03 = getTableFormObj(label_YN05_03,rownumber);
			var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
			if (obj_YN05_03.value == "是") {
				obj_YN05_04.readOnly = "";
			} else {

				obj_YN05_04.readOnly = "readonly";
				obj_YN05_04.value = "";
			}
		}
	}else{
		var obj_YN05_03Arr = getTableFormObjs(label_YN05_03);
		for ( var i = 0; i < obj_YN05_03Arr.length; i++) {
			var obj_YN05_03 = obj_YN05_03Arr[i];
			var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
			if (obj_YN05_03.value == "是") {
				obj_YN05_04.readOnly = "";
			} else {

				obj_YN05_04.readOnly = "readonly";
				obj_YN05_04.value = "";
			}
		}
	}
	
	

}

/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第三层#备份数据异地保存#保存地点
 */
function setObj_YN04_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN04_03 = getTableFormObj(label_YN04_03,rownumber);
			var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
			if (obj_YN04_03.value == "是") {
				obj_YN04_04.readOnly = "";
			} else {

				obj_YN04_04.readOnly = "readonly";
				obj_YN04_04.value = "";
			}
		}
	}else{
		var obj_YN04_03Arr = getTableFormObjs(label_YN04_03);
		for ( var i = 0; i < obj_YN04_03Arr.length; i++) {
			var obj_YN04_03 = obj_YN04_03Arr[i];
			var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
			if (obj_YN04_03.value == "是") {
				obj_YN04_04.readOnly = "";
			} else {

				obj_YN04_04.readOnly = "readonly";
				obj_YN04_04.value = "";
			}
		}
	}
	
	

}

/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第二层#托管于外部机构#托管机构名称
 */
function setObj_YN03_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "是") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN03_03 = getTableFormObj(label_YN03_03,rownumber);
			var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
			if (obj_YN03_03.value == "是") {
				obj_YN03_04.readOnly = "";
			} else {

				obj_YN03_04.readOnly = "readonly";
				obj_YN03_04.value = "";
			}
		}
	}else{
		var obj_YN03_03Arr = getTableFormObjs(label_YN03_03);
		for ( var i = 0; i < obj_YN03_03Arr.length; i++) {
			var obj_YN03_03 = obj_YN03_03Arr[i];
			var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
			if (obj_YN03_03.value == "是") {
				obj_YN03_04.readOnly = "";
			} else {

				obj_YN03_04.readOnly = "readonly";
				obj_YN03_04.value = "";
			}
		}
	}
	
	
	
}

/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第二层#运维模式#运维模式
 */
function setLabel_YN02_04_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "自有") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "共有"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_04_01 = getTableFormObj(label_YN02_04_01,rownumber);
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
					obj_YN02_04_01.rownumber);
			if (obj_YN02_04_01.value == "共有" || obj_YN02_04_01.value == "他有") {
				obj_YN02_04_02.readOnly = "";
				obj_YN02_04_02.value = "";
			} else {
				obj_YN02_04_02.readOnly = "readonly";
				obj_YN02_04_02.value = "";
			}
		}
	}else{
		var obj_YN02_04_01Arr = getTableFormObjs(label_YN02_04_01);
		for ( var i = 0; i < obj_YN02_04_01Arr.length; i++) {
			var obj_YN02_04_01 = obj_YN02_04_01Arr[i];
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
					obj_YN02_04_01.rownumber);
			if (obj_YN02_04_01.value == "共有" || obj_YN02_04_01.value == "他有") {
				obj_YN02_04_02.readOnly = "";
			} else {
				obj_YN02_04_02.readOnly = "readonly";
				obj_YN02_04_02.value = "";
			}
		}
	}
	
	

}

/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第二层#运维模式#运维模式
 */
function setLabel_YN02_03_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "自主运维") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "整体外包"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_03_01 = getTableFormObj(label_YN02_03_01,rownumber);
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
					obj_YN02_03_01.rownumber);
			if (obj_YN02_03_01.value == "整体外包" || obj_YN02_03_01.value == "部分外包") {
				obj_YN02_03_02.readOnly = "";
				obj_YN02_03_02.value = "";
			} else {
				obj_YN02_03_02.readOnly = "readonly";
				obj_YN02_03_02.value = "";
			}
		}
	}else{
		var obj_YN02_03_01Arr = getTableFormObjs(label_YN02_03_01);
		for ( var i = 0; i < obj_YN02_03_01Arr.length; i++) {
			var obj_YN02_03_01 = obj_YN02_03_01Arr[0];
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
					obj_YN02_03_01.rownumber);
			if (obj_YN02_03_01.value == "整体外包" || obj_YN02_03_01.value == "部分外包") {
				obj_YN02_03_02.readOnly = "";

			} else {
				obj_YN02_03_02.readOnly = "readonly";
				obj_YN02_03_02.value = "";
			}
		}
	}
}

/*
 * 功能：根据单选按钮修改表单是否可读写 配置：部分重要信息系统详细情况#框架#系统类别#第一层#开发模式#开发模式
 */
function setLabel_YN02_02_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "自主研发") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "整体外包"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_02_01 = getTableFormObj(label_YN02_02_01,rownumber);
			var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
					obj_YN02_02_01.rownumber);
			if (obj_YN02_02_01.value == "整体外包" || obj_YN02_02_01.value == "部分外包") {
				obj_YN02_02_02.readOnly = "";
				obj_YN02_02_02.value = "";
			} else {
				obj_YN02_02_02.readOnly = "readonly";
				obj_YN02_02_02.value = "";
			}
		}
	}else{
		var obj_YN02_02_01Arr = getTableFormObjs(label_YN02_02_01);
		for ( var i = 0; i < obj_YN02_02_01Arr.length; i++) {
			var obj_YN02_02_01 = obj_YN02_02_01Arr[0];
			var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
					obj_YN02_02_01.rownumber);
			if (obj_YN02_02_01.value == "整体外包" || obj_YN02_02_01.value == "部分外包") {
				obj_YN02_02_02.readOnly = "";
			} else {
				obj_YN02_02_02.readOnly = "readonly";
				obj_YN02_02_02.value = "";
			}
		}
	}
	
	
	
	

}
/*
 * 功能：初始化页面
 * 
 */
function initSet() {
	jQuery("table[id = '1108001526_tableForm']").parent().css("width", "405px")
			.css("overflow-x", "scroll");
	var obj = null;
	setLabel_YN02_02_02Disable(obj);
	setLabel_YN02_03_02Disable(obj);
	setLabel_YN02_04_02Disable(obj);
	setObj_YN03_04Disable(obj);
	setObj_YN04_04Disable(obj);
	setObj_YN05_04Disable(obj);
	setObj_YN06_02_01Or02Disable(obj);
}

/*
 * 功能：提交校验
 * 
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	var obj_YN03Arr = getTableFormObjs(label_YN03);
	for ( var i = 0; i < obj_YN03Arr.length-1; i++) {
		var obj_YN02_02_01 = getTableFormObjs(label_YN02_02_01)[i];
		var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
				obj_YN02_02_01.rownumber);
		if ((obj_YN02_02_01.value == "整体外包" || obj_YN02_02_01.value == "部分外包")
				&& obj_YN02_02_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_02_02);
			a += "开发模式，外包商名称：不能为空！\n";
		}
		var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[i];
		var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
				obj_YN02_03_01.rownumber);
		if ((obj_YN02_03_01.value == "整体外包" || obj_YN02_03_01.value == "部分外包")
				&& obj_YN02_03_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_03_02);
			a += "运维模式，外包商名称：不能为空！\n";

		}
		var obj_YN02_04_01 = getTableFormObjs(label_YN02_04_01)[i];
		var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
				obj_YN02_04_01.rownumber);
		if ((obj_YN02_04_01.value == "共有" || obj_YN02_04_01.value == "他有")
				&& obj_YN02_04_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_04_02);
			a += "知识产权，他有方名称：不能为空！\n";
		}
		var obj_YN03_03 = getTableFormObjs(label_YN03_03)[i];
		var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
		if (obj_YN03_03.value == "是" && obj_YN03_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN03_04);
			a += "托管机构名称：不能为空！\n";
		}
		var obj_YN04_03 = getTableFormObjs(label_YN04_03)[i];
		var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
		if (obj_YN04_03.value == "是" && obj_YN04_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN04_04);
			a += "保存地点：不能为空！\n";
		}
		var obj_YN05_03 = getTableFormObjs(label_YN05_03)[i];
		var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
		if (obj_YN05_03.value == "是" && obj_YN05_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN05_04);
			a += "演练次数：不能为空！\n";
		}
		var obj_YN06_01_01 = getTableFormObjs(label_YN06_01_01)[i];
		var obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,
				obj_YN06_01_01.rownumber+"_1");
		var obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,
				obj_YN06_01_01.rownumber+"_1");
		
		if (obj_YN06_01_01.value == "") {
			isValid = false;
			errorObjs.push(obj_YN06_01_01);
			a += "同城灾备或异地灾备选项：不能为空！\n";
		}else{
			if(obj_YN06_01_01.value.indexOf("同")>-1 &&obj_YN06_02_01.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06_02_01);
				a += "同城灾备级别选项：不能为空！\n";
			}
			if(obj_YN06_01_01.value.indexOf("异")>-1 &&obj_YN06_02_02.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06_02_02);
				a += "异地灾备级别选项：不能为空！\n";
			}
		}
	}
	var obj_YN01_01_01 = getTableFormObjs(label_YN01_01_01)[0];
	var obj_YN01_02_01 = getTableFormObjs(label_YN01_02_01)[0];
	var obj_YN01_02_02 = getTableFormObjs(label_YN01_02_02)[0];
	var obj_YN01_02_03 = getTableFormObjs(label_YN01_02_03)[0];
	var obj_YN01_02_04 = getTableFormObjs(label_YN01_02_04)[0];
	var obj_YN01_02_05 = getTableFormObjs(label_YN01_02_05)[0];
	var obj_YN01_02_06 = getTableFormObjs(label_YN01_02_06)[0];
	var obj_YN01_02_07 = getTableFormObjs(label_YN01_02_07)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_02_01.value)
			+ parseInt(obj_YN01_02_02.value) + parseInt(obj_YN01_02_03.value)
			+ parseInt(obj_YN01_02_04.value) + parseInt(obj_YN01_02_05.value)
			+ parseInt(obj_YN01_02_06.value) + parseInt(obj_YN01_02_07.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_02_01);
		errorObjs.push(obj_YN01_02_02);
		errorObjs.push(obj_YN01_02_03);
		errorObjs.push(obj_YN01_02_04);
		errorObjs.push(obj_YN01_02_05);
		errorObjs.push(obj_YN01_02_06);
		errorObjs.push(obj_YN01_02_07);
		a += "重要信息系统总数＝渠道管理类+客户管理类+产品管理类+财务管理类+决策支持类+共享支持类+其他类别重要信息系统数！\n";
	}
	var obj_YN01_05_01 = getTableFormObjs(label_YN01_05_01)[0];
	var obj_YN01_05_02 = getTableFormObjs(label_YN01_05_02)[0];
	var obj_YN01_05_03 = getTableFormObjs(label_YN01_05_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_05_01.value)
			+ parseInt(obj_YN01_05_02.value) + parseInt(obj_YN01_05_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_05_01);
		errorObjs.push(obj_YN01_05_02);
		errorObjs.push(obj_YN01_05_03);
		a+="重要信息系统总数＝自主研发+整体外包+部分外包！\n";
	}
	var obj_YN01_06_01 = getTableFormObjs(label_YN01_06_01)[0];
	var obj_YN01_06_02 = getTableFormObjs(label_YN01_06_02)[0];
	var obj_YN01_06_03 = getTableFormObjs(label_YN01_06_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_06_01.value)
			+ parseInt(obj_YN01_06_02.value) + parseInt(obj_YN01_06_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_06_01);
		errorObjs.push(obj_YN01_06_02);
		errorObjs.push(obj_YN01_06_03);
		a+="重要信息系统总数＝自主运维+整体外包+部分外包！\n";
	}
	var obj_YN01_07_01 = getTableFormObjs(label_YN01_07_01)[0];
	var obj_YN01_07_02 = getTableFormObjs(label_YN01_07_02)[0];
	var obj_YN01_07_03 = getTableFormObjs(label_YN01_07_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_07_01.value)
			+ parseInt(obj_YN01_07_02.value) + parseInt(obj_YN01_07_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_07_01);
		errorObjs.push(obj_YN01_07_02);
		errorObjs.push(obj_YN01_07_03);
		a+="重要信息系统总数＝自有+共有+他有！\n";
	}
	var obj_YN01_04_01 = getTableFormObjs(label_YN01_04_01)[0];
	var obj_YN01_04_02 = getTableFormObjs(label_YN01_04_02)[0];
	var obj_YN01_04_03 = getTableFormObjs(label_YN01_04_03)[0];
	var obj_YN01_04_04 = getTableFormObjs(label_YN01_04_04)[0];
	if (parseInt(obj_YN01_04_01.value) != parseInt(obj_YN01_04_02.value)
			+ parseInt(obj_YN01_04_03.value) + parseInt(obj_YN01_04_04.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_04_02);
		errorObjs.push(obj_YN01_04_03);
		errorObjs.push(obj_YN01_04_04);
		a+="纳入灾备的重要信息系统＝实现应用级灾备重要信息系统数+实现系统级灾备重要信息系统数+实现数据级灾备重要信息系统数！\n";
	}
	var obj_YN01_04_05 = getTableFormObjs(label_YN01_04_05)[0];
	var obj_YN01_04_06 = getTableFormObjs(label_YN01_04_06)[0];
	var obj_YN01_04_07 = getTableFormObjs(label_YN01_04_07)[0];
	if (parseInt(obj_YN01_04_01.value) != parseInt(obj_YN01_04_05.value)
			+ parseInt(obj_YN01_04_06.value) + parseInt(obj_YN01_04_07.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_04_05);
		errorObjs.push(obj_YN01_04_06);
		errorObjs.push(obj_YN01_04_07);
		a+="纳入灾备的重要信息系统＝仅纳入同城灾备的重要信息系统数+仅纳入异地灾备的重要信息系统数+纳入同城又纳入异地灾备的重要信息系统数！\n";
	}
	var obj_YN01_04_16 = getTableFormObjs(label_YN01_04_16)[0];
	var obj_YN01_04_18 = getTableFormObjs(label_YN01_04_18)[0];
	if(parseInt(obj_YN01_04_16.value)<parseInt(obj_YN01_04_18.value)){
		 a+="已制定应急预案的重要信息系统数>＝本年度已开展应急演练的重要信息系统数！\n";
		 isValid=false;
		 errorObjs.push(obj_YN01_04_18);
	}
	var obj_YN01_04_17 = getTableFormObjs(label_YN01_04_17)[0];
	var obj_YN01_04_19 = getTableFormObjs(label_YN01_04_19)[0];
	if(parseInt(obj_YN01_04_17.value)<parseInt(obj_YN01_04_19.value)){
		 a+="重要信息系统应急预案覆盖率>＝本年度重要信息系统应急演练覆盖数率！\n";
		 isValid=false;
		 errorObjs.push(obj_YN01_04_19);
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

	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("其他") > -1) {
				errorObjs[i].style.backgroundColor = "red";
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
 * 功能：判断表单内容是否大于100
 */
function checkPercent(obj) {
	if (obj.value > 100 || obj.value < 0) {
		obj.value = "";
		alert("请输入0-100的数值");
	}

}

/*
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio1(obj, access, flag) {
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

//初始化样式
jQuery(function() {
	if(jQuery("#psdid").val()!=jQuery("#pdid").val()+"003"){
		var pdid = jQuery("#pdid").val();
		jQuery("#"+pdid+"484_tableForm").css("width","815px"); 
	}
});