/*
 * ����T-B-11 ��Ϣ�Ƽ�Ӧ�����������_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_EG_YN_Item1 = "Ӧ����֯#��ϸ��Ŀ#������Ҫ��Ϣϵͳ�ش�ͻ���¼�Ӧ����֯#����#��ѡ";
var label_R_item1 = "Ӧ����֯#��ϸ��Ŀ#������Ҫ��Ϣϵͳ�ش�ͻ���¼�Ӧ����֯#����#��֯����";

var label_EG_YN_Item2 = "Ӧ����֯#��ϸ��Ŀ#һ����֧����Ӧ��������֯������������ʽ#����#�������";
var label_R_item2 = "Ӧ����֯#��ϸ��Ŀ#һ����֧����Ӧ��������֯������������ʽ#����#������ʽ";

var label_item1_GTZero = "��Ϣ�Ƽ�ͻ���¼�#������#1#����";
var label_item1_GTZero_2 = "Ӧ��Ԥ����Ӧ������#������#1#����";

/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	setEG_YN_Item1Disable(obj);
	setEG_YN_Item2Disable(obj);
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã�Ӧ����֯#��ϸ��Ŀ#������Ҫ��Ϣϵͳ�ش�ͻ���¼�Ӧ����֯#����#��ѡ
 */
function setEG_YN_Item1Disable(obj) {
	var obj_item1 = getTableFormObjs(label_EG_YN_Item1)[0];
	var obj_R_item1 = getTableFormObjs(label_R_item1)[0];
	if (obj_item1.value.trim() == "��") {
		// ֻ��
		obj_R_item1.readOnly = "readonly";
		// ���
		obj_R_item1.value = "";

	} else if (obj_item1.value.trim() == "��") {
		// ��ԭ
		obj_R_item1.readOnly = "";
	}
}

/*
 *���ܣ����ݵ�ѡ��ť�޸ı��Ƿ�ɶ�д
 *���ã�Ӧ����֯#��ϸ��Ŀ#һ����֧����Ӧ��������֯������������ʽ#����#�������
 */
function setEG_YN_Item2Disable(obj) {
	var obj_item2 = getTableFormObjs(label_EG_YN_Item2)[0];
	var obj_R_item2 = getTableFormObjs(label_R_item2)[0];
	if (obj_item2.value.trim() == "δ����") {
		// ֻ��
		obj_R_item2.readOnly = "readonly";
		// ���
		obj_R_item2.value = "";

	} else if (obj_item2.value.trim() == "������") {
		// ��ԭ
		obj_R_item2.readOnly = "";
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
	
	var obj_EG_YN_Item1 = getTableFormObjs(label_EG_YN_Item1)[0];
	var obj_R_item1 = getTableFormObjs(label_R_item1)[0];
	if(obj_EG_YN_Item1.value == "��" && obj_R_item1.value.trim() == ""){
		errorObjs.push(obj_R_item1);
	 	a+="Ӧ����֯-��֯���ƣ�����Ϊ�գ�\n";
	  	isValid=false;
	}
	
	var obj_EG_YN_Item2 = getTableFormObjs(label_EG_YN_Item2)[0];
	var obj_R_item2 = getTableFormObjs(label_R_item2)[0];
	if(obj_EG_YN_Item2.value == "������" && obj_R_item2.value.trim() == ""){
		errorObjs.push(obj_R_item2);
	 	a+="Ӧ����֯-������ʽ����Ϊ�գ�\n";
	  	isValid=false;
	}
	
	var obj_item1_GTZero = getTableFormObjs(label_item1_GTZero);
	if(parseInt(obj_item1_GTZero[0].value) > parseInt(obj_item1_GTZero[1].value )+ parseInt(obj_item1_GTZero[2].value) + 
			parseInt(obj_item1_GTZero[3].value) + parseInt(obj_item1_GTZero[4].value) ||
				parseInt(obj_item1_GTZero[0].value) < parseInt(obj_item1_GTZero[1].value) + parseInt(obj_item1_GTZero[2].value) +
						parseInt(obj_item1_GTZero[3].value) + parseInt(obj_item1_GTZero[4].value) ){
		errorObjs.push(obj_item1_GTZero[0]);
		 a+="��Ϣ�Ƽ�ͻ���¼�-��Ϣ�Ƽ�ͻ���¼�����=I��+II��+III��+III�����³���\n";
		 isValid=false;
	}
	

	
	var obj_item1_GTZero_2 = getTableFormObjs(label_item1_GTZero_2);
	if(parseInt(obj_item1_GTZero_2[0].value) > parseInt(obj_item1_GTZero_2[1].value) + 
			parseInt(obj_item1_GTZero_2[2].value) + parseInt(obj_item1_GTZero_2[3].value) ||
				parseInt(obj_item1_GTZero_2[0].value) < parseInt(obj_item1_GTZero_2[1].value) +
						parseInt(obj_item1_GTZero_2[2].value) + parseInt(obj_item1_GTZero_2[3].value) ){
		errorObjs.push(obj_item1_GTZero_2[0]);
		 a+="Ӧ��Ԥ����Ӧ������-����Ӧ����������=ģ������+�л�����+��������\n";
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