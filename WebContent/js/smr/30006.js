/*
 * ����T-A-7 ��Ϣ�Ƽ���ذ��������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_zuoanshijian_item8 = "����ʱ��#����ʱ��#��ʼʱ��";
var label_zuoanshijian_item9 = "����ʱ��#����ʱ��#����ʱ��";
var label_faxianshijian_item10 = "����ʱ��#����ʱ��";
var label_qudaoguanli="�永��Ϣϵͳ���#�����ϸ#�����������#��������";
var label_item8="�永��Ϣϵͳ���#�����ϸ#�����������#�����ӷ���";
var label_kehuguanli="�永��Ϣϵͳ���#�����ϸ#�ͻ��������#�ͻ�����";
var label_item10="�永��Ϣϵͳ���#�����ϸ#�ͻ��������#�ͻ������ӷ���";
var label_chanpinguanli="�永��Ϣϵͳ���#�����ϸ#��Ʒ�������#��Ʒ����";
var label_item12="�永��Ϣϵͳ���#�����ϸ#��Ʒ�������#��Ʒ���������";
var label_caiwuguanli="�永��Ϣϵͳ���#�����ϸ#����������#�������";
var label_item14="�永��Ϣϵͳ���#�����ϸ#����������#������������";
var label_juecezhichi="�永��Ϣϵͳ���#�����ϸ#����֧�����#����֧��";
var label_item16="�永��Ϣϵͳ���#�����ϸ#����֧�����#����֧�������";
var label_qita="�永��Ϣϵͳ���#�����ϸ#�������#����";
var label_item19="�永��Ϣϵͳ���#�����ϸ#�������#��������";
var label_item13 = "�永��#����";
var label_item15 = "�永��#����";
var label_sheanjine= "�永����Ԫ��#�永����Ԫ��";
var label_fengxianjine="�永����Ԫ��#���ս���Ԫ��";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item19 = getTableFormObj(label_item19,"1_1_1" );
	
	if (obj_qudaoguanli.value=="��������") {
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_kehuguanli.value=="�ͻ�����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_chanpinguanli.value=="��Ʒ����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_caiwuguanli.value=="�������") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item16,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_juecezhichi.value=="����֧��") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		getEditDiv(obj_item19).contentEditable=false;
	} else if (obj_qita.value=="����") {
		disableTableCheckBox(obj_item8,true);
		disableTableCheckBox(obj_item10,true);
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item14,true);
		disableTableCheckBox(obj_item16,true);
	}
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã�����ʱ��#����ʱ��#��ʼʱ��
*/
function checkStartTime(obj){
	var obj_endtime=getTableFormObj(label_zuoanshijian_item9,"1_1");
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
		obj.value="";
		obj.focus();
	}
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã�����ʱ��#����ʱ��#����ʱ��
*/
function checkEndTime(obj){
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
		obj.value="";
		obj.focus();
	}
}
/*
* ���ܣ�����ʱ���������ʼʱ���ǰ��У��
* ���ã�����ʱ��#����ʱ��
*/
function checkDiscoveryTime(obj) {
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("����ʱ�䲻����������ʱ�䣬���������룡");
		obj.value="";
		obj.focus();
	}
}

/*
* ���ܣ����永��Ϣϵͳ����໥������
* ���ã��永��Ϣϵͳ���#�����ϸ#�����������#��������
* �永��Ϣϵͳ���#�����ϸ#�ͻ��������#�ͻ�����
* �永��Ϣϵͳ���#�����ϸ#��Ʒ�������#��Ʒ����
* �永��Ϣϵͳ���#�����ϸ#����������#�������
* �永��Ϣϵͳ���#�����ϸ#����֧�����#����֧��
* �永��Ϣϵͳ���#�����ϸ#�������#����
*/
function sheanxitongleibie_click(obj) {
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
	var obj_qita = getTableFormObj(label_qita,target.rownumber);
	var obj_item19 = getTableFormObj(label_item19,target.rownumber);

	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	getEditDiv(obj_item19).innerHTML = "";
	obj_item19.value="";
	getEditDiv(obj_item19).contentEditable=false;

	if (target.value=="��������"){
		//ָ����ѡ�����ԭ״̬
		disableTableCheckBox(obj_item8,false);
		//���������޹ص�ѡ��״̬Ϊ��ѡ��
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="�ͻ�����"){
		disableTableCheckBox(obj_item10,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="��Ʒ����") {
		disableTableCheckBox(obj_item12,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if(target.value=="�������") {
		disableTableCheckBox(obj_item14,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_juecezhichi);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="����֧��") {
		disableTableCheckBox(obj_item16,false);
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_qita);
	} else if (target.value=="����") {
		getEditDiv(obj_item19).contentEditable=true;
		setRadioNotChoosed(obj_qudaoguanli);
		setRadioNotChoosed(obj_kehuguanli);
		setRadioNotChoosed(obj_chanpinguanli);
		setRadioNotChoosed(obj_caiwuguanli);
		setRadioNotChoosed(obj_juecezhichi);
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_starttime=getTableFormObj(label_zuoanshijian_item8,"1_1");
	var obj_endtime=getTableFormObj(label_zuoanshijian_item9,"1_1");
	var obj_discoverytime=getTableFormObj(label_faxianshijian_item10,"1");
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli, "1_1_1");
	var obj_item8 = getTableFormCheckBox(label_item8,"1_1_1");
	var obj_kehuguanli = getTableFormObj(label_kehuguanli, "1_1_1");
	var obj_item10 = getTableFormCheckBox(label_item10,"1_1_1");
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli, "1_1_1");
	var obj_item12 = getTableFormCheckBox(label_item12,"1_1_1" );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli, "1_1_1");
	var obj_item14 = getTableFormCheckBox(label_item14,"1_1_1" );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi, "1_1_1");
	var obj_item16 = getTableFormCheckBox(label_item16,"1_1_1" );
	var obj_qita = getTableFormObj(label_qita,"1_1_1" );
	var obj_item19 = getTableFormObj(label_item19,"1_1_1" );
	var obj_sheanjine = getTableFormObj(label_sheanjine,"1" );
	var obj_fengxianjine = getTableFormObj(label_fengxianjine,"1" );
	
	// С��λ���㴦��
	checkNumFloat(obj_sheanjine,2);
	checkNumFloat(obj_fengxianjine,2);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "����ʱ�䲻����������ʱ�䣬���������룡\n";
		isValid = false;
	}

	if(obj_starttime.value > obj_discoverytime.value) {
		errorObjs.push(obj_discoverytime);
		a += "��ʼʱ��Ӧ�ڱ��ʱ��֮ǰ�����������룡\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value=="" && obj_kehuguanli.value=="" && obj_chanpinguanli.value=="" &&
			obj_caiwuguanli.value=="" && obj_juecezhichi.value=="" && obj_qita.value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		errorObjs.push(obj_kehuguanli.parentElement);
		errorObjs.push(obj_chanpinguanli.parentElement);
		errorObjs.push(obj_caiwuguanli.parentElement);
		errorObjs.push(obj_juecezhichi.parentElement);
		errorObjs.push(obj_qita.parentElement);
		a += "�永��Ϣϵͳ�����Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_qudaoguanli.value != "" && getTarget(getTableFormObj(label_item8, "1_1_1")).value=="") {
		errorObjs.push(obj_qudaoguanli.parentElement);
		a += "�永��Ϣϵͳ���ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_kehuguanli.value != "" && getTarget(getTableFormObj(label_item10, "1_1_1")).value=="") {
		errorObjs.push(obj_kehuguanli.parentElement);
		a += "�永��Ϣϵͳ���ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_chanpinguanli.value != "" && getTarget(getTableFormObj(label_item12, "1_1_1")).value=="") {
		errorObjs.push(obj_chanpinguanli.parentElement);
		a += "�永��Ϣϵͳ���ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_caiwuguanli.value != "" && getTarget(getTableFormObj(label_item14, "1_1_1")).value=="") {
		errorObjs.push(obj_caiwuguanli.parentElement);
		a += "�永��Ϣϵͳ���ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	if (obj_juecezhichi.value != "" && getTarget(getTableFormObj(label_item16, "1_1_1")).value=="") {
		errorObjs.push(obj_juecezhichi.parentElement);
		a += "�永��Ϣϵͳ���ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
		isValid = false;
	}
	
	// �������100ʱ�Զ�����Ϊ100
	if (isValid) {
		var objs = getTableFormObjs(label_item13);
		for ( var i = 0; i < objs.length; i++) {
			// ����ģ��
			if ((objs[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			var obj_item15 = getTableFormObj(label_item15,objs[i].rownumber);
			if (obj_item15.value>"100"){
				obj_item15.value="100";
			}
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