/*
 * ����T-B-6 ���ݣ��ֱ������Ļ��������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01 = "�����#����#��2#��3#��2#��1#�Ƿ��䱸";
var label_YN01_1 = "�����#����#��2#��3#��2#��2#�����";
var label_YN01_2 = "�����#����#��2#��3#��2#��3#�Զ�����";
var label_YN01_3 = "�����#����#��2#��3#��2#��4#����ʱ��";
var label_YN01_4 = "�����#����#��2#��3#��2#��5#���ϴ�������ʱ��";
var label_YN01_5 = "�����#����#��2#��3#��2#��6#��ά��λ #��ά��λ ";
var label_YN01_6 = "�����#����#��2#��3#��2#��6#��ά��λ #1";
var label_YN01_7 = "�����#����#��2#��3#��2#��7#�Ƿ�����#�Ƿ�����";
var label_YN01_8 = "�����#����#��2#��3#��2#��7#�Ƿ�����#���ⷽ����";

var label_item6_GTZero = "�����#����#��2#��4#���������";
var label_item12_GTZero = "�����#����#��2#��2#��2#��2#��2";
var label_item13_GTZero = "�����#����#��2#��2#��2#��6#ʵ�ʸ��ط�ֵ";
var label_item14_GTZero = "�����#����#��2#��2#��2#��3#���ص�ؿ���ʱ��";
var label_item15_GTZero = "�����#����#��2#��2#��2#��4#UPS�������ʹ�����";
var label_item16_GTZero = "�����#����#��2#��2#��2#��5#UPS������ʹ�����";

var label_item22_GTZero = "�����#�Ž�����#��2#�Ž�#�Ž�����#�Ž���¼����ʱ��#�Ž���¼����ʱ��";
var label_item25_GTZero = "�����#�Ž�����#��2#�������#�����������#��ؼ�¼����ʱ��#��ؼ�¼����ʱ��";

var label_item30_GTZero = "�����#�յ�#�յ�����#��Ƶ�λ���������#��Ƶ�λ���������";
/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var objs = getTableFormObjs(label_YN01);
	for(var i = 0; i < objs.length; i++){
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_YN01_1 = getTableFormObj(label_YN01_1,objs[i].rownumber);
		var obj_YN01_2 = getTableFormObj(label_YN01_2,objs[i].rownumber);
		var obj_YN01_3 = getTableFormObj(label_YN01_3,objs[i].rownumber);
		var obj_YN01_4 = getTableFormObj(label_YN01_4,objs[i].rownumber);
		var obj_YN01_5 = getTableFormObj(label_YN01_5,objs[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,objs[i].rownumber + "_1");
		var obj_YN01_7 = getTableFormObj(label_YN01_7,objs[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,objs[i].rownumber + "_1");
		if(objs[i].value == "��"){
			obj_YN01_1.onclick = "";
			columnVallueRadio1(obj_YN01_2,false,false,false);
			obj_YN01_3.onclick = "";
			obj_YN01_4.onclick = "";
			columnVallueRadio1(obj_YN01_5,false,false,false);
			obj_YN01_6.readOnly = "readonly";
			columnVallueRadio1(obj_YN01_7,false,false,false);
			obj_YN01_8.readOnly = "readonly";
			//���
			obj_YN01_1.value = "";
			obj_YN01_3.value = "";
			obj_YN01_4.value = "";
			obj_YN01_6.value = "";
			obj_YN01_8.value = "";
		}else{
			obj_YN01_1.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_YN01_2,true,false,false);
			obj_YN01_3.onclick = click_columnValueNumber;
			obj_YN01_4.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_YN01_5,true,true,true);
			obj_YN01_6.readOnly = "";
			columnVallueRadio1(obj_YN01_7,true,true,false);
			obj_YN01_8.readOnly = "";
		}
		var obj_YN01_5 = getTableFormObj(label_YN01_5,objs[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,objs[i].rownumber + "_1");
		if(obj_YN01_5.value == "����"){
			obj_YN01_6.readOnly = "readonly";
			obj_YN01_6.value = "";
		}else{
			obj_YN01_6.readOnly = "";
		}
		var obj_YN01_7 = getTableFormObj(label_YN01_7,objs[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,objs[i].rownumber + "_1");
		if(obj_YN01_7.value == "��"){
			obj_YN01_8.readOnly = "readonly";
			obj_YN01_8.value = "";
		}else{
			obj_YN01_8.readOnly = "";
		}
	}	
}
/*
* ���ܣ���ά��λѡ����ʱ���ı��򲻿����룬 ѡ���ⲿ����ʱ ������
* ���ã������#����#��2#��3#��2#��1#�Ƿ��䱸
*/
function checkYN01(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_1 = getTableFormObj(label_YN01_1,target.rownumber);
	var obj_YN01_2 = getTableFormObj(label_YN01_2,target.rownumber);
	var obj_YN01_3 = getTableFormObj(label_YN01_3,target.rownumber);
	var obj_YN01_4 = getTableFormObj(label_YN01_4,target.rownumber);
	var obj_YN01_5 = getTableFormObj(label_YN01_5,target.rownumber + "_1");
	var obj_YN01_6 = getTableFormObj(label_YN01_6,target.rownumber + "_1");
	var obj_YN01_7 = getTableFormObj(label_YN01_7,target.rownumber + "_1");
	var obj_YN01_8 = getTableFormObj(label_YN01_8,target.rownumber + "_1");
	if(target.value == "��"){
		obj_YN01_1.onclick = "";
		columnVallueRadio1(obj_YN01_2,false,false,false);
		obj_YN01_3.onclick = "";
		obj_YN01_4.onclick = "";
		columnVallueRadio1(obj_YN01_5,false,false,false);
		obj_YN01_6.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_7,false,false,false);
		obj_YN01_8.readOnly = "readonly";
		//���
		obj_YN01_1.value = "";
		obj_YN01_3.value = "";
		obj_YN01_4.value = "";
		obj_YN01_6.value = "";
		obj_YN01_8.value = "";
	}else{
		obj_YN01_1.onclick = click_columnValueNumber;
		columnVallueRadio1(getTableFormObj(label_YN01_2,target.rownumber),true,false,false);
		obj_YN01_3.onclick = click_columnValueNumber;
		obj_YN01_4.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN01_5,true,true,true);
		obj_YN01_6.readOnly = "";
		columnVallueRadio1(obj_YN01_7,true,true,false);
		obj_YN01_8.readOnly = "";
	}
}

/*
 *���ܣ��ָ����ּ�������
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
 *���ܣ���ѡ��ť�Ķ�д����
 *������objΪ��ѡ����
 *	  access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false
 *	  flag Ϊ�Ƿ�������⺯������
 *	  addmethed Ϊ��Ӻ����жϣ�true���checkYN01_5   false���checkYN01_7
 */
function columnVallueRadio1(obj,access,flag,addmethed){
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
							if(addmethed){
								imgs[k].onclick = function(){
									columnVallueRadio(this);
									checkYN01_5(this);
								};
							}else{
								imgs[k].onclick = function(){
									columnVallueRadio(this);
									checkYN01_7(this);
								};
							}
						}
					}
				}
			}
		}
	}
}
/*
* ���ܣ���ά��λѡ����ʱ���ı��򲻿����룬 ѡ���ⲿ����ʱ ������
* ���ã������#����#��2#��3#��2#��6#��ά��λ#��ά��λ
*/
function checkYN01_5(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_6 = getTableFormObj(label_YN01_6,target.rownumber);
	if(target.value == "����"){
		obj_YN01_6.readOnly = "readonly";
		obj_YN01_6.value = "";
	}else{
		obj_YN01_6.readOnly = "";
	}
}

/*
* ���ܣ�������Ƿ�����ѡ���ʱ���ı��򲻿����룬 ѡ����ʱ ������
* ���ã������#����#��2#��3#��2#��7#�Ƿ�����#�Ƿ�����
*/
function checkYN01_7(obj){
	var target = getTarget(obj.parentElement);
	var obj_YN01_8 = getTableFormObj(label_YN01_8,target.rownumber);
	if(target.value == "��"){
		obj_YN01_8.readOnly = "readonly";
		obj_YN01_8.value = "";
	}else{
		obj_YN01_8.readOnly = "";
	}
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
	
	
	
	
	
	
	
	var obj_YN01 = getTableFormObjs(label_YN01);
	for(var i = 0; i < obj_YN01.length; i++){
		var obj_YN01_1 = getTableFormObj(label_YN01_1,obj_YN01[i].rownumber);
		var obj_YN01_2 = getTableFormObj(label_YN01_2,obj_YN01[i].rownumber);
		var obj_YN01_3 = getTableFormObj(label_YN01_3,obj_YN01[i].rownumber);
		var obj_YN01_4 = getTableFormObj(label_YN01_4,obj_YN01[i].rownumber);
		var obj_YN01_5 = getTableFormObj(label_YN01_5,obj_YN01[i].rownumber + "_1");
		var obj_YN01_6 = getTableFormObj(label_YN01_6,obj_YN01[i].rownumber + "_1");
		var obj_YN01_7 = getTableFormObj(label_YN01_7,obj_YN01[i].rownumber + "_1");
		var obj_YN01_8 = getTableFormObj(label_YN01_8,obj_YN01[i].rownumber + "_1");
	
		if(obj_YN01[i].value == "��"){
			if(obj_YN01_1.value.trim() == ""){
				errorObjs.push(obj_YN01_1);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� �����������ʣ�����Ϊ�գ�\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_1,2);
			}
			if(obj_YN01_2.value.trim() == ""){
				errorObjs.push(obj_YN01_2.parentElement);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ��������Զ�����������Ϊ�գ�\n";
				isValid = false;
			}
			if(obj_YN01_3.value.trim() == ""){
				errorObjs.push(obj_YN01_3);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� �����������ʱ�䣢����Ϊ�գ�\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_3,2);
			}
			if(obj_YN01_4.value.trim() == ""){
				errorObjs.push(obj_YN01_4);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ����������ϴ�������ʱ�䣢����Ϊ�գ�\n";
				isValid = false;
			}else{
				checkNumFloat(obj_YN01_4,2);
			}
			if(obj_YN01_5.value.trim() == ""){
				errorObjs.push(obj_YN01_5.parentElement);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ���������ά��λ������Ϊ�գ�\n";
				isValid = false;
			}
			if(obj_YN01_7.value.trim() == ""){
				errorObjs.push(obj_YN01_7.parentElement);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ��������Ƿ����ã�����Ϊ�գ�\n";
				isValid = false;
			}
			
			if(obj_YN01_5.value == "�ⲿ����" && obj_YN01_6.value.trim() == ""){
				errorObjs.push(obj_YN01_6);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ��������ⲿ����������Ϊ�գ�\n";
				isValid = false;
			}
			if(obj_YN01_7.value == "��" && obj_YN01_8.value.trim() == ""){
				errorObjs.push(obj_YN01_8);
				a += "����(�ֱ�)���Ļ���" + (i+1) + "�������� ����������ⷽ���ƣ�����Ϊ�գ�\n";
				isValid = false;
			}
			
			
		}
	}
	
	var obj_item6_GTZero = getTableFormObjs(label_item6_GTZero);
	for(var i = 0; i < obj_item6_GTZero.length; i++){
		checkNumFloat(obj_item6_GTZero[i],2);
	}
	var obj_item12_GTZero = getTableFormObjs(label_item12_GTZero);
	for(var i = 0; i < obj_item12_GTZero.length; i++){
		checkNumFloat(obj_item12_GTZero[i],2);
	}
	
	var obj_item13_GTZero = getTableFormObjs(label_item13_GTZero);
	for(var i = 0; i < obj_item13_GTZero.length; i++){
		checkNumFloat(obj_item13_GTZero[i],2);
	}
	
	var obj_item14_GTZero = getTableFormObjs(label_item14_GTZero);
	for(var i = 0; i < obj_item14_GTZero.length; i++){
		checkNumFloat(obj_item14_GTZero[i],2);
	}
	
	var obj_item15_GTZero = getTableFormObjs(label_item15_GTZero);
	for(var i = 0; i < obj_item15_GTZero.length; i++){
		checkNumFloat(obj_item15_GTZero[i],2);
	}
	
	var obj_item16_GTZero = getTableFormObjs(label_item16_GTZero);
	for(var i = 0; i < obj_item16_GTZero.length; i++){
		checkNumFloat(obj_item16_GTZero[i],2);
	}
	
	var obj_item22_GTZero = getTableFormObjs(label_item22_GTZero);
	for(var i = 0; i < obj_item22_GTZero.length; i++){
		checkNumFloat(obj_item22_GTZero[i],2);
	}
	
	var obj_item25_GTZero = getTableFormObjs(label_item25_GTZero);
	for(var i = 0; i < obj_item25_GTZero.length; i++){
		checkNumFloat(obj_item25_GTZero[i],2);
	}
	
	var obj_item30_GTZero = getTableFormObjs(label_item30_GTZero);
	for(var i = 0; i < obj_item30_GTZero.length; i++){
		checkNumFloat(obj_item30_GTZero[i],2);
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