/*
 * ����T-A-5 �������ı�������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];
var label_starttime = "�ƻ������ʼʱ��";
var label_endtime = "�ƻ��������ʱ��";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã��ƻ������ʼʱ��
*/
function checkStartTime(obj){
	var obj_endtime=getFormObj(label_endtime);
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("�����ʼʱ��Ӧ�ڱ������ʱ��֮ǰ�����������룡");
		obj.focus();
	}
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã��ƻ��������ʱ��
*/
function checkEndTime(obj){
	var obj_starttime=getFormObj(label_starttime);
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("�������ʱ��Ӧ�ڱ����ʼʱ��֮�����������룡");
		obj.focus();
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_starttime=getFormObj(label_starttime);
	var obj_endtime=getFormObj(label_endtime);
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "�����ʼʱ��Ӧ�ڱ������ʱ��֮ǰ�����������룡\n";
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