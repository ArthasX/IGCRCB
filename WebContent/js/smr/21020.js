/*
 * ����2014-T-Q-1 ��������ҵ��ͳ�Ʊ��������
 */
// У�鰴ť
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
// ��Ҫ���ӽ��ױ���
// ATM
var label_03_01_01_01 = "��Ҫ���ӽ��ױ���#ATM#����#1#����";
var label_03_01_01_02 = "��Ҫ���ӽ��ױ���#ATM#����#2#����";
var label_03_01_01_03 = "��Ҫ���ӽ��ױ���#ATM#����#3#����";

var label_03_01_02_01 = "��Ҫ���ӽ��ױ���#ATM#������#1#����";
var label_03_01_02_02 = "��Ҫ���ӽ��ױ���#ATM#������#2#����";
var label_03_01_02_03 = "��Ҫ���ӽ��ױ���#ATM#������#3#����";

var label_03_01_03_01 = "��Ҫ���ӽ��ױ���#ATM#������#1#����";
var label_03_01_03_02 = "��Ҫ���ӽ��ױ���#ATM#������#2#����";
var label_03_01_03_03 = "��Ҫ���ӽ��ױ���#ATM#������#3#����";

// pos
var label_03_02_01_01 = "��Ҫ���ӽ��ױ���#POS#����#1#����";
var label_03_02_02_01 = "��Ҫ���ӽ��ױ���#POS#������#1#����";
var label_03_02_03_01 = "��Ҫ���ӽ��ױ���#POS#������#1#����";

// ��������
var label_03_03_01_01 = "��Ҫ���ӽ��ױ���#��������#������������#1#����";
var label_03_03_01_02 = "��Ҫ���ӽ��ױ���#��������#������������#2#����";
var label_03_03_01_03 = "��Ҫ���ӽ��ױ���#��������#������������#3#����";

var label_03_03_02_01 = "��Ҫ���ӽ��ױ���#��������#��ҵ��������#1#����";
var label_03_03_02_02 = "��Ҫ���ӽ��ױ���#��������#��ҵ��������#2#����";
var label_03_03_02_03 = "��Ҫ���ӽ��ױ���#��������#��ҵ��������#3#����";

// �绰����
var label_03_03_01 = "��Ҫ���ӽ��ױ���#�绰����#1#����";
var label_03_03_02 = "��Ҫ���ӽ��ױ���#�绰����#2#����";
var label_03_03_03 = "��Ҫ���ӽ��ױ���#�绰����#3#����";

// �ֻ�����
var label_03_04_01 = "��Ҫ���ӽ��ױ���#�ֻ�����#1#����";
var label_03_04_02 = "��Ҫ���ӽ��ױ���#�ֻ�����#2#����";
var label_03_04_03 = "��Ҫ���ӽ��ױ���#�ֻ�����#3#����";

// ������������ҵ��
var label_03_05_01 = "��Ҫ���ӽ��ױ���#������������ҵ��#1#����";
var label_03_05_02 = "��Ҫ���ӽ��ױ���#������������ҵ��#2#����";
var label_03_05_03 = "��Ҫ���ӽ��ױ���#������������ҵ��#3#����";

// �ϼ�
var label_03_06_01 = "��Ҫ���ӽ��ױ���#�ϼ�#1#����";

// ��Ҫ���ӽ��׽��
// ATM
var label_04_01_01 = "��Ҫ���ӽ��׽��#ATM#����#1#����";
var label_04_01_02 = "��Ҫ���ӽ��׽��#ATM#������#1#����";
var label_04_01_03 = "��Ҫ���ӽ��׽��#ATM#������#1#����";

// POS
var label_04_02_01 = "��Ҫ���ӽ��׽��#POS#����#1#����";
var label_04_02_02 = "��Ҫ���ӽ��׽��#POS#������#1#����";
var label_04_02_03 = "��Ҫ���ӽ��׽��#POS#������#1#����";

// ��������
var label_04_03_01 = "��Ҫ���ӽ��׽��#��������#������������#1#����";
var label_04_03_02 = "��Ҫ���ӽ��׽��#��������#��ҵ��������#1#����";

// �绰����
var label_04_04_01 = "��Ҫ���ӽ��׽��#�绰����#1#����";

// �ֻ�����
var label_04_05_01 = "��Ҫ���ӽ��׽��#�ֻ�����#1#����";

// ������������ҵ��
var label_04_06_01 = "��Ҫ���ӽ��׽��#������������ҵ��#1#����";

// �ϼ�
var label_04_07_01 = "��Ҫ���ӽ��׽��#�ϼ�#1#����";

// ��Ҫ���ӽ��������
var label_05_01 = "��Ҫ���ӽ��������#1#����";
var label_05_02 = "��Ҫ���ӽ��������#2#����";
var label_05_03 = "��Ҫ���ӽ��������#3#����";
var label_05_04 = "��Ҫ���ӽ��������#4#����";
var label_05_05 = "��Ҫ���ӽ��������#5#����";
var label_05_06 = "��Ҫ���ӽ��������#6#����";
var label_05_07 = "��Ҫ���ӽ��������#7#����";
var label_05_08 = "��Ҫ���ӽ��������#8#����";

/*
 * ���ܣ��ύУ��
 * 
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	// У�鸴ѡ�������Ƿ���ֵ
	for ( var i = 0; i < checkBoxValueObjs.length; i++) {
		var checkBoxObj = checkBoxValueObjs[i];
		if (checkBoxObj.checked) {
			var checkBoxObjValueObj = checkBoxObj.parentElement.nextSibling.nextSibling;
			if (checkBoxObjValueObj.value.indexOf("_cev_") < 0) {
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a += "���������ݲ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("����") > -1) {
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
 * ���ܣ���Ҫ���ӽ��ױ���������������ҵ��С�Ƽ���
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
 * ���ܣ�ͨ��ȫ�����н��׽����������Ҫ���ӽ��׽�������
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
 * ���ܣ���Ҫ���ӽ��ױ���������������ҵ��С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ����ֻ�����С�Ƽ���
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
 * ���ܣ�������Ҫ���ӽ�������ʵ��ֻ����н��ױ��������
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
 * ���ܣ���Ҫ���ӽ��ױ����绰����С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ�������������ҵ��������С�Ƽ���
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
 * ���ܣ�������Ҫ���ӽ�������ʵ��������н��ױ��������
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
 * ���ܣ���Ҫ���ӽ��ױ����������и�����������С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ���posС�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ���ATM������С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ���ATM������С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ���ATM����С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ��ױ���ATM����С�Ƽ���
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
 * ���ܣ���Ҫ���ӽ�������ʵļ����������н��׽�������
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
 * ���ܣ���Ҫ���ӽ�������ʵ��ֻ����н��׽�������
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
 * ���ܣ�����ȫ�����н��ױ�����������������Ҫ���ӽ��ױ��������
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
 * ���ܣ���ʼ��ҳ��
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
 * ���ܣ������ѡ��ѡ���е�������������������У����ύ��ʱ��У�������������Ƿ�Ϊ��
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



// ����С��λ��
function checkNumberFloat(obj, len) {
	return Math.round(obj * Math.pow(10, len)) / Math.pow(10, len);
}
/*
 * ��ʼ��ҳ���ѯ���ڵ�ֵ
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
// * ���㻷�ȷ���
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
//			alert("�˼��ȱ���û����������ֵ��");
//			countFlag = 1;
//		}else if(!jQuery.isEmptyObject(valueMap) && jQuery.isEmptyObject(valueMap[id])){
//			alert("û�д���������������!");
//		}
//	}
//}