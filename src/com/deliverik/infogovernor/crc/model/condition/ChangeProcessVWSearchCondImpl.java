/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * ����: ������̼�������ʵ��
  * ��������: ������̼�������ʵ��
  * ������¼: 2015/01/04
  * �޸ļ�¼: 
  */
public class ChangeProcessVWSearchCondImpl implements
		ChangeProcessVWSearchCond {

	/** ��������*/
	protected Integer prid;
	
	/** ������*/
	protected String prserialnum_like;
	
	/** �������� */
	protected String prtitle_like;
	
	/** ����״̬ */
	protected String prstatus;
	
	/** ���̿�ʼʱ�� (��ʼ)*/
	protected String propentime_begin;

	/** ���̿�ʼʱ�� (����)*/
	protected String propentime_end;
	
	/** ���̹ر�ʱ��(��ʼ) */
	protected String prclosetime_begin;
	
	/** ���̹ر�ʱ�� (����)*/
	protected String prclosetime_end;
	
	/** ������� */
	protected String changeclassify;

	/** ����ƽ̨ */
	protected String updateplatform_like;

	/** ������� */
	protected String changetype_like;

	/** ���ԭ�� */
	protected String changereason_like;

	/** ������ */
	protected String changecategory;
	
	/** ҵ��Ӱ�췶Χ */
	protected String businessscope;

	/** �Ƿ�Ӱ��ҵ�� */
	protected String isinfluence;
	
	/** ������� */
	protected String changecontent_like;

	/** ������ */
	protected String ppusername_like;
	
	/**
	 * ��������ȡ��
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid the ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������ȡ��
	 * @return the prserialnum_like
	 */
	public String getPrserialnum_like() {
		return prserialnum_like;
	}

	/**
	 * �������趨
	 * @param prserialnum_like the ������
	 */
	public void setPrserialnum_like(String prserialnum_like) {
		this.prserialnum_like = prserialnum_like;
	}

	/**
	 * ����״̬ȡ��
	 * @return the prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * @param prstatus the ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ���̿�ʼʱ��(��ʼ)ȡ��
	 * @return the propentime_begin
	 */
	public String getPropentime_begin() {
		return propentime_begin;
	}

	/**
	 * ���̿�ʼʱ��(��ʼ)�趨
	 * @param propentime_begin the ���̿�ʼʱ��(��ʼ)
	 */
	public void setPropentime_begin(String propentime_begin) {
		this.propentime_begin = propentime_begin;
	}

	/**
	 * ���̿�ʼʱ��(����)ȡ��
	 * @return the propentime_end
	 */
	public String getPropentime_end() {
		return propentime_end;
	}

	/**
	 * ���̿�ʼʱ��(����)�趨
	 * @param propentime_end the ���̿�ʼʱ��(����)
	 */
	public void setPropentime_end(String propentime_end) {
		this.propentime_end = propentime_end;
	}

	/**
	 * ���̹ر�ʱ��(��ʼ)ȡ��
	 * @return the prclosetime_begin
	 */
	public String getPrclosetime_begin() {
		return prclosetime_begin;
	}

	/**
	 * ���̹ر�ʱ��(��ʼ)�趨
	 * @param prclosetime_begin the ���̹ر�ʱ��(��ʼ)
	 */
	public void setPrclosetime_begin(String prclosetime_begin) {
		this.prclosetime_begin = prclosetime_begin;
	}

	/**
	 * ���̹ر�ʱ��(����)ȡ��
	 * @return the prclosetime_end
	 */
	public String getPrclosetime_end() {
		return prclosetime_end;
	}

	/**
	 * ���̹ر�ʱ��(����)�趨
	 * @param prclosetime_end the ���̹ر�ʱ��(����)
	 */
	public void setPrclosetime_end(String prclosetime_end) {
		this.prclosetime_end = prclosetime_end;
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


	/**
	 * ����ƽ̨ȡ��
	 * @return the updateplatform_like
	 */
	public String getUpdateplatform_like() {
		return updateplatform_like;
	}

	/**
	 * ����ƽ̨�趨
	 * @param updateplatform_like the ����ƽ̨
	 */
	public void setUpdateplatform_like(String updateplatform_like) {
		this.updateplatform_like = updateplatform_like;
	}

	/**
	 * ���ԭ��ȡ��
	 * @return the changereason_like
	 */
	public String getChangereason_like() {
		return changereason_like;
	}

	/**
	 * ���ԭ���趨
	 * @param changereason_like the ���ԭ��
	 */
	public void setChangereason_like(String changereason_like) {
		this.changereason_like = changereason_like;
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
	 * ��������ȡ��
	 * @return the prtitle_like
	 */
	public String getPrtitle_like() {
		return prtitle_like;
	}

	/**
	 * ���������趨
	 * @param prtitle_like the ��������
	 */
	public void setPrtitle_like(String prtitle_like) {
		this.prtitle_like = prtitle_like;
	}

	/**
	 * �������ȡ��
	 * @return the changetype_like
	 */
	public String getChangetype_like() {
		return changetype_like;
	}

	/**
	 * ��������趨
	 * @param changetype_like the �������
	 */
	public void setChangetype_like(String changetype_like) {
		this.changetype_like = changetype_like;
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
	 * @return the changecontent_like
	 */
	public String getChangecontent_like() {
		return changecontent_like;
	}

	/**
	 * ��������趨
	 * @param changecontent_like the �������
	 */
	public void setChangecontent_like(String changecontent_like) {
		this.changecontent_like = changecontent_like;
	}

	/**
	 * ������ȡ��
	 * @return ppusername_like  ������
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * �������趨
	 * @param ppusername_like  ������
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

}