/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ������ѯ��������ʵ��
  * ��������: ������ѯ��������ʵ��
  * ������¼: 2014/07/01
  * �޸ļ�¼: 
  */
public class CheckItemVWSearchCondImpl implements
		CheckItemVWSearchCond {

	/**��������*/
	protected String einame;
	
	/**���ϵ���*/
	protected String datady;
	
	/**��̸����*/
	protected String viewobj;
	
	/**������*/
	protected String managername;
	
	/**���*/
	protected String bh;
	
	/**��ʼ����*/
	protected String startdate;
	/**�������� */
	protected String enddate;
	
	/**���Ƶ��*/
	protected String checkfrequency;
	
	/**�����������ID*/
	protected String eiid;
	
	protected String eiid_NotIn;
	
	/**
	 * �����������IDȡ��
	 * @return eiid �����������ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * �����������ID�趨
	 * @param eiid �����������ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ���Ƶ��ȡ��
	 * @return checkfrequency ���Ƶ��
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * ���Ƶ���趨
	 * @param checkfrequency ���Ƶ��
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * ��ʼ����ȡ��
	 * @return startdate ��ʼ����
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * ��ʼ�����趨
	 * @param startdate ��ʼ����
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * ��������ȡ��
	 * @return enddate ��������
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * ���������趨
	 * @param enddate ��������
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * ���ȡ��
	 * @return bh ���
	 */
	public String getBh() {
		return bh;
	}

	/**
	 * ����趨
	 * @param bh ���
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}

	/**
	 * ���������趨
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���ϵ����趨
	 * @param datady ���ϵ���
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * ��̸�����趨
	 * @param viewobj ��̸����
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * �������趨
	 * @param managername ������
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * eIINSDATE�趨
	 * @param eIINSDATE eIINSDATE
	 */
	public void setEIINSDATE(String eIINSDATE) {
		EIINSDATE = eIINSDATE;
	}

	/**
	 * ������趨
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**�Ǽ���*/
	protected String EIINSDATE;
	
	/**�����*/
	protected String syscoding;

	/**
	 * ��������ȡ��
	 * @return einame ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���ϵ���ȡ��
	 * @return datady ���ϵ���
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * ��̸����ȡ��
	 * @return viewobj ��̸����
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * ������ȡ��
	 * @return managername ������
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * eIINSDATEȡ��
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE() {
		return EIINSDATE;
	}

	/**
	 * �����ȡ��
	 * @return syscoding �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn() {
		return eiid_NotIn;
	}

	/**
	 * @param eiid_NotIn the eiid_NotIn to set
	 */
	public void setEiid_NotIn(String eiid_NotIn) {
		this.eiid_NotIn = eiid_NotIn;
	}


	
	
}