/**T-B-13 ������滯������������*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item55 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�����";

var label_R_Item6="������滯����������#����";
var label_R_Item7="������滯����������#ְ��";
var label_R_Item8 = "������滯����������#�칫�绰�� ����";
var label_R_Item9 = "������滯����������#�绰����";


var label_R_Item17 = "�����������滯��ѵ���#����#ʱ��";


var R_Item = "�������ʹ�����ͳ��#�������ʹ�����ͳ��#������";
var R_Item1_GTZero = "�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#�����Ʒ#�������";
var R_Item2_GTZero = "�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#���ڲ�Ʒ#�������";

var R_Item5 = "�������ʹ�����ͳ��#Ӧ��ϵͳ���#������";
var R_Item3_GTZero = "�������ʹ�����ͳ��#Ӧ��ϵͳ���#�����Ʒ#�������";
var R_Item3_YN = "�������ʹ�����ͳ��#Ӧ��ϵͳ���#�����Ʒ#�������";
var R_Item4_GTZero = "�������ʹ�����ͳ��#Ӧ��ϵͳ���#���ڲ�Ʒ#�������";
var R_Item4_YN = "�������ʹ�����ͳ��#Ӧ��ϵͳ���#���ڲ�Ʒ#�������";


var DecimalField5_GTZero= "���������װ������#�����������";
var DecimalField5_GTZero1= "���������װ������#���������������";
var DecimalField5_GTZero2= "���������װ������#��������֪ʶ��Ȩ�������";

var item10000_GTZero="�����������滯��ѵ���#�������ѵ������";
var item10001_GTZero="�����������滯��ѵ���#��ѵ���˴Σ�";

var label_R_Item5="������滯����������#����#��������";
var label_R_Item16="������滯����������#������";
var label_R_Item19="������滯����������#����#������";

var label_R_Item20 = "�����������滯Ͷ�����#��������ɹ�Ͷ��";
var label_R_Item21 = "�����������滯Ͷ�����#������ά��Ͷ��";

var R_Item1_YN = "�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#�����Ʒ#�������";
var R_Item2_YN = "�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#���ڲ�Ʒ#�������";


function initSet(){
	r_items=getTableFormObjs(R_Item);
	for(var i=0;i<r_items.length;i++){
		r_Item1_GTZero(r_items[i]); 
		r_Item2_GTZero(r_items[i]); 
	}
	r_item5s=getTableFormObjs(R_Item5);
	for(var i=0;i<r_item5s.length;i++){
		r_Item3_GTZero(r_item5s[i]); 
		r_Item4_GTZero(r_item5s[i]); 
	}
	eG_YN_Item1(getTableFormObj(label_R_Item5,"1_1"));
	eG_YN_Item2(getTableFormObj(label_R_Item6,"1_1"));
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
/*
*���ܣ�У��绰����
*���ã�������滯����������#����#�칫�绰�� ����
*/
function R_Item8(obj) {
	var reg1=/^(0[0-9]{2,3})?$/;
	//var reg2=/^((\+86)|(86))?(13)\d{9}$/;
	if(obj.value.trim()!="")
	{
		var Valid=reg1.exec(obj.value.trim());
		if(!Valid){
			alert("��������ȷ�����ţ�3-4λ����(������0��ͷ)��\n");
			obj.value = "";
			return false;
			}
	}
	if(obj.value == "-"){
		alert("���������븺��");
		obj.value = "";
	}else if(obj.value.indexOf(".") > 0){
		alert("����������С��");
		obj.value = obj.value.substring(0,obj.value.indexOf("."));
	}
//	else if(obj.value.indexOf("0") == 0 && obj.value.length >= 2){
//		obj.value = obj.value.substring(1,obj.value.length);
//	}
}

/*
*���ܣ�ʱ��
*���ã������������滯��ѵ��� #����#ʱ�� 
*/

function R_Item17(obj) {
	var reg1=/^((((1[6-9]|[2-9]\d)\d{2})��(0[13578]|1[02])��(0[1-9]|[12]\d|3[01])��)|(((1[6-9]|[2-9]\d)\d{2})��(0[13456789]|1[012])��(0[1-9]|[12]\d|30)��)|(((1[6-9]|[2-9]\d)\d{2})��02��(0[1-9]|1\d|2[0-8])��)|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))��02��29��))$/;
	var reg2=/^((((1[6-9]|[2-9]\d)\d{2})-(0[13578]|1[02])-(0[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0[13456789]|1[012])-(0[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-02-(0[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-02-29))$/;
	if(obj.value.trim()!=null)
	{
		var Valid=reg2.exec(obj.value.trim())||reg1.exec(obj.value.trim());
		if(!Valid){
			alert("�밴�淶��д����,��2010-12-20��\n");
			obj.value=null;
			}
	}
}

/*
*���ܣ�У��绰����
*���ã�������滯����������#����#�绰���� 
*/
function R_Item9(obj) {
	var reg1=/^([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/;
	//var reg2=/^((\+86)|(86))?(13)\d{9}$/;
	if(obj.value.trim()!="")
	{
		var Valid=reg1.exec(obj.value.trim());
		if(!Valid){
			alert("��������ȷ�ĵ绰��7-8λֱ���ţ�������1��ͷ����1-4λ�ֻ��ţ����š�ֱ���š��ֻ���֮���á�-���ָ��\n");
			obj.value = "";
			return false;	
		}
	}
	if(obj.value == "-"){
		alert("���������븺��");
		obj.value = "";
	}else if(obj.value.indexOf(".") > 0){
		alert("����������С��");
		obj.value = obj.value.substring(0,obj.value.indexOf("."));
	}else if(obj.value.indexOf("0") == 0 && obj.value.length >= 2){
		obj.value = obj.value.substring(1,obj.value.length);
	}
}

/*
*���ܣ������Ʒ�������
*���ã��������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#�����Ʒ#�������
*/
function r_Item1_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs("�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#�����Ʒ#�������");
	for(var i = 0; i < objs.length;i++){
		var obj_R_Item1_GTZero = getTableFormObj(R_Item1_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "�������������") {
			// ֻ��
			obj_R_Item1_GTZero.onclick = "";
			// ���
			obj_R_Item1_GTZero.value = "";
		} else if (objs[i].value.trim() == "�����������") {
			// ��ԭ
			obj_R_Item1_GTZero.onclick = click_columnValueNumber;
		}
	}
}
/*
*���ܣ����ڲ�Ʒ�������
*���ã��������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#���ڲ�Ʒ#�������
*/
function r_Item2_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs("�������ʹ�����ͳ��#�������ʹ�����ͳ��#��ϸ#���ڲ�Ʒ#�������");
	for(var i = 0; i < objs.length;i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item2_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "�������������") {
			// ֻ��
			obj_R_Item2_GTZero.onclick = "";
			// ���
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "�����������") {
			// ��ԭ
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*���ܣ����ڲ�Ʒ�������
*���ã��������ʹ�����ͳ��#Ӧ��ϵͳ���#��ϸ#�����Ʒ#������� 
*/
function r_Item3_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs(R_Item3_YN);
	for(var i = 0; i < objs.length; i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item3_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "�������������") {
			// ֻ��
			obj_R_Item2_GTZero.onclick = "";
			// ���
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "�����������") {
			// ��ԭ
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*���ܣ����ڲ�Ʒ�������
*���ã��������ʹ�����ͳ��#Ӧ��ϵͳ���#��ϸ#���ڲ�Ʒ#������� 
*/
function r_Item4_GTZero(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var objs = getTableFormObjs(R_Item4_YN);
	for(var i = 0; i < objs.length; i++){
		var obj_R_Item2_GTZero = getTableFormObj(R_Item4_GTZero, objs[i].rownumber);
		if (objs[i].value.trim() == "�������������") {
			// ֻ��
			obj_R_Item2_GTZero.onclick = "";
			// ���
			obj_R_Item2_GTZero.value = "";
		} else if (objs[i].value.trim() == "�����������") {
			// ��ԭ
			obj_R_Item2_GTZero.onclick = click_columnValueNumber;
		}
	}
}

/*
*���ܣ�������滯��������������
*���ã�"������滯����������#����#��������
*/
function eG_YN_Item1(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var obj = getTableFormObjs("������滯����������#����#������")[0];
	var R_Item5 = getTableFormObj(label_R_Item5, obj.rownumber);
	if (obj.value.trim() == "��") {
		// ֻ��
		R_Item5.onclick = "";
		// ���
		R_Item5.value = "";
		R_Item5.readOnly = "readonly";
	} else if (obj.value.trim() == "��") {
		// ��ԭ
		R_Item5.onclick = "";
		R_Item5.readOnly = "";

	}
}

/*
*���ܣ�������滯��������������
*���ã�������滯����������#����#������ 
*/
function eG_YN_Item2(objcld) {
//	var obj = getTarget(objcld.parentElement);
	var obj = getTableFormObjs("������滯����������#������")[0];
	var R_Item6 = getTableFormObj(label_R_Item6, obj.rownumber);
	var R_Item7 = getTableFormObj(label_R_Item7, obj.rownumber);
	var R_Item8 = getTableFormObj(label_R_Item8, obj.rownumber);
	var R_Item9 = getTableFormObj(label_R_Item9, obj.rownumber);
	if (obj.value.trim() == "��") {
		// ���
		R_Item6.value = "";
		R_Item7.value = "";
		R_Item8.value = "";
		R_Item9.value = "";
		// ֻ��
		R_Item6.readOnly="readonly";
		R_Item7.readOnly="readonly";
		R_Item8.readOnly="readonly";
		R_Item9.readOnly="readonly";
		
		R_Item6.onclick = "";
		R_Item7.onclick = "";
		R_Item8.onclick = "";
		R_Item9.onclick = "";
		
	} else if (obj.value.trim() == "��") {
		// ��ԭ
		R_Item6.onclick = "";
		R_Item7.onclick = "";
		R_Item8.onclick = "";
		R_Item9.onclick = "";
		R_Item6.readOnly="";
		R_Item7.readOnly="";
		R_Item8.readOnly="";
		R_Item9.readOnly="";
	}
}


function checkData() {
//	alert(getTableFormObjs(R_Item1_GTZero).length)
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	if(parseInt(getTableFormObj(DecimalField5_GTZero,"1").value.trim())!=(parseInt(getTableFormObj(DecimalField5_GTZero1,"1").value.trim())+parseInt(getTableFormObj(DecimalField5_GTZero2,"1").value.trim())))
	{
		errorObjs.push(getTableFormObj(DecimalField5_GTZero,"1"));
		errorObjs.push(getTableFormObj(DecimalField5_GTZero1,"1"));
		errorObjs.push(getTableFormObj(DecimalField5_GTZero2,"1"));
	 	a+="�����������=���������������+��������֪ʶ��Ȩ������� У�����\n";
	  	isValid=false;
	}
	if((getTableFormObj(item10000_GTZero,"1").value.trim() > 0
		 	   && getTableFormObj(item10001_GTZero,"1").value.trim() == 0)||
		 	   (getTableFormObj(item10000_GTZero,"1").value.trim() == 0
		 	   && getTableFormObj(item10001_GTZero,"1").value.trim() > 0)){
		errorObjs.push(getTableFormObj(item10000_GTZero,"1"));
		errorObjs.push(getTableFormObj(item10001_GTZero,"1"));
				a += "�����������滯��ѵ��� | �������ѵ��������ѵ���˴���д����!\n";
				isValid=false;	
			}
	if(getTableFormObj(label_R_Item19,"1_1").value.trim()=="��"){
		if(getTableFormObj(label_R_Item5,"1_1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item5,"1_1"));
			a += "������滯�������������Ʋ���Ϊ�գ�\n";
			isValid=false;	
		}
	}
	if(getTableFormObj(label_R_Item16,"1").value.trim()=="��"){
		if(getTableFormObj(label_R_Item6,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item6,"1"));
			a += "������滯���������ˣ���������Ϊ�գ�\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item7,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item7,"1"));
			a += "������滯���������ˣ�ְ����Ϊ�գ�\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item8,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item8,"1"));
			a += "������滯���������ˣ��칫�绰���Ų���Ϊ�գ�\n";
			isValid=false;	
		}
		if(getTableFormObj(label_R_Item9,"1").value.trim()==""){
			errorObjs.push(getTableFormObj(label_R_Item9,"1"));
			a += "������滯���������ˣ��칫�绰���벻��Ϊ�գ�\n";
			isValid=false;	
		}
	}
	
	var R_Item1_YNs = getTableFormObjs(R_Item1_YN);
	var R_Item1_GTZeros= getTableFormObjs(R_Item1_GTZero);
	for(var i=0; i<R_Item1_GTZeros.length;i++){
		if (R_Item1_YNs[i].value.trim() == "�����������") {
			if(R_Item1_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item1_GTZeros[i]);
				a += "�����������Ϊ�գ�\n";
				isValid=false;	
			}
		}
	}
	var R_Item2_YNs = getTableFormObjs(R_Item2_YN);
	var R_Item2_GTZeros= getTableFormObjs(R_Item2_GTZero);
	for(var i=0; i<R_Item2_GTZeros.length;i++){
		if (R_Item2_YNs[i].value.trim() == "�����������") {
			if(R_Item2_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item2_GTZeros[i]);
				a += "�����������Ϊ�գ�\n";
				isValid=false;	
			}
		}
	}
	
	var R_Item3_YNs = getTableFormObjs(R_Item3_YN);
	var R_Item3_GTZeros= getTableFormObjs(R_Item3_GTZero);
	for(var i=0; i<R_Item3_GTZeros.length;i++){
		if (R_Item3_YNs[i].value.trim() == "�����������") {
			if(R_Item3_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item3_GTZeros[i]);
				a += "�����������Ϊ�գ�\n";
				isValid=false;	
			}
		}
	}
	
	var R_Item4_YNs = getTableFormObjs(R_Item4_YN);
	var R_Item4_GTZeros= getTableFormObjs(R_Item4_GTZero);
	for(var i=0; i<R_Item4_GTZeros.length;i++){
		if (R_Item4_YNs[i].value.trim() == "�����������") {
			if(R_Item4_GTZeros[i].value.trim()==""){
				errorObjs.push(R_Item4_GTZeros[i]);
				a += "�����������Ϊ�գ�\n";
				isValid=false;	
			}
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
	checkNumFloat(getTableFormObj(label_R_Item20,"1"),2);
	checkNumFloat(getTableFormObj(label_R_Item21,"1")),2;
	return isValid;
}
var click_columnValueNumber = function() {
	columnValueNumber(this);
};
