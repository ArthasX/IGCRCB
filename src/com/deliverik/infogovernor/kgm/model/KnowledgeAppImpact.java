/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

/**
 * 
 * @Description:֪ʶҵ��ϵͳ����ʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeAppImpact {
	/**
	 *����ID
	 */
	public Integer getKaiid();

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
