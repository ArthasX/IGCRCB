/**T-B-14 ��������ϵͳ��ȫ�����*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item5 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�������";
var label_isempty = "���Ϳձ���#���Ϳձ�";

var label_YN54="��ȫ����#����#��������ϵͳ��״ϵͳ�������";

var label_YN01 = "��ȫ����#����#���׷��յȼ��Ƿ񻮷�";
var label_YN01_01 = "��ȫ����#����#�߷��ս��װ�����";
var label_YN01_02 = "��ȫ����#����#�ͷ��ս��װ���";

var label_YN02 = "��ȫ����#����#������Ƿ�ʵʩ��������ϵͳ��ȫ����";
var label_YN02_01 = "��ȫ����#����#������ʽ";
var label_YN02_01_01 = "��ȫ����#����#��������";

var label_YN03 = "��ȫ����#����#��ȫ�¼�����#�Ƿ����������а�ȫ�¼��ļ�⡢��Ӧ���㱨����";
var label_YN03_01 = "��ȫ����#����#��ȫ�¼�����#�������а�ȫ�¼�����·��";

var label_YN04 = "��ȫ����#����#��ȫ���#�Ƿ��ѽ�������������ϵͳ��ȫ��ƻ���";
var label_YN04_01 = "��ȫ����#����#��ȫ���#��ȫ��Ƹ��Ƿ�Χ";

var label_YN05 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ�����ʩ";
var label_YN05_01 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�����ʩ";

var label_YN06 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ��������Ӫ��ǩ��DDoS��������Э��";
var label_YN06_01 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#������Ҫ���ݼ���";

var label_YN07 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸";
var label_YN07_01 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�豸Ʒ�Ƽ��ͺ�";

var label_YN08 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ������ּ�⼰���ַ�����ʩ";
var label_YN08_01 = "ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�������";

var label_YN09 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤";
var label_YN09_01 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��ʩ����";

var label_YN10 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤";
var label_YN10_01 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�����������ӿ��г�ʱ�ر�ʱ��Ϊ";
var label_YN10_02 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��ҵ�������ӿ��г�ʱ�ر�ʱ��Ϊ";

var label_YN11 = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������";
var label_YN11_01_GTZero = "ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��¼ʧ�ܴ�������Ϊ";

var label_YN12 = "���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ";
var label_YN12_01 = "���ݰ�ȫ#����#���ݼ���#�������Э������";
var label_YN12_02 = "���ݰ�ȫ#����#���ݼ���#�����㷨����";
var label_YN12_03 = "���ݰ�ȫ#����#���ݼ���#��Կ����";

var label_YN13 = "���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢";
var label_YN13_01 = "���ݰ�ȫ#����#���ݼ���#���ܵ������ֶΰ���";

var label_YN14 = "���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ";
var label_YN14_01 = "���ݰ�ȫ#����#�߷��ս������������Ա�����������#��ʩ���� ";

var label_YN15 = "���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ";
var label_YN15_01 = "���ݰ�ȫ#����#�߷��ս������������Ա�����������#��ʩ����";

var label_YN16 = "���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ";
var label_YN16_01 = "���ݰ�ȫ#����#������Ϣ��й¶#��ʩ����";

var label_YN17 = "Ӧ��ϵͳ��ȫ#����#��������ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���";
var label_YN17_01 = "Ӧ��ϵͳ��ȫ#����#��ⲿ�ţ���֯���Ŷӣ�����";

var label_YN18 = "Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���";
var label_YN18_01 = "Ӧ��ϵͳ��ȫ#����#��⹤������";

var label_YN19 = "Ӧ��ϵͳ��ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ";
var label_YN19_01 = "Ӧ��ϵͳ��ȫ#����#��⹤������";

var label_YN20 = "Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ��������ϵͳ��͸�Բ���";
var label_YN20_01 = "Ӧ��ϵͳ��ȫ#����#���Ի�������֯������";
var label_YN20_02 = "Ӧ��ϵͳ��ȫ#����#����ڿ�չ������ȫ���Բ��Դ���";


var label_YN100 = "Ӧ��ϵͳ��ȫ#����#�Ƿ���з��������Ĺ���";
var label_YN100_01 = "Ӧ��ϵͳ��ȫ#����#���ֵ�����վ��";
var label_YN100_02 = "Ӧ��ϵͳ��ȫ#����#�رյ�����վ��";

var label_YN52 = "Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���";
var label_YN52_01 = "Ӧ��ϵͳ��ȫ#����#��������������";

var label_YN53 = "Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ��ȡ����������ʩ";
var label_YN53_01 = "Ӧ��ϵͳ��ȫ#����#��ʩ����";

var label_YN21 = "�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���";
var label_YN21_01 = "�����֤#����#��̬����#�����޶�Ϊ";

var label_YN22 = "�����֤#����#��̬����#�Ƿ�߱������뱩���½����";
var label_YN22_01 = "�����֤#����#��̬����#��ʩ����";

var label_YN23 = "�����֤#����#��̬����#�Ƿ�֧��ʹ����չ��ȫ�豸��������";
var label_YN23_01 = "�����֤#����#��̬����#��չ��ȫ�豸����";

var label_YN58 = "�����֤#����#�ļ�֤��#�Ƿ�֧��";
var label_YN58_01 = "�����֤#����#�ļ�֤��#�Ƿ�ǿ��ʹ�����뱣��˽Կ";
var label_YN58_02 = "�����֤#����#�ļ�֤��#�ͻ�֤�鹫˽Կ���Ƿ��ڿͻ�������";
var label_YN58_03 = "�����֤#����#�ļ�֤��#˽Կ����ʱ���ͻ����Ƿ�Կͻ����ʵʩ��֤";
var label_YN58_04 = "�����֤#����#�ļ�֤��#�Ƿ�֧��֤��˽Կ���ɵ���ѡ��";
var label_YN58_05 = "�����֤#����#�ļ�֤��#֤��˽Կ����ʱ���Ƿ���ʾ��ǿ�Ʒ����ƶ��豸��";
var label_YN58_06 = "�����֤#����#�ļ�֤��#�Ƿ�Ա��ݵ�֤��˽Կ���м���";
var label_YN58_07 = "�����֤#����#�ļ�֤��#���ݻ�ָ�֤��˽Կ�ɹ����Ƿ�ͨ���ֻ����ŵȵڶ�ͨ��������ͻ�������ʾ��Ϣ";
var label_YN58_08 = "�����֤#����#�ļ�֤��#�ͻ�֤��ǩ������";
var label_YN58_08_01 = "�����֤#����#�ļ�֤��#��������";

var label_YN59 = "�����֤#����#USB Key#�Ƿ�֧��";
var label_YN59_01 = "�����֤#����#USB Key#USB Key�Ƿ���ͨ���������������Ի����İ�ȫ���";
var label_YN59_01_01 ="�����֤#����#USB Key#���Ի�������";
var label_YN59_02 = "�����֤#����#USB Key#USB Key��ִ��ǩ�������в���ʱ���Ƿ�߱�������ʾ���ܣ���Ҫ��Կͻ����ʵʩ����";
var label_YN59_03 = "�����֤#����#USB Key#��ʾ��ʽ����";
var label_YN59_04 = "�����֤#����#USB Key#USB Key�Ƿ�߱�PIN������������������";
var label_YN59_05 = "�����֤#����#USB Key#�ͻ��ǳ���������ʱ�Ƿ���ʾ�ͻ��Ͽ�USB Key";
var label_YN59_06 = "�����֤#����#USB Key#�ͻ�֤��ǩ������Ϊ";
var label_YN59_06_01 = "�����֤#����#USB Key#��������";
var label_YN59_07 = "�����֤#����#USB Key#�ͻ�֤��˽Կ�� USB Key�ڲ����ɣ��������κ���ʽ�� USB Key��ȡ��д��˽Կ";

var label_YN60 = "�����֤#����#OTP����#�Ƿ�֧��";
var label_YN60_01 = "�����֤#����#OTP����#OTP�����Ƿ�����PIN�뱣������";
var label_YN60_02 = "�����֤#����#OTP����#OTP�����Ƿ�߱�PIN������������������";
var label_YN60_03 = "�����֤#����#OTP����#��̬����ĳ����Ƿ�����6λ";
var label_YN60_04 = "�����֤#����#OTP����#PIN�ĳ����Ƿ�����4λ";

var label_YN24 = "�����֤#����#���Ŷ�̬����#�Ƿ�֧��";
var label_YN24_01 = "�����֤#����#���Ŷ�̬����#��ͨ�ֻ���̬����ʱ�� ʹ�ù�����˹����뷽ʽ��֤�ͻ���ݲ��Ǽ��ֻ�����";
var label_YN24_02 = "�����֤#����#���Ŷ�̬����#�����ֻ�����ʱ���Ƿ�Կͻ������ʵʩ��֤";
var label_YN24_02_01 = "�����֤#����#���Ŷ�̬����#��֤��ʽ";
var label_YN24_03 = "�����֤#����#���Ŷ�̬����#��̬����ĳ����Ƿ�����6λ";
var label_YN24_04 = "�����֤#����#���Ŷ�̬����#�ֻ���̬����������Ƿ���ת���˻������׽���Ҫ�������";
var label_YN24_05 = "�����֤#����#���Ŷ�̬����#�������Ƿ���ʾ�ؼ�����Ҫ����Ϣ����ת���˻������׽���";
var label_YN24_05_01  = "�����֤#����#���Ŷ�̬����#�ֻ���̬�������Чʱ��Ϊ";

var label_YN25 = "�����֤#����#��̬���#�Ƿ�֧��";
var label_YN25_01 = "�����֤#����#��̬���#��̬����Ƿ�߱�PIN������������������";
var label_YN25_02 = "�����֤#����#��̬���#��̬����Ƿ�����PIN�뱣������";
var label_YN25_03 = "�����֤#����#��̬���#��̬����ĳ����Ƿ�����6λ";
var label_YN25_04 = "�����֤#����#��̬���#PIN�ĳ����Ƿ�����4λ";
var label_YN25_05 = "�����֤#����#��̬���#�Ƿ�֧�ֻ���������ƵĶ�̬���";
var label_YN25_06 = "�����֤#����#��̬���#����������ƵĶ�̬����Ƿ����������ս��������";
var label_YN25_06_01 = "�����֤#����#��̬���#����������ƵĶ�̬��������ʹ�ô���";
var label_YN25_06_02 = "�����֤#����#��̬���#��̬���ʹ����Ч��";
var label_YN25_07 = "�����֤#����#��̬���#�Ƿ�ʹ��Ϳ�㸲�ǵȷ�����������";

var label_YN25_08="��ȫ����#����#��ȫ������������ϵͳ��ȫ�ڲ�������Ҫʵʩ���ţ���֯��";

/*
* ���ܣ����̴���ҳ��ʼ��ʱ���ñ�Ȩ��
* ���ã��״̬�Ͷ�������״̬
*/
function initSet(){
	
	obj_YN01_01(getTableFormObj(label_YN01 ,"1_1"));
	obj_YN25_06(getTableFormObjs(label_YN25_06)[0]);
	obj_YN02_01(getTableFormObj(label_YN02 ,"1_1"));
	obj_YN03_01(getTableFormObj(label_YN03 ,"1_1_1"));
	obj_YN04_01(getTableFormObj(label_YN04 ,"1_1_1"));
	obj_YN05_01(getTableFormObj( label_YN05,"1_1_1"));
	obj_YN06_01(getTableFormObj( label_YN06,"1_1_1"));
	obj_YN07_01(getTableFormObj( label_YN07,"1_1_1"));
	obj_YN08_01(getTableFormObj( label_YN08,"1_1_1"));
	obj_YN09_01(getTableFormObj( label_YN09,"1_1_1"));
	obj_YN10_01(getTableFormObj( label_YN10,"1_1_1"));
	obj_YN11_01(getTableFormObj( label_YN11,"1_1_1"));
	obj_YN14_01(getTableFormObj( label_YN14,"1_1_1"));
	obj_YN15_01(getTableFormObj( label_YN15,"1_1_1"));
	obj_YN16_01(getTableFormObj( label_YN16 ,"1_1_1"));
	obj_YN17_01(getTableFormObj( label_YN17,"1_1"));
	obj_YN18_01(getTableFormObj( label_YN18,"1_1"));
	obj_YN20_01(getTableFormObj( label_YN20,"1_1"));
	obj_YN100_01(getTableFormObj(label_YN100 ,"1_1"));
	obj_YN52_01(getTableFormObj( label_YN52,"1_1"));
	obj_YN53_01(getTableFormObj(label_YN53 ,"1_1"));
	obj_YN21_01(getTableFormObj(label_YN21 ,"1_1_1"));
	obj_YN22_01(getTableFormObj(label_YN22 ,"1_1_1"));
	obj_YN12_01(getTableFormObj(label_YN12 ,"1_1_1"));
	obj_YN13_01(getTableFormObj(label_YN13 ,"1_1_1"));
	obj_YN231(getTableFormObj( label_YN23,"1_1_1"));
	obj_YN58(getTableFormObj( label_YN58,"1_1_1"));
	obj_YN58_08(getTableFormObj(label_YN58_08,"1_1_1" ));
	obj_YN62(getTableFormObj( label_YN25,"1_1_1"));
	obj_YN59(getTableFormObj(label_YN59 ,"1_1_1"));
	obj_YN59_01(getTableFormObj(label_YN59_01 ,"1_1_1"));
	obj_YN59_06(getTableFormObj(label_YN59_06 ,"1_1_1"));
	obj_YN60(getTableFormObj( label_YN60,"1_1_1"));
	obj_YN61(getTableFormObj( label_YN24,"1_1_1"));
	obj_YN24_02_01(getTableFormObj( label_YN24_02,"1_1_1"));
	obj_YN24_05_01(getTableFormObj(label_YN24_05 ,"1_1_1"));
	obj_validatenulll(getTableFormObjs(label_YN54)[0]);
}

/*
 * ��֤���ǿձ��ʱ,��ͷ��Ϣ����Ϊ��
 */
function checkHeader() {
	// ���ͷǿձ���ͷ����
	if (getFormObj(label_header_item1).value.trim() == ""
			|| getFormObj(label_header_item2).value.trim() == ""
			|| getFormObj(label_header_TextField11).value.trim() == ""
			|| getFormObj(label_header_item3).value.trim() == ""
			|| getFormObj(label_header_item4).value.trim() == "") {
		a += "����š���ˡ���ϵ�绰�������ˡ�����ڲ���Ϊ�գ�\n";
		isValid = false;
	}
}

var obj_YN1=function(){
	columnVallueRadio(this);
	obj_YN01_01(this);
};
var obj_YN2=function(){
	columnVallueRadio(this);
	obj_YN25_06(this);
};
var obj_YN3=function(){
	columnVallueRadio(this);
	obj_YN02_01(this);
};
var obj_YN4=function(){
	columnVallueRadio(this);
	obj_YN03_01(this);
};
var obj_YN5=function(){
	columnVallueRadio(this);
	obj_YN04_01(this);
};
var obj_YN6=function(){
	columnVallueRadio(this);
	obj_YN05_01(this);
};
var obj_YN7=function(){
	columnVallueRadio(this);
	obj_YN06_01(this);
};
var obj_YN8=function(){
	columnVallueRadio(this);
	obj_YN07_01(this);
};
var obj_YN9=function(){
	columnVallueRadio(this);
	obj_YN08_01(this);
};
var obj_YN10=function(){
	columnVallueRadio(this);
	obj_YN09_01(this);
};
var obj_YN11=function(){
	columnVallueRadio(this);
	obj_YN10_01(this);
};
var obj_YN12=function(){
	columnVallueRadio(this);
	obj_YN11_01(this);
};
var obj_YN13=function(){
	columnVallueRadio(this);
	obj_YN14_01(this);
};
var obj_YN14=function(){
	columnVallueRadio(this);
	obj_YN15_01(this);
};
var obj_YN15=function(){
	columnVallueRadio(this);
	obj_YN16_01(this);
};
var obj_YN16=function(){
	columnVallueRadio(this);
	obj_YN17_01(this);
};
var obj_YN17=function(){
	columnVallueRadio(this);
	obj_YN18_01(this);
};
var obj_YN18=function(){
	columnVallueRadio(this);
	obj_YN20_01(this);
};
var obj_YN19=function(){
	columnVallueRadio(this);
	obj_YN100_01(this);
};
var obj_YN20=function(){
	columnVallueRadio(this);
obj_YN52_01(this);
};
var obj_YN21=function(){
	columnVallueRadio(this);
obj_YN53_01(this);
};
var obj_YN22=function(){
	columnVallueRadio(this);
obj_YN21_01(this);
};
var obj_YN23=function(){
	columnVallueRadio(this);
obj_YN22_01(this);
};
var obj_YN24=function(){
	columnVallueRadio(this);
obj_YN12_01(this);
};
var obj_YN25=function(){
	columnVallueRadio(this);
obj_YN13_01(this);
};
var obj_YN26=function(){
	columnVallueRadio(this);
	obj_YN231(this);
};
var obj_YN27=function(){
	columnVallueRadio(this);
obj_YN58(this);
};
var obj_YN28=function(){
	columnVallueRadio(this);
	obj_YN62(this);
};
var obj_YN29=function(){
	columnVallueRadio(this);
	obj_YN59(this);
};
var obj_YN30=function(){
	columnVallueRadio(this);
	obj_YN59_01(this);
};
var obj_YN31=function(){
	columnVallueRadio(this);
obj_YN59_06(this);
};
var obj_YN32=function(){
	columnVallueRadio(this);
obj_YN60(this);
};
var obj_YN33=function(){
	columnVallueRadio(this);
	obj_YN61(this);
};
var obj_YN34=function(){
	columnVallueRadio(this);
obj_YN24_02_01(this);
};
var obj_YN35=function(){
	columnVallueRadio(this);
obj_YN24_05_01(this);
};
var obj_YN5801=function(){
	columnVallueRadio(this);
	obj_YN58_08(this);
};
var obj_YN24_051=function(){
	columnVallueRadio(this);
	obj_YN24_05_01(this);
};

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#��������ϵͳ��״ϵͳ�������
*/
function obj_validatenulll(obj) {
	var obj_validatenull=getTableFormObjs(label_YN54)[0];
	var obj_item1 = getTableFormObjs(label_header_item1)[0].value;
	var obj_item2 = getTableFormObjs(label_header_item2)[0].value;
	var obj_item3 = getTableFormObjs(label_header_item3)[0].value;
	var obj_item4 = getTableFormObjs(label_header_item4)[0].value;
	var obj_item5 = getTableFormObjs(label_header_item5)[0].value;
	var obj_isempty = getTableFormCheckBox(label_isempty,"1" )[0].checked;
	if (obj_validatenull.value == "����ϵͳ") {
		// ֻ��
		onlyRead(true);
	} else/* if(obj_validatenull.value!="")*/ {
		onlyRead(false);
		//getTableFormObj(label_header_item4,"1").onclick=function(){showDate(this);};
		 getTableFormObj(label_YN10_01,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN10_01,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN10_02,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN10_02,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN25_06_02,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN25_06_02,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN25_06_01,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN25_06_01,"1_1_1").readOnly = "readOnly";
		 getTableFormObj(label_YN11_01_GTZero,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN11_01_GTZero,"1_1_1").readOnly = "readOnly";
		 getTableFormObj(label_YN20_02,"1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN20_02,"1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN100_01,"1_1"  ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN100_01,"1_1"  ).readOnly = "readOnly";
		 getTableFormObj(label_YN100_02,"1_1"  ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN100_02,"1_1"  ).readOnly = "readOnly";
		 getTableFormObj(label_YN21_01,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN21_01,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN12_03,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN12_03,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN24_05_01,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN24_05_01,"1_1_1").readOnly = "readOnly";

		 columnVallueRadio3(getTableFormObj(label_YN01,"1_1" ),obj_YN1);
		 columnVallueRadio3(getTableFormObj(label_YN25_06,"1_1_1" ),obj_YN2);
		 columnVallueRadio3(getTableFormObj(label_YN02,"1_1" ),obj_YN3);
		 columnVallueRadio3(getTableFormObj(label_YN03,"1_1_1" ),obj_YN4);
		 columnVallueRadio3(getTableFormObj(label_YN04,"1_1_1" ),obj_YN5);
		 columnVallueRadio3(getTableFormObj(label_YN05,"1_1_1" ),obj_YN6);
		 columnVallueRadio3(getTableFormObj(label_YN06,"1_1_1" ),obj_YN7);
		 columnVallueRadio3(getTableFormObj(label_YN07,"1_1_1" ),obj_YN8);
		 columnVallueRadio3(getTableFormObj(label_YN08,"1_1_1" ),obj_YN9);
		 columnVallueRadio3(getTableFormObj(label_YN09,"1_1_1" ),obj_YN10);
		 columnVallueRadio3(getTableFormObj(label_YN10,"1_1_1" ),obj_YN11);
		 columnVallueRadio3(getTableFormObj(label_YN11,"1_1_1" ),obj_YN12);
		 columnVallueRadio3(getTableFormObj(label_YN14,"1_1_1"),obj_YN13);
		 columnVallueRadio3(getTableFormObj(label_YN20,"1_1" ),obj_YN18);
		 columnVallueRadio3(getTableFormObj(label_YN100,"1_1" ),obj_YN19);
//		 columnVallueRadio3(getTableFormObj(label_YN14,"1_1_1" ),obj_YN15);
		 columnVallueRadio3(getTableFormObj(label_YN15,"1_1_1" ),obj_YN14);
		 columnVallueRadio3(getTableFormObj(label_YN16,"1_1_1" ),obj_YN15);
		 columnVallueRadio3(getTableFormObj(label_YN17,"1_1" ),obj_YN16);
		 columnVallueRadio3(getTableFormObj(label_YN18,"1_1" ),obj_YN17);
		 columnVallueRadio3( getTableFormObj( label_YN52,"1_1"),obj_YN20);
		 columnVallueRadio3(getTableFormObj(label_YN53 ,"1_1"),obj_YN21);
		 columnVallueRadio3(getTableFormObj(label_YN21 ,"1_1_1"),obj_YN22);
		 columnVallueRadio3(getTableFormObj(label_YN22 ,"1_1_1"),obj_YN23);
		 columnVallueRadio3(getTableFormObjs(label_YN12)[0],obj_YN24);
		 columnVallueRadio3(getTableFormObjs(label_YN13)[0],obj_YN25);
		 columnVallueRadio3(getTableFormObjs(label_YN13)[0],obj_YN25);
		 columnVallueRadio3( getTableFormObj(label_YN23 ,"1_1_1"),obj_YN26);
		 columnVallueRadio3(getTableFormObj( label_YN58,"1_1_1"),obj_YN27);
		 columnVallueRadio3( getTableFormObj( label_YN25,"1_1_1"),obj_YN28);
		 columnVallueRadio3(getTableFormObj(label_YN59 ,"1_1_1"),obj_YN29);
		 columnVallueRadio3( getTableFormObj(label_YN59_01 ,"1_1_1"),obj_YN30);
		 columnVallueRadio3(  getTableFormObj(label_YN59_06,"1_1_1" ),obj_YN31);
		 columnVallueRadio3(  getTableFormObj( label_YN60,"1_1_1"),obj_YN32);
		 columnVallueRadio3(  getTableFormObj( label_YN24,"1_1_1"),obj_YN33);
		 columnVallueRadio3(  getTableFormObj( label_YN24_02,"1_1_1"),obj_YN34);
		 columnVallueRadio3(  getTableFormObj(label_YN24_05 ,"1_1_1"),obj_YN35);
		 columnVallueRadio3(  getTableFormObj(label_YN58_08,"1_1_1" ),obj_YN5801);
		 columnVallueRadio3(getTableFormObj(label_YN24_05 ,"1_1_1"),obj_YN24_051);

	}
	getTableFormObj(label_header_item1,"1").readOnly="";
	getTableFormObj(label_header_item1,"1").value=obj_item1;
	getTableFormObj(label_header_item2,"1").readOnly="";
	getTableFormObj(label_header_item2,"1").value=obj_item2;
	getTableFormObj(label_header_item3,"1").readOnly="";
	getTableFormObj(label_header_item3,"1").value=obj_item3;
	getTableFormObj(label_header_item4,"1").readOnly="";
	getTableFormObj(label_header_item4,"1").value=obj_item4;
	getTableFormObj(label_header_item5,"1").readOnly="";
	getTableFormObj(label_header_item5,"1").value=obj_item5;
	getTableFormObj(label_header_item4,"1").onclick=function(){showDate(this);};
	getTableFormCheckBox(label_isempty,"1" )[0].checked=obj_isempty;
	if(obj_isempty)getTableFormObjs(label_isempty)[0].value = "���Ϳձ�";
	getTableFormCheckBox(label_isempty,"1" )[0].disabled=false;
	columnVallueRadio2(getTableFormObjs(label_YN54)[0],"obj_validatenulll(this);");
}
/*
* ���ܣ����checkboxֵ
*/
function getbox(obj) {
	var checkvalues=obj.parentElement.parentElement.childNodes;
	for(var i=0;i<checkvalues.length;i++){
		if(checkvalues[i]=="column_value"){
			checkvalues[i].value="";
		}
	}
}
/*
 *���ܣ���ѡ��ť�Ķ�д����
 */
function columnVallueRadio3(obj,check){
	//alert(obj.outerHTML);
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
						imgs[k].onclick = check;
				}
			}
		}
	}
}

/*
* ���ܣ������������Ƿ��ѡ
* 	     ������б�������ı����ֵ������ͷ��
* 	     ������ж�ѡ��ֵ�����˱��Ϳձ�
* 	     ��������ı����ֵ
*/
function onlyRead(access){  
	var divs = document.getElementsByTagName("div");
	var inputs=document.getElementsByTagName("input");
	var imgs=document.getElementsByTagName("img");
		for(var k=0;k<imgs.length;k++){
			if(imgs[k].name == "radioImg"){
				if(access){
					if(imgs[k].flag=="����ϵͳ"){
						imgs[k].src = "images/rb02.gif";
					}else{
						imgs[k].src = "images/rb01.gif";
					}
					imgs[k].onclick = "";
				}else{
					if(imgs[k].flag==""){
						imgs[k].onclick = function(){
							columnVallueRadioElse(this);
						};	
					}else{
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
		for(var i=0;i<inputs.length;i++){
			var obj=inputs[i];
			if(obj.type=='text'){   
				obj.setAttribute("readOnly",access);
				if(access){
					obj.value=""; 
					obj.onclick="";
				}
			}
			if(obj.type == "hidden" && obj.name == "column_value" && access ){
				if(obj.vlaue != "���Ϳձ�" && obj.value != "����ϵͳ"){
					obj.value = "";
				}
			}
			if(obj.type=='checkbox'){ 
				if(access && obj.value != "���Ϳձ�"){
					//obj.value="";
					obj.checked=false;
				}
				obj.disabled=access;
				
			}
		}
		for(var i = 0; i < divs.length; i++){
			obj = divs[i];
			if(obj.className == "editDiv"){ 
				obj.contentEditable = !access;
				if(access)
				obj.innerHTML = "";
			}
		}
}
/*
 *���ܣ���ѡ��ť��ԭ
 */
function columnVallueRadio2(obj,onclickname){
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs=objs[i].childNodes;
				for(var k=0;k<imgs.length;k++){
					if(imgs[k].name == "radioImg"){
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								obj_validatenulll(this);
							};	
						}else{
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								obj_validatenulll(this);
							};
						}
					}
				}
		}
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��ȫ����#����#���׷��յȼ��Ƿ񻮷�;
*/
function obj_YN01_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN01 = getTableFormObj(label_YN01,"1_1");
	var obj_YN01_01 = getTableFormCheckBox(label_YN01_01,"1_1");
	var obj_YN01_02 = getTableFormCheckBox(label_YN01_02,"1_1");
	if (obj_YN01.value == "��") {
		// ֻ��
		obj_YN01_01.onclick = "";
		obj_YN01_02.onclick = "";
		// ���
		disableTableCheckBox(obj_YN01_01,true);
		disableTableCheckBox(obj_YN01_02,true);
		//getEditDiv(obj_item24).innerHTML = "";
		//delSingleTableColumnFileInput(obj_item25);
	} else if (obj_YN01.value == "��") {
		// ��ԭ
		obj_YN01_01.onclick = "";
		obj_YN01_02.onclick = "";
		disableTableCheckBox(obj_YN01_01,false);
		disableTableCheckBox(obj_YN01_02,false);

	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#������Ƿ�ʵʩ��������ϵͳ��ȫ����;
*/
function obj_YN02_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN02=getTableFormObj(label_YN02 ,"1_1");
	var obj_YN02_01 = getTableFormObj(label_YN02_01,"1_1");
	var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,"1_1");
	if (obj_YN02.value == "��") {
		// ֻ��
		obj_YN02_01.onclick = "";
		obj_YN02_01_01.onclick = "";
		// ���
		columnVallueRadio1(obj_YN02_01,false);
		obj_YN02_01_01.value="";
		obj_YN02_01_01.readOnly="readonly";
	} else if (obj_YN02.value == "��") {
		// ��ԭ
		obj_YN01_01.onclick = "";
		columnVallueRadio1(obj_YN02_01,true);
		obj_YN02_01_01.readOnly="";

	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#������Ƿ�ʵʩ��������ϵͳ��ȫ����;
*/
function obj_YN03_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN03=getTableFormObj(label_YN03 ,"1_1_1");
	var obj_YN03_01 = getTableFormObj(label_YN03_01,"1_1_1");
	if (obj_YN03.value == "��") {
		// ֻ��
		obj_YN03_01.onclick = "";
		// ���
		obj_YN03_01.value="";
		obj_YN03_01.readOnly="readonly";
	} else if (obj_YN03.value == "��") {
		// ��ԭ
		obj_YN03_01.onclick = "";
		obj_YN03_01.readOnly="";
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#��ȫ���#�Ƿ��ѽ�������������ϵͳ��ȫ��ƻ���;
*/
function obj_YN04_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN04=getTableFormObj(label_YN04 ,"1_1_1");
	var obj_YN04_01 = getTableFormCheckBox(label_YN04_01,"1_1_1" );
	if (obj_YN04.value == "��") {
		// ֻ��
		//obj_YN04_01.onclick = "";
		// ���
		disableTableCheckBox(obj_YN04_01,true);
	} else if (obj_YN04.value == "��") {
		// ��ԭ
		//obj_YN04_01.onclick = "";
		disableTableCheckBox(obj_YN04_01,false);
	}
}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ�����ʩ;
*/
function obj_YN05_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN05=getTableFormObj( label_YN05,"1_1_1");
	var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1" );
	if (obj_YN05.value == "��") {
		// ֻ��
		// ���
		obj_YN05_01.value="";
		obj_YN05_01.readOnly="readonly";
	} else if (obj_YN05.value == "��") {
		// ��ԭ
		obj_YN05_01.readOnly="";
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ��������Ӫ��ǩ��DDoS��������Э��;
*/
function obj_YN06_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN06=getTableFormObj( label_YN06,"1_1_1");
	var obj_YN06_01 = getTableFormObj(label_YN06_01,"1_1_1" );
	if (obj_YN06.value == "��") {
		// ֻ��
	
		// ���
		obj_YN06_01.value="";
		obj_YN06_01.readOnly="readonly";
	} else if (obj_YN06.value == "��") {
		// ��ԭ
		obj_YN06_01.readOnly="";
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸;
*/
function obj_YN07_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN07=getTableFormObj( label_YN07,"1_1_1");
	var obj_YN07_01 = getTableFormObj(label_YN07_01,"1_1_1" );
	if (obj_YN07.value == "��") {
		// ֻ��
	
		// ���
		obj_YN07_01.value="";
		obj_YN07_01.readOnly="readonly";
	} else if (obj_YN07.value == "��") {
		// ��ԭ
		obj_YN07_01.readOnly="";
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ������ּ�⼰���ַ�����ʩ";
*/
function obj_YN08_01(obj) {
	var obj_YN08=getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormCheckBox(label_YN08_01,obj_YN08.rownumber );
	if (obj_YN08.value == "��") {
		// ֻ��
		// ���
		obj_YN08_01.value = "";
		disableTableCheckBox(obj_YN08_01,true);
	} else if (obj_YN08.value == "��") {
		// ��ԭ
		disableTableCheckBox(obj_YN08_01,false);
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤;
*/
function obj_YN09_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN09=getTableFormObj( label_YN09,"1_1_1");
	var obj_YN09_01 = getTableFormObj(label_YN09_01,"1_1_1" );
	if (obj_YN09.value == "��") {
		// ֻ��
		// ���
		obj_YN09_01.value="";
		obj_YN09_01.readOnly="readonly";
	} else if (obj_YN09.value == "��") {
		// ��ԭ
		obj_YN09_01.readOnly="";
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤";
*/
function obj_YN10_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10=getTableFormObj( label_YN10,"1_1_1");
	var obj_YN10_01 = getTableFormObj(label_YN10_01,"1_1_1");
	var obj_YN10_02 = getTableFormObj(label_YN10_02,"1_1_1");
	if (obj_YN10.value == "��") {
		// ֻ��
		obj_YN10_01.onclick = "";
		obj_YN10_02.onclick = "";
		// ���
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
	} else if (obj_YN10.value == "��") {
		// ��ԭ
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
		obj_YN10_01.onclick = click_columnValueNumber;
		obj_YN10_02.onclick = click_columnValueNumber;
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������";;
*/
function obj_YN11_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN11=getTableFormObj( label_YN11,"1_1_1");
	var obj_YN11_01 = getTableFormObj(label_YN11_01_GTZero,"1_1_1");
	if (obj_YN11.value == "��") {
		// ֻ��
		obj_YN11_01.onclick = "";
		// ���
		obj_YN11_01.value = "";
		obj_YN11_01.onclic="";
	} else if (obj_YN11.value== "��") {
		// ��ԭ
		obj_YN11_01.onclick = click_columnValueNumber;
	}
}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ";
*/
function obj_YN12_01(obj) {
	
	//var target = getTarget(obj.parentElement);
	var obj_YN12=getTableFormObjs(label_YN12)[0];
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObjs(label_YN12_02)[0];
	var obj_YN12_03 = getTableFormObjs(label_YN12_03)[0];

	if (obj_YN12.value == "��") {
		// ֻ��
		// ���
		obj_YN12_01.value = "";
		obj_YN12_01.readOnly="readonly";
		obj_YN12_02.value = "";
		obj_YN12_02.readOnly="readonly";
		obj_YN12_03.value = "";
		obj_YN12_03.onclick = "";
	} else if (obj_YN12.value == "��") {
		// ��ԭ
		obj_YN12_01.readOnly="";
		obj_YN12_02.readOnly="";
		obj_YN12_03.onclick = click_columnValueNumber;
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢;
*/
function obj_YN13_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN13=getTableFormObj(label_YN13 ,"1_1_1");
	var obj_YN13_01 = getTableFormObj(label_YN13_01,"1_1_1" );

	if (obj_YN13.value == "��") {
		// ֻ��
		// ���
		obj_YN13_01.value = "";
		obj_YN13_01.readOnly="readonly";
	} else if (obj_YN13.value == "��") {
		// ��ԭ
		obj_YN13_01.readOnly="";
	}
}




/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ;
*/
function obj_YN14_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN14=getTableFormObj(label_YN14,"1_1_1");
	var obj_YN14_01 = getTableFormObj(label_YN14_01,"1_1_1");

	if (obj_YN14.value == "��") {
		// ֻ��
		// ���
		obj_YN14_01.value = "";
		obj_YN14_01.readOnly="readonly";
	} else if (obj_YN14.value == "��") {
		// ��ԭ
		obj_YN14_01.readOnly="";
	}
}




/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ;
*/
function obj_YN15_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN15=getTableFormObj( label_YN15,"1_1_1");
	var obj_YN15_01 = getTableFormObj(label_YN15_01,"1_1_1");
	if (obj_YN15.value == "��") {
		// ֻ��
		// ���
		obj_YN15_01.value = "";
		obj_YN15_01.readOnly="readonly";
	} else if (obj_YN15.value == "��") {
		// ��ԭ
		obj_YN15_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ;
*/
function obj_YN16_01(obj) {
	var obj_YN16=getTableFormObj( label_YN16 ,"1_1_1");
	var obj_YN16_01 = getTableFormObj(label_YN16_01,"1_1_1" );
	if (obj_YN16.value == "��") {
		// ֻ��
		// ���
		obj_YN16_01.value = "";
		obj_YN16_01.readOnly="readonly";
	} else if (obj_YN16.value  == "��") {
		// ��ԭ
		obj_YN16_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#��������ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���";
*/
function obj_YN17_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN17=getTableFormObj( label_YN17,"1_1");
	var obj_YN17_01 = getTableFormObj(label_YN17_01,"1_1" );

	if (obj_YN17.value == "��") {
		// ֻ��
		// ���
		obj_YN17_01.value = "";
		obj_YN17_01.readOnly="readonly";
	} else if (obj_YN17.value == "��") {
		// ��ԭ
		obj_YN17_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���";
*/
function obj_YN18_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN18=getTableFormObj( label_YN18,"1_1");
	var obj_YN18_01 = getTableFormObj(label_YN18_01,"1_1");
	if (obj_YN18.value == "��") {
		// ֻ��
		// ���
		obj_YN18_01.value = "";
		obj_YN18_01.readOnly="readonly";
	} else if (obj_YN18.value == "��") {
		// ��ԭ
		obj_YN18_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã� Ӧ��ϵͳ��ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ  ;
*/
function obj_YN19_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN19=getTableFormObj(label_YN19,"1_1");
	var obj_YN19_01 = getTableFormObj(label_YN19_01,"1_1" );

	if (obj_YN19.value == "��") {
		// ֻ��
		// ���
		obj_YN19_01.value = "";
		obj_YN19_01.readOnly="readonly";
	} else if (obj_YN19.value == "��") {
		// ��ԭ
		obj_YN19_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ��������ϵͳ��͸�Բ���";
*/
function obj_YN20_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN20=getTableFormObj( label_YN20,"1_1");
	var obj_YN20_01 = getTableFormObj(label_YN20_01,"1_1" );
	var obj_YN20_02 = getTableFormObj(label_YN20_02,"1_1" );
	if (obj_YN20.value == "��") {
		// ֻ��
		// ���
		obj_YN20_01.value = "";
		obj_YN20_01.readOnly="readonly";
		obj_YN20_02.value = "";
		obj_YN20_02.onclick ="";
	} else if (obj_YN20.value  == "��") {
		// ��ԭ
		obj_YN20_01.value = "";
		obj_YN20_01.readOnly="";
		obj_YN20_02.onclick = click_columnValueNumber;

	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"Ӧ��ϵͳ��ȫ#����#�Ƿ���з��������Ĺ���;
*/
function obj_YN100_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN100=getTableFormObj(label_YN100 ,"1_1");
	var obj_YN100_01 = getTableFormObj(label_YN100_01,"1_1");
	var obj_YN100_02 = getTableFormObj(label_YN100_02,"1_1" );
	if (obj_YN100.value== "��") {
		// ֻ��
		// ���
		obj_YN100_01.value = "";
		obj_YN100_01.onclick ="";
		obj_YN100_02.value = "";
		obj_YN100_02.onclick ="";
	} else if (obj_YN100.value == "��") {
		// ��ԭ
		obj_YN100_01.onclick = click_columnValueNumber;
		obj_YN100_02.onclick = click_columnValueNumber;

	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���;
*/
function obj_YN52_01(obj) {
	var obj_YN52=getTableFormObj( label_YN52,"1_1");
	var obj_YN52_01 = getTableFormObj(label_YN52_01,"1_1" );
	if (obj_YN52.value == "��") {
		// ֻ��
		// ���
		obj_YN52_01.value = "";
		obj_YN52_01.readOnly="readonly";
	} else if (obj_YN52.value == "��") {
		// ��ԭ
		obj_YN52_01.readOnly="";

	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ��ȡ����������ʩ"
*/
function obj_YN53_01(obj) {
	var obj_YN53=getTableFormObj(label_YN53 ,"1_1");
	var obj_YN53_01 = getTableFormObj(label_YN53_01,"1_1" );
	if (obj_YN53.value == "��") {
		// ֻ��
		// ���
		obj_YN53_01.value = "";
		obj_YN53_01.readOnly="readonly";
	} else if (obj_YN53.value == "��") {
		// ��ԭ
		obj_YN53_01.readOnly="";

	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���";
*/
function obj_YN21_01(obj) {
	var obj_YN21=getTableFormObj(label_YN21 ,"1_1_1");
	var obj_YN21_01 = getTableFormObj(label_YN21_01,"1_1_1" );
	if (obj_YN21.value== "��") {
		// ֻ��
		// ���
		obj_YN21_01.value = "";
		obj_YN21_01.onclick="";
	} else if (obj_YN21.value == "��") {
		// ��ԭ
		obj_YN21_01.onclick = click_columnValueNumber;
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"�����֤#����#��̬����#�Ƿ�߱������뱩���½����";
*/
function obj_YN22_01(obj) {
	var obj_YN22=getTableFormObj(label_YN22 ,"1_1_1");
	var obj_YN22_01 = getTableFormObj(label_YN22_01,"1_1_1" );
	if (obj_YN22.value == "��") {
		// ֻ��
		// ���
		obj_YN22_01.value = "";
		obj_YN22_01.readOnly="readonly";
	} else if (obj_YN22.value == "��") {
		// ��ԭ
		obj_YN22_01.readOnly="";

	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"�����֤#����#��̬����#�Ƿ�֧��ʹ����չ��ȫ�豸��������";
*/
function obj_YN231(obj) {
	var obj_YN23=getTableFormObj(label_YN23 ,"1_1_1");
	var obj_YN23_01 = getTableFormObj(label_YN23_01,"1_1_1");
	if (obj_YN23.value == "��") {
		// ֻ��
		// ���
		obj_YN23_01.value = "";
		obj_YN23_01.readOnly="readonly";
	} else if (obj_YN23.value == "��") {
		// ��ԭ
		obj_YN23_01.readOnly="";
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"�����֤#����#�ļ�֤��#�Ƿ�֧��";
*/
function obj_YN58(obj) {
	var obj_YN58=getTableFormObj( label_YN58,"1_1_1");
	var obj_YN58_01 = getTableFormObj(label_YN58_01,"1_1_1");
	var obj_YN58_02 = getTableFormObj(label_YN58_02,"1_1_1");
	var obj_YN58_03 = getTableFormObj(label_YN58_03,"1_1_1");
	var obj_YN58_04 = getTableFormObj(label_YN58_04,"1_1_1");
	var obj_YN58_05 = getTableFormObj(label_YN58_05,"1_1_1");
	var obj_YN58_06 = getTableFormObj(label_YN58_06,"1_1_1");
	var obj_YN58_07 = getTableFormObj(label_YN58_07,"1_1_1");
	var obj_YN58_08 = getTableFormObj(label_YN58_08,"1_1_1");
	var obj_YN58_08_01 = getTableFormObj(label_YN58_08_01,"1_1_1");
	if (obj_YN58.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN58_01,false);
		columnVallueRadio1(obj_YN58_02,false);
		columnVallueRadio1(obj_YN58_03,false);
		columnVallueRadio1(obj_YN58_04,false);
		columnVallueRadio1(obj_YN58_05,false);
		columnVallueRadio1(obj_YN58_06,false);
		columnVallueRadio1(obj_YN58_07,false);
		columnVallueRadio1(obj_YN58_08,false);
		obj_YN58_08_01.value = "";
		obj_YN58_08_01.readOnly="readonly";
	} else if (obj_YN58.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN58_01,true);
		columnVallueRadio1(obj_YN58_02,true);
		columnVallueRadio1(obj_YN58_03,true);
		columnVallueRadio1(obj_YN58_04,true);
		columnVallueRadio1(obj_YN58_05,true);
		columnVallueRadio1(obj_YN58_06,true);
		columnVallueRadio1(obj_YN58_07,true);
		columnVallueRadio3(obj_YN58_08,obj_YN5801);
		obj_YN58_08_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"�����֤#����#�ļ�֤��#�ͻ�֤��ǩ������";
*/
function obj_YN58_08(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN58_08_01 = getTableFormObj(label_YN58_08_01,"1_1_1" );
	var obj_YN58_08 = getTableFormObj(label_YN58_08,"1_1_1" );
		if(obj_YN58_08.value == "�Խ�CA"  ){
				obj_YN58_08_01.value = "";
				obj_YN58_08_01.readOnly="readonly";
		}else if(obj_YN58_08.value == "����������CA") {
				obj_YN58_08_01.value = "";
				obj_YN58_08_01.readOnly="";
		}
}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#USB Key#�Ƿ�֧��
*/
function obj_YN59(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN59=getTableFormObj(label_YN59 ,"1_1_1");
	var obj_YN59_01 = getTableFormObj(label_YN59_01,"1_1_1" );
	var obj_YN59_01_01 = getTableFormObj(label_YN59_01_01,"1_1_1" );
	var obj_YN59_02 = getTableFormObj(label_YN59_02,"1_1_1" );
	var obj_YN59_03 = getTableFormCheckBox(label_YN59_03,"1_1_1");
	var obj_YN59_04 = getTableFormObj(label_YN59_04,"1_1_1" );
	var obj_YN59_05 = getTableFormObj(label_YN59_05,"1_1_1" );
	var obj_YN59_06 = getTableFormObj(label_YN59_06,"1_1_1" );
	var obj_YN59_06_01 = getTableFormObj(label_YN59_06_01,"1_1_1" );
	var obj_YN59_07 = getTableFormObj(label_YN59_07,"1_1_1" );

	if (obj_YN59.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN59_01,false);
		columnVallueRadio1(obj_YN59_02,false);
	  disableTableCheckBox2(obj_YN59_03,true);
		columnVallueRadio1(obj_YN59_04,false);
		columnVallueRadio1(obj_YN59_05,false);
		columnVallueRadio1(obj_YN59_06,false);
		columnVallueRadio1(obj_YN59_07,false);
		obj_YN59_01_01.value = "";
		obj_YN59_01_01.readOnly="readonly";
		obj_YN59_06_01.value = "";
		obj_YN59_06_01.readOnly="readonly";
	} else if (obj_YN59.value == "��") {
		// ��ԭ
		columnVallueRadio3(obj_YN59_01,obj_YN30);
	//	columnVallueRadio1(obj_YN59_01,true);
		columnVallueRadio1(obj_YN59_02,true);
		disableTableCheckBox2(obj_YN59_03,false);
		columnVallueRadio1(obj_YN59_04,true);
		columnVallueRadio1(obj_YN59_05,true);
		columnVallueRadio3(obj_YN59_06,obj_YN31);
		columnVallueRadio1(obj_YN59_07,true);
		obj_YN59_01_01.readOnly="";
		obj_YN59_06_01.readOnly="";
	}
}
//�����ʽ���ĸ�ѡ���Ϊֻ�����д
function disableTableCheckBox2(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
			}
		}
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#USB Key#USB Key�Ƿ���ͨ���������������Ի����İ�ȫ���
*/
function obj_YN59_01(obj) {
	 var obj_YN59_01=getTableFormObj(label_YN59_01 ,"1_1_1");
	var obj_YN59_01_01 = getTableFormObj(label_YN59_01_01,"1_1_1" );
	if (obj_YN59_01.value == "��") {
		// ֻ��
		// ���
		obj_YN59_01_01.value = "";
		obj_YN59_01_01.readOnly="readonly";
	} else if (obj_YN59_01.value== "��") {
		// ��ԭ
		obj_YN59_01_01.readOnly="";
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#USB Key#�ͻ�֤��ǩ������Ϊ
*/
function obj_YN59_06(obj) {
	var obj_YN59_06=getTableFormObj(label_YN59_06 ,"1_1_1");
	var obj_YN59_06_01 = getTableFormObj(label_YN59_06_01,"1_1_1");
	if (obj_YN59_06.value == "�Խ�CA") {
		// ֻ��
		// ���
		obj_YN59_06_01.value = "";
		obj_YN59_06_01.readOnly="readonly";
	} else if (obj_YN59_06.value == "����������CA") {
		// ��ԭ
		obj_YN59_06_01.readOnly="";
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã� �����֤#����#OTP����#�Ƿ�֧��
*/
function obj_YN60(obj) {
	var	obj_YN60=getTableFormObj( label_YN60,"1_1_1");
	var obj_YN60_01 = getTableFormObj(label_YN60_01,"1_1_1" );
	var obj_YN60_02 = getTableFormObj(label_YN60_02,"1_1_1" );
	var obj_YN60_03 = getTableFormObj(label_YN60_03,"1_1_1");
	var obj_YN60_04 = getTableFormObj(label_YN60_04,"1_1_1");
	if (obj_YN60.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN60_01,false);
		columnVallueRadio1(obj_YN60_02,false);
		columnVallueRadio1(obj_YN60_03,false);
		columnVallueRadio1(obj_YN60_04,false);
	} else if (obj_YN60.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN60_01,true);
		columnVallueRadio1(obj_YN60_02,true);
		columnVallueRadio1(obj_YN60_03,true);
		columnVallueRadio1(obj_YN60_04,true);
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#���Ŷ�̬����#�Ƿ�֧��
*/
function obj_YN61(obj) {
	var obj_YN61=getTableFormObj( label_YN24,"1_1_1");
	var obj_YN24_01 = getTableFormObj(label_YN24_01,"1_1_1");
	var obj_YN24_02 = getTableFormObj(label_YN24_02,"1_1_1" );
	var obj_YN24_02_01 = getTableFormObj(label_YN24_02_01,"1_1_1");
	var obj_YN24_03 = getTableFormObj(label_YN24_03,"1_1_1" );
	var obj_YN24_04 = getTableFormObj(label_YN24_04,"1_1_1");
	var obj_YN24_05 = getTableFormObj(label_YN24_05,"1_1_1");
	var obj_YN24_05_01 = getTableFormObj(label_YN24_05_01,"1_1_1" );
	if (obj_YN61.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN24_01,false);
		columnVallueRadio1(obj_YN24_02,false);
		columnVallueRadio1(obj_YN24_03,false);
		columnVallueRadio1(obj_YN24_04,false);
		columnVallueRadio1(obj_YN24_05,false);
		obj_YN24_02_01.value = "";
		obj_YN24_02_01.readOnly="readonly";
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = "";
	} else if (obj_YN61.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN24_01,true);
		columnVallueRadio3(obj_YN24_02,obj_YN34);
		columnVallueRadio1(obj_YN24_03,true);
		columnVallueRadio1(obj_YN24_04,true);
		columnVallueRadio3(obj_YN24_05,obj_YN24_051);
		obj_YN24_02_01.readOnly="";
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = click_columnValueNumber;
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã� �����֤#����#���Ŷ�̬����#�����ֻ�����ʱ���Ƿ�Կͻ������ʵʩ��֤
*/
function obj_YN24_02_01(obj) {
	var obj_YN24_02=getTableFormObj( label_YN24_02,"1_1_1");
	var obj_YN24_02_01 = getTableFormObj(label_YN24_02_01,"1_1_1");
	if (obj_YN24_02.value == "��") {
		// ֻ��
		// ���
		obj_YN24_02_01.value = "";
		obj_YN24_02_01.readOnly="readonly";
	} else if (obj_YN24_02.value == "��") {
		// ��ԭ
		obj_YN24_02_01.readOnly="";
		
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#���Ŷ�̬����#�������Ƿ���ʾ�ؼ�����Ҫ����Ϣ����ת���˻������׽���
*/
function obj_YN24_05_01(obj) {
	var obj_YN24_05=getTableFormObj(label_YN24_05 ,"1_1_1");
	var obj_YN24_05_01 = getTableFormObj(label_YN24_05_01,"1_1_1");
	if (obj_YN24_05.value == "��") {
		// ֻ��
		// ���
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = "";
	} else if (obj_YN24_05.value == "��") {
		// ��ԭ
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = click_columnValueNumber;
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã� �����֤#����#��̬���#�Ƿ�֧��
*/
function obj_YN62(obj) {
	var obj_YN62=getTableFormObj( label_YN25,"1_1_1");
	var obj_YN25_01 = getTableFormObj(label_YN25_01,"1_1_1");
	var obj_YN25_02 = getTableFormObj(label_YN25_02,"1_1_1");
	var obj_YN25_03 = getTableFormObj(label_YN25_03,"1_1_1");
	var obj_YN25_04 = getTableFormObj(label_YN25_04,"1_1_1");
	var obj_YN25_05 = getTableFormObj(label_YN25_05,"1_1_1");
	var obj_YN25_06 = getTableFormObj(label_YN25_06,"1_1_1");
	var obj_YN25_06_01 = getTableFormObj(label_YN25_06_01,"1_1_1");
	var obj_YN25_06_02 = getTableFormObj(label_YN25_06_02,"1_1_1"); 
	var obj_YN25_07 = getTableFormObj(label_YN25_07,"1_1_1");

	if (obj_YN62.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN25_01,false);
		columnVallueRadio1(obj_YN25_02,false);
		columnVallueRadio1(obj_YN25_03,false);
		columnVallueRadio1(obj_YN25_04,false);
		columnVallueRadio1(obj_YN25_05,false);
		columnVallueRadio1(obj_YN25_06,false);
		columnVallueRadio1(obj_YN25_07,false);
		obj_YN25_06_01.value = "";
		obj_YN25_06_01.onclick = "";
		obj_YN25_06_02.value = "";
		obj_YN25_06_02.onclick = "";
	} else if (obj_YN62.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN25_01,true);
		columnVallueRadio1(obj_YN25_02,true);
		columnVallueRadio1(obj_YN25_03,true);
		columnVallueRadio1(obj_YN25_04,true);
		columnVallueRadio1(obj_YN25_05,true);
		columnVallueRadio3(obj_YN25_06,obj_YN2);
		columnVallueRadio1(obj_YN25_07,true);
		obj_YN25_06_01.onclick = click_columnValueNumber;
		obj_YN25_06_02.onclick = click_columnValueNumber;
	}
}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#��̬���#����������ƵĶ�̬����Ƿ����������ս��������
*/
function obj_YN25_06(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN25_06=getTableFormObjs(label_YN25_06)[0];
	var obj_YN25_06_01 = getTableFormObjs(label_YN25_06_01)[0];
	var obj_YN25_06_02 = getTableFormObjs(label_YN25_06_02)[0]; 
	if (obj_YN25_06.value == "��") {
		// ֻ��
		// ���
		obj_YN25_06_01.value = "";
		obj_YN25_06_01.onclick = "";
		obj_YN25_06_02.value = "";
		obj_YN25_06_02.onclick = "";
	} else if (obj_YN25_06.value == "��") {
		// ��ԭ
		obj_YN25_06_01.onclick = click_columnValueNumber;
		obj_YN25_06_02.onclick = click_columnValueNumber;
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
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	if (getTableFormObj(label_YN54,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN54,"1_1" ).parentElement);
		a+="�������� 1����ȫ����-ϵͳ�����������Ϊ��\n";
		isValid=false;
	} 
	if (getTableFormObj(label_YN01,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN01,"1_1" ).parentElement);
		a+="�������� 1����ȫ�������׷��յȼ����ֲ���Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj(label_YN25_08,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN25_08,"1_1" ).parentElement);
		a+="�������� 1����ȫ����-��������ϵͳ��ȫ�ڲ�������Ҫʵʩ���ţ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj(label_YN02,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN02,"1_1" ).parentElement);
		a+="�������� 1����ȫ����������Ƿ�ʵʩ��������ϵͳ��ȫ��������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObjs(label_YN03)[0].value.trim() == "") {
		errorObjs.push(getTableFormObjs(label_YN03)[0].parentElement);
		a+="�������� 1����ȫ����-�Ƿ����������а�ȫ�¼��ļ�⡢��Ӧ���㱨���ƣ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("��ȫ����#����#Ӧ������#�Ƿ������������ϵͳ������Ӧ���������","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("��ȫ����#����#Ӧ������#�Ƿ������������ϵͳ������Ӧ���������","1_1_1" ).parentElement);
		a+="�������� 1����ȫ����-�Ƿ������������ϵͳ������Ӧ��������Ʋ���Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("��ȫ����#����#Ӧ������#Ӧ���ƻ��Ƿ�������","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("��ȫ����#����#Ӧ������#Ӧ���ƻ��Ƿ�������","1_1_1" ).parentElement);
		a+="�������� 1����ȫ����-Ӧ���ƻ��Ƿ�����������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("��ȫ����#����#��ȫ���#�Ƿ��ѽ�������������ϵͳ��ȫ��ƻ���","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("��ȫ����#����#��ȫ���#�Ƿ��ѽ�������������ϵͳ��ȫ��ƻ���","1_1_1" ).parentElement);
		a+="�������� 1����ȫ����-�Ƿ�����������ϵͳ��ȫ��ƻ��Ʋ���Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("��ȫ����#����#Ӧ��ϵͳ��־#�Ƿ�����������а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("��ȫ����#����#Ӧ��ϵͳ��־#�Ƿ�����������а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���","1_1_1" ).parentElement);
		a+="�������� 1����ȫ����-�Ƿ�����������а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���:����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�ͻ���ȫ����#�ͻ�������ʶ��ǿ#�������з���Э�����Ƿ������ȫ������ʾ����","1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("�ͻ���ȫ����#�ͻ�������ʶ��ǿ#�������з���Э�����Ƿ������ȫ������ʾ����","1_1" ).parentElement);
		a+="�������� 2���ͻ���ȫ����-�������з���Э�����Ƿ������ȫ������ʾ���ݣ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�ͻ���ȫ����#�ͻ�������ʶ��ǿ#ͨ����������������ǿ�ͻ�����","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�ͻ���ȫ����#�ͻ�������ʶ��ǿ#ͨ����������������ǿ�ͻ�����","1_1").parentElement);
		a+="�������� 2���ͻ���ȫ����-ͨ����������������ǿ�ͻ�����������Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������DMZ��֮��ĸ����ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������DMZ��֮��ĸ����ʩ","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-��������DMZ��֮��ĸ����ʩ������Ϊ�գ�\n";
		isValid=false;
	}

	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#DMZ��������֮��ĸ����ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#DMZ��������֮��ĸ����ʩ","1_1_1").parentElement);
		a+="	�������� 3��ͨѶ��ȫ-DMZ��������֮��ĸ����ʩ ����Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ�����ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ�����ʩ","1_1_1").parentElement);
		a+="	�������� 3��ͨѶ��ȫ-��������ϵͳ������ҵ��ϵͳ֮���Ƿ��ȥ���룻����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ��","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ�첻��Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ��������Ӫ��ǩ��DDoS��������Э��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ��������Ӫ��ǩ��DDoS��������Э��","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-�Ƿ��������Ӫ��ǩ��DDoS��������Э�飺����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸","1_1_1").parentElement);
		a+="	�������� 3��ͨѶ��ȫ-�Ƿ���DDoS��������Э�飺����Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���DDoS�����豸","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-�Ƿ������ּ�⼰���ַ�����ʩ����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-����������ͻ���֮���Ƿ�˫����֤������Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�������з�����֤��䷢����Ϊ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�������з�����֤��䷢����Ϊ","1_1_1"));
		a+="�������� 3��ͨѶ��ȫ-�������з�����֤��䷢��������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������","1_1_1").parentElement);
		a+="�������� 3��ͨѶ��ȫ-�Ƿ�߱�������¼ʧ���������ƣ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��¼ʧ�ܴ�������Ϊ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��¼ʧ�ܴ�������Ϊ","1_1_1"));
		a+="�������� ��3��ͨѶ��ȫ-��¼ʧ�ܴ������ơ�����Ϊ��!\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#���ݼ���#�Ƿ��ƶ�����������Կ�����ƶȣ�����Կ�������ڽ���ȫ�����","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#���ݼ���#�Ƿ��ƶ�����������Կ�����ƶȣ�����Կ�������ڽ���ȫ�����","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�Ƿ��ƶ�����������Կ�����ƶȣ�����Կ�������ڽ���ȫ���������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�Ƿ���������ݽ��м��ܴ洢������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#���ݼ���#������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#���ݼ���#������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�ͻ��˳����Ƿ��ȡ�����̼�����ʩ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ�洢�ͻ�������Ϣ","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ�洢�ͻ�������Ϣ","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�ͻ��˳����Ƿ�洢�ͻ�������Ϣ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ���","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ���","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ�������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("���ݰ�ȫ#����#������Ϣ��й¶#�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤","1_1_1").parentElement);
		a+="�������� 4�����ݰ�ȫ-�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#��������ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#��������ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-��������ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���:����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-ʹ�ü�⹤��ʵʩ���밲ȫ���:����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ��������ϵͳ��͸�Բ���","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ��������ϵͳ��͸�Բ���","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�Ƿ��ڻ򲻶��ڿ�չ��������ϵͳ��͸�Բ��ԣ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ���з��������Ĺ���","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ���з��������Ĺ���","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�Ƿ���з��������Ĺ��ܣ�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ�֧���û���ѯ��¼��¼","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�Ƿ�֧���û���ѯ��¼��¼","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�Ƿ�֧���û���ѯ��¼��¼������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ��⣺����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ���������ǩ��","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ���������ǩ��","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�ͻ��˳����Ƿ���������ǩ��������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ��ȡ����������ʩ","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ��ȡ����������ʩ","1_1").parentElement);
		a+="�������� 5��Ӧ��ϵͳ��ȫ-�ͻ��˳����Ƿ��ȡ����������ʩ������Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#��̬����#�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ����","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#��̬����#�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ����","1_1_1").parentElement);
		a+="�������� 6�������֤-�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ���룺����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���","1_1_1").parentElement);
		a+="�������� 6�������֤-��ͨ����̬������֤��������Ƿ���������ʽ��ף�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#��̬����#�Ƿ�߱������뱩���½����","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#��̬����#�Ƿ�߱������뱩���½����","1_1_1").parentElement);
		a+="�������� 6�������֤-�Ƿ�߱������뱩���½���ƣ�����Ϊ�գ�\n";
		isValid=false;
	}
	
	if (getTableFormObj("�����֤#����#��̬����#�Ƿ�֧��ʹ����չ��ȫ�豸��������","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#��̬����#�Ƿ�֧��ʹ����չ��ȫ�豸��������","1_1_1").parentElement);
		a+="�������� 6�������֤-�Ƿ�֧��ʹ����չ��ȫ�豸�������룺����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#�ļ�֤��#�Ƿ�֧��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#�ļ�֤��#�Ƿ�֧��","1_1_1").parentElement);
		a+="�������� 6�������֤-�ļ�֤�� �Ƿ�֧�֣�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#USB Key#�Ƿ�֧��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#USB Key#�Ƿ�֧��","1_1_1").parentElement);
		a+="�������� 6�������֤-USBKey �Ƿ�֧��;����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#OTP����#�Ƿ�֧��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#OTP����#�Ƿ�֧��","1_1_1").parentElement);
		a+="�������� 6�������֤-OTP���ƣ��Ƿ�֧�ֲ���Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#���Ŷ�̬����#�Ƿ�֧��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#���Ŷ�̬����#�Ƿ�֧��","1_1_1").parentElement);
		a+="�������� 6�������֤-���Ŷ�̬����Ƿ�֧�֣�����Ϊ�գ�\n";
		isValid=false;
	}
	if (getTableFormObj("�����֤#����#��̬���#�Ƿ�֧��","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("�����֤#����#��̬���#�Ƿ�֧��","1_1_1").parentElement);
		a+="�������� 6�������֤-��̬������Ƿ�֧�ֲ���Ϊ�գ�\n";
		isValid=false;
	}
	
	if(parseInt(getTableFormObj(label_YN100_01,"1_1").value.trim())<parseInt(getTableFormObj(label_YN100_02,"1_1").value.trim())){
		errorObjs.push(getTableFormObj(label_YN100_01,"1_1"));
		errorObjs.push(getTableFormObj(label_YN100_02,"1_1"));
		a+="Ӧ��ϵͳ��ȫ-���ֵ�����վ��>=Ӧ��ϵͳ��ȫ-�رյ�����վ������\n";
  		isValid=false;
		}
	if(getTableFormObj(label_YN01,"1_1" ).value=="��"){
		var obj1 = getTableFormObj(label_YN01_01,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="��ȫ����-����-�߷��ս��װ���������Ϊ��\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN01_02,"1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="��ȫ����-����-�ͷ��ս��װ�������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN25_06,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN25_06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����#��̬���-����������ƵĶ�̬��������ʹ�ô�������Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN25_06_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="�����֤-����-��̬���-��̬���ʹ����Ч�ڲ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN02,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN02_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="��ȫ����-����-������ʽ����Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN02_01_01,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="��ȫ����-����-�������Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN03,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN03_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="��ȫ����-����-��ȫ�¼�����-�������а�ȫ�¼�����·�߲���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN04,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN04_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj.parentElement);
			a +="��ȫ����-����-��ȫ���-��ȫ��Ƹ��Ƿ�Χ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN05_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-���簲ȫ���ƴ�ʩ-�����ʩ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN06,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-���簲ȫ���ƴ�ʩ-������Ҫ���ݼ�������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN07,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN07_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-���簲ȫ���ƴ�ʩ-�豸Ʒ�Ƽ��ͺŲ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN08,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN08_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-���簲ȫ���ƴ�ʩ#�������:����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN09_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-�Ự��ȫ�����ʩ-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN10_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-�Ự��ȫ�����ʩ-�����������ӿ��г�ʱ�ر�ʱ��Ϊ����Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN10_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="ͨѶ��ȫ-����-�Ự��ȫ�����ʩ-��ҵ�������ӿ��г�ʱ�ر�ʱ��Ϊ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN11_01_GTZero,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-�Ự��ȫ�����ʩ-��¼ʧ�ܴ�������Ϊ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN14,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN14_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-�߷��ս������������Ա�����������-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN15_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-�߷��ս������������Ա�����������-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN16,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN16_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-������Ϣ��й¶-#��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN17,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN17_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-��ⲿ�ţ���֯���Ŷӣ����Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN18,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN18_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-��⹤��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN20,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN20_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-���Ի�������֯�����Ʋ���Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN20_02,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="Ӧ��ϵͳ��ȫ-����-����ڿ�չ������ȫ���Բ��Դ�������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN100,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN100_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-���ֵ�����վ������Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN100_02,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="Ӧ��ϵͳ��ȫ-����-�رյ�����վ������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN52,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN52_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-�������������Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN53,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN53_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN21,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN21_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����#��̬����-�����޶�Ϊ����Ϊ��\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN22,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN22_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-��̬����-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN12,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN12_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-���ݼ���-�������Э�����Ʋ���Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN12_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="���ݰ�ȫ-����-���ݼ���-�����㷨���Ʋ���Ϊ��\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN12_03,"1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="���ݰ�ȫ-����-���ݼ���-��Կ���Ȳ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN13_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����#���ݼ���-���ܵ������ֶΰ�������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN23,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN23_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-��̬����-��չ��ȫ�豸��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN59_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN59_01_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-USB Key-���Ի������Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN59_06,"1_1_1" ).value=="����������CA"){
		var obj = getTableFormObj(label_YN59_06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-USB Key��������CA�������ơ�����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN24_02,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN24_02_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-���Ŷ�̬����-��֤��ʽ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN24_05,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN24_05_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-���Ŷ�̬����-�ֻ���̬�������Чʱ��Ϊ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN58_08,"1_1_1" ).value=="����������CA"){
		var obj = getTableFormObj(label_YN58_08_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-�ļ�֤�飺������CA�������ơ�����Ϊ��!\n";
			isValid = false;
		}
	}
	

	if(getTableFormObjs("�����֤#����#USB Key#�Ƿ�֧��")[0].value=="��"){
		if(getTableFormObjs("�����֤#����#USB Key#USB Key�Ƿ���ͨ���������������Ի����İ�ȫ���")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#USB Key�Ƿ���ͨ���������������Ի����İ�ȫ���")[0].parentElement);
			a +="�������� ��6�������֤-USB Key�Ƿ���ͨ���������������Ի����İ�ȫ��⣺������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#USB Key#�ͻ�֤��˽Կ�� USB Key�ڲ����ɣ��������κ���ʽ�� USB Key��ȡ��д��˽Կ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#�ͻ�֤��˽Կ�� USB Key�ڲ����ɣ��������κ���ʽ�� USB Key��ȡ��д��˽Կ")[0].parentElement);
			a +="�������� ��6�������֤-�ͻ�֤��˽Կ�� USB Key�ڲ����ɣ��������κ���ʽ�� USB Key��ȡ��д��˽Կ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#USB Key#USB Key��ִ��ǩ�������в���ʱ���Ƿ�߱�������ʾ���ܣ���Ҫ��Կͻ����ʵʩ����")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#USB Key��ִ��ǩ�������в���ʱ���Ƿ�߱�������ʾ���ܣ���Ҫ��Կͻ����ʵʩ����")[0].parentElement);
			a +="�������� ��6�������֤-USB Key��ִ��ǩ�������в���ʱ���Ƿ�߱�������ʾ���ܣ���Ҫ��Կͻ����ʵʩ���𣺡�����Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#USB Key#USB Key�Ƿ�߱�PIN������������������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#USB Key�Ƿ�߱�PIN������������������")[0].parentElement);
			a +="�������� ��6�������֤-USB Key�Ƿ�߱�PIN�����������������ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#USB Key#�ͻ��ǳ���������ʱ�Ƿ���ʾ�ͻ��Ͽ�USB Key")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#�ͻ��ǳ���������ʱ�Ƿ���ʾ�ͻ��Ͽ�USB Key")[0].parentElement);
			a +="�������� ��6�������֤-�ͻ��ǳ���������ʱ�Ƿ���ʾ�ͻ��Ͽ�USB Key��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#USB Key#�ͻ�֤��ǩ������Ϊ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#USB Key#�ͻ�֤��ǩ������Ϊ")[0].parentElement);
			a +="�������� ��6�������֤-USB Key���ͻ�֤��ǩ������������Ϊ��!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("�����֤#����#OTP����#�Ƿ�֧��")[0].value=="��"){
		if(getTableFormObjs("�����֤#����#OTP����#OTP�����Ƿ�����PIN�뱣������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#OTP����#OTP�����Ƿ�����PIN�뱣������")[0].parentElement);
			a +="�������� ��6�������֤-OTP�����Ƿ�����PIN�뱣�����ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#OTP����#OTP�����Ƿ�߱�PIN������������������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#OTP����#OTP�����Ƿ�߱�PIN������������������")[0].parentElement);
			a +="�������� ��6�������֤-OTP�����Ƿ�߱�PIN�����������������ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#OTP����#��̬����ĳ����Ƿ�����6λ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#OTP����#��̬����ĳ����Ƿ�����6λ")[0].parentElement);
			a +="�������� ��6�������֤-��̬����ĳ����Ƿ�����6λ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#OTP����#PIN�ĳ����Ƿ�����4λ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#OTP����#PIN�ĳ����Ƿ�����4λ")[0].parentElement);
			a +="�������� ��6�������֤-PIN�ĳ����Ƿ�����4λ��������Ϊ��!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�֧��")[0].value=="��"){
		if(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�ǿ��ʹ�����뱣��˽Կ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�ǿ��ʹ�����뱣��˽Կ")[0].parentElement);
			a +="�������� ��6�������֤-�Ƿ�ǿ��ʹ�����뱣��˽Կ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#�ͻ�֤�鹫˽Կ���Ƿ��ڿͻ�������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#�ͻ�֤�鹫˽Կ���Ƿ��ڿͻ�������")[0].parentElement);
			a +="	�������� ��6�������֤-�ͻ�֤�鹫˽Կ���Ƿ��ڿͻ������ɣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#˽Կ����ʱ���ͻ����Ƿ�Կͻ����ʵʩ��֤")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#˽Կ����ʱ���ͻ����Ƿ�Կͻ����ʵʩ��֤")[0].parentElement);
			a +="	�������� ��6�������֤-˽Կ����ʱ���ͻ����Ƿ�Կͻ����ʵʩ��֤��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�֧��֤��˽Կ���ɵ���ѡ��")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�֧��֤��˽Կ���ɵ���ѡ��")[0].parentElement);
			a +="�������� ��6�������֤-�Ƿ�֧��֤��˽Կ���ɵ���ѡ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#֤��˽Կ����ʱ���Ƿ���ʾ��ǿ�Ʒ����ƶ��豸��")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#֤��˽Կ����ʱ���Ƿ���ʾ��ǿ�Ʒ����ƶ��豸��")[0].parentElement);
			a +="�������� ��6�������֤-֤��˽Կ����ʱ���Ƿ���ʾ��ǿ�Ʒ����ƶ��豸�ڣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�Ա��ݵ�֤��˽Կ���м���")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#�Ƿ�Ա��ݵ�֤��˽Կ���м���")[0].parentElement);
			a +="�������� ��6�������֤-�Ƿ�Ա��ݵ�֤��˽Կ���м��ܣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#���ݻ�ָ�֤��˽Կ�ɹ����Ƿ�ͨ���ֻ����ŵȵڶ�ͨ��������ͻ�������ʾ��Ϣ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#���ݻ�ָ�֤��˽Կ�ɹ����Ƿ�ͨ���ֻ����ŵȵڶ�ͨ��������ͻ�������ʾ��Ϣ")[0].parentElement);
			a +="�������� ��6�������֤-���ݻ�ָ�֤��˽Կ�ɹ����Ƿ�ͨ���ֻ����ŵȵڶ�ͨ��������ͻ�������ʾ��Ϣ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#�ļ�֤��#�ͻ�֤��ǩ������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#�ļ�֤��#�ͻ�֤��ǩ������")[0].parentElement);
			a +="�������� ��6�������֤-�ļ���֤���ͻ�֤��ǩ������������Ϊ��!\n";
			isValid = false;
		}
		
	}
	if(getTableFormObjs("�����֤#����#���Ŷ�̬����#�Ƿ�֧��")[0].value=="��"){
		if(getTableFormObjs("�����֤#����#���Ŷ�̬����#��ͨ�ֻ���̬����ʱ�� ʹ�ù�����˹����뷽ʽ��֤�ͻ���ݲ��Ǽ��ֻ�����")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#���Ŷ�̬����#��ͨ�ֻ���̬����ʱ�� ʹ�ù�����˹����뷽ʽ��֤�ͻ���ݲ��Ǽ��ֻ�����")[0].parentElement);
			a +="�������� ��6�������֤-��ͨ�ֻ���̬����ʱ�� ʹ�ù�����˹����뷽ʽ��֤�ͻ���ݲ��Ǽ��ֻ����룺������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#���Ŷ�̬����#�����ֻ�����ʱ���Ƿ�Կͻ������ʵʩ��֤")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#���Ŷ�̬����#�����ֻ�����ʱ���Ƿ�Կͻ������ʵʩ��֤")[0].parentElement);
			a +="�������� ��6�������֤-�����ֻ�����ʱ���Ƿ�Կͻ������ʵʩ��֤��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#���Ŷ�̬����#��̬����ĳ����Ƿ�����6λ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#���Ŷ�̬����#��̬����ĳ����Ƿ�����6λ")[0].parentElement);
			a +="�������� ��6�������֤-��̬����ĳ����Ƿ�����6λ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#���Ŷ�̬����#�ֻ���̬����������Ƿ���ת���˻������׽���Ҫ�������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#���Ŷ�̬����#�ֻ���̬����������Ƿ���ת���˻������׽���Ҫ�������")[0].parentElement);
			a +="�������� ��6�������֤-�ֻ���̬����������Ƿ���ת���˻������׽���Ҫ���������������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#���Ŷ�̬����#�������Ƿ���ʾ�ؼ�����Ҫ����Ϣ����ת���˻������׽���")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#���Ŷ�̬����#�������Ƿ���ʾ�ؼ�����Ҫ����Ϣ����ת���˻������׽���")[0].parentElement);
			a +="�������� ��6�������֤-�������Ƿ���ʾ�ؼ�����Ҫ����Ϣ����ת���˻������׽��ȣ�������Ϊ��!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("�����֤#����#��̬���#�Ƿ�֧��")[0].value=="��"){
		if(getTableFormObjs("�����֤#����#��̬���#��̬����Ƿ�߱�PIN������������������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#��̬����Ƿ�߱�PIN������������������")[0].parentElement);
			a +="	�������� ��6�������֤-��̬����Ƿ�߱�PIN�����������������ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#��̬����Ƿ�����PIN�뱣������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#��̬����Ƿ�����PIN�뱣������")[0].parentElement);
			a +="�������� ��6�������֤-��̬����Ƿ�����PIN�뱣�����ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#��̬����ĳ����Ƿ�����6λ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#��̬����ĳ����Ƿ�����6λ")[0].parentElement);
			a +="�������� ��6�������֤-��̬����ĳ����Ƿ�����6λ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#PIN�ĳ����Ƿ�����4λ")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#PIN�ĳ����Ƿ�����4λ")[0].parentElement);
			a +="�������� ��6�������֤-PIN�ĳ����Ƿ�����4λ��������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#�Ƿ�֧�ֻ���������ƵĶ�̬���")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#�Ƿ�֧�ֻ���������ƵĶ�̬���")[0].parentElement);
			a +="�������� ��6�������֤-�Ƿ�֧�ֻ���������ƵĶ�̬�����������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#��̬���ʹ����Ч��")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#��̬���ʹ����Ч��")[0].parentElement);
			a +="�������� ��6�������֤-��̬����ʹ����Ч�ڡ�����Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#�Ƿ�ʹ��Ϳ�㸲�ǵȷ�����������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#�Ƿ�ʹ��Ϳ�㸲�ǵȷ�����������")[0].parentElement);
			a +="�������� ��6�������֤-�Ƿ�ʹ��Ϳ�㸲�ǵȷ��������������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#����������ƵĶ�̬����Ƿ����������ս��������")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#����������ƵĶ�̬����Ƿ����������ս��������")[0]);
			a +="�������� ��6�������֤-����������ƵĶ�̬����Ƿ����������ս�������꣺������Ϊ��!\n";
			isValid = false;
		}
		if(getTableFormObjs("�����֤#����#��̬���#����������ƵĶ�̬��������ʹ�ô���")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("�����֤#����#��̬���#����������ƵĶ�̬��������ʹ�ô���")[0]);
			a +="�������� ��6�������֤-����������ƵĶ�̬��������ʹ�ô�����������Ϊ��!\n";
			isValid = false;
		}
	}
	
	checkFloatNum(getTableFormObj(label_YN21_01,"1_1"));
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
 *���ܣ��������ֿؼ�
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
 *���ܣ���ѡ��ť�Ķ�д����
 */
function columnVallueRadio1(obj,access){
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
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								};
						}else{
							imgs[k].onclick = function(){
							columnVallueRadio(this);
							};
						}
					}
				}
			}
		}
	}
}