/*
 * ����T-Q-5 ����������Ϣ�Ƽ����ռ���_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "�����#��������#����#��ȫ�¼�����";
var label_item6 = "�����#��������#����#�¼�����";
var label_item0 = "�����#��������#����#����ʱ��#����ʱ���";
var label_item2 = "�����#��������#����#����ʱ��#����ʱ�䵽";
var label_item9_GTZero = "�����#��������#����#����";
var label_item10 = "�����#��������#����#ԭ�򼰴��ô�ʩ";
var label_item11 = "�����#��������#����#��ʧ���";
var label_cell2 = "�����#��������#����#��ע";

var label_item5_2 = "�����#���п�#����#��ȫ�¼�����";
var label_item14_2 = "�����#���п�#����#�¼�����";
var label_item0_2 = "�����#���п�#����#����ʱ��#1";
var label_item2_2 = "�����#���п�#����#����ʱ��#2";
var label_item17_GTZero_2 = "�����#���п�#����#����";
var label_item18_2 = "�����#���п�#����#ԭ�򼰴��ô�ʩ";
var label_item19_2 = "�����#���п�#����#��ʧ���";
var label_cell20_2 = "�����#���п�#����#��ע";

var label_item21 = "�����#3#ϵͳ����#����";
var label_item5_3 = "�����#3#����#��ȫ�¼�����";
var label_item13_3 = "�����#3#����#�¼�����";
var label_item0_3 = "�����#3#����#����ʱ��#1";
var label_item2_3 = "�����#3#����#����ʱ��#2";
var label_item9_GTZero_3 = "�����#3#����#����";
var label_item18_3 = "�����#3#����#ԭ�򼰴��ô�ʩ";
var label_item19_3 = "�����#3#����#��ʧ���";
var label_cell20_3 = "�����#3#����#��ע";
/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	
}
/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#��������#����#����ʱ��#����ʱ���    
 */
function setItem0Disable(obj) {
	var end = getTableFormObj(label_item2,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
	} 
}

/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#��������#����#����ʱ��#����ʱ�䵽
 */
function setItem2Disable(obj) {
	var start = getTableFormObj(label_item0,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("����ʱ��Ӧ����ʼʱ������������룡");
	} 
}

/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#���п�#����#����ʱ��#1
 */
function setItem0_2Disable(obj) {
	var end = getTableFormObj(label_item2_2,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
	} 
}

/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#���п�#����#����ʱ��#2
 */
function setItem2_2Disable(obj) {
	var start = getTableFormObj(label_item0_2,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
	} 
}

/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#3#����#����ʱ��#1
 */
function setItem0_3Disable(obj) {
	var end = getTableFormObj(label_item2_3,obj.rownumber);
	var start = obj.value;
	var start_date = start.split(" ")[0];
	var start_time = start.split(" ")[1];
	var end_date = end.value.split(" ")[0];
	var end_time = end.value.split(" ")[1];
	if (obj.value != "" && end.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
		obj.value = "";
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
	} 
}
/*
 *���ܣ�������д��ʱ���жϿ�ʼʱ���Ƿ���ڽ���ʱ��
 *���ã������#3#����#����ʱ��#2
 */
function setItem2_3Disable(obj) {
	var start = getTableFormObj(label_item0_3,obj.rownumber);
	var end = obj.value;
	var start_date = start.value.split(" ")[0];
	var start_time = start.value.split(" ")[1];
	var end_date = end.split(" ")[0];
	var end_time = end.split(" ")[1];
	if (obj.value != "" && start.value != "" && start_date > end_date || (
			start_date == end_date && start_time > end_time)) {
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
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	
	var objs2 = getTableFormObjs(label_item5_2);
	for ( var i = 0; i < objs2.length; i++) {
		// ����ģ��
		if ((objs2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull2(objs2[i]);
	}
	
	var objs3 = getTableFormObjs(label_item5_3);
	for ( var i = 0; i < objs3.length; i++) {
		// ����ģ��
		if ((objs3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull3(objs3[i]);
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
	var obj_item6 = getTableFormObj(label_item6,obj.rownumber);
	var obj_item0 = getTableFormObj(label_item0,obj.rownumber + "_1");
	var obj_item2 = getTableFormObj(label_item2,obj.rownumber + "_1");
	var obj_item9_GTZero = getTableFormObj(label_item9_GTZero,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber);
	var obj_cell2 = getTableFormObj(label_cell2,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "��"){
		if (obj_item6.value == "") {
			errorObjs.push(obj_item6.parentElement);
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������¼����಻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item0.value == "") {
			errorObjs.push(obj_item0);
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���������ʼʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item2.value == "") {
			errorObjs.push(obj_item2);
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����������ʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item9_GTZero.value == "") {
			errorObjs.push(obj_item9_GTZero);
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������������Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item10.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item10));
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������ԭ�򼰴��ô�ʩ����Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item11.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item11));
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��������ʧ�������Ϊ�գ�\n";
			isValid = false;
		}
	}else{
		if(replaceAll(obj.value.trim()) != "" && obj_item6.value != "" ||
				obj_item0.value != "" || obj_item2.value != "" && obj_item9_GTZero.value != "" ||
				replaceAll(obj_item10.value.trim()) != "" || replaceAll(obj_item11.value.trim()) != "" ||
				replaceAll(obj_cell2.value.trim()) != ""
					){
			errorObjs.push(getEditDiv(obj));
			a += "1.�������� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����ȫ�¼����Ʋ���Ϊ�գ�\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull2(obj) {
	
	var obj_item14_2 = getTableFormObj(label_item14_2,obj.rownumber);
	var obj_item0_2 = getTableFormObj(label_item0_2,obj.rownumber + "_1");
	var obj_item2_2 = getTableFormObj(label_item2_2,obj.rownumber + "_1");
	var obj_item17_GTZero_2 = getTableFormObj(label_item17_GTZero_2,obj.rownumber);
	var obj_item18_2 = getTableFormObj(label_item18_2,obj.rownumber);
	var obj_item19_2 = getTableFormObj(label_item19_2,obj.rownumber);
	var obj_cell20_2 = getTableFormObj(label_cell20_2,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "��"){
		if (obj_item14_2.value == "") {
			errorObjs.push(obj_item14_2.parentElement);
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������¼����಻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item0_2.value == "") {
			errorObjs.push(obj_item0_2);
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���������ʼʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item2_2.value == "") {
			errorObjs.push(obj_item2_2);
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����������ʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item17_GTZero_2.value == "") {
			errorObjs.push(obj_item17_GTZero_2);
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������������Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item18_2.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item18_2));
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������ԭ�򼰴��ô�ʩ����Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item19_2.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item19_2));
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��������ʧ�������Ϊ�գ�\n";
			isValid = false;
		}
	}else{
		if(obj_item14_2.value != "" || obj_item0_2.value != "" || obj_item2_2.value != "" || obj_item17_GTZero_2.value != "" ||
				replaceAll(obj_item18_2.value.trim()) != "" || replaceAll(obj_item19_2.value.trim()) != "" ||
				replaceAll(obj_cell20_2.value.trim()) != ""){
			errorObjs.push(getEditDiv(obj));
			a += "2.���п� ��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�����Ϊ���ޡ���գ�\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull3(obj) {
	var obj_item21 = getTableFormObj(label_item21,obj.rownumber);
	var obj_item13_3 = getTableFormObj(label_item13_3,obj.rownumber);
	var obj_item0_3 = getTableFormObj(label_item0_3,obj.rownumber + "_1");
	var obj_item2_3 = getTableFormObj(label_item2_3,obj.rownumber + "_1");
	var obj_item9_GTZero_3 = getTableFormObj(label_item9_GTZero_3,obj.rownumber);
	var obj_item18_3 = getTableFormObj(label_item18_3,obj.rownumber);
	var obj_item19_3 = getTableFormObj(label_item19_3,obj.rownumber);
	var obj_cell20_3 = getTableFormObj(label_cell20_3,obj.rownumber);

	if (obj.value.trim() !="" && obj.value.trim() != "��"){
		
		if (obj_item21.value == "") {
			errorObjs.push(obj_item21.parentElement);
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������ϵͳ���Ʋ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item13_3.value == "") {
			errorObjs.push(getEditDiv(obj_item13_3));
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������¼����಻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item0_3.value == "") {
			errorObjs.push(obj_item0_3);
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���������ʼʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item2_3.value == "") {
			errorObjs.push(obj_item2_3);
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����������ʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item9_GTZero_3.value == "") {
			errorObjs.push(obj_item9_GTZero_3);
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�������������Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item18_3.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item18_3));
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������ԭ�򼰴��ô�ʩ����Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item19_3.value.trim()) == "") {
			errorObjs.push(getEditDiv(obj_item19_3));
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��������ʧ�������Ϊ�գ�\n";
			isValid = false;
		}
	}else{
		if( obj_item21.value != "" || obj_item13_3.value != "" ||
				obj_item0_3.value != "" || obj_item2_3.value != "" || obj_item9_GTZero_3.value != "" ||
				replaceAll(obj_item18_3.value.trim()) != "" || replaceAll(obj_item19_3.value.trim()) != "" ||
				replaceAll(obj_cell20_3.value.trim()) != ""){
			errorObjs.push(getEditDiv(obj));
			a += "3.��ȫ�¼�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�����ȫ�¼����Ʋ���Ϊ�գ�\n";
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