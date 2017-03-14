/*
 * 报表：T-B-1 信息科技治理情况表_11A
 */

//校验按钮
var isValid = true;
var a = "";
var errorObjs=[];

var label_YN0101_GTZero = "董事会信息科技风险管理职责#内容#董事人数";
var label_YN0102_GTZero = "董事会信息科技风险管理职责#内容#独立董事人数";
var label_YN0103_GTZero = "董事会信息科技风险管理职责#内容#具有信息科技管理背景的董事人数";
var label_YN0104_GTZero = "董事会信息科技风险管理职责#内容#具有信息科技管理背景的独立董事人数";
var label_YN0105_GTZero = "董事会信息科技风险管理职责#内容#高管层人数";
var label_YN0106_GTZero = "董事会信息科技风险管理职责#内容#具有信息科技管理背景的高管人数";

var label_YN02 = "信息科技管理委员会#内容#是否设立";
var label_YN02_01 = "信息科技管理委员会#内容#组织名称";
var label_YN02_02 = "信息科技管理委员会#内容#成立日期";
var label_YN02_03 = "信息科技管理委员会#内容#组织负责人";
var label_YN02_04 = "信息科技管理委员会#内容#职务";
var label_YN02_06_GTZero = "信息科技管理委员会#内容#信息科技管理委员会总人数";
var label_YN02_07_GTZero = "信息科技管理委员会#内容#信息科技管理委员会中具有信息科技背景人数";
var label_YN02_08_GTZero = "信息科技管理委员会#内容#信息科技管理委员会下设专业分委员会或工作组数量";
var label_YN02_09_GTZero = "信息科技管理委员会#内容#本年度信息科技管理委员会全体会议次数";	

var label_YN03 = "首席信息官(CIO)#内容#是否设立";
var label_YN03_01 = "首席信息官(CIO)#内容#姓名";
var label_YN03_02 = "首席信息官(CIO)#内容#职务";
var label_YN03_03 = "首席信息官(CIO)#内容#履职起始日期";
var label_YN03_04 = "首席信息官(CIO)#内容#首席信息官是否纳入高级管理层";
var label_YN03_05 = "首席信息官(CIO)#内容#首席信息官汇报路线";

var label_YN08 = "信息科技战略规划#内容#是否建立信息科技战略规划";
var label_YN08_01 = "信息科技战略规划#内容#信息科技战略规划名称";
var label_YN08_02_GTZero = "信息科技战略规划#内容#规划期";
var label_YN08_03_GTZero = "信息科技战略规划#内容#到";
var label_YN08_04 = "信息科技战略规划#内容#签发日期";
var label_YN08_05 = "信息科技战略规划#内容#签发人职务";

var label_YN09 = "风险管理部门（组织）#内容#是否设立或指定专门的信息科技风险管理部门(组织)";
var label_YN09_01 = "风险管理部门（组织）#内容#部门（组织）名称";
var label_YN09_02 = "风险管理部门（组织）#内容#负责人";
var label_YN09_03 = "风险管理部门（组织）#内容#职务";
var label_YN09_04 = "风险管理部门（组织）#内容#隶属于";
var label_YN09_05_GTZero = "风险管理部门（组织）#内容#信息科技风险专职人员";
var label_YN09_06 = "风险管理部门（组织）#内容#风险管理部门（组织）报告路线";

var label_YN10 = "内审部门（岗位）#内容#是否设立";
var label_YN10_01 = "内审部门（岗位）#内容#部门（岗位）名称";
var label_YN10_02 = "内审部门（岗位）#内容#负责人";
var label_YN10_03 = "内审部门（岗位）#内容#职务";
var label_YN10_04_GTZero = "内审部门（岗位）#内容#内审人员";
var label_YN10_05 = "内审部门（岗位）#内容#信息科技内审部门（岗位）是否设立";
var label_YN10_05_01 = "内审部门（岗位）#内容#信息科技内审部门（岗位）名称";
var label_YN10_05_02_GTZero = "内审部门（岗位）#内容#信息科技内审人员";
var label_YN10_05_03 = "内审部门（岗位）#内容#信息科技内审部门报告路线";

var label_item95 = "机构信息科技投入#内容#本年度信息科技投入占年度总投入的比例：";
var label_D1_GTZero = "信息科技相关制度及标准#内容#信息科技管理制度总数#信息科技管理制度总数";
var label_D2_GTZero = "信息科技相关制度及标准#内容#信息科技管理制度总数#其中#本年度新增";
var label_D3_GTZero = "信息科技相关制度及标准#内容#信息科技管理制度总数#其中#本年度修订";
var label_D4_GTZero = "信息科技相关制度及标准#内容#信息科技风险管理制度总数#信息科技风险管理制度总数";
var label_D5_GTZero = "信息科技相关制度及标准#内容#信息科技风险管理制度总数#其中#本年度新增";
var label_D6_GTZero = "信息科技相关制度及标准#内容#信息科技风险管理制度总数#其中#本年度修订";
var label_D7_GTZero = "信息科技相关制度及标准#内容#信息科技审计制度总数#信息科技审计制度总数";
var label_D8_GTZero = "信息科技相关制度及标准#内容#信息科技审计制度总数#其中#本年度新增";
var label_D9_GTZero = "信息科技相关制度及标准#内容#信息科技审计制度总数#其中#本年度修订";

var label_item75_GTZero = "机构资产规模#内容#资产总额";

var label_item80_GTZero = "机构人员、关键岗位#内容#正式员工数";
var label_item81_GTZero = "机构人员、关键岗位#内容#非正式员工数";
var label_item82_GTZero = "机构人员、关键岗位#内容#信息科技正式员工数";
var label_item83_GTZero = "机构人员、关键岗位#内容#信息科技非正式员工数";
var label_item84_GTZero = "机构人员、关键岗位#内容#信息科技本年度入职员工数";
var label_item85_GTZero = "机构人员、关键岗位#内容#信息科技本年度离职员工数";
var label_item87_GTZero = "机构人员、关键岗位#内容#信息科技关键岗位人数";

var label_item88_GTZero = "机构信息科技投入#内容#本年度信息科技投入#本年度信息科技投入";
var label_item89_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#基础设施建设投入";
var label_item90_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#电子设备采购投";
var label_item91_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#软件采购投入";
var label_item92_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#系统开发项目投入";
var label_item93_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#系统运营投入";
var label_item1000_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#信息科技人力资源费用";
var label_item101_GTZero = "机构信息科技投入#内容#本年度信息科技投入#其中#其他";
var label_item94_GTZero = "机构信息科技投入#内容#本年度信息科技投入中外包费用：";
var label_item95_GTZero = "机构信息科技投入#内容#本年度信息科技投入占年度总投入的比例：";

var label_DecimalField1_GTZero = "信息科技人员专业高级资质持证情况#信息安全管理#通过人数(单位:人)";
var label_DecimalField2_GTZero = "信息科技人员专业高级资质持证情况#信息安全管理#其中-通过人数(单位:人)#CISSP";
var label_DecimalField3_GTZero = "信息科技人员专业高级资质持证情况#信息安全管理#其中-通过人数(单位:人)#CISM";
var label_DecimalField4_GTZero = "信息科技人员专业高级资质持证情况#信息安全管理#其中-通过人数(单位:人)#BS7799-LA";
var label_DecimalField5_GTZero = "信息科技人员专业高级资质持证情况#信息安全管理#其中-通过人数(单位:人)#其他";

var label_DecimalField6_GTZero = "信息科技人员专业高级资质持证情况#信息科技服务管理#通过人数(单位:人)";
var label_DecimalField7_GTZero = "信息科技人员专业高级资质持证情况#信息科技服务管理#其中-通过人数(单位:人)#ITIL Service Manager";
var label_DecimalField8_GTZero = "信息科技人员专业高级资质持证情况#信息科技服务管理#其中-通过人数(单位:人)#ITIL Practitioner";
var label_DecimalField9_GTZero = "信息科技人员专业高级资质持证情况#信息科技服务管理#其中-通过人数(单位:人)#其他";

var label_DecimalField10_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#通过人数（单位：人）";
var label_DecimalField11_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#PMP";
var label_DecimalField12_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#PRINCE2";
var label_DecimalField13_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#系统架构师";
var label_DecimalField14_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#系统分析师";
var label_DecimalField15_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#信息系统项目管理师";
var label_DecimalField16_GTZero = "信息科技人员专业高级资质持证情况#信息科技项目开发和管理#其中-通过人数(单位:人)#其他";

var label_DecimalField17_GTZero = "信息科技人员专业高级资质持证情况#网络管理#通过人数（单位：人）";
var label_DecimalField18_GTZero = "信息科技人员专业高级资质持证情况#网络管理#其中-通过人数（单位：人）#CCIE";
var label_DecimalField19_GTZero = "信息科技人员专业高级资质持证情况#网络管理#其中-通过人数（单位：人）#其他";

var label_DecimalField20_GTZero = "信息科技人员专业高级资质持证情况#数据库管理#通过人数（单位：人）";
var label_DecimalField21_GTZero = "信息科技人员专业高级资质持证情况#数据库管理#其中-通过人数（单位：人）#OCP";
var label_DecimalField22_GTZero = "信息科技人员专业高级资质持证情况#数据库管理#其中-通过人数（单位：人）#OCM";
var label_DecimalField23_GTZero = "信息科技人员专业高级资质持证情况#数据库管理#其中-通过人数（单位：人）#IBM Certified DBA";
var label_DecimalField24_GTZero = "信息科技人员专业高级资质持证情况#数据库管理#其中-通过人数（单位：人）#其他";

var label_DecimalField25_GTZero = "信息科技人员专业高级资质持证情况#业务连续性管理#通过人数（单位：人）";
var label_DecimalField26_GTZero = "信息科技人员专业高级资质持证情况#业务连续性管理#其中-通过人数（单位：人）#CBCP";
var label_DecimalField27_GTZero = "信息科技人员专业高级资质持证情况#业务连续性管理#其中-通过人数（单位：人）#其他";

var label_DecimalField28_GTZero = "信息科技人员专业高级资质持证情况#审计#通过人数（单位：人）";
var label_DecimalField29_GTZero = "信息科技人员专业高级资质持证情况#审计#其中-通过人数（单位：人）#CISA";
var label_DecimalField30_GTZero = "信息科技人员专业高级资质持证情况#审计#其中-通过人数（单位：人）#CIA";
var label_DecimalField31_GTZero = "信息科技人员专业高级资质持证情况#审计#其中-通过人数（单位：人）#其他";

var label_D11_GTZero = "机构网点规模#内容#设有境内分支机构的省级行政区数量";
/*
* 功能：初始化页面设置表单联动
* 配置：年报审批
*/
function initSet(){
	var obj = 0;
	setYN02Disable(obj);
	setYN03Disable(obj);
	setYN08Disable(obj);
	setYN09Disable(obj);
	setYN10Disable(obj);
	setYN10_05Disable(obj);
}

/*
 *功能：将信息科技管理委员会成立日期的日取每个月的第一天
 *配置：信息科技管理委员会#内容#成立日期
 */
function changeYN02_02(obj){
	var obj_YN02_02 = getTableFormObjs(label_YN02_02)[0];
	obj_YN02_02.value = obj_YN02_02.value.substring(0,obj_YN02_02.value.lastIndexOf("/")) + "/01";
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
	var obj_YN02_06_GTZero = getTableFormObj(label_YN02_06_GTZero,obj_YN02.rownumber );
	var obj_YN02_07_GTZero = getTableFormObj(label_YN02_07_GTZero,obj_YN02.rownumber );
	var obj_YN02_08_GTZero = getTableFormObj(label_YN02_08_GTZero,obj_YN02.rownumber );
	var obj_YN02_09_GTZero = getTableFormObj(label_YN02_09_GTZero,obj_YN02.rownumber );
	if (obj_YN02.value.trim() == "否") {
		// 只读
		obj_YN02_01.readOnly = "readonly";
		obj_YN02_02.onclick = "";
		obj_YN02_03.readOnly = "readonly";
		obj_YN02_04.readOnly = "readonly";
		obj_YN02_06_GTZero.onclick = "";
		obj_YN02_07_GTZero.onclick = "";
		obj_YN02_08_GTZero.onclick = "";
		obj_YN02_09_GTZero.onclick = "";
		// 清空
		obj_YN02_01.value = "";
		obj_YN02_02.value = "";
		obj_YN02_03.value = "";
		obj_YN02_04.value = "";
		obj_YN02_06_GTZero.value = "";
		obj_YN02_07_GTZero.value = "";
		obj_YN02_08_GTZero.value = "";
		obj_YN02_09_GTZero.value = "";
	} else if (obj_YN02.value.trim() == "是") {
		// 还原
		obj_YN02_01.readOnly = "";
		obj_YN02_02.onclick = click_columnshowDate;
		obj_YN02_03.readOnly = "";
		obj_YN02_04.readOnly = "";
		obj_YN02_06_GTZero.onclick = click_columnValueNumber;
		obj_YN02_07_GTZero.onclick = click_columnValueNumber;
		obj_YN02_08_GTZero.onclick = click_columnValueNumber;
		obj_YN02_09_GTZero.onclick = click_columnValueNumber;
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
	
	if (obj_YN03.value == "否") {
		// 只读
		obj_YN03_01.readOnly = "readonly";
		obj_YN03_02.readOnly = "readonly";
		obj_YN03_03.onclick = "";
		columnVallueRadio1(obj_YN03_04,false,false);
		obj_YN03_05.readOnly = "readonly";

		// 清空
		obj_YN03_01.value = "";
		obj_YN03_02.value = "";
		obj_YN03_03.value = "";
		obj_YN03_04.value = "";
		obj_YN03_05.value = "";

	} else if (obj_YN03.value == "是") {
		// 还原
		obj_YN03_01.readOnly = "";
		obj_YN03_02.readOnly = "";
		obj_YN03_03.onclick = click_columnshowDate;
		columnVallueRadio1(obj_YN03_04,true,false);
		obj_YN03_05.readOnly = "";

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
 *功能：根据单选按钮修改表单是否可读写
 *配置：信息科技战略规划#内容#是否建立信息科技战略规划
 */
function setYN08Disable(objcld) {
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02_GTZero = getTableFormObj(label_YN08_02_GTZero,obj_YN08.rownumber );
	var obj_YN08_03_GTZero = getTableFormObj(label_YN08_03_GTZero,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if (obj_YN08.value.trim() == "否") {
		// 只读
		obj_YN08_01.readOnly = "readonly";
		obj_YN08_02_GTZero.onclick = "";
		obj_YN08_03_GTZero.onclick = "";
		obj_YN08_04.onclick = "";
		obj_YN08_05.readOnly = "readonly";

		// 清空
		obj_YN08_01.value = "";
		obj_YN08_02_GTZero.value = "";
		obj_YN08_03_GTZero.value = "";
		obj_YN08_04.value = "";
		obj_YN08_05.value = "";

	} else if (obj_YN08.value.trim() == "是") {
		// 还原
		obj_YN08_01.readOnly = "";
		obj_YN08_02_GTZero.onclick = click_columnValueNumber;
		obj_YN08_03_GTZero.onclick = click_columnValueNumber;
		obj_YN08_04.onclick = click_columnshowDate;
		obj_YN08_05.readOnly = "";

	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：风险管理部门（组织）#内容#是否设立或指定专门的信息科技风险管理部门(组织)
 */
function setYN09Disable(objcld) {
	var obj_YN09 = getTableFormObjs(label_YN09)[0];
	var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN09.rownumber );
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_04 = getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_05_GTZero = getTableFormObj(label_YN09_05_GTZero,obj_YN09.rownumber );
	var obj_YN09_06 = getTableFormObj(label_YN09_06,obj_YN09.rownumber );
	if (obj_YN09.value.trim() == "否") {
		// 只读
		obj_YN09_01.readOnly = "readonly";
		obj_YN09_02.readOnly = "readonly";
		obj_YN09_03.readOnly = "readonly";
		obj_YN09_04.readOnly = "readonly";
		obj_YN09_05_GTZero.onclick = "";
		obj_YN09_06.readOnly = "readonly";
		// 清空
		obj_YN09_01.value = "";
		obj_YN09_02.value = "";
		obj_YN09_03.value = "";
		obj_YN09_04.value = "";
		obj_YN09_05_GTZero.value = "";
		obj_YN09_06.value = "";
	} else if (obj_YN09.value.trim() == "是") {
		// 还原		
		obj_YN09_01.readOnly = "";
		obj_YN09_02.readOnly = "";
		obj_YN09_03.readOnly = "";
		obj_YN09_04.readOnly = "";
		obj_YN09_05_GTZero.onclick = click_columnValueNumber;
		obj_YN09_06.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：内审部门（岗位） #内容#是否设立
 */
function setYN10Disable(objcld) {
	var obj_YN10 = getTableFormObjs(label_YN10)[0];
	var obj_YN10_01 = getTableFormObj(label_YN10_01,obj_YN10.rownumber );
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10.rownumber );
	var obj_YN10_04_GTZero = getTableFormObj(label_YN10_04_GTZero,obj_YN10.rownumber );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10.rownumber );
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10.rownumber );
	if (obj_YN10.value.trim() == "否") {
		// 只读
		obj_YN10_01.readOnly = "readonly";
		obj_YN10_02.readOnly = "readonly";
		obj_YN10_03.readOnly = "readonly";
		obj_YN10_04_GTZero.onclick = "";
		columnVallueRadio1(obj_YN10_05,false,true);
		obj_YN10_05_01.readOnly = "readonly";
		obj_YN10_05_02_GTZero.onclick = "";
		obj_YN10_05_03.readOnly = "readonly";
		// 清空
		obj_YN10_01.value = "";
		obj_YN10_02.value = "";
		obj_YN10_03.value = "";
		obj_YN10_04_GTZero.value = "";
		obj_YN10_05.value = "";
		obj_YN10_05_01.value = "";
		obj_YN10_05_02_GTZero.value = "";
		obj_YN10_05_03.value = "";
		
	} else if (obj_YN10.value.trim() == "是") {
		// 还原		
		obj_YN10_01.readOnly = "";
		obj_YN10_02.readOnly = "";
		obj_YN10_03.readOnly = "";
		obj_YN10_04_GTZero.onclick = click_columnValueNumber;
		columnVallueRadio1(obj_YN10_05,true,true);
		obj_YN10_05_01.readOnly = "";
		obj_YN10_05_02_GTZero.onclick = click_columnValueNumber;
		obj_YN10_05_03.readOnly = "";
	}
}

/*
 *功能：根据单选按钮修改表单是否可读写
 *配置：内审部门（岗位） #内容#信息科技内审部门（岗位）是否设立
 */
function setYN10_05Disable(objcld) {
	var obj_YN10_05 = getTableFormObjs(label_YN10_05)[0];
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10_05.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10_05.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10_05.rownumber );
	if (obj_YN10_05.value.trim() == "否") {
		// 只读
		obj_YN10_05_01.readOnly = "readonly";
		obj_YN10_05_02_GTZero.onclick = "";
		obj_YN10_05_03.readOnly = "readonly";
		// 清空
		obj_YN10_05_01.value = "";
		obj_YN10_05_02_GTZero.value = "";
		obj_YN10_05_03.value = "";
		
	} else if (obj_YN10_05.value.trim() == "是") {
		// 还原		
		obj_YN10_05_01.readOnly = "";
		obj_YN10_05_02_GTZero.onclick = click_columnValueNumber;
		obj_YN10_05_03.readOnly = "";
	}
}

/*
 *功能：判断表单内容是否大于100
 *配置： 机构信息科技投入 #内容#本年度信息科技投入占年度总投入的比例：
 */
function checkItem95(obj){
	var obj = getTarget(obj);
	var obj_item95 = getTableFormObjs(label_item95)[0];
	if(obj_item95.value>100){
		alert("比率不能大于100！");
		obj_item95.value = "";
	}
}

/*
 *功能：恢复日期输入
 */
var click_columnshowDate = function(){
	showDate(this);
}

/*
 *功能：恢复数字键盘输入
 */
var click_columnValueNumber = function() {
	columnValueNumber(this);
};

function checkData() {
	//清空错误表单的背景色
	for(var i=0 ;i<errorObjs.length;i++) {
		errorObjs[i].style.color="";
		errorObjs[i].style.backgroundColor="";
	}
	errorObjs = [];
	var obj_YN02 = getTableFormObjs(label_YN02)[0];
	var obj_YN02_01 = getTableFormObj(label_YN02_01,obj_YN02.rownumber );
	var obj_YN02_02 = getTableFormObj(label_YN02_02,obj_YN02.rownumber );
	var obj_YN02_03 = getTableFormObj(label_YN02_03,obj_YN02.rownumber );
	var obj_YN02_04 = getTableFormObj(label_YN02_04,obj_YN02.rownumber );
	var obj_YN02_06_GTZero = getTableFormObj(label_YN02_06_GTZero,obj_YN02.rownumber );
	var obj_YN02_07_GTZero = getTableFormObj(label_YN02_07_GTZero,obj_YN02.rownumber );
	var obj_YN02_08_GTZero = getTableFormObj(label_YN02_08_GTZero,obj_YN02.rownumber );
	var obj_YN02_09_GTZero = getTableFormObj(label_YN02_09_GTZero,obj_YN02.rownumber );
	if(obj_YN02.value == "是" ){
		if(obj_YN02_01.value.trim() == ""){
			errorObjs.push(obj_YN02_01);
			a += "信息科技管理委员会-组织名称不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_02.value.trim() == ""){
			errorObjs.push(obj_YN02_02);
			a += "信息科技管理委员会-成立日期不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_03.value.trim() == ""){
			errorObjs.push(obj_YN02_03);
			a += "信息科技管理委员会-组织负责人不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_04.value.trim() == ""){
			errorObjs.push(obj_YN02_04);
			a += "信息科技管理委员会-职务不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_06_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_06_GTZero);
			a += "信息科技管理委员会总人数不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_07_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_07_GTZero);
			a += "信息科技管理委员会中具有信息科技背景人数不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_08_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_08_GTZero);
			a += "信息科技管理委员会下设专业分委员会或工作组数量不能为空!\n";
			isValid = false;
		}
		if(obj_YN02_09_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN02_09_GTZero);
			a += "本年度信息科技管理委员会全体会议次数不能为空!\n";
			isValid = false;
		}
		
	}
	var obj_YN03 = getTableFormObjs(label_YN03)[0];
	var obj_YN03_01 = getTableFormObj(label_YN03_01,obj_YN03.rownumber );
	var obj_YN03_02 = getTableFormObj(label_YN03_02,obj_YN03.rownumber );
	var obj_YN03_03 = getTableFormObj(label_YN03_03,obj_YN03.rownumber );
	var obj_YN03_05 = getTableFormObj(label_YN03_05,obj_YN03.rownumber );
	if(obj_YN03.value == "是"){
		if(obj_YN03_01.value.trim() == ""){
			errorObjs.push(obj_YN03_01);
			a += "首席信息官-姓名不能为空!\n";
			isValid = false;
		}
		if(obj_YN03_02.value.trim() == ""){
			errorObjs.push(obj_YN03_02);
			a += "首席信息官-职务不能为空!\n";
			isValid = false;
		}
		if(obj_YN03_03.value.trim() == ""){
			errorObjs.push(obj_YN03_03);
			a += "首席信息官-履职起始日期不能为空!\n";
			isValid = false;
		}
		if(obj_YN03_05.value.trim() == ""){
			errorObjs.push(obj_YN03_05);
			a += "首席信息官汇报路线不能为空!\n";
			isValid = false;
		}
	}
	var obj_YN08 = getTableFormObjs(label_YN08)[0];
	var obj_YN08_01 = getTableFormObj(label_YN08_01,obj_YN08.rownumber );
	var obj_YN08_02_GTZero = getTableFormObj(label_YN08_02_GTZero,obj_YN08.rownumber );
	var obj_YN08_03_GTZero = getTableFormObj(label_YN08_03_GTZero,obj_YN08.rownumber );
	var obj_YN08_04 = getTableFormObj(label_YN08_04,obj_YN08.rownumber );
	var obj_YN08_05 = getTableFormObj(label_YN08_05,obj_YN08.rownumber );
	if(obj_YN08.value == "是"){
		if(obj_YN08_01.value.trim() == ""){
			errorObjs.push(obj_YN08_01);
			a += "对业务战略规划的支持-规划名称不能为空!\n";
			isValid = false;
		}
		if(obj_YN08_02_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN08_02_GTZero);
			a += "对业务战略规划的支持-规划起始日期不能为空!\n";
			isValid = false;
		}
		if(obj_YN08_03_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN08_03_GTZero);
			a += "对业务战略规划的支持-规划结束日期不能为空!\n";
			isValid = false;
		}
		if(obj_YN08_04.value.trim() == ""){
			errorObjs.push(obj_YN08_04);
			a += "对业务战略规划的支持-签发日期不能为空!\n";
			isValid = false;
		}
		if(obj_YN08_05.value.trim() == ""){
			errorObjs.push(obj_YN08_05);
			a += "对业务战略规划的支持-签发人职务不能为空!\n";
			isValid = false;
		}
	}
	var obj_YN09 = getTableFormObjs(label_YN09)[0];
	var obj_YN09_01 = getTableFormObj(label_YN09_01,obj_YN09.rownumber );
	var obj_YN09_02 = getTableFormObj(label_YN09_02,obj_YN09.rownumber );
	var obj_YN09_03 = getTableFormObj(label_YN09_03,obj_YN09.rownumber );
	var obj_YN09_04 = getTableFormObj(label_YN09_04,obj_YN09.rownumber );
	var obj_YN09_05_GTZero = getTableFormObj(label_YN09_05_GTZero,obj_YN09.rownumber );
	var obj_YN09_06 = getTableFormObj(label_YN09_06,obj_YN09.rownumber );
	if(obj_YN09.value == "是"){
		if(obj_YN09_01.value.trim() == ""){
			errorObjs.push(obj_YN09_01);
			a += "信息科技风险管理部门-部门名称不能为空!\n";
			isValid = false;
		}
		if(obj_YN09_02.value.trim() == ""){
			errorObjs.push(obj_YN09_02);
			a += "信息科技风险管理部门-负责人不能为空!\n";
			isValid = false;
		}
		if(obj_YN09_03.value.trim() == ""){
			errorObjs.push(obj_YN09_03);
			a += "信息科技风险管理部门-职务不能为空!\n";
			isValid = false;
		}
		if(obj_YN09_04.value.trim() == ""){
			errorObjs.push(obj_YN09_04);
			a += "信息科技风险管理部门-隶属部门不能为空!\n";
			isValid = false;
		}
		if(obj_YN09_05_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN09_05_GTZero);
			a += "信息科技风险管理部门-人员数不能为空!\n";
			isValid = false;
		}
		if(obj_YN09_06.value.trim() == ""){
			errorObjs.push(obj_YN09_06);
			a += "信息科技风险管理部门-报告路线不能为空!\n";
			isValid = false;
		}
	}
	var obj_YN10 = getTableFormObjs(label_YN10)[0];
	var obj_YN10_01 = getTableFormObj(label_YN10_01,obj_YN10.rownumber );
	var obj_YN10_02 = getTableFormObj(label_YN10_02,obj_YN10.rownumber );
	var obj_YN10_03 = getTableFormObj(label_YN10_03,obj_YN10.rownumber );
	var obj_YN10_04_GTZero = getTableFormObj(label_YN10_04_GTZero,obj_YN10.rownumber );
	var obj_YN10_05 = getTableFormObj(label_YN10_05,obj_YN10.rownumber );
	var obj_YN10_05_01 = getTableFormObj(label_YN10_05_01,obj_YN10.rownumber );
	var obj_YN10_05_02_GTZero = getTableFormObj(label_YN10_05_02_GTZero,obj_YN10.rownumber );
	var obj_YN10_05_03 = getTableFormObj(label_YN10_05_03,obj_YN10.rownumber );
	if(obj_YN10.value == "是"){
		if(obj_YN10_01.value.trim() == ""){
			errorObjs.push(obj_YN10_01);
			a += "内审部门-部门名称不能为空!\n";
			isValid = false;
		}
		if(obj_YN10_02.value.trim() == ""){
			errorObjs.push(obj_YN10_02);
			a += "内审部门-负责人不能为空!\n";
			isValid = false;
		}
		if(obj_YN10_03.value.trim() == ""){
			errorObjs.push(obj_YN10_03);
			a += "内审部门-职务不能为空!\n";
			isValid = false;
		}
		if(obj_YN10_04_GTZero.value.trim() == ""){
			errorObjs.push(obj_YN10_04_GTZero);
			a += "内审部门-内审人员不能为空!\n";
			isValid = false;
		}
		if(obj_YN10_05.value.trim() == ""){
			errorObjs.push(obj_YN10_05.parentElement);
			a += "内审部门-信息科技内审部门是否设立不能为空!\n";
			isValid = false;
		}
		if(obj_YN10_05.value == "是"){
			if(obj_YN10_05_01.value.trim() == ""){
				errorObjs.push(obj_YN10_05_01);
				a += "内审部门-信息科技内审部门名称不能为空!\n";
				isValid = false;
			}
			if(obj_YN10_05_02_GTZero.value.trim() == ""){
				errorObjs.push(obj_YN10_05_02_GTZero);
				a += "内审部门-信息科技内审人员不能为空!\n";
				isValid = false;
			}
			if(obj_YN10_05_03.value.trim() == ""){
				errorObjs.push(obj_YN10_05_03);
				a += "内审部门-报告路线不能为空!\n";
				isValid = false;
			}
		}
	}
	
	var obj_YN0101_GTZero = getTableFormObjs(label_YN0101_GTZero)[0];
	var obj_YN0103_GTZero = getTableFormObjs(label_YN0103_GTZero)[0];
	if(parseInt(obj_YN0103_GTZero.value) > parseInt(obj_YN0101_GTZero.value)){
		errorObjs.push(obj_YN0103_GTZero);
		a += "具有信息科技管理背景的董事人数≤董事人数校验出错！\n";
		isValid = false;
	}
	
	var obj_YN0102_GTZero = getTableFormObjs(label_YN0102_GTZero)[0];
	var obj_YN0104_GTZero = getTableFormObjs(label_YN0104_GTZero)[0];
	if(parseInt(obj_YN0102_GTZero.value) < parseInt(obj_YN0104_GTZero.value)){
		errorObjs.push(obj_YN0104_GTZero);
	 	a+="具有信息科技管理背景的独立董事人数≤独立董事人数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_YN0105_GTZero = getTableFormObjs(label_YN0105_GTZero)[0];
	var obj_YN0106_GTZero = getTableFormObjs(label_YN0106_GTZero)[0];
	if(parseInt(obj_YN0105_GTZero.value) < parseInt(obj_YN0106_GTZero.value)){
		errorObjs.push(obj_YN0106_GTZero);
	 	a+="具有信息科技管理背景的高管层人数≤高管层人数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_YN02_06_GTZero = getTableFormObjs(label_YN02_06_GTZero)[0];
	var obj_YN02_07_GTZero = getTableFormObjs(label_YN02_07_GTZero)[0];
	if(parseInt(obj_YN02_06_GTZero.value) < parseInt(obj_YN02_07_GTZero.value)){
		errorObjs.push(obj_YN02_07_GTZero);
	 	a+="信息科技管理委员会中具有信息科技背景人数≤信息科技管理委员会人数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_D11_GTZero = getTableFormObjs(label_D11_GTZero)[0];
	if(parseInt(obj_D11_GTZero.value) > 36){
		errorObjs.push(obj_D11_GTZero);
	 	a+="设有境内分支机构的省级行政区数量≤36校验出错！\n";
	  	isValid=false;
	}
	
	var obj_D1_GTZero = getTableFormObjs(label_D1_GTZero)[0];
	var obj_D2_GTZero = getTableFormObjs(label_D2_GTZero)[0];
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D2_GTZero.value)){
		errorObjs.push(obj_D2_GTZero);
	 	a+="信息科技管理制度总数>=本年度新增校验出错！\n";
	  	isValid=false;
	}

	var obj_D3_GTZero = getTableFormObjs(label_D3_GTZero)[0];
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D3_GTZero.value)){
		errorObjs.push(obj_D3_GTZero);
	 	a+="信息科技管理制度总数>=本年度修订校验出错！\n";
	  	isValid=false;
	}
	
	var obj_D4_GTZero = getTableFormObjs(label_D4_GTZero)[0];
	var obj_D5_GTZero = getTableFormObjs(label_D5_GTZero)[0];
	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D5_GTZero.value)){
		errorObjs.push(obj_D5_GTZero);
	 	a+="信息科技风险管理制度总数>=本年度新增校验出错！\n";
	  	isValid=false;
	}

	var obj_D6_GTZero = getTableFormObjs(label_D6_GTZero)[0];
	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D6_GTZero.value)){
		errorObjs.push(obj_D6_GTZero);
	 	a+="信息科技风险管理制度总数>=本年度修订校验出错！\n";
	  	isValid=false;
	}
	
	var obj_D7_GTZero = getTableFormObjs(label_D7_GTZero)[0];
	var obj_D8_GTZero = getTableFormObjs(label_D8_GTZero)[0];
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D8_GTZero.value)){
		errorObjs.push(obj_D8_GTZero);
	 	a+="信息科技审计制度总数>=本年度新增校验出错！\n";
	  	isValid=false;
	}
	
	var obj_D9_GTZero = getTableFormObjs(label_D9_GTZero)[0];
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D9_GTZero.value)){
		errorObjs.push(obj_D9_GTZero);
	 	a+="信息科技审计制度总数>=本年度修订校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_D7_GTZero.value) < parseInt(obj_D8_GTZero.value) + parseInt(obj_D9_GTZero.value)){
		errorObjs.push(obj_D7_GTZero);
	 	a+="信息科技审计制度总数>=本年度新增 + 本年度修订校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_D1_GTZero.value) < parseInt(obj_D2_GTZero.value) + parseInt(obj_D3_GTZero.value)){
		errorObjs.push(obj_D1_GTZero);
	 	a+="信息科技管理制度总数>=本年度新增 + 本年度修订校验出错！\n";
	  	isValid=false;
	}

	if(parseInt(obj_D4_GTZero.value) < parseInt(obj_D5_GTZero.value) + parseInt(obj_D6_GTZero.value)){
		errorObjs.push(obj_D4_GTZero);
	 	a+="信息科技风险管理制度总数>=本年度新增 + 本年度修订校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item80_GTZero = getTableFormObjs(label_item80_GTZero)[0];
	var obj_item82_GTZero = getTableFormObjs(label_item82_GTZero)[0];
	if(parseInt(obj_item82_GTZero.value) > parseInt(obj_item80_GTZero.value)){
		errorObjs.push(obj_item82_GTZero);
	 	a+="正式员工数>=信息科技正式员工数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item81_GTZero = getTableFormObjs(label_item81_GTZero)[0];
	var obj_item83_GTZero = getTableFormObjs(label_item83_GTZero)[0];
	if( parseInt(obj_item81_GTZero.value) < parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item83_GTZero);
	 	a+="非正式员工数>=信息科技非正式员工数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item87_GTZero = getTableFormObjs(label_item87_GTZero)[0];
	if(parseInt(obj_item87_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item87_GTZero.value)){
		errorObjs.push(obj_item87_GTZero);
	 	a+="信息科技正式员工数>=信息科技关键岗位人数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item84_GTZero = getTableFormObjs(label_item84_GTZero)[0];
	if(parseInt(obj_item84_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item84_GTZero);
	 	a+="信息科技本年度入职员工数<=信息科技总员工数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item85_GTZero = getTableFormObjs(label_item85_GTZero)[0];
	if( parseInt(obj_item85_GTZero.value) > parseInt(obj_item82_GTZero.value) + parseInt(obj_item83_GTZero.value)){
		errorObjs.push(obj_item85_GTZero);
	 	a+="信息科技本年度离职员工数<=信息科技总员工数校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item88_GTZero = getTableFormObjs(label_item88_GTZero)[0];
	checkNumFloat(obj_item88_GTZero,2);
	var obj_item89_GTZero = getTableFormObjs(label_item89_GTZero)[0];
	checkNumFloat(obj_item89_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item89_GTZero.value)){
		errorObjs.push(obj_item89_GTZero);
	 	a+="本年度信息科技投入>=基础设施建设投入校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item90_GTZero = getTableFormObjs(label_item90_GTZero)[0];
	checkNumFloat(obj_item90_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item90_GTZero.value)){
		errorObjs.push(obj_item90_GTZero);
	 	a+="本年度信息科技投入>=电子设备采购投校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item91_GTZero = getTableFormObjs(label_item91_GTZero)[0];
	checkNumFloat(obj_item91_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item91_GTZero.value)){
		errorObjs.push(obj_item91_GTZero);
	 	a+="本年度信息科技投入>=软件采购投入校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item92_GTZero = getTableFormObjs(label_item92_GTZero)[0];
	checkNumFloat(obj_item92_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item92_GTZero.value)){
		errorObjs.push(obj_item92_GTZero);
	 	a+="本年度信息科技投入>=系统开发项目投入校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item93_GTZero = getTableFormObjs(label_item93_GTZero)[0];
	checkNumFloat(obj_item93_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item93_GTZero.value)){
		errorObjs.push(obj_item93_GTZero);
	 	a+="本年度信息科技投入>=系统运营投入校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item1000_GTZero = getTableFormObjs(label_item1000_GTZero)[0];
	checkNumFloat(obj_item1000_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item1000_GTZero.value)){
		errorObjs.push(obj_item1000_GTZero);
	 	a+="本年度信息科技投入>=信息科技人力资源费用校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item101_GTZero = getTableFormObjs(label_item101_GTZero)[0];
	checkNumFloat(obj_item101_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item101_GTZero.value)){
		errorObjs.push(obj_item101_GTZero);
	 	a+="本年度信息科技投入>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item94_GTZero = getTableFormObjs(label_item94_GTZero)[0];
	checkNumFloat(obj_item94_GTZero,2);
	if(parseFloat(obj_item88_GTZero.value) < parseFloat(obj_item94_GTZero.value)){
		errorObjs.push(obj_item94_GTZero);
	 	a+="本年度信息科技投入>=本年度信息科技投入中外包费用校验出错！\n";
	  	isValid=false;
	}
	
	var obj_item95_GTZero = getTableFormObjs(label_item95_GTZero)[0];
	checkNumFloat(obj_item95_GTZero,2);
	
	var obj_item75_GTZero = getTableFormObjs(label_item75_GTZero)[0];
	checkNumFloat(obj_item75_GTZero,2);
	
	var obj_DecimalField1_GTZero = getTableFormObjs(label_DecimalField1_GTZero)[0];
	var obj_DecimalField2_GTZero = getTableFormObjs(label_DecimalField2_GTZero)[0]; 
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField2_GTZero.value)){
		errorObjs.push(obj_DecimalField2_GTZero);
	 	a+="信息安全管理>=CISSP校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField3_GTZero = getTableFormObjs(label_DecimalField3_GTZero)[0];
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField3_GTZero.value)){
		errorObjs.push(obj_DecimalField3_GTZero);
	 	a+="信息安全管理>=CISM校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField4_GTZero = getTableFormObjs(label_DecimalField4_GTZero)[0];
	if(parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField4_GTZero.value)){
		errorObjs.push(obj_DecimalField4_GTZero);
	 	a+="信息安全管理>=BS7799-LA校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField5_GTZero = getTableFormObjs(label_DecimalField5_GTZero)[0];
	if( parseInt(obj_DecimalField1_GTZero.value) < parseInt(obj_DecimalField5_GTZero.value)){
		errorObjs.push(obj_DecimalField5_GTZero);
	 	a+="信息安全管理>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField6_GTZero = getTableFormObjs(label_DecimalField6_GTZero)[0];
	var obj_DecimalField7_GTZero = getTableFormObjs(label_DecimalField7_GTZero)[0];
	if( parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField7_GTZero.value)){
		errorObjs.push(obj_DecimalField7_GTZero);
	 	a+="信息科技服务管理>=ITIL Service Manager校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField8_GTZero = getTableFormObjs(label_DecimalField8_GTZero)[0];
	if(parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField8_GTZero.value)){
		errorObjs.push(obj_DecimalField8_GTZero);
	 	a+="信息科技服务管理>=ITIL Practitioner校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField9_GTZero = getTableFormObjs(label_DecimalField9_GTZero)[0];
	if(parseInt(obj_DecimalField6_GTZero.value) < parseInt(obj_DecimalField9_GTZero.value)){
		errorObjs.push(obj_DecimalField9_GTZero);
	 	a+="信息科技服务管理>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField10_GTZero = getTableFormObjs(label_DecimalField10_GTZero)[0];
	var obj_DecimalField11_GTZero = getTableFormObjs(label_DecimalField11_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField11_GTZero.value)){
		errorObjs.push(obj_DecimalField11_GTZero);
	 	a+="信息科技项目开发和管理>=PMP校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField12_GTZero = getTableFormObjs(label_DecimalField12_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField12_GTZero.value)){
		errorObjs.push(obj_DecimalField12_GTZero);
	 	a+="信息科技项目开发和管理>=PRINCE2校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField13_GTZero = getTableFormObjs(label_DecimalField13_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField13_GTZero.value)){
		errorObjs.push(obj_DecimalField13_GTZero);
	 	a+="信息科技项目开发和管理>=系统架构师校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField14_GTZero = getTableFormObjs(label_DecimalField14_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField14_GTZero.value)){
		errorObjs.push(obj_DecimalField14_GTZero);
	 	a+="信息科技项目开发和管理>=系统分析师校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField15_GTZero = getTableFormObjs(label_DecimalField15_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField15_GTZero.value)){
		errorObjs.push(obj_DecimalField15_GTZero);
	 	a+="信息科技项目开发和管理>=信息系统项目管理师校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField16_GTZero = getTableFormObjs(label_DecimalField16_GTZero)[0];
	if( parseInt(obj_DecimalField10_GTZero.value) < parseInt(obj_DecimalField16_GTZero.value)){
		errorObjs.push(obj_DecimalField16_GTZero);
	 	a+="信息科技项目开发和管理>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField17_GTZero = getTableFormObjs(label_DecimalField17_GTZero)[0];
	var obj_DecimalField18_GTZero = getTableFormObjs(label_DecimalField18_GTZero)[0];
	if( parseInt(obj_DecimalField17_GTZero.value) < parseInt(obj_DecimalField18_GTZero.value)){
		errorObjs.push(obj_DecimalField18_GTZero);
	 	a+="网络管理>=CCIE校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField19_GTZero = getTableFormObjs(label_DecimalField19_GTZero)[0];
	if( parseInt(obj_DecimalField17_GTZero.value) < parseInt(obj_DecimalField19_GTZero.value)){
		errorObjs.push(obj_DecimalField19_GTZero);
	 	a+="网络管理>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField20_GTZero = getTableFormObjs(label_DecimalField20_GTZero)[0];
	var obj_DecimalField21_GTZero = getTableFormObjs(label_DecimalField21_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField21_GTZero.value)){
		errorObjs.push(obj_DecimalField21_GTZero);
	 	a+="数据库管理>=OCP校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField22_GTZero = getTableFormObjs(label_DecimalField22_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField22_GTZero.value)){
		errorObjs.push(obj_DecimalField22_GTZero);
	 	a+="数据库管理>=OCM校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField23_GTZero = getTableFormObjs(label_DecimalField23_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField23_GTZero.value)){
		errorObjs.push(obj_DecimalField23_GTZero);
	 	a+="数据库管理>=IBM Certified DBA校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField24_GTZero = getTableFormObjs(label_DecimalField24_GTZero)[0];
	if( parseInt(obj_DecimalField20_GTZero.value) < parseInt(obj_DecimalField24_GTZero.value)){
		errorObjs.push(obj_DecimalField24_GTZero);
	 	a+="数据库管理>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField25_GTZero = getTableFormObjs(label_DecimalField25_GTZero)[0];
	var obj_DecimalField26_GTZero = getTableFormObjs(label_DecimalField26_GTZero)[0];
	if( parseInt(obj_DecimalField25_GTZero.value) < parseInt(obj_DecimalField26_GTZero.value)){
		errorObjs.push(obj_DecimalField26_GTZero);
	 	a+="业务连续性管理>=CBCP校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField27_GTZero = getTableFormObjs(label_DecimalField27_GTZero)[0];
	if( parseInt(obj_DecimalField25_GTZero.value) < parseInt(obj_DecimalField27_GTZero.value)){
		errorObjs.push(obj_DecimalField27_GTZero);
	 	a+="业务连续性管理>=其他校验出错！\n";
	  	isValid=false;
	}

	var obj_DecimalField28_GTZero = getTableFormObjs(label_DecimalField28_GTZero)[0];
	var obj_DecimalField29_GTZero = getTableFormObjs(label_DecimalField29_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField29_GTZero.value)){
		errorObjs.push(obj_DecimalField29_GTZero);
	 	a+="审计>=CISA校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField30_GTZero = getTableFormObjs(label_DecimalField30_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField30_GTZero.value)){
		errorObjs.push(obj_DecimalField30_GTZero);
	 	a+="审计>=CIA校验出错！\n";
	  	isValid=false;
	}
	
	var obj_DecimalField31_GTZero = getTableFormObjs(label_DecimalField31_GTZero)[0];
	if( parseInt(obj_DecimalField28_GTZero.value) < parseInt(obj_DecimalField31_GTZero.value)){
		errorObjs.push(obj_DecimalField31_GTZero);
	 	a+="审计>=其他校验出错！\n";
	  	isValid=false;
	}
	
	var obj_YN08_02_GTZero = getTableFormObjs(label_YN08_02_GTZero)[0];
	var obj_YN08_03_GTZero = getTableFormObjs(label_YN08_03_GTZero)[0];
	if( parseInt(obj_YN08_02_GTZero.value) > parseInt(obj_YN08_03_GTZero.value)){
		errorObjs.push(obj_YN08_03_GTZero);
	 	a+="规划期起始日期<=规划期截至日期校验出错！\n";
	  	isValid=false;
	}
	
	if( parseFloat(obj_item88_GTZero.value) >( parseFloat(obj_item89_GTZero.value) + parseFloat(obj_item90_GTZero.value) + parseFloat(obj_item91_GTZero.value)
			+ parseFloat(obj_item92_GTZero.value) + parseFloat(obj_item93_GTZero.value) + parseFloat(obj_item1000_GTZero.value) 
				+ parseFloat(obj_item101_GTZero.value) )|| parseFloat(obj_item88_GTZero.value) < ( parseFloat(obj_item89_GTZero.value) 
					+ parseFloat(obj_item90_GTZero.value) + parseFloat(obj_item91_GTZero.value) + parseFloat(obj_item92_GTZero.value) 
						+ parseFloat(obj_item93_GTZero.value) + parseFloat(obj_item1000_GTZero.value) + parseFloat(obj_item101_GTZero.value))){
		errorObjs.push(obj_item88_GTZero);
	 	a+="本年度科技信息投入=基础设施建设投入+电子设备采购投入+软件采购投入+系统开发项目投入+系统运营投入+信息科技人力资源费用+其他校验出错！\n";
	  	isValid=false;
	}

	if(parseInt(obj_DecimalField1_GTZero.value) >( parseInt(obj_DecimalField2_GTZero.value) + parseInt(obj_DecimalField3_GTZero.value)
			+ parseInt(obj_DecimalField4_GTZero.value) + parseInt(obj_DecimalField5_GTZero.value) ) || parseInt(obj_DecimalField1_GTZero.value) 
				<(parseInt(obj_DecimalField2_GTZero.value) + parseInt(obj_DecimalField3_GTZero.value)
					+ parseInt(obj_DecimalField4_GTZero.value) + parseInt(obj_DecimalField5_GTZero.value))){
		errorObjs.push(obj_DecimalField1_GTZero);
	 	a+="信息安全管理= 其中，CISSP + CISM + BS7799-LA + 其他校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField6_GTZero.value) >( parseInt(obj_DecimalField7_GTZero.value) + parseInt(obj_DecimalField8_GTZero.value)
			+ parseInt(obj_DecimalField9_GTZero.value) )|| parseInt(obj_DecimalField6_GTZero.value) <( parseInt(obj_DecimalField7_GTZero.value)
					+ parseInt(obj_DecimalField8_GTZero.value) + parseInt(obj_DecimalField9_GTZero.value))){
		errorObjs.push(obj_DecimalField6_GTZero);
	 	a+="信息科技服务管理=其中，ITIL Service Manager + ITIL Practitioner + 其他 校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField10_GTZero.value) >( parseInt(obj_DecimalField11_GTZero.value) + parseInt(obj_DecimalField12_GTZero.value)
		 + parseInt(obj_DecimalField13_GTZero.value) + parseInt(obj_DecimalField14_GTZero.value) + parseInt(obj_DecimalField15_GTZero.value)
			 + parseInt(obj_DecimalField16_GTZero.value) )|| parseInt(obj_DecimalField10_GTZero.value) <( parseInt(obj_DecimalField11_GTZero.value) 
				+ parseInt(obj_DecimalField12_GTZero.value) + parseInt(obj_DecimalField13_GTZero.value) + parseInt(obj_DecimalField14_GTZero.value)
					+ parseInt(obj_DecimalField15_GTZero.value) + parseInt(obj_DecimalField16_GTZero.value) )){
		errorObjs.push(obj_DecimalField10_GTZero);
	 	a+="信息科技项目开发与管理= 其中，PMP + PRINCE2 + 系统架构师 + 系统分析师  + 信息系统项目管理师 + 其他 校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField17_GTZero.value) >( parseInt(obj_DecimalField18_GTZero.value) + parseInt(obj_DecimalField19_GTZero.value) )||
			parseInt(obj_DecimalField17_GTZero.value) <( parseInt(obj_DecimalField18_GTZero.value) + parseInt(obj_DecimalField19_GTZero.value))){
		errorObjs.push(obj_DecimalField17_GTZero);
	 	a+="信息科技项目开发与管理=  其中，CCIE + 其他 校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField20_GTZero.value) >( parseInt(obj_DecimalField21_GTZero.value) + parseInt(obj_DecimalField22_GTZero.value)
			+ parseInt(obj_DecimalField23_GTZero.value) + parseInt(obj_DecimalField24_GTZero.value) ) || parseInt(obj_DecimalField20_GTZero.value)
				<( parseInt(obj_DecimalField21_GTZero.value) + parseInt(obj_DecimalField22_GTZero.value) + parseInt(obj_DecimalField23_GTZero.value)
					+ parseInt(obj_DecimalField24_GTZero.value))){
		errorObjs.push(obj_DecimalField20_GTZero);
	 	a+="数据库管理= 其中，OCP + OCM + IBM Certified DBA + 其他 校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField25_GTZero.value) >( parseInt(obj_DecimalField26_GTZero.value) + parseInt(obj_DecimalField27_GTZero.value) )||
			parseInt(obj_DecimalField25_GTZero.value) <( parseInt(obj_DecimalField26_GTZero.value) +parseInt( obj_DecimalField27_GTZero.value) )){
		errorObjs.push(obj_DecimalField25_GTZero);
		a+="业务连续性管理= 其中，CBCP + 其他 校验出错！\n";
	  	isValid=false;
	}
	
	if(parseInt(obj_DecimalField28_GTZero.value) >( parseInt(obj_DecimalField29_GTZero.value) + parseInt(obj_DecimalField30_GTZero.value) 
			+ parseInt(obj_DecimalField31_GTZero.value) )|| parseInt(obj_DecimalField28_GTZero.value) <( parseInt(obj_DecimalField29_GTZero.value)
				+ parseInt(obj_DecimalField30_GTZero.value) + parseInt(obj_DecimalField31_GTZero.value) )){
		errorObjs.push(obj_DecimalField28_GTZero);
	 	a+="审计= 其中，CISA + CIA + 其他 校验出错！\n";
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
