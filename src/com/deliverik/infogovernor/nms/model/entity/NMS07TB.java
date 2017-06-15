/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS07")
@TableSpace(name="IG_SPACE")
public class NMS07TB extends BaseEntity implements NMS07Info {
	
	/** ���� */
	@Id
	@FieldType(value="VARCHAR(64)")
	protected String id;

	/** Դ�豸ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String fromdid;

	/** Ŀ���豸ID */
	@FieldType(value="VARCHAR(128)")
	@Fk(tablename="NMS04",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected String todid;

	/** ��ID */
	@FieldType(value="INTEGER")
	@Fk(tablename="NMS01",fkfield="ID",deleteCascade=true,updateCascade=true)
	protected Integer gid;

	/** ��汾 */
	@FieldType(value="INTEGER")
	protected Integer gversion;

	/** Դ�豸����˿� */
	@FieldType(value="INTEGER")
	protected Integer fromPhysicalPort;

	/** Դ�豸IFINDEX */
	@FieldType(value="INTEGER")
	protected Integer fromNodeIfIndex;

	/** Դ�豸IFNAME */
	@FieldType(value="VARCHAR(128)")
	protected String fromNodeIfName;

	/** Ŀ���豸����˿� */
	@FieldType(value="INTEGER")
	protected Integer topHysicalPort;

	/** Ŀ���豸IFINDEX */
	@FieldType(value="INTEGER")
	protected Integer toNodeIfIndex;

	/** Ŀ���豸IFNAME */
	@FieldType(value="VARCHAR(128)")
	protected String toNodeIfName;

	/** ����ʱ�� */
	@FieldType(value="CHAR(16)")
	protected String instime;
	
	/**
	 * ��������
	 * @return ����
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
	 * Դ�豸IDȡ��
	 * @return fromdid Դ�豸ID
	 */
	public String getFromdid() {
		return fromdid;
	}

	/**
	 * Դ�豸ID�趨
	 * @param fromdid Դ�豸ID
	 */
	public void setFromdid(String fromdid) {
		this.fromdid = fromdid;
	}

	/**
	 * Ŀ���豸IDȡ��
	 * @return todid Ŀ���豸ID
	 */
	public String getTodid() {
		return todid;
	}

	/**
	 * Ŀ���豸ID�趨
	 * @param todid Ŀ���豸ID
	 */
	public void setTodid(String todid) {
		this.todid = todid;
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
	 * Դ�豸����˿�ȡ��
	 * @return fromPhysicalPort Դ�豸����˿�
	 */
	public Integer getFromPhysicalPort() {
		return fromPhysicalPort;
	}

	/**
	 * Դ�豸����˿��趨
	 * @param fromPhysicalPort Դ�豸����˿�
	 */
	public void setFromPhysicalPort(Integer fromPhysicalPort) {
		this.fromPhysicalPort = fromPhysicalPort;
	}

	/**
	 * Դ�豸IFINDEXȡ��
	 * @return fromNodeIfIndex Դ�豸IFINDEX
	 */
	public Integer getFromNodeIfIndex() {
		return fromNodeIfIndex;
	}

	/**
	 * Դ�豸IFINDEX�趨
	 * @param fromNodeIfIndex Դ�豸IFINDEX
	 */
	public void setFromNodeIfIndex(Integer fromNodeIfIndex) {
		this.fromNodeIfIndex = fromNodeIfIndex;
	}

	/**
	 * Դ�豸IFNAMEȡ��
	 * @return fromNodeIfName Դ�豸IFNAME
	 */
	public String getFromNodeIfName() {
		return fromNodeIfName;
	}

	/**
	 * Դ�豸IFNAME�趨
	 * @param fromNodeIfName Դ�豸IFNAME
	 */
	public void setFromNodeIfName(String fromNodeIfName) {
		this.fromNodeIfName = fromNodeIfName;
	}

	/**
	 * Ŀ���豸����˿�ȡ��
	 * @return topHysicalPort Ŀ���豸����˿�
	 */
	public Integer getTopHysicalPort() {
		return topHysicalPort;
	}

	/**
	 * Ŀ���豸����˿��趨
	 * @param topHysicalPort Ŀ���豸����˿�
	 */
	public void setTopHysicalPort(Integer topHysicalPort) {
		this.topHysicalPort = topHysicalPort;
	}

	/**
	 * Ŀ���豸IFINDEXȡ��
	 * @return toNodeIfIndex Ŀ���豸IFINDEX
	 */
	public Integer getToNodeIfIndex() {
		return toNodeIfIndex;
	}

	/**
	 * Ŀ���豸IFINDEX�趨
	 * @param toNodeIfIndex Ŀ���豸IFINDEX
	 */
	public void setToNodeIfIndex(Integer toNodeIfIndex) {
		this.toNodeIfIndex = toNodeIfIndex;
	}

	/**
	 * Ŀ���豸IFNAMEȡ��
	 * @return toNodeIfName Ŀ���豸IFNAME
	 */
	public String getToNodeIfName() {
		return toNodeIfName;
	}

	/**
	 * Ŀ���豸IFNAME�趨
	 * @param toNodeIfName Ŀ���豸IFNAME
	 */
	public void setToNodeIfName(String toNodeIfName) {
		this.toNodeIfName = toNodeIfName;
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
