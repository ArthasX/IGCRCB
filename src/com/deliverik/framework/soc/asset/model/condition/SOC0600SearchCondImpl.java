/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 
 * �ʲ�������̲�ѯ�ӿ�ʵ��
 *
 */
public class SOC0600SearchCondImpl implements SOC0600SearchCond {
	
	/** �ʲ�id*/
	protected String eiid;
	
	/** �������ͼ���*/
	protected List<String> prpdid_in;
	
	/** ��������*/
	protected String prpdid_eq;

	/**
	 * �ʲ�id�趨
	 * @param eiid �ʲ�id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �������ͼ����趨
	 * @param prpdid_in �������ͼ���
	 */
	public void setPrpdid_in(List<String> prpdid_in) {
		this.prpdid_in = prpdid_in;
	}

	/**
	 * ���������趨
	 * @param prpdid_eq ��������
	 */
	public void setPrpdid_eq(String prpdid_eq) {
		this.prpdid_eq = prpdid_eq;
	}

	/**
	 * �ʲ�idȡ��
	 * @return eiid �ʲ�id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �������ͼ���ȡ��
	 * @return prpdid_in �������ͼ���
	 */
	public List<String> getPrpdid_in() {
		return prpdid_in;
	}

	/**
	 * ��������ȡ��
	 * @return prpdid_eq ��������
	 */
	public String getPrpdid_eq() {
		return prpdid_eq;
	}
}