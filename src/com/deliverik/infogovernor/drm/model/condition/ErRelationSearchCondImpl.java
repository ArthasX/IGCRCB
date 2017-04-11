/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ErRelation��������ʵ��
  * ��������: ErRelation��������ʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class ErRelationSearchCondImpl implements
		ErRelationSearchCond {
	

	protected Integer errid;
	
	/** Ӧ����Դ���� */
	protected Integer erid;

	/** ��Դ���� */
	protected String ercode;

	/** �������� */
	protected String erparcode;

	/** �ʲ�id */
	protected String eiid;

	/** �ʲ����� */
	protected String einame;

	/** ¼�������� */
	protected String errstatus;

	/** ɾ����־ */
	protected String deleteflag;
	
	/**
	 * ��Դ����(1:Ӧ��,0:����)
	 */
	protected String resourceType;

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * ��Դ����(1:Ӧ��,0:����)
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErrid() {
		return errid;
	}

	/**
	 * �����趨
	 *
	 * @param errid ����
	 */
	public void setErrid(Integer errid) {
		this.errid = errid;
	}

	/**
	 * Ӧ����Դ����ȡ��
	 *
	 * @return Ӧ����Դ����
	 */
	public Integer getErid() {
		return erid;
	}

	/**
	 * Ӧ����Դ�����趨
	 *
	 * @param erid Ӧ����Դ����
	 */
	public void setErid(Integer erid) {
		this.erid = erid;
	}

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode() {
		return ercode;
	}

	/**
	 * ��Դ�����趨
	 *
	 * @param ercode ��Դ����
	 */
	public void setErcode(String ercode) {
		this.ercode = ercode;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getErparcode() {
		return erparcode;
	}

	/**
	 * ���������趨
	 *
	 * @param erparcode ��������
	 */
	public void setErparcode(String erparcode) {
		this.erparcode = erparcode;
	}

	/**
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�id�趨
	 *
	 * @param eiid �ʲ�id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �ʲ������趨
	 *
	 * @param einame �ʲ�����
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErrstatus() {
		return errstatus;
	}

	/**
	 * ¼���������趨
	 *
	 * @param errstatus ¼��������
	 */
	public void setErrstatus(String errstatus) {
		this.errstatus = errstatus;
	}

	/**
	 * ɾ����־ȡ��
	 *
	 * @return ɾ����־
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * ɾ����־�趨
	 *
	 * @param deleteflag ɾ����־
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}
}