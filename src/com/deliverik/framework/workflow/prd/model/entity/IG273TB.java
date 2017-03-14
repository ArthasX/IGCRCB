/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG273Info;

/**
 * ����״̬ԾǨ����
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG273")
public class IG273TB extends BaseEntity implements Serializable, Cloneable, IG273Info {
	
	/** ����״̬ԾǨ����ID */
	@Id
	protected String ptdid;
	
	/**
	 * ����״̬ID��From��
	 */
	protected String fpsdid;
	
	/**
	 * ����״̬ID��To��
	 */
	protected String tpsdid;

	/**
	 * ����״̬ԾǨ��������
	 */
	protected String ptdname;
	
	/**
	 * ����״̬ԾǨ��������
	 */
	protected String ptddesc;
	
	/**
	 * ����״̬ԾǨ��������
	 */
	protected String ptdtype;
	
	/**
	 * ����״̬ԾǨ����
	 */
	protected String ptdcond;
	
	/**
	 * ����״̬ԾǨ����
	 */
	@Transient
	protected String ptdcondinfo;
	
	/** ���̵�ǰ״̬ */
	@OneToOne
	@JoinColumn(name="fpsdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB fromPSDTB;
	
	/** ����ԾǨ״̬ */
	@OneToOne
	@JoinColumn(name="tpsdid", referencedColumnName="psdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG333TB toPSDTB;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return ptdid;
	}

	/**
	 * ����״̬ԾǨ����IDȡ��
	 * @return ����״̬ԾǨ����ID
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * ����״̬ԾǨ����ID�趨
	 * @param ptdid ����״̬ԾǨ����ID
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * ����״̬ID��From��ȡ��
	 * @return ����״̬ID��From��
	 */
	public String getFpsdid() {
		return fpsdid;
	}

	/**
	 * ����״̬ID��From���趨
	 * @param fpsdid ����״̬ID��From��
	 */
	public void setFpsdid(String fpsdid) {
		this.fpsdid = fpsdid;
	}

	/**
	 * ����״̬ID��To��ȡ��
	 * @return ����״̬ID��To��
	 */
	public String getTpsdid() {
		return tpsdid;
	}

	/**
	 * ����״̬ID��To���趨
	 * @param tpsdid ����״̬ID��To��
	 */
	public void setTpsdid(String tpsdid) {
		this.tpsdid = tpsdid;
	}

	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdname() {
		return ptdname;
	}

	/**
	 * ����״̬ԾǨ���������趨
	 * @param ptdname ����״̬ԾǨ��������
	 */
	public void setPtdname(String ptdname) {
		this.ptdname = ptdname;
	}

	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtddesc() {
		return ptddesc;
	}

	/**
	 * ����״̬ԾǨ���������趨
	 * @param ptddesc ����״̬ԾǨ��������
	 */
	public void setPtddesc(String ptddesc) {
		this.ptddesc = ptddesc;
	}

	/**
	 * ����״̬ԾǨ��������ȡ��
	 * @return ����״̬ԾǨ��������
	 */
	public String getPtdtype() {
		return ptdtype;
	}

	/**
	 * ����״̬ԾǨ���������趨
	 * @param ptdtype ����״̬ԾǨ��������
	 */
	public void setPtdtype(String ptdtype) {
		this.ptdtype = ptdtype;
	}

	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcond() {
		return ptdcond;
	}

	/**
	 * ����״̬ԾǨ�����趨
	 * @param ptdcond ����״̬ԾǨ����
	 */
	public void setPtdcond(String ptdcond) {
		this.ptdcond = ptdcond;
	}

	/**
	 * ���̵�ǰ״̬ȡ��
	 * @return ���̵�ǰ״̬
	 */
	public IG333TB getFromPSDTB() {
		return fromPSDTB;
	}

	/**
	 * ���̵�ǰ״̬�趨
	 * @param fromPSDTB ���̵�ǰ״̬
	 */
	public void setFromPSDTB(IG333TB fromPSDTB) {
		this.fromPSDTB = fromPSDTB;
	}

	/**
	 * ����ԾǨ״̬ȡ��
	 * @return ����ԾǨ״̬
	 */
	public IG333TB getToPSDTB() {
		return toPSDTB;
	}

	/**
	 * ����ԾǨ״̬�趨
	 * @param toPSDTB ����ԾǨ״̬
	 */
	public void setToPSDTB(IG333TB toPSDTB) {
		this.toPSDTB = toPSDTB;
	}
	
	/**
	 * ����״̬ԾǨ����ȡ��
	 * @return ����״̬ԾǨ����
	 */
	public String getPtdcondinfo() {
		return ptdcondinfo;
	}

	/**
	 * ����״̬ԾǨ�����趨
	 * @param ptdcondinfo ����״̬ԾǨ����
	 */
	public void setPtdcondinfo(String ptdcondinfo) {
		this.ptdcondinfo = ptdcondinfo;
	}

}
