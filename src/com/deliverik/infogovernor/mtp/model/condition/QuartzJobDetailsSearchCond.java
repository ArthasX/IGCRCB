package com.deliverik.infogovernor.mtp.model.condition;


/**
 * <p>
 * �ճ���ά�ƻ���Ϣ��������
 * </p>
 */
public interface QuartzJobDetailsSearchCond {
	/**
	 * ��ȡ��ά��������
	 * @return ����
	 */
	public Integer getQjid();

	/**
	 * ��ȡִ��ʱ��
	 * @return ִ��ʱ��
	 */
	public String getQjdtime();

	/**
	 * ��ȡ���ڼ�
	 * @return ���ڼ�
	 */
	public String getQjdweek();

	/**
	 * ��ȡִ��״̬
	 * @return ִ��״̬
	 */
	public String getQjdtype();
	
	/**
	 * ��ȡ����������
	 * @return ����������
	 */
	public String getQjdtriname();
}
