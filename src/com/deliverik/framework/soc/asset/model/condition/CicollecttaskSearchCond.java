/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
  * ����: cicollecttask���������ӿ�
  * ��������: cicollecttask���������ӿ�
  * ������¼: 2013/07/05
  * �޸ļ�¼: 
  */
public interface CicollecttaskSearchCond {
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
	
	/**
	 * typeidȡ��
	 * @return
	 */
	public Integer getTypeid();
	
	/**
	 * typeNamesȡ��
	 * @return
	 */
	public List<String> getTypeNames();
	
	public String getCollectType();
	
	public List<Integer> getTypeIds();
	
}