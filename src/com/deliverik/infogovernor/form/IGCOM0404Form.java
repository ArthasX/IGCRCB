/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ���񹤵���ݷ�������Form
 * @Author masai
 * @History 
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class IGCOM0404Form extends BaseForm {

	/** ����ID�������� */
	protected Integer parprid;
	
	/** ��������ID */
	protected String prpdid;
	
	/** �������� */
	protected String prtype;
	
	/** �Ƿ�����ģ�壬1��0�� */
	protected String flag;
	
	/** ���̷���url */
	protected String url;
	
	/** ��������ID */
	protected String ptid;

	/**
	 * ����ID��������ȡ��
	 * 
	 * @return ����ID��������
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ����ID���������趨
	 * 
	 * @param prid ����ID��������
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * 
	 * @param prtype ����ID
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ��������IDȡ��
	 * 
	 * @return ��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ��������ID�趨
	 * 
	 * @param prpdid ��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * �Ƿ�����ģ��ȡ��
	 * 
	 * @return �Ƿ�����ģ��
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * �Ƿ�����ģ���趨
	 * 
	 * @param flag �Ƿ�����ģ��
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * ���̷���urlȡ��
	 * 
	 * @return ���̷���url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * ���̷���url�趨
	 * 
	 * @param url ���̷���url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPtid() {
		return ptid;
	}

	/**
	 * ��������ID�趨
	 * @param ptid ��������ID
	 */
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	
}
