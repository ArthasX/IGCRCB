/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyPlan;

/**
 * ֵ�������߼��ӿ�
 */
public class IGDUT02062VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ�������������
	 */
	protected DutyPlan dutyPlan;
	
	protected String name;

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}

	/**
	 * ֵ�������趨
	 * @param dutyPlan ֵ������
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
