/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

/**
 * ������������js����
 * @time 2014/06/19
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */


/**
 * ���ܣ����Ľ���ʱ�����������Ŀ�ʼʱ��
 * ���ã��������ύ��ť
 * */
function checkTime(obj){
	//��ȡ���Ŀ�ʼʱ������Ľ���ʱ��
	var beginTime = getFormObj('���Ŀ�ʼʱ��').value;
	var endTime = getFormObj('���Ľ���ʱ��').value;
	
	//�жϿ�ʼʱ����߽�ֹʱ���Ƿ�Ϊ��
	if("" == beginTime || "" == endTime){
		return true;
	}
	
	//������Ŀ�ʼʱ����ڵ������Ľ���ʱ�䣬��ʾ��Ϣ
	if(beginTime.localeCompare(endTime) > 0){
		alert('���Ľ���ʱ�����������Ŀ�ʼʱ��!');
		return false;
	}else{
		return true;
	}
}

/**
 * ���ܣ���ȡ�����̵ı�������� ��ֵ�� �������ı��⡢������������
 * ���ã����������js����
 * */
function valueTitleDesc(obj){
	//��ȡ�������ֵ
	var hiddenField = getFormObj('������').value;
	if(hiddenField != null && hiddenField.length >0){
		//ȥ���ָ���_$_
		var contents = hiddenField.split('_$_');
		//�ж�contents�ĳ��ȣ��������3�����1,2��ϲ�
		if(contents.length > 3){
			for(var i=2 ;i<contents.length; i++){
				if(i < contents.length -1){
					contents[2] +=  contents[i]+'_$_';
				}else{
					contents[2] +=  contents[i];
				}
			}
		}
		//Ϊ�����̱�����ʼֵ
		document.getElementsByName("show_value")[0].value = contents[2];
		document.getElementById("pivarvalue[4]").value = '_processValue_only_id_'+ contents[0]+'_svc_'+ contents[1]+'_name='+contents[2];
	}
	var parameters = document.getElementById("parameters").value;
	if(parameters != null && parameters != ""){
		jQuery.noConflict();
		var par = {};
		par.eiid = parameters;
		jQuery.ajax({
			url:getAppRootUrl()+"/IGFXK0601_GetEntityInfo.do",
			type:"POST",
			data:par,
			dataType :"json",
			cache:false,
			async:false,
			//�ɹ��ص�����
			success:function(result){
				jQuery("#tbentity0100201003").find("input[asm='0100201003']").val(result.einame);
				jQuery("#tbentity0100201003").find("input[name^='entityId']").val("0100201003#" + result.eiid + "#" + result.eiversion);
				getFormObj("��ط����¼�").value = "N/A";
			},
			//ʧ�ܻص�����
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("��ȡ��ʼ�������쳣");
			}
		});
	}
	return true;
}
function selectFxsj(){
	openSubWindow("/IGASM3201_T.do", "_blank", 1100, 600);
}
function setFxsjValue(eiid,einame,eiversion){
	if(eiid != ""){
		jQuery("#tbentity0100201003").find("input[asm='0100201003']").val(einame);
		jQuery("#tbentity0100201003").find("input[name^='entityId']").val("0100201003#" + eiid + "#" + eiversion);
		getFormObj("��ط����¼�").value = "N/A";
	}else{
		jQuery("#tbentity0100201003").find("input[asm='0100201003']").val("");
		jQuery("#tbentity0100201003").find("input[name^='entityId']").val("");
		getFormObj("��ط����¼�").value = "";
	}
}
function openFxsj(eiid){
	openSubWindow("/IGASM3203_T.do?eiid=" + eiid, "_blank", 1100, 600);
}
function deleteEntityFx(pieid){
	if(window.confirm("���Ƿ�ȷ��ɾ����")){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		document.getElementById("pieids").value = pieid;
		var tb = document.getElementById("tbentity0100201003");
		var tr = tb.insertRow();
		var td = tr.insertCell();
		td.innerHTML = '<input type="text" readonly="readonly" name="entityName[0]" asm="0100201003"/><img src="images/seek.gif" width="16" height="16" style="cursor: hand;" alt="��ѯ" onclick="selectFxsj();"/><input type="hidden" name="entityId[0]"/><input type="hidden" name="0100201003"/>';
	}
}