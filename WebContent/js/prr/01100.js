/**
 * ���ܣ����ϵͳ�Զ���Ӧ��������������"ϵͳ�˻�Ȩ������"ʱ�������Զ��������˻����Ա����ñ��ڷ���ڵ�Ϊ�Ǳ���
 * ���ã������������ͱ�
 * */
function checkLaunched(){
	if(getFormObj("�����������").value == ''){
		getFormObj("�˻�����").parentElement.parentElement.style.display = "none"; 
	}else{
		var serversType = getFormObj("�����������").value.split('-')[1];  		// �����������ͱ�
		if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
			getFormObj("�˻�����").parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj("�˻�����").parentElement.parentElement.style.display = "none";
		}
	} 
}

/**
 * ���ܣ����ϵͳ�Զ���Ӧ��������������"ϵͳ�˻�Ȩ������"ʱ�������Զ��������˻����Ա����ñ��ڷ���ڵ�Ϊ�Ǳ���
 * ���ã������������ͱ�
 * */
function checkServers(obj){
	var serversType = obj.value.split('-')[1];  		// �����������ͱ�
	if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
		getFormObj("�˻�����").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("�˻�����").parentElement.parentElement.style.display = "none";
		var tb = document.getElementById("0110001035_tableForm");
		if(tb){
			for(var i=tb.rows.length -1;i>=0;i--){
				deleteGroup(tb.rows[i]);
			}
		}
	}
}

/**
 * ���ܣ����ϵͳ�Զ���Ӧ��������������"ϵͳ�˻�Ȩ������"ʱ�������Զ��������˻����Ա����ñ��ڷ���ڵ�Ϊ�Ǳ���
 * ���ã����ڵ�
 * */
function checkServersType(){
	var serversType = getFormObj("�����������").value.split('-')[1];  		// �����������ͱ�
	if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
		getFormObj("�˻�����").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("�˻�����").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * ���ܣ����ϵͳ�Զ���Ӧ��������������"ϵͳ�˻�Ȩ������"ʱ�������Զ��������˻����Ա����ñ��ڷ���ڵ�Ϊ�Ǳ���
 * ���ã�����ڵ�
 * */
function checkServersTypeProcess(){
	var serversType = getFormObj("�����������").value.split('-')[1];  		// �����������ͱ�
	if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
		getFormObj("�˻�����").parentElement.parentElement.style.display = ""; 
		getFormObj("HAC����Ȩ���").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("�˻�����").parentElement.parentElement.style.display = "none"; 
		getFormObj("HAC����Ȩ���").parentElement.parentElement.style.display = "none"; 
	}
	var isExport = getFormObj("�Ƿ�Ϊ�������ݵ�������").value;
	if(isExport == '��'){
		getFormObj("�Ƿ���Ҫ����").parentElement.parentElement.style.display = "none"; 
	}else{
		 var labelList = document.getElementsByTagName("label");
		 for(var i=0;i<labelList.length;i++){
			 var q = labelList[i].innerText;
			 if(q.indexOf("����") == 4){
				 q = '*�Ƿ���Ҫ������';
			 }
		 }
	}
	
	isNeedDesensitization();
	
}

/**
 * ���ܣ�������ѡ���Ƿ���Ҫ����
 * ���ã�����ڵ�
 * */
function Desensitization(){
	var desensitizationType = getFormObj("�Ƿ���Ҫ����").value;  				// �Ƿ���Ҫ������
	if(desensitizationType == '��'){
		if(getFormObj("����������").value == ''){
			alert("��ѡ��������������");
			return false;
		}
		if(getFormObj("����������").value == ''){
			alert("��ѡ��������������");
			return false;
		}
		
	}
	if("ϵͳ�����"==getFormObj("�����������").value.split('_')[2]){
		var serversType = getFormObj("�����������").value.split('-')[1];  		// �����������ͱ�
		if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
			 
		}else{
			if(getFormObj("HAC����Ȩ���").value == ''){
				alert("��ѡ��HAC����Ȩ�����");
				return false;
			}
		}
	}

	var isExport = getFormObj("�Ƿ�Ϊ�������ݵ�������").value;
	if(isExport == '��'){
		if(desensitizationType == ''){
			alert("��ѡ���Ƿ���Ҫ������");
			return false;
		}
	}
	
	return true;
}

/**
 * ���ܣ����Ƿ���Ҫ��������ѡ��Ϊ����ʱ�����������������͡������������������ز���ʾ�����ѡ��Ϊ���ǡ�ʱ������ʾ
 * ���ã��Ƿ���Ҫ������onchange�¼��ʹ���ڵ�onload�¼�
 * */

function isNeedDesensitization(obj){
	var desensitizationType = getFormObj("�Ƿ���Ҫ����").value;  				// �Ƿ���Ҫ������
	if(desensitizationType == '��'){
		getFormObj("����������").parentElement.parentElement.style.display = "";
		getFormObj("����������").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("����������").parentElement.parentElement.style.display = "none";
		getFormObj("����������").parentElement.parentElement.style.display = "none";
	}
}

/**
 * ���ܣ��Ƿ���Ҫ����ѡ���ǡ����Ż���ʾ���Ƿ���Ҫ����������HAC����Ȩ�������ѡ�񡮷񡯲���ʾ�������� 
 * ���ã��رսڵ�
 * */
function checkTypeClose(obj){
	if(getFormObj("�Ƿ���Ҫ����")!=undefined){
		var desensitizationType = getFormObj("�Ƿ���Ҫ����").value;  				// �Ƿ���Ҫ������
		if(desensitizationType == '��'){
			getFormObj("����������").parentElement.parentElement.style.display = "";
			getFormObj("����������").parentElement.parentElement.style.display = "";
		}else{
			getFormObj("����������").parentElement.parentElement.style.display = "none";
			getFormObj("����������").parentElement.parentElement.style.display = "none";
		}
	}
	if(getFormObj("�����������")!=undefined){
		var serversType = getFormObj("�����������").value.split('-')[1];  		// �����������ͱ�
		if(serversType== 'ϵͳ�˻�Ȩ������' || serversType == 'ϵͳ�˻����' || serversType == 'ϵͳ�˻�ע��'){
			getFormObj("�˻�����").parentElement.parentElement.style.display = ""; 
			getFormObj("HAC����Ȩ���").parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj("�˻�����").parentElement.parentElement.style.display = "none"; 
			getFormObj("HAC����Ȩ���").parentElement.parentElement.style.display = "none"; 
		}
	}
}

//��ʼ������
jQuery(document).ready(function(){
	
	var psd = jQuery("#psdid");
	var flag = "";
	if(psd != null){
		//"0100101002" -> 002
		flag = psd.val().substring(7,10);
		if(flag == '001'){//������ڵ�ʱ
			//���ش˱�
			var obj = getFormObj("���ظ���ID");
			if(obj){
				obj.parentElement.parentElement.style.display = "none";
			}
		}
	}
	
	var params = jQuery("#parameters").val();
	if(params != null && params != ''){
		var flag = "@_@";//�ָ���
		var param = params.split(flag);
		var title = param[0];//������������
		var desc = param[1];//������������
		var tree = param[2];//�����������
		var type1 = param[3];//�Ƿ�Ϊ�������ݵ�������
		var type2 = param[4];//Ӱ��̶�
		var type3 = param[5];//�����̶�
		var attkey = param[6];//����key
		var attstr = param[7];//������ʾ�Ĵ�
		
		//��ȡ���� �汾��
		var pdid = jQuery("#pdid").val();
		//��ֵ
		jQuery("input[name='prtitle']").val(title);
		//pidid0110001043 ������������
		jQuery("#pidid"+pdid+"043").html(desc);
		jQuery("#pidid"+pdid+"043").focus();
		//pidid0110001041 �����������
		jQuery("#pidid"+pdid+"041").val(tree.split("_tree_")[1]);
		jQuery("#pidid"+pdid+"041").next().next().val(tree);
		//pidid0110001030 �Ƿ�Ϊ�������ݵ�������
		jQuery("#pidid"+pdid+"030").val(type1);
		//pidid0110001007 Ӱ��̶�
		jQuery("#pidid"+pdid+"007").val(type2);
		//pidid0110001006 �����̶�
		jQuery("#pidid"+pdid+"006").val(type3);
		//pidid0110001045 ���ظ���ID

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
			jQuery("#pidid"+pdid+"045").val(attkey);
		}
		
	}
});