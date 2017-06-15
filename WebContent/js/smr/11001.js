/*
 * 报表：2014-T-B-4 信息安全管理情况表
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs = [];

// 信息安全制度建设
var label_YN01_01 = "信息安全制度建设#内容#信息安全管理制度总数";
var label_YN01_02 = "信息安全制度建设#内容#其中，本年度新增数量";
var label_YN01_03 = "信息安全制度建设#内容#本年度修订数量";
var label_YN01_04 = "信息安全制度建设#内容#通过信息安全管理体系认证";
var label_YN01_05 = "信息安全制度建设#内容#认证范围";
// 信息安全检查及渗透测试
var label_YN02_02 = "信息安全检查及渗透测试#内容#本年度信息安全检查总数";
var label_YN02_03 = "信息安全检查及渗透测试#内容#其中，总行（或总公司）组织的信息安全检查数量";
var label_YN02_06 = "信息安全检查及渗透测试#内容#本年度组织的渗透测试次数";
var label_YN02_07 = "信息安全检查及渗透测试#内容#其中聘请外部机构开展的专项渗透测试次数";

var label_YN02_13_06 = "信息安全检查及渗透测试#内容#检查项#发现问题数量（个）";
var label_YN02_13_07 = "信息安全检查及渗透测试#内容#检查项#已整改问题数量（个）";
var label_YN02_13 = "信息安全检查及渗透测试#内容#检查项#事项名称";

var label_YN02_14_01 = "信息安全检查及渗透测试#内容#合计#1";
var label_YN02_14_02 = "信息安全检查及渗透测试#内容#合计#2";
var label_YN02_14_03 = "信息安全检查及渗透测试#内容#合计#3";
var label_YN02_13_02 = "信息安全检查及渗透测试#内容#检查项#事项类型";
var label_YN02_13_03 = "信息安全检查及渗透测试#内容#检查项#实施部门（组织）";
var label_YN02_13_04 = "信息安全检查及渗透测试#内容#检查项#主要工作内容";
var label_YN02_13_05 = "信息安全检查及渗透测试#内容#检查项#发现问题数量（个）";
var label_YN02_13_06 = "信息安全检查及渗透测试#内容#检查项#已整改问题数量（个）";
var label_YN02_13_07 = "信息安全检查及渗透测试#内容#检查项#整改率（%）";
var label_YN02_08 = "信息安全检查及渗透测试#内容#本年度渗透测试覆盖的系统";
//等级保护
var label_YN03_02 = "等级保护#内容#等级保护已备案的信息系统总数";
var label_YN03_03 = "等级保护#内容#在已备案信息系统中#五级系统";
var label_YN03_04 = "等级保护#内容#在已备案信息系统中#四级系统";
var label_YN03_05 = "等级保护#内容#在已备案信息系统中#三级系统";
var label_YN03_06 = "等级保护#内容#在已备案信息系统中#二级系统";

// 信息安全培训
var label_YN04_01_01 = "信息安全培训#内容#本年度开展的信息安全培训次数#次数";
var label_YN04_02_01 = "信息安全培训#内容#其中，全辖范围的信息安全培训#次数";
// 主机安全
var label_YN05_01 = "主机安全#内容#制定主机安全配置基线";
var label_YN05_02 = "主机安全#内容#如是，主机安全配置基线覆盖范围";
var label_YN05_03 = "主机安全#内容#定期对主机系统漏洞进行检测";
var label_YN05_04 = "主机安全#内容#检测频率";
var label_YN05_05 = "主机安全#内容#采取的主机系统安全控制措施包括";
// 终端安全
var label_YN06_01 = "终端安全#内容#安装统一的防病毒软件";
var label_YN06_02 = "终端安全#内容#安装统一的终端安全防护软件";
var label_YN06_03 = "终端安全#内容#终端口令定期强制修改";
var label_YN06_04 = "终端安全#内容#修改周期";
var label_YN06_08 = "终端安全#内容#采取的移动设备管理措施包括";
// 应用安全
var label_YN07_06_01 = "应用安全#内容#2#如网上银行支持USB Key，USB Key是否通过第三方测评机构的安全检测";
var label_YN07_06_02 = "应用安全#内容#2#测评机构名称";
var label_YN07_06_03 = "应用安全#内容#2#最近一次检测时间";
var label_YN07_08 = "应用安全#内容#1#网上银行客户证书签发机构为";
var label_YN07_09 = "应用安全#内容#1#机构名称";
var label_YN07_01 = "应用安全#内容#制定应用安全技术规范";
var label_YN07_02 = "应用安全#内容#如是，应用安全技术规范覆盖";
var label_YN07_05 = "应用安全#内容#网上银行支持的多因素认证方式";
var label_YN07_07 = "应用安全#内容#手机银行支持多因素认证方式";

// 数据安全
var label_YN08_01 = "数据安全#内容#建立专门的数据管理组织";
var label_YN08_02 = "数据安全#内容#组织名称";
var label_YN08_03 = "数据安全#内容#制定数据管理制度和流程";
var label_YN08_04 = "数据安全#内容#如是，数据管理制度和流程覆盖范围";
var label_YN08_10 = "数据安全#内容#非生产环境使用生产数据时进行脱敏处理";
var label_YN08_13 = "数据安全#内容#重要信息系统建立数据清理策略";
var label_YN08_14 = "数据安全#内容#对已失效数据或已毁坏但包含重要数据的介质进行销毁";
var label_YN08_15 = "数据安全#内容#销毁机构名称";
// 客户安全教育
var label_YN09_02 = "客户安全教育#内容#加强客户安全教育的宣传渠道包括";
//附件校验
var label_YN11_01 = "附件#内容#内容1#附件索引";
var label_YN11_02 = "附件#内容#内容2#附件索引";
var label_YN11_03 = "附件#内容#内容3#附件索引";
/*
 * 功能：校验表单
 * 
 */
function checkData(obj) {
	//清空错误表单的背景色
	for ( var i = 0; i < errorObjs.length; i++) {
		errorObjs[i].style.backgroundColor = "";
		errorObjs[i].parentNode.style.color = "";
	}
	errorObjs = [];
	// 信息安全制度建设
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	if (obj_YN01_04.value == "") {
		a += "1 信息安全制度建设 认证范围不能为空\n";
		errorObjs.push(obj_YN01_04);
		isValid = false;
	}
	// 信息安全检查及渗透测试检验
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	for ( var i = 0; i < obj_YN02_13.length-1; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_03 = getTableFormObj(label_YN02_13_03,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_04 = getTableFormObj(label_YN02_13_04,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
				obj_YN02_13[i].rownumber);
		var obj_YN02_13_07 = getTableFormObj(label_YN02_13_07,
				obj_YN02_13[i].rownumber);
		
		if (obj_YN02_13[i].value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "事项名称不能为空\n";
			errorObjs.push(obj_YN02_13[i]);
			isValid = false;
		}
		if (obj_YN02_13_02.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "事项类型不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_02);
		}
		if (obj_YN02_13_03.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "实施部门不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_03);
		}
		if (obj_YN02_13_04.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "主要工作内容不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_04);
		}
		if (obj_YN02_13_05.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "发现问题数量不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_05);
		}
		if (obj_YN02_13_06.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "已整改问题数量不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_06);
		}
		if (obj_YN02_13_07.value == "") {
			a += "2 信息安全检查及渗透测试 "
					+ "表"
					+ obj_YN02_13[i].rownumber.substring(
							obj_YN02_13[i].rownumber.lastIndexOf("_") + 1,
							obj_YN02_13[i].rownumber.length) + "整改率不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN02_13_07);
		}

	}
	var obj_YN02_08 = getTableFormObjs(label_YN02_08)[0];
	if (obj_YN02_08.value == "") {
		a += "2 信息安全检查及渗透测试 本年度渗透测试覆盖的系统不能为空";
		isValid = false;
		errorObjs.push(obj_YN02_08);
	}
	var obj_YN02_14_01 = getTableFormObjs(label_YN02_14_01)[0];
	var obj_YN02_14_02 = getTableFormObjs(label_YN02_14_02)[0];
	var obj_YN02_14_03 = getTableFormObjs(label_YN02_14_03)[0];
	if (obj_YN02_14_01.value == "") {
		a += "2 信息安全检查及渗透测试 合计项发现问题数量不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_01);
	}
	if (obj_YN02_14_02.value == "") {
		a += "2 信息安全检查及渗透测试 合计项已整改问题数量不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_02);
	}
	if (obj_YN02_14_03.value == "") {
		a += "2 信息安全检查及渗透测试 合计项整改率不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN02_14_03);
	}
	// 主机安全验证
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormObjs(label_YN05_02)[0];
	if (obj_YN05_01.value == "是" && obj_YN05_02.value == "") {
		a += "5 主机安全 主机安全配置基线覆盖范围不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN05_02);
	}
//	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
//	var obj_YN05_04 = getTableFormObjs(label_YN05_04)[0];
//	if (obj_YN05_03.value == "是" && obj_YN05_04.value == "") {
//		a += "5 主机安全 定期对主机系统漏洞进行检测 检测频率不能为空\n";
//		isValid = false;
//		errorObjs.push(obj_YN05_04);
//	}
	var obj_YN05_05 = getTableFormObjs(label_YN05_05)[0];
	if (obj_YN05_05.value == "") {
		a += "5 主机安全 采取的主机系统安全控制措施不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN05_05);
	}
	// 终端安全校验
	var obj_YN06_01 = getTableFormObjs(label_YN06_01)[0];
	if (obj_YN06_01.value == "") {
		a += "6 终端安全 安装统一的防病毒软件不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN06_01);
	}
	var obj_YN06_02 = getTableFormObjs(label_YN06_02)[0];
	if (obj_YN06_02.value == "") {
		a += "6 终端安全 安装统一的终端安全防护软件不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN06_02);
	}
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	if (obj_YN06_03.value == "") {
		a += "6 终端安全 终端口令定期强制修改不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN06_03);
	}
	var obj_YN06_04 = getTableFormObjs(label_YN06_04)[0];
	if (obj_YN06_03.value == "是" && obj_YN06_04.value == "") {
		a += "6 终端安全 终端口令定期强制修改 修改周期不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN06_04);
	}
	var obj_YN06_08 = getTableFormObjs(label_YN06_08)[0];
	if (obj_YN06_08.value == "") {
		a += "6 终端安全 采取的移动设备管理措施包括不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN06_08);
	}
	// 应用安全校验
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormObjs(label_YN07_02)[0];
	if (obj_YN07_01.value == "是" && obj_YN07_02.value == "") {
		a += "7 应用安全 应用安全技术规范覆盖不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN07_02);
	}
	var obj_YN07_05 = getTableFormObjs(label_YN07_05)[0];
	if (obj_YN07_05.value == "") {
		a += "7 应用安全 网上银行支持的多因素认证方式不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN07_05);
	}
	var obj_YN07_06_01 = getTableFormObjs(label_YN07_06_01)[0];
	var obj_YN07_06_02 = getTableFormObjs(label_YN07_06_02)[0];
	var obj_YN07_06_03 = getTableFormObjs(label_YN07_06_03)[0];
	if (obj_YN07_06_01.value == "") {
		a += "7 应用安全 USB Key是否通过第三方测评机构的安全检测不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN07_06_01);
	} else if (obj_YN07_06_01.value == "是") {
		if (obj_YN07_06_02.value == "") {
			a += "7 应用安全 USB Key是否通过第三方测评机构的安全检测 测评机构名称不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN07_06_02);
		}
		if (obj_YN07_06_03.value == "") {
			a += "7 应用安全 USB Key是否通过第三方测评机构的安全检测 最近一次检测时间不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN07_06_03);
		}
	}
	var obj_YN07_07 = getTableFormObjs(label_YN07_07)[0];
	if (obj_YN07_07.value == "") {
		a += "7 应用安全 手机银行支持多因素认证方式不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN07_07);
	}
	var obj_YN07_08 = getTableFormObjs(label_YN07_08)[0];
	var obj_YN07_09 = getTableFormObjs(label_YN07_09)[0];
	if (obj_YN07_08.value == "") {
		a += "7 应用安全 网上银行客户证书签发机构不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN07_08);
	} else if (obj_YN07_08.value == "第三方CA机构") {
		if (obj_YN07_09.value == "") {
			a += "7 应用安全 网上银行客户证书签发机构 机构名称不能为空\n";
			isValid = false;
			errorObjs.push(obj_YN07_09);
		}

	}
	// 数据安全
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02, obj_YN08_01.rownumber);
	if (obj_YN08_01.value == "") {
		a += "8 数据安全 建立专门的数据管理组织不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_01);
	} else if (obj_YN08_01.value == "是" && obj_YN08_02.value == "") {
		a += "8 数据安全 建立专门的数据管理组织 组织名称不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_02);
	}
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	if (obj_YN08_03.value == "是" && obj_YN08_04.value == "") {
		a += "8 数据安全 制定数据管理制度和流程覆盖范围不能为空 ";
		isValid = false;
		errorObjs.push(obj_YN08_04);
	}
	var obj_YN08_10 = getTableFormObjs(label_YN08_10)[0];
	if (obj_YN08_10.value == "") {
		a += "8 数据安全 非生产环境使用生产数据时进行脱敏处理不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_10);
	}
	var obj_YN08_13 = getTableFormObjs(label_YN08_13)[0];
	if (obj_YN08_13.value == "") {
		a += "8 数据安全 重要信息系统建立数据清理策略不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_13);
	}
	var obj_YN08_14 = getTableFormObjs(label_YN08_14)[0];
	var obj_YN08_15 = getTableFormObjs(label_YN08_15)[0];
	if (obj_YN08_14.value == "") {
		a += "8 数据安全 对已失效数据或已毁坏但包含重要数据的介质进行销毁不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_14);
	} else if (obj_YN08_14.value == "是" && obj_YN08_15.value == "") {
		a += "8 数据安全 对已失效数据或已毁坏但包含重要数据的介质进行销毁 销毁机构名称不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN08_15);
	}
	var obj_YN09_02 = getTableFormObjs(label_YN09_02)[0];
	if (obj_YN09_02.value == "") {
		a += "9 客户教育安全 加强客户安全教育的宣传渠道不能为空\n";
		isValid = false;
		errorObjs.push(obj_YN09_02);
	}
	// 校验事项类型和
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = 0;
	var obj_YN02_06Value = 0;
	var zgsSum = 0;
	var stSum = 0;
	if (obj_YN02_03.value != "") {
		obj_YN02_03Value = obj_YN02_03.value;
	}
	if (obj_YN02_06.value != "") {
		obj_YN02_06Value = obj_YN02_06.value;
	}
	for ( var i = 0; i < obj_YN02_13.length; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		if (obj_YN02_13_02.value == "总行（或总公司）组织的信息安全检查") {
			zgsSum += 1;
		} else if (obj_YN02_13_02.value == "渗透测试") {
			stSum += 1;
		}

	}
	if(zgsSum != obj_YN02_03Value){
		a+="2 信息安全检查 总行（或总公司）组织开展的信息安全检查数量＝事项类型选择“总行（或总公司）组织的信息安全检查”的数量之和\n";
		errorObjs.push(obj_YN02_03);
		isValid=false;
	}
	if(stSum != obj_YN02_06Value){
		a+="2 信息安全检查 本年度组织的渗透测试次数＝事项类型选择“渗透测试”的数量之和\n";
		errorObjs.push(obj_YN02_06);
		isValid=false;
	}
	//等级保护校验
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObjs(label_YN03_03)[0];
	var obj_YN03_04 = getTableFormObjs(label_YN03_04)[0];
	var obj_YN03_05 = getTableFormObjs(label_YN03_05)[0];
	var obj_YN03_06 = getTableFormObjs(label_YN03_06)[0];
	var sum_03_04_05_06 = parseInt(obj_YN03_03.value) + parseInt(obj_YN03_04.value) + parseInt(obj_YN03_05.value) + parseInt(obj_YN03_06.value);
	if(obj_YN03_02.value != sum_03_04_05_06){
		a+="3 等级保护 已备案信息系统总数＝二级系统个数+三级系统个数+四级系统个数+五级系统个数\n";
		errorObjs.push(obj_YN03_03);
		errorObjs.push(obj_YN03_04);
		errorObjs.push(obj_YN03_05);
		errorObjs.push(obj_YN03_06);
		isValid=false;
	}
	//附件校验
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObjs(label_YN11_02)[0];
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	if(obj_YN11_01.value ==""){
		a+="10 附件 信息安全总体策略文件不能为空";
		errorObjs.push(obj_YN11_01);
		isValid=false;
	}
	if(obj_YN11_02.value ==""){
		a+="10 附件 信息系统定级备案情况表不能为空";
		errorObjs.push(obj_YN11_02);
		isValid=false;
	}
	if(obj_YN11_03.value ==""){
		a+="10 附件 数据管理情况明细报告不能为空";
		errorObjs.push(obj_YN11_03);
		isValid=false;
	}
	//校验复选中其他是否有值
	for(var i = 0;i<checkBoxValueObjs.length;i++){
		var checkBoxObj = checkBoxValueObjs[i];
		if(checkBoxObj.checked){
			var checkBoxObjValueObj= checkBoxObj.parentElement.nextSibling.nextSibling;
			if(checkBoxObjValueObj.value.indexOf("_cev_")<0){
				errorObjs.push(checkBoxObjValueObj.previousSibling);
				a+="其他项内容不能为空！\n";
				isValid=false;
			}
		}
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
 * 功能：通过对已失效数据或已毁坏但包含重要数据的介质进行销毁来判断销毁机构名称是否可填
 * 配置：数据安全#内容#对已失效数据或已毁坏但包含重要数据的介质进行销毁
 */
function setYN08_15Disable(obj) {
	var obj_YN08_14 = getTableFormObjs(label_YN08_14)[0];
	var obj_YN08_15 = getTableFormObj(label_YN08_15, obj_YN08_14.rownumber);
	if (obj_YN08_14.value == "否" || obj_YN08_14.value == "") {
		obj_YN08_15.readOnly = "readonly";
		obj_YN08_15.value = "";
	} else if (obj_YN08_14.value == "是") {
		obj_YN08_15.readOnly = "";
	}
}
/*
 * 功能：通过制定数据管理制度和流程来判断数据管理制度和流程覆盖范围是否可填 配置：数据安全#内容#制定数据管理制度和流程
 */
function setYN08_04Disable(obj) {
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObjs(label_YN08_04)[0];
	if (obj_YN08_03.value == "否" || obj_YN08_03.value == "") {
		// 清空
		obj_YN08_04.onclick = "";
		// 只读
		disableTableCheckBox(obj_YN08_04, true);
	} else if (obj_YN08_03.value == "是") {
		disableTableCheckBox(obj_YN08_04, false);
	}
}

/*
 * 功能：通过制定建立专门的数据管理组织来判断组织名称是否可填 配置：数据安全#内容#建立专门的数据管理组织
 */
function setYN08_02Disable(obj) {
	var obj_YN08_01 = getTableFormObjs(label_YN08_01)[0];
	var obj_YN08_02 = getTableFormObj(label_YN08_02, obj_YN08_01.rownumber);
	if (obj_YN08_01.value == "否" ||obj_YN08_01.value == "") {
		obj_YN08_02.value = "";
		obj_YN08_02.readOnly = "readonly";
	} else if (obj_YN08_01.value == "是") {
		obj_YN08_02.readOnly = "";
	}
}

/*
 * 功能：通过制定应用安全技术规范来判断应用安全技术规范覆盖是否可填 配置：应用安全#内容#制定应用安全技术规范
 */
function setYN07_02Disable(obj) {
	var obj_YN07_01 = getTableFormObjs(label_YN07_01)[0];
	var obj_YN07_02 = getTableFormCheckBox(label_YN07_02, "1_1");
	if (obj_YN07_01.value == "否" || obj_YN07_01.value == "") {
		// 清空
		obj_YN07_02.onclick = "";
		// 只读
		disableTableCheckBox(obj_YN07_02, true);
	} else if (obj_YN07_01.value == "是") {
		disableTableCheckBox(obj_YN07_02, false);
	}
}
/*
 * 功能：通过网上银行客户证书签发机构为来判断机构名称是否可填 配置：应用安全#内容#网上银行客户证书签发机构为
 */
function setYN07_09Disable(obj) {
	var obj_YN07_08 = getTableFormObjs(label_YN07_08)[0];
	var obj_YN07_09 = getTableFormObj(label_YN07_09, obj_YN07_08.rownumber);
	if (obj_YN07_08.value == "自建CA" || obj_YN07_08.value == "") {
		obj_YN07_09.value = "";
		obj_YN07_09.readOnly = "readonly";
	} else if (obj_YN07_08.value == "第三方CA机构") {
		obj_YN07_09.readOnly = "";
	}
}
/*
 * 功能：通过安全检测来决定测评机构名称和最近一次检测时间是否可填 配置：应用安全#内容#网上银行安全监测#如网上银行支持USB Key，USB
 * Key是否通过第三方测评机构的安全检测
 */
function setYN07_06_02_03Disable(obj) {
	var obj_YN07_06_01 = getTableFormObjs(label_YN07_06_01)[0];
	var obj_YN07_06_02 = getTableFormObj(label_YN07_06_02,
			obj_YN07_06_01.rownumber);
	var obj_YN07_06_03 = getTableFormObj(label_YN07_06_03,
			obj_YN07_06_01.rownumber);
	if (obj_YN07_06_01.value == "否" || obj_YN07_06_01.value == "")  {
		obj_YN07_06_02.value = "";
		obj_YN07_06_02.readOnly = "readonly";
		obj_YN07_06_03.value = "";
		obj_YN07_06_03.onclick = "";
	} else if (obj_YN07_06_01.value == "是") {
		obj_YN07_06_03.onclick = click_columnshowDate;
		obj_YN07_06_02.readOnly = "";
	}
}
/*
 * 功能：恢复日期输入
 */
var click_columnshowDate = function() {
	showDate(this);
}
/*
 * 功能：通过终端口令定期强制修改来判断修改周期受否可填 配置：终端安全#内容#终端口令定期强制修改
 */
function setYN06_03Disable(obj) {
	var obj_YN06_03 = getTableFormObjs(label_YN06_03)[0];
	var obj_YN06_04 = getTableFormObj(label_YN06_04, obj_YN06_03.rownumber);
	if (obj_YN06_03.value == "否" || obj_YN06_03.value == "") {
		obj_YN06_04.value = "";
		obj_YN06_04.readOnly = "readonly";
	} else if (obj_YN06_03.value == "是") {
		obj_YN06_04.readOnly = "";
	}
}
/*
 * 功能：定期对主机系统漏洞进行检测来决定检测频率 配置：主机安全#内容#定期对主机系统漏洞进行检测
 */
function setYN05_04Disable(obj) {
	var obj_YN05_03 = getTableFormObjs(label_YN05_03)[0];
	var obj_YN05_04 = getTableFormObj(label_YN05_04, obj_YN05_03.rownumber);
	if (obj_YN05_03.value == "否" || obj_YN05_03.value == "") {
		obj_YN05_04.value = "";
		obj_YN05_04.readOnly = "readonly";
	} else if (obj_YN05_03.value == "是") {
		obj_YN05_04.readOnly = "";
	}
}
/*
 * 功能：通过制定主机安全配置基线来制定主机安全配置基线覆盖范围是否可选 配置：主机安全#内容#制定主机安全配置基线
 */
function setYN05_02Disable(obj) {
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormCheckBox(label_YN05_02, "1_1");
	if (obj_YN05_01.value == "否" ||obj_YN05_01.value == "") {
		// 清空
		obj_YN05_02.onclick = "";
		// 只读
		disableTableCheckBox(obj_YN05_02, true);
	} else if (obj_YN05_01.value == "是") {
		disableTableCheckBox(obj_YN05_02, false);
	}
}
/*
 * 功能：本年度开展的信息安全培训次数与全辖范围的信息安全培训次数比较 配置：信息安全培训#内容#本年度开展的信息安全培训次数#次数
 */
function checkYN04_01_01AndYN04_02_01(obj) {
	var obj_YN04_01_01 = getTableFormObjs(label_YN04_01_01)[0];
	var obj_YN04_02_01 = getTableFormObjs(label_YN04_02_01)[0];
	if (obj_YN04_02_01.value != "") {
		if (obj_YN04_01_01.value == "") {
			obj_YN04_02_01.value = "";

			alert("本年度开展的信息安全培训次数>＝全辖范围的信息安全培训次数");
		} else {
			if (parseInt(obj_YN04_01_01.value) < parseInt(obj_YN04_02_01.value)) {
				obj_YN04_02_01.value = "";
				alert("本年度开展的信息安全培训次数>＝全辖范围的信息安全培训次数");
			}
		}
	}
}
/*
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio0(obj, access, flag) {
	if (!access) {
		obj.value = "";
	}
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					if (!access) {
						imgs[k].src = "images/rb01.gif";
						imgs[k].onclick = "";
					} else {
						if (!flag) {
							imgs[k].onclick = function() {
								columnVallueRadio(this);
							};
						} else {
							imgs[k].onclick = function() {
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
 * 功能：单选按钮的读写设置 参数：obj为单选对象 access当单选可被选时传true，不可被选时传false flag 为是否添加特殊函数调用
 */
function columnVallueRadio1(obj) {
	obj.value = "";
	var objs = obj.parentElement.childNodes;
	if (objs != null) {
		for ( var i = 0; i < objs.length; i++) {
			var imgs = objs[i].childNodes;
			for ( var k = 0; k < imgs.length; k++) {
				if (imgs[k].name == "radioImg") {
					imgs[k].src = "images/rb01.gif";
				}
			}
		}
	}
}
// 点击检查项的事项类型查看数量
function checkYN02_13_02Count(obj) {
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = 0;
	var obj_YN02_06Value = 0;
	var zgsSum = 0;
	var stSum = 0;
	var errorMessage = "";
	var sign = true;
	for ( var i = 0; i < obj_YN02_13.length; i++) {
		var obj_YN02_13_02 = getTableFormObj(label_YN02_13_02,
				obj_YN02_13[i].rownumber);
		if (obj_YN02_13_02.value == "总行（或总公司）组织的信息安全检查") {
			zgsSum += 1;
			if (obj_YN02_03.value != "") {
				obj_YN02_03Value = obj_YN02_03.value;
			}
			if (parseInt(zgsSum) > parseInt(obj_YN02_03Value)) {
				errorMessage = "总行（或总公司）组织开展的信息安全检查数量＝事项类型选择“总行（或总公司）组织的信息安全检查”的数量之和\n";
				sign = false;
				columnVallueRadio1(obj_YN02_13_02);
			}
		} else if (obj_YN02_13_02.value == "渗透测试") {
			stSum += 1;
			if (obj_YN02_06.value != "") {
				obj_YN02_06Value = obj_YN02_06.value;
			}
			if (parseInt(stSum) > parseInt(obj_YN02_06Value)) {
				errorMessage = "本年度组织的渗透测试次数＝事项类型选择“渗透测试”的数量之和\n";
				sign = false;
				columnVallueRadio1(obj_YN02_13_02);
			}
		}
	}
	if (!sign) {
		alert(errorMessage);
	}

}
// 初始化方法
function initSet() {
	var obj = 0;
	setYN08_15Disable(obj);
	setYN08_04Disable(obj);
	setYN08_02Disable(obj);
	setYN07_02Disable(obj);
	setYN07_09Disable(obj);
	setYN07_06_02_03Disable(obj);
	setYN06_03Disable(obj);
	setYN05_04Disable(obj);
	setYN05_02Disable(obj);
	setYN01_05Disable(obj);
}
function checkYN02_02_03Value() {
	var obj_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	if (obj_YN02_03.value != "") {
		if (obj_YN02_02.value == "") {
			obj_YN02_03.value = "";
			alert("本年度信息安全检查总数>＝总行（或总公司）组织的信息安全检查数量");
		} else if (parseInt(obj_YN02_03.value) > parseInt(obj_YN02_02.value)) {
			obj_YN02_03.value = "";
			alert("本年度信息安全检查总数>＝总行（或总公司）组织的信息安全检查数量");
		}
	}
}
/*
 * 功能：发现问题数量是否已整改问题数量 配置：信息安全检查及渗透测试#内容#检查项#发现问题数量（个）
 */
function checkYN02_13_06_07Value(obj) {
	var sign = true;
	var sum1 = 0;
	var sum2 = 0;
	var sum3 = 0;
	var objs = getTableFormObjs(label_YN02_13);
	var obj_YN02_14_01 = getTableFormObjs(label_YN02_14_01)[0];
	var obj_YN02_14_02 = getTableFormObjs(label_YN02_14_02)[0];
	var obj_YN02_14_03 = getTableFormObjs(label_YN02_14_03)[0];

	for ( var i = 0; i < objs.length; i++) {
		var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
				objs[i].rownumber);
		var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
				objs[i].rownumber);
		if (obj_YN02_13_06.value != "") {
			if (obj_YN02_13_05.value == "") {
				obj_YN02_13_06.value = "";
				obj_YN02_14_03.value = "";
				sign = false;
				obj_YN02_14_02.value = "";
				alert("已发现问题数 >= 已整改问题数");
			} else if (parseInt(obj_YN02_13_06.value) > parseInt(obj_YN02_13_05.value)) {
				obj_YN02_13_06.value = "";
				sign = false;
				obj_YN02_14_02.value = "";
				obj_YN02_14_03.value = "";
				alert("已发现问题数 >= 已整改问题数");
			}
		}
	}
	if (sign) {
		for ( var i = 0; i < objs.length; i++) {
			var obj_YN02_13_05 = getTableFormObj(label_YN02_13_05,
					objs[i].rownumber);
			var obj_YN02_13_06 = getTableFormObj(label_YN02_13_06,
					objs[i].rownumber);
			var obj_YN02_13_05Value = 0;
			var obj_YN02_13_06Value = 0;
			if (obj_YN02_13_05.value == "") {
				obj_YN02_13_05Value = 0;
			} else {
				obj_YN02_13_05Value = obj_YN02_13_05.value;
			}
			if (obj_YN02_13_06.value == "") {
				obj_YN02_13_06Value = 0;
			} else {
				obj_YN02_13_06Value = obj_YN02_13_06.value;
			}
			sum1 += parseInt(obj_YN02_13_05Value);
			sum2 += parseInt(obj_YN02_13_06Value);
		}
		if (sum1 == 0) {
			sum3 = 0;
		} else {
			sum3 = sum2 / sum1 * 100;
		}
		obj_YN02_14_01.value = sum1;
		obj_YN02_14_02.value = sum2;
		obj_YN02_14_03.value = checkNumberFloat(sum3, 2);
	}

}
// 保留小数位数
function checkNumberFloat(obj, len) {
	return Math.round(obj * Math.pow(10, len)) / Math.pow(10, len);
}
/*
 * 功能：专项渗透测试次数是否大于本年度组织的渗透测试次数 配置：信息安全检查及渗透测试#内容#其中聘请外部机构开展的专项渗透测试次数
 */
function checkYN02_06_07Value(obj) {
	var objs = getTableFormObjs(label_YN02_06);
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_07 = getTableFormObjs(label_YN02_07)[0];
	if (obj_YN02_07.value != "") {
		if (obj_YN02_06.value == "") {
			obj_YN02_07.value = "";
			alert("本年度组织的渗透测试次数>＝聘请外部机构开展的专项渗透测试次数");
		} else if (parseInt(obj_YN02_07.value) > parseInt(obj_YN02_06.value)) {
			obj_YN02_07.value = "";
			alert("本年度组织的渗透测试次数>＝聘请外部机构开展的专项渗透测试次数");
		}
	}
}
/*
 * 功能：判断表单内容是否大于100
 */
function checkPercent(obj) {
	if (obj.value > 100) {
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"), 0);
		alert("请按规范填写" + errorMessage + "，数值不能大于100\n");
	}
	if (obj.value < 0) {
		obj.value = "";
		var errorMessage = obj.parentNode.parentNode.innerText;
		errorMessage = errorMessage.substring(errorMessage.lastIndexOf("%"), 0);
		alert("请按规范填写" + errorMessage + "，数值不能小于0\n");
	}
}
/*
 * 功能：通过信息安全管理体系认证来判断认证范围是否能填 配置：信息安全制度建设#内容#认证范围
 */
function setYN01_05Disable(obj) {
	var obj_YN01_04 = getTableFormObjs(label_YN01_04)[0];
	var obj_YN01_05 = getTableFormObjs(label_YN01_05)[0];
	if (obj_YN01_04.value.trim() == "否" || obj_YN01_04.value.trim() == "" ) {
		// 只读
		obj_YN01_05.readOnly = "readonly";
		// 清空
		obj_YN01_05.value = "";
	} else if (obj_YN01_04.value.trim() == "是") {
		obj_YN01_05.readOnly = "";
	}
}
/*
 * 功能：判断表单内容是否大于信息安全管理制度总数 配置：信息安全制度建设#内容#信息安全管理制度总数
 */
function checkItem01(obj) {
	var obj_YN01_01 = getTableFormObjs(label_YN01_01)[0];
	var obj_YN01_02 = getTableFormObj(label_YN01_02, obj_YN01_01.rownumber);
	var obj_YN01_03 = getTableFormObj(label_YN01_03, obj_YN01_01.rownumber);
	if (obj_YN01_02.value.trim() != "" || obj_YN01_03.value.trim() != "") {
		if (obj_YN01_01.value.trim() != "") {
			var message = "";
			if (parseInt(obj_YN01_02.value) > parseInt(obj_YN01_01.value)) {
				message += "信息安全管理制度总数>＝本年度新增数量\n";
				obj_YN01_02.value = "";
			}
			if (parseInt(obj_YN01_03.value) > parseInt(obj_YN01_01.value)) {
				message += "信息安全管理制度总数>＝本年度修订数量	\n";
				obj_YN01_03.value = "";
			}
			if (message) {
				alert(message);
			}
		} else {
			obj_YN01_02.value = "";
			obj_YN01_03.value = "";
			alert("请输入信息安全管理制度总数以及本年度新增数量和本年度修订数量！");
		}

	}
}
// 添加一行
function addRow(obj, insertRowNum) {
	var obj_YN02_03 = getTableFormObjs(label_YN02_03)[0];
	var obj_YN02_06 = getTableFormObjs(label_YN02_06)[0];
	var obj_YN02_13 = getTableFormObjs(label_YN02_13);
	var obj_YN02_03Value = obj_YN02_03.value;
	var obj_YN02_06Value = obj_YN02_06.value;
	if (obj_YN02_03Value == "") {
		obj_YN02_03Value = 0;
	}
	if (obj_YN02_06Value == "") {
		obj_YN02_06Value = 0;
	}
	var sumTr = parseInt(obj_YN02_03Value) + parseInt(obj_YN02_06Value);
	if (parseInt(obj_YN02_13.length) > sumTr) {
		alert("表格行数已足够填写，不需要增加多余行");
		return null;
	} else {
		//需要添加行的table对象
		var targetTab = obj.parentElement.parentElement;
		//模板对象
		var templateTab = document.getElementById(targetTab.id + "_template");
		//是否显示行号 Y 显示； N 不显示
		var showrownum = targetTab.showrownum;
		//遍历模板对象，将其内容添加到当前table对象中
		var tr = null;
		for(var i=0;i<templateTab.rows.length;i++){
			//需要添加的行对象
			//判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
			if(insertRowNum != null){
				tr = targetTab.insertRow(insertRowNum);
			}else{
				tr = targetTab.insertRow(targetTab.rows.length);
			}
			//设定新行的右键菜单
			tr.className = "rightMenu";
			tr.oncontextmenu = function(){return false;};
			jQuery(tr).unbind("mousedown").mousedown(function(event){
				event.stopPropagation();
				rightMenu(this,event);
			});
			//如果显示行号，预留行号显示位置
			if("Y" == showrownum){
				var indexCell2 = tr.insertCell(0);
				indexCell2.align = "center";
			}
			//遍历模板列，将其添加到当前对象中
			for(var j=0;j<templateTab.rows[i].cells.length;j++){
				var td = tr.insertCell();
				if( templateTab.rows[i].cells[j].style.textAlign){
					td.style.textAlign =  templateTab.rows[i].cells[j].style.textAlign;
				}
				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
			}
			//添加行后，行号有可能被打乱，需要重新排列行号
			shortRowNum(targetTab);
			var onAdd = targetTab.onAdd;
			if(onAdd){
				onAdd(tr);
			}
		}
		
		return tr;
//		// 需要添加行的table对象
//		var targetTab = obj.parentElement.parentElement;
//		// 模板对象
//		var templateTab = document.getElementById(targetTab.id + "_template");
//		// 是否显示行号 Y 显示； N 不显示
//		var showrownum = targetTab.showrownum;
//		// 遍历模板对象，将其内容添加到当前table对象中
//		for ( var i = 0; i < templateTab.rows.length; i++) {
//			// 需要添加的行对象
//			var tr = null;
//			// 判断是否指定了行的添加位置，如果指定，在指定位置添加，如果未指定，默认添加到最后一行
//			if (insertRowNum != null) {
//				tr = targetTab.insertRow(insertRowNum);
//			} else {
//				tr = targetTab.insertRow(targetTab.rows.length - 1);
//			}
//			var delTd = tr.insertCell(0);
//			delTd.align = "center";
//			delTd.innerHTML = '<img src="images/bullet_delete.png" onclick="deleteRow(this);" style="cursor: hand" border="0" />';
//			var idxFlag = 1;
//			// 如果显示行号，预留行号显示位置
//			if ("Y" == showrownum) {
//				idxFlag = 2;
//				var indexCell2 = tr.insertCell(1);
//				indexCell2.align = "center";
//				if (targetTab.rows[0].name == "titlerow") {
//					indexCell2.innerHTML = targetTab.rows.length - 3;
//				} else {
//					indexCell2.innerHTML = targetTab.rows.length - 2;
//				}
//			}
//
//			// 遍历模板列，将其添加到当前对象中
//			for ( var j = 0; j < templateTab.rows[i].cells.length; j++) {
//				var td = tr.insertCell(j + idxFlag);
//				if (templateTab.rows[i].cells[j].style.textAlign) {
//					td.style.textAlign = templateTab.rows[i].cells[j].style.textAlign;
//				}
//				if (templateTab.rows[i].cells[j].style.display) {
//					td.style.display = templateTab.rows[i].cells[j].style.display;
//				}
//				td.innerHTML = templateTab.rows[i].cells[j].innerHTML;
//			}
//			// 添加行后，行号有可能被打乱，需要重新排列行号
//			shortRowNum(targetTab);
//			var onAdd = targetTab.onAdd;
//			if (onAdd) {
//				onAdd(tr);
//			}
//			return tr;
//		}
	}

}
/*
* 功能：点击复选框复选框中的其他，将起放入数组中，在提交的时候校验其他的内容是否为空 
* 
*/
var checkBoxValueObjs = [];
function showOrHiddenTableColumnCheckBoxElse(obj){
	var target = getTarget(obj.parentElement);
	var showTarget = getShowTarget(obj.parentElement);
	if(obj.checked){
		showTarget.style.display = "";
		checkBoxValueObjs.push(obj);
	}else{
		showTarget.value = "";
		showTarget.style.display = "none";
		var checkBoxValue = target.value;
		var strs = checkBoxValue.split("#");
		var valueStr = "";
		for(var i=0;i<strs.length;i++){
			if(strs[i].indexOf("_cev_") < 0){
				valueStr += strs[i] + "#";
			}
		}
		target.value = valueStr.substring(0, valueStr.length - 1);
		
	}
}