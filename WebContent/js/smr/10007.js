/*
 * ����T-B-8 ��������ҵ��Ʒ�ֱ�_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_RadioButtonList_COL43 = "������������#�Ƿ񿪰�#����";
var label_HV_item6 = "������������#���ڷ���#����";
var label_HV_item8 = "������������#֧������ҵ��#��Ŀ";
var label_HV_item10 = "������������#���ҵ��#����";

var label_RadioButtonList_COL44 = "��ҵ��������#�Ƿ񿪰�#����";
var label_HV_item12 = "��ҵ��������#���ڷ���#����";
var label_HV_item14 = "��ҵ��������#֧������ҵ��#����";
var label_HV_item16 = "��ҵ��������#����ֱ��#����";
var label_HV_item18 = "��ҵ��������#���ҵ��#����";

var label_RadioButtonList_COL45 = "��������#�Ƿ񿪰�#����";
var label_HV_item20 = "��������#ҵ��Ʒ��#����";

var label_RadioButtonList_COL46 = "�绰����#�Ƿ񿪰�#����";
var label_HV_item22 = "�绰����#���ڷ���#����";
var label_HV_item24 = "�绰����#֧������ҵ��#����";
var label_HV_item26 = "�绰����#���ҵ��#����";

var label_RadioButtonList_COL47 = "�ֻ�����#��1#����";
var label_HV_item28 = "�ֻ�����#��2#����";
var label_HV_item30 = "�ֻ�����#��3#����";
var label_HV_item32 = "�ֻ�����#��4#����";

/*
* ���ܣ���ʼ��ҳ�����ñ�����
* ���ã��걨����
*/
function initSet(){
	var obj = 0;
	
	checkHV_item6(obj);
	checkHV_item8(obj);
	checkHV_item10(obj);
	checkRadio_COL43(obj);
	
	checkHV_item12(obj);
	checkHV_item14(obj);
	checkHV_item16(obj);
	checkHV_item18(obj);
	checkRadio_COL44(obj);
	
	checkHV_item20(obj);
	checkRadio_COL45(obj);
	
	checkHV_item22(obj);
	checkHV_item24(obj);
	checkHV_item26(obj);
	checkRadio_COL46(obj);
	
	checkHV_item28(obj);
	checkHV_item30(obj);
	checkHV_item32(obj);
	checkRadio_COL47(obj);
}

/*
* ���ܣ��Ƿ񿪰죬 ѡ����ʱ�� ͬ���ѡ����ѡ
* ���ã�������������#�Ƿ񿪰�#����
*/
function checkRadio_COL43(obj){
	var obj_RadioButtonList_COL43 = getTableFormObjs(label_RadioButtonList_COL43)[0];
	var obj_HV_item6 = getTableFormCheckBox(label_HV_item6, obj_RadioButtonList_COL43.rownumber);
	var obj_HV_item8 = getTableFormCheckBox(label_HV_item8, obj_RadioButtonList_COL43.rownumber);
	var obj_HV_item10 = getTableFormCheckBox(label_HV_item10, obj_RadioButtonList_COL43.rownumber);
	
	if(obj_RadioButtonList_COL43.value == "��"){
		disableTableCheckBox(obj_HV_item6,true);
		disableTableCheckBox(obj_HV_item8,true);
		disableTableCheckBox(obj_HV_item10,true);
	}else{
		disableTableCheckBoxs(obj_HV_item6,false);
		disableTableCheckBoxs(obj_HV_item8,false);
		disableTableCheckBoxs(obj_HV_item10,false);
	}
}

/*
* ���ܣ� ���ڷ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã�������������#���ڷ���#����
*/
function checkHV_item6(obj){
	var obj_item6 = getTableFormObjs(label_HV_item6)[0];
	var obj_HV_item6 = getTableFormCheckBox(label_HV_item6, obj_item6.rownumber);
	for(var i = 0; i < obj_HV_item6.length; i++){
		if(obj_HV_item6[i].value == "�޴������" && obj_HV_item6[i].checked == true){
			disableTableCheckBox1(obj_HV_item6 , true , "�޴������");
			obj_item6.value = "�޴������";
			break;
		}else if(obj_HV_item6[i].value == "�޴������" && obj_HV_item6[i].checked == false){
			disableTableCheckBox1(obj_HV_item6 , false , "�޴������");
//			obj_item6.value = "";
			break;
		}
	}
}

/*
* ���ܣ� ���ڷ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã�������������#֧������ҵ��#��Ŀ
*/
function checkHV_item8(obj){
	var obj_item8 = getTableFormObjs(label_HV_item8)[0];
	var obj_HV_item8 = getTableFormCheckBox(label_HV_item8 , obj_item8.rownumber);
	for(var i = 0; i < obj_HV_item8.length; i++){
		if(obj_HV_item8[i].value == "�޴���ҵ��" && obj_HV_item8[i].checked == true){
			disableTableCheckBox1(obj_HV_item8 , true , "�޴���ҵ��");
			obj_item8.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item8[i].value == "�޴���ҵ��" && obj_HV_item8[i].checked == false){
			disableTableCheckBox1(obj_HV_item8 , false , "�޴���ҵ��");
//			obj_item8.value = "";
			break;
		}
	}
}

/*
* ���ܣ� ���ڷ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã�������������#���ҵ��#����
*/
function checkHV_item10(obj){
	var obj_item10 = getTableFormObjs(label_HV_item10)[0];
	var obj_HV_item10 = getTableFormCheckBox(label_HV_item10 , obj_item10.rownumber);
	for(var i = 0; i < obj_HV_item10.length; i++){
		if(obj_HV_item10[i].value == "�޴���ҵ��" && obj_HV_item10[i].checked == true){
			disableTableCheckBox1(obj_HV_item10 , true , "�޴���ҵ��");
			obj_item10.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item10[i].value == "�޴���ҵ��" && obj_HV_item10[i].checked == false){
			disableTableCheckBox1(obj_HV_item10 , false , "�޴���ҵ��");
//			obj_item10.value = "";
			break;
		}
	}
}

/*
* ���ܣ��Ƿ񿪰죬 ѡ����ʱ�� ͬ���ѡ����ѡ
* ���ã���ҵ��������#�Ƿ񿪰�#����
*/
function checkRadio_COL44(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL44 = getTableFormObjs(label_RadioButtonList_COL44)[0];
	var obj_HV_item12 = getTableFormCheckBox(label_HV_item12, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item14 = getTableFormCheckBox(label_HV_item14, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item16 = getTableFormCheckBox(label_HV_item16, obj_RadioButtonList_COL44.rownumber);
	var obj_HV_item18 = getTableFormCheckBox(label_HV_item18, obj_RadioButtonList_COL44.rownumber);
	
	if(obj_RadioButtonList_COL44.value == "��"){
		disableTableCheckBox(obj_HV_item12 , true);
		disableTableCheckBox(obj_HV_item14 , true);
		disableTableCheckBox(obj_HV_item16 , true);
		disableTableCheckBox(obj_HV_item18 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item12 , false);
		disableTableCheckBoxs(obj_HV_item14 , false);
		disableTableCheckBoxs(obj_HV_item16 , false);
		disableTableCheckBoxs(obj_HV_item18 , false);
	}
}

/*
* ���ܣ� ���ڷ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���ҵ��������#���ڷ���#����
*/
function checkHV_item12(obj){
	var obj_item12 = getTableFormObjs(label_HV_item12)[0];
	var obj_HV_item12 = getTableFormCheckBox(label_HV_item12 , obj_item12.rownumber);
	for(var i = 0; i < obj_HV_item12.length; i++){
		if(obj_HV_item12[i].value == "�޴������" && obj_HV_item12[i].checked == true){
			disableTableCheckBox1(obj_HV_item12 , true , "�޴������");
			obj_item12.value = "�޴������";
			break;
		}else if(obj_HV_item12[i].value == "�޴������" && obj_HV_item12[i].checked == false){
			disableTableCheckBox1(obj_HV_item12 , false , "�޴������");
//			obj_item12.value = "";
			break;
		}
	}
}

/*
* ���ܣ� ֧������ҵ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���ҵ��������#֧������ҵ��#����
*/
function checkHV_item14(obj){
	var obj_item14 = getTableFormObjs(label_HV_item14)[0];
	var obj_HV_item14 = getTableFormCheckBox(label_HV_item14 , obj_item14.rownumber);
	for(var i = 0; i < obj_HV_item14.length; i++){
		if(obj_HV_item14[i].value == "�޴���ҵ��" && obj_HV_item14[i].checked == true){
			disableTableCheckBox1(obj_HV_item14 , true , "�޴���ҵ��");
			obj_item14.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item14[i].value == "�޴���ҵ��" && obj_HV_item14[i].checked == false){
			disableTableCheckBox1(obj_HV_item14 , false , "�޴���ҵ��");
//			obj_item14.value = "";
			break;
		}
	}
}

/*
* ���ܣ� ����ֱ����ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���ҵ��������#����ֱ��#����
*/
function checkHV_item16(obj){
	var obj_item16 = getTableFormObjs(label_HV_item16)[0];
	var obj_HV_item16 = getTableFormCheckBox(label_HV_item16 , obj_item16.rownumber);
	for(var i = 0; i < obj_HV_item16.length; i++){
		if(obj_HV_item16[i].value == "�޴������" && obj_HV_item16[i].checked == true){
			disableTableCheckBox1(obj_HV_item16 , true , "�޴������");
			obj_item16.value = "�޴������";
			break;
		}else if(obj_HV_item16[i].value == "�޴������" && obj_HV_item16[i].checked == false){
			disableTableCheckBox1(obj_HV_item16 , false , "�޴������");
//			obj_item16.value = "";
			break;
		}
	}
}

/*
* ���ܣ����ҵ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���ҵ��������#���ҵ��#����
*/
function checkHV_item18(obj){
	var obj_item18 = getTableFormObjs(label_HV_item18)[0];
	var obj_HV_item18 = getTableFormCheckBox(label_HV_item18 , obj_item18.rownumber);
	for(var i = 0; i < obj_HV_item18.length; i++){
		if(obj_HV_item18[i].value == "�޴���ҵ��" && obj_HV_item18[i].checked == true){
			disableTableCheckBox1(obj_HV_item18 , true , "�޴���ҵ��");
			obj_item18.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item18[i].value == "�޴���ҵ��" && obj_HV_item18[i].checked == false){
			disableTableCheckBox1(obj_HV_item18 , false , "�޴���ҵ��");
//			obj_item18.vlaue = "";
			break;
		}
	}
}

/*
* ���ܣ��Ƿ񿪰죬 ѡ����ʱ�� ͬ���ѡ����ѡ
* ���ã���������#�Ƿ񿪰�#����
*/
function checkRadio_COL45(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL45 = getTableFormObjs(label_RadioButtonList_COL45)[0];
	var obj_HV_item20 = getTableFormCheckBox(label_HV_item20, obj_RadioButtonList_COL45.rownumber);
	
	if(obj_RadioButtonList_COL45.value == "��"){
		disableTableCheckBox(obj_HV_item20 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item20 , false);
	}
}

/*
* ���ܣ�ҵ��Ʒ�� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���������#ҵ��Ʒ��#����
*/
function checkHV_item20(obj){
	//var target = getTarget(obj.parentElement);
	var obj_item20 = getTableFormObjs(label_HV_item20)[0];
	var obj_HV_item20 = getTableFormCheckBox(label_HV_item20 , obj_item20.rownumber);
	for(var i = 0; i < obj_HV_item20.length; i++){
		if(obj_HV_item20[i].value == "�޴���ҵ��" && obj_HV_item20[i].checked == true){
			disableTableCheckBox1(obj_HV_item20 , true , "�޴���ҵ��") ;
			obj_item20.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item20[i].value == "�޴���ҵ��" && obj_HV_item20[i].checked == false){
			disableTableCheckBox1(obj_HV_item20 , false , "�޴���ҵ��");
//			obj_item20.value = "";
			break;
		}
	}
}

/*
* ���ܣ��Ƿ񿪰죬 ѡ����ʱ�� ͬ���ѡ����ѡ
* ���ã��绰����#�Ƿ񿪰�#����
*/
function checkRadio_COL46(obj){
//	var target = getTarget(obj.parentElement);
	var obj_RadioButtonList_COL46 = getTableFormObjs(label_RadioButtonList_COL46)[0];
	var obj_HV_item22 = getTableFormCheckBox(label_HV_item22, obj_RadioButtonList_COL46.rownumber);
	var obj_HV_item24 = getTableFormCheckBox(label_HV_item24, obj_RadioButtonList_COL46.rownumber);
	var obj_HV_item26 = getTableFormCheckBox(label_HV_item26, obj_RadioButtonList_COL46.rownumber);
	
	if(obj_RadioButtonList_COL46.value == "��"){
		disableTableCheckBox(obj_HV_item22 , true);
		disableTableCheckBox(obj_HV_item24 , true);
		disableTableCheckBox(obj_HV_item26 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item22 , false);
		disableTableCheckBoxs(obj_HV_item24 , false);
		disableTableCheckBoxs(obj_HV_item26 , false);
	}
}

/*
* ���ܣ����ڷ��� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���������#���ڷ���#����
*/
function checkHV_item22(obj){
	var obj_item22 = getTableFormObjs(label_HV_item22)[0];
	var obj_HV_item22 = getTableFormCheckBox(label_HV_item22 , obj_item22.rownumber);
	for(var i = 0; i < obj_HV_item22.length; i++){
		if(obj_HV_item22[i].value == "�޴������" && obj_HV_item22[i].checked == true){
			disableTableCheckBox1(obj_HV_item22 , true , "�޴������");
			obj_item22.value = "�޴������";
			break;
		}else if(obj_HV_item22[i].value == "�޴������" && obj_HV_item22[i].checked == false){
			disableTableCheckBox1(obj_HV_item22 , false , "�޴������");
//			obj_item22.value = "";
			break;
		}
	}
}

/*
* ���ܣ�֧������ҵ�� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���������#֧������ҵ��#����
*/
function checkHV_item24(obj){
	var obj_item24 = getTableFormObjs(label_HV_item24)[0];
	var obj_HV_item24 = getTableFormCheckBox(label_HV_item24 , obj_item24.rownumber);
	for(var i = 0; i < obj_HV_item24.length; i++){
		if(obj_HV_item24[i].value == "�޴���ҵ��" && obj_HV_item24[i].checked == true){
			disableTableCheckBox1(obj_HV_item24 , true , "�޴���ҵ��");
			obj_item24.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item24[i].value == "�޴���ҵ��" && obj_HV_item24[i].checked == false){
			disableTableCheckBox1(obj_HV_item24 , false , "�޴���ҵ��");
//			obj_item24.value = "";
			break;
		}
	}
}

/*
* ���ܣ����ҵ�� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã���������#���ҵ��#����
*/
function checkHV_item26(obj){
	var obj_item26 = getTableFormObjs(label_HV_item26)[0];
	var obj_HV_item26 = getTableFormCheckBox(label_HV_item26 , obj_item26.rownumber);
	for(var i = 0; i < obj_HV_item26.length; i++){
		if(obj_HV_item26[i].value == "�޴���ҵ��" && obj_HV_item26[i].checked == true){
			disableTableCheckBox1(obj_HV_item26 , true , "�޴���ҵ��");
			obj_item26.value = "�޴���ҵ��";
		}else if(obj_HV_item26[i].value == "�޴���ҵ��" && obj_HV_item26[i].checked == false){
			disableTableCheckBox1(obj_HV_item26 , false , "�޴���ҵ��");
//			obj_item26.value = "";
		}
	}
}

/*
* ���ܣ��Ƿ񿪰죬 ѡ����ʱ�� ͬ���ѡ����ѡ
* ���ã��ֻ�����#��1#����
*/
function checkRadio_COL47(obj){
	var obj_RadioButtonList_COL47 = getTableFormObjs(label_RadioButtonList_COL47)[0];
	var obj_HV_item28 = getTableFormCheckBox(label_HV_item28, obj_RadioButtonList_COL47.rownumber);
	var obj_HV_item30 = getTableFormCheckBox(label_HV_item30, obj_RadioButtonList_COL47.rownumber);
	var obj_HV_item32 = getTableFormCheckBox(label_HV_item32, obj_RadioButtonList_COL47.rownumber);
	
	if(obj_RadioButtonList_COL47.value == "��"){
		disableTableCheckBox(obj_HV_item28 , true);
		disableTableCheckBox(obj_HV_item30 , true);
		disableTableCheckBox(obj_HV_item32 , true);
	}else{
		disableTableCheckBoxs(obj_HV_item28 , false);
		disableTableCheckBoxs(obj_HV_item30 , false);
		disableTableCheckBoxs(obj_HV_item32 , false);
	}
}
/*
* ���ܣ����ڷ��� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã��ֻ�����#��2#����
*/
function checkHV_item28(obj){
	var obj_item28 = getTableFormObjs(label_HV_item28)[0];
	var obj_HV_item28 = getTableFormCheckBox(label_HV_item28 , obj_item28.rownumber);
	for(var i = 0; i < obj_HV_item28.length; i++){
		if(obj_HV_item28[i].value == "�޴������" && obj_HV_item28[i].checked == true){
			disableTableCheckBox1(obj_HV_item28 , true , "�޴������");
			obj_item28.value = "�޴������";
			break;
		}else if(obj_HV_item28[i].value == "�޴������" && obj_HV_item28[i].checked == false){
			disableTableCheckBox1(obj_HV_item28 , false , "�޴������");
//			obj_item28.value = "";
			break;
		}
	}
}

/*
* ���ܣ�֧������ҵ�� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã��ֻ�����#��3#����
*/
function checkHV_item30(obj){
	var obj_item30 = getTableFormObjs(label_HV_item30)[0];
	var obj_HV_item30 = getTableFormCheckBox(label_HV_item30 , obj_item30.rownumber);
	for(var i = 0; i < obj_HV_item30.length; i++){
		if(obj_HV_item30[i].value == "�޴���ҵ��" && obj_HV_item30[i].checked == true){
			disableTableCheckBox1(obj_HV_item30 , true , "�޴���ҵ��");
			obj_item30.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item30[i].value == "�޴���ҵ��" && obj_HV_item30[i].checked == false){
			disableTableCheckBox1(obj_HV_item30 , false , "�޴���ҵ��");
//			obj_item30.value = "";
			break;
		}
	}
}

/*
* ���ܣ����ҵ�� ��ѡ�� �޴������ ʱ������ѡ���ѡ
* ���ã��ֻ�����#��4#����
*/
function checkHV_item32(obj){
	var obj_item32 = getTableFormObjs(label_HV_item32)[0];
	var obj_HV_item32 = getTableFormCheckBox(label_HV_item32 , obj_item32.rownumber);
	for(var i = 0; i < obj_HV_item32.length; i++){
		if(obj_HV_item32[i].value == "�޴���ҵ��" && obj_HV_item32[i].checked == true){
			disableTableCheckBox1(obj_HV_item32 , true , "�޴���ҵ��");
			obj_item32.value = "�޴���ҵ��";
			break;
		}else if(obj_HV_item32[i].value == "�޴���ҵ��" && obj_HV_item32[i].checked == false){
			disableTableCheckBox1(obj_HV_item32 , false , "�޴���ҵ��");
//			obj_item32.value = "";
			break;
		}
	}
}

/*
* ���ܣ���ѡ�� �޴������ ʱ������ѡ���ѡ
* ������objs Ϊ���и�ѡ����󼯺�
* 	  flag Ϊ���ò���ѡ��ʶ��trueʱ��str��ѡ���Ĳ���ѡ��false��֮
* 	  str  ��ѡֵ������ѡ���ѡ��
*/
function disableTableCheckBox1(objs,flag,str){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(flag && objs[i].value != str){
				objs[i].disabled = flag;
				objs[i].checked = false;
				//��ա�������������Ϊֻ��
				var showvalue = getShowTarget(objs[i].parentElement);
				showvalue.value = "";
				showvalue.style.display="none";
			}else if(!flag && objs[i].value != str ){
				objs[i].disabled = flag;
//				objs[i].checked = false;
			}
		}
	}
}

/*
* ���ܣ���ѡ�� �Ƿ񿪰� ʱ������ѡ���ѡ/��ѡ
*/
function disableTableCheckBoxs(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
				getTarget(objs[i].parentElement).value = "";
			}
		}
		//���ѡ���� �޴������ ������ѡ����Ȼ����ѡ
		if(objs[0].checked == true){
			disableTableCheckBox1(objs,true,objs[0].value);
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
	
	var obj_RadioButtonList_COL43 = getTableFormObjs(label_RadioButtonList_COL43)[0];
	var obj_RadioButtonList_COL44 = getTableFormObjs(label_RadioButtonList_COL44)[0];
	var obj_RadioButtonList_COL45 = getTableFormObjs(label_RadioButtonList_COL45)[0];
	var obj_RadioButtonList_COL46 = getTableFormObjs(label_RadioButtonList_COL46)[0];
	var obj_RadioButtonList_COL47 = getTableFormObjs(label_RadioButtonList_COL47)[0];
	if(obj_RadioButtonList_COL43.value == "��"){
		var obj_HV_item6 = getTableFormObj(label_HV_item6, obj_RadioButtonList_COL43.rownumber);
		var obj_HV_item8 = getTableFormObj(label_HV_item8, obj_RadioButtonList_COL43.rownumber);
		var obj_HV_item10 = getTableFormObj(label_HV_item10, obj_RadioButtonList_COL43.rownumber);
		if(obj_HV_item6.value == ""){
			errorObjs.push(obj_HV_item6.parentElement);
			a+="�����������У����ڷ�����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item8.value == ""){
			errorObjs.push(obj_HV_item8.parentElement);
			a+="�����������У�֧������ҵ����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item10.value == ""){
			errorObjs.push(obj_HV_item10.parentElement);
			a+="�����������У����ҵ����Ϊ�գ�\n";
			isValid=false;
		}
	}
	if(obj_RadioButtonList_COL44.value == "��"){
		var obj_HV_item12 = getTableFormObj(label_HV_item12, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item14 = getTableFormObj(label_HV_item14, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item16 = getTableFormObj(label_HV_item16, obj_RadioButtonList_COL44.rownumber);
		var obj_HV_item18 = getTableFormObj(label_HV_item18, obj_RadioButtonList_COL44.rownumber);
		if(obj_HV_item12.value == ""){
			errorObjs.push(obj_HV_item12.parentElement);
			a+="��ҵ�������У����ڷ�����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item14.value == ""){
			errorObjs.push(obj_HV_item14.parentElement);
			a+="��ҵ�������У�֧������ҵ����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item16.value == ""){
			errorObjs.push(obj_HV_item16.parentElement);
			a+="��ҵ�������У�����ֱ������Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item18.value == ""){
			errorObjs.push(obj_HV_item18.parentElement);
			a+="��ҵ�������У����ҵ����Ϊ�գ�\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL45.value == "��"){
		var obj_HV_item20 = getTableFormObj(label_HV_item20, obj_RadioButtonList_COL45.rownumber);
		if(obj_HV_item20.value == ""){
			errorObjs.push(obj_HV_item20.parentElement);
			a+="�������У�ҵ��Ʒ�ֲ���Ϊ�գ�\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL46.value == "��"){
		var obj_HV_item22 = getTableFormObj(label_HV_item22, obj_RadioButtonList_COL46.rownumber);
		var obj_HV_item24 = getTableFormObj(label_HV_item24, obj_RadioButtonList_COL46.rownumber);
		var obj_HV_item26 = getTableFormObj(label_HV_item26, obj_RadioButtonList_COL46.rownumber);
		if(obj_HV_item22.value == ""){
			errorObjs.push(obj_HV_item22.parentElement);
			a+="�绰���У����ڷ�����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item24.value == ""){
			errorObjs.push(obj_HV_item24.parentElement);
			a+="�绰���У�֧������ҵ����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item26.value == ""){
			errorObjs.push(obj_HV_item26.parentElement);
			a+="�绰���У����ҵ����Ϊ�գ�\n";
			isValid=false;
		}
	}
	
	if(obj_RadioButtonList_COL47.value == "��"){
		var obj_HV_item28 = getTableFormObj(label_HV_item28, obj_RadioButtonList_COL47.rownumber);
		var obj_HV_item30 = getTableFormObj(label_HV_item30, obj_RadioButtonList_COL47.rownumber);
		var obj_HV_item32 = getTableFormObj(label_HV_item32, obj_RadioButtonList_COL47.rownumber);
		if(obj_HV_item28.value == ""){
			errorObjs.push(obj_HV_item28.parentElement);
			a+="�ֻ����У����ڷ�����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item30.value == ""){
			errorObjs.push(obj_HV_item30.parentElement);
			a+="�ֻ����У�֧������ҵ����Ϊ�գ�\n";
			isValid=false;
		}
		if(obj_HV_item32.value == ""){
			errorObjs.push(obj_HV_item32.parentElement);
			a+="�ֻ����У����ҵ����Ϊ�գ�\n";
			isValid=false;
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