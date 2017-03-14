/*
 * 报表：2014 -T-B-1 信息科技治理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs=[];

/*
* 功能：点击复选框复选框中的其他，将其放入数组中，在提交的时候校验其他的内容是否为空 
* 
*/
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj){
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if(obj.checked){
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	}else{
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);
		
	}
}

//表单验证
function checkData(){
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	//增加必填校验  start
	var obj_TITLE_01 = getTableFormObj("标题#填报部门","1");
	if(obj_TITLE_01){
		if(obj_TITLE_01.value == ""){
			errorObjs.push(obj_TITLE_01);
			isValid = false;
			a += "填报部门不能为空！\n";
		}
	}
	var obj_TITLE_02 = getTableFormObj("标题#填报人","1");
	if(obj_TITLE_02){
		if(obj_TITLE_02.value == ""){
			errorObjs.push(obj_TITLE_02);
			isValid = false;
			a += "填报人不能为空！\n";
		}
	}
	var obj_TITLE_03 = getTableFormObj("标题#联系电话","1");
	if(obj_TITLE_03){
		if(obj_TITLE_03.value == ""){
			errorObjs.push(obj_TITLE_03);
			isValid = false;
			a += "联系电话不能为空！\n";
		}
	}
	var obj_TITLE_04 = getTableFormObj("标题#责任人","1");
	if(obj_TITLE_04){
		if(obj_TITLE_04.value == ""){
			errorObjs.push(obj_TITLE_04);
			isValid = false;
			a += "责任人不能为空！\n";
		}
	}
	var obj_TITLE_05 = getTableFormObj("标题#填表日期","1");
	if(obj_TITLE_05){
		if(obj_TITLE_05.value == ""){
			errorObjs.push(obj_TITLE_05);
			isValid = false;
			a += "填表日期不能为空！\n";
		}
	}
	// 发现时间
	var obj_YN01 = getTableFormObjs("#组模式#发现时间#内容#时间");
	for(var i = 0;i<obj_YN01.length;i++){
		var obj_YN01_01 = obj_YN01[i];
		var obj_YN01_01_num = obj_YN01_01.rownumber.indexOf("_#_");
		if(obj_YN01_01.value == "" && obj_YN01_01_num != "0"){
			errorObjs.push(obj_YN01_01);
			isValid = false;
			a += "基础软硬件产品缺陷信息表"+(i+1)+":'发现时间'不能为空！\n";
		}
	}
	// 缺陷信息具体联系人,联系人
	var obj_YN03 = getTableFormObjs("#组模式#缺陷信息具体联系人#内容#联系人");
	for(var i = 0;i<obj_YN03.length;i++){
		var obj_YN03_01 = obj_YN03[i];
		var obj_YN03_01_num = obj_YN03_01.rownumber.indexOf("_#_");
		if(obj_YN03_01.value == "" && obj_YN03_01_num != "0"){
			errorObjs.push(obj_YN03_01);
			isValid = false;
			a += "基础软硬件产品缺陷信息表"+(i+1)+":'缺陷信息具体联系人 联系人'不能为空！\n";
		}
	}
	// 缺陷信息具体联系人,联系电话
	var obj_YN02 = getTableFormObjs("#组模式#缺陷信息具体联系人#内容#联系电话");
	for(var i = 0;i<obj_YN02.length;i++){
		var obj_YN02_01 = obj_YN02[i];
		var obj_YN02_01_num = obj_YN02_01.rownumber.indexOf("_#_");
		if(obj_YN02_01.value == "" && obj_YN02_01_num != "0"){
			errorObjs.push(obj_YN02_01);
			isValid = false;
			a += "基础软硬件产品缺陷信息表"+(i+1)+":'缺陷信息具体联系人 联系电话'不能为空！\n";
		}
	}
	
	//校验复选中其他是否有值
	for(var i = 0;i<checkBoxValueObjs.length;i++){
		var checkBoxObj = checkBoxValueObjs[i];
		if(checkBoxObj.checked){
			var checkBoxObjValueObj= checkBoxObj.parentElement.nextSibling.nextSibling;
			if(checkBoxObjValueObj.value.indexOf("_cev_")<0){
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a+="其他项内容不能为空！\n";
				isValid=false;
			}
		}
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null ) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("其他")>-1){
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