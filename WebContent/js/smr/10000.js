/*
 * ����T-B-1 ��Ϣ�Ƽ����������_11A
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN0101_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#��������";
var label_YN0102_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#������������";
var label_YN0103_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#������Ϣ�Ƽ��������Ķ�������";
var label_YN0104_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#������Ϣ�Ƽ��������Ķ�����������";
var label_YN0105_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#�߹ܲ�����";
var label_YN0106_GTZero = "���»���Ϣ�Ƽ����չ���ְ��#����#������Ϣ�Ƽ��������ĸ߹�����";

var label_YN02 = "��Ϣ�Ƽ�����ίԱ��#����#�Ƿ�����";
var label_YN02_01 = "��Ϣ�Ƽ�����ίԱ��#����#��֯����";
var label_YN02_02 = "��Ϣ�Ƽ�����ίԱ��#����#��������";
var label_YN02_03 = "��Ϣ�Ƽ�����ίԱ��#����#��֯������";
var label_YN02_04 = "��Ϣ�Ƽ�����ίԱ��#����#ְ��";
var label_YN02_06_GTZero = "��Ϣ�Ƽ�����ίԱ��#����#��Ϣ�Ƽ�����ίԱ��������";
var label_YN02_07_GTZero = "��Ϣ�Ƽ�����ίԱ��#����#��Ϣ�Ƽ�����ίԱ���о�����Ϣ�Ƽ���������";
var label_YN02_08_GTZero = "��Ϣ�Ƽ�����ίԱ��#����#��Ϣ�Ƽ�����ίԱ������רҵ��ίԱ�����������";
var label_YN02_09_GTZero = "��Ϣ�Ƽ�����ίԱ��#����#�������Ϣ�Ƽ�����ίԱ��ȫ��������";	

var label_YN03 = "��ϯ��Ϣ��(CIO)#����#�Ƿ�����";
var label_YN03_01 = "��ϯ��Ϣ��(CIO)#����#����";
var label_YN03_02 = "��ϯ��Ϣ��(CIO)#����#ְ��";
var label_YN03_03 = "��ϯ��Ϣ��(CIO)#����#��ְ��ʼ����";
var label_YN03_04 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ���Ƿ�����߼������";
var label_YN03_05 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ�ٻ㱨·��";

var label_YN08 = "��Ϣ�Ƽ�ս�Թ滮#����#�Ƿ�����Ϣ�Ƽ�ս�Թ滮";
var label_YN08_01 = "��Ϣ�Ƽ�ս�Թ滮#����#��Ϣ�Ƽ�ս�Թ滮����";
var label_YN08_02_GTZero = "��Ϣ�Ƽ�ս�Թ滮#����#�滮��";
var label_YN08_03_GTZero = "��Ϣ�Ƽ�ս�Թ滮#����#��";
var label_YN08_04 = "��Ϣ�Ƽ�ս�Թ滮#����#ǩ������";
var label_YN08_05 = "��Ϣ�Ƽ�ս�Թ滮#����#ǩ����ְ��";

var label_YN09 = "���չ����ţ���֯��#����#�Ƿ�������ָ��ר�ŵ���Ϣ�Ƽ����չ�����(��֯)";
var label_YN09_01 = "���չ����ţ���֯��#����#���ţ���֯������";
var label_YN09_02 = "���չ����ţ���֯��#����#������";
var label_YN09_03 = "���չ����ţ���֯��#����#ְ��";
var label_YN09_04 = "���չ����ţ���֯��#����#������";
var label_YN09_05_GTZero = "���չ����ţ���֯��#����#��Ϣ�Ƽ�����רְ��Ա";
var label_YN09_06 = "���չ����ţ���֯��#����#���չ����ţ���֯������·��";

var label_YN10 = "�����ţ���λ��#����#�Ƿ�����";
var label_YN10_01 = "�����ţ���λ��#����#���ţ���λ������";
var label_YN10_02 = "�����ţ���λ��#����#������";
var label_YN10_03 = "�����ţ���λ��#����#ְ��";
var label_YN10_04_GTZero = "�����ţ���λ��#����#������Ա";
var label_YN10_05 = "�����ţ���λ��#����#��Ϣ�Ƽ������ţ���λ���Ƿ�����";
var label_YN10_05_01 = "�����ţ���λ��#����#��Ϣ�Ƽ������ţ���λ������";
var label_YN10_05_02_GTZero = "�����ţ���λ��#����#��Ϣ�Ƽ�������Ա";
var label_YN10_05_03 = "�����ţ���λ��#����#��Ϣ�Ƽ������ű���·��";

var label_item95 = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��ռ�����Ͷ��ı�����";
var label_D1_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ������ƶ�����#��Ϣ�Ƽ������ƶ�����";
var label_D2_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ������ƶ�����#����#���������";
var label_D3_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ������ƶ�����#����#������޶�";
var label_D4_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ����չ����ƶ�����#��Ϣ�Ƽ����չ����ƶ�����";
var label_D5_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ����չ����ƶ�����#����#���������";
var label_D6_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ����չ����ƶ�����#����#������޶�";
var label_D7_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ�����ƶ�����#��Ϣ�Ƽ�����ƶ�����";
var label_D8_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ�����ƶ�����#����#���������";
var label_D9_GTZero = "��Ϣ�Ƽ�����ƶȼ���׼#����#��Ϣ�Ƽ�����ƶ�����#����#������޶�";

var label_item75_GTZero = "�����ʲ���ģ#����#�ʲ��ܶ�";

var label_item80_GTZero = "������Ա���ؼ���λ#����#��ʽԱ����";
var label_item81_GTZero = "������Ա���ؼ���λ#����#����ʽԱ����";
var label_item82_GTZero = "������Ա���ؼ���λ#����#��Ϣ�Ƽ���ʽԱ����";
var label_item83_GTZero = "������Ա���ؼ���λ#����#��Ϣ�Ƽ�����ʽԱ����";
var label_item84_GTZero = "������Ա���ؼ���λ#����#��Ϣ�Ƽ��������ְԱ����";
var label_item85_GTZero = "������Ա���ؼ���λ#����#��Ϣ�Ƽ��������ְԱ����";
var label_item87_GTZero = "������Ա���ؼ���λ#����#��Ϣ�Ƽ��ؼ���λ����";

var label_item88_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#�������Ϣ�Ƽ�Ͷ��";
var label_item89_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#������ʩ����Ͷ��";
var label_item90_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#�����豸�ɹ�Ͷ";
var label_item91_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#����ɹ�Ͷ��";
var label_item92_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#ϵͳ������ĿͶ��";
var label_item93_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#ϵͳ��ӪͶ��";
var label_item1000_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#��Ϣ�Ƽ�������Դ����";
var label_item101_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��#����#����";
var label_item94_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ����������ã�";
var label_item95_GTZero = "������Ϣ�Ƽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��ռ�����Ͷ��ı�����";

var label_DecimalField1_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ��ȫ����#ͨ������(��λ:��)";
var label_DecimalField2_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ��ȫ����#����-ͨ������(��λ:��)#CISSP";
var label_DecimalField3_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ��ȫ����#����-ͨ������(��λ:��)#CISM";
var label_DecimalField4_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ��ȫ����#����-ͨ������(��λ:��)#BS7799-LA";
var label_DecimalField5_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ��ȫ����#����-ͨ������(��λ:��)#����";

var label_DecimalField6_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ��������#ͨ������(��λ:��)";
var label_DecimalField7_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ��������#����-ͨ������(��λ:��)#ITIL Service Manager";
var label_DecimalField8_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ��������#����-ͨ������(��λ:��)#ITIL Practitioner";
var label_DecimalField9_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ��������#����-ͨ������(��λ:��)#����";

var label_DecimalField10_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#ͨ����������λ���ˣ�";
var label_DecimalField11_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#PMP";
var label_DecimalField12_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#PRINCE2";
var label_DecimalField13_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#ϵͳ�ܹ�ʦ";
var label_DecimalField14_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#ϵͳ����ʦ";
var label_DecimalField15_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#��Ϣϵͳ��Ŀ����ʦ";
var label_DecimalField16_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#��Ϣ�Ƽ���Ŀ�����͹���#����-ͨ������(��λ:��)#����";

var label_DecimalField17_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#�������#ͨ����������λ���ˣ�";
var label_DecimalField18_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#�������#����-ͨ����������λ���ˣ�#CCIE";
var label_DecimalField19_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#�������#����-ͨ����������λ���ˣ�#����";

var label_DecimalField20_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���ݿ����#ͨ����������λ���ˣ�";
var label_DecimalField21_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���ݿ����#����-ͨ����������λ���ˣ�#OCP";
var label_DecimalField22_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���ݿ����#����-ͨ����������λ���ˣ�#OCM";
var label_DecimalField23_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���ݿ����#����-ͨ����������λ���ˣ�#IBM Certified DBA";
var label_DecimalField24_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���ݿ����#����-ͨ����������λ���ˣ�#����";

var label_DecimalField25_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#ҵ�������Թ���#ͨ����������λ���ˣ�";
var label_DecimalField26_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#ҵ�������Թ���#����-ͨ����������λ���ˣ�#CBCP";
var label_DecimalField27_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#ҵ�������Թ���#����-ͨ����������λ���ˣ�#����";

var label_DecimalField28_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���#ͨ����������λ���ˣ�";
var label_DecimalField29_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���#����-ͨ����������λ���ˣ�#CISA";
var label_DecimalField30_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���#����-ͨ����������λ���ˣ�#CIA";
var label_DecimalField31_GTZero = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#���#����-ͨ����������λ���ˣ�#����";

var label_D11_GTZero = "���������ģ#����#���о��ڷ�֧������ʡ������������";
/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	setYN02Disable(obj);
	setYN03Disable(obj);
	setYN08Disable(obj);
	setYN09Disable(obj);
	setYN10Disable(obj);
	setYN10_05Disable(obj);
}

/*
 *���ܣ�����Ϣ�Ƽ�����ίԱ��������ڵ���ȡÿ���µĵ�һ��
 *���ã���Ϣ�Ƽ�����ίԱ��#����#��������
 */
function changeYN02_02(obj){
	var obj_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	obj_YN02_02.value = obj_YN02_02.value.substring(0,obj_YN02_02.value.lastIndexOf("/")) + "/01";
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ�����ίԱ��#����#�Ƿ�����
 */
function setYN02Disable(objcld) {
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_01 = getTableFormObj(label_YN02_01,obj_YN02.rownumber );
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02.rownumber );
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02.rownumber );
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02.rownumber );
	var obj_YN02_06_GTZero = getTableFormObj(label_YN02_06_GTZero,obj_YN02.rownumber );
	var obj_YN02_07_GTZero = getTableFormObj(label_YN02_07_GTZero,obj_YN02.rownumber );
	var obj_YN02_08_GTZero = getTableFormObj(label_YN02_08_GTZero,obj_YN02.rownumber );
	var obj_YN02_09_GTZero = getTableFormObj(label_YN02_09_GTZero,obj_YN02.rownumber );
	if (obj_YN02.value.trim() == "��") {
		// ֻ��
		obj_YN02_01.readOnly = "readonly";
		obj_YN02_02.onclick = "";
		obj_YN02_03.readOnly = "readonly";
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_06_GTZero.onclick = "";
		obj_YN02_07_GTZero.onclick = "";
		obj_YN02_08_GTZero.onclick = "";
		obj_YN02_09_GTZero.onclick = "";
		// ���
		obj_YN02_01.value = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		obj_YN02_04.value = "";
		obj_YN02_06_GTZero.value = "";
		obj_YN02_07_GTZero.value = "";
		obj_YN02_08_GTZero.value = "";
		obj_YN02_09_GTZero.value = "";
	} else if (obj_YN02.value.trim() == "��") {
		// ��ԭ
		obj_YN02_01.readOnly = "";
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03.readOnly = "";
		obj_YN02_04.readOnly = "";
		obj_YN02_06_GTZero.onclick = click_columnValueNumber;
		obj_YN02_07_GTZero.onclick = click_columnValueNumber;
		obj_YN02_08_GTZero.onclick = click_columnValueNumber;
		obj_YN02_09_GTZero.onclick = click_columnValueNumber;
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���ϯ��Ϣ��(CIO)#����#�Ƿ�����
 */
function setYN03Disable(obj) {
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN03.rownumber );
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03.rownumber );
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03.rownumber );
	var obj_YN03_05 = getTableFormObj(label_YN03_05,obj_YN03.rownumber );
	
	if (obj_YN03.value == "��") {
		// ֻ��
		obj_YN03_01.readOnly = "readonly";
		obj_YN03_02.readOnly = "readonly";
		obj_YN03_03.onclick = "";
		columnVallueRadio1(obj_YN03_04,false,false);
		obj_YN03_05.readOnly = "readonly";

		// ���
		obj_YN03_01.value = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";

	} else if (obj_YN03.value == "��") {
		// ��ԭ
		obj_YN03_01.readOnly = "";
		obj_YN03_02.readOnly = "";
		obj_YN03_03.onclick = click_columnshowDate;
		columnVallueRadio1(obj_YN03_04,true,false);
		obj_YN03_05.readOnly = "";

	}
}
/*
 *���ܣ���ѡ��ť�Ķ�д����
 *������objΪ��ѡ����
 *	  access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false
 *	  flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio1(obj,access,flag){
	if(!access){
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
					if(!access){
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					}else{
						if(!flag){
							imgs[k].onclick = function(){
								columnVallueRadio(this);
							};
						}else{
							imgs[k].onclick = function(){
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
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ�ս�Թ滮#����#�Ƿ�����Ϣ�Ƽ�ս�Թ滮
 */
function setYN08Disable(objcld) {
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02_GTZero = getTableFormObj(label_YN08_02_GTZero,obj_YN08.rownumber );
	var obj_YN08_03_GTZero = getTableFormObj(label_YN08_03_GTZero,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "��") {
		// ֻ��
		obj_YN08_01.readOnly = "readonly";
		obj_YN08_02_GTZero.onclick = "";
		obj_YN08_03_GTZero.onclick = "";
		obj_YN08_04.onclick = "";
		obj_YN08_05.readOnly = "readonly";

		// ���
		obj_YN08_01.value = "";
		obj_YN08_02_GTZero.value = "";
		obj_YN08_03_GTZero.value = "";
		obj_YN08_04.value = "";
		obj_YN08_05.value = "";

	} else if (obj_YN08.value.trim() == "��") {
		// ��ԭ
		obj_YN08_01.readOnly = "";
		obj_YN08_02_GTZero.onclick = click_columnValueNumber;
		obj_YN08_03_GTZero.onclick = click_columnValueNumber;
		obj_YN08_04.onclick = click_columnshowDate;
		obj_YN08_05.readOnly = "";

	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã����չ����ţ���֯��#����#�Ƿ�������ָ��ר�ŵ���Ϣ�Ƽ����չ�����(��֯)
 */
function setYN09Disable(objcld) {
	var obj_YN09 = getTableFormObjs(label_YN09)[0];
	var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN09.rownumber );
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_04 = getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_05_GTZero = getTableFormObj(label_YN09_05_GTZero,obj_YN09.rownumber );
	var obj_YN09_06 = getTableFormObj(label_YN09_06,obj_YN09.rownumber );
	if (obj_YN09.value.trim() == "��") {
		// ֻ��
		obj_YN09_01.readOnly = "readonly";
		obj_YN09_02.readOnly = "readonly";
		obj_YN09_03.readOnly = "readonly";
		obj_YN09_04.readOnly = "readonly";
		obj_YN09_05_GTZero.onclick = "";
		obj_YN09_06.readOnly = "readonly";
		// ���
		obj_YN09_01.value = "";
		obj_YN09_02.value = "";
		obj_YN09_03.value = "";
		obj_YN09_04.value = "";
		obj_YN09_05_GTZero.value = "";
		obj_YN09_06.value = "";
	} else if (obj_YN09.value.trim() == "��") {
		// ��ԭ		
		obj_YN09_01.readOnly = "";
		obj_YN09_02.readOnly = "";
		obj_YN09_03.readOnly = "";
		obj_YN09_04.readOnly = "";
		obj_YN09_05_GTZero.onclick = click_columnValueNumber;
		obj_YN09_06.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã������ţ���λ�� #����#�Ƿ�����
 */
function setYN10Disable(objcld) {
	var obj_YN10 = getTableFormObjs(label_YN10)[0];
	var obj_YN10_01 = getTableFormObj(label_YN10_01,obj_YN10.rownumber );
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10.rownumber );
	var obj_YN10_04_GTZero = getTableFormObj(label_YN10_04_GTZero,obj_YN10.rownumber );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10.rownumber );
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10.rownumber );
	if (obj_YN10.value.trim() == "��") {
		// ֻ��
		obj_YN10_01.readOnly = "readonly";
		obj_YN10_02.readOnly = "readonly";
		obj_YN10_03.readOnly = "readonly";
		obj_YN10_04_GTZero.onclick = "";
		columnVallueRadio1(obj_YN10_05,false,true);
		obj_YN10_05_01.readOnly = "readonly";
		obj_YN10_05_02_GTZero.onclick = "";
		obj_YN10_05_03.readOnly = "readonly";
		// ���
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
		obj_YN10_03.value = "";
		obj_YN10_04_GTZero.value = "";
		obj_YN10_05.value = "";
		obj_YN10_05_01.value = "";
		obj_YN10_05_02_GTZero.value = "";
		obj_YN10_05_03.value = "";
		
	} else if (obj_YN10.value.trim() == "��") {
		// ��ԭ		
		obj_YN10_01.readOnly = "";
		obj_YN10_02.readOnly = "";
		obj_YN10_03.readOnly = "";
		obj_YN10_04_GTZero.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN10_05,true,true);
		obj_YN10_05_01.readOnly = "";
		obj_YN10_05_02_GTZero.onclick = click_columnValueNumber;
		obj_YN10_05_03.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã������ţ���λ�� #����#��Ϣ�Ƽ������ţ���λ���Ƿ�����
 */
function setYN10_05Disable(objcld) {
	var obj_YN10_05 = getTableFormObjs(label_YN10_05)[0];
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10_05.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10_05.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10_05.rownumber );
	if (obj_YN10_05.value.trim() == "��") {
		// ֻ��
		obj_YN10_05_01.readOnly = "readonly";
		obj_YN10_05_02_GTZero.onclick = "";
		obj_YN10_05_03.readOnly = "readonly";
		// ���
		obj_YN10_05_01.value = "";
		obj_YN10_05_02_GTZero.value = "";
		obj_YN10_05_03.value = "";
		
	} else if (obj_YN10_05.value.trim() == "��") {
		// ��ԭ		
		obj_YN10_05_01.readOnly = "";
		obj_YN10_05_02_GTZero.onclick = click_columnValueNumber;
		obj_YN10_05_03.readOnly = "";
	}
}

/*
 *���ܣ��жϱ������Ƿ����100
 *���ã� ������Ϣ�Ƽ�Ͷ�� #����#�������Ϣ�Ƽ�Ͷ��ռ�����Ͷ��ı�����
 */
function checkItem95(obj){
	var obj = getTarget(obj);
	var obj_item95 = getTableFormObjs(label_item95)[0];
	if(obj_item95.value>100){
		alert("���ʲ��ܴ���100��");
		obj_item95.value = "";
	}
}

/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
 *���ܣ��ָ����ּ�������
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

function checkData() {
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_01 = getTableFormObj(label_YN02_01,obj_YN02.rownumber );
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02.rownumber );
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02.rownumber );
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02.rownumber );
	var obj_YN02_06_GTZero = getTableFormObj(label_YN02_06_GTZero,obj_YN02.rownumber );
	var obj_YN02_07_GTZero = getTableFormObj(label_YN02_07_GTZero,obj_YN02.rownumber );
	var obj_YN02_08_GTZero = getTableFormObj(label_YN02_08_GTZero,obj_YN02.rownumber );
	var obj_YN02_09_GTZero = getTableFormObj(label_YN02_09_GTZero,obj_YN02.rownumber );
	if(obj_YN02.value == "��" ){
		if(obj_YN02_01.value.trim() == ""){
			errorObjs.push(obj_YN02_01);
			a += "��Ϣ�Ƽ�����ίԱ��-��֯���Ʋ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_02.value.trim() == ""){
			errorObjs.push(obj_YN02_02);
			a += "��Ϣ�Ƽ�����ίԱ��-�������ڲ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_03.value.trim() == ""){
			errorObjs.push(obj_YN02_03);
			a += "��Ϣ�Ƽ�����ίԱ��-��֯�����˲���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_04.value.trim() == ""){
			errorObjs.push(obj_YN02_04);
			a += "��Ϣ�Ƽ�����ίԱ��-ְ����Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_06_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_06_GTZero);
			a += "��Ϣ�Ƽ�����ίԱ������������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_07_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_07_GTZero);
			a += "��Ϣ�Ƽ�����ίԱ���о�����Ϣ�Ƽ�������������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_08_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_08_GTZero);
			a += "��Ϣ�Ƽ�����ίԱ������רҵ��ίԱ���������������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN02_09_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_09_GTZero);
			a += "�������Ϣ�Ƽ�����ίԱ��ȫ������������Ϊ��!\n";
			isValid = false;
		}
		
	}
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN03.rownumber );
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03.rownumber );
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_05 = getTableFormObj(label_YN03_05,obj_YN03.rownumber );
	if(obj_YN03.value == "��"){
		if(obj_YN03_01.value.trim() == ""){
			errorObjs.push(obj_YN03_01);
			a += "��ϯ��Ϣ��-��������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN03_02.value.trim() == ""){
			errorObjs.push(obj_YN03_02);
			a += "��ϯ��Ϣ��-ְ����Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN03_03.value.trim() == ""){
			errorObjs.push(obj_YN03_03);
			a += "��ϯ��Ϣ��-��ְ��ʼ���ڲ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN03_05.value.trim() == ""){
			errorObjs.push(obj_YN03_05);
			a += "��ϯ��Ϣ�ٻ㱨·�߲���Ϊ��!\n";
			isValid = false;
		}
	}
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02_GTZero = getTableFormObj(label_YN08_02_GTZero,obj_YN08.rownumber );
	var obj_YN08_03_GTZero = getTableFormObj(label_YN08_03_GTZero,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if(obj_YN08.value == "��"){
		if(obj_YN08_01.value.trim() == ""){
			errorObjs.push(obj_YN08_01);
			a += "��ҵ��ս�Թ滮��֧��-�滮���Ʋ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN08_02_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN08_02_GTZero);
			a += "��ҵ��ս�Թ滮��֧��-�滮��ʼ���ڲ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN08_03_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN08_03_GTZero);
			a += "��ҵ��ս�Թ滮��֧��-�滮�������ڲ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN08_04.value.trim() == ""){
			errorObjs.push(obj_YN08_04);
			a += "��ҵ��ս�Թ滮��֧��-ǩ�����ڲ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN08_05.value.trim() == ""){
			errorObjs.push(obj_YN08_05);
			a += "��ҵ��ս�Թ滮��֧��-ǩ����ְ����Ϊ��!\n";
			isValid = false;
		}
	}
	var obj_YN09 = getTableFormObjs(label_YN09)[0];
	var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN09.rownumber );
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_04 = getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_05_GTZero = getTableFormObj(label_YN09_05_GTZero,obj_YN09.rownumber );
	var obj_YN09_06 = getTableFormObj(label_YN09_06,obj_YN09.rownumber );
	if(obj_YN09.value == "��"){
		if(obj_YN09_01.value.trim() == ""){
			errorObjs.push(obj_YN09_01);
			a += "��Ϣ�Ƽ����չ�����-�������Ʋ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN09_02.value.trim() == ""){
			errorObjs.push(obj_YN09_02);
			a += "��Ϣ�Ƽ����չ�����-�����˲���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN09_03.value.trim() == ""){
			errorObjs.push(obj_YN09_03);
			a += "��Ϣ�Ƽ����չ�����-ְ����Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN09_04.value.trim() == ""){
			errorObjs.push(obj_YN09_04);
			a += "��Ϣ�Ƽ����չ�����-�������Ų���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN09_05_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN09_05_GTZero);
			a += "��Ϣ�Ƽ����չ�����-��Ա������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN09_06.value.trim() == ""){
			errorObjs.push(obj_YN09_06);
			a += "��Ϣ�Ƽ����չ�����-����·�߲���Ϊ��!\n";
			isValid = false;
		}
	}
	var obj_YN10 = getTableFormObjs(label_YN10)[0];
	var obj_YN10_01 = getTableFormObj(label_YN10_01,obj_YN10.rownumber );
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10.rownumber );
	var obj_YN10_04_GTZero = getTableFormObj(label_YN10_04_GTZero,obj_YN10.rownumber );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10.rownumber );
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10.rownumber );
	if(obj_YN10.value == "��"){
		if(obj_YN10_01.value.trim() == ""){
			errorObjs.push(obj_YN10_01);
			a += "������-�������Ʋ���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN10_02.value.trim() == ""){
			errorObjs.push(obj_YN10_02);
			a += "������-�����˲���Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN10_03.value.trim() == ""){
			errorObjs.push(obj_YN10_03);
			a += "������-ְ����Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN10_04_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN10_04_GTZero);
			a += "������-������Ա����Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN10_05.value.trim() == ""){
			errorObjs.push(obj_YN10_05.parentElement);
			a += "������-��Ϣ�Ƽ��������Ƿ���������Ϊ��!\n";
			isValid = false;
		}
		if(obj_YN10_05.value == "��"){
			if(obj_YN10_05_01.value.trim() == ""){
				errorObjs.push(obj_YN10_05_01);
				a += "������-��Ϣ�Ƽ����������Ʋ���Ϊ��!\n";
				isValid = false;
			}
			if(obj_YN10_05_02_GTZero.value.trim() == ""){
				errorObjs.push(obj_YN10_05_02_GTZero);
				a += "������-��Ϣ�Ƽ�������Ա����Ϊ��!\n";
				isValid = false;
			}
			if(obj_YN10_05_03.value.trim() == ""){
				errorObjs.push(obj_YN10_05_03);
				a += "������-����·�߲���Ϊ��!\n";
				isValid = false;
			}
		}
	}
	
	var obj_YN0101_GTZero = getTableFormObjs(label_YN0101_GTZero)[0];
	var obj_YN0103_GTZero = getTableFormObjs(label_YN0103_GTZero)[0];
	if(parseInt(obj_YN0103_GTZero.value) > parseInt(obj_YN0101_GTZero.value)){
		errorObjs.push(obj_YN0103_GTZero);
		a += "������Ϣ�Ƽ��������Ķ��������ܶ�������У�����\n";
		isValid = false;
	}
	
	var obj_YN0102_GTZero = getTableFormObjs(label_YN0102_GTZero)[0];
	var obj_YN0104_GTZero = getTableFormObjs(label_YN0104_GTZero)[0];
	if(parseInt(obj_YN0102_GTZero.value) < parseInt(obj_YN0104_GTZero.value)){
		errorObjs.push(obj_YN0104_GTZero);
	 	a+="������Ϣ�Ƽ��������Ķ������������ܶ�����������У�����\n";
	  	isValid=false;
	}
	
	var obj_YN0105_GTZero = getTableFormObjs(label_YN0105_GTZero)[0];
	var obj_YN0106_GTZero = getTableFormObjs(label_YN0106_GTZero)[0];
	if(parseInt(obj_YN0105_GTZero.value) < parseInt(obj_YN0106_GTZero.value)){
		errorObjs.push(obj_YN0106_GTZero);
	 	a+="������Ϣ�Ƽ��������ĸ߹ܲ������ܸ߹ܲ�����У�����\n";
	  	isValid=false;
	}
	
	var obj_YN02_06_GTZero = getTableFormObjs(label_YN02_06_GTZero)[0];
	var obj_YN02_07_GTZero = getTableFormObjs(label_YN02_07_GTZero)[0];
	if(parseInt(obj_YN02_06_GTZero.value) < parseInt(obj_YN02_07_GTZero.value)){
		errorObjs.push(obj_YN02_07_GTZero);
	 	a+="��Ϣ�Ƽ�����ίԱ���о�����Ϣ�Ƽ�������������Ϣ�Ƽ�����ίԱ������У�����\n";
	  	isValid=false;
	}
	
	var obj_D11_GTZero = getTableFormObjs(label_D11_GTZero)[0];
	if(parseInt(obj_D11_GTZero.value) > 36){
		errorObjs.push(obj_D11_GTZero);
	 	a+="���о��ڷ�֧������ʡ��������������36У�����\n";
	  	isValid=false;
	}
	
	var obj_D1_GTZero = getTableFormObjs(label_D1_GTZero)[0];
	var obj_D2_GTZero = getTableFormObjs(label_D2_GTZero)[0];
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D2_GTZero.value)){
		errorObjs.push(obj_D2_GTZero);
	 	a+="��Ϣ�Ƽ������ƶ�����>=���������У�����\n";
	  	isValid=false;
	}

	var obj_D3_GTZero = getTableFormObjs(label_D3_GTZero)[0];
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D3_GTZero.value)){
		errorObjs.push(obj_D3_GTZero);
	 	a+="��Ϣ�Ƽ������ƶ�����>=������޶�У�����\n";
	  	isValid=false;
	}
	
	var obj_D4_GTZero = getTableFormObjs(label_D4_GTZero)[0];
	var obj_D5_GTZero = getTableFormObjs(label_D5_GTZero)[0];
	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D5_GTZero.value)){
		errorObjs.push(obj_D5_GTZero);
	 	a+="��Ϣ�Ƽ����չ����ƶ�����>=���������У�����\n";
	  	isValid=false;
	}

	var obj_D6_GTZero = getTableFormObjs(label_D6_GTZero)[0];
	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D6_GTZero.value)){
		errorObjs.push(obj_D6_GTZero);
	 	a+="��Ϣ�Ƽ����չ����ƶ�����>=������޶�У�����\n";
	  	isValid=false;
	}
	
	var obj_D7_GTZero = getTableFormObjs(label_D7_GTZero)[0];
	var obj_D8_GTZero = getTableFormObjs(label_D8_GTZero)[0];
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D8_GTZero.value)){
		errorObjs.push(obj_D8_GTZero);
	 	a+="��Ϣ�Ƽ�����ƶ�����>=���������У�����\n";
	  	isValid=false;
	}
	
	var obj_D9_GTZero = getTableFormObjs(label_D9_GTZero)[0];
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D9_GTZero.value)){
		errorObjs.push(obj_D9_GTZero);
	 	a+="��Ϣ�Ƽ�����ƶ�����>=������޶�У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D8_GTZero.value) + parseInt(obj_D9_GTZero.value)){
		errorObjs.push(obj_D7_GTZero);
	 	a+="��Ϣ�Ƽ�����ƶ�����>=��������� + ������޶�У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D2_GTZero.value) + parseInt(obj_D3_GTZero.value)){
		errorObjs.push(obj_D1_GTZero);
	 	a+="��Ϣ�Ƽ������ƶ�����>=��������� + ������޶�У�����\n";
	  	isValid=false;
	}

	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D5_GTZero.value) + parseInt(obj_D6_GTZero.value)){
		errorObjs.push(obj_D4_GTZero);
	 	a+="��Ϣ�Ƽ����չ����ƶ�����>=��������� + ������޶�У�����\n";
	  	isValid=false;
	}
	
	var obj_item80_GTZero = getTableFormObjs(label_item80_GTZero)[0];
	var obj_item82_GTZero = getTableFormObjs(label_item82_GTZero)[0];
	if(parseInt(obj_item82_GTZero.value) > parseInt(obj_item80_GTZero.value)){
		errorObjs.push(obj_item82_GTZero);
	 	a+="��ʽԱ����>=��Ϣ�Ƽ���ʽԱ����У�����\n";
	  	isValid=false;
	}
	
	var obj_item81_GTZero = getTableFormObjs(label_item81_GTZero)[0];
	var obj_item83_GTZero = getTableFormObjs(label_item83_GTZero)[0];
	if( parseInt(obj_item81_GTZero.value) < parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item83_GTZero);
	 	a+="����ʽԱ����>=��Ϣ�Ƽ�����ʽԱ����У�����\n";
	  	isValid=false;
	}
	
	var obj_item87_GTZero = getTableFormObjs(label_item87_GTZero)[0];
	if(parseInt(obj_item87_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item87_GTZero.value)){
		errorObjs.push(obj_item87_GTZero);
	 	a+="��Ϣ�Ƽ���ʽԱ����>=��Ϣ�Ƽ��ؼ���λ����У�����\n";
	  	isValid=false;
	}
	
	var obj_item84_GTZero = getTableFormObjs(label_item84_GTZero)[0];
	if(parseInt(obj_item84_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item84_GTZero);
	 	a+="��Ϣ�Ƽ��������ְԱ����<=��Ϣ�Ƽ���Ա����У�����\n";
	  	isValid=false;
	}
	
	var obj_item85_GTZero = getTableFormObjs(label_item85_GTZero)[0];
	if( parseInt(obj_item85_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item85_GTZero);
	 	a+="��Ϣ�Ƽ��������ְԱ����<=��Ϣ�Ƽ���Ա����У�����\n";
	  	isValid=false;
	}
	
	var obj_item88_GTZero = getTableFormObjs(label_item88_GTZero)[0];
	checkNumFloat(obj_item88_GTZero,2);
	var obj_item89_GTZero = getTableFormObjs(label_item89_GTZero)[0];
	checkNumFloat(obj_item89_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item89_GTZero.value)){
		errorObjs.push(obj_item89_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=������ʩ����Ͷ��У�����\n";
	  	isValid=false;
	}
	
	var obj_item90_GTZero = getTableFormObjs(label_item90_GTZero)[0];
	checkNumFloat(obj_item90_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item90_GTZero.value)){
		errorObjs.push(obj_item90_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=�����豸�ɹ�ͶУ�����\n";
	  	isValid=false;
	}
	
	var obj_item91_GTZero = getTableFormObjs(label_item91_GTZero)[0];
	checkNumFloat(obj_item91_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item91_GTZero.value)){
		errorObjs.push(obj_item91_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=����ɹ�Ͷ��У�����\n";
	  	isValid=false;
	}
	
	var obj_item92_GTZero = getTableFormObjs(label_item92_GTZero)[0];
	checkNumFloat(obj_item92_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item92_GTZero.value)){
		errorObjs.push(obj_item92_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=ϵͳ������ĿͶ��У�����\n";
	  	isValid=false;
	}
	
	var obj_item93_GTZero = getTableFormObjs(label_item93_GTZero)[0];
	checkNumFloat(obj_item93_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item93_GTZero.value)){
		errorObjs.push(obj_item93_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=ϵͳ��ӪͶ��У�����\n";
	  	isValid=false;
	}
	
	var obj_item1000_GTZero = getTableFormObjs(label_item1000_GTZero)[0];
	checkNumFloat(obj_item1000_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item1000_GTZero.value)){
		errorObjs.push(obj_item1000_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=��Ϣ�Ƽ�������Դ����У�����\n";
	  	isValid=false;
	}
	
	var obj_item101_GTZero = getTableFormObjs(label_item101_GTZero)[0];
	checkNumFloat(obj_item101_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item101_GTZero.value)){
		errorObjs.push(obj_item101_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_item94_GTZero = getTableFormObjs(label_item94_GTZero)[0];
	checkNumFloat(obj_item94_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item94_GTZero.value)){
		errorObjs.push(obj_item94_GTZero);
	 	a+="�������Ϣ�Ƽ�Ͷ��>=�������Ϣ�Ƽ�Ͷ�����������У�����\n";
	  	isValid=false;
	}
	
	var obj_item95_GTZero = getTableFormObjs(label_item95_GTZero)[0];
	checkNumFloat(obj_item95_GTZero,2);
	
	var obj_item75_GTZero = getTableFormObjs(label_item75_GTZero)[0];
	checkNumFloat(obj_item75_GTZero,2);
	
	var obj_DecimalField1_GTZero = getTableFormObjs(label_DecimalField1_GTZero)[0];
	var obj_DecimalField2_GTZero = getTableFormObjs(label_DecimalField2_GTZero)[0]; 
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField2_GTZero.value)){
		errorObjs.push(obj_DecimalField2_GTZero);
	 	a+="��Ϣ��ȫ����>=CISSPУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField3_GTZero = getTableFormObjs(label_DecimalField3_GTZero)[0];
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField3_GTZero.value)){
		errorObjs.push(obj_DecimalField3_GTZero);
	 	a+="��Ϣ��ȫ����>=CISMУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField4_GTZero = getTableFormObjs(label_DecimalField4_GTZero)[0];
	if(parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField4_GTZero.value)){
		errorObjs.push(obj_DecimalField4_GTZero);
	 	a+="��Ϣ��ȫ����>=BS7799-LAУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField5_GTZero = getTableFormObjs(label_DecimalField5_GTZero)[0];
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField5_GTZero.value)){
		errorObjs.push(obj_DecimalField5_GTZero);
	 	a+="��Ϣ��ȫ����>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField6_GTZero = getTableFormObjs(label_DecimalField6_GTZero)[0];
	var obj_DecimalField7_GTZero = getTableFormObjs(label_DecimalField7_GTZero)[0];
	if( parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField7_GTZero.value)){
		errorObjs.push(obj_DecimalField7_GTZero);
	 	a+="��Ϣ�Ƽ��������>=ITIL Service ManagerУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField8_GTZero = getTableFormObjs(label_DecimalField8_GTZero)[0];
	if(parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField8_GTZero.value)){
		errorObjs.push(obj_DecimalField8_GTZero);
	 	a+="��Ϣ�Ƽ��������>=ITIL PractitionerУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField9_GTZero = getTableFormObjs(label_DecimalField9_GTZero)[0];
	if(parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField9_GTZero.value)){
		errorObjs.push(obj_DecimalField9_GTZero);
	 	a+="��Ϣ�Ƽ��������>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField10_GTZero = getTableFormObjs(label_DecimalField10_GTZero)[0];
	var obj_DecimalField11_GTZero = getTableFormObjs(label_DecimalField11_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField11_GTZero.value)){
		errorObjs.push(obj_DecimalField11_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=PMPУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField12_GTZero = getTableFormObjs(label_DecimalField12_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField12_GTZero.value)){
		errorObjs.push(obj_DecimalField12_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=PRINCE2У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField13_GTZero = getTableFormObjs(label_DecimalField13_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField13_GTZero.value)){
		errorObjs.push(obj_DecimalField13_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=ϵͳ�ܹ�ʦУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField14_GTZero = getTableFormObjs(label_DecimalField14_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField14_GTZero.value)){
		errorObjs.push(obj_DecimalField14_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=ϵͳ����ʦУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField15_GTZero = getTableFormObjs(label_DecimalField15_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField15_GTZero.value)){
		errorObjs.push(obj_DecimalField15_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=��Ϣϵͳ��Ŀ����ʦУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField16_GTZero = getTableFormObjs(label_DecimalField16_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField16_GTZero.value)){
		errorObjs.push(obj_DecimalField16_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ�����͹���>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField17_GTZero = getTableFormObjs(label_DecimalField17_GTZero)[0];
	var obj_DecimalField18_GTZero = getTableFormObjs(label_DecimalField18_GTZero)[0];
	if( parseInt(obj_DecimalField17_GTZero.value) < parseInt(obj_DecimalField18_GTZero.value)){
		errorObjs.push(obj_DecimalField18_GTZero);
	 	a+="�������>=CCIEУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField19_GTZero = getTableFormObjs(label_DecimalField19_GTZero)[0];
	if( parseInt(obj_DecimalField17_GTZero.value) < parseInt(obj_DecimalField19_GTZero.value)){
		errorObjs.push(obj_DecimalField19_GTZero);
	 	a+="�������>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField20_GTZero = getTableFormObjs(label_DecimalField20_GTZero)[0];
	var obj_DecimalField21_GTZero = getTableFormObjs(label_DecimalField21_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField21_GTZero.value)){
		errorObjs.push(obj_DecimalField21_GTZero);
	 	a+="���ݿ����>=OCPУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField22_GTZero = getTableFormObjs(label_DecimalField22_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField22_GTZero.value)){
		errorObjs.push(obj_DecimalField22_GTZero);
	 	a+="���ݿ����>=OCMУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField23_GTZero = getTableFormObjs(label_DecimalField23_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField23_GTZero.value)){
		errorObjs.push(obj_DecimalField23_GTZero);
	 	a+="���ݿ����>=IBM Certified DBAУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField24_GTZero = getTableFormObjs(label_DecimalField24_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField24_GTZero.value)){
		errorObjs.push(obj_DecimalField24_GTZero);
	 	a+="���ݿ����>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField25_GTZero = getTableFormObjs(label_DecimalField25_GTZero)[0];
	var obj_DecimalField26_GTZero = getTableFormObjs(label_DecimalField26_GTZero)[0];
	if( parseInt(obj_DecimalField25_GTZero.value) < parseInt(obj_DecimalField26_GTZero.value)){
		errorObjs.push(obj_DecimalField26_GTZero);
	 	a+="ҵ�������Թ���>=CBCPУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField27_GTZero = getTableFormObjs(label_DecimalField27_GTZero)[0];
	if( parseInt(obj_DecimalField25_GTZero.value) < parseInt(obj_DecimalField27_GTZero.value)){
		errorObjs.push(obj_DecimalField27_GTZero);
	 	a+="ҵ�������Թ���>=����У�����\n";
	  	isValid=false;
	}

	var obj_DecimalField28_GTZero = getTableFormObjs(label_DecimalField28_GTZero)[0];
	var obj_DecimalField29_GTZero = getTableFormObjs(label_DecimalField29_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField29_GTZero.value)){
		errorObjs.push(obj_DecimalField29_GTZero);
	 	a+="���>=CISAУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField30_GTZero = getTableFormObjs(label_DecimalField30_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField30_GTZero.value)){
		errorObjs.push(obj_DecimalField30_GTZero);
	 	a+="���>=CIAУ�����\n";
	  	isValid=false;
	}
	
	var obj_DecimalField31_GTZero = getTableFormObjs(label_DecimalField31_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField31_GTZero.value)){
		errorObjs.push(obj_DecimalField31_GTZero);
	 	a+="���>=����У�����\n";
	  	isValid=false;
	}
	
	var obj_YN08_02_GTZero = getTableFormObjs(label_YN08_02_GTZero)[0];
	var obj_YN08_03_GTZero = getTableFormObjs(label_YN08_03_GTZero)[0];
	if( parseInt(obj_YN08_02_GTZero.value) > parseInt(obj_YN08_03_GTZero.value)){
		errorObjs.push(obj_YN08_03_GTZero);
	 	a+="�滮����ʼ����<=�滮�ڽ�������У�����\n";
	  	isValid=false;
	}
	
	if( parseFloat(obj_item88_GTZero.value) >( parseFloat(obj_item89_GTZero.value) + parseFloat(obj_item90_GTZero.value) + parseFloat(obj_item91_GTZero.value)
			+ parseFloat(obj_item92_GTZero.value) + parseFloat(obj_item93_GTZero.value) + parseFloat(obj_item1000_GTZero.value) 
				+ parseFloat(obj_item101_GTZero.value) )|| parseFloat(obj_item88_GTZero.value) < ( parseFloat(obj_item89_GTZero.value) 
					+ parseFloat(obj_item90_GTZero.value) + parseFloat(obj_item91_GTZero.value) + parseFloat(obj_item92_GTZero.value) 
						+ parseFloat(obj_item93_GTZero.value) + parseFloat(obj_item1000_GTZero.value) + parseFloat(obj_item101_GTZero.value))){
		errorObjs.push(obj_item88_GTZero);
	 	a+="����ȿƼ���ϢͶ��=������ʩ����Ͷ��+�����豸�ɹ�Ͷ��+����ɹ�Ͷ��+ϵͳ������ĿͶ��+ϵͳ��ӪͶ��+��Ϣ�Ƽ�������Դ����+����У�����\n";
	  	isValid=false;
	}

	if(parseInt(obj_DecimalField1_GTZero.value) >( parseInt(obj_DecimalField2_GTZero.value) + parseInt(obj_DecimalField3_GTZero.value)
			+ parseInt(obj_DecimalField4_GTZero.value) + parseInt(obj_DecimalField5_GTZero.value) ) || parseInt(obj_DecimalField1_GTZero.value) 
				<(parseInt(obj_DecimalField2_GTZero.value) + parseInt(obj_DecimalField3_GTZero.value)
					+ parseInt(obj_DecimalField4_GTZero.value) + parseInt(obj_DecimalField5_GTZero.value))){
		errorObjs.push(obj_DecimalField1_GTZero);
	 	a+="��Ϣ��ȫ����= ���У�CISSP + CISM + BS7799-LA + ����У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField6_GTZero.value) >( parseInt(obj_DecimalField7_GTZero.value) + parseInt(obj_DecimalField8_GTZero.value)
			+ parseInt(obj_DecimalField9_GTZero.value) )|| parseInt(obj_DecimalField6_GTZero.value) <( parseInt(obj_DecimalField7_GTZero.value)
					+ parseInt(obj_DecimalField8_GTZero.value) + parseInt(obj_DecimalField9_GTZero.value))){
		errorObjs.push(obj_DecimalField6_GTZero);
	 	a+="��Ϣ�Ƽ��������=���У�ITIL Service Manager + ITIL Practitioner + ���� У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField10_GTZero.value) >( parseInt(obj_DecimalField11_GTZero.value) + parseInt(obj_DecimalField12_GTZero.value)
		 + parseInt(obj_DecimalField13_GTZero.value) + parseInt(obj_DecimalField14_GTZero.value) + parseInt(obj_DecimalField15_GTZero.value)
			 + parseInt(obj_DecimalField16_GTZero.value) )|| parseInt(obj_DecimalField10_GTZero.value) <( parseInt(obj_DecimalField11_GTZero.value) 
				+ parseInt(obj_DecimalField12_GTZero.value) + parseInt(obj_DecimalField13_GTZero.value) + parseInt(obj_DecimalField14_GTZero.value)
					+ parseInt(obj_DecimalField15_GTZero.value) + parseInt(obj_DecimalField16_GTZero.value) )){
		errorObjs.push(obj_DecimalField10_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ���������= ���У�PMP + PRINCE2 + ϵͳ�ܹ�ʦ + ϵͳ����ʦ  + ��Ϣϵͳ��Ŀ����ʦ + ���� У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField17_GTZero.value) >( parseInt(obj_DecimalField18_GTZero.value) + parseInt(obj_DecimalField19_GTZero.value) )||
			parseInt(obj_DecimalField17_GTZero.value) <( parseInt(obj_DecimalField18_GTZero.value) + parseInt(obj_DecimalField19_GTZero.value))){
		errorObjs.push(obj_DecimalField17_GTZero);
	 	a+="��Ϣ�Ƽ���Ŀ���������=  ���У�CCIE + ���� У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField20_GTZero.value) >( parseInt(obj_DecimalField21_GTZero.value) + parseInt(obj_DecimalField22_GTZero.value)
			+ parseInt(obj_DecimalField23_GTZero.value) + parseInt(obj_DecimalField24_GTZero.value) ) || parseInt(obj_DecimalField20_GTZero.value)
				<( parseInt(obj_DecimalField21_GTZero.value) + parseInt(obj_DecimalField22_GTZero.value) + parseInt(obj_DecimalField23_GTZero.value)
					+ parseInt(obj_DecimalField24_GTZero.value))){
		errorObjs.push(obj_DecimalField20_GTZero);
	 	a+="���ݿ����= ���У�OCP + OCM + IBM Certified DBA + ���� У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField25_GTZero.value) >( parseInt(obj_DecimalField26_GTZero.value) + parseInt(obj_DecimalField27_GTZero.value) )||
			parseInt(obj_DecimalField25_GTZero.value) <( parseInt(obj_DecimalField26_GTZero.value) +parseInt( obj_DecimalField27_GTZero.value) )){
		errorObjs.push(obj_DecimalField25_GTZero);
		a+="ҵ�������Թ���= ���У�CBCP + ���� У�����\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_GTZero.value) >( parseInt(obj_DecimalField29_GTZero.value) + parseInt(obj_DecimalField30_GTZero.value) 
			+ parseInt(obj_DecimalField31_GTZero.value) )|| parseInt(obj_DecimalField28_GTZero.value) <( parseInt(obj_DecimalField29_GTZero.value)
				+ parseInt(obj_DecimalField30_GTZero.value) + parseInt(obj_DecimalField31_GTZero.value) )){
		errorObjs.push(obj_DecimalField28_GTZero);
	 	a+="���= ���У�CISA + CIA + ���� У�����\n";
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
