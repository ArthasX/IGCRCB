/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS06Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸MAC/IP��Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS06")
@TableSpace(name="IG_SPACE")
public class NMS06TB extends BaseEntity implements NMS06Info {

	/** ���� */
	@Id
	protected String id;
	
	/** �豸ID */
	protected String did;
	
	/** IP */
	protected String ip;
	
	/**  MAC��ַ*/
	protected String mac;
	
	/** ����ʱ�� */
	protected String instime;
	
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
	 * �豸IDȡ��
	 * @return did �豸ID
	 */
	public String getDid() {
		return did;
	}

	/**
	 * �豸ID�趨
	 * @param did �豸ID
	 */
	public void setDid(String did) {
		this.did = did;
	}

	/**
	 * IPȡ��
	 * @return ip IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * IP�趨
	 * @param ip IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * MAC��ַȡ��
	 * @return mac MAC��ַ
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * MAC��ַ�趨
	 * @param mac MAC��ַ
	 */
	public void setMac(String mac) {
		this.mac = mac;
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
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
