/**
 * ���ܣ�������ѡ���Ƿ�Ӱ��ҵ�񣬰�������#�񣨷Ǳ������Ϊ"��"����Ӱ��ҵ��Χ��Ӱ��ʱ������������
 * ���ã�������ڵ��ύ��ť
 * */
function checkLaunchedSubmit(){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	var a1 = getFormObj("ҵ��Ӱ�췶Χ").value;  				// ҵ��Ӱ�췶Χ��
	var a2 = getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").value;  			// �ƻ�Ӱ��ҵ��ʱ�������ӣ���
	if(affect == '��'){
		if(a1 == ''){
			alert("��ѡ��ҵ��Ӱ�췶Χ��");
			return false;
		}
		if(a2 == ''){
			alert("������ƻ�Ӱ��ҵ��ʱ����");
			return false;
		}
	}
}

/**
 * ���ܣ��Ƿ�Ӱ��ҵ��ѡ��Ϊ����ʱ����ҵ��Ӱ�췶Χ�������ƻ�Ӱ��ʱ����������ʾ��ֻ��ѡ���ǡ�ʱ������ʾ��Ĭ��Ϊ���صĲ���ʾ
 * ���ã��Ƿ�Ӱ��ҵ���onchange�¼��ʹ�����ڵ�onload�¼�
 * */
function onChangeIsAffect(obj){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	if(affect == '��'){
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
	}
}

/**
 * ���ܣ����������ѡ��ı������ΪӦ�ó����������Ŀ��ʱ������"�Ƿ���ҪUAT��֤"������������ʱ��Ҫ������ѡ���Ƿ���ҪUAT��֤�����
 * ���ã��������ڵ�
 * */
function checkAssessment(){
	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
	if(changeType== 'ϵͳ������' || changeType == '������'){
		getFormObj("�Ƿ���ҪUAT��֤").parentElement.parentElement.style.display = "none"; 
	}
	if(getFormObj("�Ƿ�Ӱ��ҵ��").value == '��'){
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
		getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").parentElement.parentElement.style.display = "none";
	}
}

/**
 * ���ܣ�ȷ���Ƿ���ҪUAT��֤��ر��Ƿ�ɼ�
 * ���ã��������ִ�нڵ�
 * */
function checkProductionChange(){
	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
	if(changeType== 'ϵͳ������' || changeType == '������'){
		getFormObj("�Ƿ���ҪUAT��֤").parentElement.parentElement.style.display = "none"; 
		jQuery(getFormObj("��׼������UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();

	}else{
		if(getFormObj("�Ƿ���ҪUAT��֤").value == '��'){
			jQuery(getFormObj("��׼������UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		}
	}
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
}

/**
 * ���ܣ�ȷ���Ƿ���ҪUAT��֤��ر��Ƿ�ɼ�
 * ���ã����������˽ڵ�
 * */
//function checkResultsReview(){
//	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
//	if(changeType== 'ϵͳ������' || changeType == '������'){
//		getFormObj("�Ƿ���ҪUAT��֤").parentElement.parentElement.style.display = "none"; 
//		if(getFormObj("�Ƿ���ҪUAT��֤").value == '��'){
//			getFormObj("��׼������UAT���ִ�п�ʼʱ��").parentElement.parentElement.style.display = "none";
//			getFormObj("��׼������UAT���ִ�н���ʱ��").parentElement.parentElement.style.display = "none";
//			jQuery("input[name='pivarname'][value='��׼������UAT���ִ�й���']");
//		}
//	}
//}
/**
 * ���ܣ�������ѡ���Ƿ�Ӱ��ҵ�񣬰�������#�񣨷Ǳ������Ϊ"��"����Ӱ��ҵ��Χ��Ӱ��ʱ������������
 * ���ã�������ڵ��ύ��ť
 * */
function checkLaunchedSubmit(){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	var a1 = getFormObj("ҵ��Ӱ�췶Χ").value;  				// ҵ��Ӱ�췶Χ��
	var a2 = getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").value;  			// �ƻ�Ӱ��ҵ��ʱ�������ӣ���
	if(affect == '��'){
		if(a1 == ''){
			alert("��ѡ��ҵ��Ӱ�췶Χ��");
			return false;
		}
		if(a2 == ''){
			alert("������ƻ�Ӱ��ҵ��ʱ����");
			return false;
		}
	}
	return true;
}

/**
 * ���ܣ����������ѡ��ı������ΪӦ�ó����������Ŀ��ʱ������"�Ƿ���ҪUAT��֤"������������ʱ��Ҫ������ѡ���Ƿ���ҪUAT��֤�����
 * ���ã��������ڵ�
 * */
function checkAssessment(){
	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
	if(changeType== 'ϵͳ������' || changeType == '������'){
		getFormObj("�Ƿ���ҪUAT��֤").parentElement.parentElement.style.display = "none"; 
	}
	var obj =getFormObj("�Ƿ�Ӱ��ҵ��");			// �Ƿ�Ӱ��ҵ��
	if(obj){
		var affect = obj.value;
		if(affect == '��'){
			getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "";
		}else{
			getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
		}
	}
}



/**
 * ���ܣ�ȷ���Ƿ���ҪUAT��֤��ر��Ƿ�ɼ�
 * ���ã����������˽ڵ�
 * */
function checkResultsReview(){
	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
	if(changeType== 'ϵͳ������' || changeType == '������'){
		getFormObj("�Ƿ���ҪUAT��֤").parentElement.parentElement.style.display = "none"; 
	}
	if(getFormObj("�Ƿ���ҪUAT��֤").value == '��'){
		getFormObj("��׼������UAT���ִ�п�ʼʱ��").parentElement.parentElement.style.display = "none";
		getFormObj("��׼������UAT���ִ�н���ʱ��").parentElement.parentElement.style.display = "none";
		jQuery("input[name='pivarname'][value='��׼������UAT���ִ�й���']").parent().parent().hide();
	}
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
}
/**
 * ���������ڵ�
*���ݴ�����ڵ��С��Ƿ�Ӱ��ҵ��ϵͳ���ı�ֵ������ر�
*��ֵΪ �� ʱ���ر���
 */
function hideBusForms(){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		// ҵ��Ӱ�췶Χ��
		
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
//		getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").style.display = "none";  
	}
}

/**
 * �رսڵ�
 * �����Ƿ���ҪUAT��֤ ������ر�
 */
function hideUATForms(){
	var isUat = getFormObj("�Ƿ���ҪUAT��֤");
	if(isUat && isUat.value == '��'){
		if(getFormObj("��׼������UAT���ִ�п�ʼʱ��")!=null){
			getFormObj("��׼������UAT���ִ�п�ʼʱ��").parentElement.parentElement.style.display = "none";
			getFormObj("��׼������UAT���ִ�н���ʱ��").parentElement.parentElement.style.display = "none";
			jQuery("input[name='pivarname'][value='��׼������UAT���ִ�й���']").parent().parent().hide();
		}
	}
	var affect = getFormObj("�Ƿ�Ӱ��ҵ��");
	if(affect && affect.value == "��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
}
/**
 * ����ڵ��ʼ��
 */
function init_001(){
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		//ajax��������
		jQuery.ajax({
			url:"/IGCRC0401_GetParInfo.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//�ɹ��ص�����
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//ʧ�ܻص�����
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("��ȡ����������쳣");
			}
		});
	}
}

/** -----------------------�汾2-----------------------  */
/**
 * ���ܣ�������ѡ���Ƿ�Ӱ��ҵ�񣬰�������#�񣨷Ǳ������Ϊ"��"����Ӱ��ҵ��Χ��Ӱ��ʱ������������
 * ���ã�������ڵ��ύ��ť
 * */
function checkLaunchedSubmit2(){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	var a1 = getFormObj("ҵ��Ӱ�췶Χ").value;  				// ҵ��Ӱ�췶Χ��
	var a2 = getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").value;  			// �ƻ�Ӱ��ҵ��ʱ�������ӣ���
	if(affect == '��'){
		if(a1 == ''){
			alert("��ѡ��ҵ��Ӱ�췶Χ��");
			return false;
		}
		if(a2 == ''){
			alert("������ƻ�Ӱ��ҵ��ʱ����");
			return false;
		}
	}
	
	var type = getFormObj("������").value;
	if(type == '�������'){
		var obj = getFormObj("���ԭ��");
		if(obj != null && jQuery(getFormObj("���ԭ��")).parent().find("[name='pidaccess']").val() == '3'){//������ԭ��Ϊ ��д
			if(obj.innerHTML == ''){
				alert("��������ԭ��");
				return false;
			}
		}
	}
	
	return true;
}

/**
 * ���ܣ��Ƿ�Ӱ��ҵ��ѡ��Ϊ����ʱ����ҵ��Ӱ�췶Χ�������ƻ�Ӱ��ʱ����������ʾ��ֻ��ѡ���ǡ�ʱ������ʾ��Ĭ��Ϊ���صĲ���ʾ
 * ���ã��Ƿ�Ӱ��ҵ���onchange�¼��ʹ�����ڵ�onload�¼�
 * */
function onChangeIsAffect2(obj){
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	if(affect == '��'){
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
	}
}

/**
 * ���ܣ�����ƽ̨��ѡ��Ϊ��������ʱ������������ƽ̨����ʾ
 * */
function selectOther2(obj){	
	var select = getFormObj("��������ƽ̨");
	if(obj.value == "����"){
		getFormObj("��������ƽ̨").parentElement.parentElement.style.display = "inline";
	}else{
		getFormObj("��������ƽ̨").parentElement.parentElement.style.display = "none";
	}
}
/**
 * ����ڵ��ʼ��  �汾2
 */
function init_001_2(){
	getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
	getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;			// �Ƿ�Ӱ��ҵ��
	if(affect == '��'){
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
	}
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		//ajax��������
		jQuery.ajax({
			url:"/IGCRC0401_GetParInfo.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//�ɹ��ص�����
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//ʧ�ܻص�����
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("��ȡ����������쳣");
			}
		});
	}
}

/**
 * ���������ڵ�
 * ���²��Խڵ�
 * UAT�������
 * 
*���ݴ�����ڵ��С��Ƿ�Ӱ��ҵ��ϵͳ���ı�ֵ������ر�
*��ֵΪ �� ʱ���ر���
 */
function hideBusForms_2(){
	if(!(jQuery(getFormObj("��ѡ�������")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
	}
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
}

/**
 * ���ܣ�
 * ���ã��������ڵ�
 * */
function checkAssessment_2(){
	if(!(jQuery(getFormObj("��ѡ�������")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("�Ƿ�Ӱ��ҵ��").value == '��'){
		getFormObj("ҵ��Ӱ�췶Χ").parentElement.parentElement.style.display = "none";
		getFormObj("�ƻ�Ӱ��ҵ��ʱ�������ӣ�").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("��ѡ�������").value == 'ϵͳ������'){
		getFormObj("UAT���¼��������").parentElement.parentElement.style.display = "none";
	}
}

/**
 * ���ܣ�
 * ���ã��������ִ�нڵ�
 * */
function checkProductionChange_2(){
	if(!(jQuery(getFormObj("��ѡ�������")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("UAT���¼��������").value == '����Ҫ����UAT'){
		jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
	}
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
	if(getFormObj("��ѡ�������").value == 'ϵͳ������'){
		getFormObj("UAT���¼��������").parentElement.parentElement.style.display = "none";
		jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
		jQuery(getFormObj("��׼����ִ�н���ʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("��׼����ִ�й���")).parent().parent().hide().next().hide();
	}
}

/**
 * ���ܣ�
 * ���ã����������˽ڵ�
 * */
function checkResultsReview_2(){
	if(!(jQuery(getFormObj("��ѡ�������")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("UAT���¼��������").value == '����Ҫ����UAT'){
		jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
	}
	var affect =getFormObj("�Ƿ�Ӱ��ҵ��").value;
	if(affect=="��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
	if(getFormObj("��ѡ�������").value == 'ϵͳ������'){
		getFormObj("UAT���¼��������").parentElement.parentElement.style.display = "none";
		jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
		jQuery(getFormObj("��׼����ִ�н���ʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("��׼����ִ�й���")).parent().parent().hide().next().hide();
	}
}

/**
 * ���ܣ���ñ������ֵ�����ѡ������ͱ���ֵ
 * ���ã�������ڵ������ͱ�
 * */
function checkChangeType2(obj){
	var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
	getFormObj("��ѡ�������").value=changeType;
}
/**
 * �رսڵ�
 * �����Ƿ���ҪUAT��֤ ������ر�
 */
function changeReview2(){
	var affect =getFormObj("��ѡ�������").value;			// ��ѡ�������
	var a1 = getFormObj("UAT���¼��������").value;  		// UAT���¼����������
	if(affect != 'ϵͳ������'){
		if(a1 == ''){
			alert("��ѡ��UAT���¼����������");
			return false;
		}
	}
	
	var type = getFormObj("������").value;
	if(type == '�������'){
		var obj = getFormObj("���ԭ��");
		if(obj != null && jQuery(getFormObj("���ԭ��")).parent().find("[name='pidaccess']").val() == '3'){//������ԭ��Ϊ ��д
			if(obj.innerHTML == ''){
				alert("��������ԭ��");
				return false;
			}
		}
	}
	
	return true;
}
/**
 * �رսڵ�
 * �����Ƿ���ҪUAT��֤ ������ر�
 */
function hideUATForms2(){
	if(getFormObj("��ѡ�������")){
		if(!(jQuery(getFormObj("��ѡ�������")).parent().find("[name='pidaccess']").val() == '1')){
			getFormObj("��ѡ�������").parentElement.parentElement.style.display = "none";
		}
	}
	if(getFormObj("UAT���¼��������") && getFormObj("UAT���¼��������").value == '����Ҫ����UAT'){
		jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
	}
	var affect = getFormObj("�Ƿ�Ӱ��ҵ��");
	if(affect && affect.value == "��"){
		// ҵ��Ӱ�췶Χ��
		jQuery(getFormObj("ҵ��Ӱ�췶Χ")).parent().parent().hide();		
	}
	if(getFormObj("��ѡ�������")){
		if(getFormObj("��ѡ�������").value == 'ϵͳ������'){
			getFormObj("UAT���¼��������").parentElement.parentElement.style.display = "none";
			jQuery(getFormObj("UAT���ִ�п�ʼʱ��")).parent().parent().hide().next().hide();
			jQuery(getFormObj("UAT���ִ�й���")).parent().parent().hide().next().hide();
			jQuery(getFormObj("��׼����ִ�н���ʱ��")).parent().parent().hide().next().hide();
			jQuery(getFormObj("��׼����ִ�й���")).parent().parent().hide().next().hide();
		}
	}
}




//������ǩ����ǰ��Ӻ�ɫ"*"(����)
function replaceRedClass(pidName){
	var replaceObj = jQuery("#" + getFormObj(pidName).id).parent().prev().find("strong");
	replaceObj.replaceWith("<span class='red'>* </span>" + replaceObj.text());
}


//��ʼ������
jQuery(document).ready(function(){
	var psd = jQuery("#psdid");
	var flag = "";
	if(psd != null){
		flag = psd.val().substring(7,10);
		if(flag == '001'){//������ڵ�ʱ
			//���ش˱�
			var obj = getFormObj("���ظ���ID");
			if(obj){
				obj.parentElement.parentElement.style.display = "none";
			}
		}
	}
	//��ȡ���� �汾��
	var pdid = jQuery("#pdid").val();
	//zhangqiang add start 2016 04 25
	//��ȡ������� ����ֵ
	var cTypevalue = jQuery("#pidid"+pdid+"035").val();
	if(cTypevalue != null && cTypevalue !=""){
		cvalue = cTypevalue.split("-")[0];
		if(cvalue == "ϵͳ������"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=1;		
		}else if( cvalue == "Ӧ�ó�����"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=2;	
		}else if( cvalue == "��Ŀ��"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=3;	
		}else if( cvalue == "������"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=4;	
		}
	}
	// zhangqiang add end 
//	var params = getQueryString("params");
	var params = jQuery("#parameters").val();
	if(params != null && params != ''){
		var flag = "@_@";//�ָ���
		var param = params.split(flag);
		var title = param[0];//�������
		var desc = param[1];//�������
		var begintime = param[2];//�ƻ�ִ�п�ʼʱ��
		var tree = param[3];//�������
		var type1 = param[4];//������
		var type2 = param[5];//�������
		var type3 = param[6];//����ƽ̨
		var type4 = param[7];//���ԭ�����
		var text1 = param[8];//���ԭ��
		var text2 = param[9];//�������
		var type5 = param[10];//�Ƿ�Ӱ��ҵ��
		var text3 = param[11];//ִ�мƻ�
		var text4 = param[12];//���˼ƻ�
		var text5 = param[13];//��֤�ƻ�
		var attkey = param[14];//����key
		var attstr = param[15];//������ʾ�Ĵ�
		
		
		
		//�������
		jQuery("input[name='prtitle']").val(title);
		//�������
		jQuery("input[name='prdesc']").val(desc);
		jQuery("input[name='prdesc']").prev().html(desc);
		//�ƻ�ִ�п�ʼʱ��0108405002
		jQuery("#pidid"+pdid+"002").val(begintime);
		
		//������� 0108405046
		jQuery("#pidid"+pdid+"035").val(tree.split("_tree_")[1]);
		jQuery("#pidid"+pdid+"035").next().next().val(tree);
		
		//������0108405046
		jQuery("#pidid"+pdid+"046").val(type1);
		//�������0108405065
		jQuery("#pidid"+pdid+"065").val(type2);
		//����ƽ̨0108405063
		var str1 = null;
		var str2 = null;
		if(type3.indexOf('_') != -1){//������
			str1 = type3.substr(0, type3.indexOf('_'));
			str2 = type3.substr(type3.indexOf('_')+1,type3.length);
		}else{
			str1 = type3;
		}
		jQuery("[name = pivarcheckbox[6]]:checkbox").each(function () {
			if(jQuery(this).parent().text() == str1){
				jQuery(this).click();
				jQuery(this).focus();
				if(str2 != null && str2 != ""){
					jQuery(this).next().val(str2);
					jQuery(this).next().change();
				}
			}
        });
		
		//���ԭ�����0108405071
		jQuery("#pidid"+pdid+"071").val(type4);
		//���ԭ��0108405036
		jQuery("#pidid"+pdid+"036").html(text1);
		jQuery("#pidid"+pdid+"036").focus();
		//�������0108405037
		jQuery("#pidid"+pdid+"037").html(text2);
		jQuery("#pidid"+pdid+"037").focus();
		//�Ƿ�Ӱ��ҵ��0108405022
		jQuery("#pidid"+pdid+"022").val(type5);
		//ִ�мƻ�0108405042
		jQuery("#pidid"+pdid+"042").html(text3);
		jQuery("#pidid"+pdid+"042").focus();
		//���˼ƻ�0108405043
		jQuery("#pidid"+pdid+"043").text(text4);
		jQuery("#pidid"+pdid+"043").focus();
		//��֤�ƻ�0108405044
		jQuery("#pidid"+pdid+"044").text(text5);
		jQuery("#pidid"+pdid+"044").focus();
		
		var changeType = getFormObj("�������").value.split('-')[0];  // ������ͱ�
		getFormObj("��ѡ�������").value=changeType;
		
		//����и��� ��ȡ�������ֺ�id��ʾ�ڴ�����ҳ����
		if(attkey != null && attkey !=""){
			if(attstr != null && attstr != ""){
				var str = "<div>";
				var attidArr = attstr.split("*-*")[0];
				var attnameArr = attstr.split("*-*")[1];
				//����Ƕ������ ���,����ֱ��ƴ��
				if(attidArr.length > 1){
					var attids = attidArr.split("*_*");
					var attnames = attnameArr.split("*_*");
					for(var i=0;i<attids.length;i++){
						str += "<a href='/InfoGovernor/downloadSvcFile.do?attId="+attids[i]+"&type=svc'>"+attnames[i]+"</a><br>";
					}
				}else{
					str += "<a href='/InfoGovernor/downloadSvcFile.do?attId="+attidArr+"&type=svc'>"+attnameArr+"</a><br>";
				}
				str += "</div>";
				jQuery("#att").before(str);
			}
			//������key���浽���ر�
			jQuery("#pidid"+pdid+"072").val(attkey);
		}
		
	}
});

//��ȡurl����ֵ
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //����һ������Ŀ�������������ʽ����
    var r = window.location.search.substr(1).match(reg);  //ƥ��Ŀ�����
    if (r != null) return unescape(r[2]); return null; //���ز���ֵ
} 