/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸���ϵ��Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@IdClass(NMS05PK.class)
@Table(name="NMS05")
@TableSpace(name="IG_SPACE")
public class NMS05TB extends BaseEntity implements NMS05Info {

	/** ��ID */
	@Id
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;
	
	/** �豸ID */
	@Id
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String did;
	
	/** ��汾 */
	@Id
	@FieldType(value="INTEGER")
	protected Integer gversion;
	
	/** ��ʾIP */
	@FieldType(value="VARCHAR(64)")
	protected String ip;
	
	/** ��ʾMAC��ַ */
	@FieldType(value="VARCHAR(32)")
	protected String mac;
	
	/** SNMP��Ϣ */
	@FieldType(value="VARCHAR(512)")
	protected String snmpid;
	
	/** ����ʱ�� */
	@FieldType(value="CHAR(16)")
	protected String instime;
	
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
	 * ��汾ȡ��
	 * @return gversion ��汾
	 */
	public Integer getGversion() {
		return gversion;
	}

	/**
	 * ��汾�趨
	 * @param gversion ��汾
	 */
	public void setGversion(Integer gversion) {
		this.gversion = gversion;
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
	 * SNMP��Ϣȡ��
	 * @return snmpid SNMP��Ϣ
	 */
	public String getSnmpid() {
		return snmpid;
	}

	/**
	 * SNMP��Ϣ�趨
	 * @param snmpid SNMP��Ϣ
	 */
	public void setSnmpid(String snmpid) {
		this.snmpid = snmpid;
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
		return new NMS05PK(gid, did, gversion);
	}

}
