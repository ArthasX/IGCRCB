/*
 * 报表：T-A-6 重要信息系统投产及变更报告表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "实施起止时间（或计划实施日期）#开始时间";
var label_item8 = "实施起止时间（或计划实施日期）#结束时间";
var label_item7 = "报告类型";
var label_item14= "报送材料#事前报送材料#1、应急预案#附件索引";
var label_item14_fujian= "报送材料#事前报送材料#1、应急预案#应急预案";
var label_item15= "报送材料#事前报送材料#2、风险评估报告#附件索引";
var label_item15_fujian= "报送材料#事前报送材料#2、风险评估报告#风险评估报告";
var label_item16= "报送材料#事后报送材料#1、投产及变更方案#附件索引";
var label_item16_fujian= "报送材料#事后报送材料#1、投产及变更方案#投产及变更方案";
var label_item17= "报送材料#事后报送材料#2、外包服务信息#附件索引";
var label_item17_fujian= "报送材料#事后报送材料#2、外包服务信息#外包服务信息";
var label_item18= "报送材料#事后报送材料#3、总结报告#附件索引";
var label_item18_fujian= "报送材料#事后报送材料#3、总结报告#总结报告";

/*
* 功能：二级审批状态初始化时设置表单权限
* 配置：二级审批状态初始化js
*/
function initSet(){
	var obj_item7= getFormObj(label_item7);
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	
	if(obj_item7.value=="事前报告"){
		getEditDiv(obj_item14).contentEditable = true;
		getEditDiv(obj_item15).contentEditable = true;
		getEditDiv(obj_item16).contentEditable = false;
		getEditDiv(obj_item17).contentEditable = false;
		getEditDiv(obj_item18).contentEditable = false;
		var obj_item16_fujian = getFujianObj(label_item16_fujian,"1_1_1");
		var obj_item17_fujian = getFujianObj(label_item17_fujian,"1_1_1");
		var obj_item18_fujian = getFujianObj(label_item18_fujian,"1_1_1");
		if (obj_item16_fujian != null) {
			var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
			var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
			var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
			obj_item16_fujian.readOnly= "readonly";
			obj_item16_fujianDelButton.onclick="";
			obj_item17_fujian.readOnly= "readonly";
			obj_item17_fujianDelButton.onclick="";
			obj_item18_fujian.readOnly= "readonly";
			obj_item18_fujianDelButton.onclick="";
		}
	}else if (obj_item7.value=="事后报告"){
		getEditDiv(obj_item14).contentEditable = false;
		getEditDiv(obj_item15).contentEditable = false;
		getEditDiv(obj_item16).contentEditable = true;
		getEditDiv(obj_item17).contentEditable = true;
		getEditDiv(obj_item18).contentEditable = true;
		var obj_item14_fujian= getFujianObj(label_item14_fujian,"1_1_1");
		var obj_item15_fujian= getFujianObj(label_item15_fujian,"1_1_1");
		if (obj_item14_fujian != null) {
			var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
			var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
			obj_item14_fujian.readOnly= "readonly";
			obj_item14_fujianDelButton.onclick="";
			obj_item15_fujian.readOnly= "readonly";
			obj_item15_fujianDelButton.onclick="";
		}
	}
}

/*
* 功能：开始和结束时间前后校验
* 配置：实施起止时间（或计划实施日期）#开始时间
*/
function checkStartTime(obj){
	var obj_endtime=getTableFormObj(label_item8,"1");
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("开始时间应在结束时间之前，请重新输入！");
		obj.value="";
		obj.focus();
	}
}

/*
* 功能：开始和结束时间前后校验
* 配置：实施起止时间（或计划实施日期）#结束时间
*/
function checkEndTime(obj){
	var obj_starttime=getTableFormObj(label_item5,"1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("结束时间应在起始时间之后，请重新输入！");
		obj.value="";
		obj.focus();
	}
}

/*
* 功能：报告类型点击时清空对应的附件索引内容
* 配置：报告类型
*/
function item7_click(obj){
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	var obj_item14_fujian= getFujianObj(label_item14_fujian,"1_1_1");
	var obj_item15_fujian= getFujianObj(label_item15_fujian,"1_1_1");
	var obj_item16_fujian = getFujianObj(label_item16_fujian,"1_1_1");
	var obj_item17_fujian = getFujianObj(label_item17_fujian,"1_1_1");
	var obj_item18_fujian = getFujianObj(label_item18_fujian,"1_1_1");
	if(obj.value=="事前报告"){
		getEditDiv(obj_item16).innerHTML = "";
		obj_item16.value="";
		getEditDiv(obj_item17).innerHTML = "";
		obj_item17.value="";
		getEditDiv(obj_item18).innerHTML = "";
		obj_item18.value="";
		getEditDiv(obj_item16).contentEditable = false;
		getEditDiv(obj_item17).contentEditable = false;
		getEditDiv(obj_item18).contentEditable = false;
		getEditDiv(obj_item14).contentEditable = true;
		getEditDiv(obj_item15).contentEditable = true;
		
		if (obj_item16_fujian.id.indexOf("IMG") > -1) {
			if (obj_item16_fujian.style.display!="none") {
				obj_item16_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item16_fujian);
			obj_item16_fujian = getSingalFileObj(label_item16_fujian,"1_1_1");
			obj_item16_fujian.readOnly= "readonly";
			var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
			obj_item16_fujianDelButton.onclick="";
		}
		if (obj_item17_fujian.id.indexOf("IMG") > -1) {
			if (obj_item17_fujian.style.display!="none") {
				obj_item17_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item17_fujian);
			obj_item17_fujian = getSingalFileObj(label_item17_fujian,
					"1_1_1");
			obj_item17_fujian.readOnly= "readonly";
			var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
			obj_item17_fujianDelButton.onclick="";
		}
		if (obj_item18_fujian.id.indexOf("IMG") > -1) {
			if (obj_item18_fujian.style.display!="none") {
				obj_item18_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item18_fujian);
			obj_item18_fujian = getSingalFileObj(label_item18_fujian,
					"1_1_1");
			obj_item18_fujian.readOnly= "readonly";
			var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
			obj_item18_fujianDelButton.onclick="";
		}
		obj_item14_fujian.readOnly= "";
		var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
		obj_item14_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item15_fujian.readOnly= "";
		var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
		obj_item15_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
	}else if (obj.value=="事后报告"){
		getEditDiv(obj_item14).innerHTML = "";
		obj_item14.value="";
		getEditDiv(obj_item15).innerHTML = "";
		obj_item15.value="";
		getEditDiv(obj_item16).contentEditable = true;
		getEditDiv(obj_item17).contentEditable = true;
		getEditDiv(obj_item18).contentEditable = true;
		getEditDiv(obj_item14).contentEditable = false;
		getEditDiv(obj_item15).contentEditable = false;
		
		obj_item16_fujian.readOnly= "";
		var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
		obj_item16_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item17_fujian.readOnly= "";
		var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
		obj_item17_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item18_fujian.readOnly= "";
		var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
		obj_item18_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		if (obj_item14_fujian.id.indexOf("IMG") > -1) {
			if (obj_item14_fujian.style.display!="none") {
				obj_item14_fujian.click();
//				obj_item14_fujian = getTableFormObj(label_item14_fujian, "1_1_1");
//				var temps =  obj_item14_fujian.parentElement.childNodes[0];
//				alert(temps.outerHTML)
			}
		} else {
			delSingleTableColumnFileInput(obj_item14_fujian);
			obj_item14_fujian = getSingalFileObj(label_item14_fujian,"1_1_1");
			obj_item14_fujian.readOnly= "readonly";
			var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
			obj_item14_fujianDelButton.onclick="";
		}
		
		if (obj_item15_fujian.id.indexOf("IMG") > -1) {
			if (obj_item15_fujian.style.display!="none") {
				obj_item15_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item15_fujian);
			obj_item15_fujian = getSingalFileObj(label_item15_fujian,"1_1_1");
			obj_item15_fujian.readOnly= "readonly";
			var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
			obj_item15_fujianDelButton.onclick="";
		}
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	var obj_starttime=getTableFormObj(label_item5,"1");
	var obj_endtime=getTableFormObj(label_item8,"1");
	var obj_item7 = getFormObj(label_item7);
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "开始时间应在变更时间之前，请重新输入！\n";
		isValid = false;
	}
	
	if (obj_item7.value=="事前报告") {
		if (getEditDiv(obj_item14).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item14));
			a += "事前报告时：事前报送材附件索引不能为空！\n";
			isValid = false;
		} else if (getEditDiv(obj_item15).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item15));
			a += "事前报告时：事前报送材附件索引不能为空！\n";
			isValid = false;
		}
	}

	if (obj_item7.value=="事后报告") {
		if (getEditDiv(obj_item16).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item16));
			a += "事后报告时：事后报送材附件索引不能为空！\n";
			isValid = false;
		} else if (getEditDiv(obj_item17).innerHTML =="") {
			errorObjs.push(getEditDiv(obj_item17));
			a += "事后报告时：事后报送材附件索引不能为空！\n";
			isValid = false;
		} else if (getEditDiv(obj_item18).innerHTML =="") {
			errorObjs.push(getEditDiv(obj_item18));
			a += "事后报告时：事后报送材附件索引不能为空！\n";
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

/*
* 功能：取得保存前或者保存后的附件对象
*/
function getFujianObj(labelname,rownumber) {
	var hasSaved=false;
	var obj = getTableFormObj(labelname,rownumber);
	var temps =  obj.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
        if(temps[i].id.indexOf("IMG")>-1){
        	hasSaved=true;
        	obj = temps[i];
        	break;
        }
    }
	if (!hasSaved) {
		obj = getSingalFileObj(labelname,rownumber);
	}
	return obj;
}

/*
* 功能：取得附件删除按钮
*/
function getFujianDelButtonObj(obj) {
	var temps =  obj.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
		if (temps[i].onclick!=null){
			obj = temps[i];
			break;
		}
    }
	return obj;
}

var delSingleTableColumnFileInput_click = function() {
	delSingleTableColumnFileInput(this);
};