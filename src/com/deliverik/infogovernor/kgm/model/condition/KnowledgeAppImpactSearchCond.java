/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����Cond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpactSearchCond {
	/**
	 *֪ʶID
	 */
	public Integer getKnid();

	/**
	 *ҵ��ϵͳCode
	 */
	public String getKaicode();

	/**
	 * ֪ʶ�汾
	 */
	public Integer getKnversion();

}
