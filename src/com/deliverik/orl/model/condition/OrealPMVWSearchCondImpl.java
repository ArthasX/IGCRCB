/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.condition;

/**
 * ����: ŷ���ż��ָ����ͼ��������ʵ��
 * ��������: ŷ���ż��ָ����ͼ��������ʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public class OrealPMVWSearchCondImpl implements OrealPMVWSearchCond {
	/** �Ƿ���(��ʶ) */
	protected String enabled_eq;
	
	/** ƽ̨���� */
	protected String platform_name_like;
	
	/** ƽ̨����(in) */
	protected String[] platform_name_in;
	
	/**
	 * Getter and Setter
	 */
	/**
	 * �Ƿ���(��ʶ)ȡ��
	 * @return enabled_eq �Ƿ���(��ʶ)
	 */
	public String getEnabled_eq() {
		return enabled_eq;
	}
	/**
	 * �Ƿ���(��ʶ)�趨
	 * @param enabled_eq
	 */
	public void setEnabled_eq(String enabled_eq) {
		this.enabled_eq = enabled_eq;
	}

	/**
	 * ƽ̨����ȡ��
	 * @return platform_name_like ƽ̨����
	 */
	public String getPlatform_name_like() {
		return platform_name_like;
	}
	/**
	 * ƽ̨�����趨
	 * @param platform_name_like
	 */
	public void setPlatform_name_like(String platform_name_like) {
		this.platform_name_like = platform_name_like;
	}

	/**
	 * ƽ̨����(in)ȡ��
	 * @return platform_name_in ƽ̨����(in)
	 */
	public String[] getPlatform_name_in() {
		return platform_name_in;
	}
	/**
	 * ƽ̨����(in)�趨
	 * @param platform_name_in
	 */
	public void setPlatform_name_in(String[] platform_name_in) {
		this.platform_name_in = platform_name_in;
	}
}