/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;

/**
 * 
 * ����: ���յ��ѯ����ר��DTO
 * ��������: ���յ��ѯ����ר��DTO
 * �����ˣ�hujuwen
 * ������¼: 2014/07/22
 * �޸ļ�¼:
 */
public class IGASM2714ExcelDTO extends ExcelDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729726206045327987L;

	/**���յ��ѯ����*/
	public List<RiskPointVMInfo> processList;
	
	/**���յ��ѯ���� ���
	 * @return list
	 */
	public List<RiskPointVMInfo> getProcessList() {
		return processList;
	}
	
	/**���յ��ѯ���� �趨*/
	public void setProcessList(List<RiskPointVMInfo> processList) {
		this.processList = processList;
	}
	
}
