/*
 * ����2014-T-Q-2 ��Ϣ�Ƽ���Ŀ����� 
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN00 = "���Ϳձ���#���Ϳձ�";
var label_YN01 = "�������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����";
var label_YN02 = "�������������ش���Ŀ#�������������ش���Ŀ#������ʵʩ���";

var label_YN01_01 = "����#�����";
var label_YN01_02 = "����#���";
var label_YN01_03 = "����#��ϵ�绰";
var label_YN01_04 = "����#������";
var label_YN01_05 = "����#�������";

var label_YN03_01_01 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#��������#ϵͳ���";
var label_YN03_01_02 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#ϵͳ���";
var label_YN03_01_03 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#ϵͳ���";
var label_YN03_01_04 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#�������#ϵͳ���";
var label_YN03_01_05 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���";
var label_YN03_01_06 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���";
var label_YN03_01_07 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#ϵͳ���";
var label_YN03_01_08 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����#ϵͳ���";

var label_YN03_02_01 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#��������#�����";
var label_YN03_02_02 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#�����";
var label_YN03_02_03 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#�����";
var label_YN03_02_04 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#�������#�����";
var label_YN03_02_05 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#�����";
var label_YN03_02_06 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#�����";
var label_YN03_02_07 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#�����";
var label_YN03_02_08 = "�������������ش���Ŀ#�������������ش���Ŀ#��������#����#�����";

var label_YN04 = "�������������ش���Ŀ#�������������ش���Ŀ#��ͬ���";

var label_YN05_01 = "�������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����#�ƻ���������#�ƻ���������";
var label_YN05_02 = "�������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����#��Ŀ��ʼ����#��Ŀ��ʼ����";
var label_YN05_03 = "�������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����#ʵ���������#ʵ���������";

var label_YN06 = "�������������ش���Ŀ#�������������ش���Ŀ#ʵʩģʽ";

var label_YN07 = "�������������ش���Ŀ#�������������ش���Ŀ#��Ŀ���ݼ���";

var label_YN08 = "�������������ش���Ŀ#�������������ش���Ŀ#��ע";

/*
 * ���ܣ�ͨ��ϵͳ����Ƿ���������������Ƿ�ֻ��
 */
function setCheckBoxDisable(obj) {
	setCheckBoxDisable1(obj.parentElement.nextSibling);
	var label_obj = "�������������ش���Ŀ#�������������ش���Ŀ#��������#" + obj.value + "#�����";
	var checkBoxObj = getTableFormCheckBox(label_obj,
			obj.parentElement.nextSibling.rownumber);
	if (obj.parentElement.nextSibling.value != "") {
		disableTableCheckBox(checkBoxObj, false);
	} else {
		disableTableCheckBox(checkBoxObj, true);
	}
}

function setObj_YN03_02_08Disable(obj) {
	var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
			obj.parentElement.nextSibling.rownumber);
	if (obj.parentElement.nextSibling.value != "") {
		obj_YN03_02_08.readOnly = "";
	} else {
		obj_YN03_02_08.readOnly = "readonly";
		obj_YN03_02_08.value = "";
	}
	setCheckBoxDisable1(obj.parentElement.nextSibling);
}

/*
 * ���ܣ��ύ��ťУ��
 * 
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
		if(errorObjs[i].previousSibling !=null){			
			errorObjs[i].previousSibling.style.color = "";
		}
	}
	errorObjs = [];
	var emptyObj = getTableFormObjs(label_YN00)[0];
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for ( var i = 0; i < obj_YN01Arr.length - 1; i++) {
		// ��Ŀ����У��
		var obj_YN01 = obj_YN01Arr[i];
		if (obj_YN01.value != "" && obj_YN01.value != "��") {
			// ������ʵʩ���У��
			var row = obj_YN01.rownumber.substring(0, obj_YN01.rownumber
					.indexOf("_"));
			var obj_YN02 = getTableFormObj(label_YN02, obj_YN01.rownumber);
			if (obj_YN02.value == "") {
				isValid = false;
				errorObjs.push(obj_YN02);
				a += "�������ش���Ŀ" + row + "��������ʵʩ�������Ϊ�գ�\n";
			}
			// ϵͳ���У��
			var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_03 = getTableFormObj(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_04 = getTableFormObj(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_05 = getTableFormObj(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_06 = getTableFormObj(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_07 = getTableFormObj(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_08 = getTableFormObj(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			if (obj_YN03_01_01.value == "" && obj_YN03_01_02.value == ""
					&& obj_YN03_01_03.value == "" && obj_YN03_01_04.value == ""
					&& obj_YN03_01_05.value == "" && obj_YN03_01_06.value == ""
					&& obj_YN03_01_07.value == "" && obj_YN03_01_08.value == "") {
				isValid = false;
				errorObjs.push(obj_YN03_01_01);
				errorObjs.push(obj_YN03_01_02);
				errorObjs.push(obj_YN03_01_03);
				errorObjs.push(obj_YN03_01_04);
				errorObjs.push(obj_YN03_01_05);
				errorObjs.push(obj_YN03_01_06);
				errorObjs.push(obj_YN03_01_07);
				errorObjs.push(obj_YN03_01_08);
				obj_YN03_01_08.previousSibling.style.color = "red";
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ������ϵͳ�����Ϊ�գ�\n";
			}else{
				//�����У��
				var obj_YN03_02_01 = getTableFormObj(label_YN03_02_01,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_02 = getTableFormObj(label_YN03_02_02,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_03 = getTableFormObj(label_YN03_02_03,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_04 = getTableFormObj(label_YN03_02_04,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_05 = getTableFormObj(label_YN03_02_05,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_06 = getTableFormObj(label_YN03_02_06,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_07 = getTableFormObj(label_YN03_02_07,
						obj_YN01.rownumber + "_1_1");
				var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
						obj_YN01.rownumber + "_1_1");
				if (obj_YN03_02_01.value == "" && obj_YN03_02_02.value == ""
						&& obj_YN03_02_03.value == "" && obj_YN03_02_04.value == ""
						&& obj_YN03_02_05.value == "" && obj_YN03_02_06.value == ""
						&& obj_YN03_02_07.value == "" && obj_YN03_02_08.value == "") {
					isValid = false;
					if(obj_YN03_01_01.value != "" && obj_YN03_02_01.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_01);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_02.value != "" && obj_YN03_02_02.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_02);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_03.value != "" && obj_YN03_02_03.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_03);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_04.value != "" && obj_YN03_02_04.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_04);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_05.value != "" && obj_YN03_02_05.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_05);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_06.value != "" && obj_YN03_02_06.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_06);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰹���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_07.value != "" && obj_YN03_02_07.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_07);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰻�����ʩ��ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
					if(obj_YN03_01_08.value != "" && obj_YN03_02_08.value == "" ){
						isValid = false;
						errorObjs.push(obj_YN03_02_08);
						a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�ѡ��������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
					}
				}
			}
			//��ͬ���У��
			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			if(obj_YN04.value == ""){
				isValid = false;
				errorObjs.push(obj_YN04);
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ�������ͬ����Ϊ�գ�\n";
			}
			
			//��Ŀ����У��
			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			if(obj_YN05_01.value ==""){
				isValid = false;
				errorObjs.push(obj_YN05_01);
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ������ƻ��������ڲ���Ϊ�գ�\n";
			}
			
			if(obj_YN05_02.value == ""){
				isValid = false;
				errorObjs.push(obj_YN05_02);
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ��������Ŀ��ʼ���ڲ���Ϊ�գ�\n";
			}
			if(obj_YN02.value == "���" && obj_YN05_03.value == ""){
				isValid = false;
				errorObjs.push(obj_YN05_03);
				a += "�������ش���Ŀ" + row + "��������ʵʩ���Ϊ������ɡ��������ʵ�����ʱ�䲻��Ϊ�գ�\n";
			}
			if(obj_YN05_03.value != "" &&obj_YN05_02.value != ""){
				
				if(obj_YN05_03.value<obj_YN05_02.value){
					isValid = false;
					errorObjs.push(obj_YN05_03);
					a += "�������ش���Ŀ" + row + "����ʵ��������ڡ���Ӧ���ڡ��ƻ��������ڡ���\n";
				}
			}
			if(obj_YN05_01.value !="" && obj_YN05_02.value != ""){
				if(obj_YN05_01.value<obj_YN05_02.value){
					isValid = false;
					errorObjs.push(obj_YN05_01);
					a += "�������ش���Ŀ" + row + "������Ŀ��ʼ���ڡ���ӦС�ڡ��ƻ��������ڡ���\n";
				}
			}
			//ʵʩģʽУ��
			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			if(obj_YN06.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06);
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ������ʵʩģʽ����Ϊ�գ�\n";
			}
			
			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber);
			if(obj_YN07.value == ""){
				isValid = false;
				errorObjs.push(obj_YN07.previousSibling);
				a += "�������ش���Ŀ" + row + "�����Ʋ�Ϊ���ޡ���գ��������Ŀ������������Ϊ�գ�\n";
			}
		} else if (obj_YN01.value == "" &&emptyObj.value == "") {
			isValid = false;
			errorObjs.push(obj_YN01);
			a += "��Ŀ���Ʋ���Ϊ�գ�\n";
		}
	}

	// У�鸴ѡ�������Ƿ���ֵ
	for ( var i = 0; i < checkBoxValueObjs.length; i++) {
		var checkBoxObj = checkBoxValueObjs[i];
		if (checkBoxObj.checked) {
			var checkBoxObjValueObj = checkBoxObj.parentElement.nextSibling.nextSibling;
			if (checkBoxObjValueObj.value.indexOf("_cev_") < 0) {
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a += "���������ݲ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
	
	if (emptyObj.value == "") {
		if (!isValid && a > "") {
			for ( var i = 0; i < errorObjs.length; i++) {
				if (errorObjs[i].previousSibling == null) {
					errorObjs[i].style.backgroundColor = "red";
				}else if(errorObjs[i].previousSibling.innerHTML.indexOf("����")>-1){
					errorObjs[i].style.backgroundColor = "red";
				}  else {
					errorObjs[i].parentNode.style.color = "red";
				}
			}
			alert(a);
			a = "";
			isValid = true;
			return false;
		}
	} else if (emptyObj.value == "���Ϳձ�") {
		isValid = true;
		var obj_YN01_01 = getTableFormObj(label_YN01_01,"1");
		var obj_YN01_02 = getTableFormObj(label_YN01_02,"1");
		var obj_YN01_03 = getTableFormObj(label_YN01_03,"1");
		var obj_YN01_04 = getTableFormObj(label_YN01_04,"1");
		var obj_YN01_05 = getTableFormObj(label_YN01_05,"1");
		if(obj_YN01_01.value == ""){
			a += "��������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_02.value == ""){
			a += "������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_03.value == ""){
			a += "��ϵ�绰���ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_04.value == ""){
			a += "���������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN01_05.value == ""){
			a += "����������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(!isValid){
			alert(a);
			a="";
		}
	}
	return isValid;
}

/*
 * ���ܣ���Ŀ������ֵ�����������ܿ������ֻ�� ���ã��������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����
 */
function setOtherUnDisable(obj) {
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for ( var i = 0; i < obj_YN01Arr.length; i++) {
		if (obj_YN01Arr[i].value != "" && obj_YN01Arr[i].value != "��") {
			
			var obj_YN01 = obj_YN01Arr[i];
			var obj_YN02 = getTableFormCheckBox(label_YN02, obj_YN01.rownumber);
			disableTableCheckBox(obj_YN02, false);
			var obj_YN03_01_01 = getTableFormCheckBox(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_011 = getTableFormObj(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_01, false);
			var obj_YN03_01_02 = getTableFormCheckBox(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_021 = getTableFormObj(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_02, false);
			var obj_YN03_01_03 = getTableFormCheckBox(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_031 = getTableFormObj(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_03, false);
			var obj_YN03_01_04 = getTableFormCheckBox(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_041 = getTableFormObj(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_04, false);
			var obj_YN03_01_05 = getTableFormCheckBox(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_051 = getTableFormObj(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_05, false);
			var obj_YN03_01_06 = getTableFormCheckBox(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_061 = getTableFormObj(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_06, false);
			var obj_YN03_01_07 = getTableFormCheckBox(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_071 = getTableFormObj(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_07, false);
			var obj_YN03_01_08 = getTableFormCheckBox(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			var obj_YN03_01_081 = getTableFormObj(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_08, false);
			
			var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
					obj_YN01.rownumber + "_1_1");
		
			var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
					obj_YN01.rownumber + "_1_1");
			
			var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
					obj_YN01.rownumber + "_1_1");
			
			
			if (obj_YN03_01_011.value) {
				disableTableCheckBox(obj_YN03_02_01, false);
			} else {
				disableTableCheckBox(obj_YN03_02_01, true);
			}

			if (obj_YN03_01_021.value) {
				disableTableCheckBox(obj_YN03_02_02, false);
			} else {
				disableTableCheckBox(obj_YN03_02_02, true);
			}
			if (obj_YN03_01_031.value) {
				disableTableCheckBox(obj_YN03_02_03, false);
			} else {
				disableTableCheckBox(obj_YN03_02_03, true);
			}

			if (obj_YN03_01_041.value ) {
				disableTableCheckBox(obj_YN03_02_04, false);
			} else {
				disableTableCheckBox(obj_YN03_02_04, true);
			}

			if (obj_YN03_01_051.value ) {
				disableTableCheckBox(obj_YN03_02_05, false);
			} else {
				disableTableCheckBox(obj_YN03_02_05, true);
			}

			if (obj_YN03_01_061.value) {
				disableTableCheckBox(obj_YN03_02_06, false);
			} else {
				disableTableCheckBox(obj_YN03_02_06, true);
			}

			if (obj_YN03_01_071.value ) {
				disableTableCheckBox(obj_YN03_02_07, false);
			} else {
				disableTableCheckBox(obj_YN03_02_07, true);
			}

			if (obj_YN03_01_081.value) {
				obj_YN03_02_08.readOnly = "";
			} else {
				obj_YN03_02_08.readOnly = "readonly";
				
			}

			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			obj_YN04.readOnly = "";

			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			obj_YN05_01.onclick = click_columnshowDate;
			obj_YN05_02.onclick = click_columnshowDate;
			obj_YN05_03.onclick = click_columnshowDate;
			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			columnVallueRadio0(obj_YN06, true, false);

			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber).previousSibling;
			var obj_YN08 = getTableFormObj(label_YN08, obj_YN01.rownumber).previousSibling;
			obj_YN07.contentEditable = "true";
			obj_YN08.contentEditable = "true";
		} else {
			var obj_YN01 = obj_YN01Arr[i];
			var obj_YN02 = getTableFormCheckBox(label_YN02, obj_YN01.rownumber);
			disableTableCheckBox(obj_YN02, true);
			var obj_YN03_01_01 = getTableFormCheckBox(label_YN03_01_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_01, true);
			var obj_YN03_01_02 = getTableFormCheckBox(label_YN03_01_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_02, true);
			var obj_YN03_01_03 = getTableFormCheckBox(label_YN03_01_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_03, true);
			var obj_YN03_01_04 = getTableFormCheckBox(label_YN03_01_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_04, true);
			var obj_YN03_01_05 = getTableFormCheckBox(label_YN03_01_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_05, true);
			var obj_YN03_01_06 = getTableFormCheckBox(label_YN03_01_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_06, true);
			var obj_YN03_01_07 = getTableFormCheckBox(label_YN03_01_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_07, true);
			var obj_YN03_01_08 = getTableFormCheckBox(label_YN03_01_08,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_01_08, true);

			var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_01, true);
			var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_02, true);
			var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_03, true);
			var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_04, true);
			var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_05, true);
			var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_06, true);
			var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
					obj_YN01.rownumber + "_1_1");
			disableTableCheckBox(obj_YN03_02_07, true);
			var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
					obj_YN01.rownumber + "_1_1");
			obj_YN03_02_08.readOnly = "readonly";
			obj_YN03_02_08.value = "";

			var obj_YN04 = getTableFormObj(label_YN04, obj_YN01.rownumber);
			obj_YN04.readOnly = "readonly";
			obj_YN04.value = "";

			var obj_YN05_01 = getTableFormObj(label_YN05_01, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN01.rownumber
					+ "_1_1");
			var obj_YN05_03 = getTableFormObj(label_YN05_03, obj_YN01.rownumber
					+ "_1_1");
			obj_YN05_01.onclick = "";
			obj_YN05_02.onclick = "";
			obj_YN05_03.onclick = "";
			obj_YN05_01.value = "";
			obj_YN05_02.value = "";
			obj_YN05_03.value = "";

			var obj_YN06 = getTableFormObj(label_YN06, obj_YN01.rownumber);
			columnVallueRadio0(obj_YN06, false, false);
			obj_YN06.value = "";

			var obj_YN07 = getTableFormObj(label_YN07, obj_YN01.rownumber).previousSibling;
			var obj_YN08 = getTableFormObj(label_YN08, obj_YN01.rownumber).previousSibling;
			obj_YN07.innerHTML = "";
			obj_YN08.innerHTML = "";
			obj_YN07.contentEditable = "false";
			obj_YN08.contentEditable = "false";
		}
	}

}
/*
 * ���ܣ����ϵͳ���������checked��Ϊfalse����������ϵͳ����������Ƿ�Ϊֻ��
 */
function setCheckBoxDisable1(obj_YN01) {
	var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_01) {
		obj_YN03_01_01.value = "";
		obj_YN03_01_01.previousSibling.firstChild.checked = false;
		var obj_YN03_02_01 = getTableFormCheckBox(label_YN03_02_01,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_01, true);
	}

	var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_02) {
		obj_YN03_01_02.value = "";
		obj_YN03_01_02.previousSibling.firstChild.checked = false;
		var obj_YN03_02_02 = getTableFormCheckBox(label_YN03_02_02,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_02, true);
	}

	var obj_YN03_01_03 = getTableFormObj(label_YN03_01_03, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_03) {
		obj_YN03_01_03.value = "";
		obj_YN03_01_03.previousSibling.firstChild.checked = false;
		var obj_YN03_02_03 = getTableFormCheckBox(label_YN03_02_03,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_03, true);
	}

	var obj_YN03_01_04 = getTableFormObj(label_YN03_01_04, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_04) {
		obj_YN03_01_04.value = "";
		obj_YN03_01_04.previousSibling.firstChild.checked = false;
		var obj_YN03_02_04 = getTableFormCheckBox(label_YN03_02_04,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_04, true);
	}

	var obj_YN03_01_05 = getTableFormObj(label_YN03_01_05, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_05) {
		obj_YN03_01_05.value = "";
		obj_YN03_01_05.previousSibling.firstChild.checked = false;
		var obj_YN03_02_05 = getTableFormCheckBox(label_YN03_02_05,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_05, true);
	}

	var obj_YN03_01_06 = getTableFormObj(label_YN03_01_06, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_06) {
		obj_YN03_01_06.value = "";
		obj_YN03_01_06.previousSibling.firstChild.checked = false;
		var obj_YN03_02_06 = getTableFormCheckBox(label_YN03_02_06,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_06, true);
	}

	var obj_YN03_01_07 = getTableFormObj(label_YN03_01_07, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_07) {
		obj_YN03_01_07.value = "";
		obj_YN03_01_07.previousSibling.firstChild.checked = false;
		var obj_YN03_02_07 = getTableFormCheckBox(label_YN03_02_07,
				obj_YN01.rownumber);
		disableTableCheckBox(obj_YN03_02_07, true);
	}

	var obj_YN03_01_08 = getTableFormObj(label_YN03_01_08, obj_YN01.rownumber);
	if (obj_YN01 != obj_YN03_01_08) {
		obj_YN03_01_08.value = "";
		obj_YN03_01_08.previousSibling.firstChild.checked = false;
		var obj_YN03_02_08 = getTableFormObj(label_YN03_02_08,
				obj_YN01.rownumber);
		obj_YN03_02_08.readOnly = "readonly";
		obj_YN03_02_08.value = "";
	}
}

/*
 * ���ܣ���ʼ��
 */
function initSet() {
	setOtherUnDisable();
}

/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio0(obj, access, flag) {
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
/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * ���ܣ������ѡ��ѡ���е�������������������У����ύ��ʱ��У�������������Ƿ�Ϊ��
 * 
 */
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj) {
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if (obj.checked) {
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	} else {
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for ( var i = 0; i < strs.length; i++) {
			if (strs[i].indexOf("_cev_") < 0) {
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);

	}
}