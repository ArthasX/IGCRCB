/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * ����: TOPOXML��������ʵ��
  * ��������: TOPOXML��������ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class TOPOXMLSearchCondImpl implements
		TOPOXMLSearchCond {
	/** �Ƿ�Ϊ����ͼ 0:��  1:��*/
	protected String isellipsis;
	
	protected String userid;

	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * isellipsis�趨
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}

	/**
	 * useridȡ��
	 *
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid�趨
	 *
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
}