/*
 * 报表：2014 -T-B-5 网络安全管理情况表——报表填报
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
var label_YN00 = "报送空表表格#报送空表";
var label_YN00_01 = "标题#填报部门";
var label_YN00_02 = "标题#填报人";
var label_YN00_03 = "标题#填联系电话";
var label_YN00_04 = "标题#填报责任人";
var label_YN00_05 = "标题#填表日期";
// 生产网络安全域划分
var label_YN01_01 = "生产网络安全域划分#内容#区域名称";
var label_YN01_02 = "生产网络安全域划分#内容#用途及包含的重要信息系统";
var label_YN01_03 = "生产网络安全域划分#内容#可访问哪些网络安全域";
var label_YN01_04 = "生产网络安全域划分#内容#可被哪些网络安全域访问";
var label_YN01_05 = "生产网络安全域划分#内容#隔离及防护措施";
var label_YN01_06 = "生产网络安全域划分#内容#远程接入";
// 网络边界控制
var label_YN02_01 = "网络边界控制#表1#内容";
var label_YN02_02 = "网络边界控制#表2#内容";
var label_YN02_03 = "网络边界控制#表3#内容";
var label_YN02_04 = "网络边界控制#表4#内容";
// 生产网设备可用性
//var label_YN03_02_01 = "生产网设备可用性#数据中心名称";
// 生产网隔离
var label_YN07_01 = "生产网隔离#1#多选";
var label_YN07_02 = "生产网隔离#2#多选";
// 网络安全管理措施
var label_YN08_01 = "网络安全管理措施#内容#允许从内部办公网访问互联网";
var label_YN08_02 = "网络安全管理措施#内容#审批部门";
var label_YN08_03 = "网络安全管理措施#内容#互联网可访问内部网络";
var label_YN08_04 = "网络安全管理措施#内容#在机构内部使用无线局域网络";
var label_YN08_05 = "网络安全管理措施#内容#采用协议和加密方式";
var label_YN08_06 = "网络安全管理措施#内容#如是，无线局域网络所处网络区域";
var label_YN08_07 = "网络安全管理措施#内容#无线局域网络接入认证方式";
var label_YN08_08 = "网络安全管理措施#内容#建立定期网络漏洞扫描或检测机制";
var label_YN08_09 = "网络安全管理措施#内容#本年度网络漏洞扫描或检测的次数";
var label_YN08_10 = "网络安全管理措施#内容#网络防病毒软件安装覆盖率";
var label_YN08_11 = "网络安全管理措施#内容#网络病毒特征码更新率";

var label_YN08_12 = "网络安全管理措施#内容#与电信运营商签署DDoS防御服务协议";
var label_YN08_13 = "网络安全管理措施#内容#签署协议的电信运营商名称";
// 附件
var label_YN_09 = "附件#内容#内容#附件索引";
/*
 * 功能：提交按钮校验
 * 
 */
function checkData() {
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// 生产网络安全域划分校验
	var objs_YN01_01 = getTableFormObjs(label_YN01_01);
	var sign_YN01 = true;
	for ( var i = 0; i < objs_YN01_01.length-1; i++) {
		var obj_YN01_02 = getTableFormObj(label_YN01_02,
				objs_YN01_01[i].rownumber);
		var obj_YN01_03 = getTableFormObj(label_YN01_03,
				objs_YN01_01[i].rownumber);
		var obj_YN01_04 = getTableFormObj(label_YN01_04,
				objs_YN01_01[i].rownumber);
		var obj_YN01_05 = getTableFormObj(label_YN01_05,
				objs_YN01_01[i].rownumber);
		var obj_YN01_06 = getTableFormObj(label_YN01_06,
				objs_YN01_01[i].rownumber);

		if (objs_YN01_01[i].value == "" || obj_YN01_02.value == ""
				|| obj_YN01_03.value == "" || obj_YN01_04.value == ""
				|| obj_YN01_05.value == "" || obj_YN01_06.value == "") {
			if (objs_YN01_01[i].value == "") {
				errorObjs.push(objs_YN01_01[i]);
			}
			if (obj_YN01_02.value == "") {
				errorObjs.push(obj_YN01_02);
			}
			if (obj_YN01_03.value == "") {
				errorObjs.push(obj_YN01_03);
			}
			if (obj_YN01_04.value == "") {
				errorObjs.push(obj_YN01_04);
			}
			if (obj_YN01_05.value == "") {
				errorObjs.push(obj_YN01_05);
			}
			if (obj_YN01_06.value == "") {
				errorObjs.push(obj_YN01_06);
			}
			isValid = false;
			sign_YN01 = false;
		}
	}
	if (!sign_YN01) {
		a += "1.生产网络安全域划分各项不能为空！\n";
	}
	// 网络边界控制校验
	var objs_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var objs_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	var objs_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var objs_YN02_04 = getTableFormObjs(label_YN02_04)[0];
	if (objs_YN02_01.value == "" || objs_YN02_02.value == ""
			|| objs_YN02_03.value == "" || objs_YN02_04.value == "") {
		if (objs_YN02_01.value == "") {
			errorObjs.push(objs_YN02_01);
		}
		if (objs_YN02_02.value == "") {
			errorObjs.push(objs_YN02_02);
		}
		if (objs_YN02_03.value == "") {
			errorObjs.push(objs_YN02_03);
		}
		if (objs_YN02_04.value == "") {
			errorObjs.push(objs_YN02_04);
		}
		a += "2.网络边界控制各项不能为空！\n";
		isValid = false;
	}
//	// 生产网设备可用性校验
//	var objs_YN03_02_01 = getTableFormObjs(label_YN03_02_01);
//	var sign_YN03 = true;
//	for(var i = 0;i<objs_YN03_02_01.length;i++){
//		if(objs_YN03_02_01[i].value == ""){
//			sign_YN03 = false;
//			errorObjs.push(objs_YN03_02_01[i]);
//			isValid = false;
//		}
//	}
//	if(!sign_YN03){
//		a+="3.生产网设备可用性各项不能为空！\n";
//	}
	// 生产网隔离校验
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];

	if (obj_YN07_01.value == "" || obj_YN07_02.value == "") {
		if (obj_YN07_01.value == "") {
			errorObjs.push(obj_YN07_01);
		}
		if (obj_YN07_02.value == "") {
			errorObjs.push(obj_YN07_01);
		}
		a += "5.生产网隔离必输项不能为空！\n";
		isValid = false;
	}
	// 网络安全管理措施校验
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_08 = getTableFormObjs(label_YN08_08)[0];
	var obj_YN08_09 = getTableFormObjs(label_YN08_09)[0];
	var obj_YN08_10 = getTableFormObjs(label_YN08_10)[0];
	var obj_YN08_11 = getTableFormObjs(label_YN08_11)[0];
	var obj_YN08_12 = getTableFormObjs(label_YN08_12)[0];
	if (obj_YN08_01.value == "" || obj_YN08_03.value == ""
			|| obj_YN08_04.value == "" || obj_YN08_08.value == ""
			|| obj_YN08_09.value == "" || obj_YN08_10.value == ""
			|| obj_YN08_11.value == "" || obj_YN08_12.value == "") {
		if(obj_YN08_01.value == ""){
			errorObjs.push(obj_YN08_01);
		}
		if(obj_YN08_03.value == ""){
			errorObjs.push(obj_YN08_03);
		}
		if(obj_YN08_04.value == ""){
			errorObjs.push(obj_YN08_04);
		}
		if(obj_YN08_08.value == ""){
			errorObjs.push(obj_YN08_08);
		}
		if(obj_YN08_09.value == ""){
			errorObjs.push(obj_YN08_09);
		}
		if(obj_YN08_10.value == ""){
			errorObjs.push(obj_YN08_10);
		}
		if(obj_YN08_11.value == ""){
			errorObjs.push(obj_YN08_11);
		}
		if(obj_YN08_12.value == ""){
			errorObjs.push(obj_YN08_12);
		}
		
		a+="6.网络带宽管理必输项不能为空！\n";
		isValid = false;
	}
	// 附件校验
	var obj_YN_09 = getTableFormObjs(label_YN_09)[0];
	if (obj_YN_09.value == "") {
		errorObjs.push(obj_YN_09);
		a += "7.\"网络拓扑示意图及总体介绍版\"不能为空！\n";
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
	var emptyObj = getTableFormObjs(label_YN00)[0];
	if (emptyObj.value == "") {
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
	} else if (emptyObj.value == "报送空表") {
		isValid = true;
		var b = "";
		var obj_YN00_01 = getTableFormObj(label_YN00_01,"1");
		var obj_YN00_02 = getTableFormObj(label_YN00_02,"1");
		var obj_YN00_03 = getTableFormObj(label_YN00_03,"1");
		var obj_YN00_04 = getTableFormObj(label_YN00_04,"1");
		var obj_YN00_05 = getTableFormObj(label_YN00_05,"1");
		if(obj_YN00_01.value == ""){
			b += "填报部门内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_02.value == ""){
			b += "填报人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_03.value == ""){
			b += "联系电话内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_04.value == ""){
			b += "责任人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_05.value == ""){
			b += "填表日期内容不能为空！\n";
			isValid = false;
		}
		if(!isValid){
			alert(b);
		}
	}
	return isValid;
}
/*
 * 功能：初始化
 * 
 */
function initSet() {
	var obj = 0;
	setYN_08_02Visable(obj);
	setYN_08_05Visable(obj);
	setYN_08_13Visable(obj);
}
/*
 * 功能：通过与电信运营商签署DDoS防御服务协议来决定签署协议的电信运营商名称的隐藏和显示
 * 配置：网络安全管理措施#内容#与电信运营商签署DDoS防御服务协议
 */
function setYN_08_13Visable(obj) {
	var obj_YN08_12 = getTableFormObjs(label_YN08_12)[0];
	var obj_YN08_13 = getTableFormObjs(label_YN08_13)[0];
	if (obj_YN08_12.value == "否") {
		obj_YN08_13.value = "";
		obj_YN08_13.parentNode.previousSibling.style.display = "none";
		obj_YN08_13.parentNode.style.display = "none";
	} else if (obj_YN08_12.value == "是") {
		obj_YN08_13.readOnly = "";
		obj_YN08_13.parentNode.previousSibling.style.display = "";
		obj_YN08_13.parentNode.style.display = "";
	} else {
		obj_YN08_13.readOnly = "readonly";
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
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio0(obj, access, flag) {
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
						imgs[k].onclick="";
						if(!imgs[k].flag){
							jQuery(imgs[k].parentElement.nextSibling.firstChild).hide();
							imgs[k].parentElement.nextSibling.firstChild.value = "";
						}
					} else {
						if (!flag) {
							if(imgs[k].flag){
								imgs[k].onclick = ( function() {
									columnVallueRadio(this);
								});
							}else{
								imgs[k].onclick = ( function() {
									columnVallueRadioElse(this);
								});
							}
							
						} 
					}
				}
			}
		}
	}
}
/*
 * 功能：通过在机构内部使用无线局域网络来决定采用协议和加密方式的隐藏和显示 配置：网络安全管理措施#内容#在机构内部使用无线局域网络
 */
function setYN_08_05Visable(obj) {
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_05 = getTableFormObjs(label_YN08_05)[0];
	var obj_YN08_06 = getTableFormCheckBox(label_YN08_06, "1_1");
	var obj_YN08_07 = getTableFormObj(label_YN08_07, obj_YN08_04.rownumber);
	if (obj_YN08_04.value == "否") {
		obj_YN08_05.value = "";
		obj_YN08_05.parentNode.previousSibling.style.display = "none";
		obj_YN08_05.parentNode.style.display = "none";
		// 清空
		obj_YN08_06.onclick = "";
		obj_YN08_07.value = "";
		// 只读
		disableTableCheckBox(obj_YN08_06, true);
		columnVallueRadio0(obj_YN08_07, false,true);
	} else if (obj_YN08_04.value == "是") {
		obj_YN08_05.readOnly = "";
		obj_YN08_05.parentNode.previousSibling.style.display = "";
		obj_YN08_05.parentNode.style.display = "";
		disableTableCheckBox(obj_YN08_06, false);
		columnVallueRadio0(obj_YN08_07, true,false);
	} else {
		disableTableCheckBox(obj_YN08_06, true);
		obj_YN08_05.readOnly = "readonly";
		columnVallueRadio0(obj_YN08_07, false,true);
	}

}
/*
 * 功能：通过允许从内部办公网访问互联网来决定审批部门的隐藏和显示 配置：网络安全管理措施#内容#允许从内部办公网访问互联网
 */
function setYN_08_02Visable(obj) {
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObjs(label_YN08_02)[0];
	if (obj_YN08_01.value == "否") {
		obj_YN08_02.value = "";
		obj_YN08_02.parentNode.previousSibling.style.display = "none";
		obj_YN08_02.parentNode.style.display = "none";
	} else if (obj_YN08_01.value == "是") {
		obj_YN08_02.readOnly = "";
		obj_YN08_02.parentNode.previousSibling.style.display = "";
		obj_YN08_02.parentNode.style.display = "";
	} else {
		obj_YN08_02.readOnly = "readonly";
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

//初始化样式
jQuery(function() {
	if(jQuery("#psdid").val()!=jQuery("#pdid").val()+"003"){
		jQuery("#"+jQuery("#pdid").val()+"034_tableForm").css("width","815px");
		var tableArr = jQuery(".table_form_group");
		for(var i = 0;i<tableArr.length;i++){
			if(tableArr[i].id == jQuery("#pdid").val()+"042_tableForm"){
				jQuery(tableArr[i]).css("width","815px");
			}
		}
	}
});