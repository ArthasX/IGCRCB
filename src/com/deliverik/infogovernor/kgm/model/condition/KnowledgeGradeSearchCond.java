/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶ����Cond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGradeSearchCond {
	/**
	 *֪ʶ��key
	 */
	public Integer getKnid();

	/**
	 *����
	 */
	public Integer getKggrade();

	/**
	 *֪ʶ������
	 */
	public String getKgappraise();

	/**
	 *������
	 */
	public String getKguserid();

	/**
	 *����ʱ��
	 */
	public String getKgtime();

}
