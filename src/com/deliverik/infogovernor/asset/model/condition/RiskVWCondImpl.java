/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class RiskVWCondImpl implements RiskVWCond {
	/** ��������*/
	protected String riskly;
	
	/** ��������*/
	protected String riskarea;
	
	/** ������*/
	protected String riskitem;
	
	/** ���յ㣨���㣩*/
	protected String einame;
	
	/** ���صȼ�*/
	protected String grad;
	
	/** ����������*/
	protected String poss;
	
	/** ���ռ���*/
	protected String levels;
	
	/** ���յ��־*/
	protected String risksign;

	/**
	 * ��������ȡ��
	 * @return riskly ��������
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * ���������趨
	 * @param riskly ��������
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * ��������ȡ��
	 * @return riskarea ��������
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * ���������趨
	 * @param riskarea ��������
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * ������ȡ��
	 * @return riskitem ������
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * �������趨
	 * @param riskitem ������
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}

	/**
	 * ���յ㣨���㣩ȡ��
	 * @return einame ���յ㣨���㣩
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * ���յ㣨���㣩�趨
	 * @param einame ���յ㣨���㣩
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * ���صȼ�ȡ��
	 * @return grad ���صȼ�
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * ���صȼ��趨
	 * @param grad ���صȼ�
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}

	/**
	 * ����������ȡ��
	 * @return poss ����������
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * �����������趨
	 * @param poss ����������
	 */
	public void setPoss(String poss) {
		this.poss = poss;
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
	 * ���յ��־ȡ��
	 * @return risksign ���յ��־
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * ���յ��־�趨
	 * @param risksign ���յ��־
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}
}
