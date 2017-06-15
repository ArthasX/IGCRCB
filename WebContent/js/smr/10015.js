/**T-B-16 信息科技外包管理情况表——报表填报*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01="信息科技外包管理整体框架#信息科技外包管理组织结构#内容#是否建立信息科技外包管理组织结构#是否建立信息科技外包管理组织结构";
var label_YN01_01= "信息科技外包管理整体框架#信息科技外包管理组织结构#内容#信息科技外包管理组织（部门、团队）名称#信息科技外包管理组织（部门、团队）名称";
var label_YN01_02="信息科技外包管理整体框架#信息科技外包管理组织结构#内容#信息科技外包管理组织成员来自（多选）#信息科技外包管理组织成员来自（多选）";

var label_item1_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#信息科技外包项目总数#信息科技外包项目总数";
var label_item3_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#其中，基础设施类外包项目#其中，基础设施类外包项目";
var label_item5_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#系统服务类外包项目#系统服务类外包项目";
var label_item7_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#人员服务类外包项目#人员服务类外包项目";
var label_item9_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#咨询服务类项目#咨询服务类项目";

var label_item2_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#信息科技外包工作总量#信息科技外包工作总量：";
var label_item4_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#其中，基础设施类外包项目#其中，基础设施类外包项目";
var label_item6_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#系统服务类#系统服务类";
var label_item8_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#人员服务类#人员服务类";
var label_item10_GTZero = "信息科技外包管理整体框架#信息科技外包项目#内容#咨询服务类#咨询服务类";

var label_item1_GTZero_2 = "信息科技外包管理#外包服务商管理#内容#信息科技外包商的数量#信息科技外包商的数量";
var label_item3_GTZero_2 = "信息科技外包管理#外包服务商管理#内容#外包服务评价结果合格的外包商数#外包服务评价结果合格的外包商数";
var label_item4_GTZero_2 = "信息科技外包管理#外包服务商管理#内容#参与评价的外包商数#参与评价的外包商数";

var label_YN02="信息科技外包管理整体框架#信息科技外包范围#内容#是否明确信息科技外包范围#是否明确信息科技外包范围"; 
var label_YN02_01="信息科技外包管理整体框架#信息科技外包范围#内容#涉及信息科技外包的领域包括(多选)#涉及信息科技外包的领域包括(多选)";

var label_YN07="信息科技外包管理#信息科技外包风险评估#内容#是否开展信息科技外包风险评估#是否开展信息科技外包风险评估";
var label_YN07_01="信息科技外包管理#信息科技外包风险评估#内容#信息科技外包风险评估阶段#信息科技外包风险评估阶段";
var label_YN07_02="信息科技外包管理#信息科技外包风险评估#内容#信息科技外包风险评估执行部门#信息科技外包风险评估执行部门";

var label_YN05="信息科技外包管理#外包合同管理#内容#是否所有外包合同均需经过相关部门审核#是否所有外包合同均需经过相关部门审核";
var label_YN05_01="信息科技外包管理#外包合同管理#内容#审核部门#审核部门";

var label_YN06="信息科技外包管理#外包服务商审计#内容#外包服务商审计1#依据何种情况要求外包服务商委托外部审计机构对其实施安全审计";
var label_YN06_01_GTZero="信息科技外包管理#外包服务商审计#内容#外包服务商审计2#审计频度";
var label_DecimalField3_GTZero="信息科技外包管理#外包服务商管理#内容#产生的总费用#产生的总费用";
function initSet(){
	 setobj_YN01(getTableFormObj(label_YN01,"1_1_1_1" ));
	 setobj_YN02(getTableFormObj(label_YN02,"1_1_1_1" ));
	 setobj_YN07(getTableFormObj(label_YN07,"1_1_1_1" ));
	 setobj_YN05(getTableFormObj(label_YN05,"1_1_1_1" ));
	 setobj_YN06(getTableFormObj(label_YN06,"1_1_1_1" ));
	// setObj_YN06_01(getTableFormObj(label_YN06,"1_1_1_1" ));
}

/*
* 功能：点击是否下方表单是否可填
* 配置："信息科技外包管理整体框架#信息科技外包管理组织结构#内容#是否建立信息科技外包管理组织结构#是否建立信息科技外包管理组织结构";
"信息科技外包管理整体框架#信息科技外包管理组织结构#内容#信息科技外包管理组织（部门、团队）名称#信息科技外包管理组织（部门、团队）名称";
"信息科技外包管理整体框架#信息科技外包管理组织结构#内容#信息科技外包管理组织成员来自（多选）#信息科技外包管理组织成员来自（多选）";
*/
function setobj_YN01(obj){
	var obj_YN01 = getTableFormObj(label_YN01,"1_1_1_1" );
	var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1_1_1" );
	var obj_YN01_02 = getTableFormCheckBox(label_YN01_02,"1_1_1_1" );
	if (obj_YN01.value == "否") {
		// 只读
		// 清空
		obj_YN01_01.value = "";
		obj_YN01_01.readOnly = "readonly";
		disableTableCheckBox(obj_YN01_02,true);
	} else if (obj_YN01.value == "是") {
		// 还原
		obj_YN01_01.value = "";
		obj_YN01_01.readOnly = "";
		disableTableCheckBox(obj_YN01_02,false);
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置："信息科技外包管理整体框架#信息科技外包范围#内容#是否明确信息科技外包范围#是否明确信息科技外包范围"; 
*		"信息科技外包管理整体框架#信息科技外包范围#内容#涉及信息科技外包的领域包括(多选)#涉及信息科技外包的领域包括(多选)";
*/
function setobj_YN02(obj){
	var obj_YN02 = getTableFormObj(label_YN02,"1_1_1_1" );
	var obj_YN02_01 = getTableFormCheckBox(label_YN02_01,"1_1_1_1" );
	if (obj_YN02.value == "否") {
		// 只读
		// 清空
		disableTableCheckBox(obj_YN02_01,true);
	} else if (obj_YN02.value == "是") {
		// 还原
		disableTableCheckBox(obj_YN02_01,false);
	}
}



/*
* 功能：点击是否下方表单是否可填
* 配置："信息科技外包管理#信息科技外包风险评估#内容#是否开展信息科技外包风险评估#是否开展信息科技外包风险评估";
		"信息科技外包管理#信息科技外包风险评估#内容#信息科技外包风险评估阶段#信息科技外包风险评估阶段";
		"信息科技外包管理#信息科技外包风险评估#内容#信息科技外包风险评估执行部门#信息科技外包风险评估执行部门";
*/
function setobj_YN07(obj){
	var obj_YN07 = getTableFormObj(label_YN07,"1_1_1_1" );
	var obj_YN07_01 = getTableFormCheckBox(label_YN07_01,"1_1_1_1" );
	var obj_YN07_02 = getTableFormObj(label_YN07_02,"1_1_1_1" );
	if (obj_YN07.value == "否") {
		// 只读
		// 清空
		disableTableCheckBox(obj_YN07_01,true);
		columnVallueRadio1(obj_YN07_02,false);
	} else if (obj_YN07.value == "是") {
		// 还原
		disableTableCheckBox(obj_YN07_01,false);
		columnVallueRadio1(obj_YN07_02,true);
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置："信息科技外包管理#外包合同管理#内容#是否所有外包合同均需经过相关部门审核#是否所有外包合同均需经过相关部门审核";
		"信息科技外包管理#外包合同管理#内容#审核部门#审核部门";
*/
function setobj_YN05(obj){
	var obj_YN05 = getTableFormObj(label_YN05,"1_1_1_1" );
	var obj_YN05_01 = getTableFormCheckBox(label_YN05_01,"1_1_1_1" );
	if (obj_YN05.value == "否") {
		// 只读
		// 清空
		disableTableCheckBox(obj_YN05_01,true);
	} else if (obj_YN05.value == "是") {
		// 还原
		disableTableCheckBox(obj_YN05_01,false);
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置："信息科技外包管理#外包服务商审计#内容#外包服务商审计1#依据何种情况要求外包服务商委托外部审计机构对其实施安全审计";
		"信息科技外包管理#外包服务商审计#内容#外包服务商审计2#审计频度";
		"信息科技外包管理#外包服务商管理#内容#产生的总费用#产生的总费用";
*/
function setobj_YN06(obj){
	var obj_item = getTableFormObj(label_YN06,"1_1_1_1" );
	var obj_YN06_01_GTZero = getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" );
	var obj_YN06 = getTableFormCheckBox(label_YN06,"1_1_1_1" );
	for(var i = 0; i < obj_YN06.length; i++){
		if (obj_YN06[i].value.trim() == "未要求外包商委托外部机构实施审计" && obj_YN06[i].checked == true) {
			// 只读
			disableTableCheckBox1(obj_YN06,true,"未要求外包商委托外部机构实施审计",true);
			obj_YN06_01_GTZero.value = "";
			obj_YN06_01_GTZero.onclick = "";
			obj_item.value = "未要求外包商委托外部机构实施审计";
			break;
		} 
		if(obj_YN06[i].value == "未要求外包商委托外部机构实施审计" && obj_YN06[i].checked == false){
			// 还原
			disableTableCheckBox1(obj_YN06,false,"未要求外包商委托外部机构实施审计",true);
			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
			break;
		}
	}
	for(var i = 0; i < obj_YN06.length; i++){
		if(obj_YN06[i].value == "定期审计" && obj_YN06[i].checked == false){
			obj_YN06_01_GTZero.value = "";
			obj_YN06_01_GTZero.onclick = "";
			break;
		}
		if(obj_YN06[i].value == "定期审计" && obj_YN06[i].checked == true){
			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
			break;
		}
	}
}

///*
// *功能：在依据何种情况要求外包服务商委托外部审计机构对其实施安全审计 多选框没有选择“定期审计”时定期审计不可输入
// *配置： 信息科技外包管理#外包服务商审计#内容#外包服务商审计2#外包服务商审计2-2
// * */
//function setObj_YN06_01(obj){
//	var obj_YN06 = getTableFormCheckBox(label_YN06,"1_1_1_1" );
//	var obj_YN06_01_GTZero = getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" );
//	for(var i = 0; i < obj_YN06.length; i++){
//		if(obj_YN06[i].value == "定期审计" && obj_YN06[i].checked == true){
//			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
//		//	break;
//		}else if(obj_YN06[i].value =="定期审计" && obj_YN06[i].checked == false){
//			obj_YN06_01_GTZero.value = "";
//			obj_YN06_01_GTZero.onclick = "";
//		}
//	}
//	
//}
/*
* 功能：当选择 不保存 时其他多选项不可选
* 参数：objs 为所有复选框对象集合
* 	  flag 为设置不可选标识，true时除str复选框别的不可选，false反之
* 	  str  可选值（其他选项不可选）
* 	  qita 为是否有“其他”选项的文本框
*/	  
function disableTableCheckBox1(objs,flag,str,qita){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(flag && objs[i].value != str){
				objs[i].disabled = flag;
				objs[i].checked = false;
				if(qita){
					//清空“其他”并设置为只读
					var showvalue = getShowTarget(objs[i].parentElement);
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}else if(!flag && objs[i].value != str ){
				objs[i].disabled = flag;
//				objs[i].checked = false;
			}
		}
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData(){
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	checkNumFloat(getTableFormObjs("信息科技外包管理#外包服务商管理#内容#外包商服务水平达标率#外包商服务水平达标率")[0],2);
	checkNumFloat(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ),2);
	checkNumFloat(getTableFormObjs("信息科技外包管理#外包服务商管理#内容#外包人员异常退出率#外包人员异常退出率")[0],2);
	if(getTableFormObj(label_YN01,"1_1_1_1" ).value=="是"){
		var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1_1_1" );
		var obj_YN01_02 = getTableFormObj(label_YN01_02,"1_1_1_1" );
		if(obj_YN01_01.value.trim()==""){
			errorObjs.push(obj_YN01_01);
			a +="信息科技外包管理组织（部门、团队）名称不能为空\n";
			isValid = false;
		}
		if(obj_YN01_02.value.trim()==""){
			errorObjs.push(obj_YN01_02.parentElement);
			a +="信息科技外包管理组织成员来自（多选）不能为空\n";
			isValid = false;
		}
		
	}
	if(getTableFormObj(label_YN02,"1_1_1_1" ).value=="是"){
		var obj_YN02_01 = getTableFormObj(label_YN02_01,"1_1_1_1" );
		if(obj_YN02_01.value.trim()==""){
			errorObjs.push(obj_YN02_01.parentElement);
			a +="涉及信息科技外包的领域包括(多选)不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN07,"1_1_1_1" ).value=="是"){
		var obj_YN07_01 = getTableFormObj(label_YN07_01,"1_1_1_1" );
		var obj_YN07_02 = getTableFormObj(label_YN07_02,"1_1_1_1" );
		if(obj_YN07_01.value.trim()==""){
			errorObjs.push(obj_YN07_01.parentElement);
			a +="信息科技外包风险评估阶段不能为空\n";
			isValid = false;
		}
		if(obj_YN07_02.value.trim()==""){
			errorObjs.push(obj_YN07_02.parentElement);
			a +="信息科技外包风险评估执行部门不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05,"1_1_1_1" ).value=="是"){
		var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1_1" );
		if(obj_YN05_01.value.trim()==""){
			errorObjs.push(obj_YN05_01.parentElement);
			a +="审核部门不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormCheckBox(label_YN06,"1_1_1_1" ).value=="是"){
		var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj_YN05_01.parentElement);
			a +="审核部门不能为空\n";
			isValid = false;
		}
	}
	for(var i = 0; i < getTableFormCheckBox(label_YN06,"1_1_1_1" ).length; i++){
		if(getTableFormCheckBox(label_YN06,"1_1_1_1" )[i].value == "定期审计" && getTableFormCheckBox(label_YN06,"1_1_1_1" )[i].checked == true){
				if(getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" ).value.trim()==""){
					errorObjs.push(getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" ));
					a +="定期审计不能为空\n";
					isValid = false;
				}
		}
	}
	if(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ).value ==""){
		errorObjs.push(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ));
		a +="外包服务商管理-产生的总费用不能为空\n";
		isValid = false;
	}
	var obj_item2_GTZero = getTableFormObjs(label_item2_GTZero)[0];
	var obj_item4_GTZero = getTableFormObjs(label_item4_GTZero)[0];
	var obj_item6_GTZero = getTableFormObjs(label_item6_GTZero)[0];
	var obj_item8_GTZero = getTableFormObjs(label_item8_GTZero)[0];
	var obj_item10_GTZero = getTableFormObjs(label_item10_GTZero)[0];
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item4_GTZero.value)){
		errorObjs.push(obj_item2_GTZero);
		errorObjs.push(obj_item4_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目工作总量>=信息科技外包管理整体框架 | 信息科技外包项目基础设施类出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item6_GTZero.value)){
		errorObjs.push(obj_item6_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目工作总量>=信息科技外包管理整体框架 | 信息科技外包项目系统服务类出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item8_GTZero.value)){
		errorObjs.push(obj_item8_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目工作总量>=信息科技外包管理整体框架 | 信息科技外包项目人员服务类出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item10_GTZero.value)){
		errorObjs.push(obj_item10_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目工作总量>=信息科技外包管理整体框架 | 信息科技外包项目咨询服务类出错！\n";
	  	isValid=false;
	}
	
	var obj_item1_GTZero = getTableFormObjs(label_item1_GTZero)[0];
	var obj_item3_GTZero = getTableFormObjs(label_item3_GTZero)[0];
	var obj_item5_GTZero = getTableFormObjs(label_item5_GTZero)[0];
	var obj_item7_GTZero = getTableFormObjs(label_item7_GTZero)[0];
	var obj_item9_GTZero = getTableFormObjs(label_item9_GTZero)[0];
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item3_GTZero.value)){
		errorObjs.push(obj_item3_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目总数>=信息科技外包管理整体框架 | 信息科技外包项目基础类项目数出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item5_GTZero.value)){
		errorObjs.push(obj_item5_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目总数>=信息科技外包管理整体框架 | 信息科技外包项目系统服务类项目数出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item7_GTZero.value)){
		errorObjs.push(obj_item7_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目总数>=信息科技外包管理整体框架 | 信息科技外包项目人员服务类项目数出错！\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item9_GTZero.value)){
		errorObjs.push(obj_item9_GTZero);
	 	a+="信息科技外包管理整体框架 | 信息科技外包项目总数>=信息科技外包管理整体框架 | 信息科技外包项目咨询服务类项目数出错！\n";
	  	isValid=false;
	}
	var obj_item1_GTZero_2 = getTableFormObjs(label_item1_GTZero_2)[0];
	var obj_item3_GTZero_2 = getTableFormObjs(label_item3_GTZero_2)[0];
	var obj_item4_GTZero_2 = getTableFormObjs(label_item4_GTZero_2)[0];
	if(parseInt(obj_item1_GTZero_2.value) < parseInt(obj_item3_GTZero_2.value)){
		errorObjs.push(obj_item3_GTZero_2);
	 	a+="信息科技外包管理 | 外包服务商管理 | 信息科技外包商的数量>=2、信息科技外包管理 | 外包服务商管理 | 外包服务评价结果合格的外包商数出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_item1_GTZero_2.value) < parseInt(obj_item4_GTZero_2.value)){
		errorObjs.push(obj_item4_GTZero_2);
	 	a+="信息科技外包管理 | 外包服务商管理 | 信息科技外包商的数量>=2、信息科技外包管理 | 外包服务商管理 | 参与评价的外包商数出错！\n";
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
/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
var click_columnValueNumber = function() {
	columnValueNumber(this);
};
/*
* 功能：文本框若输入大于100时默认为100
*
*/
function sethundred(obj){
	checkNumNotNegative(obj);
	if(obj.value>100){
		obj.value=100;
	}
}
/*
 *功能：单选按钮的读写设置
 */
function columnVallueRadio1(obj,access){
	if(!access){
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
					if(!access){
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					}else{
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
	}
}




