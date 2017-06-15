/*
 * 报表：T-B-6 数据（灾备）中心机房情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01 = "填报内容#供电#列2#行3#列2#行1#是否配备";
var label_YN01_1 = "填报内容#供电#列2#行3#列2#行2#额定功率";
var label_YN01_2 = "填报内容#供电#列2#行3#列2#行3#自动启动";
var label_YN01_3 = "填报内容#供电#列2#行3#列2#行4#启动时间";
var label_YN01_4 = "填报内容#供电#列2#行3#列2#行5#油料储备可用时间";
var label_YN01_5 = "填报内容#供电#列2#行3#列2#行6#运维单位 #运维单位 ";
var label_YN01_6 = "填报内容#供电#列2#行3#列2#行6#运维单位 #1";
var label_YN01_7 = "填报内容#供电#列2#行3#列2#行7#是否租用#是否租用";
var label_YN01_8 = "填报内容#供电#列2#行3#列2#行7#是否租用#出租方名称";

var label_item6_GTZero = "填报内容#机房#列2#行4#主机房面积";
var label_item12_GTZero = "填报内容#供电#列2#行2#列2#行2#列2";
var label_item13_GTZero = "填报内容#供电#列2#行2#列2#行6#实际负载峰值";
var label_item14_GTZero = "填报内容#供电#列2#行2#列2#行3#满载电池可用时间";
var label_item15_GTZero = "填报内容#供电#列2#行2#列2#行4#UPS主机中最长使用年份";
var label_item16_GTZero = "填报内容#供电#列2#行2#列2#行5#UPS电池中最长使用年份";

var label_item22_GTZero = "填报内容#门禁与监控#列2#门禁#门禁内容#门禁记录保存时间#门禁记录保存时间";
var label_item25_GTZero = "填报内容#门禁与监控#列2#环境监控#环境监控内容#监控记录保存时间#监控记录保存时间";

var label_item30_GTZero = "填报内容#空调#空调内容#设计单位面积制冷量#设计单位面积制冷量";
/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var objs = getTableFormObjs(label_YN01);
	for(var i = 0; i < objs.length; i++){
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_YN01_1 = getTableFormObj(label_YN01_1,objs[i].rownumber);
		var obj_YN01_2 = getTableFormObj(label_YN01_2,objs[i].rownumber);
		var obj_YN01_3 = getTableFormObj(label_YN01_3,objs[i].rownumber);
		var obj_YN01_4 = getTableFormObj(label_YN01_4,objs[i].rownumber);
		var obj_YN01_5 = getTableFormObj(label_YN01_5,objs[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,objs[i].rownumber + "_1");
		var obj_YN01_7 = getTableFormObj(label_YN01_7,objs[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,objs[i].rownumber + "_1");
		if(objs[i].value == "否"){
			obj_YN01_1.onclick = "";
			columnVallueRadio1(obj_YN01_2,false,false,false);
			obj_YN01_3.onclick = "";
			obj_YN01_4.onclick = "";
			columnVallueRadio1(obj_YN01_5,false,false,false);
			obj_YN01_6.readOnly = "readonly";
			columnVallueRadio1(obj_YN01_7,false,false,false);
			obj_YN01_8.readOnly = "readonly";
			//清空
			obj_YN01_1.value = "";
			obj_YN01_3.value = "";
			obj_YN01_4.value = "";
			obj_YN01_6.value = "";
			obj_YN01_8.value = "";
		}else{
			obj_YN01_1.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_YN01_2,true,false,false);
			obj_YN01_3.onclick = click_columnValueNumber;
			obj_YN01_4.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_YN01_5,true,true,true);
			obj_YN01_6.readOnly = "";
			columnVallueRadio1(obj_YN01_7,true,true,false);
			obj_YN01_8.readOnly = "";
		}
		var obj_YN01_5 = getTableFormObj(label_YN01_5,objs[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,objs[i].rownumber + "_1");
		if(obj_YN01_5.value == "本行"){
			obj_YN01_6.readOnly = "readonly";
			obj_YN01_6.value = "";
		}else{
			obj_YN01_6.readOnly = "";
		}
		var obj_YN01_7 = getTableFormObj(label_YN01_7,objs[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,objs[i].rownumber + "_1");
		if(obj_YN01_7.value == "否"){
			obj_YN01_8.readOnly = "readonly";
			obj_YN01_8.value = "";
		}else{
			obj_YN01_8.readOnly = "";
		}
	}	
}
/*
* 功能：运维单位选择本行时，文本框不可输入， 选择外部机构时 可输入
* 配置：填报内容#供电#列2#行3#列2#行1#是否配备
*/
function checkYN01(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_1 = getTableFormObj(label_YN01_1,target.rownumber);
	var obj_YN01_2 = getTableFormObj(label_YN01_2,target.rownumber);
	var obj_YN01_3 = getTableFormObj(label_YN01_3,target.rownumber);
	var obj_YN01_4 = getTableFormObj(label_YN01_4,target.rownumber);
	var obj_YN01_5 = getTableFormObj(label_YN01_5,target.rownumber + "_1");
	var obj_YN01_6 = getTableFormObj(label_YN01_6,target.rownumber + "_1");
	var obj_YN01_7 = getTableFormObj(label_YN01_7,target.rownumber + "_1");
	var obj_YN01_8 = getTableFormObj(label_YN01_8,target.rownumber + "_1");
	if(target.value == "否"){
		obj_YN01_1.onclick = "";
		columnVallueRadio1(obj_YN01_2,false,false,false);
		obj_YN01_3.onclick = "";
		obj_YN01_4.onclick = "";
		columnVallueRadio1(obj_YN01_5,false,false,false);
		obj_YN01_6.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_7,false,false,false);
		obj_YN01_8.readOnly = "readonly";
		//清空
		obj_YN01_1.value = "";
		obj_YN01_3.value = "";
		obj_YN01_4.value = "";
		obj_YN01_6.value = "";
		obj_YN01_8.value = "";
	}else{
		obj_YN01_1.onclick = click_columnValueNumber;
		columnVallueRadio1(getTableFormObj(label_YN01_2,target.rownumber),true,false,false);
		obj_YN01_3.onclick = click_columnValueNumber;
		obj_YN01_4.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN01_5,true,true,true);
		obj_YN01_6.readOnly = "";
		columnVallueRadio1(obj_YN01_7,true,true,false);
		obj_YN01_8.readOnly = "";
	}
}

/*
 *功能：恢复数字键盘输入
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
 *功能：单选按钮的读写设置
 *参数：obj为单选对象
 *	  access当单选可被选时传true，不可被选时传false
 *	  flag 为是否添加特殊函数调用
 *	  addmethed 为添加函数判断，true添加checkYN01_5   false添加checkYN01_7
 */
function columnVallueRadio1(obj,access,flag,addmethed){
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
							if(addmethed){
								imgs[k].onclick = function(){
									columnVallueRadio(this);
									checkYN01_5(this);
								};
							}else{
								imgs[k].onclick = function(){
									columnVallueRadio(this);
									checkYN01_7(this);
								};
							}
						}
					}
				}
			}
		}
	}
}
/*
* 功能：运维单位选择本行时，文本框不可输入， 选择外部机构时 可输入
* 配置：填报内容#供电#列2#行3#列2#行6#运维单位#运维单位
*/
function checkYN01_5(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_6 = getTableFormObj(label_YN01_6,target.rownumber);
	if(target.value == "本行"){
		obj_YN01_6.readOnly = "readonly";
		obj_YN01_6.value = "";
	}else{
		obj_YN01_6.readOnly = "";
	}
}

/*
* 功能：发电机是否租用选择否时，文本框不可输入， 选择是时 可输入
* 配置：填报内容#供电#列2#行3#列2#行7#是否租用#是否租用
*/
function checkYN01_7(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_8 = getTableFormObj(label_YN01_8,target.rownumber);
	if(target.value == "否"){
		obj_YN01_8.readOnly = "readonly";
		obj_YN01_8.value = "";
	}else{
		obj_YN01_8.readOnly = "";
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
	
	
	
	
	
	
	
	var obj_YN01 = getTableFormObjs(label_YN01);
	for(var i = 0; i < obj_YN01.length; i++){
		var obj_YN01_1 = getTableFormObj(label_YN01_1,obj_YN01[i].rownumber);
		var obj_YN01_2 = getTableFormObj(label_YN01_2,obj_YN01[i].rownumber);
		var obj_YN01_3 = getTableFormObj(label_YN01_3,obj_YN01[i].rownumber);
		var obj_YN01_4 = getTableFormObj(label_YN01_4,obj_YN01[i].rownumber);
		var obj_YN01_5 = getTableFormObj(label_YN01_5,obj_YN01[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,obj_YN01[i].rownumber + "_1");
		var obj_YN01_7 = getTableFormObj(label_YN01_7,obj_YN01[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,obj_YN01[i].rownumber + "_1");
	
		if(obj_YN01[i].value == "是"){
			if(obj_YN01_1.value.trim() == ""){
				errorObjs.push(obj_YN01_1);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：额定功率＂不能为空！\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_1,2);
			}
			if(obj_YN01_2.value.trim() == ""){
				errorObjs.push(obj_YN01_2.parentElement);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：自动启动＂不能为空！\n";
				isValid = false;
			}
			if(obj_YN01_3.value.trim() == ""){
				errorObjs.push(obj_YN01_3);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：启动时间＂不能为空！\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_3,2);
			}
			if(obj_YN01_4.value.trim() == ""){
				errorObjs.push(obj_YN01_4);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：油料储备可用时间＂不能为空！\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_4,2);
			}
			if(obj_YN01_5.value.trim() == ""){
				errorObjs.push(obj_YN01_5.parentElement);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：运维单位＂不能为空！\n";
				isValid = false;
			}
			if(obj_YN01_7.value.trim() == ""){
				errorObjs.push(obj_YN01_7.parentElement);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：是否租用＂不能为空！\n";
				isValid = false;
			}
			
			if(obj_YN01_5.value == "外部机构" && obj_YN01_6.value.trim() == ""){
				errorObjs.push(obj_YN01_6);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：外部机构＂不能为空！\n";
				isValid = false;
			}
			if(obj_YN01_7.value == "是" && obj_YN01_8.value.trim() == ""){
				errorObjs.push(obj_YN01_8);
				a += "数据(灾备)中心机房" + (i+1) + "：＂供电 发电机：出租方名称＂不能为空！\n";
				isValid = false;
			}
			
			
		}
	}
	
	var obj_item6_GTZero = getTableFormObjs(label_item6_GTZero);
	for(var i = 0; i < obj_item6_GTZero.length; i++){
		checkNumFloat(obj_item6_GTZero[i],2);
	}
	var obj_item12_GTZero = getTableFormObjs(label_item12_GTZero);
	for(var i = 0; i < obj_item12_GTZero.length; i++){
		checkNumFloat(obj_item12_GTZero[i],2);
	}
	
	var obj_item13_GTZero = getTableFormObjs(label_item13_GTZero);
	for(var i = 0; i < obj_item13_GTZero.length; i++){
		checkNumFloat(obj_item13_GTZero[i],2);
	}
	
	var obj_item14_GTZero = getTableFormObjs(label_item14_GTZero);
	for(var i = 0; i < obj_item14_GTZero.length; i++){
		checkNumFloat(obj_item14_GTZero[i],2);
	}
	
	var obj_item15_GTZero = getTableFormObjs(label_item15_GTZero);
	for(var i = 0; i < obj_item15_GTZero.length; i++){
		checkNumFloat(obj_item15_GTZero[i],2);
	}
	
	var obj_item16_GTZero = getTableFormObjs(label_item16_GTZero);
	for(var i = 0; i < obj_item16_GTZero.length; i++){
		checkNumFloat(obj_item16_GTZero[i],2);
	}
	
	var obj_item22_GTZero = getTableFormObjs(label_item22_GTZero);
	for(var i = 0; i < obj_item22_GTZero.length; i++){
		checkNumFloat(obj_item22_GTZero[i],2);
	}
	
	var obj_item25_GTZero = getTableFormObjs(label_item25_GTZero);
	for(var i = 0; i < obj_item25_GTZero.length; i++){
		checkNumFloat(obj_item25_GTZero[i],2);
	}
	
	var obj_item30_GTZero = getTableFormObjs(label_item30_GTZero);
	for(var i = 0; i < obj_item30_GTZero.length; i++){
		checkNumFloat(obj_item30_GTZero[i],2);
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