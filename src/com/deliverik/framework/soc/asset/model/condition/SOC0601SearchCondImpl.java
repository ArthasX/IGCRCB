/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * ������Ϣ��������ʵ��
 * 
 */
public class SOC0601SearchCondImpl implements SOC0601SearchCond {

	/** ����ID */
	protected String eiid;
	
	/** �������� */
	protected String relateroom;

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getRelateroom() {
		return relateroom;
	}

	public void setRelateroom(String relateroom) {
		this.relateroom = relateroom;
	}
}
