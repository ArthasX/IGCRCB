/*
 * ����T-B-5 �������������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item10 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�����";
var label_item5 = "���������Ϣ#����";
var label_O_item25 = "���������Ϣ#����";
var label_O_item12 = "���������Ϣ#��άģʽ";
var label_item6 = "���������Ϣ#�ص�#����";
var label_item7 = "���������Ϣ#�ص�#ʡ����������ֱϽ�У�";
var label_item8 = "���������Ϣ#�ص�#�У��ء��ݡ��ˣ�";
var label_item9 = "���������Ϣ#�ص�#���ڵ���������";
var label_item22 = "���������Ϣ#��������";
var label_item1 = "����#����#��������";
var label_item2 = "����#����#�������������ϸ����";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){}

/*
* ���ܣ�����ύʱ���еı���֤
* ���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		checkTableItemNull(objs[i]);
	}
//	if (getTableFormObj(label_item2,"1_1").value.trim() == "") {
//		errorObjs.push(label_item2);
//		a += "�������������ϸ���治��Ϊ�գ�\n";
//		isValid = false;
//	}
//	if (getTableFormObj(label_item1,"1_1").value.trim() == "") {
//		errorObjs.push(label_item1);
//		a += "�������������ϸ���棬������������Ϊ�գ�\n";
//		isValid = false;
//	}
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
* ���ܣ����������жϸ����Ƿ�ȫ����ֵ
*/
function checkTableItemNull(obj) {
	if (replaceAll(obj.value.trim()) == "") {
		errorObjs.push(obj);
		a += "���Ʋ���Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_O_item25, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_O_item25, obj.rownumber));
		a += "����" + obj.value.trim() + "��" + "���Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_O_item12, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_O_item12, obj.rownumber));
		a += "����" + obj.value.trim() + "��" + "��άģʽ����Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_item6, obj.rownumber + "_1").value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item6, obj.rownumber + "_1"));
		a += "����" + obj.value.trim() + "��" + "���Ҳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_item7, obj.rownumber + "_1").value.trim().trim() == "") {
		errorObjs.push(getTableFormObj(label_item7, obj.rownumber + "_1"));
		a += "����" + obj.value.trim() + "��" + "ʡ����������ֱϽ�У�����Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_item8, obj.rownumber + "_1").value.trim().trim() == "") {
		errorObjs.push(getTableFormObj(label_item8, obj.rownumber + "_1"));
		a += "����" + obj.value.trim() + "��" + "�У��ء��ݡ��ˣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_item9, obj.rownumber + "_1").value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item9, obj.rownumber + "_1"));
		a += "����" + obj.value.trim() + "��" + "���ڵ��������벻��Ϊ�գ�\n";
		isValid = false;
	}
	if (getTableFormObj(label_item22, obj.rownumber).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_item22, obj.rownumber));
		a += "����" + obj.value.trim() + "��" + "�������ڲ���Ϊ�գ�\n";
		isValid = false;
	}
}

/*
 * ���ܣ��س����滻
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}



