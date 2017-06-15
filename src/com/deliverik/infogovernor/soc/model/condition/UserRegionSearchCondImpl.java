/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * 概述: UserRegion检索条件实现
  * 功能描述: UserRegion检索条件实现
  * 创建记录: 2014/01/10
  * 修改记录: 
  */
public class UserRegionSearchCondImpl implements
		UserRegionSearchCond {

	private String FLEXID;
	private String USERID;
	/**
	 * fLEXID取得
	 *
	 * @return fLEXID fLEXID
	 */
	public String getFLEXID() {
		return FLEXID;
	}
	/**
	 * uSERID取得
	 *
	 * @return uSERID uSERID
	 */
	public String getUSERID() {
		return USERID;
	}
	/**
	 * fLEXID设定
	 *
	 * @param fLEXID fLEXID
	 */
	public void setFLEXID(String fLEXID) {
		FLEXID = fLEXID;
	}
	/**
	 * uSERID设定
	 *
	 * @param uSERID uSERID
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
}