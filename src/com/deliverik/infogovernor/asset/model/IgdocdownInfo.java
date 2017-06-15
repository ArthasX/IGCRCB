/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 下载记录表接口
  * 功能描述: 下载记录表接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface IgdocdownInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getDdid();

	/**
	 * 文档资产ID取得
	 *
	 * @return 文档资产ID
	 */
	public Integer getEiid();

	/**
	 * 下载人取得
	 *
	 * @return 下载人
	 */
	public String getUserid();

	/**
	 * 下载时间取得
	 *
	 * @return 下载时间
	 */
	public String getDowntime();

	/**
	 * 下载位置取得
	 *
	 * @return 下载位置
	 */
	public String getDownlocation();


	public void setEiid(Integer eiid);

	public void setUserid(String userid) ;


	public void setDowntime(String downtime);

	public void setDownlocation(String downlocation);

	public void setFingerprint(String fingerprint);
}