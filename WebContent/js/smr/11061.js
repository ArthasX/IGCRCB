/*
 * ����2014 -T-B-5 ���簲ȫ����������������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
var label_YN00 = "���Ϳձ���#���Ϳձ�";
var label_YN00_01 = "����#�����";
var label_YN00_02 = "����#���";
var label_YN00_03 = "����#����ϵ�绰";
var label_YN00_04 = "����#�������";
var label_YN00_05 = "����#�������";
// �������簲ȫ�򻮷�
var label_YN01_01 = "�������簲ȫ�򻮷�#����#��������";
var label_YN01_02 = "�������簲ȫ�򻮷�#����#��;����������Ҫ��Ϣϵͳ";
var label_YN01_03 = "�������簲ȫ�򻮷�#����#�ɷ�����Щ���簲ȫ��";
var label_YN01_04 = "�������簲ȫ�򻮷�#����#�ɱ���Щ���簲ȫ�����";
var label_YN01_05 = "�������簲ȫ�򻮷�#����#���뼰������ʩ";
var label_YN01_06 = "�������簲ȫ�򻮷�#����#Զ�̽���";
// ����߽����
var label_YN02_01 = "����߽����#��1#����";
var label_YN02_02 = "����߽����#��2#����";
var label_YN02_03 = "����߽����#��3#����";
var label_YN02_04 = "����߽����#��4#����";
// �������豸������
//var label_YN03_02_01 = "�������豸������#������������";
// ����������
var label_YN07_01 = "����������#1#��ѡ";
var label_YN07_02 = "����������#2#��ѡ";
// ���簲ȫ�����ʩ
var label_YN08_01 = "���簲ȫ�����ʩ#����#������ڲ��칫�����ʻ�����";
var label_YN08_02 = "���簲ȫ�����ʩ#����#��������";
var label_YN08_03 = "���簲ȫ�����ʩ#����#�������ɷ����ڲ�����";
var label_YN08_04 = "���簲ȫ�����ʩ#����#�ڻ����ڲ�ʹ�����߾�������";
var label_YN08_05 = "���簲ȫ�����ʩ#����#����Э��ͼ��ܷ�ʽ";
var label_YN08_06 = "���簲ȫ�����ʩ#����#���ǣ����߾�������������������";
var label_YN08_07 = "���簲ȫ�����ʩ#����#���߾������������֤��ʽ";
var label_YN08_08 = "���簲ȫ�����ʩ#����#������������©��ɨ��������";
var label_YN08_09 = "���簲ȫ�����ʩ#����#���������©��ɨ�����Ĵ���";
var label_YN08_10 = "���簲ȫ�����ʩ#����#��������������װ������";
var label_YN08_11 = "���簲ȫ�����ʩ#����#���粡�������������";

var label_YN08_12 = "���簲ȫ�����ʩ#����#�������Ӫ��ǩ��DDoS��������Э��";
var label_YN08_13 = "���簲ȫ�����ʩ#����#ǩ��Э��ĵ�����Ӫ������";
// ����
var label_YN_09 = "����#����#����#��������";
/*
 * ���ܣ��ύ��ťУ��
 * 
 */
function checkData() {
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// �������簲ȫ�򻮷�У��
	var objs_YN01_01 = getTableFormObjs(label_YN01_01);
	var sign_YN01 = true;
	for ( var i = 0; i < objs_YN01_01.length-1; i++) {
		var obj_YN01_02 = getTableFormObj(label_YN01_02,
				objs_YN01_01[i].rownumber);
		var obj_YN01_03 = getTableFormObj(label_YN01_03,
				objs_YN01_01[i].rownumber);
		var obj_YN01_04 = getTableFormObj(label_YN01_04,
				objs_YN01_01[i].rownumber);
		var obj_YN01_05 = getTableFormObj(label_YN01_05,
				objs_YN01_01[i].rownumber);
		var obj_YN01_06 = getTableFormObj(label_YN01_06,
				objs_YN01_01[i].rownumber);

		if (objs_YN01_01[i].value == "" || obj_YN01_02.value == ""
				|| obj_YN01_03.value == "" || obj_YN01_04.value == ""
				|| obj_YN01_05.value == "" || obj_YN01_06.value == "") {
			if (objs_YN01_01[i].value == "") {
				errorObjs.push(objs_YN01_01[i]);
			}
			if (obj_YN01_02.value == "") {
				errorObjs.push(obj_YN01_02);
			}
			if (obj_YN01_03.value == "") {
				errorObjs.push(obj_YN01_03);
			}
			if (obj_YN01_04.value == "") {
				errorObjs.push(obj_YN01_04);
			}
			if (obj_YN01_05.value == "") {
				errorObjs.push(obj_YN01_05);
			}
			if (obj_YN01_06.value == "") {
				errorObjs.push(obj_YN01_06);
			}
			isValid = false;
			sign_YN01 = false;
		}
	}
	if (!sign_YN01) {
		a += "1.�������簲ȫ�򻮷ָ����Ϊ�գ�\n";
	}
	// ����߽����У��
	var objs_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var objs_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	var objs_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var objs_YN02_04 = getTableFormObjs(label_YN02_04)[0];
	if (objs_YN02_01.value == "" || objs_YN02_02.value == ""
			|| objs_YN02_03.value == "" || objs_YN02_04.value == "") {
		if (objs_YN02_01.value == "") {
			errorObjs.push(objs_YN02_01);
		}
		if (objs_YN02_02.value == "") {
			errorObjs.push(objs_YN02_02);
		}
		if (objs_YN02_03.value == "") {
			errorObjs.push(objs_YN02_03);
		}
		if (objs_YN02_04.value == "") {
			errorObjs.push(objs_YN02_04);
		}
		a += "2.����߽���Ƹ����Ϊ�գ�\n";
		isValid = false;
	}
//	// �������豸������У��
//	var objs_YN03_02_01 = getTableFormObjs(label_YN03_02_01);
//	var sign_YN03 = true;
//	for(var i = 0;i<objs_YN03_02_01.length;i++){
//		if(objs_YN03_02_01[i].value == ""){
//			sign_YN03 = false;
//			errorObjs.push(objs_YN03_02_01[i]);
//			isValid = false;
//		}
//	}
//	if(!sign_YN03){
//		a+="3.�������豸�����Ը����Ϊ�գ�\n";
//	}
	// ����������У��
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];

	if (obj_YN07_01.value == "" || obj_YN07_02.value == "") {
		if (obj_YN07_01.value == "") {
			errorObjs.push(obj_YN07_01);
		}
		if (obj_YN07_02.value == "") {
			errorObjs.push(obj_YN07_01);
		}
		a += "5.����������������Ϊ�գ�\n";
		isValid = false;
	}
	// ���簲ȫ�����ʩУ��
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_08 = getTableFormObjs(label_YN08_08)[0];
	var obj_YN08_09 = getTableFormObjs(label_YN08_09)[0];
	var obj_YN08_10 = getTableFormObjs(label_YN08_10)[0];
	var obj_YN08_11 = getTableFormObjs(label_YN08_11)[0];
	var obj_YN08_12 = getTableFormObjs(label_YN08_12)[0];
	if (obj_YN08_01.value == "" || obj_YN08_03.value == ""
			|| obj_YN08_04.value == "" || obj_YN08_08.value == ""
			|| obj_YN08_09.value == "" || obj_YN08_10.value == ""
			|| obj_YN08_11.value == "" || obj_YN08_12.value == "") {
		if(obj_YN08_01.value == ""){
			errorObjs.push(obj_YN08_01);
		}
		if(obj_YN08_03.value == ""){
			errorObjs.push(obj_YN08_03);
		}
		if(obj_YN08_04.value == ""){
			errorObjs.push(obj_YN08_04);
		}
		if(obj_YN08_08.value == ""){
			errorObjs.push(obj_YN08_08);
		}
		if(obj_YN08_09.value == ""){
			errorObjs.push(obj_YN08_09);
		}
		if(obj_YN08_10.value == ""){
			errorObjs.push(obj_YN08_10);
		}
		if(obj_YN08_11.value == ""){
			errorObjs.push(obj_YN08_11);
		}
		if(obj_YN08_12.value == ""){
			errorObjs.push(obj_YN08_12);
		}
		
		a+="6.����������������Ϊ�գ�\n";
		isValid = false;
	}
	// ����У��
	var obj_YN_09 = getTableFormObjs(label_YN_09)[0];
	if (obj_YN_09.value == "") {
		errorObjs.push(obj_YN_09);
		a += "7.\"��������ʾ��ͼ��������ܰ�\"����Ϊ�գ�\n";
		isValid = false;
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
	var emptyObj = getTableFormObjs(label_YN00)[0];
	if (emptyObj.value == "") {
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
	} else if (emptyObj.value == "���Ϳձ�") {
		isValid = true;
		var b = "";
		var obj_YN00_01 = getTableFormObj(label_YN00_01,"1");
		var obj_YN00_02 = getTableFormObj(label_YN00_02,"1");
		var obj_YN00_03 = getTableFormObj(label_YN00_03,"1");
		var obj_YN00_04 = getTableFormObj(label_YN00_04,"1");
		var obj_YN00_05 = getTableFormObj(label_YN00_05,"1");
		if(obj_YN00_01.value == ""){
			b += "��������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_02.value == ""){
			b += "������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_03.value == ""){
			b += "��ϵ�绰���ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_04.value == ""){
			b += "���������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(obj_YN00_05.value == ""){
			b += "����������ݲ���Ϊ�գ�\n";
			isValid = false;
		}
		if(!isValid){
			alert(b);
		}
	}
	return isValid;
}
/*
 * ���ܣ���ʼ��
 * 
 */
function initSet() {
	var obj = 0;
	setYN_08_02Visable(obj);
	setYN_08_05Visable(obj);
	setYN_08_13Visable(obj);
}
/*
 * ���ܣ�ͨ���������Ӫ��ǩ��DDoS��������Э��������ǩ��Э��ĵ�����Ӫ�����Ƶ����غ���ʾ
 * ���ã����簲ȫ�����ʩ#����#�������Ӫ��ǩ��DDoS��������Э��
 */
function setYN_08_13Visable(obj) {
	var obj_YN08_12 = getTableFormObjs(label_YN08_12)[0];
	var obj_YN08_13 = getTableFormObjs(label_YN08_13)[0];
	if (obj_YN08_12.value == "��") {
		obj_YN08_13.value = "";
		obj_YN08_13.parentNode.previousSibling.style.display = "none";
		obj_YN08_13.parentNode.style.display = "none";
	} else if (obj_YN08_12.value == "��") {
		obj_YN08_13.readOnly = "";
		obj_YN08_13.parentNode.previousSibling.style.display = "";
		obj_YN08_13.parentNode.style.display = "";
	} else {
		obj_YN08_13.readOnly = "readonly";
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
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio0(obj, access, flag) {
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
						imgs[k].onclick="";
						if(!imgs[k].flag){
							jQuery(imgs[k].parentElement.nextSibling.firstChild).hide();
							imgs[k].parentElement.nextSibling.firstChild.value = "";
						}
					} else {
						if (!flag) {
							if(imgs[k].flag){
								imgs[k].onclick = ( function() {
									columnVallueRadio(this);
								});
							}else{
								imgs[k].onclick = ( function() {
									columnVallueRadioElse(this);
								});
							}
							
						} 
					}
				}
			}
		}
	}
}
/*
 * ���ܣ�ͨ���ڻ����ڲ�ʹ�����߾�����������������Э��ͼ��ܷ�ʽ�����غ���ʾ ���ã����簲ȫ�����ʩ#����#�ڻ����ڲ�ʹ�����߾�������
 */
function setYN_08_05Visable(obj) {
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_05 = getTableFormObjs(label_YN08_05)[0];
	var obj_YN08_06 = getTableFormCheckBox(label_YN08_06, "1_1");
	var obj_YN08_07 = getTableFormObj(label_YN08_07, obj_YN08_04.rownumber);
	if (obj_YN08_04.value == "��") {
		obj_YN08_05.value = "";
		obj_YN08_05.parentNode.previousSibling.style.display = "none";
		obj_YN08_05.parentNode.style.display = "none";
		// ���
		obj_YN08_06.onclick = "";
		obj_YN08_07.value = "";
		// ֻ��
		disableTableCheckBox(obj_YN08_06, true);
		columnVallueRadio0(obj_YN08_07, false,true);
	} else if (obj_YN08_04.value == "��") {
		obj_YN08_05.readOnly = "";
		obj_YN08_05.parentNode.previousSibling.style.display = "";
		obj_YN08_05.parentNode.style.display = "";
		disableTableCheckBox(obj_YN08_06, false);
		columnVallueRadio0(obj_YN08_07, true,false);
	} else {
		disableTableCheckBox(obj_YN08_06, true);
		obj_YN08_05.readOnly = "readonly";
		columnVallueRadio0(obj_YN08_07, false,true);
	}

}
/*
 * ���ܣ�ͨ��������ڲ��칫�����ʻ������������������ŵ����غ���ʾ ���ã����簲ȫ�����ʩ#����#������ڲ��칫�����ʻ�����
 */
function setYN_08_02Visable(obj) {
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObjs(label_YN08_02)[0];
	if (obj_YN08_01.value == "��") {
		obj_YN08_02.value = "";
		obj_YN08_02.parentNode.previousSibling.style.display = "none";
		obj_YN08_02.parentNode.style.display = "none";
	} else if (obj_YN08_01.value == "��") {
		obj_YN08_02.readOnly = "";
		obj_YN08_02.parentNode.previousSibling.style.display = "";
		obj_YN08_02.parentNode.style.display = "";
	} else {
		obj_YN08_02.readOnly = "readonly";
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

//��ʼ����ʽ
jQuery(function() {
	if(jQuery("#psdid").val()!=jQuery("#pdid").val()+"003"){
		jQuery("#"+jQuery("#pdid").val()+"034_tableForm").css("width","815px");
		var tableArr = jQuery(".table_form_group");
		for(var i = 0;i<tableArr.length;i++){
			if(tableArr[i].id == jQuery("#pdid").val()+"042_tableForm"){
				jQuery(tableArr[i]).css("width","815px");
			}
		}
	}
});