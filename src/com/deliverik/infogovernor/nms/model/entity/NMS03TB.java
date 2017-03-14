/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.infogovernor.nms.model.NMS03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS03")
public class NMS03TB extends BaseEntity implements NMS03Info ,LogicalDelete{
	
	/** ���� */
	@Id
	@TableGenerator(
			name="NMS03_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="NMS03_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE,generator="NMS03_TABLE_GENERATOR")
	protected Integer id;
	
	/** ��ID */
	protected Integer gid;
	
	/** �汾 */
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
	
	/** ɾ����ʶ */
	protected String deleteflag;

	/**
	 * ����ȡ��
	 * @return id ����
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
	 * @return gid ��ID
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

	/**
	 * ��������ȡ��
	 * @return type ��������
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
	 * @return isEnablePing �Ƿ�����PING
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
	 * @return isEnableArp �Ƿ�����ARP
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
	 * @return fromIP ��ʼIP
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
	 * @return toIP ����IP
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
	 * @return subNet ����
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
	 * @return instime ����ʱ��
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
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
