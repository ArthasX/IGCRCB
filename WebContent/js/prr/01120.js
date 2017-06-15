/**
 * 功能：在审批节点，文档名称字段显示为文本
 * 配置：文档管理员审批 综合管理部负责人审批 科技部总经理审批 onload事件 
 * */
function checkNode(obj){
	//获取a标签集合
	var tagas = document.getElementsByTagName("a");
	for(var i=0;i<tagas.length;i++){
		if(tagas[i].innerHTML == '查看表单日志'){
			tagas[i-1].outerHTML = tagas[i-1].innerHTML;
		}
	}

}

/**
 * 功能：在归还节点，发起人与登录人不一致，文档名称字段显示为文本
 * 配置：归还节点
 * */
function checkIsDownLoadReturn(obj){
	var tabs = document.getElementsByTagName("table");
	var loginer = tabs[0].rows[0].cells[1].innerHTML;
	var opener = tabs[2].rows[2].cells[1].innerHTML;
	if(loginer.indexOf(opener) < 0){
		checkNode();
	}
}

/**
 * 功能：在关闭节点，发起人与登录人不一致，文档名称字段显示为文本
 * 配置：关闭节点
 * */
function checkIsDownLoadClose(obj){
	var tabs = document.getElementsByTagName("table");
	var loginer = tabs[0].rows[0].cells[1].innerHTML;
	var opener = tabs[1].rows[2].cells[1].innerHTML;
	if(loginer.indexOf(opener) < 0){
		checkNode();
	}
}
