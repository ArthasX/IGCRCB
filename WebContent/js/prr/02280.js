jQ(function(){
	//Ӧ����������pdid
	var pdid = jQ("#pdid").val();
	//��������ִ�нڵ�
	if (jQuery("#psdid[value$='005']").length > 0) {
		if(jQuery("input[name = 'pivarvalue[9]']")&&jQuery("input[name = 'pivarvalue[9]']").val()==""){
			jQuery("input[name = 'pivarvalue[9]']").parent().parent().hide();
		}
		// ����Ԥ������
		planId = "tbentity" + pdid + "008";
		var jplan = jQuery("#"+planId);
		if(!jQuery("input[value='"+pdid+ "009']").parent().find(".editDiv").text())
		jplan.parent().parent().hide();
		// �Ƿ����Ԥ��
		updatePlanId = "pidid" + pdid + "007";
		var jUpdatePlan = jQuery("#"+updatePlanId);
		var isUpdatePlan = jUpdatePlan.val();
		//��ʼ������ ����Ԥ������ ��
//		jplan.parent().parent().hide();
		if("��"==isUpdatePlan){
			jplan.parent().parent().show();
			jplan.parent().parent().find("strong").html("<SPAN class=red>* </SPAN>����Ԥ�����ƣ�");
		}
		//�Ƿ����Ԥ�� ��������
		jUpdatePlan.unbind("change");
		jUpdatePlan.bind('change', function(){
			var selectedVal = jQuery(this).val();
			if("��"==selectedVal){
				jplan.parent().parent().show();
				jplan.parent().parent().find("strong").html("<SPAN class=red>*</SPAN>����Ԥ�����ƣ�");
			}else{
				jplan.parent().parent().hide();
				//����ʲ� ����
				jplan.children().children().children().find("input[name='entityName[0]']").val("");
				//����ʲ�N/A
				jplan.val("");
			}
		});
	}
	//ȥ���ʲ��İ汾����ʾ
//	if(jQuery("#psdid[value$='005']").length > 0 || jQuery("#psdid[value$='006']").length > 0 ||jQuery("#psdid[value$='002']").length > 0){
//		if(jQuery("#pidid"+pdid+"007")){
//			var aStr = jQuery(jQuery(jQuery("#pidid0228001007").parent().parent().next().children()[1])).find("a").html();
//			if(aStr !=null && aStr != ""){
//				aStr = aStr.substring(0,aStr.indexOf("("));
//				jQuery(jQuery(jQuery("#pidid0228001007").parent().parent().next().children()[1])).find("a").html(aStr);
//			}
//			
//		}
//	}
	
	
	//���ļƻ������ڵ�
	if (jQuery("#psdid[value$='003']").length > 0) {
		obj = getFormObj("�������");
		if(obj){
			jQuery(obj).val("ͬ��");
		}
	}
	
	
	
});
//����Ԥ������ ������У��
function checkPlanName(){
	//��������ִ�нڵ�
	if (jQuery("#psdid[value$='005']").length > 0) {
		var pdid = jQuery("#pdid").val();
		// �Ƿ����Ԥ��
		updatePlanId = "pidid" + pdid + "007";
		var jUpdatePlan = jQuery("#"+updatePlanId);
		var isUpdatePlan = jUpdatePlan.val();
		// ����Ԥ������
		planId = "tbentity" + pdid + "008";
		var jplan = jQuery("#"+planId);
		
		if("��"==isUpdatePlan){
			// �жϵ�ǰ�ʲ�����  �Ƿ����jEntity ���������˵���� ���ص���ǰ�ڵ��A��ǩЧ��
			var jEntity = jplan.children().children().children().find("input[name='entityName[0]']");
			if(jEntity.length>0){
				var planName = jEntity.val();
				if(null==planName || ""==planName){
					alert("���������Ԥ�����ƣ�");
					return false; 
				}
			}
		}
	}
	return true;
}