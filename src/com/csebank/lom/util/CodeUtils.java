package com.csebank.lom.util;

import org.apache.commons.lang.time.FastDateFormat;

import com.deliverik.framework.utility.ResourceUtility;

public final class CodeUtils {
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");
	
	/** 接待人数规模 */
	public static final String RECPTION_RSCALE = "9";	
	/** 接待接待标准 */
	public static final String RECPTION_RSTANDARD = "10";
	/** 接待工作状态 */
	public static final String RECPTION_STATUS = "11";
	/** 预支方式 */
	public static final String ADVANCESCOST_ACTYPE = "12";	
	/** 住宿标准 */
	public static final String LODGE_STANDARD = "30";
	
	/**消耗类型*/
	public static final String GOUT_CONSUME="31";
	
	
	/** 早餐卡单价 */
	public static final String EWLBREAKFASTCARDPRICE = ResourceUtility.getString("EWLBREAKFASTCARDPRICE");	
	/** 午餐卡单价 */
	public static final String EWLLUNCHCARDPRICE = ResourceUtility.getString("EWLLUNCHCARDPRICE");
	/** 晚餐卡单价 */
	public static final String EWLSUPPERPRICE = ResourceUtility.getString("EWLSUPPERPRICE");
	/** 1类券单价 */
	public static final String EWLONETICKETPRICE = ResourceUtility.getString("EWLONETICKETPRICE");
	/** 2类券单价 */
	public static final String EWLTWOTICKETPRICE = ResourceUtility.getString("EWLTWOTICKETPRICE");
	/** 3类券单价 */
	public static final String EWLTHREETICKETPRICE = ResourceUtility.getString("EWLTHREETICKETPRICE");
	
	/** 入出库类型 入库*/
	public static final String GIODTYPE_INSTOCK = "0";
	/** 入出库状态 入库*/
	public static final String GIODSTATUS_INSTOCK = "0";
	/** 出库状态 核销*/
	public static final String GOUTSTOCK_DESTROY = "3";
	/** 出库状态 待审批*/
	public static final String GOUTSTOCK_DSP = "1";
	/** 出库状态 出库完成*/
	public static final String GOUTSTOCK_CKWC = "0";
	/** 出库状态 审批未通过*/
	public static final String GOUTSTOCK_SPWTG = "2";
	/** 付款方式 */
	public static final String INVOICE_IPAYMENTTYPE = "19";
	/** 状态 */
	public static final String INVOICE_ISTATUS = "20";
	/** 发票类型 */
	public static final String INVOICE_ITYPE = "21";
	/** 预支费用状态 */
	public static final String ADVANCESCOST_ACSTATUS = "22";	
	/** 还款方式 */
	public static final String LOANPAYDETAIL_LPDTYPE = "23";
	/** 借还款状态 */
	public static final String LOANPAYDETAIL_LPDSTATUS = "28";
	/** 交易类型 */
	public static final String ADVANCEDETAIL_TYPE = "29";
	
	/****************************************食堂餐卡*************************************************/
	
	/** 餐卡种类 */
	public static final String CARD_CATEGORY = "35";
	
	/****************************************物品领用*************************************************/
	
	/** 物品种类 */
	public static final String GOODS_CATEGORY = "24";
	/** 物品状态 */
	public static final String GOODS_STATUS = "25";
	/** 出库状态 */
	public static final String OUTSTOCK_STATUS = "26";
	/** 出库方式 */
	public static final String OUTSTOCK_TYPE = "32";
	
	/** 入出库类型 */
	public static final String INOUTSTOCK_TYPE = "27";	
	/** 预警类型 */
	public static final String GSTOCK_WARNING_TYPE = "28";	
	
}