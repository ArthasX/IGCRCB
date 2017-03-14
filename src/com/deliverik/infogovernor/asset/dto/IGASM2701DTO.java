package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

@SuppressWarnings("serial")
public class IGASM2701DTO extends BaseDTO{

	/**���ռ���ȡֵ��Χ����*/
	protected List<SOC0151Info> levelList;

	/**���յȼ�ȡֵ��Χ����*/
	protected List<SOC0151Info> gradeList;
	
	/**���յ��ʲ�FORM*/
	protected IGASM2713Form Igasm2713form;
	
	/**���յ��ѯ����*/
	private  List<RiskPointVMInfo> riskList;
	
	/** �����ѯ������¼�� */
	protected int maxSearchCount;

	/** ��ҳBean */
	protected PagingDTO pagingDto;
	
		
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
	 * igasm2713formȡ��
	 * @return igasm2713form igasm2713form
	 */
	public IGASM2713Form getIgasm2713form() {
		return Igasm2713form;
	}

	/**
	 * igasm2713form�趨
	 * @param igasm2713form igasm2713form
	 */
	public void setIgasm2713form(IGASM2713Form igasm2713form) {
		Igasm2713form = igasm2713form;
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
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

}
