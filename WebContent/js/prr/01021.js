/**
 * ���ܣ����ϵͳ�Զ���Ӧ��������������"ϵͳ�˻�Ȩ������"ʱ�������Զ��������˻����Ա����ñ��ڷ���ڵ�Ϊ�Ǳ���
 * ���ã�����ڵ�
 * */
function checkQuestionResource(){
	if(document.readyState === "complete"){
		getFormObj('��ܻ�������').parentElement.parentElement.style.display = "none";
		var name = getFormObj('�����Դ').value;  		// �����������ͱ�
		if(name!=null && name=='������ܻ���'){
			getFormObj('��ܻ�������').parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj('��ܻ�������').parentElement.parentElement.style.display = "none";
			getFormObj('��ܻ�������').parentElement.parentElement.style.width = "200";
		}
	}else{
		//setTimeout(checkQuestionResource(), 500);
	}
}
checkQuestionResource();

//��ʼ������
jQuery(document).ready(function(){
	checkQuestionResource();
});
