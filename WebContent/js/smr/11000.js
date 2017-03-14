/*
 * 报表：2014 -T-B-1 信息科技治理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN02 = "信息科技管理委员会#内容#设立信息科技管理委员会";
var label_YN02_01 = "信息科技管理委员会#内容#组织名称";
var label_YN02_02 = "信息科技管理委员会#内容#成立日期";
var label_YN02_03 = "信息科技管理委员会#内容#负责人";
var label_YN02_04 = "信息科技管理委员会#内容#职务";
var label_YN02_06 = "信息科技管理委员会#内容#信息科技管理委员会总人数";
var label_YN02_07 = "信息科技管理委员会#内容#其中，信息科技管理委员会中非信息科技部门人员数";
var label_YN02_08 = "信息科技管理委员会#内容#本年度信息科技管理委员会全体会议次数";
var label_YN02_09 = "信息科技管理委员会#内容#已制定并印发信息科技管理委员会议事规则";	

var label_YN03 = "首席信息官(CIO)#内容#设立首席信息官";
var label_YN03_01 = "首席信息官(CIO)#内容#姓名";
var label_YN03_02 = "首席信息官(CIO)#内容#履职起始日期";
var label_YN03_03 = "首席信息官(CIO)#内容#首席信息官纳入高级管理层";
var label_YN03_04 = "首席信息官(CIO)#内容#首席信息官兼任其他职务";
var label_YN03_05 = "首席信息官(CIO)#内容#兼任职务";
var label_YN03_06 = "首席信息官(CIO)#内容#首席信息官在机构内部通过书面方式正式任职首席信息官岗位";
var label_YN03_07 = "首席信息官(CIO)#内容#首席信息官汇报路线";

var label_YN08 = "信息科技战略规划#内容#已制定并印发信息科技战略规划";
var label_YN08_01 = "信息科技战略规划#内容#经董事会审批";
var label_YN08_02 = "信息科技战略规划#内容#审批时间";
var label_YN08_03 = "信息科技战略规划#内容#信息科技战略规划名称";
var label_YN08_04 = "信息科技战略规划#内容#规划期";
var label_YN08_05 = "信息科技战略规划#内容#到";
var label_YN08_06 = "信息科技战略规划#内容#定期评价信息科技战略规划实施效果";
var label_YN08_07 = "信息科技战略规划#内容#评价周期";

var label_item95 = "重大项目情况#内容#本年度重大项目计划完成率";
var label_item105 = "信息科技资金投入#内容#本年度信息科技投入占本年度总投入的比例";

var label_YN11 = "信息科技资金投入#内容#本年度信息科技投入";
var label_YN11_01 = "信息科技资金投入#内容#其中，基础设施建设投入";
var label_YN11_02 = "信息科技资金投入#内容#电子设备采购投入";
var label_YN11_03 = "信息科技资金投入#内容#软件采购投入";
var label_YN11_04 = "信息科技资金投入#内容#系统开发项目投入";
var label_YN11_05 = "信息科技资金投入#内容#系统运营投入";
var label_YN11_06 = "信息科技资金投入#内容#信息科技咨询投入";
var label_YN11_07 = "信息科技资金投入#内容#信息科技人力资源费用";
var label_YN11_08 = "信息科技资金投入#内容#其他";
var label_YN11_09 = "信息科技资金投入#内容#本年度信息科技投入中外包费用";

var label_YN04_01 = "信息科技组织架构#内容#设立信息科技管理部门（组织）#设立信息科技管理部门（组织）";
var label_YN04_01_01 = "信息科技组织架构#内容#设立信息科技管理部门（组织）#部门（组织）名称";
var label_YN04_01_02 = "信息科技组织架构#内容#设立信息科技管理部门（组织）#隶属于";
var label_YN04_01_03 = "信息科技组织架构#内容#设立信息科技管理部门（组织）#负责人";
var label_YN04_01_04 = "信息科技组织架构#内容#设立信息科技管理部门（组织）#职务";

var label_YN04_02 = "信息科技组织架构#内容#设立信息科技需求管理部门（组织）#设立信息科技需求管理部门（组织）";
var label_YN04_02_01 = "信息科技组织架构#内容#设立信息科技需求管理部门（组织）#部门（组织）名称";
var label_YN04_02_02 = "信息科技组织架构#内容#设立信息科技需求管理部门（组织）#隶属于";
var label_YN04_02_03 = "信息科技组织架构#内容#设立信息科技需求管理部门（组织）#负责人";
var label_YN04_02_04 = "信息科技组织架构#内容#设立信息科技需求管理部门（组织）#职务";

var label_YN04_03 = "信息科技组织架构#内容#设立信息科技开发部门（组织）#设立信息科技开发部门（组织）";
var label_YN04_03_01 = "信息科技组织架构#内容#设立信息科技开发部门（组织）#部门（组织）名称";
var label_YN04_03_02 = "信息科技组织架构#内容#设立信息科技开发部门（组织）#隶属于";
var label_YN04_03_03 = "信息科技组织架构#内容#设立信息科技开发部门（组织）#负责人";
var label_YN04_03_04 = "信息科技组织架构#内容#设立信息科技开发部门（组织）#职务";

var label_YN04_04 = "信息科技组织架构#内容#设立信息科技测试部门（组织）#设立信息科技测试部门（组织）";
var label_YN04_04_01 = "信息科技组织架构#内容#设立信息科技测试部门（组织）#部门（组织）名称";
var label_YN04_04_02 = "信息科技组织架构#内容#设立信息科技测试部门（组织）#隶属于";
var label_YN04_04_03 = "信息科技组织架构#内容#设立信息科技测试部门（组织）#负责人";
var label_YN04_04_04 = "信息科技组织架构#内容#设立信息科技测试部门（组织）#职务";

var label_YN04_05 = "信息科技组织架构#内容#设立信息科技运行维护部门（组织）#设立信息科技运行维护部门（组织）";
var label_YN04_05_01 = "信息科技组织架构#内容#设立信息科技运行维护部门（组织）#部门（组织）名称";
var label_YN04_05_02 = "信息科技组织架构#内容#设立信息科技运行维护部门（组织）#隶属于";
var label_YN04_05_03 = "信息科技组织架构#内容#设立信息科技运行维护部门（组织）#负责人";
var label_YN04_05_04 = "信息科技组织架构#内容#设立信息科技运行维护部门（组织）#职务";

var label_YN04_06 = "信息科技组织架构#内容#设立信息安全管理部门（组织）#设立信息安全管理部门（组织）";
var label_YN04_06_01 = "信息科技组织架构#内容#设立信息安全管理部门（组织）#部门（组织）名称";
var label_YN04_06_02 = "信息科技组织架构#内容#设立信息安全管理部门（组织）#隶属于";
var label_YN04_06_03 = "信息科技组织架构#内容#设立信息安全管理部门（组织）#负责人";
var label_YN04_06_04 = "信息科技组织架构#内容#设立信息安全管理部门（组织）#职务";

var label_YN09_01 = "信息科技风险管理#内容#设立或指定专门的信息科技风险管理部门（组织）";
var label_YN09_02 = "信息科技风险管理#内容#部门（组织）名称";
var label_YN09_03 = "信息科技风险管理#内容#隶属于";
var label_YN09_04 = "信息科技风险管理#内容#独立于信息科技部门";
var label_YN09_05 = "信息科技风险管理#内容#信息科技风险管理部门（组织）报告路线";

var label_YN09_06 = "信息科技风险管理#内容#设立专职的信息科技风险管理岗位";
var label_YN09_07 = "信息科技风险管理#内容#岗位名称";
var label_YN09_08 = "信息科技风险管理#内容#专职信息科技风险管理人员数量";
var label_YN09_09 = "信息科技风险管理#内容#其中具有信息科技背景的人数";
var label_YN09_10 = "信息科技风险管理#内容#机构风险管理人员数量";
var label_YN09_11= "信息科技风险管理#内容#信息科技风险管理制度总数";
var label_YN09_12= "信息科技风险管理#内容#本年度新增";
var label_YN09_13= "信息科技风险管理#内容#本年度修订";

var label_YN10_01 = "内部审计#内容#设立或指定信息科技内审部门（组织）";
var label_YN10_02 = "内部审计#内容#部门（组织）名称";
var label_YN10_03 = "内部审计#内容#隶属于";
var label_YN10_04 = "内部审计#内容#独立于信息科技部门";
var label_YN10_06 = "内部审计#内容#内审人员数量";
var label_YN10_07 = "内部审计#内容#信息科技专职内审人员数量";
var label_YN10_08 = "内部审计#内容#其中具有信息科技背景的人数";
var label_YN10_09 = "内部审计#内容#信息科技内审部门（组织）报告路线";
var label_YN10_10 = "内部审计#内容#信息科技审计制度总数";
var label_YN10_11 = "内部审计#内容#本年度新增";
var label_YN10_12 = "内部审计#内容#本年度修订";

var label_YN01_01 = "机构规模#内容#设有境外分支机构（或分公司）的国家和地区数量";
var label_YN01_02 = "机构规模#内容#设有境内分支机构（或分公司）的省级行政区数量（含直辖市、计划单列市）";

var label_YN12_01 = "信息科技人力资源投入#内容#正式员工数";
var label_YN12_02 = "信息科技人力资源投入#内容#信息科技正式员工数";
var label_YN12_03 = "信息科技人力资源投入#内容#其中，信息科技需求管理正式员工数量";
var label_YN12_04 = "信息科技人力资源投入#内容#信息科技开发正式员工数量";
var label_YN12_05 = "信息科技人力资源投入#内容#信息科技测试正式员工数量";
var label_YN12_06 = "信息科技人力资源投入#内容#信息科技运行维护正式员工数量";
var label_YN12_07 = "信息科技人力资源投入#内容#专职信息安全岗位正式员工数量";
var label_YN12_08 = "信息科技人力资源投入#内容#信息科技本年度入职正式员工数";
var label_YN12_09 = "信息科技人力资源投入#内容#信息科技本年度离职正式员工数";

var label_YN13_01 = "信息科技人员专业高级资质持证情况#内容#信息安全管理类资质认证";
var label_YN13_02 = "信息科技人员专业高级资质持证情况#内容#信息科技服务管理类资质认证";
var label_YN13_03 = "信息科技人员专业高级资质持证情况#内容#信息科技项目开发与管理类资质认证";
var label_YN13_04 = "信息科技人员专业高级资质持证情况#内容#网络管理类资质认证";
var label_YN13_05 = "信息科技人员专业高级资质持证情况#内容#数据库管理类资质认证";
var label_YN13_06 = "信息科技人员专业高级资质持证情况#内容#业务连续性管理类资质认证";
var label_YN13_07 = "信息科技人员专业高级资质持证情况#内容#审计类资质认证";
var label_YN13_08 = "信息科技人员专业高级资质持证情况#内容#其他类型资质认证";
var label_YN13_09 = "信息科技人员专业高级资质持证情况#内容#持有上述专业高级资质的信息科技正式员工总数";

/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	
	var obj = 0;
	setYN02Disable(obj);
	setYN03Disable(obj);
	setYN08Disable(obj);
	setYN04_01Disable(obj);
	setYN04_02Disable(obj);
	setYN04_03Disable(obj);
	setYN04_04Disable(obj);
	setYN04_05Disable(obj);
	setYN04_06Disable(obj);
	setYN09Disable(obj);
	setYN09_childDisable(obj);
	setYN10Disable(obj);
}
//数字控件0
function checkNumber(obj){
	if(obj.value < 0){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.firstChild.innerText;
		alert("请按规范填写"+errorMessage+"，数值不能小于0\n");
	}
}

function checkData() {
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	//机构规模验证
	var obj_YN_01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN_01_02 = getTableFormObjs(label_YN01_02)[0];
	if(parseInt(obj_YN_01_01.value)> 36)
	{
		errorObjs.push(obj_YN_01_01);
		a+="设有境内分支机构（或分公司）的省级行政区数量不能大于36！\n";
		isValid=false;
	}
	if(parseInt(obj_YN_01_02.value)> 36)
	{
		errorObjs.push(obj_YN_01_02);
		a+="设有境内分支机构（或分公司）的省级行政区数量不能大于36！\n";
		isValid=false;
	}
	//信息科技管理委员会验证
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02.rownumber );
	var obj_YN02_07 = getTableFormObj(label_YN02_07,obj_YN02.rownumber );
	var obj_YN02_08= getTableFormObj(label_YN02_08,obj_YN02.rownumber );
	if(obj_YN02.value.trim() == "是"){
		if(obj_YN02_06.value.trim() == "")
		{
			errorObjs.push(obj_YN02_06);
			a+="信息科技管理委员会总人数不能为空！\n";
			isValid=false;
		}
		
		if(obj_YN02_07.value.trim() == "")
		{
			errorObjs.push(obj_YN02_07);
			a+="信息科技管理委员会中非信息科技部门人员数不能为空！\n";
			isValid=false;
		}
		
		if(parseInt(obj_YN02_07.value) > parseInt(obj_YN02_06.value))
		{
			errorObjs.push(obj_YN02_07);
			a+="信息科技管理委员会中非信息科技部门人员数不能大于信息科技管理委员会总人数！\n";
			isValid=false;
		}
	
		if(obj_YN02_08.value.trim() == "")
		{
			errorObjs.push(obj_YN02_08);
			a+="本年度信息科技管理委员会全体会议次数不能为空！\n";
			isValid=false;
		}
	}
	//首席信息官(CIO)验证
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03.rownumber );
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03.rownumber );
    if(obj_YN03.value.trim() == "是")
	{
		if(obj_YN03_03.value.trim() == "")
		{
			errorObjs.push(obj_YN03_03);
			a+="首席信息官是否纳入高级管理员不能为空！\n";
			isValid=false;
		}
		
		if(obj_YN03_04.value.trim() == "")
		{
			errorObjs.push(obj_YN03_04);
			a+="首席信息官是否兼任其他职务不能为空！\n";
			isValid=false;
		}
	
		if(obj_YN03_06.value.trim() == "")
		{
			errorObjs.push(obj_YN03_06);
			a+="首席信息官在机构内部是否通过书面方式正式任职不能为空！\n";
			isValid=false;
		}
	}
	//信息科技战略规划验证
    var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "是") {
		if(obj_YN08_04.value.trim() != "" && obj_YN08_05.value.trim() != "")
		{
			if(parseInt(obj_YN08_04.value) > parseInt(obj_YN08_05.value) )
			{
				errorObjs.push(obj_YN08_04);
				errorObjs.push(obj_YN08_05);
				a+="规划期起始年份不能大于结束年份！\n";
				isValid=false;
			}
		}
	}
	//信息科技资金投入验证
	var obj_YN11 = getTableFormObjs(label_YN11)[0];
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObjs(label_YN11_02)[0];
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	var obj_YN11_04 = getTableFormObjs(label_YN11_04)[0];
	var obj_YN11_05 = getTableFormObjs(label_YN11_05)[0];
	var obj_YN11_06 = getTableFormObjs(label_YN11_06)[0];
	var obj_YN11_07 = getTableFormObjs(label_YN11_07)[0];
	var obj_YN11_08 = getTableFormObjs(label_YN11_08)[0];
	var obj_YN11_09 = getTableFormObjs(label_YN11_09)[0];
	if(parseInt(obj_YN11_01.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_01);
		a+="基础设施建设投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_02.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_02);
		a+="电子设备采购投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_03.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_03);
		a+="软件采购投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	if(parseInt(obj_YN11_04.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_04);
		a+="系统开发项目投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_05.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_05);
		a+="系统运营投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_06.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_06);
		a+="信息科技咨询投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_07.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_07);
		a+="信息科技人力资源费用不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_08.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_08);
		a+="其他投入不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	if(parseInt(obj_YN11_09.value) > parseInt(obj_YN11.value))
	{
		errorObjs.push(obj_YN11_09);
		a+="本年度信息科技投入中外包费用不能大于本年度信息科技投入！\n";
		isValid=false;	
	}
	
	var sumTR = 0;
	sumTR += parseFloat(obj_YN11_01.value);
	sumTR += parseFloat(obj_YN11_02.value);
	sumTR += parseFloat(obj_YN11_03.value);
	sumTR += parseFloat(obj_YN11_04.value);
	sumTR += parseFloat(obj_YN11_05.value);
	sumTR += parseFloat(obj_YN11_06.value);
	sumTR += parseFloat(obj_YN11_07.value);
	sumTR += parseFloat(obj_YN11_08.value);
	
	if(sumTR != parseFloat(obj_YN11.value))
	{
		errorObjs.push(obj_YN11);
		errorObjs.push(obj_YN11_01);
		errorObjs.push(obj_YN11_02);
		errorObjs.push(obj_YN11_03);
		errorObjs.push(obj_YN11_04);
		errorObjs.push(obj_YN11_05);
		errorObjs.push(obj_YN11_06);
		errorObjs.push(obj_YN11_07);
		errorObjs.push(obj_YN11_08);
		a +="本年度所有投入的费用总和应该等于本年度信息科技投入！\n";
		
		isValid = false;
	}
	//信息科技人力资源投入校验
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObjs(label_YN12_02)[0];
	var obj_YN12_03 = getTableFormObjs(label_YN12_03)[0];
	var obj_YN12_04 = getTableFormObjs(label_YN12_04)[0];
	var obj_YN12_05 = getTableFormObjs(label_YN12_05)[0];
	var obj_YN12_06 = getTableFormObjs(label_YN12_06)[0];
	var obj_YN12_07 = getTableFormObjs(label_YN12_07)[0];
	
	if(parseInt(obj_YN12_02.value) > parseInt(obj_YN12_01.value))
	{
		errorObjs.push(obj_YN12_02);
		a +="信息科技正式员工数不能大于正式员工数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_03.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_03);
		a +="信息科技需求管理正式员工数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_04.value)> parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_04);
		a +="信息科技开发正式员工数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_05.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_05);
		a +="信息科技测试正式员工数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_06.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_06);
		a +="信息科技运行维护正式员工数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN12_07.value) > parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_07);
		a +="专职信息安全岗位正式员工数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	var sumPep = 0;
	sumPep += parseInt(obj_YN12_03.value);
	sumPep += parseInt(obj_YN12_04.value);
	sumPep += parseInt(obj_YN12_05.value);
	sumPep += parseInt(obj_YN12_06.value);
	sumPep += parseInt(obj_YN12_07.value);
	
	if(sumPep >  parseInt(obj_YN12_02.value))
	{
		errorObjs.push(obj_YN12_02);
		errorObjs.push(obj_YN12_07);
		errorObjs.push(obj_YN12_03);
		errorObjs.push(obj_YN12_04);
		errorObjs.push(obj_YN12_05);
		errorObjs.push(obj_YN12_06);
		a +="其中信息科技各类正式员工总数不能大于信息科技正式员工数！\n";;
		isValid = false;
	}
	
	//信息科技风险管理验证
	var obj_YN09_10 = getTableFormObjs(label_YN09_10)[0];
	var obj_YN09_06 = getTableFormObjs(label_YN09_06)[0];
	var obj_YN09_11 = getTableFormObjs(label_YN09_11)[0];
	var obj_YN09_12 = getTableFormObjs(label_YN09_12)[0];
	var obj_YN09_13 = getTableFormObjs(label_YN09_13)[0];
	
	if(obj_YN09_10.value.trim() == "")
	{
		errorObjs.push(obj_YN09_10);
		a +="机构风险管理人员数量不能为空！\n";;
		isValid = false;
	}
	
	if(obj_YN09_06.value.trim() == "")
	{
		errorObjs.push(obj_YN09_06);
		a +="是否设立专职的信息科技风险管理岗位不能为空！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN09_12.value) > parseInt(obj_YN09_11.value))
	{
		errorObjs.push(obj_YN09_12);
		a +="本年度新增制度数量不能大于信息科技风险管理制度总数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN09_13.value) > parseInt(obj_YN09_11.value))
	{
		errorObjs.push(obj_YN09_13);
		a +="本年度修订制度数量不能大于信息科技风险管理制度总数！\n";;
		isValid = false;
	}
	
	//内部审计校验
	var obj_YN10_06 = getTableFormObjs(label_YN10_06)[0];
	var obj_YN10_07 = getTableFormObjs(label_YN10_07)[0];
	var obj_YN10_08 = getTableFormObjs(label_YN10_08)[0];
	var obj_YN10_10 = getTableFormObjs(label_YN10_10)[0];
	var obj_YN10_11 = getTableFormObjs(label_YN10_11)[0];
	var obj_YN10_12 = getTableFormObjs(label_YN10_12)[0];
	if(parseInt(obj_YN10_07.value) > parseInt(obj_YN10_06.value))
	{
		errorObjs.push(obj_YN10_07);
		a +="信息科技专职内审人员数量不能大于内审人员总数！\n";;
		isValid = false;
	}
	if(parseInt(obj_YN10_07.value) < parseInt(obj_YN10_08.value))
	{
		errorObjs.push(obj_YN10_08);
		a +="信息科技背景的人数应小于信息科技专职内审人员数量！\n";;
		isValid = false;
	}
	if(parseInt(obj_YN10_11.value) > parseInt(obj_YN10_10.value))
	{
		errorObjs.push(obj_YN10_11);
		a +="本年度新增制度数量不能大于信息科技审计制度总数！\n";;
		isValid = false;
	}
	
	if(parseInt(obj_YN10_12.value) > parseInt(obj_YN10_10.value))
	{
		errorObjs.push(obj_YN10_12);
		a +="本年度修订制度数量不能大于信息科技审计制度总数！\n";;
		isValid = false;
	}
	
	//信息科技人员专业高级资质持证情况验证
	var obj_YN13_01 = getTableFormObjs(label_YN13_01)[0];
	var obj_YN13_02 = getTableFormObjs(label_YN13_02)[0];
	var obj_YN13_03 = getTableFormObjs(label_YN13_03)[0];
	var obj_YN13_04 = getTableFormObjs(label_YN13_04)[0];
	var obj_YN13_05 = getTableFormObjs(label_YN13_05)[0];
	var obj_YN13_06 = getTableFormObjs(label_YN13_06)[0];
	var obj_YN13_07 = getTableFormObjs(label_YN13_07)[0];
	var obj_YN13_08 = getTableFormObjs(label_YN13_08)[0];
	var obj_YN13_09 = getTableFormObjs(label_YN13_09)[0];
	var sumZZ = 0;
	sumZZ += parseInt(obj_YN13_01.value);
	sumZZ += parseInt(obj_YN13_02.value);
	sumZZ += parseInt(obj_YN13_03.value);
	sumZZ += parseInt(obj_YN13_04.value);
	sumZZ += parseInt(obj_YN13_05.value);
	sumZZ += parseInt(obj_YN13_06.value);
	sumZZ += parseInt(obj_YN13_07.value);
	sumZZ += parseInt(obj_YN13_08.value);
	if(parseInt(obj_YN13_09.value) > sumZZ)
	{
		errorObjs.push(obj_YN13_01);
		errorObjs.push(obj_YN13_02);
		errorObjs.push(obj_YN13_03);
		errorObjs.push(obj_YN13_04);
		errorObjs.push(obj_YN13_05);
		errorObjs.push(obj_YN13_06);
		errorObjs.push(obj_YN13_07);
		errorObjs.push(obj_YN13_08);
		errorObjs.push(obj_YN13_09);
		a +="持有上述高级资质认证的信息科技正式员工数不能大于所有持证人员之和！\n";;
		isValid = false;
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
 *功能：根据单选按钮修改表单是否可读写
 *配置：内部审计#内容#设立或指定信息科技内审部门（组织）
 */
function setYN10Disable(objcld){
	var obj_YN10_01 = getTableFormObjs(label_YN10_01)[0];
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10_01.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10_01.rownumber );
	var obj_YN10_04 = getTableFormObj(label_YN10_04,obj_YN10_01.rownumber );
	var obj_YN10_06 = getTableFormObj(label_YN10_06,obj_YN10_01.rownumber );
	var obj_YN10_07 = getTableFormObj(label_YN10_07,obj_YN10_01.rownumber );
	var obj_YN10_08 = getTableFormObj(label_YN10_08,obj_YN10_01.rownumber );
	var obj_YN10_09 = getTableFormObj(label_YN10_09,obj_YN10_01.rownumber );
	var obj_YN10_10 = getTableFormObj(label_YN10_10,obj_YN10_01.rownumber );
	var obj_YN10_11 = getTableFormObj(label_YN10_11,obj_YN10_01.rownumber );
	var obj_YN10_12 = getTableFormObj(label_YN10_12,obj_YN10_01.rownumber );
	if (obj_YN10_01.value.trim() == "否" || obj_YN10_01.value.trim() == "") {
		//只读
		obj_YN10_02.readOnly = "readonly";
		obj_YN10_03.readOnly = "readonly";
		columnVallueRadio1(obj_YN10_04,false,false);
		obj_YN10_04.readOnly = "readonly";
		obj_YN10_06.readOnly = "readonly";
		obj_YN10_07.readOnly = "readonly";
		obj_YN10_08.readOnly = "readonly";
		obj_YN10_09.readOnly = "readonly";
		obj_YN10_10.readOnly = "readonly";
		obj_YN10_11.readOnly = "readonly";
		obj_YN10_12.readOnly = "readonly";
		//清空
		obj_YN10_02.value = "";
		obj_YN10_03.value = "";
		obj_YN10_04.value = "";
		obj_YN10_06.value = "";
		obj_YN10_07.value = "";
		obj_YN10_08.value = "";
		obj_YN10_09.value = "";
		obj_YN10_10.value = "";
		obj_YN10_11.value = "";
		obj_YN10_12.value = "";
	}else if (obj_YN10_01.value.trim() == "是"){
		obj_YN10_02.readOnly = "";
		obj_YN10_03.readOnly = "";
		columnVallueRadio1(obj_YN10_04,true,false);
		obj_YN10_04.readOnly = "";
		obj_YN10_06.readOnly = "";
		obj_YN10_07.readOnly = "";
		obj_YN10_08.readOnly = "";
		obj_YN10_09.readOnly = "";
		obj_YN10_10.readOnly = "";
		obj_YN10_11.readOnly = "";
		obj_YN10_12.readOnly = "";
	}
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技风险管理#内容#设立专职的信息科技风险管理岗位
 */
function setYN09_childDisable(objcld){
	var obj_YN09_06 = getTableFormObjs(label_YN09_06)[0];
	var obj_YN09_07 =  getTableFormObj(label_YN09_07,obj_YN09_06.rownumber );
	var obj_YN09_08 =  getTableFormObj(label_YN09_08,obj_YN09_06.rownumber );
	var obj_YN09_09 =  getTableFormObj(label_YN09_09,obj_YN09_06.rownumber );
	if (obj_YN09_06.value.trim() == "否" || obj_YN09_06.value.trim() == "") {
		//只读
		obj_YN09_07.readOnly = "readonly";
		obj_YN09_08.readOnly = "readonly";
		obj_YN09_09.readOnly = "readonly";
		//清空
		obj_YN09_07.value = "";
		obj_YN09_08.value = "";
		obj_YN09_09.value = "";
	}else if (obj_YN09_06.value.trim() == "是"){
		obj_YN09_07.readOnly = "";
		obj_YN09_08.readOnly = "";
		obj_YN09_09.readOnly = "";
	}
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技风险管理#内容#设立或指定专门的信息科技风险管理部门（组织）
 */
function setYN09Disable(objcld){
	var obj_YN09 = getTableFormObjs(label_YN09_01)[0];
	var obj_YN09_01 =  getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_02 =  getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_03 =  getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_04 =  getTableFormObj(label_YN09_05,obj_YN09.rownumber );
	if (obj_YN09.value.trim() == "否" || obj_YN09.value.trim() == "") {
		//只读
		obj_YN09_01.readOnly = "readonly";
		obj_YN09_02.readOnly = "readonly";
		columnVallueRadio1(obj_YN09_03,false,false);
		obj_YN09_04.readOnly = "readonly";
		//清空
		obj_YN09_01.value = "";
		obj_YN09_02.value = "";
		obj_YN09_03.value = "";
		obj_YN09_04.value = "";
	}else if (obj_YN09.value.trim() == "是"){
		obj_YN09_01.readOnly = "";
		obj_YN09_02.readOnly = "";
		columnVallueRadio1(obj_YN09_03,true,false);
		obj_YN09_04.readOnly = "";
	}
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息科技管理部门（组织）#设立信息科技管理部门（组织）
 */
function setYN04_01Disable(objcld) {
	var obj_YN04_01 = getTableFormObjs(label_YN04_01)[0];
	var obj_YN04_01_01 =  getTableFormObj(label_YN04_01_01,obj_YN04_01.rownumber );
	var obj_YN04_01_02 =  getTableFormObj(label_YN04_01_02,obj_YN04_01.rownumber );
	var obj_YN04_01_03 =  getTableFormObj(label_YN04_01_03,obj_YN04_01.rownumber );
	var obj_YN04_01_04 =  getTableFormObj(label_YN04_01_04,obj_YN04_01.rownumber );
	
	if (obj_YN04_01.value.trim() == "否" || obj_YN04_01.value.trim() == "") {
		// 只读
		obj_YN04_01_01.readOnly = "readonly";
		obj_YN04_01_02.readOnly = "readonly";
		obj_YN04_01_03.readOnly = "readonly";
		obj_YN04_01_04.readOnly = "readonly";
		// 清空
		obj_YN04_01_01.value = "";
		obj_YN04_01_02.value = "";
		obj_YN04_01_03.value = "";
		obj_YN04_01_04.value = "";
		
	}else if (obj_YN04_01.value.trim() == "是"){
		obj_YN04_01_01.readOnly = "";
		obj_YN04_01_02.readOnly = "";
		obj_YN04_01_03.readOnly = "";
		obj_YN04_01_04.readOnly = "";
	}
}
/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息科技需求管理部门（组织）#设立信息科技需求管理部门（组织）
 */
function setYN04_02Disable(objcld) {
	var obj_YN04_02 = getTableFormObjs(label_YN04_02)[0];
	var obj_YN04_02_01 =  getTableFormObj(label_YN04_02_01,obj_YN04_02.rownumber );
	var obj_YN04_02_02 =  getTableFormObj(label_YN04_02_02,obj_YN04_02.rownumber );
	var obj_YN04_02_03 =  getTableFormObj(label_YN04_02_03,obj_YN04_02.rownumber );
	var obj_YN04_02_04 =  getTableFormObj(label_YN04_02_04,obj_YN04_02.rownumber );
	
	if (obj_YN04_02.value.trim() == "否" || obj_YN04_02.value.trim() == "") {
		// 只读
		obj_YN04_02_01.readOnly = "readonly";
		obj_YN04_02_02.readOnly = "readonly";
		obj_YN04_02_03.readOnly = "readonly";
		obj_YN04_02_04.readOnly = "readonly";
		// 清空
		obj_YN04_02_01.value = "";
		obj_YN04_02_02.value = "";
		obj_YN04_02_03.value = "";
		obj_YN04_02_04.value = "";
		
	}else if (obj_YN04_02.value.trim() == "是"){
		obj_YN04_02_01.readOnly = "";
		obj_YN04_02_02.readOnly = "";
		obj_YN04_02_03.readOnly = "";
		obj_YN04_02_04.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息科技开发部门（组织）#设立信息科技开发部门（组织）
 */
function setYN04_03Disable(objcld) {
	var obj_YN04_03 = getTableFormObjs(label_YN04_03)[0];
	var obj_YN04_03_01 =  getTableFormObj(label_YN04_03_01,obj_YN04_03.rownumber );
	var obj_YN04_03_02 =  getTableFormObj(label_YN04_03_02,obj_YN04_03.rownumber );
	var obj_YN04_03_03 =  getTableFormObj(label_YN04_03_03,obj_YN04_03.rownumber );
	var obj_YN04_03_04 =  getTableFormObj(label_YN04_03_04,obj_YN04_03.rownumber );
	
	if (obj_YN04_03.value.trim() == "否" || obj_YN04_03.value.trim() == "") {
		// 只读
		obj_YN04_03_01.readOnly = "readonly";
		obj_YN04_03_02.readOnly = "readonly";
		obj_YN04_03_03.readOnly = "readonly";
		obj_YN04_03_04.readOnly = "readonly";
		// 清空
		obj_YN04_03_01.value = "";
		obj_YN04_03_02.value = "";
		obj_YN04_03_03.value = "";
		obj_YN04_03_04.value = "";
		
	}else if (obj_YN04_03.value.trim() == "是"){
		obj_YN04_03_01.readOnly = "";
		obj_YN04_03_02.readOnly = "";
		obj_YN04_03_03.readOnly = "";
		obj_YN04_03_04.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息科技测试部门（组织）#设立信息科技测试部门（组织）
 */
function setYN04_04Disable(objcld) {
	var obj_YN04_04 = getTableFormObjs(label_YN04_04)[0];
	var obj_YN04_04_01 =  getTableFormObj(label_YN04_04_01,obj_YN04_04.rownumber );
	var obj_YN04_04_02 =  getTableFormObj(label_YN04_04_02,obj_YN04_04.rownumber );
	var obj_YN04_04_03 =  getTableFormObj(label_YN04_04_03,obj_YN04_04.rownumber );
	var obj_YN04_04_04 =  getTableFormObj(label_YN04_04_04,obj_YN04_04.rownumber );
	
	if (obj_YN04_04.value.trim() == "否" || obj_YN04_04.value.trim() == "") {
		// 只读
		obj_YN04_04_01.readOnly = "readonly";
		obj_YN04_04_02.readOnly = "readonly";
		obj_YN04_04_03.readOnly = "readonly";
		obj_YN04_04_04.readOnly = "readonly";
		// 清空
		obj_YN04_04_01.value = "";
		obj_YN04_04_02.value = "";
		obj_YN04_04_03.value = "";
		obj_YN04_04_04.value = "";
		
	}else if (obj_YN04_04.value.trim() == "是"){
		obj_YN04_04_01.readOnly = "";
		obj_YN04_04_02.readOnly = "";
		obj_YN04_04_03.readOnly = "";
		obj_YN04_04_04.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息科技运行维护部门（组织）#设立信息科技运行维护部门（组织）
 */
function setYN04_05Disable(objcld) {
	var obj_YN04_05 = getTableFormObjs(label_YN04_05)[0];
	var obj_YN04_05_01 =  getTableFormObj(label_YN04_05_01,obj_YN04_05.rownumber);
	var obj_YN04_05_02 =  getTableFormObj(label_YN04_05_02,obj_YN04_05.rownumber);
	var obj_YN04_05_03 =  getTableFormObj(label_YN04_05_03,obj_YN04_05.rownumber);
	var obj_YN04_05_04 =  getTableFormObj(label_YN04_05_04,obj_YN04_05.rownumber);
	
	if (obj_YN04_05.value.trim() == "否" || obj_YN04_05.value.trim() == "") {
		// 只读
		obj_YN04_05_01.readOnly = "readonly";
		obj_YN04_05_02.readOnly = "readonly";
		obj_YN04_05_03.readOnly = "readonly";
		obj_YN04_05_04.readOnly = "readonly";
		// 清空
		obj_YN04_05_01.value = "";
		obj_YN04_05_02.value = "";
		obj_YN04_05_03.value = "";
		obj_YN04_05_04.value = "";
		
	}else if (obj_YN04_05.value.trim() == "是"){
		obj_YN04_05_01.readOnly = "";
		obj_YN04_05_02.readOnly = "";
		obj_YN04_05_03.readOnly = "";
		obj_YN04_05_04.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技组织架构#内容#设立信息安全管理部门（组织）#设立信息安全管理部门（组织）
 */
function setYN04_06Disable(objcld) {
	var obj_YN04_06 = getTableFormObjs(label_YN04_06)[0];
	var obj_YN04_06_01 =  getTableFormObj(label_YN04_06_01,obj_YN04_06.rownumber );
	var obj_YN04_06_02 =  getTableFormObj(label_YN04_06_02,obj_YN04_06.rownumber );
	var obj_YN04_06_03 =  getTableFormObj(label_YN04_06_03,obj_YN04_06.rownumber );
	var obj_YN04_06_04 =  getTableFormObj(label_YN04_06_04,obj_YN04_06.rownumber );
	
	if (obj_YN04_06.value.trim() == "否" || obj_YN04_06.value.trim() == "") {
		// 只读
		obj_YN04_06_01.readOnly = "readonly";
		obj_YN04_06_02.readOnly = "readonly";
		obj_YN04_06_03.readOnly = "readonly";
		obj_YN04_06_04.readOnly = "readonly";
		// 清空
		obj_YN04_06_01.value = "";
		obj_YN04_06_02.value = "";
		obj_YN04_06_03.value = "";
		obj_YN04_06_04.value = "";
		
	}else if (obj_YN04_06.value.trim() == "是"){
		obj_YN04_06_01.readOnly = "";
		obj_YN04_06_02.readOnly = "";
		obj_YN04_06_03.readOnly = "";
		obj_YN04_06_04.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技管理委员会#内容#是否设立
 */
function setYN02Disable(objcld) {
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_01 = getTableFormObj(label_YN02_01,obj_YN02.rownumber );
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02.rownumber );
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02.rownumber );
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02.rownumber );
	var obj_YN02_06 = getTableFormObj(label_YN02_06,obj_YN02.rownumber );
	var obj_YN02_07 = getTableFormObj(label_YN02_07,obj_YN02.rownumber );
	var obj_YN02_08= getTableFormObj(label_YN02_08,obj_YN02.rownumber );
	var obj_YN02_09 = getTableFormObj(label_YN02_09,obj_YN02.rownumber);

	if (obj_YN02.value.trim() == "否" || obj_YN02.value.trim() == "") {
		// 只读
		obj_YN02_01.readOnly = "readonly";
		obj_YN02_02.onclick = "";
		obj_YN02_03.readOnly = "readonly";
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_06.readOnly = "readonly";
		obj_YN02_07.readOnly = "readonly";
		obj_YN02_08.readOnly = "readonly";
		columnVallueRadio1(obj_YN02_09,false,false);
		// 清空
		obj_YN02_01.value = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		obj_YN02_04.value = "";
		obj_YN02_06.value = "";
		obj_YN02_07.value = "";
		obj_YN02_08.value = "";
		obj_YN02_09.value = "";
	} else if (obj_YN02.value.trim() == "是") {
		// 还原
		obj_YN02_01.readOnly = "";
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03.readOnly = "";
		obj_YN02_04.readOnly = "";
		obj_YN02_06.readOnly = "";
		obj_YN02_07.readOnly = "";
		obj_YN02_08.readOnly = "";
		columnVallueRadio1(obj_YN02_09,true,false);
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：首席信息官(CIO)#内容#是否设立
 */
function setYN03Disable(obj) {
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN03.rownumber );
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03.rownumber );
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03.rownumber );
	var obj_YN03_05 = getTableFormObj(label_YN03_05,obj_YN03.rownumber );
	var obj_YN03_06 = getTableFormObj(label_YN03_06,obj_YN03.rownumber );
	var obj_YN03_07 = getTableFormObj(label_YN03_07,obj_YN03.rownumber );
	
	if (obj_YN03.value.trim() == "否" || obj_YN03.value.trim() == "") {
		// 只读
		obj_YN03_01.readOnly = "readonly";
		obj_YN03_02.onclick = "";
		columnVallueRadio1(obj_YN03_03,false,false);
		columnVallueRadio1(obj_YN03_04,false,false);
		obj_YN03_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN03_06,false,false);
		obj_YN03_07.readOnly = "readonly";
		// 清空
		obj_YN03_01.value = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";
		obj_YN03_06.value = "";
		obj_YN03_07.value = "";
	}else if (obj_YN03.value.trim() == "是"){ 
		obj_YN03_01.readOnly = "";
		obj_YN03_02.onclick = click_columnshowDate;
		columnVallueRadio1(obj_YN03_03,true,false);
		columnVallueRadio1(obj_YN03_04,true,false);
		obj_YN03_05.readOnly = "";
		columnVallueRadio1(obj_YN03_06,true,false);
		obj_YN03_07.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技战略规划#内容#是否建立信息科技战略规划
 */
function setYN08Disable(objcld) {
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02 = getTableFormObj(label_YN08_02,obj_YN08.rownumber );
	var obj_YN08_03 = getTableFormObj(label_YN08_03,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	var obj_YN08_06 = getTableFormObj(label_YN08_06,obj_YN08.rownumber );
	var obj_YN08_07 = getTableFormObj(label_YN08_07,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "否" || obj_YN08.value.trim() == "") {
		// 只读
		columnVallueRadio1(obj_YN08_01,false,false);
		obj_YN08_02.onclick = "";
		obj_YN08_03.readOnly = "readonly";
		obj_YN08_04.readOnly = "readonly";
		obj_YN08_05.readOnly = "readonly";
		columnVallueRadio1(obj_YN08_06,false,false);
		obj_YN08_07.readOnly = "readonly";
		// 清空
		obj_YN08_01.value = "";
		obj_YN08_02.value = "";
		obj_YN08_03.value = "";
		obj_YN08_04.value = "";
		obj_YN08_05.value = "";
		obj_YN08_06.value = "";
		obj_YN08_07.value = "";
	}else if (obj_YN08.value.trim() == "是") {
		columnVallueRadio1(obj_YN08_01,true,false);
		obj_YN08_02.onclick = click_columnshowDate;
		obj_YN08_03.readOnly = "";
		obj_YN08_04.readOnly = "";
		obj_YN08_05.readOnly = "";
		columnVallueRadio1(obj_YN08_06,true,false);
		obj_YN08_07.readOnly = "";
	}
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
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
};

/*
 *功能：判断表单内容是否大于100
 */
function checkPercent(obj){
	if(obj.value > 100){
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"),0);
		alert("请按规范填写"+errorMessage+"，数值不能大于100\n");
	}
}

/*
 *功能：规划期是否为四位数
 *配置：信息科技战略规划#内容#规划期
 */
function checkItemYN08(obj){
	var length = obj.value.length;
	if(length != "4" || obj.value == "0000" ||obj.value.substring(0,1) == "0"){
		obj.value = "";
		alert("规划期格式不对，应为4位数字，例如2012！");
	}
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	var obj_YN08_05 = getTableFormObjs(label_YN08_05)[0];
	if(obj_YN08_04.value !=""&&obj_YN08_05.value !=""){
		if(parseInt(obj_YN08_04.value)>parseInt(obj_YN08_05.value)){
			obj_YN08_04.value = "";
			alert("规划期应从小到大，请重新输入！");
		}
	}
}
var label_YN08_07 = "信息科技战略规划#内容#评价周期";
/*
 *功能：周期是否大于0
 *配置：信息科技战略规划#内容#评价周期
 */
function checkDateValue(obj){
	var obj_YN08_07 = getTableFormObjs(label_YN08_07)[0];
	if(parseInt(obj_YN08_07.value)<1){
		alert("请按规范评价周期，应填写大于1的整数！");
	}
}
