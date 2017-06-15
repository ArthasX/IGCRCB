/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG933TB;

/**
 * ����: ֪ʶ���̹�����Ϣ�ӿ�
 * ����������֪ʶ���̹�����Ϣ�ӿ�
 * ������¼������    2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeProcess extends BaseModel {
	
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKpid();

	/**
	 * ֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();
	
	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getSfid();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getConnecttype();
	
	/**
	 * �Ƿ���Ч��ʶȡ��
	 * 
	 * @return �Ƿ���Ч��ʶ
	 */
	public String getKpEffect();
	
	/**
	 * ֪ʶ��Ϣȡ��
	 * @return ֪ʶ��Ϣ
	 */
	public Knowledge getKnowledge();

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IG500Info getProcessRecord();

	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion();
	
	/**
	 * ���񹤵�ȡ��
	 * @return ���񹤵�
	 */
	public IG933TB getServiceForm(); 
}
