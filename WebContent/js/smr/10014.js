/**T-B-15 �ֻ�����ϵͳ��ȫ������������*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item5 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�������";
var label_YN01_00="��ȫ����#����#������Ƿ�ʵʩ��������ϵͳ��ȫ����";
var label_YN01_01="��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ�������";
var label_YN01_02="��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ����ά��ģʽ";

var label_YN02_01="��ȫ����#����#���׷��յȼ�����#�Ƿ񻮷�";
var label_YN02_02="��ȫ����#����#���׷��յȼ�����#�߷��ս��װ���";
var label_YN02_03="��ȫ����#����#���׷��յȼ�����#�ͷ��ս��װ���";

var label_YN03_01="��ȫ����#����#��ȫ����#�ֻ�����ϵͳ��ȫ�ڲ�������Ҫʵʩ���ţ���֯�� ";
var label_YN03_02="��ȫ����#����#��ȫ����#������Ƿ�ʵʩ�ֻ�����ϵͳ��ȫ����";
var label_YN03_03="��ȫ����#����#��ȫ����#������ʽ";
var label_YN03_04="��ȫ����#����#��ȫ����#��������";

var label_YN04_01="��ȫ����#����#Ӧ������#�Ƿ�����ֻ�����ϵͳ������Ӧ���������";
var label_YN04_02="��ȫ����#����#Ӧ������#Ӧ���ƻ��Ƿ�������";

var label_YN05_01="��ȫ����#����#��ȫ���#�Ƿ��ѽ������ֻ�����ϵͳ��ȫ��ƻ���";
var label_YN05_02="��ȫ����#����#��ȫ���#��ȫ��Ƹ��Ƿ�Χ";

var label_YN06_01="��ȫ����#����#��ȫ���Ʒ���#�Ƿ�����ֻ����а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���";


var label_YN07_01="�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#�ֻ����з���Э�����Ƿ������ȫ������ʾ����";
var label_YN07_02="�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#ͨ����������������ǿ�ͻ�����";


var label_YN08_01="ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������DMZ��֮��ĸ����ʩ";
var label_YN08_02="ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#DMZ��������֮��ĸ����ʩ";
var label_YN08_03="ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�ֻ�����ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ��";
var label_YN08_04="ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�����ʩ";
var label_YN08_05="ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ��";

var label_YN09_01="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤";
var label_YN09_02="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��ʩ����";
var label_YN09_03="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����в��õ�WAPЭ��汾";
var label_YN09_04="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤";
var label_YN09_05="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#���ӿ��г�ʱ�ر�ʱ��Ϊ";
var label_YN09_06="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����з�����֤��䷢����Ϊ";
var label_YN09_07="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������";
var label_YN09_08="ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#��¼ʧ�ܴ�������Ϊ";



var label_YN10_01="���ݰ�ȫ#����#���ݼ���#�Ƿ��ƶ��ֻ�������Կ�����ƶȣ�����Կ�������ڽ���ȫ�����";
var label_YN10_02="���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ";
var label_YN10_03="���ݰ�ȫ#����#���ݼ���#1#�������Э�����ƣ�";
var label_YN10_04="���ݰ�ȫ#����#���ݼ���#1#�����㷨���ƣ�";
var label_YN10_05="���ݰ�ȫ#����#���ݼ���#1#��Կ���ȣ�";
var label_YN10_06="���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢";
var label_YN10_07="���ݰ�ȫ#����#���ݼ���#���ܵ������ֶΰ���";
var label_YN10_08="���ݰ�ȫ#����#���ݼ���#������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢";

var label_YN11_01="���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ";
var label_YN11_02="���ݰ�ȫ#����#�߷��ս������������Ա�����������#��ʩ����";
var label_YN11_03="���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ";
var label_YN11_04="���ݰ�ȫ#����#�߷��ս������������Ա�����������#��ʩ���� ";

var label_YN12_01="���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ";
var label_YN12_02="���ݰ�ȫ#����#������Ϣ��й¶#��ʩ����";
var label_YN12_03="���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ�洢�ͻ�������Ϣ";
var label_YN12_04="���ݰ�ȫ#����#������Ϣ��й¶#��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ���";
var label_YN12_05="���ݰ�ȫ#����#������Ϣ��й¶#�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤";

var label_YN13_01="Ӧ��ϵͳ��ȫ#����#�ֻ�����ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���";
var label_YN13_02="Ӧ��ϵͳ��ȫ#����#��ⲿ�ţ���֯���Ŷӣ�����";
var label_YN13_03="Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���";
var label_YN13_04="Ӧ��ϵͳ��ȫ#����#��⹤������";
var label_YN13_05="Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ�ֻ�����ϵͳ��͸�Բ���";
var label_YN13_06="Ӧ��ϵͳ��ȫ#����#���Ի�������֯������";
var label_YN13_07="Ӧ��ϵͳ��ȫ#����#�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ";
var label_YN13_08="Ӧ��ϵͳ��ȫ#����#�Ƿ�֧���û���ѯ��¼��¼";
var label_YN13_09="Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���";
var label_YN13_10="Ӧ��ϵͳ��ȫ#����#��������������";

var label_YN14_01="�����֤#����#��̬����#�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ����";
var label_YN14_02="�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���";
var label_YN14_03="�����֤#����#��̬����#�����޶�Ϊ";
var label_YN14_04="�����֤#����#��̬����#�Ƿ�߱������뱩���½����";
var label_YN14_05="�����֤#����#��̬����#��ʩ����";

var label_YN15_01="�����֤#����#�ֻ�������֤#�Ƿ������ֻ�������֤����";
var label_YN15_02="�����֤#����#�ֻ�������֤#��ʩ����";
var label_YN15_03="�����֤#����#�ֻ�������֤#�Ƿ��ȡ�ֻ������α��ʩ";
var label_YN15_04="�����֤#����#�ֻ�������֤#��ʩ���� ";

var label_YN16_01="�����֤#����#OTP����#�Ƿ�֧��";
var label_YN16_02="�����֤#����#OTP����#OTP�����Ƿ�����PIN�뱣������";
var label_YN16_03="�����֤#����#OTP����#OTP�����Ƿ�߱�PIN������������������";
var label_YN16_04="�����֤#����#OTP����#��̬����ĳ����Ƿ�����6λ";
var label_YN16_05="�����֤#����#OTP����#PIN�ĳ����Ƿ�����4λ";

var label_YN17_01="�����֤#����#��̬���#�Ƿ�֧��";
var label_YN17_02="�����֤#����#��̬���#��̬����Ƿ�����PIN�뱣������";
var label_YN17_03="�����֤#����#��̬���#��̬����Ƿ�߱�PIN������������������";
var label_YN17_04="�����֤#����#��̬���#��̬����ĳ����Ƿ�����6λ";
var label_YN17_05="�����֤#����#��̬���#PIN�ĳ����Ƿ�����4λ";
var label_YN17_06="�����֤#����#��̬���#�Ƿ�֧�ֻ���������ƵĶ�̬���";
var label_YN17_07="�����֤#����#��̬���#����������ƵĶ�̬����Ƿ����������ս��������";
var label_YN17_08="�����֤#����#��̬���#����������ƵĶ�̬��������ʹ�ô���";
var label_YN17_09="�����֤#����#��̬���#��̬���ʹ����Ч��";
var label_YN17_10="�����֤#����#��̬���#�Ƿ�ʹ��Ϳ�㸲�ǵȷ�����������";

var label_YN18_01="�����֤#����#����#�Ƿ����������֤��ʽ";
var label_YN18_02="�����֤#����#����#��ʩ����";
var label_isempty = "���Ϳձ���#���Ϳձ�";

var label_YN18_11="��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ����ά��ģʽ";


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã� ��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ����ά��ģʽ
*/
function setobj_YN18_11(obj){
	var obj1 = getTableFormObj(label_YN18_11,"1_1_1" );
	var obj_YN18_11 = getTableFormCheckBox(label_YN18_11,"1_1_1" );
		if( obj_YN18_11[0].checked==true ){
			obj_YN18_11[1].checked=false;
			obj_YN18_11[1].disabled=true;
			obj_YN18_11[2].checked=false;
			obj_YN18_11[2].disabled=true;
			obj_YN18_11[3].checked=false;
			obj_YN18_11[3].disabled=true;
			obj_YN18_11[4].checked=false;
			obj_YN18_11[4].disabled=true;
			obj_YN18_11[5].checked=false;
			obj_YN18_11[5].disabled=true;
			showOrHiddenTableColumnCheckBoxElse(obj_YN18_11[5]);
			obj1.value=obj_YN18_11[0].value;
		}else {
			obj_YN18_11[0].checked=false;
			obj_YN18_11[1].disabled=false;
			obj_YN18_11[2].disabled=false;
			obj_YN18_11[3].disabled=false;
			obj_YN18_11[4].disabled=false;
			obj_YN18_11[5].disabled=false;

		}
		
}
/*
* ���ܣ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ������objs Ϊ���и�ѡ����󼯺�
*/
function disableTableCheckBox1(objs){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(objs[i].value==""){
				objs[i].onclick=function(){showOrHiddenTableColumnCheckBoxElse(this);
				setobj_YN18_11(this);};
			}else{
				objs[i].onclick=function(){columnValueCheckBox(this);setobj_YN18_11(this);};
			}
		}
	}
}
/*
* ���ܣ����̴���ҳ��ʼ��ʱ���ñ�Ȩ��
* ���ã��״̬�Ͷ�������״̬
*/
function initSet(){
	obj_YN02_01(getTableFormObj(label_YN01_01,"1_1_1" ));
	obj_YN02_011(getTableFormObj(label_YN02_01,"1_1_1" ));
	obj_YN03_02(getTableFormObj(label_YN03_02,"1_1_1" ));
	obj_YN05_01(getTableFormObj(label_YN05_01,"1_1_1" ));
	obj_YN09_01(getTableFormObj(label_YN09_01,"1_1_1" ));
	obj_YN09_04(getTableFormObj(label_YN09_04,"1_1_1" ));
	obj_YN09_07(getTableFormObj(label_YN09_07,"1_1_1" ));
	obj_YN10_02(getTableFormObj(label_YN10_02,"1_1_1" ));
	obj_YN10_06(getTableFormObj(label_YN10_06,"1_1_1" ));
	obj_YN11_01(getTableFormObj(label_YN11_01,"1_1_1" ));
	obj_YN11_03(getTableFormObj(label_YN11_03,"1_1_1" ));
	obj_YN12_01(getTableFormObj(label_YN12_01,"1_1_1" ));
	obj_YN08_03(getTableFormObj(label_YN08_03,"1_1_1" ));
	obj_YN13_01(getTableFormObj(label_YN13_01,"1_1" ));
	obj_YN14_02(getTableFormObj(label_YN14_02,"1_1_1" ));
	obj_YN14_04(getTableFormObj(label_YN14_04,"1_1_1" ));
	obj_YN15_01(getTableFormObj(label_YN15_01,"1_1_1" ));
	obj_YN15_03(getTableFormObj(label_YN15_03,"1_1_1" ));
	obj_YN16_01(getTableFormObj(label_YN16_01,"1_1_1" ));
	obj_YN17_01(getTableFormObj(label_YN17_01,"1_1_1" ));
	obj_YN18_01(getTableFormObj(label_YN18_01,"1_1_1" ));
	obj_YN13_09(getTableFormObj(label_YN13_09,"1_1" ));
	if(getTableFormObj(label_YN01_01,"1_1_1" ).value != "����ϵͳ")
	setobj_YN18_11(getTableFormObj(label_YN18_11,"1_1_1" ));
	 obj_YN13_05(getTableFormObj(label_YN13_05,"1_1"));
}
/**
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
var YN02_011=function(){
	columnVallueRadio(this);
	obj_YN02_011(this);
};
var YN03_02=function(){
	columnVallueRadio(this);
	obj_YN03_02(this);
};
var YN05_01=function(){
	columnVallueRadio(this);
	obj_YN05_01(this);
};
var YN09_01=function(){
	columnVallueRadio(this);
	obj_YN09_01(this);
};
var YN09_04=function(){
	columnVallueRadio(this);
	obj_YN09_04(this);
};
var YN09_07=function(){
	columnVallueRadio(this);
	obj_YN09_07(this);
};
var YN10_02=function(){
	columnVallueRadio(this);
	obj_YN10_02(this);
};
var YN10_06=function(){
	columnVallueRadio(this);
	obj_YN10_06(this);
};
var YN11_01=function(){
	columnVallueRadio(this);
	obj_YN11_01(this);
};
var YN11_03=function(){
	columnVallueRadio(this);
	obj_YN11_03(this);
};
var YN12_01=function(){
	columnVallueRadio(this);
	obj_YN12_01(this);
};
var YN08_03=function(){
	columnVallueRadio(this);
	obj_YN08_03(this);
};
var YN13_01=function(){
	columnVallueRadio(this);
	obj_YN13_01(this);
};
var YN14_02=function(){
	columnVallueRadio(this);
	obj_YN14_02(this);
};
var YN14_04=function(){
	columnVallueRadio(this);
	obj_YN14_04(this);
};
var YN15_01=function(){
	columnVallueRadio(this);
	obj_YN15_01(this);
};
var YN15_03=function(){
	columnVallueRadio(this);
	obj_YN15_03(this);
};
var YN16_01=function(){
	columnVallueRadio(this);
	obj_YN16_01(this);
};
var YN17_01=function(){
	columnVallueRadio(this);
	obj_YN17_01(this);
};
var YN17_06=function(){
	columnVallueRadio(this);
//	obj_YN17_06(this);
};

var YN18_01=function(){
	columnVallueRadio(this);
	obj_YN18_01(this);
};
var YN13_09=function(){
	columnVallueRadio(this);
	obj_YN13_09(this);
};
var YN13_05=function(){
	columnVallueRadio(this);
	obj_YN13_05(this);
};


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ�������;
*/
function obj_YN02_01(obj) {
	//alert(getTableFormObj(label_YN01_01,"1_1_1").value);
	var obj_item1 = getTableFormObj(label_header_item1,"1").value;
	var obj_item2 = getTableFormObj(label_header_item2,"1").value;
	var obj_item3 = getTableFormObj(label_header_item3,"1").value;
	var obj_item4 = getTableFormObj(label_header_item4,"1").value;
	var obj_item5 = getTableFormObj(label_header_item5,"1").value;
	var obj_isempty = getTableFormCheckBox(label_isempty,"1" )[0].checked;
	if (getTableFormObj(label_YN01_01,"1_1_1").value == "����ϵͳ") {
		// ֻ��
		onlyRead(true);
	} else {
		onlyRead(false);
		getTableFormObj(label_YN09_05,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN09_05,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN09_08,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN09_08,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN10_05,"1_1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN10_05,"1_1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN14_03,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN14_03,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN17_08,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN17_08,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN17_09,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN17_09,"1_1_1" ).readOnly = "readonly";

		 columnVallueRadio3(getTableFormObj(label_YN02_01,"1_1_1" ),YN02_011);
		 columnVallueRadio3(getTableFormObj(label_YN03_02,"1_1_1" ),YN03_02);
		 columnVallueRadio3(getTableFormObj(label_YN05_01,"1_1_1" ),YN05_01);
		 columnVallueRadio3(getTableFormObj(label_YN09_01,"1_1_1" ),YN09_01);
		 columnVallueRadio3(getTableFormObj(label_YN09_04,"1_1_1" ),YN09_04);
		 columnVallueRadio3(getTableFormObj(label_YN09_07,"1_1_1" ),YN09_07);
		 columnVallueRadio3(getTableFormObj(label_YN10_02,"1_1_1" ),YN10_02);
		 columnVallueRadio3(getTableFormObj(label_YN10_06,"1_1_1" ),YN10_06);
		 columnVallueRadio3(getTableFormObj(label_YN11_01,"1_1_1" ),YN11_01);
		 columnVallueRadio3(getTableFormObj(label_YN11_03,"1_1_1" ),YN11_03);
		 columnVallueRadio3(getTableFormObj(label_YN12_01,"1_1_1" ),YN12_01);
		 columnVallueRadio3(getTableFormObj(label_YN08_03,"1_1_1" ),YN08_03);
		 columnVallueRadio3(getTableFormObj(label_YN13_01,"1_1" ),YN13_01);
		 columnVallueRadio3(getTableFormObj(label_YN14_02,"1_1_1" ),YN14_02);
		 columnVallueRadio3(getTableFormObj(label_YN14_04,"1_1_1" ),YN14_04);
		 columnVallueRadio3(getTableFormObj(label_YN15_01,"1_1_1" ),YN15_01);
		 columnVallueRadio3(getTableFormObj(label_YN15_03,"1_1_1" ),YN15_03);
		 columnVallueRadio3(getTableFormObj(label_YN16_01,"1_1_1" ),YN16_01);
		 columnVallueRadio3(getTableFormObj(label_YN17_01,"1_1_1" ),YN17_01);
		 columnVallueRadio3(getTableFormObj(label_YN17_06,"1_1_1" ),YN17_06);
		 columnVallueRadio3(getTableFormObj(label_YN18_01,"1_1_1" ),YN18_01);
		 columnVallueRadio3(getTableFormObj(label_YN13_09,"1_1" ),YN13_09);
		 columnVallueRadio3(getTableFormObj(label_YN13_05,"1_1" ),YN13_05);
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
	getTableFormCheckBox(label_isempty,"1" )[0].disabled=false;
	getTableFormCheckBox(label_isempty,"1" )[0].checked = obj_isempty;
	if(obj_isempty)getTableFormObjs(label_isempty)[0].value = "���Ϳձ�";
	disableTableCheckBox1(getTableFormCheckBox(label_YN18_11,"1_1_1" ));
	columnVallueRadio2(getTableFormObj(label_YN01_01,"1_1_1"),"obj_YN02_01(this);");
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
								obj_YN02_01(this);
							};	
						}else{
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								obj_YN02_01(this);
							};
						}
					}
				}
		}
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#���׷��յȼ�����#�Ƿ񻮷�
*/
function obj_YN02_011(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormCheckBox(label_YN02_02,obj_YN02_01.rownumber );
	var obj_YN02_03 = getTableFormCheckBox(label_YN02_03,obj_YN02_01.rownumber );
	if (obj_YN02_01.value == "��") {
		// ֻ��
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		// ���
		disableTableCheckBox(obj_YN02_02,true);
		disableTableCheckBox(obj_YN02_03,true);
	} else if (obj_YN02_01.value == "��") {
		// ��ԭ
		/*obj_YN02_02.onclick = "";
		obj_YN02_03.onclick = "";*/
		disableTableCheckBox(obj_YN02_02,false);
		disableTableCheckBox(obj_YN02_03,false);

	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#��ȫ����#������Ƿ�ʵʩ�ֻ�����ϵͳ��ȫ����
*/
function obj_YN03_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_02.rownumber );
	if (obj_YN03_02.value == "��") {
		// ֻ��
	
		// ���
		columnVallueRadio1(obj_YN03_03,false);
		obj_YN03_04.value="";
		obj_YN03_04.readOnly="readonly";
	} else if (obj_YN03_02.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN03_03,true);
		obj_YN03_04.readOnly="";
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���ȫ����#����#��ȫ���#�Ƿ��ѽ������ֻ�����ϵͳ��ȫ��ƻ���
*/
function obj_YN05_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormCheckBox(label_YN05_02,obj_YN05_01.rownumber );
	if (obj_YN05_01.value == "��") {
		// ֻ��
		obj_YN05_02.onclick = "";
		// ���
		disableTableCheckBox(obj_YN05_02,true);
	} else if (obj_YN05_01.value== "��") {
		// ��ԭ
		obj_YN05_02.onclick = "";
		disableTableCheckBox(obj_YN05_02,false);
	}

}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�ֻ�����ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ��
*/
function obj_YN08_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08_03.rownumber );
	if (obj_YN08_03.value == "��") {
		// ֻ��
		// ���
		obj_YN08_04.value="";
		obj_YN08_04.readOnly="readonly";
	} else if (obj_YN08_03.value == "��") {
		// ��ԭ
		obj_YN08_04.readOnly = "";
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤
*/
function obj_YN09_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_01 = getTableFormObjs(label_YN09_01)[0];
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09_01.rownumber );
	if (obj_YN09_01.value == "��") {
		// ֻ��
		// ���
		obj_YN09_02.value="";
		obj_YN09_02.readOnly="readonly";
	} else if (obj_YN09_01.value == "��") {
		// ��ԭ
		obj_YN09_02.readOnly = "";
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤
*/
function obj_YN09_04(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_04 = getTableFormObjs(label_YN09_04)[0];
	var obj_YN09_05 = getTableFormObj(label_YN09_05,obj_YN09_04.rownumber);
	if (obj_YN09_04.value == "��") {
		// ֻ��
		// ���
		obj_YN09_05.value = "";
		obj_YN09_05.onclick = "";
	} else if (obj_YN09_04.value== "��") {
		// ��ԭ
		obj_YN09_05.onclick = click_columnValueNumber;
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������
*/
function obj_YN09_07(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_07 = getTableFormObjs(label_YN09_07)[0];
	var obj_YN09_08 = getTableFormObj(label_YN09_08,obj_YN09_07.rownumber );
	if (obj_YN09_07.value == "��") {
		// ֻ��
		// ���
		obj_YN09_08.value = "";
		obj_YN09_08.onclick = "";
	} else if (obj_YN09_07.value== "��") {
		// ��ԭ
		obj_YN09_08.onclick = click_columnValueNumber;
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ
*/
function obj_YN10_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10_02 = getTableFormObjs(label_YN10_02)[0];
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10_02.rownumber+"_1" );
	var obj_YN10_04 = getTableFormObj(label_YN10_04,obj_YN10_02.rownumber+"_1" );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10_02.rownumber+"_1" );

	if (obj_YN10_02.value == "��") {
		// ֻ��
		// ���
		obj_YN10_03.value="";
		obj_YN10_03.readOnly="readonly";
		obj_YN10_04.value="";
		obj_YN10_04.readOnly="readonly";
		obj_YN10_05.value = "";
		obj_YN10_05.onclick = "";
	} else if (obj_YN10_02.value == "��") {
		// ��ԭ
		obj_YN10_03.readOnly="";
		obj_YN10_04.readOnly="";
		obj_YN10_05.onclick = click_columnValueNumber;
	}

}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢
*/
function obj_YN10_06(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10_06 = getTableFormObjs(label_YN10_06)[0];
	var obj_YN10_07 = getTableFormObj(label_YN10_07,obj_YN10_06.rownumber );

	if (obj_YN10_06.value == "��") {
		// ֻ��
		// ���
		obj_YN10_07.value="";
		obj_YN10_07.readOnly="readonly";
	} else if (obj_YN10_06.value == "��") {
		// ��ԭ
		obj_YN10_07.readOnly="";
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ
*/
function obj_YN11_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObj(label_YN11_02,obj_YN11_01.rownumber);

	if (obj_YN11_01.value == "��") {
		// ֻ��
		// ���
		obj_YN11_02.value="";
		obj_YN11_02.readOnly="readonly";
	} else if (obj_YN11_01.value == "��") {
		// ��ԭ
		obj_YN11_02.readOnly="";
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ
*/
function obj_YN11_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	var obj_YN11_04 = getTableFormObj(label_YN11_04,obj_YN11_03.rownumber );

	if (obj_YN11_03.value == "��") {
		// ֻ��
		// ���
		obj_YN11_04.value="";
		obj_YN11_04.readOnly="readonly";
	} else if (obj_YN11_03.value == "��") {
		// ��ԭ
		obj_YN11_04.readOnly="";
	}

}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã����ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ
*/
function obj_YN12_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObj(label_YN12_02,obj_YN12_01.rownumber );
	if (obj_YN12_01.value == "��") {
		// ֻ��
		// ���
		obj_YN12_02.value="";
		obj_YN12_02.readOnly="readonly";
	} else if (obj_YN12_01.value == "��") {
		// ��ԭ
		obj_YN12_02.readOnly="";
	}

}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�ֻ�����ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���
*/
function obj_YN13_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN13_01 = getTableFormObjs(label_YN13_01)[0];
	var obj_YN13_02 = getTableFormObj(label_YN13_02,obj_YN13_01.rownumber );
	if (obj_YN13_01.value == "��") {
		// ֻ��
		// ���
		obj_YN13_02.value="";
		obj_YN13_02.readOnly="readonly";
	} else if (obj_YN13_01.value == "��") {
		// ��ԭ
		obj_YN13_02.readOnly="";
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ���
*/
function obj_YN13_03(obj) {
	var obj_YN13_03 = getTableFormObjs(label_YN13_03)[0];
	var obj_YN13_04 = getTableFormObj(label_YN13_04,"1_1");
	if (obj_YN13_03.value == "��") {
		// ֻ��
		// ���
		obj_YN13_04.value="";
		obj_YN13_04.readOnly="readonly";
	} else if (obj_YN13_03.value == "��") {
		// ��ԭ
		obj_YN13_04.readOnly="";
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ�ֻ�����ϵͳ��͸�Բ���
*/
function obj_YN13_05(obj) {
	var obj_YN13_05 = getTableFormObjs(label_YN13_05)[0];
	var obj_YN13_06 = getTableFormObj(label_YN13_06,"1_1" );
	if (obj_YN13_05.value == "��") {
		// ֻ��
		// ���
		obj_YN13_06.value="";
		obj_YN13_06.readOnly="readonly";
	} else if (obj_YN13_05.value == "��") {
		// ��ԭ
		obj_YN13_06.readOnly="";
	}

}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���
*/
function obj_YN13_09(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN13_09 = getTableFormObjs(label_YN13_09)[0];
	var obj_YN13_10 = getTableFormObj(label_YN13_10,obj_YN13_09.rownumber );
	if (obj_YN13_09.value == "��") {
		// ֻ��
		// ���
		obj_YN13_10.value="";
		obj_YN13_10.readOnly="readonly";
	} else if (obj_YN13_09.value == "��") {
		// ��ԭ
		obj_YN13_10.readOnly="";
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���
*/
function obj_YN14_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN14_02 = getTableFormObjs(label_YN14_02)[0];
	var obj_YN14_03 = getTableFormObj(label_YN14_03,obj_YN14_02.rownumber );
	if (obj_YN14_02.value == "��") {
		// ֻ��
		// ���
		obj_YN14_03.value = "";
		obj_YN14_03.onclick = "";
	} else if (obj_YN14_02.value == "��") {
		// ��ԭ
		obj_YN14_03.onclick = click_columnValueNumber;
	}

}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#��̬����#�Ƿ�߱������뱩���½����
*/
function obj_YN14_04(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN14_04 = getTableFormObjs(label_YN14_04)[0];
	var obj_YN14_05 = getTableFormObj(label_YN14_05,obj_YN14_04.rownumber );
	if (obj_YN14_04.value == "��") {
		// ֻ��
		// ���
		obj_YN14_05.value="";
		obj_YN14_05.readOnly="readonly";
	} else if (obj_YN14_04.value== "��") {
		// ��ԭ
		obj_YN14_05.readOnly="";
	}

}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#�ֻ�������֤#�Ƿ������ֻ�������֤����
*/
function obj_YN15_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN15_01 = getTableFormObjs(label_YN15_01)[0];
	var obj_YN15_02 = getTableFormObj(label_YN15_02,obj_YN15_01.rownumber );
	if (obj_YN15_01.value == "��") {
		// ֻ��
		// ���
		obj_YN15_02.value="";
		obj_YN15_02.readOnly="readonly";
	} else if (obj_YN15_01.value == "��") {
		// ��ԭ
		obj_YN15_02.readOnly="";
	}

}
/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#�ֻ�������֤#�Ƿ��ȡ�ֻ������α��ʩ
*/
function obj_YN15_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN15_03 = getTableFormObjs(label_YN15_03)[0];
	var obj_YN15_04 = getTableFormObj(label_YN15_04,obj_YN15_03.rownumber );
	if (obj_YN15_03.value == "��") {
		// ֻ��
		// ���
		obj_YN15_04.value="";
		obj_YN15_04.readOnly="readonly";
	} else if (obj_YN15_03.value == "��") {
		// ��ԭ
		obj_YN15_04.readOnly="";
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#OTP����#�Ƿ�֧��
*/
function obj_YN16_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN16_01 = getTableFormObjs(label_YN16_01)[0];
	var obj_YN16_02 = getTableFormObj(label_YN16_02,obj_YN16_01.rownumber );
	var obj_YN16_03 = getTableFormObj(label_YN16_03,obj_YN16_01.rownumber );
	var obj_YN16_04 = getTableFormObj(label_YN16_04,obj_YN16_01.rownumber );
	var obj_YN16_05 = getTableFormObj(label_YN16_05,obj_YN16_01.rownumber );
	if (obj_YN16_01.value == "��") {
		// ֻ��
		// ���
		columnVallueRadio1(obj_YN16_02,false);
		columnVallueRadio1(obj_YN16_03,false);
		columnVallueRadio1(obj_YN16_04,false);
		columnVallueRadio1(obj_YN16_05,false);
	} else if (obj_YN16_01.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN16_02,true);
		columnVallueRadio1(obj_YN16_03,true);
		columnVallueRadio1(obj_YN16_04,true);
		columnVallueRadio1(obj_YN16_05,true);
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#��̬���#�Ƿ�֧��
*/
function obj_YN17_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN17_01 = getTableFormObjs(label_YN17_01)[0];
	var obj_YN17_02 = getTableFormObj(label_YN17_02,obj_YN17_01.rownumber );
	var obj_YN17_03 = getTableFormObj(label_YN17_03,obj_YN17_01.rownumber );
	var obj_YN17_04 = getTableFormObj(label_YN17_04,obj_YN17_01.rownumber );
	var obj_YN17_05 = getTableFormObj(label_YN17_05,obj_YN17_01.rownumber );
	var obj_YN17_06 = getTableFormObj(label_YN17_06,obj_YN17_01.rownumber );
	var obj_YN17_07 = getTableFormObj(label_YN17_07,obj_YN17_01.rownumber );
	var obj_YN17_08 = getTableFormObj(label_YN17_08,obj_YN17_01.rownumber );
	var obj_YN17_09 = getTableFormObj(label_YN17_09,obj_YN17_01.rownumber );
	var obj_YN17_10 = getTableFormObj(label_YN17_10,obj_YN17_01.rownumber );
	if (obj_YN17_01.value == "��") {
		// ֻ��   ���
		columnVallueRadio1(obj_YN17_02,false);
		columnVallueRadio1(obj_YN17_03,false);
		columnVallueRadio1(obj_YN17_04,false);
		columnVallueRadio1(obj_YN17_05,false);
		columnVallueRadio1(obj_YN17_06,false);
		columnVallueRadio1(obj_YN17_07,false);
		obj_YN17_08.value = "";
		obj_YN17_08.onclick = "";
		obj_YN17_08.setAttribute("readOnly",true);
		obj_YN17_09.value = "";
		obj_YN17_09.onclick = "";
		obj_YN17_09.setAttribute("readOnly",true);
		columnVallueRadio1(obj_YN17_10,false);

	} else if (obj_YN17_01.value == "��") {
		// ��ԭ
		columnVallueRadio1(obj_YN17_02,true);
		columnVallueRadio1(obj_YN17_03,true);
		columnVallueRadio1(obj_YN17_04,true);
		columnVallueRadio1(obj_YN17_05,true);
		columnVallueRadio1(obj_YN17_06,true);
		columnVallueRadio3(obj_YN17_07,YN17_06);
	//	columnVallueRadio1(obj_YN17_07,true);
		obj_YN17_08.onclick = click_columnValueNumber;
		obj_YN17_09.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN17_10,true);
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã������֤#����#����#�Ƿ����������֤��ʽ
*/
function obj_YN18_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN18_01 =getTableFormObj(label_YN18_01,"1_1_1" );
	var obj_YN18_02 = getTableFormObj(label_YN18_02,obj_YN18_01.rownumber );
	if (obj_YN18_01.value == "��") {
		// ֻ��  ���
		obj_YN18_02.value="";
		obj_YN18_02.readOnly="readonly";
	} else if (obj_YN18_01.value  == "��") {
		// ��ԭ
		obj_YN18_02.readOnly="";
	}
}


/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if (!checkEmptyReport()) {
		return true;
	}

	if(getTableFormObjs("��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ�������")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#�ֻ�����ϵͳ��״#ϵͳ�������")[0].parentElement);
		a +="��ȫ����-ϵͳ�����������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("��ȫ����#����#���׷��յȼ�����#�Ƿ񻮷�")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#���׷��յȼ�����#�Ƿ񻮷�")[0].parentElement);
		a +="��ȫ����-���׷��յȼ����ֲ���Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs(label_YN03_01)[0].value == ""){
		errorObjs.push(getTableFormObjs(label_YN03_01)[0].parentElement);
		a +="��ȫ����-�ֻ�����ϵͳ��ȫ�ڲ�������Ҫʵʩ���ţ���֯��������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("��ȫ����#����#��ȫ����#������Ƿ�ʵʩ�ֻ�����ϵͳ��ȫ����")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#��ȫ����#������Ƿ�ʵʩ�ֻ�����ϵͳ��ȫ����")[0].parentElement);
		a +="��ȫ����-�ֻ����а�ȫ��������Ϊ�գ�\n";
		isValid = false;
	}	
	if(getTableFormObjs("��ȫ����#����#Ӧ������#�Ƿ�����ֻ�����ϵͳ������Ӧ���������")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#Ӧ������#�Ƿ�����ֻ�����ϵͳ������Ӧ���������")[0].parentElement);
		a +="��ȫ����-�Ƿ�����ֻ�����ϵͳ������Ӧ���������:����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("��ȫ����#����#Ӧ������#Ӧ���ƻ��Ƿ�������")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#Ӧ������#Ӧ���ƻ��Ƿ�������")[0].parentElement);
		a +="��ȫ����-Ӧ���ƻ��Ƿ�������������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("��ȫ����#����#��ȫ���#�Ƿ��ѽ������ֻ�����ϵͳ��ȫ��ƻ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#��ȫ���#�Ƿ��ѽ������ֻ�����ϵͳ��ȫ��ƻ���")[0].parentElement);
		a +="��ȫ����-�Ƿ��ѽ������ֻ�����ϵͳ��ȫ��ƻ��ƣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("��ȫ����#����#��ȫ���Ʒ���#�Ƿ�����ֻ����а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("��ȫ����#����#��ȫ���Ʒ���#�Ƿ�����ֻ����а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���")[0].parentElement);
		a +="�ͻ���ȫ����-�Ƿ�����ֻ����а�ȫǰ�ؼ����ͷ������ƽ��и��ٺͷ���:����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#�ֻ����з���Э�����Ƿ������ȫ������ʾ����")[0].value == ""){
		errorObjs.push(getTableFormObjs("�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#�ֻ����з���Э�����Ƿ������ȫ������ʾ����")[0].parentElement);
		a +="�ͻ���ȫ����-�ֻ����з���Э�����Ƿ������ȫ������ʾ���ݣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#ͨ����������������ǿ�ͻ�����")[0].value == ""){
		errorObjs.push(getTableFormObjs("�ͻ���ȫ����#����#�ͻ�������ʶ��ǿ#ͨ����������������ǿ�ͻ�����")[0].parentElement);
		a +="�ͻ���ȫ����-ͨ����������������ǿ�ͻ������� ����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������DMZ��֮��ĸ����ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#��������DMZ��֮��ĸ����ʩ")[0].parentElement);
		a +="ͨѶ��ȫ-��������DMZ��֮��ĸ����ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#DMZ��������֮��ĸ����ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#DMZ��������֮��ĸ����ʩ")[0].parentElement);
		a +="ͨѶ��ȫ-DMZ��������֮��ĸ����ʩ�� ����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�ֻ�����ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ��")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�ֻ�����ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ��")[0].parentElement);
		a +="ͨѶ��ȫ-�ֻ�����ϵͳ������ҵ��ϵͳ֮���Ƿ��ȡ��:����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ��")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#���簲ȫ���ƴ�ʩ#�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ��")[0].parentElement);
		a +="ͨѶ��ȫ-�Ƿ���ò�ͬ������Ӫ�̵���·���໥�����һ���Ӱ�죺����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ���֮���Ƿ�˫����֤")[0].parentElement);
		a +="ͨѶ��ȫ-����������ͻ���֮���Ƿ�˫����֤������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����в��õ�WAPЭ��汾")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����в��õ�WAPЭ��汾")[0]);
		a +="ͨѶ��ȫ-�ֻ����в��õ�WAPЭ��汾������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤")[0].parentElement);
		a +="ͨѶ��ȫ-����������ͻ��˼�Ự�Ƿ��ȡ���г�ʱ���ƣ��Ự��ʱ��˫����������֤������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����з�����֤��䷢����Ϊ")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�ֻ����з�����֤��䷢����Ϊ")[0].parentElement);
		a +="ͨѶ��ȫ-�ֻ����з�����֤��䷢����Ϊ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������")[0].value == ""){
		errorObjs.push(getTableFormObjs("ͨѶ��ȫ#����#�Ự��ȫ�����ʩ#�Ƿ�߱�������¼ʧ����������")[0].parentElement);
		a +="ͨѶ��ȫ-�Ƿ�߱�������¼ʧ���������ƣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�Ƿ��ƶ��ֻ�������Կ�����ƶȣ�����Կ�������ڽ���ȫ�����")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�Ƿ��ƶ��ֻ�������Կ�����ƶȣ�����Կ�������ڽ���ȫ�����")[0].parentElement);
		a +="���ݰ�ȫ-�Ƿ��ƶ��ֻ�������Կ�����ƶȣ�����Կ�������ڽ���ȫ���������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ")[0].parentElement);
		a +="���ݰ�ȫ-�ͻ������������˼䴫������������Ƿ��ȡ���ܴ�ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#�Ƿ���������ݽ��м��ܴ洢")[0].parentElement);
		a +="���ݰ�ȫ-�Ƿ���������ݽ��м��ܴ洢������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#���ݼ���#������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢")[0].parentElement);
		a +="���ݰ�ȫ-������������Կ�Ƿ����Ӳ����ȫģ�飨HSM���洢����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ")[0].parentElement);
		a +="���ݰ�ȫ-�߷��ս������ݵĴ����Ƿ��ȡ�����Ա�����ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#�߷��ս������������Ա�����������#�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ")[0].parentElement);
		a +="���ݰ�ȫ-�߷��ս������ݵĴ����Ƿ��ȡ��������ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ��ȡ�����̼�����ʩ")[0].parentElement);
		a +="���ݰ�ȫ-�ͻ��˳����Ƿ��ȡ�����̼�����ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ�洢�ͻ�������Ϣ")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�ͻ��˳����Ƿ�洢�ͻ�������Ϣ")[0].parentElement);
		a +="���ݰ�ȫ-�ͻ��˳����Ƿ�洢�ͻ�������Ϣ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ���")[0].parentElement);
		a +="���ݰ�ȫ-��ʾ�ͻ�������Ϣʱ���Ƿ�ʵʩ���δ�������Ϊ�գ�\n";
		isValid = false;
	}	
	if(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤")[0].value == ""){
		errorObjs.push(getTableFormObjs("���ݰ�ȫ#����#������Ϣ��й¶#�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤")[0].parentElement);
		a +="���ݰ�ȫ-�����пͻ������޸�ʱ���Ƿ�Ҫ����ж�����֤������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�ֻ�����ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�ֻ�����ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���")[0].parentElement);
		a +="Ӧ��ϵͳ��ȫ-�ֻ�����ϵͳ����ǰ�Ƿ�ʵʩ���밲ȫ���:����Ϊ�գ�\n";
		isValid = false;
	}
	/*if(getTableFormObjs(label_YN13_03)[0].value == ""){
		errorObjs.push(getTableFormObjs(label_YN13_03)[0]);
		a +="Ӧ��ϵͳ��ȫ-�Ƿ�ʹ�ü�⹤��ʵʩ���밲ȫ��⣺����Ϊ�գ�\n";
		isValid = false;
	}*/
	if(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ�ֻ�����ϵͳ��͸�Բ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ��ڻ򲻶��ڿ�չ�ֻ�����ϵͳ��͸�Բ���")[0].parentElement);
		a +="Ӧ��ϵͳ��ȫ-�Ƿ��ڻ򲻶��ڿ�չ�ֻ�����ϵͳ��͸�Բ��ԣ�����Ϊ�գ�\n";
		isValid = false;
	}
	/*if(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ")[0].value == ""){
		errorObjs.push(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ")[0]);
		a +="Ӧ��ϵͳ��ȫ-�Ƿ���ͻ���ʾ��ʷ��¼��Ϣ������Ϊ�գ�\n";
		isValid = false;
	}*/
	if(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ�֧���û���ѯ��¼��¼")[0].value == ""){
		errorObjs.push(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�Ƿ�֧���û���ѯ��¼��¼")[0].parentElement);
		a +="Ӧ��ϵͳ��ȫ-�Ƿ�֧���û���ѯ��¼��¼������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("Ӧ��ϵͳ��ȫ#����#�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ���")[0].parentElement);
		a +="Ӧ��ϵͳ��ȫ-�ͻ��˳����Ƿ񾭹��������������Ի����İ�ȫ��⣺����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#��̬����#�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ����")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#��̬����#�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ����")[0].parentElement);
		a +="�����֤-�״ε�¼ʱ�Ƿ�ǿ�ƿͻ��޸ĳ�ʼ���룺����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#��̬����#��ͨ����̬������֤��������Ƿ���������ʽ���")[0].parentElement);
		a +="�����֤-��ͨ����̬������֤��������Ƿ���������ʽ��ף�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#��̬����#�Ƿ�߱������뱩���½����")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#��̬����#�Ƿ�߱������뱩���½����")[0].parentElement);
		a +="�����֤-�Ƿ�߱������뱩���½���ƣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#�ֻ�������֤#�Ƿ������ֻ�������֤����")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#�ֻ�������֤#�Ƿ������ֻ�������֤����")[0].parentElement);
		a +="�����֤-�Ƿ������ֻ�������֤���ƣ�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#�ֻ�������֤#�Ƿ��ȡ�ֻ������α��ʩ")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#�ֻ�������֤#�Ƿ��ȡ�ֻ������α��ʩ")[0].parentElement);
		a +="�����֤-�Ƿ��ȡ�ֻ������α��ʩ������Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#OTP����#�Ƿ�֧��")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#OTP����#�Ƿ�֧��")[0].parentElement);
		a +="�����֤-�Ƿ�֧�֣�����Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#��̬���#�Ƿ�֧��")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#��̬���#�Ƿ�֧��")[0].parentElement);
		a +="�����֤-��̬������Ƿ�֧�ֲ���Ϊ�գ�\n";
		isValid = false;
	}
	if(getTableFormObjs("�����֤#����#����#�Ƿ����������֤��ʽ")[0].value == ""){
		errorObjs.push(getTableFormObjs("�����֤#����#����#�Ƿ����������֤��ʽ")[0].parentElement);
		a +="�����֤-�Ƿ����������֤��ʽ������Ϊ�գ�\n";
		isValid = false;
	}
	
	if(getTableFormObj(label_YN03_02,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN03_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="��ȫ����-����#��ȫ����-�������Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN09_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ#����-�Ự��ȫ�����ʩ-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09_04,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN09_05,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ#����-�Ự��ȫ�����ʩ-���ӿ��г�ʱ�ر�ʱ��Ϊ����Ϊ��\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN09_07,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN09_08,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-�Ự��ȫ�����ʩ-��¼ʧ�ܴ�������Ϊ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10_02,"1_1_1" ).value=="��"){
		var obj1 = getTableFormObj(label_YN10_03,"1_1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="���ݰ�ȫ-����-���ݼ���-�������Э�����ƣ�����Ϊ��\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN10_04,"1_1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="���ݰ�ȫ-����-���ݼ���-�����㷨���ƣ�����Ϊ��\n";
			isValid = false;
		}var obj3 = getTableFormObj(label_YN10_05,"1_1_1_1" );
		if(obj3.value.trim()==""){
			errorObjs.push(obj3);
			a +="���ݰ�ȫ-����#���ݼ���-��Կ���ȣ�����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10_06,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN10_07,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-���ݼ���-���ܵ������ֶΰ�������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN11_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-�߷��ս������������Ա�����������-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11_03,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN11_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-�߷��ս������������Ա�����������-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN12_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN12_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="���ݰ�ȫ-����-������Ϣ��й¶-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN08_03,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN08_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="ͨѶ��ȫ-����-���簲ȫ���ƴ�ʩ-�����ʩ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13_01,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN13_02,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-��ⲿ�ţ���֯���Ŷӣ����Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN14_02,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN14_03,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-��̬����-�����޶�Ϊ����Ϊ��\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN14_04,"1_1_1" ).value=="��"){
			var obj = getTableFormObj(label_YN14_05,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-��̬����-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN15_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-�ֻ�������֤-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15_03,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN15_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-�ֻ�������֤-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN17_07,"1_1_1" ).value=="��"){
		var obj1 = getTableFormObj(label_YN17_08,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="�����֤-����-��̬���-����������ƵĶ�̬��������ʹ�ô�������Ϊ��\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN17_09,"1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="�����֤-����-��̬���-��̬���ʹ����Ч�ڲ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN18_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN18_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="�����֤-����-����-��ʩ��������Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13_09,"1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN13_10,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="Ӧ��ϵͳ��ȫ-����-�������������Ʋ���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN05_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj.parentElement);
			a +="��ȫ����-����-��ȫ���-��ȫ��Ƹ��Ƿ�Χ����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN02_01,"1_1_1" ).value=="��"){
		var obj = getTableFormObj(label_YN02_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="��ȫ����-����-���׷��յȼ�����-�߷��ս��װ�������Ϊ��\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN02_03,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="��ȫ����-����-���׷��յȼ�����-�ͷ��ս��װ�������Ϊ��\n";
			isValid = false;
		}
	}
	
	if(getTableFormObjs(label_YN16_01)[0].value == "��"){
		var obj2 = getTableFormObjs(label_YN16_02)[0];
		var obj3 = getTableFormObjs(label_YN16_03)[0];
		var obj4 = getTableFormObjs(label_YN16_04)[0];
		var obj5 = getTableFormObjs(label_YN16_05)[0];

		if(obj2.value.trim()==""){
			errorObjs.push(obj2.parentElement);
			a +="�ֻ����� �������֤-��̬����Ƿ�����PIN�뱣�����ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(obj3.value.trim()==""){
			errorObjs.push(obj3.parentElement);
			a +="�ֻ����� �������֤-��̬����Ƿ�߱�PIN�����������������ƣ�������Ϊ��!\n";
			isValid = false;
		}
		if(obj4.value.trim()==""){
			errorObjs.push(obj4.parentElement);
			a +="�ֻ����� �������֤-��̬����ĳ����Ƿ�����6λ��������Ϊ��!\n";
			isValid = false;
		}
		if(obj5.value.trim()==""){
			errorObjs.push(obj5.parentElement);
			a +="�ֻ����� �������֤-PIN�ĳ����Ƿ�����4λ��������Ϊ��!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs(label_YN17_01)[0].value == "��"){

		var obj2 = getTableFormObjs(label_YN17_02)[0];
		var obj3 = getTableFormObjs(label_YN17_03)[0];
		var obj4 = getTableFormObjs(label_YN17_04)[0];
		var obj5 = getTableFormObjs(label_YN17_05)[0];
		var obj6 = getTableFormObjs(label_YN17_06)[0];
		var obj7 = getTableFormObjs(label_YN17_07)[0];
		var obj8 = getTableFormObjs(label_YN17_08)[0];
		var obj9 = getTableFormObjs(label_YN17_09)[0];
		var obj10 = getTableFormObjs(label_YN17_10)[0];
		
		if(obj2.value.trim()==""){
			errorObjs.push(obj2.parentElement);
			a +="�ֻ����� �������֤-��̬����Ƿ�����PIN�뱣�����ƣ�����Ϊ��!\n";
			isValid = false;
		}
		if(obj3.value.trim()==""){
			errorObjs.push(obj3.parentElement);
			a +="�ֻ����� �������֤-��̬����Ƿ�߱�PIN�����������������ƣ�����Ϊ��!\n";
			isValid = false;
		}
		if(obj4.value.trim()==""){
			errorObjs.push(obj4.parentElement);
			a +="�ֻ����� �������֤-��̬����ĳ����Ƿ�����6λ������Ϊ��!\n";
			isValid = false;
		}
		if(obj5.value.trim()==""){
			errorObjs.push(obj5.parentElement);
			a +="�ֻ����� �������֤-PIN�ĳ����Ƿ�����4λ������Ϊ��!\n";
			isValid = false;
		}
		if(obj6.value.trim()==""){
			errorObjs.push(obj6.parentElement);
			a +="�ֻ����� �������֤-�Ƿ�֧�ֻ���������ƵĶ�̬���������Ϊ��!\n";
			isValid = false;
		}
		if(obj7.value.trim()==""){
			errorObjs.push(obj7.parentElement);
			a +="�ֻ����� �������֤-����������ƵĶ�̬����Ƿ����������ս�������꣺����Ϊ��!\n";
			isValid = false;
		}
		if(obj8.value.trim()==""){
			errorObjs.push(obj8);
			a +="�ֻ����� �������֤-����������ƵĶ�̬��������ʹ�ô���������Ϊ��!\n";
			isValid = false;
		}
		if(obj9.value.trim()==""){
			errorObjs.push(obj9);
			a +="�ֻ����� �������֤-��̬���ʹ����Ч��Ϊ������Ϊ��!\n";
			isValid = false;
		}
		if(obj10.value.trim()==""){
			errorObjs.push(obj10.parentElement);
			a +="�ֻ����� �������֤-�Ƿ�ʹ��Ϳ�㸲�ǵȷ��������������Ϊ��!\n";
			isValid = false;
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

var click_columnValueNumber = function() {
	columnValueNumber(this);
};

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
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
	}
}

