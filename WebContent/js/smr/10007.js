/*
 * 报表：T-B-8 电子银行业务品种表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_RadioButtonList_COL43 = "个人网上银行#是否开办#内容";
var label_HV_item6 = "个人网上银行#金融服务#内容";
var label_HV_item8 = "个人网上银行#支付结算业务#项目";
var label_HV_item10 = "个人网上银行#理财业务#内容";

var label_RadioButtonList_COL44 = "企业网上银行#是否开办#内容";
var label_HV_item12 = "企业网上银行#金融服务#内容";
var label_HV_item14 = "企业网上银行#支付结算业务#内容";
var label_HV_item16 = "企业网上银行#银企直连#内容";
var label_HV_item18 = "企业网上银行#理财业务#内容";

var label_RadioButtonList_COL45 = "自助银行#是否开办#内容";
var label_HV_item20 = "自助银行#业务品种#内容";

var label_RadioButtonList_COL46 = "电话银行#是否开办#内容";
var label_HV_item22 = "电话银行#金融服务#内容";
var label_HV_item24 = "电话银行#支付结算业务#内容";
var label_HV_item26 = "电话银行#理财业务#内容";

var label_RadioButtonList_COL47 = "手机银行#表1#内容";
var label_HV_item28 = "手机银行#表2#内容";
var label_HV_item30 = "手机银行#表3#内容";
var label_HV_item32 = "手机银行#表4#内容";

/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	
	checkHV_item6(obj);
	checkHV_item8(obj);
	checkHV_item10(obj);
	checkRadio_COL43(obj);
	
	checkHV_item12(obj);
	checkHV_item14(obj);
	checkHV_item16(obj);
	checkHV_item18(obj);
	checkRadio_COL44(obj);
	
	checkHV_item20(obj);
	checkRadio_COL45(obj);
	
	checkHV_item22(obj);
	checkHV_item24(obj);
	checkHV_item26(obj);
	checkRadio_COL46(obj);
	
	checkHV_item28(obj);
	checkHV_item30(obj);
	checkHV_item32(obj);
	checkRadio_COL47(obj);
}

/*
* 功能：是否开办， 选择否的时候 同格多选不可选
* 配置：个人网上银行#是否开办#内容
*/
function checkRadio_COL43(obj){
	var obj_RadioButtonList_COL43 = getTableFormObjs(label_RadioButtonList_COL43)[0];
	var obj_HV_item6 = getTableFormCheckBox(label_HV_item6, obj_RadioButtonList_COL43.rownumber);
	var obj_HV_item8 = getTableFormCheckBox(label_HV_item8, obj_RadioButtonList_COL43.rownumber);
	var obj_HV_item10 = getTableFormCheckBox(label_HV_item10, obj_RadioButtonList_COL43.rownumber);
	
	if(obj_RadioButtonList_COL43.value == "否"){
		disableTableCheckBox(obj_HV_item6,true);
		disableTableCheckBox(obj_HV_item8,true);
		disableTableCheckBox(obj_HV_item10,true);
	}else{
		disableTableCheckBoxs(obj_HV_item6,false);
		disableTableCheckBoxs(obj_HV_item8,false);
		disableTableCheckBoxs(obj_HV_item10,false);
	}
}

/*
* 功能： 金融服务当选择 无此项服务 时其他多选项不可选
* 配置：个人网上银行#金融服务#内容
*/
function checkHV_item6(obj){
	var obj_item6 = getTableFormObjs(label_HV_item6)[0];
	var obj_HV_item6 = getTableFormCheckBox(label_HV_item6, obj_item6.rownumber);
	for(var i = 0; i < obj_HV_item6.length; i++){
		if(obj_HV_item6[i].value == "无此项服务" && obj_HV_item6[i].checked == true){
			disableTableCheckBox1(obj_HV_item6 , true , "无此项服务");
			obj_item6.value = "无此项服务";
			break;
		}else if(obj_HV_item6[i].value == "无此项服务" && obj_HV_item6[i].checked == false){
			disableTableCheckBox1(obj_HV_item6 , false , "无此项服务");
//			obj_item6.value = "";
			break;
		}
	}
}

/*
* 功能： 金融服务当选择 无此项服务 时其他多选项不可选
* 配置：个人网上银行#支付结算业务#项目
*/
function checkHV_item8(obj){
	var obj_item8 = getTableFormObjs(label_HV_item8)[0];
	var obj_HV_item8 = getTableFormCheckBox(label_HV_item8 , obj_item8.rownumber);
	for(var i = 0; i < obj_HV_item8.length; i++){
		if(obj_HV_item8[i].value == "无此项业务" && obj_HV_item8[i].checked == true){
			disableTableCheckBox1(obj_HV_item8 , true , "无此项业务");
			obj_item8.value = "无此项业务";
			break;
		}else if(obj_HV_item8[i].value == "无此项业务" && obj_HV_item8[i].checked == false){
			disableTableCheckBox1(obj_HV_item8 , false , "无此项业务");
//			obj_item8.value = "";
			break;
		}
	}
}

/*
* 功能： 金融服务当选择 无此项服务 时其他多选项不可选
* 配置：个人网上银行#理财业务#内容
*/
function checkHV_item10(obj){
	var obj_item10 = getTableFormObjs(label_HV_item10)[0];
	var obj_HV_item10 = getTableFormCheckBox(label_HV_item10 , obj_item10.rownumber);
	for(var i = 0; i < obj_HV_item10.length; i++){
		if(obj_HV_item10[i].value == "无此项业务" && obj_HV_item10[i].checked == true){
			disableTableCheckBox1(obj_HV_item10 , true , "无此项业务");
			obj_item10.value = "无此项业务";
			break;
		}else if(obj_HV_item10[i].value == "无此项业务" && obj_HV_item10[i].checked == false){
			disableTableCheckBox1(obj_HV_item10 , false , "无此项业务");
//			obj_item10.value = "";
			break;
		}
	}
}

/*
* 功能：是否开办， 选择否的时候 同格多选不可选
* 配置：企业网上银行#是否开办#内容
*/
function checkRadio_COL44(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL44 = getTableFormObjs(label_RadioButtonList_COL44)[0];
	var obj_HV_item12 = getTableFormCheckBox(label_HV_item12, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item14 = getTableFormCheckBox(label_HV_item14, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item16 = getTableFormCheckBox(label_HV_item16, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item18 = getTableFormCheckBox(label_HV_item18, obj_RadioButtonList_COL44.rownumber);
	
	if(obj_RadioButtonList_COL44.value == "否"){
		disableTableCheckBox(obj_HV_item12 , true);
		disableTableCheckBox(obj_HV_item14 , true);
		disableTableCheckBox(obj_HV_item16 , true);
		disableTableCheckBox(obj_HV_item18 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item12 , false);
		disableTableCheckBoxs(obj_HV_item14 , false);
		disableTableCheckBoxs(obj_HV_item16 , false);
		disableTableCheckBoxs(obj_HV_item18 , false);
	}
}

/*
* 功能： 金融服务当选择 无此项服务 时其他多选项不可选
* 配置：企业网上银行#金融服务#内容
*/
function checkHV_item12(obj){
	var obj_item12 = getTableFormObjs(label_HV_item12)[0];
	var obj_HV_item12 = getTableFormCheckBox(label_HV_item12 , obj_item12.rownumber);
	for(var i = 0; i < obj_HV_item12.length; i++){
		if(obj_HV_item12[i].value == "无此项服务" && obj_HV_item12[i].checked == true){
			disableTableCheckBox1(obj_HV_item12 , true , "无此项服务");
			obj_item12.value = "无此项服务";
			break;
		}else if(obj_HV_item12[i].value == "无此项服务" && obj_HV_item12[i].checked == false){
			disableTableCheckBox1(obj_HV_item12 , false , "无此项服务");
//			obj_item12.value = "";
			break;
		}
	}
}

/*
* 功能： 支付结算业务当选择 无此项服务 时其他多选项不可选
* 配置：企业网上银行#支付结算业务#内容
*/
function checkHV_item14(obj){
	var obj_item14 = getTableFormObjs(label_HV_item14)[0];
	var obj_HV_item14 = getTableFormCheckBox(label_HV_item14 , obj_item14.rownumber);
	for(var i = 0; i < obj_HV_item14.length; i++){
		if(obj_HV_item14[i].value == "无此项业务" && obj_HV_item14[i].checked == true){
			disableTableCheckBox1(obj_HV_item14 , true , "无此项业务");
			obj_item14.value = "无此项业务";
			break;
		}else if(obj_HV_item14[i].value == "无此项业务" && obj_HV_item14[i].checked == false){
			disableTableCheckBox1(obj_HV_item14 , false , "无此项业务");
//			obj_item14.value = "";
			break;
		}
	}
}

/*
* 功能： 银企直连当选择 无此项服务 时其他多选项不可选
* 配置：企业网上银行#银企直连#内容
*/
function checkHV_item16(obj){
	var obj_item16 = getTableFormObjs(label_HV_item16)[0];
	var obj_HV_item16 = getTableFormCheckBox(label_HV_item16 , obj_item16.rownumber);
	for(var i = 0; i < obj_HV_item16.length; i++){
		if(obj_HV_item16[i].value == "无此项服务" && obj_HV_item16[i].checked == true){
			disableTableCheckBox1(obj_HV_item16 , true , "无此项服务");
			obj_item16.value = "无此项服务";
			break;
		}else if(obj_HV_item16[i].value == "无此项服务" && obj_HV_item16[i].checked == false){
			disableTableCheckBox1(obj_HV_item16 , false , "无此项服务");
//			obj_item16.value = "";
			break;
		}
	}
}

/*
* 功能：理财业务当选择 无此项服务 时其他多选项不可选
* 配置：企业网上银行#理财业务#内容
*/
function checkHV_item18(obj){
	var obj_item18 = getTableFormObjs(label_HV_item18)[0];
	var obj_HV_item18 = getTableFormCheckBox(label_HV_item18 , obj_item18.rownumber);
	for(var i = 0; i < obj_HV_item18.length; i++){
		if(obj_HV_item18[i].value == "无此项业务" && obj_HV_item18[i].checked == true){
			disableTableCheckBox1(obj_HV_item18 , true , "无此项业务");
			obj_item18.value = "无此项业务";
			break;
		}else if(obj_HV_item18[i].value == "无此项业务" && obj_HV_item18[i].checked == false){
			disableTableCheckBox1(obj_HV_item18 , false , "无此项业务");
//			obj_item18.vlaue = "";
			break;
		}
	}
}

/*
* 功能：是否开办， 选择否的时候 同格多选不可选
* 配置：自助银行#是否开办#内容
*/
function checkRadio_COL45(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL45 = getTableFormObjs(label_RadioButtonList_COL45)[0];
	var obj_HV_item20 = getTableFormCheckBox(label_HV_item20, obj_RadioButtonList_COL45.rownumber);
	
	if(obj_RadioButtonList_COL45.value == "否"){
		disableTableCheckBox(obj_HV_item20 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item20 , false);
	}
}

/*
* 功能：业务品种 当选择 无此项服务 时其他多选项不可选
* 配置：自助银行#业务品种#内容
*/
function checkHV_item20(obj){
	//var target = getTarget(obj.parentElement);
	var obj_item20 = getTableFormObjs(label_HV_item20)[0];
	var obj_HV_item20 = getTableFormCheckBox(label_HV_item20 , obj_item20.rownumber);
	for(var i = 0; i < obj_HV_item20.length; i++){
		if(obj_HV_item20[i].value == "无此项业务" && obj_HV_item20[i].checked == true){
			disableTableCheckBox1(obj_HV_item20 , true , "无此项业务") ;
			obj_item20.value = "无此项业务";
			break;
		}else if(obj_HV_item20[i].value == "无此项业务" && obj_HV_item20[i].checked == false){
			disableTableCheckBox1(obj_HV_item20 , false , "无此项业务");
//			obj_item20.value = "";
			break;
		}
	}
}

/*
* 功能：是否开办， 选择否的时候 同格多选不可选
* 配置：电话银行#是否开办#内容
*/
function checkRadio_COL46(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL46 = getTableFormObjs(label_RadioButtonList_COL46)[0];
	var obj_HV_item22 = getTableFormCheckBox(label_HV_item22, obj_RadioButtonList_COL46.rownumber);
	var obj_HV_item24 = getTableFormCheckBox(label_HV_item24, obj_RadioButtonList_COL46.rownumber);
	var obj_HV_item26 = getTableFormCheckBox(label_HV_item26, obj_RadioButtonList_COL46.rownumber);
	
	if(obj_RadioButtonList_COL46.value == "否"){
		disableTableCheckBox(obj_HV_item22 , true);
		disableTableCheckBox(obj_HV_item24 , true);
		disableTableCheckBox(obj_HV_item26 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item22 , false);
		disableTableCheckBoxs(obj_HV_item24 , false);
		disableTableCheckBoxs(obj_HV_item26 , false);
	}
}

/*
* 功能：金融服务 当选择 无此项服务 时其他多选项不可选
* 配置：自助银行#金融服务#内容
*/
function checkHV_item22(obj){
	var obj_item22 = getTableFormObjs(label_HV_item22)[0];
	var obj_HV_item22 = getTableFormCheckBox(label_HV_item22 , obj_item22.rownumber);
	for(var i = 0; i < obj_HV_item22.length; i++){
		if(obj_HV_item22[i].value == "无此项服务" && obj_HV_item22[i].checked == true){
			disableTableCheckBox1(obj_HV_item22 , true , "无此项服务");
			obj_item22.value = "无此项服务";
			break;
		}else if(obj_HV_item22[i].value == "无此项服务" && obj_HV_item22[i].checked == false){
			disableTableCheckBox1(obj_HV_item22 , false , "无此项服务");
//			obj_item22.value = "";
			break;
		}
	}
}

/*
* 功能：支付结算业务 当选择 无此项服务 时其他多选项不可选
* 配置：自助银行#支付结算业务#内容
*/
function checkHV_item24(obj){
	var obj_item24 = getTableFormObjs(label_HV_item24)[0];
	var obj_HV_item24 = getTableFormCheckBox(label_HV_item24 , obj_item24.rownumber);
	for(var i = 0; i < obj_HV_item24.length; i++){
		if(obj_HV_item24[i].value == "无此项业务" && obj_HV_item24[i].checked == true){
			disableTableCheckBox1(obj_HV_item24 , true , "无此项业务");
			obj_item24.value = "无此项业务";
			break;
		}else if(obj_HV_item24[i].value == "无此项业务" && obj_HV_item24[i].checked == false){
			disableTableCheckBox1(obj_HV_item24 , false , "无此项业务");
//			obj_item24.value = "";
			break;
		}
	}
}

/*
* 功能：理财业务 当选择 无此项服务 时其他多选项不可选
* 配置：自助银行#理财业务#内容
*/
function checkHV_item26(obj){
	var obj_item26 = getTableFormObjs(label_HV_item26)[0];
	var obj_HV_item26 = getTableFormCheckBox(label_HV_item26 , obj_item26.rownumber);
	for(var i = 0; i < obj_HV_item26.length; i++){
		if(obj_HV_item26[i].value == "无此项业务" && obj_HV_item26[i].checked == true){
			disableTableCheckBox1(obj_HV_item26 , true , "无此项业务");
			obj_item26.value = "无此项业务";
		}else if(obj_HV_item26[i].value == "无此项业务" && obj_HV_item26[i].checked == false){
			disableTableCheckBox1(obj_HV_item26 , false , "无此项业务");
//			obj_item26.value = "";
		}
	}
}

/*
* 功能：是否开办， 选择否的时候 同格多选不可选
* 配置：手机银行#表1#内容
*/
function checkRadio_COL47(obj){
	var obj_RadioButtonList_COL47 = getTableFormObjs(label_RadioButtonList_COL47)[0];
	var obj_HV_item28 = getTableFormCheckBox(label_HV_item28, obj_RadioButtonList_COL47.rownumber);
	var obj_HV_item30 = getTableFormCheckBox(label_HV_item30, obj_RadioButtonList_COL47.rownumber);
	var obj_HV_item32 = getTableFormCheckBox(label_HV_item32, obj_RadioButtonList_COL47.rownumber);
	
	if(obj_RadioButtonList_COL47.value == "否"){
		disableTableCheckBox(obj_HV_item28 , true);
		disableTableCheckBox(obj_HV_item30 , true);
		disableTableCheckBox(obj_HV_item32 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item28 , false);
		disableTableCheckBoxs(obj_HV_item30 , false);
		disableTableCheckBoxs(obj_HV_item32 , false);
	}
}
/*
* 功能：金融服务 当选择 无此项服务 时其他多选项不可选
* 配置：手机银行#表2#内容
*/
function checkHV_item28(obj){
	var obj_item28 = getTableFormObjs(label_HV_item28)[0];
	var obj_HV_item28 = getTableFormCheckBox(label_HV_item28 , obj_item28.rownumber);
	for(var i = 0; i < obj_HV_item28.length; i++){
		if(obj_HV_item28[i].value == "无此项服务" && obj_HV_item28[i].checked == true){
			disableTableCheckBox1(obj_HV_item28 , true , "无此项服务");
			obj_item28.value = "无此项服务";
			break;
		}else if(obj_HV_item28[i].value == "无此项服务" && obj_HV_item28[i].checked == false){
			disableTableCheckBox1(obj_HV_item28 , false , "无此项服务");
//			obj_item28.value = "";
			break;
		}
	}
}

/*
* 功能：支付结算业务 当选择 无此项服务 时其他多选项不可选
* 配置：手机银行#表3#内容
*/
function checkHV_item30(obj){
	var obj_item30 = getTableFormObjs(label_HV_item30)[0];
	var obj_HV_item30 = getTableFormCheckBox(label_HV_item30 , obj_item30.rownumber);
	for(var i = 0; i < obj_HV_item30.length; i++){
		if(obj_HV_item30[i].value == "无此项业务" && obj_HV_item30[i].checked == true){
			disableTableCheckBox1(obj_HV_item30 , true , "无此项业务");
			obj_item30.value = "无此项业务";
			break;
		}else if(obj_HV_item30[i].value == "无此项业务" && obj_HV_item30[i].checked == false){
			disableTableCheckBox1(obj_HV_item30 , false , "无此项业务");
//			obj_item30.value = "";
			break;
		}
	}
}

/*
* 功能：理财业务 当选择 无此项服务 时其他多选项不可选
* 配置：手机银行#表4#内容
*/
function checkHV_item32(obj){
	var obj_item32 = getTableFormObjs(label_HV_item32)[0];
	var obj_HV_item32 = getTableFormCheckBox(label_HV_item32 , obj_item32.rownumber);
	for(var i = 0; i < obj_HV_item32.length; i++){
		if(obj_HV_item32[i].value == "无此项业务" && obj_HV_item32[i].checked == true){
			disableTableCheckBox1(obj_HV_item32 , true , "无此项业务");
			obj_item32.value = "无此项业务";
			break;
		}else if(obj_HV_item32[i].value == "无此项业务" && obj_HV_item32[i].checked == false){
			disableTableCheckBox1(obj_HV_item32 , false , "无此项业务");
//			obj_item32.value = "";
			break;
		}
	}
}

/*
* 功能：当选择 无此项服务 时其他多选项不可选
* 参数：objs 为所有复选框对象集合
* 	  flag 为设置不可选标识，true时除str复选框别的不可选，false反之
* 	  str  可选值（其他选项不可选）
*/
function disableTableCheckBox1(objs,flag,str){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(flag && objs[i].value != str){
				objs[i].disabled = flag;
				objs[i].checked = false;
				//清空“其他”并设置为只读
				var showvalue = getShowTarget(objs[i].parentElement);
				showvalue.value = "";
				showvalue.style.display="none";
			}else if(!flag && objs[i].value != str ){
				objs[i].disabled = flag;
//				objs[i].checked = false;
			}
		}
	}
}

/*
* 功能：当选择 是否开办 时其他多选项不可选/可选
*/
function disableTableCheckBoxs(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = "";
			}
		}
		//如果选择了 无此项服务 其他多选项仍然不可选
		if(objs[0].checked == true){
			disableTableCheckBox1(objs,true,objs[0].value);
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
	
	var obj_RadioButtonList_COL43 = getTableFormObjs(label_RadioButtonList_COL43)[0];
	var obj_RadioButtonList_COL44 = getTableFormObjs(label_RadioButtonList_COL44)[0];
	var obj_RadioButtonList_COL45 = getTableFormObjs(label_RadioButtonList_COL45)[0];
	var obj_RadioButtonList_COL46 = getTableFormObjs(label_RadioButtonList_COL46)[0];
	var obj_RadioButtonList_COL47 = getTableFormObjs(label_RadioButtonList_COL47)[0];
	if(obj_RadioButtonList_COL43.value == "是"){
		var obj_HV_item6 = getTableFormObj(label_HV_item6, obj_RadioButtonList_COL43.rownumber);
		var obj_HV_item8 = getTableFormObj(label_HV_item8, obj_RadioButtonList_COL43.rownumber);
		var obj_HV_item10 = getTableFormObj(label_HV_item10, obj_RadioButtonList_COL43.rownumber);
		if(obj_HV_item6.value == ""){
			errorObjs.push(obj_HV_item6.parentElement);
			a+="个人网上银行：金融服务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item8.value == ""){
			errorObjs.push(obj_HV_item8.parentElement);
			a+="个人网上银行：支付结算业务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item10.value == ""){
			errorObjs.push(obj_HV_item10.parentElement);
			a+="个人网上银行：理财业务不能为空！\n";
			isValid=false;
		}
	}
	if(obj_RadioButtonList_COL44.value == "是"){
		var obj_HV_item12 = getTableFormObj(label_HV_item12, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item14 = getTableFormObj(label_HV_item14, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item16 = getTableFormObj(label_HV_item16, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item18 = getTableFormObj(label_HV_item18, obj_RadioButtonList_COL44.rownumber);
		if(obj_HV_item12.value == ""){
			errorObjs.push(obj_HV_item12.parentElement);
			a+="企业网上银行：金融服务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item14.value == ""){
			errorObjs.push(obj_HV_item14.parentElement);
			a+="企业网上银行：支付结算业务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item16.value == ""){
			errorObjs.push(obj_HV_item16.parentElement);
			a+="企业网上银行：银企直联不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item18.value == ""){
			errorObjs.push(obj_HV_item18.parentElement);
			a+="企业网上银行：理财业务不能为空！\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL45.value == "是"){
		var obj_HV_item20 = getTableFormObj(label_HV_item20, obj_RadioButtonList_COL45.rownumber);
		if(obj_HV_item20.value == ""){
			errorObjs.push(obj_HV_item20.parentElement);
			a+="自助银行：业务品种不能为空！\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL46.value == "是"){
		var obj_HV_item22 = getTableFormObj(label_HV_item22, obj_RadioButtonList_COL46.rownumber);
		var obj_HV_item24 = getTableFormObj(label_HV_item24, obj_RadioButtonList_COL46.rownumber);
		var obj_HV_item26 = getTableFormObj(label_HV_item26, obj_RadioButtonList_COL46.rownumber);
		if(obj_HV_item22.value == ""){
			errorObjs.push(obj_HV_item22.parentElement);
			a+="电话银行：金融服务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item24.value == ""){
			errorObjs.push(obj_HV_item24.parentElement);
			a+="电话银行：支付结算业务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item26.value == ""){
			errorObjs.push(obj_HV_item26.parentElement);
			a+="电话银行：理财业务不能为空！\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL47.value == "是"){
		var obj_HV_item28 = getTableFormObj(label_HV_item28, obj_RadioButtonList_COL47.rownumber);
		var obj_HV_item30 = getTableFormObj(label_HV_item30, obj_RadioButtonList_COL47.rownumber);
		var obj_HV_item32 = getTableFormObj(label_HV_item32, obj_RadioButtonList_COL47.rownumber);
		if(obj_HV_item28.value == ""){
			errorObjs.push(obj_HV_item28.parentElement);
			a+="手机银行：金融服务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item30.value == ""){
			errorObjs.push(obj_HV_item30.parentElement);
			a+="手机银行：支付结算业务不能为空！\n";
			isValid=false;
		}
		if(obj_HV_item32.value == ""){
			errorObjs.push(obj_HV_item32.parentElement);
			a+="手机银行：理财业务不能为空！\n";
			isValid=false;
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