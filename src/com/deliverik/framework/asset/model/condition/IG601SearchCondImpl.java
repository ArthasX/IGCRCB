package com.deliverik.framework.asset.model.condition;

/**
 * ������Ϣ��������ʵ��
 * 
 */
public class IG601SearchCondImpl implements IG601SearchCond {

	/** ����ID */
	protected Integer eiid;
	
	/** �������� */
	protected String relateroom;

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param eiid ����ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getRelateroom() {
		return relateroom;
	}

	public void setRelateroom(String relateroom) {
		this.relateroom = relateroom;
	}
}
