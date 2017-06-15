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
public class IGCRC1401Form extends BaseForm{

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

	/** ��������������ʾ*/
	protected String showFlag; 
	
	/** ������� */
	protected String changetype;
	
	/** ������� */
	protected String changecontent;
	
	/** ����ƽ̨ */
	protected String updateplatform;
	
	/** ������ */
	protected String changecategory;
	
	/** ���ԭ�� */
	protected String changereason;
	
	/** ҵ��Ӱ�췶Χ */
	protected String businessscope;

	/** �Ƿ�Ӱ��ҵ�� */
	protected String isinfluence;
	
	/** ������� */
	protected String changeclassify;
	
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

	/**
	 * ��������������ʾȡ��
	 * @return the showFlag
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * ��������������ʾ�趨
	 * @param showFlag the ��������������ʾ
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

	/**
	 * �������ȡ��
	 * @return the changecontent
	 */
	public String getChangecontent() {
		return changecontent;
	}

	/**
	 * ��������趨
	 * @param changecontent the �������
	 */
	public void setChangecontent(String changecontent) {
		this.changecontent = changecontent;
	}

	/**
	 * ����ƽ̨ȡ��
	 * @return the updateplatform
	 */
	public String getUpdateplatform() {
		return updateplatform;
	}

	/**
	 * ����ƽ̨�趨
	 * @param updateplatform the ����ƽ̨
	 */
	public void setUpdateplatform(String updateplatform) {
		this.updateplatform = updateplatform;
	}

	/**
	 * �������ȡ��
	 * @return the changetype
	 */
	public String getChangetype() {
		return changetype;
	}

	/**
	 * ��������趨
	 * @param changetype the �������
	 */
	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}

	/**
	 * ������ȡ��
	 * @return the changecategory
	 */
	public String getChangecategory() {
		return changecategory;
	}

	/**
	 * �������趨
	 * @param changecategory the ������
	 */
	public void setChangecategory(String changecategory) {
		this.changecategory = changecategory;
	}

	/**
	 * ���ԭ��ȡ��
	 * @return the changereason
	 */
	public String getChangereason() {
		return changereason;
	}

	/**
	 * ���ԭ���趨
	 * @param changereason the ���ԭ��
	 */
	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}

	/**
	 * ҵ��Ӱ�췶Χȡ��
	 * @return the businessscope
	 */
	public String getBusinessscope() {
		return businessscope;
	}

	/**
	 * ҵ��Ӱ�췶Χ�趨
	 * @param businessscope the ҵ��Ӱ�췶Χ
	 */
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}

	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 * @return the isinfluence
	 */
	public String getIsinfluence() {
		return isinfluence;
	}

	/**
	 * �Ƿ�Ӱ��ҵ���趨
	 * @param isinfluence the �Ƿ�Ӱ��ҵ��
	 */
	public void setIsinfluence(String isinfluence) {
		this.isinfluence = isinfluence;
	}

	/**
	 * �������ȡ��
	 * @return the changeclassify
	 */
	public String getChangeclassify() {
		return changeclassify;
	}

	/**
	 * ��������趨
	 * @param changeclassify the �������
	 */
	public void setChangeclassify(String changeclassify) {
		this.changeclassify = changeclassify;
	}
}