/*
 * ����2014-T-B-13 ��Ϣ�Ƽ������ͬ�����
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
var label_YN00 = "���Ϳձ���#���Ϳձ�";
var label_YN00_01 = "����#�����";
var label_YN00_02 = "����#���";
var label_YN00_03 = "����#��ϵ�绰";
var label_YN00_04 = "����#������";
var label_YN00_05 = "����#�������";
// �ձ�
var label_empty = "���Ϳձ���#���Ϳձ�";
// ��ͬ��Ϣ
var label_YN01_02_01 = "��ͬ#��ͬ��Ϣ#��������#�з���ѯ��";
var label_YN01_02_02 = "��ͬ#��ͬ��Ϣ#��������#ϵͳ����ά����";
var label_YN01_02_03 = "��ͬ#��ͬ��Ϣ#��������#ҵ������е���Ϣ�Ƽ��";
var label_YN01_08_01 = "��ͬ#��ͬ��Ϣ#ִ�����#���������";
var label_YN01_08_02 = "��ͬ#��ͬ��Ϣ#ִ�����#�����ִ��״̬";
var label_YN01_08_03 = "��ͬ#��ͬ��Ϣ#ִ�����#���ʱ��";
var label_YN01_08_03 = "��ͬ#��ͬ��Ϣ#ִ�����#���ʱ��";
var label_YN01_06= "��ͬ#��ͬ��Ϣ#��ʼʱ��";	
var label_YN01_07= "��ͬ#��ͬ��Ϣ#�ƻ����ʱ��";	
var label_YN02_08 = "��ͬ#��ͬ��Ϣ#ʵʩ����";
// ��ͬ��Ϣ2
var label_YN02_01 = "��ͬ#��ͬ��Ϣ2#�������������£�";
var label_YN02_02 = "��ͬ#��ͬ��Ϣ2#����Ԫ��";
var label_YN02_03 = "��ͬ#��ͬ��Ϣ2#�Ƿ��������жϻ��쳣�˳�";
var label_YN02_06 = "��ͬ#��ͬ��Ϣ2#�����������";
var label_YN02_07 = "��ͬ#��ͬ��Ϣ2#�羳������";
// ͳ�����
var label_YN03_01 = "ͳ�����#�з���ѯ����Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_02 = "ͳ�����#ϵͳ����ά������Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_03 = "ͳ�����#����ҵ������е���Ϣ�Ƽ������Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_04 = "ͳ�����#���������ִ�к��ڱ�������ɵ���Ҫ��Ϣ�Ƽ������ͬ����";
var label_YN03_05 = "ͳ�����#��ͬ�ܽ��";
var label_YN03_06 = "ͳ�����#��������";
var label_YN03_07 = "ͳ�����#�������������Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_08 = "ͳ�����#���������ִ�е���Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_09 = "ͳ�����#���������ɵ���Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_10 = "ͳ�����#������漰�����������Ҫ��Ϣ�Ƽ���������ͬ����";
var label_YN03_11 = "ͳ�����#����ȷ��������жϻ��쳣�˳�����Ҫ��Ϣ�Ƽ������ͬ����";

var label_YN03_12 = "ͳ�����#���������ִ�к�����ɵ���Ϣ�Ƽ��羳��������ͬ����";
var label_YN03_13 = "ͳ�����#�����漰��������ṩ������";
var label_YN03_14 = "ͳ�����#���������ִ�к�����ɵ���Ϣ�Ƽ���פ����������ͬ����";
var label_YN03_15 = "ͳ�����#�����漰����������ṩ������";
// ��ʼ����
// ͳ���������
var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
var obj_YN03_07 = getTableFormObjs(label_YN03_07)[0];
var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
var obj_YN03_09 = getTableFormObjs(label_YN03_09)[0];
var obj_YN03_10 = getTableFormObjs(label_YN03_10)[0];
var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];

var obj_YN03_12 = getTableFormObjs(label_YN03_12)[0];
var obj_YN03_13 = getTableFormObjs(label_YN03_13)[0];
var obj_YN03_14 = getTableFormObjs(label_YN03_14)[0];
var obj_YN03_15 = getTableFormObjs(label_YN03_15)[0];
/*
 * ���ܣ�У����ʼʱ��ͼƻ����ʱ��Ĵ�С
 *
 */
function checkDate_06_07(obj){
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObjs(label_YN01_07)[0];
	if(obj_YN01_06.value != "" && obj_YN01_07.value != ""){
		if(obj_YN01_06.value < obj_YN01_07.value){
			
		}else{
			obj_YN01_07.value = ""
			alert("��ʼʱ��ӦС�ڼƻ����ʱ�䣡");
		}
	}
	
}
/*
 * ���ܣ�У�������漰��������ṩ�������Ƿ���ڱ��������ִ�к�����ɵ���Ϣ�Ƽ��羳��������ͬ����
 *
 */
function setObj_YN03_13Value(obj) {
	if (parseInt(obj.value) > parseInt(obj_YN03_12.value)) {
		obj.value = "";
		alert("�漰��������ṩ���������ܴ��ڱ���Ⱥ�ͬ��������");
	}
}
/*
 * ���ܣ�У�������漰����������ṩ�������Ƿ���ڱ��������ִ�к�����ɵ���Ϣ�Ƽ���פ����������ͬ����
 * 
 */
function setObj_YN03_15Value(obj) {
	if (parseInt(obj.value) > parseInt(obj_YN03_14.value)) {
		obj.value = "";
		alert("�漰��������ṩ���������ܴ��ڱ���Ⱥ�ͬ��������");
	}
}

/*
 * ���ܣ�ͨ���羳���������������������ִ�к�����ɵ���Ϣ�Ƽ��羳��������ͬ�����ͱ��������ִ�к�����ɵ���Ϣ�Ƽ���פ����������ͬ����
 * ���ã���#��ͬ��Ϣ2#�羳������
 */
function setObj_YN03_12_14Value(obj) {
	var obj_YN02_07Array = getTableFormObjs(label_YN02_07);
	obj_YN03_12.value = 0;
	for ( var i = 0; i < obj_YN02_07Array.length -1; i++) {
		if (obj_YN02_07Array[i].value == "�羳���") {
			obj_YN03_12.value = parseInt(obj_YN03_12.value) + 1;
		}
		
	}
}

/*
 * ���ܣ�ͨ��ʵʩ������������������ִ�к�����ɵ���Ϣ�Ƽ��羳��������ͬ�����ͱ��������ִ�к�����ɵ���Ϣ�Ƽ���פ����������ͬ����
 * ���ã���#��ͬ��Ϣ#ʵʩ���
 */
function setObj_YN03_14Value(obj) {
	var obj_YN02_08Array = getTableFormObjs(label_YN02_08);
	obj_YN03_14.value = 0;
	for ( var i = 0; i < obj_YN02_08Array.length -1; i++) {
		if (obj_YN02_08Array[i].value == "��פ�����") {
			obj_YN03_14.value = parseInt(obj_YN03_14.value) + 1;
		}
		
	}
}
/*
 * ���ܣ�ͨ���Ƿ��������жϻ��쳣�˳�����������ȷ��������жϻ��쳣�˳�����Ҫ��Ϣ�Ƽ������ͬ���� ���ã���#��ͬ��Ϣ2#�Ƿ��������жϻ��쳣�˳�
 */
function setObj_YN03_11Value(obj) {
	var obj_YN02_03Array = getTableFormObjs(label_YN02_03);
	obj_YN03_11.value = 0;
	for ( var i = 0; i < obj_YN02_03Array.length - 1; i++) {
		if (obj_YN02_03Array[i].value == "��") {
			obj_YN03_11.value = parseInt(obj_YN03_11.value) + 1;
		}
	}
}
/*
 * ���ܣ�ͨ����������������������������ִ�е���Ҫ��Ϣ�Ƽ���������ͬ���� ���ã���#��ͬ��Ϣ2#�����������
 */
function setObj_YN03_10Value(obj) {
	var obj_YN02_06Array = getTableFormObjs(label_YN02_06);
	obj_YN03_10.value = 0;
	for ( var i = 0; i < obj_YN02_06Array.length - 1; i++) {
		if (obj_YN02_06Array[i].value != "�ǹ������"
				&& obj_YN02_06Array[i].value != "") {
			obj_YN03_10.value = parseInt(obj_YN03_10.value) + 1;
		}
	}
}

/*
 * ���ܣ�ͨ������������������������������Ҫ��Ϣ�Ƽ���������ͬ���� ���ã���#��ͬ��Ϣ#ִ�����#���������
 */
function setObj_YN03_07Value(obj) {
	var obj_YN01_08_01Array = getTableFormObjs(label_YN01_08_01);
	obj_YN03_07.value = 0;
	for ( var i = 0; i < obj_YN01_08_01Array.length; i++) {
		if (obj_YN01_08_01Array[i].value == "��") {
			obj_YN03_07.value = parseInt(obj_YN03_07.value) + 1;
		}
	}
}

/*
 * ���ܣ�ͨ������Ԫ����������ͬ�ܽ���ֵ�Լ��Լ���ֵ ���ã���#��ͬ��Ϣ2#����Ԫ��
 */
function setObj_YN02_02Value(obj) {
	obj.value = Math.abs(obj.value);
	obj_YN03_05.value = 0;
	var obj_YN02_02Array = getTableFormObjs(label_YN02_02);
	for ( var i = 0; i < obj_YN02_02Array.length; i++) {
		if (obj_YN02_02Array[i].value != "") {
			obj_YN03_05.value = (parseFloat(obj_YN02_02Array[i].value)*100
					+ parseFloat(obj_YN03_05.value)*100)/100;
		}
	}
}

/*
 * ���ܣ�ͨ���������������£�����������������ֵ�Լ��Լ���ֵ ���ã���#��ͬ��Ϣ2#�������������£�
 */
function setObj_YN02_01Value(obj) {
	obj.value = Math.abs(obj.value);
	obj_YN03_06.value = 0;
	var obj_YN02_01Array = getTableFormObjs(label_YN02_01);
	for ( var i = 0; i < obj_YN02_01Array.length; i++) {
		if (obj_YN02_01Array[i].value != "") {
			obj_YN03_06.value = (parseFloat(obj_YN02_01Array[i].value)*100
					+ parseFloat(obj_YN03_06.value)*100)/100;
		}
	}
}
/*
 * ���ܣ�ͨ��ҵ������е���Ϣ�Ƽ������������ҵ������е���Ϣ�Ƽ������Ҫ��Ϣ�Ƽ���������ͬ�����е�ֵ
 * ���ã���#��ͬ��Ϣ#��������#ҵ������е���Ϣ�Ƽ��
 */
function setObj_YN03_03Value(obj) {
	var obj_YN01_02_03Array = getTableFormObjs(label_YN01_02_03);
	obj_YN03_03.value = 0;
	for ( var i = 0; i < obj_YN01_02_03Array.length; i++) {
		if (obj_YN01_02_03Array[i].value != "") {
			obj_YN03_03.value = parseInt(obj_YN03_03.value) + 1;
		}
	}
}

/*
 * ���ܣ�ͨ��ϵͳ����ά����������ϵͳ����ά������Ҫ��Ϣ�Ƽ���������ͬ�����е�ֵ ���ã���#��ͬ��Ϣ#��������#ϵͳ����ά����
 */
function setObj_YN03_02Value(obj) {
	var obj_YN01_02_02Array = getTableFormObjs(label_YN01_02_02);
	obj_YN03_02.value = 0;
	for ( var i = 0; i < obj_YN01_02_02Array.length; i++) {
		if (obj_YN01_02_02Array[i].value != "") {
			obj_YN03_02.value = parseInt(obj_YN03_02.value) + 1;
		}
	}
}

/*
 * ���ܣ�ͨ���з���ѯ���������з���ѯ����Ҫ��Ϣ�Ƽ���������ͬ�����е�ֵ ���ã���#��ͬ��Ϣ#��������#�з���ѯ��
 */
function setObj_YN03_01Value(obj) {
	var obj_YN01_02_01Array = getTableFormObjs(label_YN01_02_01);
	obj_YN03_01.value = 0;
	for ( var i = 0; i < obj_YN01_02_01Array.length; i++) {
		if (obj_YN01_02_01Array[i].value != "") {
			obj_YN03_01.value = parseInt(obj_YN03_01.value) + 1;
		}
	}
}

/*
 * ���ܣ������ִ��״̬���������ʱ���Ƿ��е���¼��Լ���ͬ������ֵ ���ã���#��ͬ��Ϣ#ִ�����#�����ִ��״̬
 */
function setObj_YN01_08_03Disable(obj) {
	var obj_YN01_08_02Array = getTableFormObjs(label_YN01_08_02);
	obj_YN03_04.value = 0;
	obj_YN03_08.value = 0;
	obj_YN03_09.value = 0;
	for ( var i = 0; i < obj_YN01_08_02Array.length; i++) {
		var obj_YN01_08_03 = getTableFormObj(label_YN01_08_03,
				obj_YN01_08_02Array[i].rownumber);
		if (obj_YN01_08_02Array[i].value == "���") {
			obj_YN01_08_03.onclick = click_columnshowDate;
		} else {
			obj_YN01_08_03.value = "";
			obj_YN01_08_03.onclick = "";
		}
		setYN_04_08_09Value(obj_YN01_08_02Array, i);
	}

}
/*
 * ���ܣ������ִ��״̬��������ͬ������ֵ ���ã���#��ͬ��Ϣ#ִ�����#�����ִ��״̬
 */
function setYN_04_08_09Value(objArray, index) {

	if (objArray[index].value != "") {
		obj_YN03_04.value = parseInt(obj_YN03_04.value) + 1;
		if (objArray[index].value == "ִ����") {
			obj_YN03_08.value = parseInt(obj_YN03_08.value) + 1;
		}
		if (objArray[index].value == "���") {
			obj_YN03_09.value = parseInt(obj_YN03_09.value) + 1;
		}

	}
}
/*
 * ��ʼ��
 */
function initSet() {
	var obj = 0;
	setObj_YN01_08_03Disable(obj);
	// ͳ�����ֻ��
	obj_YN03_01.readOnly = "readonly";
	obj_YN03_02.readOnly = "readonly";
	obj_YN03_03.readOnly = "readonly";
	obj_YN03_04.readOnly = "readonly";
	obj_YN03_05.readOnly = "readonly";
	obj_YN03_06.readOnly = "readonly";
	obj_YN03_07.readOnly = "readonly";
	obj_YN03_08.readOnly = "readonly";
	obj_YN03_09.readOnly = "readonly";
	obj_YN03_10.readOnly = "readonly";
	obj_YN03_11.readOnly = "readonly";
	obj_YN03_12.readOnly = "readonly";
	obj_YN03_14.readOnly = "readonly";
	// ͳ�������ʼ��
	if(obj_YN03_01.value == ""){
		obj_YN03_01.value = 0;
	}
	if(obj_YN03_02.value == ""){
		obj_YN03_02.value = 0;
	}
	if(obj_YN03_03.value == ""){
		obj_YN03_03.value = 0;
	}
	if(obj_YN03_04.value == ""){
		obj_YN03_04.value = 0;
	}
	if(obj_YN03_07.value == ""){
		obj_YN03_07.value = 0;
	}
	if(obj_YN03_08.value == ""){
		obj_YN03_08.value = 0;
	}
	if(obj_YN03_09.value == ""){
		obj_YN03_09.value = 0;
	}
	if(obj_YN03_10.value == ""){
		obj_YN03_10.value = 0;
	}
	if(obj_YN03_11.value == ""){
		obj_YN03_11.value = 0;
	}
	if(obj_YN03_12.value == ""){
		obj_YN03_12.value = 0;
	}
	if(obj_YN03_14.value == ""){
		obj_YN03_14.value = 0;
	}

}

/*
 * ���ܣ��ύУ��
 */
function checkData() {
	a = "";
	isValid = true;
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	var obj_YN03_12 = getTableFormObj(label_YN03_12,1);
	var obj_YN03_13 = getTableFormObj(label_YN03_13,1);
	var obj_YN03_14 = getTableFormObj(label_YN03_14,1);
	var obj_YN03_15 = getTableFormObj(label_YN03_15,1);
	var emptyObj = getTableFormObjs(label_empty)[0];
	if (emptyObj.value == "") {
		if(parseInt(obj_YN03_12.value)<parseInt(obj_YN03_13.value)){
			errorObjs.push(obj_YN03_13);
			a += "���������ִ�к�����ɵ���Ϣ�Ƽ��羳��������ͬ����Ӧ���������漰��������ṩ������\n";
			isValid = false;
		}
		if(parseInt(obj_YN03_14.value)<parseInt(obj_YN03_15.value)){
			errorObjs.push(obj_YN03_15);
			a += "���������ִ�к�����ɵ���Ϣ�Ƽ���פ����������ͬ����Ӧ���������漰����������ṩ������\n";
			isValid = false;
		}
		if (!isValid && a > "") {
			for ( var i = 0; i < errorObjs.length; i++) {
				if (errorObjs[i].previousSibling == null ) {
					errorObjs[i].style.backgroundColor = "red";
				}else if(errorObjs[i].previousSibling.innerHTML.indexOf("����")>-1){
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
	} else if (emptyObj.value == "���Ϳձ�") {
		var obj_YN00_01 = getTableFormObj(label_YN00_01,"1");
		var obj_YN00_02 = getTableFormObj(label_YN00_02,"1");
		var obj_YN00_03 = getTableFormObj(label_YN00_03,"1");
		var obj_YN00_04 = getTableFormObj(label_YN00_04,"1");
		var obj_YN00_05 = getTableFormObj(label_YN00_05,"1");
		if(obj_YN00_01.value == ""){
			a += "��������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_02.value == ""){
			a += "������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_03.value == ""){
			a += "��ϵ�绰���ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_04.value == ""){
			a += "���������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_05.value == ""){
			a += "����������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(!isValid){
			alert(a);
		}
	}
	
	return isValid;
}

/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio1(obj, access, flag) {
	if (!access) {
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					if (!access) {
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setYN10_05Disable(this);
							};
						}
					}
				}
			}
		}
	}
}
/**
 * ��ģʽ���ʽ��ɾ����
 * 
 * @param obj
 *            �¼�Դ����
 */
function deleteGroup(obj) {
	// Ŀ��table����
	var tb = obj.parentElement.parentElement;
	// ��Ҫ�����б�ʶ�������ǰ��ΪΨһ�����У�����Ҫ����һ�У�Ȼ����ɾ������
	var index = 0;
	for ( var i = 0; i < tb.rows.length; i++) {
		if (tb.rows[i].name != "titlerow" && tb.rows[i].name != "titletr") {
			index++;
		}
	}
	if (index == 2) {
		alert("\u6700\u540e\u4e00\u7ec4\u4e0d\u53ef\u5220\u9664\uff01");
		return;
	}
	// �к�
	var rowIndex = obj.rowIndex;
	tb.deleteRow(rowIndex);
	shortGroup(tb);
	var onDel = tb.onDel;
	if (onDel) {
		onDel();
	}
	// ���¸�һЩֵ��ֵ
	var obj_YN01_08_02Array = getTableFormObjs(label_YN01_08_02);
	obj_YN03_04.value = 0;
	obj_YN03_08.value = 0;
	obj_YN03_09.value = 0;
	for ( var i = 0; i < obj_YN01_08_02Array.length; i++) {
		setYN_04_08_09Value(obj_YN01_08_02Array, i);
	}
	setObj_YN03_07Value(0);
	setObj_YN03_01Value(0);
	setObj_YN03_02Value(0);
	setObj_YN03_03Value(0);
	setObj_YN02_01Value(0);
	setObj_YN02_02Value(0);
	setObj_YN03_10Value(0);
	setObj_YN03_11Value(0);
	setObj_YN03_12_14Value(0);
}

/*
 * ���ܣ��жϱ������Ƿ����100
 */
function checkPercent(obj) {
	if (obj.value > 100 || obj.value < 0) {
		obj.value = "";
		alert("������0-100����ֵ");
	}

}
jQuery("span").css("float","");