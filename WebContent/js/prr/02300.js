jQ(function(){
	jQ("input[name='show_value']").attr("readonly",true);
	//应急评估流程pdid
	var pdid = jQ("#pdid").val();
	//发起节点业务处理
	if (jQuery("#psdid[value$='001']").length > 0) {
		if(jQuery("input[name = 'pivarvalue[4]']")&&jQuery("input[name = 'pivarvalue[4]']").val()==""){
			// 评估意见描述
			jQuery("input[name = 'pivarvalue[4]']").parent().parent().hide();
		}
		
	}
});
//弹出程选择页面
function openSVCPage(obj,index,ccid){
	processObj = obj.parentElement.childNodes[0];
	num = index;
	//应急评估流程pdid
	var pdid = jQ("#pdid").val();
	// 评估类型
	var assessTypeId = "pidid" + pdid + "001";
	var jAssessType = jQ("#"+assessTypeId);
	if("演练评估"==jAssessType.val()){
		ccid = "01385";//应急演练
	}else if("应急评估"==jAssessType.val()){
		ccid = "01381";//应急评估
	}
	//prActive=N 查询关闭或终止的流程
	openSubWindow('/IGSVC0107_Disp.do?prpdid=' + ccid+'&prActive=N', '_blank','1000','600');
}

//被评估流程 表单必填校验
function checkAssessName(){
	//发起节点
	if (jQuery("#psdid[value$='001']").length > 0) {
		var pdid = jQuery("#pdid").val();
		// 被评估流程 processform0230001002
		assessId = "processform" + pdid + "002";
		var jAssess = jQuery("#"+assessId);
		
		// 判断当前资产表单中  是否存在jEntity 如果不存在说明是 驳回到当前节点的A标签效果
		var jProcess = jAssess.children().children().children().find("input[name='show_value']");
		if(jProcess.length>0){
			var assessName = jProcess.val();
			if(null==assessName || ""==assessName){
				alert("请输入被评估流程 ！");
				return false; 
			}
		}
	}
	return true;
}