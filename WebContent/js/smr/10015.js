/**T-B-16 ��Ϣ�Ƽ��������������������*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_YN01="��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#�Ƿ�����Ϣ�Ƽ����������֯�ṹ#�Ƿ�����Ϣ�Ƽ����������֯�ṹ";
var label_YN01_01= "��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#��Ϣ�Ƽ����������֯�����š��Ŷӣ�����#��Ϣ�Ƽ����������֯�����š��Ŷӣ�����";
var label_YN01_02="��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#��Ϣ�Ƽ����������֯��Ա���ԣ���ѡ��#��Ϣ�Ƽ����������֯��Ա���ԣ���ѡ��";

var label_item1_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��Ϣ�Ƽ������Ŀ����#��Ϣ�Ƽ������Ŀ����";
var label_item3_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#���У�������ʩ�������Ŀ#���У�������ʩ�������Ŀ";
var label_item5_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#ϵͳ�����������Ŀ#ϵͳ�����������Ŀ";
var label_item7_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��Ա�����������Ŀ#��Ա�����������Ŀ";
var label_item9_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��ѯ��������Ŀ#��ѯ��������Ŀ";

var label_item2_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��Ϣ�Ƽ������������#��Ϣ�Ƽ��������������";
var label_item4_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#���У�������ʩ�������Ŀ#���У�������ʩ�������Ŀ";
var label_item6_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#ϵͳ������#ϵͳ������";
var label_item8_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��Ա������#��Ա������";
var label_item10_GTZero = "��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Ŀ#����#��ѯ������#��ѯ������";

var label_item1_GTZero_2 = "��Ϣ�Ƽ��������#��������̹���#����#��Ϣ�Ƽ�����̵�����#��Ϣ�Ƽ�����̵�����";
var label_item3_GTZero_2 = "��Ϣ�Ƽ��������#��������̹���#����#����������۽���ϸ���������#����������۽���ϸ���������";
var label_item4_GTZero_2 = "��Ϣ�Ƽ��������#��������̹���#����#�������۵��������#�������۵��������";

var label_YN02="��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Χ#����#�Ƿ���ȷ��Ϣ�Ƽ������Χ#�Ƿ���ȷ��Ϣ�Ƽ������Χ"; 
var label_YN02_01="��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Χ#����#�漰��Ϣ�Ƽ�������������(��ѡ)#�漰��Ϣ�Ƽ�������������(��ѡ)";

var label_YN07="��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#�Ƿ�չ��Ϣ�Ƽ������������#�Ƿ�չ��Ϣ�Ƽ������������";
var label_YN07_01="��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#��Ϣ�Ƽ�������������׶�#��Ϣ�Ƽ�������������׶�";
var label_YN07_02="��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#��Ϣ�Ƽ������������ִ�в���#��Ϣ�Ƽ������������ִ�в���";

var label_YN05="��Ϣ�Ƽ��������#�����ͬ����#����#�Ƿ����������ͬ���辭����ز������#�Ƿ����������ͬ���辭����ز������";
var label_YN05_01="��Ϣ�Ƽ��������#�����ͬ����#����#��˲���#��˲���";

var label_YN06="��Ϣ�Ƽ��������#������������#����#������������1#���ݺ������Ҫ�����������ί���ⲿ��ƻ�������ʵʩ��ȫ���";
var label_YN06_01_GTZero="��Ϣ�Ƽ��������#������������#����#������������2#���Ƶ��";
var label_DecimalField3_GTZero="��Ϣ�Ƽ��������#��������̹���#����#�������ܷ���#�������ܷ���";
function initSet(){
	 setobj_YN01(getTableFormObj(label_YN01,"1_1_1_1" ));
	 setobj_YN02(getTableFormObj(label_YN02,"1_1_1_1" ));
	 setobj_YN07(getTableFormObj(label_YN07,"1_1_1_1" ));
	 setobj_YN05(getTableFormObj(label_YN05,"1_1_1_1" ));
	 setobj_YN06(getTableFormObj(label_YN06,"1_1_1_1" ));
	// setObj_YN06_01(getTableFormObj(label_YN06,"1_1_1_1" ));
}

/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#�Ƿ�����Ϣ�Ƽ����������֯�ṹ#�Ƿ�����Ϣ�Ƽ����������֯�ṹ";
"��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#��Ϣ�Ƽ����������֯�����š��Ŷӣ�����#��Ϣ�Ƽ����������֯�����š��Ŷӣ�����";
"��Ϣ�Ƽ��������������#��Ϣ�Ƽ����������֯�ṹ#����#��Ϣ�Ƽ����������֯��Ա���ԣ���ѡ��#��Ϣ�Ƽ����������֯��Ա���ԣ���ѡ��";
*/
function setobj_YN01(obj){
	var obj_YN01 = getTableFormObj(label_YN01,"1_1_1_1" );
	var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1_1_1" );
	var obj_YN01_02 = getTableFormCheckBox(label_YN01_02,"1_1_1_1" );
	if (obj_YN01.value == "��") {
		// ֻ��
		// ���
		obj_YN01_01.value = "";
		obj_YN01_01.readOnly = "readonly";
		disableTableCheckBox(obj_YN01_02,true);
	} else if (obj_YN01.value == "��") {
		// ��ԭ
		obj_YN01_01.value = "";
		obj_YN01_01.readOnly = "";
		disableTableCheckBox(obj_YN01_02,false);
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Χ#����#�Ƿ���ȷ��Ϣ�Ƽ������Χ#�Ƿ���ȷ��Ϣ�Ƽ������Χ"; 
*		"��Ϣ�Ƽ��������������#��Ϣ�Ƽ������Χ#����#�漰��Ϣ�Ƽ�������������(��ѡ)#�漰��Ϣ�Ƽ�������������(��ѡ)";
*/
function setobj_YN02(obj){
	var obj_YN02 = getTableFormObj(label_YN02,"1_1_1_1" );
	var obj_YN02_01 = getTableFormCheckBox(label_YN02_01,"1_1_1_1" );
	if (obj_YN02.value == "��") {
		// ֻ��
		// ���
		disableTableCheckBox(obj_YN02_01,true);
	} else if (obj_YN02.value == "��") {
		// ��ԭ
		disableTableCheckBox(obj_YN02_01,false);
	}
}



/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#�Ƿ�չ��Ϣ�Ƽ������������#�Ƿ�չ��Ϣ�Ƽ������������";
		"��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#��Ϣ�Ƽ�������������׶�#��Ϣ�Ƽ�������������׶�";
		"��Ϣ�Ƽ��������#��Ϣ�Ƽ������������#����#��Ϣ�Ƽ������������ִ�в���#��Ϣ�Ƽ������������ִ�в���";
*/
function setobj_YN07(obj){
	var obj_YN07 = getTableFormObj(label_YN07,"1_1_1_1" );
	var obj_YN07_01 = getTableFormCheckBox(label_YN07_01,"1_1_1_1" );
	var obj_YN07_02 = getTableFormObj(label_YN07_02,"1_1_1_1" );
	if (obj_YN07.value == "��") {
		// ֻ��
		// ���
		disableTableCheckBox(obj_YN07_01,true);
		columnVallueRadio1(obj_YN07_02,false);
	} else if (obj_YN07.value == "��") {
		// ��ԭ
		disableTableCheckBox(obj_YN07_01,false);
		columnVallueRadio1(obj_YN07_02,true);
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��Ϣ�Ƽ��������#�����ͬ����#����#�Ƿ����������ͬ���辭����ز������#�Ƿ����������ͬ���辭����ز������";
		"��Ϣ�Ƽ��������#�����ͬ����#����#��˲���#��˲���";
*/
function setobj_YN05(obj){
	var obj_YN05 = getTableFormObj(label_YN05,"1_1_1_1" );
	var obj_YN05_01 = getTableFormCheckBox(label_YN05_01,"1_1_1_1" );
	if (obj_YN05.value == "��") {
		// ֻ��
		// ���
		disableTableCheckBox(obj_YN05_01,true);
	} else if (obj_YN05.value == "��") {
		// ��ԭ
		disableTableCheckBox(obj_YN05_01,false);
	}
}


/*
* ���ܣ�����Ƿ��·����Ƿ����
* ���ã�"��Ϣ�Ƽ��������#������������#����#������������1#���ݺ������Ҫ�����������ί���ⲿ��ƻ�������ʵʩ��ȫ���";
		"��Ϣ�Ƽ��������#������������#����#������������2#���Ƶ��";
		"��Ϣ�Ƽ��������#��������̹���#����#�������ܷ���#�������ܷ���";
*/
function setobj_YN06(obj){
	var obj_item = getTableFormObj(label_YN06,"1_1_1_1" );
	var obj_YN06_01_GTZero = getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" );
	var obj_YN06 = getTableFormCheckBox(label_YN06,"1_1_1_1" );
	for(var i = 0; i < obj_YN06.length; i++){
		if (obj_YN06[i].value.trim() == "δҪ�������ί���ⲿ����ʵʩ���" && obj_YN06[i].checked == true) {
			// ֻ��
			disableTableCheckBox1(obj_YN06,true,"δҪ�������ί���ⲿ����ʵʩ���",true);
			obj_YN06_01_GTZero.value = "";
			obj_YN06_01_GTZero.onclick = "";
			obj_item.value = "δҪ�������ί���ⲿ����ʵʩ���";
			break;
		} 
		if(obj_YN06[i].value == "δҪ�������ί���ⲿ����ʵʩ���" && obj_YN06[i].checked == false){
			// ��ԭ
			disableTableCheckBox1(obj_YN06,false,"δҪ�������ί���ⲿ����ʵʩ���",true);
			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
			break;
		}
	}
	for(var i = 0; i < obj_YN06.length; i++){
		if(obj_YN06[i].value == "�������" && obj_YN06[i].checked == false){
			obj_YN06_01_GTZero.value = "";
			obj_YN06_01_GTZero.onclick = "";
			break;
		}
		if(obj_YN06[i].value == "�������" && obj_YN06[i].checked == true){
			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
			break;
		}
	}
}

///*
// *���ܣ������ݺ������Ҫ�����������ί���ⲿ��ƻ�������ʵʩ��ȫ��� ��ѡ��û��ѡ�񡰶�����ơ�ʱ������Ʋ�������
// *���ã� ��Ϣ�Ƽ��������#������������#����#������������2#������������2-2
// * */
//function setObj_YN06_01(obj){
//	var obj_YN06 = getTableFormCheckBox(label_YN06,"1_1_1_1" );
//	var obj_YN06_01_GTZero = getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" );
//	for(var i = 0; i < obj_YN06.length; i++){
//		if(obj_YN06[i].value == "�������" && obj_YN06[i].checked == true){
//			obj_YN06_01_GTZero.onclick = click_columnValueNumber;
//		//	break;
//		}else if(obj_YN06[i].value =="�������" && obj_YN06[i].checked == false){
//			obj_YN06_01_GTZero.value = "";
//			obj_YN06_01_GTZero.onclick = "";
//		}
//	}
//	
//}
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
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
function checkData(){
	//��մ�����ı���ɫ
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	checkNumFloat(getTableFormObjs("��Ϣ�Ƽ��������#��������̹���#����#����̷���ˮƽ�����#����̷���ˮƽ�����")[0],2);
	checkNumFloat(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ),2);
	checkNumFloat(getTableFormObjs("��Ϣ�Ƽ��������#��������̹���#����#�����Ա�쳣�˳���#�����Ա�쳣�˳���")[0],2);
	if(getTableFormObj(label_YN01,"1_1_1_1" ).value=="��"){
		var obj_YN01_01 = getTableFormObj(label_YN01_01,"1_1_1_1" );
		var obj_YN01_02 = getTableFormObj(label_YN01_02,"1_1_1_1" );
		if(obj_YN01_01.value.trim()==""){
			errorObjs.push(obj_YN01_01);
			a +="��Ϣ�Ƽ����������֯�����š��Ŷӣ����Ʋ���Ϊ��\n";
			isValid = false;
		}
		if(obj_YN01_02.value.trim()==""){
			errorObjs.push(obj_YN01_02.parentElement);
			a +="��Ϣ�Ƽ����������֯��Ա���ԣ���ѡ������Ϊ��\n";
			isValid = false;
		}
		
	}
	if(getTableFormObj(label_YN02,"1_1_1_1" ).value=="��"){
		var obj_YN02_01 = getTableFormObj(label_YN02_01,"1_1_1_1" );
		if(obj_YN02_01.value.trim()==""){
			errorObjs.push(obj_YN02_01.parentElement);
			a +="�漰��Ϣ�Ƽ�������������(��ѡ)����Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN07,"1_1_1_1" ).value=="��"){
		var obj_YN07_01 = getTableFormObj(label_YN07_01,"1_1_1_1" );
		var obj_YN07_02 = getTableFormObj(label_YN07_02,"1_1_1_1" );
		if(obj_YN07_01.value.trim()==""){
			errorObjs.push(obj_YN07_01.parentElement);
			a +="��Ϣ�Ƽ�������������׶β���Ϊ��\n";
			isValid = false;
		}
		if(obj_YN07_02.value.trim()==""){
			errorObjs.push(obj_YN07_02.parentElement);
			a +="��Ϣ�Ƽ������������ִ�в��Ų���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05,"1_1_1_1" ).value=="��"){
		var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1_1" );
		if(obj_YN05_01.value.trim()==""){
			errorObjs.push(obj_YN05_01.parentElement);
			a +="��˲��Ų���Ϊ��\n";
			isValid = false;
		}
	}
	if(getTableFormCheckBox(label_YN06,"1_1_1_1" ).value=="��"){
		var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj_YN05_01.parentElement);
			a +="��˲��Ų���Ϊ��\n";
			isValid = false;
		}
	}
	for(var i = 0; i < getTableFormCheckBox(label_YN06,"1_1_1_1" ).length; i++){
		if(getTableFormCheckBox(label_YN06,"1_1_1_1" )[i].value == "�������" && getTableFormCheckBox(label_YN06,"1_1_1_1" )[i].checked == true){
				if(getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" ).value.trim()==""){
					errorObjs.push(getTableFormObj(label_YN06_01_GTZero,"1_1_1_1" ));
					a +="������Ʋ���Ϊ��\n";
					isValid = false;
				}
		}
	}
	if(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ).value ==""){
		errorObjs.push(getTableFormObj(label_DecimalField3_GTZero,"1_1_1_1" ));
		a +="��������̹���-�������ܷ��ò���Ϊ��\n";
		isValid = false;
	}
	var obj_item2_GTZero = getTableFormObjs(label_item2_GTZero)[0];
	var obj_item4_GTZero = getTableFormObjs(label_item4_GTZero)[0];
	var obj_item6_GTZero = getTableFormObjs(label_item6_GTZero)[0];
	var obj_item8_GTZero = getTableFormObjs(label_item8_GTZero)[0];
	var obj_item10_GTZero = getTableFormObjs(label_item10_GTZero)[0];
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item4_GTZero.value)){
		errorObjs.push(obj_item2_GTZero);
		errorObjs.push(obj_item4_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��������>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ������ʩ�����\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item6_GTZero.value)){
		errorObjs.push(obj_item6_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��������>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀϵͳ���������\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item8_GTZero.value)){
		errorObjs.push(obj_item8_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��������>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��Ա���������\n";
	  	isValid=false;
	}
	if(parseInt(obj_item2_GTZero.value) < parseInt(obj_item10_GTZero.value)){
		errorObjs.push(obj_item10_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��������>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��ѯ���������\n";
	  	isValid=false;
	}
	
	var obj_item1_GTZero = getTableFormObjs(label_item1_GTZero)[0];
	var obj_item3_GTZero = getTableFormObjs(label_item3_GTZero)[0];
	var obj_item5_GTZero = getTableFormObjs(label_item5_GTZero)[0];
	var obj_item7_GTZero = getTableFormObjs(label_item7_GTZero)[0];
	var obj_item9_GTZero = getTableFormObjs(label_item9_GTZero)[0];
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item3_GTZero.value)){
		errorObjs.push(obj_item3_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ����>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��������Ŀ������\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item5_GTZero.value)){
		errorObjs.push(obj_item5_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ����>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀϵͳ��������Ŀ������\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item7_GTZero.value)){
		errorObjs.push(obj_item7_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ����>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��Ա��������Ŀ������\n";
	  	isValid=false;
	}
	if(parseInt(obj_item1_GTZero.value) < parseInt(obj_item9_GTZero.value)){
		errorObjs.push(obj_item9_GTZero);
	 	a+="��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ����>=��Ϣ�Ƽ�������������� | ��Ϣ�Ƽ������Ŀ��ѯ��������Ŀ������\n";
	  	isValid=false;
	}
	var obj_item1_GTZero_2 = getTableFormObjs(label_item1_GTZero_2)[0];
	var obj_item3_GTZero_2 = getTableFormObjs(label_item3_GTZero_2)[0];
	var obj_item4_GTZero_2 = getTableFormObjs(label_item4_GTZero_2)[0];
	if(parseInt(obj_item1_GTZero_2.value) < parseInt(obj_item3_GTZero_2.value)){
		errorObjs.push(obj_item3_GTZero_2);
	 	a+="��Ϣ�Ƽ�������� | ��������̹��� | ��Ϣ�Ƽ�����̵�����>=2����Ϣ�Ƽ�������� | ��������̹��� | ����������۽���ϸ�������������\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_item1_GTZero_2.value) < parseInt(obj_item4_GTZero_2.value)){
		errorObjs.push(obj_item4_GTZero_2);
	 	a+="��Ϣ�Ƽ�������� | ��������̹��� | ��Ϣ�Ƽ�����̵�����>=2����Ϣ�Ƽ�������� | ��������̹��� | �������۵������������\n";
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
*���ܣ�����ύʱ���еı���֤
*���ã��״̬�ġ��ύ����ť
*/
var click_columnValueNumber = function() {
	columnValueNumber(this);
};
/*
* ���ܣ��ı������������100ʱĬ��Ϊ100
*
*/
function sethundred(obj){
	checkNumNotNegative(obj);
	if(obj.value>100){
		obj.value=100;
	}
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
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
	}
}




