/*
 * ����2014 T-B-6 ��Ϣ�Ƽ��������Թ���������������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
//���������Ŀ���
var label_YN01_01 = "���������Ŀ���#����#��������������Ŀ����";
var label_YN01_02 = "���������Ŀ���#����#���У�����ɵ����������Ŀ����";
var label_YN01_03 = "���������Ŀ���#����#��������ش���Ŀ��";
var label_YN01_04 = "���������Ŀ���#����#����������Ŀ��";
var label_YN01_05 = "���������Ŀ���#����#�������������Ŀ��";
var label_YN01_06 = "���������Ŀ���#����#��ȫ���������Ŀ��";
var label_YN01_07 = "���������Ŀ���#����#��������������Ŀ������";
var label_YN01_08 = "���������Ŀ���#����#���У���������������";
var label_YN01_09 = "���������Ŀ���#����#�������������";
//��Ŀ����
var label_YN02_01 = "��Ŀ����#����#�����ѽ���ר�ŵ���Ϣ�Ƽ���Ŀ������֯";
var label_YN02_02 = "��Ŀ����#����#��֯����";
var label_YN02_03 = "��Ŀ����#����#������Ϣ�Ƽ���ز���ͨ��������������������֤";
var label_YN02_04 = "��Ŀ����#����#���ǣ���֤���ƣ�����";
var label_YN02_05 = "��Ŀ����#����#ͨ����֤�Ĳ�������";
var label_YN02_07 = "��Ŀ����#����#��Ϣ�Ƽ������Ա����Ϣ��ȫ��Ա�μ���������ش���Ŀ����";
var label_YN02_08 = "��Ŀ����#����#�μ��������������ش���Ŀ����";
var label_YN02_09 = "��Ŀ����#����#��ĿͶ������֯ҵ���Ŷ���������ش���Ŀ���к�����";
var label_YN02_10 = "��Ŀ����#����#�������֯ҵ���Ž��к����۵���������ش���Ŀ����";
//��������
var label_YN03_01 = "��������#����#�ƶ��ͷ���ͳһ����������淶";
var label_YN03_02 = "��������#����#����ʱ��";
var label_YN03_03 = "��������#����#������������淶�����޶�����";
var label_YN03_04 = "��������#����#���һ���޶���������ʱ��";
var label_YN03_06 = "��������#����#�ƶ��ͷ���ͳһ�Ĵ��밲ȫ��ƹ淶";
var label_YN03_07 = "��������#����#����ʱ��:";
var label_YN03_08 = "��������#����#�������밲ȫ��ƹ淶�����޶�����";
var label_YN03_09 = "��������#����#���һ���޶���������ʱ��:";
//���Թ���
var label_YN04_01 = "���Թ���#����#�ƶ��ͷ���ͳһ�Ĳ��Թ淶";
var label_YN04_02 = "���Թ���#����#����ʱ��";
var label_YN04_03 = "���Թ���#����#�������Թ淶�����޶�����";
var label_YN04_04 = "���Թ���#����#���һ���޶���������ʱ��";
var label_YN04_05 = "���Թ���#����#��չԴ���밲ȫ���";
var label_YN04_06 = "���Թ���#����#���ǣ���ȫ��鷽ʽ";
//�汾����
var label_YN05_01 = "�汾����#����#�ƶ��ͷ���ͳһ������汾����淶";
var label_YN05_02 = "�汾����#����#����ʱ��";
var label_YN05_03 = "�汾����#����#��������汾����淶�����޶�����";
var label_YN05_04 = "�汾����#����#���һ���޶���������ʱ��";
var label_YN05_05 = "�汾����#����#����רְ������汾�����Ŷӣ���֯��";
var label_YN05_06 = "�汾����#����#�Ŷӣ���֯������";
//Ͷ������
var label_YN06_01 = "Ͷ������#����#�ƶ��ͷ���ͳһ����ĿͶ������淶";
var label_YN06_02 = "Ͷ������#����#����ʱ��";
var label_YN06_03 = "Ͷ������#����#������ĿͶ������淶�����޶�����";
var label_YN06_04 = "Ͷ������#����#���һ���޶���������ʱ��";
//����
var label_YN07_01 = "����#����#����1#��������";
var label_YN07_02 = "����#����#����2#��������";
var label_YN07_03 = "����#����#����3#��������";
var label_YN07_04 = "����#����#����4#��������";
/*
 * �ύУ������
 */
function checkData(){
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	
	//��Ŀ����У��
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_01.rownumber);
	if(obj_YN02_01.value == "��" && obj_YN02_02.value == ""){
		errorObjs.push(obj_YN02_02);
		a += "��Ŀ������֯���Ʋ���Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_03.rownumber);
	var obj_YN02_05 = getTableFormObj(label_YN02_05,obj_YN02_03.rownumber);
	if(obj_YN02_03.value == "��" && obj_YN02_04.value == ""){
		errorObjs.push(obj_YN02_04);
		a += "��Ŀ������֤���ƣ����𣩲���Ϊ�գ�\n";
		isValid = false;
	}
	if(obj_YN02_03.value == "��" && obj_YN02_05.value == ""){
		errorObjs.push(obj_YN02_05);
		a += "��Ŀ����ͨ����֤�Ĳ������Ʋ���Ϊ�գ�\n";
		isValid = false;
	}
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	var obj_YN02_08 = getTableFormObj(label_YN02_08,obj_YN02_07.rownumber);
	if(obj_YN02_07.value == "��" && obj_YN02_08.value == ""){
		errorObjs.push(obj_YN02_08);
		a += "��Ŀ�����μ��������������ش���Ŀ��������Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN02_09 = getTableFormObjs(label_YN02_09)[0];
	var obj_YN02_10 = getTableFormObj(label_YN02_10,obj_YN02_09.rownumber);
	if(obj_YN02_09.value == "��" && obj_YN02_10.value == ""){
		errorObjs.push(obj_YN02_10);
		a += "��Ŀ�����������֯ҵ���Ž��к����۵���������ش���Ŀ��������Ϊ�գ�\n";
		isValid = false;
	}

	//��������У��
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03_01.rownumber);
	if(obj_YN03_01.value == "��" && obj_YN03_02.value == ""){
		errorObjs.push(obj_YN03_02);
		a += "������������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_03.rownumber);
	if(obj_YN03_03.value == "��" && obj_YN03_04.value == ""){
		errorObjs.push(obj_YN03_04);
		a += "�����������һ���޶���������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03_06.rownumber);
	if(obj_YN03_06.value == "��" && obj_YN03_07.value == ""){
		errorObjs.push(obj_YN03_07);
		a += "������������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}

	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "��" && obj_YN03_09.value == ""){
		errorObjs.push(obj_YN03_09);
		a += "�����������һ���޶���������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	//���Թ���
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02,obj_YN04_01.rownumber);
	if(obj_YN04_01.value == "��" && obj_YN04_02.value == ""){
		errorObjs.push(obj_YN04_02);
		a += "���Թ�������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN04_03.rownumber);
	if(obj_YN04_03.value == "��" && obj_YN04_04.value == ""){
		errorObjs.push(obj_YN04_04);
		a += "���Թ������һ���޶���������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}

	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06,obj_YN04_05.rownumber);
	if(obj_YN04_05.value == "��" && obj_YN04_06.value == ""){
		errorObjs.push(obj_YN04_06);
		a += "���Թ�����ȫ��鷽ʽ����Ϊ�գ�\n";
		isValid = false;
	}
	//�汾����
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02,obj_YN05_01.rownumber);
	if(obj_YN05_01.value == "��" && obj_YN05_02.value == ""){
		errorObjs.push(obj_YN05_02);
		a += "�汾��������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}

	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04,obj_YN05_03.rownumber);
	if(obj_YN05_03.value == "��" && obj_YN05_04.value == ""){
		errorObjs.push(obj_YN05_04);
		a += "�汾�������һ���޶���������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	var obj_YN05_06 = getTableFormObj(label_YN05_06,obj_YN05_05.rownumber);
	if(obj_YN05_05.value == "��" && obj_YN05_06.value == ""){
		errorObjs.push(obj_YN05_06);
		a += "�汾�����Ŷӣ���֯�����Ʋ���Ϊ�գ�\n";
		isValid = false;
	}
	//Ͷ������
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02,obj_YN06_01.rownumber);
	if(obj_YN06_01.value == "��" && obj_YN06_02.value == ""){
		errorObjs.push(obj_YN06_02);
		a += "Ͷ����������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "��" && obj_YN06_04.value == ""){
		errorObjs.push(obj_YN06_04);
		a += "Ͷ���������һ���޶���������ʱ�䲻��Ϊ�գ�\n";
		isValid = false;
	}
	//���������Ŀ���У��

	
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObjs(label_YN01_02)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObjs(label_YN01_05)[0];
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObjs(label_YN01_07)[0];
	var obj_YN01_08 = getTableFormObjs(label_YN01_08)[0];
	var obj_YN01_09 = getTableFormObjs(label_YN01_09)[0];
	if(obj_YN01_01.value != (parseInt(obj_YN01_04.value)+parseInt(obj_YN01_05.value)+parseInt(obj_YN01_06.value))){
		errorObjs.push(obj_YN01_04);
		errorObjs.push(obj_YN01_05);
		errorObjs.push(obj_YN01_06);
		a+="���������Ŀ�������������������Ŀ���� Ӧ���� ����������Ŀ��+�������������Ŀ��+��ȫ���������Ŀ����\n";
		isValid = false;
	}
	if(obj_YN01_07.value != (parseInt(obj_YN01_08.value)+parseInt(obj_YN01_09.value))){
		errorObjs.push(obj_YN01_08);
		errorObjs.push(obj_YN01_09);
		a+="���������Ŀ�������������������Ŀ������ Ӧ���� �������������������������������\n";
		isValid = false;
	}
	
	var obj_YN02_08 = getTableFormObjs(label_YN02_08)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN02_08Value = 0;
	if(obj_YN02_08.value != ""){
		obj_YN02_08Value = obj_YN02_08.value;
	}
	if(parseFloat(obj_YN02_08Value) > parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN02_08);
		errorObjs.push(obj_YN01_03);
		a+="��Ŀ�����μ��������������ش���Ŀ���� ӦС�ڵ��� ��������������Ŀ�������ش���Ŀ������\n";
		isValid=false;
	}
	
	var obj_YN02_10 = getTableFormObjs(label_YN02_10)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN02_10Value = 0;
	if(obj_YN02_10.value != ""){
		obj_YN02_10Value = obj_YN02_10.value;
	}
	if(parseFloat(obj_YN02_10Value) > parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN02_10);
		errorObjs.push(obj_YN01_03);
		a+="��Ŀ�����������֯ҵ���Ž��к����۵���������ش���Ŀ�� ӦС�ڵ��� ��������������Ŀ�������ش���Ŀ������\n";
		isValid=false;
	}
	
	if(parseFloat(obj_YN01_01.value) < parseFloat(obj_YN01_02.value)){
		errorObjs.push(obj_YN01_02);
		a+="���������Ŀ�������������������Ŀ���� Ӧ���ڵ��� ����ɵ����������Ŀ������\n";
		isValid=false;
	}
	if(parseFloat(obj_YN01_01.value) < parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN01_03);
		a+="���������Ŀ�������������������Ŀ���� Ӧ���ڵ��� ��������ش���Ŀ����\n";
		isValid=false;
	}
	//����У��
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];
	var obj_YN07_03 = getTableFormObjs(label_YN07_03)[0];
	var obj_YN07_04 = getTableFormObjs(label_YN07_04)[0];
	if(obj_YN07_01.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="��������Ϣ�Ƽ���Ŀ������ϸ���治��Ϊ�գ�\n";
		isValid=false;
	}
	if(obj_YN07_02.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="��������������淶��Դ���밲ȫ��ƹ淶����Ϊ�գ�\n";
		isValid=false;
	}
	if(obj_YN07_03.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="����������汾����淶����Ϊ�գ�\n";
		isValid=false;
	}
	if(obj_YN07_04.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="��������ĿͶ������淶����Ϊ�գ�\n";
		isValid=false;
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
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ����ĿͶ������淶��������ʱ��ֻ���Ϳ���
 * ���ã��汾����#����#��������汾����淶�����޶�����
 */
function setYN06_04Disable(obj){
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "��" || obj_YN06_03.value == ""){
		//ֻ��
		obj_YN06_04.onclick = "";
		//���
		obj_YN06_04.value = "";
	}else if(obj_YN06_03.value == "��"){
		obj_YN06_04.onclick = click_columnshowDate;
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ����ĿͶ������淶��������ʱ��ֻ���Ϳ���
 * ���ã��汾����#����#��������汾����淶�����޶�����
 */
function setYN06_02Disable(obj){
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02,obj_YN06_01.rownumber);
	if(obj_YN06_01.value == "��" ||obj_YN06_01.value == ""){
		//ֻ��
		obj_YN06_02.onclick = "";
		//���
		obj_YN06_02.value = "";
	}else if(obj_YN06_01.value == "��"){
		obj_YN06_02.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ����֯ҵ���Ŷ���������ش���Ŀ���к������������������֯ҵ���Ž��к����۵���������ش���Ŀ����ֻ���Ϳ���
 * ���ã���Ŀ����#����#��ĿͶ������֯ҵ���Ŷ���������ش���Ŀ���к�����
 */
function setYN05_06Disable(obj){
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	var obj_YN05_06 = getTableFormObj(label_YN05_06,obj_YN05_05.rownumber);
	if(obj_YN05_05.value == "��" || obj_YN05_05.value == ""){
		//ֻ��
		obj_YN05_06.readOnly = "readonly";
		//���
		obj_YN05_06.value = "";
	}else if(obj_YN05_05.value == "��"){
		obj_YN05_06.readOnly = "";
	}
}

/*
 * ���ܣ�ͨ����������汾����淶�����޶����ƾ������һ���޶���������ʱ��ֻ���Ϳ���
 * ���ã��汾����#����#��������汾����淶�����޶�����
 */
function setYN05_04Disable(obj){
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04,obj_YN05_03.rownumber);
	if(obj_YN05_03.value == "��" || obj_YN05_03.value == ""){
		//ֻ��
		obj_YN05_04.onclick = "";
		//���
		obj_YN05_04.value = "";
	}else if(obj_YN05_03.value == "��"){
		obj_YN05_04.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ������汾����淶��������ʱ��ֻ���Ϳ���
 * ���ã��汾����#����#�ƶ��ͷ���ͳһ������汾����淶
 */
function setYN05_02Disable(obj){
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02,obj_YN05_01.rownumber);
	if(obj_YN05_01.value == "��" || obj_YN05_01.value == ""){
		//ֻ��
		obj_YN05_02.onclick = "";
		//���
		obj_YN05_02.value = "";
	}else if(obj_YN05_01.value == "��"){
		obj_YN05_02.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ����չԴ���밲ȫ���������ǣ���ȫ��鷽ʽֻ���Ϳ���
 * ���ã����Թ���#����#��չԴ���밲ȫ���
 */
function setYN_04_06Disable(obj){
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06,obj_YN04_05.rownumber);
	if(obj_YN04_05.value == "��" || obj_YN04_05.value == ""){
		//ֻ��
		columnVallueRadio1(obj_YN04_06,false,false);
		//���
		obj_YN04_06.value = "";
	}else if(obj_YN04_05.value == "��"){
		columnVallueRadio1(obj_YN04_06,true,false);
	}
}

/*
 * ���ܣ�ͨ���������Թ淶�����޶����ƾ������һ���޶���������ʱ��ֻ���Ϳ���
 * ���ã���������#����#�������밲ȫ��ƹ淶�����޶�����
 */
function setYN_04_04Disable(obj){
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN04_03.rownumber);
	if(obj_YN04_03.value == "��" || obj_YN04_03.value == ""){
		//ֻ��
		obj_YN04_04.onclick = "";
		//���
		obj_YN04_04.value = "";
	}else if(obj_YN04_03.value == "��"){
		obj_YN04_04.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ�Ĳ��Թ淶����������ʱ��ֻ���Ϳ���
 * ���ã����Թ���#����#�ƶ��ͷ���ͳһ�Ĳ��Թ淶
 */
function setYN_04_02Disable(obj){
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02,obj_YN04_01.rownumber);
	if(obj_YN04_01.value == "��" || obj_YN04_01.value == ""){
		//ֻ��
		obj_YN04_02.onclick = "";
		//���
		obj_YN04_02.value = "";
	}else if(obj_YN04_01.value == "��"){
		obj_YN04_02.onclick = click_columnshowDate;
	}
}
/*
 * ���ܣ�ͨ���������밲ȫ��ƹ淶�����޶��������������һ���޶���������ʱ��:ֻ���Ϳ���
 * ���ã���������#����#�������밲ȫ��ƹ淶�����޶�����
 */
function setYN_03_09Disable(obj){
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "��" || obj_YN03_08.value == ""){
		//ֻ��
		obj_YN03_09.onclick = "";
		//���
		obj_YN03_09.value = "";
	}else if(obj_YN03_08.value == "��"){
		obj_YN03_09.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ�Ĵ��밲ȫ��ƹ淶����������ʱ��:ֻ���Ϳ���
 * ���ã���������#����#������������淶�����޶�����
 */
function setYN_03_07Disable(obj){
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03_06.rownumber);
	if(obj_YN03_06.value == "��" || obj_YN03_06.value == ""){
		//ֻ��
		obj_YN03_07.onclick = "";
		//���
		obj_YN03_07.value = "";
	}else if(obj_YN03_06.value == "��"){
		obj_YN03_07.onclick = click_columnshowDate;
	}
}

/*
 * ���ܣ�ͨ��������������淶�����޶��������������һ���޶���������ʱ��ֻ���Ϳ���
 * ���ã���������#����#������������淶�����޶�����
 */
function setYN_03_04Disable(obj){
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_03.rownumber);
	if(obj_YN03_03.value == "��" || obj_YN03_03.value == ""){
		//ֻ��
		obj_YN03_04.onclick = "";
		//���
		obj_YN03_04.value = "";
	}else if(obj_YN03_03.value == "��"){
		obj_YN03_04.onclick = click_columnshowDate;
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ���ͳһ����������淶����������ʱ��ֻ���Ϳ���
 * ���ã���������#����#�ƶ��ͷ���ͳһ����������淶
 */
function setYN_03_02Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03_01.rownumber);
	if(obj_YN03_01.value == "��" || obj_YN03_01.value == ""){
		//ֻ��
		obj_YN03_02.onclick = "";
		//���
		obj_YN03_02.value = "";
	}else if(obj_YN03_01.value == "��"){
		obj_YN03_02.onclick = click_columnshowDate;
	}
}
/*
 * ���ܣ�ͨ����֯ҵ���Ŷ���������ش���Ŀ���к������������������֯ҵ���Ž��к����۵���������ش���Ŀ����ֻ���Ϳ���
 * ���ã���Ŀ����#����#��ĿͶ������֯ҵ���Ŷ���������ش���Ŀ���к�����
 */
function setYN_02_10Disable(obj){
	var obj_YN02_09 = getTableFormObjs(label_YN02_09)[0];
	var obj_YN02_10 = getTableFormObj(label_YN02_10,obj_YN02_09.rownumber);
	if(obj_YN02_09.value == "��" || obj_YN02_09.value == ""){
		//ֻ��
		obj_YN02_10.readOnly = "readonly";
		//���
		obj_YN02_10.value = "";
	}else if(obj_YN02_09.value == "��"){
		obj_YN02_10.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ����Ϣ�Ƽ������Ա����Ϣ��ȫ��Ա�μ���������ش���Ŀ�����������μ��������������ش���Ŀ����ֻ���Ϳ���
 * ���ã���Ŀ����#����#��Ϣ�Ƽ������Ա����Ϣ��ȫ��Ա�μ���������ش���Ŀ����
 */
function setYN_02_08Disable(obj){
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	var obj_YN02_08 = getTableFormObj(label_YN02_08,obj_YN02_07.rownumber);
	if(obj_YN02_07.value == "��" || obj_YN02_07.value == ""){
		//ֻ��
		obj_YN02_08.readOnly = "readonly";
		//���
		obj_YN02_08.value = "";
	}else if(obj_YN02_07.value == "��"){
		obj_YN02_08.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ��������Ϣ�Ƽ���ز���ͨ��������������������֤���������ǣ���֤���ƣ����𣩺�ͨ����֤�Ĳ�������ֻ���Ϳ�д
 * ���ã���Ŀ����#����#������Ϣ�Ƽ���ز���ͨ��������������������֤
 */
function setYN02_03And04Disable(obj){
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_03.rownumber);
	var obj_YN02_05 = getTableFormObj(label_YN02_05,obj_YN02_03.rownumber);
	if(obj_YN02_03.value == "��" || obj_YN02_03.value == ""){
		//ֻ��
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_05.readOnly = "readonly";
		//���
		obj_YN02_04.value = "";
		obj_YN02_05.value = "";
	}else if(obj_YN02_03.value == "��"){
		obj_YN02_04.readOnly = "";
		obj_YN02_05.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ�������ѽ���ר�ŵ���Ϣ�Ƽ���Ŀ������֯��������֯����ֻ���Ϳ�д
 * ���ã���Ŀ����#����#�����ѽ���ר�ŵ���Ϣ�Ƽ���Ŀ������֯
 */
function setYN02_02Disable(obj){
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_01.rownumber);
	if(obj_YN02_01.value == "��" || obj_YN02_01.value == ""){
		//ֻ��
		obj_YN02_02.readOnly = "readonly";
		//���
		obj_YN02_02.value = "";
	}else if(obj_YN02_01.value == "��"){
		obj_YN02_02.readOnly = "";
	}
}
/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
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
 * ��ʼ��
 */
function initSet(){
	setYN06_04Disable(obj);
	setYN06_02Disable(obj);
	setYN05_06Disable(obj);
	setYN05_04Disable(obj);
	setYN05_02Disable(obj);
	setYN_04_06Disable(obj);
	setYN_04_04Disable(obj);
	setYN_04_02Disable(obj);
	setYN_03_09Disable(obj);
	setYN_03_07Disable(obj);
	setYN_03_04Disable(obj);
	setYN_03_02Disable(obj);
	setYN_02_10Disable(obj);
	setYN_02_08Disable(obj);
	setYN02_03And04Disable(obj);
	setYN02_02Disable(obj);
}
