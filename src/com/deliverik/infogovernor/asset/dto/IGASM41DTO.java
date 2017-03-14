/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ��ҵ����DTO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGASM41DTO extends BaseDTO implements Serializable{
	
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
