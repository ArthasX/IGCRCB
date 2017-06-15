/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
 * 概述: SOC0114VWTB_FX检索条件接口
 * 功能描述: FX: Fuxin检索条件接口
 * 创建记录: 2013-10-26
 * 修改记录: 
 */
public interface SOC0114VW_FXSearchCond {
	/**
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid();
	/**
	 * eiversiion取得
	 *
	 * @return eiversiion eiversiion
	 */
	public Integer getEiversion();
	/**
	 * eismallversion取得
	 *
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion();
	/**
	 * domainid取得
	 *
	 * @return domainid domainid
	 */
	public Integer getDomainid();
	/**
	 * domainversion取得
	 *
	 * @return domainversion domainversion
	 */
	public Integer getDomainversion();
	/**
	 * fingerprint取得
	 *
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint();
}