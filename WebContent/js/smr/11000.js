/*
 * ����2014 -T-B-1 ��Ϣ�Ƽ����������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN02 = "��Ϣ�Ƽ�����ίԱ��#����#������Ϣ�Ƽ�����ίԱ��";
var label_YN02_01 = "��Ϣ�Ƽ�����ίԱ��#����#��֯����";
var label_YN02_02 = "��Ϣ�Ƽ�����ίԱ��#����#��������";
var label_YN02_03 = "��Ϣ�Ƽ�����ίԱ��#����#������";
var label_YN02_04 = "��Ϣ�Ƽ�����ίԱ��#����#ְ��";
var label_YN02_06 = "��Ϣ�Ƽ�����ίԱ��#����#��Ϣ�Ƽ�����ίԱ��������";
var label_YN02_07 = "��Ϣ�Ƽ�����ίԱ��#����#���У���Ϣ�Ƽ�����ίԱ���з���Ϣ�Ƽ�������Ա��";
var label_YN02_08 = "��Ϣ�Ƽ�����ίԱ��#����#�������Ϣ�Ƽ�����ίԱ��ȫ��������";
var label_YN02_09 = "��Ϣ�Ƽ�����ίԱ��#����#���ƶ���ӡ����Ϣ�Ƽ�����ίԱ�����¹���";	

var label_YN03 = "��ϯ��Ϣ��(CIO)#����#������ϯ��Ϣ��";
var label_YN03_01 = "��ϯ��Ϣ��(CIO)#����#����";
var label_YN03_02 = "��ϯ��Ϣ��(CIO)#����#��ְ��ʼ����";
var label_YN03_03 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ������߼������";
var label_YN03_04 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ�ټ�������ְ��";
var label_YN03_05 = "��ϯ��Ϣ��(CIO)#����#����ְ��";
var label_YN03_06 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ���ڻ����ڲ�ͨ�����淽ʽ��ʽ��ְ��ϯ��Ϣ�ٸ�λ";
var label_YN03_07 = "��ϯ��Ϣ��(CIO)#����#��ϯ��Ϣ�ٻ㱨·��";

var label_YN08 = "��Ϣ�Ƽ�ս�Թ滮#����#���ƶ���ӡ����Ϣ�Ƽ�ս�Թ滮";
var label_YN08_01 = "��Ϣ�Ƽ�ս�Թ滮#����#�����»�����";
var label_YN08_02 = "��Ϣ�Ƽ�ս�Թ滮#����#����ʱ��";
var label_YN08_03 = "��Ϣ�Ƽ�ս�Թ滮#����#��Ϣ�Ƽ�ս�Թ滮����";
var label_YN08_04 = "��Ϣ�Ƽ�ս�Թ滮#����#�滮��";
var label_YN08_05 = "��Ϣ�Ƽ�ս�Թ滮#����#��";
var label_YN08_06 = "��Ϣ�Ƽ�ս�Թ滮#����#����������Ϣ�Ƽ�ս�Թ滮ʵʩЧ��";
var label_YN08_07 = "��Ϣ�Ƽ�ս�Թ滮#����#��������";

var label_item95 = "�ش���Ŀ���#����#������ش���Ŀ�ƻ������";
var label_item105 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��ռ�������Ͷ��ı���";

var label_YN11 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ��";
var label_YN11_01 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#���У�������ʩ����Ͷ��";
var label_YN11_02 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#�����豸�ɹ�Ͷ��";
var label_YN11_03 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#����ɹ�Ͷ��";
var label_YN11_04 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#ϵͳ������ĿͶ��";
var label_YN11_05 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#ϵͳ��ӪͶ��";
var label_YN11_06 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#��Ϣ�Ƽ���ѯͶ��";
var label_YN11_07 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#��Ϣ�Ƽ�������Դ����";
var label_YN11_08 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#����";
var label_YN11_09 = "��Ϣ�Ƽ��ʽ�Ͷ��#����#�������Ϣ�Ƽ�Ͷ�����������";

var label_YN04_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#������Ϣ�Ƽ������ţ���֯��";
var label_YN04_01_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#���ţ���֯������";
var label_YN04_01_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#������";
var label_YN04_01_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#������";
var label_YN04_01_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#ְ��";

var label_YN04_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#������Ϣ�Ƽ���������ţ���֯��";
var label_YN04_02_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#���ţ���֯������";
var label_YN04_02_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#������";
var label_YN04_02_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#������";
var label_YN04_02_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#ְ��";

var label_YN04_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#������Ϣ�Ƽ��������ţ���֯��";
var label_YN04_03_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#���ţ���֯������";
var label_YN04_03_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#������";
var label_YN04_03_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#������";
var label_YN04_03_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#ְ��";

var label_YN04_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#������Ϣ�Ƽ����Բ��ţ���֯��";
var label_YN04_04_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#���ţ���֯������";
var label_YN04_04_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#������";
var label_YN04_04_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#������";
var label_YN04_04_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#ְ��";

var label_YN04_05 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#������Ϣ�Ƽ�����ά�����ţ���֯��";
var label_YN04_05_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#���ţ���֯������";
var label_YN04_05_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#������";
var label_YN04_05_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#������";
var label_YN04_05_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#ְ��";

var label_YN04_06 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#������Ϣ��ȫ�����ţ���֯��";
var label_YN04_06_01 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#���ţ���֯������";
var label_YN04_06_02 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#������";
var label_YN04_06_03 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#������";
var label_YN04_06_04 = "��Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#ְ��";

var label_YN09_01 = "��Ϣ�Ƽ����չ���#����#������ָ��ר�ŵ���Ϣ�Ƽ����չ����ţ���֯��";
var label_YN09_02 = "��Ϣ�Ƽ����չ���#����#���ţ���֯������";
var label_YN09_03 = "��Ϣ�Ƽ����չ���#����#������";
var label_YN09_04 = "��Ϣ�Ƽ����չ���#����#��������Ϣ�Ƽ�����";
var label_YN09_05 = "��Ϣ�Ƽ����չ���#����#��Ϣ�Ƽ����չ����ţ���֯������·��";

var label_YN09_06 = "��Ϣ�Ƽ����չ���#����#����רְ����Ϣ�Ƽ����չ����λ";
var label_YN09_07 = "��Ϣ�Ƽ����չ���#����#��λ����";
var label_YN09_08 = "��Ϣ�Ƽ����չ���#����#רְ��Ϣ�Ƽ����չ�����Ա����";
var label_YN09_09 = "��Ϣ�Ƽ����չ���#����#���о�����Ϣ�Ƽ�����������";
var label_YN09_10 = "��Ϣ�Ƽ����չ���#����#�������չ�����Ա����";
var label_YN09_11= "��Ϣ�Ƽ����չ���#����#��Ϣ�Ƽ����չ����ƶ�����";
var label_YN09_12= "��Ϣ�Ƽ����չ���#����#���������";
var label_YN09_13= "��Ϣ�Ƽ����չ���#����#������޶�";

var label_YN10_01 = "�ڲ����#����#������ָ����Ϣ�Ƽ������ţ���֯��";
var label_YN10_02 = "�ڲ����#����#���ţ���֯������";
var label_YN10_03 = "�ڲ����#����#������";
var label_YN10_04 = "�ڲ����#����#��������Ϣ�Ƽ�����";
var label_YN10_06 = "�ڲ����#����#������Ա����";
var label_YN10_07 = "�ڲ����#����#��Ϣ�Ƽ�רְ������Ա����";
var label_YN10_08 = "�ڲ����#����#���о�����Ϣ�Ƽ�����������";
var label_YN10_09 = "�ڲ����#����#��Ϣ�Ƽ������ţ���֯������·��";
var label_YN10_10 = "�ڲ����#����#��Ϣ�Ƽ�����ƶ�����";
var label_YN10_11 = "�ڲ����#����#���������";
var label_YN10_12 = "�ڲ����#����#������޶�";

var label_YN01_01 = "������ģ#����#���о����֧��������ֹ�˾���Ĺ��Һ͵�������";
var label_YN01_02 = "������ģ#����#���о��ڷ�֧��������ֹ�˾����ʡ����������������ֱϽ�С��ƻ������У�";

var label_YN12_01 = "��Ϣ�Ƽ�������ԴͶ��#����#��ʽԱ����";
var label_YN12_02 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ���ʽԱ����";
var label_YN12_03 = "��Ϣ�Ƽ�������ԴͶ��#����#���У���Ϣ�Ƽ����������ʽԱ������";
var label_YN12_04 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ�������ʽԱ������";
var label_YN12_05 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ�������ʽԱ������";
var label_YN12_06 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ�����ά����ʽԱ������";
var label_YN12_07 = "��Ϣ�Ƽ�������ԴͶ��#����#רְ��Ϣ��ȫ��λ��ʽԱ������";
var label_YN12_08 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ��������ְ��ʽԱ����";
var label_YN12_09 = "��Ϣ�Ƽ�������ԴͶ��#����#��Ϣ�Ƽ��������ְ��ʽԱ����";

var label_YN13_01 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#��Ϣ��ȫ������������֤";
var label_YN13_02 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#��Ϣ�Ƽ����������������֤";
var label_YN13_03 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#��Ϣ�Ƽ���Ŀ�����������������֤";
var label_YN13_04 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#���������������֤";
var label_YN13_05 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#���ݿ������������֤";
var label_YN13_06 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#ҵ�������Թ�����������֤";
var label_YN13_07 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#�����������֤";
var label_YN13_08 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#��������������֤";
var label_YN13_09 = "��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤���#����#��������רҵ�߼����ʵ���Ϣ�Ƽ���ʽԱ������";

/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	
	var obj = 0;
	setYN02Disable(obj);
	setYN03Disable(obj);
	setYN08Disable(obj);
	setYN04_01Disable(obj);
	setYN04_02Disable(obj);
	setYN04_03Disable(obj);
	setYN04_04Disable(obj);
	setYN04_05Disable(obj);
	setYN04_06Disable(obj);
	setYN09Disable(obj);
	setYN09_childDisable(obj);
	setYN10Disable(obj);
}
//���ֿؼ�0
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("�밴�淶��д"+errorMessage+"����ֵ����С��0\n");
	}
}

function checkData() {
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//������ģ��֤
	var obj_YN_01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN_01_02 = getTableFormObjs(label_YN01_02)[0];
	if(parseInt(obj_YN_01_01.value)> 36)
	{
		errorObjs.push(obj_YN_01_01);
		a+="���о��ڷ�֧��������ֹ�˾����ʡ���������������ܴ���36��\n";
		isValid=false;
	}
	if(parseInt(obj_YN_01_02.value)> 36)
	{
		errorObjs.push(obj_YN_01_02);
		a+="���о��ڷ�֧��������ֹ�˾����ʡ���������������ܴ���36��\n";
		isValid=false;
	}
	//��Ϣ�Ƽ�����ίԱ����֤
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02.rownumber );
	var obj_YN02_07 = getTableFormObj(label_YN02_07,obj_YN02.rownumber );
	var obj_YN02_08= getTableFormObj(label_YN02_08,obj_YN02.rownumber );
	if(obj_YN02.value.trim() == "��"){
		if(obj_YN02_06.value.trim() == "")
		{
			errorObjs.push(obj_YN02_06);
			a+="��Ϣ�Ƽ�����ίԱ������������Ϊ�գ�\n";
			isValid=false;
		}
		
		if(obj_YN02_07.value.trim() == "")
		{
			errorObjs.push(obj_YN02_07);
			a+="��Ϣ�Ƽ�����ίԱ���з���Ϣ�Ƽ�������Ա������Ϊ�գ�\n";
			isValid=false;
		}
		
		if(parseInt(obj_YN02_07.value) > parseInt(obj_YN02_06.value))
		{
			errorObjs.push(obj_YN02_07);
			a+="��Ϣ�Ƽ�����ίԱ���з���Ϣ�Ƽ�������Ա�����ܴ�����Ϣ�Ƽ�����ίԱ����������\n";
			isValid=false;
		}
	
		if(obj_YN02_08.value.trim() == "")
		{
			errorObjs.push(obj_YN02_08);
			a+="�������Ϣ�Ƽ�����ίԱ��ȫ������������Ϊ�գ�\n";
			isValid=false;
		}
	}
	//��ϯ��Ϣ��(CIO)��֤
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03.rownumber );
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03.rownumber );
    if(obj_YN03.value.trim() == "��")
	{
		if(obj_YN03_03.value.trim() == "")
		{
			errorObjs.push(obj_YN03_03);
			a+="��ϯ��Ϣ���Ƿ�����߼�����Ա����Ϊ�գ�\n";
			isValid=false;
		}
		
		if(obj_YN03_04.value.trim() == "")
		{
			errorObjs.push(obj_YN03_04);
			a+="��ϯ��Ϣ���Ƿ��������ְ����Ϊ�գ�\n";
			isValid=false;
		}
	
		if(obj_YN03_06.value.trim() == "")
		{
			errorObjs.push(obj_YN03_06);
			a+="��ϯ��Ϣ���ڻ����ڲ��Ƿ�ͨ�����淽ʽ��ʽ��ְ����Ϊ�գ�\n";
			isValid=false;
		}
	}
	//��Ϣ�Ƽ�ս�Թ滮��֤
    var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "��") {
		if(obj_YN08_04.value.trim() != "" && obj_YN08_05.value.trim() != "")
		{
			if(parseInt(obj_YN08_04.value) > parseInt(obj_YN08_05.value) )
			{
				errorObjs.push(obj_YN08_04);
				errorObjs.push(obj_YN08_05);
				a+="�滮����ʼ��ݲ��ܴ��ڽ�����ݣ�\n";
				isValid=false;
			}
		}
	}
	//��Ϣ�Ƽ��ʽ�Ͷ����֤
	var obj_YN11 = getTableFormObjs(label_YN11)[0];
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObjs(label_YN11_02)[0];
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	var obj_YN11_04 = getTableFormObjs(label_YN11_04)[0];
	var obj_YN11_05 = getTableFormObjs(label_YN11_05)[0];
	var obj_YN11_06 = getTableFormObjs(label_YN11_06)[0];
	var obj_YN11_07 = getTableFormObjs(label_YN11_07)[0];
	var obj_YN11_08 = getTableFormObjs(label_YN11_08)[0];
	var obj_YN11_09 = getTableFormObjs(label_YN11_09)[0];
	if(parseInt(obj_YN11_01.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_01);
		a+="������ʩ����Ͷ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_02.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_02);
		a+="�����豸�ɹ�Ͷ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_03.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_03);
		a+="����ɹ�Ͷ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_04.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_04);
		a+="ϵͳ������ĿͶ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_05.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_05);
		a+="ϵͳ��ӪͶ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_06.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_06);
		a+="��Ϣ�Ƽ���ѯͶ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_07.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_07);
		a+="��Ϣ�Ƽ�������Դ���ò��ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_08.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_08);
		a+="����Ͷ�벻�ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_09.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_09);
		a+="�������Ϣ�Ƽ�Ͷ����������ò��ܴ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		isValid=false;	
	}
	
	var sumTR = 0;
	sumTR += parseFloat(obj_YN11_01.value);
	sumTR += parseFloat(obj_YN11_02.value);
	sumTR += parseFloat(obj_YN11_03.value);
	sumTR += parseFloat(obj_YN11_04.value);
	sumTR += parseFloat(obj_YN11_05.value);
	sumTR += parseFloat(obj_YN11_06.value);
	sumTR += parseFloat(obj_YN11_07.value);
	sumTR += parseFloat(obj_YN11_08.value);
	
	if(sumTR != parseFloat(obj_YN11.value))
	{
		errorObjs.push(obj_YN11);
		errorObjs.push(obj_YN11_01);
		errorObjs.push(obj_YN11_02);
		errorObjs.push(obj_YN11_03);
		errorObjs.push(obj_YN11_04);
		errorObjs.push(obj_YN11_05);
		errorObjs.push(obj_YN11_06);
		errorObjs.push(obj_YN11_07);
		errorObjs.push(obj_YN11_08);
		a +="���������Ͷ��ķ����ܺ�Ӧ�õ��ڱ������Ϣ�Ƽ�Ͷ�룡\n";
		
		isValid = false;
	}
	//��Ϣ�Ƽ�������ԴͶ��У��
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObjs(label_YN12_02)[0];
	var obj_YN12_03 = getTableFormObjs(label_YN12_03)[0];
	var obj_YN12_04 = getTableFormObjs(label_YN12_04)[0];
	var obj_YN12_05 = getTableFormObjs(label_YN12_05)[0];
	var obj_YN12_06 = getTableFormObjs(label_YN12_06)[0];
	var obj_YN12_07 = getTableFormObjs(label_YN12_07)[0];
	
	if(parseInt(obj_YN12_02.value) > parseInt(obj_YN12_01.value))
	{
		errorObjs.push(obj_YN12_02);
		a +="��Ϣ�Ƽ���ʽԱ�������ܴ�����ʽԱ������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_03.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_03);
		a +="��Ϣ�Ƽ����������ʽԱ�������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_04.value)> parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_04);
		a +="��Ϣ�Ƽ�������ʽԱ�������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_05.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_05);
		a +="��Ϣ�Ƽ�������ʽԱ�������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_06.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_06);
		a +="��Ϣ�Ƽ�����ά����ʽԱ�������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_07.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_07);
		a +="רְ��Ϣ��ȫ��λ��ʽԱ�������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	var sumPep = 0;
	sumPep += parseInt(obj_YN12_03.value);
	sumPep += parseInt(obj_YN12_04.value);
	sumPep += parseInt(obj_YN12_05.value);
	sumPep += parseInt(obj_YN12_06.value);
	sumPep += parseInt(obj_YN12_07.value);
	
	if(sumPep >  parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_02);
		errorObjs.push(obj_YN12_07);
		errorObjs.push(obj_YN12_03);
		errorObjs.push(obj_YN12_04);
		errorObjs.push(obj_YN12_05);
		errorObjs.push(obj_YN12_06);
		a +="������Ϣ�Ƽ�������ʽԱ���������ܴ�����Ϣ�Ƽ���ʽԱ������\n";;
		isValid = false;
	}
	
	//��Ϣ�Ƽ����չ�����֤
	var obj_YN09_10 = getTableFormObjs(label_YN09_10)[0];
	var obj_YN09_06 = getTableFormObjs(label_YN09_06)[0];
	var obj_YN09_11 = getTableFormObjs(label_YN09_11)[0];
	var obj_YN09_12 = getTableFormObjs(label_YN09_12)[0];
	var obj_YN09_13 = getTableFormObjs(label_YN09_13)[0];
	
	if(obj_YN09_10.value.trim() == "")
	{
		errorObjs.push(obj_YN09_10);
		a +="�������չ�����Ա��������Ϊ�գ�\n";;
		isValid = false;
	}
	
	if(obj_YN09_06.value.trim() == "")
	{
		errorObjs.push(obj_YN09_06);
		a +="�Ƿ�����רְ����Ϣ�Ƽ����չ����λ����Ϊ�գ�\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN09_12.value) > parseInt(obj_YN09_11.value))
	{
		errorObjs.push(obj_YN09_12);
		a +="����������ƶ��������ܴ�����Ϣ�Ƽ����չ����ƶ�������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN09_13.value) > parseInt(obj_YN09_11.value))
	{
		errorObjs.push(obj_YN09_13);
		a +="������޶��ƶ��������ܴ�����Ϣ�Ƽ����չ����ƶ�������\n";;
		isValid = false;
	}
	
	//�ڲ����У��
	var obj_YN10_06 = getTableFormObjs(label_YN10_06)[0];
	var obj_YN10_07 = getTableFormObjs(label_YN10_07)[0];
	var obj_YN10_08 = getTableFormObjs(label_YN10_08)[0];
	var obj_YN10_10 = getTableFormObjs(label_YN10_10)[0];
	var obj_YN10_11 = getTableFormObjs(label_YN10_11)[0];
	var obj_YN10_12 = getTableFormObjs(label_YN10_12)[0];
	if(parseInt(obj_YN10_07.value) > parseInt(obj_YN10_06.value))
	{
		errorObjs.push(obj_YN10_07);
		a +="��Ϣ�Ƽ�רְ������Ա�������ܴ���������Ա������\n";;
		isValid = false;
	}
	if(parseInt(obj_YN10_07.value) < parseInt(obj_YN10_08.value))
	{
		errorObjs.push(obj_YN10_08);
		a +="��Ϣ�Ƽ�����������ӦС����Ϣ�Ƽ�רְ������Ա������\n";;
		isValid = false;
	}
	if(parseInt(obj_YN10_11.value) > parseInt(obj_YN10_10.value))
	{
		errorObjs.push(obj_YN10_11);
		a +="����������ƶ��������ܴ�����Ϣ�Ƽ�����ƶ�������\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN10_12.value) > parseInt(obj_YN10_10.value))
	{
		errorObjs.push(obj_YN10_12);
		a +="������޶��ƶ��������ܴ�����Ϣ�Ƽ�����ƶ�������\n";;
		isValid = false;
	}
	
	//��Ϣ�Ƽ���Աרҵ�߼����ʳ�֤�����֤
	var obj_YN13_01 = getTableFormObjs(label_YN13_01)[0];
	var obj_YN13_02 = getTableFormObjs(label_YN13_02)[0];
	var obj_YN13_03 = getTableFormObjs(label_YN13_03)[0];
	var obj_YN13_04 = getTableFormObjs(label_YN13_04)[0];
	var obj_YN13_05 = getTableFormObjs(label_YN13_05)[0];
	var obj_YN13_06 = getTableFormObjs(label_YN13_06)[0];
	var obj_YN13_07 = getTableFormObjs(label_YN13_07)[0];
	var obj_YN13_08 = getTableFormObjs(label_YN13_08)[0];
	var obj_YN13_09 = getTableFormObjs(label_YN13_09)[0];
	var sumZZ = 0;
	sumZZ += parseInt(obj_YN13_01.value);
	sumZZ += parseInt(obj_YN13_02.value);
	sumZZ += parseInt(obj_YN13_03.value);
	sumZZ += parseInt(obj_YN13_04.value);
	sumZZ += parseInt(obj_YN13_05.value);
	sumZZ += parseInt(obj_YN13_06.value);
	sumZZ += parseInt(obj_YN13_07.value);
	sumZZ += parseInt(obj_YN13_08.value);
	if(parseInt(obj_YN13_09.value) > sumZZ)
	{
		errorObjs.push(obj_YN13_01);
		errorObjs.push(obj_YN13_02);
		errorObjs.push(obj_YN13_03);
		errorObjs.push(obj_YN13_04);
		errorObjs.push(obj_YN13_05);
		errorObjs.push(obj_YN13_06);
		errorObjs.push(obj_YN13_07);
		errorObjs.push(obj_YN13_08);
		errorObjs.push(obj_YN13_09);
		a +="���������߼�������֤����Ϣ�Ƽ���ʽԱ�������ܴ������г�֤��Ա֮�ͣ�\n";;
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
	return isValid;
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã��ڲ����#����#������ָ����Ϣ�Ƽ������ţ���֯��
 */
function setYN10Disable(objcld){
	var obj_YN10_01 = getTableFormObjs(label_YN10_01)[0];
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10_01.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10_01.rownumber );
	var obj_YN10_04 = getTableFormObj(label_YN10_04,obj_YN10_01.rownumber );
	var obj_YN10_06 = getTableFormObj(label_YN10_06,obj_YN10_01.rownumber );
	var obj_YN10_07 = getTableFormObj(label_YN10_07,obj_YN10_01.rownumber );
	var obj_YN10_08 = getTableFormObj(label_YN10_08,obj_YN10_01.rownumber );
	var obj_YN10_09 = getTableFormObj(label_YN10_09,obj_YN10_01.rownumber );
	var obj_YN10_10 = getTableFormObj(label_YN10_10,obj_YN10_01.rownumber );
	var obj_YN10_11 = getTableFormObj(label_YN10_11,obj_YN10_01.rownumber );
	var obj_YN10_12 = getTableFormObj(label_YN10_12,obj_YN10_01.rownumber );
	if (obj_YN10_01.value.trim() == "��" || obj_YN10_01.value.trim() == "") {
		//ֻ��
		obj_YN10_02.readOnly = "readonly";
		obj_YN10_03.readOnly = "readonly";
		columnVallueRadio1(obj_YN10_04,false,false);
		obj_YN10_04.readOnly = "readonly";
		obj_YN10_06.readOnly = "readonly";
		obj_YN10_07.readOnly = "readonly";
		obj_YN10_08.readOnly = "readonly";
		obj_YN10_09.readOnly = "readonly";
		obj_YN10_10.readOnly = "readonly";
		obj_YN10_11.readOnly = "readonly";
		obj_YN10_12.readOnly = "readonly";
		//���
		obj_YN10_02.value = "";
		obj_YN10_03.value = "";
		obj_YN10_04.value = "";
		obj_YN10_06.value = "";
		obj_YN10_07.value = "";
		obj_YN10_08.value = "";
		obj_YN10_09.value = "";
		obj_YN10_10.value = "";
		obj_YN10_11.value = "";
		obj_YN10_12.value = "";
	}else if (obj_YN10_01.value.trim() == "��"){
		obj_YN10_02.readOnly = "";
		obj_YN10_03.readOnly = "";
		columnVallueRadio1(obj_YN10_04,true,false);
		obj_YN10_04.readOnly = "";
		obj_YN10_06.readOnly = "";
		obj_YN10_07.readOnly = "";
		obj_YN10_08.readOnly = "";
		obj_YN10_09.readOnly = "";
		obj_YN10_10.readOnly = "";
		obj_YN10_11.readOnly = "";
		obj_YN10_12.readOnly = "";
	}
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ����չ���#����#����רְ����Ϣ�Ƽ����չ����λ
 */
function setYN09_childDisable(objcld){
	var obj_YN09_06 = getTableFormObjs(label_YN09_06)[0];
	var obj_YN09_07 =  getTableFormObj(label_YN09_07,obj_YN09_06.rownumber );
	var obj_YN09_08 =  getTableFormObj(label_YN09_08,obj_YN09_06.rownumber );
	var obj_YN09_09 =  getTableFormObj(label_YN09_09,obj_YN09_06.rownumber );
	if (obj_YN09_06.value.trim() == "��" || obj_YN09_06.value.trim() == "") {
		//ֻ��
		obj_YN09_07.readOnly = "readonly";
		obj_YN09_08.readOnly = "readonly";
		obj_YN09_09.readOnly = "readonly";
		//���
		obj_YN09_07.value = "";
		obj_YN09_08.value = "";
		obj_YN09_09.value = "";
	}else if (obj_YN09_06.value.trim() == "��"){
		obj_YN09_07.readOnly = "";
		obj_YN09_08.readOnly = "";
		obj_YN09_09.readOnly = "";
	}
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ����չ���#����#������ָ��ר�ŵ���Ϣ�Ƽ����չ����ţ���֯��
 */
function setYN09Disable(objcld){
	var obj_YN09 = getTableFormObjs(label_YN09_01)[0];
	var obj_YN09_01 =  getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_02 =  getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_03 =  getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_04 =  getTableFormObj(label_YN09_05,obj_YN09.rownumber );
	if (obj_YN09.value.trim() == "��" || obj_YN09.value.trim() == "") {
		//ֻ��
		obj_YN09_01.readOnly = "readonly";
		obj_YN09_02.readOnly = "readonly";
		columnVallueRadio1(obj_YN09_03,false,false);
		obj_YN09_04.readOnly = "readonly";
		//���
		obj_YN09_01.value = "";
		obj_YN09_02.value = "";
		obj_YN09_03.value = "";
		obj_YN09_04.value = "";
	}else if (obj_YN09.value.trim() == "��"){
		obj_YN09_01.readOnly = "";
		obj_YN09_02.readOnly = "";
		columnVallueRadio1(obj_YN09_03,true,false);
		obj_YN09_04.readOnly = "";
	}
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ������ţ���֯��#������Ϣ�Ƽ������ţ���֯��
 */
function setYN04_01Disable(objcld) {
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_01_01 =  getTableFormObj(label_YN04_01_01,obj_YN04_01.rownumber );
	var obj_YN04_01_02 =  getTableFormObj(label_YN04_01_02,obj_YN04_01.rownumber );
	var obj_YN04_01_03 =  getTableFormObj(label_YN04_01_03,obj_YN04_01.rownumber );
	var obj_YN04_01_04 =  getTableFormObj(label_YN04_01_04,obj_YN04_01.rownumber );
	
	if (obj_YN04_01.value.trim() == "��" || obj_YN04_01.value.trim() == "") {
		// ֻ��
		obj_YN04_01_01.readOnly = "readonly";
		obj_YN04_01_02.readOnly = "readonly";
		obj_YN04_01_03.readOnly = "readonly";
		obj_YN04_01_04.readOnly = "readonly";
		// ���
		obj_YN04_01_01.value = "";
		obj_YN04_01_02.value = "";
		obj_YN04_01_03.value = "";
		obj_YN04_01_04.value = "";
		
	}else if (obj_YN04_01.value.trim() == "��"){
		obj_YN04_01_01.readOnly = "";
		obj_YN04_01_02.readOnly = "";
		obj_YN04_01_03.readOnly = "";
		obj_YN04_01_04.readOnly = "";
	}
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ���������ţ���֯��#������Ϣ�Ƽ���������ţ���֯��
 */
function setYN04_02Disable(objcld) {
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_02_01 =  getTableFormObj(label_YN04_02_01,obj_YN04_02.rownumber );
	var obj_YN04_02_02 =  getTableFormObj(label_YN04_02_02,obj_YN04_02.rownumber );
	var obj_YN04_02_03 =  getTableFormObj(label_YN04_02_03,obj_YN04_02.rownumber );
	var obj_YN04_02_04 =  getTableFormObj(label_YN04_02_04,obj_YN04_02.rownumber );
	
	if (obj_YN04_02.value.trim() == "��" || obj_YN04_02.value.trim() == "") {
		// ֻ��
		obj_YN04_02_01.readOnly = "readonly";
		obj_YN04_02_02.readOnly = "readonly";
		obj_YN04_02_03.readOnly = "readonly";
		obj_YN04_02_04.readOnly = "readonly";
		// ���
		obj_YN04_02_01.value = "";
		obj_YN04_02_02.value = "";
		obj_YN04_02_03.value = "";
		obj_YN04_02_04.value = "";
		
	}else if (obj_YN04_02.value.trim() == "��"){
		obj_YN04_02_01.readOnly = "";
		obj_YN04_02_02.readOnly = "";
		obj_YN04_02_03.readOnly = "";
		obj_YN04_02_04.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ��������ţ���֯��#������Ϣ�Ƽ��������ţ���֯��
 */
function setYN04_03Disable(objcld) {
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_03_01 =  getTableFormObj(label_YN04_03_01,obj_YN04_03.rownumber );
	var obj_YN04_03_02 =  getTableFormObj(label_YN04_03_02,obj_YN04_03.rownumber );
	var obj_YN04_03_03 =  getTableFormObj(label_YN04_03_03,obj_YN04_03.rownumber );
	var obj_YN04_03_04 =  getTableFormObj(label_YN04_03_04,obj_YN04_03.rownumber );
	
	if (obj_YN04_03.value.trim() == "��" || obj_YN04_03.value.trim() == "") {
		// ֻ��
		obj_YN04_03_01.readOnly = "readonly";
		obj_YN04_03_02.readOnly = "readonly";
		obj_YN04_03_03.readOnly = "readonly";
		obj_YN04_03_04.readOnly = "readonly";
		// ���
		obj_YN04_03_01.value = "";
		obj_YN04_03_02.value = "";
		obj_YN04_03_03.value = "";
		obj_YN04_03_04.value = "";
		
	}else if (obj_YN04_03.value.trim() == "��"){
		obj_YN04_03_01.readOnly = "";
		obj_YN04_03_02.readOnly = "";
		obj_YN04_03_03.readOnly = "";
		obj_YN04_03_04.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ����Բ��ţ���֯��#������Ϣ�Ƽ����Բ��ţ���֯��
 */
function setYN04_04Disable(objcld) {
	var obj_YN04_04 = getTableFormObjs(label_YN04_04)[0];
	var obj_YN04_04_01 =  getTableFormObj(label_YN04_04_01,obj_YN04_04.rownumber );
	var obj_YN04_04_02 =  getTableFormObj(label_YN04_04_02,obj_YN04_04.rownumber );
	var obj_YN04_04_03 =  getTableFormObj(label_YN04_04_03,obj_YN04_04.rownumber );
	var obj_YN04_04_04 =  getTableFormObj(label_YN04_04_04,obj_YN04_04.rownumber );
	
	if (obj_YN04_04.value.trim() == "��" || obj_YN04_04.value.trim() == "") {
		// ֻ��
		obj_YN04_04_01.readOnly = "readonly";
		obj_YN04_04_02.readOnly = "readonly";
		obj_YN04_04_03.readOnly = "readonly";
		obj_YN04_04_04.readOnly = "readonly";
		// ���
		obj_YN04_04_01.value = "";
		obj_YN04_04_02.value = "";
		obj_YN04_04_03.value = "";
		obj_YN04_04_04.value = "";
		
	}else if (obj_YN04_04.value.trim() == "��"){
		obj_YN04_04_01.readOnly = "";
		obj_YN04_04_02.readOnly = "";
		obj_YN04_04_03.readOnly = "";
		obj_YN04_04_04.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ�Ƽ�����ά�����ţ���֯��#������Ϣ�Ƽ�����ά�����ţ���֯��
 */
function setYN04_05Disable(objcld) {
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_05_01 =  getTableFormObj(label_YN04_05_01,obj_YN04_05.rownumber);
	var obj_YN04_05_02 =  getTableFormObj(label_YN04_05_02,obj_YN04_05.rownumber);
	var obj_YN04_05_03 =  getTableFormObj(label_YN04_05_03,obj_YN04_05.rownumber);
	var obj_YN04_05_04 =  getTableFormObj(label_YN04_05_04,obj_YN04_05.rownumber);
	
	if (obj_YN04_05.value.trim() == "��" || obj_YN04_05.value.trim() == "") {
		// ֻ��
		obj_YN04_05_01.readOnly = "readonly";
		obj_YN04_05_02.readOnly = "readonly";
		obj_YN04_05_03.readOnly = "readonly";
		obj_YN04_05_04.readOnly = "readonly";
		// ���
		obj_YN04_05_01.value = "";
		obj_YN04_05_02.value = "";
		obj_YN04_05_03.value = "";
		obj_YN04_05_04.value = "";
		
	}else if (obj_YN04_05.value.trim() == "��"){
		obj_YN04_05_01.readOnly = "";
		obj_YN04_05_02.readOnly = "";
		obj_YN04_05_03.readOnly = "";
		obj_YN04_05_04.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ���֯�ܹ�#����#������Ϣ��ȫ�����ţ���֯��#������Ϣ��ȫ�����ţ���֯��
 */
function setYN04_06Disable(objcld) {
	var obj_YN04_06 = getTableFormObjs(label_YN04_06)[0];
	var obj_YN04_06_01 =  getTableFormObj(label_YN04_06_01,obj_YN04_06.rownumber );
	var obj_YN04_06_02 =  getTableFormObj(label_YN04_06_02,obj_YN04_06.rownumber );
	var obj_YN04_06_03 =  getTableFormObj(label_YN04_06_03,obj_YN04_06.rownumber );
	var obj_YN04_06_04 =  getTableFormObj(label_YN04_06_04,obj_YN04_06.rownumber );
	
	if (obj_YN04_06.value.trim() == "��" || obj_YN04_06.value.trim() == "") {
		// ֻ��
		obj_YN04_06_01.readOnly = "readonly";
		obj_YN04_06_02.readOnly = "readonly";
		obj_YN04_06_03.readOnly = "readonly";
		obj_YN04_06_04.readOnly = "readonly";
		// ���
		obj_YN04_06_01.value = "";
		obj_YN04_06_02.value = "";
		obj_YN04_06_03.value = "";
		obj_YN04_06_04.value = "";
		
	}else if (obj_YN04_06.value.trim() == "��"){
		obj_YN04_06_01.readOnly = "";
		obj_YN04_06_02.readOnly = "";
		obj_YN04_06_03.readOnly = "";
		obj_YN04_06_04.readOnly = "";
	}
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
	var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02.rownumber );
	var obj_YN02_07 = getTableFormObj(label_YN02_07,obj_YN02.rownumber );
	var obj_YN02_08= getTableFormObj(label_YN02_08,obj_YN02.rownumber );
	var obj_YN02_09 = getTableFormObj(label_YN02_09,obj_YN02.rownumber);

	if (obj_YN02.value.trim() == "��" || obj_YN02.value.trim() == "") {
		// ֻ��
		obj_YN02_01.readOnly = "readonly";
		obj_YN02_02.onclick = "";
		obj_YN02_03.readOnly = "readonly";
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_06.readOnly = "readonly";
		obj_YN02_07.readOnly = "readonly";
		obj_YN02_08.readOnly = "readonly";
		columnVallueRadio1(obj_YN02_09,false,false);
		// ���
		obj_YN02_01.value = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		obj_YN02_04.value = "";
		obj_YN02_06.value = "";
		obj_YN02_07.value = "";
		obj_YN02_08.value = "";
		obj_YN02_09.value = "";
	} else if (obj_YN02.value.trim() == "��") {
		// ��ԭ
		obj_YN02_01.readOnly = "";
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03.readOnly = "";
		obj_YN02_04.readOnly = "";
		obj_YN02_06.readOnly = "";
		obj_YN02_07.readOnly = "";
		obj_YN02_08.readOnly = "";
		columnVallueRadio1(obj_YN02_09,true,false);
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
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03.rownumber );
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03.rownumber );
	
	if (obj_YN03.value.trim() == "��" || obj_YN03.value.trim() == "") {
		// ֻ��
		obj_YN03_01.readOnly = "readonly";
		obj_YN03_02.onclick = "";
		columnVallueRadio1(obj_YN03_03,false,false);
		columnVallueRadio1(obj_YN03_04,false,false);
		obj_YN03_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN03_06,false,false);
		obj_YN03_07.readOnly = "readonly";
		// ���
		obj_YN03_01.value = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";
		obj_YN03_06.value = "";
		obj_YN03_07.value = "";
	}else if (obj_YN03.value.trim() == "��"){ 
		obj_YN03_01.readOnly = "";
		obj_YN03_02.onclick = click_columnshowDate;
		columnVallueRadio1(obj_YN03_03,true,false);
		columnVallueRadio1(obj_YN03_04,true,false);
		obj_YN03_05.readOnly = "";
		columnVallueRadio1(obj_YN03_06,true,false);
		obj_YN03_07.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã���Ϣ�Ƽ�ս�Թ滮#����#�Ƿ�����Ϣ�Ƽ�ս�Թ滮
 */
function setYN08Disable(objcld) {
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08.rownumber );
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	var obj_YN08_06 = getTableFormObj(label_YN08_06,obj_YN08.rownumber );
	var obj_YN08_07 = getTableFormObj(label_YN08_07,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "��" || obj_YN08.value.trim() == "") {
		// ֻ��
		columnVallueRadio1(obj_YN08_01,false,false);
		obj_YN08_02.onclick = "";
		obj_YN08_03.readOnly = "readonly";
		obj_YN08_04.readOnly = "readonly";
		obj_YN08_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN08_06,false,false);
		obj_YN08_07.readOnly = "readonly";
		// ���
		obj_YN08_01.value = "";
		obj_YN08_02.value = "";
		obj_YN08_03.value = "";
		obj_YN08_04.value = "";
		obj_YN08_05.value = "";
		obj_YN08_06.value = "";
		obj_YN08_07.value = "";
	}else if (obj_YN08.value.trim() == "��") {
		columnVallueRadio1(obj_YN08_01,true,false);
		obj_YN08_02.onclick = click_columnshowDate;
		obj_YN08_03.readOnly = "";
		obj_YN08_04.readOnly = "";
		obj_YN08_05.readOnly = "";
		columnVallueRadio1(obj_YN08_06,true,false);
		obj_YN08_07.readOnly = "";
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
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
};

/*
 *���ܣ��жϱ������Ƿ����100
 */
function checkPercent(obj){
	if(obj.value > 100){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
		alert("�밴�淶��д"+errorMessage+"����ֵ���ܴ���100\n");
	}
}

/*
 *���ܣ��滮���Ƿ�Ϊ��λ��
 *���ã���Ϣ�Ƽ�ս�Թ滮#����#�滮��
 */
function checkItemYN08(obj){
	var length = obj.value.length;
	if(length != "4" || obj.value == "0000" ||obj.value.substring(0,1) == "0"){
		obj.value = "";
		alert("�滮�ڸ�ʽ���ԣ�ӦΪ4λ���֣�����2012��");
	}
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_05 = getTableFormObjs(label_YN08_05)[0];
	if(obj_YN08_04.value !=""&&obj_YN08_05.value !=""){
		if(parseInt(obj_YN08_04.value)>parseInt(obj_YN08_05.value)){
			obj_YN08_04.value = "";
			alert("�滮��Ӧ��С�������������룡");
		}
	}
}
var label_YN08_07 = "��Ϣ�Ƽ�ս�Թ滮#����#��������";
/*
 *���ܣ������Ƿ����0
 *���ã���Ϣ�Ƽ�ս�Թ滮#����#��������
 */
function checkDateValue(obj){
	var obj_YN08_07 = getTableFormObjs(label_YN08_07)[0];
	if(parseInt(obj_YN08_07.value)<1){
		alert("�밴�淶�������ڣ�Ӧ��д����1��������");
	}
}
