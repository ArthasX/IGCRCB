/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���topͳ�Ʋ�ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ServiceTopFiveSearchCond {

	/**
	 * �¼����̶���IDȡ��
	 * @return ipdid �¼����̶���ID
	 */
	public String getIpdid();

	/**
	 * �����������̶���IDȡ��
	 * @return spdid �����������̶���ID
	 */
	public String getSpdid();

	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear();

	/**
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth();

	/**
	 * ͳ������ȡ��
	 * @return type ͳ������
	 */
	public String getType();
}
