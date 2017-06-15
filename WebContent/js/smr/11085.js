/*
 * 报表：2014-T-B-13 信息科技外包合同情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
var label_YN00 = "报送空表表格#报送空表";
var label_YN00_01 = "标题#填报部门";
var label_YN00_02 = "标题#填报人";
var label_YN00_03 = "标题#联系电话";
var label_YN00_04 = "标题#责任人";
var label_YN00_05 = "标题#填表日期";
// 空表
var label_empty = "报送空表表格#报送空表";
// 合同信息
var label_YN01_02_01 = "合同#合同信息#服务类型#研发咨询类";
var label_YN01_02_02 = "合同#合同信息#服务类型#系统运行维护类";
var label_YN01_02_03 = "合同#合同信息#服务类型#业务外包中的信息科技活动";
var label_YN01_08_01 = "合同#合同信息#执行情况#本年度新增";
var label_YN01_08_02 = "合同#合同信息#执行情况#本年度执行状态";
var label_YN01_08_03 = "合同#合同信息#执行情况#完成时间";
var label_YN01_08_03 = "合同#合同信息#执行情况#完成时间";
var label_YN01_06= "合同#合同信息#起始时间";	
var label_YN01_07= "合同#合同信息#计划完成时间";	
var label_YN02_08 = "合同#合同信息#实施方法";
// 合同信息2
var label_YN02_01 = "合同#合同信息2#工作总量（人月）";
var label_YN02_02 = "合同#合同信息2#金额（万元）";
var label_YN02_03 = "合同#合同信息2#是否发生服务中断或异常退出";
var label_YN02_06 = "合同#合同信息2#关联外包类型";
var label_YN02_07 = "合同#合同信息2#跨境外包情况";
// 统计情况
var label_YN03_01 = "统计情况#研发咨询类重要信息科技外包服务合同数量";
var label_YN03_02 = "统计情况#系统运行维护类重要信息科技外包服务合同数量";
var label_YN03_03 = "统计情况#包含业务外包中的信息科技活动的重要信息科技外包服务合同数量";
var label_YN03_04 = "统计情况#本年度正在执行和在本年已完成的重要信息科技外包合同总数";
var label_YN03_05 = "统计情况#合同总金额";
var label_YN03_06 = "统计情况#工作总量";
var label_YN03_07 = "统计情况#本年度新增的重要信息科技外包服务合同数量";
var label_YN03_08 = "统计情况#本年度正在执行的重要信息科技外包服务合同数量";
var label_YN03_09 = "统计情况#本年度已完成的重要信息科技外包服务合同数量";
var label_YN03_10 = "统计情况#本年度涉及关联外包的重要信息科技外包服务合同数量";
var label_YN03_11 = "统计情况#本年度发生服务中断或异常退出的重要信息科技外包合同总数";

var label_YN03_12 = "统计情况#本年度正在执行和已完成的信息科技跨境外包服务合同数量";
var label_YN03_13 = "统计情况#其中涉及外包服务提供商数量";
var label_YN03_14 = "统计情况#本年度正在执行和已完成的信息科技非驻场外包服务合同数量";
var label_YN03_15 = "统计情况#其中涉及的外包服务提供商数量";
// 初始对象
// 统计情况对象
var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
var obj_YN03_07 = getTableFormObjs(label_YN03_07)[0];
var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
var obj_YN03_09 = getTableFormObjs(label_YN03_09)[0];
var obj_YN03_10 = getTableFormObjs(label_YN03_10)[0];
var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];

var obj_YN03_12 = getTableFormObjs(label_YN03_12)[0];
var obj_YN03_13 = getTableFormObjs(label_YN03_13)[0];
var obj_YN03_14 = getTableFormObjs(label_YN03_14)[0];
var obj_YN03_15 = getTableFormObjs(label_YN03_15)[0];
/*
 * 功能：校验起始时间和计划完成时间的大小
 *
 */
function checkDate_06_07(obj){
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObjs(label_YN01_07)[0];
	if(obj_YN01_06.value != "" && obj_YN01_07.value != ""){
		if(obj_YN01_06.value < obj_YN01_07.value){
			
		}else{
			obj_YN01_07.value = ""
			alert("起始时间应小于计划完成时间！");
		}
	}
	
}
/*
 * 功能：校验其中涉及外包服务提供商数量是否大于本年度正在执行和已完成的信息科技跨境外包服务合同数量
 *
 */
function setObj_YN03_13Value(obj) {
	if (parseInt(obj.value) > parseInt(obj_YN03_12.value)) {
		obj.value = "";
		alert("涉及外包服务提供商数量不能大于本年度和同的总数！");
	}
}
/*
 * 功能：校验其中涉及的外包服务提供商数量是否大于本年度正在执行和已完成的信息科技非驻场外包服务合同数量
 * 
 */
function setObj_YN03_15Value(obj) {
	if (parseInt(obj.value) > parseInt(obj_YN03_14.value)) {
		obj.value = "";
		alert("涉及外包服务提供商数量不能大于本年度和同的总数！");
	}
}

/*
 * 功能：通过跨境外包情况来联动本年度正在执行和已完成的信息科技跨境外包服务合同数量和本年度正在执行和已完成的信息科技非驻场外包服务合同数量
 * 配置：表#合同信息2#跨境外包情况
 */
function setObj_YN03_12_14Value(obj) {
	var obj_YN02_07Array = getTableFormObjs(label_YN02_07);
	obj_YN03_12.value = 0;
	for ( var i = 0; i < obj_YN02_07Array.length -1; i++) {
		if (obj_YN02_07Array[i].value == "跨境外包") {
			obj_YN03_12.value = parseInt(obj_YN03_12.value) + 1;
		}
		
	}
}

/*
 * 功能：通过实施情况来联动本年度正在执行和已完成的信息科技跨境外包服务合同数量和本年度正在执行和已完成的信息科技非驻场外包服务合同数量
 * 配置：表#合同信息#实施情况
 */
function setObj_YN03_14Value(obj) {
	var obj_YN02_08Array = getTableFormObjs(label_YN02_08);
	obj_YN03_14.value = 0;
	for ( var i = 0; i < obj_YN02_08Array.length -1; i++) {
		if (obj_YN02_08Array[i].value == "非驻场外包") {
			obj_YN03_14.value = parseInt(obj_YN03_14.value) + 1;
		}
		
	}
}
/*
 * 功能：通过是否发生服务中断或异常退出来联动本年度发生服务中断或异常退出的重要信息科技外包合同总数 配置：表#合同信息2#是否发生服务中断或异常退出
 */
function setObj_YN03_11Value(obj) {
	var obj_YN02_03Array = getTableFormObjs(label_YN02_03);
	obj_YN03_11.value = 0;
	for ( var i = 0; i < obj_YN02_03Array.length - 1; i++) {
		if (obj_YN02_03Array[i].value == "是") {
			obj_YN03_11.value = parseInt(obj_YN03_11.value) + 1;
		}
	}
}
/*
 * 功能：通过关联外包类型来联动本年度正在执行的重要信息科技外包服务合同数量 配置：表#合同信息2#关联外包类型
 */
function setObj_YN03_10Value(obj) {
	var obj_YN02_06Array = getTableFormObjs(label_YN02_06);
	obj_YN03_10.value = 0;
	for ( var i = 0; i < obj_YN02_06Array.length - 1; i++) {
		if (obj_YN02_06Array[i].value != "非关联外包"
				&& obj_YN02_06Array[i].value != "") {
			obj_YN03_10.value = parseInt(obj_YN03_10.value) + 1;
		}
	}
}

/*
 * 功能：通过本年度新增来联动本年度新增的重要信息科技外包服务合同数量 配置：表#合同信息#执行情况#本年度新增
 */
function setObj_YN03_07Value(obj) {
	var obj_YN01_08_01Array = getTableFormObjs(label_YN01_08_01);
	obj_YN03_07.value = 0;
	for ( var i = 0; i < obj_YN01_08_01Array.length; i++) {
		if (obj_YN01_08_01Array[i].value == "是") {
			obj_YN03_07.value = parseInt(obj_YN03_07.value) + 1;
		}
	}
}

/*
 * 功能：通过金额（万元）来联动合同总金额的值以及自己的值 配置：表#合同信息2#金额（万元）
 */
function setObj_YN02_02Value(obj) {
	obj.value = Math.abs(obj.value);
	obj_YN03_05.value = 0;
	var obj_YN02_02Array = getTableFormObjs(label_YN02_02);
	for ( var i = 0; i < obj_YN02_02Array.length; i++) {
		if (obj_YN02_02Array[i].value != "") {
			obj_YN03_05.value = (parseFloat(obj_YN02_02Array[i].value)*100
					+ parseFloat(obj_YN03_05.value)*100)/100;
		}
	}
}

/*
 * 功能：通过工作总量（人月）来联动工作总量的值以及自己的值 配置：表#合同信息2#工作总量（人月）
 */
function setObj_YN02_01Value(obj) {
	obj.value = Math.abs(obj.value);
	obj_YN03_06.value = 0;
	var obj_YN02_01Array = getTableFormObjs(label_YN02_01);
	for ( var i = 0; i < obj_YN02_01Array.length; i++) {
		if (obj_YN02_01Array[i].value != "") {
			obj_YN03_06.value = (parseFloat(obj_YN02_01Array[i].value)*100
					+ parseFloat(obj_YN03_06.value)*100)/100;
		}
	}
}
/*
 * 功能：通过业务外包中的信息科技活动来联动包含业务外包中的信息科技活动的重要信息科技外包服务合同数量中的值
 * 配置：表#合同信息#服务类型#业务外包中的信息科技活动
 */
function setObj_YN03_03Value(obj) {
	var obj_YN01_02_03Array = getTableFormObjs(label_YN01_02_03);
	obj_YN03_03.value = 0;
	for ( var i = 0; i < obj_YN01_02_03Array.length; i++) {
		if (obj_YN01_02_03Array[i].value != "") {
			obj_YN03_03.value = parseInt(obj_YN03_03.value) + 1;
		}
	}
}

/*
 * 功能：通过系统运行维护类来联动系统运行维护类重要信息科技外包服务合同数量中的值 配置：表#合同信息#服务类型#系统运行维护类
 */
function setObj_YN03_02Value(obj) {
	var obj_YN01_02_02Array = getTableFormObjs(label_YN01_02_02);
	obj_YN03_02.value = 0;
	for ( var i = 0; i < obj_YN01_02_02Array.length; i++) {
		if (obj_YN01_02_02Array[i].value != "") {
			obj_YN03_02.value = parseInt(obj_YN03_02.value) + 1;
		}
	}
}

/*
 * 功能：通过研发咨询类来联动研发咨询类重要信息科技外包服务合同数量中的值 配置：表#合同信息#服务类型#研发咨询类
 */
function setObj_YN03_01Value(obj) {
	var obj_YN01_02_01Array = getTableFormObjs(label_YN01_02_01);
	obj_YN03_01.value = 0;
	for ( var i = 0; i < obj_YN01_02_01Array.length; i++) {
		if (obj_YN01_02_01Array[i].value != "") {
			obj_YN03_01.value = parseInt(obj_YN03_01.value) + 1;
		}
	}
}

/*
 * 功能：本年度执行状态来决定完成时间是否有点击事件以及合同总数的值 配置：表#合同信息#执行情况#本年度执行状态
 */
function setObj_YN01_08_03Disable(obj) {
	var obj_YN01_08_02Array = getTableFormObjs(label_YN01_08_02);
	obj_YN03_04.value = 0;
	obj_YN03_08.value = 0;
	obj_YN03_09.value = 0;
	for ( var i = 0; i < obj_YN01_08_02Array.length; i++) {
		var obj_YN01_08_03 = getTableFormObj(label_YN01_08_03,
				obj_YN01_08_02Array[i].rownumber);
		if (obj_YN01_08_02Array[i].value == "完成") {
			obj_YN01_08_03.onclick = click_columnshowDate;
		} else {
			obj_YN01_08_03.value = "";
			obj_YN01_08_03.onclick = "";
		}
		setYN_04_08_09Value(obj_YN01_08_02Array, i);
	}

}
/*
 * 功能：本年度执行状态来决定合同总数的值 配置：表#合同信息#执行情况#本年度执行状态
 */
function setYN_04_08_09Value(objArray, index) {

	if (objArray[index].value != "") {
		obj_YN03_04.value = parseInt(obj_YN03_04.value) + 1;
		if (objArray[index].value == "执行中") {
			obj_YN03_08.value = parseInt(obj_YN03_08.value) + 1;
		}
		if (objArray[index].value == "完成") {
			obj_YN03_09.value = parseInt(obj_YN03_09.value) + 1;
		}

	}
}
/*
 * 初始化
 */
function initSet() {
	var obj = 0;
	setObj_YN01_08_03Disable(obj);
	// 统计情况只读
	obj_YN03_01.readOnly = "readonly";
	obj_YN03_02.readOnly = "readonly";
	obj_YN03_03.readOnly = "readonly";
	obj_YN03_04.readOnly = "readonly";
	obj_YN03_05.readOnly = "readonly";
	obj_YN03_06.readOnly = "readonly";
	obj_YN03_07.readOnly = "readonly";
	obj_YN03_08.readOnly = "readonly";
	obj_YN03_09.readOnly = "readonly";
	obj_YN03_10.readOnly = "readonly";
	obj_YN03_11.readOnly = "readonly";
	obj_YN03_12.readOnly = "readonly";
	obj_YN03_14.readOnly = "readonly";
	// 统计情况初始化
	if(obj_YN03_01.value == ""){
		obj_YN03_01.value = 0;
	}
	if(obj_YN03_02.value == ""){
		obj_YN03_02.value = 0;
	}
	if(obj_YN03_03.value == ""){
		obj_YN03_03.value = 0;
	}
	if(obj_YN03_04.value == ""){
		obj_YN03_04.value = 0;
	}
	if(obj_YN03_07.value == ""){
		obj_YN03_07.value = 0;
	}
	if(obj_YN03_08.value == ""){
		obj_YN03_08.value = 0;
	}
	if(obj_YN03_09.value == ""){
		obj_YN03_09.value = 0;
	}
	if(obj_YN03_10.value == ""){
		obj_YN03_10.value = 0;
	}
	if(obj_YN03_11.value == ""){
		obj_YN03_11.value = 0;
	}
	if(obj_YN03_12.value == ""){
		obj_YN03_12.value = 0;
	}
	if(obj_YN03_14.value == ""){
		obj_YN03_14.value = 0;
	}

}

/*
 * 功能：提交校验
 */
function checkData() {
	a = "";
	isValid = true;
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	var obj_YN03_12 = getTableFormObj(label_YN03_12,1);
	var obj_YN03_13 = getTableFormObj(label_YN03_13,1);
	var obj_YN03_14 = getTableFormObj(label_YN03_14,1);
	var obj_YN03_15 = getTableFormObj(label_YN03_15,1);
	var emptyObj = getTableFormObjs(label_empty)[0];
	if (emptyObj.value == "") {
		if(parseInt(obj_YN03_12.value)<parseInt(obj_YN03_13.value)){
			errorObjs.push(obj_YN03_13);
			a += "本年度正在执行和已完成的信息科技跨境外包服务合同数量应大于其中涉及外包服务提供商数量\n";
			isValid = false;
		}
		if(parseInt(obj_YN03_14.value)<parseInt(obj_YN03_15.value)){
			errorObjs.push(obj_YN03_15);
			a += "本年度正在执行和已完成的信息科技非驻场外包服务合同数量应大于其中涉及的外包服务提供商数量\n";
			isValid = false;
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
	} else if (emptyObj.value == "报送空表") {
		var obj_YN00_01 = getTableFormObj(label_YN00_01,"1");
		var obj_YN00_02 = getTableFormObj(label_YN00_02,"1");
		var obj_YN00_03 = getTableFormObj(label_YN00_03,"1");
		var obj_YN00_04 = getTableFormObj(label_YN00_04,"1");
		var obj_YN00_05 = getTableFormObj(label_YN00_05,"1");
		if(obj_YN00_01.value == ""){
			a += "填报部门内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_02.value == ""){
			a += "填报人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_03.value == ""){
			a += "联系电话内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_04.value == ""){
			a += "责任人内容不能为空！\n";
			isValid = false;
		}
		if(obj_YN00_05.value == ""){
			a += "填表日期内容不能为空！\n";
			isValid = false;
		}
		if(!isValid){
			alert(a);
		}
	}
	
	return isValid;
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
/**
 * 组模式表格式表单删除行
 * 
 * @param obj
 *            事件源对象
 */
function deleteGroup(obj) {
	// 目标table对象
	var tb = obj.parentElement.parentElement;
	// 需要新增行标识：如果当前行为唯一数据行，则需要新增一行，然后再删除此行
	var index = 0;
	for ( var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].name != "titlerow" && tb.rows[i].name != "titletr") {
			index++;
		}
	}
	if (index == 2) {
		alert("\u6700\u540e\u4e00\u7ec4\u4e0d\u53ef\u5220\u9664\uff01");
		return;
	}
	// 行号
	var rowIndex = obj.rowIndex;
	tb.deleteRow(rowIndex);
	shortGroup(tb);
	var onDel = tb.onDel;
	if (onDel) {
		onDel();
	}
	// 重新给一些值赋值
	var obj_YN01_08_02Array = getTableFormObjs(label_YN01_08_02);
	obj_YN03_04.value = 0;
	obj_YN03_08.value = 0;
	obj_YN03_09.value = 0;
	for ( var i = 0; i < obj_YN01_08_02Array.length; i++) {
		setYN_04_08_09Value(obj_YN01_08_02Array, i);
	}
	setObj_YN03_07Value(0);
	setObj_YN03_01Value(0);
	setObj_YN03_02Value(0);
	setObj_YN03_03Value(0);
	setObj_YN02_01Value(0);
	setObj_YN02_02Value(0);
	setObj_YN03_10Value(0);
	setObj_YN03_11Value(0);
	setObj_YN03_12_14Value(0);
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
jQuery("span").css("float","");