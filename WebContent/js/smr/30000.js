/*
 * ����T-A-1 ��Ϣ�Ƽ���֯����Ա�ش�䶯��_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5="�䶯����";
var label_RadioButtonList="�䶯����";
var label_item7="��Ч����";
var label_item8="�䶯��ϸ���";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_item5=getFormObj(label_item5);
	var obj_RadioButtonList=getFormObj(label_RadioButtonList);
	var obj_item7=getFormObj(label_item7);
	var obj_item8=getFormObj(label_item8);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	// ��"�䶯����"��Ϊ�ջ�"��"ʱ,��֤�����ݵı���
	if (obj_item5.innerHTML.trim()!= "��" && obj_item5.innerHTML.trim() != "") {
		if (obj_RadioButtonList.value.trim() == "") {
			errorObjs.push(obj_RadioButtonList.parentElement);
			a += "�䶯���Ϊ���ޡ���գ���䶯���Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item7.value.trim() == "") {
			errorObjs.push(obj_item7);
			a += "�䶯���Ϊ���ޡ���գ�����Ч���ڲ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item8.innerHTML.trim() == "") {
			errorObjs.push(obj_item8);
			a += "�䶯���Ϊ���ޡ���գ���䶯��ϸ�������Ϊ�գ�\n";
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