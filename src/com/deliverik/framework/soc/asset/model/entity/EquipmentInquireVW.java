/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.entity;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;


/**
 * ����:3D����֧��IP��ѯ��ͼ 
 * ����������3D����֧��IP��ѯ��ͼ 
 * �����ˣ�����͢
 * ������¼�� 2013-01-31
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
@Entity
public class EquipmentInquireVW implements Serializable, Cloneable,EquipmentInquireVWInfo {
	
	@Id
	/**�豸����*/
	protected Integer eiid;
	/**��������*/
	protected String ename;
	
	/**�豸����*/
	protected String einame;

	/**�豸���*/
	protected String eilabel;
	
	/**ҵ��ϵͳ*/
	protected String businesssys;
	
	/**IP��ַ*/
	protected String ip;
	
	/**�ͺ�*/
	protected String pattern;
	
	/**������λ��*/
	protected String site ;
	
	/**��������*/
	protected String computerContainer ;
	
	/**��������Id*/
	protected Integer computerContainerId ;
	
	/**��������Id*/
	protected Integer computerroomId;

	/**��������*/
	protected String computerroom;
	/**
	 *��������Idȡ��
	 * @return ��������Id
	 */
	public Integer getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * ��������Id�趨
	 *
	 * @param computerContainerId ��������Id
	 */
	public void setComputerContainerId(Integer computerContainerId) {
		this.computerContainerId = computerContainerId;
	}

	/**
	 *�豸����ȡ��
	 * @return �豸����
	 */
	public Integer getEiid() {
		return eiid;
	}
	/**
	 * �豸�����趨
	 *
	 * @param eiid �豸����
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getEname() {
		return ename;
	}
	/**
	 * ���������趨
	 *
	 * @param ename ��������
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	/**
	 *�豸����ȡ��
	 * @return �豸����
	 */
	public String getEiname() {
		return einame;
	}
	/**
	 * �豸�����趨
	 *
	 * @param einame �豸����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}
	
	/**
	 *ҵ��ϵͳȡ��
	 * @return ҵ��ϵͳ
	 */
	public String getBusinesssys() {
		return businesssys;
	}
	
	/**
	 * ҵ��ϵͳ�趨
	 *
	 * @param businesssys ҵ��ϵͳ
	 */
	public void setBusinesssys(String businesssys) {
		this.businesssys = businesssys;
	}
	
	/**
	 *IP��ַȡ��
	 * @return IP��ַ
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * IP��ַ�趨
	 *
	 * @param ip IP��ַ
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	/**
	 *�ͺ�ȡ��
	 * @return �ͺ�
	 */
	public String getPattern() {
		return pattern;
	}
	
	/**
	 * �ͺ��趨
	 *
	 * @param pattern �ͺ�
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	/**
	 *������λ��ȡ��
	 * @return ������λ��
	 */
	public String getSite() {
		return site;
	}
	/**
	 * ������λ���趨
	 *
	 * @param site ������λ��
	 */
	public void setSite(String site) {
		this.site = site;
	}
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerContainer() {
		return computerContainer;
	}
	/**
	 * ���������趨
	 *
	 * @param computerContainer ��������
	 */
	public void setComputerContainer(String computerContainer) {
		this.computerContainer = computerContainer;
	}
	/**
	 *��������ȡ��
	 * @return ��������
	 */
	public String getComputerroom() {
		return computerroom;
	}
	/**
	 * ���������趨
	 *
	 * @param computerroom ��������
	 */
	public void setComputerroom(String computerroom) {
		this.computerroom = computerroom;
	}
    /**
     * �豸���ȡ��
     *
     * @return eilabel �豸���
     */
    public String getEilabel() {
        return eilabel;
    }
    /**
     * ��������Idȡ��
     *
     * @return computerroomId ��������Id
     */
    public Integer getComputerroomId() {
        return computerroomId;
    }
    /**
     * �豸����趨
     *
     * @param eilabel �豸���
     */
    public void setEilabel(String eilabel) {
        this.eilabel = eilabel;
    }
    /**
     * ��������Id�趨
     *
     * @param computerroomId ��������Id
     */
    public void setComputerroomId(Integer computerroomId) {
        this.computerroomId = computerroomId;
    }
	
	
}
