/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������������ѯForm
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC0401Form extends BaseForm{

	/** ���̶���ID */
	protected String pdid;
	
	/** ����״̬�� */
	protected String prstatus;
	
	/** ����״̬����ID */
	protected String psdid;
	
	/** ������ */
	protected String prserialnum;
	
	/** ���̱��� */
	protected String prtitle;
	
	/** ������ */
	protected String ppusername_like;
	
	/**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;
	
	/** �������� */
	protected String[] varnames;
	
	/** ��ֵ���� */
	protected String[] varvalues;
	
	/** ������ID */
	protected Integer parprid;

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
	 * ����״̬��ȡ��
	 * @return prstatus ����״̬��
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬���趨
	 * @param prstatus ����״̬��
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ����״̬����IDȡ��
	 * @return psdid ����״̬����ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬����ID�趨
	 * @param psdid ����״̬����ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * ������ȡ��
	 * @return prserialnum ������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * �������趨
	 * @param prserialnum ������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ���̱���ȡ��
	 * @return prtitle ���̱���
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̱����趨
	 * @param prtitle ���̱���
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ������ȡ��
	 * @return ppusername_like ������
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * �������趨
	 * @param ppusername_like ������
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

	/**
	 * ��ʼʱ��ȡ��
	 * @return propentime ��ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ��ʼʱ���趨
	 * @param propentime ��ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return prclosetime ����ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ����ʱ���趨
	 * @param prclosetime ����ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ��������ȡ��
	 * @return varnames ��������
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * ���������趨
	 * @param varnames ��������
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * ��ֵ����ȡ��
	 * @return varvalues ��ֵ����
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * ��ֵ�����趨
	 * @param varvalues ��ֵ����
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * ������IDȡ��
	 * @return parprid ������ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * ������ID�趨
	 * @param parprid ������ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}
}