/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;

/**
  * ����: �������ļල��ͼʵ��
  * ��������: �������ļල��ͼʵ��
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class RiskCheckProblemSuperviseVW implements Serializable, RiskCheckProblemSuperviseVWInfo {

	/** ��������ID */
	@Id
	protected String prid;
	
	/** ���̶���Id */
	protected String prpdid;
	
	/** �������� */
	protected String prtitle;
	
	/** �������� */
	protected String prdesc;
	
	/** ���̷�����id */
	protected String pruserid;
	
	/** ���̷��������� */
	protected String prusername;
	
	/** ���ⷢ��ʱ�� */
	protected String propentime;
	
	/** �������ʱ�� */
	protected String prclosetime; 
	
	/** ����״̬ */
	protected String prstatus; 
	
	/** �������� */
	protected String riskprype;
	
	/** ������Դ */
	protected String problemsource;

	/**
	 * ��������IDȡ��
	 * @return prid ��������ID
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * ��������ID�趨
	 * @param prid ��������ID
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * ���̶���Idȡ��
	 * @return prpdid ���̶���Id
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶���Id�趨
	 * @param prpdid ���̶���Id
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ��������ȡ��
	 * @return prtitle ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���������趨
	 * @param prdesc ��������
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ���̷�����idȡ��
	 * @return pruserid ���̷�����id
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * ���̷�����id�趨
	 * @param pruserid ���̷�����id
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	/**
	 * ���̷���������ȡ��
	 * @return prusername ���̷���������
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̷����������趨
	 * @param prusername ���̷���������
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * ���ⷢ��ʱ��ȡ��
	 * @return propentime ���ⷢ��ʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���ⷢ��ʱ���趨
	 * @param propentime ���ⷢ��ʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * �������ʱ��ȡ��
	 * @return prclosetime �������ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * �������ʱ���趨
	 * @param prclosetime �������ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ����״̬ȡ��
	 * @return prstatus ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��������ȡ��
	 * @return riskprype ��������
	 */
	public String getRiskprype() {
		return riskprype;
	}

	/**
	 * ���������趨
	 * @param riskprype ��������
	 */
	public void setRiskprype(String riskprype) {
		this.riskprype = riskprype;
	}

	/**
	 * ������Դȡ��
	 * @return problemsource ������Դ
	 */
	public String getProblemsource() {
		return problemsource;
	}

	/**
	 * ������Դ�趨
	 * @param problemsource ������Դ
	 */
	public void setProblemsource(String problemsource) {
		this.problemsource = problemsource;
	} 


}