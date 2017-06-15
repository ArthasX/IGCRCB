/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;

/**
  * ����: ���ռƻ���ѯʵ��
  * ��������: ���ռƻ���ѯʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="riskprojectvw")
public class RiskprojectvwTB extends BaseEntity implements Serializable,
		Cloneable, RiskprojectvwInfo {

	/** ���̼�¼ID */
	@Id
	protected Integer prid ;

	/** ���̼�¼״̬ */
	protected String prstatus;

	/** ���̼�¼��Ŀ */
	protected String prtitle ;

	/** ���̼�¼����ʱ�� */
	protected String propentime;

	/** ���̼�¼�ƻ�ִ��ʱ�� */
	protected String prplantime;

	/** ���̼�¼�����߽�ɫ���� */
	protected String prrolename;

	/** ���̼�¼������ */
	protected String prserialnum;

	/** ���ռƻ����� */
	protected String risktype;

	/** ���̼�¼������������������ */
	protected String prorgname;

	/** �ƻ������� */
	protected String riskcompletion;

//	/** ���ռƻ�״̬ */
//	protected String riskstatus;

	/** ���̼�¼������������������� */
	protected String prorgid;

	/** ���̼�¼���� */
	protected String prdesc;

	/** ���ձ�� */
	protected String risknum;

	/** ���̼�¼������������ */
	protected String prpdname;

	/** ���̼�¼��������ID */
	protected String prpdid;

	/** ���̼�¼�����߽�ɫID */
	protected String prroleid;

	/** ���̼�¼�������û����� */
	protected String prusername;

	/** ���̼�¼�������û�ID */
	protected String pruserid;

	/** ���̼�¼�ر�ʱ�� */
	protected String prclosetime;
	/**�ƻ���ʼʱ��*/
	protected String riskstart;
	/**�ƻ�����ʱ��*/
	protected String riskend;

	
	public String getRiskstart() {
        return riskstart;
    }

    public void setRiskstart(String riskstart) {
        this.riskstart = riskstart;
    }

    public String getRiskend() {
        return riskend;
    }

    public void setRiskend(String riskend) {
        this.riskend = riskend;
    }

    /**
	 * ���̼�¼IDȡ��
	 *
	 * @return ���̼�¼ID
	 */
	public Integer getPrid () {
		return prid ;
	}

	/**
	 * ���̼�¼ID�趨
	 *
	 * @param prid  ���̼�¼ID
	 */
	public void setPrid (Integer prid ) {
		this.prid  = prid ;
	}

	/**
	 * ���̼�¼״̬ȡ��
	 *
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ���̼�¼״̬�趨
	 *
	 * @param prstatus ���̼�¼״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���̼�¼��Ŀȡ��
	 *
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle () {
		return prtitle ;
	}

	/**
	 * ���̼�¼��Ŀ�趨
	 *
	 * @param prtitle  ���̼�¼��Ŀ
	 */
	public void setPrtitle (String prtitle ) {
		this.prtitle  = prtitle ;
	}

	/**
	 * ���̼�¼����ʱ��ȡ��
	 *
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̼�¼����ʱ���趨
	 *
	 * @param propentime ���̼�¼����ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 *
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime() {
		return prplantime;
	}

	/**
	 * ���̼�¼�ƻ�ִ��ʱ���趨
	 *
	 * @param prplantime ���̼�¼�ƻ�ִ��ʱ��
	 */
	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	/**
	 * ���̼�¼�����߽�ɫ����ȡ��
	 *
	 * @return ���̼�¼�����߽�ɫ����
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * ���̼�¼�����߽�ɫ�����趨
	 *
	 * @param prrolename ���̼�¼�����߽�ɫ����
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * ���̼�¼������ȡ��
	 *
	 * @return ���̼�¼������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * ���̼�¼�������趨
	 *
	 * @param prserialnum ���̼�¼������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���ռƻ�����ȡ��
	 *
	 * @return ���ռƻ�����
	 */
	public String getRisktype() {
		return risktype;
	}

	/**
	 * ���ռƻ������趨
	 *
	 * @param risktype ���ռƻ�����
	 */
	public void setRisktype(String risktype) {
		this.risktype = risktype;
	}

	/**
	 * ���̼�¼������������������ȡ��
	 *
	 * @return ���̼�¼������������������
	 */
	public String getProrgname() {
		return prorgname;
	}

	/**
	 * ���̼�¼�������������������趨
	 *
	 * @param prorgname ���̼�¼������������������
	 */
	public void setProrgname(String prorgname) {
		this.prorgname = prorgname;
	}

	/**
	 * �ƻ�������ȡ��
	 *
	 * @return �ƻ�������
	 */
	public String getRiskcompletion() {
		return riskcompletion;
	}

	/**
	 * �ƻ��������趨
	 *
	 * @param riskcompletion �ƻ�������
	 */
	public void setRiskcompletion(String riskcompletion) {
		this.riskcompletion = riskcompletion;
	}
//
//	/**
//	 * ���ռƻ�״̬ȡ��
//	 *
//	 * @return ���ռƻ�״̬
//	 */
//	public String getRiskstatus() {
//		return riskstatus;
//	}

//	/**
//	 * ���ռƻ�״̬�趨
//	 *
//	 * @param riskstatus ���ռƻ�״̬
//	 */
//	public void setRiskstatus(String riskstatus) {
//		this.riskstatus = riskstatus;
//	}

	/**
	 * ���̼�¼�������������������ȡ��
	 *
	 * @return ���̼�¼�������������������
	 */
	public String getProrgid() {
		return prorgid;
	}

	/**
	 * ���̼�¼��������������������趨
	 *
	 * @param prorgid ���̼�¼�������������������
	 */
	public void setProrgid(String prorgid) {
		this.prorgid = prorgid;
	}

	/**
	 * ���̼�¼����ȡ��
	 *
	 * @return ���̼�¼����
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���̼�¼�����趨
	 *
	 * @param prdesc ���̼�¼����
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���ձ��ȡ��
	 *
	 * @return ���ձ��
	 */
	public String getRisknum() {
		return risknum;
	}

	/**
	 * ���ձ���趨
	 *
	 * @param risknum ���ձ��
	 */
	public void setRisknum(String risknum) {
		this.risknum = risknum;
	}

	/**
	 * ���̼�¼������������ȡ��
	 *
	 * @return ���̼�¼������������
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���̼�¼�������������趨
	 *
	 * @param prpdname ���̼�¼������������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ���̼�¼��������IDȡ��
	 *
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̼�¼��������ID�趨
	 *
	 * @param prpdid ���̼�¼��������ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 *
	 * @return ���̼�¼�����߽�ɫID
	 */
	public String getPrroleid() {
		return prroleid;
	}

	/**
	 * ���̼�¼�����߽�ɫID�趨
	 *
	 * @param prroleid ���̼�¼�����߽�ɫID
	 */
	public void setPrroleid(String prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ���̼�¼�������û�����ȡ��
	 *
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̼�¼�������û������趨
	 *
	 * @param prusername ���̼�¼�������û�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���̼�¼�������û�IDȡ��
	 *
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���̼�¼�������û�ID�趨
	 *
	 * @param pruserid ���̼�¼�������û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���̼�¼�ر�ʱ��ȡ��
	 *
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���̼�¼�ر�ʱ���趨
	 *
	 * @param prclosetime ���̼�¼�ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
    public Serializable getPK() {
		return prid ;
	}

}