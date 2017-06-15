/*
 * 报表：2014 -T-B-9 信息系统软硬件产品使用情况表——报表填报
 */
//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
// 软件产品使用情况,软件正版化情况
var label_YN01_01_01 = "软件产品使用情况软件正版化情况#内容#软件正版化工作#软件正版化工作负责部门";
var label_YN01_01_02 = "软件产品使用情况软件正版化情况#内容#软件正版化工作#部门名称";

var label_YN01_02_01 = "软件产品使用情况软件正版化情况#内容#软件正版化工作负责人#软件正版化工作负责人";
var label_YN01_02_02 = "软件产品使用情况软件正版化情况#内容#软件正版化工作负责人#姓名";
var label_YN01_02_03 = "软件产品使用情况软件正版化情况#内容#软件正版化工作负责人#职务";

var label_YN01_03_01 = "软件产品使用情况软件正版化情况#内容#建立软件正版化有关规章制度#建立软件正版化有关规章制度";
var label_YN01_03_02 = "软件产品使用情况软件正版化情况#内容#建立软件正版化有关规章制度#制度名称";
var label_YN01_03_03 = "软件产品使用情况软件正版化情况#内容#建立软件正版化有关规章制度#发布时间";
var label_YN01_03_04 = "软件产品使用情况软件正版化情况#内容#建立软件正版化有关规章制度#最近一次修订时间";
//信息系统软硬件服务支持情况对象
var label_YN04_01 = "信息系统软硬件服务支持情况#内容#存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统";
var label_YN04_02 = "信息系统软硬件服务支持情况#内容#如是，总数";
var label_YN04_03 = "信息系统软硬件服务支持情况#内容#具体系统名称";
var label_YN04_04 = "信息系统软硬件服务支持情况#内容#其中已停止支持的硬件平台数量";
var label_YN04_05 = "信息系统软硬件服务支持情况#内容#已停止支持的软件平台数量";

// 软件产品使用情况,软件正版化情况对象
var obj_YN01_01_01 = getTableFormObjs(label_YN01_01_01)[0];
var obj_YN01_01_02 = getTableFormObj(label_YN01_01_02, obj_YN01_01_01.rownumber);

var obj_YN01_02_01 = getTableFormObjs(label_YN01_02_01)[0];
var obj_YN01_02_02 = getTableFormObj(label_YN01_02_02, obj_YN01_02_01.rownumber);
var obj_YN01_02_03 = getTableFormObj(label_YN01_02_03, obj_YN01_02_01.rownumber);

var obj_YN01_03_01 = getTableFormObjs(label_YN01_03_01)[0];
var obj_YN01_03_02 = getTableFormObj(label_YN01_03_02, obj_YN01_03_01.rownumber);
var obj_YN01_03_03 = getTableFormObj(label_YN01_03_03, obj_YN01_03_01.rownumber);
var obj_YN01_03_04 = getTableFormObj(label_YN01_03_04, obj_YN01_03_01.rownumber);

//信息系统软硬件服务支持情况对象
var ojb_YN04_01 = getTableFormObjs(label_YN04_01)[0];
var ojb_YN04_02 = getTableFormObj(label_YN04_02, ojb_YN04_01.rownumber);
var ojb_YN04_03 = getTableFormObj(label_YN04_03, ojb_YN04_01.rownumber);
var ojb_YN04_04 = getTableFormObj(label_YN04_04, ojb_YN04_01.rownumber);
var ojb_YN04_05 = getTableFormObj(label_YN04_05, ojb_YN04_01.rownumber);

/*
 * 功能：存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统中的值来确定其他项是否能填
 * 配置：第四部分#内容#存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统
 */
function setObj_YN04_02_03_04_05Disable(obj){
	if(ojb_YN04_01){
		if(ojb_YN04_01.value == "是"){
			ojb_YN04_02.readOnly = "";
			ojb_YN04_03.readOnly = "";
			ojb_YN04_04.readOnly = "";
			ojb_YN04_05.readOnly = "";
		}else{
			ojb_YN04_02.readOnly = "readonly";
			ojb_YN04_03.readOnly = "readonly";
			ojb_YN04_04.readOnly = "readonly";
			ojb_YN04_05.readOnly = "readonly";
			
			ojb_YN04_02.value = "";
			ojb_YN04_03.value = "";
			ojb_YN04_04.value = "";
			ojb_YN04_05.value = "";
		}
	}
	
}





/*
 * 功能：校验两个文本框之间的值
 */
function checkInputsNumber(obj){
	var inputId1 = obj.id.substring(0,obj.id.indexOf("_"));
	if(inputId1%2 == 0){
		var input2 = document.getElementById((parseInt(inputId1)-1)+"_"+obj.rownumber);
		if(input2.value!=""&&obj.value!=""){
			if(parseInt(input2.value)<parseInt(obj.value)){
				obj.value ="";
				alert("其中使用时间超过5年的数量不能大于总数");
			}
		}
		
	}else{
		var input2 = document.getElementById((parseInt(inputId1)+1)+"_"+obj.rownumber);
		if(input2.value!=""&&obj.value!=""){
			if(parseInt(input2.value)>parseInt(obj.value)){
				input2.value ="";
				alert("其中使用时间超过5年的数量不能大于总数");
			}
		}
	}
}

/*
 * 功能：第二部分单选框决定文本是否填值
 */
function setNumberInputDisable(obj) {
	if(obj){
		if (obj.flag == "不限制许可数量") {
			var getObj = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling;
			if (!getObj.id) {
				getObj = obj.parentElement.nextSibling.nextSibling;
			}
			var objId = getObj.id;
			var objLastId = getObj.rownumber;
			var nextInputId = (parseInt(objId.substring(0, objId.indexOf("_"))) + 1)
					+ "_" + objLastId;
			var nextInputObj = document.getElementById(nextInputId);
			nextInputObj.readOnly = "readonly";
			nextInputObj.value = "";
		} else if(obj!="0"){
			var getObj = obj.parentElement.nextSibling.nextSibling;
			if (!getObj.id) {
				getObj = obj.parentElement.nextSibling;
			}
			var objId = getObj.id;
			var objLastId = getObj.rownumber;
			var nextInputId = (parseInt(objId.substring(0, objId.indexOf("_"))) + 1)
					+ "_" + objLastId;
			var nextInputObj = document.getElementById(nextInputId);
			nextInputObj.readOnly = "";
		}
	}
	

}

/*
 * 功能：校验是否为负数，为负数将其变为整数
 */
function checkDataAbs(obj) {
	if (parseFloat(obj.value) < 0) {
		obj.value = "";
		alert("不能输入小于0的数字，请重新输入！");
	}
}

/*
 * 功能：通过软件正版化工作负责人控制姓名职务的只读和可写 配置：软件正版化情况#内容#软件正版化工作负责人#软件正版化工作负责人
 */
function setObj_YN01_03_02_03_04Disable(obj) {
	if(obj_YN01_03_01){
		if (obj_YN01_03_01.value == "是") {
			obj_YN01_03_02.readOnly = "";
			obj_YN01_03_03.onclick = click_columnshowDate;
			obj_YN01_03_04.onclick = click_columnshowDate;
		} else {
			obj_YN01_03_02.readOnly = "readonly";
			obj_YN01_03_03.onclick = "";
			obj_YN01_03_04.onclick = "";
			obj_YN01_03_02.value = "";
			obj_YN01_03_03.value = "";
			obj_YN01_03_04.value = "";
		}
	}
	
}

/*
 * 功能：通过软件正版化工作负责人控制姓名职务的只读和可写 配置：软件正版化情况#内容#软件正版化工作负责人#软件正版化工作负责人
 */
function setObj_YN01_02_02_03Disable(obj) {
	if(obj_YN01_02_01){
		if (obj_YN01_02_01.value == "有") {
			obj_YN01_02_02.readOnly = "";
			obj_YN01_02_03.readOnly = "";
		} else {
			obj_YN01_02_02.readOnly = "readonly";
			obj_YN01_02_03.readOnly = "readonly";

			obj_YN01_02_02.value = "";
			obj_YN01_02_03.value = "";
		}
	}
	
}

/*
 * 功能：通过软件正版化工作负责部门控制部门名称的只读和可写 配置：软件正版化情况#内容#软件正版化工作#软件正版化工作负责部门
 */
function setObj_YN01_01_02Disable(obj) {
	if(obj_YN01_01_01){
		if (obj_YN01_01_01.value == "有") {
			obj_YN01_01_02.readOnly = "";
		} else {
			obj_YN01_01_02.readOnly = "readonly";
			obj_YN01_01_02.value = "";
		}
	}
	
}

/*
 * 初始化
 */
function initSet() {
	var obj = 0;
	setObj_YN04_02_03_04_05Disable(obj);
	setNumberInputDisable(obj);
	setObj_YN01_03_02_03_04Disable(obj);
	setObj_YN01_02_02_03Disable(obj);
	setObj_YN01_01_02Disable(obj);

}
/*
 * 功能：恢复日期输入
 */
var click_columnshowDate = function() {
	showDate(this);
};
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
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	if(obj_YN01_01_01.value =="有" && obj_YN01_01_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_01_02);
		a += "软件正版化情况：软件正版化工作负责 部门名称不能为空！\n";
	}
	
	if(obj_YN01_02_01.value =="有" && obj_YN01_02_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_02_02);
		a += "软件正版化情况：软件正版化工作负责人 姓名不能为空！\n";
	}
	if(obj_YN01_02_01.value =="有" && obj_YN01_02_03.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_02_03);
		a += "软件正版化情况：软件正版化工作负责人 职务不能为空！\n";
	}
	
	if(obj_YN01_03_01.value =="是" && obj_YN01_03_02.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_02);
		a += "软件正版化情况：建立软件正版化有关规章制度 制度名称不能为空！\n";
	}
	if(obj_YN01_03_01.value =="是" && obj_YN01_03_03.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_03);
		a += "软件正版化情况：建立软件正版化有关规章制度 发布时间不能为空！\n";
	}
	if(obj_YN01_03_01.value =="是" && obj_YN01_03_04.value == ""){
		isValid = false;
		errorObjs.push(obj_YN01_03_04);
		a += "软件正版化情况：实施软件资产管理不能为空！\n";
	}
	
	if(ojb_YN04_01.value =="是" && ojb_YN04_02.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_02);
		a += "信息系统软硬件服务支持情况：存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统 总数不能为空！\n";
	}
	if(ojb_YN04_01.value =="是" && ojb_YN04_03.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_03);
		a += "信息系统软硬件服务支持情况：存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统 具体系统名称不能为空！\n";
	}
	if(ojb_YN04_01.value =="是" && ojb_YN04_04.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_04);
		a += "信息系统软硬件服务支持情况：存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统 已停止支持的硬件平台数量不能为空！\n";
	}
	if(ojb_YN04_01.value =="是" && ojb_YN04_05.value == ""){
		isValid = false;
		errorObjs.push(ojb_YN04_05);
		a += "信息系统软硬件服务支持情况：存在仍在使用供应商已停止支持的软件或硬件平台的重要信息系统 已停止支持的软件平台数量不能为空！\n";
	}
	
	//取元素的值为有限制许可数量
	var inputArr = jQuery("input[name='column_value']");
	var inputArr1 = [];
	for(var i = 0;i<inputArr.length;i++){
	   if(inputArr[i].value == "有限制许可数量"){
		inputArr1.push(inputArr[i]);
		}
	}
	for(var i = 0;i<inputArr1.length;i++){
		var permitObj = inputArr1[i];
		var permitNumberObjId =  (parseInt(permitObj.id.substring(0,permitObj.id.indexOf("_")))+1)+"_"+permitObj.rownumber;
		var permitNumberObj = document.getElementById(permitNumberObjId);
		if(permitNumberObj.value == ""){
//			var softNameObjId = (parseInt(permitNumberObj.id.substring(0,permitNumberObj.id.indexOf("_")))+2)+"_"+permitNumberObj.rownumber;
//			var softName = document.getElementById(softNameObjId).value;
			isValid = false;
			errorObjs.push(permitNumberObj);
			a +=  " 许可数量 有限制许可数量不能为空！\n";
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
/**
 * 
 * 二维表模式添加行
 * 
 * @param obj
 *            事件源对象
 * @param insertRowNum
 *            添加行的位置
 */
//最多不能多余三行
function addRow(obj, insertRowNum) {
	// 需要添加行的table对象
	var targetTab = obj.parentElement.parentElement;
	// 模板对象
	var templateTab = document.getElementById(targetTab.id + "_template");
	// 是否显示行号 Y 显示； N 不显示
	var showrownum = targetTab.showrownum;
	var rows = 0;
	if (targetTab.rows[0].name == "titletr") {
		rows = targetTab.rows.length - 3;
	} else {
		rows = targetTab.rows.length - 2;
	}
	if(rows<1){
		//需要添加行的table对象
		var targetTab = obj.parentElement.parentElement;
		//模板对象
		var templateTab = document.getElementById(targetTab.id + "_template");
		//是否显示行号 Y 显示； N 不显示
		var showrownum = targetTab.showrownum;
		//遍历模板对象，将其内容添加到当前table对象中
		var tr = null;
		for(var i=0;i<templateTab.rows.length;i++){
			//需要添加的行对象
			//判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
			if(insertRowNum != null){
				tr = targetTab.insertRow(insertRowNum);
			}else{
				tr = targetTab.insertRow(targetTab.rows.length);
			}
			//设定新行的右键菜单
			tr.className = "rightMenu";
			tr.oncontextmenu = function(){return false;};
			jQuery(tr).unbind("mousedown").mousedown(function(event){
				event.stopPropagation();
				rightMenu(this,event);
			});
			//如果显示行号，预留行号显示位置
			if("Y" == showrownum){
				var indexCell2 = tr.insertCell(0);
				indexCell2.align = "center";
			}
			//遍历模板列，将其添加到当前对象中
			for(var j=0;j<templateTab.rows[i].cells.length;j++){
				var td = tr.insertCell();
				if( templateTab.rows[i].cells[j].style.textAlign){
					td.style.textAlign =  templateTab.rows[i].cells[j].style.textAlign;
				}
				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
			}
			//添加行后，行号有可能被打乱，需要重新排列行号
			shortRowNum(targetTab);
			var onAdd = targetTab.onAdd;
			if(onAdd){
				onAdd(tr);
			}
		}
		
		return tr;
//		// 遍历模板对象，将其内容添加到当前table对象中
//		for ( var i = 0; i < templateTab.rows.length; i++) {
//			// 需要添加的行对象
//			var tr = null;
//			// 判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
//			if (insertRowNum != null) {
//				tr = targetTab.insertRow(insertRowNum);
//			} else {
//				tr = targetTab.insertRow(targetTab.rows.length - 1);
//			}
//			var delTd = tr.insertCell(0);
//			delTd.align = "center";
//			delTd.innerHTML = '<img src="images/bullet_delete.png" onclick="deleteRow(this);" style="cursor: hand" border="0" />';
//			var idxFlag = 1;
//			// 如果显示行号，预留行号显示位置
//			if ("Y" == showrownum) {
//				idxFlag = 2;
//				var indexCell2 = tr.insertCell(1);
//				indexCell2.align = "center";
//				if (targetTab.rows[0].name == "titlerow") {
//					indexCell2.innerHTML = targetTab.rows.length - 3;
//				} else {
//					indexCell2.innerHTML = targetTab.rows.length - 2;
//				}
//			}
//			// 遍历模板列，将其添加到当前对象中
//			for ( var j = 0; j < templateTab.rows[i].cells.length; j++) {
//				var td = tr.insertCell(j + idxFlag);
//				if (templateTab.rows[i].cells[j].style.textAlign) {
//					td.style.textAlign = templateTab.rows[i].cells[j].style.textAlign;
//				}
//				if (templateTab.rows[i].cells[j].style.display) {
//					td.style.display = templateTab.rows[i].cells[j].style.display;
//				}
//				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
//			}
//			// 添加行后，行号有可能被打乱，需要重新排列行号
//			shortRowNum(targetTab);
//			var onAdd = targetTab.onAdd;
//			if (onAdd) {
//				onAdd(tr);
//			}
//			return tr;
//		}
	}else{
		alert("最多只能添加到三行！");
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
	var tdArr = jQuery("table[id$='tableForm']"); 
	for(var i = 0;i<tdArr.length;i++){
		jQuery(tdArr[i]).css("padding-right","");
		jQuery(tdArr[i]).css("width","100%");
	}
});