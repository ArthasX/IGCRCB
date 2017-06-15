/*
 * 报表：T-B-12 灾难备份管理情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "灾备中心（或灾备机房）基本情况#灾备模式#内容";
var label_item6 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#中心名称";
var label_item7 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#所备份的生产中心名称";
var label_item = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#区域";
var label_item8 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#地点";
var label_item9_GTZero = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#与生产中心距离（公里）";
var label_item10 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#灾备恢复能力等级";
var label_item11 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#是否外包";
var label_item12 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#外包商名称";
var label_item14 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#外包类型";
var label_item15 = "灾备中心（或灾备机房）基本情况#灾备中心（或灾备机房）名称#启用日期";

/*
 *功能：恢复添加行功能
 */
var click_addrow = function(){
	addRow(this,'N');
}
/*
 *功能：恢复删除行功能
 */
var re_deleterow = function(){
	deleteRow(this,'N');
}
/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
 *功能：恢复数字键盘输入
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
//	var target = getTarget(obj.parentElement);
	var obj_item5 = getTableFormObjs(label_item5)[0];
	var obj_item6s = getTableFormObjs(label_item6);
	if(obj_item5.value == "无灾备中心"){
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			//清除所有添加行
			if(obj_item6s[i].rownumber.indexOf("#") < 0)
			deleteRow(obj_item6s[i],'N');
			var addImg = document.getElementsByName("灾备中心（或灾备机房）名称")[0];
			addImg.onclick = "";
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14 = getTableFormObj(label_item14,obj_item6s[i].rownumber);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			只读
			obj_item6_area.contentEditable = false;
			obj_item7_area.contentEditable = false;
			columnVallueRadio1(obj_item,false,false);
			obj_item8_area.contentEditable = false;
			columnVallueRadio1(obj_item10,false,false);
			columnVallueRadio1(obj_item11,false,false);
			obj_item12_area.contentEditable = false;
			disableTableCheckBox(obj_item14_checkbox,true);
			
//			清值
			obj_item6_area.innerHTML = "";
			obj_item7_area.innerHTML = "";
			obj_item8_area.innerHTML = "";
			obj_item9.onclick = "";
			obj_item12_area.innerHTML = "";
			obj_item14.value = "";
			obj_item15.onclick = "";			
			
		}
	}else if(obj_item5.value != "无灾备中心"){
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			可写
			obj_item6_area.contentEditable = true;
			obj_item7_area.contentEditable = true;
			columnVallueRadio1(obj_item,true,false);
			obj_item8_area.contentEditable = true;
			obj_item9.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_item10,true,false);
			columnVallueRadio1(obj_item11,true,true);
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
			obj_item15.onclick = click_columnshowDate;			
			
			var addImg = document.getElementsByName("灾备中心（或灾备机房）名称")[0];
			if(addImg.onclick == ""){
				//如果之前点过“无灾备中心”addimg的onclick事件为空，则添加添加行方法
				addImg.onclick = click_addrow;
			}
		}
	}
	
	var obj_item11 = getTableFormObjs(label_item11);
	for(var i = 0; i < obj_item11.length; i++){
		var obj_item12 = getTableFormObj(label_item12,obj_item11[i].rownumber);
		var obj_item12_area = getEditDiv(obj_item12);
		var obj_item14 = getTableFormObj(label_item14,obj_item11[i].rownumber);
		var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item11[i].rownumber);
		if(obj_item11[i].value == "否"){
			// 只读
			obj_item12_area.contentEditable = false;
			// 清空
			obj_item12_area.innerHTML = "";
			disableTableCheckBox(obj_item14_checkbox,true);
			//清除颜色
			getEditDiv(obj_item12).style.backgroundColor = "";
			obj_item14.parentElement.style.color = "";
		}else {
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
		}
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：灾备中心（或灾备机房）基本情况 #灾备模式#内容
 */
function setItem5Disable(obj) {
	var target = getTarget(obj.parentElement);
	var obj_item6s = getTableFormObjs(label_item6);
	if(target.value == "无灾备中心"){
		
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			//清除所有添加行
			if(obj_item6s[i].rownumber.indexOf("#") < 0)
			deleteRow(obj_item6s[i],'N');
			
			var addImg = document.getElementsByName("灾备中心（或灾备机房）名称")[0];
			addImg.onclick = "";
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14 = getTableFormObj(label_item14,obj_item6s[i].rownumber);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			只读
			obj_item6_area.contentEditable = false;
			obj_item7_area.contentEditable = false;
			columnVallueRadio1(obj_item,false,false);
			obj_item8_area.contentEditable = false;
			columnVallueRadio1(obj_item10,false,false);
			columnVallueRadio1(obj_item11,false,false);
			obj_item12_area.contentEditable = false;
			disableTableCheckBox(obj_item14_checkbox,true);
			
//			清值
			obj_item6_area.innerHTML = "";
			obj_item7_area.innerHTML = "";
			obj_item8_area.innerHTML = "";
			obj_item9.onclick = "";
			obj_item12_area.innerHTML = "";
			obj_item14.value = "";
			obj_item15.onclick = "";			
			
		}
		var deleteimgs = document.getElementsByTagName("img");
		for(var i = 0; i < deleteimgs.length; i++){
			if(deleteimgs[i].src.indexOf("images/bullet_delete.png") > -1){
				deleteimgs[i].onclick = "";
			}
		}
	}else if(target.value != "无灾备中心"){
		var deleteimgs = document.getElementsByTagName("img");
		for(var i = 0; i < deleteimgs.length; i++){
			if(deleteimgs[i].src.indexOf("images/bullet_delete.png") > -1 && deleteimgs[i].onclick == ""){
				deleteimgs[i].onclick = re_deleterow;
			}
		}
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			可写
			obj_item6_area.contentEditable = true;
			obj_item7_area.contentEditable = true;
			columnVallueRadio1(obj_item,true,false);
			obj_item8_area.contentEditable = true;
			obj_item9.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_item10,true,false);
			columnVallueRadio1(obj_item11,true,true);
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
			obj_item15.onclick = click_columnshowDate;	
			
			var addImg = document.getElementsByName("灾备中心（或灾备机房）名称")[0];
			if(addImg.onclick == ""){
				//如果之前点过“无灾备中心”addimg的onclick事件为空，则添加添加行方法
				addImg.onclick = click_addrow;
			}
		}
	}
}


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
								setItem11Disable(this);
							};
						}
					}
				}
			}
		}
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：灾备中心（或灾备机房）基本情况 #灾备中心（或灾备机房）名称#是否外包
 */
function setItem11Disable(obj) {
	var target = getTarget(obj.parentElement);
	var obj_item12 = getTableFormObj(label_item12,target.rownumber);
	var obj_item12_area = getEditDiv(obj_item12);
	var obj_item14 = getTableFormObj(label_item14,target.rownumber);
	var obj_item14_checkbox = getTableFormCheckBox(label_item14,target.rownumber);
	if(target.value == "否"){
		// 只读
		obj_item12_area.contentEditable = false;
		// 清空
		obj_item12_area.innerHTML = "";
		disableTableCheckBox(obj_item14_checkbox,true);
		//清除颜色
		getEditDiv(obj_item12).style.backgroundColor = "";
		obj_item14.parentElement.style.color = "";
	}else {
		obj_item12_area.contentEditable = true;
		disableTableCheckBox(obj_item14_checkbox,false);
	}
}

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
	
	var obj_item5 = getTableFormObjs(label_item5)[0];
	if(obj_item5.value == ""){
		a+="灾备中心基本情况：灾备模式不能为空\n";
		isValid=false;
		return;
	}
	
	var obj_item6s = getTableFormObjs(label_item6);
	for(var i = 0; i < obj_item6s.length; i++){
		if(obj_item6s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		checkTableItemNull(obj_item6s[i],obj_item5);
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
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull(obj,obj_item5) {

	var obj_item7 = getTableFormObj(label_item7,obj.rownumber);
	var obj_item = getTableFormObj(label_item,obj.rownumber);
	var obj_item8 = getTableFormObj(label_item8,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9_GTZero,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber);
	var obj_item12 = getTableFormObj(label_item12,obj.rownumber);
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	var obj_item15 = getTableFormObj(label_item15,obj.rownumber);

	if (obj_item5.value != "无灾备中心"){
		if(obj.value == "" && replaceAll(obj_item7.value.trim()) == "" && replaceAll(obj_item.value.trim()) == "" &&
				replaceAll(obj_item8.value.trim()) == "" && obj_item9.value == "" && obj_item10.value.trim() == ""&&
				obj_item11.value.trim() == "" && obj_item12.value == "" && obj_item14.value == "" && obj_item15.value.trim() == ""){
			errorObjs.push(getEditDiv(obj));
			errorObjs.push(getEditDiv(obj_item7));
			errorObjs.push(obj_item.parentElement);
			errorObjs.push(getEditDiv(obj_item8));
			errorObjs.push(obj_item9);
			errorObjs.push(obj_item10.parentElement);
			errorObjs.push(obj_item11.parentElement);
			errorObjs.push(obj_item15);
			a += "当选择非“无灾备中心”时，必须填报“灾备中心（或灾备机房）基本情况”中的“中心名称”等信息。\n";
			isValid = false;
		}else{
			if (replaceAll(obj.value.trim()) == ""  ) {
				errorObjs.push(getEditDiv(obj));
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不能为空！\n";
				isValid = false;
			}
			if (replaceAll(obj_item7.value.trim()) == "" ) {
				errorObjs.push(getEditDiv(obj_item7));
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“所备生产中心名称”不能为空！\n";
				isValid = false;
			}
			if (replaceAll(obj_item.value.trim()) == "" ) {
				errorObjs.push(obj_item.parentElement);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“区域”不能为空！\n";
				isValid = false;
			}
			if (replaceAll(obj_item8.value.trim()) == "" ) {
				errorObjs.push(getEditDiv(obj_item8));
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“地点”不能为空！\n";
				isValid = false;
			}
			if (obj_item9.value == "" ) {
				errorObjs.push(obj_item9);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“与生产中心距离（公里）”不能为空！\n";
				isValid = false;
			}
			if (obj_item10.value.trim() == "") {
				errorObjs.push(obj_item10.parentElement);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“启用日期”不能为空！\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "") {
				errorObjs.push(obj_item11.parentElement);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空，则此项“是否外包”不能为空！\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "是" && obj_item12.value == "") {
				errorObjs.push(obj_item12);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空并且“是否外包”为“是”时，则此项“外包商名称”不能为空！\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "是" && obj_item14.value == "") {
				errorObjs.push(obj_item14.parentElement);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空并且“是否外包”为“是”时，则此项“外包类型”不能为空！\n";
				isValid = false;
			}
			if (obj_item15.value.trim() == "") {
				errorObjs.push(obj_item15);
				a += "灾备中心(或灾备机房)基本情况"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：中心名称不为“无”或空并且“是否外包”为“是”时，则此项“启用日期”不能为空！\n";
				isValid = false;
			}
		}
	}
}

/*
 *功能：回车行替换
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}
