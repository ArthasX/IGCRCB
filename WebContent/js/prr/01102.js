/**
 * 功能：如果是否需要测试表单值为“需要测试”，TR属性改为显示；否则，隐藏该TR属性
 * 配置：是否需要测试表单调用js
 * */
function checkTestWay(obj){
	var changeType = getFormObj("是否需要测试").value;
	if(changeType == '需要测试'){
		getFormObj("测试方式").parentElement.parentElement.style.display = "block"; 
	}else{
		getFormObj("测试方式").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * 功能：如果是否需要测试表单值为“需要测试”，TR属性改为显示；否则，隐藏该TR属性
 * 配置：关闭节点调用js
 * */
function checkTestClose(){
	var changeType = getFormObj("是否需要测试").value;
	if(changeType == '需要测试'){
		getFormObj("测试方式").parentElement.parentElement.style.display = "block"; 
	}else{
		getFormObj("测试方式").parentElement.parentElement.style.display = "none"; 
	}
}

/**
 * 功能：发起节点校验
 * */
function checkTestSubmit(){
	var changeType = getFormObj("是否需要测试").value;
	if(changeType == '需要测试'){
		var testType = getFormObj("测试方式").value;  			// 测试方式
		if(testType == ''){
			alert("请选择测试方式！");
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

/**
 * 功能：加载的时候，将测试方式表单隐藏
 * 配置：初始化调用js
 * */
function checkHideTestWay(obj){
	var changeType = getFormObj("是否需要测试").value;
	if("需要测试" != changeType){
		getFormObj("测试方式").parentElement.parentElement.style.display = "none"; 
		getFormObj("环境部署").parentElement.parentElement.style.display = "none"; 
		getFormObj("普通测试结果").parentElement.parentElement.style.display = "none"; 
		getFormObj("UAT测试结果").parentElement.parentElement.style.display = "none"; 
	}else{
		getFormObj("测试方式").parentElement.parentElement.style.display = ""; 
		getFormObj("环境部署").parentElement.parentElement.style.display = ""; 
		getFormObj("普通测试结果").parentElement.parentElement.style.display = ""; 
		getFormObj("UAT测试结果").parentElement.parentElement.style.display = ""; 
	}
}


function formJoinMove(){
	//if(getFormObj("普通测试").checked==true){
	var type = getFormObj("测试方式").value.split("#");
	if(type == null || type == ""){
		alert("请选择对应测试结果");
		return false;
	}
	if(type.length == 1){
		if(type == "普通测试"){
			var str = getFormObj("普通测试结果").value;
			if(str == null || str == ""){
				alert("请选择普通测试结果");
				return false;
			}
		}
		else{
			var str = getFormObj("UAT测试结果").value;
			if(str = null || str == ""){
				alert("请选择UAT测试结果");
				return false;
			}
		}
		
	}
	else{
		var str = getFormObj("普通测试结果").value;
		if(str == null || str == ""){
			alert("请选择普通测试结果");
			return false;
		}
		str = getFormObj("UAT测试结果").value;
		if(str = null || str == ""){
			alert("请选择UAT测试结果");
			return false;
		}
	}
	return true;
}

/**
 * 功能：整改结束时间必须大于整改开始时间
 * 配置：待发起提交按钮
 * */
function checkTime(){
	//获取整改开始时间和整改结束时间
	var beginTime = getFormObj('计划执行开始时间').value;
	var endTime = getFormObj('计划执行结束时间').value;
	var changeType = getFormObj("是否需要测试").value;
	//判断开始时间或者截止时间是否为空
	if("" == beginTime || "" == endTime){
		return true;
	}
	
	//如果整改开始时间大于等于整改结束时间，提示信息
	if(beginTime.localeCompare(endTime) > 0){
		alert('计划执行结束时间必须大于计划执行开始时间!');
		return false;
	}else if(changeType == '需要测试'){
		var testType = getFormObj("测试方式").value;  			// 测试方式
		if(testType == ''){
			alert("请选择测试方式！");
			return false;
		}else{
			return true;
		}
	}else{
		return true;
	}
}

/** -----------------------版本2-----------------------  */
/**
 * 功能：如果是否需要测试表单值为“需要测试”，TR属性改为显示；否则，隐藏该TR属性
 * 配置：是否需要测试表单调用js
 * */
function checkTestWay2(obj){
}

/**
 * 功能：如果是否需要测试表单值为“需要测试”，TR属性改为显示；否则，隐藏该TR属性
 * 配置：关闭节点调用js
 * */
function checkTestClose2(){
}

/**
 * 功能：发起节点校验
 * */
function checkTestSubmit2(){
}

/**
 * 功能：加载的时候，将测试方式表单隐藏
 * 配置：初始化调用js
 * */
function checkHideTestWay2(){
}


function formJoinMove2(){
	return true;
}

/**
 * 功能：整改结束时间必须大于整改开始时间
 * 配置：待发起提交按钮
 * */
function checkTime2(){
	//获取整改开始时间和整改结束时间
	var beginTime = getFormObj('计划执行开始时间').value;
	var endTime = getFormObj('计划执行结束时间').value;
	//如果整改开始时间大于等于整改结束时间，提示信息
	if(beginTime.localeCompare(endTime) > 0){
		alert('计划执行结束时间必须大于计划执行开始时间!');
		return false;
	}else{
		return true;
	}
}
function init_001(){
	var parprid = document.getElementById("parprid").value;
	if(parprid != ""){
		var params= {};
		params.parprid = parprid;
		
		//ajax请求数据
		jQuery.ajax({
			url:"IGCRC1005_GetParent.do",
			type:"POST",
			dataType :"json",
			data:params,
			cache:false,
			//成功回调函数
			success:function(data){
				if(data.type == "success"){
					document.getElementById("prtitle").value = data.prtitle;
//					document.getElementById("prdesc").value = data.prdesc;
				}
			},
			//失败回调函数
			error:function(XMLHttpRequest, textStatus, errorThrown){
				//alert("获取检查项数据异常");
			}
		});
	}
}

jQuery(document).ready(function(){
	//日志信息 默认展示
	var path=jQuery("#loginfo").attr("src");
	if(path=="images/redu.gif"){
		jQuery("#loginfo").attr("src","images/addd.gif");
		jQuery("#TabbedPanels1").toggle();
	}else{
		jQuery("#loginfo").attr("src","images/redu.gif");
		jQuery("#TabbedPanels1").toggle();
	}
		
});
