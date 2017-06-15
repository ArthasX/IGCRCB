/*
 * 报表：T-A-1 信息科技组织、人员重大变动表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5="变动事项";
var label_RadioButtonList="变动类型";
var label_item7="生效日期";
var label_item8="变动详细情况";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_item5=getFormObj(label_item5);
	var obj_RadioButtonList=getFormObj(label_RadioButtonList);
	var obj_item7=getFormObj(label_item7);
	var obj_item8=getFormObj(label_item8);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	// 当"变动事项"不为空或"无"时,验证表单内容的必填
	if (obj_item5.innerHTML.trim()!= "无" && obj_item5.innerHTML.trim() != "") {
		if (obj_RadioButtonList.value.trim() == "") {
			errorObjs.push(obj_RadioButtonList.parentElement);
			a += "变动事项不为“无”或空，则变动类型不能为空！\n";
			isValid = false;
		}
		if (obj_item7.value.trim() == "") {
			errorObjs.push(obj_item7);
			a += "变动事项不为“无”或空，则生效日期不能为空！\n";
			isValid = false;
		}
		if (obj_item8.innerHTML.trim() == "") {
			errorObjs.push(obj_item8);
			a += "变动事项不为“无”或空，则变动详细情况不能为空！\n";
			isValid = false;
		}
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