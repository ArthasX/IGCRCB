/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ģ������ѯForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0401Form extends BaseForm{
	
	/** ����ID */
	protected Integer prid;

	/** �ʲ�һ��ģ�� */
	protected String subtype;
	
	/** ģ����Ϣ */
	protected String esyscoding;

	/**
	 * ����IDȡ��
	 * @return prid ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �ʲ�һ��ģ��ȡ��
	 * @return subtype �ʲ�һ��ģ��
	 */
	public String getSubtype() {
		return subtype;
	}

	/**
	 * �ʲ�һ��ģ���趨
	 * @param subtype �ʲ�һ��ģ��
	 */
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	/**
	 * ģ����Ϣȡ��
	 * @return esyscoding ģ����Ϣ
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * ģ����Ϣ�趨
	 * @param esyscoding ģ����Ϣ
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
}
