/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�ƣ�������ѯ���������ӿ�
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public interface CheckVWCond {
	/**
	 * syscodingȡ��
	 * @return syscoding syscoding
	 */
	public String getSyscoding();
	/**
	 * ��鷽��ȡ��
	 * @return checkMethod ��鷽��
	 */
	public String getCheckMethod();

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency();
}
