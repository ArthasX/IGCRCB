/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model;

/**
 * 概述: 
 * 功能描述：
 * 创建人：王廷志
 * 创建记录： 2012-5-25
 * 修改记录：
 */
public interface InvestContractInfoVW {
	/**
	 * 项目ID取得
	 * @return pid 项目ID
	 */
	public Integer getPid();
	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname();
	/**
	 * 项目编号取得
	 * @return pcode 项目编号
	 */
	public String getPcode() ;
	/**
	 * 预算编号取得
	 * @return pstorecode 预算编号
	 */
	public String getPstorecode() ;
	/**
	 * 预算名称取得
	 * @return btitle 预算名称
	 */
	public String getBtitle() ;
	/**
	 * 软硬件取得
	 * @return pcut 软硬件
	 */
	public String getPcut();
	/**
	 * 合同编号取得
	 * @return plcnumber 合同编号
	 */
	public String getPlcnumber() ;
	/**
	 * 合同金额取得
	 * @return plcsum 合同金额
	 */
	public Double getPlcsum() ;
	/**
	 * 已付款取得
	 * @return plbplcsum 已付款
	 */
	public Double getPlbsum() ;
	/**
	 * 余额取得
	 * @return subnum 余额
	 */
	public Double getSubnum() ;
	/**
	 * 合同期数取得
	 * @return lcount 合同期数
	 */
	public Integer getLcount() ;
	/**
	 * 付款期数取得
	 * @return bcount 付款期数
	 */
	public Integer getBcount();
	/**
	 * 经办人取得
	 * @return username 经办人
	 */
	public String getUsername();
}
