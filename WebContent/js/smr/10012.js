/**T-B-13 软件正版化情况表——报表填报*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item55 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填报日期";

var label_R_Item6="软件正版化工作负责人#姓名";
var label_R_Item7="软件正版化工作负责人#职务";
var label_R_Item8 = "软件正版化工作负责人#办公电话： 区号";
var label_R_Item9 = "软件正版化工作负责人#电话号码";


var label_R_Item17 = "本年度软件正版化培训情况#内容#时间";


var R_Item = "商用软件使用情况统计#商用软件使用情况统计#软件类别";
var R_Item1_GTZero = "商用软件使用情况统计#商用软件使用情况统计#详细#国外产品#许可数量";
var R_Item2_GTZero = "商用软件使用情况统计#商用软件使用情况统计#详细#国内产品#许可数量";

var R_Item5 = "商用软件使用情况统计#应用系统软件#软件类别";
var R_Item3_GTZero = "商用软件使用情况统计#应用系统软件#国外产品#许可数量";
var R_Item3_YN = "商用软件使用情况统计#应用系统软件#国外产品#限制许可";
var R_Item4_GTZero = "商用软件使用情况统计#应用系统软件#国内产品#许可数量";
var R_Item4_YN = "商用软件使用情况统计#应用系统软件#国内产品#限制许可";


var DecimalField5_GTZero= "软件种类与装机数量#正版软件总数";
var DecimalField5_GTZero1= "软件种类与装机数量#正版商用软件总数";
var DecimalField5_GTZero2= "软件种类与装机数量#本行自主知识产权软件总数";

var item10000_GTZero="本年度软件正版化培训情况#本年度培训次数：";
var item10001_GTZero="本年度软件正版化培训情况#培训总人次：";

var label_R_Item5="软件正版化工作负责部门#内容#部门名称";
var label_R_Item16="软件正版化工作负责人#负责人";
var label_R_Item19="软件正版化工作负责部门#内容#负责部门";

var label_R_Item20 = "本年度软件正版化投入情况#新增软件采购投入";
var label_R_Item21 = "本年度软件正版化投入情况#软件许可维护投入";

var R_Item1_YN = "商用软件使用情况统计#商用软件使用情况统计#详细#国外产品#限制许可";
var R_Item2_YN = "商用软件使用情况统计#商用软件使用情况统计#详细#国内产品#限制许可";


function initSet(){
	r_items=getTableFormObjs(R_Item);
	for(var i=0;i<r_items.length;i++){
		r_Item1_GTZero(r_items[i]); 
		r_Item2_GTZero(r_items[i]); 
	}
	r_item5s=getTableFormObjs(R_Item5);
	for(var i=0;i<r_item5s.length;i++){
		r_Item3_GTZero(r_item5s[i]); 
		r_Item4_GTZero(r_item5s[i]); 
	}
	eG_YN_Item1(getTableFormObj(label_R_Item5,"1_1"));
	eG_YN_Item2(getTableFormObj(label_R_Item6,"1_1"));
}
/**
 * 验证当非空表格时,表头信息不能为空
 */
function checkHeader() {
	// 报送非空表，表头必填
	if (getFormObj(label_header_item1).value.trim() == ""
			|| getFormObj(label_header_item2).value.trim() == ""
			|| getFormObj(label_header_TextField11).value.trim() == ""
			|| getFormObj(label_header_item3).value.trim() == ""
			|| getFormObj(label_header_item4).value.trim() == "") {
		a += "填报部门、填报人、联系电话、责任人、填报日期不能为空！\n";
		isValid = false;
	}
}
/*
*功能：校验电话区号
*配置：软件正版化工作负责人#内容#办公电话： 区号
*/
function R_Item8(obj) {
	var reg1=/^(0[0-9]{2,3})?$/;
	//var reg2=/^((\+86)|(86))?(13)\d{9}$/;
	if(obj.value.trim()!="")
	{
		var Valid=reg1.exec(obj.value.trim());
		if(!Valid){
			alert("请输入正确的区号（3-4位区号(必须以0开头)！\n");
			obj.value = "";
			return false;
			}
	}
	if(obj.value == "-"){
		alert("不可以输入负数");
		obj.value = "";
	}else if(obj.value.indexOf(".") > 0){
		alert("不可以输入小数");
		obj.value = obj.value.substring(0,obj.value.indexOf("."));
	}
//	else if(obj.value.indexOf("0") == 0 && obj.value.length >= 2){
//		obj.value = obj.value.substring(1,obj.value.length);
//	}
}

/*
*功能：时间
*配置：本年度软件正版化培训情况 #内容#时间 
*/

function R_Item17(obj) {
	var reg1=/^((((1[6-9]|[2-9]\d)\d{2})年(0[13578]|1[02])月(0[1-9]|[12]\d|3[01])日)|(((1[6-9]|[2-9]\d)\d{2})年(0[13456789]|1[012])月(0[1-9]|[12]\d|30)日)|(((1[6-9]|[2-9]\d)\d{2})年02月(0[1-9]|1\d|2[0-8])日)|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))年02月29日))$/;
	var reg2=/^((((1[6-9]|[2-9]\d)\d{2})-(0[13578]|1[02])-(0[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0[13456789]|1[012])-(0[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-02-(0[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-02-29))$/;
	if(obj.value.trim()!=null)
	{
		var Valid=reg2.exec(obj.value.trim())||reg1.exec(obj.value.trim());
		if(!Valid){
			alert("请按规范填写日期,如2010-12-20！\n");
			obj.value=null;
			}
	}
}

/*
*功能：校验电话区号
*配置：软件正版化工作负责人#内容#电话号码 
*/
function R_Item9(obj) {
	var reg1=/^([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/;
	//var reg2=/^((\+86)|(86))?(13)\d{9}$/;
	if(obj.value.trim()!="")
	{
		var Valid=reg1.exec(obj.value.trim());
		if(!Valid){
			alert("请输入正确的电话（7-8位直播号（不能以1开头），1-4位分机号，区号、直拨号、分机号之间用‘-’分割）！\n");
			obj.value = "";
			return false;	
		}
	}
	if(obj.value == "-"){
		alert("不可以输入负数");
		obj.value = "";
	}else if(obj.value.indexOf(".") > 0){
		alert("不可以输入小数");
		obj.value = obj.value.substring(0,obj.value.indexOf("."));
	}else if(obj.value.indexOf("0") == 0 && obj.value.length >= 2){
		obj.value = obj.value.substring(1,obj.value.length);
	}
}

/*
*功能：国外产品限制许可
*配置：商用软件使用情况统计#商用软件使用情况统计#详细#国外产品#限制许可
*/
function r_Item1_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs("商用软件使用情况统计#商用软件使用情况统计#详细#国外产品#限制许可");
	for(var i = 0; i < objs.length;i++){
		var obj_R_Item1_GTZero = getTableFormObj(R_Item1_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "不限制许可数量") {
			// 只读
			obj_R_Item1_GTZero.onclick = "";
			// 清空
			obj_R_Item1_GTZero.value = "";
		} else if (objs[i].value.trim() == "限制许可数量") {
			// 还原
			obj_R_Item1_GTZero.onclick = click_columnValueNumber;
		}
	}
}
/*
*功能：国内产品限制许可
*配置：商用软件使用情况统计#商用软件使用情况统计#详细#国内产品#限制许可
*/
function r_Item2_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs("商用软件使用情况统计#商用软件使用情况统计#详细#国内产品#限制许可");
	for(var i = 0; i < objs.length;i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item2_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "不限制许可数量") {
			// 只读
			obj_R_Item2_GTZero.onclick = "";
			// 清空
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "限制许可数量") {
			// 还原
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*功能：国内产品限制许可
*配置：商用软件使用情况统计#应用系统软件#详细#国外产品#许可数量 
*/
function r_Item3_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs(R_Item3_YN);
	for(var i = 0; i < objs.length; i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item3_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "不限制许可数量") {
			// 只读
			obj_R_Item2_GTZero.onclick = "";
			// 清空
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "限制许可数量") {
			// 还原
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*功能：国内产品限制许可
*配置：商用软件使用情况统计#应用系统软件#详细#国内产品#许可数量 
*/
function r_Item4_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs(R_Item4_YN);
	for(var i = 0; i < objs.length; i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item4_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "不限制许可数量") {
			// 只读
			obj_R_Item2_GTZero.onclick = "";
			// 清空
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "限制许可数量") {
			// 还原
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*功能：软件正版化工作负责部门有无
*配置："软件正版化工作负责部门#内容#部门名称
*/
function eG_YN_Item1(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var obj = getTableFormObjs("软件正版化工作负责部门#内容#负责部门")[0];
	var R_Item5 = getTableFormObj(label_R_Item5, obj.rownumber);
	if (obj.value.trim() == "无") {
		// 只读
		R_Item5.onclick = "";
		// 清空
		R_Item5.value = "";
		R_Item5.readOnly = "readonly";
	} else if (obj.value.trim() == "有") {
		// 还原
		R_Item5.onclick = "";
		R_Item5.readOnly = "";

	}
}

/*
*功能：软件正版化工作负责人有无
*配置：软件正版化工作负责人#内容#负责人 
*/
function eG_YN_Item2(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var obj = getTableFormObjs("软件正版化工作负责人#负责人")[0];
	var R_Item6 = getTableFormObj(label_R_Item6, obj.rownumber);
	var R_Item7 = getTableFormObj(label_R_Item7, obj.rownumber);
	var R_Item8 = getTableFormObj(label_R_Item8, obj.rownumber);
	var R_Item9 = getTableFormObj(label_R_Item9, obj.rownumber);
	if (obj.value.trim() == "无") {
		// 清空
		R_Item6.value = "";
		R_Item7.value = "";
		R_Item8.value = "";
		R_Item9.value = "";
		// 只读
		R_Item6.readOnly="readonly";
		R_Item7.readOnly="readonly";
		R_Item8.readOnly="readonly";
		R_Item9.readOnly="readonly";
		
		R_Item6.onclick = "";
		R_Item7.onclick = "";
		R_Item8.onclick = "";
		R_Item9.onclick = "";
		
	} else if (obj.value.trim() == "有") {
		// 还原
		R_Item6.onclick = "";
		R_Item7.onclick = "";
		R_Item8.onclick = "";
		R_Item9.onclick = "";
		R_Item6.readOnly="";
		R_Item7.readOnly="";
		R_Item8.readOnly="";
		R_Item9.readOnly="";
	}
}


function checkData() {
//	alert(getTableFormObjs(R_Item1_GTZero).length)
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	if(parseInt(getTableFormObj(DecimalField5_GTZero,"1").value.trim())!=(parseInt(getTableFormObj(DecimalField5_GTZero1,"1").value.trim())+parseInt(getTableFormObj(DecimalField5_GTZero2,"1").value.trim())))
	{
		errorObjs.push(getTableFormObj(DecimalField5_GTZero,"1"));
		errorObjs.push(getTableFormObj(DecimalField5_GTZero1,"1"));
		errorObjs.push(getTableFormObj(DecimalField5_GTZero2,"1"));
	 	a+="正版软件总数=正版商用软件总数+本行自主知识产权软件总数 校验出错！\n";
	  	isValid=false;
	}
	if((getTableFormObj(item10000_GTZero,"1").value.trim() > 0
		 	   && getTableFormObj(item10001_GTZero,"1").value.trim() == 0)||
		 	   (getTableFormObj(item10000_GTZero,"1").value.trim() == 0
		 	   && getTableFormObj(item10001_GTZero,"1").value.trim() > 0)){
		errorObjs.push(getTableFormObj(item10000_GTZero,"1"));
		errorObjs.push(getTableFormObj(item10001_GTZero,"1"));
				a += "本年度软件正版化培训情况 | 本年度培训次数或培训总人次填写有误!\n";
				isValid=false;	
			}
	if(getTableFormObj(label_R_Item19,"1_1").value.trim()=="有"){
		if(getTableFormObj(label_R_Item5,"1_1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item5,"1_1"));
			a += "软件正版化工作负责部门名称不能为空！\n";
			isValid=false;	
		}
	}
	if(getTableFormObj(label_R_Item16,"1").value.trim()=="有"){
		if(getTableFormObj(label_R_Item6,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item6,"1"));
			a += "软件正版化工作负责人：姓名不能为空！\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item7,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item7,"1"));
			a += "软件正版化工作负责人：职务不能为空！\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item8,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item8,"1"));
			a += "软件正版化工作负责人：办公电话区号不能为空！\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item9,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item9,"1"));
			a += "软件正版化工作负责人：办公电话号码不能为空！\n";
			isValid=false;	
		}
	}
	
	var R_Item1_YNs = getTableFormObjs(R_Item1_YN);
	var R_Item1_GTZeros= getTableFormObjs(R_Item1_GTZero);
	for(var i=0; i<R_Item1_GTZeros.length;i++){
		if (R_Item1_YNs[i].value.trim() == "限制许可数量") {
			if(R_Item1_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item1_GTZeros[i]);
				a += "许可数量不能为空！\n";
				isValid=false;	
			}
		}
	}
	var R_Item2_YNs = getTableFormObjs(R_Item2_YN);
	var R_Item2_GTZeros= getTableFormObjs(R_Item2_GTZero);
	for(var i=0; i<R_Item2_GTZeros.length;i++){
		if (R_Item2_YNs[i].value.trim() == "限制许可数量") {
			if(R_Item2_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item2_GTZeros[i]);
				a += "许可数量不能为空！\n";
				isValid=false;	
			}
		}
	}
	
	var R_Item3_YNs = getTableFormObjs(R_Item3_YN);
	var R_Item3_GTZeros= getTableFormObjs(R_Item3_GTZero);
	for(var i=0; i<R_Item3_GTZeros.length;i++){
		if (R_Item3_YNs[i].value.trim() == "限制许可数量") {
			if(R_Item3_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item3_GTZeros[i]);
				a += "许可数量不能为空！\n";
				isValid=false;	
			}
		}
	}
	
	var R_Item4_YNs = getTableFormObjs(R_Item4_YN);
	var R_Item4_GTZeros= getTableFormObjs(R_Item4_GTZero);
	for(var i=0; i<R_Item4_GTZeros.length;i++){
		if (R_Item4_YNs[i].value.trim() == "限制许可数量") {
			if(R_Item4_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item4_GTZeros[i]);
				a += "许可数量不能为空！\n";
				isValid=false;	
			}
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
	checkNumFloat(getTableFormObj(label_R_Item20,"1"),2);
	checkNumFloat(getTableFormObj(label_R_Item21,"1")),2;
	return isValid;
}
var click_columnValueNumber = function() {
	columnValueNumber(this);
};
