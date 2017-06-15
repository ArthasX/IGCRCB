/*
 * 报表：2014-T-B-12 信息科技外包管理情况表
 */
//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
// 信息科技外包管理组织架构
var label_YN01_01 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#已明确信息科技外包风险主管部门";
var label_YN01_02 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#部门名称";
var label_YN01_03 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#如是，独立于信息科技部门";
var label_YN01_04 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#建立信息科技外包管理执行团队";
var label_YN01_05 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#团队名称";
var label_YN01_06 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#定期向高级管理层汇报信息科技外包风险管理有关情况";
var label_YN01_07 = "信息科技外包管理组织架构#信息科技外包管理组织结构#内容#汇报频率";
// 信息科技外包战略
var label_YN02_01 = "信息科技外包战略#信息科技外包战略结构#内容#制定和发布信息科技外包战略";
var label_YN02_02 = "信息科技外包战略#信息科技外包战略结构#内容#如是，经过董事会或高级管理层审批";
var label_YN02_03 = "信息科技外包战略#信息科技外包战略结构#内容#审批时间";
// 信息科技外包战略
var label_YN03_01 = "信息科技外包风险管理#信息科技外包风险管理架构#内容#本年度已开展全面的信息科技外包风险评估";
var label_YN03_02 = "信息科技外包风险管理#信息科技外包风险管理架构#内容#如是，评估报告提交高级管理层";
var label_YN03_03 = "信息科技外包风险管理#信息科技外包风险管理架构#内容#提交时间";
var label_YN03_04 = "信息科技外包风险管理#信息科技外包风险管理架构#内容#本年度重要信息科技外包服务提供商数量";
var label_YN03_05 = "信息科技外包风险管理#信息科技外包风险管理架构#内容#其中，本年度进行风险评估的重要信息科技外包服务提供商数量";
// 信息科技外包管理过程
var label_YN04_02 = "信息科技外包管理过程#信息科技外包管理过程架构#内容#对重要信息科技外包服务提供商进行尽职调查";
var label_YN04_03 = "信息科技外包管理过程#信息科技外包管理过程架构#内容#如是，本年度已开展尽职调查的重要信息科技外包服务提供商的数量";
var label_YN04_04 = "信息科技外包管理过程#信息科技外包管理过程架构#内容#本年度信息科技外包服务合同履行结束的服务提供商的数量";
var label_YN04_05 = "信息科技外包管理过程#信息科技外包管理过程架构#内容#其中开展评价的服务提供商的数量";
var label_YN04_07 = "信息科技外包管理过程#信息科技外包管理过程架构#内容#采取的信息科技外包安全管理措施";
//机构集中度风险管理
var label_YN05_03 = "机构集中度风险管理#机构集中度风险管理框架#内容#针对具有机构集中度特点的信息科技外包服务提供商采取的控制手段";
// 跨境及非驻场外包管理
var label_YN06_01 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#是否存在信息科技跨境外包";
var label_YN06_02 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#如是，明确信息科技跨境外包服务提供商所在国家或地区监管当局已与银监会签订谅解备忘录";
var label_YN06_03 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#解决外包争议时适用的法律";
var label_YN06_04 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#存在信息科技非驻场外包";
var label_YN06_05 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#如是，对重要信息科技非驻场外包服务进行实地检查";
var label_YN06_06 = "跨境及非驻场外包管理#跨境及非驻场外包管理结构#内容#检查频率";
/*
 * 功能：通过本年度信息科技外包服务合同履行结束的服务提供商的数量和其中开展评价的服务提供商的数量比较
 * 配置：信息科技外包管理过程#信息科技外包管理过程架构#内容#本年度信息科技外包服务合同履行结束的服务提供商的数量
 */
function setYN06_05_06Disable(obj) {
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "是") {
//		columnVallueRadio2(obj_YN06_05, true, false);
		columnVallueRadio2(obj_YN06_05, true, true,setYN06_06Disable);

	} else {
		columnVallueRadio2(obj_YN06_05, false, false,setYN06_06Disable);
		obj_YN06_06.readOnly = "readonly";
		obj_YN06_06.value = "";
		obj_YN06_05.value = "";
	}
}
function setYN06_06Disable(obj){
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if(obj_YN06_05.value == "是"){
		obj_YN06_06.readOnly = "";
	}else{
		obj_YN06_06.value = "";
		obj_YN06_06.readOnly = "readonly";
	}
}
/*
 * 功能：通过本年度信息科技外包服务合同履行结束的服务提供商的数量和其中开展评价的服务提供商的数量比较
 * 配置：信息科技外包管理过程#信息科技外包管理过程架构#内容#本年度信息科技外包服务合同履行结束的服务提供商的数量
 */
function setYN06_02_03Disable(obj) {
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02, obj_YN06_01.rownumber);
	var obj_YN06_03 = getTableFormCheckBox(label_YN06_03, "1_1");
	if (obj_YN06_01.value == "是") {
		columnVallueRadio2(obj_YN06_02, true, true,setYN06_03Disable);
		disableTableCheckBox(obj_YN06_03, true);
	} else {
		columnVallueRadio2(obj_YN06_02, false, false,setYN06_03Disable);
		disableTableCheckBox(obj_YN06_03, true);
		obj_YN06_02.value = "";
	}
}

function setYN06_03Disable(obj){
	var obj_YN06_03 = getTableFormCheckBox(label_YN06_03, "1_1_1");
	if(obj.flag == "是"){
		disableTableCheckBox(obj_YN06_03, false);
	}else{
		disableTableCheckBox(obj_YN06_03, true);
	}
}

/*
 * 功能：通过本年度信息科技外包服务合同履行结束的服务提供商的数量和其中开展评价的服务提供商的数量比较
 * 配置：信息科技外包管理过程#信息科技外包管理过程架构#内容#本年度信息科技外包服务合同履行结束的服务提供商的数量
 */
function checkYN04_04_05Number(obj) {
	var obj_YN04_04 = getTableFormObjs(label_YN04_04)[0];
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	if (obj_YN04_04.value != "" && obj_YN04_05.value != "") {
		if (parseInt(obj_YN04_04.value) < parseInt(obj_YN04_05.value)) {
			obj_YN04_05.value = "";
			alert("开展评价的服务提供商的数量不能大于本年度信息科技外包服务合同履行结束的服务提供商的数量");
		}
	}
}
/*
 * 功能：通过对重要信息科技外包服务提供商进行尽职调查来决定本年度已开展尽职调查的重要信息科技外包服务提供商的数量是否可写和只读
 * 配置：信息科技外包管理过程#信息科技外包管理过程架构#内容#对重要信息科技外包服务提供商进行尽职调查
 */
function checkYN04_03Disable(obj) {
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_03 = getTableFormObj(label_YN04_03, obj_YN04_02.rownumber);
	if (obj_YN04_02.value == "是") {
		obj_YN04_03.readOnly = "";
	} else {
		obj_YN04_03.readOnly = "readonly";
		obj_YN04_03.value = "";
	}
}

/*
 * 功能：通过本年度重要信息科技外包服务提供商数量和本年度进行风险评估的重要信息科技外包服务提供商数量比较
 * 配置：信息科技外包风险管理#信息科技外包风险管理架构#内容#本年度重要信息科技外包服务提供商数量
 */
function checkYN03_04_05Number(obj) {
	var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	if (obj_YN03_04.value != "" && obj_YN03_05.value != "") {
		if (parseInt(obj_YN03_04.value) < parseInt(obj_YN03_05.value)) {
			obj_YN03_05.value = "";
			alert("本年度进行风险评估的重要信息科技外包服务提供商数量不能大于本年度重要信息科技外包服务提供商数量");
		}
	}
}
/*
 * 功能：通过本年度已开展全面的信息科技外包风险评估决定评估报告提交高级管理层和提交时间只读和可填
 * 配置：信息科技外包风险管理#信息科技外包风险管理架构#内容#本年度已开展全面的信息科技外包风险评估
 */
function setYN03_02_03Disable(obj) {
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "是") {
		columnVallueRadio2(obj_YN03_02,true,true,setYN_03_03Disable);
		if(obj_YN03_02.value == "是"){
		}else{
			obj_YN03_03.onclick = "";
		}
	} else {
		columnVallueRadio2(obj_YN03_02,true,true,setYN_03_03Disable);
		obj_YN03_03.onclick = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
	}

}
function setYN_03_03Disable(obj){
	var obj_YN03_03 = getTableFormObj(label_YN03_03,"1_1_1");
	if(obj.flag == "是"){
		obj_YN03_03.onclick = click_columnshowDate;
	}else{
		obj_YN03_03.onclick = "";
		obj_YN03_03.value = "";
	}
}
/*
 * 功能：通过制定和发布信息科技外包战略决定经过董事会或高级管理层审批和审批时间只读和可填
 * 配置：信息科技外包管理组织架构#信息科技外包管理组织结构#内容#建立信息科技外包管理执行团队
 */
function setYN02_02_03Disable(obj) {
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02_01.rownumber);
	if (obj_YN02_01.value == "是") {
		columnVallueRadio2(obj_YN02_02,true,true,setYN02_03Disable);
		if(obj_YN02_02.value == "是"){
		}else{
			obj_YN02_03.onclick = "";
		}
	} else{
		columnVallueRadio2(obj_YN02_02,false,false,setYN02_03Disable);
		obj_YN02_03.onclick = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
	}
}
function setYN02_03Disable(obj){
	var obj_YN02_03 = getTableFormObj(label_YN02_03,"1_1_1");
	if(obj.flag == "是"){
		obj_YN02_03.onclick = click_columnshowDate;
	}else{
		obj_YN02_03.onclick = "";
		obj_YN02_03.value = "";
	}
}
/*
 * 功能：通过建立信息科技外包管理执行团队决定团队名称只读和可填 配置：信息科技外包管理组织架构#信息科技外包管理组织结构#内容#建立信息科技外包管理执行团队
 */
function setYN01_07Disable(obj) {
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObj(label_YN01_07, obj_YN01_06.rownumber);
	if (obj_YN01_06.value == "是") {
		obj_YN01_07.readOnly = "";
	} else {
		obj_YN01_07.readOnly = "readonly";
		obj_YN01_07.value = "";
	}
}
/*
 * 功能：通过建立信息科技外包管理执行团队决定团队名称只读和可填 配置：信息科技外包管理组织架构#信息科技外包管理组织结构#内容#建立信息科技外包管理执行团队
 */
function setYN01_05Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "是") {
		obj_YN01_05.readOnly = "";
	} else {
		obj_YN01_05.readOnly = "readonly";
		obj_YN01_05.value = "";
	}
}
/*
 * 功能：通过已明确信息科技外包风险主管部门决定部门名称和独立于信息科技部门只读和可填
 * 配置：信息科技外包管理组织架构#信息科技外包管理组织结构#内容#已明确信息科技外包风险主管部门
 */
function setYN01_02_03Disable(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "是") {
		obj_YN01_02.readOnly = "";
		columnVallueRadio1(obj_YN01_03, true, false);
	} else {
		obj_YN01_02.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_03, false, false);
		obj_YN01_02.value = "";
		obj_YN01_03.value = "";
	}
}
/*
 * 功能：提交校验
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.color = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// 信息科技外包管理组织架构
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "是") {
		if (obj_YN01_02.value == "") {
			errorObjs.push(obj_YN01_02);
			isValid = false;
			a += "信息科技外包管理情况表：＂1 信息科技外包管理组织结构 已明确信息科技外包风险主管部门 部门名称＂不能为空！\n";
		}
		if (obj_YN01_03.value == "") {
			errorObjs.push(obj_YN01_03);
			isValid = false;
			a += "信息科技外包管理情况表：＂1 信息科技外包管理组织结构 独立于信息科技部门＂不能为空！\n";
		}
	}
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "是" && obj_YN01_05.value == "") {
		errorObjs.push(obj_YN01_05);
		isValid = false;
		a += "信息科技外包管理情况表：＂1 信息科技外包管理组织结构 团队名称＂不能为空！\n";
	}
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObj(label_YN01_07, obj_YN01_06.rownumber);
	if (obj_YN01_06.value == "是" && obj_YN01_07.value == "") {
		errorObjs.push(obj_YN01_07);
		isValid = false;
		a += "信息科技外包管理情况表：＂1 信息科技外包管理组织结构 定期向高级管理层汇报信息科技外包风险管理有关情况 汇报频率＂不能为空！\n";
	}
	// 信息科技外包战略
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03 = getTableFormObj(label_YN02_03, obj_YN02_01.rownumber);
	if (obj_YN02_01.value == "是") {
		if (obj_YN02_02.value == "") {
			errorObjs.push(obj_YN02_02);
			isValid = false;
			a += "信息科技外包管理情况表：＂2 信息科技外包战略 制定和发布信息科技外包战略 经过董事会或高级管理层审批＂不能为空！\n";
		}
		if (obj_YN02_03.value == "") {
			errorObjs.push(obj_YN02_03);
			isValid = false;
			a += "信息科技外包管理情况表：＂2 信息科技外包战略 制定和发布信息科技外包战略 经过董事会或高级管理层审批 审批时间＂不能为空！\n";
		}
	}
	//信息科技外包风险管理
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "是") {
		if (obj_YN03_02.value == "") {
			errorObjs.push(obj_YN03_02);
			isValid = false;
			a += "信息科技外包管理情况表：＂3 信息科技外包风险管理 本年度已开展全面的信息科技外包风险评估 评估报告提交高级管理层＂不能为空！\n";
		}
		if (obj_YN03_03.value == "") {
			errorObjs.push(obj_YN03_03);
			isValid = false;
			a += "信息科技外包管理情况表：＂3 信息科技外包风险管理 本年度已开展全面的信息科技外包风险评估 评估报告提交高级管理层 提交时间＂不能为空！\n";
		}
	}
	//科技外包管理过程
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_03 = getTableFormObj(label_YN04_03, obj_YN04_02.rownumber);
	if (obj_YN04_02.value == "是" && obj_YN04_03.value == "") {
		errorObjs.push(obj_YN04_03);
		isValid = false;
		a += "信息科技外包管理情况表：＂4 信息科技外包管理过程 对重要信息科技外包服务提供商进行尽职调查 本年度已开展尽职调查的重要信息科技外包服务提供商的数量＂不能为空！\n";
	}
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	if (obj_YN04_07.value == "") {
		errorObjs.push(obj_YN04_07);
		isValid = false;
		a += "信息科技外包管理情况表：＂4 信息科技外包管理过程 采取的信息科技外包安全管理措施＂不能为空！\n";
	}
	//机构集中度风险管理
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	if (obj_YN05_03.value == "") {
		errorObjs.push(obj_YN05_03);
		isValid = false;
		a += "信息科技外包管理情况表：＂5 机构集中度风险管理 针对具有机构集中度特点的信息科技外包服务提供商采取的控制手段＂不能为空！\n";
	}
	// 跨境及非驻场外包管理
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02, obj_YN06_01.rownumber);
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if (obj_YN06_01.value == "是") {
		if(obj_YN06_02.value == ""){
			errorObjs.push(obj_YN06_02);
			isValid = false;
			a += "信息科技外包管理情况表：＂6 跨境及非驻场外包管理 是否存在信息科技跨境外包 明确信息科技跨境外包服务提供商所在国家或地区监管当局已与银监会签订谅解备忘录＂不能为空！\n";
		}
		if(obj_YN06_03.value == ""){
			errorObjs.push(obj_YN06_03);
			isValid = false;
			a += "信息科技外包管理情况表：＂6 跨境及非驻场外包管理 是否存在信息科技跨境外包 解决外包争议时适用的法律＂不能为空！\n";
		}
		
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "是") {
		if(obj_YN06_05.value == ""){
			errorObjs.push(obj_YN06_05);
			isValid = false;
			a += "信息科技外包管理情况表：＂6 跨境及非驻场外包管理 是否存在信息科技跨境外包 对重要信息科技非驻场外包服务进行实地检查＂不能为空！\n";
		}
		if(obj_YN06_05.value == "是" && obj_YN06_06.value == ""){
			errorObjs.push(obj_YN06_06);
			isValid = false;
			a += "信息科技外包管理情况表：＂6 跨境及非驻场外包管理 是否存在信息科技跨境外包 检查频率＂不能为空！\n";
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
/*
 * 初始化
 */
function initSet() {
	var obj = 0;
	setYN01_02_03Disable(obj);
	setYN01_05Disable(obj);
	setYN01_07Disable(obj);
	setYN03_02_03Disable(obj);
	setYN02_02_03Disable(obj);
	checkYN04_03Disable(obj);
	setYN06_02_03Disable(obj);
	setYN06_05_06Disable(obj);
}
/*
 * 功能：恢复日期输入
 */
var click_columnshowDate = function() {
	showDate(this);
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
 * 功能：判断表单内容是否大于100
 */
function checkPercent(obj) {
	if (obj.value > 100 || obj.value < 0) {
		obj.value = "";
		alert("请输入0-100的数值");
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
/*
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio2(obj, access, flag,clickfunction) {
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
						jQuery(imgs[k]).unbind("click");
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							jQuery(imgs[k]).bind("click",function(){
								columnVallueRadio(this);
								clickfunction(this);
							});
						}
					}
				}
			}
		}
	}
}

jQuery(function(){
	jQuery("div[name = 'textarea_show_value']").css("width","160px");
});