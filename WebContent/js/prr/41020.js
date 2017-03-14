function initSet(obj){
	if(obj!=null&&obj.value>5){
		alert("评分分数不能大于5");
		obj.value="";
	}
}

/**
 * 功能：评估打分节点的每项评分备注不能大于170个汉字
 * 配置：评估打分按钮
 * */

function checkTextArea(){
	var textareas = document.getElementsByTagName("textarea");
	for(var i = 0; i < textareas.length - 1; i++){
		if(textareas[i].value.length > 512){
			alert("第"+(i+1)+"评估项的备注信息不能大于"+Math.floor(512/strByteFlag)+"个汉字");
			return false;
		}
	}
	return true;
}