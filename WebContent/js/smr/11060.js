/*
 * ����2014 - T-B-3 ��Ϣ�Ƽ����ⲿ�������� 
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs=[];
//��Ϣ�Ƽ����ⲿ�������� 
var label_YN11 = "��Ϣ�Ƽ����ⲿ��������#��Ŀ״̬";
var label_YN11_01 = "��Ϣ�Ƽ����ⲿ��������#����ʱ��";
//������
var label_item95 = "��Ϣ�Ƽ����ⲿ��������#������";
//��ʼʱ��
var label_YN02_01 = "��Ϣ�Ƽ����ⲿ��������#��ʼʱ��";
//����ʱ��
var label_YN02_02 = "��Ϣ�Ƽ����ⲿ��������#����ʱ��";
//�������Ϣ�Ƽ���Ƹ���һ����֧�����İٷֱ� 
var label_item105 = "�ٷֱ�#�������Ϣ�Ƽ���Ƹ���һ����֧�����İٷֱ�";
//��Ʒ�������
var label_YN_03_01 = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#�߷���";
var label_YN_03_02 = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#�з���";
var label_YN_03_03 = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#�ͷ���";
//����������
var label_YN_04_01 = "��Ϣ�Ƽ����ⲿ��������#����������#�߷���";	
var label_YN_04_02 = "��Ϣ�Ƽ����ⲿ��������#����������#�з���";	
var label_YN_04_03 = "��Ϣ�Ƽ����ⲿ��������#����������#�ͷ���";	
var label_item5 = "��Ϣ�Ƽ����ⲿ��������#��Ŀ����";
var label_empty = "���Ϳձ���#���Ϳձ�";
/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length-1;i++){
		var obj_YN11 = getTableFormObj(label_YN11,objs[i].rownumber);
		var obj_YN11_01 = getTableFormObj(label_YN11_01,obj_YN11.rownumber);
		if(obj_YN11.value.trim() == "������" || obj_YN11.value.trim() == "")
		{
			//ֻ��
			obj_YN11_01.onclick = "";
			//���
			obj_YN11_01.value = "";
		}else if(obj_YN11.value.trim() == "�����"){
			obj_YN11_01.onclick = click_columnshowDate;
		}
	}
}

/*
* ���ܣ���Ŀ״̬Ϊ�����н���ʱ������Ϊ�գ����ҵ���¼�ȡ��
* ���ã��걨����
*/
function setItem11Disable(obj){
	var rownumber = "1";
	if(obj.flag == "������"){
		rownumber = obj.parentElement.nextSibling.nextSibling.nextSibling.nextSibling.rownumber;
	}else if(obj.flag == "�����"){
		rownumber = obj.parentElement.nextSibling.nextSibling.rownumber;
	}
	var obj_YN11 = getTableFormObj(label_YN11, rownumber);
	var obj_YN11_01 = getTableFormObj(label_YN11_01,rownumber);
	if (obj_YN11.value.trim() == "������" || obj_YN11.value.trim() == "") {
		// ֻ��
		obj_YN11_01.onclick = "";
		// ���
		obj_YN11_01.value = "";
	} else if (obj_YN11.value.trim() == "�����") {
		obj_YN11_01.onclick = click_columnshowDate;
	}
}

/*
 *���ܣ��жϱ������Ƿ����100
 *���ã���Ϣ�Ƽ����ⲿ��������#������
 */
function checkItem95(obj){
	var rownumber = obj.rownumber;
	var obj_item95 = getTableFormObj(label_item95,rownumber);
	if (obj_item95.value > 100) {
		alert("�밴�淶��д�����ʣ������ʲ��ܴ���100\n");
		obj_item95.value = "";
	}
	if (obj_item95.value < 0) {
		alert("�밴�淶��д�����ʣ������ʲ���С��0\n");
		obj_item95.value = "";
	}
//	var objs = getTableFormObjs(label_item5);
//	for(var i = 0;i<objs.length;i++){
//		var obj_item95 = getTableFormObj(label_item95,objs[i].rownumber);
//		if(obj_item95.value>100){
//			alert("�밴�淶��д�����ʣ������ʲ��ܴ���100\n");
//			obj_item95.value = ""; 
//		}
//		if(obj_item95.value<0){
//			alert("�밴�淶��д�����ʣ������ʲ���С��0\n");
//			obj_item95.value = ""; 
//		}
//	}
	
}

/*
 *���ܣ��жϱ������Ƿ����100
 *���ã��������Ϣ�Ƽ���Ƹ���һ����֧�����İٷֱ� 
 */
function checkItem105(obj){
	var obj_item105 = getTableFormObj(label_item105,"1");
	if(obj_item105.value>100){
		alert("�밴�淶��д�������Ϣ�Ƽ���Ƹ���һ����֧�����İٷֱȣ���ֵ���ܴ���100\n");
		obj_item105.value = ""; 
	}
}

/*
* ���ܣ�У����ֹ���ڵĴ�С
* ���ã���Ϣ�Ƽ����ⲿ��������#����ʱ��
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
//	var objs = getTableFormObjs(label_item5);
//	for(var i = 0;i<objs.length;i++){
//		var obj_YN02_01 = getTableFormObj(label_YN02_01,objs[i].rownumber);
//		var obj_YN02_02 = getTableFormObj(label_YN02_02,objs[i].rownumber);
//		if(obj_YN02_01.value != "" && obj_YN02_02.value != ""){
//			if(obj_YN02_01.value > obj_YN02_02.value){
//				 alert("�������ڲ���С�ڿ�ʼ���ڣ�");
//				 obj_YN02_01.value = "";
//			}
//		}
//	}
	
}

/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
};
/*
 *���ܣ��ύУ��
 */
function checkData(){
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length;i++){
		//У����Ʒ�������������������
		var obj_YN_03_01 = getTableFormObj(label_YN_03_01,objs[i].rownumber + "_1");
		var obj_YN_03_02 = getTableFormObj(label_YN_03_02,objs[i].rownumber + "_1");
		var obj_YN_03_03 = getTableFormObj(label_YN_03_03,objs[i].rownumber + "_1");
		var obj_YN_04_01 = getTableFormObj(label_YN_04_01,objs[i].rownumber + "_1");
		var obj_YN_04_02 = getTableFormObj(label_YN_04_02,objs[i].rownumber + "_1");
		var obj_YN_04_03 = getTableFormObj(label_YN_04_03,objs[i].rownumber + "_1");
		//�ж������������������Ƿ����У����Ʒ�������
		//�߷���
		if(obj_YN_04_01.value !=""){
			if(obj_YN_03_01.value != "" && parseInt(obj_YN_04_01.value) > parseInt(obj_YN_03_01.value)){
				errorObjs.push(obj_YN_03_01);
				errorObjs.push(obj_YN_04_01);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�߷���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}else if(obj_YN_03_01.value == ""){
				errorObjs.push(obj_YN_03_01);
				errorObjs.push(obj_YN_04_01);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�߷���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}
		}
		//�з���
		if(obj_YN_04_02.value !=""){
			if(obj_YN_03_02.value != "" && parseInt(obj_YN_04_02.value) > parseInt(obj_YN_03_02.value)){
				errorObjs.push(obj_YN_03_02);
				errorObjs.push(obj_YN_04_02);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�з���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}else if(obj_YN_03_02.value == ""){
				errorObjs.push(obj_YN_03_02);
				errorObjs.push(obj_YN_04_02);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�з���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}
		}
		//�ͷ���
		if(obj_YN_04_03.value !=""){
			if(obj_YN_03_03.value != "" && parseInt(obj_YN_04_03.value) > parseInt(obj_YN_03_03.value)){
				errorObjs.push(obj_YN_03_03);
				errorObjs.push(obj_YN_04_03);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�ͷ���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}else if(obj_YN_03_03.value == ""){
				errorObjs.push(obj_YN_03_03);
				errorObjs.push(obj_YN_04_03);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"��������(�ͷ���)Ӧ���ڵ�������������(�߷���)"+"��\n";
				isValid = false;
			}
		}
	}
	
	var objs = getTableFormObjs(label_item5);
	for(var i = 0;i<objs.length;i++){
		var obj_YN11 = getTableFormObj(label_YN11,objs[i].rownumber);
		var obj_YN11_01 = getTableFormObj(label_YN11_01,obj_YN11.rownumber);
		 if(obj_YN11.value.trim() == "�����" && obj_YN11_01.value == ""){
			 errorObjs.push(obj_YN11_01);
				a+="��Ϣ�Ƽ����ⲿ��������"+objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length)+"����"+"����ʱ�䲻��Ϊ�գ�"+"��\n";
				isValid = false;

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
	var emptyObj = getTableFormObjs(label_empty)[0];
	if(emptyObj.value == ""){
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
	}else if(emptyObj.value == "���Ϳձ�"){
		isValid = true;
	}
	return isValid;
}

/*
 *���ܣ����ֿؼ�����0
 */
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("�밴�淶��д"+errorMessage+"����ֵ����С��0\n");
	}
}
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
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
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
