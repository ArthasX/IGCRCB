/*
 * ����T-B-10  ���ݹ��������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item8 = "��������#����";

var label_EG_YN_Item9 = "���ݱ���#��1#����#1";
var label_R_Item10 = "���ݱ���#��1#����#�ص�";
var label_EG_YN_Item9_2 = "���ݱ���#��2#����#1";
var label_R_Item11 = "���ݱ���#��2#����#��Ż�������";

var label_EG_YN_Item27 = "���ݷ��ʺ�ʹ�ÿ���#��4#����#1";
var label_R_Item28 = "���ݷ��ʺ�ʹ�ÿ���#��4#����#���ü����㷨";

var label_EG_YN_Item38 = "���ݷ��ʺ�ʹ�ÿ���#��7#����";
var label_EG_YN_Item38_2 = "���ݷ��ʺ�ʹ�ÿ���#��8#����#1";
var label_R_Item39 = "���ݷ��ʺ�ʹ�ÿ���#��8#����#���շ���";

var label_EG_YN_Item43 = "������������#��2#����#1";
var label_R_Item44 = "������������#��2#����#���ٻ�������";
/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	setEG_YN_Item9Disable(obj);
	setEG_YN_Item9_2Disable(obj);
	setEG_YN_Item27Disable(obj);
	setEG_YN_Item38Disable(obj);
	setEG_YN_Item43Disable(obj);
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã����ݱ���#��1#����#1
 */
function setEG_YN_Item9Disable(obj) {
	var obj_item9 = getTableFormObjs(label_EG_YN_Item9)[0];
	var obj_R_Item10 = getTableFormObjs(label_R_Item10)[0];
	if (obj_item9.value.trim() == "��") {
		// ֻ��
		obj_R_Item10.readOnly = "readonly";
		// ���
		obj_R_Item10.value = "";

	} else if (obj_item9.value.trim() == "��") {
		// ��ԭ
		obj_R_Item10.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã����ݱ���#��2#����#1
 */
function setEG_YN_Item9_2Disable(obj) {
	var obj_item9_2 = getTableFormObjs(label_EG_YN_Item9_2)[0];
	var obj_R_Item11 = getTableFormObjs(label_R_Item11)[0];
	if (obj_item9_2.value.trim() == "��") {
		// ֻ��
		obj_R_Item11.readOnly = "readonly";
		// ���
		obj_R_Item11.value = "";

	} else if (obj_item9_2.value.trim() == "��") {
		// ��ԭ
		obj_R_Item11.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã����ݷ��ʺ�ʹ�ÿ���#��4#����#1
 */
function setEG_YN_Item27Disable(obj) {
	var obj_item27 = getTableFormObjs(label_EG_YN_Item27)[0];
	var obj_R_Item28 = getTableFormObjs(label_R_Item28)[0];
	if (obj_item27.value.trim() == "��") {
		// ֻ��
		obj_R_Item28.readOnly = "readonly";
		// ���
		obj_R_Item28.value = "";

	} else if (obj_item27.value.trim() == "��") {
		// ��ԭ
		obj_R_Item28.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã�  1.���ݷ��ʺ�ʹ�ÿ���#��8#����#1      (������ģ���BUG���粻��ͬʱ������:2.���ݷ��ʺ�ʹ�ÿ���#��7#����)
 */
function setEG_YN_Item38Disable(obj) {
	var obj_item38 = getTableFormObjs(label_EG_YN_Item38_2)[0];
	var obj_R_Item39 = getTableFormObjs(label_R_Item39)[0];
	if (obj_item38.value.trim() == "��") {
		// ֻ��
		obj_R_Item39.readOnly = "readonly";
		// ���
		obj_R_Item39.value = "";

	} else if (obj_item38.value.trim() == "��") {
		// ��ԭ
		obj_R_Item39.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã�������������#��2#����#1
 */
function setEG_YN_Item43Disable(obj) {
	var obj_item43 = getTableFormObjs(label_EG_YN_Item43)[0];
	var obj_R_Item44 = getTableFormObjs(label_R_Item44)[0];
	if (obj_item43.value.trim() == "��") {
		// ֻ��
		obj_R_Item44.readOnly = "readonly";
		// ���
		obj_R_Item44.value = "";

	} else if (obj_item43.value.trim() == "��") {
		// ��ԭ
		obj_R_Item44.readOnly = "";
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
	
	var obj_item8 = getTableFormObjs(label_item8);
	checkNumFloat(obj_item8[0],3);
	checkNumFloat(obj_item8[1],3);
	checkNumFloat(obj_item8[2],3);
	if(parseFloat(obj_item8[0].value) < 0){
		errorObjs.push(obj_item8[0]);
	 	a+="����������������������С��0 ��\n";
	  	isValid=false;
	}
	if(parseFloat(obj_item8[1].value) < 0){
		errorObjs.push(obj_item8[1]);
	 	a+="�����ܴ洢��������С��0 ��\n";
	  	isValid=false;
	}
	if(parseFloat(obj_item8[2].value) < 0){
		errorObjs.push(obj_item8[2]);
	 	a+="�������ݻ�����������С��0 ��\n";
	  	isValid=false;
	}
	if( obj_item8[0].value > obj_item8[1].value){
		errorObjs.push(obj_item8[0]);
	 	a+="�����������������������ܴ洢����У�����\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item9 = getTableFormObjs(label_EG_YN_Item9)[0];
	var obj_R_Item10 = getTableFormObjs(label_R_Item10)[0];
	if(obj_EG_YN_Item9.value == "��" && obj_R_Item10.value.trim() == ""){
		errorObjs.push(obj_R_Item10);
	 	a+="���ݱ��棺��ر��� �ص㲻��Ϊ�գ�\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item9_2 = getTableFormObjs(label_EG_YN_Item9_2)[0];
	var obj_R_Item11 = getTableFormObjs(label_R_Item11)[0];
	if(obj_EG_YN_Item9_2.value == "��" && obj_R_Item11.value.trim() == ""){
		errorObjs.push(obj_R_Item11);
	 	a+="���ݱ��棺�������ݱ������ⲿ�����򱸷ݽ��ʱ������ⲿ���� ��Ż������Ʋ���Ϊ�գ�\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item27 = getTableFormObjs(label_EG_YN_Item27)[0];
	var obj_R_Item28 = getTableFormObjs(label_R_Item28)[0];
	if(obj_EG_YN_Item27.value == "��" && obj_R_Item28.value.trim() == ""){
		errorObjs.push(obj_R_Item28);
	 	a+="���ü����㷨����Ϊ�գ�\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item38_2 = getTableFormObjs(label_EG_YN_Item38_2)[0];
	var obj_R_Item39 = getTableFormObjs(label_R_Item39)[0];
	if(obj_EG_YN_Item38_2.value == "��" && obj_R_Item39.value.trim() == ""){
		errorObjs.push(obj_R_Item39);
	 	a+="���ݷ��ʺ�ʹ�ÿ��ƣ���ʷ����ʹ�ú����ݻ��շ�������Ϊ�գ�\n";
	  	isValid=false;
	}
	var obj_EG_YN_Item43 = getTableFormObjs(label_EG_YN_Item43)[0];
	var obj_R_Item44 = getTableFormObjs(label_R_Item44)[0];
	if(obj_EG_YN_Item43.value == "��" && obj_R_Item44.value.trim() == ""){
		errorObjs.push(obj_R_Item44);
	 	a+="�����������٣����ٻ������Ʋ���Ϊ�գ�\n";
	  	isValid=false;
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