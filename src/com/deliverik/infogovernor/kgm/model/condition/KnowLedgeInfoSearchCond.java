/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:֪ʶ���ѯ��Cond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowLedgeInfoSearchCond {
	/**
	 *֪ʶ�����
	 */
	public String getKnclass();

	/**
	 *�ؼ���
	 */
	public String getKnkey();

	/**
	 *֪ʶ����
	 */
	public String getKntitle();

	/**
	 *�¼�
	 */
	public String getKnapprovetime();

	/**
	 *������
	 */
	public Integer getGrade();

	/**
	 *������
	 */
	public String getKndealno();

	/**
	 *������
	 */
	public String getKnerrno();

}
