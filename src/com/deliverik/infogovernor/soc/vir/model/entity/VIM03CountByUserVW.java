/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
/**
 * ����:������Դͳ����ͼʵ��(���û�)
 * ��������:������Դͳ����ͼʵ��(���û�) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class VIM03CountByUserVW implements Serializable, Cloneable,
		VIM03CountByUserVWInfo {

	/**����  */
	@Id
	protected String id;
	/**�û���  */
	protected String username;
	/**�û�id */
	protected String userid;
	/**������  */
	protected String orgname;
	/**������  */
	protected String orgsyscoding;
	/**�������  */
	protected String count;
	
	/**CPUʹ����*���� */
	protected Integer totalcpu;
	/**�ڴ�ʹ����*���� */
	protected Integer totalmem;
	/**Ӳ��ʹ����*���� */
	protected Integer totaldisk;
	
	/** �ܷ��� */
	@Transient
	protected Integer cost;
	
	
	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

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
	 * �û���ȡ��
	 * @return username �û���
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * �û����趨
	 * @param username �û���
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * �û�idȡ��
	 * @return userid �û�id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�id�趨
	 * @param userid �û�id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ������ȡ��
	 * @return orgname ������
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * �������趨
	 * @param orgname ������
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * ������ȡ��
	 * @return orgsyscoding ������
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * �������趨
	 * @param orgsyscoding ������
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * �������ȡ��
	 * @return count �������
	 */
	public String getCount() {
		return count;
	}

	/**
	 * ��������趨
	 * @param count �������
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

	public Integer getTotalcpu() {
		return totalcpu;
	}

	public void setTotalcpu(Integer totalcpu) {
		this.totalcpu = totalcpu;
	}

	public Integer getTotalmem() {
		return totalmem;
	}

	public void setTotalmem(Integer totalmem) {
		this.totalmem = totalmem;
	}

	public Integer getTotaldisk() {
		return totaldisk;
	}

	public void setTotaldisk(Integer totaldisk) {
		this.totaldisk = totaldisk;
	}
	
	
}
