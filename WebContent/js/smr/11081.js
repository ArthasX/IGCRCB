/*
 * ����2014- T-B-7 ��Ϣ�Ƽ�������ʩ����� 
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN01_01 = "������ʩ�ֱ�ģʽ#����#������ʩ�ֱ�ģʽ";
// �������
var label_YN02_00 = "��Ϣ�Ƽ�������ʩ���#���ݣ��ֱ������Ļ�������";
var label_YN02_01_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#����#ѡ��#1#ѡ��#����";
var label_YN02_01_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#����#ѡ��#1#ѡ��#��ѡ#����";

var label_YN02_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#��Ƶȼ�#��ѡ";
var label_YN02_03 = "��Ϣ�Ƽ�������ʩ���#�������#���#���������#���ֿؼ�";
var label_YN02_04 = "��Ϣ�Ƽ�������ʩ���#�������#���#������;#������;";

var label_YN02_05_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#ʹ��ģʽ";
var label_YN02_05_02_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#1#���з�����";
var label_YN02_05_02_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#1#����(����)������";
var label_YN02_05_03_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#2#����";

var label_YN02_06_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#ʹ��ģʽ#1#��ѡ";
var label_YN02_06_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#ʹ��ģʽ#1#�йܻ�������";
var label_YN02_06_03 = "��Ϣ�Ƽ�������ʩ���#�������#���#ʹ��ģʽ#1#����";

var label_YN02_07_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#��άģʽ#1#1#��άģʽ";
var label_YN02_07_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#��άģʽ#1#1#���������";
var label_YN02_07_03 = "��Ϣ�Ƽ�������ʩ���#�������#���#��άģʽ#1#1#����";
var label_YN02_07_04 = "��Ϣ�Ƽ�������ʩ���#�������#���#��άģʽ#1#������������#�����������";

var label_YN02_08_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#�ص�#1#����";
var label_YN02_08_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#�ص�#1#ʡ����������ֱϽ�У�";
var label_YN02_08_03 = "��Ϣ�Ƽ�������ʩ���#�������#���#�ص�#1#�У��ء��ݡ��ˣ�";

var label_YN02_09 = "��Ϣ�Ƽ�������ʩ���#�������#���#��������#����";

var label_YN03_01_01 = "��Ϣ�Ƽ�������ʩ���#����#���#������·#���������˫·�е����";
var label_YN03_01_02 = "��Ϣ�Ƽ�������ʩ���#����#���#������·#˫·�е��ɲ�ͬ���������";

var label_YN03_02_01 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#1#UPS����ģʽ#��ѡ";
var label_YN03_02_02 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#2#ϵͳ�������#1";
var label_YN03_02_03 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#3#ʵ�ʸ��ط�ֵ#1";
var label_YN03_02_04 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#4#���ص�ؿ���ʱ��#1";
var label_YN03_02_05 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#5#UPS�������ʹ�����#1";
var label_YN03_02_06 = "��Ϣ�Ƽ�������ʩ���#����#���#UPS#6#UPS������ʹ�����#1";

var label_YN03_03_01 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#1#�Ƿ��䱸#�Ƿ��䱸";
var label_YN03_03_02 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#2#�����#�����";
var label_YN03_03_03 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#3#�Զ�����#�Զ�����";
var label_YN03_03_04 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#4#����ʱ��#����ʱ��";
var label_YN03_03_05 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#5#�������ϴ�������ʱ��#�������ϴ�������ʱ��";

var label_YN03_03_06_01 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#6#��ά��λ#��ά��λ";
var label_YN03_03_06_02 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#6#��ά��λ#��ά��λ����";
var label_YN03_03_07_01 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#7#�Ƿ�����#�Ƿ�����";
var label_YN03_03_07_02 = "��Ϣ�Ƽ�������ʩ���#����#���#�����#7#�Ƿ�����#���ⷿ����";

var label_YN04_01_02 = "��Ϣ�Ƽ�������ʩ���#�Ž�����#���#�����Ž�#�Ž���¼����ʱ��#���ֿؼ�";
var label_YN04_01_03 = "��Ϣ�Ƽ�������ʩ���#�Ž�����#���#�����Ž�#�Ƿ���ù����豸#��ѡ";

var label_YN04_02_02 = "��Ϣ�Ƽ�������ʩ���#�Ž�����#���#�������#��ؼ�¼����ʱ��#���ֿؼ�";

var label_YN05_01 = "��Ϣ�Ƽ�������ʩ���#�������#���#ȫ����#�Ƿ�����";
var label_YN05_02 = "��Ϣ�Ƽ�������ʩ���#�������#���#ȫ����#�����������";

var label_YN06 = "��Ϣ�Ƽ�������ʩ���#������ʩ#���#�Ƿ�߱�#��ѡ";

var label_YN07 = "��Ϣ�Ƽ�������ʩ���#��ˮ#�Ƿ�߱�#��ѡ";

var label_YN08_01 = "��Ϣ�Ƽ�������ʩ���#�յ�#��Ƶ�λ���������#���ֿؼ�";

var label_YN09_01 = "��Ϣ�Ƽ�������ʩ���#����#���ʽ#�ı���";
var label_YN09_02 = "��Ϣ�Ƽ�������ʩ���#����#��������#�ı���";
var label_YN09_03 = "��Ϣ�Ƽ�������ʩ���#����#������Ƿ���רҵ�������Ŷ������豸���м��#�Ƿ���м��";
var label_YN09_04 = "��Ϣ�Ƽ�������ʩ���#����#������Ƿ���רҵ�������Ŷ������豸���м��#���ʱ��";

var label_YN10 = "��Ϣ�Ƽ�������ʩ���#Ѳ��#Ѳ��Ƶ��#���ֿؼ�";

var label_YN11_01 = "��Ϣ�Ƽ�������ʩ���#�ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д��#���#����������������";
var label_YN11_02 = "��Ϣ�Ƽ�������ʩ���#�ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д��#���#����";
var label_YN11_03 = "��Ϣ�Ƽ�������ʩ���#�ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д��#���#���������ľ��루���";
var label_YN11_04 = "��Ϣ�Ƽ�������ʩ���#�ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д��#���#��ע";
/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#����#������Ƿ���רҵ�������Ŷ������豸���м��#��ѡ
 */
function setObj_YN09_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if (rownumber != "") {
			var obj_YN09_03 = getTableFormObj(label_YN09_03, rownumber);
			var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
			if (obj_YN09_03.value == "��") {
				obj_YN09_04.onclick = click_columnshowDate;
			} else {
				obj_YN09_04.onclick = "";
				obj_YN09_04.value = "";
			}
		}
	}else{
		var obj_YN09_03Arr = getTableFormObjs(label_YN09_03);
		for ( var i = 0; i < obj_YN09_03Arr.length; i++) {
			var obj_YN09_03 = obj_YN09_03Arr[i];
			var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
			if (obj_YN09_03.value == "��") {
				obj_YN09_04.onclick = click_columnshowDate;
			} else {
				obj_YN09_04.onclick = "";
				obj_YN09_04.value = "";
			}
		}
	}
	
	

}
/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã��������#���#ȫ����#��ѡ
 */
function setObj_YN05_02Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN05_01 = getTableFormObj(label_YN05_01,rownumber);
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
			if (obj_YN05_01.value == "��") {
				obj_YN05_02.readOnly = "";
			} else {
				obj_YN05_02.readOnly = "readonly";
				obj_YN05_02.value = "";
			}
		}
	}else{
		var obj_YN05_01Arr = getTableFormObjs(label_YN05_01);
		for ( var i = 0; i < obj_YN05_01Arr.length; i++) {
			var obj_YN05_01 = obj_YN05_01Arr[i];
			var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
			if (obj_YN05_01.value == "��") {
				obj_YN05_02.readOnly = "";
			} else {
				obj_YN05_02.readOnly = "readonly";
				obj_YN05_02.value = "";
			}
		}
	}

}
/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#����#���#�����#7#�Ƿ�����#��ѡ
 */
function setObj_YN03_03_07_02(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,rownumber);
			var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02,
					obj_YN03_03_07_01.rownumber);
			if (obj_YN03_03_07_01.value == "��") {
				obj_YN03_03_07_02.readOnly = "";
			} else {
				obj_YN03_03_07_02.value = "";
				obj_YN03_03_07_02.readOnly = "readonly";
			}
		}
	}else{
		var obj_YN03_03_07_01Arr = getTableFormObjs(label_YN03_03_07_01);
		for ( var i = 0; i < obj_YN03_03_07_01Arr.length; i++) {
			var obj_YN03_03_07_01 = obj_YN03_03_07_01Arr[i];
			var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02,
					obj_YN03_03_07_01.rownumber);
			if (obj_YN03_03_07_01.value == "��") {
				obj_YN03_03_07_02.readOnly = "";
			} else {
				obj_YN03_03_07_02.value = "";
				obj_YN03_03_07_02.readOnly = "readonly";
			}
		}
	}
	
}

/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#����#���#�����#6#��ά��λ#��ѡ
 */
function setObj_YN03_03_06_02(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "������") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,rownumber);
			var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02,
					obj_YN03_03_06_01.rownumber);
			if (obj_YN03_03_06_01.value == "�ⲿ����") {
				obj_YN03_03_06_02.readOnly = "";
			} else {
				obj_YN03_03_06_02.value = "";
				obj_YN03_03_06_02.readOnly = "readonly";
			}
		}
	}else{
		var obj_YN03_03_06_01Arr = getTableFormObjs(label_YN03_03_06_01);
		for ( var i = 0; i < obj_YN03_03_06_01Arr.length; i++) {
			var obj_YN03_03_06_01 = obj_YN03_03_06_01Arr[i];
			var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02,
					obj_YN03_03_06_01.rownumber);
			if (obj_YN03_03_06_01.value == "�ⲿ����") {
				obj_YN03_03_06_02.readOnly = "";
			} else {
				obj_YN03_03_06_02.value = "";
				obj_YN03_03_06_02.readOnly = "readonly";
			}
		}
	}
	
	
	
	
}

/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#����#���#�����#1#�Ƿ��䱸#��ѡ
 */
function setObj_YN03OthersDisable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN03_03_01 = getTableFormObj(label_YN03_03_01,rownumber);
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,
					obj_YN03_03_01.rownumber);
			if (obj_YN03_03_01.value == "��") {
				obj_YN03_03_02.readOnly = "";
				columnVallueRadio1(obj_YN03_03_03, true, 0);
				obj_YN03_03_04.readOnly = "";
				obj_YN03_03_05.readOnly = "";
				columnVallueRadio1(obj_YN03_03_06_01, true, 1);
				columnVallueRadio1(obj_YN03_03_07_01, true, 2);
			} else {
				obj_YN03_03_02.value = "";
				obj_YN03_03_03.value = "";
				obj_YN03_03_04.value = "";
				obj_YN03_03_05.value = "";
				obj_YN03_03_06_01.value = "";
				obj_YN03_03_07_01.value = "";
				obj_YN03_03_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_03, false, 0);
				obj_YN03_03_04.readOnly = "readonly";
				obj_YN03_03_05.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_06_01, false, 0);
				columnVallueRadio1(obj_YN03_03_07_01, false, 0);

			}

		}
	}else{
		var obj_YN03_03_01Arr = getTableFormObjs(label_YN03_03_01);
		for ( var i = 0; i < obj_YN03_03_01Arr.length; i++) {
			var obj_YN03_03_01 = obj_YN03_03_01Arr[i];
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01,
					obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01,
					obj_YN03_03_01.rownumber);
			if (obj_YN03_03_01.value == "��") {
				obj_YN03_03_02.readOnly = "";
				columnVallueRadio1(obj_YN03_03_03, true, 0);
				obj_YN03_03_04.readOnly = "";
				obj_YN03_03_05.readOnly = "";
				columnVallueRadio1(obj_YN03_03_06_01, true, 1);
				columnVallueRadio1(obj_YN03_03_07_01, true, 2);
			} else {
				obj_YN03_03_02.value = "";
				obj_YN03_03_03.value = "";
				obj_YN03_03_04.value = "";
				obj_YN03_03_05.value = "";
				obj_YN03_03_06_01.value = "";
				obj_YN03_03_07_01.value = "";
				obj_YN03_03_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_03, false, 0);
				obj_YN03_03_04.readOnly = "readonly";
				obj_YN03_03_05.readOnly = "readonly";
				columnVallueRadio1(obj_YN03_03_06_01, false, 0);
				columnVallueRadio1(obj_YN03_03_07_01, false, 0);

			}

		}
	}
	
	
	
	
}
/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#�������#���#��άģʽ#1#��ѡ
 */
function setObj_YN02_07_02_03_04Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "������ά") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.rownumber;
		} else if(obj.flag == "������ά���"){
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber != ""){
			var obj_YN02_07_01 = getTableFormObj(label_YN02_07_01,rownumber);
			var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04,
					obj_YN02_07_01.rownumber);
			if (obj_YN02_07_01.value == "������ά" || obj_YN02_07_01.value == "") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "������ά���") {

				obj_YN02_07_02.readOnly = "";
				columnVallueRadio1(obj_YN02_07_03, true, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "������ά���") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, false);
			}
		}
	}else{
		var obj_YN02_07_01Arr = getTableFormObjs(label_YN02_07_01);
		for ( var i = 0; i < obj_YN02_07_01Arr.length; i++) {
			var obj_YN02_07_01 = obj_YN02_07_01Arr[i];
			var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03,
					obj_YN02_07_01.rownumber);
			var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04,
					obj_YN02_07_01.rownumber);
			if (obj_YN02_07_01.value == "������ά" || obj_YN02_07_01.value == "") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "������ά���") {

				obj_YN02_07_02.readOnly = "";

				columnVallueRadio1(obj_YN02_07_03, true, 0);
				disableTableCheckBox(obj_YN02_07_04, true);

			} else if (obj_YN02_07_01.value == "������ά���") {
				obj_YN02_07_02.value = "";
				obj_YN02_07_03.value = "";
				obj_YN02_07_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_07_03, false, 0);
				disableTableCheckBox(obj_YN02_07_04, false);
			}
		}
	}
	

}

/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#��ѡ
 */
function setObj_YN02_06_02_03Disable(obj) {
	if(obj){
		var rownumber = "";
		if (obj.flag == "����ʹ��") {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_06_01 = getTableFormObj(label_YN02_06_01,rownumber);
			var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02,
					obj_YN02_06_01.rownumber);
			var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03,
					obj_YN02_06_01.rownumber);
			if (obj_YN02_06_01.value == "�й�") {
				obj_YN02_06_02.readOnly = "";
				columnVallueRadio1(obj_YN02_06_03, true, 0);
			} else {
				obj_YN02_06_02.value = "";
				obj_YN02_06_03.value = "";
				obj_YN02_06_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_06_03, false, 0);
			}
		}
	}else{
		var obj_YN02_06_01Arr = getTableFormObjs(label_YN02_06_01);
		for ( var i = 0; i < obj_YN02_06_01Arr.length; i++) {
			var obj_YN02_06_01 = obj_YN02_06_01Arr[i];
			var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02,
					obj_YN02_06_01.rownumber);
			var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03,
					obj_YN02_06_01.rownumber);
			if (obj_YN02_06_01.value == "�й�") {
				obj_YN02_06_02.readOnly = "";
				columnVallueRadio1(obj_YN02_06_03, true, 0);
			} else {
				obj_YN02_06_02.value = "";
				obj_YN02_06_03.value = "";
				obj_YN02_06_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_06_03, false, 0);
			}
		}
	}
	

}

/*
 * ���ܣ�ͨ����ѡ�����ƺ����ı���͵�ѡ�Ƿ�ֻ�� ���ã���Ϣ�Ƽ�������ʩ���#�������#���#��Ȩ��ʽ#����#��ѡ
 */
function setObj_YN02_05_02_03Disable(obj) {	
	if(obj){
		var rownumber = "";
		if (obj.flag == "����") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.rownumber;
		} else if(obj.flag == "����"){
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}else{
			rownumber = obj.parentElement.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,rownumber);
			var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01,
					obj_YN02_05_01.rownumber + "_1");
			
			if (obj_YN02_05_01.value == "����" || obj_YN02_05_01.value == "") {
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.value = "";
				obj_YN02_05_03_01.value = "";
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
			} else if (obj_YN02_05_01.value == "����") {
				obj_YN02_05_02_01.readOnly = "";
				obj_YN02_05_02_02.readOnly = "readonly";
				obj_YN02_05_02_02.value = "";
//				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			} else if (obj_YN02_05_01.value == "����") {
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.readOnly = "";
//				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			}
		}
	}else{
		var obj_YN02_05_01Arr = getTableFormObjs(label_YN02_05_01);
		for ( var i = 0; i < obj_YN02_05_01Arr.length; i++) {
			var obj_YN02_05_01 = obj_YN02_05_01Arr[i];
			var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02,
					obj_YN02_05_01.rownumber + "_1");
			var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01,
					obj_YN02_05_01.rownumber + "_1");
			
			if (obj_YN02_05_01.value == "����" || obj_YN02_05_01.value == "") {
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.value = "";
				obj_YN02_05_03_01.value = "";
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_02.readOnly = "readonly";
				columnVallueRadio1(obj_YN02_05_03_01, false, 0);
			} else if (obj_YN02_05_01.value == "����") {
				obj_YN02_05_02_01.readOnly = "";
				obj_YN02_05_02_02.readOnly = "readonly";
				obj_YN02_05_02_02.value = "";
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			} else if (obj_YN02_05_01.value == "����") {
				obj_YN02_05_02_01.readOnly = "readonly";
				obj_YN02_05_02_01.value = "";
				obj_YN02_05_02_02.readOnly = "";
				columnVallueRadio1(obj_YN02_05_03_01, true, 0);
//				obj_YN02_05_03_01.value = "";
			}
		}
	}
	
	

}
/*
 * ���ܣ�ͨ����ѡ�����ƺ����ѡ�����Ƿ��ѡ ���ã���Ϣ�Ƽ�������ʩ���#�������#���#����#ѡ��#1#ѡ��#��ѡ
 */
function setObj_YN02_01_02_03Disable(obj) {
	if(obj){
		var rownumber = "";
		
		if (obj.flag == "��������") {
			rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
		} else {
			rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
		}
		if(rownumber){
			var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,rownumber);
			var obj_YN02_01_02 = getTableFormCheckBox(label_YN02_01_02,
					obj_YN02_01_01.rownumber + "_1");
			var obj_YN02_01_02Header = [];
			var obj_YN02_01_02Last = [];
			for(var n = 0;n<3;n++){
				obj_YN02_01_02Header.push(obj_YN02_01_02[n]);
			}
			for(var j = 3;j<6;j++){
				obj_YN02_01_02Last.push(obj_YN02_01_02[j]);
			}
			if (obj_YN02_01_01.value == "��������") {
				disableTableCheckBox1(obj_YN02_01_02Header, false);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			} else if (obj_YN02_01_01.value == "���Ļ���") {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, false);
			} else {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			}
		}
	}else{
		var obj_YN02_01_01Arr = getTableFormObjs(label_YN02_01_01);
		for ( var i = 0; i < obj_YN02_01_01Arr.length; i++) {
			var obj_YN02_01_01 = obj_YN02_01_01Arr[i];
			var obj_YN02_01_02 = getTableFormCheckBox(label_YN02_01_02,
					obj_YN02_01_01.rownumber + "_1");
			var obj_YN02_01_02Header = [];
			var obj_YN02_01_02Last = [];
			for(var n = 0;n<3;n++){
				obj_YN02_01_02Header.push(obj_YN02_01_02[n]);
			}
			for(var j = 3;j<6;j++){
				obj_YN02_01_02Last.push(obj_YN02_01_02[j]);
			}
			if (obj_YN02_01_01.value == "��������") {
				disableTableCheckBox1(obj_YN02_01_02Header, false);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			} else if (obj_YN02_01_01.value == "���Ļ���") {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, false);
			} else {
				disableTableCheckBox1(obj_YN02_01_02Header, true);
				disableTableCheckBox1(obj_YN02_01_02Last, true);
			}
		}
	}

}

/*
 * ��ʼ��
 */
function initSet() {
	var obj = null;
	setObj_YN02_01_02_03Disable(obj);
	setObj_YN02_05_02_03Disable(obj);
	setObj_YN02_06_02_03Disable(obj);
	setObj_YN02_07_02_03_04Disable(obj);
	setObj_YN03OthersDisable(obj);
	setObj_YN03_03_06_02(obj);
	setObj_YN03_03_07_02(obj);
	setObj_YN05_02Disable(obj);
	setObj_YN09_04Disable(obj);
	setZBQKDisable();
}

function setZBQKDisable(){
	var objs = getTableFormObjs(label_YN02_01_02);
	if(objs){
		for(var i=0;i<objs.length;i++){
			if(objs[i].rownumber.indexOf("_#_") < 0){
				setTableNoRightMenu(objs[i]);
			}
		}
	}
}
/*
 * �ύУ������
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	//���ӱ���У�� wangjiahui start
	//У�������ʩ�ֱ�ģʽ
	var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1");
	if(obj_YN01_01){
		if(obj_YN01_01.value == ""){
			errorObjs.push(obj_YN01_01);
			isValid = false;
			a += "������ʩ�ֱ�ģʽ����Ϊ�գ�\n";
		}
	}
	var obj_YN02_00Arr = getTableFormObjs(label_YN02_00);
	var index = 0;
	if(obj_YN02_00Arr){
		for(var i=0;i<obj_YN02_00Arr.length;i++){
			if(obj_YN02_00Arr[i].rownumber.indexOf("_#_") >= 0){
				continue;
			}else{
				index ++;
			}
			//У�����Ļ�������
			if(obj_YN02_00Arr[i].value == ""){
				errorObjs.push(obj_YN02_00Arr[i]);
				isValid = false;
				a += "����(�ֱ�)���Ļ���"+ index + "�����ݣ��ֱ������Ļ������Ʋ���Ϊ�գ�\n";
			}
			//У������
			var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1_1");
			if(obj_YN02_01_01){
				if(obj_YN02_01_01.value == ""){
					errorObjs.push(obj_YN02_01_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index + "��������� ���� ���Ĳ���Ϊ�գ�\n";
				}else{
					//У����������
					var obj_YN02_01_02 = getTableFormObj(label_YN02_01_02,obj_YN02_01_01.rownumber+"_1");
					if(obj_YN02_01_02.value == ""){
						errorObjs.push(obj_YN02_01_02);
						isValid = false;
						a += "����(�ֱ�)���Ļ���"+ index +"��������� ���� �������ʲ���Ϊ�գ�\n";
					}
				}
			}
			//У����Ƶȼ�
			var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_02){
				if(obj_YN02_02.value == ""){
					errorObjs.push(obj_YN02_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� ��Ƶȼ�����Ϊ�գ�\n";
				}
			}
			//У����������
			var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_03){
				if(obj_YN02_03.value == ""){
					errorObjs.push(obj_YN02_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� �������������Ϊ�գ�\n";
				}
			}
			//У�鹦����;
			var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_04){
				if(obj_YN02_04.value == ""){
					errorObjs.push(obj_YN02_04);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� ������;����Ϊ�գ�\n";
				}
			}
			//У���Ȩ��ʽ
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_05_01){
				if(obj_YN02_05_01.value == ""){
					errorObjs.push(obj_YN02_05_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� ��Ȩ��ʽ����Ϊ�գ�\n";
				}else{
					var obj_YN02_05_02_01 = getTableFormObj(label_YN02_05_02_01, obj_YN02_05_01.rownumber + "_1");
					var obj_YN02_05_02_02 = getTableFormObj(label_YN02_05_02_02, obj_YN02_05_01.rownumber + "_1");
					var obj_YN02_05_03_01 = getTableFormObj(label_YN02_05_03_01, obj_YN02_05_01.rownumber + "_1");
					if (obj_YN02_05_01.value == "����") {
						if(obj_YN02_05_02_01.value == ""){
							errorObjs.push(obj_YN02_05_02_01);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��Ȩ��ʽ �������Ʋ���Ϊ�գ�\n";
						}
						if(obj_YN02_05_03_01.value == ""){
							errorObjs.push(obj_YN02_05_03_01);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��Ȩ��ʽ ���ʲ���Ϊ�գ�\n";
						}
					} else if (obj_YN02_05_01.value == "����") {
						if(obj_YN02_05_02_02.value == ""){
							errorObjs.push(obj_YN02_05_02_02);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��Ȩ��ʽ ���⣨���裩�����Ʋ���Ϊ�գ�\n";
						}
						if(obj_YN02_05_03_01.value == ""){
							errorObjs.push(obj_YN02_05_03_01);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��Ȩ��ʽ ���ʲ���Ϊ�գ�\n";
						}
					}
				}
			}
			
			//У��ʹ��ģʽ
			var obj_YN02_06_01 = getTableFormObj(label_YN02_06_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_06_01){
				if(obj_YN02_06_01.value == ""){
					errorObjs.push(obj_YN02_06_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� ʹ��ģʽ����Ϊ�գ�\n";
				}else{
					var obj_YN02_06_02 = getTableFormObj(label_YN02_06_02, obj_YN02_06_01.rownumber);
					var obj_YN02_06_03 = getTableFormObj(label_YN02_06_03, obj_YN02_06_01.rownumber);
					if (obj_YN02_06_01.value == "�й�") {
						if(obj_YN02_06_02.value == ""){
							errorObjs.push(obj_YN02_06_02);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ʹ��ģʽ �йܻ������� ����Ϊ�գ�\n";
						}
						if(obj_YN02_06_03.value == ""){
							errorObjs.push(obj_YN02_06_03);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ʹ��ģʽ ���ʲ���Ϊ�գ�\n";
						}
					} 
				}
			}
			//У����άģʽ
			var obj_YN02_07_01 = getTableFormObj(label_YN02_07_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN02_07_01){
				if(obj_YN02_07_01.value == ""){
					errorObjs.push(obj_YN02_07_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +"��������� ��άģʽ����Ϊ�գ�\n";
				}else{
					var obj_YN02_07_02 = getTableFormObj(label_YN02_07_02, obj_YN02_07_01.rownumber);
					var obj_YN02_07_03 = getTableFormObj(label_YN02_07_03, obj_YN02_07_01.rownumber);
					var obj_YN02_07_04 = getTableFormCheckBox(label_YN02_07_04, obj_YN02_07_01.rownumber);
					if (obj_YN02_07_01.value == "������ά���") {
						if(obj_YN02_07_02.value == ""){
							errorObjs.push(obj_YN02_07_02);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��άģʽ ��������Ʋ���Ϊ�գ�\n";
						}
						if(obj_YN02_07_03.value == ""){
							errorObjs.push(obj_YN02_07_03);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��άģʽ ���ʲ���Ϊ�գ�\n";
						}
					} else if (obj_YN02_07_01.value == "������ά���") {
						if(obj_YN02_07_04.value == ""){
							errorObjs.push(obj_YN02_07_04);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+ index +": ������� ��άģʽ �����������ݲ���Ϊ�գ�\n";
						}
					}
				}
			}
			//У��ص�
			var obj_YN02_08_01 = getTableFormObj(label_YN02_08_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_01){
				if(obj_YN02_08_01.value == ""){
					errorObjs.push(obj_YN02_08_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������� �ص� ���Ҳ���Ϊ�գ�\n";
				}
			}
			var obj_YN02_08_02 = getTableFormObj(label_YN02_08_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_02){
				if(obj_YN02_08_02.value == ""){
					errorObjs.push(obj_YN02_08_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������� �ص� ʡ(��������ֱϽ��)����Ϊ�գ�\n";
				}
			}
			var obj_YN02_08_03 = getTableFormObj(label_YN02_08_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN02_08_03){
				if(obj_YN02_08_03.value == ""){
					errorObjs.push(obj_YN02_08_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������� �ص� �У��ء��ݡ��ˣ�����Ϊ�գ�\n";
				}
			}
			//У����������
			var obj_YN02_09 = getTableFormObj(label_YN02_09,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN02_09){
				if(obj_YN02_09.value == ""){
					errorObjs.push(obj_YN02_09);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������� �������ڲ���Ϊ�գ�\n";
				}
			}
			//У�鹩����·
			var obj_YN03_01_01 = getTableFormObj(label_YN03_01_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN03_01_01){
				if(obj_YN03_01_01.value == ""){
					errorObjs.push(obj_YN03_01_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ������· ���������˫·�е���벻��Ϊ�գ�\n";
				}
			}
			var obj_YN03_01_02 = getTableFormObj(label_YN03_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN03_01_02){
				if(obj_YN03_01_02.value == ""){
					errorObjs.push(obj_YN03_01_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ������· ˫·�е��ɲ�ͬ��������벻��Ϊ�գ�\n";
				}
			}
			//У�鹩��UPS
			var obj_YN03_02_01 = getTableFormObj(label_YN03_02_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_01){
				if(obj_YN03_02_01.value == ""){
					errorObjs.push(obj_YN03_02_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS UPS����ģʽ����Ϊ�գ�\n";
				}
			}
			var obj_YN03_02_02 = getTableFormObj(label_YN03_02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_02){
				if(obj_YN03_02_02.value == ""){
					errorObjs.push(obj_YN03_02_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS ϵͳ�����������Ϊ�գ�\n";
				}
			}
			var obj_YN03_02_03 = getTableFormObj(label_YN03_02_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_03){
				if(obj_YN03_02_03.value == ""){
					errorObjs.push(obj_YN03_02_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS ʵ�ʸ��ط�ֵ����Ϊ�գ�\n";
				}
			}
			var obj_YN03_02_04 = getTableFormObj(label_YN03_02_04,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_04){
				if(obj_YN03_02_04.value == ""){
					errorObjs.push(obj_YN03_02_04);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS ���ص�ؿ���ʱ�䲻��Ϊ�գ�\n";
				}
			}
			var obj_YN03_02_05 = getTableFormObj(label_YN03_02_05,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_05){
				if(obj_YN03_02_05.value == ""){
					errorObjs.push(obj_YN03_02_05);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS UPS�������ʹ����ݲ���Ϊ�գ�\n";
				}
			}
			var obj_YN03_02_06 = getTableFormObj(label_YN03_02_06,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			if(obj_YN03_02_06){
				if(obj_YN03_02_06.value == ""){
					errorObjs.push(obj_YN03_02_06);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� UPS UPS������ʹ����ݲ���Ϊ�գ�\n";
				}
			}
			//У�鹩�緢���
			var obj_YN03_03_01 = getTableFormObj(label_YN03_03_01,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1");
			var obj_YN03_03_02 = getTableFormObj(label_YN03_03_02, obj_YN03_03_01.rownumber);
			var obj_YN03_03_03 = getTableFormObj(label_YN03_03_03, obj_YN03_03_01.rownumber);
			var obj_YN03_03_04 = getTableFormObj(label_YN03_03_04, obj_YN03_03_01.rownumber);
			var obj_YN03_03_05 = getTableFormObj(label_YN03_03_05, obj_YN03_03_01.rownumber);
			var obj_YN03_03_06_01 = getTableFormObj(label_YN03_03_06_01, obj_YN03_03_01.rownumber);
			var obj_YN03_03_07_01 = getTableFormObj(label_YN03_03_07_01, obj_YN03_03_01.rownumber);
			 if (obj_YN03_03_01.value == "��") {
				if(obj_YN03_03_02.value == ""){
					errorObjs.push(obj_YN03_03_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� ����ʲ���Ϊ�գ�\n";
				}
				if(obj_YN03_03_03.value == ""){
					errorObjs.push(obj_YN03_03_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� �Զ���������Ϊ�գ�\n";
				}
				if(obj_YN03_03_04.value == ""){
					errorObjs.push(obj_YN03_03_04);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� ����ʱ�䲻��Ϊ�գ�\n";
				}
				if(obj_YN03_03_05.value == ""){
					errorObjs.push(obj_YN03_03_05);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� �������ϴ�������ʱ�䲻��Ϊ�գ�\n";
				}
				if(obj_YN03_03_06_01.value == ""){
					errorObjs.push(obj_YN03_03_06_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� ��ά��λ����Ϊ�գ�\n";
				}
				if(obj_YN03_03_07_01.value == ""){
					errorObjs.push(obj_YN03_03_07_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� �Ƿ����ò���Ϊ�գ�\n";
				}
				var obj_YN03_03_06_02 = getTableFormObj(label_YN03_03_06_02, obj_YN03_03_06_01.rownumber);
				if (obj_YN03_03_06_01.value == "�ⲿ����" && obj_YN03_03_06_02.value == "") {
					errorObjs.push(obj_YN03_03_06_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� ��ά��λ�ⲿ�������Ʋ���Ϊ�գ�\n";
				}
				
				var obj_YN03_03_07_02 = getTableFormObj(label_YN03_03_07_02, obj_YN03_03_07_01.rownumber);
				if (obj_YN03_03_07_01.value == "��" && obj_YN03_03_07_02.value == "") {
					errorObjs.push(obj_YN03_03_07_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ����� ���ⷽ���Ʋ���Ϊ�գ�\n";
				}
			}
			//У���Ž�����
			var obj_YN04_01_02 = getTableFormObj(label_YN04_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_01_02){
				if(obj_YN04_01_02.value == ""){
					errorObjs.push(obj_YN04_01_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": �Ž����� �Ž� �Ž���¼����ʱ�䲻��Ϊ�գ�\n";
				}
			}
			var obj_YN04_01_03 = getTableFormObj(label_YN04_01_03,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_01_03){
				if(obj_YN04_01_03.value == ""){
					errorObjs.push(obj_YN04_01_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": �Ž����� �Ž� �Ƿ���ù����豸����Ϊ�գ�\n";
				}
			}
			var obj_YN04_02_02 = getTableFormObj(label_YN04_02_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1");
			if(obj_YN04_02_02){
				if(obj_YN04_02_02.value == ""){
					errorObjs.push(obj_YN04_02_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": �Ž����� ������� ��ؼ�¼����ʱ�䲻��Ϊ�գ�\n";
				}
			}
			
			//У��������
			var obj_YN05_01 = getTableFormObj(label_YN05_01,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN05_01){
				if(obj_YN05_01.value == ""){
					errorObjs.push(obj_YN05_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������� �Ƿ�ȫ���β���Ϊ�գ�\n";
				}else if(obj_YN05_01.value == "��"){
					var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
					if(obj_YN05_02 && obj_YN05_02.value == ""){
						errorObjs.push(obj_YN05_02);
						isValid = false;
						a += "����(�ֱ�)���Ļ���"+ index +": ������� ȫ���� �������������Ϊ�գ�\n";
					}
				}
			}
			//У�������ʩ
			var obj_YN06 = getTableFormObj(label_YN06,obj_YN02_00Arr[i].rownumber + "_1_1_1");
			if(obj_YN06){
				if(obj_YN06.value == ""){
					errorObjs.push(obj_YN06);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ������ʩ �Ƿ�߱�����Ϊ�գ�\n";
				}
			}
			//У���ˮ
			var obj_YN07 = getTableFormObj(label_YN07,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN07){
				if(obj_YN07.value == ""){
					errorObjs.push(obj_YN07);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ��ˮ �Ƿ�߱�����Ϊ�գ�\n";
				}
			}
			
			//У��յ�
			var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN08_01){
				if(obj_YN08_01.value == ""){
					errorObjs.push(obj_YN08_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": �յ� ��Ƶ�λ�������������Ϊ�գ�\n";
				}
			}
			//У������
			var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_01){
				if(obj_YN09_01.value == ""){
					errorObjs.push(obj_YN09_01);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ���ʽ����Ϊ�գ�\n";
				}
			}
			var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_02){
				if(obj_YN09_02.value == ""){
					errorObjs.push(obj_YN09_02);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� �������Ͳ���Ϊ�գ�\n";
				}
			}
			var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN09_03){
				if(obj_YN09_03.value == ""){
					errorObjs.push(obj_YN09_03);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": ���� ������Ƿ���רҵ�������Ŷ������豸���м�ⲻ��Ϊ�գ�\n";
				}else{
					var obj_YN09_04 = getTableFormObj(label_YN09_04, obj_YN09_03.rownumber);
					if (obj_YN09_03.value == "��" && obj_YN09_04.value == "") {
						errorObjs.push(obj_YN09_04);
						isValid = false;
						a += "����(�ֱ�)���Ļ���"+ index +": ���� ������Ƿ���רҵ�������Ŷ������豸���м�� ���ʱ�䲻��Ϊ�գ�\n";
					}
				}
			}
			//У��Ѳ��
			var obj_YN10 = getTableFormObj(label_YN10,obj_YN02_00Arr[i].rownumber + "_1_1");
			if(obj_YN10){
				if(obj_YN10.value == ""){
					errorObjs.push(obj_YN10);
					isValid = false;
					a += "����(�ֱ�)���Ļ���"+ index +": Ѳ��  Ѳ��Ƶ�Ȳ���Ϊ�գ�\n";
				}
			}
			//�ֱ��������
			
			var obj_YN02_01_02 = getTableFormObj(label_YN02_01_02,obj_YN02_00Arr[i].rownumber + "_1_1_1_1_1_1_1");
			if(checkBoxValues(obj_YN02_01_02)){
				var obj_YN11_01Arr = getTableFormObjs(label_YN11_01);
				for(var index = 0;index<obj_YN11_01Arr.length;index++){
					var obj_YN11_01 = obj_YN11_01Arr[index];
					var rownumber = obj_YN11_01.rownumber.substring(0,1);
					if((index+1).toString() == rownumber){
						var obj_YN11_02 = getTableFormObj(label_YN11_02,obj_YN11_01.rownumber);
						var obj_YN11_03 = getTableFormObj(label_YN11_03,obj_YN11_01.rownumber);
						if(obj_YN11_01.value == ""){
							errorObjs.push(obj_YN11_01);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+(parseInt(i)+1)+": 10 �ֱ�������� ���������������Ʋ���Ϊ�գ�(��"+(parseInt(i)+1)+")\n";
						}
						if(obj_YN11_02.value == ""){
							errorObjs.push(obj_YN11_02);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+(parseInt(i)+1)+": 10 �ֱ�������� ������Ϊ�գ�(��"+(parseInt(i)+1)+")\n";
						}
						if(obj_YN11_03.value == ""){
							errorObjs.push(obj_YN11_03);
							isValid = false;
							a += "����(�ֱ�)���Ļ���"+(parseInt(i)+1)+": 10 �ֱ�������� ���������ľ��벻��Ϊ�գ�(��"+(parseInt(i)+1)+")\n";
						}
					}
					
					
				}

			}
		}
	}
	//���ӱ���У�� wangjiahui end
	
	//У�鸴ѡ�������Ƿ���ֵ
	for(var i = 0;i<checkBoxValueObjs.length;i++){
		var checkBoxObj = checkBoxValueObjs[i];
		if(checkBoxObj.checked){
			var checkBoxObjValueObj= checkBoxObj.parentElement.nextSibling.nextSibling;
			if(checkBoxObjValueObj.value.indexOf("_cev_")<0){
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a+="���������ݲ���Ϊ�գ�\n";
				isValid=false;
			}
		}
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
	return isValid;
}
/*
 * ���ܣ���������Ƿ���ȷ
 */ 
function checkYear(obj){
	if(obj.value.length != 4){
		obj.value = "";
		alert("������ݲ��ԣ����������루���磺2012����");
	}
}
/*
 * ���ܣ���������Ƿ���ȷ
 */
function checkValueAbs(obj){
	if(parseFloat(obj.value)<0){
		obj.value = "";
		alert("�������ֵ����С��0�����������룡");
	}
}

/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
};

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
						if (flag == 0) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else if (flag == 1) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setObj_YN03_03_06_02(this);
							};
						} else if (flag == 2) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
								setObj_YN03_03_07_02(this);
							};
						}
					}
				}
			}
		}
	}
}
/*
 * ���ܣ�ͨ�����һ���������͵�ֵ�������ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д���Ƿ��д�Լ��ܲ��ܹ����
 * ������������������͵ĸ�ѡ������뷽����
 */
function checkBoxValues(checkBox1){
	if(checkBox1.value.indexOf("ͬ��")>-1){
		return true;
	}
	if(checkBox1.value.indexOf("���")>-1){
		return true;
	}
	return false;
}
/*
 * ���ܣ�������������������ֱ���������������������Ͱ����ֱ����Ļ�е��ֱ�����ʱ��д���Ƿ��д�Լ��ܲ��ܹ����
 */
function setAddImgClickDisable(obj) {
	if(obj){
		var target = getTarget(obj.parentElement);
		setTableNoRightMenu(target);
	}
}

function setTableNoRightMenu(target){
	if(target){
		var tb = getTableFormObj(label_YN11_01,target.rownumber.split("_")[0] + "_1_1").parentElement.parentElement.parentElement;
		var obj_YN11_01 = getTableFormObj(label_YN11_01,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_02 = getTableFormObj(label_YN11_02,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_03 = getTableFormObj(label_YN11_03,target.rownumber.split("_")[0] + "_1_1");
		var obj_YN11_04 = getTableFormObj(label_YN11_04,target.rownumber.split("_")[0] + "_1_1");
		if(!checkBoxValues(target)){
			if(tb.rows.length > 1){
				tb.rows[1].className = "";
				jQuery(tb.rows[1]).unbind("mousedown");
				var len = tb.rows.length;
				for(var i=2;i<len;i++){
					deleteRow(tb.rows[2]);
				}
			}
			obj_YN11_01.readOnly = "readonly";
			columnVallueRadio1(obj_YN11_02, false, 0);
			obj_YN11_03.readOnly = "readonly";
			obj_YN11_04.readOnly = "readonly";
			obj_YN11_01.value = "";
			obj_YN11_03.value = "";
			obj_YN11_04.value = "";
		}else{
			if(tb.rows.length > 1){
				tb.rows[1].className = "rightMenu";
				jQuery(tb.rows[1]).unbind("mousedown").mousedown(function(event){
					event.stopPropagation();
					rightMenu(this,event);
				}) ;
			}
			obj_YN11_01.readOnly = "";
			columnVallueRadio1(obj_YN11_02, true, 0);
			obj_YN11_03.readOnly = "";
			obj_YN11_04.readOnly = "";
		}
	}
}

/*
* ���ܣ������ѡ��ѡ���е�������������������У����ύ��ʱ��У�������������Ƿ�Ϊ�� 
* 
*/
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj){
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if(obj.checked){
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	}else{
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);
		
	}
}

function disableTableCheckBox1(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = getTarget(objs[i].parentElement).value.replace(objs[i].value,"");
				//��ա�������������Ϊֻ��
				var showvalue = getShowTarget(objs[i].parentElement);
				if(showvalue!=null){
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}
		}
	}
}

function deleteGroup(obj){
	//Ŀ��table����
	var tb = obj.parentElement.parentElement;
	//��Ҫ�����б�ʶ�������ǰ��ΪΨһ�����У�����Ҫ����һ�У�Ȼ����ɾ������
	var index = 0;
	for(var i=0;i<tb.rows.length;i++){
		if(tb.rows[i].name != "titlerow" && tb.rows[i].name != "titletr"){
			index ++;
		}
	}
	if(index == 1){
		addGroup(obj, obj.rowIndex);
	}
	var map = {};
	jQuery(tb).find("table[id$='_template']").each(function(index,obj){
		map[obj.id]=obj.outerHTML;
	});
	//Ҫɾ���е�����
	var rowIndex = obj.rowIndex;
	//ɾ���в���
	tb.deleteRow(rowIndex); 
	//ɾ���в������к��п��ܱ����ң���Ҫ��������
	shortGroup(tb);
	for ( var prop in map) {
		if (map.hasOwnProperty(prop)) {
				jQuery("#"+prop.replace("_template","")).parent().append(jQuery(map[prop]).clone(true));
		}
	}
	setZBQKDisable();
//	//�к�
//	var rowIndex = obj.rowIndex;
//	tb.deleteRow(rowIndex); 
	
}

/**
 * 
 * ��ģʽ�����
 * 
 * @param obj �¼�Դ����
 * @param insertRowNum ����е�λ��
 */
function addGroup(obj,insertRowNum){
	//��Ҫ����е�table����
	var targetTab = obj.parentElement.parentElement;
	//ģ�����
	var templateTab = document.getElementById(targetTab.id + "_template");
	//������
	var tr = null;
	//�ж��Ƿ�ָ�����е����λ�ã����ָ������ָ��λ����ӣ����δָ����Ĭ����ӵ����һ��
	if(insertRowNum != null){
		tr = targetTab.insertRow(insertRowNum);
	}else{
		tr = targetTab.insertRow(targetTab.rows.length);
	}
	//�趨���е��Ҽ��˵�
	tr.className = "rightMenu";
	tr.oncontextmenu = function(){return false;};
	jQuery(tr).unbind("mousedown").mousedown(function(event){
		event.stopPropagation();
		rightMenu(this,event);
	});
	var td = tr.insertCell();
	td.innerHTML = templateTab.outerHTML;
	td.style.border = "none";
	shortGroup(targetTab);
	setZBQKDisable();
	return tr;
}