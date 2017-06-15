/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������̷���Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0306Form extends BaseForm{

	/** ������ID */
	protected Integer parprid;
	
	/** ��������ID */
	protected String prpdid;
	
	/** �������� */
	protected String prtype;
	
	/** ���̷���url */
	protected String url;
	
	/** ��������ID */
	protected String ptid;

	/** ���̷����������� */
    protected String parameters;

	/**
	 * ������IDȡ��
	 * @return parprid ������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ������ID�趨
	 * @param parprid ������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * ��������IDȡ��
	 * @return prpdid ��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ��������ID�趨
	 * @param prpdid ��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ��������ȡ��
	 * @return prtype ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���̷���urlȡ��
	 * @return url ���̷���url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * ���̷���url�趨
	 * @param url ���̷���url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ��������IDȡ��
	 * @return ptid ��������ID
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

	/**
	 * ���̷�����������ȡ��
	 * @return parameters ���̷�����������
	 */
	public String getParameters() {
		return parameters;
	}

	/**
	 * ���̷������������趨
	 * @param parameters ���̷�����������
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
}
