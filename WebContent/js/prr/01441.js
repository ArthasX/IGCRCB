jQ(function(){

});

//��������ҳ���check 
function checkSituationForm(){
	var strByteFlag = 3;
	//����ڵ�ҵ����
	if (jQuery("#psdid[value$='001']").length > 0) {
		//���̶���ID
		// ��������
		var val1 = getFormObj("��������").value;
		if(val1 == null || val1 == "") {
			alert("�����볡������!");
			return false;
		}
		//��������len
		if(val1.strlen()>120){
			alert("�������Ʋ��ܴ���"+Math.floor(120/strByteFlag)+"�����֣�");
			return false;
		}
		// ��������
		var val2 = jQuery(getFormObj("��������")).next("input").val();
		if (val2 == null || val2 == "") {
			alert("�����볡������!");
			return false;
		}
		//��������len
		if(val2.strlen()>3000){
			alert("�����������ܴ���"+Math.floor(3000/strByteFlag)+"�����֣�");
			return false;
		}
		// Ԥ�ƻָ�ʱ��
		var val3 = getFormObj("Ԥ�ƻָ�ʱ��").value;
		if (val3 == null || val3 == "") {
			alert("������Ԥ�ƻָ�ʱ��!");
			return false;
		}
	}
	return true;
}
