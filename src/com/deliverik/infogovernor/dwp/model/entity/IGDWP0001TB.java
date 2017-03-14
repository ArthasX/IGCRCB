/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0001")
public class IGDWP0001TB extends BaseEntity implements IGDWP0001Info{
	
	/** ���� */
	@Id
	@TableGenerator(
		    name="IGDWP0001_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0001_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0001_TABLE_GENERATOR")
	protected Integer id;
	
	/** �ƻ����� */
	protected String pname;
	
	/** �ƻ����� */
	protected String pdesc;
	
	/** ������ID */
	protected String puserid;
	
	/** ���������� */
	protected String pusername;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** �������� */
	protected String pdname;
	
	/** �������� */
	protected String smscontent;
	
	/** ��ʼʱ�� */
	protected String startdate;
	
	/** ����ʱ�� */
	protected String enddate;
	
	/** �ƻ�ģʽ */
	protected String pmode;
	
	/** �ƻ����� */
	protected String ptype;
	
	/** �ƻ�ִ��ʱ�䣺Сʱ */
	protected String phour;
	
	/** �ƻ�ִ��ʱ�䣺���� */
	protected String pminute;
	
	/** �Ƿ����JOB */
	protected String isAddJob;

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
	 * �ƻ�����ȡ��
	 * @return pname �ƻ�����
	 */
	public String getPname() {
		return pname;
	}

	/**
	 * �ƻ������趨
	 * @param pname �ƻ�����
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return pdesc �ƻ�����
	 */
	public String getPdesc() {
		return pdesc;
	}

	/**
	 * �ƻ������趨
	 * @param pdesc �ƻ�����
	 */
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	/**
	 * ������IDȡ��
	 * @return puserid ������ID
	 */
	public String getPuserid() {
		return puserid;
	}

	/**
	 * ������ID�趨
	 * @param puserid ������ID
	 */
	public void setPuserid(String puserid) {
		this.puserid = puserid;
	}

	/**
	 * ����������ȡ��
	 * @return pusername ����������
	 */
	public String getPusername() {
		return pusername;
	}

	/**
	 * �����������趨
	 * @param pusername ����������
	 */
	public void setPusername(String pusername) {
		this.pusername = pusername;
	}

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ��������ȡ��
	 * @return pdname ��������
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * ���������趨
	 * @param pdname ��������
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * ��������ȡ��
	 * @return smscontent ��������
	 */
	public String getSmscontent() {
		return smscontent;
	}

	/**
	 * ���������趨
	 * @param smscontent ��������
	 */
	public void setSmscontent(String smscontent) {
		this.smscontent = smscontent;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return startdate ��ʼʱ��
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * ��ʼʱ���趨
	 * @param startdate ��ʼʱ��
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return enddate ����ʱ��
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * ����ʱ���趨
	 * @param enddate ����ʱ��
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * �ƻ�ģʽȡ��
	 * @return pmode �ƻ�ģʽ
	 */
	public String getPmode() {
		return pmode;
	}

	/**
	 * �ƻ�ģʽ�趨
	 * @param pmode �ƻ�ģʽ
	 */
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return ptype �ƻ�����
	 */
	public String getPtype() {
		return ptype;
	}

	/**
	 * �ƻ������趨
	 * @param ptype �ƻ�����
	 */
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺Сʱȡ��
	 * @return hour �ƻ�ִ��ʱ�䣺Сʱ
	 */
	public String getPhour() {
		return phour;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺Сʱ�趨
	 * @param hour �ƻ�ִ��ʱ�䣺Сʱ
	 */
	public void setPhour(String phour) {
		this.phour = phour;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺����ȡ��
	 * @return pminute �ƻ�ִ��ʱ�䣺����
	 */
	public String getPminute() {
		return pminute;
	}

	/**
	 * �ƻ�ִ��ʱ�䣺�����趨
	 * @param pminute �ƻ�ִ��ʱ�䣺����
	 */
	public void setPminute(String pminute) {
		this.pminute = pminute;
	}

	/**
	 * �Ƿ����JOBȡ��
	 * @return isAddJob �Ƿ����JOB
	 */
	public String getIsAddJob() {
		return isAddJob;
	}

	/**
	 * �Ƿ����JOB�趨
	 * @param isAddJob �Ƿ����JOB
	 */
	public void setIsAddJob(String isAddJob) {
		this.isAddJob = isAddJob;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
