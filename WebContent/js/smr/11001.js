/*
 * ����2014-T-B-4 ��Ϣ��ȫ���������
 */

//У�鰴ť
var isValid = true;
var a = "";
var errorObjs = [];

// ��Ϣ��ȫ�ƶȽ���
var label_YN01_01 = "��Ϣ��ȫ�ƶȽ���#����#��Ϣ��ȫ�����ƶ�����";
var label_YN01_02 = "��Ϣ��ȫ�ƶȽ���#����#���У��������������";
var label_YN01_03 = "��Ϣ��ȫ�ƶȽ���#����#������޶�����";
var label_YN01_04 = "��Ϣ��ȫ�ƶȽ���#����#ͨ����Ϣ��ȫ������ϵ��֤";
var label_YN01_05 = "��Ϣ��ȫ�ƶȽ���#����#��֤��Χ";
// ��Ϣ��ȫ��鼰��͸����
var label_YN02_02 = "��Ϣ��ȫ��鼰��͸����#����#�������Ϣ��ȫ�������";
var label_YN02_03 = "��Ϣ��ȫ��鼰��͸����#����#���У����У����ܹ�˾����֯����Ϣ��ȫ�������";
var label_YN02_06 = "��Ϣ��ȫ��鼰��͸����#����#�������֯����͸���Դ���";
var label_YN02_07 = "��Ϣ��ȫ��鼰��͸����#����#����Ƹ���ⲿ������չ��ר����͸���Դ���";

var label_YN02_13_06 = "��Ϣ��ȫ��鼰��͸����#����#�����#������������������";
var label_YN02_13_07 = "��Ϣ��ȫ��鼰��͸����#����#�����#��������������������";
var label_YN02_13 = "��Ϣ��ȫ��鼰��͸����#����#�����#��������";

var label_YN02_14_01 = "��Ϣ��ȫ��鼰��͸����#����#�ϼ�#1";
var label_YN02_14_02 = "��Ϣ��ȫ��鼰��͸����#����#�ϼ�#2";
var label_YN02_14_03 = "��Ϣ��ȫ��鼰��͸����#����#�ϼ�#3";
var label_YN02_13_02 = "��Ϣ��ȫ��鼰��͸����#����#�����#��������";
var label_YN02_13_03 = "��Ϣ��ȫ��鼰��͸����#����#�����#ʵʩ���ţ���֯��";
var label_YN02_13_04 = "��Ϣ��ȫ��鼰��͸����#����#�����#��Ҫ��������";
var label_YN02_13_05 = "��Ϣ��ȫ��鼰��͸����#����#�����#������������������";
var label_YN02_13_06 = "��Ϣ��ȫ��鼰��͸����#����#�����#��������������������";
var label_YN02_13_07 = "��Ϣ��ȫ��鼰��͸����#����#�����#�����ʣ�%��";
var label_YN02_08 = "��Ϣ��ȫ��鼰��͸����#����#�������͸���Ը��ǵ�ϵͳ";
//�ȼ�����
var label_YN03_02 = "�ȼ�����#����#�ȼ������ѱ�������Ϣϵͳ����";
var label_YN03_03 = "�ȼ�����#����#���ѱ�����Ϣϵͳ��#�弶ϵͳ";
var label_YN03_04 = "�ȼ�����#����#���ѱ�����Ϣϵͳ��#�ļ�ϵͳ";
var label_YN03_05 = "�ȼ�����#����#���ѱ�����Ϣϵͳ��#����ϵͳ";
var label_YN03_06 = "�ȼ�����#����#���ѱ�����Ϣϵͳ��#����ϵͳ";

// ��Ϣ��ȫ��ѵ
var label_YN04_01_01 = "��Ϣ��ȫ��ѵ#����#����ȿ�չ����Ϣ��ȫ��ѵ����#����";
var label_YN04_02_01 = "��Ϣ��ȫ��ѵ#����#���У�ȫϽ��Χ����Ϣ��ȫ��ѵ#����";
// ������ȫ
var label_YN05_01 = "������ȫ#����#�ƶ�������ȫ���û���";
var label_YN05_02 = "������ȫ#����#���ǣ�������ȫ���û��߸��Ƿ�Χ";
var label_YN05_03 = "������ȫ#����#���ڶ�����ϵͳ©�����м��";
var label_YN05_04 = "������ȫ#����#���Ƶ��";
var label_YN05_05 = "������ȫ#����#��ȡ������ϵͳ��ȫ���ƴ�ʩ����";
// �ն˰�ȫ
var label_YN06_01 = "�ն˰�ȫ#����#��װͳһ�ķ��������";
var label_YN06_02 = "�ն˰�ȫ#����#��װͳһ���ն˰�ȫ�������";
var label_YN06_03 = "�ն˰�ȫ#����#�ն˿����ǿ���޸�";
var label_YN06_04 = "�ն˰�ȫ#����#�޸�����";
var label_YN06_08 = "�ն˰�ȫ#����#��ȡ���ƶ��豸�����ʩ����";
// Ӧ�ð�ȫ
var label_YN07_06_01 = "Ӧ�ð�ȫ#����#2#����������֧��USB Key��USB Key�Ƿ�ͨ�����������������İ�ȫ���";
var label_YN07_06_02 = "Ӧ�ð�ȫ#����#2#������������";
var label_YN07_06_03 = "Ӧ�ð�ȫ#����#2#���һ�μ��ʱ��";
var label_YN07_08 = "Ӧ�ð�ȫ#����#1#�������пͻ�֤��ǩ������Ϊ";
var label_YN07_09 = "Ӧ�ð�ȫ#����#1#��������";
var label_YN07_01 = "Ӧ�ð�ȫ#����#�ƶ�Ӧ�ð�ȫ�����淶";
var label_YN07_02 = "Ӧ�ð�ȫ#����#���ǣ�Ӧ�ð�ȫ�����淶����";
var label_YN07_05 = "Ӧ�ð�ȫ#����#��������֧�ֵĶ�������֤��ʽ";
var label_YN07_07 = "Ӧ�ð�ȫ#����#�ֻ�����֧�ֶ�������֤��ʽ";

// ���ݰ�ȫ
var label_YN08_01 = "���ݰ�ȫ#����#����ר�ŵ����ݹ�����֯";
var label_YN08_02 = "���ݰ�ȫ#����#��֯����";
var label_YN08_03 = "���ݰ�ȫ#����#�ƶ����ݹ����ƶȺ�����";
var label_YN08_04 = "���ݰ�ȫ#����#���ǣ����ݹ����ƶȺ����̸��Ƿ�Χ";
var label_YN08_10 = "���ݰ�ȫ#����#����������ʹ����������ʱ������������";
var label_YN08_13 = "���ݰ�ȫ#����#��Ҫ��Ϣϵͳ���������������";
var label_YN08_14 = "���ݰ�ȫ#����#����ʧЧ���ݻ��ѻٻ���������Ҫ���ݵĽ��ʽ�������";
var label_YN08_15 = "���ݰ�ȫ#����#���ٻ�������";
// �ͻ���ȫ����
var label_YN09_02 = "�ͻ���ȫ����#����#��ǿ�ͻ���ȫ������������������";
//����У��
var label_YN11_01 = "����#����#����1#��������";
var label_YN11_02 = "����#����#����2#��������";
var label_YN11_03 = "����#����#����3#��������";
/*
 * ���ܣ�У���
 * 
 */
function checkData(obj) {
	//��մ�����ı���ɫ
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	// ��Ϣ��ȫ�ƶȽ���
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	if (obj_YN01_04.value == "") {
		a += "1 ��Ϣ��ȫ�ƶȽ��� ��֤��Χ����Ϊ��\n";
		errorObjs.push(obj_YN01_04);
		isValid = false;
	}
	// ��Ϣ��ȫ��鼰��͸���Լ���
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	for ( var i = 0; i < obj_YN02_13.length-1; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_03 = getTableFormObj(label_YN02_13_03,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_04 = getTableFormObj(label_YN02_13_04,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_07 = getTableFormObj(label_YN02_13_07,
				obj_YN02_13[i].rownumber);
		
		if (obj_YN02_13[i].value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "�������Ʋ���Ϊ��\n";
			errorObjs.push(obj_YN02_13[i]);
			isValid = false;
		}
		if (obj_YN02_13_02.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "�������Ͳ���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_02);
		}
		if (obj_YN02_13_03.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "ʵʩ���Ų���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_03);
		}
		if (obj_YN02_13_04.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "��Ҫ�������ݲ���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_04);
		}
		if (obj_YN02_13_05.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "����������������Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_05);
		}
		if (obj_YN02_13_06.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "������������������Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_06);
		}
		if (obj_YN02_13_07.value == "") {
			a += "2 ��Ϣ��ȫ��鼰��͸���� "
					+ "��"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "�����ʲ���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_07);
		}

	}
	var obj_YN02_08 = getTableFormObjs(label_YN02_08)[0];
	if (obj_YN02_08.value == "") {
		a += "2 ��Ϣ��ȫ��鼰��͸���� �������͸���Ը��ǵ�ϵͳ����Ϊ��";
		isValid = false;
		errorObjs.push(obj_YN02_08);
	}
	var obj_YN02_14_01 = getTableFormObjs(label_YN02_14_01)[0];
	var obj_YN02_14_02 = getTableFormObjs(label_YN02_14_02)[0];
	var obj_YN02_14_03 = getTableFormObjs(label_YN02_14_03)[0];
	if (obj_YN02_14_01.value == "") {
		a += "2 ��Ϣ��ȫ��鼰��͸���� �ϼ����������������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_01);
	}
	if (obj_YN02_14_02.value == "") {
		a += "2 ��Ϣ��ȫ��鼰��͸���� �ϼ���������������������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_02);
	}
	if (obj_YN02_14_03.value == "") {
		a += "2 ��Ϣ��ȫ��鼰��͸���� �ϼ��������ʲ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_03);
	}
	// ������ȫ��֤
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObjs(label_YN05_02)[0];
	if (obj_YN05_01.value == "��" && obj_YN05_02.value == "") {
		a += "5 ������ȫ ������ȫ���û��߸��Ƿ�Χ����Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN05_02);
	}
//	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
//	var obj_YN05_04 = getTableFormObjs(label_YN05_04)[0];
//	if (obj_YN05_03.value == "��" && obj_YN05_04.value == "") {
//		a += "5 ������ȫ ���ڶ�����ϵͳ©�����м�� ���Ƶ�ʲ���Ϊ��\n";
//		isValid = false;
//		errorObjs.push(obj_YN05_04);
//	}
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	if (obj_YN05_05.value == "") {
		a += "5 ������ȫ ��ȡ������ϵͳ��ȫ���ƴ�ʩ����Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN05_05);
	}
	// �ն˰�ȫУ��
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	if (obj_YN06_01.value == "") {
		a += "6 �ն˰�ȫ ��װͳһ�ķ������������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN06_01);
	}
	var obj_YN06_02 = getTableFormObjs(label_YN06_02)[0];
	if (obj_YN06_02.value == "") {
		a += "6 �ն˰�ȫ ��װͳһ���ն˰�ȫ�����������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN06_02);
	}
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if (obj_YN06_03.value == "") {
		a += "6 �ն˰�ȫ �ն˿����ǿ���޸Ĳ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN06_03);
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	if (obj_YN06_03.value == "��" && obj_YN06_04.value == "") {
		a += "6 �ն˰�ȫ �ն˿����ǿ���޸� �޸����ڲ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN06_04);
	}
	var obj_YN06_08 = getTableFormObjs(label_YN06_08)[0];
	if (obj_YN06_08.value == "") {
		a += "6 �ն˰�ȫ ��ȡ���ƶ��豸�����ʩ��������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN06_08);
	}
	// Ӧ�ð�ȫУ��
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];
	if (obj_YN07_01.value == "��" && obj_YN07_02.value == "") {
		a += "7 Ӧ�ð�ȫ Ӧ�ð�ȫ�����淶���ǲ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN07_02);
	}
	var obj_YN07_05 = getTableFormObjs(label_YN07_05)[0];
	if (obj_YN07_05.value == "") {
		a += "7 Ӧ�ð�ȫ ��������֧�ֵĶ�������֤��ʽ����Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN07_05);
	}
	var obj_YN07_06_01 = getTableFormObjs(label_YN07_06_01)[0];
	var obj_YN07_06_02 = getTableFormObjs(label_YN07_06_02)[0];
	var obj_YN07_06_03 = getTableFormObjs(label_YN07_06_03)[0];
	if (obj_YN07_06_01.value == "") {
		a += "7 Ӧ�ð�ȫ USB Key�Ƿ�ͨ�����������������İ�ȫ��ⲻ��Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN07_06_01);
	} else if (obj_YN07_06_01.value == "��") {
		if (obj_YN07_06_02.value == "") {
			a += "7 Ӧ�ð�ȫ USB Key�Ƿ�ͨ�����������������İ�ȫ��� �����������Ʋ���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN07_06_02);
		}
		if (obj_YN07_06_03.value == "") {
			a += "7 Ӧ�ð�ȫ USB Key�Ƿ�ͨ�����������������İ�ȫ��� ���һ�μ��ʱ�䲻��Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN07_06_03);
		}
	}
	var obj_YN07_07 = getTableFormObjs(label_YN07_07)[0];
	if (obj_YN07_07.value == "") {
		a += "7 Ӧ�ð�ȫ �ֻ�����֧�ֶ�������֤��ʽ����Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN07_07);
	}
	var obj_YN07_08 = getTableFormObjs(label_YN07_08)[0];
	var obj_YN07_09 = getTableFormObjs(label_YN07_09)[0];
	if (obj_YN07_08.value == "") {
		a += "7 Ӧ�ð�ȫ �������пͻ�֤��ǩ����������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN07_08);
	} else if (obj_YN07_08.value == "������CA����") {
		if (obj_YN07_09.value == "") {
			a += "7 Ӧ�ð�ȫ �������пͻ�֤��ǩ������ �������Ʋ���Ϊ��\n";
			isValid = false;
			errorObjs.push(obj_YN07_09);
		}

	}
	// ���ݰ�ȫ
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02, obj_YN08_01.rownumber);
	if (obj_YN08_01.value == "") {
		a += "8 ���ݰ�ȫ ����ר�ŵ����ݹ�����֯����Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_01);
	} else if (obj_YN08_01.value == "��" && obj_YN08_02.value == "") {
		a += "8 ���ݰ�ȫ ����ר�ŵ����ݹ�����֯ ��֯���Ʋ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_02);
	}
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	if (obj_YN08_03.value == "��" && obj_YN08_04.value == "") {
		a += "8 ���ݰ�ȫ �ƶ����ݹ����ƶȺ����̸��Ƿ�Χ����Ϊ�� ";
		isValid = false;
		errorObjs.push(obj_YN08_04);
	}
	var obj_YN08_10 = getTableFormObjs(label_YN08_10)[0];
	if (obj_YN08_10.value == "") {
		a += "8 ���ݰ�ȫ ����������ʹ����������ʱ��������������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_10);
	}
	var obj_YN08_13 = getTableFormObjs(label_YN08_13)[0];
	if (obj_YN08_13.value == "") {
		a += "8 ���ݰ�ȫ ��Ҫ��Ϣϵͳ��������������Բ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_13);
	}
	var obj_YN08_14 = getTableFormObjs(label_YN08_14)[0];
	var obj_YN08_15 = getTableFormObjs(label_YN08_15)[0];
	if (obj_YN08_14.value == "") {
		a += "8 ���ݰ�ȫ ����ʧЧ���ݻ��ѻٻ���������Ҫ���ݵĽ��ʽ������ٲ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_14);
	} else if (obj_YN08_14.value == "��" && obj_YN08_15.value == "") {
		a += "8 ���ݰ�ȫ ����ʧЧ���ݻ��ѻٻ���������Ҫ���ݵĽ��ʽ������� ���ٻ������Ʋ���Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN08_15);
	}
	var obj_YN09_02 = getTableFormObjs(label_YN09_02)[0];
	if (obj_YN09_02.value == "") {
		a += "9 �ͻ�������ȫ ��ǿ�ͻ���ȫ������������������Ϊ��\n";
		isValid = false;
		errorObjs.push(obj_YN09_02);
	}
	// У���������ͺ�
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = 0;
	var obj_YN02_06Value = 0;
	var zgsSum = 0;
	var stSum = 0;
	if (obj_YN02_03.value != "") {
		obj_YN02_03Value = obj_YN02_03.value;
	}
	if (obj_YN02_06.value != "") {
		obj_YN02_06Value = obj_YN02_06.value;
	}
	for ( var i = 0; i < obj_YN02_13.length; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		if (obj_YN02_13_02.value == "���У����ܹ�˾����֯����Ϣ��ȫ���") {
			zgsSum += 1;
		} else if (obj_YN02_13_02.value == "��͸����") {
			stSum += 1;
		}

	}
	if(zgsSum != obj_YN02_03Value){
		a+="2 ��Ϣ��ȫ��� ���У����ܹ�˾����֯��չ����Ϣ��ȫ�����������������ѡ�����У����ܹ�˾����֯����Ϣ��ȫ��顱������֮��\n";
		errorObjs.push(obj_YN02_03);
		isValid=false;
	}
	if(stSum != obj_YN02_06Value){
		a+="2 ��Ϣ��ȫ��� �������֯����͸���Դ�������������ѡ����͸���ԡ�������֮��\n";
		errorObjs.push(obj_YN02_06);
		isValid=false;
	}
	//�ȼ�����У��
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var sum_03_04_05_06 = parseInt(obj_YN03_03.value) + parseInt(obj_YN03_04.value) + parseInt(obj_YN03_05.value) + parseInt(obj_YN03_06.value);
	if(obj_YN03_02.value != sum_03_04_05_06){
		a+="3 �ȼ����� �ѱ�����Ϣϵͳ����������ϵͳ����+����ϵͳ����+�ļ�ϵͳ����+�弶ϵͳ����\n";
		errorObjs.push(obj_YN03_03);
		errorObjs.push(obj_YN03_04);
		errorObjs.push(obj_YN03_05);
		errorObjs.push(obj_YN03_06);
		isValid=false;
	}
	//����У��
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObjs(label_YN11_02)[0];
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	if(obj_YN11_01.value ==""){
		a+="10 ���� ��Ϣ��ȫ��������ļ�����Ϊ��";
		errorObjs.push(obj_YN11_01);
		isValid=false;
	}
	if(obj_YN11_02.value ==""){
		a+="10 ���� ��Ϣϵͳ���������������Ϊ��";
		errorObjs.push(obj_YN11_02);
		isValid=false;
	}
	if(obj_YN11_03.value ==""){
		a+="10 ���� ���ݹ��������ϸ���治��Ϊ��";
		errorObjs.push(obj_YN11_03);
		isValid=false;
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
 * ���ܣ�ͨ������ʧЧ���ݻ��ѻٻ���������Ҫ���ݵĽ��ʽ����������ж����ٻ��������Ƿ����
 * ���ã����ݰ�ȫ#����#����ʧЧ���ݻ��ѻٻ���������Ҫ���ݵĽ��ʽ�������
 */
function setYN08_15Disable(obj) {
	var obj_YN08_14 = getTableFormObjs(label_YN08_14)[0];
	var obj_YN08_15 = getTableFormObj(label_YN08_15, obj_YN08_14.rownumber);
	if (obj_YN08_14.value == "��" || obj_YN08_14.value == "") {
		obj_YN08_15.readOnly = "readonly";
		obj_YN08_15.value = "";
	} else if (obj_YN08_14.value == "��") {
		obj_YN08_15.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ����ݹ����ƶȺ��������ж����ݹ����ƶȺ����̸��Ƿ�Χ�Ƿ���� ���ã����ݰ�ȫ#����#�ƶ����ݹ����ƶȺ�����
 */
function setYN08_04Disable(obj) {
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	if (obj_YN08_03.value == "��" || obj_YN08_03.value == "") {
		// ���
		obj_YN08_04.onclick = "";
		// ֻ��
		disableTableCheckBox(obj_YN08_04, true);
	} else if (obj_YN08_03.value == "��") {
		disableTableCheckBox(obj_YN08_04, false);
	}
}

/*
 * ���ܣ�ͨ���ƶ�����ר�ŵ����ݹ�����֯���ж���֯�����Ƿ���� ���ã����ݰ�ȫ#����#����ר�ŵ����ݹ�����֯
 */
function setYN08_02Disable(obj) {
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02, obj_YN08_01.rownumber);
	if (obj_YN08_01.value == "��" ||obj_YN08_01.value == "") {
		obj_YN08_02.value = "";
		obj_YN08_02.readOnly = "readonly";
	} else if (obj_YN08_01.value == "��") {
		obj_YN08_02.readOnly = "";
	}
}

/*
 * ���ܣ�ͨ���ƶ�Ӧ�ð�ȫ�����淶���ж�Ӧ�ð�ȫ�����淶�����Ƿ���� ���ã�Ӧ�ð�ȫ#����#�ƶ�Ӧ�ð�ȫ�����淶
 */
function setYN07_02Disable(obj) {
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormCheckBox(label_YN07_02, "1_1");
	if (obj_YN07_01.value == "��" || obj_YN07_01.value == "") {
		// ���
		obj_YN07_02.onclick = "";
		// ֻ��
		disableTableCheckBox(obj_YN07_02, true);
	} else if (obj_YN07_01.value == "��") {
		disableTableCheckBox(obj_YN07_02, false);
	}
}
/*
 * ���ܣ�ͨ���������пͻ�֤��ǩ������Ϊ���жϻ��������Ƿ���� ���ã�Ӧ�ð�ȫ#����#�������пͻ�֤��ǩ������Ϊ
 */
function setYN07_09Disable(obj) {
	var obj_YN07_08 = getTableFormObjs(label_YN07_08)[0];
	var obj_YN07_09 = getTableFormObj(label_YN07_09, obj_YN07_08.rownumber);
	if (obj_YN07_08.value == "�Խ�CA" || obj_YN07_08.value == "") {
		obj_YN07_09.value = "";
		obj_YN07_09.readOnly = "readonly";
	} else if (obj_YN07_08.value == "������CA����") {
		obj_YN07_09.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ����ȫ��������������������ƺ����һ�μ��ʱ���Ƿ���� ���ã�Ӧ�ð�ȫ#����#�������а�ȫ���#����������֧��USB Key��USB
 * Key�Ƿ�ͨ�����������������İ�ȫ���
 */
function setYN07_06_02_03Disable(obj) {
	var obj_YN07_06_01 = getTableFormObjs(label_YN07_06_01)[0];
	var obj_YN07_06_02 = getTableFormObj(label_YN07_06_02,
			obj_YN07_06_01.rownumber);
	var obj_YN07_06_03 = getTableFormObj(label_YN07_06_03,
			obj_YN07_06_01.rownumber);
	if (obj_YN07_06_01.value == "��" || obj_YN07_06_01.value == "")  {
		obj_YN07_06_02.value = "";
		obj_YN07_06_02.readOnly = "readonly";
		obj_YN07_06_03.value = "";
		obj_YN07_06_03.onclick = "";
	} else if (obj_YN07_06_01.value == "��") {
		obj_YN07_06_03.onclick = click_columnshowDate;
		obj_YN07_06_02.readOnly = "";
	}
}
/*
 * ���ܣ��ָ���������
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * ���ܣ�ͨ���ն˿����ǿ���޸����ж��޸������ܷ���� ���ã��ն˰�ȫ#����#�ն˿����ǿ���޸�
 */
function setYN06_03Disable(obj) {
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04, obj_YN06_03.rownumber);
	if (obj_YN06_03.value == "��" || obj_YN06_03.value == "") {
		obj_YN06_04.value = "";
		obj_YN06_04.readOnly = "readonly";
	} else if (obj_YN06_03.value == "��") {
		obj_YN06_04.readOnly = "";
	}
}
/*
 * ���ܣ����ڶ�����ϵͳ©�����м�����������Ƶ�� ���ã�������ȫ#����#���ڶ�����ϵͳ©�����м��
 */
function setYN05_04Disable(obj) {
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
	if (obj_YN05_03.value == "��" || obj_YN05_03.value == "") {
		obj_YN05_04.value = "";
		obj_YN05_04.readOnly = "readonly";
	} else if (obj_YN05_03.value == "��") {
		obj_YN05_04.readOnly = "";
	}
}
/*
 * ���ܣ�ͨ���ƶ�������ȫ���û������ƶ�������ȫ���û��߸��Ƿ�Χ�Ƿ��ѡ ���ã�������ȫ#����#�ƶ�������ȫ���û���
 */
function setYN05_02Disable(obj) {
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormCheckBox(label_YN05_02, "1_1");
	if (obj_YN05_01.value == "��" ||obj_YN05_01.value == "") {
		// ���
		obj_YN05_02.onclick = "";
		// ֻ��
		disableTableCheckBox(obj_YN05_02, true);
	} else if (obj_YN05_01.value == "��") {
		disableTableCheckBox(obj_YN05_02, false);
	}
}
/*
 * ���ܣ�����ȿ�չ����Ϣ��ȫ��ѵ������ȫϽ��Χ����Ϣ��ȫ��ѵ�����Ƚ� ���ã���Ϣ��ȫ��ѵ#����#����ȿ�չ����Ϣ��ȫ��ѵ����#����
 */
function checkYN04_01_01AndYN04_02_01(obj) {
	var obj_YN04_01_01 = getTableFormObjs(label_YN04_01_01)[0];
	var obj_YN04_02_01 = getTableFormObjs(label_YN04_02_01)[0];
	if (obj_YN04_02_01.value != "") {
		if (obj_YN04_01_01.value == "") {
			obj_YN04_02_01.value = "";

			alert("����ȿ�չ����Ϣ��ȫ��ѵ����>��ȫϽ��Χ����Ϣ��ȫ��ѵ����");
		} else {
			if (parseInt(obj_YN04_01_01.value) < parseInt(obj_YN04_02_01.value)) {
				obj_YN04_02_01.value = "";
				alert("����ȿ�չ����Ϣ��ȫ��ѵ����>��ȫϽ��Χ����Ϣ��ȫ��ѵ����");
			}
		}
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
						imgs[k].onclick = "";
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							imgs[k].onclick = function() {
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
 * ���ܣ���ѡ��ť�Ķ�д���� ������objΪ��ѡ���� access����ѡ�ɱ�ѡʱ��true�����ɱ�ѡʱ��false flag Ϊ�Ƿ�������⺯������
 */
function columnVallueRadio1(obj) {
	obj.value = "";
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					imgs[k].src = "images/rb01.gif";
				}
			}
		}
	}
}
// ����������������Ͳ鿴����
function checkYN02_13_02Count(obj) {
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = 0;
	var obj_YN02_06Value = 0;
	var zgsSum = 0;
	var stSum = 0;
	var errorMessage = "";
	var sign = true;
	for ( var i = 0; i < obj_YN02_13.length; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		if (obj_YN02_13_02.value == "���У����ܹ�˾����֯����Ϣ��ȫ���") {
			zgsSum += 1;
			if (obj_YN02_03.value != "") {
				obj_YN02_03Value = obj_YN02_03.value;
			}
			if (parseInt(zgsSum) > parseInt(obj_YN02_03Value)) {
				errorMessage = "���У����ܹ�˾����֯��չ����Ϣ��ȫ�����������������ѡ�����У����ܹ�˾����֯����Ϣ��ȫ��顱������֮��\n";
				sign = false;
				columnVallueRadio1(obj_YN02_13_02);
			}
		} else if (obj_YN02_13_02.value == "��͸����") {
			stSum += 1;
			if (obj_YN02_06.value != "") {
				obj_YN02_06Value = obj_YN02_06.value;
			}
			if (parseInt(stSum) > parseInt(obj_YN02_06Value)) {
				errorMessage = "�������֯����͸���Դ�������������ѡ����͸���ԡ�������֮��\n";
				sign = false;
				columnVallueRadio1(obj_YN02_13_02);
			}
		}
	}
	if (!sign) {
		alert(errorMessage);
	}

}
// ��ʼ������
function initSet() {
	var obj = 0;
	setYN08_15Disable(obj);
	setYN08_04Disable(obj);
	setYN08_02Disable(obj);
	setYN07_02Disable(obj);
	setYN07_09Disable(obj);
	setYN07_06_02_03Disable(obj);
	setYN06_03Disable(obj);
	setYN05_04Disable(obj);
	setYN05_02Disable(obj);
	setYN01_05Disable(obj);
}
function checkYN02_02_03Value() {
	var obj_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	if (obj_YN02_03.value != "") {
		if (obj_YN02_02.value == "") {
			obj_YN02_03.value = "";
			alert("�������Ϣ��ȫ�������>�����У����ܹ�˾����֯����Ϣ��ȫ�������");
		} else if (parseInt(obj_YN02_03.value) > parseInt(obj_YN02_02.value)) {
			obj_YN02_03.value = "";
			alert("�������Ϣ��ȫ�������>�����У����ܹ�˾����֯����Ϣ��ȫ�������");
		}
	}
}
/*
 * ���ܣ��������������Ƿ��������������� ���ã���Ϣ��ȫ��鼰��͸����#����#�����#������������������
 */
function checkYN02_13_06_07Value(obj) {
	var sign = true;
	var sum1 = 0;
	var sum2 = 0;
	var sum3 = 0;
	var objs = getTableFormObjs(label_YN02_13);
	var obj_YN02_14_01 = getTableFormObjs(label_YN02_14_01)[0];
	var obj_YN02_14_02 = getTableFormObjs(label_YN02_14_02)[0];
	var obj_YN02_14_03 = getTableFormObjs(label_YN02_14_03)[0];

	for ( var i = 0; i < objs.length; i++) {
		var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
				objs[i].rownumber);
		var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
				objs[i].rownumber);
		if (obj_YN02_13_06.value != "") {
			if (obj_YN02_13_05.value == "") {
				obj_YN02_13_06.value = "";
				obj_YN02_14_03.value = "";
				sign = false;
				obj_YN02_14_02.value = "";
				alert("�ѷ��������� >= ������������");
			} else if (parseInt(obj_YN02_13_06.value) > parseInt(obj_YN02_13_05.value)) {
				obj_YN02_13_06.value = "";
				sign = false;
				obj_YN02_14_02.value = "";
				obj_YN02_14_03.value = "";
				alert("�ѷ��������� >= ������������");
			}
		}
	}
	if (sign) {
		for ( var i = 0; i < objs.length; i++) {
			var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
					objs[i].rownumber);
			var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
					objs[i].rownumber);
			var obj_YN02_13_05Value = 0;
			var obj_YN02_13_06Value = 0;
			if (obj_YN02_13_05.value == "") {
				obj_YN02_13_05Value = 0;
			} else {
				obj_YN02_13_05Value = obj_YN02_13_05.value;
			}
			if (obj_YN02_13_06.value == "") {
				obj_YN02_13_06Value = 0;
			} else {
				obj_YN02_13_06Value = obj_YN02_13_06.value;
			}
			sum1 += parseInt(obj_YN02_13_05Value);
			sum2 += parseInt(obj_YN02_13_06Value);
		}
		if (sum1 == 0) {
			sum3 = 0;
		} else {
			sum3 = sum2 / sum1 * 100;
		}
		obj_YN02_14_01.value = sum1;
		obj_YN02_14_02.value = sum2;
		obj_YN02_14_03.value = checkNumberFloat(sum3, 2);
	}

}
// ����С��λ��
function checkNumberFloat(obj, len) {
	return Math.round(obj * Math.pow(10, len)) / Math.pow(10, len);
}
/*
 * ���ܣ�ר����͸���Դ����Ƿ���ڱ������֯����͸���Դ��� ���ã���Ϣ��ȫ��鼰��͸����#����#����Ƹ���ⲿ������չ��ר����͸���Դ���
 */
function checkYN02_06_07Value(obj) {
	var objs = getTableFormObjs(label_YN02_06);
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	if (obj_YN02_07.value != "") {
		if (obj_YN02_06.value == "") {
			obj_YN02_07.value = "";
			alert("�������֯����͸���Դ���>��Ƹ���ⲿ������չ��ר����͸���Դ���");
		} else if (parseInt(obj_YN02_07.value) > parseInt(obj_YN02_06.value)) {
			obj_YN02_07.value = "";
			alert("�������֯����͸���Դ���>��Ƹ���ⲿ������չ��ר����͸���Դ���");
		}
	}
}
/*
 * ���ܣ��жϱ������Ƿ����100
 */
function checkPercent(obj) {
	if (obj.value > 100) {
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"), 0);
		alert("�밴�淶��д" + errorMessage + "����ֵ���ܴ���100\n");
	}
	if (obj.value < 0) {
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"), 0);
		alert("�밴�淶��д" + errorMessage + "����ֵ����С��0\n");
	}
}
/*
 * ���ܣ�ͨ����Ϣ��ȫ������ϵ��֤���ж���֤��Χ�Ƿ����� ���ã���Ϣ��ȫ�ƶȽ���#����#��֤��Χ
 */
function setYN01_05Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObjs(label_YN01_05)[0];
	if (obj_YN01_04.value.trim() == "��" || obj_YN01_04.value.trim() == "" ) {
		// ֻ��
		obj_YN01_05.readOnly = "readonly";
		// ���
		obj_YN01_05.value = "";
	} else if (obj_YN01_04.value.trim() == "��") {
		obj_YN01_05.readOnly = "";
	}
}
/*
 * ���ܣ��жϱ������Ƿ������Ϣ��ȫ�����ƶ����� ���ã���Ϣ��ȫ�ƶȽ���#����#��Ϣ��ȫ�����ƶ�����
 */
function checkItem01(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_02.value.trim() != "" || obj_YN01_03.value.trim() != "") {
		if (obj_YN01_01.value.trim() != "") {
			var message = "";
			if (parseInt(obj_YN01_02.value) > parseInt(obj_YN01_01.value)) {
				message += "��Ϣ��ȫ�����ƶ�����>���������������\n";
				obj_YN01_02.value = "";
			}
			if (parseInt(obj_YN01_03.value) > parseInt(obj_YN01_01.value)) {
				message += "��Ϣ��ȫ�����ƶ�����>��������޶�����	\n";
				obj_YN01_03.value = "";
			}
			if (message) {
				alert(message);
			}
		} else {
			obj_YN01_02.value = "";
			obj_YN01_03.value = "";
			alert("��������Ϣ��ȫ�����ƶ������Լ���������������ͱ�����޶�������");
		}

	}
}
// ���һ��
function addRow(obj, insertRowNum) {
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = obj_YN02_03.value;
	var obj_YN02_06Value = obj_YN02_06.value;
	if (obj_YN02_03Value == "") {
		obj_YN02_03Value = 0;
	}
	if (obj_YN02_06Value == "") {
		obj_YN02_06Value = 0;
	}
	var sumTr = parseInt(obj_YN02_03Value) + parseInt(obj_YN02_06Value);
	if (parseInt(obj_YN02_13.length) > sumTr) {
		alert("����������㹻��д������Ҫ���Ӷ�����");
		return null;
	} else {
		//��Ҫ����е�table����
		var targetTab = obj.parentElement.parentElement;
		//ģ�����
		var templateTab = document.getElementById(targetTab.id + "_template");
		//�Ƿ���ʾ�к� Y ��ʾ�� N ����ʾ
		var showrownum = targetTab.showrownum;
		//����ģ����󣬽���������ӵ���ǰtable������
		var tr = null;
		for(var i=0;i<templateTab.rows.length;i++){
			//��Ҫ��ӵ��ж���
			//�ж��Ƿ�ָ�����е����λ�ã����ָ������ָ��λ����ӣ����δָ����Ĭ����ӵ����һ��
			if(insertRowNum != null){
				tr = targetTab.insertRow(insertRowNum);
			}else{
				tr = targetTab.insertRow(targetTab.rows.length);
			}
			//�趨���е��Ҽ��˵�
			tr.className = "rightMenu";
			tr.oncontextmenu = function(){return false;};
			jQuery(tr).unbind("mousedown").mousedown(function(event){
				event.stopPropagation();
				rightMenu(this,event);
			});
			//�����ʾ�кţ�Ԥ���к���ʾλ��
			if("Y" == showrownum){
				var indexCell2 = tr.insertCell(0);
				indexCell2.align = "center";
			}
			//����ģ���У�������ӵ���ǰ������
			for(var j=0;j<templateTab.rows[i].cells.length;j++){
				var td = tr.insertCell();
				if( templateTab.rows[i].cells[j].style.textAlign){
					td.style.textAlign =  templateTab.rows[i].cells[j].style.textAlign;
				}
				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
			}
			//����к��к��п��ܱ����ң���Ҫ���������к�
			shortRowNum(targetTab);
			var onAdd = targetTab.onAdd;
			if(onAdd){
				onAdd(tr);
			}
		}
		
		return tr;
//		// ��Ҫ����е�table����
//		var targetTab = obj.parentElement.parentElement;
//		// ģ�����
//		var templateTab = document.getElementById(targetTab.id + "_template");
//		// �Ƿ���ʾ�к� Y ��ʾ�� N ����ʾ
//		var showrownum = targetTab.showrownum;
//		// ����ģ����󣬽���������ӵ���ǰtable������
//		for ( var i = 0; i < templateTab.rows.length; i++) {
//			// ��Ҫ��ӵ��ж���
//			var tr = null;
//			// �ж��Ƿ�ָ�����е����λ�ã����ָ������ָ��λ����ӣ����δָ����Ĭ����ӵ����һ��
//			if (insertRowNum != null) {
//				tr = targetTab.insertRow(insertRowNum);
//			} else {
//				tr = targetTab.insertRow(targetTab.rows.length - 1);
//			}
//			var delTd = tr.insertCell(0);
//			delTd.align = "center";
//			delTd.innerHTML = '<img src="images/bullet_delete.png" onclick="deleteRow(this);" style="cursor: hand" border="0" />';
//			var idxFlag = 1;
//			// �����ʾ�кţ�Ԥ���к���ʾλ��
//			if ("Y" == showrownum) {
//				idxFlag = 2;
//				var indexCell2 = tr.insertCell(1);
//				indexCell2.align = "center";
//				if (targetTab.rows[0].name == "titlerow") {
//					indexCell2.innerHTML = targetTab.rows.length - 3;
//				} else {
//					indexCell2.innerHTML = targetTab.rows.length - 2;
//				}
//			}
//
//			// ����ģ���У�������ӵ���ǰ������
//			for ( var j = 0; j < templateTab.rows[i].cells.length; j++) {
//				var td = tr.insertCell(j + idxFlag);
//				if (templateTab.rows[i].cells[j].style.textAlign) {
//					td.style.textAlign = templateTab.rows[i].cells[j].style.textAlign;
//				}
//				if (templateTab.rows[i].cells[j].style.display) {
//					td.style.display = templateTab.rows[i].cells[j].style.display;
//				}
//				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
//			}
//			// ����к��к��п��ܱ����ң���Ҫ���������к�
//			shortRowNum(targetTab);
//			var onAdd = targetTab.onAdd;
//			if (onAdd) {
//				onAdd(tr);
//			}
//			return tr;
//		}
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