/*
 * ����T-B-3 ��Ϣ�Ƽ����ⲿ��������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "����#�����";
var label_header_item2 = "����#���";
var label_header_item55 = "����#��ϵ�绰";
var label_header_item3 = "����#������";
var label_header_item4 = "����#�����";
var label_item48_GTZero = "��Ϣ�Ƽ����ⲿ��������#����������#��";
var label_item49_GTZero = "��Ϣ�Ƽ����ⲿ��������#����������#��";
var label_item47_GTZero = "��Ϣ�Ƽ����ⲿ��������#����������#��";
var label_item44_GTZero = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��";
var label_item45_GTZero = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��";
var label_item46_GTZero = "��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��";
var label_item30_GTZero = "��Ϣ�Ƽ����ⲿ��������#������";
var label_item5 = "��Ϣ�Ƽ����ⲿ��������#��Ŀ����";
var label_item6 = "��Ϣ�Ƽ����ⲿ��������#��Ŀ���";
var label_item7 = "��Ϣ�Ƽ����ⲿ��������#���ݼ���Χ";
var label_item8 = "��Ϣ�Ƽ����ⲿ��������#ʵʩ��λ";
var label_DateTimeField1 = "��Ϣ�Ƽ����ⲿ��������#��ֹ����#��ʼ����#��ʼ����";
var label_DateTimeField2 = "��Ϣ�Ƽ����ⲿ��������#��ֹ����#�������#�������";
var label_item10 = "��Ϣ�Ƽ����ⲿ��������#�Ƿ��ϱ����»����»�";
var label_item11 = "��Ϣ�Ƽ����ⲿ��������#��Ŀ״̬";
var label_item24 = "��Ϣ�Ƽ����ⲿ��������#��Ʊ��渽��#��������";
var label_item25 = "��Ϣ�Ƽ����ⲿ��������#��Ʊ��渽��#��Ʊ���";
var label_item50_GTZero = "�������Ϣ�Ƽ��ڲ���Ƹ���һ����֧����������#�������Ϣ�Ƽ��ڲ���Ƹ���һ����֧�������";

/*
* ���ܣ���������״̬��ʼ��ʱ���ñ�Ȩ��
* ���ã���������״̬��ʼ��js
*/
function initSet(){
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		var obj_item11 = getTableFormObj(label_item11,
				objs[i].rownumber);
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				objs[i].rownumber + "_1");
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				objs[i].rownumber + "_1");
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				objs[i].rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				objs[i].rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				objs[i].rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				objs[i].rownumber + "_1");
		var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
				objs[i].rownumber);
		obj_item30_GTZero.onclick = "";
		var obj_item24 = getTableFormObj(label_item24,
				objs[i].rownumber + "_1");

		if (obj_item11.value.trim()=="δ���") {
			// ֻ��
			obj_item44_GTZero.onclick = "";
			obj_item45_GTZero.onclick = "";
			obj_item46_GTZero.onclick = "";
			obj_item48_GTZero.onclick = "";
			obj_item49_GTZero.onclick = "";
			obj_item47_GTZero.onclick = "";
			
			obj_item24 = getEditDiv(obj_item24);
			obj_item24.contentEditable=false;
			var obj_item25 = getSingalFileObj(label_item25,
					objs[i].rownumber+ "_1");
			if (obj_item25 != null)
				obj_item25.disabled=true;
		}
	}
	var noused = 0;
	item30_GTZero(noused);
}

/*
*���ܣ����ݡ���Ʒ����������͡��������������Զ�����������
*���ã���Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��
*��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��
*��Ϣ�Ƽ����ⲿ��������#��Ʒ�������#��
*��Ϣ�Ƽ����ⲿ��������#����������#��
*��Ϣ�Ƽ����ⲿ��������#����������#��
*��Ϣ�Ƽ����ⲿ��������#����������#��
*/
function item30_GTZero(obj) {
	
	var objs = getTableFormObjs(label_item5);
	for(var i = 0 ; i< objs.length; i++){
		var value44 = 0;
		var value45 = 0;
		var value46 = 0;
		var value47 = 0;
		var value48 = 0;
		var value49 = 0;
		if(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value != "") {
			value44 = parseInt(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value != "") {
			value45 = parseInt(getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value != "") {
			value46 = parseInt(getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item47_GTZero, objs[i].rownumber + "_1").value != "") {
			value47 = parseInt(getTableFormObj(label_item47_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item48_GTZero, objs[i].rownumber + "_1").value != "") {
			value48 = parseInt(getTableFormObj(label_item48_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item49_GTZero, objs[i].rownumber + "_1").value != "") {
			value49 = parseInt(getTableFormObj(label_item49_GTZero, objs[i].rownumber + "_1").value);
		}
		if(getTableFormObj(label_item44_GTZero, objs[i].rownumber + "_1").value + 
				getTableFormObj(label_item45_GTZero, objs[i].rownumber + "_1").value + 
						getTableFormObj(label_item46_GTZero, objs[i].rownumber + "_1").value != ""){
			var temp_value = ( (value47 + value48 + value49) / (value44 + value45 + value46) * 
							100).toFixed(2) * 100 / 100;
			getTableFormObj(label_item30_GTZero, objs[i].rownumber).value = temp_value;
		}else{
			getTableFormObj(label_item30_GTZero, objs[i].rownumber).value = "";
		}
	}
}

/*
* ���ܣ�����Ŀ״̬��δ���ʱ��չ�������
* ���ã���Ϣ�Ƽ����ⲿ��������#��Ŀ״̬
*/
function setItem11Disable(objcld) {
	var obj = getTarget(objcld.parentElement);
	var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
			obj.rownumber + "_1");
	var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
			obj.rownumber + "_1");
	var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
			obj.rownumber + "_1");
	var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
			obj.rownumber + "_1");
	var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
			obj.rownumber + "_1");
	var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
			obj.rownumber + "_1");
	var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
			obj.rownumber);
	var obj_item24 = getTableFormObj(label_item24,
			obj.rownumber + "_1");
	
	
	var hasSaved=false;
	var obj_item25 = getTableFormObj(label_item25,
			obj.rownumber + "_1");
	var temps =  obj_item25.parentElement.childNodes;
	for(var i=0;i<temps.length;i++){
        if(temps[i].id.indexOf("IMG")>-1){
        	hasSaved=true;
        	obj_item25 = temps[i];
        	break;
        }
    }
	if (!hasSaved) {
		obj_item25 = getSingalFileObj(label_item25,
				obj.rownumber+ "_1");
	}
	
	
	if (obj.value.trim() == "δ���") {
		// ֻ��
		obj_item44_GTZero.onclick = "";
		obj_item45_GTZero.onclick = "";
		obj_item46_GTZero.onclick = "";
		obj_item48_GTZero.onclick = "";
		obj_item49_GTZero.onclick = "";
		obj_item47_GTZero.onclick = "";
		obj_item30_GTZero.onclick = "";
		// ���
		obj_item44_GTZero.value = "";
		obj_item45_GTZero.value = "";
		obj_item46_GTZero.value = "";
		obj_item48_GTZero.value = "";
		obj_item49_GTZero.value = "";
		obj_item47_GTZero.value = "";
		obj_item30_GTZero.value = "";
		obj_item24 = getEditDiv(obj_item24);
		obj_item24.innerHTML = "";
		obj_item24.value="";
		obj_item24.contentEditable=false;
		if (hasSaved){
			if (obj_item25.style.display!="none") {
				obj_item25.click();
			}
		} else {
			delSingleTableColumnFileInput(obj_item25);
			obj_item25 = getSingalFileObj(label_item25,
					obj.rownumber+ "_1");
			obj_item25.disabled=true;
		}
	} else if (obj.value.trim() == "���") {
		// ��ԭ
		obj_item44_GTZero.onclick = click_columnValueNumber;
		obj_item45_GTZero.onclick = click_columnValueNumber;
		obj_item46_GTZero.onclick = click_columnValueNumber;
		obj_item48_GTZero.onclick = click_columnValueNumber;
		obj_item49_GTZero.onclick = click_columnValueNumber;
		obj_item47_GTZero.onclick = click_columnValueNumber;
		obj_item30_GTZero.onclick = click_columnValueNumber;
		obj_item24 = getEditDiv(obj_item24);
		obj_item24.contentEditable=true;
		obj_item25.disabled=false;
	}
}

/*
* ���ܣ�����ύʱ���еı���֤
* ���ã��״̬�ġ��ύ����ť
* �걨����״̬�ġ��ύ����ť
*/
function checkData() {
	var obj = getTableFormObj(label_item50_GTZero,"1");
	checkNumFloat(obj, 2);
	
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var objs = getTableFormObjs(label_item5);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
		checkTableItemNull(objs[i]);
		checkSubform10(objs[i]);
		var obj_DateTimeField1 = getTableFormObj(label_DateTimeField1,
				objs[i].rownumber + "_1_1");
		var obj_DateTimeField2 = getTableFormObj(label_DateTimeField2,
				objs[i].rownumber + "_1_1");
		if (obj_DateTimeField1.value.trim() != ""
				&& obj_DateTimeField2.value.trim() != ""
				&& obj_DateTimeField1.value.trim() > obj_DateTimeField2.value
						.trim()) {
			errorObjs.push(obj_DateTimeField1);
			errorObjs.push(obj_DateTimeField2);
			a += "��Ŀ" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "��" + "��ʼʱ�䲻�ܳ������ʱ�䣡\n";
			isValid = false;
		}
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				objs[i].rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item44_GTZero.value.trim() != ""
				&& obj_item48_GTZero.value.trim() != ""
				&& parseInt(obj_item44_GTZero.value.trim()) < parseInt(obj_item48_GTZero.value
						.trim())) {
			errorObjs.push(obj_item44_GTZero);
			errorObjs.push(obj_item48_GTZero);
			a += "��Ŀ" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "��"
					+ "�ߣ��������������������Ʒ�����������У�鲻ͨ����\n";
			isValid = false;
		}
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				objs[i].rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item45_GTZero.value.trim() != ""
				&& obj_item49_GTZero.value.trim() != ""
				&& parseInt(obj_item45_GTZero.value.trim()) < parseInt(obj_item49_GTZero.value
						.trim())) {
			errorObjs.push(obj_item45_GTZero);
			errorObjs.push(obj_item49_GTZero);
			a += "��Ŀ" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "��"
					+ "�У��������������������Ʒ�����������У�鲻ͨ����\n";
			isValid = false;
		}
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				objs[i].rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				objs[i].rownumber + "_1");
		if (obj_item46_GTZero.value.trim() != ""
				&& obj_item47_GTZero.value.trim() != ""
				&& parseInt(obj_item46_GTZero.value.trim()) < parseInt(obj_item47_GTZero.value
						.trim())) {
			errorObjs.push(obj_item46_GTZero);
			errorObjs.push(obj_item47_GTZero);
			a += "��Ŀ" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "��"
					+ "�ͣ��������������������Ʒ�����������У�鲻ͨ����\n";
			isValid = false;
		}
		var obj_item30_GTZero = getTableFormObj(label_item30_GTZero,
				objs[i].rownumber);
		if (parseInt(obj_item30_GTZero.value.trim()) > 100
				|| parseInt(obj_item30_GTZero.value.trim()) < 0) {
			errorObjs.push(obj_item30_GTZero);
			a += "��Ŀ" + objs[i].rownumber.substring(objs[i].rownumber.lastIndexOf("_")+1,objs[i].rownumber.length) + "��" + "0<������<=100���� \n";
			isValid = false;
		}
	}
	checkData1();
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
 *���ܣ��س����滻
 */
function replaceAll(value) {
	if (value == null)
		return value;
	while (value.indexOf("\r") > -1) {
		value = value.replace("\r", "");
	}
	return value;
}

/*
 *���ܣ�����������ֵ�Ƿ���ڵ��ڣ� ����ǣ�����true�����򣬷���false.
 */
function validGTZero(obj) {
	var _result = true;
	var val = obj.value.trim();
	if (val != null && val != "") {
		if (parseInt(val) < 0) {
			_result = false;
		}
	}
	return _result;
}

/*
 * ���ܣ���"��Ŀ״̬"Ϊ"���"ʱ,��֤��Ʋ��ֵı���
 */
function checkSubform10(obj) {
	if (getTableFormObj(label_item11, obj.rownumber).value.trim() == "���") {
		var obj_item44_GTZero = getTableFormObj(label_item44_GTZero,
				obj.rownumber + "_1");
		var obj_item45_GTZero = getTableFormObj(label_item45_GTZero,
				obj.rownumber + "_1");
		var obj_item46_GTZero = getTableFormObj(label_item46_GTZero,
				obj.rownumber + "_1");
		var obj_item48_GTZero = getTableFormObj(label_item48_GTZero,
				obj.rownumber + "_1");
		var obj_item49_GTZero = getTableFormObj(label_item49_GTZero,
				obj.rownumber + "_1");
		var obj_item47_GTZero = getTableFormObj(label_item47_GTZero,
				obj.rownumber + "_1");

		if (obj_item44_GTZero.value.trim() == "") {
			errorObjs.push(obj_item44_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������߲���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item45_GTZero.value.trim() == "") {
			errorObjs.push(obj_item45_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������в���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item46_GTZero.value.trim() == "") {
			errorObjs.push(obj_item46_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item48_GTZero.value.trim() == "") {
			errorObjs.push(obj_item48_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������߲���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item49_GTZero.value.trim() == "") {
			errorObjs.push(obj_item49_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������в���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item47_GTZero.value.trim() == "") {
			errorObjs.push(obj_item47_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������Ͳ���Ϊ�գ�\n";
			isValid = false;
		}
		
		var obj_label_item30_GTZero = getTableFormObj(label_item30_GTZero, obj.rownumber);
		if (obj_label_item30_GTZero.value.trim() == "") {
			errorObjs.push(obj_label_item30_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�����ʲ���Ϊ�գ�\n";
			isValid = false;
		}
		var obj_label_item24 = getTableFormObj(label_item24, obj.rownumber + "_1");
		if (obj_label_item24.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item24));
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�����Ŀ״̬��Ϊ����ɡ�ʱ������������������Ϊ�գ�\n";
			isValid = false;
		}
		var obj_label_item25=getSingalFileObj(label_item25, obj.rownumber + "_1");
		if (obj_label_item25.value.trim() == "") {
			errorObjs.push(getSingalFileTextObj(label_item25, obj.rownumber + "_1"));
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�����Ŀ״̬��Ϊ����ɡ�ʱ������Ʊ��渽��������Ϊ�գ�\n";
			isValid = false;
		}
		if (validGTZero(obj_item44_GTZero) == false) {
			errorObjs.push(obj_item44_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������߲�������С��0����ֵ��\n";
			isValid = false;
		}
		if (validGTZero(obj_item45_GTZero) == false) {
			errorObjs.push(obj_item45_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������в�������С��0����ֵ��\n";
			isValid = false;
		}
		if (validGTZero(obj_item46_GTZero) == false) {
			errorObjs.push(obj_item46_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "��Ʒ����������Ͳ�������С��0����ֵ��\n";
			isValid = false;
		}
		if (validGTZero(obj_item48_GTZero) == false) {
			errorObjs.push(obj_item48_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������߲�������С��0����ֵ��\n";
			isValid = false;
		}
		if (validGTZero(obj_item49_GTZero) == false) {
			errorObjs.push(obj_item49_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������в�������С��0����ֵ��\n";
			isValid = false;
		}
		if (validGTZero(obj_item47_GTZero) == false) {
			errorObjs.push(obj_item47_GTZero);
			a += "��Ŀ" + obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length) + "��" + "�������������Ͳ�������С��0����ֵ��\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ����������Ϣ�Ƽ��ڲ���Ƹ���һ����֧�������������У��
 */
function checkData1() {
	var obj = getTableFormObj(label_item50_GTZero,"1");
	if (obj.value.trim() =="") {
		errorObjs.push(obj);
		a += "�������Ϣ�Ƽ��ڲ���Ƹ���һ����֧�����������Ϊ�գ� \n";
		isValid = false;
	}else {
		if (parseInt(obj.value.trim()) > 100) {
			errorObjs.push(obj);
			a += "�������Ϣ�Ƽ��ڲ���Ƹ���һ����֧�������=<100���� \n";
			isValid = false;
		}
		if (parseInt(obj.value) < 0) {
			errorObjs.push(obj);
			a += "0=<�������Ϣ�Ƽ��ڲ���Ƹ���һ����֧����������� \n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull(obj) {
	 var obj_label_item6 = getTableFormObj(label_item6, obj.rownumber);
	 var obj_label_item7 = getTableFormObj(label_item7, obj.rownumber);
	 var obj_label_item8 = getTableFormObj(label_item8, obj.rownumber);
	 var obj_label_DateTimeField1 =getTableFormObj(label_DateTimeField1, obj.rownumber + "_1_1");
	 var obj_label_DateTimeField2 =getTableFormObj(label_DateTimeField2, obj.rownumber + "_1_1");
	 var obj_label_item10 =getTableFormObj(label_item10, obj.rownumber);
	 var obj_label_item11 =getTableFormObj(label_item11, obj.rownumber);

	 if (obj.value.trim() !="" && obj.value.trim() != "��"){
		if (obj_label_item6.value.trim() == "") {
			errorObjs.push(obj_label_item6.parentElement);
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�������Ŀ��𡱲���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_item7.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item7));
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ��������ݼ���Χ������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_item8.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_label_item8));
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�����ʵʩ��λ������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_DateTimeField1.value.trim() == "") {
			errorObjs.push(obj_label_DateTimeField1);
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�������ʼ���ڡ�����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_DateTimeField2.value.trim() == "") {
			errorObjs.push(obj_label_DateTimeField2);
			a += "��Ŀ" +obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+ "��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�����������ڡ�����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_item10.value.trim() == "") {
			errorObjs.push(obj_label_item10.parentElement);
			a += "��Ŀ" +obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ������Ƿ��ϱ����»����»ᡱ����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_label_item11.value.trim() == "") {
			errorObjs.push(obj_label_item11.parentElement);
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"��" + "��Ŀ���Ʋ�Ϊ���ޡ���գ�������Ŀ״̬������Ϊ�գ�\n";
			isValid = false;
		}
	 }else{
		 if(obj_label_item6.value.trim() != "" || obj_label_item7.value.trim() != "" || obj_label_item8.value.trim() != ""||
				 obj_label_DateTimeField1.value.trim() != "" || obj_label_DateTimeField2.value.trim() != "" || 
				 	obj_label_item10.value.trim() != "" || obj_label_item11.value.trim() != ""){
			errorObjs.push(getEditDiv(obj));
			a += "��Ŀ"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"����Ŀ���Ʋ���Ϊ�գ�\n";
			isValid = false;
		 }
	 }
}

var click_columnValueNumber = function() {
	columnValueNumber(this);
};

