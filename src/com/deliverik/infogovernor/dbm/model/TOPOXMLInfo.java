/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: TOPOXML�ӿ�
  * ��������: TOPOXML�ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface TOPOXMLInfo extends BaseModel {
	/**
	 * myidȡ��
	 *
	 * @return myid myid
	 */
	public String getMyid();


	/**
	 * aixsȡ��
	 *
	 * @return aixs aixs
	 */
	public String getAixs();
	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis();
	/**
	 * useridȡ��
	 *
	 * @return userid userid
	 */
	public String getUserid();
}