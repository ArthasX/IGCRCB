var jq = jQuery.noConflict();

function checkPapers(obj){
	var typeObj = getTableFormObj("进入人员信息#证件类型",obj.getAttribute("rownumber"));
	var cardNo = obj.value;
	
	var flag = false;
	var message = "";
	if(!typeObj.value && obj.value){
		alert("请选择证件类型！");
		obj.value = "";
		typeObj.focus();
	}
	if (typeObj.value == "身份证") {
		if (cardNo && !isCardNo(cardNo)) {
			flag = true;
			message = "身份证格式不正确！";
		}
	}
	if (typeObj.value == "护照") {
		if (cardNo && !checkPassport(cardNo)) {
			flag = true;
			message = "护照格式不正确！";
		}
	}
	
	if(flag){
		alert(message);
		obj.value = "";
		obj.focus();
	}
}

//验证护照是否正确
function checkPassport(number) {
	var str = number;
	//在JavaScript中，正则表达式只能使用"/"开头和结束，不能使用双引号
	//护照号码的格式：
	//因私普通护照号码格式有:14/15+7位数,G+8位数；因公普通的是:P.+7位数；
	//公务的是：S.+7位数 或者 S+8位数,以D开头的是外交护照.D=diplomatic
	var Expression = /^1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|D[0-9]+$/;
	var objExp = new RegExp(Expression);
	return objExp.test(str);
}

function isCardNo(card) {
	// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	return reg.test(card);
}

function checkContactInfo(obj) {
	var contactObj = getTableFormObj("进入人员信息#联系方式",obj.getAttribute("rownumber"));
  	var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678 
  	var mob=/^(((1[0-9]{1}[0-9]{1}))+\d{8})$/;
	if (contactObj.value&&!tel.test(contactObj.value)&&!mob.test(contactObj.value)) {
		alert("请填写正确格式的联系方式！");
		contactObj.value = "";
		contactObj.focus();
		return;

	}
}

