/*
 * ����T-A-3 �������Ĺ滮�����_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01="�Ƿ����";
var label_YN01_01="�����Χ";
var label_YN01_02="�������";
var label_YN01_03="���������";
var label_zhandimianji ="������Ϣ#ռ�����";
var label_jifangmianji ="������Ϣ#�������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var obj_YN01=getFormObj(label_YN01);
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	if (obj_YN01.value=="��") {
		// ���������Ͳ�����Ϊ��Ч
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,true);
		// ��������Χ������Ϊ��Ч
		clearNormalRadioValue(obj_YN01_01,true);
		// �����������ʲ�����Ϊ��Ч
		clearNormalRadioValue(obj_YN01_03,true);
	}
}

/*
* ���ܣ��Ƿ�����໥������
* ���ã��Ƿ����
*/
function shifouwaibao_click(obj){
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	
	if (obj.value=="��") {
		// ���������Ͳ�����Ϊ��Ч
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,true);
		// ��������Χ������Ϊ��Ч
		clearNormalRadioValue(obj_YN01_01,true);
		// �����������ʲ�����Ϊ��Ч
		clearNormalRadioValue(obj_YN01_03,true);
	} else {
		//��ԭ
		var checkeditem_YN01_02 = getFormCheckBox(label_YN01_02);
		disableCheckBox(checkeditem_YN01_02,false);
		clearNormalRadioValue(obj_YN01_01,false);
		clearNormalRadioValue(obj_YN01_03,false);
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_YN01=getFormObj(label_YN01);
	var obj_YN01_01=getFormObj(label_YN01_01);
	var obj_YN01_02=getFormObj(label_YN01_02);
	var obj_YN01_03=getFormObj(label_YN01_03);
	var obj_zhandimianji=getTableFormObjs(label_zhandimianji)[0];
	var obj_jifangmianji=getTableFormObjs(label_jifangmianji)[0];
	
	// С��λ���㴦��
	checkNumFloat(obj_zhandimianji,2);
	checkNumFloat(obj_jifangmianji,2);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];

	if (obj_YN01.value=="��") {
		if(obj_YN01_01.value=="") {
			errorObjs.push(obj_YN01_01.parentElement);
			a += "�����Χ����Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_02.value=="") {
			errorObjs.push(obj_YN01_02.parentElement);
			a += "������Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_03.value=="") {
			errorObjs.push(obj_YN01_03.parentElement);
			a += "��������ʲ���Ϊ�գ�\n";
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
