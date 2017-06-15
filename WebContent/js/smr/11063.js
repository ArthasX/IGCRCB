/*
 * 报表：2014 T-B-6 信息科技开发测试管理情况表——报表填报
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];
//软件开发项目情况
var label_YN01_01 = "软件开发项目情况#内容#本年度软件开发项目总数";
var label_YN01_02 = "软件开发项目情况#内容#其中：已完成的软件开发项目总数";
var label_YN01_03 = "软件开发项目情况#内容#软件开发重大项目数";
var label_YN01_04 = "软件开发项目情况#内容#自主开发项目数";
var label_YN01_05 = "软件开发项目情况#内容#部分外包开发项目数";
var label_YN01_06 = "软件开发项目情况#内容#完全外包开发项目数";
var label_YN01_07 = "软件开发项目情况#内容#本年度软件开发项目工作量";
var label_YN01_08 = "软件开发项目情况#内容#其中：自主开发工作量";
var label_YN01_09 = "软件开发项目情况#内容#外包开发工作量";
//项目管理
var label_YN02_01 = "项目管理#内容#机构已建立专门的信息科技项目管理组织";
var label_YN02_02 = "项目管理#内容#组织名称";
var label_YN02_03 = "项目管理#内容#机构信息科技相关部门通过软件开发能力成熟度认证";
var label_YN02_04 = "项目管理#内容#如是，认证名称（级别）";
var label_YN02_05 = "项目管理#内容#通过认证的部门名称";
var label_YN02_07 = "项目管理#内容#信息科技审计人员或信息安全人员参加软件开发重大项目评审";
var label_YN02_08 = "项目管理#内容#参加评审的软件开发重大项目数量";
var label_YN02_09 = "项目管理#内容#项目投产后，组织业务部门对软件开发重大项目进行后评价";
var label_YN02_10 = "项目管理#内容#本年度组织业务部门进行后评价的软件开发重大项目数量";
//开发管理
var label_YN03_01 = "开发管理#内容#制定和发布统一的软件开发规范";
var label_YN03_02 = "开发管理#内容#发布时间";
var label_YN03_03 = "开发管理#内容#建立软件开发规范定期修订机制";
var label_YN03_04 = "开发管理#内容#最近一次修订并发布的时间";
var label_YN03_06 = "开发管理#内容#制定和发布统一的代码安全设计规范";
var label_YN03_07 = "开发管理#内容#发布时间:";
var label_YN03_08 = "开发管理#内容#建立代码安全设计规范定期修订机制";
var label_YN03_09 = "开发管理#内容#最近一次修订并发布的时间:";
//测试管理
var label_YN04_01 = "测试管理#内容#制定和发布统一的测试规范";
var label_YN04_02 = "测试管理#内容#发布时间";
var label_YN04_03 = "测试管理#内容#建立测试规范定期修订机制";
var label_YN04_04 = "测试管理#内容#最近一次修订并发布的时间";
var label_YN04_05 = "测试管理#内容#开展源代码安全检查";
var label_YN04_06 = "测试管理#内容#如是，安全检查方式";
//版本管理
var label_YN05_01 = "版本管理#内容#制定和发布统一的软件版本管理规范";
var label_YN05_02 = "版本管理#内容#发布时间";
var label_YN05_03 = "版本管理#内容#建立软件版本管理规范定期修订机制";
var label_YN05_04 = "版本管理#内容#最近一次修订并发布的时间";
var label_YN05_05 = "版本管理#内容#设立专职的软件版本管理团队（组织）";
var label_YN05_06 = "版本管理#内容#团队（组织）名称";
//投产管理
var label_YN06_01 = "投产管理#内容#制定和发布统一的项目投产管理规范";
var label_YN06_02 = "投产管理#内容#发布时间";
var label_YN06_03 = "投产管理#内容#建立项目投产管理规范定期修订机制";
var label_YN06_04 = "投产管理#内容#最近一次修订并发布的时间";
//附件
var label_YN07_01 = "附件#内容#内容1#附件索引";
var label_YN07_02 = "附件#内容#内容2#附件索引";
var label_YN07_03 = "附件#内容#内容3#附件索引";
var label_YN07_04 = "附件#内容#内容4#附件索引";
/*
 * 提交校验数据
 */
function checkData(){
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";	
	}
	errorObjs = [];
	
	//项目管理校验
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_01.rownumber);
	if(obj_YN02_01.value == "是" && obj_YN02_02.value == ""){
		errorObjs.push(obj_YN02_02);
		a += "项目管理：组织名称不能为空！\n";
		isValid = false;
	}
	
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_03.rownumber);
	var obj_YN02_05 = getTableFormObj(label_YN02_05,obj_YN02_03.rownumber);
	if(obj_YN02_03.value == "是" && obj_YN02_04.value == ""){
		errorObjs.push(obj_YN02_04);
		a += "项目管理：认证名称（级别）不能为空！\n";
		isValid = false;
	}
	if(obj_YN02_03.value == "是" && obj_YN02_05.value == ""){
		errorObjs.push(obj_YN02_05);
		a += "项目管理：通过认证的部门名称不能为空！\n";
		isValid = false;
	}
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	var obj_YN02_08 = getTableFormObj(label_YN02_08,obj_YN02_07.rownumber);
	if(obj_YN02_07.value == "是" && obj_YN02_08.value == ""){
		errorObjs.push(obj_YN02_08);
		a += "项目管理：参加评审的软件开发重大项目数量不能为空！\n";
		isValid = false;
	}
	
	var obj_YN02_09 = getTableFormObjs(label_YN02_09)[0];
	var obj_YN02_10 = getTableFormObj(label_YN02_10,obj_YN02_09.rownumber);
	if(obj_YN02_09.value == "是" && obj_YN02_10.value == ""){
		errorObjs.push(obj_YN02_10);
		a += "项目管理：本年度组织业务部门进行后评价的软件开发重大项目数量不能为空！\n";
		isValid = false;
	}

	//开发管理校验
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03_01.rownumber);
	if(obj_YN03_01.value == "是" && obj_YN03_02.value == ""){
		errorObjs.push(obj_YN03_02);
		a += "开发管理：发布时间不能为空！\n";
		isValid = false;
	}
	
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_03.rownumber);
	if(obj_YN03_03.value == "是" && obj_YN03_04.value == ""){
		errorObjs.push(obj_YN03_04);
		a += "开发管理：最近一次修订并发布的时间不能为空！\n";
		isValid = false;
	}
	
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03_06.rownumber);
	if(obj_YN03_06.value == "是" && obj_YN03_07.value == ""){
		errorObjs.push(obj_YN03_07);
		a += "开发管理：发布时间不能为空！\n";
		isValid = false;
	}

	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "是" && obj_YN03_09.value == ""){
		errorObjs.push(obj_YN03_09);
		a += "开发管理：最近一次修订并发布的时间不能为空！\n";
		isValid = false;
	}
	//测试管理
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02,obj_YN04_01.rownumber);
	if(obj_YN04_01.value == "是" && obj_YN04_02.value == ""){
		errorObjs.push(obj_YN04_02);
		a += "测试管理：发布时间不能为空！\n";
		isValid = false;
	}
	
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN04_03.rownumber);
	if(obj_YN04_03.value == "是" && obj_YN04_04.value == ""){
		errorObjs.push(obj_YN04_04);
		a += "测试管理：最近一次修订并发布的时间不能为空！\n";
		isValid = false;
	}

	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06,obj_YN04_05.rownumber);
	if(obj_YN04_05.value == "是" && obj_YN04_06.value == ""){
		errorObjs.push(obj_YN04_06);
		a += "测试管理：安全检查方式不能为空！\n";
		isValid = false;
	}
	//版本管理
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02,obj_YN05_01.rownumber);
	if(obj_YN05_01.value == "是" && obj_YN05_02.value == ""){
		errorObjs.push(obj_YN05_02);
		a += "版本管理：发布时间不能为空！\n";
		isValid = false;
	}

	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04,obj_YN05_03.rownumber);
	if(obj_YN05_03.value == "是" && obj_YN05_04.value == ""){
		errorObjs.push(obj_YN05_04);
		a += "版本管理：最近一次修订并发布的时间不能为空！\n";
		isValid = false;
	}
	
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	var obj_YN05_06 = getTableFormObj(label_YN05_06,obj_YN05_05.rownumber);
	if(obj_YN05_05.value == "是" && obj_YN05_06.value == ""){
		errorObjs.push(obj_YN05_06);
		a += "版本管理：团队（组织）名称不能为空！\n";
		isValid = false;
	}
	//投产管理
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02,obj_YN06_01.rownumber);
	if(obj_YN06_01.value == "是" && obj_YN06_02.value == ""){
		errorObjs.push(obj_YN06_02);
		a += "投产管理：发布时间不能为空！\n";
		isValid = false;
	}
	
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "是" && obj_YN06_04.value == ""){
		errorObjs.push(obj_YN06_04);
		a += "投产管理：最近一次修订并发布的时间不能为空！\n";
		isValid = false;
	}
	//软件开发项目情况校验

	
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObjs(label_YN01_02)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObjs(label_YN01_05)[0];
	var obj_YN01_06 = getTableFormObjs(label_YN01_06)[0];
	var obj_YN01_07 = getTableFormObjs(label_YN01_07)[0];
	var obj_YN01_08 = getTableFormObjs(label_YN01_08)[0];
	var obj_YN01_09 = getTableFormObjs(label_YN01_09)[0];
	if(obj_YN01_01.value != (parseInt(obj_YN01_04.value)+parseInt(obj_YN01_05.value)+parseInt(obj_YN01_06.value))){
		errorObjs.push(obj_YN01_04);
		errorObjs.push(obj_YN01_05);
		errorObjs.push(obj_YN01_06);
		a+="软件开发项目情况：本年度软件开发项目总数 应等于 自主开发项目数+部分外包开发项目数+完全外包开发项目数！\n";
		isValid = false;
	}
	if(obj_YN01_07.value != (parseInt(obj_YN01_08.value)+parseInt(obj_YN01_09.value))){
		errorObjs.push(obj_YN01_08);
		errorObjs.push(obj_YN01_09);
		a+="软件开发项目情况：本年度软件开发项目工作量 应等于 自主开发工作量＋外包开发工作量！\n";
		isValid = false;
	}
	
	var obj_YN02_08 = getTableFormObjs(label_YN02_08)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN02_08Value = 0;
	if(obj_YN02_08.value != ""){
		obj_YN02_08Value = obj_YN02_08.value;
	}
	if(parseFloat(obj_YN02_08Value) > parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN02_08);
		errorObjs.push(obj_YN01_03);
		a+="项目管理：参加评审的软件开发重大项目数量 应小于等于 本年度软件开发项目总数中重大项目数量！\n";
		isValid=false;
	}
	
	var obj_YN02_10 = getTableFormObjs(label_YN02_10)[0];
	var obj_YN01_03 = getTableFormObjs(label_YN01_03)[0];
	var obj_YN02_10Value = 0;
	if(obj_YN02_10.value != ""){
		obj_YN02_10Value = obj_YN02_10.value;
	}
	if(parseFloat(obj_YN02_10Value) > parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN02_10);
		errorObjs.push(obj_YN01_03);
		a+="项目管理：本年度组织业务部门进行后评价的软件开发重大项目数 应小于等于 本年度软件开发项目总数中重大项目数量！\n";
		isValid=false;
	}
	
	if(parseFloat(obj_YN01_01.value) < parseFloat(obj_YN01_02.value)){
		errorObjs.push(obj_YN01_02);
		a+="软件开发项目情况：本年度软件开发项目总数 应大于等于 已完成的软件开发项目总数！\n";
		isValid=false;
	}
	if(parseFloat(obj_YN01_01.value) < parseFloat(obj_YN01_03.value)){
		errorObjs.push(obj_YN01_03);
		a+="软件开发项目情况：本年度软件开发项目总数 应大于等于 软件开发重大项目数！\n";
		isValid=false;
	}
	//附件校验
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];
	var obj_YN07_03 = getTableFormObjs(label_YN07_03)[0];
	var obj_YN07_04 = getTableFormObjs(label_YN07_04)[0];
	if(obj_YN07_01.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="附件：信息科技项目管理明细报告不能为空！\n";
		isValid=false;
	}
	if(obj_YN07_02.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="附件：软件开发规范和源代码安全设计规范不能为空！\n";
		isValid=false;
	}
	if(obj_YN07_03.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="附件：软件版本管理规范不能为空！\n";
		isValid=false;
	}
	if(obj_YN07_04.value == ""){
		errorObjs.push(obj_YN07_01);
		a+="附件：项目投产管理规范不能为空！\n";
		isValid=false;
	}

	if (!isValid && a > "") {
		for ( var i = 0; i < errorObjs.length; i++) {
			if (errorObjs[i].previousSibling == null ) {
				errorObjs[i].style.backgroundColor = "red";
			}else if(errorObjs[i].previousSibling.innerHTML.indexOf("其他")>-1){
				errorObjs[i].style.backgroundColor = "red";
			} else {
				errorObjs[i].parentNode.style.color = "red";
			}
		}
		alert(a);
		a = "";
		isValid = true;
		return false;
	}
	return isValid;
}

/*
 * 功能：通过制定和发布统一的项目投产管理规范决定发布时间只读和可填
 * 配置：版本管理#内容#建立软件版本管理规范定期修订机制
 */
function setYN06_04Disable(obj){
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04,obj_YN06_03.rownumber);
	if(obj_YN06_03.value == "否" || obj_YN06_03.value == ""){
		//只读
		obj_YN06_04.onclick = "";
		//清空
		obj_YN06_04.value = "";
	}else if(obj_YN06_03.value == "是"){
		obj_YN06_04.onclick = click_columnshowDate;
	}
}
/*
 * 功能：通过制定和发布统一的项目投产管理规范决定发布时间只读和可填
 * 配置：版本管理#内容#建立软件版本管理规范定期修订机制
 */
function setYN06_02Disable(obj){
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	var obj_YN06_02 = getTableFormObj(label_YN06_02,obj_YN06_01.rownumber);
	if(obj_YN06_01.value == "否" ||obj_YN06_01.value == ""){
		//只读
		obj_YN06_02.onclick = "";
		//清空
		obj_YN06_02.value = "";
	}else if(obj_YN06_01.value == "是"){
		obj_YN06_02.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过组织业务部门对软件开发重大项目进行后评价来决定本年度组织业务部门进行后评价的软件开发重大项目数量只读和可填
 * 配置：项目管理#内容#项目投产后，组织业务部门对软件开发重大项目进行后评价
 */
function setYN05_06Disable(obj){
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	var obj_YN05_06 = getTableFormObj(label_YN05_06,obj_YN05_05.rownumber);
	if(obj_YN05_05.value == "否" || obj_YN05_05.value == ""){
		//只读
		obj_YN05_06.readOnly = "readonly";
		//清空
		obj_YN05_06.value = "";
	}else if(obj_YN05_05.value == "是"){
		obj_YN05_06.readOnly = "";
	}
}

/*
 * 功能：通过建立软件版本管理规范定期修订机制决定最近一次修订并发布的时间只读和可填
 * 配置：版本管理#内容#建立软件版本管理规范定期修订机制
 */
function setYN05_04Disable(obj){
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04,obj_YN05_03.rownumber);
	if(obj_YN05_03.value == "否" || obj_YN05_03.value == ""){
		//只读
		obj_YN05_04.onclick = "";
		//清空
		obj_YN05_04.value = "";
	}else if(obj_YN05_03.value == "是"){
		obj_YN05_04.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过制定和发布统一的软件版本管理规范决定发布时间只读和可填
 * 配置：版本管理#内容#制定和发布统一的软件版本管理规范
 */
function setYN05_02Disable(obj){
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObj(label_YN05_02,obj_YN05_01.rownumber);
	if(obj_YN05_01.value == "否" || obj_YN05_01.value == ""){
		//只读
		obj_YN05_02.onclick = "";
		//清空
		obj_YN05_02.value = "";
	}else if(obj_YN05_01.value == "是"){
		obj_YN05_02.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过开展源代码安全检查决定如是，安全检查方式只读和可填
 * 配置：测试管理#内容#开展源代码安全检查
 */
function setYN_04_06Disable(obj){
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_06 = getTableFormObj(label_YN04_06,obj_YN04_05.rownumber);
	if(obj_YN04_05.value == "否" || obj_YN04_05.value == ""){
		//只读
		columnVallueRadio1(obj_YN04_06,false,false);
		//清空
		obj_YN04_06.value = "";
	}else if(obj_YN04_05.value == "是"){
		columnVallueRadio1(obj_YN04_06,true,false);
	}
}

/*
 * 功能：通过建立测试规范定期修订机制决定最近一次修订并发布的时间只读和可填
 * 配置：开发管理#内容#建立代码安全设计规范定期修订机制
 */
function setYN_04_04Disable(obj){
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_04 = getTableFormObj(label_YN04_04,obj_YN04_03.rownumber);
	if(obj_YN04_03.value == "否" || obj_YN04_03.value == ""){
		//只读
		obj_YN04_04.onclick = "";
		//清空
		obj_YN04_04.value = "";
	}else if(obj_YN04_03.value == "是"){
		obj_YN04_04.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过制定和发布统一的测试规范来决定发布时间只读和可填
 * 配置：测试管理#内容#制定和发布统一的测试规范
 */
function setYN_04_02Disable(obj){
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_02 = getTableFormObj(label_YN04_02,obj_YN04_01.rownumber);
	if(obj_YN04_01.value == "否" || obj_YN04_01.value == ""){
		//只读
		obj_YN04_02.onclick = "";
		//清空
		obj_YN04_02.value = "";
	}else if(obj_YN04_01.value == "是"){
		obj_YN04_02.onclick = click_columnshowDate;
	}
}
/*
 * 功能：通过建立代码安全设计规范定期修订机制来决定最近一次修订并发布的时间:只读和可填
 * 配置：开发管理#内容#建立代码安全设计规范定期修订机制
 */
function setYN_03_09Disable(obj){
	var obj_YN03_08 = getTableFormObjs(label_YN03_08)[0];
	var obj_YN03_09 = getTableFormObj(label_YN03_09,obj_YN03_08.rownumber);
	if(obj_YN03_08.value == "否" || obj_YN03_08.value == ""){
		//只读
		obj_YN03_09.onclick = "";
		//清空
		obj_YN03_09.value = "";
	}else if(obj_YN03_08.value == "是"){
		obj_YN03_09.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过制定和发布统一的代码安全设计规范来决定发布时间:只读和可填
 * 配置：开发管理#内容#建立软件开发规范定期修订机制
 */
function setYN_03_07Disable(obj){
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03_06.rownumber);
	if(obj_YN03_06.value == "否" || obj_YN03_06.value == ""){
		//只读
		obj_YN03_07.onclick = "";
		//清空
		obj_YN03_07.value = "";
	}else if(obj_YN03_06.value == "是"){
		obj_YN03_07.onclick = click_columnshowDate;
	}
}

/*
 * 功能：通过建立软件开发规范定期修订机制来决定最近一次修订并发布的时间只读和可填
 * 配置：开发管理#内容#建立软件开发规范定期修订机制
 */
function setYN_03_04Disable(obj){
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_03.rownumber);
	if(obj_YN03_03.value == "否" || obj_YN03_03.value == ""){
		//只读
		obj_YN03_04.onclick = "";
		//清空
		obj_YN03_04.value = "";
	}else if(obj_YN03_03.value == "是"){
		obj_YN03_04.onclick = click_columnshowDate;
	}
}
/*
 * 功能：通过制定和发布统一的软件开发规范来决定发布时间只读和可填
 * 配置：开发管理#内容#制定和发布统一的软件开发规范
 */
function setYN_03_02Disable(obj){
	var obj_YN03_01 = getTableFormObjs(label_YN03_01)[0];
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03_01.rownumber);
	if(obj_YN03_01.value == "否" || obj_YN03_01.value == ""){
		//只读
		obj_YN03_02.onclick = "";
		//清空
		obj_YN03_02.value = "";
	}else if(obj_YN03_01.value == "是"){
		obj_YN03_02.onclick = click_columnshowDate;
	}
}
/*
 * 功能：通过组织业务部门对软件开发重大项目进行后评价来决定本年度组织业务部门进行后评价的软件开发重大项目数量只读和可填
 * 配置：项目管理#内容#项目投产后，组织业务部门对软件开发重大项目进行后评价
 */
function setYN_02_10Disable(obj){
	var obj_YN02_09 = getTableFormObjs(label_YN02_09)[0];
	var obj_YN02_10 = getTableFormObj(label_YN02_10,obj_YN02_09.rownumber);
	if(obj_YN02_09.value == "否" || obj_YN02_09.value == ""){
		//只读
		obj_YN02_10.readOnly = "readonly";
		//清空
		obj_YN02_10.value = "";
	}else if(obj_YN02_09.value == "是"){
		obj_YN02_10.readOnly = "";
	}
}
/*
 * 功能：通过信息科技审计人员或信息安全人员参加软件开发重大项目评审来决定参加评审的软件开发重大项目数量只读和可填
 * 配置：项目管理#内容#信息科技审计人员或信息安全人员参加软件开发重大项目评审
 */
function setYN_02_08Disable(obj){
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	var obj_YN02_08 = getTableFormObj(label_YN02_08,obj_YN02_07.rownumber);
	if(obj_YN02_07.value == "否" || obj_YN02_07.value == ""){
		//只读
		obj_YN02_08.readOnly = "readonly";
		//清空
		obj_YN02_08.value = "";
	}else if(obj_YN02_07.value == "是"){
		obj_YN02_08.readOnly = "";
	}
}
/*
 * 功能：通过机构信息科技相关部门通过软件开发能力成熟度认证来决定如是，认证名称（级别）和通过认证的部门名称只读和可写
 * 配置：项目管理#内容#机构信息科技相关部门通过软件开发能力成熟度认证
 */
function setYN02_03And04Disable(obj){
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02_03.rownumber);
	var obj_YN02_05 = getTableFormObj(label_YN02_05,obj_YN02_03.rownumber);
	if(obj_YN02_03.value == "否" || obj_YN02_03.value == ""){
		//只读
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_05.readOnly = "readonly";
		//清空
		obj_YN02_04.value = "";
		obj_YN02_05.value = "";
	}else if(obj_YN02_03.value == "是"){
		obj_YN02_04.readOnly = "";
		obj_YN02_05.readOnly = "";
	}
}
/*
 * 功能：通过机构已建立专门的信息科技项目管理组织来决定组织名称只读和可写
 * 配置：项目管理#内容#机构已建立专门的信息科技项目管理组织
 */
function setYN02_02Disable(obj){
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02_01.rownumber);
	if(obj_YN02_01.value == "否" || obj_YN02_01.value == ""){
		//只读
		obj_YN02_02.readOnly = "readonly";
		//清空
		obj_YN02_02.value = "";
	}else if(obj_YN02_01.value == "是"){
		obj_YN02_02.readOnly = "";
	}
}
/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
}
/*
 *功能：单选按钮的读写设置
 *参数：obj为单选对象
 *	  access当单选可被选时传true，不可被选时传false
 *	  flag 为是否添加特殊函数调用
 */
function columnVallueRadio1(obj,access,flag){
	if(!access){
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
					if(!access){
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					}else{
						if(!flag){
							imgs[k].onclick = function(){
								columnVallueRadio(this);
							};
						}else{
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								setYN10_05Disable(this);
							};
						}
					}
				}
			}
		}
	}
}
/*
 * 初始化
 */
function initSet(){
	setYN06_04Disable(obj);
	setYN06_02Disable(obj);
	setYN05_06Disable(obj);
	setYN05_04Disable(obj);
	setYN05_02Disable(obj);
	setYN_04_06Disable(obj);
	setYN_04_04Disable(obj);
	setYN_04_02Disable(obj);
	setYN_03_09Disable(obj);
	setYN_03_07Disable(obj);
	setYN_03_04Disable(obj);
	setYN_03_02Disable(obj);
	setYN_02_10Disable(obj);
	setYN_02_08Disable(obj);
	setYN02_03And04Disable(obj);
	setYN02_02Disable(obj);
}
