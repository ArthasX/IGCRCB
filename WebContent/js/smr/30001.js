/*
 * ����T-A-2 �ش�ͻ���¼������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_qudaoguanli="ϵͳ���#��������#1";
var label_item8="ϵͳ���#��������#2";
var label_kehuguanli="ϵͳ���#�ͻ�����#1";
var label_item10="ϵͳ���#�ͻ�����#2";
var label_chanpinguanli="ϵͳ���#��Ʒ����#1";
var label_item12="ϵͳ���#��Ʒ����#2";
var label_caiwuguanli="ϵͳ���#�������#1";
var label_item14="ϵͳ���#�������#2";
var label_juecezhichi="ϵͳ���#����֧��#1";
var label_item16="ϵͳ���#����֧��#2";
var label_gongxiangzhichi="ϵͳ���#����֧��#1";
var label_item18="ϵͳ���#����֧��#2";
var label_jichusheshi="ϵͳ���#������ʩ#1";
var label_item89="ϵͳ���#������ʩ#2";
var label_qita="ϵͳ���#����#1#1";
var label_item7="ϵͳ���#����#1#2";
var label_item87="ϵͳ���#����#2";

var label_RadioButtonList="Ӱ�췶Χ";
var label_S_item11="��Χ����#��֧��������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1" );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, "1_1");
	var obj_item18 = getTableFormCheckBox(label_item18,"1_1" );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, "1_1");
	var obj_item89 = getTableFormCheckBox(label_item89,"1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item7 = getTableFormObj(label_item7,"1_1_1" );
	var obj_item87 = getTableFormObj(label_item87,"1_1" );
	
	if (obj_qudaoguanli.value=="��������") {
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_kehuguanli.value=="�ͻ�����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_chanpinguanli.value=="��Ʒ����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_caiwuguanli.value=="�������") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_juecezhichi.value=="����֧��") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_gongxiangzhichi.value=="����֧��") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item89,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_jichusheshi.value=="������ʩ") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		obj_item7.readOnly = "readonly";
		getEditDiv(obj_item87).contentEditable=false;
	} else if (obj_qita.value=="����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		disableTableCheckBox(obj_item18,true);
		disableTableCheckBox(obj_item89,true);
	}
}

/*
* ���ܣ���ϵͳ����໥������
* ���ã�ϵͳ���#��������#1
* ϵͳ���#�ͻ�����#1
* ϵͳ���#��Ʒ����#1
* ϵͳ���#�������#1
* ϵͳ���#����֧��#1
* ϵͳ���#����֧��#1
* ϵͳ���#������ʩ#1
*/
function xitongleibie_click(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_item8,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_item10,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_item12,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_item14,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_item16,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_item18,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_item89,target.rownumber );
	var obj_qita = getTableFormObj(label_qita,target.rownumber+"_1" );
	var obj_item7 = getTableFormObj(label_item7,target.rownumber+"_1" );
	var obj_item87 = getTableFormObj(label_item87,target.rownumber );
	
	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	getEditDiv(obj_item87).innerHTML = "";
	getEditDiv(obj_item87).contentEditable=false;
	obj_item87.value="";
	obj_item7.value="";
	obj_item7.readOnly = "readonly";
	
	if (target.value=="��������"){
		//ָ����ѡ�����ԭ״̬
		disableTableCheckBox(obj_item8,false);
		//���������޹ص�ѡ��״̬Ϊ��ѡ��
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="�ͻ�����"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="��Ʒ����") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="�������") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="����֧��") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="����֧��") {
		disableTableCheckBox(obj_item18,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="������ʩ") {
		disableTableCheckBox(obj_item89,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_gongxiangzhichi);
		setRadioNotChoosed(obj_qita);
	}
}

/*
* ���ܣ���ϵͳ����໥������(����)
* ���ã�ϵͳ���#����#1#1
*/
function xitongleibie_qita_click(obj) {
	
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item8 = getTableFormCheckBox(label_item8,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item10 = getTableFormCheckBox(label_item10,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item12 = getTableFormCheckBox(label_item12,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item14 = getTableFormCheckBox(label_item14,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item16 = getTableFormCheckBox(label_item16,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item18 = getTableFormCheckBox(label_item18,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_jichusheshi = getTableFormObj(label_jichusheshi,target.rownumber.substring(0,target.rownumber.length-2));
	var obj_item89 = getTableFormCheckBox(label_item89,target.rownumber.substring(0,target.rownumber.length-2) );
	var obj_qita = getTableFormObj(label_qita,target.rownumber);
	var obj_item7 = getTableFormObj(label_item7,target.rownumber);
	var obj_item87 = getTableFormObj(label_item87,target.rownumber.substring(0,target.rownumber.length-2));
	
	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	getEditDiv(obj_item87).innerHTML = "";
	getEditDiv(obj_item87).contentEditable=false;
	obj_item87.value="";
	obj_item7.value="";
	obj_item7.readOnly = "readonly";

	if (target.value=="����") {
		getEditDiv(obj_item87).contentEditable=true;
		obj_item7.readOnly = "";
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_jichusheshi);
		setRadioNotChoosed(obj_gongxiangzhichi);
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1" );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi, "1_1");
	var obj_item18 = getTableFormCheckBox(label_item18,"1_1" );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi, "1_1");
	var obj_item89 = getTableFormCheckBox(label_item89,"1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item7 = getTableFormObj(label_item7,"1_1_1" );
	var obj_item87 = getTableFormObj(label_item87,"1_1" );
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var obj_RadioButtonList = getFormObj(label_RadioButtonList);
	var objs_label_S_item11 = getTableFormObjs(label_S_item11);
	if (obj_RadioButtonList.value=="ȫϽ��Χ") {
		for ( var i = 0; i < objs_label_S_item11.length; i++) {
			// ����ģ��
			if ((objs_label_S_item11[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			if (objs_label_S_item11[i].value.trim()!="") {
				errorObjs.push(getEditDiv(objs_label_S_item11[i]));
				a += "Ӱ�췶Χѡ��ȫϽ��Χ����Χ����Ӧ��Ϊ�գ�\n";
				isValid = false;
			}
		}
	} else {
		for ( var i = 0; i < objs_label_S_item11.length; i++) {
			// ����ģ��
			if ((objs_label_S_item11[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			if (objs_label_S_item11[i].value.trim()=="") {
				errorObjs.push(getEditDiv(objs_label_S_item11[i]));
				a += "Ӱ�췶Χѡ���ȫϽ��Χ����Χ������֧�������Ʋ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
	
	if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
			obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_gongxiangzhichi.value=="" && 
			obj_jichusheshi.value=="" && obj_qita.value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		errorObjs.push(obj_kehuguanli.parentElement);
		errorObjs.push(obj_chanpinguanli.parentElement);
		errorObjs.push(obj_caiwuguanli.parentElement);
		errorObjs.push(obj_juecezhichi.parentElement);
		errorObjs.push(obj_gongxiangzhichi.parentElement);
		errorObjs.push(obj_jichusheshi.parentElement);
		errorObjs.push(obj_qita.parentElement);
		a += "ϵͳ�����Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value != "" && getTarget(getTableFormObj(label_item8, "1_1")).value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		a += "ϵͳ���ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_kehuguanli.value != "" && getTarget(getTableFormObj(label_item10, "1_1")).value=="") {
		errorObjs.push(obj_kehuguanli.parentElement);
		a += "ϵͳ���ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_chanpinguanli.value != "" && getTarget(getTableFormObj(label_item12, "1_1")).value=="") {
		errorObjs.push(obj_chanpinguanli.parentElement);
		a += "ϵͳ���ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_caiwuguanli.value != "" && getTarget(getTableFormObj(label_item14, "1_1")).value=="") {
		errorObjs.push(obj_caiwuguanli.parentElement);
		a += "ϵͳ���ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_juecezhichi.value != "" && getTarget(getTableFormObj(label_item16, "1_1")).value=="") {
		errorObjs.push(obj_juecezhichi.parentElement);
		a += "ϵͳ���ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_gongxiangzhichi.value != "" && getTarget(getTableFormObj(label_item18, "1_1")).value=="") {
		errorObjs.push(obj_gongxiangzhichi.parentElement);
		a += "ϵͳ���ѡ�񡰹���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_jichusheshi.value != "" && getTarget(getTableFormObj(label_item89, "1_1")).value=="") {
		errorObjs.push(obj_jichusheshi.parentElement);
		a += "ϵͳ���ѡ�񡰻�����ʩ��ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
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
