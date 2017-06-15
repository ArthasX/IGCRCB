/*
 * 报表：T-B-5 各类中心情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item10 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填报日期";
var label_item5 = "中心情况信息#名称";
var label_O_item25 = "中心情况信息#类型";
var label_O_item12 = "中心情况信息#运维模式";
var label_item6 = "中心情况信息#地点#国家";
var label_item7 = "中心情况信息#地点#省（自治区、直辖市）";
var label_item8 = "中心情况信息#地点#市（县、州、盟）";
var label_item9 = "中心情况信息#地点#所在地邮政编码";
var label_item22 = "中心情况信息#启用日期";
var label_item1 = "附件#内容#附件索引";
var label_item2 = "附件#内容#各类中心情况明细报告";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){}

/*
* 功能：点击提交时进行的表单验证
* 配置：填报状态的“提交”按钮
*/
function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		checkTableItemNull(objs[i]);
	}
//	if (getTableFormObj(label_item2,"1_1").value.trim() == "") {
//		errorObjs.push(label_item2);
//		a += "各类中心情况明细报告不能为空！\n";
//		isValid = false;
//	}
//	if (getTableFormObj(label_item1,"1_1").value.trim() == "") {
//		errorObjs.push(label_item1);
//		a += "各类中心情况明细报告，附件索引不能为空！\n";
//		isValid = false;
//	}
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
* 功能：根据名称判断该行是否全输入值
*/
function checkTableItemNull(obj) {
	if (replaceAll(obj.value.trim()) == "") {
		errorObjs.push(obj);
		a += "名称不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_O_item25, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_O_item25, obj.rownumber));
		a += "名称" + obj.value.trim() + "：" + "类型不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_O_item12, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_O_item12, obj.rownumber));
		a += "名称" + obj.value.trim() + "：" + "运维模式不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_item6, obj.rownumber + "_1").value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item6, obj.rownumber + "_1"));
		a += "名称" + obj.value.trim() + "：" + "国家不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_item7, obj.rownumber + "_1").value.trim().trim() == "") {
		errorObjs.push(getTableFormObj(label_item7, obj.rownumber + "_1"));
		a += "名称" + obj.value.trim() + "：" + "省（自治区、直辖市）不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_item8, obj.rownumber + "_1").value.trim().trim() == "") {
		errorObjs.push(getTableFormObj(label_item8, obj.rownumber + "_1"));
		a += "名称" + obj.value.trim() + "：" + "市（县、州、盟）不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_item9, obj.rownumber + "_1").value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item9, obj.rownumber + "_1"));
		a += "名称" + obj.value.trim() + "：" + "所在地邮政编码不能为空！\n";
		isValid = false;
	}
	if (getTableFormObj(label_item22, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item22, obj.rownumber));
		a += "名称" + obj.value.trim() + "：" + "启用日期不能为空！\n";
		isValid = false;
	}
}

/*
 * 功能：回车行替换
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}



