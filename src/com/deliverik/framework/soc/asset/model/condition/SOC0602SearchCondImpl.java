/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * �豸�ʲ���Ϣ��������ʵ��
 * 
 */
public class SOC0602SearchCondImpl implements SOC0602SearchCond {

	/** �豸�ʲ�ID */
	protected Integer eiid;
	
	/** ����ID */
	protected Integer container_eiid;

	/** ����ID*/
	protected Integer room_eiid;
	
	/** �豸�ʲ���� */
	protected String eilabel;
	
	/** �豸�ʲ����� */
	protected String einame;
	
	/** �豸�ʲ��߶ȣ�U�� */
	protected String u_total;
	
	/** �Ƿ��Ѿ��ϼ� */
	protected String inJiguiFlg;
	
	/** �豸����� */
	protected String esyscoding;
	
	/** �Ƿ��ǻ����豸 */
	protected String inroomFlg;
	
	/** �豸״̬ */
	protected String[] eiStatuses;
	
	/** ��������  */	
	protected String cabinet;
	
	/**
	 * �豸�ʲ�IDȡ��
	 * @return �豸�ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �豸�ʲ�ID�趨
	 *
	 * @param eiid �豸�ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getContainer_eiid() {
		return container_eiid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param container_eiid ����ID
	 */
	public void setContainer_eiid(Integer container_eiid) {
		this.container_eiid = container_eiid;
	}
	
	/**
	 * �豸�ʲ����ȡ��
	 * @return �豸�ʲ����
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �豸�ʲ�����趨
	 *
	 * @param eilabel �豸�ʲ����
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �豸�ʲ�����ȡ��
	 * @return �豸�ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �豸�ʲ������趨
	 *
	 * @param einame �豸�ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �豸�ʲ��߶ȣ�U��ȡ��
	 * @return �豸�ʲ��߶ȣ�U��
	 */
	public String getU_total() {
		return u_total;
	}

	/**
	 * �豸�ʲ��߶ȣ�U���趨
	 *
	 * @param u_total �豸�ʲ��߶ȣ�U��
	 */
	public void setU_total(String u_total) {
		this.u_total = u_total;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}

	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	public String getInJiguiFlg() {
		return inJiguiFlg;
	}

	public void setInJiguiFlg(String inJiguiFlg) {
		this.inJiguiFlg = inJiguiFlg;
	}
	/**
	 * �Ƿ��ǻ����豸��־λȡ��
	 * @return �Ƿ��ǻ����豸��־λ
	 */
	public String getInroomFlg() {
		return inroomFlg;
	}
	
	/**
	 * �Ƿ��ǻ����豸��־λ�趨
	 *
	 * @param esyscoding �Ƿ��ǻ����豸��־λ
	 */
	public void setInroomFlg(String inroomFlg) {
		this.inroomFlg = inroomFlg;
	}

	/**
	 * @return �豸״̬
	 */
	public String[] getEiStatuses() {
		return eiStatuses;
	}

	/**
	 * @param �豸״̬
	 */
	public void setEiStatuses(String[] eiStatuses) {
		this.eiStatuses = eiStatuses;
	}

    /**
     * ����IDȡ��
     *
     * @return room_eiid ����ID
     */
    public Integer getRoom_eiid() {
        return room_eiid;
    }

    /**
     * ����ID�趨
     *
     * @param room_eiid ����ID
     */
    public void setRoom_eiid(Integer room_eiid) {
        this.room_eiid = room_eiid;
    }

	/**
	 * ��������ȡ��
	 * @return cabinet  ��������
	 */
	public String getCabinet() {
		return cabinet;
	}

	/**
	 * ���������趨
	 * @param cabinet  ��������
	 */
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}

}
