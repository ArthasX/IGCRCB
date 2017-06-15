/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.nms.model.NMS10Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·��������Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS10")
public class NMS10TB extends BaseEntity implements NMS10Info {
    
    /** ���� */
    @Id
    protected String id;

    /** Դ�豸ID */
    protected String fromdid;

    /** Ŀ���豸ID */
    protected String todid;

    /** ��ID */
    protected Integer gid;
    
    /** �û�id */
    protected String userid;

    /** ��汾 */
    protected Integer gversion;

    /** Դ�豸����˿� */
    protected Integer fromPhysicalPort;

    /** Դ�豸IFINDEX */
    protected Integer fromNodeIfIndex;

    /** Դ�豸IFNAME */
    protected String fromNodeIfName;

    /** Ŀ���豸����˿� */
    protected Integer topHysicalPort;

    /** Ŀ���豸IFINDEX */
    protected Integer toNodeIfIndex;

    /** Ŀ���豸IFNAME */
    protected String toNodeIfName;

    /** ����ʱ�� */
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
     * ��ȡ�û�id
     * @return �û�id 
     */
    public String getUserid() {
        return userid;
    }

    /**
     * �����û�id
     * @param userid �û�id
     */
    public void setUserid(String userid) {
        this.userid = userid;
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
