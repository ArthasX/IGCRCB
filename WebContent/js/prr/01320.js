var jq = jQuery.noConflict();

function checkPapers(obj){
	var typeObj = getTableFormObj("������Ա��Ϣ#֤������",obj.getAttribute("rownumber"));
	var cardNo = obj.value;
	
	var flag = false;
	var message = "";
	if(!typeObj.value && obj.value){
		alert("��ѡ��֤�����ͣ�");
		obj.value = "";
		typeObj.focus();
	}
	if (typeObj.value == "���֤") {
		if (cardNo && !isCardNo(cardNo)) {
			flag = true;
			message = "���֤��ʽ����ȷ��";
		}
	}
	if (typeObj.value == "����") {
		if (cardNo && !checkPassport(cardNo)) {
			flag = true;
			message = "���ո�ʽ����ȷ��";
		}
	}
	
	if(flag){
		alert(message);
		obj.value = "";
		obj.focus();
	}
}

//��֤�����Ƿ���ȷ
function checkPassport(number) {
	var str = number;
	//��JavaScript�У�������ʽֻ��ʹ��"/"��ͷ�ͽ���������ʹ��˫����
	//���պ���ĸ�ʽ��
	//��˽��ͨ���պ����ʽ��:14/15+7λ��,G+8λ��������ͨ����:P.+7λ����
	//������ǣ�S.+7λ�� ���� S+8λ��,��D��ͷ�����⽻����.D=diplomatic
	var Expression = /^1[45][0-9]{7}|G[0-9]{8}|P[0-9]{7}|S[0-9]{7,8}|D[0-9]+$/;
	var objExp = new RegExp(Expression);
	return objExp.test(str);
}

function isCardNo(card) {
	// ���֤����Ϊ15λ����18λ��15λʱȫΪ���֣�18λǰ17λΪ���֣����һλ��У��λ������Ϊ���ֻ��ַ�X
	var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
	return reg.test(card);
}

function checkContactInfo(obj) {
	var contactObj = getTableFormObj("������Ա��Ϣ#��ϵ��ʽ",obj.getAttribute("rownumber"));
  	var tel = /^\d{3,4}-?\d{7,9}$/; //�绰�����ʽ010-12345678 
  	var mob=/^(((1[0-9]{1}[0-9]{1}))+\d{8})$/;
	if (contactObj.value&&!tel.test(contactObj.value)&&!mob.test(contactObj.value)) {
		alert("����д��ȷ��ʽ����ϵ��ʽ��");
		contactObj.value = "";
		contactObj.focus();
		return;

	}
}

