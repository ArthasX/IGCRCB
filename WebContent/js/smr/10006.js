/*
 * 报表：T-B-7 重要信息系统情况表_11A
 */
var isValid = true;
var a = "";
var errorObjs=[];

var label_DecimalField28_COL125 = "变更情况#变更情况2#生产环境变更回退率";
var label_DecimalField28_COL126 = "灾备情况#数量（单位：个）1";

var label_YN01 = "重要信息系统管理情况#内容#核心业务系统已实施替换";
var label_YN01_1 = "重要信息系统管理情况#内容#替换时间";
var label_YN02 = "重要信息系统管理情况#内容#核心业务系统计划次年实施替换";
var label_YN02_1 = "重要信息系统管理情况#内容#计划替换时间";

var label_DecimalField1_GTZero = "数量#数量（单位：个）";
var label_DecimalField3_GTZero = "类别#数量";
var label_DecimalField10_GTZero = "保护等级#数量";
var label_DecimalField2_GTZero = "开发模式#数量（单位：个）";
var label_DecimalField4_GTZero = "运维模式#数量（单位：个）";
var label_DecimalField4_GTZero_2 = "知识产权#数量（单位：个）";
var label_DecimalField28_GTZero = "灾备情况#数量";
var label_item4 = "标题#填表日期";

var label_DecimalField16_GTZero = "灾备情况#数量（单位：个）";

/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	checkYN01(obj);
	checkYN02(obj);
}

/*
* 功能：核心业务系统已实施替换， 选择否的时候 替换时间不可输入
* 配置：重要信息系统管理情况#内容#核心业务系统已实施替换
*/
function checkYN01(obj){
	
	var obj_YN01 = getTableFormObjs(label_YN01)[0];
	var obj_YN01_1 = getTableFormObjs(label_YN01_1)[0];
	
	if(obj_YN01.value == "否"){
		obj_YN01_1.onclick = "";
		obj_YN01_1.value = "";
	}else{
		obj_YN01_1.onclick = click_columnshowDate;
	}
}

/*
* 功能：核心业务系统计划次年实施替换， 选择否的时候 计划替换时间不可输入
* 配置：重要信息系统管理情况#内容#核心业务系统计划次年实施替换
*/
function checkYN02(obj){
	
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_1 = getTableFormObjs(label_YN02_1)[0];
	
	if(obj_YN02.value == "否"){
		obj_YN02_1.onclick = "";
		obj_YN02_1.value = "";
	}else{
		obj_YN02_1.onclick = click_columnshowDate;
	}
}

/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
* 功能：点击提交时进行的表单验证
* 配置：填报状态的“提交”按钮
*/
function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	var obj_DecimalField28_COL125 = getTableFormObjs(label_DecimalField28_COL125)[0];
	checkNumFloat(obj_DecimalField28_COL125,2);

	var obj_DecimalField28_COL126 = getTableFormObjs(label_DecimalField28_COL126)[0];
	checkNumFloat(obj_DecimalField28_COL126,2); 
	
	var obj_DecimalField1_GTZero = getTableFormObjs(label_DecimalField1_GTZero);
	var obj_DecimalField3_GTZero = getTableFormObjs(label_DecimalField3_GTZero);
	
	if( parseInt(obj_DecimalField1_GTZero[0].value) >
			parseInt(obj_DecimalField3_GTZero[0].value) + parseInt(obj_DecimalField3_GTZero[1].value) +
				parseInt(obj_DecimalField3_GTZero[2].value) + parseInt(obj_DecimalField3_GTZero[3].value) +
					parseInt(obj_DecimalField3_GTZero[4].value) + parseInt(obj_DecimalField3_GTZero[5].value) +
						parseInt(obj_DecimalField3_GTZero[6].value)  ||  
		parseInt(obj_DecimalField1_GTZero[0].value) <
			parseInt(obj_DecimalField3_GTZero[0].value) + parseInt(obj_DecimalField3_GTZero[1].value) +
				parseInt(obj_DecimalField3_GTZero[2].value) + parseInt(obj_DecimalField3_GTZero[3].value) +
					parseInt(obj_DecimalField3_GTZero[4].value) + parseInt(obj_DecimalField3_GTZero[5].value) +
						parseInt(obj_DecimalField3_GTZero[6].value)){
		errorObjs.push(obj_DecimalField3_GTZero[0]);
		errorObjs.push(obj_DecimalField3_GTZero[1]);
		errorObjs.push(obj_DecimalField3_GTZero[2]);
		errorObjs.push(obj_DecimalField3_GTZero[3]);
		errorObjs.push(obj_DecimalField3_GTZero[4]);
		errorObjs.push(obj_DecimalField3_GTZero[5]);
		errorObjs.push(obj_DecimalField3_GTZero[6]);
	 	a+="重要信息系统总数＝渠道管理类+客户管理类+产品管理类+财务管理类+决策支持类+共享支持类+其他类别重要系统数校验出错！\n";
	  	isValid=false;
	}
	var obj_DecimalField10_GTZero = getTableFormObjs(label_DecimalField10_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > 
			parseInt(obj_DecimalField10_GTZero[0].value) + parseInt(obj_DecimalField10_GTZero[1].value) +
				parseInt(obj_DecimalField10_GTZero[2].value) + parseInt(obj_DecimalField10_GTZero[3].value) +
					parseInt(obj_DecimalField10_GTZero[4].value)  ||
		parseInt(obj_DecimalField1_GTZero[0].value) < 
			parseInt(obj_DecimalField10_GTZero[0].value) + parseInt(obj_DecimalField10_GTZero[1].value) +
				parseInt(obj_DecimalField10_GTZero[2].value) + parseInt(obj_DecimalField10_GTZero[3].value) +
					parseInt(obj_DecimalField10_GTZero[4].value) ){
		errorObjs.push(obj_DecimalField10_GTZero[0]);
		errorObjs.push(obj_DecimalField10_GTZero[1]);
		errorObjs.push(obj_DecimalField10_GTZero[2]);
		errorObjs.push(obj_DecimalField10_GTZero[3]);
		errorObjs.push(obj_DecimalField10_GTZero[4]);
		a+="重要信息系统总数＝保护等级 1级+保护等级2级+保护等级3级+保护等级4级+保护等级5级出错！\n";
		isValid=false;
	}
	
	var obj_DecimalField2_GTZero = getTableFormObjs(label_DecimalField2_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField2_GTZero[0].value) + 
			parseInt(obj_DecimalField2_GTZero[1].value) + parseInt(obj_DecimalField2_GTZero[2].value) || 
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField2_GTZero[0].value) + 
					parseInt(obj_DecimalField2_GTZero[1].value) + parseInt(obj_DecimalField2_GTZero[2].value)){
		errorObjs.push(obj_DecimalField2_GTZero[0]);
		errorObjs.push(obj_DecimalField2_GTZero[1]);
		errorObjs.push(obj_DecimalField2_GTZero[2]);
		
		a += "数量-重要信息系统总数=自主研发+整体外包+部分外包出错！\n";
		isValid=false;
	}
	
	var obj_DecimalField4_GTZero = getTableFormObjs(label_DecimalField4_GTZero);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField4_GTZero[0].value) +
			parseInt(obj_DecimalField4_GTZero[1].value) + parseInt(obj_DecimalField4_GTZero[2].value) ||
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField4_GTZero[0].value) +
					parseInt(obj_DecimalField4_GTZero[1].value) + parseInt(obj_DecimalField4_GTZero[2].value)){
		errorObjs.push(obj_DecimalField4_GTZero[0]);
		errorObjs.push(obj_DecimalField4_GTZero[1]);
		errorObjs.push(obj_DecimalField4_GTZero[2]);
		a+="数量-重要信息系统总数=自主运维+整体外包+部分外包出错！\n";
		isValid=false;
	}
	var obj_DecimalField4_GTZero_2 = getTableFormObjs(label_DecimalField4_GTZero_2);
	if( parseInt(obj_DecimalField1_GTZero[0].value) > parseInt(obj_DecimalField4_GTZero_2[0].value) +
			parseInt(obj_DecimalField4_GTZero_2[1].value) + parseInt(obj_DecimalField4_GTZero_2[2].value) || 
				parseInt(obj_DecimalField1_GTZero[0].value) < parseInt(obj_DecimalField4_GTZero_2[0].value) +
					parseInt(obj_DecimalField4_GTZero_2[1].value) + parseInt(obj_DecimalField4_GTZero_2[2].value)){
		errorObjs.push(obj_DecimalField4_GTZero_2[0]);
		errorObjs.push(obj_DecimalField4_GTZero_2[1]);
		errorObjs.push(obj_DecimalField4_GTZero_2[2]);
		a+="数量-重要信息系统总数=自有+共有+他有出错！\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL125.value) > 100){
		errorObjs.push(obj_DecimalField28_COL125);
		a+="变更情况-生产环境变更回退率<=100出错！\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL126.value) > 100){
		errorObjs.push(obj_DecimalField28_COL126);
		a+="灾备情况-重要信息系统灾备覆盖率<=100出错！\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL125.value) < 0){
		errorObjs.push(obj_DecimalField28_COL125);
		a+="变更情况-生产环境变更回退率>=0出错！\n";
		isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_COL126.value) < 0){
		errorObjs.push(obj_DecimalField28_COL126);
		a+="灾备情况-重要信息系统灾备覆盖率>=0出错！\n";
		isValid=false;
	}
	var obj_DecimalField28_GTZero = getTableFormObjs(label_DecimalField28_GTZero);
	if(parseInt(obj_DecimalField28_GTZero[0].value) < parseInt(obj_DecimalField28_GTZero[2].value)){
		errorObjs.push(obj_DecimalField28_GTZero[0]);
		a+="所有重要信息系统当中RTO最大值>=RTO平均值出错！\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[1].value) > parseInt(obj_DecimalField28_GTZero[2].value)){
		errorObjs.push(obj_DecimalField28_GTZero[1]);
		a+="所有重要信息系统当中RTO最小值<=RTO平均值出错！\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[3].value) < parseInt(obj_DecimalField28_GTZero[5].value)){
		errorObjs.push(obj_DecimalField28_GTZero[3]);
		a+="所有系统当中RTO最大值>=RTO平均值出错！\n";
		isValid=false;
	}
	if(parseInt(obj_DecimalField28_GTZero[4].value) > parseInt(obj_DecimalField28_GTZero[5].value)){
		errorObjs.push(obj_DecimalField28_GTZero[4]);
		a+="所有系统当中RTO最小值<=RTO平均值出错！\n";
		isValid=false;
	}
	var obj_YN01 = getTableFormObjs(label_YN01)[0];
	var obj_YN01_1 = getTableFormObjs(label_YN01_1)[0];
	var obj_item4 = getTableFormObjs(label_item4)[0];
	if(obj_YN01.value == "是" && obj_YN01_1.value.trim() == ""){
		errorObjs.push(obj_YN01_1);
		a+="核心业务系统实施替换时间不能为空！\n";
		isValid=false;
	}
	if(obj_YN01.value == "是" && obj_YN01_1.value > obj_item4.value){
		errorObjs.push(obj_YN01_1);
		a+="核心业务系统实施替换时间应应小于等于填报日期出错！\n";
		isValid=false;
	}
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_1 = getTableFormObjs(label_YN02_1)[0];
	if( obj_YN02.value == "是" && obj_YN02_1.value.trim() == ""){
		errorObjs.push(obj_YN02_1);
		a+="核心业务系统次年计划替换时间不能为空！\n";
		isValid=false;
	}
	if( obj_YN02.value == "是" && obj_YN02_1.value.trim() != "" &&obj_YN02_1.value < obj_item4.value){
		errorObjs.push(obj_YN02_1);
		a+="核心业务系统次年计划替换时间应应大于填报日期出错！\n";
		isValid=false;
	}
	
	var obj_DecimalField16_GTZero = getTableFormObjs(label_DecimalField16_GTZero);
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[2].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[2]);
		a+="灾备情况-纳入灾备的重要信息系统数>=实现数据级灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[3].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[3]);
		a+="灾备情况-纳入灾备的重要信息系统数>=实现系统级灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[4].value) ){
		errorObjs.push(obj_DecimalField16_GTZero[4]);
		a+="灾备情况-纳入灾备的重要信息系统数>=实现应用级灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[5].value)){
		errorObjs.push(obj_DecimalField16_GTZero[5]);
		a+="灾备情况-纳入灾备的重要信息系统数>=仅纳入同城灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[6].value)){
		errorObjs.push(obj_DecimalField16_GTZero[6]);
		a+="灾备情况-纳入灾备的重要信息系统数>=仅纳入异地灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[7].value)){
		errorObjs.push(obj_DecimalField16_GTZero[7]);
		a+="灾备情况-纳入灾备的重要信息系统数>=纳入同城又纳入异地灾备的出错！\n";
		isValid=false;
	}
	if( parseInt(obj_DecimalField16_GTZero[1].value) < parseInt(obj_DecimalField16_GTZero[8].value)){
		errorObjs.push(obj_DecimalField16_GTZero[8]);
		a+="灾备情况-纳入灾备的重要信息系统数>=采用高可用技术的出错！\n";
		isValid=false;
	}
	
	if (!isValid && a > "") {
		for(var i=0 ;i<errorObjs.length;i++) {
			if (errorObjs[i].outerHTML.indexOf("TD") > -1) {
				errorObjs[i].style.color="red";
			} else {
				errorObjs[i].style.backgroundColor="red";
			}
		}
		alert(a);
		a = "";
		isValid = true;
		return false;
	}
	return isValid;
}