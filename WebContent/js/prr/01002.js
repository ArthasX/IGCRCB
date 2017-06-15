/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

/**
 * 问题整改流程js方法
 * @time 2014/06/19
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */


/**
 * 功能：整改结束时间必须大于整改开始时间
 * 配置：待发起提交按钮
 * */
function checkTime(obj){
	//获取整改开始时间和整改结束时间
	var beginTime = getFormObj('整改开始时间').value;
	var endTime = getFormObj('整改结束时间').value;
	
	//判断开始时间或者截止时间是否为空
	if("" == beginTime || "" == endTime){
		return true;
	}
	
	//如果整改开始时间大于等于整改结束时间，提示信息
	if(beginTime.localeCompare(endTime) > 0){
		alert('整改结束时间必须大于整改开始时间!');
		return false;
	}else{
		return true;
	}
}

/**
 * 功能：获取主流程的标题和描述 赋值给 问题整改标题、问题整改描述
 * 配置：待发起加载js方法
 * */
function valueTitleDesc(obj){
	//获取隐藏域的值
	var hiddenField = getFormObj('隐藏域').value;
	if(hiddenField != null && hiddenField.length >0){
		//去除分隔符_$_
		var contents = hiddenField.split('_$_');
		//判断contents的长度，如果大于3，则除1,2外合并
		if(contents.length > 3){
			for(var i=2 ;i<contents.length; i++){
				if(i < contents.length -1){
					contents[2] +=  contents[i]+'_$_';
				}else{
					contents[2] +=  contents[i];
				}
			}
		}
		//为单流程表单赋初始值
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
			//成功回调函数
			success:function(result){
				jQuery("#tbentity0100201003").find("input[asm='0100201003']").val(result.einame);
				jQuery("#tbentity0100201003").find("input[name^='entityId']").val("0100201003#" + result.eiid + "#" + result.eiversion);
				getFormObj("相关风险事件").value = "N/A";
			},
			//失败回调函数
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert("获取初始化数据异常");
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
		getFormObj("相关风险事件").value = "N/A";
	}else{
		jQuery("#tbentity0100201003").find("input[asm='0100201003']").val("");
		jQuery("#tbentity0100201003").find("input[name^='entityId']").val("");
		getFormObj("相关风险事件").value = "";
	}
}
function openFxsj(eiid){
	openSubWindow("/IGASM3203_T.do?eiid=" + eiid, "_blank", 1100, 600);
}
function deleteEntityFx(pieid){
	if(window.confirm("您是否确认删除？")){
		document.getElementById(pieid).style.display = "none";
		document.getElementById(pieid + "ENT").style.display = "none";
		document.getElementById("pieids").value = pieid;
		var tb = document.getElementById("tbentity0100201003");
		var tr = tb.insertRow();
		var td = tr.insertCell();
		td.innerHTML = '<input type="text" readonly="readonly" name="entityName[0]" asm="0100201003"/><img src="images/seek.gif" width="16" height="16" style="cursor: hand;" alt="查询" onclick="selectFxsj();"/><input type="hidden" name="entityId[0]"/><input type="hidden" name="0100201003"/>';
	}
}