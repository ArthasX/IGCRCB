function initSet(obj){
	if(obj!=null&&obj.value>5){
		alert("���ַ������ܴ���5");
		obj.value="";
	}
}

/**
 * ���ܣ�������ֽڵ��ÿ�����ֱ�ע���ܴ���170������
 * ���ã�������ְ�ť
 * */

function checkTextArea(){
	var textareas = document.getElementsByTagName("textarea");
	for(var i = 0; i < textareas.length - 1; i++){
		if(textareas[i].value.length > 512){
			alert("��"+(i+1)+"������ı�ע��Ϣ���ܴ���"+Math.floor(512/strByteFlag)+"������");
			return false;
		}
	}
	return true;
}