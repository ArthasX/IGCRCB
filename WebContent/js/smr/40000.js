/*
 * ����2014 -T-B-1 ��Ϣ�Ƽ����������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs=[];

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

//����֤
function checkData(){
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	//���ӱ���У��  start
	var obj_TITLE_01 = getTableFormObj("����#�����","1");
	if(obj_TITLE_01){
		if(obj_TITLE_01.value == ""){
			errorObjs.push(obj_TITLE_01);
			isValid = false;
			a += "����Ų���Ϊ�գ�\n";
		}
	}
	var obj_TITLE_02 = getTableFormObj("����#���","1");
	if(obj_TITLE_02){
		if(obj_TITLE_02.value == ""){
			errorObjs.push(obj_TITLE_02);
			isValid = false;
			a += "��˲���Ϊ�գ�\n";
		}
	}
	var obj_TITLE_03 = getTableFormObj("����#��ϵ�绰","1");
	if(obj_TITLE_03){
		if(obj_TITLE_03.value == ""){
			errorObjs.push(obj_TITLE_03);
			isValid = false;
			a += "��ϵ�绰����Ϊ�գ�\n";
		}
	}
	var obj_TITLE_04 = getTableFormObj("����#������","1");
	if(obj_TITLE_04){
		if(obj_TITLE_04.value == ""){
			errorObjs.push(obj_TITLE_04);
			isValid = false;
			a += "�����˲���Ϊ�գ�\n";
		}
	}
	var obj_TITLE_05 = getTableFormObj("����#�������","1");
	if(obj_TITLE_05){
		if(obj_TITLE_05.value == ""){
			errorObjs.push(obj_TITLE_05);
			isValid = false;
			a += "������ڲ���Ϊ�գ�\n";
		}
	}
	// ����ʱ��
	var obj_YN01 = getTableFormObjs("#��ģʽ#����ʱ��#����#ʱ��");
	for(var i = 0;i<obj_YN01.length;i++){
		var obj_YN01_01 = obj_YN01[i];
		var obj_YN01_01_num = obj_YN01_01.rownumber.indexOf("_#_");
		if(obj_YN01_01.value == "" && obj_YN01_01_num != "0"){
			errorObjs.push(obj_YN01_01);
			isValid = false;
			a += "������Ӳ����Ʒȱ����Ϣ��"+(i+1)+":'����ʱ��'����Ϊ�գ�\n";
		}
	}
	// ȱ����Ϣ������ϵ��,��ϵ��
	var obj_YN03 = getTableFormObjs("#��ģʽ#ȱ����Ϣ������ϵ��#����#��ϵ��");
	for(var i = 0;i<obj_YN03.length;i++){
		var obj_YN03_01 = obj_YN03[i];
		var obj_YN03_01_num = obj_YN03_01.rownumber.indexOf("_#_");
		if(obj_YN03_01.value == "" && obj_YN03_01_num != "0"){
			errorObjs.push(obj_YN03_01);
			isValid = false;
			a += "������Ӳ����Ʒȱ����Ϣ��"+(i+1)+":'ȱ����Ϣ������ϵ�� ��ϵ��'����Ϊ�գ�\n";
		}
	}
	// ȱ����Ϣ������ϵ��,��ϵ�绰
	var obj_YN02 = getTableFormObjs("#��ģʽ#ȱ����Ϣ������ϵ��#����#��ϵ�绰");
	for(var i = 0;i<obj_YN02.length;i++){
		var obj_YN02_01 = obj_YN02[i];
		var obj_YN02_01_num = obj_YN02_01.rownumber.indexOf("_#_");
		if(obj_YN02_01.value == "" && obj_YN02_01_num != "0"){
			errorObjs.push(obj_YN02_01);
			isValid = false;
			a += "������Ӳ����Ʒȱ����Ϣ��"+(i+1)+":'ȱ����Ϣ������ϵ�� ��ϵ�绰'����Ϊ�գ�\n";
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