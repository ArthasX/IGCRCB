/*
 * ����2014-T-B-12 ��Ϣ�Ƽ�������������
 */
//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
// ��Ϣ�Ƽ����������֯�ܹ�
var label_YN01_01 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#����ȷ��Ϣ�Ƽ�����������ܲ���";
var label_YN01_02 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#��������";
var label_YN01_03 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#���ǣ���������Ϣ�Ƽ�����";
var label_YN01_04 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#������Ϣ�Ƽ��������ִ���Ŷ�";
var label_YN01_05 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#�Ŷ�����";
var label_YN01_06 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#������߼������㱨��Ϣ�Ƽ�������չ����й����";
var label_YN01_07 = "��Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#�㱨Ƶ��";
// ��Ϣ�Ƽ����ս��
var label_YN02_01 = "��Ϣ�Ƽ����ս��#��Ϣ�Ƽ����ս�Խṹ#����#�ƶ��ͷ�����Ϣ�Ƽ����ս��";
var label_YN02_02 = "��Ϣ�Ƽ����ս��#��Ϣ�Ƽ����ս�Խṹ#����#���ǣ��������»��߼����������";
var label_YN02_03 = "��Ϣ�Ƽ����ս��#��Ϣ�Ƽ����ս�Խṹ#����#����ʱ��";
// ��Ϣ�Ƽ����ս��
var label_YN03_01 = "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#������ѿ�չȫ�����Ϣ�Ƽ������������";
var label_YN03_02 = "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#���ǣ����������ύ�߼������";
var label_YN03_03 = "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#�ύʱ��";
var label_YN03_04 = "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#�������Ҫ��Ϣ�Ƽ���������ṩ������";
var label_YN03_05 = "��Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#���У�����Ƚ��з�����������Ҫ��Ϣ�Ƽ���������ṩ������";
// ��Ϣ�Ƽ�����������
var label_YN04_02 = "��Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#����Ҫ��Ϣ�Ƽ���������ṩ�̽��о�ְ����";
var label_YN04_03 = "��Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#���ǣ�������ѿ�չ��ְ�������Ҫ��Ϣ�Ƽ���������ṩ�̵�����";
var label_YN04_04 = "��Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#�������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵�����";
var label_YN04_05 = "��Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#���п�չ���۵ķ����ṩ�̵�����";
var label_YN04_07 = "��Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#��ȡ����Ϣ�Ƽ������ȫ�����ʩ";
//�������жȷ��չ���
var label_YN05_03 = "�������жȷ��չ���#�������жȷ��չ�����#����#��Ծ��л������ж��ص����Ϣ�Ƽ���������ṩ�̲�ȡ�Ŀ����ֶ�";
// �羳����פ���������
var label_YN06_01 = "�羳����פ���������#�羳����פ���������ṹ#����#�Ƿ������Ϣ�Ƽ��羳���";
var label_YN06_02 = "�羳����פ���������#�羳����פ���������ṹ#����#���ǣ���ȷ��Ϣ�Ƽ��羳��������ṩ�����ڹ��һ������ܵ������������ǩ���½ⱸ��¼";
var label_YN06_03 = "�羳����פ���������#�羳����פ���������ṹ#����#����������ʱ���õķ���";
var label_YN06_04 = "�羳����פ���������#�羳����פ���������ṹ#����#������Ϣ�Ƽ���פ�����";
var label_YN06_05 = "�羳����פ���������#�羳����פ���������ṹ#����#���ǣ�����Ҫ��Ϣ�Ƽ���פ������������ʵ�ؼ��";
var label_YN06_06 = "�羳����פ���������#�羳����פ���������ṹ#����#���Ƶ��";
/*
 * ���ܣ�ͨ���������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵����������п�չ���۵ķ����ṩ�̵������Ƚ�
 * ���ã���Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#�������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵�����
 */
function setYN06_05_06Disable(obj) {
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "��") {
//		columnVallueRadio2(obj_YN06_05, true, false);
		columnVallueRadio2(obj_YN06_05, true, true,setYN06_06Disable);

	} else {
		columnVallueRadio2(obj_YN06_05, false, false,setYN06_06Disable);
		obj_YN06_06.readOnly = "readonly";
		obj_YN06_06.value = "";
		obj_YN06_05.value = "";
	}
}
function setYN06_06Disable(obj){
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if(obj_YN06_05.value == "��"){
		obj_YN06_06.readOnly = "";
	}else{
		obj_YN06_06.value = "";
		obj_YN06_06.readOnly = "readonly";
	}
}
/*
 * ���ܣ�ͨ���������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵����������п�չ���۵ķ����ṩ�̵������Ƚ�
 * ���ã���Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#�������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵�����
 */
function setYN06_02_03Disable(obj) {
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02, obj_YN06_01.rownumber);
	var obj_YN06_03 = getTableFormCheckBox(label_YN06_03, "1_1");
	if (obj_YN06_01.value == "��") {
		columnVallueRadio2(obj_YN06_02, true, true,setYN06_03Disable);
		disableTableCheckBox(obj_YN06_03, true);
	} else {
		columnVallueRadio2(obj_YN06_02, false, false,setYN06_03Disable);
		disableTableCheckBox(obj_YN06_03, true);
		obj_YN06_02.value = "";
	}
}

function setYN06_03Disable(obj){
	var obj_YN06_03 = getTableFormCheckBox(label_YN06_03, "1_1_1");
	if(obj.flag == "��"){
		disableTableCheckBox(obj_YN06_03, false);
	}else{
		disableTableCheckBox(obj_YN06_03, true);
	}
}

/*
 * ���ܣ�ͨ���������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵����������п�չ���۵ķ����ṩ�̵������Ƚ�
 * ���ã���Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#�������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵�����
 */
function checkYN04_04_05Number(obj) {
	var obj_YN04_04 = getTableFormObjs(label_YN04_04)[0];
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	if (obj_YN04_04.value != "" && obj_YN04_05.value != "") {
		if (parseInt(obj_YN04_04.value) < parseInt(obj_YN04_05.value)) {
			obj_YN04_05.value = "";
			alert("��չ���۵ķ����ṩ�̵��������ܴ��ڱ������Ϣ�Ƽ���������ͬ���н����ķ����ṩ�̵�����");
		}
	}
}
/*
 * ���ܣ�ͨ������Ҫ��Ϣ�Ƽ���������ṩ�̽��о�ְ����������������ѿ�չ��ְ�������Ҫ��Ϣ�Ƽ���������ṩ�̵������Ƿ��д��ֻ��
 * ���ã���Ϣ�Ƽ�����������#��Ϣ�Ƽ����������̼ܹ�#����#����Ҫ��Ϣ�Ƽ���������ṩ�̽��о�ְ����
 */
function checkYN04_03Disable(obj) {
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_03 = getTableFormObj(label_YN04_03, obj_YN04_02.rownumber);
	if (obj_YN04_02.value == "��") {
		obj_YN04_03.readOnly = "";
	} else {
		obj_YN04_03.readOnly = "readonly";
		obj_YN04_03.value = "";
	}
}

/*
 * ���ܣ�ͨ���������Ҫ��Ϣ�Ƽ���������ṩ�������ͱ���Ƚ��з�����������Ҫ��Ϣ�Ƽ���������ṩ�������Ƚ�
 * ���ã���Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#�������Ҫ��Ϣ�Ƽ���������ṩ������
 */
function checkYN03_04_05Number(obj) {
	var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	if (obj_YN03_04.value != "" && obj_YN03_05.value != "") {
		if (parseInt(obj_YN03_04.value) < parseInt(obj_YN03_05.value)) {
			obj_YN03_05.value = "";
			alert("����Ƚ��з�����������Ҫ��Ϣ�Ƽ���������ṩ���������ܴ��ڱ������Ҫ��Ϣ�Ƽ���������ṩ������");
		}
	}
}
/*
 * ���ܣ�ͨ��������ѿ�չȫ�����Ϣ�Ƽ�������������������������ύ�߼��������ύʱ��ֻ���Ϳ���
 * ���ã���Ϣ�Ƽ�������չ���#��Ϣ�Ƽ�������չ���ܹ�#����#������ѿ�չȫ�����Ϣ�Ƽ������������
 */
function setYN03_02_03Disable(obj) {
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "��") {
		columnVallueRadio2(obj_YN03_02,true,true,setYN_03_03Disable);
		if(obj_YN03_02.value == "��"){
		}else{
			obj_YN03_03.onclick = "";
		}
	} else {
		columnVallueRadio2(obj_YN03_02,true,true,setYN_03_03Disable);
		obj_YN03_03.onclick = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
	}

}
function setYN_03_03Disable(obj){
	var obj_YN03_03 = getTableFormObj(label_YN03_03,"1_1_1");
	if(obj.flag == "��"){
		obj_YN03_03.onclick = click_columnshowDate;
	}else{
		obj_YN03_03.onclick = "";
		obj_YN03_03.value = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ�����Ϣ�Ƽ����ս�Ծ����������»��߼����������������ʱ��ֻ���Ϳ���
 * ���ã���Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#������Ϣ�Ƽ��������ִ���Ŷ�
 */
function setYN02_02_03Disable(obj) {
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02_01.rownumber);
	if (obj_YN02_01.value == "��") {
		columnVallueRadio2(obj_YN02_02,true,true,setYN02_03Disable);
		if(obj_YN02_02.value == "��"){
		}else{
			obj_YN02_03.onclick = "";
		}
	} else{
		columnVallueRadio2(obj_YN02_02,false,false,setYN02_03Disable);
		obj_YN02_03.onclick = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
	}
}
function setYN02_03Disable(obj){
	var obj_YN02_03 = getTableFormObj(label_YN02_03,"1_1_1");
	if(obj.flag == "��"){
		obj_YN02_03.onclick = click_columnshowDate;
	}else{
		obj_YN02_03.onclick = "";
		obj_YN02_03.value = "";
	}
}
/*
 * ���ܣ�ͨ��������Ϣ�Ƽ��������ִ���ŶӾ����Ŷ�����ֻ���Ϳ��� ���ã���Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#������Ϣ�Ƽ��������ִ���Ŷ�
 */
function setYN01_07Disable(obj) {
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObj(label_YN01_07, obj_YN01_06.rownumber);
	if (obj_YN01_06.value == "��") {
		obj_YN01_07.readOnly = "";
	} else {
		obj_YN01_07.readOnly = "readonly";
		obj_YN01_07.value = "";
	}
}
/*
 * ���ܣ�ͨ��������Ϣ�Ƽ��������ִ���ŶӾ����Ŷ�����ֻ���Ϳ��� ���ã���Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#������Ϣ�Ƽ��������ִ���Ŷ�
 */
function setYN01_05Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "��") {
		obj_YN01_05.readOnly = "";
	} else {
		obj_YN01_05.readOnly = "readonly";
		obj_YN01_05.value = "";
	}
}
/*
 * ���ܣ�ͨ������ȷ��Ϣ�Ƽ�����������ܲ��ž����������ƺͶ�������Ϣ�Ƽ�����ֻ���Ϳ���
 * ���ã���Ϣ�Ƽ����������֯�ܹ�#��Ϣ�Ƽ����������֯�ṹ#����#����ȷ��Ϣ�Ƽ�����������ܲ���
 */
function setYN01_02_03Disable(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "��") {
		obj_YN01_02.readOnly = "";
		columnVallueRadio1(obj_YN01_03, true, false);
	} else {
		obj_YN01_02.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_03, false, false);
		obj_YN01_02.value = "";
		obj_YN01_03.value = "";
	}
}
/*
 * ���ܣ��ύУ��
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.color = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// ��Ϣ�Ƽ����������֯�ܹ�
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "��") {
		if (obj_YN01_02.value == "") {
			errorObjs.push(obj_YN01_02);
			isValid = false;
			a += "��Ϣ�Ƽ���������������1 ��Ϣ�Ƽ����������֯�ṹ ����ȷ��Ϣ�Ƽ�����������ܲ��� �������ƣ�����Ϊ�գ�\n";
		}
		if (obj_YN01_03.value == "") {
			errorObjs.push(obj_YN01_03);
			isValid = false;
			a += "��Ϣ�Ƽ���������������1 ��Ϣ�Ƽ����������֯�ṹ ��������Ϣ�Ƽ����ţ�����Ϊ�գ�\n";
		}
	}
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "��" && obj_YN01_05.value == "") {
		errorObjs.push(obj_YN01_05);
		isValid = false;
		a += "��Ϣ�Ƽ���������������1 ��Ϣ�Ƽ����������֯�ṹ �Ŷ����ƣ�����Ϊ�գ�\n";
	}
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObj(label_YN01_07, obj_YN01_06.rownumber);
	if (obj_YN01_06.value == "��" && obj_YN01_07.value == "") {
		errorObjs.push(obj_YN01_07);
		isValid = false;
		a += "��Ϣ�Ƽ���������������1 ��Ϣ�Ƽ����������֯�ṹ ������߼������㱨��Ϣ�Ƽ�������չ����й���� �㱨Ƶ�ʣ�����Ϊ�գ�\n";
	}
	// ��Ϣ�Ƽ����ս��
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03 = getTableFormObj(label_YN02_03, obj_YN02_01.rownumber);
	if (obj_YN02_01.value == "��") {
		if (obj_YN02_02.value == "") {
			errorObjs.push(obj_YN02_02);
			isValid = false;
			a += "��Ϣ�Ƽ���������������2 ��Ϣ�Ƽ����ս�� �ƶ��ͷ�����Ϣ�Ƽ����ս�� �������»��߼����������������Ϊ�գ�\n";
		}
		if (obj_YN02_03.value == "") {
			errorObjs.push(obj_YN02_03);
			isValid = false;
			a += "��Ϣ�Ƽ���������������2 ��Ϣ�Ƽ����ս�� �ƶ��ͷ�����Ϣ�Ƽ����ս�� �������»��߼���������� ����ʱ�䣢����Ϊ�գ�\n";
		}
	}
	//��Ϣ�Ƽ�������չ���
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "��") {
		if (obj_YN03_02.value == "") {
			errorObjs.push(obj_YN03_02);
			isValid = false;
			a += "��Ϣ�Ƽ���������������3 ��Ϣ�Ƽ�������չ��� ������ѿ�չȫ�����Ϣ�Ƽ������������ ���������ύ�߼�����㣢����Ϊ�գ�\n";
		}
		if (obj_YN03_03.value == "") {
			errorObjs.push(obj_YN03_03);
			isValid = false;
			a += "��Ϣ�Ƽ���������������3 ��Ϣ�Ƽ�������չ��� ������ѿ�չȫ�����Ϣ�Ƽ������������ ���������ύ�߼������ �ύʱ�䣢����Ϊ�գ�\n";
		}
	}
	//�Ƽ�����������
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_03 = getTableFormObj(label_YN04_03, obj_YN04_02.rownumber);
	if (obj_YN04_02.value == "��" && obj_YN04_03.value == "") {
		errorObjs.push(obj_YN04_03);
		isValid = false;
		a += "��Ϣ�Ƽ���������������4 ��Ϣ�Ƽ����������� ����Ҫ��Ϣ�Ƽ���������ṩ�̽��о�ְ���� ������ѿ�չ��ְ�������Ҫ��Ϣ�Ƽ���������ṩ�̵�����������Ϊ�գ�\n";
	}
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	if (obj_YN04_07.value == "") {
		errorObjs.push(obj_YN04_07);
		isValid = false;
		a += "��Ϣ�Ƽ���������������4 ��Ϣ�Ƽ����������� ��ȡ����Ϣ�Ƽ������ȫ�����ʩ������Ϊ�գ�\n";
	}
	//�������жȷ��չ���
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	if (obj_YN05_03.value == "") {
		errorObjs.push(obj_YN05_03);
		isValid = false;
		a += "��Ϣ�Ƽ���������������5 �������жȷ��չ��� ��Ծ��л������ж��ص����Ϣ�Ƽ���������ṩ�̲�ȡ�Ŀ����ֶΣ�����Ϊ�գ�\n";
	}
	// �羳����פ���������
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02, obj_YN06_01.rownumber);
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if (obj_YN06_01.value == "��") {
		if(obj_YN06_02.value == ""){
			errorObjs.push(obj_YN06_02);
			isValid = false;
			a += "��Ϣ�Ƽ���������������6 �羳����פ��������� �Ƿ������Ϣ�Ƽ��羳��� ��ȷ��Ϣ�Ƽ��羳��������ṩ�����ڹ��һ������ܵ������������ǩ���½ⱸ��¼������Ϊ�գ�\n";
		}
		if(obj_YN06_03.value == ""){
			errorObjs.push(obj_YN06_03);
			isValid = false;
			a += "��Ϣ�Ƽ���������������6 �羳����פ��������� �Ƿ������Ϣ�Ƽ��羳��� ����������ʱ���õķ��ɣ�����Ϊ�գ�\n";
		}
		
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	var obj_YN06_06 = getTableFormObj(label_YN06_06, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "��") {
		if(obj_YN06_05.value == ""){
			errorObjs.push(obj_YN06_05);
			isValid = false;
			a += "��Ϣ�Ƽ���������������6 �羳����פ��������� �Ƿ������Ϣ�Ƽ��羳��� ����Ҫ��Ϣ�Ƽ���פ������������ʵ�ؼ�飢����Ϊ�գ�\n";
		}
		if(obj_YN06_05.value == "��" && obj_YN06_06.value == ""){
			errorObjs.push(obj_YN06_06);
			isValid = false;
			a += "��Ϣ�Ƽ���������������6 �羳����פ��������� �Ƿ������Ϣ�Ƽ��羳��� ���Ƶ�ʣ�����Ϊ�գ�\n";
		}
		
	}
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
 * ��ʼ��
 */
function initSet() {
	var obj = 0;
	setYN01_02_03Disable(obj);
	setYN01_05Disable(obj);
	setYN01_07Disable(obj);
	setYN03_02_03Disable(obj);
	setYN02_02_03Disable(obj);
	checkYN04_03Disable(obj);
	setYN06_02_03Disable(obj);
	setYN06_05_06Disable(obj);
}
/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
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
 * ���ܣ��жϱ������Ƿ����100
 */
function checkPercent(obj) {
	if (obj.value > 100 || obj.value < 0) {
		obj.value = "";
		alert("������0-100����ֵ");
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
/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio2(obj, access, flag,clickfunction) {
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
						jQuery(imgs[k]).unbind("click");
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							jQuery(imgs[k]).bind("click",function(){
								columnVallueRadio(this);
								clickfunction(this);
							});
						}
					}
				}
			}
		}
	}
}

jQuery(function(){
	jQuery("div[name = 'textarea_show_value']").css("width","160px");
});