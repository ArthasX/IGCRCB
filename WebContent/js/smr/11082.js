/*
 * ����2014-T-B-11 ҵ�������Թ��������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];
// ҵ�������Թ�����֯�ܹ�
var label_YN01_01 = "ҵ�������Թ�����֯�ܹ�#����#����ҵ�������Թ���ίԱ���������֯";
var label_YN01_02 = "ҵ�������Թ�����֯�ܹ�#����#���ǣ���֯����";
var label_YN01_03 = "ҵ�������Թ�����֯�ܹ�#����#��Ա����";
var label_YN01_04 = "ҵ�������Թ�����֯�ܹ�#����#������ָ��ҵ�������Թ������ܲ���";
var label_YN01_05 = "ҵ�������Թ�����֯�ܹ�#����#���ǣ���������";
var label_YN01_06 = "ҵ�������Թ�����֯�ܹ�#����#��������Ϣ�Ƽ�����";
// ҵ�������Թ�����ϵ���ƶ�
var label_YN02_01 = "ҵ�������Թ�����ϵ���ƶ�#����#�ƶ��ͷ���ҵ�������Թ���ս�Թ滮";
var label_YN02_02 = "ҵ�������Թ�����ϵ���ƶ�#����#���ǣ�����ʱ��";
var label_YN02_03_01 = "ҵ�������Թ�����ϵ���ƶ�#����#ս�Թ滮�ڴ�#1";
var label_YN02_03_02 = "ҵ�������Թ�����ϵ���ƶ�#����#ս�Թ滮�ڴ�#2";
// ҵ��Ӱ�����
var label_YN03_01 = "ҵ��Ӱ�����#����#�ѿ�չҵ��Ӱ�����";
var label_YN03_02 = "ҵ��Ӱ�����#����#���ǣ�ǣͷ��֯��չҵ��Ӱ������Ĳ�����";
var label_YN03_03 = "ҵ��Ӱ�����#����#��������";
var label_YN03_04 = "ҵ��Ӱ�����#����#ҵ��Ӱ��������澭ҵ�������Թ���ίԱ���߼����������";
var label_YN03_05 = "ҵ��Ӱ�����#����#���һ������ʱ��";
var label_YN03_06 = "ҵ��Ӱ�����#����#����ҵ��Ӱ���������ƶ�ҵ��ָ�����";
var label_YN03_07 = "ҵ��Ӱ�����#����#����";
var label_YN03_08 = "ҵ��Ӱ�����#����#��ʶ�����Ҫҵ������";
var label_YN03_09_01 = "ҵ��Ӱ�����#����#��ά��ѭ��#��Ҫҵ������";
var label_YN03_09_02_01 = "ҵ��Ӱ�����#����#��ά��ѭ��#ҵ��ָ�ָ��#RTO";
var label_YN03_09_02_02 = "ҵ��Ӱ�����#����#��ά��ѭ��#ҵ��ָ�ָ��#RPO";
var label_YN03_09_03 = "ҵ��Ӱ�����#����#��ά��ѭ��#ҵ���ڹ�����";
var label_YN03_09_04 = "ҵ��Ӱ�����#����#��ά��ѭ��#ҵ��Ӱ�������չ����";
var label_YN03_09_05 = "ҵ��Ӱ�����#����#��ά��ѭ��#ҵ��Ӱ��������ʱ��";
// ҵ�������Լƻ�����Դ����
var label_YN04_01 = "ҵ�������Լƻ�����Դ����#����#�ƶ��ͷ�����������ҵ�������Լƻ�";
var label_YN04_02 = "ҵ�������Լƻ�����Դ����#����#����ʱ��";
var label_YN04_03 = "ҵ�������Լƻ�����Դ����#����#����ҵ�������Լƻ������޶�����";
var label_YN04_04 = "ҵ�������Լƻ�����Դ����#����#���һ���޶���������ʱ��";
var label_YN04_05 = "ҵ�������Լƻ�����Դ����#����#�ƶ��ͷ�����������Ӧ��Ԥ��";
var label_YN04_06 = "ҵ�������Լƻ�����Դ����#����#����ʱ��:";
var label_YN04_07 = "ҵ�������Լƻ�����Դ����#����#����ר��Ӧ��Ԥ�������޶�����";
var label_YN04_08 = "ҵ�������Լƻ�����Դ����#����#���һ���޶���������ʱ��:";
var label_YN04_11 = "ҵ�������Լƻ�����Դ����#����#��Ҫҵ��ר��Ӧ��Ԥ��������";
// ҵ������������
var label_YN05_01 = "ҵ������������#����#���ƶ��ͷ���ҵ�������������ƻ�";
var label_YN05_02 = "ҵ������������#����#����ʱ��";
var label_YN05_06 = "ҵ������������#����#�������Ҫҵ���ҵ������������������";
// ҵ�������������Ľ�
var label_YN06_01 = "ҵ�������������Ľ�#����#��չҵ�������Թ�����ϵ����";
var label_YN06_02 = "ҵ�������������Ľ�#����#���ǣ�������ʽ";
var label_YN06_03 = "ҵ�������������Ľ�#����#������������";
var label_YN06_04 = "ҵ�������������Ľ�#����#�����������ύ�߼����������";
var label_YN06_05 = "ҵ�������������Ľ�#����#���һ������ʱ��";
/*
 * ���ܣ��ύУ��
 */
function checkData() {
	// ��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	// ҵ�������Թ�����֯�ܹ�У��
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "��") {
		if (obj_YN01_02.value == "") {
			errorObjs.push(obj_YN01_02);
			a += "1.ҵ�������Թ�����֯�ܹ�����֯���Ʋ���Ϊ��\n";
			isValid = false;
		}
		if (obj_YN01_03.value == "") {
			errorObjs.push(obj_YN01_03);
			a += "1.ҵ�������Թ�����֯�ܹ��г�Ա���Ų���Ϊ��\n";
			isValid = false;
		}
	}
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "��") {
		if (obj_YN01_05.value == "") {
			errorObjs.push(obj_YN01_05);
			a += "1.ҵ�������Թ�����֯�ܹ�����֯���Ʋ���Ϊ��\n";
			isValid = false;
		}
		if (obj_YN01_06.value == "") {
			errorObjs.push(obj_YN01_06);
			a += "1.ҵ�������Թ�����֯�ܹ��ж�������Ϣ�Ƽ����Ų���Ϊ��\n";
			isValid = false;
		}
	}

	// ҵ�������Թ�����ϵ���ƶ�У��
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[0];
	var obj_YN02_03_02 = getTableFormObjs(label_YN02_03_02)[0];
	if (obj_YN02_01.value == "��") {
		if (obj_YN02_02.value == "") {
			errorObjs.push(obj_YN02_02);
			a += "2.ҵ�������Թ�����ϵ���ƶ��з���ʱ�䲻��Ϊ��\n";
			isValid = false;
		}
		if (obj_YN02_03_01.value == "" || obj_YN02_03_02.value == "") {
			errorObjs.push(obj_YN02_03_01);
			a += "2.ҵ�������Թ�����ϵ���ƶ���ս�Թ滮�ڲ���Ϊ��\n";
			isValid = false;
		}
	}
	// ҵ��Ӱ�����
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	var obj_YN03_06 = getTableFormObj(label_YN03_06, obj_YN03_01.rownumber);
	var obj_YN03_07 = getTableFormObjs(label_YN03_07)[0];
	var obj_YN03_08 = getTableFormObj(label_YN03_08, obj_YN03_01.rownumber);

	if (obj_YN03_01.value == "��") {
		if (obj_YN03_02.value == "") {
			errorObjs.push(obj_YN03_02);
			a += "3.ҵ��Ӱ�������ǣͷ��֯��չҵ��Ӱ������Ĳ��Ų���Ϊ��\n";
			isValid = false;
		}
		if(obj_YN03_02.value =="��������"){
			if (obj_YN03_03.value == "") {
				errorObjs.push(obj_YN03_03);
				a += "3.ҵ��Ӱ������в������Ʋ���Ϊ��\n";
				isValid = false;
			}
		}
		
		if (obj_YN03_04.value == "") {
			errorObjs.push(obj_YN03_04);
			a += "3.ҵ��Ӱ�������ҵ��Ӱ��������澭ҵ�������Թ���ίԱ���߼��������������Ϊ��\n";
			isValid = false;
		}
		if(obj_YN03_04.value == "��"){
			if (obj_YN03_05.value == "") {
				errorObjs.push(obj_YN03_05);
				a += "3.ҵ��Ӱ����������һ������ʱ�䲻��Ϊ��\n";
				isValid = false;
			}
		}
		if (obj_YN03_06.value == "") {
			errorObjs.push(obj_YN03_06);
			a += "3.ҵ��Ӱ������и���ҵ��Ӱ���������ƶ�ҵ��ָ����Բ���Ϊ��\n";
			isValid = false;
		}
//		if (obj_YN03_07.value == "") {
//			errorObjs.push(obj_YN03_07);
//			a += "3.ҵ��Ӱ������а�������Ϊ��\n";
//			isValid = false;
//		}
		if (obj_YN03_08.value == "") {
			errorObjs.push(obj_YN03_08);
			a += "3.ҵ��Ӱ���������ʶ�����Ҫҵ����������Ϊ��\n";
			isValid = false;
		}
	}
	var obj_YN03_09_01 = getTableFormObjs(label_YN03_09_01);
	for ( var i = 0; i < obj_YN03_09_01.length - 1; i++) {
		var obj_YN03_09_02_01 = getTableFormObj(label_YN03_09_02_01,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_02_02 = getTableFormObj(label_YN03_09_02_02,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_03 = getTableFormObj(label_YN03_09_03,
				obj_YN03_09_01[i].rownumber);
		var obj_YN03_09_04 = getTableFormObj(label_YN03_09_04,
				obj_YN03_09_01[i].rownumber);
		var obj_YN03_09_05 = getTableFormObj(label_YN03_09_05,
				obj_YN03_09_01[i].rownumber);
		if (obj_YN03_09_01[i].value == "" || obj_YN03_09_01[i].value == "��") {
			errorObjs.push(obj_YN03_09_01[i]);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ���Ҫҵ�����Ʋ���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_YN03_09_02_01.value == "" || obj_YN03_09_02_01.value == "��") {
			errorObjs.push(obj_YN03_09_02_01);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ�RTO:����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_YN03_09_02_02.value == "" || obj_YN03_09_02_02.value == "��") {
			errorObjs.push(obj_YN03_09_02_02);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ�RPO:����Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_YN03_09_03.value == "" || obj_YN03_09_03.value == "��") {
			errorObjs.push(obj_YN03_09_03);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ�ҵ���ڹ����Ų���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_YN03_09_04.value == "" || obj_YN03_09_04.value == "��") {
			errorObjs.push(obj_YN03_09_04);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ�ҵ��Ӱ�������չ���Ų���Ϊ�գ�\n";
			isValid = false;
		}
		if (obj_YN03_09_05.value == "" || obj_YN03_09_05.value == "��") {
			errorObjs.push(obj_YN03_09_05);
			a += "3.ͨ��ҵ��Ӱ�����ʶ�����Ҫҵ����ϸ��� ���� ���" + (i + 1)
					+ "����Ҫҵ�����Ʋ�Ϊ���ޡ���գ�ҵ��Ӱ��������ʱ�䲻��Ϊ�գ�\n";
			isValid = false;
		}
	}
	// ҵ�������Լƻ�����Դ����У��
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02, obj_YN04_01.rownumber);
	if (obj_YN04_01.value == "��" && obj_YN04_02.value == "") {
		errorObjs.push(obj_YN04_02);
		a += "4.ҵ�������Լƻ�����Դ�����з���ʱ�䲻��Ϊ��\n";
		isValid = false;
	}
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
	if (obj_YN04_03.value == "��" && obj_YN04_04.value == "") {
		errorObjs.push(obj_YN04_02);
		a += "4.ҵ�������Լƻ�����Դ���������һ���޶���������ʱ��\n";
		isValid = false;
	}
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06, obj_YN04_05.rownumber);
	if (obj_YN04_05.value == "��" && obj_YN04_06.value == "") {
		errorObjs.push(obj_YN04_06);
		a += "4.ҵ�������Լƻ�����Դ�����з���ʱ�䲻��Ϊ��\n";
		isValid = false;
	}
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	var obj_YN04_08 = getTableFormObj(label_YN04_08, obj_YN04_07.rownumber);
	if (obj_YN04_07.value == "��" && obj_YN04_08.value == "") {
		errorObjs.push(obj_YN04_08);
		a += "4.ҵ�������Լƻ�����Դ���������һ���޶���������ʱ�䲻��Ϊ��\n";
		isValid = false;
	}

	// ҵ������������
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
	if (obj_YN05_01.value == "��" &&obj_YN05_02.value =="") {
		errorObjs.push(obj_YN05_02);
		a += "5.ҵ�������������з���ʱ�䲻��Ϊ��\n";
		isValid = false;
	}

	var obj_YN04_11 = getTableFormObjs(label_YN04_11)[0];
	var obj_YN05_06 = getTableFormObjs(label_YN05_06)[0];
	if (parseFloat(obj_YN04_11.value) < parseFloat(obj_YN05_06.value)) {
		errorObjs.push(obj_YN05_06);
		a += "[��Ҫҵ��ר��Ӧ��Ԥ��������] Ӧ���ڵ��� [�������Ҫҵ��Ӧ������������] \n";
		isValid = false;
	}
	// ҵ�������������Ľ�
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObjs(label_YN06_02)[0];
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_01.rownumber);
	if (obj_YN06_01.value == "��") {
		if (obj_YN06_02.value == "") {
			errorObjs.push(obj_YN06_02);
			a += "6.ҵ�������������Ľ���������ʽ����Ϊ��\n";
			isValid = false;
		}
		if(obj_YN06_02.value.indexOf("ί�е�����������չ")>0){
			if (obj_YN06_03.value == "") {
				errorObjs.push(obj_YN06_03);
				a += "6.ҵ�������������Ľ��������������Ʋ���Ϊ��\n";
				isValid = false;
			}
		}
		
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "��" && obj_YN06_05.value == "") {
		errorObjs.push(obj_YN06_05);
		a += "6.ҵ�������������Ľ������һ������ʱ�䲻��Ϊ��\n";
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
	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null ) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("����")>-1&&errorObjs[i].previousSibling.innerHTML.indexOf("��������")<-1){
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
 * ���ܣ�ͨ�����ƶ��ͷ���ҵ�������������ƻ���������ʱ��ֻ���Ϳ��� ���ã�ҵ������������#����#���ƶ��ͷ���ҵ�������������ƻ�
 */
function setYN06_05Disable(obj) {
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	var obj_YN06_05 = getTableFormObj(label_YN06_05, obj_YN06_04.rownumber);
	if (obj_YN06_04.value == "��") {
		obj_YN06_05.onclick = click_columnshowDate;
	} else {
		obj_YN06_05.onclick = "";
		obj_YN06_05.value = "";
	}
}

/*
 * ���ܣ�ͨ����չҵ�������Թ�����ϵ��������������ʽֻ���Ϳ��� ���ã�ҵ�������������Ľ�#����#��չҵ�������Թ�����ϵ����
 */
function setYN06_02Disable(obj) {
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormCheckBox(label_YN06_02, "1_1");
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_01.rownumber);
	if (obj_YN06_01.value == "��") {
		disableTableCheckBox(obj_YN06_02, false);
		setYN06_03Disable();
		jQuery(obj_YN06_02).click(
				function(){
					setYN06_03Disable();
				}
		);
		
	} else {
		disableTableCheckBox(obj_YN06_02, true);
		obj_YN06_03.readOnly = "readOnly";
		obj_YN06_03.value = "";
	}
}

function setYN06_03Disable(obj){
	var obj_YN06_02Value = getTableFormObj(label_YN06_02, "1_1");
	var obj_YN06_03 = getTableFormObj(label_YN06_03, obj_YN06_02Value.rownumber);
	var str = obj_YN06_02Value.value;
	if(str.indexOf("ί�е�����������չ")>-1){
		obj_YN06_03.readOnly = "";
	}else{
		obj_YN06_03.readOnly = "readOnly";
		obj_YN06_03.value = "";
	}
}
/*
 * ���ܣ�ͨ�����ƶ��ͷ���ҵ�������������ƻ���������ʱ��ֻ���Ϳ��� ���ã�ҵ������������#����#���ƶ��ͷ���ҵ�������������ƻ�
 */
function setYN05_02Disable(obj) {
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02, obj_YN05_01.rownumber);
	if (obj_YN05_01.value == "��") {
		obj_YN05_02.onclick = click_columnshowDate;
	} else {
		obj_YN05_02.onclick = "";
		obj_YN05_02.value = "";
	}
}
/*
 * ���ܣ�ͨ������ҵ�������Լƻ������޶����ƾ������һ���޶���������ʱ��ֻ���Ϳ��� ���ã�ҵ�������Լƻ�����Դ����#����#����ҵ�������Լƻ������޶�����
 */
function setYN04_04Disable(obj) {
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04, obj_YN04_03.rownumber);
	if (obj_YN04_03.value == "��") {
		obj_YN04_04.onclick = click_columnshowDate;
	} else {
		obj_YN04_04.onclick = "";
		obj_YN04_04.value = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ�����������Ӧ��Ԥ����������ʱ��:ֻ���Ϳ��� ���ã�ҵ�������Լƻ�����Դ����#����#�ƶ��ͷ�����������Ӧ��Ԥ��
 */
function setYN04_06Disable(obj) {
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06, obj_YN04_05.rownumber);
	if (obj_YN04_05.value == "��") {
		obj_YN04_06.onclick = click_columnshowDate;
	} else {
		obj_YN04_06.onclick = "";
		obj_YN04_06.value = "";
	}
}
/*
 * ���ܣ�����ר��Ӧ��Ԥ�������޶����ƾ������һ���޶���������ʱ��:�޶�����ֻ���Ϳ��� ���ã�ҵ�������Լƻ�����Դ����#����#����ר��Ӧ��Ԥ�������޶�����
 */
function setYN04_08Disable(obj) {
	var obj_YN04_07 = getTableFormObjs(label_YN04_07)[0];
	var obj_YN04_08 = getTableFormObj(label_YN04_08, obj_YN04_07.rownumber);
	if (obj_YN04_07.value == "��") {
		obj_YN04_08.onclick = click_columnshowDate;
	} else {
		obj_YN04_08.onclick = "";
		obj_YN04_08.value = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ�����������ҵ�������Լƻ���������ʱ��ֻ���Ϳ��� ���ã�ҵ�������Լƻ�����Դ����#����#�ƶ��ͷ�����������ҵ�������Լƻ�
 */
function setYN04_02Disable(obj) {
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02, obj_YN04_01.rownumber);
	if (obj_YN04_01.value == "��") {
		obj_YN04_02.onclick = click_columnshowDate;
	} else {
		obj_YN04_02.onclick = "";
		obj_YN04_02.value = "";
	}
}

/*
 * ���ܣ�ͨ���ѿ�չҵ��Ӱ���������������ֻ���Ϳ��� ���ã�ҵ��Ӱ�����#����#�ѿ�չҵ��Ӱ�����
 */
function setYN02OtherDisable(obj) {
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	var obj_YN03_06 = getTableFormObj(label_YN03_06, obj_YN03_01.rownumber);
	var obj_YN03_07 = getTableFormCheckBox(label_YN03_07, "1_1");
	var obj_YN03_08 = getTableFormObj(label_YN03_08, obj_YN03_01.rownumber);
	if (obj_YN03_01.value == "��") {
		columnVallueRadio2(obj_YN03_02, true, true,setYN03_03Disable);
		columnVallueRadio2(obj_YN03_04, true, true,setYN03_05Disable);
		columnVallueRadio1(obj_YN03_06, true, false);
		disableTableCheckBox(obj_YN03_07, false);
		obj_YN03_08.readOnly = "";
	} else {
//		columnVallueRadio1(obj_YN03_02, false, false);
		columnVallueRadio2(obj_YN03_02, false, false,setYN03_03Disable);
		obj_YN03_03.readOnly = "readonly";
//		columnVallueRadio1(obj_YN03_04, false, false);
		columnVallueRadio2(obj_YN03_04, false, false,setYN03_05Disable);
		obj_YN03_05.onclick = "";
		columnVallueRadio1(obj_YN03_06, false, false);
		disableTableCheckBox(obj_YN03_07, true);
		obj_YN03_08.readOnly = "readonly";

		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";
		obj_YN03_06.value = "";
		obj_YN03_08.value = "";
	}

}
/**���һ������ʱ��*/
function setYN03_05Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04, obj_YN03_01.rownumber);
	var obj_YN03_05 = getTableFormObj(label_YN03_05, obj_YN03_01.rownumber);
	if(obj_YN03_04.value == "��"){
		obj_YN03_05.onclick = click_columnshowDate;
	}else{
		obj_YN03_05.onclick = "";
		obj_YN03_05.value = "";
	}
}

/**��������*/
function setYN03_03Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02, obj_YN03_01.rownumber);
	var obj_YN03_03 = getTableFormObj(label_YN03_03, obj_YN03_01.rownumber);
	if(obj_YN03_02.value =="��������"){
		obj_YN03_03.readOnly = "";
	}else{
		obj_YN03_03.readOnly = "readonly";
		obj_YN03_03.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ��ͷ���ҵ�������Թ���ս�Թ滮��������ʱ��ֻ���Ϳ��� ���ã�ҵ�������Թ�����ϵ���ƶ�#����#�ƶ��ͷ���ҵ�������Թ���ս�Թ滮
 */
function setYN02_02_03Disable(obj) {
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02, obj_YN02_01.rownumber);
	var obj_YN02_03_01 = getTableFormObjs(label_YN02_03_01)[0];
	var obj_YN02_03_02 = getTableFormObjs(label_YN02_03_02)[0];
	if (obj_YN02_01.value == "��") {
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03_01.readOnly = "";
		obj_YN02_03_02.readOnly = "";
	} else {
		obj_YN02_02.onclick = "";
		obj_YN02_03_01.readOnly = "readonly";

		obj_YN02_02.value = "";
		obj_YN02_03_02.readOnly = "readonly";

	}
}
/*
 * ���ܣ�У�����Ƿ�����λ��
 */
function checkDateLength(obj) {
	var objValue = obj.value;
	if (objValue.length != 4) {
		obj.value = "";
		alert("���������ʽ���ԣ�ӦΪ4λ���֣�����2012��");
	}
}
/*
 * ���ܣ�ͨ��������ָ��ҵ�������Թ������ܲ��ž�����������ֻ���Ϳ��� ���ã�ҵ�������Թ�����֯�ܹ�#����#������ָ��ҵ�������Թ������ܲ���
 */
function setYN01_05_06Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObj(label_YN01_05, obj_YN01_04.rownumber);
	var obj_YN01_06 = getTableFormObj(label_YN01_06, obj_YN01_04.rownumber);
	if (obj_YN01_04.value == "��") {
		columnVallueRadio1(obj_YN01_06, true, false);
		obj_YN01_05.readOnly = "";
	} else {
		obj_YN01_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN01_06, false, false);
		obj_YN01_05.value = "";
		obj_YN01_06.value = "";
	}
}

/*
 * ���ܣ�ͨ������ҵ�������Թ���ίԱ���������֯������֯����ֻ���Ϳ��� ���ã�ҵ�������Թ�����֯�ܹ�#����#����ҵ�������Թ���ίԱ���������֯
 */
function setYN01_02_03Disable(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_01.value == "��") {
		obj_YN01_02.readOnly = "";
		obj_YN01_03.readOnly = "";
	} else {
		obj_YN01_02.readOnly = "readonly";
		obj_YN01_03.readOnly = "readonly";
		obj_YN01_02.value = "";
		obj_YN01_03.value = "";
	}
}
/*
 * ��ʼ��
 */
function initSet() {
	var obj = 0;
	setYN01_02_03Disable(obj);
	setYN01_05_06Disable(obj);
	setYN02_02_03Disable(obj);
	setYN02OtherDisable(obj);
	setYN04_02Disable(obj);
	setYN04_04Disable(obj);
	setYN04_06Disable(obj);
	setYN04_08Disable(obj);
	setYN05_02Disable(obj);
	setYN06_02Disable(obj);
	setYN06_05Disable(obj);
	setWidth();
}

function setWidth(){
	var obj_YN03_09_01 = getTableFormObjs(label_YN03_09_01);
	for ( var i = 0; i < obj_YN03_09_01.length; i++) {
		var obj_YN03_09_02_01 = getTableFormObj(label_YN03_09_02_01,
				obj_YN03_09_01[i].rownumber + "_1");
		var obj_YN03_09_02_02 = getTableFormObj(label_YN03_09_02_02,
				obj_YN03_09_01[i].rownumber + "_1");
		jQuery(obj_YN03_09_02_01).css("width","40px");
		jQuery(obj_YN03_09_02_02).css("width","40px");
	}
}
/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio1(obj, access, flag) {
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
						imgs[k].onclick = "";
						
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} 
					}
				}
			}
		}
	}
}
/*
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio2(obj, access, flag,clickfunction) {
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
						imgs[k].onclick = "";
						jQuery(imgs[k]).unbind("click");
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							jQuery(imgs[k]).bind("click",function(){
								columnVallueRadio(this);
								clickfunction(this);
							});
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
* ���ܣ������ڵ��ʼ��
* 
*/
function delTable(){
	var YN02_03_01Obj = getTableFormObjs(label_YN02_03_01)[0];
	var YN02_03_02Obj = getTableFormObjs(label_YN02_03_02)[0];
	if(YN02_03_01Obj.value == "" &&YN02_03_02Obj.value == ""){
		jQuery("table[id="+jQuery("#pdid").val()+"226_tableForm]").parent().children().remove();
	}
	initSet();
}

