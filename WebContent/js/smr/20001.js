/*
 * ����T-Q-2 ��Ϣ�Ƽ���Ŀ�����_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5_1="1 �������������ش���Ŀ#��Ŀ����";
var label_item24_GTZero_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��ĿͶ��";
var label_item25_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����#�ƻ���������#�ƻ���������";
var label_item26_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��Ŀ����#��Ŀ��ʼ����#��Ŀ��ʼ����";
var label_item48_1="1 �������������ش���Ŀ#�������������ش���Ŀ#ʵʩģʽ";
var label_item26_desc_1="1 �������������ش���Ŀ#�������������ش���Ŀ#ϵͳ��������";
var label_qudaoguanli_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��������#ϵͳ���";
var label_qudaoguanliItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��������#�����";
var label_kehuguanli_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#ϵͳ���";
var label_kehuguanliItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#�����";
var label_chanpinguanli_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#ϵͳ���";
var label_chanpinguanliItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#�����";
var label_caiwuguanli_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�������#ϵͳ���";
var label_caiwuguanliItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�������#�����";
var label_juecezhichi_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���";
var label_juecezhichiItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#�����";
var label_gongxiangzhichi_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���";
var label_gongxiangzhichiItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#�����";
var label_jichusheshi_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#ϵͳ���";
var label_jichusheshiItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#�����";
var label_qita_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����#ϵͳ���";
var label_qitaItems_1="1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����#�����";
var label_item5_2="2 ��������ɵ��ش���Ŀ#��Ŀ����";
var label_item24_GTZero_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��ĿͶ��";
var label_item25_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��Ŀ����#��������#��������";
var label_item26_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��Ŀ����#��Ŀ��ʼ����#��Ŀ��ʼ����";
var label_item48_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#ʵʩģʽ";
var label_item26_desc_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#ϵͳ��������";
var label_item27_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#����#����";
var label_O_item27_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#����#����ԭ��";
var label_qudaoguanli_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#��������#ϵͳ���";
var label_qudaoguanliItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#��������#�����";
var label_kehuguanli_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#�ͻ�����#ϵͳ���";
var label_kehuguanliItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#�ͻ�����#�����";
var label_chanpinguanli_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#��Ʒ����#ϵͳ���";
var label_chanpinguanliItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#��Ʒ����#�����";
var label_caiwuguanli_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#�������#ϵͳ���";
var label_caiwuguanliItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#�������#�����";
var label_juecezhichi_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����֧��#ϵͳ���";
var label_juecezhichiItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����֧��#�����";
var label_gongxiangzhichi_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����֧��#ϵͳ���";
var label_gongxiangzhichiItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����֧��#�����";
var label_jichusheshi_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#������ʩ#ϵͳ���";
var label_jichusheshiItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#������ʩ#�����";
var label_qita_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����#ϵͳ���";
var label_qitaItems_2="2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#��������#����#�����";
var label_item5_3="3 ����������ʵʩ���ش���Ŀ#��Ŀ����";
var label_item24_GTZero_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��ĿͶ��";
var label_item25_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��Ŀ����#�ƻ���������#�ƻ���������";
var label_item26_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��Ŀ����#��Ŀ��ʼ����#��Ŀ��ʼ����";
var label_item48_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#ʵʩģʽ";
var label_item26_desc_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#ϵͳ��������";
var label_item27_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#����#����";
var label_O_item27_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#����#����ԭ��";
var label_qudaoguanli_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#��������#ϵͳ���";
var label_qudaoguanliItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#��������#�����";
var label_kehuguanli_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#�ͻ�����#ϵͳ���";
var label_kehuguanliItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#�ͻ�����#�����";
var label_chanpinguanli_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#��Ʒ����#ϵͳ���";
var label_chanpinguanliItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#��Ʒ����#�����";
var label_caiwuguanli_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#�������#ϵͳ���";
var label_caiwuguanliItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#�������#�����";
var label_juecezhichi_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����֧��#ϵͳ���";
var label_juecezhichiItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����֧��#�����";
var label_gongxiangzhichi_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����֧��#ϵͳ���";
var label_gongxiangzhichiItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����֧��#�����";
var label_jichusheshi_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#������ʩ#ϵͳ���";
var label_jichusheshiItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#������ʩ#�����";
var label_qita_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����#ϵͳ���";
var label_qitaItems_3="3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#��������#����#�����";


/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var objs_1 = getTableFormObjs(label_item5_1);
	var objs_2 = getTableFormObjs(label_item5_2);
	var objs_3 = getTableFormObjs(label_item5_3);
	initSet_1(objs_1);
	initSet_2(objs_2);
	initSet_3(objs_3);
	var cc = 0;
	set_O_item27_2(cc);
	set_O_item27_3(cc);
}

/*
* ���ܣ�2.��������ɵ��ش���Ŀ ����ԭ������
* ���ã�2 ��������ɵ��ش���Ŀ#��������ɵ��ش���Ŀ#����#����
*/
function set_O_item27_2(obj){
	var obj_item27_2s = getTableFormObjs(label_item27_2);
	for(var i = 0; i< obj_item27_2s.length; i++){
		var obj_O_item27_2 = getTableFormObj(label_O_item27_2,obj_item27_2s[i].rownumber );
		var obj_O_item27_2_area = getEditDiv(obj_O_item27_2);
		if(obj_item27_2s[i].value == "��"){
			obj_O_item27_2_area.contentEditable = false;
			obj_O_item27_2_area.innerHTML = "";
			obj_O_item27_2.value = "";
		}else{
			obj_O_item27_2_area.contentEditable = true;
		}
	}
}

/*
* ���ܣ�3 ����������ʵʩ���ش���Ŀ ����ԭ������
* ���ã�3 ����������ʵʩ���ش���Ŀ#����������ʵʩ���ش���Ŀ#����#����
*/
function set_O_item27_3(obj){
	var obj_item27_3s = getTableFormObjs(label_item27_3);
	for(var i = 0; i< obj_item27_3s.length; i++){
		var obj_O_item27_3 = getTableFormObj(label_O_item27_3,obj_item27_3s[i].rownumber );
		var obj_O_item27_3_area = getEditDiv(obj_O_item27_3);
		if(obj_item27_3s[i].value == "��"){
			obj_O_item27_3_area.contentEditable = false;
			obj_O_item27_3_area.innerHTML = "";
			obj_O_item27_3.value = "";
		}else{
			obj_O_item27_3_area.contentEditable = true;
		}
	}
}

/*
* ���ܣ�1 �������������ش���Ŀ��ϵͳ����໥������
* ���ã�1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��������#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#�������#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#ϵͳ���
* 1 �������������ش���Ŀ#�������������ش���Ŀ#��������#����#ϵͳ���
*/
function xitongleibie_click_1(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_1,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_1, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_1,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_1,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_1,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_1, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_1,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_1,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_1, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_1,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_1,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_1,target.rownumber );
	
	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value= "";
	obj_item87.readOnly="readonly";

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
	} else if (target.value=="����") {
		obj_item87.readOnly="";
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
* ���ܣ�2 ��������ɵ��ش���Ŀ��ϵͳ����໥������
* ���ã�2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#��������#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#�������#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#ϵͳ���
* 2 ��������ɵ��ش���Ŀ#�������������ش���Ŀ#��������#����#ϵͳ���
*/
function xitongleibie_click_2(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_2,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_2, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_2,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_2,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_2,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_2, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_2,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_2,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_2, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_2,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_2,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_2,target.rownumber );
	
	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value= "";
	obj_item87.readOnly="readonly";

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
	} else if (target.value=="����") {
		obj_item87.readOnly="";
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
* ���ܣ�3 ����������ʵʩ���ش���Ŀ��ϵͳ����໥������
* ���ã�3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#��������#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#�ͻ�����#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#��Ʒ����#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#�������#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#����֧��#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#������ʩ#ϵͳ���
* 3 ����������ʵʩ���ش���Ŀ#�������������ش���Ŀ#��������#����#ϵͳ���
*/
function xitongleibie_click_3(obj) {
	var target = getTarget(obj.parentElement);
	var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3, target.rownumber);
	var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_3,target.rownumber);
	var obj_kehuguanli = getTableFormObj(label_kehuguanli_3, target.rownumber);
	var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_3,target.rownumber);
	var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3, target.rownumber);
	var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_3,target.rownumber );
	var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3, target.rownumber);
	var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_3,target.rownumber );
	var obj_juecezhichi = getTableFormObj(label_juecezhichi_3, target.rownumber);
	var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_3,target.rownumber );
	var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3, target.rownumber);
	var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_3,target.rownumber );
	var obj_jichusheshi = getTableFormObj(label_jichusheshi_3, target.rownumber);
	var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_3,target.rownumber );
	var obj_qita = getTableFormObj(label_qita_3,target.rownumber );
	var obj_item87 = getTableFormObj(label_qitaItems_3,target.rownumber );
	
	//����ϵͳ����ȫ����ѡ��Ϊֻ�������ֵ
	disableTableCheckBox(obj_item8,true);
	disableTableCheckBox(obj_item10,true);
	disableTableCheckBox(obj_item12,true);
	disableTableCheckBox(obj_item14,true);
	disableTableCheckBox(obj_item16,true);
	disableTableCheckBox(obj_item18,true);
	disableTableCheckBox(obj_item89,true);
	obj_item87.value = "";
	obj_item87.readOnly="readonly";

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
	} else if (target.value=="����") {
		obj_item87.readOnly="";
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
	if (!checkEmptyReport()) {
		return true;
	}
	var objs_1 = getTableFormObjs(label_item5_1);
	var objs_2 = getTableFormObjs(label_item5_2);
	var objs_3 = getTableFormObjs(label_item5_3);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	//1 �������������ش���Ŀ У��
	subCheckfunction1(objs_1);
	//2 ��������ɵ��ش���ĿУ��
	subCheckfunction2(objs_2);
	//3 ����������ʵʩ���ش���ĿУ��
	subCheckfunction3(objs_3);
	
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
*���ܣ�1 �������������ش���Ŀ����֤
*/
function subCheckfunction1(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// ����ģ��
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_1 = getTableFormObj(label_item24_GTZero_1,
				objs_1[i].rownumber + "_1");
		var obj_item25_1 = getTableFormObj(label_item25_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item26_1 = getTableFormObj(label_item26_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item48_1 = getTableFormObj(label_item48_1,
				objs_1[i].rownumber + "_1");
		var obj_item26_desc_1 = getTableFormObj(label_item26_desc_1,
				objs_1[i].rownumber + "_1");
		if (objs_1[i].value.trim() !="" && objs_1[i].value.trim() != "��"){
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
				a +="1���������������ش���Ŀ"+(i+1)+ "�����Ʋ�Ϊ���ޡ���գ������ϵͳ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_1, objs_1[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ��������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item24_GTZero_1.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_1);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������ĿͶ�벻��Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_1.value.trim() == "") {
				errorObjs.push(obj_item25_1);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ƻ��������ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_1.value.trim() == "") {
				errorObjs.push(obj_item26_1);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������Ŀ��ʼ���ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item48_1.value.trim() == "") {
				errorObjs.push(obj_item48_1.parentElement);
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ʵʩģʽ����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_desc_1.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_1));
				a += "1���������������ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ϵͳ������������Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_1.value!="" && obj_item26_1.value!="") {
				if (obj_item25_1.value < obj_item26_1.value){
					errorObjs.push(obj_item26_1);
					errorObjs.push(obj_item25_1);
					a += "1���������������ش���Ŀ"+(i+1)+"������Ŀ��ʼ���ڡ�ӦС�ڡ��ƻ��������ڡ���\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_1.value.trim()!=""||
					obj_item25_1.value.trim() != ""||obj_item26_1.value.trim() != ""||obj_item48_1.value.trim() != ""||
					obj_item26_desc_1.value.trim() != "") {
				errorObjs.push(objs_1[i]);
				a += "1���������������ش���Ŀ"+(i+1)+"���·����ݷǿգ�����Ŀ���Ʋ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
}



/*
*���ܣ�2 ��������ɵ��ش���Ŀ����֤
*/
function subCheckfunction2(objs_2){
	for ( var i = 0; i < objs_2.length; i++) {
		// ����ģ��
		if ((objs_2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_2 = getTableFormObj(label_item24_GTZero_2,
				objs_2[i].rownumber + "_1");
		var obj_item25_2 = getTableFormObj(label_item25_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item26_2 = getTableFormObj(label_item26_2,
				objs_2[i].rownumber + "_1_1_1");
		var obj_item48_2 = getTableFormObj(label_item48_2,
				objs_2[i].rownumber + "_1");
		var obj_item26_desc_2 = getTableFormObj(label_item26_desc_2,
				objs_2[i].rownumber + "_1");
		var obj_item27_2 = getTableFormObj(label_item27_2,
				objs_2[i].rownumber + "_1_1");
		var obj_O_item27_2 = getTableFormObj(label_O_item27_2,
				objs_2[i].rownumber + "_1_1");
		
		if (objs_2[i].value.trim() !="" && objs_2[i].value.trim() != "��"){
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
				a +="2 ��������ɵ��ش���Ŀ"+(i+1)+ "�����Ʋ�Ϊ���ޡ���գ������ϵͳ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_2, objs_2[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ��������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item24_GTZero_2.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_2);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������ĿͶ�벻��Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_2.value.trim() == "") {
				errorObjs.push(obj_item25_2);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ƻ��������ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_2.value.trim() == "") {
				errorObjs.push(obj_item26_2);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������Ŀ��ʼ���ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item48_2.value.trim() == "") {
				errorObjs.push(obj_item48_2.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ʵʩģʽ����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_desc_2.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_2));
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ϵͳ������������Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item27_2.value.trim() == "") {
				errorObjs.push(obj_item27_2.parentElement);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�������Ƿ����ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_2.value!="" && obj_item26_2.value!="") {
				if (obj_item25_2.value < obj_item26_2.value){
					errorObjs.push(obj_item26_2);
					errorObjs.push(obj_item25_2);
					a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"������Ŀ��ʼ���ڡ�ӦС�ڡ��ƻ��������ڡ���\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_2.value.trim()!=""||
					obj_item25_2.value.trim() != ""||obj_item26_2.value.trim() != ""||obj_item48_2.value.trim() != ""||
					obj_item26_desc_2.value.trim() != "" || obj_item27_2.value.trim() !="") {
				errorObjs.push(objs_2[i]);
				a += "2 ��������ɵ��ش���Ŀ"+(i+1)+"���·����ݷǿգ�����Ŀ���Ʋ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
	
}


/*
*���ܣ�3 ����������ʵʩ���ش���Ŀ
*/
function subCheckfunction3(objs_3){
	for ( var i = 0; i < objs_3.length; i++) {
		// ����ģ��
		if ((objs_3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item24_GTZero_3 = getTableFormObj(label_item24_GTZero_3,
				objs_3[i].rownumber + "_1");
		var obj_item25_3 = getTableFormObj(label_item25_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item26_3 = getTableFormObj(label_item26_3,
				objs_3[i].rownumber + "_1_1_1");
		var obj_item48_3 = getTableFormObj(label_item48_3,
				objs_3[i].rownumber + "_1");
		var obj_item26_desc_3 = getTableFormObj(label_item26_desc_3,
				objs_3[i].rownumber + "_1");
		var obj_item27_3 = getTableFormObj(label_item27_3,
				objs_3[i].rownumber + "_1_1");
		var obj_O_item27_3 = getTableFormObj(label_O_item27_3,
				objs_3[i].rownumber + "_1_1");
		
		if (objs_3[i].value.trim() !="" && objs_3[i].value.trim() != "��"){
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
				a +="3 ����������ʵʩ���ش���Ŀ"+(i+1)+ "�����Ʋ�Ϊ���ޡ���գ������ϵͳ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qudaoguanli.value != "" && 
					getTarget(getTableFormObj(label_qudaoguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qudaoguanli.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ����������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_kehuguanli.value != "" && 
					getTarget(getTableFormObj(label_kehuguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_kehuguanli.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰿ͻ�����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_chanpinguanli.value != "" && 
					getTarget(getTableFormObj(label_chanpinguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_chanpinguanli.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲�Ʒ����ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_caiwuguanli.value != "" && 
					getTarget(getTableFormObj(label_caiwuguanliItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_caiwuguanli.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰲������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_juecezhichi.value != "" && 
					getTarget(getTableFormObj(label_juecezhichiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_juecezhichi.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_gongxiangzhichi.value != "" && 
					getTarget(getTableFormObj(label_gongxiangzhichiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_gongxiangzhichi.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_jichusheshi.value != "" && 
					getTarget(getTableFormObj(label_jichusheshiItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_jichusheshi.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ�񡰾���֧�֡�ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_qita.value != "" && 
					getTarget(getTableFormObj(label_qitaItems_3, objs_3[i].rownumber+"_1_1_1")).value=="") {
				errorObjs.push(obj_qita.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�ѡ��������ʱ�����Ӧ�������Ͳ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item24_GTZero_3.value.trim() == "") {
				errorObjs.push(obj_item24_GTZero_3);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������ĿͶ�벻��Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_3.value.trim() == "") {
				errorObjs.push(obj_item25_3);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ƻ��������ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_3.value.trim() == "") {
				errorObjs.push(obj_item26_3);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ��������Ŀ��ʼ���ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item48_3.value.trim() == "") {
				errorObjs.push(obj_item48_3.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ʵʩģʽ����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item26_desc_3.value.trim() == "") {
				errorObjs.push(getEditDiv(obj_item26_desc_3));
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ������ϵͳ������������Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item27_3.value.trim() == "") {
				errorObjs.push(obj_item27_3.parentElement);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"�����Ʋ�Ϊ���ޡ���գ�������Ƿ����ڲ���Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item25_3.value!="" && obj_item26_3.value!="") {
				if (obj_item25_3.value < obj_item26_3.value){
					errorObjs.push(obj_item26_3);
					errorObjs.push(obj_item25_3);
					a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"������Ŀ��ʼ���ڡ�ӦС�ڡ��ƻ��������ڡ���\n";
					isValid = false;
				}
			}
		} else {
			if (obj_qudaoguanli.value!="" || obj_kehuguanli.value!="" || obj_chanpinguanli.value!="" ||
					obj_caiwuguanli.value!="" || obj_juecezhichi.value!="" || obj_gongxiangzhichi.value!="" || 
					obj_jichusheshi.value!="" || obj_qita.value!="" || obj_item24_GTZero_3.value.trim()!=""||
					obj_item25_3.value.trim() != ""||obj_item26_3.value.trim() != ""||obj_item48_3.value.trim() != ""||
					obj_item26_desc_3.value.trim() != "" || obj_item27_3.value.trim() !="") {
				errorObjs.push(objs_3[i]);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"���·����ݷǿգ�����Ŀ���Ʋ���Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
	//�������У��������У��ƻ��������ں���Ŀ��ʼ����ǰ���ϵ
	if (isValid){
		for ( var i = 0; i < objs_3.length; i++) {
			// ����ģ��
			if ((objs_3[i].rownumber + "").indexOf("#") > -1) {
				continue;
			}
			var obj_item25 = getTableFormObj(label_item25_3,
					objs_3[i].rownumber + "_1_1_1");
			var obj_item26 = getTableFormObj(label_item26_3,
					objs_3[i].rownumber + "_1_1_1");
			if (obj_item25.value < obj_item26.value){
				errorObjs.push(obj_item26);
				a += "3 ����������ʵʩ���ش���Ŀ"+(i+1)+"������Ŀ��ʼ���ڡ�ӦС�ڡ��ƻ��������ڡ���\n";
				isValid = false;
			}
		}
	}
}


/*
* ���ܣ�"1 �������������ش���Ŀ"��������״̬��ʼ��ʱ���ñ�Ȩ��
*/
function initSet_1(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// ����ģ��
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_1,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_1,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_1,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_1,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="��������") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="�ͻ�����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="��Ʒ����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="�������") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="������ʩ") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
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
}
/*
* ���ܣ�"2 ��������ɵ��ش���Ŀ"��������״̬��ʼ��ʱ���ñ�Ȩ��
*/
function initSet_2(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// ����ģ��
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_2,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_2,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_2,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_2,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="��������") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="�ͻ�����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="��Ʒ����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="�������") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="������ʩ") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
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
}

/*
* ���ܣ�"3 ����������ʵʩ���ش���Ŀ"��������״̬��ʼ��ʱ���ñ�Ȩ��
*/
function initSet_3(objs_1){
	for ( var i = 0; i < objs_1.length; i++) {
		// ����ģ��
		if ((objs_1[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_qudaoguanli = getTableFormObj(label_qudaoguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_kehuguanli = getTableFormObj(label_kehuguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_chanpinguanli = getTableFormObj(label_chanpinguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_caiwuguanli = getTableFormObj(label_caiwuguanli_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_juecezhichi = getTableFormObj(label_juecezhichi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_gongxiangzhichi = getTableFormObj(label_gongxiangzhichi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_jichusheshi = getTableFormObj(label_jichusheshi_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_qita = getTableFormObj(label_qita_3,
				objs_1[i].rownumber + "_1_1_1");
		var obj_item8 = getTableFormCheckBox(label_qudaoguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item10 = getTableFormCheckBox(label_kehuguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item12 = getTableFormCheckBox(label_chanpinguanliItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item14 = getTableFormCheckBox(label_caiwuguanliItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item16 = getTableFormCheckBox(label_juecezhichiItems_3,objs_1[i].rownumber + "_1_1_1");
		var obj_item18 = getTableFormCheckBox(label_gongxiangzhichiItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item89 = getTableFormCheckBox(label_jichusheshiItems_3,objs_1[i].rownumber + "_1_1_1" );
		var obj_item87 = getTableFormObj(label_qitaItems_3,objs_1[i].rownumber + "_1_1_1" );
		
		if (obj_qudaoguanli.value=="��������") {
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_kehuguanli.value=="�ͻ�����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_chanpinguanli.value=="��Ʒ����") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_caiwuguanli.value=="�������") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_juecezhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item18,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_gongxiangzhichi.value=="����֧��") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item89,true);
			obj_item87.readOnly="readonly";
		} else if (obj_jichusheshi.value=="������ʩ") {
			disableTableCheckBox(obj_item8,true);
			disableTableCheckBox(obj_item10,true);
			disableTableCheckBox(obj_item12,true);
			disableTableCheckBox(obj_item14,true);
			disableTableCheckBox(obj_item16,true);
			disableTableCheckBox(obj_item18,true);
			obj_item87.readOnly="readonly";
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
}