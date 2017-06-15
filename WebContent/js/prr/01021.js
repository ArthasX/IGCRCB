/**
 * 功能：如果系统自动对应服务请求类型是"系统账户权限申请"时，将会自动联动出账户属性表单，该表单在发起节点为非必填
 * 配置：处理节点
 * */
function checkQuestionResource(){
	if(document.readyState === "complete"){
		getFormObj('监管机构名称').parentElement.parentElement.style.display = "none";
		var name = getFormObj('检查来源').value;  		// 服务请求类型表单
		if(name!=null && name=='其他监管机构'){
			getFormObj('监管机构名称').parentElement.parentElement.style.display = ""; 
		}else{
			getFormObj('监管机构名称').parentElement.parentElement.style.display = "none";
			getFormObj('监管机构名称').parentElement.parentElement.style.width = "200";
		}
	}else{
		//setTimeout(checkQuestionResource(), 500);
	}
}
checkQuestionResource();

//初始化函数
jQuery(document).ready(function(){
	checkQuestionResource();
});
