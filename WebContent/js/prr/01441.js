jQ(function(){

});

//场景发起页面表单check 
function checkSituationForm(){
	var strByteFlag = 3;
	//发起节点业务处理
	if (jQuery("#psdid[value$='001']").length > 0) {
		//流程定义ID
		// 场景名称
		var val1 = getFormObj("场景名称").value;
		if(val1 == null || val1 == "") {
			alert("请输入场景名称!");
			return false;
		}
		//场景名称len
		if(val1.strlen()>120){
			alert("场景名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
			return false;
		}
		// 场景描述
		var val2 = jQuery(getFormObj("场景描述")).next("input").val();
		if (val2 == null || val2 == "") {
			alert("请输入场景描述!");
			return false;
		}
		//场景描述len
		if(val2.strlen()>3000){
			alert("场景描述不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
			return false;
		}
		// 预计恢复时间
		var val3 = getFormObj("预计恢复时间").value;
		if (val3 == null || val3 == "") {
			alert("请输入预计恢复时间!");
			return false;
		}
	}
	return true;
}
