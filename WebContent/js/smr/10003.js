/*
 * 报表：T-B-4 信息科技项目管理情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item5 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填报日期";
var label_DecimalField2_GTZero = "本年度项目情况#内容#本年度新增立项项目#本年度新增立项项目";
var label_DecimalField3_GTZero = "本年度项目情况#内容#本年度新增立项项目#其中#重大项目";
var label_DecimalField4_GTZero = "本年度项目情况#内容#本年度新增立项项目#其中#一般项目";
var label_DecimalField5_GTZero = "本年度项目情况#内容#本年度完成项目#本年度完成项目";
var label_DecimalField6_GTZero = "本年度项目情况#内容#本年度完成项目#其中#重大项目";
var label_DecimalField9_GTZero = "本年度项目情况#内容#本年度完成项目#其中#一般项目";
var label_DecimalField7_GTZero = "本年度项目情况#内容#本年度延期项目#本年度延期项目";
var label_DecimalField8_GTZero = "本年度项目情况#内容#本年度延期项目#其中#重大项目";
var label_DecimalField15_GTZero = "本年度项目情况#内容#本年度延期项目#其中#一般项目";
var label_DecimalField1_GTZero = "本年度项目情况#内容#本年度信息科技项目总数";
var label_R_Item13_GTZero = "项目管理情况#内容#本年度质量保证人员项目参与率";

var label_R_Item20_GTZero = "本年度项目情况#内容#项目压力测试完成率";
var label_R_Item21_GTZero = "本年度项目情况#内容#项目用户验收测试完成率";
var label_R_Item22_GTZero = "本年度项目情况#内容#项目代码安全检查完成率";
var label_DecimalField10_GTZero = "本年度项目情况#内容#年度项目计划完成率";
var label_DecimalField11_GTZero = "本年度项目情况#内容#本年度软件开发项目工作量#本年度软件开发项目工作量";
var label_DecimalField12_GTZero = "本年度项目情况#内容#本年度软件开发项目工作量#其中#自主开发工作量";
var label_DecimalField13_GTZero = "本年度项目情况#内容#本年度软件开发项目工作量#其中#外包开发工作量";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	//本年度项目情况#内容#本年度新增立项项目#本年度新增立项项目
	var obj_DecimalField2_GTZero = getTableFormObj(label_DecimalField2_GTZero,"1_1_1");
	//本年度项目情况#内容#本年度新增立项项目#其中#重大项目
	var obj_DecimalField3_GTZero = getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1");
	//本年度项目情况#内容#本年度新增立项项目#其中#一般项目
	var obj_DecimalField4_GTZero = getTableFormObj(label_DecimalField4_GTZero,"1_1_1_1");
	//本年度项目情况#内容#本年度完成项目#本年度完成项目
	var obj_DecimalField5_GTZero = getTableFormObj(label_DecimalField5_GTZero,"1_1_1");
	//本年度项目情况#内容#本年度完成项目#其中#重大项目
	var obj_DecimalField6_GTZero = getTableFormObj(label_DecimalField6_GTZero,"1_1_1_1");
	//本年度项目情况#内容#本年度完成项目#其中#一般项目
	var obj_DecimalField9_GTZero = getTableFormObj(label_DecimalField9_GTZero,"1_1_1_1");
	//本年度项目情况#内容#本年度延期项目#本年度延期项目
	var obj_DecimalField7_GTZero = getTableFormObj(label_DecimalField7_GTZero,"1_1_1");
	//本年度项目情况#内容#本年度延期项目#其中#重大项目
	var obj_DecimalField8_GTZero = getTableFormObj(label_DecimalField8_GTZero,"1_1_1_1");
	//本年度项目情况#内容#本年度延期项目#其中#一般项目
	var obj_DecimalField15_GTZero = getTableFormObj(label_DecimalField15_GTZero, "1_1_1_1");
	//本年度项目情况#内容#本年度软件开发项目工作量#本年度软件开发项目工作量
	var obj_DecimalField11_GTZero = getTableFormObj(label_DecimalField11_GTZero, "1_1_1");
	//本年度项目情况#内容#本年度软件开发项目工作量#其中#自主开发工作量
	var obj_DecimalField12_GTZero = getTableFormObj(label_DecimalField12_GTZero, "1_1_1_1");
	//本年度项目情况#内容#本年度软件开发项目工作量#其中#外包开发工作量
	var obj_DecimalField13_GTZero = getTableFormObj(label_DecimalField13_GTZero, "1_1_1_1");
	//本年度项目情况#内容#项目压力测试完成率";
	var obj_R_Item20_GTZero = getTableFormObj(label_R_Item20_GTZero, "1_1");
	//本年度项目情况#内容#项目用户验收测试完成率";
	var obj_R_Item21_GTZero = getTableFormObj(label_R_Item21_GTZero, "1_1");
	//本年度项目情况#内容#项目代码安全检查完成率";
	var obj_R_Item22_GTZero = getTableFormObj(label_R_Item22_GTZero, "1_1");
	//本年度项目情况#内容#年度项目计划完成率
	var obj_DecimalField10_GTZero = getTableFormObj(label_DecimalField10_GTZero, "1_1");
	//本年度项目情况#内容#本年度信息科技项目总数
	var obj_DecimalField1_GTZero = getTableFormObj(label_DecimalField1_GTZero,"1_1");
	//项目管理情况#内容#本年度质量保证人员项目参与率
	var obj_R_Item13_GTZero = getTableFormObj(label_R_Item13_GTZero, "1_1");
	
	checkNumFloat(obj_DecimalField11_GTZero,2);
	checkNumFloat(obj_DecimalField12_GTZero,2);
	checkNumFloat(obj_DecimalField13_GTZero,2);
	checkNumFloat(obj_R_Item20_GTZero,2);
	checkNumFloat(obj_R_Item21_GTZero,2);
	checkNumFloat(obj_R_Item22_GTZero,2);
	checkNumFloat(obj_DecimalField10_GTZero,2);
	checkNumFloat(obj_R_Item13_GTZero,2);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if (parseInt(obj_DecimalField11_GTZero.value.trim()) < 
			parseInt(obj_DecimalField12_GTZero.value.trim())
			+ parseInt(obj_DecimalField13_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField11_GTZero);
		a += "本年度软件开发工作量≥自主开发工作量＋外包开发工作量校验出错！\n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField2_GTZero.value.trim()) > 
		parseInt(obj_DecimalField3_GTZero.value.trim())
		+ parseInt(obj_DecimalField4_GTZero.value.trim())
			|| parseInt(obj_DecimalField2_GTZero.value.trim()) < 
			parseInt(obj_DecimalField3_GTZero.value.trim())
			+ parseInt(obj_DecimalField4_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField2_GTZero);
		a += "本年度新增立项项目=重大项目+一般项目出错! \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField5_GTZero.value.trim()) > 
		parseInt(obj_DecimalField6_GTZero.value.trim()) 
		+ parseInt(obj_DecimalField9_GTZero.value.trim())
			|| parseInt(obj_DecimalField5_GTZero.value.trim()) < 
			parseInt(obj_DecimalField6_GTZero.value.trim())
			+ parseInt(obj_DecimalField9_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField5_GTZero);
		a += "本年度完成项目=重大项目+一般项目出错! \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField7_GTZero.value.trim()) > 
		parseInt(obj_DecimalField8_GTZero.value.trim())
		+ parseInt(obj_DecimalField15_GTZero.value.trim())
			|| parseInt(obj_DecimalField7_GTZero.value.trim()) < 
			parseInt(obj_DecimalField8_GTZero.value.trim())
			+ parseInt(obj_DecimalField15_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField7_GTZero);
		a += "本年度延期项目=重大项目+一般项目出错! \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item20_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item20_GTZero);
		a += "项目管理情况-项目压力测试完成率<=100出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item21_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item21_GTZero);
		a += "项目管理情况-项目用户验收测试完成率<=100出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item22_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item22_GTZero);
		a += "项目管理情况-项目代码安全检查完成率<=100出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField10_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_DecimalField10_GTZero);
		a += "项目管理情况-年度项目计划完成率<=100出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) < 
			parseInt(obj_DecimalField2_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField2_GTZero);
		a += "本年度项目情况-本年度信息科技项目总数>本年度新增立项项目校验出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) <
			parseInt(obj_DecimalField5_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField5_GTZero);
		a += "本年度项目情况-本年度信息科技项目总数>本年度完成项目校验出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) < 
			parseInt(obj_DecimalField7_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField7_GTZero);
		a += "本年度项目情况-本年度信息科技项目总数>本年度延期项目校验出错！ \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item13_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item13_GTZero);
		a += "项目管理情况-本年度质量保证人员项目参与率<=100出错！ \n";
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

