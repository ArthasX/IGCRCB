/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl;

import org.apache.commons.lang.time.FastDateFormat;

import com.csebank.common.TopOrgValueBean;
import com.deliverik.framework.utility.ResourceUtility;

/**
 * 
 * 接待管理常量
 *
 */
public class IGLOMCONSTANTS {
	
	public static final String LOM_GOODS_TYPE = "216";
	
	//------------------------------------接待工作使用状态-----------------------------------------------------
	
	/** 接待工作状态 进行中 */
	public static final String REC_STATUS_ENABLE = "1";
	/** 接待工作状态 结束 */
	public static final String REC_STATUS_DISABLE = "2";
	
	//------------------------------------预支方式-----------------------------------------------------
	
	/** 预支方式 现金 */
	public static final String ADVANCESCOST_TYPE_CASH = "1";
	/** 预支方式 现金支票 */
	public static final String ADVANCESCOST_TYPE_INVOICE = "2";
	
	//------------------------------------预支费用状态-----------------------------------------------------
	
	/** 预支费用状态 未冲抵 */
	public static final String ADVANCESCOST_STATUS_UNCREDIT = "0";
	/** 预支费用状态 已冲抵 */
	public static final String ADVANCESCOST_STATUS_CREDIT = "1";
	/** 预支费用状态 预支调整 */
	public static final String ADVANCESCOST_STATUS_ADJUST = "2";
	/** 预支费用状态 现金冲抵 */
	public static final String ADVANCESCOST_STATUS_CASH_CREDIT = "3";
	
	/** 时间 */
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
	
	//------------------------------------借还款状态-----------------------------------------------------
	/** 借还款状态 已确定 */
	public static final String LPD_STATUS_YIQUEREN= "0";
	/** 借还款状态 待审批 */
	public static final String LPD_STATUS_DAISHENPI = "1";
	/** 借还款状态 审批通过 */
	public static final String LPD_STATUS_YITONGGUO = "2";
	/** 借还款状态 审批未通过 */
	public static final String LPD_STATUS_WEITONGGUO = "3";
	/** 借还款状态 已还款 */
	public static final String LPD_STATUS_YIHUANKUAN= "4";
	/** 借还款状态 已冲抵 */
	public static final String LPD_STATUS_CREDIT = "5";
	/** 借还款状态 查询时用 非基础数据 */
	public static final String LPD_STATUS_YIQUEREN_YIHUANKUAN = "6";
	
	//------------------------------------借还款区分-----------------------------------------------------
	
	/** 借款 */
	public static final String LPD_TYPE_LOAN = "0";
	
	/** 现金还款 */
	public static final String LPD_TYPE_PAY = "1";
	
	/** 发票还款 */
	public static final String LPD_TYPE_PAY_INVOICE = "2";
	
	//------------------------------------物品信息状态-----------------------------------------------------

	/** 物品信息状态 可用 */
	public static final String GOODS_STATUS_ENABLE = "1";
	/** 物品信息状态 停用 */
	public static final String GOODS_STATUS_DISABLE = "0";
	
	
	//------------------------------------物品领用-----------------------------------------------------
	
	/**
	 * 默认顶级机构
	 */
	public static final String DEFAULT_ORGSYSCODING = TopOrgValueBean.getTopOrg();
	
	/** 食堂机构层次码 */
	public static final String ST_ORGSYSCODING = "STORG";
	
	/** 食堂机构名称 */
	public static final String ST_ORGNAME = "食堂";
	
	/** 可被食堂入库的物品种类编码 */
	public static final String ST_SEARCH_TYPE = "216004";
	/** 礼品类物品种类编码 */
	public static final String  PRESENT_CODE = "216002";
	
	//////////////////////////////////////入出库明细表
	
	/** 入出库类型 入库 */
	public static final String GIODTYPE_RK = "0";
	
	/** 入出库类型 领用 */
	public static final String GIODTYPE_LY = "1";
	
	/** 入出库类型 调剂 */
	public static final String GIODTYPE_TJ = "2";
	
	/** 入出库类型 核销 */
	public static final String GIODTYPE_HX = "3";

	/** 入出库状态 库存无 */
	public static final String GIODSTATUS_KCW = "0";
	
	/** 入出库状态 库存有 */
	public static final String GIODSTATUS_KCY = "1";
	
	/** 入出库状态 出库完成 */
	public static final String GIODSTATUS_CKWC = "0";
	
	/** 入出库状态 待审批 */
	public static final String GIODSTATUS_DSP = "1";

	/** 入出库状态 审批未通过 */
	public static final String GIODSTATUS_SPWTG = "2";
	

	//////////////////////////////////////出库表
	
	/** 出库类型 领用 */
	public static final String GOTYPE_LY = "1";

	/** 出库类型 调剂 */
	public static final String GOTYPE_TJ = "2";
	
	/** 出库状态 出库完成 */
	public static final String GOSTATUS_CKWC = "0";
	
	/** 出库状态 待审批 */
	public static final String GOSTATUS_DSP = "1";

	/** 出库状态 审批未通过 */
	public static final String GOSTATUS_SPWTG = "2";
	
	//////////////////////////////////////库存预警
	/** 预警类型 已预警查询 */
	public static final String WARN_TYPE_YYJ = "1";
	
	/** 预警类型 临界预警查询 */
	public static final String WARN_TYPE_LJYJ = "2";
	
	
	/** 常熟后勤管理_物品_每月盘点功能是否启用（1启用 0停用） */
	public static final String INVENTORY_STATUS = ResourceUtility.getString("INVENTORY_STATUS");;
	
	//------------------------------------发票-----------------------------------------------------
	/** 发票状态 */
	public static final String INVOICE_TYPE_UNPLAY = "0";
}
