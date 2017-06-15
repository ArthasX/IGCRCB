/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;

/**
 * ֵ�������ѯҵ���߼��ӿ�
 */
public class IGDUT01041VO extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ֵ������Ϣ�������
	 */
	protected List<DutyAuditDef> dutyAuditList;

	/**
	 * ���캯��
	 * @return ֵ������Ϣ�������
	 */
	public List<DutyAuditDef> getDutyAuditList() {
		return dutyAuditList;
	}

	/**
	 * ֵ������Ϣ�������
	 * @param dutyDataList ֵ������Ϣ�������
	 */
	public void setDutyAuditList(List<DutyAuditDef> dutyAuditList) {
		this.dutyAuditList = dutyAuditList;
	}
	
}
