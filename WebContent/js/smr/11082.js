/*
 * 报表：2014-T-B-11 业务连续性管理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
// 业务连续性管理组织架构
var label_YN01_01 = "业务连续性管理组织架构#内容#设立业务连续性管理委员会或类似组织";
var label_YN01_02 = "业务连续性管理组织架构#内容#如是，组织名称";
var label_YN01_03 = "业务连续性管理组织架构#内容#成员部门";
var label_YN01_04 = "业务连续性管理组织架构#内容#设立或指定业务连续性管理主管部门";
var label_YN01_05 = "业务连续性管理组织架构#内容#如是，部门名称";
var label_YN01_06 = "业务连续性管理组织架构#内容#独立于信息科技部门";
// 业务连续性管理体系与制度
var label_YN02_01 = "业务连续性管理体系与制度#内容#制定和发布业务连续性管理战略规划";
var label_YN02_02 = "业务连续性管理体系与制度#内容#如是，发布时间";
var label_YN02_03_01 = "业务连续性管理体系与制度#内容#战略规划期从#1";
var label_YN02_03_02 = "业务连续性管理体系与制度#内容#战略规划期从#2";
// 业务影响分析
var label_YN03_01 = "业务影响分析#内容#已开展业务影响分析";
var label_YN03_02 = "业务影响分析#内容#如是，牵头组织开展业务影响分析的部门是";
var label_YN03_03 = "业务影响分析#内容#部门名称";
var label_YN03_04 = "业务影响分析#内容#业务影响分析报告经业务连续性管理委员会或高级管理层审批";
var label_YN03_05 = "业务影响分析#内容#最近一次审批时间";
var label_YN03_06 = "业务影响分析#内容#根据业务影响分析结果制定业务恢复策略";
var label_YN03_07 = "业务影响分析#内容#包括";
var label_YN03_08 = "业务影响分析#内容#已识别的重要业务总数";
var label_YN03_09_01 = "业务影响分析#内容#二维表循环#重要业务名称";
var label_YN03_09_02_01 = "业务影响分析#内容#二维表循环#业务恢复指标#RTO";
var label_YN03_09_02_02 = "业务影响分析#内容#二维表循环#业务恢复指标#RPO";
var label_YN03_09_03 = "业务影响分析#内容#二维表循环#业务归口管理部门";
var label_YN03_09_04 = "业务影响分析#内容#二维表循环#业务影响分析开展部门";
var label_YN03_09_05 = "业务影响分析#内容#二维表循环#业务影响分析完成时间";
// 业务连续性计划与资源建设
var label_YN04_01 = "业务连续性计划与资源建设#内容#制定和发布机构整体业务连续性计划";
var label_YN04_02 = "业务连续性计划与资源建设#内容#发布时间";
var label_YN04_03 = "业务连续性计划与资源建设#内容#建立业务连续性计划定期修订机制";
var label_YN04_04 = "业务连续性计划与资源建设#内容#最近一次修订并发布的时间";
var label_YN04_05 = "业务连续性计划与资源建设#内容#制定和发布机构总体应急预案";
var label_YN04_06 = "业务连续性计划与资源建设#内容#发布时间:";
var label_YN04_07 = "业务连续性计划与资源建设#内容#建立专项应急预案定期修订机制";
var label_YN04_08 = "业务连续性计划与资源建设#内容#最近一次修订并发布的时间:";
var label_YN04_11 = "业务连续性计划与资源建设#内容#重要业务专项应急预案覆盖率";
// 业务连续性演练
var label_YN05_01 = "业务连续性演练#内容#已制定和发布业务连续性演练计划";
var label_YN05_02 = "业务连续性演练#内容#发布时间";
var label_YN05_06 = "业务连续性演练#内容#本年度重要业务的业务连续性演练覆盖率";
// 业务连续性评估改进
var label_YN06_01 = "业务连续性评估改进#内容#开展业务连续性管理体系评估";
var label_YN06_02 = "业务连续性评估改进#内容#如是，评估形式";
var label_YN06_03 = "业务连续性评估改进#内容#评估机构名称";
var label_YN06_04 = "业务连续性评估改进#内容#自评估报告提交高级管理层审批";
var label_YN06_05 = "业务连续性评估改进#内容#最近一次审批时间";
/*
 * 功能：提交校验
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// 业务连续性管理组织架构校验
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "是") {
		if (obj_YN01_02.value == "") {
			errorObjs.push(obj_YN01_02);
			a += "1.业务连续性管理组织架构中组织名称不能为空\n";
			isValid = false;
		}
		if (obj_YN01_03.value == "") {
			errorObjs.push(obj_YN01_03);
			a += "1.业务连续性管理组织架构中成员部门不能为空\n";
			isValid = false;
		}
	}
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "是") {
		if (obj_YN01_05.value == "") {
			errorObjs.push(obj_YN01_05);
			a += "1.业务连续性管理组织架构中组织名称不能为空\n";
			isValid = false;
		}
		if (obj_YN01_06.value == "") {
			errorObjs.push(obj_YN01_06);
			a += "1.业务连续性管理组织架构中独立于信息科技部门不能为空\n";
			isValid = false;
		}
	}

	// 业务连续性管理体系与制度校验
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[0];
	var obj_YN02_03_02 = getTableFormObjs(label_YN02_03_02)[0];
	if (obj_YN02_01.value == "是") {
		if (obj_YN02_02.value == "") {
			errorObjs.push(obj_YN02_02);
			a += "2.业务连续性管理体系与制度中发布时间不能为空\n";
			isValid = false;
		}
		if (obj_YN02_03_01.value == "" || obj_YN02_03_02.value == "") {
			errorObjs.push(obj_YN02_03_01);
			a += "2.业务连续性管理体系与制度中战略规划期不能为空\n";
			isValid = false;
		}
	}
	// 业务影响分析
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	var obj_YN03_06 = getTableFormObj(label_YN03_06, obj_YN03_01.rownumber);
	var obj_YN03_07 = getTableFormObjs(label_YN03_07)[0];
	var obj_YN03_08 = getTableFormObj(label_YN03_08, obj_YN03_01.rownumber);

	if (obj_YN03_01.value == "是") {
		if (obj_YN03_02.value == "") {
			errorObjs.push(obj_YN03_02);
			a += "3.业务影响分析中牵头组织开展业务影响分析的部门不能为空\n";
			isValid = false;
		}
		if(obj_YN03_02.value =="其他部门"){
			if (obj_YN03_03.value == "") {
				errorObjs.push(obj_YN03_03);
				a += "3.业务影响分析中部门名称不能为空\n";
				isValid = false;
			}
		}
		
		if (obj_YN03_04.value == "") {
			errorObjs.push(obj_YN03_04);
			a += "3.业务影响分析中业务影响分析报告经业务连续性管理委员会或高级管理层审批不能为空\n";
			isValid = false;
		}
		if(obj_YN03_04.value == "是"){
			if (obj_YN03_05.value == "") {
				errorObjs.push(obj_YN03_05);
				a += "3.业务影响分析中最近一次审批时间不能为空\n";
				isValid = false;
			}
		}
		if (obj_YN03_06.value == "") {
			errorObjs.push(obj_YN03_06);
			a += "3.业务影响分析中根据业务影响分析结果制定业务恢复策略不能为空\n";
			isValid = false;
		}
//		if (obj_YN03_07.value == "") {
//			errorObjs.push(obj_YN03_07);
//			a += "3.业务影响分析中包括不能为空\n";
//			isValid = false;
//		}
		if (obj_YN03_08.value == "") {
			errorObjs.push(obj_YN03_08);
			a += "3.业务影响分析中已识别的重要业务总数不能为空\n";
			isValid = false;
		}
	}
	var obj_YN03_09_01 = getTableFormObjs(label_YN03_09_01);
	for ( var i = 0; i < obj_YN03_09_01.length - 1; i++) {
		var obj_YN03_09_02_01 = getTableFormObj(label_YN03_09_02_01,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_02_02 = getTableFormObj(label_YN03_09_02_02,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_03 = getTableFormObj(label_YN03_09_03,
				obj_YN03_09_01[i].rownumber);
		var obj_YN03_09_04 = getTableFormObj(label_YN03_09_04,
				obj_YN03_09_01[i].rownumber);
		var obj_YN03_09_05 = getTableFormObj(label_YN03_09_05,
				obj_YN03_09_01[i].rownumber);
		if (obj_YN03_09_01[i].value == "" || obj_YN03_09_01[i].value == "无") {
			errorObjs.push(obj_YN03_09_01[i]);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，重要业务名称不能为空！\n";
			isValid = false;
		}
		if (obj_YN03_09_02_01.value == "" || obj_YN03_09_02_01.value == "无") {
			errorObjs.push(obj_YN03_09_02_01);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，RTO:不能为空！\n";
			isValid = false;
		}
		if (obj_YN03_09_02_02.value == "" || obj_YN03_09_02_02.value == "无") {
			errorObjs.push(obj_YN03_09_02_02);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，RPO:不能为空！\n";
			isValid = false;
		}
		if (obj_YN03_09_03.value == "" || obj_YN03_09_03.value == "无") {
			errorObjs.push(obj_YN03_09_03);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，业务归口管理部门不能为空！\n";
			isValid = false;
		}
		if (obj_YN03_09_04.value == "" || obj_YN03_09_04.value == "无") {
			errorObjs.push(obj_YN03_09_04);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，业务影响分析开展部门不能为空！\n";
			isValid = false;
		}
		if (obj_YN03_09_05.value == "" || obj_YN03_09_05.value == "无") {
			errorObjs.push(obj_YN03_09_05);
			a += "3.通过业务影响分析识别的重要业务详细情况 其中 序号" + (i + 1)
					+ "，重要业务名称不为“无”或空，业务影响分析完成时间不能为空！\n";
			isValid = false;
		}
	}
	// 业务连续性计划与资源建设校验
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02, obj_YN04_01.rownumber);
	if (obj_YN04_01.value == "是" && obj_YN04_02.value == "") {
		errorObjs.push(obj_YN04_02);
		a += "4.业务连续性计划与资源建设中发布时间不能为空\n";
		isValid = false;
	}
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
	if (obj_YN04_03.value == "是" && obj_YN04_04.value == "") {
		errorObjs.push(obj_YN04_02);
		a += "4.业务连续性计划与资源建设中最近一次修订并发布的时间\n";
		isValid = false;
	}
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06, obj_YN04_05.rownumber);
	if (obj_YN04_05.value == "是" && obj_YN04_06.value == "") {
		errorObjs.push(obj_YN04_06);
		a += "4.业务连续性计划与资源建设中发布时间不能为空\n";
		isValid = false;
	}
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	var obj_YN04_08 = getTableFormObj(label_YN04_08, obj_YN04_07.rownumber);
	if (obj_YN04_07.value == "是" && obj_YN04_08.value == "") {
		errorObjs.push(obj_YN04_08);
		a += "4.业务连续性计划与资源建设中最近一次修订并发布的时间不能为空\n";
		isValid = false;
	}

	// 业务连续性演练
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
	if (obj_YN05_01.value == "是" &&obj_YN05_02.value =="") {
		errorObjs.push(obj_YN05_02);
		a += "5.业务连续性演练中发布时间不能为空\n";
		isValid = false;
	}

	var obj_YN04_11 = getTableFormObjs(label_YN04_11)[0];
	var obj_YN05_06 = getTableFormObjs(label_YN05_06)[0];
	if (parseFloat(obj_YN04_11.value) < parseFloat(obj_YN05_06.value)) {
		errorObjs.push(obj_YN05_06);
		a += "[重要业务专项应急预案覆盖率] 应大于等于 [本年度重要业务应急演练覆盖率] \n";
		isValid = false;
	}
	// 业务连续性评估改进
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObjs(label_YN06_02)[0];
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_01.rownumber);
	if (obj_YN06_01.value == "是") {
		if (obj_YN06_02.value == "") {
			errorObjs.push(obj_YN06_02);
			a += "6.业务连续性评估改进中评估形式不能为空\n";
			isValid = false;
		}
		if(obj_YN06_02.value.indexOf("委托第三方机构开展")>0){
			if (obj_YN06_03.value == "") {
				errorObjs.push(obj_YN06_03);
				a += "6.业务连续性评估改进中评估机构名称不能为空\n";
				isValid = false;
			}
		}
		
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "是" && obj_YN06_05.value == "") {
		errorObjs.push(obj_YN06_05);
		a += "6.业务连续性评估改进中最近一次审批时间不能为空\n";
		isValid = false;
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
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("其他")>-1&&errorObjs[i].previousSibling.innerHTML.indexOf("其他部门")<-1){
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
 * 功能：通过已制定和发布业务连续性演练计划决定发布时间只读和可填 配置：业务连续性演练#内容#已制定和发布业务连续性演练计划
 */
function setYN06_05Disable(obj) {
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "是") {
		obj_YN06_05.onclick = click_columnshowDate;
	} else {
		obj_YN06_05.onclick = "";
		obj_YN06_05.value = "";
	}
}

/*
 * 功能：通过开展业务连续性管理体系评估决定评估形式只读和可填 配置：业务连续性评估改进#内容#开展业务连续性管理体系评估
 */
function setYN06_02Disable(obj) {
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormCheckBox(label_YN06_02, "1_1");
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_01.rownumber);
	if (obj_YN06_01.value == "是") {
		disableTableCheckBox(obj_YN06_02, false);
		setYN06_03Disable();
		jQuery(obj_YN06_02).click(
				function(){
					setYN06_03Disable();
				}
		);
		
	} else {
		disableTableCheckBox(obj_YN06_02, true);
		obj_YN06_03.readOnly = "readOnly";
		obj_YN06_03.value = "";
	}
}

function setYN06_03Disable(obj){
	var obj_YN06_02Value = getTableFormObj(label_YN06_02, "1_1");
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_02Value.rownumber);
	var str = obj_YN06_02Value.value;
	if(str.indexOf("委托第三方机构开展")>-1){
		obj_YN06_03.readOnly = "";
	}else{
		obj_YN06_03.readOnly = "readOnly";
		obj_YN06_03.value = "";
	}
}
/*
 * 功能：通过已制定和发布业务连续性演练计划决定发布时间只读和可填 配置：业务连续性演练#内容#已制定和发布业务连续性演练计划
 */
function setYN05_02Disable(obj) {
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
	if (obj_YN05_01.value == "是") {
		obj_YN05_02.onclick = click_columnshowDate;
	} else {
		obj_YN05_02.onclick = "";
		obj_YN05_02.value = "";
	}
}
/*
 * 功能：通过建立业务连续性计划定期修订机制决定最近一次修订并发布的时间只读和可填 配置：业务连续性计划与资源建设#内容#建立业务连续性计划定期修订机制
 */
function setYN04_04Disable(obj) {
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
	if (obj_YN04_03.value == "是") {
		obj_YN04_04.onclick = click_columnshowDate;
	} else {
		obj_YN04_04.onclick = "";
		obj_YN04_04.value = "";
	}
}
/*
 * 功能：通过制定和发布机构总体应急预案决定发布时间:只读和可填 配置：业务连续性计划与资源建设#内容#制定和发布机构总体应急预案
 */
function setYN04_06Disable(obj) {
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06, obj_YN04_05.rownumber);
	if (obj_YN04_05.value == "是") {
		obj_YN04_06.onclick = click_columnshowDate;
	} else {
		obj_YN04_06.onclick = "";
		obj_YN04_06.value = "";
	}
}
/*
 * 功能：建立专项应急预案定期修订机制决定最近一次修订并发布的时间:修订机制只读和可填 配置：业务连续性计划与资源建设#内容#建立专项应急预案定期修订机制
 */
function setYN04_08Disable(obj) {
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	var obj_YN04_08 = getTableFormObj(label_YN04_08, obj_YN04_07.rownumber);
	if (obj_YN04_07.value == "是") {
		obj_YN04_08.onclick = click_columnshowDate;
	} else {
		obj_YN04_08.onclick = "";
		obj_YN04_08.value = "";
	}
}
/*
 * 功能：通过制定和发布机构整体业务连续性计划决定发布时间只读和可填 配置：业务连续性计划与资源建设#内容#制定和发布机构整体业务连续性计划
 */
function setYN04_02Disable(obj) {
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02, obj_YN04_01.rownumber);
	if (obj_YN04_01.value == "是") {
		obj_YN04_02.onclick = click_columnshowDate;
	} else {
		obj_YN04_02.onclick = "";
		obj_YN04_02.value = "";
	}
}

/*
 * 功能：通过已开展业务影响分析划决其他项只读和可填 配置：业务影响分析#内容#已开展业务影响分析
 */
function setYN02OtherDisable(obj) {
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	var obj_YN03_06 = getTableFormObj(label_YN03_06, obj_YN03_01.rownumber);
	var obj_YN03_07 = getTableFormCheckBox(label_YN03_07, "1_1");
	var obj_YN03_08 = getTableFormObj(label_YN03_08, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "是") {
		columnVallueRadio2(obj_YN03_02, true, true,setYN03_03Disable);
		columnVallueRadio2(obj_YN03_04, true, true,setYN03_05Disable);
		columnVallueRadio1(obj_YN03_06, true, false);
		disableTableCheckBox(obj_YN03_07, false);
		obj_YN03_08.readOnly = "";
	} else {
//		columnVallueRadio1(obj_YN03_02, false, false);
		columnVallueRadio2(obj_YN03_02, false, false,setYN03_03Disable);
		obj_YN03_03.readOnly = "readonly";
//		columnVallueRadio1(obj_YN03_04, false, false);
		columnVallueRadio2(obj_YN03_04, false, false,setYN03_05Disable);
		obj_YN03_05.onclick = "";
		columnVallueRadio1(obj_YN03_06, false, false);
		disableTableCheckBox(obj_YN03_07, true);
		obj_YN03_08.readOnly = "readonly";

		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";
		obj_YN03_06.value = "";
		obj_YN03_08.value = "";
	}

}
/**最近一次审批时间*/
function setYN03_05Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	if(obj_YN03_04.value == "是"){
		obj_YN03_05.onclick = click_columnshowDate;
	}else{
		obj_YN03_05.onclick = "";
		obj_YN03_05.value = "";
	}
}

/**部门名称*/
function setYN03_03Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if(obj_YN03_02.value =="其他部门"){
		obj_YN03_03.readOnly = "";
	}else{
		obj_YN03_03.readOnly = "readonly";
		obj_YN03_03.readOnly = "";
	}
}
/*
 * 功能：通过制定和发布业务连续性管理战略规划决定发布时间只读和可填 配置：业务连续性管理体系与制度#内容#制定和发布业务连续性管理战略规划
 */
function setYN02_02_03Disable(obj) {
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[0];
	var obj_YN02_03_02 = getTableFormObjs(label_YN02_03_02)[0];
	if (obj_YN02_01.value == "是") {
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03_01.readOnly = "";
		obj_YN02_03_02.readOnly = "";
	} else {
		obj_YN02_02.onclick = "";
		obj_YN02_03_01.readOnly = "readonly";

		obj_YN02_02.value = "";
		obj_YN02_03_02.readOnly = "readonly";

	}
}
/*
 * 功能：校验年是否是四位数
 */
function checkDateLength(obj) {
	var objValue = obj.value;
	if (objValue.length != 4) {
		obj.value = "";
		alert("日期输入格式不对，应为4位数字，例如2012！");
	}
}
/*
 * 功能：通过设立或指定业务连续性管理主管部门决定部门名称只读和可填 配置：业务连续性管理组织架构#内容#设立或指定业务连续性管理主管部门
 */
function setYN01_05_06Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "是") {
		columnVallueRadio1(obj_YN01_06, true, false);
		obj_YN01_05.readOnly = "";
	} else {
		obj_YN01_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_06, false, false);
		obj_YN01_05.value = "";
		obj_YN01_06.value = "";
	}
}

/*
 * 功能：通过设立业务连续性管理委员会或类似组织决定组织名称只读和可填 配置：业务连续性管理组织架构#内容#设立业务连续性管理委员会或类似组织
 */
function setYN01_02_03Disable(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "是") {
		obj_YN01_02.readOnly = "";
		obj_YN01_03.readOnly = "";
	} else {
		obj_YN01_02.readOnly = "readonly";
		obj_YN01_03.readOnly = "readonly";
		obj_YN01_02.value = "";
		obj_YN01_03.value = "";
	}
}
/*
 * 初始化
 */
function initSet() {
	var obj = 0;
	setYN01_02_03Disable(obj);
	setYN01_05_06Disable(obj);
	setYN02_02_03Disable(obj);
	setYN02OtherDisable(obj);
	setYN04_02Disable(obj);
	setYN04_04Disable(obj);
	setYN04_06Disable(obj);
	setYN04_08Disable(obj);
	setYN05_02Disable(obj);
	setYN06_02Disable(obj);
	setYN06_05Disable(obj);
	setWidth();
}

function setWidth(){
	var obj_YN03_09_01 = getTableFormObjs(label_YN03_09_01);
	for ( var i = 0; i < obj_YN03_09_01.length; i++) {
		var obj_YN03_09_02_01 = getTableFormObj(label_YN03_09_02_01,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_02_02 = getTableFormObj(label_YN03_09_02_02,
				obj_YN03_09_01[i].rownumber + "_1");
		jQuery(obj_YN03_09_02_01).css("width","40px");
		jQuery(obj_YN03_09_02_02).css("width","40px");
	}
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
						} 
					}
				}
			}
		}
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
* 功能：审批节点初始化
* 
*/
function delTable(){
	var YN02_03_01Obj = getTableFormObjs(label_YN02_03_01)[0];
	var YN02_03_02Obj = getTableFormObjs(label_YN02_03_02)[0];
	if(YN02_03_01Obj.value == "" &&YN02_03_02Obj.value == ""){
		jQuery("table[id="+jQuery("#pdid").val()+"226_tableForm]").parent().children().remove();
	}
	initSet();
}

