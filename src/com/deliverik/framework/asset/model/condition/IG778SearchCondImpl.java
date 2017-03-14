package com.deliverik.framework.asset.model.condition;

/**
 * ������Ϣ��������ʵ��
 * 
 */
public class IG778SearchCondImpl implements IG778SearchCond {

	/** ����ID */
	protected Integer eiid;
	
	/** ����ID */
	protected Integer room_eiid;
	
	/** ������ */
	protected String eilabel;
	
	/** �������� */
	protected String einame;
	
	/** ����� */
	protected String u_total;
	
	/** �����Ƿ����ϼ� */
	protected String graphstatus;
	
	/** ������λ�� */
	protected String u_value;
	
	/** �ʲ����ͣ��յ�����������ʽ��ʽ�� */
	protected String eitype;
	
	/** �������� */
	protected String containertype;
	
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

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getRoom_eiid() {
		return room_eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param string ����ID
	 */
	public void setRoom_eiid(Integer string) {
		this.room_eiid = string;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �������趨
	 *
	 * @param eilabel ������
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 *
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ����߶ȣ�U��ȡ��
	 * @return ����߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * ����߶ȣ�U���趨
	 *
	 * @param u_total ����߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}
	/**
	 * �����Ƿ����ϼ�
	 * @return �����Ƿ����ϼ�
	 */
	public String getGraphstatus() {
		return graphstatus;
	}
	
	/**
	 * �����Ƿ����ϼ��趨
	 *
	 * @param �����Ƿ����ϼ�
	 */
	public void setGraphstatus(String graphstatus) {
		this.graphstatus = graphstatus;
	}
	
	/**
	 * ������λ��ȡ��
	 * 
	 * @return ������λ��
	 */
	public String getU_value() {
		return u_value;
	}

	/**
	 * ������λ���趨
	 * 
	 * @param standard ������λ��
	 */
	public void setU_value(String u_value) {
		this.u_value = u_value;
	}

	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ��ȡ��
	 * 
	 * @return �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public String getEitype() {
		return eitype;
	}

	/**
	 * �ʲ����ͣ��յ�����������ʽ��ʽ���趨
	 * 
	 * @param standard �ʲ����ͣ��յ�����������ʽ��ʽ��
	 */
	public void setEitype(String eitype) {
		this.eitype = eitype;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getContainertype() {
		return containertype;
	}

	/**
	 * ���������趨
	 * 
	 * @param standard ��������
	 */
	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}
}
