jQ(function(){
	jQ("input[name='show_value']").attr("readonly",true);
	//Ӧ����������pdid
	var pdid = jQ("#pdid").val();
	//����ڵ�ҵ����
	if (jQuery("#psdid[value$='001']").length > 0) {
		if(jQuery("input[name = 'pivarvalue[4]']")&&jQuery("input[name = 'pivarvalue[4]']").val()==""){
			// �����������
			jQuery("input[name = 'pivarvalue[4]']").parent().parent().hide();
		}
		
	}
});
//������ѡ��ҳ��
function openSVCPage(obj,index,ccid){
	processObj = obj.parentElement.childNodes[0];
	num = index;
	//Ӧ����������pdid
	var pdid = jQ("#pdid").val();
	// ��������
	var assessTypeId = "pidid" + pdid + "001";
	var jAssessType = jQ("#"+assessTypeId);
	if("��������"==jAssessType.val()){
		ccid = "01385";//Ӧ������
	}else if("Ӧ������"==jAssessType.val()){
		ccid = "01381";//Ӧ������
	}
	//prActive=N ��ѯ�رջ���ֹ������
	openSubWindow('/IGSVC0107_Disp.do?prpdid=' + ccid+'&prActive=N', '_blank','1000','600');
}

//���������� ������У��
function checkAssessName(){
	//����ڵ�
	if (jQuery("#psdid[value$='001']").length > 0) {
		var pdid = jQuery("#pdid").val();
		// ���������� processform0230001002
		assessId = "processform" + pdid + "002";
		var jAssess = jQuery("#"+assessId);
		
		// �жϵ�ǰ�ʲ�����  �Ƿ����jEntity ���������˵���� ���ص���ǰ�ڵ��A��ǩЧ��
		var jProcess = jAssess.children().children().children().find("input[name='show_value']");
		if(jProcess.length>0){
			var assessName = jProcess.val();
			if(null==assessName || ""==assessName){
				alert("�����뱻�������� ��");
				return false; 
			}
		}
	}
	return true;
}