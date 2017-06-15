/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: timer01���������ӿ�
  * ��������: timer01���������ӿ�
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
public interface Timer01SearchCond {

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
	public String getName();


	/**
	 * typeȡ��
	 *
	 * @return type
	 */
	public String getType();


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


	public List<String> getTypeNames_Notin();
	
	public List<String> getTypeNames_In();
	
	public List<Integer> getResourceid_Notin();
	
	public Integer getResourceid_eq();
}