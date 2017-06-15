/*
 * 报表：2014-T-Q-1 电子银行业务统计表——报表填报
 */
// 校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
//var valueMap;
//var countFlag = 0;
var tdArr = jQuery("td");
for ( var i = 0; i < tdArr.length; i++) {
	if (jQuery(tdArr[i]).width() > 460) {
		jQuery(tdArr[i]).width("");
	}

}
// 主要电子交易笔数
// ATM
var label_03_01_01_01 = "主要电子交易笔数#ATM#本行#1#数量";
var label_03_01_01_02 = "主要电子交易笔数#ATM#本行#2#数量";
var label_03_01_01_03 = "主要电子交易笔数#ATM#本行#3#数量";

var label_03_01_02_01 = "主要电子交易笔数#ATM#他代本#1#数量";
var label_03_01_02_02 = "主要电子交易笔数#ATM#他代本#2#数量";
var label_03_01_02_03 = "主要电子交易笔数#ATM#他代本#3#数量";

var label_03_01_03_01 = "主要电子交易笔数#ATM#本代他#1#数量";
var label_03_01_03_02 = "主要电子交易笔数#ATM#本代他#2#数量";
var label_03_01_03_03 = "主要电子交易笔数#ATM#本代他#3#数量";

// pos
var label_03_02_01_01 = "主要电子交易笔数#POS#本行#1#数量";
var label_03_02_02_01 = "主要电子交易笔数#POS#他代本#1#数量";
var label_03_02_03_01 = "主要电子交易笔数#POS#本代他#1#数量";

// 网上银行
var label_03_03_01_01 = "主要电子交易笔数#网上银行#个人网上银行#1#数量";
var label_03_03_01_02 = "主要电子交易笔数#网上银行#个人网上银行#2#数量";
var label_03_03_01_03 = "主要电子交易笔数#网上银行#个人网上银行#3#数量";

var label_03_03_02_01 = "主要电子交易笔数#网上银行#企业网上银行#1#数量";
var label_03_03_02_02 = "主要电子交易笔数#网上银行#企业网上银行#2#数量";
var label_03_03_02_03 = "主要电子交易笔数#网上银行#企业网上银行#3#数量";

// 电话银行
var label_03_03_01 = "主要电子交易笔数#电话银行#1#数量";
var label_03_03_02 = "主要电子交易笔数#电话银行#2#数量";
var label_03_03_03 = "主要电子交易笔数#电话银行#3#数量";

// 手机银行
var label_03_04_01 = "主要电子交易笔数#手机银行#1#数量";
var label_03_04_02 = "主要电子交易笔数#手机银行#2#数量";
var label_03_04_03 = "主要电子交易笔数#手机银行#3#数量";

// 其他电子银行业务
var label_03_05_01 = "主要电子交易笔数#其他电子银行业务#1#数量";
var label_03_05_02 = "主要电子交易笔数#其他电子银行业务#2#数量";
var label_03_05_03 = "主要电子交易笔数#其他电子银行业务#3#数量";

// 合计
var label_03_06_01 = "主要电子交易笔数#合计#1#数量";

// 主要电子交易金额
// ATM
var label_04_01_01 = "主要电子交易金额#ATM#本行#1#数量";
var label_04_01_02 = "主要电子交易金额#ATM#他代本#1#数量";
var label_04_01_03 = "主要电子交易金额#ATM#本代他#1#数量";

// POS
var label_04_02_01 = "主要电子交易金额#POS#本行#1#数量";
var label_04_02_02 = "主要电子交易金额#POS#他代本#1#数量";
var label_04_02_03 = "主要电子交易金额#POS#本代他#1#数量";

// 网上银行
var label_04_03_01 = "主要电子交易金额#网上银行#个人网上银行#1#数量";
var label_04_03_02 = "主要电子交易金额#网上银行#企业网上银行#1#数量";

// 电话银行
var label_04_04_01 = "主要电子交易金额#电话银行#1#数量";

// 手机银行
var label_04_05_01 = "主要电子交易金额#手机银行#1#数量";

// 其他电子银行业务
var label_04_06_01 = "主要电子交易金额#其他电子银行业务#1#数量";

// 合计
var label_04_07_01 = "主要电子交易金额#合计#1#数量";

// 主要电子交易替代率
var label_05_01 = "主要电子交易替代率#1#数量";
var label_05_02 = "主要电子交易替代率#2#数量";
var label_05_03 = "主要电子交易替代率#3#数量";
var label_05_04 = "主要电子交易替代率#4#数量";
var label_05_05 = "主要电子交易替代率#5#数量";
var label_05_06 = "主要电子交易替代率#6#数量";
var label_05_07 = "主要电子交易替代率#7#数量";
var label_05_08 = "主要电子交易替代率#8#数量";

/*
 * 功能：提交校验
 * 
 */
function checkData() {
	// 清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	// 校验复选中其他是否有值
	for ( var i = 0; i < checkBoxValueObjs.length; i++) {
		var checkBoxObj = checkBoxValueObjs[i];
		if (checkBoxObj.checked) {
			var checkBoxObjValueObj = checkBoxObj.parentElement.nextSibling.nextSibling;
			if (checkBoxObjValueObj.value.indexOf("_cev_") < 0) {
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a += "其他项内容不能为空！\n";
				isValid = false;
			}
		}
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("其他") > -1) {
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

/*
 * 功能：主要电子交易笔数其他电子银行业务小计计算
 * 
 */
function setObj_04_07_01Value(obj) {
	var value1 = 0;
	var value2 = 0;
	var value3 = 0;
	var value4 = 0;
	var value5 = 0;
	var value6 = 0;
	var value7 = 0;
	var value8 = 0;
	var value9 = 0;
	var value10 = 0;
	var value11 = 0;
	var obj_04_01_01 = getTableFormObjs(label_04_01_01)[0];
	var obj_04_01_02 = getTableFormObjs(label_04_01_02)[0];
	var obj_04_01_03 = getTableFormObjs(label_04_01_03)[0];
	var obj_04_02_01 = getTableFormObjs(label_04_02_01)[0];
	var obj_04_02_02 = getTableFormObjs(label_04_02_02)[0];
	var obj_04_02_03 = getTableFormObjs(label_04_02_03)[0];
	var obj_04_03_01 = getTableFormObjs(label_04_03_01)[0];
	var obj_04_03_02 = getTableFormObjs(label_04_03_02)[0];
	var obj_04_04_01 = getTableFormObjs(label_04_04_01)[0];
	var obj_04_05_01 = getTableFormObjs(label_04_05_01)[0];
	var obj_04_06_01 = getTableFormObjs(label_04_06_01)[0];
	var obj_04_07_01 = getTableFormObjs(label_04_07_01)[0];
	if (obj_04_01_01.value != "") {
		value1 = obj_04_01_01.value;
//		computeValue(obj_04_01_01);
	}
	if (obj_04_01_02.value != "") {
		value2 = obj_04_01_02.value;
//		computeValue(obj_04_01_02);
	}
	if (obj_04_01_03.value != "") {
		value3 = obj_04_01_03.value;
//		computeValue(obj_04_01_03);
	}
	if (obj_04_02_01.value != "") {
		value4 = obj_04_02_01.value;
//		computeValue(obj_04_02_01);
	}
	if (obj_04_02_02.value != "") {
		value5 = obj_04_02_02.value;
//		computeValue(obj_04_02_02);
	}
	if (obj_04_02_03.value != "") {
		value6 = obj_04_02_03.value;
//		computeValue(obj_04_02_03);
	}
	if (obj_04_03_01.value != "") {
		value7 = obj_04_03_01.value;
//		computeValue(obj_04_03_01);
	}
	if (obj_04_03_02.value != "") {
		value8 = obj_04_03_02.value;
//		computeValue(obj_04_03_02);
	}
	if (obj_04_04_01.value != "") {
		value9 = obj_04_04_01.value;
//		computeValue(obj_04_04_01);
	}
	if (obj_04_05_01.value != "") {
		value10 = obj_04_05_01.value;
//		computeValue(obj_04_05_01);
	}
	if (obj_04_06_01.value != "") {
		value11 = obj_04_06_01.value;
//		computeValue(obj_04_06_01);
	}
	obj_04_07_01.value = (parseFloat(value1)*100 + parseFloat(value2)*100
			+ parseFloat(value3)*100 + parseFloat(value4)*100 + parseFloat(value5)*100
			+ parseFloat(value6)*100 + parseFloat(value7)*100 + parseFloat(value8)*100
			+ parseFloat(value9)*100 + parseFloat(value10)*100 + parseFloat(value11)*100)/100;
//	computeValue(obj_04_07_01);
	setObj_05_04Value();
}
/*
 * 功能：通过全行所有交易金额来更改主要电子交易金额替代率
 * 
 */
function setObj_05_04Value(obj) {
	var obj_04_07_01 = getTableFormObjs(label_04_07_01)[0];
	var obj_05_02 = getTableFormObjs(label_05_02)[0];
	var obj_05_04 = getTableFormObjs(label_05_04)[0];
	if (obj_04_07_01.value != "") {
		if (obj_05_02.value != "") {
			obj_05_04.value = checkNumberFloat(parseFloat(obj_04_07_01.value)
					* 100 / parseFloat(obj_05_02.value), 2);
//			computeValue(obj_05_02);
//			computeValue(obj_05_04);
		}
	}
	setObj_05_06Value();
	setObj_05_08Value();
}
/*
 * 功能：主要电子交易笔数其他电子银行业务小计计算
 * 
 */
function setObj_03_05_01Value(obj) {
	var obj_03_05_01 = getTableFormObjs(label_03_05_01)[0];
	var obj_03_05_02 = getTableFormObjs(label_03_05_02)[0];
	var obj_03_05_03 = getTableFormObjs(label_03_05_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_05_01.value != "") {
		value1 = obj_03_05_01.value;
//		computeValue(obj_03_05_01);
	}
	if (obj_03_05_02.value != "") {
		value2 = obj_03_05_02.value;
//		computeValue(obj_03_05_02);
	}
	obj_03_05_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_05_03);
	setAllCount();

}

/*
 * 功能：主要电子交易笔数手机银行小计计算
 * 
 */
function setObj_03_04_01Value(obj) {
	var obj_03_04_01 = getTableFormObjs(label_03_04_01)[0];
	var obj_03_04_02 = getTableFormObjs(label_03_04_02)[0];
	var obj_03_04_03 = getTableFormObjs(label_03_04_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_04_01.value != "") {
		value1 = obj_03_04_01.value;
//		computeValue(obj_03_04_01);
	}
	if (obj_03_04_02.value != "") {
		value2 = obj_03_04_02.value;
//		computeValue(obj_03_04_02);
	}
	obj_03_04_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_04_03);
	setAllCount();

}
/*
 * 功能：计算主要电子交易替代率的手机银行交易笔数替代率
 * 
 */
function setObj_05_07Value(obj) {
	var obj_03_04_03 = getTableFormObjs(label_03_04_03)[0];
	var obj_05_01 = getTableFormObjs(label_05_01)[0];
	var obj_05_07 = getTableFormObjs(label_05_07)[0];
	if (obj_03_04_03.value != "" && obj_05_01.value != "") {
		obj_05_07.value = checkNumberFloat(parseFloat(obj_03_04_03.value) * 100
				/ parseFloat(obj_05_01.value), 2);
//		computeValue(obj_05_07);
	}
	
}
/*
 * 功能：主要电子交易笔数电话银行小计计算
 * 
 */
function setObj_03_03_03Value(obj) {
	var obj_03_03_01 = getTableFormObjs(label_03_03_01)[0];
	var obj_03_03_02 = getTableFormObjs(label_03_03_02)[0];
	var obj_03_03_03 = getTableFormObjs(label_03_03_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_03_01.value != "") {
		value1 = obj_03_03_01.value;
//		computeValue(obj_03_03_01);
	}
	if (obj_03_03_02.value != "") {
		value2 = obj_03_03_02.value;
//		computeValue(obj_03_03_02);
	}
	obj_03_03_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_03_03);
	setAllCount();

}

/*
 * 功能：主要电子交易笔数网上银行企业网上银行小计计算
 * 
 */
function setObj_03_03_02_03Value(obj) {
	var obj_03_03_02_01 = getTableFormObjs(label_03_03_02_01)[0];
	var obj_03_03_02_02 = getTableFormObjs(label_03_03_02_02)[0];
	var obj_03_03_02_03 = getTableFormObjs(label_03_03_02_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_03_02_01.value != "") {
		value1 = obj_03_03_02_01.value;
//		computeValue(obj_03_03_02_01);
	}
	if (obj_03_03_02_02.value != "") {
		value2 = obj_03_03_02_02.value;
//		computeValue(obj_03_03_02_02);
	}
	obj_03_03_02_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_03_02_03);
	setAllCount();
	setObj_05_05Value();
}
/*
 * 功能：计算主要电子交易替代率的网上银行交易笔数替代率
 * 
 */
function setObj_05_05Value(obj) {
	var obj_03_03_01_03 = getTableFormObjs(label_03_03_01_03)[0];
	var obj_03_03_02_03 = getTableFormObjs(label_03_03_02_03)[0];
	var obj_05_01 = getTableFormObjs(label_05_01)[0];
	var obj_05_05 = getTableFormObjs(label_05_05)[0];
	var value1 = 0;
	var value2 = 0;
	if ((obj_03_03_01_03.value != "" || obj_03_03_02_03.value != "")
			&& obj_05_01.value != "") {
		if (obj_03_03_01_03.value != "") {
			value1 = obj_03_03_01_03.value;
		}
		if (obj_03_03_02_03.value != "") {
			value2 = obj_03_03_02_03.value;
		}
		obj_05_05.value = checkNumberFloat(
				(parseFloat(value1) + parseFloat(value2)) * 100
						/ parseFloat(obj_05_01.value), 2);
//		computeValue(obj_05_05);
	}
}

/*
 * 功能：主要电子交易笔数网上银行个人网上银行小计计算
 * 
 */
function setObj_03_03_01_03Value(obj) {
	var obj_03_03_01_01 = getTableFormObjs(label_03_03_01_01)[0];
	var obj_03_03_01_02 = getTableFormObjs(label_03_03_01_02)[0];
	var obj_03_03_01_03 = getTableFormObjs(label_03_03_01_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_03_01_01.value != "") {
		value1 = obj_03_03_01_01.value;
//		computeValue(obj_03_03_01_01);
	}
	if (obj_03_03_01_02.value != "") {
		value2 = obj_03_03_01_02.value;
//		computeValue(obj_03_03_01_02);
	}
	obj_03_03_01_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_03_01_03);
	setAllCount();
	setObj_05_05Value();

}

/*
 * 功能：主要电子交易笔数pos小计计算
 * 
 */
function setObj_03_02_03_01Value(obj) {
//	var obj_03_02_01_01 = getTableFormObjs(label_03_02_01_01)[0];
//	var obj_03_02_02_01 = getTableFormObjs(label_03_02_02_01)[0];
//	var obj_03_02_03_01 = getTableFormObjs(label_03_02_03_01)[0];
//	var value1 = 0;
//	var value2 = 0;
//	if (obj_03_02_01_01.value != "") {
//		value1 = obj_03_02_01_01.value;
//		computeValue(obj_03_02_01_01);
//	}
//	if (obj_03_02_02_01.value != "") {
//		value2 = obj_03_02_02_01.value;
////		computeValue(obj_03_02_02_01);
//	}
//	obj_03_02_03_01.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_02_03_01);
	setAllCount();
}

/*
 * 功能：主要电子交易笔数ATM本代他小计计算
 * 
 */
function setObj_03_01_03_03Value(obj) {
	var obj_03_01_03_01 = getTableFormObjs(label_03_01_03_01)[0];
	var obj_03_01_03_02 = getTableFormObjs(label_03_01_03_02)[0];
	var obj_03_01_03_03 = getTableFormObjs(label_03_01_03_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_01_03_01.value != "") {
		value1 = obj_03_01_03_01.value;
//		computeValue(obj_03_01_03_01);
	}
	if (obj_03_01_03_02.value != "") {
		value2 = obj_03_01_03_02.value;
//		computeValue(obj_03_01_03_02);
	}
	obj_03_01_03_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_01_03_03);
	setAllCount();

}

/*
 * 功能：主要电子交易笔数ATM他代本小计计算
 * 
 */
function setObj_03_01_02_03Value(obj) {
	var obj_03_01_02_01 = getTableFormObjs(label_03_01_02_01)[0];
	var obj_03_01_02_02 = getTableFormObjs(label_03_01_02_02)[0];
	var obj_03_01_02_03 = getTableFormObjs(label_03_01_02_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_01_02_01.value != "") {
		value1 = obj_03_01_02_01.value;
//		computeValue(obj_03_01_02_01);
	}
	if(obj_03_01_02_02.value !=""){
		value2 = obj_03_01_02_02.value;
//		computeValue(obj_03_01_02_02);
	}
	obj_03_01_02_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_01_02_03);
	setAllCount();

}

/*
 * 功能：主要电子交易笔数ATM本行小计计算
 * 
 */
function setObj_03_01_01_03Value(obj) {
	var obj_03_01_01_01 = getTableFormObjs(label_03_01_01_01)[0];
	var obj_03_01_01_02 = getTableFormObjs(label_03_01_01_02)[0];
	var obj_03_01_01_03 = getTableFormObjs(label_03_01_01_03)[0];
	var value1 = 0;
	var value2 = 0;
	if (obj_03_01_01_01.value != "") {
		value1 = obj_03_01_01_01.value;
//		computeValue(obj_03_01_01_01);
	}
	if (obj_03_01_01_02.value != "") {
		value2 = obj_03_01_01_02.value;
//		computeValue(obj_03_01_01_02);
	}
	obj_03_01_01_03.value = (parseFloat(value1)*100 + parseFloat(value2)*100)/100;
//	computeValue(obj_03_01_01_03);
	setAllCount();

}
/*
 * 功能：主要电子交易笔数ATM本行小计计算
 * 
 */
function setAllCount() {
	var value1 = 0;
	var value2 = 0;
	var value3 = 0;
	var value4 = 0;
	var value5 = 0;
	var value6 = 0;
	var value7 = 0;
	var value8 = 0;
	var value9 = 0;
	var value10 = 0;
	var value11 = 0;
	var obj_03_02_01_01 = getTableFormObjs(label_03_02_01_01)[0];
	var obj_03_02_02_01 = getTableFormObjs(label_03_02_02_01)[0];
	var obj_03_01_01_03 = getTableFormObjs(label_03_01_01_03)[0];
	var obj_03_01_02_03 = getTableFormObjs(label_03_01_02_03)[0];
	var obj_03_01_03_03 = getTableFormObjs(label_03_01_03_03)[0];
	var obj_03_02_03_01 = getTableFormObjs(label_03_02_03_01)[0];
	var obj_03_03_01_03 = getTableFormObjs(label_03_03_01_03)[0];
	var obj_03_03_02_03 = getTableFormObjs(label_03_03_02_03)[0];
	var obj_03_03_03 = getTableFormObjs(label_03_03_03)[0];
	var obj_03_04_03 = getTableFormObjs(label_03_04_03)[0];
	var obj_03_05_03 = getTableFormObjs(label_03_05_03)[0];
	var obj_03_06_01 = getTableFormObjs(label_03_06_01)[0];
	if (obj_03_01_01_03.value != "") {
		value1 = obj_03_01_01_03.value;
	}
	if (obj_03_01_02_03.value != "") {
		value2 = obj_03_01_02_03.value;
	}
	if (obj_03_01_03_03.value != "") {
		value3 = obj_03_01_03_03.value;
	}
	if (obj_03_02_03_01.value != "") {
		value4 = obj_03_02_03_01.value;
	}
	if (obj_03_03_01_03.value != "") {
		value5 = obj_03_03_01_03.value;
	}
	if (obj_03_03_02_03.value != "") {
		value6 = obj_03_03_02_03.value;
	}
	if (obj_03_03_03.value != "") {
		value7 = obj_03_03_03.value;
	}
	if (obj_03_04_03.value != "") {
		value8 = obj_03_04_03.value;
	}
	if (obj_03_05_03.value != "") {
		value9 = obj_03_05_03.value;
	}
	if(obj_03_02_01_01.value != ""){
		value10 = obj_03_02_01_01.value;
	}
	if(obj_03_02_02_01.value != ""){
		value11 = obj_03_02_02_01.value;
	}
	obj_03_06_01.value = (parseFloat(value1)*100 + parseFloat(value2)*100
			+ parseFloat(value3)*100 + parseFloat(value4)*100 + parseFloat(value5)*100
			+ parseFloat(value6)*100 + parseFloat(value7)*100 + parseFloat(value8)*100
			+ parseFloat(value9)*100 + parseFloat(value10)*100 + parseFloat(value11)*100)/100;
	setObj_05_03Value();

}
/*
 * 功能：主要电子交易替代率的计算网上银行交易金额替代率
 * 
 */
function setObj_05_06Value(obj) {
	var obj_04_03_01 = getTableFormObjs(label_04_03_01)[0];
	var obj_04_03_02 = getTableFormObjs(label_04_03_02)[0];
	var obj_05_02 = getTableFormObjs(label_05_02)[0];
	var obj_05_06 = getTableFormObjs(label_05_06)[0];
	if ((obj_04_03_01.value != "" || obj_04_03_02.value != "")
			&& obj_05_02.value != "") {
		var value1 = 0;
		var value2 = 0;
		if (obj_04_03_01.value != "") {
			value1 = obj_04_03_01.value;
//			computeValue(obj_04_03_01);
		}
		if (obj_04_03_02.value != "") {
			value2 = obj_04_03_02.value;
//			computeValue(obj_04_03_02);
		}
		obj_05_06.value = checkNumberFloat(
				(parseFloat(value1) + parseFloat(value2)) * 100
						/ parseFloat(obj_05_02.value), 2);
//		computeValue(obj_05_06);
	}
}
/*
 * 功能：主要电子交易替代率的手机银行交易金额替代率
 * 
 */
function setObj_05_08Value(obj) {
	var obj_04_05_01 = getTableFormObjs(label_04_05_01)[0];
	var obj_05_02 = getTableFormObjs(label_05_02)[0];
	var obj_05_08 = getTableFormObjs(label_05_08)[0];
	if (obj_04_05_01.value != "" && obj_05_02.value != "") {
		obj_05_08.value = checkNumberFloat(parseFloat(obj_04_05_01.value) * 100
				/ parseFloat(obj_05_02.value), 2);
//		computeValue(obj_05_08);
	}
}
/*
 * 功能：更改全行所有交易笔数的数量来计算主要电子交易笔数替代率
 * 
 */
function setObj_05_03Value(obj) {
	var obj_03_06_01 = getTableFormObjs(label_03_06_01)[0];
	var obj_05_01 = getTableFormObjs(label_05_01)[0];
	var obj_05_03 = getTableFormObjs(label_05_03)[0];
	if (obj_03_06_01.value != "") {
		if (obj_05_01.value != "") {
			obj_05_03.value = checkNumberFloat(parseFloat(obj_03_06_01.value)
					* 100 / parseFloat(obj_05_01.value), 2);
//			computeValue(obj_05_01);
//			computeValue(obj_05_03);
		}
	}
	setObj_05_05Value();
	setObj_05_07Value();
}
/*
 * 功能：初始化页面
 * 
 */
function initSet() {
	var obj_03_01_01_03 = getTableFormObjs(label_03_01_01_03)[0];
	var obj_03_01_02_03 = getTableFormObjs(label_03_01_02_03)[0];
	var obj_03_01_03_03 = getTableFormObjs(label_03_01_03_03)[0];
//	var obj_03_02_03_01 = getTableFormObjs(label_03_02_03_01)[0];
	var obj_03_03_01_03 = getTableFormObjs(label_03_03_01_03)[0];
	var obj_03_03_02_03 = getTableFormObjs(label_03_03_02_03)[0];
	var obj_03_03_03 = getTableFormObjs(label_03_03_03)[0];
	var obj_03_04_03 = getTableFormObjs(label_03_04_03)[0];
	var obj_03_05_03 = getTableFormObjs(label_03_05_03)[0];
	var obj_03_06_01 = getTableFormObjs(label_03_06_01)[0];
	var obj_04_07_01 = getTableFormObjs(label_04_07_01)[0];
	var obj_05_03 = getTableFormObjs(label_05_03)[0];
	var obj_05_04 = getTableFormObjs(label_05_04)[0];
	var obj_05_05 = getTableFormObjs(label_05_05)[0];
	var obj_05_06 = getTableFormObjs(label_05_06)[0];
	var obj_05_07 = getTableFormObjs(label_05_07)[0];
	var obj_05_08 = getTableFormObjs(label_05_08)[0];
	obj_03_01_01_03.readOnly = "readonly";
	obj_03_01_02_03.readOnly = "readonly";
	obj_03_01_03_03.readOnly = "readonly";
//	obj_03_02_03_01.readOnly = "readonly";
	obj_03_03_01_03.readOnly = "readonly";
	obj_03_03_02_03.readOnly = "readonly";
	obj_03_03_03.readOnly = "readonly";
	obj_03_04_03.readOnly = "readonly";
	obj_03_05_03.readOnly = "readonly";
	obj_03_06_01.readOnly = "readonly";
	obj_04_07_01.readOnly = "readonly";
	obj_05_03.readOnly = "readonly";
	obj_05_04.readOnly = "readonly";
	obj_05_05.readOnly = "readonly";
	obj_05_06.readOnly = "readonly";
	obj_05_07.readOnly = "readonly";
	obj_05_08.readOnly = "readonly";
	
	if(obj_05_03.value ==""){
		obj_05_03.value = 0;
	}
	if(obj_05_04.value ==""){
		obj_05_04.value = 0;
	}
	if(obj_05_05.value ==""){
		obj_05_05.value = 0;
	}
	if(obj_05_06.value ==""){
		obj_05_06.value = 0;
	}
	if(obj_05_07.value ==""){
		obj_05_07.value = 0;
	}
	if(obj_05_08.value ==""){
		obj_05_08.value = 0;
	}
}

/*
 * 功能：点击复选框复选框中的其他，将起放入数组中，在提交的时候校验其他的内容是否为空
 * 
 */
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj) {
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if (obj.checked) {
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	} else {
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for ( var i = 0; i < strs.length; i++) {
			if (strs[i].indexOf("_cev_") < 0) {
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);

	}
}



// 保留小数位数
function checkNumberFloat(obj, len) {
	return Math.round(obj * Math.pow(10, len)) / Math.pow(10, len);
}
/*
 * 初始化页面查询上期的值
 */
jQuery(function(){
	var prid = jQuery("#prid").val();
		jQuery.ajax({
			url : "IGSMR0401_Search.do",
			data : {prid:prid},
			type : "POST",
			async : true,
			dataType:"json",
			success : function(data) {
				valueMap = data;
			}
		});
});
///*
// * 计算环比方法
// */ 
//function computeValue(obj){
//	var id = obj.id;
//	var hbId = (parseInt(id.substring(0,id.indexOf("_")))+1)+"_"+obj.rownumber;
//	if(id.indexOf("468_1_1_1")>-1){
//		hbId = (parseInt(id.substring(0,id.indexOf("_")))+2)+"_"+obj.rownumber;
//	}
//	var hbObj = document.getElementById(hbId);
//	if(!jQuery.isEmptyObject(valueMap) && !jQuery.isEmptyObject(valueMap[id])){
//		if(valueMap[id] != "0" && valueMap[id] != "-"){
//			hbObj.value = checkNumberFloat((parseFloat(obj.value)*100-parseFloat(valueMap[id])*100)/parseFloat(valueMap[id]),2);
//		}else{
//			hbObj.value = "-";
//		}
//	}else{
//		if(jQuery.isEmptyObject(valueMap) && countFlag == 0){
//			alert("此季度报表没有上期数量值！");
//			countFlag = 1;
//		}else if(!jQuery.isEmptyObject(valueMap) && jQuery.isEmptyObject(valueMap[id])){
//			alert("没有此数量的上期数量!");
//		}
//	}
//}