/*
 * 报表：2014 -T-B-2 信息科技风险管理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs=[];
var label_YN01_03 = "信息科技风险管理制度#内容#机构负责制定信息科技风险管理制度的部门";
//信息科技风险评估与处置表单
var label_YN02_01 = "信息科技风险评估与处置#内容#1#评估起止时间#1";
var label_YN02_02 = "信息科技风险评估与处置#内容#1#评估起止时间#2";
//信息科技风险监测表单
var label_YN03_01 = "信息科技风险监测#内容#建立信息科技风险监测关键风险点指标";
var label_YN03_02 = "信息科技风险监测#内容#关键风险点指标总数";
var label_YN03_03 = "信息科技风险监测#内容#本年度风险监测结果向各相关部门进行风险提示";
var label_YN03_04 = "信息科技风险监测#内容#风险提示次数";
var label_YN03_05 = "信息科技风险监测#内容#本年度风险监测结果向高管层汇报";
var label_YN03_06 = "信息科技风险监测#内容#汇报次数";
var label_YN03_07 = "信息科技风险监测#内容#实施信息科技风险监测的部门";
//信息科技风险问责
var label_YN04_01 = "信息科技风险问责#内容#本年度对信息科技风险事件进行问责";
var label_YN04_02 = "信息科技风险问责#内容#问责人次";
//信息科技风险管理持续改进
var label_YN05_01 = "信息科技风险管理持续改进#内容#对信息科技风险管理制度定期修订，并将修订后的制度正式发布";
var label_YN05_02 = "信息科技风险管理持续改进#内容#修订次数";
var label_YN05_03 = "信息科技风险管理持续改进#内容#对风险评估方法和流程、风险监测指标定期进行评审";
var label_YN05_04 = "信息科技风险管理持续改进#内容#评审频率";
//测试用
var label_YN01_02 = "信息科技风险评估与处置#内容#风险处置措施落实情况的监督部门";


/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	setYN03_02Disable(obj);
	setYN03_04Disable(obj);
	setYN03_06Disable(obj);
	setYN04_02Disable(obj);
	setYN05_02Disable(obj);
	setYN05_04Disable(obj);
}

//单选其他赋值为其他部门
function setOtherValue(obj){
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	alert(obj_YN01_03.value);
} 

/*
* 功能：校验岂止日期的大小
* 配置：信息科技风险评估与处置#内容#1#评估起止时间
*/
function checkChangeDate(obj){
	var rownumber = obj.rownumber;
	var obj_YN02_01 = getTableFormObj(label_YN02_01,rownumber);
	var obj_YN02_02 = getTableFormObj(label_YN02_02,rownumber);
	if(obj_YN02_01.value != "" && obj_YN02_02.value != ""){
		if(obj_YN02_01.value > obj_YN02_02.value){
			 alert("结束日期不能小于开始日期！");
			 obj_YN02_01.value = "";
		}
	}
}

/*
* 功能：风险提示次数是否读写
* 配置：信息科技风险监测#内容#关键风险点指标总数
*/
function setYN03_02Disable(objcld){
	var objYN03_01 = getTableFormObjs(label_YN03_01)[0];
	var objYN03_02 = getTableFormObj(label_YN03_02,objYN03_01.rownumber );
	if (objYN03_01.value.trim() == "否" || objYN03_01.value.trim() == "") {
		//只读
		objYN03_02.readOnly = "readonly";
		//清空
		objYN03_02.value = "";
	}else if (objYN03_01.value.trim() == "是") {
		objYN03_02.readOnly = "";
	}
}

/*
* 功能：关键风险点指标总数是否读写
* 配置：信息科技风险监测#内容#风险提示次数
*/
function setYN03_04Disable(objcld){
	var objYN03_03 = getTableFormObjs(label_YN03_03)[0];
	var objYN03_04 = getTableFormObj(label_YN03_04,objYN03_03.rownumber );
	if (objYN03_03.value.trim() == "否" || objYN03_03.value.trim() == "") {
		//只读
		objYN03_04.readOnly = "readonly";
		//清空
		objYN03_04.value = "";
	}else if (objYN03_03.value.trim() == "是") {
		objYN03_04.readOnly = "";
	}
}

/*
* 功能：汇报次数是否读写
* 配置：信息科技风险监测#内容#汇报次数
*/
function setYN03_06Disable(objcld){
	var objYN03_05 = getTableFormObjs(label_YN03_05)[0];
	var objYN03_06 = getTableFormObj(label_YN03_06,objYN03_05.rownumber );
	if (objYN03_05.value.trim() == "否" || objYN03_05.value.trim() == "") {
		//只读
		objYN03_06.readOnly = "readonly";
		//清空
		objYN03_06.value = "";
	}else if (objYN03_05.value.trim() == "是") {
		objYN03_06.readOnly = "";
	}
}

/*
* 功能：问责人次是否读写 
* 配置：信息科技风险问责#内容#问责人次
*/
function setYN04_02Disable(objcld){
	var objYN04_01 = getTableFormObjs(label_YN04_01)[0];
	var objYN04_02 = getTableFormObj(label_YN04_02,objYN04_01.rownumber );
	if (objYN04_01.value.trim() == "否" || objYN04_01.value.trim() == "") {
		//只读
		objYN04_02.readOnly = "readonly";
		//清空
		objYN04_02.value = "";
	}else if (objYN04_01.value.trim() == "是") {
		objYN04_02.readOnly = "";
	}
}

/*
* 功能：修订次数是否读写 
* 配置：信息科技风险管理持续改进#内容#修订次数
*/
function setYN05_02Disable(objcld){
	var objYN05_01 = getTableFormObjs(label_YN05_01)[0];
	var objYN05_02 = getTableFormObj(label_YN05_02,objYN05_01.rownumber );
	if (objYN05_01.value.trim() == "否" || objYN05_01.value.trim() == "") {
		//只读
		objYN05_02.readOnly = "readonly";
		//清空
		objYN05_02.value = "";
	}else if (objYN05_01.value.trim() == "是") {
		objYN05_02.readOnly = "";
	}
}

/*
* 功能：评审频率是否读写 
* 配置：信息科技风险管理持续改进#内容#评审频率
*/
function setYN05_04Disable(objcld){
	var objYN05_03 = getTableFormObjs(label_YN05_03)[0];
	var objYN05_04 = getTableFormObj(label_YN05_04,objYN05_03.rownumber );
	if (objYN05_03.value.trim() == "否" || objYN05_03.value.trim() == "") {
		//只读
		objYN05_04.readOnly = "readonly";
		//清空
		objYN05_04.value = "";
	}else if (objYN05_03.value.trim() == "是") {
		objYN05_04.readOnly = "";
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
	//信息科技风险监测表单校验
	var objYN03_01 = getTableFormObjs(label_YN03_01)[0];
	var objYN03_02 = getTableFormObj(label_YN03_02,objYN03_01.rownumber );
	if (objYN03_01.value.trim() == "是" && objYN03_02.value =="") {
		errorObjs.push(objYN03_02);
		a+="信息科技风险监测-关键风险点指标总数项：不能为空！\n";
		isValid=false;
	}
	var objYN03_03 = getTableFormObjs(label_YN03_03)[0];
	var objYN03_04 = getTableFormObj(label_YN03_04,objYN03_03.rownumber );
	if (objYN03_03.value.trim() == "是" && objYN03_04.value == "") {
		errorObjs.push(objYN03_04);
		a+="信息科技风险监测-风险提示次数项：不能为空！\n";
		isValid=false;
	}
	var objYN03_05 = getTableFormObjs(label_YN03_05)[0];
	var objYN03_06 = getTableFormObj(label_YN03_06,objYN03_05.rownumber );
	if (objYN03_05.value.trim() == "是" && objYN03_06.value == "") {
		errorObjs.push(objYN03_06);
		a+="信息科技风险监测-汇报次数项：不能为空！\n";
		isValid=false;
	}
	//信息科技风险问责校验
	var objYN04_01 = getTableFormObjs(label_YN04_01)[0];
	var objYN04_02 = getTableFormObj(label_YN04_02,objYN04_01.rownumber );
	if (objYN04_01.value.trim() == "是" && objYN04_02.value =="") {
		errorObjs.push(objYN04_02);
		a+="信息科技风险问责-问责人次项：不能为空！\n";
		isValid=false;
	}
	//信息科技风险管理持续改进校验
	var objYN05_01 = getTableFormObjs(label_YN05_01)[0];
	var objYN05_02 = getTableFormObj(label_YN05_02,objYN05_01.rownumber );
	if (objYN05_01.value.trim() == "是" && objYN05_02.value =="") {
		errorObjs.push(objYN05_02);
		a+="信息科技风险管理持续改进-修订次数项：不能为空！\n";
		isValid=false;
	}
	var objYN05_03 = getTableFormObjs(label_YN05_03)[0];
	var objYN05_04 = getTableFormObj(label_YN05_04,objYN05_03.rownumber );
	if (objYN05_03.value.trim() == "是" && objYN05_04.value == "") {
		errorObjs.push(objYN05_04);
		a+="信息科技风险监测-风险提示次数项：不能为空！\n";
		isValid=false;
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

function checkBoxValue(obj){
	var obj = getTableFormObjs(label_YN01_02)[0];
}

/*
* 功能：数字控件大于0
* 
*/
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("请按规范填写"+errorMessage+"，数值不能小于0\n");
	}
}

/*
* 功能：点击复选框复选框中的其他，将起放入数组中，在提交的时候校验其他的内容是否为空 
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
