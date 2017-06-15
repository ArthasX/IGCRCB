/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���top5ͳ��ʵ��ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ServiceTopFiveVWInfo {

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId();

	/**
	 * ʱ������ȡ��
	 * @return icount ʱ������
	 */
	public Integer getIcount();

	/**
	 * ��������ȡ��
	 * @return scount ��������
	 */
	public Integer getScount();

	/**
	 * ���񹤵�����ȡ��
	 * @return fcount ���񹤵�����
	 */
	public Integer getFcount();

	/**
	 * ������ȡ��
	 * @return orgid ������
	 */
	public String getOrgid();

	/**
	 * ��������ȡ��
	 * @return orgname ��������
	 */
	public String getOrgname();

	/**
	 * ����ȡ��
	 * @return totalCount ����
	 */
	public Integer getTotalCount();
}
