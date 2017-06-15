/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

/**
 * 非现场监督报表常量
 * @author wangxing
 */
public class IGSMRDBMCONSTANT {
	
	/**
	 * 流程定义ID
	 */
	public static final String PDID_TQ1 = "2102001";
	public static final String PDID_TQ4 = "2000301";
	public static final String PDID_TQ2 = "2104001";
	
	public static final String PDID_TB1 = "1100001";
	public static final String PDID_TB3 = "1106001";
	public static final String PDID_TB6 = "1106301";
	public static final String PDID_TB10 = "1108001";
	public static final String PDID_TB12 = "1110001";
	
	
	public static final String PDID_TB4 = "1000301";
	
	
	
	/**
	 * 报表内部各层标题
	 */
	//TB1
	public static final String TB1_2 = "机构规模";	
	public static final String TB1_2_1 = "内容";	
	public static final String TB1_2_1_1 = "法人境内外资产总额";
	public static final String TB1_2_1_2 = "机构网点数量";
	
	public static final String TB1_6 = "重大项目情况";	
	public static final String TB1_6_1 = "内容";	
	public static final String TB1_6_1_1 = "本年度信息科技重大项目数";
	public static final String TB1_6_1_2 = "本年度新增立项的重大项目数";
	public static final String TB1_6_1_3 = "本年度完成的重大项目数";
	public static final String TB1_6_1_4 = "本年度延期的重大项目";
	public static final String TB1_6_1_5 = "本年度重大项目计划完成率";
	
	public static final String TB1_7 = "信息科技资金投入";	
	public static final String TB1_7_1 = "内容";	
	public static final String TB1_7_1_1 = "本年度信息科技投入";
	public static final String TB1_7_1_2 = "其中，基础设施建设投入";	
	public static final String TB1_7_1_3 = "电子设备采购投入";	
	public static final String TB1_7_1_4 = "软件采购投入";	
	public static final String TB1_7_1_5 = "系统开发项目投入";	
	public static final String TB1_7_1_6 = "系统运营投入";	
	public static final String TB1_7_1_7 = "信息科技咨询投入";	
	public static final String TB1_7_1_8 = "信息科技人力资源费用";	
	public static final String TB1_7_1_9 = "其他";		
	public static final String TB1_7_1_11 = "本年度信息科技投入占本年度总投入的比例";
	
	

	public static final String TB1_8 = "信息科技人力资源投入"; 
	public static final String TB1_8_1 = "内容";
	public static final String TB1_8_1_2 = "信息科技正式员工数"; 
	public static final String TB1_8_1_3 = "其中，信息科技需求管理正式员工数量"; 
	public static final String TB1_8_1_4 = "信息科技开发正式员工数量"; 
	public static final String TB1_8_1_5 = "信息科技测试正式员工数量"; 
	public static final String TB1_8_1_6 = "信息科技运行维护正式员工数量"; 
	public static final String TB1_8_1_7 = "专职信息安全岗位正式员工数量"; 

	
	public static final String TB1_10 = "信息科技风险管理"; 
	public static final String TB1_10_1 = "内容";
	public static final String TB1_10_1_7 = "专职信息科技风险管理人员数量";
	public static final String TB1_10_1_12 = "信息科技风险管理制度总数";
	
	public static final String TB1_11 = "内部审计"; 
	public static final String TB1_11_1 = "内容";
	public static final String TB1_11_1_6 = "信息科技专职内审人员数量";
	
	//TB3
	public static final String TB3_1 = "信息科技内外部审计情况表";
	public static final String TB3_1_10 = "审计发现数量";
	public static final String TB3_1_11 = "已整改数量";
	
	//TB6
	public static final String TB6_1 = "软件开发项目情况";
	public static final String TB6_1_1 = "内容";
	public static final String TB6_1_1_7 = "本年度软件开发项目工作量";
	//TB10
	public static final String TB10_1 = "重要信息系统基本情况"; 
	public static final String TB10_1_1 = "数量"; 
	public static final String TB10_1_1_1 = "项目内容"; 
	public static final String TB10_1_1_1_1 = "重要信息系统总数";
	
//	public static final String TB1_11 = "机构人员、关键岗位";	
//	public static final String TB1_11_1 = "内容";	
//	public static final String TB1_11_1_1 = "信息科技正式员工数";
//	
//	public static final String TB1_6 = "风险管理部门（组织）";	
//	public static final String TB1_6_1 = "内容";
//	public static final String TB1_6_1_1 = "信息科技风险专职人员";
//	
//	public static final String TB1_7 = "内审部门（岗位）";
//	public static final String TB1_7_1 = "内容";
//	public static final String TB1_7_1_1 = "信息科技内审人员";
	
//	public static final String TB7_1 = "数量";
//	public static final String TB7_1_1 = "数量（单位：个）";
//	
//	public static final String TB16_1 = "信息科技外包管理整体框架";
//	public static final String TB16_1_1 = "信息科技外包项目";
//	public static final String TB16_1_1_1 = "内容";
//	public static final String TB16_1_1_1_1 = "内容1";
//	
//	public static final String TB1_8 = "信息科技相关制度及标准";
//	public static final String TB1_8_1 = "内容";
//	public static final String TB1_8_1_1 = "信息科技管理制度总数";
//	
//	public static final String TB3_8 = "信息科技内外部审计情况表";
//	public static final String TB3_8_1 = "审计发现数量";
//	public static final String TB3_8_2 = "已整改数量";
//	
//	public static final String TB4_1 = "本年度项目情况";
//	public static final String TB4_1_1 = "内容";
//	public static final String TB4_1_1_1 = "本年度信息科技项目总数";
//	public static final String TB4_1_1_2 = "本年度新增立项项目";
//	public static final String TB4_1_1_2_1 = "其中";
//	public static final String TB4_1_1_2_1_1 = "重大项目";
//	public static final String TB4_1_1_2_1_2 = "一般项目";
//	public static final String TB4_1_1_3 = "本年度完成项目";
//	public static final String TB4_1_1_3_1 = "其中";
//	public static final String TB4_1_1_3_1_1 = "重大项目";
//	public static final String TB4_1_1_3_1_2 = "一般项目";
//	public static final String TB4_1_1_4 = "本年度软件开发项目工作量";
//	public static final String TB4_1_1_5 = "本年度延期项目";
//	public static final String TB4_1_1_5_1 = "其中";
//	public static final String TB4_1_1_5_1_1 = "重大项目";
//	public static final String TB4_1_1_5_1_2 = "一般项目";
	
	
	public static final String TQ4_1 = "主要电子交易笔数";
	public static final String TQ4_2 = "ATM";
	public static final String TQ4_2_1 = "ATM3";
	public static final String TQ4_2_2 = "ATM2";
	public static final String TQ4_3 = "POS";
	public static final String TQ4_3_1 = "POS3";
	public static final String TQ4_3_2 = "POS2";
	public static final String TQ4_4 = "数量";
	public static final String TQ4_5 = "同比增减(%)";
	public static final String TQ4_6 = "环比增减(%)";
	
	
	public static final String TQ2_2 = "本季度新增的重大项目";

}
