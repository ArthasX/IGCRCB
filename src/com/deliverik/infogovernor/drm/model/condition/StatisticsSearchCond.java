/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: Ӧ������ģ��-ͳ�Ʒ�����ѯ�����ӿ�
  * ��������: Ӧ������ģ��-ͳ�Ʒ�����ѯ�����ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface StatisticsSearchCond {

	/**Ԥ���Ǽ�ʱ�俪ʼ*/
	public String getEiinstimeFrom();
	/**Ԥ���Ǽ�ʱ�����*/
	public String getEiinstimeTo();
	/**����ͳ��ʱ��������ʼ*/
	public String 	getDrillTimeFrom();
	/**����ͳ��ʱ��������ֹ*/
	public String 	getDrillTimeTo();
	/**
	 * @return the ר��Ԥ������
	 */
	public String getEiname();
	/**
	 * @return the �ʲ���
	 */
	public String getEsyscoding();
	
}