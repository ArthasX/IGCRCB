/*
 * ����2014-T-Q-03 ������Ҫ��Ϣϵͳ��������� 
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

var label_YN01 = "������Ҫ��Ϣϵͳ#��ģʽ#ϵͳ����#ϵͳ����";
var label_YN05_04 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#Ӱ�췶Χ#��֧������";
var label_YN01_01 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ֹͣ����ԭ��";
var label_YN01_02 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#�¼��ȼ�";
var label_YN01_03_01 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#��ʼʱ��";
var label_YN01_03_02 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#ʱ";
var label_YN01_03_03 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#��";
var label_YN01_04_01 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#����ʱ��";
var label_YN01_04_02 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#ʱ";
var label_YN01_04_03 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#��";
var label_YN01_05_01 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#�ж�ʱ�乲#�ж�ʱ�乲";
var label_YN01_04 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#Ӱ�췶Χ#Ӱ�췶Χ";
var label_YN04_04 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#Ӱ�췶Χ#��֧����";
var label_YN01_06 = "������Ҫ��Ϣϵͳ#��ģʽ#��Ԥ��ֹͣ����#����#����";

var label_YN02_01 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ֹͣ����ԭ��";
var label_YN02_03_01 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#��ʼʱ��";
var label_YN02_03_02 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#ʱ";
var label_YN02_03_03 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#��ʼʱ��#��";
var label_YN02_04_01 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#����ʱ��";
var label_YN02_04_02 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#ʱ";
var label_YN02_04_03 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#����ʱ��#��";
var label_YN02_05_01 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#ҵ���жϵ���ֹʱ��#�ж�ʱ�乲#�ж�ʱ�乲";
var label_YN02_04 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#Ӱ�췶Χ#Ӱ�췶Χ1";
var label_YN06_04 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#Ӱ�췶Χ#��֧������";
var label_YN02_06 = "������Ҫ��Ϣϵͳ#��ģʽ#Ԥ��ֹͣ����#����#����";

var label_YN03_01 = "������Ҫ��Ϣϵͳ#��ģʽ#ϵͳ��Ҫ����ָ��#3#1#1#1#��˾�˻�";
var label_YN03_02 = "������Ҫ��Ϣϵͳ#��ģʽ#ϵͳ��Ҫ����ָ��#3#1#2#����#�����˻�";
/*
 *ϵͳ����ѡ�����ҵ��ϵͳ��ϵͳ�����ʿ������ֻ�� 
 */
function checkSystemData(obj){
	if(obj){
		var inputObj = jQuery(obj.parentElement.parentElement).children()[8];
		var inputValue = getTableFormObj(label_YN01,inputObj.value);
		var obj_YN03_01 = getTableFormObj(label_YN03_01,inputObj.value+"_1_1_1_1");
		var obj_YN03_02 = getTableFormObj(label_YN03_02,inputObj.value+"_1_1_1_1");
		if(inputValue.value == "����ҵ��ϵͳ"){
			obj_YN03_01.readOnly = "";
			obj_YN03_02.readOnly = "";
		}else{
			obj_YN03_01.readOnly = "readonly";
			obj_YN03_02.readOnly = "readonly";
			obj_YN03_01.value = "";
			obj_YN03_02.value = "";
		}
	
	}else{
		var obj_YN01Arr = getTableFormObjs(label_YN01);
		for(var i = 0;i<obj_YN01Arr.length;i++){
			var obj_YN01Obj = obj_YN01Arr[i];
			var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN01Obj.rownumber+"_1_1_1_1");
			var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN01Obj.rownumber+"_1_1_1_1");
			if(obj_YN01Obj.value == "����ҵ��ϵͳ"){
				obj_YN03_01.readOnly = "";
				obj_YN03_02.readOnly = "";
			}else{
				obj_YN03_01.readOnly = "readonly";
				obj_YN03_02.readOnly = "readonly";
				obj_YN03_01.value = "";
				obj_YN03_02.value = "";
			}
			
		}
	}
	
}
/*
 * ���ܣ���ʼ��
 */
function initSet(){
	var obj_YN02_04Arr = getTableFormObjs(label_YN02_04);
	for(var i = 0;i<obj_YN02_04Arr.length;i++){
		var obj_YN02_04 = obj_YN02_04Arr[i];
		var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN02_04.rownumber);
		if(obj_YN02_04.value == "��֧����"){
			
		}else{
			obj_YN06_04.readOnly = "readonly";
		}
	}
	var obj_YN01_04Arr = getTableFormObjs(label_YN01_04);
	for(var i = 0;i<obj_YN01_04Arr.length;i++){
		var obj_YN01_04 = obj_YN01_04Arr[i];
		var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN01_04.rownumber);
		if(obj_YN01_04.value == "��֧����"){
			
		}else{
			obj_YN04_04.readOnly = "readonly";
		}
	}
	checkSystemData(null);
}
/*
 * У��Сʱ�Ƿ�������ȷ
 */
function checkMinute(obj){
	if(parseInt(obj.value)>59){
		obj.value = "";
		alert("���벻�Ϸ���������С��60��������");
	}
}

/*
 * У��Сʱ�Ƿ�������ȷ
 */
function checkHour(obj){
	if(parseInt(obj.value)>23){
		obj.value = "";
		alert("���벻�Ϸ���������С��24��������");
	}
}
/*
 * ��ʼʱ��ͽ���ʱ��У��
 */
function checkEndTime1(obj){
	var endId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))+1)+"_"+obj.rownumber;
	var endObj = document.getElementById(endId);
	if(obj.value !="" &&endObj.value !=""){
		if(obj.value>endObj.value){
			endObj.value = "";
			alert("ҵ���жϵ���ֹʱ�����ʱ�䲻ӦС����ʼʱ�䣡");
		}
	}
}
/*
 * ��ʼʱ��ͽ���ʱ��У��
 */
function checkStartTime1(obj){
	var startId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))-1)+"_"+obj.rownumber;
	var startObj = document.getElementById(startId);
	if(obj.value !="" &&startObj.value !=""){
		if(obj.value<startObj.value){
			obj.value = "";
			alert("ҵ���жϵ���ֹʱ�����ʱ�䲻ӦС����ʼʱ�䣡");
		}
	}
}

/*
 * ��ʼʱ��ͽ���ʱ��У��
 */
function checkEndTime(obj){
	var endId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))+2)+"_"+obj.rownumber;
	var endObj = document.getElementById(endId);
	if(obj.value !="" &&endObj.value !=""){
		if(obj.value>endObj.value){
			endObj.value = "";
			alert("ҵ���жϵ���ֹʱ�����ʱ�䲻ӦС����ʼʱ�䣡");
		}
	}
}
/*
 * ��ʼʱ��ͽ���ʱ��У��
 */
function checkStartTime(obj){
	var startId = (parseInt(obj.id.substring(0,obj.id.indexOf("_")))-2)+"_"+obj.rownumber;
	var startObj = document.getElementById(startId);
	if(obj.value !="" &&startObj.value !=""){
		if(obj.value<startObj.value){
			obj.value = "";
			alert("ҵ���жϵ���ֹʱ�����ʱ�䲻ӦС����ʼʱ�䣡");
		}
	}
}
/*
 * ͨ��Ӱ�췶Χ��������Χ�����ǲ���ֻ��
 */
function setCountDisable(obj){
	var inputObj = obj.parentElement.parentElement.parentElement.nextSibling.firstChild.firstChild;
	if(obj.flag == "��֧����"){
		inputObj.readOnly = "";
	}else{
		inputObj.readOnly = "readonly";
		inputObj.value = "";
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

function delNull(){
//	var sbObj = getTableFormObjs(label_StopBecause);
//	for(var i = 0;i<sbObj.length;i++){
//		if(sbObj[i].previousSibling){
//			if(sbObj[i].previousSibling.innerHTML == "null"){
//				sbObj[i].previousSibling.innerHTML = "";
//			}
//		}
//	}
	
}

/*
 * У���Ƿ�С��0
 * 
 */
function checkGreaterZero(obj){
	if(parseFloat(obj.value)<0){
		obj.value = "";
		alert("��ֵӦ�ô���0�����������룡");
	}
}


function checkData(){
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//��Ԥ��
	var obj_YN01_01Arr = getTableFormObjs(label_YN01_01);
	for(var i = 0;i<obj_YN01_01Arr.length;i++){
		var obj_YN01_01 = obj_YN01_01Arr[i];
		if(obj_YN01_01.value != ""){
			var obj_YN01_02 = getTableFormObj(label_YN01_02,obj_YN01_01.rownumber);
			var obj_YN01_03_01 = getTableFormObj(label_YN01_03_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_03_02 = getTableFormObj(label_YN01_03_02,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_03_03 = getTableFormObj(label_YN01_03_03,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_01 = getTableFormObj(label_YN01_04_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_02 = getTableFormObj(label_YN01_04_02,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04_03 = getTableFormObj(label_YN01_04_03,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_05_01 = getTableFormObj(label_YN01_05_01,obj_YN01_01.rownumber+"_1_1");
			var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_01.rownumber+"_1");
			var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN01_01.rownumber+"_1");
			var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_01.rownumber);
			
			if(obj_YN01_02.value == ""){
				a +="��Ԥ��ֹͣ�����¼��ȼ� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_02);
				isValid = false;
			}
			if(obj_YN01_03_01.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_03_01);
				isValid = false;
			}
			if(obj_YN01_03_02.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� ʱ ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_03_02);
				isValid = false;
			}
			if(obj_YN01_03_03.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� �� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_03_03);
				isValid = false;
			}
			if(obj_YN01_04_01.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_04_01);
				isValid = false;
			}
			if(obj_YN01_04_02.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� ʱ ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_04_02);
				isValid = false;
			}
			if(obj_YN01_04_03.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� �� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_04_03);
				isValid = false;
			}
			if(obj_YN01_05_01.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� �ж�ʱ�䲻��Ϊ�գ�\n";
				errorObjs.push(obj_YN01_05_01);
				isValid = false;
			}
			if(obj_YN01_04.value == ""){
				a +="��Ԥ��ֹͣ����Ӱ�췶Χ����Ϊ�գ�\n";
				errorObjs.push(obj_YN01_04);
				isValid = false;
			}else if(obj_YN01_04.value == "��֧����" && obj_YN04_04.value == ""){
				a +="��Ԥ��ֹͣ����Ӱ�췶Χ��������Ϊ�գ�\n";
				errorObjs.push(obj_YN04_04);
				isValid = false;
			}
			if(obj_YN01_06.value == ""){
				a +="��Ԥ��ֹͣ���񣺸�������Ϊ�գ�\n";
				errorObjs.push(obj_YN01_06);
				isValid = false;
			}
			
		}
	}
	//Ԥ��
	var obj_YN02_01Arr = getTableFormObjs(label_YN02_01);
	for(var i = 0;i<obj_YN02_01Arr.length;i++){
		var obj_YN02_01 = obj_YN02_01Arr[i];
		if(obj_YN02_01.value != ""){
			var obj_YN02_03_01 = getTableFormObj(label_YN02_03_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_03_02 = getTableFormObj(label_YN02_03_02,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_03_03 = getTableFormObj(label_YN02_03_03,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_01 = getTableFormObj(label_YN02_04_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_02 = getTableFormObj(label_YN02_04_02,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04_03 = getTableFormObj(label_YN02_04_03,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_05_01 = getTableFormObj(label_YN02_05_01,obj_YN02_01.rownumber+"_1_1");
			var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_01.rownumber+"_1");
			var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN02_01.rownumber+"_1");
			var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02_01.rownumber);
			
			if(obj_YN02_03_01.value == ""){
				a +="Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_03_01);
				isValid = false;
			}
			if(obj_YN02_03_02.value == ""){
				a +="Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� ʱ ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_03_02);
				isValid = false;
			}
			if(obj_YN02_03_03.value == ""){
				a +="Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ��ʼʱ�� �� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_03_03);
				isValid = false;
			}
			if(obj_YN02_04_01.value == ""){
				a +="Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_04_01);
				isValid = false;
			}
			if(obj_YN02_04_02.value == ""){
				a +="Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� ʱ ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_04_02);
				isValid = false;
			}
			if(obj_YN02_04_03.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� ����ʱ�� �� ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_04_03);
				isValid = false;
			}
			if(obj_YN02_05_01.value == ""){
				a +="��Ԥ��ֹͣ����ҵ���жϵ���ֹʱ�� �ж�ʱ�䲻��Ϊ�գ�\n";
				errorObjs.push(obj_YN02_05_01);
				isValid = false;
			}
			if(obj_YN02_04.value == ""){
				a +="Ԥ��ֹͣ����Ӱ�췶Χ����Ϊ�գ�\n";
				errorObjs.push(obj_YN02_04);
				isValid = false;
			}else if(obj_YN02_04.value == "��֧����" && obj_YN06_04.value == ""){
				a +="Ԥ��ֹͣ����Ӱ�췶Χ��������Ϊ�գ�\n";
				errorObjs.push(obj_YN06_04);
				isValid = false;
			}
			if(obj_YN02_06.value == ""){
				a +="��Ԥ��ֹͣ���񣺸�������Ϊ�գ�\n";
				errorObjs.push(obj_YN02_06);
				isValid = false;
			}
			
		}
		
	}
	//У���Ƿ�ѡ���˺���ҵ��ϵͳ��ѡ������У�����
	var obj_YN01Arr = getTableFormObjs(label_YN01);
	for(var i = 0;i<obj_YN01Arr.length-1;i++){
		var obj_YN01Obj = obj_YN01Arr[i];
		var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN01Obj.rownumber+"_1_1_1_1");
		var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN01Obj.rownumber+"_1_1_1_1");
		if(obj_YN01Obj.value == "����ҵ��ϵͳ"){
			if(obj_YN03_01.value ==""){
				a +="����ҵ��ϵͳ�˻�����˾�˻�����Ϊ�գ�\n";
				errorObjs.push(obj_YN03_01);
				isValid = false;
			}
			if(obj_YN03_02.value == ""){
				a +="����ҵ��ϵͳ�˻��������˻�����Ϊ�գ�\n";
				errorObjs.push(obj_YN03_02);
				isValid = false;
			}
		}
		
	}
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null) {
				errorObjs[i].style.backgroundColor = "red";
			} else if (errorObjs[i].previousSibling.innerHTML.indexOf("����") > -1) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.outerHTML.indexOf("DIV") > -1){
				
				errorObjs[i].previousSibling.style.backgroundColor = "red";
				
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
 * ȥ�������ڵ��NULL
 */
jQuery(function(){
	if(jQuery("#pdid").val()+"003" != jQuery("#psdid").val()){
		jQuery("span:contains('null')").html("");
	}
});