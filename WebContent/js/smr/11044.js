/*
 * ����2014 -T-B-2 ��Ϣ�Ƽ����չ��������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs=[];
var label_YN01_03 = "��Ϣ�Ƽ����չ����ƶ�#����#���������ƶ���Ϣ�Ƽ����չ����ƶȵĲ���";
//��Ϣ�Ƽ����������봦�ñ�
var label_YN02_01 = "��Ϣ�Ƽ����������봦��#����#1#������ֹʱ��#1";
var label_YN02_02 = "��Ϣ�Ƽ����������봦��#����#1#������ֹʱ��#2";
//��Ϣ�Ƽ����ռ���
var label_YN03_01 = "��Ϣ�Ƽ����ռ��#����#������Ϣ�Ƽ����ռ��ؼ����յ�ָ��";
var label_YN03_02 = "��Ϣ�Ƽ����ռ��#����#�ؼ����յ�ָ������";
var label_YN03_03 = "��Ϣ�Ƽ����ռ��#����#����ȷ��ռ���������ز��Ž��з�����ʾ";
var label_YN03_04 = "��Ϣ�Ƽ����ռ��#����#������ʾ����";
var label_YN03_05 = "��Ϣ�Ƽ����ռ��#����#����ȷ��ռ������߹ܲ�㱨";
var label_YN03_06 = "��Ϣ�Ƽ����ռ��#����#�㱨����";
var label_YN03_07 = "��Ϣ�Ƽ����ռ��#����#ʵʩ��Ϣ�Ƽ����ռ��Ĳ���";
//��Ϣ�Ƽ���������
var label_YN04_01 = "��Ϣ�Ƽ���������#����#����ȶ���Ϣ�Ƽ������¼���������";
var label_YN04_02 = "��Ϣ�Ƽ���������#����#�����˴�";
//��Ϣ�Ƽ����չ�������Ľ�
var label_YN05_01 = "��Ϣ�Ƽ����չ�������Ľ�#����#����Ϣ�Ƽ����չ����ƶȶ����޶��������޶�����ƶ���ʽ����";
var label_YN05_02 = "��Ϣ�Ƽ����չ�������Ľ�#����#�޶�����";
var label_YN05_03 = "��Ϣ�Ƽ����չ�������Ľ�#����#�Է����������������̡����ռ��ָ�궨�ڽ�������";
var label_YN05_04 = "��Ϣ�Ƽ����չ�������Ľ�#����#����Ƶ��";
//������
var label_YN01_02 = "��Ϣ�Ƽ����������봦��#����#���մ��ô�ʩ��ʵ����ļල����";


/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	setYN03_02Disable(obj);
	setYN03_04Disable(obj);
	setYN03_06Disable(obj);
	setYN04_02Disable(obj);
	setYN05_02Disable(obj);
	setYN05_04Disable(obj);
}

//��ѡ������ֵΪ��������
function setOtherValue(obj){
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	alert(obj_YN01_03.value);
} 

/*
* ���ܣ�У����ֹ���ڵĴ�С
* ���ã���Ϣ�Ƽ����������봦��#����#1#������ֹʱ��
*/
function checkChangeDate(obj){
	var rownumber = obj.rownumber;
	var obj_YN02_01 = getTableFormObj(label_YN02_01,rownumber);
	var obj_YN02_02 = getTableFormObj(label_YN02_02,rownumber);
	if(obj_YN02_01.value != "" && obj_YN02_02.value != ""){
		if(obj_YN02_01.value > obj_YN02_02.value){
			 alert("�������ڲ���С�ڿ�ʼ���ڣ�");
			 obj_YN02_01.value = "";
		}
	}
}

/*
* ���ܣ�������ʾ�����Ƿ��д
* ���ã���Ϣ�Ƽ����ռ��#����#�ؼ����յ�ָ������
*/
function setYN03_02Disable(objcld){
	var objYN03_01 = getTableFormObjs(label_YN03_01)[0];
	var objYN03_02 = getTableFormObj(label_YN03_02,objYN03_01.rownumber );
	if (objYN03_01.value.trim() == "��" || objYN03_01.value.trim() == "") {
		//ֻ��
		objYN03_02.readOnly = "readonly";
		//���
		objYN03_02.value = "";
	}else if (objYN03_01.value.trim() == "��") {
		objYN03_02.readOnly = "";
	}
}

/*
* ���ܣ��ؼ����յ�ָ�������Ƿ��д
* ���ã���Ϣ�Ƽ����ռ��#����#������ʾ����
*/
function setYN03_04Disable(objcld){
	var objYN03_03 = getTableFormObjs(label_YN03_03)[0];
	var objYN03_04 = getTableFormObj(label_YN03_04,objYN03_03.rownumber );
	if (objYN03_03.value.trim() == "��" || objYN03_03.value.trim() == "") {
		//ֻ��
		objYN03_04.readOnly = "readonly";
		//���
		objYN03_04.value = "";
	}else if (objYN03_03.value.trim() == "��") {
		objYN03_04.readOnly = "";
	}
}

/*
* ���ܣ��㱨�����Ƿ��д
* ���ã���Ϣ�Ƽ����ռ��#����#�㱨����
*/
function setYN03_06Disable(objcld){
	var objYN03_05 = getTableFormObjs(label_YN03_05)[0];
	var objYN03_06 = getTableFormObj(label_YN03_06,objYN03_05.rownumber );
	if (objYN03_05.value.trim() == "��" || objYN03_05.value.trim() == "") {
		//ֻ��
		objYN03_06.readOnly = "readonly";
		//���
		objYN03_06.value = "";
	}else if (objYN03_05.value.trim() == "��") {
		objYN03_06.readOnly = "";
	}
}

/*
* ���ܣ������˴��Ƿ��д 
* ���ã���Ϣ�Ƽ���������#����#�����˴�
*/
function setYN04_02Disable(objcld){
	var objYN04_01 = getTableFormObjs(label_YN04_01)[0];
	var objYN04_02 = getTableFormObj(label_YN04_02,objYN04_01.rownumber );
	if (objYN04_01.value.trim() == "��" || objYN04_01.value.trim() == "") {
		//ֻ��
		objYN04_02.readOnly = "readonly";
		//���
		objYN04_02.value = "";
	}else if (objYN04_01.value.trim() == "��") {
		objYN04_02.readOnly = "";
	}
}

/*
* ���ܣ��޶������Ƿ��д 
* ���ã���Ϣ�Ƽ����չ�������Ľ�#����#�޶�����
*/
function setYN05_02Disable(objcld){
	var objYN05_01 = getTableFormObjs(label_YN05_01)[0];
	var objYN05_02 = getTableFormObj(label_YN05_02,objYN05_01.rownumber );
	if (objYN05_01.value.trim() == "��" || objYN05_01.value.trim() == "") {
		//ֻ��
		objYN05_02.readOnly = "readonly";
		//���
		objYN05_02.value = "";
	}else if (objYN05_01.value.trim() == "��") {
		objYN05_02.readOnly = "";
	}
}

/*
* ���ܣ�����Ƶ���Ƿ��д 
* ���ã���Ϣ�Ƽ����չ�������Ľ�#����#����Ƶ��
*/
function setYN05_04Disable(objcld){
	var objYN05_03 = getTableFormObjs(label_YN05_03)[0];
	var objYN05_04 = getTableFormObj(label_YN05_04,objYN05_03.rownumber );
	if (objYN05_03.value.trim() == "��" || objYN05_03.value.trim() == "") {
		//ֻ��
		objYN05_04.readOnly = "readonly";
		//���
		objYN05_04.value = "";
	}else if (objYN05_03.value.trim() == "��") {
		objYN05_04.readOnly = "";
	}
}
//����֤
function checkData(){
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	//��Ϣ�Ƽ����ռ���У��
	var objYN03_01 = getTableFormObjs(label_YN03_01)[0];
	var objYN03_02 = getTableFormObj(label_YN03_02,objYN03_01.rownumber );
	if (objYN03_01.value.trim() == "��" && objYN03_02.value =="") {
		errorObjs.push(objYN03_02);
		a+="��Ϣ�Ƽ����ռ��-�ؼ����յ�ָ�����������Ϊ�գ�\n";
		isValid=false;
	}
	var objYN03_03 = getTableFormObjs(label_YN03_03)[0];
	var objYN03_04 = getTableFormObj(label_YN03_04,objYN03_03.rownumber );
	if (objYN03_03.value.trim() == "��" && objYN03_04.value == "") {
		errorObjs.push(objYN03_04);
		a+="��Ϣ�Ƽ����ռ��-������ʾ���������Ϊ�գ�\n";
		isValid=false;
	}
	var objYN03_05 = getTableFormObjs(label_YN03_05)[0];
	var objYN03_06 = getTableFormObj(label_YN03_06,objYN03_05.rownumber );
	if (objYN03_05.value.trim() == "��" && objYN03_06.value == "") {
		errorObjs.push(objYN03_06);
		a+="��Ϣ�Ƽ����ռ��-�㱨���������Ϊ�գ�\n";
		isValid=false;
	}
	//��Ϣ�Ƽ���������У��
	var objYN04_01 = getTableFormObjs(label_YN04_01)[0];
	var objYN04_02 = getTableFormObj(label_YN04_02,objYN04_01.rownumber );
	if (objYN04_01.value.trim() == "��" && objYN04_02.value =="") {
		errorObjs.push(objYN04_02);
		a+="��Ϣ�Ƽ���������-�����˴������Ϊ�գ�\n";
		isValid=false;
	}
	//��Ϣ�Ƽ����չ�������Ľ�У��
	var objYN05_01 = getTableFormObjs(label_YN05_01)[0];
	var objYN05_02 = getTableFormObj(label_YN05_02,objYN05_01.rownumber );
	if (objYN05_01.value.trim() == "��" && objYN05_02.value =="") {
		errorObjs.push(objYN05_02);
		a+="��Ϣ�Ƽ����չ�������Ľ�-�޶����������Ϊ�գ�\n";
		isValid=false;
	}
	var objYN05_03 = getTableFormObjs(label_YN05_03)[0];
	var objYN05_04 = getTableFormObj(label_YN05_04,objYN05_03.rownumber );
	if (objYN05_03.value.trim() == "��" && objYN05_04.value == "") {
		errorObjs.push(objYN05_04);
		a+="��Ϣ�Ƽ����ռ��-������ʾ���������Ϊ�գ�\n";
		isValid=false;
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

function checkBoxValue(obj){
	var obj = getTableFormObjs(label_YN01_02)[0];
}

/*
* ���ܣ����ֿؼ�����0
* 
*/
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("�밴�淶��д"+errorMessage+"����ֵ����С��0\n");
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
