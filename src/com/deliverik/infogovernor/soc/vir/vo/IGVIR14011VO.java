/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ����ͳ��VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14011VO extends BaseVO{

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
