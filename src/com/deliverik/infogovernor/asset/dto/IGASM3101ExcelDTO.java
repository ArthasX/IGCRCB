/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
 * 
 * ����: ����ָ���ѯ����ר��DTO
 * ��������: ����ָ���ѯ����ר��DTO
 * �����ˣ�hujuwen
 * ������¼: 2014/07/26
 * �޸ļ�¼:
 */
public class IGASM3101ExcelDTO extends ExcelDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729726206045327987L;

	/**����ָ���ѯ����*/
	public List<RiskIndexSearchVWInfo> processList;
	
	/**����ָ���ѯ���� ���
	 * @return list
	 */
	public List<RiskIndexSearchVWInfo> getProcessList() {
		return processList;
	}
	
	/**����ָ���ѯ���� �趨*/
	public void setProcessList(List<RiskIndexSearchVWInfo> processList) {
		this.processList = processList;
	}
	
}
