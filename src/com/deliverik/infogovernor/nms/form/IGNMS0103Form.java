/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * ����: ��������Form
 * ��������: ��������Form
 * ������¼: 2013/12/20
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGNMS0103Form extends BaseForm implements NMS03Info {
	
	/** ���� */
	protected Integer id;
	
	/** ��ID */
	protected Integer gid;
	
	/** ����汾 */
	protected Integer version;
	
	/** �������� */
	protected String type;
	
	/** �Ƿ�����PING */
	protected String isEnablePing;
	
	/** �Ƿ�����ARP */
	protected String isEnableArp;
	
	/** ��ʼIP */
	protected String fromIP;
	
	/** ����IP */
	protected String toIP;
	
	/** ���� */
	protected String subNet;
	
	/** ����ʱ�� */
	protected String instime;
	
	/** ��¼ʱ��� */
	protected String fingerPrint;
	
	/** ɾ����ʶ */
	protected String deleteflag;

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

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
	 * ����汾ȡ��
	 * @return ����汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * ����汾�趨
	 * @param version ��汾
	 */
	public void setVersion(Integer version) {
		this.version = version;
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
	 * �Ƿ�����PINGȡ��
	 * @return �Ƿ�����PING
	 */
	public String getIsEnablePing() {
		return isEnablePing;
	}

	/**
	 * �Ƿ�����PING�趨
	 * @param isEnablePing �Ƿ�����PING
	 */
	public void setIsEnablePing(String isEnablePing) {
		this.isEnablePing = isEnablePing;
	}

	/**
	 * �Ƿ�����ARPȡ��
	 * @return �Ƿ�����ARP
	 */
	public String getIsEnableArp() {
		return isEnableArp;
	}

	/**
	 * �Ƿ�����ARP�趨
	 * @param isEnableArp �Ƿ�����ARP
	 */
	public void setIsEnableArp(String isEnableArp) {
		this.isEnableArp = isEnableArp;
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
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * ����ʱ���趨
	 * @param instime ����ʱ��
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}

	/**
	 * ��¼ʱ���ȡ��
	 * @return ��¼ʱ���
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * ��¼ʱ����趨
	 * @param fingerPrint ��¼ʱ���
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
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
	
}
