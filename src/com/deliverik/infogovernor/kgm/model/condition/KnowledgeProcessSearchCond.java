/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * ����: ֪ʶ���̹�����Ϣ���������ӿ�
 * ����������֪ʶ���̹�����Ϣ���������ӿ�
 * ������¼������ 2010/12/07
 * �޸ļ�¼��
 */
public interface KnowledgeProcessSearchCond {
	
	/**
	 * ֪ʶIDȡ��
	 * 
	 * @return ֪ʶID
	 */
	public Integer getKnid();
	
	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion();

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid();
	
	/**
	 * ���񹤵�IDȡ��
	 * 
	 * @return ���񹤵�ID
	 */
	public Integer getSfid();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getConnecttype();
	
	/**
	 * ��Ч��ʶλȡ��
	 * @return ��Ч��ʶλ
	 */
	public String getKpEffect();

}
