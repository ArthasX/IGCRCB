/*
 * ����2014- T-B-8 ��Ϣ�Ƽ�����ά�����������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

//�������
var label_YN01_03 = "�������#����#����ͨ����ά������ϵ��֤";
var label_YN01_04 = "�������#����#���ǣ�ͨ����֤ʱ��";
var label_YN01_05 = "�������#����#��֤����";
var label_YN01_06 = "�������#����#��֤����";
var label_YN01_07 = "�������#����#ͨ����֤�Ĳ��ţ���֯������";
//��ع���
var label_YN02_01 = "��ع���#����#�Զ������߼�ط�Χ";
//�������
var label_YN03_01 = "�������#����#�������Χ";
var label_YN03_02 = "�������#����#�Ա�����зּ�����";
var label_YN03_03 = "�������#����#���ǣ���Ϊ";
var label_YN03_05 = "�������#����#���������ͳһ�������";
var label_YN03_06 = "�������#����#���������֯���Ŷӣ�����";
var label_YN03_08 = "�������#����#���Ź̶��ı�����ǽ��������ִ�д���";
var label_YN03_09 = "�������#����#����ʱ��";
var label_YN03_11 = "�������#����#���б�������м�¼";
var label_YN03_12 = "�������#����#������ʽ";
//�¼�����
var label_YN04_01 = "�¼�����#����#�¼�����Χ";
//�������
var label_YN05_01 = "�������#����#�������Χ";
//��������
var label_YN06_03 = "��������#����#������������Ķ�����������"; 
var label_YN06_04 = "��������#����#��������"; 
//�ڲ�����ˮƽ����
var label_YN08_01 = "�ڲ�����ˮƽ����#����#�ڻ����ڲ�ǩ������ˮƽЭ����ƶ�����ˮƽ����ָ��"; 
var label_YN08_02 = "�ڲ�����ˮƽ����#����#���ǣ����ڼ�顢ͨ��ִ�����"; 
var label_YN08_03 = "�ڲ�����ˮƽ����#����#Ƶ��"; 
/*
 * ���ܣ��ύУ��
 */
function checkData(){
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//�������У��
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_03.rownumber);
	var obj_YN01_05 = getTableFormObj(label_YN01_05,obj_YN01_03.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_03.rownumber);
	var obj_YN01_07 = getTableFormObj(label_YN01_07,obj_YN01_03.rownumber);
	if(obj_YN01_03.value == "��"){
		if(obj_YN01_04.value == ""){
			isValid = false;
			a += "1.���ǣ�ͨ����֤ʱ��:����Ϊ��!\n";
			errorObjs.push(obj_YN01_04);
		}
		if(obj_YN01_05.value == ""){
			isValid = false;
			a += "1.��֤���ƣ�����Ϊ��!\n";
			errorObjs.push(obj_YN01_05);
		}
		if(obj_YN01_06.value == ""){
			isValid = false;
			a += "1.��֤����������Ϊ��!\n";
			errorObjs.push(obj_YN01_06);
		}
		if(obj_YN01_07.value == ""){
			isValid = false;
			a += "1.ͨ����֤�Ĳ��ţ���֯�����ƣ�����Ϊ��!\n";
			errorObjs.push(obj_YN01_07);
		}
	}
	//��ع���У��
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	if(obj_YN02_01.value == ""){
		errorObjs.push(obj_YN02_01);
		a+="��ѡ�� �Զ������߼�ط�Χ ����Ϊ�գ�\n";
		isValid=false;
	}
	//�������У��
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	if(obj_YN03_01.value == ""){
		errorObjs.push(obj_YN03_01);
		a+="��ѡ�� 3.�������Χ ����Ϊ�գ�\n";
		isValid=false;
	}
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber);
	if(obj_YN03_02.value == "��" && obj_YN03_03.value == ""){
		isValid = false;
		a += "3.���ǣ���Ϊ��������Ϊ��!\n";
		errorObjs.push(obj_YN01_04);
	}
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03_05.rownumber);
	if(obj_YN03_05.value == "��" && obj_YN03_06.value == ""){
		isValid = false;
		a += "3.���������֯���Ŷӣ����Ʋ���Ϊ��!\n";
		errorObjs.push(obj_YN03_06);
	}
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "��" && obj_YN03_09.value == ""){
		isValid = false;
		a += "3.���������ʱ�䲻��Ϊ��!\n";
		errorObjs.push(obj_YN03_09);
	}
	var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];
	var obj_YN03_12 = getTableFormObjs(label_YN03_12)[0];
	if(obj_YN03_11.value == "��" && obj_YN03_12.value == ""){
		isValid = false;
		a += "3.�����������ʽ����Ϊ��!\n";
		errorObjs.push(obj_YN03_12);
	}
	//�¼�����
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	if(obj_YN04_01.value == ""){
		errorObjs.push(obj_YN04_01);
		a+="��ѡ�� �¼�����Χ ����Ϊ�գ�\n";
		isValid=false;
	}
	//�������
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	if(obj_YN05_01.value == ""){
		errorObjs.push(obj_YN05_01);
		a+="��ѡ�� �������Χ ����Ϊ�գ�\n";
		isValid=false;
	}
	//��������
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "��" && obj_YN06_04.value == ""){
		isValid = false;
		a += "6.�������ڲ���Ϊ��!\n";
		errorObjs.push(obj_YN06_04);
	}

	//�ڲ�����ˮƽ����
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08_01.rownumber);
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_01.rownumber);
	if(obj_YN08_01.value == "��"){
		if(obj_YN08_02.value == ""){
			isValid = false;
			a += "8.���ǣ����ڼ�顢ͨ��ִ���������Ϊ��!\n";
			errorObjs.push(obj_YN08_02);
		}
		if(obj_YN08_02.value == "��" && obj_YN08_03.value == ""){
			isValid = false;
			a += "8.Ƶ�ʲ���Ϊ��!\n";
			errorObjs.push(obj_YN08_03);
		}
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
	return isValid;
}
/*
 * ���ܣ�ͨ��������������Ķ����������ƾ�����������ֻ���Ϳ���
 * ���ã���������#����#������������Ķ�����������
 */
function setYN08_02_03Disable(obj){
	//label_YN08_01 = "�ڲ�����ˮƽ����#����#�ڻ����ڲ�ǩ������ˮƽЭ����ƶ�����ˮƽ����ָ��"
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	if(obj_YN08_01){
		//label_YN08_02 = "�ڲ�����ˮƽ����#����#���ǣ����ڼ�顢ͨ��ִ�����"
		var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08_01.rownumber);
		//label_YN08_03 = "�ڲ�����ˮƽ����#����#Ƶ��"
		var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_01.rownumber);
		if(obj_YN08_01.value == "��" || obj_YN08_01.value == ""){
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("disabled",true);
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("disabled",true);
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("src","images/rb01.gif");
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("src","images/rb01.gif");
			obj_YN08_03.readOnly = "readonly";
			obj_YN08_02.value ="";
			obj_YN08_03.value ="";
		}else if(obj_YN08_01.value == "��"){
			jQuery(obj_YN08_02.previousSibling.firstChild).attr("disabled",false);
			jQuery(obj_YN08_02.previousSibling.previousSibling.firstChild).attr("disabled",false);

		}
	}
	
}
var setDisable = function(){
	setYN08_03Disable (this);
};

function setYN08_03Disable (){
	var obj_YN08_02 = getTableFormObjs(label_YN08_02)[0];
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08_02.rownumber);
	if(obj_YN08_02.value == "��"){
		obj_YN08_03.readOnly = "";
	}else{
		obj_YN08_03.readOnly = "readonly";
		obj_YN08_03.value ="";
	}
}
/*
 * ���ܣ�ͨ��������������Ķ����������ƾ�����������ֻ���Ϳ���
 * ���ã���������#����#������������Ķ�����������
 */
function setYN06_04Disable(obj){
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if(obj_YN06_03){
		var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
		if(obj_YN06_03.value == "��" || obj_YN06_03.value == ""){
			obj_YN06_04.readOnly = "readonly";
			obj_YN06_04.value ="";
		}else if(obj_YN06_03.value == "��"){
			obj_YN06_04.readOnly = "";
		}
	}
	
}

/*
 * ���ܣ�ͨ�����б�������м�¼����������ʽֻ���Ϳ���
 * ���ã��������#����#���б�������м�¼
 */
function setYN03_12Disable(obj){
	var obj_YN03_11 = getTableFormObjs(label_YN03_11)[0];
	if(obj_YN03_11){
		var obj_YN03_12 = getTableFormCheckBox(label_YN03_12, "1_1");
		if(obj_YN03_11.value == "��" || obj_YN03_11.value == ""){
			// ���
			obj_YN03_12.onclick = "";
			// ֻ��
			disableTableCheckBox(obj_YN03_12, true);
		}else if(obj_YN03_11.value == "��"){
			disableTableCheckBox(obj_YN03_12, false);
		}
	}
	
	
}

/*
 * ���ܣ�ͨ�����Ź̶��ı�����ǽ��������ִ�д��ھ�������ʱ��ֻ���Ϳ���
 * ���ã��������#����#���Ź̶��ı�����ǽ��������ִ�д���
 */
function setYN03_09Disable(obj){
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	if(obj_YN03_08){
		var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
		if(obj_YN03_08.value == "��" || obj_YN03_08.value == ""){
			obj_YN03_09.onclick = "";
			obj_YN03_09.value ="";
		}else if(obj_YN03_08.value == "��"){
			obj_YN03_09.onclick = click_columnshowDate;
		}
	}
	
	
}
/*
 * ���ܣ�ͨ���Ա�����зּ��������ͨ�����ǣ���Ϊֻ���Ϳ���
 * ���ã��������#����#�Ա�����зּ�����
 */
function setYN03_06Disable(obj){
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	if(obj_YN03_06){
		var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03_05.rownumber);
		if(obj_YN03_05.value == "��" || obj_YN03_05.value == ""){
			obj_YN03_06.readOnly = "readonly";
			obj_YN03_06.value ="";
		}else if(obj_YN03_05.value == "��"){
			obj_YN03_06.readOnly = "";
		}
	}
	
}
/*
 * ���ܣ�ͨ���Ա�����зּ��������ͨ�����ǣ���Ϊֻ���Ϳ���
 * ���ã��������#����#�Ա�����зּ�����
 */
function setYN03_03Disable(obj){
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	if(obj_YN03_02){
		var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber);
		if(obj_YN03_02.value == "��" || obj_YN03_02.value == ""){
			obj_YN03_03.readOnly = "readonly";
			obj_YN03_03.value ="";
		}else if(obj_YN03_02.value == "��"){
			obj_YN03_03.readOnly = "";
		}
	}
	
}
/*
 * ���ܣ�ͨ������ͨ����ά������ϵ��֤����ͨ����֤ʱ��,��֤����,��֤����,ͨ����֤�Ĳ���ֻ���Ϳ���
 * ���ã��������#����#����ͨ����ά������ϵ��֤
 */
function setYN01_04_05_06_07Disable(obj){
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	if(obj_YN01_03){
		var obj_YN01_04 = getTableFormObj(label_YN01_04,obj_YN01_03.rownumber);
		var obj_YN01_05 = getTableFormObj(label_YN01_05,obj_YN01_03.rownumber);
		var obj_YN01_06 = getTableFormObj(label_YN01_06,obj_YN01_03.rownumber);
		var obj_YN01_07 = getTableFormObj(label_YN01_07,obj_YN01_03.rownumber);
		if(obj_YN01_03.value == "��" || obj_YN01_03.value == ""){
			//ֻ��
			obj_YN01_04.onclick = "";
			obj_YN01_05.readOnly = "readonly";
			obj_YN01_06.readOnly = "readonly";
			obj_YN01_07.readOnly = "readonly";
			//���
			obj_YN01_04.value ="";
			obj_YN01_05.value ="";
			obj_YN01_06.value ="";
			obj_YN01_07.value ="";
		}else if(obj_YN01_03.value == "��"){
			obj_YN01_04.onclick = click_columnshowDate;
			obj_YN01_05.readOnly = "";
			obj_YN01_06.readOnly = "";
			obj_YN01_07.readOnly = "";
		}
	}
	
}

/*
 * ��ʼ��
 */
function initSet(){
	var obj = 0;
	setYN08_02_03Disable(obj);
	setYN06_04Disable(obj);
	setYN03_12Disable(obj);
	setYN03_09Disable(obj);
	setYN03_06Disable(obj);
	setYN03_03Disable(obj);
	setYN01_04_05_06_07Disable(obj);
}
/*
 *���ܣ��ָ���������
 */
var click_columnshowDate = function(){
	showDate(this);
};
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
								setYN10_05Disable(this);
							};
						}
					}
				}
			}
		}
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
/*
 * 
 * �ı���Ŀ�ȶ���
 */ 
jQuery(function(){
	jQuery("div[name = 'textarea_show_value']").css("width","160px"); 
});