/*
 * ����T-A-6 ��Ҫ��ϢϵͳͶ������������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "ʵʩ��ֹʱ�䣨��ƻ�ʵʩ���ڣ�#��ʼʱ��";
var label_item8 = "ʵʩ��ֹʱ�䣨��ƻ�ʵʩ���ڣ�#����ʱ��";
var label_item7 = "��������";
var label_item14= "���Ͳ���#��ǰ���Ͳ���#1��Ӧ��Ԥ��#��������";
var label_item14_fujian= "���Ͳ���#��ǰ���Ͳ���#1��Ӧ��Ԥ��#Ӧ��Ԥ��";
var label_item15= "���Ͳ���#��ǰ���Ͳ���#2��������������#��������";
var label_item15_fujian= "���Ͳ���#��ǰ���Ͳ���#2��������������#������������";
var label_item16= "���Ͳ���#�º��Ͳ���#1��Ͷ�����������#��������";
var label_item16_fujian= "���Ͳ���#�º��Ͳ���#1��Ͷ�����������#Ͷ�����������";
var label_item17= "���Ͳ���#�º��Ͳ���#2�����������Ϣ#��������";
var label_item17_fujian= "���Ͳ���#�º��Ͳ���#2�����������Ϣ#���������Ϣ";
var label_item18= "���Ͳ���#�º��Ͳ���#3���ܽᱨ��#��������";
var label_item18_fujian= "���Ͳ���#�º��Ͳ���#3���ܽᱨ��#�ܽᱨ��";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var obj_item7= getFormObj(label_item7);
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	
	if(obj_item7.value=="��ǰ����"){
		getEditDiv(obj_item14).contentEditable = true;
		getEditDiv(obj_item15).contentEditable = true;
		getEditDiv(obj_item16).contentEditable = false;
		getEditDiv(obj_item17).contentEditable = false;
		getEditDiv(obj_item18).contentEditable = false;
		var obj_item16_fujian = getFujianObj(label_item16_fujian,"1_1_1");
		var obj_item17_fujian = getFujianObj(label_item17_fujian,"1_1_1");
		var obj_item18_fujian = getFujianObj(label_item18_fujian,"1_1_1");
		if (obj_item16_fujian != null) {
			var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
			var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
			var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
			obj_item16_fujian.readOnly= "readonly";
			obj_item16_fujianDelButton.onclick="";
			obj_item17_fujian.readOnly= "readonly";
			obj_item17_fujianDelButton.onclick="";
			obj_item18_fujian.readOnly= "readonly";
			obj_item18_fujianDelButton.onclick="";
		}
	}else if (obj_item7.value=="�º󱨸�"){
		getEditDiv(obj_item14).contentEditable = false;
		getEditDiv(obj_item15).contentEditable = false;
		getEditDiv(obj_item16).contentEditable = true;
		getEditDiv(obj_item17).contentEditable = true;
		getEditDiv(obj_item18).contentEditable = true;
		var obj_item14_fujian= getFujianObj(label_item14_fujian,"1_1_1");
		var obj_item15_fujian= getFujianObj(label_item15_fujian,"1_1_1");
		if (obj_item14_fujian != null) {
			var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
			var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
			obj_item14_fujian.readOnly= "readonly";
			obj_item14_fujianDelButton.onclick="";
			obj_item15_fujian.readOnly= "readonly";
			obj_item15_fujianDelButton.onclick="";
		}
	}
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã�ʵʩ��ֹʱ�䣨��ƻ�ʵʩ���ڣ�#��ʼʱ��
*/
function checkStartTime(obj){
	var obj_endtime=getTableFormObj(label_item8,"1");
	if(obj_endtime.value!="" && obj.value > obj_endtime.value) {
		alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
		obj.value="";
		obj.focus();
	}
}

/*
* ���ܣ���ʼ�ͽ���ʱ��ǰ��У��
* ���ã�ʵʩ��ֹʱ�䣨��ƻ�ʵʩ���ڣ�#����ʱ��
*/
function checkEndTime(obj){
	var obj_starttime=getTableFormObj(label_item5,"1");
	if(obj_starttime.value!="" && obj.value < obj_starttime.value) {
		alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
		obj.value="";
		obj.focus();
	}
}

/*
* ���ܣ��������͵��ʱ��ն�Ӧ�ĸ�����������
* ���ã���������
*/
function item7_click(obj){
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	var obj_item14_fujian= getFujianObj(label_item14_fujian,"1_1_1");
	var obj_item15_fujian= getFujianObj(label_item15_fujian,"1_1_1");
	var obj_item16_fujian = getFujianObj(label_item16_fujian,"1_1_1");
	var obj_item17_fujian = getFujianObj(label_item17_fujian,"1_1_1");
	var obj_item18_fujian = getFujianObj(label_item18_fujian,"1_1_1");
	if(obj.value=="��ǰ����"){
		getEditDiv(obj_item16).innerHTML = "";
		obj_item16.value="";
		getEditDiv(obj_item17).innerHTML = "";
		obj_item17.value="";
		getEditDiv(obj_item18).innerHTML = "";
		obj_item18.value="";
		getEditDiv(obj_item16).contentEditable = false;
		getEditDiv(obj_item17).contentEditable = false;
		getEditDiv(obj_item18).contentEditable = false;
		getEditDiv(obj_item14).contentEditable = true;
		getEditDiv(obj_item15).contentEditable = true;
		
		if (obj_item16_fujian.id.indexOf("IMG") > -1) {
			if (obj_item16_fujian.style.display!="none") {
				obj_item16_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item16_fujian);
			obj_item16_fujian = getSingalFileObj(label_item16_fujian,"1_1_1");
			obj_item16_fujian.readOnly= "readonly";
			var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
			obj_item16_fujianDelButton.onclick="";
		}
		if (obj_item17_fujian.id.indexOf("IMG") > -1) {
			if (obj_item17_fujian.style.display!="none") {
				obj_item17_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item17_fujian);
			obj_item17_fujian = getSingalFileObj(label_item17_fujian,
					"1_1_1");
			obj_item17_fujian.readOnly= "readonly";
			var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
			obj_item17_fujianDelButton.onclick="";
		}
		if (obj_item18_fujian.id.indexOf("IMG") > -1) {
			if (obj_item18_fujian.style.display!="none") {
				obj_item18_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item18_fujian);
			obj_item18_fujian = getSingalFileObj(label_item18_fujian,
					"1_1_1");
			obj_item18_fujian.readOnly= "readonly";
			var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
			obj_item18_fujianDelButton.onclick="";
		}
		obj_item14_fujian.readOnly= "";
		var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
		obj_item14_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item15_fujian.readOnly= "";
		var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
		obj_item15_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
	}else if (obj.value=="�º󱨸�"){
		getEditDiv(obj_item14).innerHTML = "";
		obj_item14.value="";
		getEditDiv(obj_item15).innerHTML = "";
		obj_item15.value="";
		getEditDiv(obj_item16).contentEditable = true;
		getEditDiv(obj_item17).contentEditable = true;
		getEditDiv(obj_item18).contentEditable = true;
		getEditDiv(obj_item14).contentEditable = false;
		getEditDiv(obj_item15).contentEditable = false;
		
		obj_item16_fujian.readOnly= "";
		var obj_item16_fujianDelButton = getFujianDelButtonObj(obj_item16_fujian);
		obj_item16_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item17_fujian.readOnly= "";
		var obj_item17_fujianDelButton = getFujianDelButtonObj(obj_item17_fujian);
		obj_item17_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		obj_item18_fujian.readOnly= "";
		var obj_item18_fujianDelButton = getFujianDelButtonObj(obj_item18_fujian);
		obj_item18_fujianDelButton.onclick=delSingleTableColumnFileInput_click;
		if (obj_item14_fujian.id.indexOf("IMG") > -1) {
			if (obj_item14_fujian.style.display!="none") {
				obj_item14_fujian.click();
//				obj_item14_fujian = getTableFormObj(label_item14_fujian, "1_1_1");
//				var temps =  obj_item14_fujian.parentElement.childNodes[0];
//				alert(temps.outerHTML)
			}
		} else {
			delSingleTableColumnFileInput(obj_item14_fujian);
			obj_item14_fujian = getSingalFileObj(label_item14_fujian,"1_1_1");
			obj_item14_fujian.readOnly= "readonly";
			var obj_item14_fujianDelButton = getFujianDelButtonObj(obj_item14_fujian);
			obj_item14_fujianDelButton.onclick="";
		}
		
		if (obj_item15_fujian.id.indexOf("IMG") > -1) {
			if (obj_item15_fujian.style.display!="none") {
				obj_item15_fujian.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item15_fujian);
			obj_item15_fujian = getSingalFileObj(label_item15_fujian,"1_1_1");
			obj_item15_fujian.readOnly= "readonly";
			var obj_item15_fujianDelButton = getFujianDelButtonObj(obj_item15_fujian);
			obj_item15_fujianDelButton.onclick="";
		}
	}
}

/*
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData() {
	var obj_starttime=getTableFormObj(label_item5,"1");
	var obj_endtime=getTableFormObj(label_item8,"1");
	var obj_item7 = getFormObj(label_item7);
	var obj_item14= getTableFormObj(label_item14,"1_1_1");
	var obj_item15= getTableFormObj(label_item15,"1_1_1");
	var obj_item16= getTableFormObj(label_item16,"1_1_1");
	var obj_item17= getTableFormObj(label_item17,"1_1_1");
	var obj_item18= getTableFormObj(label_item18,"1_1_1");
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if(obj_starttime.value > obj_endtime.value) {
		errorObjs.push(obj_starttime);
		errorObjs.push(obj_endtime);
		a += "��ʼʱ��Ӧ�ڱ��ʱ��֮ǰ�����������룡\n";
		isValid = false;
	}
	
	if (obj_item7.value=="��ǰ����") {
		if (getEditDiv(obj_item14).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item14));
			a += "��ǰ����ʱ����ǰ���Ͳĸ�����������Ϊ�գ�\n";
			isValid = false;
		} else if (getEditDiv(obj_item15).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item15));
			a += "��ǰ����ʱ����ǰ���Ͳĸ�����������Ϊ�գ�\n";
			isValid = false;
		}
	}

	if (obj_item7.value=="�º󱨸�") {
		if (getEditDiv(obj_item16).innerHTML == "") {
			errorObjs.push(getEditDiv(obj_item16));
			a += "�º󱨸�ʱ���º��Ͳĸ�����������Ϊ�գ�\n";
			isValid = false;
		} else if (getEditDiv(obj_item17).innerHTML =="") {
			errorObjs.push(getEditDiv(obj_item17));
			a += "�º󱨸�ʱ���º��Ͳĸ�����������Ϊ�գ�\n";
			isValid = false;
		} else if (getEditDiv(obj_item18).innerHTML =="") {
			errorObjs.push(getEditDiv(obj_item18));
			a += "�º󱨸�ʱ���º��Ͳĸ�����������Ϊ�գ�\n";
			isValid = false;
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
	return isValid;
}

/*
* ���ܣ�ȡ�ñ���ǰ���߱����ĸ�������
*/
function getFujianObj(labelname,rownumber) {
	var hasSaved=false;
	var obj = getTableFormObj(labelname,rownumber);
	var temps =  obj.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
        if(temps[i].id.indexOf("IMG")>-1){
        	hasSaved=true;
        	obj = temps[i];
        	break;
        }
    }
	if (!hasSaved) {
		obj = getSingalFileObj(labelname,rownumber);
	}
	return obj;
}

/*
* ���ܣ�ȡ�ø���ɾ����ť
*/
function getFujianDelButtonObj(obj) {
	var temps =  obj.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
		if (temps[i].onclick!=null){
			obj = temps[i];
			break;
		}
    }
	return obj;
}

var delSingleTableColumnFileInput_click = function() {
	delSingleTableColumnFileInput(this);
};