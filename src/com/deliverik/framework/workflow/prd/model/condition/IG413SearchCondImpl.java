package com.deliverik.framework.workflow.prd.model.condition;


/**
 * �����¼�������Ϣ��������ʵ��
 * 
 */
public class IG413SearchCondImpl implements IG413SearchCond {
	
	/** ���̶���ID */
	protected String pdid;

	/** ״̬ID */
	protected String psdid;

	/** �¼����� */
	protected String pedtype;
	
	/** ���� */
	protected String pedid_like;
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * 
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ״̬IDȡ��
	 * 
	 * @return ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 * 
	 * @param psdid״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �¼�����ȡ��
	 * 
	 * @return �¼�����
	 */
	public String getPedtype() {
		return pedtype;
	}

	/**
	 * �¼������趨
	 * 
	 * @param pedtype�¼�����
	 */
	public void setPedtype(String pedtype) {
		this.pedtype = pedtype;
	}

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getPedid_like() {
		return pedid_like;
	}

	/**
	 * �����趨
	 * 
	 * @param pedid_like ����
	 */
	public void setPedid_like(String pedid_like) {
		this.pedid_like = pedid_like;
	}
	
}
