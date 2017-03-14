/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���ѯVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP01011VO extends BaseVO{

	/** �ճ������ƻ���Ϣ���� */
	protected List<IGDWP0001Info> dayWorkPlanList;

	/**
	 * �ճ������ƻ���Ϣ����ȡ��
	 * @return dayWorkPlanList �ճ������ƻ���Ϣ����
	 */
	public List<IGDWP0001Info> getDayWorkPlanList() {
		return dayWorkPlanList;
	}

	/**
	 * �ճ������ƻ���Ϣ�����趨
	 * @param dayWorkPlanList �ճ������ƻ���Ϣ����
	 */
	public void setDayWorkPlanList(List<IGDWP0001Info> dayWorkPlanList) {
		this.dayWorkPlanList = dayWorkPlanList;
	}
}
