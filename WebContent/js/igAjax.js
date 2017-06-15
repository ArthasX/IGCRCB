var igAjax = {
		//请求的Action
		ajaxAction:"/ajax.do",
		//是否异步	true:异步	false:同步
		asynchronous:false,
		//提交方式	'POST'	'GET'
		method:'POST',
		//参数列表
		parameters:{},
		//回调函数
		back:function(req, json){},
		//执行请求
		doAjax:function(){
			var parStr = "";
			for(var key in igAjax.parameters){
				parStr += key + "=" + igAjax.parameters[key] + "&";
			}
			if(parStr.length>0){
				parStr = parStr.substring(0,parStr.length-1);
			}
 			var objAjax = new Ajax.Request(getAppRootUrl() + igAjax.ajaxAction,{asynchronous:igAjax.asynchronous, method:igAjax.method,
 				parameters: parStr,
 				onSuccess:igAjax.back
 				});
 			//置回默认值
			igAjax.ajaxAction = "/ajax.do";
			igAjax.asynchronous = false;
			igAjax.method = 'POST';
			igAjax.parameters = {};
			igAjax.back = function(req, json){};
		}
}