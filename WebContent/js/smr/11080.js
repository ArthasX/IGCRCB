/*
 * ����T-B-10 ��Ҫ��Ϣϵͳ���������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

// ������Ҫ��Ϣϵͳ��ϸ���
var label_YN02_02_01 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#����ģʽ#����ģʽ";
var label_YN02_02_02 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#����ģʽ#���������";
var label_YN02_03_01 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#��άģʽ#��άģʽ";
var label_YN02_03_02 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#��άģʽ#���������";
var label_YN02_04_01 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#֪ʶ��Ȩ#֪ʶ��Ȩ";
var label_YN02_04_02 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#1#֪ʶ��Ȩ#���з�����";

var label_YN03_03 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#2#�й����ⲿ����#�й����ⲿ����";
var label_YN03_04 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#2#�й����ⲿ����#�йܻ�������";

var label_YN04_03 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#3#����������ر���#����������ر���";
var label_YN04_04 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#1#ϵͳ���#3#����������ر���#����ص�";

var label_YN05_03 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#2#11#����ȿ�չӦ������#����ȿ�չӦ������";
var label_YN05_04 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#2#11#����ȿ�չӦ������#��������";

var label_YN03 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ����";

var label_YN06_01_01 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#2#11#�ֱ����#�ֱ����#ͬ������ֱ�";
var label_YN06_02_01 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#2#11#�ֱ����#�ֱ����#1#ͬ��";
var label_YN06_02_02 = "������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#2#11#�ֱ����#�ֱ����#1#���";

var label_YN01_01_01 = "��Ҫ��Ϣϵͳ�������#����#��Ŀ����#��Ҫ��Ϣϵͳ����";

var label_YN01_02_01 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#����������";
var label_YN01_02_02 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#�ͻ�������";
var label_YN01_02_03 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#��Ʒ������";
var label_YN01_02_04 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#���������";
var label_YN01_02_05 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#����֧����";
var label_YN01_02_06 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#����֧����";
var label_YN01_02_07 = "��Ҫ��Ϣϵͳ�������#���#��Ŀ����#����";

var label_YN01_05_01 = "��Ҫ��Ϣϵͳ�������#����ģʽ#��Ŀ����#�����з�";
var label_YN01_05_02 = "��Ҫ��Ϣϵͳ�������#����ģʽ#��Ŀ����#�������";
var label_YN01_05_03 = "��Ҫ��Ϣϵͳ�������#����ģʽ#��Ŀ����#�������";

var label_YN01_06_01 = "��Ҫ��Ϣϵͳ�������#��άģʽ#��Ŀ����#������ά";
var label_YN01_06_02 = "��Ҫ��Ϣϵͳ�������#��άģʽ#��Ŀ����#�������";
var label_YN01_06_03 = "��Ҫ��Ϣϵͳ�������#��άģʽ#��Ŀ����#�������";

var label_YN01_07_01 = "��Ҫ��Ϣϵͳ�������#֪ʶ��Ȩ#��Ŀ����#����";
var label_YN01_07_02 = "��Ҫ��Ϣϵͳ�������#֪ʶ��Ȩ#��Ŀ����#����";
var label_YN01_07_03 = "��Ҫ��Ϣϵͳ�������#֪ʶ��Ȩ#��Ŀ����#����";

var label_YN01_04_01 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#�����ֱ�����Ҫ��Ϣϵͳ��";
var label_YN01_04_02 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#���У�ʵ�����ݼ��ֱ�";
var label_YN01_04_03 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#ʵ��ϵͳ���ֱ�";
var label_YN01_04_04 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#ʵ��Ӧ�ü��ֱ�";
var label_YN01_04_05 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#������ͬ���ֱ�";
var label_YN01_04_06 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#����������ֱ�";
var label_YN01_04_07 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#����ͬ������������ֱ�";

var label_YN01_04_16 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#���ƶ�Ӧ��Ԥ������Ҫ��Ϣϵͳ��";
var label_YN01_04_17 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#��Ҫ��ϢϵͳӦ��Ԥ��������";
var label_YN01_04_18 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#������ѿ�չӦ����������Ҫ��Ϣϵͳ��";
var label_YN01_04_19 = "��Ҫ��Ϣϵͳ�������#�ֱ����#��Ŀ����#�������Ҫ��ϢϵͳӦ������������";
/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#�ֱ����#�ֱ����#ͬ���ֱ�#�ֱ���
 */
function setObj_YN06_02_01Or02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.value == "ͬ���ֱ�") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN06_01_01 = getTableFormObj(label_YN06_01_01,rownumber);
			obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,obj_YN06_01_01.rownumber+"_1");
			obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,obj_YN06_01_01.rownumber+"_1");
			if(obj_YN06_01_01.value.indexOf("ͬ")>-1){
				columnVallueRadio1(obj_YN06_02_01,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_01,false,false);
				obj_YN06_02_01.value = "";
			}
			if(obj_YN06_01_01.value.indexOf("��")>-1){
				columnVallueRadio1(obj_YN06_02_02,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_02,false,false);
				obj_YN06_02_02.value = "";
			}
		}
	}else{
		var obj_YN06_01_01Arr = getTableFormObjs(label_YN06_01_01);
		for ( var i = 0; i < obj_YN06_01_01Arr.length; i++) {
			obj_YN06_01_01 = obj_YN06_01_01Arr[i];
			obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,obj_YN06_01_01.rownumber+"_1");
			obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,obj_YN06_01_01.rownumber+"_1");
			if(obj_YN06_01_01.value.indexOf("ͬ")>-1){
				columnVallueRadio1(obj_YN06_02_01,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_01,false,false);
				obj_YN06_02_01.value = "";
			}
			if(obj_YN06_01_01.value.indexOf("��")>-1){
				columnVallueRadio1(obj_YN06_02_02,true,false);
			}else{
				columnVallueRadio1(obj_YN06_02_02,false,false);
				obj_YN06_02_02.value = "";
			}
		}
	}
	
	
}


/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#���Ĳ�#����ȿ�չӦ������#��������
 */
function setObj_YN05_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN05_03 = getTableFormObj(label_YN05_03,rownumber);
			var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
			if (obj_YN05_03.value == "��") {
				obj_YN05_04.readOnly = "";
			} else {

				obj_YN05_04.readOnly = "readonly";
				obj_YN05_04.value = "";
			}
		}
	}else{
		var obj_YN05_03Arr = getTableFormObjs(label_YN05_03);
		for ( var i = 0; i < obj_YN05_03Arr.length; i++) {
			var obj_YN05_03 = obj_YN05_03Arr[i];
			var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
			if (obj_YN05_03.value == "��") {
				obj_YN05_04.readOnly = "";
			} else {

				obj_YN05_04.readOnly = "readonly";
				obj_YN05_04.value = "";
			}
		}
	}
	
	

}

/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#������#����������ر���#����ص�
 */
function setObj_YN04_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN04_03 = getTableFormObj(label_YN04_03,rownumber);
			var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
			if (obj_YN04_03.value == "��") {
				obj_YN04_04.readOnly = "";
			} else {

				obj_YN04_04.readOnly = "readonly";
				obj_YN04_04.value = "";
			}
		}
	}else{
		var obj_YN04_03Arr = getTableFormObjs(label_YN04_03);
		for ( var i = 0; i < obj_YN04_03Arr.length; i++) {
			var obj_YN04_03 = obj_YN04_03Arr[i];
			var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
			if (obj_YN04_03.value == "��") {
				obj_YN04_04.readOnly = "";
			} else {

				obj_YN04_04.readOnly = "readonly";
				obj_YN04_04.value = "";
			}
		}
	}
	
	

}

/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#�ڶ���#�й����ⲿ����#�йܻ�������
 */
function setObj_YN03_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN03_03 = getTableFormObj(label_YN03_03,rownumber);
			var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
			if (obj_YN03_03.value == "��") {
				obj_YN03_04.readOnly = "";
			} else {

				obj_YN03_04.readOnly = "readonly";
				obj_YN03_04.value = "";
			}
		}
	}else{
		var obj_YN03_03Arr = getTableFormObjs(label_YN03_03);
		for ( var i = 0; i < obj_YN03_03Arr.length; i++) {
			var obj_YN03_03 = obj_YN03_03Arr[i];
			var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
			if (obj_YN03_03.value == "��") {
				obj_YN03_04.readOnly = "";
			} else {

				obj_YN03_04.readOnly = "readonly";
				obj_YN03_04.value = "";
			}
		}
	}
	
	
	
}

/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#�ڶ���#��άģʽ#��άģʽ
 */
function setLabel_YN02_04_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "����") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "����"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_04_01 = getTableFormObj(label_YN02_04_01,rownumber);
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
					obj_YN02_04_01.rownumber);
			if (obj_YN02_04_01.value == "����" || obj_YN02_04_01.value == "����") {
				obj_YN02_04_02.readOnly = "";
				obj_YN02_04_02.value = "";
			} else {
				obj_YN02_04_02.readOnly = "readonly";
				obj_YN02_04_02.value = "";
			}
		}
	}else{
		var obj_YN02_04_01Arr = getTableFormObjs(label_YN02_04_01);
		for ( var i = 0; i < obj_YN02_04_01Arr.length; i++) {
			var obj_YN02_04_01 = obj_YN02_04_01Arr[i];
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
					obj_YN02_04_01.rownumber);
			if (obj_YN02_04_01.value == "����" || obj_YN02_04_01.value == "����") {
				obj_YN02_04_02.readOnly = "";
			} else {
				obj_YN02_04_02.readOnly = "readonly";
				obj_YN02_04_02.value = "";
			}
		}
	}
	
	

}

/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#�ڶ���#��άģʽ#��άģʽ
 */
function setLabel_YN02_03_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "������ά") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "�������"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_03_01 = getTableFormObj(label_YN02_03_01,rownumber);
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
					obj_YN02_03_01.rownumber);
			if (obj_YN02_03_01.value == "�������" || obj_YN02_03_01.value == "�������") {
				obj_YN02_03_02.readOnly = "";
				obj_YN02_03_02.value = "";
			} else {
				obj_YN02_03_02.readOnly = "readonly";
				obj_YN02_03_02.value = "";
			}
		}
	}else{
		var obj_YN02_03_01Arr = getTableFormObjs(label_YN02_03_01);
		for ( var i = 0; i < obj_YN02_03_01Arr.length; i++) {
			var obj_YN02_03_01 = obj_YN02_03_01Arr[0];
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
					obj_YN02_03_01.rownumber);
			if (obj_YN02_03_01.value == "�������" || obj_YN02_03_01.value == "�������") {
				obj_YN02_03_02.readOnly = "";

			} else {
				obj_YN02_03_02.readOnly = "readonly";
				obj_YN02_03_02.value = "";
			}
		}
	}
}

/*
 * ���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д ���ã�������Ҫ��Ϣϵͳ��ϸ���#���#ϵͳ���#��һ��#����ģʽ#����ģʽ
 */
function setLabel_YN02_02_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "�����з�") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else if (obj.flag == "�������"){
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_02_01 = getTableFormObj(label_YN02_02_01,rownumber);
			var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
					obj_YN02_02_01.rownumber);
			if (obj_YN02_02_01.value == "�������" || obj_YN02_02_01.value == "�������") {
				obj_YN02_02_02.readOnly = "";
				obj_YN02_02_02.value = "";
			} else {
				obj_YN02_02_02.readOnly = "readonly";
				obj_YN02_02_02.value = "";
			}
		}
	}else{
		var obj_YN02_02_01Arr = getTableFormObjs(label_YN02_02_01);
		for ( var i = 0; i < obj_YN02_02_01Arr.length; i++) {
			var obj_YN02_02_01 = obj_YN02_02_01Arr[0];
			var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
					obj_YN02_02_01.rownumber);
			if (obj_YN02_02_01.value == "�������" || obj_YN02_02_01.value == "�������") {
				obj_YN02_02_02.readOnly = "";
			} else {
				obj_YN02_02_02.readOnly = "readonly";
				obj_YN02_02_02.value = "";
			}
		}
	}
	
	
	
	

}
/*
 * ���ܣ���ʼ��ҳ��
 * 
 */
function initSet() {
	jQuery("table[id = '1108001526_tableForm']").parent().css("width", "405px")
			.css("overflow-x", "scroll");
	var obj = null;
	setLabel_YN02_02_02Disable(obj);
	setLabel_YN02_03_02Disable(obj);
	setLabel_YN02_04_02Disable(obj);
	setObj_YN03_04Disable(obj);
	setObj_YN04_04Disable(obj);
	setObj_YN05_04Disable(obj);
	setObj_YN06_02_01Or02Disable(obj);
}

/*
 * ���ܣ��ύУ��
 * 
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	var obj_YN03Arr = getTableFormObjs(label_YN03);
	for ( var i = 0; i < obj_YN03Arr.length-1; i++) {
		var obj_YN02_02_01 = getTableFormObjs(label_YN02_02_01)[i];
		var obj_YN02_02_02 = getTableFormObj(label_YN02_02_02,
				obj_YN02_02_01.rownumber);
		if ((obj_YN02_02_01.value == "�������" || obj_YN02_02_01.value == "�������")
				&& obj_YN02_02_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_02_02);
			a += "����ģʽ����������ƣ�����Ϊ�գ�\n";
		}
		var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[i];
		var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,
				obj_YN02_03_01.rownumber);
		if ((obj_YN02_03_01.value == "�������" || obj_YN02_03_01.value == "�������")
				&& obj_YN02_03_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_03_02);
			a += "��άģʽ����������ƣ�����Ϊ�գ�\n";

		}
		var obj_YN02_04_01 = getTableFormObjs(label_YN02_04_01)[i];
		var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,
				obj_YN02_04_01.rownumber);
		if ((obj_YN02_04_01.value == "����" || obj_YN02_04_01.value == "����")
				&& obj_YN02_04_02.value == "") {
			isValid = false;
			errorObjs.push(obj_YN02_04_02);
			a += "֪ʶ��Ȩ�����з����ƣ�����Ϊ�գ�\n";
		}
		var obj_YN03_03 = getTableFormObjs(label_YN03_03)[i];
		var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_03.rownumber);
		if (obj_YN03_03.value == "��" && obj_YN03_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN03_04);
			a += "�йܻ������ƣ�����Ϊ�գ�\n";
		}
		var obj_YN04_03 = getTableFormObjs(label_YN04_03)[i];
		var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
		if (obj_YN04_03.value == "��" && obj_YN04_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN04_04);
			a += "����ص㣺����Ϊ�գ�\n";
		}
		var obj_YN05_03 = getTableFormObjs(label_YN05_03)[i];
		var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
		if (obj_YN05_03.value == "��" && obj_YN05_04.value == "") {
			isValid = false;
			errorObjs.push(obj_YN05_04);
			a += "��������������Ϊ�գ�\n";
		}
		var obj_YN06_01_01 = getTableFormObjs(label_YN06_01_01)[i];
		var obj_YN06_02_01 = getTableFormObj(label_YN06_02_01,
				obj_YN06_01_01.rownumber+"_1");
		var obj_YN06_02_02 = getTableFormObj(label_YN06_02_02,
				obj_YN06_01_01.rownumber+"_1");
		
		if (obj_YN06_01_01.value == "") {
			isValid = false;
			errorObjs.push(obj_YN06_01_01);
			a += "ͬ���ֱ�������ֱ�ѡ�����Ϊ�գ�\n";
		}else{
			if(obj_YN06_01_01.value.indexOf("ͬ")>-1 &&obj_YN06_02_01.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06_02_01);
				a += "ͬ���ֱ�����ѡ�����Ϊ�գ�\n";
			}
			if(obj_YN06_01_01.value.indexOf("��")>-1 &&obj_YN06_02_02.value == ""){
				isValid = false;
				errorObjs.push(obj_YN06_02_02);
				a += "����ֱ�����ѡ�����Ϊ�գ�\n";
			}
		}
	}
	var obj_YN01_01_01 = getTableFormObjs(label_YN01_01_01)[0];
	var obj_YN01_02_01 = getTableFormObjs(label_YN01_02_01)[0];
	var obj_YN01_02_02 = getTableFormObjs(label_YN01_02_02)[0];
	var obj_YN01_02_03 = getTableFormObjs(label_YN01_02_03)[0];
	var obj_YN01_02_04 = getTableFormObjs(label_YN01_02_04)[0];
	var obj_YN01_02_05 = getTableFormObjs(label_YN01_02_05)[0];
	var obj_YN01_02_06 = getTableFormObjs(label_YN01_02_06)[0];
	var obj_YN01_02_07 = getTableFormObjs(label_YN01_02_07)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_02_01.value)
			+ parseInt(obj_YN01_02_02.value) + parseInt(obj_YN01_02_03.value)
			+ parseInt(obj_YN01_02_04.value) + parseInt(obj_YN01_02_05.value)
			+ parseInt(obj_YN01_02_06.value) + parseInt(obj_YN01_02_07.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_02_01);
		errorObjs.push(obj_YN01_02_02);
		errorObjs.push(obj_YN01_02_03);
		errorObjs.push(obj_YN01_02_04);
		errorObjs.push(obj_YN01_02_05);
		errorObjs.push(obj_YN01_02_06);
		errorObjs.push(obj_YN01_02_07);
		a += "��Ҫ��Ϣϵͳ����������������+�ͻ�������+��Ʒ������+���������+����֧����+����֧����+���������Ҫ��Ϣϵͳ����\n";
	}
	var obj_YN01_05_01 = getTableFormObjs(label_YN01_05_01)[0];
	var obj_YN01_05_02 = getTableFormObjs(label_YN01_05_02)[0];
	var obj_YN01_05_03 = getTableFormObjs(label_YN01_05_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_05_01.value)
			+ parseInt(obj_YN01_05_02.value) + parseInt(obj_YN01_05_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_05_01);
		errorObjs.push(obj_YN01_05_02);
		errorObjs.push(obj_YN01_05_03);
		a+="��Ҫ��Ϣϵͳ�����������з�+�������+���������\n";
	}
	var obj_YN01_06_01 = getTableFormObjs(label_YN01_06_01)[0];
	var obj_YN01_06_02 = getTableFormObjs(label_YN01_06_02)[0];
	var obj_YN01_06_03 = getTableFormObjs(label_YN01_06_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_06_01.value)
			+ parseInt(obj_YN01_06_02.value) + parseInt(obj_YN01_06_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_06_01);
		errorObjs.push(obj_YN01_06_02);
		errorObjs.push(obj_YN01_06_03);
		a+="��Ҫ��Ϣϵͳ������������ά+�������+���������\n";
	}
	var obj_YN01_07_01 = getTableFormObjs(label_YN01_07_01)[0];
	var obj_YN01_07_02 = getTableFormObjs(label_YN01_07_02)[0];
	var obj_YN01_07_03 = getTableFormObjs(label_YN01_07_03)[0];
	if (parseInt(obj_YN01_01_01.value) != parseInt(obj_YN01_07_01.value)
			+ parseInt(obj_YN01_07_02.value) + parseInt(obj_YN01_07_03.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_07_01);
		errorObjs.push(obj_YN01_07_02);
		errorObjs.push(obj_YN01_07_03);
		a+="��Ҫ��Ϣϵͳ����������+����+���У�\n";
	}
	var obj_YN01_04_01 = getTableFormObjs(label_YN01_04_01)[0];
	var obj_YN01_04_02 = getTableFormObjs(label_YN01_04_02)[0];
	var obj_YN01_04_03 = getTableFormObjs(label_YN01_04_03)[0];
	var obj_YN01_04_04 = getTableFormObjs(label_YN01_04_04)[0];
	if (parseInt(obj_YN01_04_01.value) != parseInt(obj_YN01_04_02.value)
			+ parseInt(obj_YN01_04_03.value) + parseInt(obj_YN01_04_04.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_04_02);
		errorObjs.push(obj_YN01_04_03);
		errorObjs.push(obj_YN01_04_04);
		a+="�����ֱ�����Ҫ��Ϣϵͳ��ʵ��Ӧ�ü��ֱ���Ҫ��Ϣϵͳ��+ʵ��ϵͳ���ֱ���Ҫ��Ϣϵͳ��+ʵ�����ݼ��ֱ���Ҫ��Ϣϵͳ����\n";
	}
	var obj_YN01_04_05 = getTableFormObjs(label_YN01_04_05)[0];
	var obj_YN01_04_06 = getTableFormObjs(label_YN01_04_06)[0];
	var obj_YN01_04_07 = getTableFormObjs(label_YN01_04_07)[0];
	if (parseInt(obj_YN01_04_01.value) != parseInt(obj_YN01_04_05.value)
			+ parseInt(obj_YN01_04_06.value) + parseInt(obj_YN01_04_07.value)) {
		isValid = false;
		errorObjs.push(obj_YN01_04_05);
		errorObjs.push(obj_YN01_04_06);
		errorObjs.push(obj_YN01_04_07);
		a+="�����ֱ�����Ҫ��Ϣϵͳ��������ͬ���ֱ�����Ҫ��Ϣϵͳ��+����������ֱ�����Ҫ��Ϣϵͳ��+����ͬ������������ֱ�����Ҫ��Ϣϵͳ����\n";
	}
	var obj_YN01_04_16 = getTableFormObjs(label_YN01_04_16)[0];
	var obj_YN01_04_18 = getTableFormObjs(label_YN01_04_18)[0];
	if(parseInt(obj_YN01_04_16.value)<parseInt(obj_YN01_04_18.value)){
		 a+="���ƶ�Ӧ��Ԥ������Ҫ��Ϣϵͳ��>��������ѿ�չӦ����������Ҫ��Ϣϵͳ����\n";
		 isValid=false;
		 errorObjs.push(obj_YN01_04_18);
	}
	var obj_YN01_04_17 = getTableFormObjs(label_YN01_04_17)[0];
	var obj_YN01_04_19 = getTableFormObjs(label_YN01_04_19)[0];
	if(parseInt(obj_YN01_04_17.value)<parseInt(obj_YN01_04_19.value)){
		 a+="��Ҫ��ϢϵͳӦ��Ԥ��������>���������Ҫ��ϢϵͳӦ�������������ʣ�\n";
		 isValid=false;
		 errorObjs.push(obj_YN01_04_19);
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

	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("����") > -1) {
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
	
	return isValid;
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

//��ʼ����ʽ
jQuery(function() {
	if(jQuery("#psdid").val()!=jQuery("#pdid").val()+"003"){
		var pdid = jQuery("#pdid").val();
		jQuery("#"+pdid+"484_tableForm").css("width","815px"); 
	}
});