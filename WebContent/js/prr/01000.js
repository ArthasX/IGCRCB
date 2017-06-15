/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

/**
 * 风险清单流程js方法
 * @time 2014/06/24
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */

/**
 * 功能：风险清单页面初始化
 * 配置：待发起加载js方法
 */
function valueInit(obj){
	//获取隐藏域的值
	var hiddenField = getFormObj('隐藏域').value;
	if(hiddenField != null && hiddenField.length >0){
		//去除分隔符_$_
		var contents = hiddenField.split('_$_');
		//判断contents的长度，如果大于3，则除1,2外合并
		if(contents.length > 2){
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
	return true;
}
