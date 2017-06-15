/**
 * 功能：如果系统自动对应服务请求类型是"系统账户权限申请"时，将会自动联动出账户属性表单，该表单在发起节点为非必填
 * 配置：服务请求类型表单
 * */
function checkLaunched(){
	if(getFormObj("服务请求分类").value == ''){
		getFormObj("账户属性").parentElement.parentElement.style.display = "none"; 
	}else{
		var serversType = getFormObj("服务请求分类").value.split('-')[1];  		// 服务请求类型表单
		if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
			getFormObj("账户属性").parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj("账户属性").parentElement.parentElement.style.display = "none";
		}
	} 
}

/**
 * 功能：如果系统自动对应服务请求类型是"系统账户权限申请"时，将会自动联动出账户属性表单，该表单在发起节点为非必填
 * 配置：服务请求类型表单
 * */
function checkServers(obj){
	var serversType = obj.value.split('-')[1];  		// 服务请求类型表单
	if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
		getFormObj("账户属性").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("账户属性").parentElement.parentElement.style.display = "none";
		var tb = document.getElementById("0110001035_tableForm");
		if(tb){
			for(var i=tb.rows.length -1;i>=0;i--){
				deleteGroup(tb.rows[i]);
			}
		}
	}
}

/**
 * 功能：如果系统自动对应服务请求类型是"系统账户权限申请"时，将会自动联动出账户属性表单，该表单在发起节点为非必填
 * 配置：各节点
 * */
function checkServersType(){
	var serversType = getFormObj("服务请求分类").value.split('-')[1];  		// 服务请求类型表单
	if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
		getFormObj("账户属性").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("账户属性").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * 功能：如果系统自动对应服务请求类型是"系统账户权限申请"时，将会自动联动出账户属性表单，该表单在发起节点为非必填
 * 配置：处理节点
 * */
function checkServersTypeProcess(){
	var serversType = getFormObj("服务请求分类").value.split('-')[1];  		// 服务请求类型表单
	if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
		getFormObj("账户属性").parentElement.parentElement.style.display = ""; 
		getFormObj("HAC端授权情况").parentElement.parentElement.style.display = ""; 
	}else{
		getFormObj("账户属性").parentElement.parentElement.style.display = "none"; 
		getFormObj("HAC端授权情况").parentElement.parentElement.style.display = "none"; 
	}
	var isExport = getFormObj("是否为生产数据导出申请").value;
	if(isExport == '否'){
		getFormObj("是否需要脱敏").parentElement.parentElement.style.display = "none"; 
	}else{
		 var labelList = document.getElementsByTagName("label");
		 for(var i=0;i<labelList.length;i++){
			 var q = labelList[i].innerText;
			 if(q.indexOf("脱敏") == 4){
				 q = '*是否需要脱敏：';
			 }
		 }
	}
	
	isNeedDesensitization();
	
}

/**
 * 功能：处理人选择是否需要脱敏
 * 配置：处理节点
 * */
function Desensitization(){
	var desensitizationType = getFormObj("是否需要脱敏").value;  				// 是否需要脱敏表单
	if(desensitizationType == '是'){
		if(getFormObj("脱敏完成情况").value == ''){
			alert("请选择脱敏完成情况！");
			return false;
		}
		if(getFormObj("脱敏检查情况").value == ''){
			alert("请选择脱敏检查情况！");
			return false;
		}
		
	}
	if("系统软件类"==getFormObj("服务请求分类").value.split('_')[2]){
		var serversType = getFormObj("服务请求分类").value.split('-')[1];  		// 服务请求类型表单
		if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
			 
		}else{
			if(getFormObj("HAC端授权情况").value == ''){
				alert("请选择HAC端授权情况！");
				return false;
			}
		}
	}

	var isExport = getFormObj("是否为生产数据导出申请").value;
	if(isExport == '是'){
		if(desensitizationType == ''){
			alert("请选择是否需要脱敏！");
			return false;
		}
	}
	
	return true;
}

/**
 * 功能：“是否需要脱敏”，选择为“否”时，“脱敏完成情况”和“脱敏检查情况”，隐藏不显示，如果选择为“是”时，才显示
 * 配置：是否需要脱敏表单onchange事件和处理节点onload事件
 * */

function isNeedDesensitization(obj){
	var desensitizationType = getFormObj("是否需要脱敏").value;  				// 是否需要脱敏表单
	if(desensitizationType == '是'){
		getFormObj("脱敏完成情况").parentElement.parentElement.style.display = "";
		getFormObj("脱敏检查情况").parentElement.parentElement.style.display = "";
	}else{
		getFormObj("脱敏完成情况").parentElement.parentElement.style.display = "none";
		getFormObj("脱敏检查情况").parentElement.parentElement.style.display = "none";
	}
}

/**
 * 功能：是否需要脱敏选择‘是’，才会显示“是否需要脱敏”、“HAC端授权情况”，选择‘否’不显示这两个表单 
 * 配置：关闭节点
 * */
function checkTypeClose(obj){
	if(getFormObj("是否需要脱敏")!=undefined){
		var desensitizationType = getFormObj("是否需要脱敏").value;  				// 是否需要脱敏表单
		if(desensitizationType == '是'){
			getFormObj("脱敏完成情况").parentElement.parentElement.style.display = "";
			getFormObj("脱敏检查情况").parentElement.parentElement.style.display = "";
		}else{
			getFormObj("脱敏完成情况").parentElement.parentElement.style.display = "none";
			getFormObj("脱敏检查情况").parentElement.parentElement.style.display = "none";
		}
	}
	if(getFormObj("服务请求分类")!=undefined){
		var serversType = getFormObj("服务请求分类").value.split('-')[1];  		// 服务请求类型表单
		if(serversType== '系统账户权限申请' || serversType == '系统账户变更' || serversType == '系统账户注销'){
			getFormObj("账户属性").parentElement.parentElement.style.display = ""; 
			getFormObj("HAC端授权情况").parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj("账户属性").parentElement.parentElement.style.display = "none"; 
			getFormObj("HAC端授权情况").parentElement.parentElement.style.display = "none"; 
		}
	}
}

//初始化函数
jQuery(document).ready(function(){
	
	var psd = jQuery("#psdid");
	var flag = "";
	if(psd != null){
		//"0100101002" -> 002
		flag = psd.val().substring(7,10);
		if(flag == '001'){//待发起节点时
			//隐藏此表单
			var obj = getFormObj("隐藏附件ID");
			if(obj){
				obj.parentElement.parentElement.style.display = "none";
			}
		}
	}
	
	var params = jQuery("#parameters").val();
	if(params != null && params != ''){
		var flag = "@_@";//分隔符
		var param = params.split(flag);
		var title = param[0];//服务请求名称
		var desc = param[1];//服务请求描述
		var tree = param[2];//服务请求分类
		var type1 = param[3];//是否为生产数据导出申请
		var type2 = param[4];//影响程度
		var type3 = param[5];//紧急程度
		var attkey = param[6];//附件key
		var attstr = param[7];//附件显示的串
		
		//获取流程 版本号
		var pdid = jQuery("#pdid").val();
		//赋值
		jQuery("input[name='prtitle']").val(title);
		//pidid0110001043 服务请求描述
		jQuery("#pidid"+pdid+"043").html(desc);
		jQuery("#pidid"+pdid+"043").focus();
		//pidid0110001041 服务请求分类
		jQuery("#pidid"+pdid+"041").val(tree.split("_tree_")[1]);
		jQuery("#pidid"+pdid+"041").next().next().val(tree);
		//pidid0110001030 是否为生产数据导出申请
		jQuery("#pidid"+pdid+"030").val(type1);
		//pidid0110001007 影响程度
		jQuery("#pidid"+pdid+"007").val(type2);
		//pidid0110001006 紧急程度
		jQuery("#pidid"+pdid+"006").val(type3);
		//pidid0110001045 隐藏附件ID

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
			jQuery("#pidid"+pdid+"045").val(attkey);
		}
		
	}
});