/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * ������Ϣ��������ʵ��
 * 
 */
public class SOC0603SearchCondImpl implements SOC0603SearchCond {

	/** ����ID */
	protected Integer eiid;
	
	/** ����ID */
	protected Integer room_eiid;
	
	/** ������ */
	protected String eilabel;

	/** ������ */
	protected String eilabel_like;
	
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

	/** ʣ��U�� */
	protected String u_last;

	/** ʣ�ฺ��*/
	protected String load_last;

	/** ʣ�����*/
	protected String power_last;
	
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
	 * @param room_eiid ����ID
	 */
	public void setRoom_eiid(Integer room_eiid) {
		this.room_eiid = room_eiid;
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

    /**
     * ʣ��U��ȡ��
     *
     * @return u_last ʣ��U��
     */
    public String getU_last() {
        return u_last;
    }

    /**
     * ʣ�ฺ��ȡ��
     *
     * @return load_last ʣ�ฺ��
     */
    public String getLoad_last() {
        return load_last;
    }

    /**
     * ʣ�����ȡ��
     *
     * @return power_last ʣ�����
     */
    public String getPower_last() {
        return power_last;
    }

    /**
     * ʣ��U���趨
     *
     * @param u_last ʣ��U��
     */
    public void setU_last(String u_last) {
        this.u_last = u_last;
    }

    /**
     * ʣ�ฺ���趨
     *
     * @param load_last ʣ�ฺ��
     */
    public void setLoad_last(String load_last) {
        this.load_last = load_last;
    }

    /**
     * ʣ������趨
     *
     * @param power_last ʣ�����
     */
    public void setPower_last(String power_last) {
        this.power_last = power_last;
    }

    /**
     * ������ȡ��
     *
     * @return eilabel_like ������
     */
    public String getEilabel_like() {
        return eilabel_like;
    }

    /**
     * �������趨
     *
     * @param eilabel_like ������
     */
    public void setEilabel_like(String eilabel_like) {
        this.eilabel_like = eilabel_like;
    }
}
