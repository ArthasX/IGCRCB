/*
 * ������������Ϣ�������޹�˾��Ȩ����,��������Ȩ��.
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;

/**
 * ֵ��������VO
 */
public class IGDUT03021VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ�������ݼ������
	 */
	private List<DutyResult> dutyResultList;
	
	/**
	 * ֵ����������ʾVO
	 */
	protected List<IGDUT02042VO> voList;
	
	/** �װ�ƻ� */
	protected DutyPlan dutyPlanAM;
	
	/** ҹ��ƻ� */
	protected DutyPlan dutyPlanPM;
	
	/**
	 * ֵ�������ݼ������ȡ��
	 * @return ֵ�������ݼ������
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ֵ�������ݼ�������趨
	 * @param dutyDataList ֵ�������ݼ������
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
		if(dutyResultList != null && dutyResultList.size() > 0) {
			voList = new ArrayList<IGDUT02042VO>();
			//�������
			String dadtype = "";
			//VO���
			int i = -1;
			for(DutyResult dr :dutyResultList) {
				if(dr.getDadtype().equals(dadtype)) {
					voList.get(i).getDutyResultList().add(dr);
				} else {
					dadtype = dr.getDadtype();
					voList.add(new IGDUT02042VO());
					voList.get(++i).setDutyResultList(new ArrayList<DutyResult>());
					voList.get(i).setDutyResult(dr);
				}
				int count = voList.get(i).getRowspanNum();
				voList.get(i).setRowspanNum(++count);
			}
		}
	}

	/**
	 * ֵ����������ʾVO
	 * @return ֵ����������ʾVO
	 */
	public List<IGDUT02042VO> getVoList() {
		return voList;
	}
	
	/**
	 * �װ�ƻ�ȡ��
	 * @return �װ�ƻ�
	 */
	public DutyPlan getDutyPlanAM() {
		return dutyPlanAM;
	}

	/**
	 * �װ�ƻ��趨
	 * @param dutyPlanAM �װ�ƻ�
	 */
	public void setDutyPlanAM(DutyPlan dutyPlanAM) {
		this.dutyPlanAM = dutyPlanAM;
	}
	
	/**
	 * ҹ��ƻ�ȡ��
	 * @return ҹ��ƻ�
	 */
	public DutyPlan getDutyPlanPM() {
		return dutyPlanPM;
	}

	/**
	 * ҹ��ƻ��趨
	 * @param dutyPlanPM ҹ��ƻ�
	 */
	public void setDutyPlanPM(DutyPlan dutyPlanPM) {
		this.dutyPlanPM = dutyPlanPM;
	}
	
}
