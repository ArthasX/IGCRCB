/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: Ԥ������Form
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGSYM1406Form extends BaseForm {
	
	/** URL */
	protected String url;
	
	/** �����ļ���  */
	protected String rfdfilename;
	
	/** ����汾�� */
	protected Integer rfdversion;
	
	/** ����汾�� */
	protected String title;

	/** ���� */
	protected Integer rfdid;
	
	
	
	/**
	 * @return the rfdid
	 */
	public Integer getRfdid() {
		return rfdid;
	}

	/**
	 * @param rfdid the rfdid to set
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

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
	 * �����ļ���ȡ��
	 * @return �����ļ���
	 */
	public String getRfdfilename() {
		return rfdfilename;
	}

	/**
	 * �����ļ����趨
	 * @param rfdfilename �����ļ���
	 */
	public void setRfdfilename(String rfdfilename) {
		this.rfdfilename = rfdfilename;
	}
	
	/**
	 * ����Ǽ�ʱ��ȡ��
	 * @return ����Ǽ�ʱ��
	 */
	public Integer getRfdversion() {
		return rfdversion;
	}

	/**
	 * ����Ǽ�ʱ���趨
	 * @param rfdversion ����Ǽ�ʱ��
	 */
	public void setRfdversion(Integer rfdversion) {
		this.rfdversion = rfdversion;
	}
	
}
