/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * ����: UserRegion��������ʵ��
  * ��������: UserRegion��������ʵ��
  * ������¼: 2014/01/10
  * �޸ļ�¼: 
  */
public class UserRegionSearchCondImpl implements
		UserRegionSearchCond {

	private String FLEXID;
	private String USERID;
	/**
	 * fLEXIDȡ��
	 *
	 * @return fLEXID fLEXID
	 */
	public String getFLEXID() {
		return FLEXID;
	}
	/**
	 * uSERIDȡ��
	 *
	 * @return uSERID uSERID
	 */
	public String getUSERID() {
		return USERID;
	}
	/**
	 * fLEXID�趨
	 *
	 * @param fLEXID fLEXID
	 */
	public void setFLEXID(String fLEXID) {
		FLEXID = fLEXID;
	}
	/**
	 * uSERID�趨
	 *
	 * @param uSERID uSERID
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	
}