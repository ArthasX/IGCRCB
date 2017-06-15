/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * ���ռ����ʵ��
 * @author lipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="RiskCheckResult")
public class RiskCheckResultTB extends BaseEntity implements Serializable, Cloneable, RiskCheckResult {

	/** ���ռ����ID */
	@Id
	@TableGenerator(
		    name="RISKCHECKRESULT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="RISKCHECKRESULT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="RISKCHECKRESULT_TABLE_GENERATOR")
	/** ���ռ����ID */
	protected Integer rcrid;
	
	/** ���ռ��ID */
	protected Integer rcid;

	/** ���ռ��ƻ����ʱ�� */
	protected String rcrplandate;
	
	/** ���ռ��ʵ�ʼ��ʱ�� */
	protected String rcrrealtime;
	
	/** ���ռ�����ύ��ID */
	protected String rcruserid;
	
	/** ���ռ�����ύ������ */
	protected String rcrusername;
	
	/** ���ռ���� */
	protected String rcrresult;
	
	/** ���ռ����˵�� */
	protected String rcrcomment;
	
	/** ���ռ����Ҫ�̶� */
	protected String rctype;
	
	/** �´�ִ�м��ʱ�� */
	protected String rcrnextdate;
	
	/** ��������ID */
	protected Integer prid;
	
	protected String rcrtestmode;
	
	protected Integer assignprid;
	
	/** ���������*/
	protected String rcname;
	
	/** ���������*/
	protected String rcrclass;
	
	/** ���������*/
	protected String rcdesc;
	
	/** �����˵��*/
	protected String rccommon;
	
	/** ���ռ����� */
	@OneToOne
	@JoinColumn(name="rcid", referencedColumnName="rcid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RiskCheckTB riskCheck;
	
	/** ���ռ�������� */
	protected String rcrattch;

	/**
	 * @return the assignprid
	 */
	public Integer getAssignprid() {
		return assignprid;
	}

	/**
	 * @param assignprid the assignprid to set
	 */
	public void setAssignprid(Integer assignprid) {
		this.assignprid = assignprid;
	}

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rcrid;
	}

	
	/**
	 * @return the rcrtestmode
	 */
	public String getRcrtestmode() {
		return rcrtestmode;
	}

	/**
	 * @param rcrtestmode the rcrtestmode to set
	 */
	public void setRcrtestmode(String rcrtestmode) {
		this.rcrtestmode = rcrtestmode;
	}

	/**
	 * ���ռ����Ҫ�̶�ȡ��
	 * @return ���ռ����Ҫ�̶�
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 *���ռ����Ҫ�̶��趨
	 * @param rctype ���ռ����Ҫ�̶�
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * ���ռ�����ȡ��
	 * @return ���ռ�����
	 */
	public RiskCheckTB getRiskCheck() {
		return riskCheck;
	}


	/**
	 * ���ռ������趨
	 * @param riskCheck ���ռ�����
	 */
	public void setRiskCheck(RiskCheckTB riskCheck) {
		this.riskCheck = riskCheck;
	}




	/**
	 * ���ռ��������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcrattch() {
		return rcrattch;
	}



	/**
	 * ���ռ���������趨
	 * @param rcrattch ���ռ��������
	 */
	public void setRcrattch(String rcrattch) {
		this.rcrattch = rcrattch;
	}


	/**
	 * ���ռ����IDȡ��
	 * @return ���ռ����ID
	 */
	public Integer getRcrid() {
		return rcrid;
	}

	/**
	 * ���ռ����ID�趨
	 * @param rcrid ���ռ����ID
	 */
	public void setRcrid(Integer rcrid) {
		this.rcrid = rcrid;
	}

	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * ���ռ��ID�趨
	 * @param rcid ���ռ��ID
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ���ռ��ƻ����ʱ��ȡ��
	 * @return ���ռ��ƻ����ʱ��
	 */
	public String getRcrplandate() {
		return rcrplandate;
	}

	/**
	 * ���ռ��ƻ����ʱ���趨
	 * @param rcrplandate ���ռ��ƻ����ʱ��
	 */
	public void setRcrplandate(String rcrplandate) {
		this.rcrplandate = rcrplandate;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime() {
		return rcrrealtime;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ���趨
	 * @param rcrrealtime ���ռ��ʵ�ʼ��ʱ��
	 */
	public void setRcrrealtime(String rcrrealtime) {
		this.rcrrealtime = rcrrealtime;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcruserid() {
		return rcruserid;
	}

	/**
	 * ���ռ��ʵ�ʼ��ʱ���趨
	 * @param rcrrealdate ���ռ��ʵ�ʼ��ʱ��
	 */
	public void setRcruserid(String rcruserid) {
		this.rcruserid = rcruserid;
	}

	/**
	 * ���ռ�����ύ������ȡ��
	 * @return ���ռ�����ύ������
	 */
	public String getRcrusername() {
		return rcrusername;
	}

	/**
	 * ���ռ�����ύ�������趨
	 * @param rcrusername ���ռ�����ύ������
	 */
	public void setRcrusername(String rcrusername) {
		this.rcrusername = rcrusername;
	}

	/**
	 * ���ռ����ȡ��
	 * @return ���ռ����
	 */
	public String getRcrresult() {
		return rcrresult;
	}

	/**
	 * ���ռ�����趨
	 * @param rcrresult ���ռ����
	 */
	public void setRcrresult(String rcrresult) {
		this.rcrresult = rcrresult;
	}

	/**
	 * ���ռ����˵��ȡ��
	 * @return ���ռ����˵��
	 */
	public String getRcrcomment() {
		return rcrcomment;
	}

	/**
	 * ���ռ����˵���趨
	 * @param rcrcomment ���ռ����˵��
	 */
	public void setRcrcomment(String rcrcomment) {
		this.rcrcomment = rcrcomment;
	}

	/**
	 * �´�ִ�м��ʱ��ȡ��
	 * @return �´�ִ�м��ʱ��
	 */
	public String getRcrnextdate() {
		return rcrnextdate;
	}

	/**
	 * �´�ִ�м��ʱ���趨
	 * @param rcrnexttimen �´�ִ�м��ʱ��
	 */
	public void setRcrnextdate(String rcrnextdate) {
		this.rcrnextdate = rcrnextdate;
	}
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}
	
	/**
	 * ���������趨
	 * @param rcrnexttimen ���������趨
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ���������ȡ��
	 * @return the rcname
	 */
	public String getRcname() {
		return rcname;
	}

	/**
	 * ����������趨
	 * @param rcname the rcname to set
	 */
	public void setRcname(String rcname) {
		this.rcname = rcname;
	}

	/**
	 * ���������ȡ��
	 * @return the rcrclass
	 */
	public String getRcrclass() {
		return rcrclass;
	}

	/**
	 * ����������趨
	 * @param rcrclass the rcrclass to set
	 */
	public void setRcrclass(String rcrclass) {
		this.rcrclass = rcrclass;
	}

	/**
	 * ���������ȡ��
	 * @return the rcdesc
	 */
	public String getRcdesc() {
		return rcdesc;
	}

	/**
	 * ����������趨
	 * @param rcdesc the rcdesc to set
	 */
	public void setRcdesc(String rcdesc) {
		this.rcdesc = rcdesc;
	}

	/**
	 * �����˵��ȡ��
	 * @return the rccommon
	 */
	public String getRccommon() {
		return rccommon;
	}

	/**
	 * �����˵���趨
	 * @param rccommon the rccommon to set
	 */
	public void setRccommon(String rccommon) {
		this.rccommon = rccommon;
	}
	
	
	
}
