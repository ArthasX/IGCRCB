/**
 * 功能：发起人选择是否影响业务，包括：是#否（非必填）若填为"是"，则影响业务范围及影响时长两个表单必填
 * 配置：待发起节点提交按钮
 * */
function checkLaunchedSubmit(){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	var a1 = getFormObj("业务影响范围").value;  				// 业务影响范围表单
	var a2 = getFormObj("计划影响业务时长（分钟）").value;  			// 计划影响业务时长（分钟）表单
	if(affect == '是'){
		if(a1 == ''){
			alert("请选择业务影响范围！");
			return false;
		}
		if(a2 == ''){
			alert("请输入计划影响业务时长！");
			return false;
		}
	}
}

/**
 * 功能：是否影响业务，选择为“否”时，“业务影响范围”、“计划影响时长”，不显示，只有选择“是”时，才显示，默认为隐藏的不显示
 * 配置：是否影响业务表单onchange事件和待发起节点onload事件
 * */
function onChangeIsAffect(obj){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	if(affect == '是'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
	}
}

/**
 * 功能：如果发起人选择的变更类型为应用程序类或者项目类时，会有"是否需要UAT验证"的联动表单，此时需要评审人选择是否需要UAT验证（必填）
 * 配置：变更评审节点
 * */
function checkAssessment(){
	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
	if(changeType== '系统网络类' || changeType == '数据类'){
		getFormObj("是否需要UAT验证").parentElement.parentElement.style.display = "none"; 
	}
	if(getFormObj("是否影响业务").value == '否'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "none";
	}
}

/**
 * 功能：确认是否需要UAT验证相关表单是否可见
 * 配置：生产变更执行节点
 * */
function checkProductionChange(){
	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
	if(changeType== '系统网络类' || changeType == '数据类'){
		getFormObj("是否需要UAT验证").parentElement.parentElement.style.display = "none"; 
		jQuery(getFormObj("标准环境及UAT变更执行开始时间")).parent().parent().hide().next().hide();

	}else{
		if(getFormObj("是否需要UAT验证").value == '否'){
			jQuery(getFormObj("标准环境及UAT变更执行开始时间")).parent().parent().hide().next().hide();
		}
	}
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
}

/**
 * 功能：确认是否需要UAT验证相关表单是否可见
 * 配置：变更结果复核节点
 * */
//function checkResultsReview(){
//	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
//	if(changeType== '系统网络类' || changeType == '数据类'){
//		getFormObj("是否需要UAT验证").parentElement.parentElement.style.display = "none"; 
//		if(getFormObj("是否需要UAT验证").value == '否'){
//			getFormObj("标准环境及UAT变更执行开始时间").parentElement.parentElement.style.display = "none";
//			getFormObj("标准环境及UAT变更执行结束时间").parentElement.parentElement.style.display = "none";
//			jQuery("input[name='pivarname'][value='标准环境及UAT变更执行过程']");
//		}
//	}
//}
/**
 * 功能：发起人选择是否影响业务，包括：是#否（非必填）若填为"是"，则影响业务范围及影响时长两个表单必填
 * 配置：待发起节点提交按钮
 * */
function checkLaunchedSubmit(){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	var a1 = getFormObj("业务影响范围").value;  				// 业务影响范围表单
	var a2 = getFormObj("计划影响业务时长（分钟）").value;  			// 计划影响业务时长（分钟）表单
	if(affect == '是'){
		if(a1 == ''){
			alert("请选择业务影响范围！");
			return false;
		}
		if(a2 == ''){
			alert("请输入计划影响业务时长！");
			return false;
		}
	}
	return true;
}

/**
 * 功能：如果发起人选择的变更类型为应用程序类或者项目类时，会有"是否需要UAT验证"的联动表单，此时需要评审人选择是否需要UAT验证（必填）
 * 配置：变更评审节点
 * */
function checkAssessment(){
	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
	if(changeType== '系统网络类' || changeType == '数据类'){
		getFormObj("是否需要UAT验证").parentElement.parentElement.style.display = "none"; 
	}
	var obj =getFormObj("是否影响业务");			// 是否影响业务
	if(obj){
		var affect = obj.value;
		if(affect == '是'){
			getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
		}else{
			getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
		}
	}
}



/**
 * 功能：确认是否需要UAT验证相关表单是否可见
 * 配置：变更结果复核节点
 * */
function checkResultsReview(){
	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
	if(changeType== '系统网络类' || changeType == '数据类'){
		getFormObj("是否需要UAT验证").parentElement.parentElement.style.display = "none"; 
	}
	if(getFormObj("是否需要UAT验证").value == '否'){
		getFormObj("标准环境及UAT变更执行开始时间").parentElement.parentElement.style.display = "none";
		getFormObj("标准环境及UAT变更执行结束时间").parentElement.parentElement.style.display = "none";
		jQuery("input[name='pivarname'][value='标准环境及UAT变更执行过程']").parent().parent().hide();
	}
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
}
/**
 * 部门审批节点
*根据待发起节点中“是否影响业务系统”的表单值隐藏相关表单
*（值为 否 时隐藏表单）
 */
function hideBusForms(){
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		// 业务影响范围表单
		
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
//		getFormObj("计划影响业务时长（分钟）").style.display = "none";  
	}
}

/**
 * 关闭节点
 * 根据是否需要UAT验证 隐藏相关表单
 */
function hideUATForms(){
	var isUat = getFormObj("是否需要UAT验证");
	if(isUat && isUat.value == '否'){
		if(getFormObj("标准环境及UAT变更执行开始时间")!=null){
			getFormObj("标准环境及UAT变更执行开始时间").parentElement.parentElement.style.display = "none";
			getFormObj("标准环境及UAT变更执行结束时间").parentElement.parentElement.style.display = "none";
			jQuery("input[name='pivarname'][value='标准环境及UAT变更执行过程']").parent().parent().hide();
		}
	}
	var affect = getFormObj("是否影响业务");
	if(affect && affect.value == "否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
}
/**
 * 发起节点初始化
 */
function init_001(){
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		//ajax请求数据
		jQuery.ajax({
			url:"/IGCRC0401_GetParInfo.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//成功回调函数
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//失败回调函数
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("获取检查项数据异常");
			}
		});
	}
}

/** -----------------------版本2-----------------------  */
/**
 * 功能：发起人选择是否影响业务，包括：是#否（非必填）若填为"是"，则影响业务范围及影响时长两个表单必填
 * 配置：待发起节点提交按钮
 * */
function checkLaunchedSubmit2(){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	var a1 = getFormObj("业务影响范围").value;  				// 业务影响范围表单
	var a2 = getFormObj("计划影响业务时长（分钟）").value;  			// 计划影响业务时长（分钟）表单
	if(affect == '是'){
		if(a1 == ''){
			alert("请选择业务影响范围！");
			return false;
		}
		if(a2 == ''){
			alert("请输入计划影响业务时长！");
			return false;
		}
	}
	
	var type = getFormObj("变更类别").value;
	if(type == '紧急变更'){
		var obj = getFormObj("变更原因");
		if(obj != null && jQuery(getFormObj("变更原因")).parent().find("[name='pidaccess']").val() == '3'){//如果变更原因为 可写
			if(obj.innerHTML == ''){
				alert("请输入变更原因！");
				return false;
			}
		}
	}
	
	return true;
}

/**
 * 功能：是否影响业务，选择为“否”时，“业务影响范围”、“计划影响时长”，不显示，只有选择“是”时，才显示，默认为隐藏的不显示
 * 配置：是否影响业务表单onchange事件和待发起节点onload事件
 * */
function onChangeIsAffect2(obj){
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	if(affect == '是'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
	}
}

/**
 * 功能：更新平台，选择为“其他”时，“其他更新平台”显示
 * */
function selectOther2(obj){	
	var select = getFormObj("其他更新平台");
	if(obj.value == "其他"){
		getFormObj("其他更新平台").parentElement.parentElement.style.display = "inline";
	}else{
		getFormObj("其他更新平台").parentElement.parentElement.style.display = "none";
	}
}
/**
 * 发起节点初始化  版本2
 */
function init_001_2(){
	getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
	getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
	var affect =getFormObj("是否影响业务").value;			// 是否影响业务
	if(affect == '是'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
	}
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		//ajax请求数据
		jQuery.ajax({
			url:"/IGCRC0401_GetParInfo.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//成功回调函数
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//失败回调函数
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("获取检查项数据异常");
			}
		});
	}
}

/**
 * 部门审批节点
 * 更新测试节点
 * UAT变更测试
 * 
*根据待发起节点中“是否影响业务系统”的表单值隐藏相关表单
*（值为 否 时隐藏表单）
 */
function hideBusForms_2(){
	if(!(jQuery(getFormObj("所选变更类型")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
	}
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
}

/**
 * 功能：
 * 配置：变更评审节点
 * */
function checkAssessment_2(){
	if(!(jQuery(getFormObj("所选变更类型")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("是否影响业务").value == '否'){
		getFormObj("业务影响范围").parentElement.parentElement.style.display = "none";
		getFormObj("计划影响业务时长（分钟）").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("所选变更类型").value == '系统网络类'){
		getFormObj("UAT更新及测试情况").parentElement.parentElement.style.display = "none";
	}
}

/**
 * 功能：
 * 配置：生产变更执行节点
 * */
function checkProductionChange_2(){
	if(!(jQuery(getFormObj("所选变更类型")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("UAT更新及测试情况").value == '不需要更新UAT'){
		jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
	}
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
	if(getFormObj("所选变更类型").value == '系统网络类'){
		getFormObj("UAT更新及测试情况").parentElement.parentElement.style.display = "none";
		jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
		jQuery(getFormObj("标准环境执行结束时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("标准环境执行过程")).parent().parent().hide().next().hide();
	}
}

/**
 * 功能：
 * 配置：变更结果复核节点
 * */
function checkResultsReview_2(){
	if(!(jQuery(getFormObj("所选变更类型")).parent().find("[name='pidaccess']").val() == '1')){
		getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
	}
	if(getFormObj("UAT更新及测试情况").value == '不需要更新UAT'){
		jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
	}
	var affect =getFormObj("是否影响业务").value;
	if(affect=="否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
	if(getFormObj("所选变更类型").value == '系统网络类'){
		getFormObj("UAT更新及测试情况").parentElement.parentElement.style.display = "none";
		jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
		jQuery(getFormObj("标准环境执行结束时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("标准环境执行过程")).parent().parent().hide().next().hide();
	}
}

/**
 * 功能：获得变更类型值后给所选变更类型表单赋值
 * 配置：待发起节点变更类型表单
 * */
function checkChangeType2(obj){
	var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
	getFormObj("所选变更类型").value=changeType;
}
/**
 * 关闭节点
 * 根据是否需要UAT验证 隐藏相关表单
 */
function changeReview2(){
	var affect =getFormObj("所选变更类型").value;			// 所选变更类型
	var a1 = getFormObj("UAT更新及测试情况").value;  		// UAT更新及测试情况表单
	if(affect != '系统网络类'){
		if(a1 == ''){
			alert("请选择UAT更新及测试情况！");
			return false;
		}
	}
	
	var type = getFormObj("变更类别").value;
	if(type == '紧急变更'){
		var obj = getFormObj("变更原因");
		if(obj != null && jQuery(getFormObj("变更原因")).parent().find("[name='pidaccess']").val() == '3'){//如果变更原因为 可写
			if(obj.innerHTML == ''){
				alert("请输入变更原因！");
				return false;
			}
		}
	}
	
	return true;
}
/**
 * 关闭节点
 * 根据是否需要UAT验证 隐藏相关表单
 */
function hideUATForms2(){
	if(getFormObj("所选变更类型")){
		if(!(jQuery(getFormObj("所选变更类型")).parent().find("[name='pidaccess']").val() == '1')){
			getFormObj("所选变更类型").parentElement.parentElement.style.display = "none";
		}
	}
	if(getFormObj("UAT更新及测试情况") && getFormObj("UAT更新及测试情况").value == '不需要更新UAT'){
		jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
		jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
	}
	var affect = getFormObj("是否影响业务");
	if(affect && affect.value == "否"){
		// 业务影响范围表单
		jQuery(getFormObj("业务影响范围")).parent().parent().hide();		
	}
	if(getFormObj("所选变更类型")){
		if(getFormObj("所选变更类型").value == '系统网络类'){
			getFormObj("UAT更新及测试情况").parentElement.parentElement.style.display = "none";
			jQuery(getFormObj("UAT变更执行开始时间")).parent().parent().hide().next().hide();
			jQuery(getFormObj("UAT变更执行过程")).parent().parent().hide().next().hide();
			jQuery(getFormObj("标准环境执行结束时间")).parent().parent().hide().next().hide();
			jQuery(getFormObj("标准环境执行过程")).parent().parent().hide().next().hide();
		}
	}
}




//给表单标签文字前添加红色"*"(红星)
function replaceRedClass(pidName){
	var replaceObj = jQuery("#" + getFormObj(pidName).id).parent().prev().find("strong");
	replaceObj.replaceWith("<span class='red'>* </span>" + replaceObj.text());
}


//初始化函数
jQuery(document).ready(function(){
	var psd = jQuery("#psdid");
	var flag = "";
	if(psd != null){
		flag = psd.val().substring(7,10);
		if(flag == '001'){//待发起节点时
			//隐藏此表单
			var obj = getFormObj("隐藏附件ID");
			if(obj){
				obj.parentElement.parentElement.style.display = "none";
			}
		}
	}
	//获取流程 版本号
	var pdid = jQuery("#pdid").val();
	//zhangqiang add start 2016 04 25
	//获取变更类型 树的值
	var cTypevalue = jQuery("#pidid"+pdid+"035").val();
	if(cTypevalue != null && cTypevalue !=""){
		cvalue = cTypevalue.split("-")[0];
		if(cvalue == "系统网络类"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=1;		
		}else if( cvalue == "应用程序类"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=2;	
		}else if( cvalue == "项目类"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=3;	
		}else if( cvalue == "数据类"){
			jQuery("#pidid"+pdid+"067").get(0).selectedIndex=4;	
		}
	}
	// zhangqiang add end 
//	var params = getQueryString("params");
	var params = jQuery("#parameters").val();
	if(params != null && params != ''){
		var flag = "@_@";//分隔符
		var param = params.split(flag);
		var title = param[0];//变更名称
		var desc = param[1];//变更描述
		var begintime = param[2];//计划执行开始时间
		var tree = param[3];//变更类型
		var type1 = param[4];//变更类别
		var type2 = param[5];//变更分类
		var type3 = param[6];//更新平台
		var type4 = param[7];//变更原因分类
		var text1 = param[8];//变更原因
		var text2 = param[9];//变更内容
		var type5 = param[10];//是否影响业务
		var text3 = param[11];//执行计划
		var text4 = param[12];//回退计划
		var text5 = param[13];//验证计划
		var attkey = param[14];//附件key
		var attstr = param[15];//附件显示的串
		
		
		
		//变更名称
		jQuery("input[name='prtitle']").val(title);
		//变更描述
		jQuery("input[name='prdesc']").val(desc);
		jQuery("input[name='prdesc']").prev().html(desc);
		//计划执行开始时间0108405002
		jQuery("#pidid"+pdid+"002").val(begintime);
		
		//变更类型 0108405046
		jQuery("#pidid"+pdid+"035").val(tree.split("_tree_")[1]);
		jQuery("#pidid"+pdid+"035").next().next().val(tree);
		
		//变更类别0108405046
		jQuery("#pidid"+pdid+"046").val(type1);
		//变更分类0108405065
		jQuery("#pidid"+pdid+"065").val(type2);
		//更新平台0108405063
		var str1 = null;
		var str2 = null;
		if(type3.indexOf('_') != -1){//带其他
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
		
		//变更原因分类0108405071
		jQuery("#pidid"+pdid+"071").val(type4);
		//变更原因0108405036
		jQuery("#pidid"+pdid+"036").html(text1);
		jQuery("#pidid"+pdid+"036").focus();
		//变更内容0108405037
		jQuery("#pidid"+pdid+"037").html(text2);
		jQuery("#pidid"+pdid+"037").focus();
		//是否影响业务0108405022
		jQuery("#pidid"+pdid+"022").val(type5);
		//执行计划0108405042
		jQuery("#pidid"+pdid+"042").html(text3);
		jQuery("#pidid"+pdid+"042").focus();
		//回退计划0108405043
		jQuery("#pidid"+pdid+"043").text(text4);
		jQuery("#pidid"+pdid+"043").focus();
		//验证计划0108405044
		jQuery("#pidid"+pdid+"044").text(text5);
		jQuery("#pidid"+pdid+"044").focus();
		
		var changeType = getFormObj("变更类型").value.split('-')[0];  // 变更类型表单
		getFormObj("所选变更类型").value=changeType;
		
		//如果有附件 获取附件名字和id显示在待发起页面上
		if(attkey != null && attkey !=""){
			if(attstr != null && attstr != ""){
				var str = "<div>";
				var attidArr = attstr.split("*-*")[0];
				var attnameArr = attstr.split("*-*")[1];
				//如果是多个附件 拆分,否则直接拼接
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
			//将附件key保存到隐藏表单
			jQuery("#pidid"+pdid+"072").val(attkey);
		}
		
	}
});

//获取url参数值
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
} 