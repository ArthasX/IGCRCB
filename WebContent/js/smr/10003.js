/*
 * ����T-B-4 ��Ϣ�Ƽ���Ŀ���������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item5 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�����";
var label_DecimalField2_GTZero = "�������Ŀ���#����#���������������Ŀ#���������������Ŀ";
var label_DecimalField3_GTZero = "�������Ŀ���#����#���������������Ŀ#����#�ش���Ŀ";
var label_DecimalField4_GTZero = "�������Ŀ���#����#���������������Ŀ#����#һ����Ŀ";
var label_DecimalField5_GTZero = "�������Ŀ���#����#����������Ŀ#����������Ŀ";
var label_DecimalField6_GTZero = "�������Ŀ���#����#����������Ŀ#����#�ش���Ŀ";
var label_DecimalField9_GTZero = "�������Ŀ���#����#����������Ŀ#����#һ����Ŀ";
var label_DecimalField7_GTZero = "�������Ŀ���#����#�����������Ŀ#�����������Ŀ";
var label_DecimalField8_GTZero = "�������Ŀ���#����#�����������Ŀ#����#�ش���Ŀ";
var label_DecimalField15_GTZero = "�������Ŀ���#����#�����������Ŀ#����#һ����Ŀ";
var label_DecimalField1_GTZero = "�������Ŀ���#����#�������Ϣ�Ƽ���Ŀ����";
var label_R_Item13_GTZero = "��Ŀ�������#����#�����������֤��Ա��Ŀ������";

var label_R_Item20_GTZero = "�������Ŀ���#����#��Ŀѹ�����������";
var label_R_Item21_GTZero = "�������Ŀ���#����#��Ŀ�û����ղ��������";
var label_R_Item22_GTZero = "�������Ŀ���#����#��Ŀ���밲ȫ��������";
var label_DecimalField10_GTZero = "�������Ŀ���#����#�����Ŀ�ƻ������";
var label_DecimalField11_GTZero = "�������Ŀ���#����#��������������Ŀ������#��������������Ŀ������";
var label_DecimalField12_GTZero = "�������Ŀ���#����#��������������Ŀ������#����#��������������";
var label_DecimalField13_GTZero = "�������Ŀ���#����#��������������Ŀ������#����#�������������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	//�������Ŀ���#����#���������������Ŀ#���������������Ŀ
	var obj_DecimalField2_GTZero = getTableFormObj(label_DecimalField2_GTZero,"1_1_1");
	//�������Ŀ���#����#���������������Ŀ#����#�ش���Ŀ
	var obj_DecimalField3_GTZero = getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1");
	//�������Ŀ���#����#���������������Ŀ#����#һ����Ŀ
	var obj_DecimalField4_GTZero = getTableFormObj(label_DecimalField4_GTZero,"1_1_1_1");
	//�������Ŀ���#����#����������Ŀ#����������Ŀ
	var obj_DecimalField5_GTZero = getTableFormObj(label_DecimalField5_GTZero,"1_1_1");
	//�������Ŀ���#����#����������Ŀ#����#�ش���Ŀ
	var obj_DecimalField6_GTZero = getTableFormObj(label_DecimalField6_GTZero,"1_1_1_1");
	//�������Ŀ���#����#����������Ŀ#����#һ����Ŀ
	var obj_DecimalField9_GTZero = getTableFormObj(label_DecimalField9_GTZero,"1_1_1_1");
	//�������Ŀ���#����#�����������Ŀ#�����������Ŀ
	var obj_DecimalField7_GTZero = getTableFormObj(label_DecimalField7_GTZero,"1_1_1");
	//�������Ŀ���#����#�����������Ŀ#����#�ش���Ŀ
	var obj_DecimalField8_GTZero = getTableFormObj(label_DecimalField8_GTZero,"1_1_1_1");
	//�������Ŀ���#����#�����������Ŀ#����#һ����Ŀ
	var obj_DecimalField15_GTZero = getTableFormObj(label_DecimalField15_GTZero, "1_1_1_1");
	//�������Ŀ���#����#��������������Ŀ������#��������������Ŀ������
	var obj_DecimalField11_GTZero = getTableFormObj(label_DecimalField11_GTZero, "1_1_1");
	//�������Ŀ���#����#��������������Ŀ������#����#��������������
	var obj_DecimalField12_GTZero = getTableFormObj(label_DecimalField12_GTZero, "1_1_1_1");
	//�������Ŀ���#����#��������������Ŀ������#����#�������������
	var obj_DecimalField13_GTZero = getTableFormObj(label_DecimalField13_GTZero, "1_1_1_1");
	//�������Ŀ���#����#��Ŀѹ�����������";
	var obj_R_Item20_GTZero = getTableFormObj(label_R_Item20_GTZero, "1_1");
	//�������Ŀ���#����#��Ŀ�û����ղ��������";
	var obj_R_Item21_GTZero = getTableFormObj(label_R_Item21_GTZero, "1_1");
	//�������Ŀ���#����#��Ŀ���밲ȫ��������";
	var obj_R_Item22_GTZero = getTableFormObj(label_R_Item22_GTZero, "1_1");
	//�������Ŀ���#����#�����Ŀ�ƻ������
	var obj_DecimalField10_GTZero = getTableFormObj(label_DecimalField10_GTZero, "1_1");
	//�������Ŀ���#����#�������Ϣ�Ƽ���Ŀ����
	var obj_DecimalField1_GTZero = getTableFormObj(label_DecimalField1_GTZero,"1_1");
	//��Ŀ�������#����#�����������֤��Ա��Ŀ������
	var obj_R_Item13_GTZero = getTableFormObj(label_R_Item13_GTZero, "1_1");
	
	checkNumFloat(obj_DecimalField11_GTZero,2);
	checkNumFloat(obj_DecimalField12_GTZero,2);
	checkNumFloat(obj_DecimalField13_GTZero,2);
	checkNumFloat(obj_R_Item20_GTZero,2);
	checkNumFloat(obj_R_Item21_GTZero,2);
	checkNumFloat(obj_R_Item22_GTZero,2);
	checkNumFloat(obj_DecimalField10_GTZero,2);
	checkNumFloat(obj_R_Item13_GTZero,2);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if (parseInt(obj_DecimalField11_GTZero.value.trim()) < 
			parseInt(obj_DecimalField12_GTZero.value.trim())
			+ parseInt(obj_DecimalField13_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField11_GTZero);
		a += "�������������������������������������������������У�����\n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField2_GTZero.value.trim()) > 
		parseInt(obj_DecimalField3_GTZero.value.trim())
		+ parseInt(obj_DecimalField4_GTZero.value.trim())
			|| parseInt(obj_DecimalField2_GTZero.value.trim()) < 
			parseInt(obj_DecimalField3_GTZero.value.trim())
			+ parseInt(obj_DecimalField4_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField2_GTZero);
		a += "���������������Ŀ=�ش���Ŀ+һ����Ŀ����! \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField5_GTZero.value.trim()) > 
		parseInt(obj_DecimalField6_GTZero.value.trim()) 
		+ parseInt(obj_DecimalField9_GTZero.value.trim())
			|| parseInt(obj_DecimalField5_GTZero.value.trim()) < 
			parseInt(obj_DecimalField6_GTZero.value.trim())
			+ parseInt(obj_DecimalField9_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField5_GTZero);
		a += "����������Ŀ=�ش���Ŀ+һ����Ŀ����! \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField7_GTZero.value.trim()) > 
		parseInt(obj_DecimalField8_GTZero.value.trim())
		+ parseInt(obj_DecimalField15_GTZero.value.trim())
			|| parseInt(obj_DecimalField7_GTZero.value.trim()) < 
			parseInt(obj_DecimalField8_GTZero.value.trim())
			+ parseInt(obj_DecimalField15_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField7_GTZero);
		a += "�����������Ŀ=�ش���Ŀ+һ����Ŀ����! \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item20_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item20_GTZero);
		a += "��Ŀ�������-��Ŀѹ�����������<=100���� \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item21_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item21_GTZero);
		a += "��Ŀ�������-��Ŀ�û����ղ��������<=100���� \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item22_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item22_GTZero);
		a += "��Ŀ�������-��Ŀ���밲ȫ��������<=100���� \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField10_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_DecimalField10_GTZero);
		a += "��Ŀ�������-�����Ŀ�ƻ������<=100���� \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) < 
			parseInt(obj_DecimalField2_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField2_GTZero);
		a += "�������Ŀ���-�������Ϣ�Ƽ���Ŀ����>���������������ĿУ����� \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) <
			parseInt(obj_DecimalField5_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField5_GTZero);
		a += "�������Ŀ���-�������Ϣ�Ƽ���Ŀ����>����������ĿУ����� \n";
		isValid = false;
	}
	if (parseInt(obj_DecimalField1_GTZero.value.trim()) < 
			parseInt(obj_DecimalField7_GTZero.value.trim())) {
		errorObjs.push(obj_DecimalField7_GTZero);
		a += "�������Ŀ���-�������Ϣ�Ƽ���Ŀ����>�����������ĿУ����� \n";
		isValid = false;
	}
	if (parseInt(obj_R_Item13_GTZero.value.trim()) > 100) {
		errorObjs.push(obj_R_Item13_GTZero);
		a += "��Ŀ�������-�����������֤��Ա��Ŀ������<=100���� \n";
		isValid = false;
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

