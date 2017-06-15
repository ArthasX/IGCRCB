/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
 * 概述: SOC0114VWTB_FX检索条件实现
 * 功能描述: FX: Fuxin检索条件实现
 * 创建记录: 2013-10-26
 * 修改记录: 
 */
public class SOC0114VW_FXSearchCondImpl implements SOC0114VW_FXSearchCond {
	protected Integer eiid;
	protected Integer eiversion;
	protected Integer eismallversion;
	protected Integer domainid;
	protected Integer domainversion;
	protected String fingerprint;
	/**
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * eiversiion取得
	 *
	 * @return eiversiion eiversiion
	 */
	public Integer getEiversion() {
		return eiversion;
	}
	/**
	 * eismallversion取得
	 *
	 * @return eismallversion eismallversion
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	/**
	 * domainid取得
	 *
	 * @return domainid domainid
	 */
	public Integer getDomainid() {
		return domainid;
	}
	/**
	 * domainversion取得
	 *
	 * @return domainversion domainversion
	 */
	public Integer getDomainversion() {
		return domainversion;
	}
	/**
	 * fingerprint取得
	 *
	 * @return fingerprint fingerprint
	 */
	public String getFingerprint() {
		return fingerprint;
	}
	/**
	 * eiid设定
	 *
	 * @param eiid eiid
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * eiversiion设定
	 *
	 * @param eiversiion eiversiion
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	/**
	 * eismallversion设定
	 *
	 * @param eismallversion eismallversion
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
	/**
	 * domainid设定
	 *
	 * @param domainid domainid
	 */
	public void setDomainid(Integer domainid) {
		this.domainid = domainid;
	}
	/**
	 * domainversion设定
	 *
	 * @param domainversion domainversion
	 */
	public void setDomainversion(Integer domainversion) {
		this.domainversion = domainversion;
	}
	/**
	 * fingerprint设定
	 *
	 * @param fingerprint fingerprint
	 */
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	
}