/*
 * ����T-Q-1 ��Ҫ��Ϣϵͳ���������
 */
var isValid = true;
var a = "";
var errorObjs=[];
var label_item21 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#��Ϣϵͳ";
var label_item23 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#ֹͣ����ԭ��";
var label_item24 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#�¼��ȼ�";
var label_item0 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#��ʼʱ��";
var label_item1 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#����ʱ��";
var label_item25 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#Ӱ�췶Χ#Ӱ�췶Χ";
var label_item26 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#Ӱ�췶Χ#��֧����";
var label_item27 = "��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#����";

var label_R_item21 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#��Ϣϵͳ";
var label_R_item23 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#ֹͣ����ԭ��";
var label_R_item0 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#��ʼʱ��";
var label_R_item1 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#����ʱ��";
var label_R_item25 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#Ӱ�췶Χ#Ӱ�췶Χ";
var label_R_item26 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#Ӱ�췶Χ#��֧����";
var label_R_item27 = "��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#����";

var label_item57_GTZero="����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������1#����";
var label_item58_GTZero="����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������2#����";

var label_item67_GTZero="��������ϵͳ�������#��������ϵͳ�������1#����";

var label_item73_GTZero="���п�ϵͳ�������#���п�ϵͳ�������1#����";

var label_item74_GTZero="���������ϵͳ�������#���������ϵͳ�������1#����";
var label_item73 = "���������ϵͳ�������#���������ϵͳ�������2#����";

/*
* ���ܣ����̴���ҳ��ʼ��ʱ���ñ�Ȩ��
* ���ã��״̬�Ͷ�������״̬
*/
function initSet(){
	var label_item21s=getTableFormObjs(label_item21);
	var label_item23s=getTableFormObjs(label_item23);
	var label_item24s=getTableFormObjs(label_item24);
	var label_item0s=getTableFormObjs(label_item0);
	var label_item1s=getTableFormObjs(label_item1);
	var label_item25s=getTableFormObjs(label_item25);
	var label_item26s=getTableFormObjs(label_item26);
	var label_item27s=getTableFormObjs(label_item27);
	
	var label_R_item21s=getTableFormObjs(label_R_item21);
	var label_R_item23s=getTableFormObjs(label_R_item23);
	var label_R_item0s=getTableFormObjs(label_R_item0);
	var label_R_item1s=getTableFormObjs(label_R_item1);
	var label_R_item25s=getTableFormObjs(label_R_item25);
	var label_R_item26s=getTableFormObjs(label_R_item26);
	var label_R_item27s=getTableFormObjs(label_R_item27);
	
	if(label_item21s[0].value==""){
		columnVallueRadio1(label_item23s[0],false);
		columnVallueRadio1(label_item24s[0],false);
		columnVallueRadio1(label_item25s[0],false);
		label_item0s[0].onclick="";
		label_item1s[0].onclick="";
		label_item26s[0].onclick="";
		label_item27s[0].value="";
		label_item27s[0].parentElement.childNodes[0].contentEditable =false;
	}
	for(var i = 0; i < label_item23s.length; i++){
		if(label_item23s[i].rownumber.indexOf("#") > -1){
			if(label_item21s[i].value==""){
			columnVallueRadio1(label_item23s[i],false);
			columnVallueRadio1(label_item24s[i],false);
			columnVallueRadio1(label_item25s[i],false);
			label_item0s[i].onclick="";
			label_item1s[i].onclick="";
			label_item26s[i].onclick="";
			label_item27s[i].value="";
			label_item27s[i].parentElement.childNodes[0].contentEditable =false;
				}
		}else{
			continue;
		}
		
	}
	if(label_R_item21s[0].value==""){
		columnVallueRadio1(label_R_item23s[0],false);
		columnVallueRadio1(label_R_item25s[0],false);
		label_R_item0s[0].onclick="";
		label_R_item1s[0].onclick="";
		label_R_item26s[0].onclick="";
		label_R_item27s[0].value="";
		label_R_item27s[0].parentElement.childNodes[0].contentEditable =false;
	}
	for(var i = 0; i < label_R_item23s.length; i++){
		if(label_R_item23s[i].rownumber.indexOf("#") > -1){
			if(label_R_item21s[i].value==""){
			columnVallueRadio1(label_R_item23s[i],false);
			columnVallueRadio1(label_R_item25s[i],false);
			label_R_item0s[i].onclick="";
			label_R_item1s[i].onclick="";
			label_R_item26s[i].onclick="";
			label_R_item27s[i].value="";
			label_R_item27s[i].parentElement.childNodes[0].contentEditable =false;
				}
		}else{
			continue;
		}
	}
	
}
var check_item26=function(){columnVallueRadio(this); obj_item26(this);};

/*
 *���ܣ���Ϣϵͳû��ѡ���ʱ��ͬ������������ѡ
 *���ã���Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#��Ϣϵͳ
 */
function obj_item21(obj) {
	var target = getTarget(obj.parentElement);
		var obj_item23=getTableFormObj(label_item23,target.rownumber);
		var obj_item24=getTableFormObj(label_item24,target.rownumber);
		var obj_item0=getTableFormObj(label_item0,target.rownumber);
		var obj_item1=getTableFormObj(label_item1,target.rownumber);
		var obj_item25=getTableFormObj(label_item25,target.rownumber+"_1");
		var obj_item26=getTableFormObj(label_item26,target.rownumber+"_1");
		var obj_item27=getTableFormObj(label_item27,target.rownumber);
			columnVallueRadio1(obj_item23,true);
			columnVallueRadio1(obj_item24,true);
			columnVallueRadio3(obj_item25,check_item26);
			obj_item0.onclick=function(){showTime(this);};
			obj_item1.onclick=function(){showTime(this);};
			obj_item26.onclick=function(){columnValueNumber(this);};
			obj_item27.parentElement.childNodes[0].contentEditable =true;
}

var check_R_item26=function(){columnVallueRadio(this); obj_R_item26(this);};
/*
 *���ܣ���Ϣϵͳû��ѡ���ʱ��ͬ������������ѡ
 *���ã���Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#��Ϣϵͳ
 */
function obj_R_item21(obj) {
	var target = getTarget(obj.parentElement);
		var obj_R_item23=getTableFormObj(label_R_item23,target.rownumber);
		var obj_R_item0=getTableFormObj(label_R_item0,target.rownumber);
		var obj_R_item1=getTableFormObj(label_R_item1,target.rownumber);
		var obj_R_item25=getTableFormObj(label_R_item25,target.rownumber+"_1");
		var obj_R_item26=getTableFormObj(label_R_item26,target.rownumber+"_1");
		var obj_R_item27=getTableFormObj(label_R_item27,target.rownumber);
			columnVallueRadio1(obj_R_item23,true);
			columnVallueRadio3(obj_R_item25,check_R_item26);
			obj_R_item0.onclick=function(){showTime(this);};
			obj_R_item1.onclick=function(){showTime(this);};
			obj_R_item26.onclick=function(){columnValueNumber(this);};
			obj_R_item27.parentElement.childNodes[0].contentEditable =true;
}
/*
 *���ܣ���ѡ��ť�Ķ�д����
 */
function columnVallueRadio3(obj,check){
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
						imgs[k].onclick = check;
				}
			}
		}
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
	
	var objs = getTableFormObjs(label_item21);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	
	var objs_R = getTableFormObjs(label_R_item21);
	for ( var i = 0; i < objs_R.length; i++) {
		// ����ģ��
		if ((objs_R[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull1(objs_R[i]);
	}

		if(parseFloat(getTableFormObj(label_item57_GTZero,"1_1_1_1").value) > parseFloat(getTableFormObj(label_item58_GTZero,"1_1_1_1").value)){
			errorObjs.push(getTableFormObj(label_item57_GTZero,"1_1_1_1"));
			errorObjs.push(getTableFormObj(label_item58_GTZero,"1_1_1_1"));
			a+="����ҵ��ϵͳ��Ҫ����ָ��-��������-�ս��ױ�����ֵ>=�վ����ױ�������\n";
			isValid=false;
			}
		if(parseFloat(getTableFormObjs(label_item67_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item67_GTZero)[1].value)){
				errorObjs.push(getTableFormObjs(label_item67_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item67_GTZero)[1]);
				a+="��������ϵͳ�������-�ս��ױ�����ֵ>=�վ����ױ�������\n";
				isValid=false;
			}
		
		if(parseFloat(getTableFormObjs(label_item73_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item73_GTZero)[1].value)){
				errorObjs.push(getTableFormObjs(label_item73_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item73_GTZero)[1]);
				a+="���п�ϵͳ�������-�ս��ױ�����ֵ>=�վ����ױ�������\n";
				isValid=false;
			}
	
		if(parseFloat(getTableFormObjs(label_item74_GTZero)[0].value) > parseFloat(getTableFormObjs(label_item73)[0].value))  {
				errorObjs.push(getTableFormObjs(label_item74_GTZero)[0]);
				errorObjs.push(getTableFormObjs(label_item73)[0]);
				a+="���������ϵͳ�������-�ս��ױ�����ֵ>=�վ����ױ�������\n";
				isValid=false;
			}
		
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#1#����")[0],3);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#2#����")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#3#CPU#����")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#3#CPU#����")[1],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#4#����")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#4#����")[1],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������1#����")[0],4);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������2#����")[0],4);
//		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������3#����")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#5#��������#��������4#����")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯1#����#ͬ�ȣ�������")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯1#����#���ȣ�������")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯1#����#��˾�˻�")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯2#����#�����˻�")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯2#����#ͬ�ȣ�������")[0],2);
		checkNumFloat(getTableFormObjs("����ҵ��ϵͳ��Ҫ����ָ��#6#�˻������䶯��#�˻������䶯2#����#���ȣ�������")[0],2);
		checkNumFloat(getTableFormObjs("��������ϵͳ�������#��������ϵͳ�������1#����")[0],4);
		checkNumFloat(getTableFormObjs("��������ϵͳ�������#��������ϵͳ�������1#����")[1],4);
		checkNumFloat(getTableFormObjs("���п�ϵͳ�������#���п�ϵͳ�������1#����")[0],4);
		checkNumFloat(getTableFormObjs("���п�ϵͳ�������#���п�ϵͳ�������1#����")[1],4);
		checkNumFloat(getTableFormObjs("���������ϵͳ�������#���������ϵͳ�������1#����")[0],4);
		checkNumFloat(getTableFormObjs("���������ϵͳ�������#���������ϵͳ�������2#����")[0],4);

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
function checkTableItemNull(obj) {

	var obj_item23 = getTableFormObj(label_item23,obj.rownumber);
	var obj_item24 = getTableFormObj(label_item24,obj.rownumber);
	var obj_item0 = getTableFormObj(label_item0,obj.rownumber);
	var obj_item1 = getTableFormObj(label_item1, obj.rownumber);
	var obj_item25 = getTableFormObj(label_item25, obj.rownumber + "_1");
	var obj_item26 = getTableFormObj(label_item26, obj.rownumber + "_1");
	var obj_item27 = getTableFormObj(label_item27, obj.rownumber);
	if (obj.value.trim() !="" ){
	
		if (obj_item23.value == ""  ) {
			errorObjs.push(obj_item23.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� ��Ԥ��ֹͣ����ֹͣ����ԭ�򣢲���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item24.value == "" ) {
			errorObjs.push(obj_item24.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� ��Ԥ��ֹͣ�����¼��ȼ�������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item0.value== "" ) {
			errorObjs.push(obj_item0);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� ��Ԥ��ֹͣ������ʼʱ�䣢����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item1.value == "" ) {
			errorObjs.push(obj_item1);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� ��Ԥ��ֹͣ���񣺽���ʱ�䣢����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item25.value.trim() == "") {
			errorObjs.push(obj_item25.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ�������-��Ԥ��ֹͣ�����Ӱ�췶Χ������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item25.value == "��֧����" && obj_item26.value.trim() == "") {
			errorObjs.push(obj_item26);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ�������-��Ԥ��ֹͣ�����Ӱ�췶Χѡ���֧����ʱ����������������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item27.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_item27));
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� ��Ԥ��ֹͣ��������������Ϊ�գ�\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull1(obj) {

	var obj_R_item23 = getTableFormObj(label_R_item23,obj.rownumber);
//	var obj_R_item24 = getTableFormObj(label_item24,obj.rownumber);
	var obj_R_item0 = getTableFormObj(label_R_item0,obj.rownumber);
	var obj_R_item1 = getTableFormObj(label_R_item1, obj.rownumber);
	var obj_R_item25 = getTableFormObj(label_R_item25, obj.rownumber + "_1");
	var obj_R_item26 = getTableFormObj(label_R_item26, obj.rownumber + "_1");
	var obj_R_item27 = getTableFormObj(label_R_item27, obj.rownumber);
	if (obj.value.trim() !="" ){
	
		if (obj_R_item23.value == ""  ) {
			errorObjs.push(obj_R_item23.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� Ԥ��ֹͣ����ֹͣ����ԭ�򣢲���Ϊ�գ�\n";
			isValid = false;
		}
		/*if (obj_R_item24.value == "" ) {
			errorObjs.push(obj_R_item24.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� Ԥ��ֹͣ�����¼��ȼ�������Ϊ�գ�\n";
			isValid = false;
		}*/
		if (obj_R_item0.value== "" ) {
			errorObjs.push(obj_R_item0);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� Ԥ��ֹͣ������ʼʱ�䣢����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_R_item1.value == "" ) {
			errorObjs.push(obj_R_item1);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� Ԥ��ֹͣ���񣺽���ʱ�䣢����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_R_item25.value.trim() == "") {
			errorObjs.push(obj_R_item25.parentElement);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ�������-Ԥ��ֹͣ�����Ӱ�췶Χ������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_R_item25.value == "��֧����" && obj_R_item26.value.trim() == "") {
			errorObjs.push(obj_R_item26);
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ�������-Ԥ��ֹͣ�����Ӱ�췶Χѡ���֧����ʱ����������������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_R_item27.value.trim() == "") {
			errorObjs.push(getEditDiv(obj_R_item27));
			a += "��Ҫ��Ϣϵͳֹͣ������������"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"������Ϣϵͳ��ѡ������ʱ������Ҫ��Ϣϵͳֹͣ������� Ԥ��ֹͣ��������������Ϊ�գ�\n";
			isValid = false;
		}
	}
}

/*
* ���ܣ�����ʱ�������ڿ�ʼʱ��
* ���ã�"��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#��ʼʱ��";
*/
function obj_item0_Start(obj) {
	var obj_item0s = getTableFormObjs(label_item0);
	for(var i = 0; i < obj_item0s.length; i++){
		if(obj_item0s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item1 = getTableFormObj(label_item1,obj_item0s[i].rownumber);
		if(obj_item0s[i].value != "" && obj_item1.value != ""){
			if(obj_item0s[i].value.split(" ")[0] > obj_item1.value.split(" ")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[0] > obj_item1.value.split(" ")[1].split(":")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[1] > obj_item1.value.split(" ")[1].split(":")[1]){
				obj_item0s[i].value = "";
				alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
			}
		}
	}
}
/*
* ���ܣ�����ʱ�������ڿ�ʼʱ��
* ���ã�"��Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#����ʱ��";
*/
function obj_item0_Finish(obj) {
	var obj_item1s = getTableFormObjs(label_item1);
	for(var i = 0; i < obj_item1s.length; i++){
		if(obj_item1s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item0 = getTableFormObj(label_item0,obj_item1s[i].rownumber);
		if(obj_item0.value != "" && obj_item1s[i].value != ""){
			if(obj_item0.value.split(" ")[0] > obj_item1s[i].value.split(" ")[0] || 
					obj_item0.value.split(" ")[1].split(":")[0] > obj_item1s[i].value.split(" ")[1].split(":")[0] || 
					obj_item0.value.split(" ")[1].split(":")[1] > obj_item1s[i].value.split(" ")[1].split(":")[1]){
				obj_item1s[i].value = "";
				alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
			}
		}
	}
}
/*
* ���ܣ�����ʱ�������ڿ�ʼʱ��
* ���ã�"��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#��ʼʱ��";
*/
function obj_R_item0_Start(obj) {
	var obj_item0s = getTableFormObjs(label_R_item0);
	
	for(var i = 0; i < obj_item0s.length; i++){
		if(obj_item0s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item1 = getTableFormObj(label_R_item1,obj_item0s[i].rownumber);
		if(obj_item0s[i].value != "" && obj_item1.value != ""){
			if(obj_item0s[i].value.split(" ")[0] > obj_item1.value.split(" ")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[0]>obj_item1.value.split(" ")[1].split(":")[0] || 
					obj_item0s[i].value.split(" ")[1].split(":")[1]>obj_item1.value.split(" ")[1].split(":")[1]){
				obj_item0s[i].value = "";
				alert("��ʼʱ��Ӧ�ڽ���ʱ��֮ǰ�����������룡");
			}
		}
	}
}

/*
* ���ܣ�����ʱ�������ڿ�ʼʱ��
* ���ã�"��Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#����ʱ�� ";
*/
function obj_R_item0_Finish(obj) {
	var obj_item1s = getTableFormObjs(label_R_item1);	
	for(var i = 0; i < obj_item1s.length; i++){
		if(obj_item1s[i].rownumber.indexOf("#") > -1){
			continue;
		}
		var obj_item0 = getTableFormObj(label_R_item0,obj_item1s[i].rownumber);
		if(obj_item0.value != "" && obj_item1s[i].value != ""){
			if(obj_item0.value.split(" ")[0] > obj_item1s[i].value.split(" ")[0] || 
					obj_item0.value.split(" ")[1].split(":")[0]>obj_item1s[i].value.split(" ")[1].split(":")[0] || 
					obj_item0.value.split(" ")[1].split(":")[1]>obj_item1s[i].value.split(" ")[1].split(":")[1]){
				obj_item1s[i].value = "";
				alert("����ʱ��Ӧ����ʼʱ��֮�����������룡");
			}
		}
	}
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���Ҫ��Ϣϵͳֹͣ�������#��Ԥ��ֹͣ����#Ӱ�췶Χ#Ӱ�췶Χ";
*/
function obj_item26(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_item25s = getTableFormObjs(label_item25);
	for(var i = 0; i< obj_item25s.length; i++){
		var obj_item26 = getTableFormObj(label_item26,obj_item25s[i].rownumber );
		if (obj_item25s[i].value == "ȫϽ") {
			// ֻ��
			// ���
			obj_item26.value="";
			obj_item26.onclick="";
		} else if (obj_item25s[i].value == "��֧����") {
			// ��ԭ
			obj_item26.onclick=function(){columnValueNumber(this);};
		}
	}

}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã���Ҫ��Ϣϵͳֹͣ�������#Ԥ��ֹͣ����#Ӱ�췶Χ#Ӱ�췶Χ";
*/
function obj_R_item26(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_R_item25s = getTableFormObjs(label_R_item25);
	for(var i = 0; i < obj_R_item25s.length; i++ ){
		var obj_R_item26 = getTableFormObj(label_R_item26,obj_R_item25s[i].rownumber);
		if (obj_R_item25s[i].value == "ȫϽ") {
			// ֻ��
			// ���
			obj_R_item26.value="";
			obj_R_item26.onclick="";
		} else if (obj_R_item25s[i].value == "��֧����") {
			// ��ԭ
			obj_R_item26.onclick=function(){columnValueNumber(this);};
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
/*
 *���ܣ���ѡ��ť�Ķ�д����
 */
function columnVallueRadio1(obj,access){
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
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								};
						}else{
							imgs[k].onclick = function(){
							columnVallueRadio(this);
							};
						}
					}
				}
			}
		}
	}
}
