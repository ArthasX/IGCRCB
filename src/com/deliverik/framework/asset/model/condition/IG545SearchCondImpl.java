/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
 * �ʲ�ģ������ȡֵ��Χ��������ʵ��
 * 
 */
public class IG545SearchCondImpl implements IG545SearchCond {

	/**
	 * �ʲ�����ȡֵ��Χ��ʶ
	 */
	public String ccdcategory;
	
	/**
	 * �ʲ�����ȡֵ��Χ״̬��1���ã�0ͣ�ã�
	 */
	public String ccdstatus;

	/**
	 * �ʲ�����ȡֵ��Χ����Ӧ��
	 */
	public String ccdtype;

	
	/**
	 * �ʲ�����ȡֵ��Χ��ʶȡ��
	 * @return �ʲ�����ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory() {
		return ccdcategory;
	}

	/**
	 * �ʲ�����ȡֵ��Χ��ʶ�趨
	 *
	 * @param ccdcategory �ʲ�����ȡֵ��Χ��ʶ
	 */
	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	/**
	 * �ʲ�����ȡֵ��Χ״̬ȡ��
	 * @return �ʲ�����ȡֵ��Χ״̬
	 */
	public String getCcdstatus() {
		return ccdstatus;
	}

	/**
	 * �ʲ�����ȡֵ��Χ״̬�趨
	 *
	 * @param ccdstatus �ʲ�����ȡֵ��Χ״̬
	 */
	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	/**
	 * �ʲ�����ȡֵ��Χ����Ӧ��ȡ��
	 * @return �ʲ�����ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype() {
		return ccdtype;
	}

	/**
	 * �ʲ�����ȡֵ��Χ����Ӧ���趨
	 *
	 * @param ccdtype �ʲ�����ȡֵ��Χ����Ӧ��
	 */
	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

}
