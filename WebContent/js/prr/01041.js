/**
 * ���ܣ���ʾ�ĵ������������40�����ģ��ĵ������������80������
 * ���ã��ĵ���������ڵ�
 * */
function docPrompt(obj){
	getFormObj("�ĵ�����").insertAdjacentHTML("afterEnd","<span style=\"color:#bb0500\">(�������40������)</span>");
	getFormObj("�ĵ�����").insertAdjacentHTML("afterEnd","<span style=\"color:#bb0500\">(�������80������)</span>");
}

/**
 * ���ܣ��ж��ĵ������������40�����ģ��ĵ������������80������,���������ʾ
 * ���ã��ĵ���������ڵ��ύ��ť
 * */
function docsubmit(obj){
	if(getFormObj("�ĵ�����").value.length > 40){
		alert("�ĵ������������40������");
		return false;
	}
	if(document.getElementsByName("pivarvalue[1]")[0].value.length > 80){
		alert("�ĵ������������80������");
		return false;
	}
	
	return true;
}
