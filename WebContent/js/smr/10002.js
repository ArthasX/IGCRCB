/*
 * 报表：T-B-3 信息科技内外部审计情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item55 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填报日期";
var label_item48_GTZero = "信息科技内外部审计情况表#已整改数量#高";
var label_item49_GTZero = "信息科技内外部审计情况表#已整改数量#中";
var label_item47_GTZero = "信息科技内外部审计情况表#已整改数量#低";
var label_item44_GTZero = "信息科技内外部审计情况表#审计发现数量#高";
var label_item45_GTZero = "信息科技内外部审计情况表#审计发现数量#中";
var label_item46_GTZero = "信息科技内外部审计情况表#审计发现数量#低";
var label_item30_GTZero = "信息科技内外部审计情况表#整改率";
var label_item5 = "信息科技内外部审计情况表#项目名称";
var label_item6 = "信息科技内外部审计情况表#项目类别";
var label_item7 = "信息科技内外部审计情况表#内容及范围";
var label_item8 = "信息科技内外部审计情况表#实施单位";
var label_DateTimeField1 = "信息科技内外部审计情况表#起止日期#开始日期#开始日期";
var label_DateTimeField2 = "信息科技内外部审计情况表#起止日期#完成日期#完成日期";
var label_item10 = "信息科技内外部审计情况表#是否上报董事会或监事会";
var label_item11 = "信息科技内外部审计情况表#项目状态";
var label_item24 = "信息科技内外部审计情况表#审计报告附件#附件索引";
var label_item25 = "信息科技内外部审计情况表#审计报告附件#审计报告";
var label_item50_GTZero = "本年度信息科技内部审计覆盖一级分支机构情况表格#本年度信息科技内部审计覆盖一级分支机构情况";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_item11 = getTableFormObj(label_item11,
				objs[i].rownumber);
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				objs[i].rownumber + "_1");
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				objs[i].rownumber + "_1");
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				objs[i].rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				objs[i].rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				objs[i].rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				objs[i].rownumber + "_1");
		var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
				objs[i].rownumber);
		obj_item30_GTZero.onclick = "";
		var obj_item24 = getTableFormObj(label_item24,
				objs[i].rownumber + "_1");

		if (obj_item11.value.trim()=="未完成") {
			// 只读
			obj_item44_GTZero.onclick = "";
			obj_item45_GTZero.onclick = "";
			obj_item46_GTZero.onclick = "";
			obj_item48_GTZero.onclick = "";
			obj_item49_GTZero.onclick = "";
			obj_item47_GTZero.onclick = "";
			
			obj_item24 = getEditDiv(obj_item24);
			obj_item24.contentEditable=false;
			var obj_item25 = getSingalFileObj(label_item25,
					objs[i].rownumber+ "_1");
			if (obj_item25 != null)
				obj_item25.disabled=true;
		}
	}
	var noused = 0;
	item30_GTZero(noused);
}

/*
*功能：根据“审计发现数量”和“已整改数量”自动计算整改率
*配置：信息科技内外部审计情况表#审计发现数量#高
*信息科技内外部审计情况表#审计发现数量#中
*信息科技内外部审计情况表#审计发现数量#低
*信息科技内外部审计情况表#已整改数量#高
*信息科技内外部审计情况表#已整改数量#中
*信息科技内外部审计情况表#已整改数量#低
*/
function item30_GTZero(obj) {
	
	var objs = getTableFormObjs(label_item5);
	for(var i = 0 ; i< objs.length; i++){
		var value44 = 0;
		var value45 = 0;
		var value46 = 0;
		var value47 = 0;
		var value48 = 0;
		var value49 = 0;
		if(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value != "") {
			value44 = parseInt(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value != "") {
			value45 = parseInt(getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value != "") {
			value46 = parseInt(getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item47_GTZero, objs[i].rownumber + "_1").value != "") {
			value47 = parseInt(getTableFormObj(label_item47_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item48_GTZero, objs[i].rownumber + "_1").value != "") {
			value48 = parseInt(getTableFormObj(label_item48_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item49_GTZero, objs[i].rownumber + "_1").value != "") {
			value49 = parseInt(getTableFormObj(label_item49_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value + 
				getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value + 
						getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value != ""){
			var temp_value = ( (value47 + value48 + value49) / (value44 + value45 + value46) * 
							100).toFixed(2) * 100 / 100;
			getTableFormObj(label_item30_GTZero, objs[i].rownumber).value = temp_value;
		}else{
			getTableFormObj(label_item30_GTZero, objs[i].rownumber).value = "";
		}
	}
}

/*
* 功能：当项目状态是未完成时清空关联表单。
* 配置：信息科技内外部审计情况表#项目状态
*/
function setItem11Disable(objcld) {
	var obj = getTarget(objcld.parentElement);
	var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
			obj.rownumber + "_1");
	var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
			obj.rownumber + "_1");
	var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
			obj.rownumber + "_1");
	var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
			obj.rownumber + "_1");
	var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
			obj.rownumber + "_1");
	var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
			obj.rownumber + "_1");
	var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
			obj.rownumber);
	var obj_item24 = getTableFormObj(label_item24,
			obj.rownumber + "_1");
	
	
	var hasSaved=false;
	var obj_item25 = getTableFormObj(label_item25,
			obj.rownumber + "_1");
	var temps =  obj_item25.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
        if(temps[i].id.indexOf("IMG")>-1){
        	hasSaved=true;
        	obj_item25 = temps[i];
        	break;
        }
    }
	if (!hasSaved) {
		obj_item25 = getSingalFileObj(label_item25,
				obj.rownumber+ "_1");
	}
	
	
	if (obj.value.trim() == "未完成") {
		// 只读
		obj_item44_GTZero.onclick = "";
		obj_item45_GTZero.onclick = "";
		obj_item46_GTZero.onclick = "";
		obj_item48_GTZero.onclick = "";
		obj_item49_GTZero.onclick = "";
		obj_item47_GTZero.onclick = "";
		obj_item30_GTZero.onclick = "";
		// 清空
		obj_item44_GTZero.value = "";
		obj_item45_GTZero.value = "";
		obj_item46_GTZero.value = "";
		obj_item48_GTZero.value = "";
		obj_item49_GTZero.value = "";
		obj_item47_GTZero.value = "";
		obj_item30_GTZero.value = "";
		obj_item24 = getEditDiv(obj_item24);
		obj_item24.innerHTML = "";
		obj_item24.value="";
		obj_item24.contentEditable=false;
		if (hasSaved){
			if (obj_item25.style.display!="none") {
				obj_item25.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item25);
			obj_item25 = getSingalFileObj(label_item25,
					obj.rownumber+ "_1");
			obj_item25.disabled=true;
		}
	} else if (obj.value.trim() == "完成") {
		// 还原
		obj_item44_GTZero.onclick = click_columnValueNumber;
		obj_item45_GTZero.onclick = click_columnValueNumber;
		obj_item46_GTZero.onclick = click_columnValueNumber;
		obj_item48_GTZero.onclick = click_columnValueNumber;
		obj_item49_GTZero.onclick = click_columnValueNumber;
		obj_item47_GTZero.onclick = click_columnValueNumber;
		obj_item30_GTZero.onclick = click_columnValueNumber;
		obj_item24 = getEditDiv(obj_item24);
		obj_item24.contentEditable=true;
		obj_item25.disabled=false;
	}
}

/*
* 功能：点击提交时进行的表单验证
* 配置：填报状态的“提交”按钮
* 年报审批状态的“提交”按钮
*/
function checkData() {
	var obj = getTableFormObj(label_item50_GTZero,"1");
	checkNumFloat(obj, 2);
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		checkTableItemNull(objs[i]);
		checkSubform10(objs[i]);
		var obj_DateTimeField1 = getTableFormObj(label_DateTimeField1,
				objs[i].rownumber + "_1_1");
		var obj_DateTimeField2 = getTableFormObj(label_DateTimeField2,
				objs[i].rownumber + "_1_1");
		if (obj_DateTimeField1.value.trim() != ""
				&& obj_DateTimeField2.value.trim() != ""
				&& obj_DateTimeField1.value.trim() > obj_DateTimeField2.value
						.trim()) {
			errorObjs.push(obj_DateTimeField1);
			errorObjs.push(obj_DateTimeField2);
			a += "项目" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "：" + "开始时间不能迟于完成时间！\n";
			isValid = false;
		}
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				objs[i].rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item44_GTZero.value.trim() != ""
				&& obj_item48_GTZero.value.trim() != ""
				&& parseInt(obj_item44_GTZero.value.trim()) < parseInt(obj_item48_GTZero.value
						.trim())) {
			errorObjs.push(obj_item44_GTZero);
			errorObjs.push(obj_item48_GTZero);
			a += "项目" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "："
					+ "高：审计问题整改数量≤审计发现问题数量校验不通过！\n";
			isValid = false;
		}
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				objs[i].rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item45_GTZero.value.trim() != ""
				&& obj_item49_GTZero.value.trim() != ""
				&& parseInt(obj_item45_GTZero.value.trim()) < parseInt(obj_item49_GTZero.value
						.trim())) {
			errorObjs.push(obj_item45_GTZero);
			errorObjs.push(obj_item49_GTZero);
			a += "项目" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "："
					+ "中：审计问题整改数量≤审计发现问题数量校验不通过！\n";
			isValid = false;
		}
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				objs[i].rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item46_GTZero.value.trim() != ""
				&& obj_item47_GTZero.value.trim() != ""
				&& parseInt(obj_item46_GTZero.value.trim()) < parseInt(obj_item47_GTZero.value
						.trim())) {
			errorObjs.push(obj_item46_GTZero);
			errorObjs.push(obj_item47_GTZero);
			a += "项目" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "："
					+ "低：审计问题整改数量≤审计发现问题数量校验不通过！\n";
			isValid = false;
		}
		var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
				objs[i].rownumber);
		if (parseInt(obj_item30_GTZero.value.trim()) > 100
				|| parseInt(obj_item30_GTZero.value.trim()) < 0) {
			errorObjs.push(obj_item30_GTZero);
			a += "项目" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "：" + "0<整改率<=100出错！ \n";
			isValid = false;
		}
	}
	checkData1();
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

/*
 *功能：检查输入的数值是否大于等于０ 如果是，返回true；否则，返回false.
 */
function validGTZero(obj) {
	var _result = true;
	var val = obj.value.trim();
	if (val != null && val != "") {
		if (parseInt(val) < 0) {
			_result = false;
		}
	}
	return _result;
}

/*
 * 功能：当"项目状态"为"完成"时,验证审计部分的必填
 */
function checkSubform10(obj) {
	if (getTableFormObj(label_item11, obj.rownumber).value.trim() == "完成") {
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				obj.rownumber + "_1");
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				obj.rownumber + "_1");
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				obj.rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				obj.rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				obj.rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				obj.rownumber + "_1");

		if (obj_item44_GTZero.value.trim() == "") {
			errorObjs.push(obj_item44_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：高不能为空！\n";
			isValid = false;
		}
		if (obj_item45_GTZero.value.trim() == "") {
			errorObjs.push(obj_item45_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：中不能为空！\n";
			isValid = false;
		}
		if (obj_item46_GTZero.value.trim() == "") {
			errorObjs.push(obj_item46_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：低不能为空！\n";
			isValid = false;
		}
		if (obj_item48_GTZero.value.trim() == "") {
			errorObjs.push(obj_item48_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：高不能为空！\n";
			isValid = false;
		}
		if (obj_item49_GTZero.value.trim() == "") {
			errorObjs.push(obj_item49_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：中不能为空！\n";
			isValid = false;
		}
		if (obj_item47_GTZero.value.trim() == "") {
			errorObjs.push(obj_item47_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：低不能为空！\n";
			isValid = false;
		}
		
		var obj_label_item30_GTZero = getTableFormObj(label_item30_GTZero, obj.rownumber);
		if (obj_label_item30_GTZero.value.trim() == "") {
			errorObjs.push(obj_label_item30_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "整改率不能为空！\n";
			isValid = false;
		}
		var obj_label_item24 = getTableFormObj(label_item24, obj.rownumber + "_1");
		if (obj_label_item24.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item24));
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "项目名称不为“无”或空，则“项目状态”为“完成”时，“附件索引”不能为空！\n";
			isValid = false;
		}
		var obj_label_item25=getSingalFileObj(label_item25, obj.rownumber + "_1");
		if (obj_label_item25.value.trim() == "") {
			errorObjs.push(getSingalFileTextObj(label_item25, obj.rownumber + "_1"));
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "项目名称不为“无”或空，则“项目状态”为“完成”时，“审计报告附件”不能为空！\n";
			isValid = false;
		}
		if (validGTZero(obj_item44_GTZero) == false) {
			errorObjs.push(obj_item44_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：高不能输入小于0的数值！\n";
			isValid = false;
		}
		if (validGTZero(obj_item45_GTZero) == false) {
			errorObjs.push(obj_item45_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：中不能输入小于0的数值！\n";
			isValid = false;
		}
		if (validGTZero(obj_item46_GTZero) == false) {
			errorObjs.push(obj_item46_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "审计发现数量：低不能输入小于0的数值！\n";
			isValid = false;
		}
		if (validGTZero(obj_item48_GTZero) == false) {
			errorObjs.push(obj_item48_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：高不能输入小于0的数值！\n";
			isValid = false;
		}
		if (validGTZero(obj_item49_GTZero) == false) {
			errorObjs.push(obj_item49_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：中不能输入小于0的数值！\n";
			isValid = false;
		}
		if (validGTZero(obj_item47_GTZero) == false) {
			errorObjs.push(obj_item47_GTZero);
			a += "项目" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "：" + "已整改数量：低不能输入小于0的数值！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：“本年度信息科技内部审计覆盖一级分支机构情况”内容校验
 */
function checkData1() {
	var obj = getTableFormObj(label_item50_GTZero,"1");
	if (obj.value.trim() =="") {
		errorObjs.push(obj);
		a += "本年度信息科技内部审计覆盖一级分支机构情况不能为空！ \n";
		isValid = false;
	}else {
		if (parseInt(obj.value.trim()) > 100) {
			errorObjs.push(obj);
			a += "本年度信息科技内部审计覆盖一级分支机构情况=<100出错！ \n";
			isValid = false;
		}
		if (parseInt(obj.value) < 0) {
			errorObjs.push(obj);
			a += "0=<本年度信息科技内部审计覆盖一级分支机构情况出错！ \n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull(obj) {
	 var obj_label_item6 = getTableFormObj(label_item6, obj.rownumber);
	 var obj_label_item7 = getTableFormObj(label_item7, obj.rownumber);
	 var obj_label_item8 = getTableFormObj(label_item8, obj.rownumber);
	 var obj_label_DateTimeField1 =getTableFormObj(label_DateTimeField1, obj.rownumber + "_1_1");
	 var obj_label_DateTimeField2 =getTableFormObj(label_DateTimeField2, obj.rownumber + "_1_1");
	 var obj_label_item10 =getTableFormObj(label_item10, obj.rownumber);
	 var obj_label_item11 =getTableFormObj(label_item11, obj.rownumber);

	 if (obj.value.trim() !="" && obj.value.trim() != "无"){
		if (obj_label_item6.value.trim() == "") {
			errorObjs.push(obj_label_item6.parentElement);
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“项目类别”不能为空！\n";
			isValid = false;
		}
		if (obj_label_item7.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item7));
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“内容及范围”不能为空！\n";
			isValid = false;
		}
		if (obj_label_item8.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item8));
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“实施单位”不能为空！\n";
			isValid = false;
		}
		if (obj_label_DateTimeField1.value.trim() == "") {
			errorObjs.push(obj_label_DateTimeField1);
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“开始日期”不能为空！\n";
			isValid = false;
		}
		if (obj_label_DateTimeField2.value.trim() == "") {
			errorObjs.push(obj_label_DateTimeField2);
			a += "项目" +obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+ "：" + "项目名称不为“无”或空，则此项“完成日期”不能为空！\n";
			isValid = false;
		}
		if (obj_label_item10.value.trim() == "") {
			errorObjs.push(obj_label_item10.parentElement);
			a += "项目" +obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“是否上报董事会或监事会”不能为空！\n";
			isValid = false;
		}
		if (obj_label_item11.value.trim() == "") {
			errorObjs.push(obj_label_item11.parentElement);
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：" + "项目名称不为“无”或空，则此项“项目状态”不能为空！\n";
			isValid = false;
		}
	 }else{
		 if(obj_label_item6.value.trim() != "" || obj_label_item7.value.trim() != "" || obj_label_item8.value.trim() != ""||
				 obj_label_DateTimeField1.value.trim() != "" || obj_label_DateTimeField2.value.trim() != "" || 
				 	obj_label_item10.value.trim() != "" || obj_label_item11.value.trim() != ""){
			errorObjs.push(getEditDiv(obj));
			a += "项目"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：项目名称不能为空！\n";
			isValid = false;
		 }
	 }
}

var click_columnValueNumber = function() {
	columnValueNumber(this);
};

