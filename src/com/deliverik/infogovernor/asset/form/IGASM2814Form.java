package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

public class IGASM2814Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/**��������*/
	protected String einame;
	
	/**���ϵ���*/
	protected String datady;
	
	/**��̸����*/
	protected String viewobj;
	
	/**������*/
	protected String managername;
	
	/**�Ǽ���*/
	protected String EIINSDATE;
	
	/**�����*/
	protected String syscoding;
	
	/**�����*/
	protected String ename;
	
	/**������ID*/
	protected String mguserid;
	
	/**���*/
	protected  String eilabel;
	
	/**���Ƶ��*/
	protected String checkfrequency;
	
	/** ɾ���������� */
	protected String[] deleteEiid;
	
	/**
	 * ɾ����������ȡ��
	 * @return deleteEiid ɾ����������
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}

	/**
	 * ɾ�����������趨
	 * @param deleteEiid ɾ����������
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * ������IDȡ��
	 * @return mguserid ������ID
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * ������ID�趨
	 * @param mguserid ������ID
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}
	

	/**
	 * ���ȡ��
	 * @return eilabel ���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ����趨
	 * @param eilabel ���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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

	/**��ʼ����*/
	protected String startdate;
	
	/**��������*/
	protected String enddate;

	/**
	 * ��������ȡ��
	 * @return einame ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���������趨
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���ϵ���ȡ��
	 * @return datady ���ϵ���
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * ���ϵ����趨
	 * @param datady ���ϵ���
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * ��̸����ȡ��
	 * @return viewobj ��̸����
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * ��̸�����趨
	 * @param viewobj ��̸����
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * ������ȡ��
	 * @return managername ������
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * �������趨
	 * @param managername ������
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * eIINSDATEȡ��
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE() {
		return EIINSDATE;
	}

	/**
	 * eIINSDATE�趨
	 * @param eIINSDATE eIINSDATE
	 */
	public void setEIINSDATE(String eIINSDATE) {
		EIINSDATE = eIINSDATE;
	}

	/**
	 * �����ȡ��
	 * @return syscoding �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * ������趨
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * �����ȡ��
	 * @return ename �����
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * ������趨
	 * @param ename �����
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
}
