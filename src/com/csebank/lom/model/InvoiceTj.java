/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */


package com.csebank.lom.model;

import java.math.BigDecimal;

/**
 * 
 *  发票管理统计实体接口
 * 
 * @author piaowei@deliverik.com
 * 
 */
public interface InvoiceTj  {
	/**
	 * 发票统计序号取得
	 * 
	 * @return 发票统计序号
	 */
	public String getNum();

	/**
	 * 统计发票比数取得
	 * 
	 * @return 发票比数
	 */
	public Integer getInvoicenum();
	
	/**
	 * 申请部门层次码取得
	 * 
	 * @return 申请部门层次码
	 */
	public String getIreqemp();
	
	/**
	 * 统计总金额取得
	 * 
	 * @return 统计总金额
	 */
	public BigDecimal getSumiamount();
	
	/**
	 * 统计未付款金额取得
	 * 
	 * @return 统计未付款金额
	 */
	public BigDecimal getUnsumiamounted();
	
	
	/**
	 * 统计已付款金额取得
	 * 
	 * @return 统计已付款金额
	 */
	public BigDecimal getSumiamounted();
	
	/** 资产项所属机构取得
	 * @return 资产项所属机构
	 * */
	public String getEiorgsyscoding();
	
	
	



}