/*
 * 报表：2014- T-B-8 信息科技运行维护管理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

//基本情况
var label_YN01_03 = "基本情况#内容#机构通过运维管理体系认证";
var label_YN01_04 = "基本情况#内容#如是，通过认证时间";
var label_YN01_05 = "基本情况#内容#认证名称";
var label_YN01_06 = "基本情况#内容#认证机构";
var label_YN01_07 = "基本情况#内容#通过认证的部门（组织）名称";
//监控管理
var label_YN02_01 = "监控管理#内容#自动化工具监控范围";
//变更管理
var label_YN03_01 = "变更管理#内容#变更管理范围";
var label_YN03_02 = "变更管理#内容#对变更进行分级管理";
var label_YN03_03 = "变更管理#内容#如是，分为";
var label_YN03_05 = "变更管理#内容#建立变更的统一管理机制";
var label_YN03_06 = "变更管理#内容#变更管理组织（团队）名称";
var label_YN03_08 = "变更管理#内容#安排固定的变更（非紧急变更）执行窗口";
var label_YN03_09 = "变更管理#内容#窗口时间";
var label_YN03_11 = "变更管理#内容#所有变更均留有记录";
var label_YN03_12 = "变更管理#内容#保留方式";
//事件管理
var label_YN04_01 = "事件管理#内容#事件管理范围";
//问题管理
var label_YN05_01 = "问题管理#内容#问题管理范围";
//容量管理
var label_YN06_03 = "容量管理#内容#建立容量管理的定期评估机制"; 
var label_YN06_04 = "容量管理#内容#评估周期"; 
//内部服务水平管理
var label_YN08_01 = "内部服务水平管理#内容#在机构内部签订服务水平协议或制定服务水平考核指标"; 
var label_YN08_02 = "内部服务水平管理#内容#如是，定期检查、通报执行情况"; 
var label_YN08_03 = "内部服务水平管理#内容#频率"; 
/*
 * 功能：提交校验
 */
function checkData(){
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//基本情况校验
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_03.rownumber);
	var obj_YN01_05 = getTableFormObj(label_YN01_05,obj_YN01_03.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_03.rownumber);
	var obj_YN01_07 = getTableFormObj(label_YN01_07,obj_YN01_03.rownumber);
	if(obj_YN01_03.value == "是"){
		if(obj_YN01_04.value == ""){
			isValid = false;
			a += "1.如是，通过认证时间:不能为空!\n";
			errorObjs.push(obj_YN01_04);
		}
		if(obj_YN01_05.value == ""){
			isValid = false;
			a += "1.认证名称：不能为空!\n";
			errorObjs.push(obj_YN01_05);
		}
		if(obj_YN01_06.value == ""){
			isValid = false;
			a += "1.认证机构：不能为空!\n";
			errorObjs.push(obj_YN01_06);
		}
		if(obj_YN01_07.value == ""){
			isValid = false;
			a += "1.通过认证的部门（组织）名称：不能为空!\n";
			errorObjs.push(obj_YN01_07);
		}
	}
	//监控管理校验
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	if(obj_YN02_01.value == ""){
		errorObjs.push(obj_YN02_01);
		a+="复选框 自动化工具监控范围 不能为空！\n";
		isValid=false;
	}
	//变更管理校验
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	if(obj_YN03_01.value == ""){
		errorObjs.push(obj_YN03_01);
		a+="复选框 3.变更管理范围 不能为空！\n";
		isValid=false;
	}
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber);
	if(obj_YN03_02.value == "是" && obj_YN03_03.value == ""){
		isValid = false;
		a += "3.如是，分为几级不能为空!\n";
		errorObjs.push(obj_YN01_04);
	}
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03_05.rownumber);
	if(obj_YN03_05.value == "是" && obj_YN03_06.value == ""){
		isValid = false;
		a += "3.变更管理组织（团队）名称不能为空!\n";
		errorObjs.push(obj_YN03_06);
	}
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "是" && obj_YN03_09.value == ""){
		isValid = false;
		a += "3.变更管理窗口时间不能为空!\n";
		errorObjs.push(obj_YN03_09);
	}
	var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];
	var obj_YN03_12 = getTableFormObjs(label_YN03_12)[0];
	if(obj_YN03_11.value == "是" && obj_YN03_12.value == ""){
		isValid = false;
		a += "3.变更管理保留方式不能为空!\n";
		errorObjs.push(obj_YN03_12);
	}
	//事件管理
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	if(obj_YN04_01.value == ""){
		errorObjs.push(obj_YN04_01);
		a+="复选框 事件管理范围 不能为空！\n";
		isValid=false;
	}
	//问题管理
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	if(obj_YN05_01.value == ""){
		errorObjs.push(obj_YN05_01);
		a+="复选框 问题管理范围 不能为空！\n";
		isValid=false;
	}
	//容量管理
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "是" && obj_YN06_04.value == ""){
		isValid = false;
		a += "6.评估周期不能为空!\n";
		errorObjs.push(obj_YN06_04);
	}

	//内部服务水平管理
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08_01.rownumber);
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_01.rownumber);
	if(obj_YN08_01.value == "是"){
		if(obj_YN08_02.value == ""){
			isValid = false;
			a += "8.如是，定期检查、通报执行情况不能为空!\n";
			errorObjs.push(obj_YN08_02);
		}
		if(obj_YN08_02.value == "是" && obj_YN08_03.value == ""){
			isValid = false;
			a += "8.频率不能为空!\n";
			errorObjs.push(obj_YN08_03);
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
 * 功能：通过建立容量管理的定期评估机制决定评估周期只读和可填
 * 配置：容量管理#内容#建立容量管理的定期评估机制
 */
function setYN08_02_03Disable(obj){
	//label_YN08_01 = "内部服务水平管理#内容#在机构内部签订服务水平协议或制定服务水平考核指标"
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	if(obj_YN08_01){
		//label_YN08_02 = "内部服务水平管理#内容#如是，定期检查、通报执行情况"
		var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08_01.rownumber);
		//label_YN08_03 = "内部服务水平管理#内容#频率"
		var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_01.rownumber);
		if(obj_YN08_01.value == "否" || obj_YN08_01.value == ""){
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("disabled",true);
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("disabled",true);
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("src","images/rb01.gif");
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("src","images/rb01.gif");
			obj_YN08_03.readOnly = "readonly";
			obj_YN08_02.value ="";
			obj_YN08_03.value ="";
		}else if(obj_YN08_01.value == "是"){
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("disabled",false);
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("disabled",false);

		}
	}
	
}
var setDisable = function(){
	setYN08_03Disable (this);
};

function setYN08_03Disable (){
	var obj_YN08_02 = getTableFormObjs(label_YN08_02)[0];
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_02.rownumber);
	if(obj_YN08_02.value == "是"){
		obj_YN08_03.readOnly = "";
	}else{
		obj_YN08_03.readOnly = "readonly";
		obj_YN08_03.value ="";
	}
}
/*
 * 功能：通过建立容量管理的定期评估机制决定评估周期只读和可填
 * 配置：容量管理#内容#建立容量管理的定期评估机制
 */
function setYN06_04Disable(obj){
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if(obj_YN06_03){
		var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
		if(obj_YN06_03.value == "否" || obj_YN06_03.value == ""){
			obj_YN06_04.readOnly = "readonly";
			obj_YN06_04.value ="";
		}else if(obj_YN06_03.value == "是"){
			obj_YN06_04.readOnly = "";
		}
	}
	
}

/*
 * 功能：通过所有变更均留有记录决定保留方式只读和可填
 * 配置：变更管理#内容#所有变更均留有记录
 */
function setYN03_12Disable(obj){
	var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];
	if(obj_YN03_11){
		var obj_YN03_12 = getTableFormCheckBox(label_YN03_12, "1_1");
		if(obj_YN03_11.value == "否" || obj_YN03_11.value == ""){
			// 清空
			obj_YN03_12.onclick = "";
			// 只读
			disableTableCheckBox(obj_YN03_12, true);
		}else if(obj_YN03_11.value == "是"){
			disableTableCheckBox(obj_YN03_12, false);
		}
	}
	
	
}

/*
 * 功能：通过安排固定的变更（非紧急变更）执行窗口决定窗口时间只读和可填
 * 配置：变更管理#内容#安排固定的变更（非紧急变更）执行窗口
 */
function setYN03_09Disable(obj){
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	if(obj_YN03_08){
		var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
		if(obj_YN03_08.value == "否" || obj_YN03_08.value == ""){
			obj_YN03_09.onclick = "";
			obj_YN03_09.value ="";
		}else if(obj_YN03_08.value == "是"){
			obj_YN03_09.onclick = click_columnshowDate;
		}
	}
	
	
}
/*
 * 功能：通过对变更进行分级管理决定通过如是，分为只读和可填
 * 配置：变更管理#内容#对变更进行分级管理
 */
function setYN03_06Disable(obj){
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	if(obj_YN03_06){
		var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03_05.rownumber);
		if(obj_YN03_05.value == "否" || obj_YN03_05.value == ""){
			obj_YN03_06.readOnly = "readonly";
			obj_YN03_06.value ="";
		}else if(obj_YN03_05.value == "是"){
			obj_YN03_06.readOnly = "";
		}
	}
	
}
/*
 * 功能：通过对变更进行分级管理决定通过如是，分为只读和可填
 * 配置：变更管理#内容#对变更进行分级管理
 */
function setYN03_03Disable(obj){
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	if(obj_YN03_02){
		var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber);
		if(obj_YN03_02.value == "否" || obj_YN03_02.value == ""){
			obj_YN03_03.readOnly = "readonly";
			obj_YN03_03.value ="";
		}else if(obj_YN03_02.value == "是"){
			obj_YN03_03.readOnly = "";
		}
	}
	
}
/*
 * 功能：通过机构通过运维管理体系认证决定通过认证时间,认证名称,认证机构,通过认证的部门只读和可填
 * 配置：基本情况#内容#机构通过运维管理体系认证
 */
function setYN01_04_05_06_07Disable(obj){
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	if(obj_YN01_03){
		var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_03.rownumber);
		var obj_YN01_05 = getTableFormObj(label_YN01_05,obj_YN01_03.rownumber);
		var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_03.rownumber);
		var obj_YN01_07 = getTableFormObj(label_YN01_07,obj_YN01_03.rownumber);
		if(obj_YN01_03.value == "否" || obj_YN01_03.value == ""){
			//只读
			obj_YN01_04.onclick = "";
			obj_YN01_05.readOnly = "readonly";
			obj_YN01_06.readOnly = "readonly";
			obj_YN01_07.readOnly = "readonly";
			//清空
			obj_YN01_04.value ="";
			obj_YN01_05.value ="";
			obj_YN01_06.value ="";
			obj_YN01_07.value ="";
		}else if(obj_YN01_03.value == "是"){
			obj_YN01_04.onclick = click_columnshowDate;
			obj_YN01_05.readOnly = "";
			obj_YN01_06.readOnly = "";
			obj_YN01_07.readOnly = "";
		}
	}
	
}

/*
 * 初始化
 */
function initSet(){
	var obj = 0;
	setYN08_02_03Disable(obj);
	setYN06_04Disable(obj);
	setYN03_12Disable(obj);
	setYN03_09Disable(obj);
	setYN03_06Disable(obj);
	setYN03_03Disable(obj);
	setYN01_04_05_06_07Disable(obj);
}
/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
};
/*
 *功能：单选按钮的读写设置
 *参数：obj为单选对象
 *	  access当单选可被选时传true，不可被选时传false
 *	  flag 为是否添加特殊函数调用
 */
function columnVallueRadio1(obj,access,flag){
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
						if(!flag){
							imgs[k].onclick = function(){
								columnVallueRadio(this);
							};
						}else{
							imgs[k].onclick = function(){
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
 * 
 * 文本域的宽度对齐
 */ 
jQuery(function(){
	jQuery("div[name = 'textarea_show_value']").css("width","160px"); 
});