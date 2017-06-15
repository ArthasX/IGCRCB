/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
/**
 * ����:������Դͳ����ͼʵ��(������)
 * ��������:������Դͳ����ͼʵ��(������) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class VIM03CountByOrgVW implements Serializable, Cloneable,
		VIM03CountByOrgVWInfo {

	/**������  */
	protected String orgname;
	/**������  */
	@Id
	protected String orgsyscoding;
	/**�������  */
	protected String count;
	/**CPU���� */
	protected Integer totalcpu;
	/**�ڴ����� */
	protected Integer totalmem;
	/**Ӳ������ */
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
		return orgsyscoding;
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
