/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor Ӧ������
 * </p>
 * <p>
 * Description: Ԥ��ͳ��
 * </p>
 * 
 * @author zhangjian@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDRM18011VO extends BaseVO{
	
	/** Ԥ��ͳ���б� */
	protected List<Map<String,Object>> planRateList;

	/**
	 * Ԥ��ͳ���б�ȡ��
	 * @return planRateList Ԥ��ͳ���б�
	 */
	public List<Map<String, Object>> getPlanRateList() {
		return planRateList;
	}

	/**
	 * Ԥ��ͳ���б��趨
	 * @param planRateList Ԥ��ͳ���б�
	 */
	public void setPlanRateList(List<Map<String, Object>> planRateList) {
		this.planRateList = planRateList;
	}
}
