/*
 * ����T-B-7 ��Ҫ��Ϣϵͳ�����_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_DecimalField28_COL125 = "������#������2#�����������������";
var label_DecimalField28_COL126 = "�ֱ����#��������λ������1";

var label_YN01 = "��Ҫ��Ϣϵͳ�������#����#����ҵ��ϵͳ��ʵʩ�滻";
var label_YN01_1 = "��Ҫ��Ϣϵͳ�������#����#�滻ʱ��";
var label_YN02 = "��Ҫ��Ϣϵͳ�������#����#����ҵ��ϵͳ�ƻ�����ʵʩ�滻";
var label_YN02_1 = "��Ҫ��Ϣϵͳ�������#����#�ƻ��滻ʱ��";

var label_DecimalField1_GTZero = "����#��������λ������";
var label_DecimalField3_GTZero = "���#����";
var label_DecimalField10_GTZero = "�����ȼ�#����";
var label_DecimalField2_GTZero = "����ģʽ#��������λ������";
var label_DecimalField4_GTZero = "��άģʽ#��������λ������";
var label_DecimalField4_GTZero_2 = "֪ʶ��Ȩ#��������λ������";
var label_DecimalField28_GTZero = "�ֱ����#����";
var label_item4 = "����#�������";

var label_DecimalField16_GTZero = "�ֱ����#��������λ������";

/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	checkYN01(obj);
	checkYN02(obj);
}

/*
* ���ܣ�����ҵ��ϵͳ��ʵʩ�滻�� ѡ����ʱ�� �滻ʱ�䲻������
* ���ã���Ҫ��Ϣϵͳ�������#����#����ҵ��ϵͳ��ʵʩ�滻
*/
function checkYN01(obj){
	
	var obj_YN01 = getTableFormObjs(label_YN01)[0];
	var obj_YN01_1 = getTableFormObjs(label_YN01_1)[0];
	
	if(obj_YN01.value == "��"){
		obj_YN01_1.onclick = "";
		obj_YN01_1.value = "";
	}else{
		obj_YN01_1.onclick = click_columnshowDate;
	}
}

/*
* ���ܣ�����ҵ��ϵͳ�ƻ�����ʵʩ�滻�� ѡ����ʱ�� �ƻ��滻ʱ�䲻������
* ���ã���Ҫ��Ϣϵͳ�������#����#����ҵ��ϵͳ�ƻ�����ʵʩ�滻
*/
function checkYN02(obj){
	
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_1 = getTableFormObjs(label_YN02_1)[0];
	
	if(obj_YN02.value == "��"){
		obj_YN02_1.onclick = "";
		obj_YN02_1.value = "";
	}else{
		obj_YN02_1.onclick = click_columnshowDate;
	}
}

/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
* ���ܣ�����ύʱ���еı���֤
* ���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var obj_DecimalField28_COL125 = getTableFormObjs(label_DecimalField28_COL125)[0];
	checkNumFloat(obj_DecimalField28_COL125,2);

	var obj_DecimalField28_COL126 = getTableFormObjs(label_DecimalField28_COL126)[0];
	checkNumFloat(obj_DecimalField28_COL126,2); 
	
	var obj_DecimalField1_GTZero = getTableFormObjs(label_DecimalField1_GTZero);
	var obj_DecimalField3_GTZero = getTableFormObjs(label_DecimalField3_GTZero);
	
	if( parseInt(obj_DecimalField1_GTZero[0].value) >
			parseInt(obj_DecimalField3_GTZero[0].value) + parseInt(obj_DecimalField3_GTZero[1].value) +
				parseInt(obj_DecimalField3_GTZero[2].value) + parseInt(obj_DecimalField3_GTZero[3].value) +
					parseInt(obj_DecimalField3_GTZero[4].value) + parseInt(obj_DecimalField3_GTZero[5].value) +
						parseInt(obj_DecimalField3_GTZero[6].value)  ||  
		parseInt(obj_DecimalField1_GTZero[0].value) <
			parseInt(obj_DecimalField3_GTZero[0].value) + parseInt(obj_DecimalField3_GTZero[1].value) +
				parseInt(obj_DecimalField3_GTZero[2].value) + parseInt(obj_DecimalField3_GTZero[3].value) +
					parseInt(obj_DecimalField3_GTZero[4].value) + parseInt(obj_DecimalField3_GTZero[5].value) +
						parseInt(obj_DecimalField3_GTZero[6].value)){
		errorObjs.push(obj_DecimalField3_GTZero[0]);
		errorObjs.push(obj_DecimalField3_GTZero[1]);
		errorObjs.push(obj_DecimalField3_GTZero[2]);
		errorObjs.push(obj_DecimalField3_GTZero[3]);
		errorObjs.push(obj_DecimalField3_GTZero[4]);
		errorObjs.push(obj_DecimalField3_GTZero[5]);
		errorObjs.push(obj_DecimalField3_GTZero[6]);
	 	a+="��Ҫ��Ϣϵͳ����������������+�ͻ�������+��Ʒ������+���������+����֧����+����֧����+���������Ҫϵͳ��У�����\n";
	  	isValid=false;
	}
	var obj_DecimalField10_GTZero = getTableFormObjs(label_DecimalField10_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > 
			parseInt(obj_DecimalField10_GTZero[0].value) + parseInt(obj_DecimalField10_GTZero[1].value) +
				parseInt(obj_DecimalField10_GTZero[2].value) + parseInt(obj_DecimalField10_GTZero[3].value) +
					parseInt(obj_DecimalField10_GTZero[4].value)  ||
		parseInt(obj_DecimalField1_GTZero[0].value) < 
			parseInt(obj_DecimalField10_GTZero[0].value) + parseInt(obj_DecimalField10_GTZero[1].value) +
				parseInt(obj_DecimalField10_GTZero[2].value) + parseInt(obj_DecimalField10_GTZero[3].value) +
					parseInt(obj_DecimalField10_GTZero[4].value) ){
		errorObjs.push(obj_DecimalField10_GTZero[0]);
		errorObjs.push(obj_DecimalField10_GTZero[1]);
		errorObjs.push(obj_DecimalField10_GTZero[2]);
		errorObjs.push(obj_DecimalField10_GTZero[3]);
		errorObjs.push(obj_DecimalField10_GTZero[4]);
		a+="��Ҫ��Ϣϵͳ�����������ȼ� 1��+�����ȼ�2��+�����ȼ�3��+�����ȼ�4��+�����ȼ�5������\n";
		isValid=false;
	}
	
	var obj_DecimalField2_GTZero = getTableFormObjs(label_DecimalField2_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField2_GTZero[0].value) + 
			parseInt(obj_DecimalField2_GTZero[1].value) + parseInt(obj_DecimalField2_GTZero[2].value) || 
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField2_GTZero[0].value) + 
					parseInt(obj_DecimalField2_GTZero[1].value) + parseInt(obj_DecimalField2_GTZero[2].value)){
		errorObjs.push(obj_DecimalField2_GTZero[0]);
		errorObjs.push(obj_DecimalField2_GTZero[1]);
		errorObjs.push(obj_DecimalField2_GTZero[2]);
		
		a += "����-��Ҫ��Ϣϵͳ����=�����з�+�������+�����������\n";
		isValid=false;
	}
	
	var obj_DecimalField4_GTZero = getTableFormObjs(label_DecimalField4_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField4_GTZero[0].value) +
			parseInt(obj_DecimalField4_GTZero[1].value) + parseInt(obj_DecimalField4_GTZero[2].value) ||
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField4_GTZero[0].value) +
					parseInt(obj_DecimalField4_GTZero[1].value) + parseInt(obj_DecimalField4_GTZero[2].value)){
		errorObjs.push(obj_DecimalField4_GTZero[0]);
		errorObjs.push(obj_DecimalField4_GTZero[1]);
		errorObjs.push(obj_DecimalField4_GTZero[2]);
		a+="����-��Ҫ��Ϣϵͳ����=������ά+�������+�����������\n";
		isValid=false;
	}
	var obj_DecimalField4_GTZero_2 = getTableFormObjs(label_DecimalField4_GTZero_2);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField4_GTZero_2[0].value) +
			parseInt(obj_DecimalField4_GTZero_2[1].value) + parseInt(obj_DecimalField4_GTZero_2[2].value) || 
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField4_GTZero_2[0].value) +
					parseInt(obj_DecimalField4_GTZero_2[1].value) + parseInt(obj_DecimalField4_GTZero_2[2].value)){
		errorObjs.push(obj_DecimalField4_GTZero_2[0]);
		errorObjs.push(obj_DecimalField4_GTZero_2[1]);
		errorObjs.push(obj_DecimalField4_GTZero_2[2]);
		a+="����-��Ҫ��Ϣϵͳ����=����+����+���г���\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL125.value) > 100){
		errorObjs.push(obj_DecimalField28_COL125);
		a+="������-�����������������<=100����\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL126.value) > 100){
		errorObjs.push(obj_DecimalField28_COL126);
		a+="�ֱ����-��Ҫ��Ϣϵͳ�ֱ�������<=100����\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL125.value) < 0){
		errorObjs.push(obj_DecimalField28_COL125);
		a+="������-�����������������>=0����\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL126.value) < 0){
		errorObjs.push(obj_DecimalField28_COL126);
		a+="�ֱ����-��Ҫ��Ϣϵͳ�ֱ�������>=0����\n";
		isValid=false;
	}
	var obj_DecimalField28_GTZero = getTableFormObjs(label_DecimalField28_GTZero);
	if(parseInt(obj_DecimalField28_GTZero[0].value) < parseInt(obj_DecimalField28_GTZero[2].value)){
		errorObjs.push(obj_DecimalField28_GTZero[0]);
		a+="������Ҫ��Ϣϵͳ����RTO���ֵ>=RTOƽ��ֵ����\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[1].value) > parseInt(obj_DecimalField28_GTZero[2].value)){
		errorObjs.push(obj_DecimalField28_GTZero[1]);
		a+="������Ҫ��Ϣϵͳ����RTO��Сֵ<=RTOƽ��ֵ����\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[3].value) < parseInt(obj_DecimalField28_GTZero[5].value)){
		errorObjs.push(obj_DecimalField28_GTZero[3]);
		a+="����ϵͳ����RTO���ֵ>=RTOƽ��ֵ����\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[4].value) > parseInt(obj_DecimalField28_GTZero[5].value)){
		errorObjs.push(obj_DecimalField28_GTZero[4]);
		a+="����ϵͳ����RTO��Сֵ<=RTOƽ��ֵ����\n";
		isValid=false;
	}
	var obj_YN01 = getTableFormObjs(label_YN01)[0];
	var obj_YN01_1 = getTableFormObjs(label_YN01_1)[0];
	var obj_item4 = getTableFormObjs(label_item4)[0];
	if(obj_YN01.value == "��" && obj_YN01_1.value.trim() == ""){
		errorObjs.push(obj_YN01_1);
		a+="����ҵ��ϵͳʵʩ�滻ʱ�䲻��Ϊ�գ�\n";
		isValid=false;
	}
	if(obj_YN01.value == "��" && obj_YN01_1.value > obj_item4.value){
		errorObjs.push(obj_YN01_1);
		a+="����ҵ��ϵͳʵʩ�滻ʱ��ӦӦС�ڵ�������ڳ���\n";
		isValid=false;
	}
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_1 = getTableFormObjs(label_YN02_1)[0];
	if( obj_YN02.value == "��" && obj_YN02_1.value.trim() == ""){
		errorObjs.push(obj_YN02_1);
		a+="����ҵ��ϵͳ����ƻ��滻ʱ�䲻��Ϊ�գ�\n";
		isValid=false;
	}
	if( obj_YN02.value == "��" && obj_YN02_1.value.trim() != "" &&obj_YN02_1.value < obj_item4.value){
		errorObjs.push(obj_YN02_1);
		a+="����ҵ��ϵͳ����ƻ��滻ʱ��ӦӦ��������ڳ���\n";
		isValid=false;
	}
	
	var obj_DecimalField16_GTZero = getTableFormObjs(label_DecimalField16_GTZero);
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[2].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[2]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=ʵ�����ݼ��ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[3].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[3]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=ʵ��ϵͳ���ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[4].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[4]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=ʵ��Ӧ�ü��ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[5].value)){
		errorObjs.push(obj_DecimalField16_GTZero[5]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=������ͬ���ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[6].value)){
		errorObjs.push(obj_DecimalField16_GTZero[6]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=����������ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[7].value)){
		errorObjs.push(obj_DecimalField16_GTZero[7]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=����ͬ������������ֱ��ĳ���\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[8].value)){
		errorObjs.push(obj_DecimalField16_GTZero[8]);
		a+="�ֱ����-�����ֱ�����Ҫ��Ϣϵͳ��>=���ø߿��ü����ĳ���\n";
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