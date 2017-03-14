/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: timer01�ӿ�
  * ��������: timer01�ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer01Info extends BaseModel {

	/**
	 * uuidȡ��
	 *
	 * @return uuid
	 */
	public String getUuid();

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getTypename();


	/**
	 * strartruleȡ��
	 *
	 * @return strartrule
	 */
	public String getStartrule();

	/**
	 * stopruleȡ��
	 *
	 * @return stoprule
	 */
	public String getStoprule();

	/**
	 * starttimeȡ��
	 *
	 * @return starttime
	 */
	public String getStarttime();

	/**
	 * stoptimeȡ��
	 *
	 * @return stoptime
	 */
	public String getStoptime();

	/**
	 * newstarttimeȡ��
	 *
	 * @return newstarttime
	 */
	public String getNewstarttime();

	/**
	 * newstoptimeȡ��
	 *
	 * @return newstoptime
	 */
	public String getNewstoptime();

	/**
	 * executstatusȡ��
	 *
	 * @return executstatus
	 */
	public String getExecutstatus();

	/**
	 * periodtypeȡ��
	 *
	 * @return periodtype
	 */
	public String getPeriodtype();
	
	public String getCollecttype();
	
	public String getName();
	
	public Integer getResourceid();

}