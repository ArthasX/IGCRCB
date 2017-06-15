jQ(function(){
	//应急整改流程pdid
	var pdid = jQ("#pdid").val();
	//整改任务执行节点
	if (jQuery("#psdid[value$='005']").length > 0) {
		if(jQuery("input[name = 'pivarvalue[9]']")&&jQuery("input[name = 'pivarvalue[9]']").val()==""){
			jQuery("input[name = 'pivarvalue[9]']").parent().parent().hide();
		}
		// 更新预案名称
		planId = "tbentity" + pdid + "008";
		var jplan = jQuery("#"+planId);
		if(!jQuery("input[value='"+pdid+ "009']").parent().find(".editDiv").text())
		jplan.parent().parent().hide();
		// 是否更新预案
		updatePlanId = "pidid" + pdid + "007";
		var jUpdatePlan = jQuery("#"+updatePlanId);
		var isUpdatePlan = jUpdatePlan.val();
		//初始化隐藏 更新预案名称 表单
//		jplan.parent().parent().hide();
		if("是"==isUpdatePlan){
			jplan.parent().parent().show();
			jplan.parent().parent().find("strong").html("<SPAN class=red>* </SPAN>更新预案名称：");
		}
		//是否更新预案 下拉监听
		jUpdatePlan.unbind("change");
		jUpdatePlan.bind('change', function(){
			var selectedVal = jQuery(this).val();
			if("是"==selectedVal){
				jplan.parent().parent().show();
				jplan.parent().parent().find("strong").html("<SPAN class=red>*</SPAN>更新预案名称：");
			}else{
				jplan.parent().parent().hide();
				//清空资产 内容
				jplan.children().children().children().find("input[name='entityName[0]']").val("");
				//清空资产N/A
				jplan.val("");
			}
		});
	}
	
	
	//整改计划审批节点
	if (jQuery("#psdid[value$='003']").length > 0) {
		obj = getFormObj("评审意见");
		if(obj){
			jQuery(obj).val("同意");
		}
	}
	//获取流程节点ID
	var psdid = jQuery("#psdid").val();
	//发起节点为整改名称赋值，并且将演练流程名称变更只读，演练流程prid隐藏，表单整改名称隐藏
	if(psdid.substring(psdid.length-3,psdid.length)=="001"){
		jQuery(getFormObj("演练流程名称")).attr("readonly","true");
		var zgname = getFormObj("演练流程名称").value;
		jQuery("input[name='prtitle']").val(zgname+"-演练流程整改").attr("readonly","true");
	jQuery(getFormObj("演练流程prid")).parent().parent().hide();
	}
	
});
//更新预案名称 表单必填校验
function checkPlanName(){
	//整改任务执行节点
	if (jQuery("#psdid[value$='005']").length > 0) {
		var pdid = jQuery("#pdid").val();
		// 是否更新预案
		updatePlanId = "pidid" + pdid + "007";
		var jUpdatePlan = jQuery("#"+updatePlanId);
		var isUpdatePlan = jUpdatePlan.val();
		// 更新预案名称
		planId = "tbentity" + pdid + "008";
		var jplan = jQuery("#"+planId);
		
		if("是"==isUpdatePlan){
			// 判断当前资产表单中  是否存在jEntity 如果不存在说明是 驳回到当前节点的A标签效果
			var jEntity = jplan.children().children().children().find("input[name='entityName[0]']");
			if(jEntity.length>0){
				var planName = jEntity.val();
				if(null==planName || ""==planName){
					alert("请输入更新预案名称！");
					return false; 
				}
			}
		}
	}
	return true;
}