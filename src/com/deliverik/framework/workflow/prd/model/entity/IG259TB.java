package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG259Info;


/**
 * ����ģ����Ϣʵ��
 *
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IG259")
public class IG259TB extends BaseEntity implements Serializable, Cloneable, IG259Info {
	/**
	 * ����ģ��ID
	 */
	@Id
	@TableGenerator(
		    name="IG259_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG259_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG259_TABLE_GENERATOR")
	protected Integer ptid;

	/**
	 * ����ģ������
	 */
	protected String ptname;

	/**
	 * ����ģ������
	 */
	protected String pttype;

	/**
	 * ����ģ�巢��ҳURL
	 */
	protected String ptstartpg;

	/**
	 * ����ģ�崴��ʱ��
	 */
	protected String ptcrtdate;

	/**
	 * ����ģ����Ϣ
	 */
	protected String ptpicinfo;

	/**
	 * ����ģ��״̬��a���ã�iͣ�ã�
	 */
	protected String ptstatus;
	
	/**
	 * ����ģ��鿴ҳURL
	 */
	protected String ptdetailpg;
	
	/**
	 * ͨ������ģ������ת�ķ���ҳ��URL��ƽ̨������
	 */
	protected String ptsavepg;

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������
	 */
	protected String ptqrtzflag;
	
	/** ��λ�ñ�ʶ */
	protected String firstsite;
	
	/** ���ж��� */
	protected String pdsequence;
	
	
	/**
	 * ����ȡ��
	 * @return ptid
	 */
	public Serializable getPK() {
		return ptid;
	}


	public boolean equals(Object obj) {
		if (!(obj instanceof IG259TB))
			return false;
		IG259Info target = (IG259Info) obj;
		if (!(getPtid()==target.getPtid()))
			return false;
		return true;
	}

	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	  * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPtname() {
		return ptname;
	}

	/**
	 * ����ģ�������趨
	  * @param ptname ����ģ������
	 */
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	/**
	 * ����ģ������ȡ��
	 * @return ����ģ������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ����ģ�������趨
	  * @param pttype ����ģ������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * ����ģ�巢��ҳURLȡ��
	 * @return ����ģ�巢��ҳURL
	 */
	public String getPtstartpg() {
		return ptstartpg;
	}

	/**
	 * ����ģ�巢��ҳURL�趨
	  * @param ptstartpg ����ģ�巢��ҳURL
	 */
	public void setPtstartpg(String ptstartpg) {
		this.ptstartpg = ptstartpg;
	}

	/**
	 * ����ģ�崴��ʱ��ȡ��
	 * @return ����ģ�崴��ʱ��
	 */
	public String getPtcrtdate() {
		return ptcrtdate;
	}

	/**
	 * ����ģ�崴��ʱ���趨
	  * @param ptcrtdate ����ģ�崴��ʱ��
	 */
	public void setPtcrtdate(String ptcrtdate) {
		this.ptcrtdate = ptcrtdate;
	}

	/**
	 * ����ģ����Ϣȡ��
	 * @return ����ģ����Ϣ
	 */
	public String getPtpicinfo() {
		return ptpicinfo;
	}

	/**
	 * ����ģ����Ϣ�趨
	  * @param ptpicinfo ����ģ����Ϣ
	 */
	public void setPtpicinfo(String ptpicinfo) {
		this.ptpicinfo = ptpicinfo;
	}

	/**
	 * ����ģ��״̬ȡ��
	 * @return ����ģ��״̬
	 */
	public String getPtstatus() {
		return ptstatus;
	}

	/**
	 * ����ģ��״̬�趨
	  * @param ptstatus ����ģ��״̬
	 */
	public void setPtstatus(String ptstatus) {
		this.ptstatus = ptstatus;
	}

	/**
	 * ����ģ��鿴ҳURLȡ��
	 * @return ����ģ��鿴ҳURL
	 */
	public String getPtdetailpg() {
		return ptdetailpg;
	}

	/**
	 * ����ģ��鿴ҳURL�趨
	  * @param ptdetailpg ����ģ��鿴ҳURL
	 */
	public void setPtdetailpg(String ptdetailpg) {
		this.ptdetailpg = ptdetailpg;
	}

	/**
	 * ͨ������ģ������ת�ķ���ҳ��URL��ƽ̨������ȡ��
	 * @return ͨ������ģ������ת�ķ���ҳ��URL
	 */
	public String getPtsavepg() {
		return ptsavepg;
	}

	/**
	 * ͨ������ģ������ת�ķ���ҳ��URL��ƽ̨�������趨
	  * @param pdid ͨ������ģ������ת�ķ���ҳ��URL
	 */
	public void setPtsavepg(String ptsavepg) {
		this.ptsavepg = ptsavepg;
	}

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨������ȡ��
	 * @return ����ģ��ʹ��λ�ñ�ʶ
	 */
	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	/**
	 * ����ģ��ʹ��λ�ñ�ʶ��ƽ̨�������趨
	  * @param ptqrtzflag ����ģ��ʹ��λ�ñ�ʶ
	 */
	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}


	/**
	 * ��λ�ñ�ʶȡ��
	 * @return firstsite ��λ�ñ�ʶ
	 */
	public String getFirstsite() {
		return firstsite;
	}


	/**
	 * ��λ�ñ�ʶ�趨
	 * @param firstsite ��λ�ñ�ʶ
	 */
	public void setFirstsite(String firstsite) {
		this.firstsite = firstsite;
	}


	/**
	 * ���ж���ȡ��
	 * @return pdsequence ���ж���
	 */
	public String getPdsequence() {
		return pdsequence;
	}


	/**
	 * ���ж����趨
	 * @param pdsequence ���ж���
	 */
	public void setPdsequence(String pdsequence) {
		this.pdsequence = pdsequence;
	}
	
}
