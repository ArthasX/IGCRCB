/**T-B-15 手机银行系统安全情况表——报表填报*/

var isValid = true;
var a = "";
var errorObjs=[];

var label_header_item1 = "标题#填报部门";
var label_header_item2 = "标题#填报人";
var label_header_item5 = "标题#联系电话";
var label_header_item3 = "标题#责任人";
var label_header_item4 = "标题#填表日期";
var label_YN01_00="安全管理#内容#本年度是否实施网上银行系统安全评估";
var label_YN01_01="安全管理#内容#手机银行系统现状#系统建设情况";
var label_YN01_02="安全管理#内容#手机银行系统现状#系统管理及维护模式";

var label_YN02_01="安全管理#内容#交易风险等级划分#是否划分";
var label_YN02_02="安全管理#内容#交易风险等级划分#高风险交易包括";
var label_YN02_03="安全管理#内容#交易风险等级划分#低风险交易包括";

var label_YN03_01="安全管理#内容#安全评估#手机银行系统安全内部评估主要实施部门（组织） ";
var label_YN03_02="安全管理#内容#安全评估#本年度是否实施手机银行系统安全评估";
var label_YN03_03="安全管理#内容#安全评估#评估方式";
var label_YN03_04="安全管理#内容#安全评估#机构名称";

var label_YN04_01="安全管理#内容#应急管理#是否针对手机银行系统建立了应急管理机制";
var label_YN04_02="安全管理#内容#应急管理#应急计划是否定期演练";

var label_YN05_01="安全管理#内容#安全审计#是否已建立了手机银行系统安全审计机制";
var label_YN05_02="安全管理#内容#安全审计#安全审计覆盖范围";

var label_YN06_01="安全管理#内容#安全趋势分析#是否进行手机银行安全前沿技术和风险趋势进行跟踪和分析";


var label_YN07_01="客户安全教育#内容#客户风险意识加强#手机银行服务协议中是否包含安全风险提示内容";
var label_YN07_02="客户安全教育#内容#客户风险意识加强#通过何种宣传渠道加强客户教育";


var label_YN08_01="通讯安全#内容#网络安全控制措施#互联网与DMZ区之间的隔离措施";
var label_YN08_02="通讯安全#内容#网络安全控制措施#DMZ区与内网之间的隔离措施";
var label_YN08_03="通讯安全#内容#网络安全控制措施#手机银行系统与其他业务系统之间是否采取隔";
var label_YN08_04="通讯安全#内容#网络安全控制措施#隔离措施";
var label_YN08_05="通讯安全#内容#网络安全控制措施#是否采用不同电信运营商的线路，相互备份且互不影响";

var label_YN09_01="通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证";
var label_YN09_02="通讯安全#内容#会话安全管理措施#措施简述";
var label_YN09_03="通讯安全#内容#会话安全管理措施#手机银行采用的WAP协议版本";
var label_YN09_04="通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证";
var label_YN09_05="通讯安全#内容#会话安全管理措施#连接空闲超时关闭时间为";
var label_YN09_06="通讯安全#内容#会话安全管理措施#手机银行服务器证书颁发机构为";
var label_YN09_07="通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制";
var label_YN09_08="通讯安全#内容#会话安全管理措施#登录失败次数限制为";



var label_YN10_01="数据安全#内容#数据加密#是否制订手机银行密钥管理制度，对密钥生命周期进行全面管理";
var label_YN10_02="数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施";
var label_YN10_03="数据安全#内容#数据加密#1#传输加密协议名称：";
var label_YN10_04="数据安全#内容#数据加密#1#加密算法名称：";
var label_YN10_05="数据安全#内容#数据加密#1#密钥长度：";
var label_YN10_06="数据安全#内容#数据加密#是否对敏感数据进行加密存储";
var label_YN10_07="数据安全#内容#数据加密#加密的数据字段包括";
var label_YN10_08="数据安全#内容#数据加密#服务器端主密钥是否采用硬件安全模块（HSM）存储";

var label_YN11_01="数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施";
var label_YN11_02="数据安全#内容#高风险交易数据完整性保护及抗抵赖#措施简述";
var label_YN11_03="数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施";
var label_YN11_04="数据安全#内容#高风险交易数据完整性保护及抗抵赖#措施简述 ";

var label_YN12_01="数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施";
var label_YN12_02="数据安全#内容#敏感信息防泄露#措施简述";
var label_YN12_03="数据安全#内容#敏感信息防泄露#客户端程序是否存储客户敏感信息";
var label_YN12_04="数据安全#内容#敏感信息防泄露#显示客户敏感信息时，是否实施屏蔽处理";
var label_YN12_05="数据安全#内容#敏感信息防泄露#对敏感客户参数修改时，是否要求进行二次认证";

var label_YN13_01="应用系统安全#内容#手机银行系统上线前是否实施代码安全检测";
var label_YN13_02="应用系统安全#内容#检测部门（组织、团队）名称";
var label_YN13_03="应用系统安全#内容#是否使用检测工具实施代码安全检测";
var label_YN13_04="应用系统安全#内容#检测工具名称";
var label_YN13_05="应用系统安全#内容#是否定期或不定期开展手机银行系统渗透性测试";
var label_YN13_06="应用系统安全#内容#测试机构（组织）名称";
var label_YN13_07="应用系统安全#内容#是否向客户提示历史登录信息";
var label_YN13_08="应用系统安全#内容#是否支持用户查询登录记录";
var label_YN13_09="应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测";
var label_YN13_10="应用系统安全#内容#第三方机构名称";

var label_YN14_01="身份认证#内容#静态口令#首次登录时是否强制客户修改初始密码";
var label_YN14_02="身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易";
var label_YN14_03="身份认证#内容#静态口令#交易限额为";
var label_YN14_04="身份认证#内容#静态口令#是否具备防密码暴力猜解机制";
var label_YN14_05="身份认证#内容#静态口令#措施简述";

var label_YN15_01="身份认证#内容#手机号码验证#是否启用手机号码验证机制";
var label_YN15_02="身份认证#内容#手机号码验证#措施简述";
var label_YN15_03="身份认证#内容#手机号码验证#是否采取手机号码防伪措施";
var label_YN15_04="身份认证#内容#手机号码验证#措施简述 ";

var label_YN16_01="身份认证#内容#OTP令牌#是否支持";
var label_YN16_02="身份认证#内容#OTP令牌#OTP令牌是否启用PIN码保护机制";
var label_YN16_03="身份认证#内容#OTP令牌#OTP令牌是否具备PIN码连续错误锁定机制";
var label_YN16_04="身份认证#内容#OTP令牌#动态口令的长度是否不少于6位";
var label_YN16_05="身份认证#内容#OTP令牌#PIN的长度是否不少于4位";

var label_YN17_01="身份认证#内容#动态口令卡#是否支持";
var label_YN17_02="身份认证#内容#动态口令卡#动态口令卡是否启用PIN码保护机制";
var label_YN17_03="身份认证#内容#动态口令卡#动态口令卡是否具备PIN码连续错误锁定机制";
var label_YN17_04="身份认证#内容#动态口令卡#动态口令的长度是否不少于6位";
var label_YN17_05="身份认证#内容#动态口令卡#PIN的长度是否不少于4位";
var label_YN17_06="身份认证#内容#动态口令卡#是否支持基于坐标机制的动态口令卡";
var label_YN17_07="身份认证#内容#动态口令卡#基于坐标机制的动态口令卡是否随机产生挑战口令坐标";
var label_YN17_08="身份认证#内容#动态口令卡#基于坐标机制的动态口令卡的最大使用次数";
var label_YN17_09="身份认证#内容#动态口令卡#动态口令卡使用有效期";
var label_YN17_10="身份认证#内容#动态口令卡#是否使用涂层覆盖等方法保护口令";

var label_YN18_01="身份认证#内容#其他#是否采用其他认证方式";
var label_YN18_02="身份认证#内容#其他#措施简述";
var label_isempty = "报送空表表格#报送空表";

var label_YN18_11="安全管理#内容#手机银行系统现状#系统管理及维护模式";


/*
* 功能：点击是否下方表单是否可填
* 配置： 安全管理#内容#手机银行系统现状#系统管理及维护模式
*/
function setobj_YN18_11(obj){
	var obj1 = getTableFormObj(label_YN18_11,"1_1_1" );
	var obj_YN18_11 = getTableFormCheckBox(label_YN18_11,"1_1_1" );
		if( obj_YN18_11[0].checked==true ){
			obj_YN18_11[1].checked=false;
			obj_YN18_11[1].disabled=true;
			obj_YN18_11[2].checked=false;
			obj_YN18_11[2].disabled=true;
			obj_YN18_11[3].checked=false;
			obj_YN18_11[3].disabled=true;
			obj_YN18_11[4].checked=false;
			obj_YN18_11[4].disabled=true;
			obj_YN18_11[5].checked=false;
			obj_YN18_11[5].disabled=true;
			showOrHiddenTableColumnCheckBoxElse(obj_YN18_11[5]);
			obj1.value=obj_YN18_11[0].value;
		}else {
			obj_YN18_11[0].checked=false;
			obj_YN18_11[1].disabled=false;
			obj_YN18_11[2].disabled=false;
			obj_YN18_11[3].disabled=false;
			obj_YN18_11[4].disabled=false;
			obj_YN18_11[5].disabled=false;

		}
		
}
/*
* 功能：当选择 无此项服务 时其他多选项不可选
* 参数：objs 为所有复选框对象集合
*/
function disableTableCheckBox1(objs){
	if(objs != null && objs.length > 0){
		for(var i=0;i<objs.length;i++){
			if(objs[i].value==""){
				objs[i].onclick=function(){showOrHiddenTableColumnCheckBoxElse(this);
				setobj_YN18_11(this);};
			}else{
				objs[i].onclick=function(){columnValueCheckBox(this);setobj_YN18_11(this);};
			}
		}
	}
}
/*
* 功能：流程处理页初始化时设置表单权限
* 配置：填报状态和二级审批状态
*/
function initSet(){
	obj_YN02_01(getTableFormObj(label_YN01_01,"1_1_1" ));
	obj_YN02_011(getTableFormObj(label_YN02_01,"1_1_1" ));
	obj_YN03_02(getTableFormObj(label_YN03_02,"1_1_1" ));
	obj_YN05_01(getTableFormObj(label_YN05_01,"1_1_1" ));
	obj_YN09_01(getTableFormObj(label_YN09_01,"1_1_1" ));
	obj_YN09_04(getTableFormObj(label_YN09_04,"1_1_1" ));
	obj_YN09_07(getTableFormObj(label_YN09_07,"1_1_1" ));
	obj_YN10_02(getTableFormObj(label_YN10_02,"1_1_1" ));
	obj_YN10_06(getTableFormObj(label_YN10_06,"1_1_1" ));
	obj_YN11_01(getTableFormObj(label_YN11_01,"1_1_1" ));
	obj_YN11_03(getTableFormObj(label_YN11_03,"1_1_1" ));
	obj_YN12_01(getTableFormObj(label_YN12_01,"1_1_1" ));
	obj_YN08_03(getTableFormObj(label_YN08_03,"1_1_1" ));
	obj_YN13_01(getTableFormObj(label_YN13_01,"1_1" ));
	obj_YN14_02(getTableFormObj(label_YN14_02,"1_1_1" ));
	obj_YN14_04(getTableFormObj(label_YN14_04,"1_1_1" ));
	obj_YN15_01(getTableFormObj(label_YN15_01,"1_1_1" ));
	obj_YN15_03(getTableFormObj(label_YN15_03,"1_1_1" ));
	obj_YN16_01(getTableFormObj(label_YN16_01,"1_1_1" ));
	obj_YN17_01(getTableFormObj(label_YN17_01,"1_1_1" ));
	obj_YN18_01(getTableFormObj(label_YN18_01,"1_1_1" ));
	obj_YN13_09(getTableFormObj(label_YN13_09,"1_1" ));
	if(getTableFormObj(label_YN01_01,"1_1_1" ).value != "尚无系统")
	setobj_YN18_11(getTableFormObj(label_YN18_11,"1_1_1" ));
	 obj_YN13_05(getTableFormObj(label_YN13_05,"1_1"));
}
/**
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
var YN02_011=function(){
	columnVallueRadio(this);
	obj_YN02_011(this);
};
var YN03_02=function(){
	columnVallueRadio(this);
	obj_YN03_02(this);
};
var YN05_01=function(){
	columnVallueRadio(this);
	obj_YN05_01(this);
};
var YN09_01=function(){
	columnVallueRadio(this);
	obj_YN09_01(this);
};
var YN09_04=function(){
	columnVallueRadio(this);
	obj_YN09_04(this);
};
var YN09_07=function(){
	columnVallueRadio(this);
	obj_YN09_07(this);
};
var YN10_02=function(){
	columnVallueRadio(this);
	obj_YN10_02(this);
};
var YN10_06=function(){
	columnVallueRadio(this);
	obj_YN10_06(this);
};
var YN11_01=function(){
	columnVallueRadio(this);
	obj_YN11_01(this);
};
var YN11_03=function(){
	columnVallueRadio(this);
	obj_YN11_03(this);
};
var YN12_01=function(){
	columnVallueRadio(this);
	obj_YN12_01(this);
};
var YN08_03=function(){
	columnVallueRadio(this);
	obj_YN08_03(this);
};
var YN13_01=function(){
	columnVallueRadio(this);
	obj_YN13_01(this);
};
var YN14_02=function(){
	columnVallueRadio(this);
	obj_YN14_02(this);
};
var YN14_04=function(){
	columnVallueRadio(this);
	obj_YN14_04(this);
};
var YN15_01=function(){
	columnVallueRadio(this);
	obj_YN15_01(this);
};
var YN15_03=function(){
	columnVallueRadio(this);
	obj_YN15_03(this);
};
var YN16_01=function(){
	columnVallueRadio(this);
	obj_YN16_01(this);
};
var YN17_01=function(){
	columnVallueRadio(this);
	obj_YN17_01(this);
};
var YN17_06=function(){
	columnVallueRadio(this);
//	obj_YN17_06(this);
};

var YN18_01=function(){
	columnVallueRadio(this);
	obj_YN18_01(this);
};
var YN13_09=function(){
	columnVallueRadio(this);
	obj_YN13_09(this);
};
var YN13_05=function(){
	columnVallueRadio(this);
	obj_YN13_05(this);
};


/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#手机银行系统现状#系统建设情况;
*/
function obj_YN02_01(obj) {
	//alert(getTableFormObj(label_YN01_01,"1_1_1").value);
	var obj_item1 = getTableFormObj(label_header_item1,"1").value;
	var obj_item2 = getTableFormObj(label_header_item2,"1").value;
	var obj_item3 = getTableFormObj(label_header_item3,"1").value;
	var obj_item4 = getTableFormObj(label_header_item4,"1").value;
	var obj_item5 = getTableFormObj(label_header_item5,"1").value;
	var obj_isempty = getTableFormCheckBox(label_isempty,"1" )[0].checked;
	if (getTableFormObj(label_YN01_01,"1_1_1").value == "尚无系统") {
		// 只读
		onlyRead(true);
	} else {
		onlyRead(false);
		getTableFormObj(label_YN09_05,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN09_05,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN09_08,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN09_08,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN10_05,"1_1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN10_05,"1_1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN14_03,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN14_03,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN17_08,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN17_08,"1_1_1" ).readOnly = "readonly";
		getTableFormObj(label_YN17_09,"1_1_1" ).onclick=click_columnValueNumber;
		getTableFormObj(label_YN17_09,"1_1_1" ).readOnly = "readonly";

		 columnVallueRadio3(getTableFormObj(label_YN02_01,"1_1_1" ),YN02_011);
		 columnVallueRadio3(getTableFormObj(label_YN03_02,"1_1_1" ),YN03_02);
		 columnVallueRadio3(getTableFormObj(label_YN05_01,"1_1_1" ),YN05_01);
		 columnVallueRadio3(getTableFormObj(label_YN09_01,"1_1_1" ),YN09_01);
		 columnVallueRadio3(getTableFormObj(label_YN09_04,"1_1_1" ),YN09_04);
		 columnVallueRadio3(getTableFormObj(label_YN09_07,"1_1_1" ),YN09_07);
		 columnVallueRadio3(getTableFormObj(label_YN10_02,"1_1_1" ),YN10_02);
		 columnVallueRadio3(getTableFormObj(label_YN10_06,"1_1_1" ),YN10_06);
		 columnVallueRadio3(getTableFormObj(label_YN11_01,"1_1_1" ),YN11_01);
		 columnVallueRadio3(getTableFormObj(label_YN11_03,"1_1_1" ),YN11_03);
		 columnVallueRadio3(getTableFormObj(label_YN12_01,"1_1_1" ),YN12_01);
		 columnVallueRadio3(getTableFormObj(label_YN08_03,"1_1_1" ),YN08_03);
		 columnVallueRadio3(getTableFormObj(label_YN13_01,"1_1" ),YN13_01);
		 columnVallueRadio3(getTableFormObj(label_YN14_02,"1_1_1" ),YN14_02);
		 columnVallueRadio3(getTableFormObj(label_YN14_04,"1_1_1" ),YN14_04);
		 columnVallueRadio3(getTableFormObj(label_YN15_01,"1_1_1" ),YN15_01);
		 columnVallueRadio3(getTableFormObj(label_YN15_03,"1_1_1" ),YN15_03);
		 columnVallueRadio3(getTableFormObj(label_YN16_01,"1_1_1" ),YN16_01);
		 columnVallueRadio3(getTableFormObj(label_YN17_01,"1_1_1" ),YN17_01);
		 columnVallueRadio3(getTableFormObj(label_YN17_06,"1_1_1" ),YN17_06);
		 columnVallueRadio3(getTableFormObj(label_YN18_01,"1_1_1" ),YN18_01);
		 columnVallueRadio3(getTableFormObj(label_YN13_09,"1_1" ),YN13_09);
		 columnVallueRadio3(getTableFormObj(label_YN13_05,"1_1" ),YN13_05);
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
	getTableFormCheckBox(label_isempty,"1" )[0].disabled=false;
	getTableFormCheckBox(label_isempty,"1" )[0].checked = obj_isempty;
	if(obj_isempty)getTableFormObjs(label_isempty)[0].value = "报送空表";
	disableTableCheckBox1(getTableFormCheckBox(label_YN18_11,"1_1_1" ));
	columnVallueRadio2(getTableFormObj(label_YN01_01,"1_1_1"),"obj_YN02_01(this);");
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
								obj_YN02_01(this);
							};	
						}else{
							imgs[k].onclick = function(){
								columnVallueRadio(this);
								obj_YN02_01(this);
							};
						}
					}
				}
		}
	}
}

/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#交易风险等级划分#是否划分
*/
function obj_YN02_011(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN02_01 = getTableFormObjs(label_YN02_01)[0];
	var obj_YN02_02 = getTableFormCheckBox(label_YN02_02,obj_YN02_01.rownumber );
	var obj_YN02_03 = getTableFormCheckBox(label_YN02_03,obj_YN02_01.rownumber );
	if (obj_YN02_01.value == "否") {
		// 只读
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		// 清空
		disableTableCheckBox(obj_YN02_02,true);
		disableTableCheckBox(obj_YN02_03,true);
	} else if (obj_YN02_01.value == "是") {
		// 还原
		/*obj_YN02_02.onclick = "";
		obj_YN02_03.onclick = "";*/
		disableTableCheckBox(obj_YN02_02,false);
		disableTableCheckBox(obj_YN02_03,false);

	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#安全评估#本年度是否实施手机银行系统安全评估
*/
function obj_YN03_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN03_02 = getTableFormObjs(label_YN03_02)[0];
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03_02.rownumber );
	var obj_YN03_04 = getTableFormObj(label_YN03_04,obj_YN03_02.rownumber );
	if (obj_YN03_02.value == "否") {
		// 只读
	
		// 清空
		columnVallueRadio1(obj_YN03_03,false);
		obj_YN03_04.value="";
		obj_YN03_04.readOnly="readonly";
	} else if (obj_YN03_02.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN03_03,true);
		obj_YN03_04.readOnly="";
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：安全管理#内容#安全审计#是否已建立了手机银行系统安全审计机制
*/
function obj_YN05_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN05_01 = getTableFormObjs(label_YN05_01)[0];
	var obj_YN05_02 = getTableFormCheckBox(label_YN05_02,obj_YN05_01.rownumber );
	if (obj_YN05_01.value == "否") {
		// 只读
		obj_YN05_02.onclick = "";
		// 清空
		disableTableCheckBox(obj_YN05_02,true);
	} else if (obj_YN05_01.value== "是") {
		// 还原
		obj_YN05_02.onclick = "";
		disableTableCheckBox(obj_YN05_02,false);
	}

}



/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#网络安全控制措施#手机银行系统与其他业务系统之间是否采取隔
*/
function obj_YN08_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN08_03 = getTableFormObjs(label_YN08_03)[0];
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08_03.rownumber );
	if (obj_YN08_03.value == "否") {
		// 只读
		// 清空
		obj_YN08_04.value="";
		obj_YN08_04.readOnly="readonly";
	} else if (obj_YN08_03.value == "是") {
		// 还原
		obj_YN08_04.readOnly = "";
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证
*/
function obj_YN09_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_01 = getTableFormObjs(label_YN09_01)[0];
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09_01.rownumber );
	if (obj_YN09_01.value == "否") {
		// 只读
		// 清空
		obj_YN09_02.value="";
		obj_YN09_02.readOnly="readonly";
	} else if (obj_YN09_01.value == "是") {
		// 还原
		obj_YN09_02.readOnly = "";
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证
*/
function obj_YN09_04(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_04 = getTableFormObjs(label_YN09_04)[0];
	var obj_YN09_05 = getTableFormObj(label_YN09_05,obj_YN09_04.rownumber);
	if (obj_YN09_04.value == "否") {
		// 只读
		// 清空
		obj_YN09_05.value = "";
		obj_YN09_05.onclick = "";
	} else if (obj_YN09_04.value== "是") {
		// 还原
		obj_YN09_05.onclick = click_columnValueNumber;
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制
*/
function obj_YN09_07(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN09_07 = getTableFormObjs(label_YN09_07)[0];
	var obj_YN09_08 = getTableFormObj(label_YN09_08,obj_YN09_07.rownumber );
	if (obj_YN09_07.value == "否") {
		// 只读
		// 清空
		obj_YN09_08.value = "";
		obj_YN09_08.onclick = "";
	} else if (obj_YN09_07.value== "是") {
		// 还原
		obj_YN09_08.onclick = click_columnValueNumber;
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施
*/
function obj_YN10_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10_02 = getTableFormObjs(label_YN10_02)[0];
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10_02.rownumber+"_1" );
	var obj_YN10_04 = getTableFormObj(label_YN10_04,obj_YN10_02.rownumber+"_1" );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10_02.rownumber+"_1" );

	if (obj_YN10_02.value == "否") {
		// 只读
		// 清空
		obj_YN10_03.value="";
		obj_YN10_03.readOnly="readonly";
		obj_YN10_04.value="";
		obj_YN10_04.readOnly="readonly";
		obj_YN10_05.value = "";
		obj_YN10_05.onclick = "";
	} else if (obj_YN10_02.value == "是") {
		// 还原
		obj_YN10_03.readOnly="";
		obj_YN10_04.readOnly="";
		obj_YN10_05.onclick = click_columnValueNumber;
	}

}



/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#数据加密#是否对敏感数据进行加密存储
*/
function obj_YN10_06(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN10_06 = getTableFormObjs(label_YN10_06)[0];
	var obj_YN10_07 = getTableFormObj(label_YN10_07,obj_YN10_06.rownumber );

	if (obj_YN10_06.value == "否") {
		// 只读
		// 清空
		obj_YN10_07.value="";
		obj_YN10_07.readOnly="readonly";
	} else if (obj_YN10_06.value == "是") {
		// 还原
		obj_YN10_07.readOnly="";
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施
*/
function obj_YN11_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN11_01 = getTableFormObjs(label_YN11_01)[0];
	var obj_YN11_02 = getTableFormObj(label_YN11_02,obj_YN11_01.rownumber);

	if (obj_YN11_01.value == "否") {
		// 只读
		// 清空
		obj_YN11_02.value="";
		obj_YN11_02.readOnly="readonly";
	} else if (obj_YN11_01.value == "是") {
		// 还原
		obj_YN11_02.readOnly="";
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施
*/
function obj_YN11_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN11_03 = getTableFormObjs(label_YN11_03)[0];
	var obj_YN11_04 = getTableFormObj(label_YN11_04,obj_YN11_03.rownumber );

	if (obj_YN11_03.value == "否") {
		// 只读
		// 清空
		obj_YN11_04.value="";
		obj_YN11_04.readOnly="readonly";
	} else if (obj_YN11_03.value == "是") {
		// 还原
		obj_YN11_04.readOnly="";
	}

}
/*
* 功能：点击是否下方表单是否可填
* 配置：数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施
*/
function obj_YN12_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN12_01 = getTableFormObjs(label_YN12_01)[0];
	var obj_YN12_02 = getTableFormObj(label_YN12_02,obj_YN12_01.rownumber );
	if (obj_YN12_01.value == "否") {
		// 只读
		// 清空
		obj_YN12_02.value="";
		obj_YN12_02.readOnly="readonly";
	} else if (obj_YN12_01.value == "是") {
		// 还原
		obj_YN12_02.readOnly="";
	}

}



/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#手机银行系统上线前是否实施代码安全检测
*/
function obj_YN13_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN13_01 = getTableFormObjs(label_YN13_01)[0];
	var obj_YN13_02 = getTableFormObj(label_YN13_02,obj_YN13_01.rownumber );
	if (obj_YN13_01.value == "否") {
		// 只读
		// 清空
		obj_YN13_02.value="";
		obj_YN13_02.readOnly="readonly";
	} else if (obj_YN13_01.value == "是") {
		// 还原
		obj_YN13_02.readOnly="";
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#是否使用检测工具实施代码安全检测
*/
function obj_YN13_03(obj) {
	var obj_YN13_03 = getTableFormObjs(label_YN13_03)[0];
	var obj_YN13_04 = getTableFormObj(label_YN13_04,"1_1");
	if (obj_YN13_03.value == "否") {
		// 只读
		// 清空
		obj_YN13_04.value="";
		obj_YN13_04.readOnly="readonly";
	} else if (obj_YN13_03.value == "是") {
		// 还原
		obj_YN13_04.readOnly="";
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#是否定期或不定期开展手机银行系统渗透性测试
*/
function obj_YN13_05(obj) {
	var obj_YN13_05 = getTableFormObjs(label_YN13_05)[0];
	var obj_YN13_06 = getTableFormObj(label_YN13_06,"1_1" );
	if (obj_YN13_05.value == "否") {
		// 只读
		// 清空
		obj_YN13_06.value="";
		obj_YN13_06.readOnly="readonly";
	} else if (obj_YN13_05.value == "是") {
		// 还原
		obj_YN13_06.readOnly="";
	}

}


/*
* 功能：点击是否下方表单是否可填
* 配置：应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测
*/
function obj_YN13_09(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN13_09 = getTableFormObjs(label_YN13_09)[0];
	var obj_YN13_10 = getTableFormObj(label_YN13_10,obj_YN13_09.rownumber );
	if (obj_YN13_09.value == "否") {
		// 只读
		// 清空
		obj_YN13_10.value="";
		obj_YN13_10.readOnly="readonly";
	} else if (obj_YN13_09.value == "是") {
		// 还原
		obj_YN13_10.readOnly="";
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易
*/
function obj_YN14_02(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN14_02 = getTableFormObjs(label_YN14_02)[0];
	var obj_YN14_03 = getTableFormObj(label_YN14_03,obj_YN14_02.rownumber );
	if (obj_YN14_02.value == "否") {
		// 只读
		// 清空
		obj_YN14_03.value = "";
		obj_YN14_03.onclick = "";
	} else if (obj_YN14_02.value == "是") {
		// 还原
		obj_YN14_03.onclick = click_columnValueNumber;
	}

}
/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#静态口令#是否具备防密码暴力猜解机制
*/
function obj_YN14_04(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN14_04 = getTableFormObjs(label_YN14_04)[0];
	var obj_YN14_05 = getTableFormObj(label_YN14_05,obj_YN14_04.rownumber );
	if (obj_YN14_04.value == "否") {
		// 只读
		// 清空
		obj_YN14_05.value="";
		obj_YN14_05.readOnly="readonly";
	} else if (obj_YN14_04.value== "是") {
		// 还原
		obj_YN14_05.readOnly="";
	}

}
/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#手机号码验证#是否启用手机号码验证机制
*/
function obj_YN15_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN15_01 = getTableFormObjs(label_YN15_01)[0];
	var obj_YN15_02 = getTableFormObj(label_YN15_02,obj_YN15_01.rownumber );
	if (obj_YN15_01.value == "否") {
		// 只读
		// 清空
		obj_YN15_02.value="";
		obj_YN15_02.readOnly="readonly";
	} else if (obj_YN15_01.value == "是") {
		// 还原
		obj_YN15_02.readOnly="";
	}

}
/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#手机号码验证#是否采取手机号码防伪措施
*/
function obj_YN15_03(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN15_03 = getTableFormObjs(label_YN15_03)[0];
	var obj_YN15_04 = getTableFormObj(label_YN15_04,obj_YN15_03.rownumber );
	if (obj_YN15_03.value == "否") {
		// 只读
		// 清空
		obj_YN15_04.value="";
		obj_YN15_04.readOnly="readonly";
	} else if (obj_YN15_03.value == "是") {
		// 还原
		obj_YN15_04.readOnly="";
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#OTP令牌#是否支持
*/
function obj_YN16_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN16_01 = getTableFormObjs(label_YN16_01)[0];
	var obj_YN16_02 = getTableFormObj(label_YN16_02,obj_YN16_01.rownumber );
	var obj_YN16_03 = getTableFormObj(label_YN16_03,obj_YN16_01.rownumber );
	var obj_YN16_04 = getTableFormObj(label_YN16_04,obj_YN16_01.rownumber );
	var obj_YN16_05 = getTableFormObj(label_YN16_05,obj_YN16_01.rownumber );
	if (obj_YN16_01.value == "否") {
		// 只读
		// 清空
		columnVallueRadio1(obj_YN16_02,false);
		columnVallueRadio1(obj_YN16_03,false);
		columnVallueRadio1(obj_YN16_04,false);
		columnVallueRadio1(obj_YN16_05,false);
	} else if (obj_YN16_01.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN16_02,true);
		columnVallueRadio1(obj_YN16_03,true);
		columnVallueRadio1(obj_YN16_04,true);
		columnVallueRadio1(obj_YN16_05,true);
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#动态口令卡#是否支持
*/
function obj_YN17_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN17_01 = getTableFormObjs(label_YN17_01)[0];
	var obj_YN17_02 = getTableFormObj(label_YN17_02,obj_YN17_01.rownumber );
	var obj_YN17_03 = getTableFormObj(label_YN17_03,obj_YN17_01.rownumber );
	var obj_YN17_04 = getTableFormObj(label_YN17_04,obj_YN17_01.rownumber );
	var obj_YN17_05 = getTableFormObj(label_YN17_05,obj_YN17_01.rownumber );
	var obj_YN17_06 = getTableFormObj(label_YN17_06,obj_YN17_01.rownumber );
	var obj_YN17_07 = getTableFormObj(label_YN17_07,obj_YN17_01.rownumber );
	var obj_YN17_08 = getTableFormObj(label_YN17_08,obj_YN17_01.rownumber );
	var obj_YN17_09 = getTableFormObj(label_YN17_09,obj_YN17_01.rownumber );
	var obj_YN17_10 = getTableFormObj(label_YN17_10,obj_YN17_01.rownumber );
	if (obj_YN17_01.value == "否") {
		// 只读   清空
		columnVallueRadio1(obj_YN17_02,false);
		columnVallueRadio1(obj_YN17_03,false);
		columnVallueRadio1(obj_YN17_04,false);
		columnVallueRadio1(obj_YN17_05,false);
		columnVallueRadio1(obj_YN17_06,false);
		columnVallueRadio1(obj_YN17_07,false);
		obj_YN17_08.value = "";
		obj_YN17_08.onclick = "";
		obj_YN17_08.setAttribute("readOnly",true);
		obj_YN17_09.value = "";
		obj_YN17_09.onclick = "";
		obj_YN17_09.setAttribute("readOnly",true);
		columnVallueRadio1(obj_YN17_10,false);

	} else if (obj_YN17_01.value == "是") {
		// 还原
		columnVallueRadio1(obj_YN17_02,true);
		columnVallueRadio1(obj_YN17_03,true);
		columnVallueRadio1(obj_YN17_04,true);
		columnVallueRadio1(obj_YN17_05,true);
		columnVallueRadio1(obj_YN17_06,true);
		columnVallueRadio3(obj_YN17_07,YN17_06);
	//	columnVallueRadio1(obj_YN17_07,true);
		obj_YN17_08.onclick = click_columnValueNumber;
		obj_YN17_09.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN17_10,true);
	}

}

/*
* 功能：点击是否下方表单是否可填
* 配置：身份认证#内容#其他#是否采用其他认证方式
*/
function obj_YN18_01(obj) {
//	var target = getTarget(obj.parentElement);
	var obj_YN18_01 =getTableFormObj(label_YN18_01,"1_1_1" );
	var obj_YN18_02 = getTableFormObj(label_YN18_02,obj_YN18_01.rownumber );
	if (obj_YN18_01.value == "否") {
		// 只读  清空
		obj_YN18_02.value="";
		obj_YN18_02.readOnly="readonly";
	} else if (obj_YN18_01.value  == "是") {
		// 还原
		obj_YN18_02.readOnly="";
	}
}


/*
*功能：点击提交时进行的表单验证
*配置：填报状态的“提交”按钮
*/
function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	
	if (!checkEmptyReport()) {
		return true;
	}

	if(getTableFormObjs("安全管理#内容#手机银行系统现状#系统建设情况")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#手机银行系统现状#系统建设情况")[0].parentElement);
		a +="安全管理-系统建设情况不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("安全管理#内容#交易风险等级划分#是否划分")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#交易风险等级划分#是否划分")[0].parentElement);
		a +="安全管理-交易风险等级划分不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs(label_YN03_01)[0].value == ""){
		errorObjs.push(getTableFormObjs(label_YN03_01)[0].parentElement);
		a +="安全管理-手机银行系统安全内部评估主要实施部门（组织）：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("安全管理#内容#安全评估#本年度是否实施手机银行系统安全评估")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#安全评估#本年度是否实施手机银行系统安全评估")[0].parentElement);
		a +="安全管理-手机银行安全评估不能为空！\n";
		isValid = false;
	}	
	if(getTableFormObjs("安全管理#内容#应急管理#是否针对手机银行系统建立了应急管理机制")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#应急管理#是否针对手机银行系统建立了应急管理机制")[0].parentElement);
		a +="安全管理-是否针对手机银行系统建立了应急管理机制:不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("安全管理#内容#应急管理#应急计划是否定期演练")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#应急管理#应急计划是否定期演练")[0].parentElement);
		a +="安全管理-应急计划是否定期演练：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("安全管理#内容#安全审计#是否已建立了手机银行系统安全审计机制")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#安全审计#是否已建立了手机银行系统安全审计机制")[0].parentElement);
		a +="安全管理-是否已建立了手机银行系统安全审计机制：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("安全管理#内容#安全趋势分析#是否进行手机银行安全前沿技术和风险趋势进行跟踪和分析")[0].value == ""){
		errorObjs.push(getTableFormObjs("安全管理#内容#安全趋势分析#是否进行手机银行安全前沿技术和风险趋势进行跟踪和分析")[0].parentElement);
		a +="客户安全教育-是否进行手机银行安全前沿技术和风险趋势进行跟踪和分析:不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("客户安全教育#内容#客户风险意识加强#手机银行服务协议中是否包含安全风险提示内容")[0].value == ""){
		errorObjs.push(getTableFormObjs("客户安全教育#内容#客户风险意识加强#手机银行服务协议中是否包含安全风险提示内容")[0].parentElement);
		a +="客户安全教育-手机银行服务协议中是否包含安全风险提示内容：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("客户安全教育#内容#客户风险意识加强#通过何种宣传渠道加强客户教育")[0].value == ""){
		errorObjs.push(getTableFormObjs("客户安全教育#内容#客户风险意识加强#通过何种宣传渠道加强客户教育")[0].parentElement);
		a +="客户安全教育-通过何种宣传渠道加强客户教育： 不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#网络安全控制措施#互联网与DMZ区之间的隔离措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#网络安全控制措施#互联网与DMZ区之间的隔离措施")[0].parentElement);
		a +="通讯安全-互联网与DMZ区之间的隔离措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#网络安全控制措施#DMZ区与内网之间的隔离措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#网络安全控制措施#DMZ区与内网之间的隔离措施")[0].parentElement);
		a +="通讯安全-DMZ区与内网之间的隔离措施： 不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#网络安全控制措施#手机银行系统与其他业务系统之间是否采取隔")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#网络安全控制措施#手机银行系统与其他业务系统之间是否采取隔")[0].parentElement);
		a +="通讯安全-手机银行系统与其他业务系统之间是否采取隔:不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#网络安全控制措施#是否采用不同电信运营商的线路，相互备份且互不影响")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#网络安全控制措施#是否采用不同电信运营商的线路，相互备份且互不影响")[0].parentElement);
		a +="通讯安全-是否采用不同电信运营商的线路，相互备份且互不影响：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#会话安全管理措施#服务器端与客户端之间是否双向认证")[0].parentElement);
		a +="通讯安全-服务器端与客户端之间是否双向认证：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#会话安全管理措施#手机银行采用的WAP协议版本")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#会话安全管理措施#手机银行采用的WAP协议版本")[0]);
		a +="通讯安全-手机银行采用的WAP协议版本：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#会话安全管理措施#服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证")[0].parentElement);
		a +="通讯安全-服务器端与客户端间会话是否采取空闲超时机制，会话超时后双方须重新认证：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#会话安全管理措施#手机银行服务器证书颁发机构为")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#会话安全管理措施#手机银行服务器证书颁发机构为")[0].parentElement);
		a +="通讯安全-手机银行服务器证书颁发机构为：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制")[0].value == ""){
		errorObjs.push(getTableFormObjs("通讯安全#内容#会话安全管理措施#是否具备连续登录失败锁定机制")[0].parentElement);
		a +="通讯安全-是否具备连续登录失败锁定机制：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#数据加密#是否制订手机银行密钥管理制度，对密钥生命周期进行全面管理")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#数据加密#是否制订手机银行密钥管理制度，对密钥生命周期进行全面管理")[0].parentElement);
		a +="数据安全-是否制订手机银行密钥管理制度，对密钥生命周期进行全面管理：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#数据加密#客户端至服务器端间传输的敏感数据是否采取加密措施")[0].parentElement);
		a +="数据安全-客户端至服务器端间传输的敏感数据是否采取加密措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#数据加密#是否对敏感数据进行加密存储")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#数据加密#是否对敏感数据进行加密存储")[0].parentElement);
		a +="数据安全-是否对敏感数据进行加密存储：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#数据加密#服务器端主密钥是否采用硬件安全模块（HSM）存储")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#数据加密#服务器端主密钥是否采用硬件安全模块（HSM）存储")[0].parentElement);
		a +="数据安全-服务器端主密钥是否采用硬件安全模块（HSM）存储不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取完整性保护措施")[0].parentElement);
		a +="数据安全-高风险交易数据的传输是否采取完整性保护措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#高风险交易数据完整性保护及抗抵赖#高风险交易数据的传输是否采取抗抵赖措施")[0].parentElement);
		a +="数据安全-高风险交易数据的传输是否采取抗抵赖措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#敏感信息防泄露#客户端程序是否采取防键盘监听措施")[0].parentElement);
		a +="数据安全-客户端程序是否采取防键盘监听措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#敏感信息防泄露#客户端程序是否存储客户敏感信息")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#敏感信息防泄露#客户端程序是否存储客户敏感信息")[0].parentElement);
		a +="数据安全-客户端程序是否存储客户敏感信息：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("数据安全#内容#敏感信息防泄露#显示客户敏感信息时，是否实施屏蔽处理")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#敏感信息防泄露#显示客户敏感信息时，是否实施屏蔽处理")[0].parentElement);
		a +="数据安全-显示客户敏感信息时，是否实施屏蔽处理：不能为空！\n";
		isValid = false;
	}	
	if(getTableFormObjs("数据安全#内容#敏感信息防泄露#对敏感客户参数修改时，是否要求进行二次认证")[0].value == ""){
		errorObjs.push(getTableFormObjs("数据安全#内容#敏感信息防泄露#对敏感客户参数修改时，是否要求进行二次认证")[0].parentElement);
		a +="数据安全-对敏感客户参数修改时，是否要求进行二次认证：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("应用系统安全#内容#手机银行系统上线前是否实施代码安全检测")[0].value == ""){
		errorObjs.push(getTableFormObjs("应用系统安全#内容#手机银行系统上线前是否实施代码安全检测")[0].parentElement);
		a +="应用系统安全-手机银行系统上线前是否实施代码安全检测:不能为空！\n";
		isValid = false;
	}
	/*if(getTableFormObjs(label_YN13_03)[0].value == ""){
		errorObjs.push(getTableFormObjs(label_YN13_03)[0]);
		a +="应用系统安全-是否使用检测工具实施代码安全检测：不能为空！\n";
		isValid = false;
	}*/
	if(getTableFormObjs("应用系统安全#内容#是否定期或不定期开展手机银行系统渗透性测试")[0].value == ""){
		errorObjs.push(getTableFormObjs("应用系统安全#内容#是否定期或不定期开展手机银行系统渗透性测试")[0].parentElement);
		a +="应用系统安全-是否定期或不定期开展手机银行系统渗透性测试：不能为空！\n";
		isValid = false;
	}
	/*if(getTableFormObjs("应用系统安全#内容#是否向客户提示历史登录信息")[0].value == ""){
		errorObjs.push(getTableFormObjs("应用系统安全#内容#是否向客户提示历史登录信息")[0]);
		a +="应用系统安全-是否向客户提示历史登录信息：不能为空！\n";
		isValid = false;
	}*/
	if(getTableFormObjs("应用系统安全#内容#是否支持用户查询登录记录")[0].value == ""){
		errorObjs.push(getTableFormObjs("应用系统安全#内容#是否支持用户查询登录记录")[0].parentElement);
		a +="应用系统安全-是否支持用户查询登录记录：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测")[0].value == ""){
		errorObjs.push(getTableFormObjs("应用系统安全#内容#客户端程序是否经过第三方中立测试机构的安全检测")[0].parentElement);
		a +="应用系统安全-客户端程序是否经过第三方中立测试机构的安全检测：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#静态口令#首次登录时是否强制客户修改初始密码")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#静态口令#首次登录时是否强制客户修改初始密码")[0].parentElement);
		a +="身份认证-首次登录时是否强制客户修改初始密码：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#静态口令#仅通过静态口令验证的情况下是否允许进行资金交易")[0].parentElement);
		a +="身份认证-仅通过静态口令验证的情况下是否允许进行资金交易：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#静态口令#是否具备防密码暴力猜解机制")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#静态口令#是否具备防密码暴力猜解机制")[0].parentElement);
		a +="身份认证-是否具备防密码暴力猜解机制：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#手机号码验证#是否启用手机号码验证机制")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#手机号码验证#是否启用手机号码验证机制")[0].parentElement);
		a +="身份认证-是否启用手机号码验证机制：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#手机号码验证#是否采取手机号码防伪措施")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#手机号码验证#是否采取手机号码防伪措施")[0].parentElement);
		a +="身份认证-是否采取手机号码防伪措施：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#OTP令牌#是否支持")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#OTP令牌#是否支持")[0].parentElement);
		a +="身份认证-是否支持：不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#动态口令卡#是否支持")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#动态口令卡#是否支持")[0].parentElement);
		a +="身份认证-动态口令卡：是否支持不能为空！\n";
		isValid = false;
	}
	if(getTableFormObjs("身份认证#内容#其他#是否采用其他认证方式")[0].value == ""){
		errorObjs.push(getTableFormObjs("身份认证#内容#其他#是否采用其他认证方式")[0].parentElement);
		a +="身份认证-是否采用其他认证方式：不能为空！\n";
		isValid = false;
	}
	
	if(getTableFormObj(label_YN03_02,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN03_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="安全管理-内容#安全评估-机构名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN09_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全#内容-会话安全管理措施-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN09_04,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN09_05,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全#内容-会话安全管理措施-连接空闲超时关闭时间为不能为空\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN09_07,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN09_08,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-会话安全管理措施-登录失败次数限制为不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10_02,"1_1_1" ).value=="是"){
		var obj1 = getTableFormObj(label_YN10_03,"1_1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="数据安全-内容-数据加密-传输加密协议名称：不能为空\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN10_04,"1_1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="数据安全-内容-数据加密-加密算法名称：不能为空\n";
			isValid = false;
		}var obj3 = getTableFormObj(label_YN10_05,"1_1_1_1" );
		if(obj3.value.trim()==""){
			errorObjs.push(obj3);
			a +="数据安全-内容#数据加密-密钥长度：不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN10_06,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN10_07,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-数据加密-加密的数据字段包括不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN11_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-高风险交易数据完整性保护及抗抵赖-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN11_03,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN11_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-高风险交易数据完整性保护及抗抵赖-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN12_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN12_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="数据安全-内容-敏感信息防泄露-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN08_03,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN08_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="通讯安全-内容-网络安全控制措施-隔离措施不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13_01,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN13_02,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-检测部门（组织、团队）名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN14_02,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN14_03,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-静态口令-交易限额为不能为空\n";
			isValid = false;
		}else{
			checkNumFloat(obj,2);
		}
	}
	if(getTableFormObj(label_YN14_04,"1_1_1" ).value=="是"){
			var obj = getTableFormObj(label_YN14_05,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-静态口令-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN15_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-手机号码验证-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN15_03,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN15_04,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-手机号码验证-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN17_07,"1_1_1" ).value=="是"){
		var obj1 = getTableFormObj(label_YN17_08,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="身份认证-内容-动态口令卡-基于坐标机制的动态口令卡的最大使用次数不能为空\n";
			isValid = false;
		}
		var obj2 = getTableFormObj(label_YN17_09,"1_1_1" );
		if(obj2.value.trim()==""){
			errorObjs.push(obj2);
			a +="身份认证-内容-动态口令卡-动态口令卡使用有效期不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN18_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN18_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="身份认证-内容-其他-措施简述不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN13_09,"1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN13_10,"1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="应用系统安全-内容-第三方机构名称不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN05_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN05_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj.parentElement);
			a +="安全管理-内容-安全审计-安全审计覆盖范围不能为空\n";
			isValid = false;
		}
	}
	if(getTableFormObj(label_YN02_01,"1_1_1" ).value=="是"){
		var obj = getTableFormObj(label_YN02_02,"1_1_1" );
		if(obj.value.trim()==""){
			errorObjs.push(obj);
			a +="安全管理-内容-交易风险等级划分-高风险交易包括不能为空\n";
			isValid = false;
		}
		var obj1 = getTableFormObj(label_YN02_03,"1_1_1" );
		if(obj1.value.trim()==""){
			errorObjs.push(obj1);
			a +="安全管理-内容-交易风险等级划分-低风险交易包括不能为空\n";
			isValid = false;
		}
	}
	
	if(getTableFormObjs(label_YN16_01)[0].value == "是"){
		var obj2 = getTableFormObjs(label_YN16_02)[0];
		var obj3 = getTableFormObjs(label_YN16_03)[0];
		var obj4 = getTableFormObjs(label_YN16_04)[0];
		var obj5 = getTableFormObjs(label_YN16_05)[0];

		if(obj2.value.trim()==""){
			errorObjs.push(obj2.parentElement);
			a +="手机银行 、身份认证-动态口令卡是否启用PIN码保护机制：”不能为空!\n";
			isValid = false;
		}
		if(obj3.value.trim()==""){
			errorObjs.push(obj3.parentElement);
			a +="手机银行 、身份认证-动态口令卡是否具备PIN码连续错误锁定机制：”不能为空!\n";
			isValid = false;
		}
		if(obj4.value.trim()==""){
			errorObjs.push(obj4.parentElement);
			a +="手机银行 、身份认证-动态口令的长度是否不少于6位：”不能为空!\n";
			isValid = false;
		}
		if(obj5.value.trim()==""){
			errorObjs.push(obj5.parentElement);
			a +="手机银行 、身份认证-PIN的长度是否不少于4位：”不能为空!\n";
			isValid = false;
		}
	}
	if(getTableFormObjs(label_YN17_01)[0].value == "是"){

		var obj2 = getTableFormObjs(label_YN17_02)[0];
		var obj3 = getTableFormObjs(label_YN17_03)[0];
		var obj4 = getTableFormObjs(label_YN17_04)[0];
		var obj5 = getTableFormObjs(label_YN17_05)[0];
		var obj6 = getTableFormObjs(label_YN17_06)[0];
		var obj7 = getTableFormObjs(label_YN17_07)[0];
		var obj8 = getTableFormObjs(label_YN17_08)[0];
		var obj9 = getTableFormObjs(label_YN17_09)[0];
		var obj10 = getTableFormObjs(label_YN17_10)[0];
		
		if(obj2.value.trim()==""){
			errorObjs.push(obj2.parentElement);
			a +="手机银行 、身份认证-动态口令卡是否启用PIN码保护机制：不能为空!\n";
			isValid = false;
		}
		if(obj3.value.trim()==""){
			errorObjs.push(obj3.parentElement);
			a +="手机银行 、身份认证-动态口令卡是否具备PIN码连续错误锁定机制：不能为空!\n";
			isValid = false;
		}
		if(obj4.value.trim()==""){
			errorObjs.push(obj4.parentElement);
			a +="手机银行 、身份认证-动态口令的长度是否不少于6位：不能为空!\n";
			isValid = false;
		}
		if(obj5.value.trim()==""){
			errorObjs.push(obj5.parentElement);
			a +="手机银行 、身份认证-PIN的长度是否不少于4位：不能为空!\n";
			isValid = false;
		}
		if(obj6.value.trim()==""){
			errorObjs.push(obj6.parentElement);
			a +="手机银行 、身份认证-是否支持基于坐标机制的动态口令卡：不能为空!\n";
			isValid = false;
		}
		if(obj7.value.trim()==""){
			errorObjs.push(obj7.parentElement);
			a +="手机银行 、身份认证-基于坐标机制的动态口令卡是否随机产生挑战口令坐标：不能为空!\n";
			isValid = false;
		}
		if(obj8.value.trim()==""){
			errorObjs.push(obj8);
			a +="手机银行 、身份认证-基于坐标机制的动态口令卡的最大使用次数：不能为空!\n";
			isValid = false;
		}
		if(obj9.value.trim()==""){
			errorObjs.push(obj9);
			a +="手机银行 、身份认证-动态口令卡使用有效期为：不能为空!\n";
			isValid = false;
		}
		if(obj10.value.trim()==""){
			errorObjs.push(obj10.parentElement);
			a +="手机银行 、身份认证-是否使用涂层覆盖等方法保护口令：不能为空!\n";
			isValid = false;
		}
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

var click_columnValueNumber = function() {
	columnValueNumber(this);
};

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
						imgs[k].onclick = function(){
							columnVallueRadio(this);
						};
					}
				}
			}
		}
	}
}

