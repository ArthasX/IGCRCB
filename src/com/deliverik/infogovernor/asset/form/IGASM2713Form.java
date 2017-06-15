package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGASM2713Form extends BaseForm{

	/**��������*/
	protected String einame;
	
	/**���ռ���*/
	protected String levels;
	
	/**���յȼ�*/
	protected String grad;
	
	/**������*/
	protected String managername;
	
	/**�Ǽ���*/
	protected String EIINSDATE;
	
	/**�����*/
	protected String syscoding;
	
	/**�����*/
	protected String ename;
	
	/**���*/
	protected  String eilabel;
	/** ɾ���������� */
	protected String[] deleteEiid;
	
	/**������*/
	protected String poss;
	/**������id*/
	protected String mguserid;
	/**���ձ�־*/
	protected String risksign;
	/**��ʼʱ��*/
	protected String startdate;
	/**����ʱ��*/
	protected String enddate;

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
	 * ������ȡ��
	 * @return poss ������
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * �������趨
	 * @param poss ������
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * ������idȡ��
	 * @return mguserid ������id
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * ������id�趨
	 * @param mguserid ������id
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * ���ձ�־ȡ��
	 * @return risksign ���ձ�־
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * ���ձ�־�趨
	 * @param risksign ���ձ�־
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
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
	 * ���ռ���ȡ��
	 * @return levels ���ռ���
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * ���ռ����趨
	 * @param levels ���ռ���
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * ���յȼ�ȡ��
	 * @return grad ���յȼ�
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * ���յȼ��趨
	 * @param grad ���յȼ�
	 */
	public void setGrad(String grad) {
		this.grad = grad;
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
	 * ��ʼʱ��ȡ��
	 * @return startdate ��ʼʱ��
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * ��ʼʱ���趨
	 * @param startdate ��ʼʱ��
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return enddate ����ʱ��
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * ����ʱ���趨
	 * @param enddate ����ʱ��
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
