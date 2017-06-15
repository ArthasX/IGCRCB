package com.deliverik.infogovernor.crc.model.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ѯVO
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGCRC14012VO extends BaseVO {
	
	protected Integer prid;

	/** ������*/
	protected String prserialnum;
	
	/** ����״̬ */
	protected String prstatus;

	/** �������� */
	protected String prtitle;

	/** ���̿�ʼʱ�� */
	protected String propentime;

	/** ���̹ر�ʱ�� */
	protected String prclosetime;
	
	/** ���̷�����*/
	protected String prusername;

	/** ������� */
	protected String changeclassify;

	/** ����ƽ̨ */
	protected String updateplatform;

	/** ������� */
	protected String changetype;

	/** ���ԭ�� */
	protected String changereason;

	/** ������ */
	protected String changecategory;

	/** ҵ��Ӱ�췶Χ */
	protected String businessscope;

	/** �Ƿ�Ӱ��ҵ�� */
	protected String isinfluence;

	/** ������� */
	protected String changecontent;

	/** ����״̬���� */
	protected String orderstatus;
	
	/** ����˵��*/
	protected String prdesc;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �����趨
	 *
	 * @param prid ����
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	

	/**
	 * ������ȡ��
	 * @return the prserialnum
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * �������趨
	 * @param prserialnum the ������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param prstatus ����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���������趨
	 *
	 * @param prtitle ��������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ���̿�ʼʱ��ȡ��
	 *
	 * @return ���̿�ʼʱ��
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * ���̿�ʼʱ���趨
	 *
	 * @param propentime ���̿�ʼʱ��
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * ���̹ر�ʱ��ȡ��
	 *
	 * @return ���̹ر�ʱ��
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * ���̹ر�ʱ���趨
	 *
	 * @param prclosetime ���̹ر�ʱ��
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * ���̷�����ȡ��
	 * @return the prusername
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * ���̷������趨
	 * @param prusername the ���̷�����
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangeclassify() {
		return changeclassify;
	}

	/**
	 * ��������趨
	 *
	 * @param changeclassify �������
	 */
	public void setChangeclassify(String changeclassify) {
		this.changeclassify = changeclassify;
	}

	/**
	 * ����ƽ̨ȡ��
	 *
	 * @return ����ƽ̨
	 */
	public String getUpdateplatform() {
		return updateplatform;
	}

	/**
	 * ����ƽ̨�趨
	 *
	 * @param updateplatform ����ƽ̨
	 */
	public void setUpdateplatform(String updateplatform) {
		this.updateplatform = updateplatform;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangetype() {
		return changetype;
	}

	/**
	 * ��������趨
	 *
	 * @param changetype �������
	 */
	public void setChangetype(String changetype) {
		this.changetype = changetype;
	}

	/**
	 * ���ԭ��ȡ��
	 *
	 * @return ���ԭ��
	 */
	public String getChangereason() {
		return changereason;
	}

	/**
	 * ���ԭ���趨
	 *
	 * @param changereason ���ԭ��
	 */
	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getChangecategory() {
		return changecategory;
	}

	/**
	 * �������趨
	 *
	 * @param changecategory ������
	 */
	public void setChangecategory(String changecategory) {
		this.changecategory = changecategory;
	}

	/**
	 * ҵ��Ӱ�췶Χȡ��
	 *
	 * @return ҵ��Ӱ�췶Χ
	 */
	public String getBusinessscope() {
		return businessscope;
	}

	/**
	 * ҵ��Ӱ�췶Χ�趨
	 *
	 * @param businessscope ҵ��Ӱ�췶Χ
	 */
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}

	/**
	 * �Ƿ�Ӱ��ҵ��ȡ��
	 *
	 * @return �Ƿ�Ӱ��ҵ��
	 */
	public String getIsinfluence() {
		return isinfluence;
	}

	/**
	 * �Ƿ�Ӱ��ҵ���趨
	 *
	 * @param isinfluence �Ƿ�Ӱ��ҵ��
	 */
	public void setIsinfluence(String isinfluence) {
		this.isinfluence = isinfluence;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getChangecontent() {
		return changecontent;
	}

	/**
	 * ��������趨
	 *
	 * @param changecontent �������
	 */
	public void setChangecontent(String changecontent) {
		this.changecontent = changecontent;
	}

	/**
	 * ����״̬����ȡ��
	 *
	 * @return ����״̬����
	 */
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * ����״̬�����趨
	 *
	 * @param orderstatus ����״̬����
	 */
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	/**
	 * ����˵��ȡ��
	 * @return the prdesc
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ����˵���趨
	 * @param prdesc the ����˵��
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}
}
