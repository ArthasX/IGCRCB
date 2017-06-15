/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�Ƶ�����DTO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGASM41ExcelDTO extends ExcelDTO {
	/** ���ռ��ͳ����Ϣ������� */
	protected Map<List<RiskVWInfo>,List<CheckVWInfo>> riskCheckMap;

	/**
	 * ���ռ��ͳ����Ϣ�������ȡ��
	 * @return riskCheckMap ���ռ��ͳ����Ϣ�������
	 */
	public Map<List<RiskVWInfo>, List<CheckVWInfo>> getRiskCheckMap() {
		return riskCheckMap;
	}

	/**
	 * ���ռ��ͳ����Ϣ��������趨
	 * @param riskCheckMap ���ռ��ͳ����Ϣ�������
	 */
	public void setRiskCheckMap(
			Map<List<RiskVWInfo>, List<CheckVWInfo>> riskCheckMap) {
		this.riskCheckMap = riskCheckMap;
	}
}
