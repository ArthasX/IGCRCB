/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ���յ��ѯ��������ʵ��
  * ��������: ���յ��ѯ��������ʵ��
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public class RiskPointVMSearchCondImpl implements
		RiskPointVMSearchCond {
	/**��������*/
	protected String einame;
	
	/**���ռ���*/
	protected String levels;
	
	/**���յȼ�*/
	protected String grad;
	
	/**������*/
	protected String mguserid;
	
	/**�Ǽǿ�ʼ*/
	protected String startdate;
	
	/**�ȼ�����*/
	protected String enddate;
	
	/**�����*/
	protected String syscoding;
	/**���ձ�־*/
	protected String risksign;
	
	/**���ձ��*/
	protected String eilabel;
	
	/**���շ�������*/
	protected String poss;
	
	/**��������EIID*/
	protected String eiid;

	/**
	 * ��������EIIDȡ��
	 * @return eiid ��������EIID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * ��������EIID�趨
	 * @param eiid ��������EIID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * ������ȡ��
	 * @return mguserid ������
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * �������趨
	 * @param mguserid ������
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * �Ǽǿ�ʼȡ��
	 * @return startdate �Ǽǿ�ʼ
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * �Ǽǿ�ʼ�趨
	 * @param startdate �Ǽǿ�ʼ
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * �ȼ�����ȡ��
	 * @return enddate �ȼ�����
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * �ȼ������趨
	 * @param enddate �ȼ�����
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
	 * ���ձ��ȡ��
	 * @return eilabel ���ձ��
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * ���ձ���趨
	 * @param eilabel ���ձ��
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * ���շ�������ȡ��
	 * @return poss ���շ�������
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * ���շ��������趨
	 * @param poss ���շ�������
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * ��������ȡ��
	 * @return einame ��������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���ռ���ȡ��
	 * @return levels ���ռ���
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * ���յȼ�ȡ��
	 * @return grad ���յȼ�
	 */
	public String getGrad() {
		return grad;
	}


	/**
	 * �����ȡ��
	 * @return syscoding �����
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * ���������趨
	 * @param einame ��������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���ռ����趨
	 * @param levels ���ռ���
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * ���յȼ��趨
	 * @param grad ���յȼ�
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}



	/**
	 * ������趨
	 * @param syscoding �����
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
}