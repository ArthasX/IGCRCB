/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 下载记录表检索条件接口
  * 功能描述: 下载记录表检索条件接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface IgdocdownSearchCond {
	
	public Integer getEiid();
	
	public void setEiid(Integer eiid);

	public String getUserid();

	public void setUserid(String userid);

	public String getDowntime();

	public void setDowntime(String downtime);

	public String getDownlocation();

	public void setDownlocation(String downlocation);

	public String getFingerprint();

	public void setFingerprint(String fingerprint);
}