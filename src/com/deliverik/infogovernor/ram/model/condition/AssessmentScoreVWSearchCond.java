/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.model.condition;

import java.util.List;

/**
  * ����: ������ʷ��ѯ���������ӿ�
  * ��������: ������ʷ��ѯ���������ӿ�
  * ������¼: 2013/10/10
  * �޸ļ�¼: 
  */
public interface AssessmentScoreVWSearchCond {
	
	/**pridȡ��*/
	public Integer getPrid();
	
	/**������Ȳ�ѯ����*/
	public String getCurrentyear() ;
	
	/**���ű���ʼʱ��*/
	public String getBegintime();
	
	/**���ű������ʱ�� */
	public String getEndtime();
	
	/** useridȡ�� */
	public String getUserid();
	
	/**
	 * ������������pdids listȡ��
	 */
	public List<String> getList();
	
	/**
	 * ����������������ͳ��ʹ��   topOrgidȡ��
	 */
	public String getTopOrgid();
}