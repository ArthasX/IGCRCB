/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * @Description:֪ʶ����ʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeGrade extends BaseModel {
	/**
	 *����
	 */
	public Integer getKgid();

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
