/**
 * 功能：提示文档名称最多输入40个中文，文档描述最多输入80个中文
 * 配置：文档入库待发起节点
 * */
function docPrompt(obj){
	getFormObj("文档名称").insertAdjacentHTML("afterEnd","<span style=\"color:#bb0500\">(最多输入40个汉字)</span>");
	getFormObj("文档描述").insertAdjacentHTML("afterEnd","<span style=\"color:#bb0500\">(最多输入80个汉字)</span>");
}

/**
 * 功能：判断文档名称最多输入40个中文，文档描述最多输入80个中文,如果超长提示
 * 配置：文档入库待发起节点提交按钮
 * */
function docsubmit(obj){
	if(getFormObj("文档名称").value.length > 40){
		alert("文档名称最多输入40个汉字");
		return false;
	}
	if(document.getElementsByName("pivarvalue[1]")[0].value.length > 80){
		alert("文档描述最多输入80个汉字");
		return false;
	}
	
	return true;
}
