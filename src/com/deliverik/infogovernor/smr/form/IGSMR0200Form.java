/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ģ̬ҳForm
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGSMR0200Form extends BaseForm {
	
	/** URL */
	protected String url;
	
	/** ���̱��������� */
	protected String pidid;
	
	/** �������� */
	protected Integer prid;
	
	/** �������к� */
	protected String rownumber;

	/**
	 * URLȡ��
	 * 
	 * @return URL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * URL�趨
	 * 
	 * @param url URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * ���̱���������ȡ��
	 *
	 * @return pidid ���̱���������
	 */
	public String getPidid() {
		return pidid;
	}
	
	/**
	 * ���̱����������趨
	 *
	 * @param pidid ���̱���������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �������к�ȡ��
	 * @return rownumber �������к�
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * �������к��趨
	 * @param rownumber �������к�
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

}
