/*
 * ����T-A-4 �����������������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item8="�Ƿ����";
var label_YN_RadioButtonList1="�����Χ";
var label_item27="�������";
var label_YN_RadioButtonList="���������";
var label_zhandimianji ="������Ϣ#ռ�����";
var label_jifangmianji ="������Ϣ#�������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var obj_item8=getFormObj(label_item8);
	var obj_YN_RadioButtonList1=getFormObj(label_YN_RadioButtonList1);
	var obj_item27=getFormObj(label_item27);
	var obj_YN_RadioButtonList=getFormObj(label_YN_RadioButtonList);
	if (obj_item8.value=="��"){
		// ���������Ͳ�����Ϊ��Ч
		var checkeditem_item27 = getFormCheckBox(label_item27);
		disableCheckBox(checkeditem_item27,true);
		obj_item27.value="";
		// ��������Χ������Ϊ��Ч
		clearNormalRadioValue(obj_YN_RadioButtonList1,true);
		// �����������ʲ�����Ϊ��Ч
		clearNormalRadioValue(obj_YN_RadioButtonList,true);
	}
}

/*
* ���ܣ��Ƿ�����໥������
* ���ã��Ƿ����
*/
function shifouwaibao_click(obj){
	var obj_YN_RadioButtonList1=getFormObj(label_YN_RadioButtonList1);
	var obj_item27=getFormObj(label_item27);
	var obj_YN_RadioButtonList=getFormObj(label_YN_RadioButtonList);
	
	if (obj.value=="��") {
		// ���������Ͳ�����Ϊ��Ч
		var checkeditem_item27 = getFormCheckBox(label_item27);
		disableCheckBox(checkeditem_item27,true);
		obj_item27.value="";
		// ��������Χ������Ϊ��Ч
		clearNormalRadioValue(obj_YN_RadioButtonList1,true);
		// �����������ʲ�����Ϊ��Ч
		clearNormalRadioValue(obj_YN_RadioButtonList,true);
	} else {
		//��ԭ
		var checkeditem_item27 = getFormCheckBox(label_item27);
		disableCheckBox(checkeditem_item27,false);
		clearNormalRadioValue(obj_YN_RadioButtonList1,false);
		clearNormalRadioValue(obj_YN_RadioButtonList,false);
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_item8=getFormObj(label_item8);
	var obj_YN_RadioButtonList1=getFormObj(label_YN_RadioButtonList1);
	var obj_item27=getFormObj(label_item27);
	var obj_YN_RadioButtonList=getFormObj(label_YN_RadioButtonList);
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
	
	if (obj_item8.value=="��") {
		if(obj_YN_RadioButtonList1.value=="") {
			errorObjs.push(obj_YN_RadioButtonList1.parentElement);
			a += "�����Χ����Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_item27.value=="") {
			errorObjs.push(obj_item27.parentElement);
			a += "������Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN_RadioButtonList.value=="") {
			errorObjs.push(obj_YN_RadioButtonList.parentElement);
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
