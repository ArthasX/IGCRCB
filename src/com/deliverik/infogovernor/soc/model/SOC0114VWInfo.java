/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.model;

/**
 * 概述: SOC0114VWInfo_FX
 * 功能描述: FX: Fuxin
 * 创建记录: 2013-10-26
 * 修改记录: 
 */
public interface SOC0114VWInfo {
	/**
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public Integer getEiid();
	/**
	 * einame取得
	 *
	 * @return einame einame
	 */
	public String getEiname();
	/**
	 * esyscoding取得
	 *
	 * @return esyscoding esyscoding
	 */
	public String getEsyscoding();
	/**
	 * eiversion取得
	 *
	 * @return eiversion eiversion
	 */
	public String getEiversion();
	/**
	 * eismallversion取得
	 *
	 * @return eismallversion eismallversion
	 */
	public String getEismallversion();
	/**
	 * linkid取得
	 *
	 * @return linkid linkid
	 */
	public Integer getLinkid();
	/**
	 * linkorder取得
	 *
	 * @return linkorder linkorder
	 */
	public String getLinkorder();
	/**
	 * hostIP取得
	 *
	 * @return hostIP hostIP
	 */
	public String getHostIP();
	/**
	 * hostEiid取得
	 *
	 * @return hostEiid hostEiid
	 */
	public Integer getHostEiid();
	
	public Integer getDomainid();
	
	public Integer getDomainversion();
	
	public Integer getHostVersion() ;
	
	public Integer getHostSmallVersion();
	
	public String getResourceid();
	
	public String getHostEsyscoding();
}
