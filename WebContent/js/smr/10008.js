/*
 * ����T-B-9 ���簲ȫ���������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_item_RName = "�������簲ȫ�򻮷�#����#����";
var label_item8 = "�������簲ȫ�򻮷�#����#��;";
var label_item9 = "�������簲ȫ�򻮷�#����#�ɷ�����Щ���簲ȫ��";
var label_item10 = "�������簲ȫ�򻮷�#����#�ɱ���Щ���簲ȫ�����";
var label_item12 = "�������簲ȫ�򻮷�#����#�����ʩ";
var label_item13 = "�������簲ȫ�򻮷�#����#Զ�̽���";
var label_M_item14 = "�������簲ȫ�򻮷�#����#��ע";

var label_item22 = "����߽����#��3#����";
var label_item25 = "����߽����#��4#����";

var label_item_RName2 = "�������豸������#���";
var label_item30 = "�������豸������#��1#�豸�������";
var label_item31 = "�������豸������#��1#�ڴ��ֵ��%��";
var label_item32 = "�������豸������#��1#CPU��ֵ��%��";
var label_M_item33= "�������豸������#��1#��ע";

var label_item_RName3 = "��������·������#��1#�������ģ������Ļ���������";
var label_item46_GTZero = "��������·������#��1#��21#��·��(����";
var label_item47_GTZero = "��������·������#��1#��21#��ͬ��Ӫ�������ң�";
var label_item48 = "��������·������#��1#��21#����·����M��";
var label_item49 = "��������·������#��1#��21#����·����ʹ���ʷ�ֵ(%)";
var label_M_item50 = "��������·������#��1#��21#��ע";

var label_item_RName4 = "��������·������#��2#�������";
var label_item46_GTZero_2 = "��������·������#��2#��·��(����";
var label_item47_GTZero_2 = "��������·������#��2#��ͬ��Ӫ�������ң�";
var label_item48_2 = "��������·������#��2#����·����M��";
var label_item49_2 = "��������·������#��2#����·����ʹ���ʷ�ֵ(%)";
var label_M_item50_2 = "��������·������#��2#��ע";

var label_item68 = "����������#����";

var label_YN73 = "����������#����#����";
var label_YN73_01 = "����������#����#�����ϵ����ȴ���";

var label_YN86 = "���������豸����#��4#����#1";
var label_YN86_01 = "���������豸����#��4#����#�������";
var label_YN86_02 = "���������豸����#��4#����#����ʱ��";

var label_item1001_GTZero = "���簲ȫ�����ʩ#��2#����";

var label_YN88 = "�ڲ������ʻ�����#��1#�Ƿ�������ڲ��칫�����ʻ�����";
var label_YN88_01 = "�ڲ������ʻ�����#��1#�������ţ�";
var label_YN91 = "�ڲ������ʻ�����#��1#�������Ƽ�����";
var label_YN91_01 = "�ڲ������ʻ�����#��1#˵����";
/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	setYN73_01Disable(obj);
	setYN86Disable(obj);
	setItem22Disable(obj);
	setItem25Disable(obj);
	setItem68(obj);
}
/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã�����������#����#����
 */
function setYN73_01Disable(obj) {
	var obj_YN73 = getTableFormObjs(label_YN73)[0];
	var obj_YN73_01 = getTableFormObjs(label_YN73_01)[0];
	if (obj_YN73.value.trim() == "��") {
		// ֻ��
		obj_YN73_01.readOnly = "readonly";
		// ���
		obj_YN73_01.value = "";

	} else if (obj_YN73.value.trim() == "��") {
		// ��ԭ
		obj_YN73_01.readOnly = "";
	}
}

/*
 *���ܣ����ݸ�ѡ��ť�������桱�޸ı��Ƿ�ɶ�д
 *���ã����������豸����#��4#����#1
 */
function setYN86Disable(obj) {
	var obj_YN86 =getTableFormObjs(label_YN86)[0];
	var objs = getTableFormCheckBox(label_YN86,obj_YN86.rownumber);
	var obj_YN86_01 = getTableFormObjs(label_YN86_01)[0];
	var obj_YN86_02 = getTableFormObjs(label_YN86_02)[0];
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "������" && objs[i].checked == true) {
			// ֻ��
			disableTableCheckBox1(objs,true,"������",false);
			obj_YN86_01.onclick = "";
			obj_YN86_02.onclick = "";
			// ���
			obj_YN86_01.value = "";
			obj_YN86_02.value = "";
			obj_YN86.value = "������";
			break;
		} else if(objs[i].value == "������" && objs[i].checked == false){
			// ��ԭ
			disableTableCheckBox1(objs,false,"������",false);
			obj_YN86_01.onclick = click_columnValueNumber;
			obj_YN86_02.onclick = click_columnValueNumber;
			break;
		}
	}
}

/*
 *���ܣ����ݸ�ѡ��ť�����������б߽硱�޸ı�������ѡ���Ƿ��ѡ
 *���ã�����߽����#��3#����
 */
function setItem22Disable(obj) {
	var obj_item22 = getTableFormObjs(label_item22)[0];
	var objs = getTableFormCheckBox(label_item22,obj_item22.rownumber);
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "���������б߽�" && objs[i].checked == true) {
			// ֻ��
			disableTableCheckBox1(objs,true,"���������б߽�",true);
			obj_item22.value = "���������б߽�";
			break;
		} else if(objs[i].value == "���������б߽�" && objs[i].checked == false){
			// ��ԭ
			disableTableCheckBox1(objs,false,"���������б߽�",true);
			break;
		}
	}
}

/*
 *���ܣ����ݸ�ѡ��ť�����������б߽硱�޸ı�������ѡ���Ƿ��ѡ
 *���ã�����߽����#��4#����
 */
function setItem25Disable(obj) {
	var obj_item25 = getTableFormObjs(label_item25)[0];
	var objs = getTableFormCheckBox(label_item25,obj_item25.rownumber);
	for(var i = 0; i < objs.length; i++){
		if (objs[i].value.trim() == "�޻������߽�" && objs[i].checked == true) {
			// ֻ��
			disableTableCheckBox1(objs,true,"�޻������߽�",true);
			obj_item25.value = "�޻������߽�";
			break;
		} else if(objs[i].value == "�޻������߽�" && objs[i].checked == false){
			// ��ԭ
			disableTableCheckBox1(objs,false,"�޻������߽�",true);
			break;
		}
	}
}

/*
 *���ܣ��ָ����ּ�������
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
* ���ܣ���ѡ�� ������ ʱ������ѡ���ѡ
* ������objs Ϊ���и�ѡ����󼯺�
* 	  flag Ϊ���ò���ѡ��ʶ��trueʱ��str��ѡ���Ĳ���ѡ��false��֮
* 	  str  ��ѡֵ������ѡ���ѡ��
* 	  qita Ϊ�Ƿ��С�������ѡ����ı���
*/	  
function disableTableCheckBox1(objs,flag,str,qita){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(flag && objs[i].value != str){
				objs[i].disabled = flag;
				objs[i].checked = false;
				if(qita){
					//��ա�������������Ϊֻ��
					var showvalue = getShowTarget(objs[i].parentElement);
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}else if(!flag && objs[i].value != str ){
				objs[i].disabled = flag;
//				objs[i].checked = false;
			}
		}
	}
}

/*
 *���ܣ����������� ����������������������������߼����� �Ķ�ѡ���
 *���ã����������� #����
 */
function setItem68(obj) {
	var obj_item68 = getTableFormObjs(label_item68);
	var obj_item68checkbox = getTableFormCheckBox(label_item68,obj_item68[0].rownumber);
	var obj_item71checkbox = getTableFormCheckBox(label_item68,obj_item68[1].rownumber);
	for(var i = 0; i < obj_item68checkbox.length-1; i++ ){
		if(obj_item68checkbox[i].checked == true){
			obj_item71checkbox[i].checked = false;
			obj_item71checkbox[i].disabled = true;
		}else if(obj_item71checkbox[i].checked == true){
			obj_item68checkbox[i].checked = false;
			obj_item68checkbox[i].disabled = true;
		}else{
			obj_item71checkbox[i].disabled = false;
			obj_item68checkbox[i].disabled = false;
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
	
	var objs = getTableFormObjs(label_item_RName);
	for ( var i = 0; i < objs.length; i++) {
		// ����ģ��
		if ((objs[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull(objs[i]);
	}
	var objs2 = getTableFormObjs(label_item_RName2);
	for ( var i = 0; i < objs2.length; i++) {
		// ����ģ��
		if ((objs2[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull2(objs2[i]);
	}
	var objs3 = getTableFormObjs(label_item_RName3);
	for ( var i = 0; i < objs3.length; i++) {
		// ����ģ��
		if ((objs3[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull3(objs3[i]);
	}
	var objs4 = getTableFormObjs(label_item_RName4);
	for ( var i = 0; i < objs4.length; i++) {
		// ����ģ��
		if ((objs4[i].rownumber + "").indexOf("#") > -1) {
			continue;
		}
			checkTableItemNull4(objs4[i]);
	}
	var obj_item1001_GTZero = getTableFormObjs(label_item1001_GTZero);
	checkNumFloat(obj_item1001_GTZero[0],2);
	checkNumFloat(obj_item1001_GTZero[1],2);
	if(parseInt(obj_item1001_GTZero[0].value) > 100){
		errorObjs.push(obj_item1001_GTZero[0]);
		a += "���������װ������<100����\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1001_GTZero[1].value) > 100){
		errorObjs.push(obj_item1001_GTZero[1]);
		a += "���������������<100����\n";
	  	isValid=false;
	}
	var obj_YN73 = getTableFormObjs(label_YN73)[0];
	var obj_YN73_01 = getTableFormObjs(label_YN73_01)[0];
	if(obj_YN73.value == "��" && obj_YN73_01.value.trim() == ""){
		errorObjs.push(obj_YN73_01);
		a += "���������������ϵ����ȴ�����Ϊ��!\n";
		isValid=false;
	}
	var obj_YN86 = getTableFormObjs(label_YN86)[0];
	var obj_YN86_01 = getTableFormObjs(label_YN86_01)[0];
	var obj_YN86_02 = getTableFormObjs(label_YN86_02)[0];
	if(obj_YN86.value != "������" && obj_YN86_01.value.trim() == ""){
		errorObjs.push(obj_YN86_01);
		a += "��־���� ������ڲ���Ϊ��!\n";
		isValid=false;
	}
	if(obj_YN86.value != "������" && obj_YN86_02.value.trim() == ""){
		errorObjs.push(obj_YN86_02);
		a += "��־���� ����ʱ������Ϊ��!\n";
		isValid=false;
	}
	
	var obj_YN88 = getTableFormObjs(label_YN88)[0];
	var obj_YN88_01 = getTableFormObjs(label_YN88_01)[0];
	if(obj_YN88.value == "��" && obj_YN88_01.value.trim() == ""){
		errorObjs.push(obj_YN88_01);
		a += "�ڲ������ʻ��������������Ų���Ϊ��!\n";
		isValid=false;
	}
	
	var obj_YN91 = getTableFormObjs(label_YN91)[0];
	var obj_YN91_01 = getTableFormObjs(label_YN91_01)[0];
	if(obj_YN91.value == "��" && obj_YN91_01.value.trim() == ""){
		errorObjs.push(obj_YN91_01);
		a += "�ڲ������ʻ��������������Ƽ���˵������Ϊ��!\n";
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

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull(obj) {
	var obj_item8 = getTableFormObj(label_item8,obj.rownumber);
	var obj_item9 = getTableFormObj(label_item9,obj.rownumber);
	var obj_item10 = getTableFormObj(label_item10,obj.rownumber);
	var obj_item12 = getTableFormObj(label_item12, obj.rownumber);
	var obj_item13 = getTableFormObj(label_item13, obj.rownumber);
	var obj_M_item14 = getTableFormObj(label_M_item14, obj.rownumber);
	if (obj.value.trim() !="" && obj.value.trim() != "��"){
	
		if (replaceAll(obj_item8.value.trim()) == ""  ) {
			errorObjs.push(getEditDiv(obj_item8));
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ���;����Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item9.value.trim()) == "" ) {
			errorObjs.push(getEditDiv(obj_item9));
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��ɷ�����Щ���簲ȫ����Ϊ�գ�\n";
			isValid = false;
		}
		if (replaceAll(obj_item10.value.trim()) == "" ) {
			errorObjs.push(getEditDiv(obj_item10));
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ��ɱ���Щ���簲ȫ����ʲ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item12.value == "" ) {
			errorObjs.push(obj_item12.parentElement);
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ������ʩ����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item13.value.trim() == "") {
			errorObjs.push(obj_item13.parentElement);
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ�Ϊ���ޡ���գ�Զ�̽��벻��Ϊ�գ�\n";
			isValid = false;
		}
	}else{
		if(replaceAll(obj_item8.value.trim()) != "" || replaceAll(obj_item9.value.trim()) != "" || 
				replaceAll(obj_item10.value.trim()) != "" || obj_item12.value != "" || 
					obj_item13.value.trim() != "" || obj_M_item14.value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "�������簲ȫ�򻮷�"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ���Ϊ���ޡ���գ�\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull2(obj) {
	var obj_item30s = getTableFormObjs(label_item30);
	var obj_item30 = new Array();
	for(var i = 0; i < obj_item30s.length; i++){
		if(obj_item30s[i].rownumber == obj.rownumber + "_1" || 
				obj_item30s[i].rownumber == obj.rownumber + "_2" || 
					obj_item30s[i].rownumber == obj.rownumber + "_3"){
			obj_item30[obj_item30.length] = obj_item30s[i];
		}
	}
	var obj_item31s = getTableFormObjs(label_item31);
	var obj_item31 = new Array();
	for(var i = 0; i < obj_item31s.length; i++){
		if(obj_item31s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item31s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item31s[i].rownumber == obj.rownumber+ "_3"){
			obj_item31[obj_item31.length] = obj_item31s[i];
		}
	}
	var obj_item32s = getTableFormObjs(label_item32);
	var obj_item32 = new Array();
	for(var i = 0; i < obj_item32s.length; i++){
		if(obj_item32s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item32s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item32s[i].rownumber == obj.rownumber+ "_3"){
			obj_item32[obj_item32.length] = obj_item32s[i];
		}
	}
	var obj_M_item33s = getTableFormObjs(label_M_item33);
	var obj_M_item33 = new Array();
	for(var i = 0; i < obj_M_item33s.length; i++){
		if(obj_M_item33s[i].rownumber == obj.rownumber+ "_1" || 
				obj_M_item33s[i].rownumber == obj.rownumber+ "_2" || 
					obj_M_item33s[i].rownumber == obj.rownumber+ "_3"){
			obj_M_item33[obj_M_item33.length] = obj_M_item33s[i];
		}
	}
	
	if (obj.value.trim() !="" && obj.value.trim() != "��"){
	
		if (replaceAll(obj_item30[0].value.trim()) == "" ) {
			errorObjs.push(obj_item30[0].parentElement);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�����·���� �豸�����������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item31[0].value == "") {
			errorObjs.push(obj_item31[0]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�����·���� �ڴ��ֵ��%������Ϊ�գ�\n";
			isValid = false;
		}else{
			checkNumFloat(obj_item31[0],2);
		}
		if (obj_item32[0].value == "") {
			errorObjs.push(obj_item32[0]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�����·���� CPU��ֵ��%������Ϊ�գ�\n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[0],2);
		}
		if (replaceAll(obj_item30[1].value.trim()) == "") {
			errorObjs.push(obj_item30[1].parentElement);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ����Ľ����� �豸�����������Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_item31[1].value == "" ) {
			errorObjs.push(obj_item31[1]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ����Ľ����� �ڴ��ֵ��%������Ϊ�գ� \n";
			isValid = false;
			
		}else{
			checkNumFloat(obj_item31[1],2);
		}
		if (obj_item32[1].value == "") {
			errorObjs.push(obj_item32[1]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ����Ľ����� CPU��ֵ��%������Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[1],2);
		}
		if (replaceAll(obj_item30[2].value.trim()) == "" ) {
			errorObjs.push(obj_item30[2].parentElement);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ��������簲ȫ�豸 �豸�����������Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item31[2].value == "" ) {
			errorObjs.push(obj_item31[2]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ��������簲ȫ�豸 �ڴ��ֵ��%������Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item31[2],2);
		}
		if (obj_item32[2].value == "") {
			errorObjs.push(obj_item32[2]);
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ��������簲ȫ�豸 CPU��ֵ��%������Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item32[2],2);
		}
	}else{
		if(replaceAll(obj_item30[0].value.trim()) != "" && replaceAll(obj_item30[1].value.trim()) != "" && replaceAll(obj_item30[2].value.trim()) != "" && 
				obj_item31[0].value != "" && obj_item31[1].value != "" && obj_item31[2].value != "" && 
					obj_item32[0].value != "" && obj_item32[1].value != "" && obj_item32[2].value !="" && 
						obj_M_item33[0].value != "" && obj_M_item33[1].value != "" && obj_M_item33[2].value != ""){
			errorObjs.push(getEditDiv(obj));
			a += "�������豸�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"�����Ʋ���Ϊ���ޡ���գ�\n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull3(obj) {
	var obj_item46_GTZeros = getTableFormObjs(label_item46_GTZero);
	var obj_item46_GTZero = new Array();
	for(var i = 0; i < obj_item46_GTZeros.length; i++){
		if(obj_item46_GTZeros[i].rownumber == obj.rownumber + "_1" || 
				obj_item46_GTZeros[i].rownumber == obj.rownumber + "_2" || 
					obj_item46_GTZeros[i].rownumber == obj.rownumber + "_3"){
			obj_item46_GTZero[obj_item46_GTZero.length] = obj_item46_GTZeros[i];
		}
	}
	var obj_item47_GTZeros = getTableFormObjs(label_item47_GTZero);
	var obj_item47_GTZero = new Array();
	for(var i = 0; i < obj_item47_GTZeros.length; i++){
		if(obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_1" || 
				obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_2" || 
					obj_item47_GTZeros[i].rownumber == obj.rownumber+ "_3"){
			obj_item47_GTZero[obj_item47_GTZero.length] = obj_item47_GTZeros[i];
		}
	}
	var obj_item48s = getTableFormObjs(label_item48);
	var obj_item48 = new Array();
	for(var i = 0; i < obj_item48s.length; i++){
		if(obj_item48s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item48s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item48s[i].rownumber == obj.rownumber+ "_3"){
			obj_item48[obj_item48.length] = obj_item48s[i];
		}
	}
	var obj_item49s = getTableFormObjs(label_item49);
	var obj_item49 = new Array();
	for(var i = 0; i < obj_item49s.length; i++){
		if(obj_item49s[i].rownumber == obj.rownumber+ "_1" || 
				obj_item49s[i].rownumber == obj.rownumber+ "_2" || 
					obj_item49s[i].rownumber == obj.rownumber+ "_3"){
			obj_item49[obj_item49.length] = obj_item49s[i];
		}
	}
	var obj_M_item50s = getTableFormObjs(label_M_item50);
	var obj_M_item50 = new Array();
	for(var i = 0; i < obj_M_item50s.length; i++){
		if(obj_M_item50s[i].rownumber == obj.rownumber+ "_1" || 
				obj_M_item50s[i].rownumber == obj.rownumber+ "_2" || 
				obj_M_item50s[i].rownumber == obj.rownumber+ "_3"){
			obj_M_item50[obj_M_item50.length] = obj_M_item50s[i];
		}
	}
	if (obj.value.trim() !="" && obj.value.trim() != "��"){
	
		if (obj_item46_GTZero[0].value== "" ) {
			errorObjs.push(obj_item46_GTZero[0]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���һ����֧���� ��·��(��������Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item47_GTZero[0].value == "") {
			errorObjs.push(obj_item47_GTZero[0]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���һ����֧���� ��ͬ��Ӫ�������ң�����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item48[0].value == "") {
			errorObjs.push(obj_item48[0]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���һ����֧���� ����·����M)����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item49[0].value == "") {
			errorObjs.push(obj_item49[0]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���һ����֧���� ����·����ʹ���ʷ�ֵ(%)����Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[0],2);
		}
		if (obj_item46_GTZero[1].value == "") {
			errorObjs.push(obj_item46_GTZero[1]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���ͬ���ֱ����� ��·��(��������Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item47_GTZero[1].value == "" ) {
			errorObjs.push(obj_item47_GTZero[1]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���ͬ���ֱ����� ��ͬ��Ӫ�������ң�����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item48[1].value == "" ) {
			errorObjs.push(obj_item48[1]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���ͬ���ֱ����� ����·����M)����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item49[1].value == "") {
			errorObjs.push(obj_item49[1]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ���ͬ���ֱ����� ����·����ʹ���ʷ�ֵ(%)����Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[1],2);
		}
		if (obj_item46_GTZero[2].value == "") {
			errorObjs.push(obj_item46_GTZero[2]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�������ֱ����� ��·��(��������Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item47_GTZero[2].value == "") {
			errorObjs.push(obj_item47_GTZero[2]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�������ֱ����� ��ͬ��Ӫ�������ң�����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item48[2].value == "") {
			errorObjs.push(obj_item48[2]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�������ֱ����� ����·����M)����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item49[2].value == "" ) {
			errorObjs.push(obj_item49[2]);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���������ģ������Ļ��������Ʋ�Ϊ���ޡ���գ�������ֱ����� ����·����ʹ���ʷ�ֵ(%)����Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49[2],2);
		}
	}else{
		if(obj_item46_GTZero[0].value != "" || obj_item46_GTZero[1].value != "" || obj_item46_GTZero[2].value != "" || 
			obj_item47_GTZero[0].value != "" || obj_item47_GTZero[1].value != "" || obj_item47_GTZero[2].value != "" || 
			obj_item48[0].value != "" || obj_item48[1].value != "" || obj_item48[2].value !="" ||
			obj_item49[0].value != "" || obj_item49[1].value != "" || obj_item49[2].value != "" || 
			obj_M_item50[0].value != "" || obj_M_item50[1].value != "" || obj_M_item50[2].value != "" ){
			errorObjs.push(getEditDiv(obj));
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���Ʋ���Ϊ���ޡ���գ� \n";
			isValid = false;
		}
	}
}

/*
 * ���ܣ�������Ŀ�����жϸ����Ƿ�ȫ������ֵ
 */
function checkTableItemNull4(obj) {
	var obj_item46_GTZero_2 = getTableFormObj(label_item46_GTZero_2 , obj.rownumber);
	var obj_item47_GTZero_2 = getTableFormObj(label_item47_GTZero_2 , obj.rownumber);
	var obj_item48_2 = getTableFormObj(label_item48_2 , obj.rownumber);
	var obj_item49_2 = getTableFormObj(label_item49_2 , obj.rownumber);
	var obj_M_item50_2 = getTableFormObj(label_M_item50_2 , obj.rownumber);
	
	if (obj.value.trim() !="" && obj.value.trim() != "��"){

		if (obj_item46_GTZero_2.value== "" ) {
			errorObjs.push(obj_item46_GTZero_2);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���ֱ����ģ����ֱ����� �����Ʋ�Ϊ���ޡ���գ���·��(��������Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item47_GTZero_2.value == "" ) {
			errorObjs.push(obj_item47_GTZero_2);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���ֱ����ģ����ֱ����� �����Ʋ�Ϊ���ޡ���գ���ͬ��Ӫ�������ң�����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item48_2.value == "" ) {
			errorObjs.push(obj_item48_2);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���ֱ����ģ����ֱ����� �����Ʋ�Ϊ���ޡ���գ�����·����M)����Ϊ�գ� \n";
			isValid = false;
		}
		if (obj_item49_2.value == "") {
			errorObjs.push(obj_item49_2);
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���ֱ����ģ����ֱ����� �����Ʋ�Ϊ���ޡ���գ�����·����ʹ���ʷ�ֵ(%)����Ϊ�գ� \n";
			isValid = false;
		}else{
			checkNumFloat(obj_item49_2,2);
		}
	}else{
		if( obj_item46_GTZero_2.value != "" ||
				obj_item47_GTZero_2.value != "" && obj_item48_2.value != "" || 
					obj_item49_2.value != "" || obj_M_item50_2.value != "" ){
			errorObjs.push(getEditDiv(obj));
			a += "��������·�����ԣ����"+obj.rownumber.substring(obj.rownumber.lastIndexOf("_")+1,obj.rownumber.length)+"���Ʋ�Ϊ���ޡ���գ� \n";
			isValid = false;
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
* ���ܣ�����Ϊ��ʱ�� �����Ĳ���������
* ���ã��������簲ȫ�򻮷�#����#����
*/
/*function checkitem_RName(obj){
	var target = getTarget(obj);
	var obj_item8 = getTableFormObj(label_item8,target.rownumber);
	var obj_item8_area = getEditDiv(obj_item8);
	var obj_item9 = getTableFormObj(label_item9,target.rownumber);
	var obj_item9_area = getEditDiv(obj_item9);
	var obj_item10 = getTableFormObj(label_item10,target.rownumber);
	var obj_item10_area = getEditDiv(obj_item10);
	var obj_item12 = getTableFormCheckBox(label_item12, target.rownumber);
	var obj_item13 = getTableFormCheckBox(label_item13, target.rownumber);
	var obj_M_item14 = getTableFormObj(label_M_item14,target.rownumber);
	var obj_M_item14_area = getEditDiv(obj_M_item14);
//	alert(obj_item8_area.value);
	if(target.value == ""){
		//ֻ��
		obj_item8_area.contentEditable  = false;
		obj_item9_area.contentEditable  = false;
		obj_item10_area.contentEditable  = false;
		disableTableCheckBox(obj_item12,true);
		disableTableCheckBox(obj_item13,true);
		obj_M_item14_area.contentEditable = false;
		//���
		obj_item8_area.innerHTML = "";
		obj_item8.value = "";
		obj_item9_area.innerHTML = "";
		obj_item9.value = "";
		obj_item10_area.innerHTML = "";
		obj_item10.value = "";
		obj_item12.value = "";
		obj_item13.value = "";
		obj_M_item14_area.innerHTML = "";
		obj_M_item14.value = "";
	}else{
		//��д
		obj_item8_area.contentEditable  = true;
		obj_item9_area.contentEditable  = true;
		obj_item10_area.contentEditable  = true;
		disableTableCheckBox(obj_item12,false);
		disableTableCheckBox(obj_item13,false);
		obj_M_item14_area.contentEditable = true;
	}
}*/