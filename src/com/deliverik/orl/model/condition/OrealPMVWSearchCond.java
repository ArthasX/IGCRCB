/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.condition;

/**
 * ����: ŷ���ż��ָ����ͼ���������ӿ�
 * ��������: ŷ���ż��ָ����ͼ���������ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
  */
public interface OrealPMVWSearchCond {
	/**
	 * �Ƿ���(��ʶ)ȡ��
	 * @return enabled_eq �Ƿ���(��ʶ)
	 */
	public String getEnabled_eq();

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