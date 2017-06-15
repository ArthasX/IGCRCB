/*
 * 报表：T-Q-1 重要信息系统运行情况表
 */
var isValid = true;
var a = "";
var errorObjs=[];
var label_item21 = "重要信息系统停止服务情况#非预期停止服务#信息系统";
var label_item23 = "重要信息系统停止服务情况#非预期停止服务#停止服务原因";
var label_item24 = "重要信息系统停止服务情况#非预期停止服务#事件等级";
var label_item0 = "重要信息系统停止服务情况#非预期停止服务#起始时间";
var label_item1 = "重要信息系统停止服务情况#非预期停止服务#结束时间";
var label_item25 = "重要信息系统停止服务情况#非预期停止服务#影响范围#影响范围";
var label_item26 = "重要信息系统停止服务情况#非预期停止服务#影响范围#分支机构";
var label_item27 = "重要信息系统停止服务情况#非预期停止服务#描述";

var label_R_item21 = "重要信息系统停止服务情况#预期停止服务#信息系统";
var label_R_item23 = "重要信息系统停止服务情况#预期停止服务#停止服务原因";
var label_R_item0 = "重要信息系统停止服务情况#预期停止服务#起始时间";
var label_R_item1 = "重要信息系统停止服务情况#预期停止服务#结束时间";
var label_R_item25 = "重要信息系统停止服务情况#预期停止服务#影响范围#影响范围";
var label_R_item26 = "重要信息系统停止服务情况#预期停止服务#影响范围#分支机构";
var label_R_item27 = "重要信息系统停止服务情况#预期停止服务#描述";

var label_item57_GTZero="核心业务系统重要性能指标#5#处理能力#处理能力1#数量";
var label_item58_GTZero="核心业务系统重要性能指标#5#处理能力#处理能力2#数量";

var label_item67_GTZero="网上银行系统运行情况#网上银行系统运行情况1#数量";

var label_item73_GTZero="银行卡系统运行情况#银行卡系统运行情况1#数量";

var label_item74_GTZero="第三方存管系统运行情况#第三方存管系统运行情况1#数量";
var label_item73 = "第三方存管系统运行情况#第三方存管系统运行情况2#数量";

/*
* 功能：流程处理页初始化时设置表单权限
* 配置：填报状态和二级审批状态
*/
function initSet(){
	var label_item21s=getTableFormObjs(label_item21);
	var label_item23s=getTableFormObjs(label_item23);
	var label_item24s=getTableFormObjs(label_item24);
	var label_item0s=getTableFormObjs(label_item0);
	var label_item1s=getTableFormObjs(label_item1);
	var label_item25s=getTableFormObjs(label_item25);
	var label_item26s=getTableFormObjs(label_item26);
	var label_item27s=getTableFormObjs(label_item27);
	
	var label_R_item21s=getTableFormObjs(label_R_item21);
	var label_R_item23s=getTableFormObjs(label_R_item23);
	var label_R_item0s=getTableFormObjs(label_R_item0);
	var label_R_item1s=getTableFormObjs(label_R_item1);
	var label_R_item25s=getTableFormObjs(label_R_item25);
	var label_R_item26s=getTableFormObjs(label_R_item26);
	var label_R_item27s=getTableFormObjs(label_R_item27);
	
	if(label_item21s[0].value==""){
		columnVallueRadio1(label_item23s[0],false);
		columnVallueRadio1(label_item24s[0],false);
		columnVallueRadio1(label_item25s[0],false);
		label_item0s[0].onclick="";
		label_item1s[0].onclick="";
		label_item26s[0].onclick="";
		label_item27s[0].value="";
		label_item27s[0].parentElement.childNodes[0].contentEditable =false;
	}
	for(var i = 0; i < label_item23s.length; i++){
		if(label_item23s[i].rownumber.indexOf("#") > -1){
			if(label_item21s[i].value==""){
			columnVallueRadio1(label_item23s[i],false);
			columnVallueRadio1(label_item24s[i],false);
			columnVallueRadio1(label_item25s[i],false);
			label_item0s[i].onclick="";
			label_item1s[i].onclick="";
			label_item26s[i].onclick="";
			label_item27s[i].value="";
			label_item27s[i].parentElement.childNodes[0].contentEditable =false;
				}
		}else{
			continue;
		}
		
	}
	if(label_R_item21s[0].value==""){
		columnVallueRadio1(label_R_item23s[0],false);
		columnVallueRadio1(label_R_item25s[0],false);
		label_R_item0s[0].onclick="";
		label_R_item1s[0].onclick="";
		label_R_item26s[0].onclick="";
		label_R_item27s[0].value="";
		label_R_item27s[0].parentElement.childNodes[0].contentEditable =false;
	}
	for(var i = 0; i < label_R_item23s.length; i++){
		if(label_R_item23s[i].rownumber.indexOf("#") > -1){
			if(label_R_item21s[i].value==""){
			columnVallueRadio1(label_R_item23s[i],false);
			columnVallueRadio1(label_R_item25s[i],false);
			label_R_item0s[i].onclick="";
			label_R_item1s[i].onclick="";
			label_R_item26s[i].onclick="";
			label_R_item27s[i].value="";
			label_R_item27s[i].parentElement.childNodes[0].contentEditable =false;
				}
		}else{
			continue;
		}
	}
	
}
var check_item26=function(){columnVallueRadio(this); obj_item26(this);};

/*
 *功能：信息系统没有选择的时候同列其他表单不可选
 *配置：重要信息系统停止服务情况#非预期停止服务#信息系统
 */
function obj_item21(obj) {
	var target = getTarget(obj.parentElement);
		var obj_item23=getTableFormObj(label_item23,target.rownumber);
		var obj_item24=getTableFormObj(label_item24,target.rownumber);
		var obj_item0=getTableFormObj(label_item0,target.rownumber);
		var obj_item1=getTableFormObj(label_item1,target.rownumber);
		var obj_item25=getTableFormObj(label_item25,target.rownumber+"_1");
		var obj_item26=getTableFormObj(label_item26,target.rownumber+"_1");
		var obj_item27=getTableFormObj(label_item27,target.rownumber);
			columnVallueRadio1(obj_item23,true);
			columnVallueRadio1(obj_item24,true);
			columnVallueRadio3(obj_item25,check_item26);
			obj_item0.onclick=function(){showTime(this);};
			obj_item1.onclick=function(){showTime(this);};
			obj_item26.onclick=function(){columnValueNumber(this);};
			obj_item27.parentElement.childNodes[0].contentEditable =true;
}

var check_R_item26=function(){columnVallueRadio(this); obj_R_item26(this);};
/*
 *功能：信息系统没有选择的时候同列其他表单不可选
 *配置：重要信息系统停止服务情况#预期停止服务#信息系统
 */
function obj_R_item21(obj) {
	var target = getTarget(obj.parentElement);
		var obj_R_item23=getTableFormObj(label_R_item23,target.rownumber);
		var obj_R_item0=getTableFormObj(label_R_item0,target.rownumber);
		var obj_R_item1=getTableFormObj(label_R_item1,target.rownumber);
		var obj_R_item25=getTableFormObj(label_R_item25,target.rownumber+"_1");
		var obj_R_item26=getTableFormObj(label_R_item26,target.rownumber+"_1");
		var obj_R_item27=getTableFormObj(label_R_item27,target.rownumber);
			columnVallueRadio1(obj_R_item23,true);
			columnVallueRadio3(obj_R_item25,check_R_item26);
			obj_R_item0.onclick=function(){showTime(this);};
			obj_R_item1.onclick=function(){showTime(this);};
			obj_R_item26.onclick=function(){columnValueNumber(this);};
			obj_R_item27.parentElement.childNodes[0].contentEditable =true;
}
/*
 *功能：单选按钮的读写设置
 */
function columnVallueRadio3(obj,check){
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
						imgs[k].onclick = check;
				}
			}
		}
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
	
	var objs = getTableFormObjs(label_item21);
	for ( var i = 0; i < objs.length; i++) {
		// 过滤模版
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	
	var objs_R = getTableFormObjs(label_R_item21);
	for ( var i = 0; i < objs_R.length; i++) {
		// 过滤模版
		if ((objs_R[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull1(objs_R[i]);
	}

		if(parseFloat(getTableFormObj(label_item57_GTZero,"1_1_1_1").value) > parseFloat(getTableFormObj(label_item58_GTZero,"1_1_1_1").value)){
			errorObjs.push(getTableFormObj(label_item57_GTZero,"1_1_1_1"));
			errorObjs.push(getTableFormObj(label_item58_GTZero,"1_1_1_1"));
			a+="核心业务系统重要性能指标-处理能力-日交易笔数峰值>=日均交易笔数出错！\n";
			isValid=false;
			}
		if(parseFloat(getTableFormObjs(label_item67_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item67_GTZero)[1].value)){
				errorObjs.push(getTableFormObjs(label_item67_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item67_GTZero)[1]);
				a+="网上银行系统运行情况-日交易笔数峰值>=日均交易笔数出错！\n";
				isValid=false;
			}
		
		if(parseFloat(getTableFormObjs(label_item73_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item73_GTZero)[1].value)){
				errorObjs.push(getTableFormObjs(label_item73_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item73_GTZero)[1]);
				a+="银行卡系统运行情况-日交易笔数峰值>=日均交易笔数出错！\n";
				isValid=false;
			}
	
		if(parseFloat(getTableFormObjs(label_item74_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item73)[0].value))  {
				errorObjs.push(getTableFormObjs(label_item74_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item73)[0]);
				a+="第三方存管系统运行情况-日交易笔数峰值>=日均交易笔数出错！\n";
				isValid=false;
			}
		
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#1#数量")[0],3);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#2#数量")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#3#CPU#数量")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#3#CPU#数量")[1],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#4#数量")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#4#数量")[1],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#5#处理能力#处理能力1#数量")[0],4);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#5#处理能力#处理能力2#数量")[0],4);
//		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#5#处理能力#处理能力3#数量")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#5#处理能力#处理能力4#数量")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动1#数量#同比（增减）")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动1#数量#环比（增减）")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动1#数量#公司账户")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动2#数量#个人账户")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动2#数量#同比（增减）")[0],2);
		checkNumFloat(getTableFormObjs("核心业务系统重要性能指标#6#账户数及变动表#账户数及变动2#数量#环比（增减）")[0],2);
		checkNumFloat(getTableFormObjs("网上银行系统运行情况#网上银行系统运行情况1#数量")[0],4);
		checkNumFloat(getTableFormObjs("网上银行系统运行情况#网上银行系统运行情况1#数量")[1],4);
		checkNumFloat(getTableFormObjs("银行卡系统运行情况#银行卡系统运行情况1#数量")[0],4);
		checkNumFloat(getTableFormObjs("银行卡系统运行情况#银行卡系统运行情况1#数量")[1],4);
		checkNumFloat(getTableFormObjs("第三方存管系统运行情况#第三方存管系统运行情况1#数量")[0],4);
		checkNumFloat(getTableFormObjs("第三方存管系统运行情况#第三方存管系统运行情况2#数量")[0],4);

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
function checkTableItemNull(obj) {

	var obj_item23 = getTableFormObj(label_item23,obj.rownumber);
	var obj_item24 = getTableFormObj(label_item24,obj.rownumber);
	var obj_item0 = getTableFormObj(label_item0,obj.rownumber);
	var obj_item1 = getTableFormObj(label_item1, obj.rownumber);
	var obj_item25 = getTableFormObj(label_item25, obj.rownumber + "_1");
	var obj_item26 = getTableFormObj(label_item26, obj.rownumber + "_1");
	var obj_item27 = getTableFormObj(label_item27, obj.rownumber);
	if (obj.value.trim() !="" ){
	
		if (obj_item23.value == ""  ) {
			errorObjs.push(obj_item23.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 非预期停止服务：停止服务原因＂不能为空！\n";
			isValid = false;
		}
		if (obj_item24.value == "" ) {
			errorObjs.push(obj_item24.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 非预期停止服务：事件等级＂不能为空！\n";
			isValid = false;
		}
		if (obj_item0.value== "" ) {
			errorObjs.push(obj_item0);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 非预期停止服务：起始时间＂不能为空！\n";
			isValid = false;
		}
		if (obj_item1.value == "" ) {
			errorObjs.push(obj_item1);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 非预期停止服务：结束时间＂不能为空！\n";
			isValid = false;
		}
		if (obj_item25.value.trim() == "") {
			errorObjs.push(obj_item25.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况-非预期停止服务的影响范围＂不能为空！\n";
			isValid = false;
		}
		if (obj_item25.value == "分支机构" && obj_item26.value.trim() == "") {
			errorObjs.push(obj_item26);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况-非预期停止服务的影响范围选择分支机构时，机构数量＂不能为空！\n";
			isValid = false;
		}
		if (obj_item27.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_item27));
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 非预期停止服务：描述＂不能为空！\n";
			isValid = false;
		}
	}
}

/*
 * 功能：根据项目名称判断该行是否全输入了值
 */
function checkTableItemNull1(obj) {

	var obj_R_item23 = getTableFormObj(label_R_item23,obj.rownumber);
//	var obj_R_item24 = getTableFormObj(label_item24,obj.rownumber);
	var obj_R_item0 = getTableFormObj(label_R_item0,obj.rownumber);
	var obj_R_item1 = getTableFormObj(label_R_item1, obj.rownumber);
	var obj_R_item25 = getTableFormObj(label_R_item25, obj.rownumber + "_1");
	var obj_R_item26 = getTableFormObj(label_R_item26, obj.rownumber + "_1");
	var obj_R_item27 = getTableFormObj(label_R_item27, obj.rownumber);
	if (obj.value.trim() !="" ){
	
		if (obj_R_item23.value == ""  ) {
			errorObjs.push(obj_R_item23.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 预期停止服务：停止服务原因＂不能为空！\n";
			isValid = false;
		}
		/*if (obj_R_item24.value == "" ) {
			errorObjs.push(obj_R_item24.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 预期停止服务：事件等级＂不能为空！\n";
			isValid = false;
		}*/
		if (obj_R_item0.value== "" ) {
			errorObjs.push(obj_R_item0);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 预期停止服务：起始时间＂不能为空！\n";
			isValid = false;
		}
		if (obj_R_item1.value == "" ) {
			errorObjs.push(obj_R_item1);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 预期停止服务：结束时间＂不能为空！\n";
			isValid = false;
		}
		if (obj_R_item25.value.trim() == "") {
			errorObjs.push(obj_R_item25.parentElement);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况-预期停止服务的影响范围＂不能为空！\n";
			isValid = false;
		}
		if (obj_R_item25.value == "分支机构" && obj_R_item26.value.trim() == "") {
			errorObjs.push(obj_R_item26);
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况-预期停止服务的影响范围选择分支机构时，机构数量＂不能为空！\n";
			isValid = false;
		}
		if (obj_R_item27.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_R_item27));
			a += "重要信息系统停止服务情况，序号"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"：”信息系统”选择内容时，＂重要信息系统停止服务情况 预期停止服务：描述＂不能为空！\n";
			isValid = false;
		}
	}
}

/*
* 功能：结束时间必须大于开始时间
* 配置："重要信息系统停止服务情况#非预期停止服务#起始时间";
*/
function obj_item0_Start(obj) {
	var obj_item0s = getTableFormObjs(label_item0);
	for(var i = 0; i < obj_item0s.length; i++){
		if(obj_item0s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item1 = getTableFormObj(label_item1,obj_item0s[i].rownumber);
		if(obj_item0s[i].value != "" && obj_item1.value != ""){
			if(obj_item0s[i].value.split(" ")[0] > obj_item1.value.split(" ")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[0] > obj_item1.value.split(" ")[1].split(":")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[1] > obj_item1.value.split(" ")[1].split(":")[1]){
				obj_item0s[i].value = "";
				alert("起始时间应在结束时间之前，请重新输入！");
			}
		}
	}
}
/*
* 功能：结束时间必须大于开始时间
* 配置："重要信息系统停止服务情况#非预期停止服务#结束时间";
*/
function obj_item0_Finish(obj) {
	var obj_item1s = getTableFormObjs(label_item1);
	for(var i = 0; i < obj_item1s.length; i++){
		if(obj_item1s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item0 = getTableFormObj(label_item0,obj_item1s[i].rownumber);
		if(obj_item0.value != "" && obj_item1s[i].value != ""){
			if(obj_item0.value.split(" ")[0] > obj_item1s[i].value.split(" ")[0] || 
					obj_item0.value.split(" ")[1].split(":")[0] > obj_item1s[i].value.split(" ")[1].split(":")[0] || 
					obj_item0.value.split(" ")[1].split(":")[1] > obj_item1s[i].value.split(" ")[1].split(":")[1]){
				obj_item1s[i].value = "";
				alert("结束时间应在起始时间之后，请重新输入！");
			}
		}
	}
}
/*
* 功能：结束时间必须大于开始时间
* 配置："重要信息系统停止服务情况#预期停止服务#起始时间";
*/
function obj_R_item0_Start(obj) {
	var obj_item0s = getTableFormObjs(label_R_item0);
	
	for(var i = 0; i < obj_item0s.length; i++){
		if(obj_item0s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item1 = getTableFormObj(label_R_item1,obj_item0s[i].rownumber);
		if(obj_item0s[i].value != "" && obj_item1.value != ""){
			if(obj_item0s[i].value.split(" ")[0] > obj_item1.value.split(" ")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[0]>obj_item1.value.split(" ")[1].split(":")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[1]>obj_item1.value.split(" ")[1].split(":")[1]){
				obj_item0s[i].value = "";
				alert("起始时间应在结束时间之前，请重新输入！");
			}
		}
	}
}

/*
* 功能：结束时间必须大于开始时间
* 配置："重要信息系统停止服务情况#预期停止服务#结束时间 ";
*/
function obj_R_item0_Finish(obj) {
	var obj_item1s = getTableFormObjs(label_R_item1);	
	for(var i = 0; i < obj_item1s.length; i++){
		if(obj_item1s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item0 = getTableFormObj(label_R_item0,obj_item1s[i].rownumber);
		if(obj_item0.value != "" && obj_item1s[i].value != ""){
			if(obj_item0.value.split(" ")[0] > obj_item1s[i].value.split(" ")[0] || 
					obj_item0.value.split(" ")[1].split(":")[0]>obj_item1s[i].value.split(" ")[1].split(":")[0] || 
					obj_item0.value.split(" ")[1].split(":")[1]>obj_item1s[i].value.split(" ")[1].split(":")[1]){
				obj_item1s[i].value = "";
				alert("结束时间应在起始时间之后，请重新输入！");
			}
		}
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：重要信息系统停止服务情况#非预期停止服务#影响范围#影响范围";
*/
function obj_item26(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_item25s = getTableFormObjs(label_item25);
	for(var i = 0; i< obj_item25s.length; i++){
		var obj_item26 = getTableFormObj(label_item26,obj_item25s[i].rownumber );
		if (obj_item25s[i].value == "全辖") {
			// 只读
			// 清空
			obj_item26.value="";
			obj_item26.onclick="";
		} else if (obj_item25s[i].value == "分支机构") {
			// 还原
			obj_item26.onclick=function(){columnValueNumber(this);};
		}
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：重要信息系统停止服务情况#预期停止服务#影响范围#影响范围";
*/
function obj_R_item26(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_R_item25s = getTableFormObjs(label_R_item25);
	for(var i = 0; i < obj_R_item25s.length; i++ ){
		var obj_R_item26 = getTableFormObj(label_R_item26,obj_R_item25s[i].rownumber);
		if (obj_R_item25s[i].value == "全辖") {
			// 只读
			// 清空
			obj_R_item26.value="";
			obj_R_item26.onclick="";
		} else if (obj_R_item25s[i].value == "分支机构") {
			// 还原
			obj_R_item26.onclick=function(){columnValueNumber(this);};
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
/*
 *功能：单选按钮的读写设置
 */
function columnVallueRadio1(obj,access){
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
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								};
						}else{
							imgs[k].onclick = function(){
							columnVallueRadio(this);
							};
						}
					}
				}
			}
		}
	}
}
