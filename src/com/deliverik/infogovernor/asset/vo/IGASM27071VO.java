package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

@SuppressWarnings("serial")
public class IGASM27071VO extends BaseVO implements Serializable{
	
	/**���ռ���ȡֵ��Χ����*/
	protected List<SOC0151Info> levelList;

	/**���յȼ�ȡֵ��Χ����*/
	protected List<SOC0151Info> gradeList;

	/**���յ������*/
	protected List<SOC0151Info> possibleList;
	/**���ձ�ʶ����*/
	protected List<SOC0151Info> signList;
	
	/**���յ��ѯ����*/
	private  List<RiskPointVMInfo> riskList;
	
	/**���յ��ѯform*/
	protected IGASM2713Form igasm2713form;
	/**
	 * ���յ��ѯformȡ��
	 * @return igasm2713form ���յ��ѯform
	 */
	public IGASM2713Form getIgasm2713form() {
		return igasm2713form;
	}

	/**
	 * ���յ��ѯform�趨
	 * @param igasm2713form ���յ��ѯform
	 */
	public void setIgasm2713form(IGASM2713Form igasm2713form) {
		this.igasm2713form = igasm2713form;
	}

	/**
	 * ���ռ���ȡֵ��Χ����ȡ��
	 * @return levelList ���ռ���ȡֵ��Χ����
	 */
	public List<SOC0151Info> getLevelList() {
		return levelList;
	}

	/**
	 * ���ռ���ȡֵ��Χ�����趨
	 * @param levelList ���ռ���ȡֵ��Χ����
	 */
	public void setLevelList(List<SOC0151Info> levelList) {
		this.levelList = levelList;
	}

	/**
	 * ���յȼ�ȡֵ��Χ����ȡ��
	 * @return gradeList ���յȼ�ȡֵ��Χ����
	 */
	public List<SOC0151Info> getGradeList() {
		return gradeList;
	}

	/**
	 * ���յȼ�ȡֵ��Χ�����趨
	 * @param gradeList ���յȼ�ȡֵ��Χ����
	 */
	public void setGradeList(List<SOC0151Info> gradeList) {
		this.gradeList = gradeList;
	}

	/**
	 * ���յ��ѯ����ȡ��
	 * @return riskList ���յ��ѯ����
	 */
	public List<RiskPointVMInfo> getRiskList() {
		return riskList;
	}

	/**
	 * ���յ��ѯ�����趨
	 * @param riskList ���յ��ѯ����
	 */
	public void setRiskList(List<RiskPointVMInfo> riskList) {
		this.riskList = riskList;
	}

	/**
	 * ���յ������ȡ��
	 * @return possibleList ���յ������
	 */
	public List<SOC0151Info> getPossibleList() {
		return possibleList;
	}

	/**
	 * ���յ�������趨
	 * @param possibleList ���յ������
	 */
	public void setPossibleList(List<SOC0151Info> possibleList) {
		this.possibleList = possibleList;
	}

	/**
	 * ���ձ�ʶ����ȡ��
	 * @return signList ���ձ�ʶ����
	 */
	public List<SOC0151Info> getSignList() {
		return signList;
	}

	/**
	 * ���ձ�ʶ�����趨
	 * @param signList ���ձ�ʶ����
	 */
	public void setSignList(List<SOC0151Info> signList) {
		this.signList = signList;
	}

}
