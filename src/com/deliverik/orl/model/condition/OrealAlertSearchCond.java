/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.condition;

/**
 * ����: ŷ���Ÿ澯����������ӿ�
 * ��������: ŷ���Ÿ澯����������ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealAlertSearchCond {
	/**
	 * �Ƿ��޸�(��ʶ)ȡ��
	 * @return fixed_eq �Ƿ��޸�(��ʶ)
	 */
	public String getFixed_eq();

	/**
	 * ƽ̨����ȡ��
	 * @return platform_name_like ƽ̨����
	 */
	public String getPlatform_name_like();
	/**
	 * ƽ̨����(in)ȡ��
	 * @return platform_name_in ƽ̨����(in)
	 */
	public String[] getPlatform_name_in();
}