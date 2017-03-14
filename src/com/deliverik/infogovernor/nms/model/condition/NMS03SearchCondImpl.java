/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ���ѯ����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS03SearchCondImpl implements NMS03SearchCond{
	
	/** ��ID */
	protected Integer gid;
	
	/** �������� */
	protected String type;
	
	/** ��ʼIP */
	protected String fromIP;
	
	/** ����IP */
	protected String toIP;
	
	/** ���� */
	protected String subNet;
	
	/** ɾ����ʶ */
	protected String deleteflag;
	
	/** �汾 */
	protected Integer version;
	
	/**
	 * ��IDȡ��
	 * @return ��ID
	 */
	public Integer getGid() {
		return gid;
	}

	/**
	 * ��ID�趨
	 * @param gid ��ID
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getType() {
		return type;
	}

	/**
	 * ���������趨
	 * @param type ��������
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ��ʼIPȡ��
	 * @return ��ʼIP
	 */
	public String getFromIP() {
		return fromIP;
	}

	/**
	 * ��ʼIP�趨
	 * @param fromIP ��ʼIP
	 */
	public void setFromIP(String fromIP) {
		this.fromIP = fromIP;
	}

	/**
	 * ����IPȡ��
	 * @return ����IP
	 */
	public String getToIP() {
		return toIP;
	}

	/**
	 * ����IP�趨
	 * @param toIP ����IP
	 */
	public void setToIP(String toIP) {
		this.toIP = toIP;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getSubNet() {
		return subNet;
	}

	/**
	 * �����趨
	 * @param subNet ����
	 */
	public void setSubNet(String subNet) {
		this.subNet = subNet;
	}

	/**
	 * ɾ����ʶȡ��
	 * @return ɾ����ʶ
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * ɾ����ʶ�趨
	 * @param deleteflag ɾ����ʶ
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
