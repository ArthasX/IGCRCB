/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.condition;

/**
 * ����: ŷ���Ÿ澯���������ʵ��
 * ��������: ŷ���Ÿ澯���������ʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public class OrealAlertSearchCondImpl implements OrealAlertSearchCond {
	/** �Ƿ��޸�(��ʶ) */
	protected String fixed_eq;
	
	/** ƽ̨���� */
	protected String platform_name_like;
	
	/** ƽ̨����(in) */
	protected String[] platform_name_in;
	
	/**
	 * Getter and Setter
	 */
	/**
	 * �Ƿ��޸�(��ʶ)ȡ��
	 * @return fixed_eq �Ƿ��޸�(��ʶ)
	 */
	public String getFixed_eq() {
		return fixed_eq;
	}
	/**
	 * �Ƿ��޸�(��ʶ)�趨
	 * @param fixed_eq
	 */
	public void setFixed_eq(String fixed_eq) {
		this.fixed_eq = fixed_eq;
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