/*
 * ����T-B-12 ���ѱ��ݹ��������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item5 = "�ֱ����ģ����ֱ��������������#�ֱ�ģʽ#����";
var label_item6 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#��������";
var label_item7 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#�����ݵ�������������";
var label_item = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#����";
var label_item8 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#�ص�";
var label_item9_GTZero = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#���������ľ��루���";
var label_item10 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#�ֱ��ָ������ȼ�";
var label_item11 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#�Ƿ����";
var label_item12 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#���������";
var label_item14 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#�������";
var label_item15 = "�ֱ����ģ����ֱ��������������#�ֱ����ģ����ֱ�����������#��������";

/*
 *���ܣ��ָ�����й���
 */
var click_addrow = function(){
	addRow(this,'N');
}
/*
 *���ܣ��ָ�ɾ���й���
 */
var re_deleterow = function(){
	deleteRow(this,'N');
}
/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
 *���ܣ��ָ����ּ�������
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
//	var target = getTarget(obj.parentElement);
	var obj_item5 = getTableFormObjs(label_item5)[0];
	var obj_item6s = getTableFormObjs(label_item6);
	if(obj_item5.value == "���ֱ�����"){
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			//������������
			if(obj_item6s[i].rownumber.indexOf("#") < 0)
			deleteRow(obj_item6s[i],'N');
			var addImg = document.getElementsByName("�ֱ����ģ����ֱ�����������")[0];
			addImg.onclick = "";
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14 = getTableFormObj(label_item14,obj_item6s[i].rownumber);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			ֻ��
			obj_item6_area.contentEditable = false;
			obj_item7_area.contentEditable = false;
			columnVallueRadio1(obj_item,false,false);
			obj_item8_area.contentEditable = false;
			columnVallueRadio1(obj_item10,false,false);
			columnVallueRadio1(obj_item11,false,false);
			obj_item12_area.contentEditable = false;
			disableTableCheckBox(obj_item14_checkbox,true);
			
//			��ֵ
			obj_item6_area.innerHTML = "";
			obj_item7_area.innerHTML = "";
			obj_item8_area.innerHTML = "";
			obj_item9.onclick = "";
			obj_item12_area.innerHTML = "";
			obj_item14.value = "";
			obj_item15.onclick = "";			
			
		}
	}else if(obj_item5.value != "���ֱ�����"){
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			��д
			obj_item6_area.contentEditable = true;
			obj_item7_area.contentEditable = true;
			columnVallueRadio1(obj_item,true,false);
			obj_item8_area.contentEditable = true;
			obj_item9.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_item10,true,false);
			columnVallueRadio1(obj_item11,true,true);
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
			obj_item15.onclick = click_columnshowDate;			
			
			var addImg = document.getElementsByName("�ֱ����ģ����ֱ�����������")[0];
			if(addImg.onclick == ""){
				//���֮ǰ��������ֱ����ġ�addimg��onclick�¼�Ϊ�գ����������з���
				addImg.onclick = click_addrow;
			}
		}
	}
	
	var obj_item11 = getTableFormObjs(label_item11);
	for(var i = 0; i < obj_item11.length; i++){
		var obj_item12 = getTableFormObj(label_item12,obj_item11[i].rownumber);
		var obj_item12_area = getEditDiv(obj_item12);
		var obj_item14 = getTableFormObj(label_item14,obj_item11[i].rownumber);
		var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item11[i].rownumber);
		if(obj_item11[i].value == "��"){
			// ֻ��
			obj_item12_area.contentEditable = false;
			// ���
			obj_item12_area.innerHTML = "";
			disableTableCheckBox(obj_item14_checkbox,true);
			//�����ɫ
			getEditDiv(obj_item12).style.backgroundColor = "";
			obj_item14.parentElement.style.color = "";
		}else {
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
		}
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã��ֱ����ģ����ֱ�������������� #�ֱ�ģʽ#����
 */
function setItem5Disable(obj) {
	var target = getTarget(obj.parentElement);
	var obj_item6s = getTableFormObjs(label_item6);
	if(target.value == "���ֱ�����"){
		
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			//������������
			if(obj_item6s[i].rownumber.indexOf("#") < 0)
			deleteRow(obj_item6s[i],'N');
			
			var addImg = document.getElementsByName("�ֱ����ģ����ֱ�����������")[0];
			addImg.onclick = "";
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14 = getTableFormObj(label_item14,obj_item6s[i].rownumber);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			ֻ��
			obj_item6_area.contentEditable = false;
			obj_item7_area.contentEditable = false;
			columnVallueRadio1(obj_item,false,false);
			obj_item8_area.contentEditable = false;
			columnVallueRadio1(obj_item10,false,false);
			columnVallueRadio1(obj_item11,false,false);
			obj_item12_area.contentEditable = false;
			disableTableCheckBox(obj_item14_checkbox,true);
			
//			��ֵ
			obj_item6_area.innerHTML = "";
			obj_item7_area.innerHTML = "";
			obj_item8_area.innerHTML = "";
			obj_item9.onclick = "";
			obj_item12_area.innerHTML = "";
			obj_item14.value = "";
			obj_item15.onclick = "";			
			
		}
		var deleteimgs = document.getElementsByTagName("img");
		for(var i = 0; i < deleteimgs.length; i++){
			if(deleteimgs[i].src.indexOf("images/bullet_delete.png") > -1){
				deleteimgs[i].onclick = "";
			}
		}
	}else if(target.value != "���ֱ�����"){
		var deleteimgs = document.getElementsByTagName("img");
		for(var i = 0; i < deleteimgs.length; i++){
			if(deleteimgs[i].src.indexOf("images/bullet_delete.png") > -1 && deleteimgs[i].onclick == ""){
				deleteimgs[i].onclick = re_deleterow;
			}
		}
		for(var i = 0; i < obj_item6s.length; i++){
			if(obj_item6s[i].rownumber.indexOf("#") > -1){
				continue;
			}
			
			var obj_item6 = getTableFormObj(label_item6,obj_item6s[i].rownumber);
			var obj_item6_area = getEditDiv(obj_item6);
			var obj_item7 = getTableFormObj(label_item7,obj_item6s[i].rownumber);
			var obj_item7_area = getEditDiv(obj_item7);
			var obj_item = getTableFormObj(label_item,obj_item6s[i].rownumber);
			var obj_item8 = getTableFormObj(label_item8,obj_item6s[i].rownumber);
			var obj_item8_area = getEditDiv(obj_item8);
			var obj_item9 = getTableFormObj(label_item9_GTZero,obj_item6s[i].rownumber);
			var obj_item10 = getTableFormObj(label_item10,obj_item6s[i].rownumber);
			var obj_item11 = getTableFormObj(label_item11,obj_item6s[i].rownumber);
			var obj_item12 = getTableFormObj(label_item12,obj_item6s[i].rownumber);
			var obj_item12_area = getEditDiv(obj_item12);
			var obj_item14_checkbox = getTableFormCheckBox(label_item14,obj_item6s[i].rownumber);
			var obj_item15 = getTableFormObj(label_item15,obj_item6s[i].rownumber);
//			��д
			obj_item6_area.contentEditable = true;
			obj_item7_area.contentEditable = true;
			columnVallueRadio1(obj_item,true,false);
			obj_item8_area.contentEditable = true;
			obj_item9.onclick = click_columnValueNumber;
			columnVallueRadio1(obj_item10,true,false);
			columnVallueRadio1(obj_item11,true,true);
			obj_item12_area.contentEditable = true;
			disableTableCheckBox(obj_item14_checkbox,false);
			obj_item15.onclick = click_columnshowDate;	
			
			var addImg = document.getElementsByName("�ֱ����ģ����ֱ�����������")[0];
			if(addImg.onclick == ""){
				//���֮ǰ��������ֱ����ġ�addimg��onclick�¼�Ϊ�գ����������з���
				addImg.onclick = click_addrow;
			}
		}
	}
}


/*
 *���ܣ���ѡ��ť�Ķ�д����
 *������objΪ��ѡ����
 *	  access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false
 *	  flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio1(obj,access,flag){
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
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								setItem11Disable(this);
							};
						}
					}
				}
			}
		}
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã��ֱ����ģ����ֱ�������������� #�ֱ����ģ����ֱ�����������#�Ƿ����
 */
function setItem11Disable(obj) {
	var target = getTarget(obj.parentElement);
	var obj_item12 = getTableFormObj(label_item12,target.rownumber);
	var obj_item12_area = getEditDiv(obj_item12);
	var obj_item14 = getTableFormObj(label_item14,target.rownumber);
	var obj_item14_checkbox = getTableFormCheckBox(label_item14,target.rownumber);
	if(target.value == "��"){
		// ֻ��
		obj_item12_area.contentEditable = false;
		// ���
		obj_item12_area.innerHTML = "";
		disableTableCheckBox(obj_item14_checkbox,true);
		//�����ɫ
		getEditDiv(obj_item12).style.backgroundColor = "";
		obj_item14.parentElement.style.color = "";
	}else {
		obj_item12_area.contentEditable = true;
		disableTableCheckBox(obj_item14_checkbox,false);
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
	
	var obj_item5 = getTableFormObjs(label_item5)[0];
	if(obj_item5.value == ""){
		a+="�ֱ����Ļ���������ֱ�ģʽ����Ϊ��\n";
		isValid=false;
		return;
	}
	
	var obj_item6s = getTableFormObjs(label_item6);
	for(var i = 0; i < obj_item6s.length; i++){
		if(obj_item6s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		checkTableItemNull(obj_item6s[i],obj_item5);
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
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull(obj,obj_item5) {

	var obj_item7 = getTableFormObj(label_item7,obj.rownumber);
	var obj_item = getTableFormObj(label_item,obj.rownumber);
	var obj_item8 = getTableFormObj(label_item8,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9_GTZero,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item11 = getTableFormObj(label_item11,obj.rownumber);
	var obj_item12 = getTableFormObj(label_item12,obj.rownumber);
	var obj_item14 = getTableFormObj(label_item14,obj.rownumber);
	var obj_item15 = getTableFormObj(label_item15,obj.rownumber);

	if (obj_item5.value != "���ֱ�����"){
		if(obj.value == "" && replaceAll(obj_item7.value.trim()) == "" && replaceAll(obj_item.value.trim()) == "" &&
				replaceAll(obj_item8.value.trim()) == "" && obj_item9.value == "" && obj_item10.value.trim() == ""&&
				obj_item11.value.trim() == "" && obj_item12.value == "" && obj_item14.value == "" && obj_item15.value.trim() == ""){
			errorObjs.push(getEditDiv(obj));
			errorObjs.push(getEditDiv(obj_item7));
			errorObjs.push(obj_item.parentElement);
			errorObjs.push(getEditDiv(obj_item8));
			errorObjs.push(obj_item9);
			errorObjs.push(obj_item10.parentElement);
			errorObjs.push(obj_item11.parentElement);
			errorObjs.push(obj_item15);
			a += "��ѡ��ǡ����ֱ����ġ�ʱ����������ֱ����ģ����ֱ�����������������еġ��������ơ�����Ϣ��\n";
			isValid = false;
		}else{
			if (replaceAll(obj.value.trim()) == ""  ) {
				errorObjs.push(getEditDiv(obj));
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ���Ϊ�գ�\n";
				isValid = false;
			}
			if (replaceAll(obj_item7.value.trim()) == "" ) {
				errorObjs.push(getEditDiv(obj_item7));
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ��������������������ơ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (replaceAll(obj_item.value.trim()) == "" ) {
				errorObjs.push(obj_item.parentElement);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ��������򡱲���Ϊ�գ�\n";
				isValid = false;
			}
			if (replaceAll(obj_item8.value.trim()) == "" ) {
				errorObjs.push(getEditDiv(obj_item8));
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ������ص㡱����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item9.value == "" ) {
				errorObjs.push(obj_item9);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ��������������ľ��루���������Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item10.value.trim() == "") {
				errorObjs.push(obj_item10.parentElement);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ������������ڡ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "") {
				errorObjs.push(obj_item11.parentElement);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���գ������Ƿ����������Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "��" && obj_item12.value == "") {
				errorObjs.push(obj_item12);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���ղ��ҡ��Ƿ������Ϊ���ǡ�ʱ��������������ơ�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item11.value.trim() == "��" && obj_item14.value == "") {
				errorObjs.push(obj_item14.parentElement);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���ղ��ҡ��Ƿ������Ϊ���ǡ�ʱ������������͡�����Ϊ�գ�\n";
				isValid = false;
			}
			if (obj_item15.value.trim() == "") {
				errorObjs.push(obj_item15);
				a += "�ֱ�����(���ֱ�����)�������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������Ʋ�Ϊ���ޡ���ղ��ҡ��Ƿ������Ϊ���ǡ�ʱ�������������ڡ�����Ϊ�գ�\n";
				isValid = false;
			}
		}
	}
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
