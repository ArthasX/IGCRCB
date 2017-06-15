/*
 * 报表：2014 - T-B-3 信息科技内外部审计情况表 
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs=[];
//信息科技内外部审计情况表 
var label_YN11 = "信息科技内外部审计情况表#项目状态";
var label_YN11_01 = "信息科技内外部审计情况表#结束时间";
//整改率
var label_item95 = "信息科技内外部审计情况表#整改率";
//起始时间
var label_YN02_01 = "信息科技内外部审计情况表#起始时间";
//结束时间
var label_YN02_02 = "信息科技内外部审计情况表#结束时间";
//本年度信息科技审计覆盖一级分支机构的百分比 
var label_item105 = "百分比#本年度信息科技审计覆盖一级分支机构的百分比";
//审计发现数量
var label_YN_03_01 = "信息科技内外部审计情况表#审计发现数量#高风险";
var label_YN_03_02 = "信息科技内外部审计情况表#审计发现数量#中风险";
var label_YN_03_03 = "信息科技内外部审计情况表#审计发现数量#低风险";
//已整改数量
var label_YN_04_01 = "信息科技内外部审计情况表#已整改数量#高风险";	
var label_YN_04_02 = "信息科技内外部审计情况表#已整改数量#中风险";	
var label_YN_04_03 = "信息科技内外部审计情况表#已整改数量#低风险";	
var label_item5 = "信息科技内外部审计情况表#项目名称";
var label_empty = "报送空表表格#报送空表";
/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length-1;i++){
		var obj_YN11 = getTableFormObj(label_YN11,objs[i].rownumber);
		var obj_YN11_01 = getTableFormObj(label_YN11_01,obj_YN11.rownumber);
		if(obj_YN11.value.trim() == "进行中" || obj_YN11.value.trim() == "")
		{
			//只读
			obj_YN11_01.onclick = "";
			//清空
			obj_YN11_01.value = "";
		}else if(obj_YN11.value.trim() == "已完成"){
			obj_YN11_01.onclick = click_columnshowDate;
		}
	}
}

/*
* 功能：项目状态为进行中结束时间设置为空，并且点击事件取消
* 配置：年报审批
*/
function setItem11Disable(obj){
	var rownumber = "1";
	if(obj.flag == "进行中"){
		rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
	}else if(obj.flag == "已完成"){
		rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
	}
	var obj_YN11 = getTableFormObj(label_YN11, rownumber);
	var obj_YN11_01 = getTableFormObj(label_YN11_01,rownumber);
	if (obj_YN11.value.trim() == "进行中" || obj_YN11.value.trim() == "") {
		// 只读
		obj_YN11_01.onclick = "";
		// 清空
		obj_YN11_01.value = "";
	} else if (obj_YN11.value.trim() == "已完成") {
		obj_YN11_01.onclick = click_columnshowDate;
	}
}

/*
 *功能：判断表单内容是否大于100
 *配置：信息科技内外部审计情况表#整改率
 */
function checkItem95(obj){
	var rownumber = obj.rownumber;
	var obj_item95 = getTableFormObj(label_item95,rownumber);
	if (obj_item95.value > 100) {
		alert("请按规范填写整改率，整改率不能大于100\n");
		obj_item95.value = "";
	}
	if (obj_item95.value < 0) {
		alert("请按规范填写整改率，整改率不能小于0\n");
		obj_item95.value = "";
	}
//	var objs = getTableFormObjs(label_item5);
//	for(var i = 0;i<objs.length;i++){
//		var obj_item95 = getTableFormObj(label_item95,objs[i].rownumber);
//		if(obj_item95.value>100){
//			alert("请按规范填写整改率，整改率不能大于100\n");
//			obj_item95.value = ""; 
//		}
//		if(obj_item95.value<0){
//			alert("请按规范填写整改率，整改率不能小于0\n");
//			obj_item95.value = ""; 
//		}
//	}
	
}

/*
 *功能：判断表单内容是否大于100
 *配置：本年度信息科技审计覆盖一级分支机构的百分比 
 */
function checkItem105(obj){
	var obj_item105 = getTableFormObj(label_item105,"1");
	if(obj_item105.value>100){
		alert("请按规范填写本年度信息科技审计覆盖一级分支机构的百分比，数值不能大于100\n");
		obj_item105.value = ""; 
	}
}

/*
* 功能：校验岂止日期的大小
* 配置：信息科技内外部审计情况表#结束时间
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
//	var objs = getTableFormObjs(label_item5);
//	for(var i = 0;i<objs.length;i++){
//		var obj_YN02_01 = getTableFormObj(label_YN02_01,objs[i].rownumber);
//		var obj_YN02_02 = getTableFormObj(label_YN02_02,objs[i].rownumber);
//		if(obj_YN02_01.value != "" && obj_YN02_02.value != ""){
//			if(obj_YN02_01.value > obj_YN02_02.value){
//				 alert("结束日期不能小于开始日期！");
//				 obj_YN02_01.value = "";
//			}
//		}
//	}
	
}

/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
};
/*
 *功能：提交校验
 */
function checkData(){
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length;i++){
		//校验审计发现数量和已整改数量
		var obj_YN_03_01 = getTableFormObj(label_YN_03_01,objs[i].rownumber + "_1");
		var obj_YN_03_02 = getTableFormObj(label_YN_03_02,objs[i].rownumber + "_1");
		var obj_YN_03_03 = getTableFormObj(label_YN_03_03,objs[i].rownumber + "_1");
		var obj_YN_04_01 = getTableFormObj(label_YN_04_01,objs[i].rownumber + "_1");
		var obj_YN_04_02 = getTableFormObj(label_YN_04_02,objs[i].rownumber + "_1");
		var obj_YN_04_03 = getTableFormObj(label_YN_04_03,objs[i].rownumber + "_1");
		//判断已整改数量的数量是否大于校验审计发现数量
		//高风险
		if(obj_YN_04_01.value !=""){
			if(obj_YN_03_01.value != "" && parseInt(obj_YN_04_01.value) > parseInt(obj_YN_03_01.value)){
				errorObjs.push(obj_YN_03_01);
				errorObjs.push(obj_YN_04_01);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(高风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}else if(obj_YN_03_01.value == ""){
				errorObjs.push(obj_YN_03_01);
				errorObjs.push(obj_YN_04_01);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(高风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}
		}
		//中风险
		if(obj_YN_04_02.value !=""){
			if(obj_YN_03_02.value != "" && parseInt(obj_YN_04_02.value) > parseInt(obj_YN_03_02.value)){
				errorObjs.push(obj_YN_03_02);
				errorObjs.push(obj_YN_04_02);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(中风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}else if(obj_YN_03_02.value == ""){
				errorObjs.push(obj_YN_03_02);
				errorObjs.push(obj_YN_04_02);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(中风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}
		}
		//低风险
		if(obj_YN_04_03.value !=""){
			if(obj_YN_03_03.value != "" && parseInt(obj_YN_04_03.value) > parseInt(obj_YN_03_03.value)){
				errorObjs.push(obj_YN_03_03);
				errorObjs.push(obj_YN_04_03);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(低风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}else if(obj_YN_03_03.value == ""){
				errorObjs.push(obj_YN_03_03);
				errorObjs.push(obj_YN_04_03);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"发现数量(低风险)应大于等于已整改数量(高风险)"+"＂\n";
				isValid = false;
			}
		}
	}
	
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length;i++){
		var obj_YN11 = getTableFormObj(label_YN11,objs[i].rownumber);
		var obj_YN11_01 = getTableFormObj(label_YN11_01,obj_YN11.rownumber);
		 if(obj_YN11.value.trim() == "已完成" && obj_YN11_01.value == ""){
			 errorObjs.push(obj_YN11_01);
				a+="信息科技内外部审计情况表"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"：＂"+"结束时间不能为空！"+"＂\n";
				isValid = false;

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
	var emptyObj = getTableFormObjs(label_empty)[0];
	if(emptyObj.value == ""){
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
	}else if(emptyObj.value == "报送空表"){
		isValid = true;
	}
	return isValid;
}

/*
 *功能：数字控件大于0
 */
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("请按规范填写"+errorMessage+"，数值不能小于0\n");
	}
}
/*
 *功能：判断表单内容是否大于100
 */
function checkPercent(obj){
	if(obj.value > 100){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
		alert("请按规范填写"+errorMessage+"，数值不能大于100\n");
	}
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
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
