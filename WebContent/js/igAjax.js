var igAjax = {
		//�����Action
		ajaxAction:"/ajax.do",
		//�Ƿ��첽	true:�첽	false:ͬ��
		asynchronous:false,
		//�ύ��ʽ	'POST'	'GET'
		method:'POST',
		//�����б�
		parameters:{},
		//�ص�����
		back:function(req, json){},
		//ִ������
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
 			//�û�Ĭ��ֵ
			igAjax.ajaxAction = "/ajax.do";
			igAjax.asynchronous = false;
			igAjax.method = 'POST';
			igAjax.parameters = {};
			igAjax.back = function(req, json){};
		}
}