/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.soc.vir.dto;

import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ����ͳ�Ƶ���DTO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR1401ExcelDTO extends ExcelDTO{

	/** ��Դ����ͳ��Map */
	protected Map<String, Integer[]> vmApplyStatisticsDataMap;

	/**
	 * ��Դ����ͳ��Mapȡ��
	 * @return vmApplyStatisticsDataMap ��Դ����ͳ��Map
	 */
	public Map<String, Integer[]> getVmApplyStatisticsDataMap() {
		return vmApplyStatisticsDataMap;
	}

	/**
	 * ��Դ����ͳ��Map�趨
	 * @param vmApplyStatisticsDataMap ��Դ����ͳ��Map
	 */
	public void setVmApplyStatisticsDataMap(
			Map<String, Integer[]> vmApplyStatisticsDataMap) {
		this.vmApplyStatisticsDataMap = vmApplyStatisticsDataMap;
	}
}
