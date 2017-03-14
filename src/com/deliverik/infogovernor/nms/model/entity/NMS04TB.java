/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS04Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS04" )
public class NMS04TB extends BaseEntity implements NMS04Info {
	
	/** ���� */
	@Id
	protected String id;
	
	/** �豸���� */
	protected String name;
	
	/** ��ʾIP */
	protected String ip;
	
	/** ��ʾMAC��ַ */
	protected String mac;
	
	/** �豸���� */
	protected String type;
	
	/** �ʲ�ID */
	protected Integer eiid;
	
	/** �ʲ���汾 */
	protected Integer eiversion;
	
	/** �ʲ�С�汾 */
	protected Integer eismallVersion;
	
	/** ����ʱ�� */
	protected String instime;
	
	/** ����ʱ�� */
	protected String updtime;
	
	/** �豸���� */
	protected String dispname;
	
	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * �豸����ȡ��
	 * @return name �豸����
	 */
	public String getName() {
		return name;
	}

	/**
	 * �豸�����趨
	 * @param name �豸����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ʾIPȡ��
	 * @return ip ��ʾIP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ��ʾIP�趨
	 * @param ip ��ʾIP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * ��ʾMAC��ַȡ��
	 * @return mac ��ʾMAC��ַ
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * ��ʾMAC��ַ�趨
	 * @param mac ��ʾMAC��ַ
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}

	/**
	 * �豸����ȡ��
	 * @return type �豸����
	 */
	public String getType() {
		return type;
	}

	/**
	 * �豸�����趨
	 * @param type �豸����
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * �ʲ�IDȡ��
	 * @return eiid �ʲ�ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID�趨
	 * @param eiid �ʲ�ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ���汾ȡ��
	 * @return eiversion �ʲ���汾
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * �ʲ���汾�趨
	 * @param eiversion �ʲ���汾
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}

	/**
	 * �ʲ�С�汾ȡ��
	 * @return eismallVersion �ʲ�С�汾
	 */
	public Integer getEismallVersion() {
		return eismallVersion;
	}

	/**
	 * �ʲ�С�汾�趨
	 * @param eismallVersion �ʲ�С�汾
	 */
	public void setEismallVersion(Integer eismallVersion) {
		this.eismallVersion = eismallVersion;
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
	 * ����ʱ��ȡ��
	 * @return updtime ����ʱ��
	 */
	public String getUpdtime() {
		return updtime;
	}

	/**
	 * ����ʱ���趨
	 * @param updtime ����ʱ��
	 */
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}

	/**
	 * ��ȡ�豸����
	 * @return �豸���� 
	 */
	public String getDispname() {
	    return dispname;
	}
	
	/**
	 * �����豸����
	 * @param dispname �豸����
	 */
	public void setDispname(String dispname) {
	    this.dispname = dispname;
	}
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}


}
