/*
 * ����T-Q-3 ��Ϣ�Ƽ���������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_ND = "���Ϳձ���#���Ϳձ�";
var label_item5 = "�����#���������Ŀ����";
var label_item13 = "�����#�����Χ";
var label_item19 = "�����#�������";
var label_item9 = "�����#��������";
var label_item10 = "�����#��������#���������";
var label_item11 = "�����#��������#����̹���";
var label_item12 = "�����#���������";
var label_item13_2 = "�����#������ʼʱ��";
var label_item14 = "�����#������ֹʱ��";
var label_item15 = "�����#�������Э�鰲ȫ��������";
var label_item16 = "�����#֪ʶ��Ȩ��������";
var label_item17 = "�����#�����������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	
}
/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#����ʼʱ��
 */
function setItem13Disable(obj) {
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	if (obj.value != "" && obj_item14.value != "" && obj.value > obj_item14.value) {
		obj.value = "";
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
	} 
}

/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#������ֹʱ��
 */
function setItem14Disable(obj) {
	var obj_item13_2 = getTableFormObj(label_item13_2,obj.rownumber);

	if (obj.value != "" && obj_item13_2.value != "" && obj_item13_2.value > obj.value) {
		obj.value = "";
		alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
	} 
}

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
	
	if (!checkEmptyReport()) {
		return true;
	}
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
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


/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull(obj) {
	var obj_item13 = getTableFormObj(label_item13,obj.rownumber);
	var obj_item19 = getTableFormObj(label_item19,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber + "_1");
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber + "_1");
	var obj_item12 = getTableFormObj(label_item12,obj.rownumber);
	var obj_item13_2 = getTableFormObj(label_item13_2,obj.rownumber);
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	var obj_item15 = getTableFormObj(label_item15,obj.rownumber);
	var obj_item16 = getTableFormObj(label_item16,obj.rownumber);
	var obj_item17 = getTableFormObj(label_item17,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "��"){
	/*if (replaceAll(obj.value.trim()) == "") {
		errorObjs.push(getEditDiv(obj));
		if(a.indexOf("���������Ŀ�����Ʋ�Ϊ���ޡ���գ�\n")<0)
		a += "���������Ŀ�����Ʋ�Ϊ���ޡ���գ�\n";
		isValid = false;
	}*/
		if (obj_item13.value == "") {
			errorObjs.push(obj_item13.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����������Χ����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item19.value == "") {
			errorObjs.push(obj_item19.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������������Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item9.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item9));
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������������������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item10.value == "") {
			errorObjs.push(obj_item10);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��������������Ʋ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item11.value == "") {
			errorObjs.push(obj_item11);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ����������̹�����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item12.value == "") {
			errorObjs.push(obj_item12.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��������������ʲ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item13_2.value == "") {
			errorObjs.push(obj_item13_2);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���������ʼʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item14.value == "") {
			errorObjs.push(obj_item14);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������������ʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}if (obj_item15.value == "") {
			errorObjs.push(obj_item15.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������������Э�鰲ȫ���������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item16.value == "") {
			errorObjs.push(obj_item16.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������֪ʶ��Ȩ���������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item17.value == "") {
			errorObjs.push(obj_item17.parentElement);
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���������������������Ϊ�գ�\n";
			isValid = false;
		}
	}else{
		if(obj_item13.value != "" || obj_item19.value != "" || replaceAll(obj_item9.value.trim()) != "" ||
				obj_item10.value != "" || obj_item11.value != "" || obj_item12.value != "" || obj_item13_2.value != ""||
				obj_item14.value != "" || obj_item15.value != "" || obj_item16.value != "" || obj_item17.value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "���������Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�����Ϊ���ޡ���գ�\n";
			isValid = false;
		}
	}
}

/*
 *���ܣ��س����滻
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}