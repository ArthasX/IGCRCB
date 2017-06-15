/**T-B-14 网上银行系统安全情况表*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item5 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填表日期";
var label_isempty = "报送空表表格#报送空表";

var label_YN54="安全管理#内容#网上银行系统现状系统建设情况";

var label_YN01 = "安全管理#内容#交易风险等级是否划分";
var label_YN01_01 = "安全管理#内容#高风险交易包括：";
var label_YN01_02 = "安全管理#内容#低风险交易包括";

var label_YN02 = "安全管理#内容#本年度是否实施网上银行系统安全评估";
var label_YN02_01 = "安全管理#内容#评估方式";
var label_YN02_01_01 = "安全管理#内容#机构名称";

var label_YN03 = "安全管理#内容#安全事件管理#是否建立网上银行安全事件的监测、响应及汇报机制";
var label_YN03_01 = "安全管理#内容#安全事件管理#网上银行安全事件报告路线";

var label_YN04 = "安全管理#内容#安全审计#是否已建立了网上银行系统安全审计机制";
var label_YN04_01 = "安全管理#内容#安全审计#安全审计覆盖范围";

var label_YN05 = "通讯安全#内容#网络安全控制措施#网上银行系统与其他业务系统之间是否采取隔离措施";
var label_YN05_01 = "通讯安全#内容#网络安全控制措施#隔离措施";

var label_YN06 = "通讯安全#内容#网络安全控制措施#是否与电信运营商签署DDoS防御服务协议";
var label_YN06_01 = "通讯安全#内容#网络安全控制措施#服务主要内容简述";

var label_YN07 = "通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备";
var label_YN07_01 = "通讯安全#内容#网络安全控制措施#设备品牌及型号";

var label_YN08 = "通讯安全#内容#网络安全控制措施#是否部署入侵检测及入侵防护措施";
var label_YN08_01 = "通讯安全#内容#网络安全控制措施#部署情况";

var label_YN09 = "通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证";
var label_YN09_01 = "通讯安全#内容#会话安全管理措施#措施简述";

var label_YN10 = "通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证";
var label_YN10_01 = "通讯安全#内容#会话安全管理措施#个人网银连接空闲超时关闭时间为";
var label_YN10_02 = "通讯安全#内容#会话安全管理措施#企业网银连接空闲超时关闭时间为";

var label_YN11 = "通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制";
var label_YN11_01_GTZero = "通讯安全#内容#会话安全管理措施#登录失败次数限制为";

var label_YN12 = "数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施";
var label_YN12_01 = "数据安全#内容#数据加密#传输加密协议名称";
var label_YN12_02 = "数据安全#内容#数据加密#加密算法名称";
var label_YN12_03 = "数据安全#内容#数据加密#密钥长度";

var label_YN13 = "数据安全#内容#数据加密#是否对敏感数据进行加密存储";
var label_YN13_01 = "数据安全#内容#数据加密#加密的数据字段包括";

var label_YN14 = "数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施";
var label_YN14_01 = "数据安全#内容#高风险交易数据完整性保护及抗抵赖#措施简述 ";

var label_YN15 = "数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施";
var label_YN15_01 = "数据安全#内容#高风险交易数据完整性保护及抗抵赖#措施简述";

var label_YN16 = "数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施";
var label_YN16_01 = "数据安全#内容#敏感信息防泄露#措施简述";

var label_YN17 = "应用系统安全#内容#网上银行系统上线前是否实施代码安全检测";
var label_YN17_01 = "应用系统安全#内容#检测部门（组织、团队）名称";

var label_YN18 = "应用系统安全#内容#是否使用检测工具实施代码安全检测";
var label_YN18_01 = "应用系统安全#内容#检测工具名称";

var label_YN19 = "应用系统安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施";
var label_YN19_01 = "应用系统安全#内容#检测工具名称";

var label_YN20 = "应用系统安全#内容#是否定期或不定期开展网上银行系统渗透性测试";
var label_YN20_01 = "应用系统安全#内容#测试机构（组织）名称";
var label_YN20_02 = "应用系统安全#内容#年度内开展网银安全渗性测试次数";


var label_YN100 = "应用系统安全#内容#是否具有防网络钓鱼的功能";
var label_YN100_01 = "应用系统安全#内容#发现钓鱼网站数";
var label_YN100_02 = "应用系统安全#内容#关闭钓鱼网站数";

var label_YN52 = "应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测";
var label_YN52_01 = "应用系统安全#内容#第三方机构名称";

var label_YN53 = "应用系统安全#内容#客户端程序是否采取反汇编分析措施";
var label_YN53_01 = "应用系统安全#内容#措施简述";

var label_YN21 = "身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易";
var label_YN21_01 = "身份认证#内容#静态口令#交易限额为";

var label_YN22 = "身份认证#内容#静态口令#是否具备防密码暴力猜解机制";
var label_YN22_01 = "身份认证#内容#静态口令#措施简述";

var label_YN23 = "身份认证#内容#静态口令#是否支持使用扩展安全设备输入密码";
var label_YN23_01 = "身份认证#内容#静态口令#扩展安全设备包括";

var label_YN58 = "身份认证#内容#文件证书#是否支持";
var label_YN58_01 = "身份认证#内容#文件证书#是否强制使用密码保护私钥";
var label_YN58_02 = "身份认证#内容#文件证书#客户证书公私钥对是否在客户端生成";
var label_YN58_03 = "身份认证#内容#文件证书#私钥导出时，客户端是否对客户身份实施验证";
var label_YN58_04 = "身份认证#内容#文件证书#是否支持证书私钥不可导出选项";
var label_YN58_05 = "身份认证#内容#文件证书#证书私钥备份时，是否提示或强制放在移动设备内";
var label_YN58_06 = "身份认证#内容#文件证书#是否对备份的证书私钥进行加密";
var label_YN58_07 = "身份认证#内容#文件证书#备份或恢复证书私钥成功后，是否通过手机短信等第二通信渠道向客户发送提示消息";
var label_YN58_08 = "身份认证#内容#文件证书#客户证书签发机构";
var label_YN58_08_01 = "身份认证#内容#文件证书#机构名称";

var label_YN59 = "身份认证#内容#USB Key#是否支持";
var label_YN59_01 = "身份认证#内容#USB Key#USB Key是否已通过第三方中立测试机构的安全检测";
var label_YN59_01_01 ="身份认证#内容#USB Key#测试机构名称";
var label_YN59_02 = "身份认证#内容#USB Key#USB Key在执行签名等敏感操作时，是否具备操作提示功能，并要求对客户身份实施鉴别";
var label_YN59_03 = "身份认证#内容#USB Key#提示方式包括";
var label_YN59_04 = "身份认证#内容#USB Key#USB Key是否具备PIN码连续错误锁定机制";
var label_YN59_05 = "身份认证#内容#USB Key#客户登出网上银行时是否提示客户断开USB Key";
var label_YN59_06 = "身份认证#内容#USB Key#客户证书签发机构为";
var label_YN59_06_01 = "身份认证#内容#USB Key#机构名称";
var label_YN59_07 = "身份认证#内容#USB Key#客户证书私钥在 USB Key内部生成，不能以任何形式从 USB Key读取或写入私钥";

var label_YN60 = "身份认证#内容#OTP令牌#是否支持";
var label_YN60_01 = "身份认证#内容#OTP令牌#OTP令牌是否启用PIN码保护机制";
var label_YN60_02 = "身份认证#内容#OTP令牌#OTP令牌是否具备PIN码连续错误锁定机制";
var label_YN60_03 = "身份认证#内容#OTP令牌#动态口令的长度是否不少于6位";
var label_YN60_04 = "身份认证#内容#OTP令牌#PIN的长度是否不少于4位";

var label_YN24 = "身份认证#内容#短信动态口令#是否支持";
var label_YN24_01 = "身份认证#内容#短信动态口令#开通手机动态口令时， 使用柜面等人工参与方式验证客户身份并登记手机号码";
var label_YN24_02 = "身份认证#内容#短信动态口令#更改手机号码时，是否对客户的身份实施验证";
var label_YN24_02_01 = "身份认证#内容#短信动态口令#验证方式";
var label_YN24_03 = "身份认证#内容#短信动态口令#动态口令的长度是否不少于6位";
var label_YN24_04 = "身份认证#内容#短信动态口令#手机动态口令的生成是否与转入账户、交易金额等要素相关联";
var label_YN24_05 = "身份认证#内容#短信动态口令#短信中是否提示关键交易要素信息，如转入账户、交易金额等";
var label_YN24_05_01  = "身份认证#内容#短信动态口令#手机动态口令的有效时间为";

var label_YN25 = "身份认证#内容#动态口令卡#是否支持";
var label_YN25_01 = "身份认证#内容#动态口令卡#动态口令卡是否具备PIN码连续错误锁定机制";
var label_YN25_02 = "身份认证#内容#动态口令卡#动态口令卡是否启用PIN码保护机制";
var label_YN25_03 = "身份认证#内容#动态口令卡#动态口令的长度是否不少于6位";
var label_YN25_04 = "身份认证#内容#动态口令卡#PIN的长度是否不少于4位";
var label_YN25_05 = "身份认证#内容#动态口令卡#是否支持基于坐标机制的动态口令卡";
var label_YN25_06 = "身份认证#内容#动态口令卡#基于坐标机制的动态口令卡是否随机产生挑战口令坐标";
var label_YN25_06_01 = "身份认证#内容#动态口令卡#基于坐标机制的动态口令卡的最大使用次数";
var label_YN25_06_02 = "身份认证#内容#动态口令卡#动态口令卡使用有效期";
var label_YN25_07 = "身份认证#内容#动态口令卡#是否使用涂层覆盖等方法保护口令";

var label_YN25_08="安全管理#内容#安全评估网上银行系统安全内部评估主要实施部门（组织）";

/*
* 功能：流程处理页初始化时设置表单权限
* 配置：填报状态和二级审批状态
*/
function initSet(){
	
	obj_YN01_01(getTableFormObj(label_YN01 ,"1_1"));
	obj_YN25_06(getTableFormObjs(label_YN25_06)[0]);
	obj_YN02_01(getTableFormObj(label_YN02 ,"1_1"));
	obj_YN03_01(getTableFormObj(label_YN03 ,"1_1_1"));
	obj_YN04_01(getTableFormObj(label_YN04 ,"1_1_1"));
	obj_YN05_01(getTableFormObj( label_YN05,"1_1_1"));
	obj_YN06_01(getTableFormObj( label_YN06,"1_1_1"));
	obj_YN07_01(getTableFormObj( label_YN07,"1_1_1"));
	obj_YN08_01(getTableFormObj( label_YN08,"1_1_1"));
	obj_YN09_01(getTableFormObj( label_YN09,"1_1_1"));
	obj_YN10_01(getTableFormObj( label_YN10,"1_1_1"));
	obj_YN11_01(getTableFormObj( label_YN11,"1_1_1"));
	obj_YN14_01(getTableFormObj( label_YN14,"1_1_1"));
	obj_YN15_01(getTableFormObj( label_YN15,"1_1_1"));
	obj_YN16_01(getTableFormObj( label_YN16 ,"1_1_1"));
	obj_YN17_01(getTableFormObj( label_YN17,"1_1"));
	obj_YN18_01(getTableFormObj( label_YN18,"1_1"));
	obj_YN20_01(getTableFormObj( label_YN20,"1_1"));
	obj_YN100_01(getTableFormObj(label_YN100 ,"1_1"));
	obj_YN52_01(getTableFormObj( label_YN52,"1_1"));
	obj_YN53_01(getTableFormObj(label_YN53 ,"1_1"));
	obj_YN21_01(getTableFormObj(label_YN21 ,"1_1_1"));
	obj_YN22_01(getTableFormObj(label_YN22 ,"1_1_1"));
	obj_YN12_01(getTableFormObj(label_YN12 ,"1_1_1"));
	obj_YN13_01(getTableFormObj(label_YN13 ,"1_1_1"));
	obj_YN231(getTableFormObj( label_YN23,"1_1_1"));
	obj_YN58(getTableFormObj( label_YN58,"1_1_1"));
	obj_YN58_08(getTableFormObj(label_YN58_08,"1_1_1" ));
	obj_YN62(getTableFormObj( label_YN25,"1_1_1"));
	obj_YN59(getTableFormObj(label_YN59 ,"1_1_1"));
	obj_YN59_01(getTableFormObj(label_YN59_01 ,"1_1_1"));
	obj_YN59_06(getTableFormObj(label_YN59_06 ,"1_1_1"));
	obj_YN60(getTableFormObj( label_YN60,"1_1_1"));
	obj_YN61(getTableFormObj( label_YN24,"1_1_1"));
	obj_YN24_02_01(getTableFormObj( label_YN24_02,"1_1_1"));
	obj_YN24_05_01(getTableFormObj(label_YN24_05 ,"1_1_1"));
	obj_validatenulll(getTableFormObjs(label_YN54)[0]);
}

/*
 * 验证当非空表格时,表头信息不能为空
 */
function checkHeader() {
	// 报送非空表，表头必填
	if (getFormObj(label_header_item1).value.trim() == ""
			|| getFormObj(label_header_item2).value.trim() == ""
			|| getFormObj(label_header_TextField11).value.trim() == ""
			|| getFormObj(label_header_item3).value.trim() == ""
			|| getFormObj(label_header_item4).value.trim() == "") {
		a += "填报部门、填报人、联系电话、责任人、填报日期不能为空！\n";
		isValid = false;
	}
}

var obj_YN1=function(){
	columnVallueRadio(this);
	obj_YN01_01(this);
};
var obj_YN2=function(){
	columnVallueRadio(this);
	obj_YN25_06(this);
};
var obj_YN3=function(){
	columnVallueRadio(this);
	obj_YN02_01(this);
};
var obj_YN4=function(){
	columnVallueRadio(this);
	obj_YN03_01(this);
};
var obj_YN5=function(){
	columnVallueRadio(this);
	obj_YN04_01(this);
};
var obj_YN6=function(){
	columnVallueRadio(this);
	obj_YN05_01(this);
};
var obj_YN7=function(){
	columnVallueRadio(this);
	obj_YN06_01(this);
};
var obj_YN8=function(){
	columnVallueRadio(this);
	obj_YN07_01(this);
};
var obj_YN9=function(){
	columnVallueRadio(this);
	obj_YN08_01(this);
};
var obj_YN10=function(){
	columnVallueRadio(this);
	obj_YN09_01(this);
};
var obj_YN11=function(){
	columnVallueRadio(this);
	obj_YN10_01(this);
};
var obj_YN12=function(){
	columnVallueRadio(this);
	obj_YN11_01(this);
};
var obj_YN13=function(){
	columnVallueRadio(this);
	obj_YN14_01(this);
};
var obj_YN14=function(){
	columnVallueRadio(this);
	obj_YN15_01(this);
};
var obj_YN15=function(){
	columnVallueRadio(this);
	obj_YN16_01(this);
};
var obj_YN16=function(){
	columnVallueRadio(this);
	obj_YN17_01(this);
};
var obj_YN17=function(){
	columnVallueRadio(this);
	obj_YN18_01(this);
};
var obj_YN18=function(){
	columnVallueRadio(this);
	obj_YN20_01(this);
};
var obj_YN19=function(){
	columnVallueRadio(this);
	obj_YN100_01(this);
};
var obj_YN20=function(){
	columnVallueRadio(this);
obj_YN52_01(this);
};
var obj_YN21=function(){
	columnVallueRadio(this);
obj_YN53_01(this);
};
var obj_YN22=function(){
	columnVallueRadio(this);
obj_YN21_01(this);
};
var obj_YN23=function(){
	columnVallueRadio(this);
obj_YN22_01(this);
};
var obj_YN24=function(){
	columnVallueRadio(this);
obj_YN12_01(this);
};
var obj_YN25=function(){
	columnVallueRadio(this);
obj_YN13_01(this);
};
var obj_YN26=function(){
	columnVallueRadio(this);
	obj_YN231(this);
};
var obj_YN27=function(){
	columnVallueRadio(this);
obj_YN58(this);
};
var obj_YN28=function(){
	columnVallueRadio(this);
	obj_YN62(this);
};
var obj_YN29=function(){
	columnVallueRadio(this);
	obj_YN59(this);
};
var obj_YN30=function(){
	columnVallueRadio(this);
	obj_YN59_01(this);
};
var obj_YN31=function(){
	columnVallueRadio(this);
obj_YN59_06(this);
};
var obj_YN32=function(){
	columnVallueRadio(this);
obj_YN60(this);
};
var obj_YN33=function(){
	columnVallueRadio(this);
	obj_YN61(this);
};
var obj_YN34=function(){
	columnVallueRadio(this);
obj_YN24_02_01(this);
};
var obj_YN35=function(){
	columnVallueRadio(this);
obj_YN24_05_01(this);
};
var obj_YN5801=function(){
	columnVallueRadio(this);
	obj_YN58_08(this);
};
var obj_YN24_051=function(){
	columnVallueRadio(this);
	obj_YN24_05_01(this);
};

/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#网上银行系统现状系统建设情况
*/
function obj_validatenulll(obj) {
	var obj_validatenull=getTableFormObjs(label_YN54)[0];
	var obj_item1 = getTableFormObjs(label_header_item1)[0].value;
	var obj_item2 = getTableFormObjs(label_header_item2)[0].value;
	var obj_item3 = getTableFormObjs(label_header_item3)[0].value;
	var obj_item4 = getTableFormObjs(label_header_item4)[0].value;
	var obj_item5 = getTableFormObjs(label_header_item5)[0].value;
	var obj_isempty = getTableFormCheckBox(label_isempty,"1" )[0].checked;
	if (obj_validatenull.value == "尚无系统") {
		// 只读
		onlyRead(true);
	} else/* if(obj_validatenull.value!="")*/ {
		onlyRead(false);
		//getTableFormObj(label_header_item4,"1").onclick=function(){showDate(this);};
		 getTableFormObj(label_YN10_01,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN10_01,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN10_02,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN10_02,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN25_06_02,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN25_06_02,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN25_06_01,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN25_06_01,"1_1_1").readOnly = "readOnly";
		 getTableFormObj(label_YN11_01_GTZero,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN11_01_GTZero,"1_1_1").readOnly = "readOnly";
		 getTableFormObj(label_YN20_02,"1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN20_02,"1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN100_01,"1_1"  ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN100_01,"1_1"  ).readOnly = "readOnly";
		 getTableFormObj(label_YN100_02,"1_1"  ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN100_02,"1_1"  ).readOnly = "readOnly";
		 getTableFormObj(label_YN21_01,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN21_01,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN12_03,"1_1_1" ).onclick=click_columnValueNumber;
		 getTableFormObj(label_YN12_03,"1_1_1" ).readOnly = "readOnly";
		 getTableFormObj(label_YN24_05_01,"1_1_1").onclick=click_columnValueNumber;
		 getTableFormObj(label_YN24_05_01,"1_1_1").readOnly = "readOnly";

		 columnVallueRadio3(getTableFormObj(label_YN01,"1_1" ),obj_YN1);
		 columnVallueRadio3(getTableFormObj(label_YN25_06,"1_1_1" ),obj_YN2);
		 columnVallueRadio3(getTableFormObj(label_YN02,"1_1" ),obj_YN3);
		 columnVallueRadio3(getTableFormObj(label_YN03,"1_1_1" ),obj_YN4);
		 columnVallueRadio3(getTableFormObj(label_YN04,"1_1_1" ),obj_YN5);
		 columnVallueRadio3(getTableFormObj(label_YN05,"1_1_1" ),obj_YN6);
		 columnVallueRadio3(getTableFormObj(label_YN06,"1_1_1" ),obj_YN7);
		 columnVallueRadio3(getTableFormObj(label_YN07,"1_1_1" ),obj_YN8);
		 columnVallueRadio3(getTableFormObj(label_YN08,"1_1_1" ),obj_YN9);
		 columnVallueRadio3(getTableFormObj(label_YN09,"1_1_1" ),obj_YN10);
		 columnVallueRadio3(getTableFormObj(label_YN10,"1_1_1" ),obj_YN11);
		 columnVallueRadio3(getTableFormObj(label_YN11,"1_1_1" ),obj_YN12);
		 columnVallueRadio3(getTableFormObj(label_YN14,"1_1_1"),obj_YN13);
		 columnVallueRadio3(getTableFormObj(label_YN20,"1_1" ),obj_YN18);
		 columnVallueRadio3(getTableFormObj(label_YN100,"1_1" ),obj_YN19);
//		 columnVallueRadio3(getTableFormObj(label_YN14,"1_1_1" ),obj_YN15);
		 columnVallueRadio3(getTableFormObj(label_YN15,"1_1_1" ),obj_YN14);
		 columnVallueRadio3(getTableFormObj(label_YN16,"1_1_1" ),obj_YN15);
		 columnVallueRadio3(getTableFormObj(label_YN17,"1_1" ),obj_YN16);
		 columnVallueRadio3(getTableFormObj(label_YN18,"1_1" ),obj_YN17);
		 columnVallueRadio3( getTableFormObj( label_YN52,"1_1"),obj_YN20);
		 columnVallueRadio3(getTableFormObj(label_YN53 ,"1_1"),obj_YN21);
		 columnVallueRadio3(getTableFormObj(label_YN21 ,"1_1_1"),obj_YN22);
		 columnVallueRadio3(getTableFormObj(label_YN22 ,"1_1_1"),obj_YN23);
		 columnVallueRadio3(getTableFormObjs(label_YN12)[0],obj_YN24);
		 columnVallueRadio3(getTableFormObjs(label_YN13)[0],obj_YN25);
		 columnVallueRadio3(getTableFormObjs(label_YN13)[0],obj_YN25);
		 columnVallueRadio3( getTableFormObj(label_YN23 ,"1_1_1"),obj_YN26);
		 columnVallueRadio3(getTableFormObj( label_YN58,"1_1_1"),obj_YN27);
		 columnVallueRadio3( getTableFormObj( label_YN25,"1_1_1"),obj_YN28);
		 columnVallueRadio3(getTableFormObj(label_YN59 ,"1_1_1"),obj_YN29);
		 columnVallueRadio3( getTableFormObj(label_YN59_01 ,"1_1_1"),obj_YN30);
		 columnVallueRadio3(  getTableFormObj(label_YN59_06,"1_1_1" ),obj_YN31);
		 columnVallueRadio3(  getTableFormObj( label_YN60,"1_1_1"),obj_YN32);
		 columnVallueRadio3(  getTableFormObj( label_YN24,"1_1_1"),obj_YN33);
		 columnVallueRadio3(  getTableFormObj( label_YN24_02,"1_1_1"),obj_YN34);
		 columnVallueRadio3(  getTableFormObj(label_YN24_05 ,"1_1_1"),obj_YN35);
		 columnVallueRadio3(  getTableFormObj(label_YN58_08,"1_1_1" ),obj_YN5801);
		 columnVallueRadio3(getTableFormObj(label_YN24_05 ,"1_1_1"),obj_YN24_051);

	}
	getTableFormObj(label_header_item1,"1").readOnly="";
	getTableFormObj(label_header_item1,"1").value=obj_item1;
	getTableFormObj(label_header_item2,"1").readOnly="";
	getTableFormObj(label_header_item2,"1").value=obj_item2;
	getTableFormObj(label_header_item3,"1").readOnly="";
	getTableFormObj(label_header_item3,"1").value=obj_item3;
	getTableFormObj(label_header_item4,"1").readOnly="";
	getTableFormObj(label_header_item4,"1").value=obj_item4;
	getTableFormObj(label_header_item5,"1").readOnly="";
	getTableFormObj(label_header_item5,"1").value=obj_item5;
	getTableFormObj(label_header_item4,"1").onclick=function(){showDate(this);};
	getTableFormCheckBox(label_isempty,"1" )[0].checked=obj_isempty;
	if(obj_isempty)getTableFormObjs(label_isempty)[0].value = "报送空表";
	getTableFormCheckBox(label_isempty,"1" )[0].disabled=false;
	columnVallueRadio2(getTableFormObjs(label_YN54)[0],"obj_validatenulll(this);");
}
/*
* 功能：清空checkbox值
*/
function getbox(obj) {
	var checkvalues=obj.parentElement.parentElement.childNodes;
	for(var i=0;i<checkvalues.length;i++){
		if(checkvalues[i]=="column_value"){
			checkvalues[i].value="";
		}
	}
}
/*
 *功能：单选按钮的读写设置
 */
function columnVallueRadio3(obj,check){
	//alert(obj.outerHTML);
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs = objs[i].childNodes;
			for(var k=0;k<imgs.length;k++){
				if(imgs[k].name == "radioImg"){
						imgs[k].onclick = check;
				}
			}
		}
	}
}

/*
* 功能：控制整个表单是否可选
* 	     清除所有表单存放于文本框的值（除表头）
* 	     清除所有多选的值（除了报送空表）
* 	     清除所有文本域的值
*/
function onlyRead(access){  
	var divs = document.getElementsByTagName("div");
	var inputs=document.getElementsByTagName("input");
	var imgs=document.getElementsByTagName("img");
		for(var k=0;k<imgs.length;k++){
			if(imgs[k].name == "radioImg"){
				if(access){
					if(imgs[k].flag=="尚无系统"){
						imgs[k].src = "images/rb02.gif";
					}else{
						imgs[k].src = "images/rb01.gif";
					}
					imgs[k].onclick = "";
				}else{
					if(imgs[k].flag==""){
						imgs[k].onclick = function(){
							columnVallueRadioElse(this);
						};	
					}else{
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
		for(var i=0;i<inputs.length;i++){
			var obj=inputs[i];
			if(obj.type=='text'){   
				obj.setAttribute("readOnly",access);
				if(access){
					obj.value=""; 
					obj.onclick="";
				}
			}
			if(obj.type == "hidden" && obj.name == "column_value" && access ){
				if(obj.vlaue != "报送空表" && obj.value != "尚无系统"){
					obj.value = "";
				}
			}
			if(obj.type=='checkbox'){ 
				if(access && obj.value != "报送空表"){
					//obj.value="";
					obj.checked=false;
				}
				obj.disabled=access;
				
			}
		}
		for(var i = 0; i < divs.length; i++){
			obj = divs[i];
			if(obj.className == "editDiv"){ 
				obj.contentEditable = !access;
				if(access)
				obj.innerHTML = "";
			}
		}
}
/*
 *功能：单选按钮复原
 */
function columnVallueRadio2(obj,onclickname){
	var objs = obj.parentElement.childNodes;
	if(objs != null){
		for(var i=0;i<objs.length;i++){
			var imgs=objs[i].childNodes;
				for(var k=0;k<imgs.length;k++){
					if(imgs[k].name == "radioImg"){
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								obj_validatenulll(this);
							};	
						}else{
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								obj_validatenulll(this);
							};
						}
					}
				}
		}
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："安全管理#内容#交易风险等级是否划分;
*/
function obj_YN01_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN01 = getTableFormObj(label_YN01,"1_1");
	var obj_YN01_01 = getTableFormCheckBox(label_YN01_01,"1_1");
	var obj_YN01_02 = getTableFormCheckBox(label_YN01_02,"1_1");
	if (obj_YN01.value == "否") {
		// 只读
		obj_YN01_01.onclick = "";
		obj_YN01_02.onclick = "";
		// 清空
		disableTableCheckBox(obj_YN01_01,true);
		disableTableCheckBox(obj_YN01_02,true);
		//getEditDiv(obj_item24).innerHTML = "";
		//delSingleTableColumnFileInput(obj_item25);
	} else if (obj_YN01.value == "是") {
		// 还原
		obj_YN01_01.onclick = "";
		obj_YN01_02.onclick = "";
		disableTableCheckBox(obj_YN01_01,false);
		disableTableCheckBox(obj_YN01_02,false);

	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#本年度是否实施网上银行系统安全评估;
*/
function obj_YN02_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN02=getTableFormObj(label_YN02 ,"1_1");
	var obj_YN02_01 = getTableFormObj(label_YN02_01,"1_1");
	var obj_YN02_01_01 = getTableFormObj(label_YN02_01_01,"1_1");
	if (obj_YN02.value == "否") {
		// 只读
		obj_YN02_01.onclick = "";
		obj_YN02_01_01.onclick = "";
		// 清空
		columnVallueRadio1(obj_YN02_01,false);
		obj_YN02_01_01.value="";
		obj_YN02_01_01.readOnly="readonly";
	} else if (obj_YN02.value == "是") {
		// 还原
		obj_YN01_01.onclick = "";
		columnVallueRadio1(obj_YN02_01,true);
		obj_YN02_01_01.readOnly="";

	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#本年度是否实施网上银行系统安全评估;
*/
function obj_YN03_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN03=getTableFormObj(label_YN03 ,"1_1_1");
	var obj_YN03_01 = getTableFormObj(label_YN03_01,"1_1_1");
	if (obj_YN03.value == "否") {
		// 只读
		obj_YN03_01.onclick = "";
		// 清空
		obj_YN03_01.value="";
		obj_YN03_01.readOnly="readonly";
	} else if (obj_YN03.value == "是") {
		// 还原
		obj_YN03_01.onclick = "";
		obj_YN03_01.readOnly="";
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#安全审计#是否已建立了网上银行系统安全审计机制;
*/
function obj_YN04_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN04=getTableFormObj(label_YN04 ,"1_1_1");
	var obj_YN04_01 = getTableFormCheckBox(label_YN04_01,"1_1_1" );
	if (obj_YN04.value == "否") {
		// 只读
		//obj_YN04_01.onclick = "";
		// 清空
		disableTableCheckBox(obj_YN04_01,true);
	} else if (obj_YN04.value == "是") {
		// 还原
		//obj_YN04_01.onclick = "";
		disableTableCheckBox(obj_YN04_01,false);
	}
}



/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#网络安全控制措施#网上银行系统与其他业务系统之间是否采取隔离措施;
*/
function obj_YN05_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN05=getTableFormObj( label_YN05,"1_1_1");
	var obj_YN05_01 = getTableFormObj(label_YN05_01,"1_1_1" );
	if (obj_YN05.value == "否") {
		// 只读
		// 清空
		obj_YN05_01.value="";
		obj_YN05_01.readOnly="readonly";
	} else if (obj_YN05.value == "是") {
		// 还原
		obj_YN05_01.readOnly="";
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#网络安全控制措施#是否与电信运营商签署DDoS防御服务协议;
*/
function obj_YN06_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN06=getTableFormObj( label_YN06,"1_1_1");
	var obj_YN06_01 = getTableFormObj(label_YN06_01,"1_1_1" );
	if (obj_YN06.value == "否") {
		// 只读
	
		// 清空
		obj_YN06_01.value="";
		obj_YN06_01.readOnly="readonly";
	} else if (obj_YN06.value == "是") {
		// 还原
		obj_YN06_01.readOnly="";
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备;
*/
function obj_YN07_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN07=getTableFormObj( label_YN07,"1_1_1");
	var obj_YN07_01 = getTableFormObj(label_YN07_01,"1_1_1" );
	if (obj_YN07.value == "否") {
		// 只读
	
		// 清空
		obj_YN07_01.value="";
		obj_YN07_01.readOnly="readonly";
	} else if (obj_YN07.value == "是") {
		// 还原
		obj_YN07_01.readOnly="";
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#网络安全控制措施#是否部署入侵检测及入侵防护措施";
*/
function obj_YN08_01(obj) {
	var obj_YN08=getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormCheckBox(label_YN08_01,obj_YN08.rownumber );
	if (obj_YN08.value == "否") {
		// 只读
		// 清空
		obj_YN08_01.value = "";
		disableTableCheckBox(obj_YN08_01,true);
	} else if (obj_YN08.value == "是") {
		// 还原
		disableTableCheckBox(obj_YN08_01,false);
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证;
*/
function obj_YN09_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN09=getTableFormObj( label_YN09,"1_1_1");
	var obj_YN09_01 = getTableFormObj(label_YN09_01,"1_1_1" );
	if (obj_YN09.value == "否") {
		// 只读
		// 清空
		obj_YN09_01.value="";
		obj_YN09_01.readOnly="readonly";
	} else if (obj_YN09.value == "是") {
		// 还原
		obj_YN09_01.readOnly="";
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证";
*/
function obj_YN10_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10=getTableFormObj( label_YN10,"1_1_1");
	var obj_YN10_01 = getTableFormObj(label_YN10_01,"1_1_1");
	var obj_YN10_02 = getTableFormObj(label_YN10_02,"1_1_1");
	if (obj_YN10.value == "否") {
		// 只读
		obj_YN10_01.onclick = "";
		obj_YN10_02.onclick = "";
		// 清空
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
	} else if (obj_YN10.value == "是") {
		// 还原
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
		obj_YN10_01.onclick = click_columnValueNumber;
		obj_YN10_02.onclick = click_columnValueNumber;
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置："通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制";;
*/
function obj_YN11_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN11=getTableFormObj( label_YN11,"1_1_1");
	var obj_YN11_01 = getTableFormObj(label_YN11_01_GTZero,"1_1_1");
	if (obj_YN11.value == "否") {
		// 只读
		obj_YN11_01.onclick = "";
		// 清空
		obj_YN11_01.value = "";
		obj_YN11_01.onclic="";
	} else if (obj_YN11.value== "是") {
		// 还原
		obj_YN11_01.onclick = click_columnValueNumber;
	}
}



/*
* 功能：点击是否下方表单是否可填
* 配置："数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施";
*/
function obj_YN12_01(obj) {
	
	//var target = getTarget(obj.parentElement);
	var obj_YN12=getTableFormObjs(label_YN12)[0];
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObjs(label_YN12_02)[0];
	var obj_YN12_03 = getTableFormObjs(label_YN12_03)[0];

	if (obj_YN12.value == "否") {
		// 只读
		// 清空
		obj_YN12_01.value = "";
		obj_YN12_01.readOnly="readonly";
		obj_YN12_02.value = "";
		obj_YN12_02.readOnly="readonly";
		obj_YN12_03.value = "";
		obj_YN12_03.onclick = "";
	} else if (obj_YN12.value == "是") {
		// 还原
		obj_YN12_01.readOnly="";
		obj_YN12_02.readOnly="";
		obj_YN12_03.onclick = click_columnValueNumber;
	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#数据加密#是否对敏感数据进行加密存储;
*/
function obj_YN13_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN13=getTableFormObj(label_YN13 ,"1_1_1");
	var obj_YN13_01 = getTableFormObj(label_YN13_01,"1_1_1" );

	if (obj_YN13.value == "否") {
		// 只读
		// 清空
		obj_YN13_01.value = "";
		obj_YN13_01.readOnly="readonly";
	} else if (obj_YN13.value == "是") {
		// 还原
		obj_YN13_01.readOnly="";
	}
}




/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施;
*/
function obj_YN14_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN14=getTableFormObj(label_YN14,"1_1_1");
	var obj_YN14_01 = getTableFormObj(label_YN14_01,"1_1_1");

	if (obj_YN14.value == "否") {
		// 只读
		// 清空
		obj_YN14_01.value = "";
		obj_YN14_01.readOnly="readonly";
	} else if (obj_YN14.value == "是") {
		// 还原
		obj_YN14_01.readOnly="";
	}
}




/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施;
*/
function obj_YN15_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN15=getTableFormObj( label_YN15,"1_1_1");
	var obj_YN15_01 = getTableFormObj(label_YN15_01,"1_1_1");
	if (obj_YN15.value == "否") {
		// 只读
		// 清空
		obj_YN15_01.value = "";
		obj_YN15_01.readOnly="readonly";
	} else if (obj_YN15.value == "是") {
		// 还原
		obj_YN15_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施;
*/
function obj_YN16_01(obj) {
	var obj_YN16=getTableFormObj( label_YN16 ,"1_1_1");
	var obj_YN16_01 = getTableFormObj(label_YN16_01,"1_1_1" );
	if (obj_YN16.value == "否") {
		// 只读
		// 清空
		obj_YN16_01.value = "";
		obj_YN16_01.readOnly="readonly";
	} else if (obj_YN16.value  == "是") {
		// 还原
		obj_YN16_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#网上银行系统上线前是否实施代码安全检测";
*/
function obj_YN17_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN17=getTableFormObj( label_YN17,"1_1");
	var obj_YN17_01 = getTableFormObj(label_YN17_01,"1_1" );

	if (obj_YN17.value == "否") {
		// 只读
		// 清空
		obj_YN17_01.value = "";
		obj_YN17_01.readOnly="readonly";
	} else if (obj_YN17.value == "是") {
		// 还原
		obj_YN17_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#是否使用检测工具实施代码安全检测";
*/
function obj_YN18_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN18=getTableFormObj( label_YN18,"1_1");
	var obj_YN18_01 = getTableFormObj(label_YN18_01,"1_1");
	if (obj_YN18.value == "否") {
		// 只读
		// 清空
		obj_YN18_01.value = "";
		obj_YN18_01.readOnly="readonly";
	} else if (obj_YN18.value == "是") {
		// 还原
		obj_YN18_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置： 应用系统安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施  ;
*/
function obj_YN19_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN19=getTableFormObj(label_YN19,"1_1");
	var obj_YN19_01 = getTableFormObj(label_YN19_01,"1_1" );

	if (obj_YN19.value == "否") {
		// 只读
		// 清空
		obj_YN19_01.value = "";
		obj_YN19_01.readOnly="readonly";
	} else if (obj_YN19.value == "是") {
		// 还原
		obj_YN19_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："应用系统安全#内容#是否定期或不定期开展网上银行系统渗透性测试";
*/
function obj_YN20_01(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN20=getTableFormObj( label_YN20,"1_1");
	var obj_YN20_01 = getTableFormObj(label_YN20_01,"1_1" );
	var obj_YN20_02 = getTableFormObj(label_YN20_02,"1_1" );
	if (obj_YN20.value == "否") {
		// 只读
		// 清空
		obj_YN20_01.value = "";
		obj_YN20_01.readOnly="readonly";
		obj_YN20_02.value = "";
		obj_YN20_02.onclick ="";
	} else if (obj_YN20.value  == "是") {
		// 还原
		obj_YN20_01.value = "";
		obj_YN20_01.readOnly="";
		obj_YN20_02.onclick = click_columnValueNumber;

	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置："应用系统安全#内容#是否具有防网络钓鱼的功能;
*/
function obj_YN100_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN100=getTableFormObj(label_YN100 ,"1_1");
	var obj_YN100_01 = getTableFormObj(label_YN100_01,"1_1");
	var obj_YN100_02 = getTableFormObj(label_YN100_02,"1_1" );
	if (obj_YN100.value== "否") {
		// 只读
		// 清空
		obj_YN100_01.value = "";
		obj_YN100_01.onclick ="";
		obj_YN100_02.value = "";
		obj_YN100_02.onclick ="";
	} else if (obj_YN100.value == "是") {
		// 还原
		obj_YN100_01.onclick = click_columnValueNumber;
		obj_YN100_02.onclick = click_columnValueNumber;

	}
}


/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测;
*/
function obj_YN52_01(obj) {
	var obj_YN52=getTableFormObj( label_YN52,"1_1");
	var obj_YN52_01 = getTableFormObj(label_YN52_01,"1_1" );
	if (obj_YN52.value == "否") {
		// 只读
		// 清空
		obj_YN52_01.value = "";
		obj_YN52_01.readOnly="readonly";
	} else if (obj_YN52.value == "是") {
		// 还原
		obj_YN52_01.readOnly="";

	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："应用系统安全#内容#客户端程序是否采取反汇编分析措施"
*/
function obj_YN53_01(obj) {
	var obj_YN53=getTableFormObj(label_YN53 ,"1_1");
	var obj_YN53_01 = getTableFormObj(label_YN53_01,"1_1" );
	if (obj_YN53.value == "否") {
		// 只读
		// 清空
		obj_YN53_01.value = "";
		obj_YN53_01.readOnly="readonly";
	} else if (obj_YN53.value == "是") {
		// 还原
		obj_YN53_01.readOnly="";

	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易";
*/
function obj_YN21_01(obj) {
	var obj_YN21=getTableFormObj(label_YN21 ,"1_1_1");
	var obj_YN21_01 = getTableFormObj(label_YN21_01,"1_1_1" );
	if (obj_YN21.value== "否") {
		// 只读
		// 清空
		obj_YN21_01.value = "";
		obj_YN21_01.onclick="";
	} else if (obj_YN21.value == "是") {
		// 还原
		obj_YN21_01.onclick = click_columnValueNumber;
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："身份认证#内容#静态口令#是否具备防密码暴力猜解机制";
*/
function obj_YN22_01(obj) {
	var obj_YN22=getTableFormObj(label_YN22 ,"1_1_1");
	var obj_YN22_01 = getTableFormObj(label_YN22_01,"1_1_1" );
	if (obj_YN22.value == "否") {
		// 只读
		// 清空
		obj_YN22_01.value = "";
		obj_YN22_01.readOnly="readonly";
	} else if (obj_YN22.value == "是") {
		// 还原
		obj_YN22_01.readOnly="";

	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置："身份认证#内容#静态口令#是否支持使用扩展安全设备输入密码";
*/
function obj_YN231(obj) {
	var obj_YN23=getTableFormObj(label_YN23 ,"1_1_1");
	var obj_YN23_01 = getTableFormObj(label_YN23_01,"1_1_1");
	if (obj_YN23.value == "否") {
		// 只读
		// 清空
		obj_YN23_01.value = "";
		obj_YN23_01.readOnly="readonly";
	} else if (obj_YN23.value == "是") {
		// 还原
		obj_YN23_01.readOnly="";
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置："身份认证#内容#文件证书#是否支持";
*/
function obj_YN58(obj) {
	var obj_YN58=getTableFormObj( label_YN58,"1_1_1");
	var obj_YN58_01 = getTableFormObj(label_YN58_01,"1_1_1");
	var obj_YN58_02 = getTableFormObj(label_YN58_02,"1_1_1");
	var obj_YN58_03 = getTableFormObj(label_YN58_03,"1_1_1");
	var obj_YN58_04 = getTableFormObj(label_YN58_04,"1_1_1");
	var obj_YN58_05 = getTableFormObj(label_YN58_05,"1_1_1");
	var obj_YN58_06 = getTableFormObj(label_YN58_06,"1_1_1");
	var obj_YN58_07 = getTableFormObj(label_YN58_07,"1_1_1");
	var obj_YN58_08 = getTableFormObj(label_YN58_08,"1_1_1");
	var obj_YN58_08_01 = getTableFormObj(label_YN58_08_01,"1_1_1");
	if (obj_YN58.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN58_01,false);
		columnVallueRadio1(obj_YN58_02,false);
		columnVallueRadio1(obj_YN58_03,false);
		columnVallueRadio1(obj_YN58_04,false);
		columnVallueRadio1(obj_YN58_05,false);
		columnVallueRadio1(obj_YN58_06,false);
		columnVallueRadio1(obj_YN58_07,false);
		columnVallueRadio1(obj_YN58_08,false);
		obj_YN58_08_01.value = "";
		obj_YN58_08_01.readOnly="readonly";
	} else if (obj_YN58.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN58_01,true);
		columnVallueRadio1(obj_YN58_02,true);
		columnVallueRadio1(obj_YN58_03,true);
		columnVallueRadio1(obj_YN58_04,true);
		columnVallueRadio1(obj_YN58_05,true);
		columnVallueRadio1(obj_YN58_06,true);
		columnVallueRadio1(obj_YN58_07,true);
		columnVallueRadio3(obj_YN58_08,obj_YN5801);
		obj_YN58_08_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置："身份认证#内容#文件证书#客户证书签发机构";
*/
function obj_YN58_08(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN58_08_01 = getTableFormObj(label_YN58_08_01,"1_1_1" );
	var obj_YN58_08 = getTableFormObj(label_YN58_08,"1_1_1" );
		if(obj_YN58_08.value == "自建CA"  ){
				obj_YN58_08_01.value = "";
				obj_YN58_08_01.readOnly="readonly";
		}else if(obj_YN58_08.value == "第三方机构CA") {
				obj_YN58_08_01.value = "";
				obj_YN58_08_01.readOnly="";
		}
}



/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#USB Key#是否支持
*/
function obj_YN59(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN59=getTableFormObj(label_YN59 ,"1_1_1");
	var obj_YN59_01 = getTableFormObj(label_YN59_01,"1_1_1" );
	var obj_YN59_01_01 = getTableFormObj(label_YN59_01_01,"1_1_1" );
	var obj_YN59_02 = getTableFormObj(label_YN59_02,"1_1_1" );
	var obj_YN59_03 = getTableFormCheckBox(label_YN59_03,"1_1_1");
	var obj_YN59_04 = getTableFormObj(label_YN59_04,"1_1_1" );
	var obj_YN59_05 = getTableFormObj(label_YN59_05,"1_1_1" );
	var obj_YN59_06 = getTableFormObj(label_YN59_06,"1_1_1" );
	var obj_YN59_06_01 = getTableFormObj(label_YN59_06_01,"1_1_1" );
	var obj_YN59_07 = getTableFormObj(label_YN59_07,"1_1_1" );

	if (obj_YN59.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN59_01,false);
		columnVallueRadio1(obj_YN59_02,false);
	  disableTableCheckBox2(obj_YN59_03,true);
		columnVallueRadio1(obj_YN59_04,false);
		columnVallueRadio1(obj_YN59_05,false);
		columnVallueRadio1(obj_YN59_06,false);
		columnVallueRadio1(obj_YN59_07,false);
		obj_YN59_01_01.value = "";
		obj_YN59_01_01.readOnly="readonly";
		obj_YN59_06_01.value = "";
		obj_YN59_06_01.readOnly="readonly";
	} else if (obj_YN59.value == "是") {
		// 还原
		columnVallueRadio3(obj_YN59_01,obj_YN30);
	//	columnVallueRadio1(obj_YN59_01,true);
		columnVallueRadio1(obj_YN59_02,true);
		disableTableCheckBox2(obj_YN59_03,false);
		columnVallueRadio1(obj_YN59_04,true);
		columnVallueRadio1(obj_YN59_05,true);
		columnVallueRadio3(obj_YN59_06,obj_YN31);
		columnVallueRadio1(obj_YN59_07,true);
		obj_YN59_01_01.readOnly="";
		obj_YN59_06_01.readOnly="";
	}
}
//将表格式表单的复选框变为只读或可写
function disableTableCheckBox2(objs,flag){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			objs[i].disabled = flag;
			if(flag){
				objs[i].checked = false;
			}
		}
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#USB Key#USB Key是否已通过第三方中立测试机构的安全检测
*/
function obj_YN59_01(obj) {
	 var obj_YN59_01=getTableFormObj(label_YN59_01 ,"1_1_1");
	var obj_YN59_01_01 = getTableFormObj(label_YN59_01_01,"1_1_1" );
	if (obj_YN59_01.value == "否") {
		// 只读
		// 清空
		obj_YN59_01_01.value = "";
		obj_YN59_01_01.readOnly="readonly";
	} else if (obj_YN59_01.value== "是") {
		// 还原
		obj_YN59_01_01.readOnly="";
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#USB Key#客户证书签发机构为
*/
function obj_YN59_06(obj) {
	var obj_YN59_06=getTableFormObj(label_YN59_06 ,"1_1_1");
	var obj_YN59_06_01 = getTableFormObj(label_YN59_06_01,"1_1_1");
	if (obj_YN59_06.value == "自建CA") {
		// 只读
		// 清空
		obj_YN59_06_01.value = "";
		obj_YN59_06_01.readOnly="readonly";
	} else if (obj_YN59_06.value == "第三方机构CA") {
		// 还原
		obj_YN59_06_01.readOnly="";
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置： 身份认证#内容#OTP令牌#是否支持
*/
function obj_YN60(obj) {
	var	obj_YN60=getTableFormObj( label_YN60,"1_1_1");
	var obj_YN60_01 = getTableFormObj(label_YN60_01,"1_1_1" );
	var obj_YN60_02 = getTableFormObj(label_YN60_02,"1_1_1" );
	var obj_YN60_03 = getTableFormObj(label_YN60_03,"1_1_1");
	var obj_YN60_04 = getTableFormObj(label_YN60_04,"1_1_1");
	if (obj_YN60.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN60_01,false);
		columnVallueRadio1(obj_YN60_02,false);
		columnVallueRadio1(obj_YN60_03,false);
		columnVallueRadio1(obj_YN60_04,false);
	} else if (obj_YN60.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN60_01,true);
		columnVallueRadio1(obj_YN60_02,true);
		columnVallueRadio1(obj_YN60_03,true);
		columnVallueRadio1(obj_YN60_04,true);
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#短信动态口令#是否支持
*/
function obj_YN61(obj) {
	var obj_YN61=getTableFormObj( label_YN24,"1_1_1");
	var obj_YN24_01 = getTableFormObj(label_YN24_01,"1_1_1");
	var obj_YN24_02 = getTableFormObj(label_YN24_02,"1_1_1" );
	var obj_YN24_02_01 = getTableFormObj(label_YN24_02_01,"1_1_1");
	var obj_YN24_03 = getTableFormObj(label_YN24_03,"1_1_1" );
	var obj_YN24_04 = getTableFormObj(label_YN24_04,"1_1_1");
	var obj_YN24_05 = getTableFormObj(label_YN24_05,"1_1_1");
	var obj_YN24_05_01 = getTableFormObj(label_YN24_05_01,"1_1_1" );
	if (obj_YN61.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN24_01,false);
		columnVallueRadio1(obj_YN24_02,false);
		columnVallueRadio1(obj_YN24_03,false);
		columnVallueRadio1(obj_YN24_04,false);
		columnVallueRadio1(obj_YN24_05,false);
		obj_YN24_02_01.value = "";
		obj_YN24_02_01.readOnly="readonly";
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = "";
	} else if (obj_YN61.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN24_01,true);
		columnVallueRadio3(obj_YN24_02,obj_YN34);
		columnVallueRadio1(obj_YN24_03,true);
		columnVallueRadio1(obj_YN24_04,true);
		columnVallueRadio3(obj_YN24_05,obj_YN24_051);
		obj_YN24_02_01.readOnly="";
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = click_columnValueNumber;
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置： 身份认证#内容#短信动态口令#更改手机号码时，是否对客户的身份实施验证
*/
function obj_YN24_02_01(obj) {
	var obj_YN24_02=getTableFormObj( label_YN24_02,"1_1_1");
	var obj_YN24_02_01 = getTableFormObj(label_YN24_02_01,"1_1_1");
	if (obj_YN24_02.value == "否") {
		// 只读
		// 清空
		obj_YN24_02_01.value = "";
		obj_YN24_02_01.readOnly="readonly";
	} else if (obj_YN24_02.value == "是") {
		// 还原
		obj_YN24_02_01.readOnly="";
		
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#短信动态口令#短信中是否提示关键交易要素信息，如转入账户、交易金额等
*/
function obj_YN24_05_01(obj) {
	var obj_YN24_05=getTableFormObj(label_YN24_05 ,"1_1_1");
	var obj_YN24_05_01 = getTableFormObj(label_YN24_05_01,"1_1_1");
	if (obj_YN24_05.value == "否") {
		// 只读
		// 清空
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = "";
	} else if (obj_YN24_05.value == "是") {
		// 还原
		obj_YN24_05_01.value = "";
		obj_YN24_05_01.onclick = click_columnValueNumber;
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置： 身份认证#内容#动态口令卡#是否支持
*/
function obj_YN62(obj) {
	var obj_YN62=getTableFormObj( label_YN25,"1_1_1");
	var obj_YN25_01 = getTableFormObj(label_YN25_01,"1_1_1");
	var obj_YN25_02 = getTableFormObj(label_YN25_02,"1_1_1");
	var obj_YN25_03 = getTableFormObj(label_YN25_03,"1_1_1");
	var obj_YN25_04 = getTableFormObj(label_YN25_04,"1_1_1");
	var obj_YN25_05 = getTableFormObj(label_YN25_05,"1_1_1");
	var obj_YN25_06 = getTableFormObj(label_YN25_06,"1_1_1");
	var obj_YN25_06_01 = getTableFormObj(label_YN25_06_01,"1_1_1");
	var obj_YN25_06_02 = getTableFormObj(label_YN25_06_02,"1_1_1"); 
	var obj_YN25_07 = getTableFormObj(label_YN25_07,"1_1_1");

	if (obj_YN62.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN25_01,false);
		columnVallueRadio1(obj_YN25_02,false);
		columnVallueRadio1(obj_YN25_03,false);
		columnVallueRadio1(obj_YN25_04,false);
		columnVallueRadio1(obj_YN25_05,false);
		columnVallueRadio1(obj_YN25_06,false);
		columnVallueRadio1(obj_YN25_07,false);
		obj_YN25_06_01.value = "";
		obj_YN25_06_01.onclick = "";
		obj_YN25_06_02.value = "";
		obj_YN25_06_02.onclick = "";
	} else if (obj_YN62.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN25_01,true);
		columnVallueRadio1(obj_YN25_02,true);
		columnVallueRadio1(obj_YN25_03,true);
		columnVallueRadio1(obj_YN25_04,true);
		columnVallueRadio1(obj_YN25_05,true);
		columnVallueRadio3(obj_YN25_06,obj_YN2);
		columnVallueRadio1(obj_YN25_07,true);
		obj_YN25_06_01.onclick = click_columnValueNumber;
		obj_YN25_06_02.onclick = click_columnValueNumber;
	}
}
/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#动态口令卡#基于坐标机制的动态口令卡是否随机产生挑战口令坐标
*/
function obj_YN25_06(obj) {
	//var target = getTarget(obj.parentElement);
	var obj_YN25_06=getTableFormObjs(label_YN25_06)[0];
	var obj_YN25_06_01 = getTableFormObjs(label_YN25_06_01)[0];
	var obj_YN25_06_02 = getTableFormObjs(label_YN25_06_02)[0]; 
	if (obj_YN25_06.value == "否") {
		// 只读
		// 清空
		obj_YN25_06_01.value = "";
		obj_YN25_06_01.onclick = "";
		obj_YN25_06_02.value = "";
		obj_YN25_06_02.onclick = "";
	} else if (obj_YN25_06.value == "是") {
		// 还原
		obj_YN25_06_01.onclick = click_columnValueNumber;
		obj_YN25_06_02.onclick = click_columnValueNumber;
	}
}

/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	if (!checkEmptyReport()) {
		return true;
	}
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	if (getTableFormObj(label_YN54,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN54,"1_1" ).parentElement);
		a+="网上银行 1、安全管理-系统建设情况不能为空\n";
		isValid=false;
	} 
	if (getTableFormObj(label_YN01,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN01,"1_1" ).parentElement);
		a+="网上银行 1、安全管理－交易风险等级划分不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj(label_YN25_08,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN25_08,"1_1" ).parentElement);
		a+="网上银行 1、安全管理-网上银行系统安全内部评估主要实施部门：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj(label_YN02,"1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj(label_YN02,"1_1" ).parentElement);
		a+="网上银行 1、安全管理－本年度是否实施网上银行系统安全评估不能为空！\n";
		isValid=false;
	}
	if (getTableFormObjs(label_YN03)[0].value.trim() == "") {
		errorObjs.push(getTableFormObjs(label_YN03)[0].parentElement);
		a+="网上银行 1、安全管理-是否建立网上银行安全事件的监测、响应及汇报机制：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("安全管理#内容#应急管理#是否针对网上银行系统建立了应急管理机制","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("安全管理#内容#应急管理#是否针对网上银行系统建立了应急管理机制","1_1_1" ).parentElement);
		a+="网上银行 1、安全管理-是否针对网上银行系统建立了应急管理机制不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("安全管理#内容#应急管理#应急计划是否定期演练","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("安全管理#内容#应急管理#应急计划是否定期演练","1_1_1" ).parentElement);
		a+="网上银行 1、安全管理-应急计划是否定期演练不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("安全管理#内容#安全审计#是否已建立了网上银行系统安全审计机制","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("安全管理#内容#安全审计#是否已建立了网上银行系统安全审计机制","1_1_1" ).parentElement);
		a+="网上银行 1、安全管理-是否建立网上银行系统安全审计机制不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("安全管理#内容#应用系统日志#是否进行网上银行安全前沿技术和风险趋势进行跟踪和分析","1_1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("安全管理#内容#应用系统日志#是否进行网上银行安全前沿技术和风险趋势进行跟踪和分析","1_1_1" ).parentElement);
		a+="网上银行 1、安全管理-是否进行网上银行安全前沿技术和风险趋势进行跟踪和分析:不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("客户安全教育#客户风险意识加强#网上银行服务协议中是否包含安全风险提示内容","1_1" ).value.trim() == "") {
		errorObjs.push(getTableFormObj("客户安全教育#客户风险意识加强#网上银行服务协议中是否包含安全风险提示内容","1_1" ).parentElement);
		a+="网上银行 2、客户安全教育-网上银行服务协议中是否包含安全风险提示内容：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("客户安全教育#客户风险意识加强#通过何种宣传渠道加强客户教育","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("客户安全教育#客户风险意识加强#通过何种宣传渠道加强客户教育","1_1").parentElement);
		a+="网上银行 2、客户安全教育-通过何种宣传渠道加强客户教育：不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#互联网与DMZ区之间的隔离措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#互联网与DMZ区之间的隔离措施","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-互联网与DMZ区之间的隔离措施：不能为空！\n";
		isValid=false;
	}

	if (getTableFormObj("通讯安全#内容#网络安全控制措施#DMZ区与内网之间的隔离措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#DMZ区与内网之间的隔离措施","1_1_1").parentElement);
		a+="	网上银行 3、通讯安全-DMZ区与内网之间的隔离措施 不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#网上银行系统与其他业务系统之间是否采取隔离措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#网上银行系统与其他业务系统之间是否采取隔离措施","1_1_1").parentElement);
		a+="	网上银行 3、通讯安全-网上银行系统与其他业务系统之间是否才去隔离；不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#是否采用不同电信运营商的线路，相互备份且互不影响","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#是否采用不同电信运营商的线路，相互备份且互不影响","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-是否采用不同电信运营商的线路，相互备份且互不影响不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#是否与电信运营商签署DDoS防御服务协议","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#是否与电信运营商签署DDoS防御服务协议","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-是否与电信运营商签署DDoS防御服务协议：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备","1_1_1").parentElement);
		a+="	网上银行 3、通讯安全-是否部署DDoS防御服务协议：不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#网络安全控制措施#是否部署DDoS防御设备","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-是否部署入侵检测及入侵防护措施不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-服务器端与客户端之间是否双向认证：不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("通讯安全#内容#会话安全管理措施#网上银行服务器证书颁发机构为","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#会话安全管理措施#网上银行服务器证书颁发机构为","1_1_1"));
		a+="网上银行 3、通讯安全-网上银行服务器证书颁发机构不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制","1_1_1").parentElement);
		a+="网上银行 3、通讯安全-是否具备连续登录失败锁定机制：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("通讯安全#内容#会话安全管理措施#登录失败次数限制为","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("通讯安全#内容#会话安全管理措施#登录失败次数限制为","1_1_1"));
		a+="网上银行 “3、通讯安全-登录失败次数限制”不能为空!\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#数据加密#是否制订网上银行密钥管理制度，对密钥生命周期进行全面管理","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#数据加密#是否制订网上银行密钥管理制度，对密钥生命周期进行全面管理","1_1_1").parentElement);
		a+="网上银行 4、数据安全-是否制订网上银行密钥管理制度，对密钥生命周期进行全面管理：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施","1_1_1").parentElement);
		a+="网上银行 4、数据安全-客户端至服务器端间传输的敏感数据是否采取加密措施：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#数据加密#是否对敏感数据进行加密存储","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#数据加密#是否对敏感数据进行加密存储","1_1_1").parentElement);
		a+="网上银行 4、数据安全-是否对敏感数据进行加密存储：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#数据加密#服务器端主密钥是否采用硬件安全模块（HSM）存储","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#数据加密#服务器端主密钥是否采用硬件安全模块（HSM）存储","1_1_1").parentElement);
		a+="网上银行 4、数据安全-服务器端主密钥是否采用硬件安全模块（HSM）存储：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施","1_1_1").parentElement);
		a+="网上银行 4、数据安全-高风险交易数据的传输是否采取完整性保护措施：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施","1_1_1").parentElement);
		a+="网上银行 4、数据安全-高风险交易数据的传输是否采取抗抵赖措施：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施","1_1_1").parentElement);
		a+="网上银行 4、数据安全-客户端程序是否采取防键盘监听措施：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#敏感信息防泄露#客户端程序是否存储客户敏感信息","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#敏感信息防泄露#客户端程序是否存储客户敏感信息","1_1_1").parentElement);
		a+="网上银行 4、数据安全-客户端程序是否存储客户敏感信息：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#敏感信息防泄露#显示客户敏感信息时，是否实施屏蔽处理","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#敏感信息防泄露#显示客户敏感信息时，是否实施屏蔽处理","1_1_1").parentElement);
		a+="网上银行 4、数据安全-显示客户敏感信息时，是否实施屏蔽处理：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("数据安全#内容#敏感信息防泄露#对敏感客户参数修改时，是否要求进行二次认证","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("数据安全#内容#敏感信息防泄露#对敏感客户参数修改时，是否要求进行二次认证","1_1_1").parentElement);
		a+="网上银行 4、数据安全-对敏感客户参数修改时，是否要求进行二次认证：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#网上银行系统上线前是否实施代码安全检测","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#网上银行系统上线前是否实施代码安全检测","1_1").parentElement);
		a+="网上银行 5、应用系统安全-网上银行系统上线前是否实施代码安全检测:不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#是否使用检测工具实施代码安全检测","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#是否使用检测工具实施代码安全检测","1_1").parentElement);
		a+="网上银行 5、应用系统安全-使用检测工具实施代码安全检测:不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#是否定期或不定期开展网上银行系统渗透性测试","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#是否定期或不定期开展网上银行系统渗透性测试","1_1").parentElement);
		a+="网上银行 5、应用系统安全-是否定期或不定期开展网上银行系统渗透性测试：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#是否具有防网络钓鱼的功能","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#是否具有防网络钓鱼的功能","1_1").parentElement);
		a+="网上银行 5、应用系统安全-是否具有防网络钓鱼的功能；不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#是否向客户提示历史登录信息","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#是否向客户提示历史登录信息","1_1").parentElement);
		a+="网上银行 5、应用系统安全-是否向客户提示历史登录信息：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#是否支持用户查询登录记录","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#是否支持用户查询登录记录","1_1").parentElement);
		a+="网上银行 5、应用系统安全-是否支持用户查询登录记录：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测","1_1").parentElement);
		a+="网上银行 5、应用系统安全-客户端程序是否经过第三方中立测试机构的安全检测：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#客户端程序是否已作数字签名","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#客户端程序是否已作数字签名","1_1").parentElement);
		a+="网上银行 5、应用系统安全-客户端程序是否已作数字签名：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("应用系统安全#内容#客户端程序是否采取反汇编分析措施","1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("应用系统安全#内容#客户端程序是否采取反汇编分析措施","1_1").parentElement);
		a+="网上银行 5、应用系统安全-客户端程序是否采取反汇编分析措施：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#静态口令#首次登录时是否强制客户修改初始密码","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#静态口令#首次登录时是否强制客户修改初始密码","1_1_1").parentElement);
		a+="网上银行 6、身份认证-首次登录时是否强制客户修改初始密码：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易","1_1_1").parentElement);
		a+="网上银行 6、身份认证-仅通过静态口令验证的情况下是否允许进行资金交易：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#静态口令#是否具备防密码暴力猜解机制","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#静态口令#是否具备防密码暴力猜解机制","1_1_1").parentElement);
		a+="网上银行 6、身份认证-是否具备防密码暴力猜解机制：不能为空！\n";
		isValid=false;
	}
	
	if (getTableFormObj("身份认证#内容#静态口令#是否支持使用扩展安全设备输入密码","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#静态口令#是否支持使用扩展安全设备输入密码","1_1_1").parentElement);
		a+="网上银行 6、身份认证-是否支持使用扩展安全设备输入密码：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#文件证书#是否支持","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#文件证书#是否支持","1_1_1").parentElement);
		a+="网上银行 6、身份认证-文件证书 是否支持：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#USB Key#是否支持","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#USB Key#是否支持","1_1_1").parentElement);
		a+="网上银行 6、身份认证-USBKey 是否支持;不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#OTP令牌#是否支持","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#OTP令牌#是否支持","1_1_1").parentElement);
		a+="网上银行 6、身份认证-OTP令牌：是否支持不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#短信动态口令#是否支持","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#短信动态口令#是否支持","1_1_1").parentElement);
		a+="网上银行 6、身份认证-短信动态口令：是否支持：不能为空！\n";
		isValid=false;
	}
	if (getTableFormObj("身份认证#内容#动态口令卡#是否支持","1_1_1").value.trim() == "") {
		errorObjs.push(getTableFormObj("身份认证#内容#动态口令卡#是否支持","1_1_1").parentElement);
		a+="网上银行 6、身份认证-动态口令卡：是否支持不能为空！\n";
		isValid=false;
	}
	
	if(parseInt(getTableFormObj(label_YN100_01,"1_1").value.trim())<parseInt(getTableFormObj(label_YN100_02,"1_1").value.trim())){
		errorObjs.push(getTableFormObj(label_YN100_01,"1_1"));
		errorObjs.push(getTableFormObj(label_YN100_02,"1_1"));
		a+="应用系统安全-发现钓鱼网站数>=应用系统安全-关闭钓鱼网站数出错！\n";
  		isValid=false;
		}
	if(getTableFormObj(label_YN01,"1_1" ).value=="是"){
		var obj1 = getTableFormObj(label_YN01_01,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="安全管理-内容-高风险交易包括：不能为空\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN01_02,"1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="安全管理-内容-低风险交易包括不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN25_06,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN25_06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容#动态口令卡-基于坐标机制的动态口令卡的最大使用次数不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN25_06_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="身份认证-内容-动态口令卡-动态口令卡使用有效期不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN02,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN02_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="安全管理-内容-评估方式不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN02_01_01,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="安全管理-内容-机构名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN03,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN03_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="安全管理-内容-安全事件管理-网上银行安全事件报告路线不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN04,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN04_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj.parentElement);
			a +="安全管理-内容-安全审计-安全审计覆盖范围不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN05_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-网络安全控制措施-隔离措施不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN06,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-网络安全控制措施-服务主要内容简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN07,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN07_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-网络安全控制措施-设备品牌及型号不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN08,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN08_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-网络安全控制措施#部署情况:不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN09_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-会话安全管理措施-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN10_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-会话安全管理措施-个人网银连接空闲超时关闭时间为不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN10_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="通讯安全-内容-会话安全管理措施-企业网银连接空闲超时关闭时间为不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN11_01_GTZero,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-会话安全管理措施-登录失败次数限制为不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN14,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN14_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-高风险交易数据完整性保护及抗抵赖-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN15_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-高风险交易数据完整性保护及抗抵赖-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN16,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN16_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-敏感信息防泄露-#措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN17,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN17_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-检测部门（组织、团队）名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN18,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN18_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-检测工具名不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN20,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN20_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-测试机构（组织）名称不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN20_02,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="应用系统安全-内容-年度内开展网银安全渗性测试次数不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN100,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN100_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-发现钓鱼网站数不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN100_02,"1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="应用系统安全-内容-关闭钓鱼网站数不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN52,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN52_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-第三方机构名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN53,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN53_01,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN21,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN21_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容#静态口令-交易限额为不能为空\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN22,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN22_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-静态口令-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN12,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN12_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-数据加密-传输加密协议名称不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN12_02,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="数据安全-内容-数据加密-加密算法名称不能为空\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN12_03,"1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="数据安全-内容-数据加密-密钥长度不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN13_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容#数据加密-加密的数据字段包括不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN23,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN23_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-静态口令-扩展安全设备包括不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN59_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN59_01_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-USB Key-测试机构名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN59_06,"1_1_1" ).value=="第三方机构CA"){
		var obj = getTableFormObj(label_YN59_06_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-USB Key：第三方CA机构名称”不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN24_02,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN24_02_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-短信动态口令-验证方式不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN24_05,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN24_05_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-短信动态口令-手机动态口令的有效时间为不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN58_08,"1_1_1" ).value=="第三方机构CA"){
		var obj = getTableFormObj(label_YN58_08_01,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-文件证书：第三方CA机构名称”不能为空!\n";
			isValid = false;
		}
	}
	

	if(getTableFormObjs("身份认证#内容#USB Key#是否支持")[0].value=="是"){
		if(getTableFormObjs("身份认证#内容#USB Key#USB Key是否已通过第三方中立测试机构的安全检测")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#USB Key是否已通过第三方中立测试机构的安全检测")[0].parentElement);
			a +="网上银行 “6、身份认证-USB Key是否已通过第三方中立测试机构的安全检测：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#USB Key#客户证书私钥在 USB Key内部生成，不能以任何形式从 USB Key读取或写入私钥")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#客户证书私钥在 USB Key内部生成，不能以任何形式从 USB Key读取或写入私钥")[0].parentElement);
			a +="网上银行 “6、身份认证-客户证书私钥在 USB Key内部生成，不能以任何形式从 USB Key读取或写入私钥：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#USB Key#USB Key在执行签名等敏感操作时，是否具备操作提示功能，并要求对客户身份实施鉴别")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#USB Key在执行签名等敏感操作时，是否具备操作提示功能，并要求对客户身份实施鉴别")[0].parentElement);
			a +="网上银行 “6、身份认证-USB Key在执行签名等敏感操作时，是否具备操作提示功能，并要求对客户身份实施鉴别：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#USB Key#USB Key是否具备PIN码连续错误锁定机制")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#USB Key是否具备PIN码连续错误锁定机制")[0].parentElement);
			a +="网上银行 “6、身份认证-USB Key是否具备PIN码连续错误锁定机制：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#USB Key#客户登出网上银行时是否提示客户断开USB Key")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#客户登出网上银行时是否提示客户断开USB Key")[0].parentElement);
			a +="网上银行 “6、身份认证-客户登出网上银行时是否提示客户断开USB Key：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#USB Key#客户证书签发机构为")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#USB Key#客户证书签发机构为")[0].parentElement);
			a +="网上银行 “6、身份认证-USB Key：客户证书签发机构”不能为空!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("身份认证#内容#OTP令牌#是否支持")[0].value=="是"){
		if(getTableFormObjs("身份认证#内容#OTP令牌#OTP令牌是否启用PIN码保护机制")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#OTP令牌#OTP令牌是否启用PIN码保护机制")[0].parentElement);
			a +="网上银行 “6、身份认证-OTP令牌是否启用PIN码保护机制：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#OTP令牌#OTP令牌是否具备PIN码连续错误锁定机制")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#OTP令牌#OTP令牌是否具备PIN码连续错误锁定机制")[0].parentElement);
			a +="网上银行 “6、身份认证-OTP令牌是否具备PIN码连续错误锁定机制：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#OTP令牌#动态口令的长度是否不少于6位")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#OTP令牌#动态口令的长度是否不少于6位")[0].parentElement);
			a +="网上银行 “6、身份认证-动态口令的长度是否不少于6位：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#OTP令牌#PIN的长度是否不少于4位")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#OTP令牌#PIN的长度是否不少于4位")[0].parentElement);
			a +="网上银行 “6、身份认证-PIN的长度是否不少于4位：”不能为空!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("身份认证#内容#文件证书#是否支持")[0].value=="是"){
		if(getTableFormObjs("身份认证#内容#文件证书#是否强制使用密码保护私钥")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#是否强制使用密码保护私钥")[0].parentElement);
			a +="网上银行 “6、身份认证-是否强制使用密码保护私钥：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#客户证书公私钥对是否在客户端生成")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#客户证书公私钥对是否在客户端生成")[0].parentElement);
			a +="	网上银行 “6、身份认证-客户证书公私钥对是否在客户端生成：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#私钥导出时，客户端是否对客户身份实施验证")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#私钥导出时，客户端是否对客户身份实施验证")[0].parentElement);
			a +="	网上银行 “6、身份认证-私钥导出时，客户端是否对客户身份实施验证：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#是否支持证书私钥不可导出选项")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#是否支持证书私钥不可导出选项")[0].parentElement);
			a +="网上银行 “6、身份认证-是否支持证书私钥不可导出选项：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#证书私钥备份时，是否提示或强制放在移动设备内")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#证书私钥备份时，是否提示或强制放在移动设备内")[0].parentElement);
			a +="网上银行 “6、身份认证-证书私钥备份时，是否提示或强制放在移动设备内：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#是否对备份的证书私钥进行加密")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#是否对备份的证书私钥进行加密")[0].parentElement);
			a +="网上银行 “6、身份认证-是否对备份的证书私钥进行加密：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#备份或恢复证书私钥成功后，是否通过手机短信等第二通信渠道向客户发送提示消息")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#备份或恢复证书私钥成功后，是否通过手机短信等第二通信渠道向客户发送提示消息")[0].parentElement);
			a +="网上银行 “6、身份认证-备份或恢复证书私钥成功后，是否通过手机短信等第二通信渠道向客户发送提示消息：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#文件证书#客户证书签发机构")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#文件证书#客户证书签发机构")[0].parentElement);
			a +="网上银行 “6、身份认证-文件认证：客户证书签发机构”不能为空!\n";
			isValid = false;
		}
		
	}
	if(getTableFormObjs("身份认证#内容#短信动态口令#是否支持")[0].value=="是"){
		if(getTableFormObjs("身份认证#内容#短信动态口令#开通手机动态口令时， 使用柜面等人工参与方式验证客户身份并登记手机号码")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#短信动态口令#开通手机动态口令时， 使用柜面等人工参与方式验证客户身份并登记手机号码")[0].parentElement);
			a +="网上银行 “6、身份认证-开通手机动态口令时， 使用柜面等人工参与方式验证客户身份并登记手机号码：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#短信动态口令#更改手机号码时，是否对客户的身份实施验证")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#短信动态口令#更改手机号码时，是否对客户的身份实施验证")[0].parentElement);
			a +="网上银行 “6、身份认证-更改手机号码时，是否对客户的身份实施验证：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#短信动态口令#动态口令的长度是否不少于6位")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#短信动态口令#动态口令的长度是否不少于6位")[0].parentElement);
			a +="网上银行 “6、身份认证-动态口令的长度是否不少于6位：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#短信动态口令#手机动态口令的生成是否与转入账户、交易金额等要素相关联")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#短信动态口令#手机动态口令的生成是否与转入账户、交易金额等要素相关联")[0].parentElement);
			a +="网上银行 “6、身份认证-手机动态口令的生成是否与转入账户、交易金额等要素相关联：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#短信动态口令#短信中是否提示关键交易要素信息，如转入账户、交易金额等")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#短信动态口令#短信中是否提示关键交易要素信息，如转入账户、交易金额等")[0].parentElement);
			a +="网上银行 “6、身份认证-短信中是否提示关键交易要素信息，如转入账户、交易金额等：”不能为空!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs("身份认证#内容#动态口令卡#是否支持")[0].value=="是"){
		if(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡是否具备PIN码连续错误锁定机制")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡是否具备PIN码连续错误锁定机制")[0].parentElement);
			a +="	网上银行 “6、身份认证-动态口令卡是否具备PIN码连续错误锁定机制：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡是否启用PIN码保护机制")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡是否启用PIN码保护机制")[0].parentElement);
			a +="网上银行 “6、身份认证-动态口令卡是否启用PIN码保护机制：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#动态口令的长度是否不少于6位")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#动态口令的长度是否不少于6位")[0].parentElement);
			a +="网上银行 “6、身份认证-动态口令的长度是否不少于6位：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#PIN的长度是否不少于4位")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#PIN的长度是否不少于4位")[0].parentElement);
			a +="网上银行 “6、身份认证-PIN的长度是否不少于4位：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#是否支持基于坐标机制的动态口令卡")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#是否支持基于坐标机制的动态口令卡")[0].parentElement);
			a +="网上银行 “6、身份认证-是否支持基于坐标机制的动态口令卡：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡使用有效期")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#动态口令卡使用有效期")[0].parentElement);
			a +="网上银行 “6、身份认证-动态口令使用有效期”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#是否使用涂层覆盖等方法保护口令")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#是否使用涂层覆盖等方法保护口令")[0].parentElement);
			a +="网上银行 “6、身份认证-是否使用涂层覆盖等方法保护口令”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#基于坐标机制的动态口令卡是否随机产生挑战口令坐标")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#基于坐标机制的动态口令卡是否随机产生挑战口令坐标")[0]);
			a +="网上银行 “6、身份认证-基于坐标机制的动态口令卡是否随机产生挑战口令坐标：”不能为空!\n";
			isValid = false;
		}
		if(getTableFormObjs("身份认证#内容#动态口令卡#基于坐标机制的动态口令卡的最大使用次数")[0].value.trim()==""){
			errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#基于坐标机制的动态口令卡的最大使用次数")[0]);
			a +="网上银行 “6、身份认证-基于坐标机制的动态口令卡的最大使用次数：”不能为空!\n";
			isValid = false;
		}
	}
	
	checkFloatNum(getTableFormObj(label_YN21_01,"1_1"));
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

/*
 *功能：加入数字控件
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

/*
 *功能：单选按钮的读写设置
 */
function columnVallueRadio1(obj,access){
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
						if(imgs[k].flag==""){
							imgs[k].onclick = function(){
								columnVallueRadioElse(this);
								};
						}else{
							imgs[k].onclick = function(){
							columnVallueRadio(this);
							};
						}
					}
				}
			}
		}
	}
}