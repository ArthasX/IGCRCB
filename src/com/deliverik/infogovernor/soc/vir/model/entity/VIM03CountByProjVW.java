/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
/**
 * ����:������Դͳ����ͼʵ��(����Ŀ)
 * ��������:������Դͳ����ͼʵ��(����Ŀ) 
 * ������¼: 2014/02/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class VIM03CountByProjVW implements Serializable, Cloneable,
		VIM03CountByProjVWInfo {

	/**��Ŀ��  */
	protected String pname;
	/**��ĿID  */
	@Id
	protected String pid;
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
	 * ��Ŀ��ȡ��
	 * @return pname ��Ŀ��
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * ��Ŀ���趨
	 * @param pname ��Ŀ��
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public String getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(String pid) {
		this.pid = pid;
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
		return pid;
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
