/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0124Info;

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
public class IGDRM18021VO extends BaseVO{
	
	/**ר��Ԥ���б�*/
	protected List<SOC0124Info> planList;

	public List<SOC0124Info> getPlanList() {
		return planList;
	}

	public void setPlanList(List<SOC0124Info> planList) {
		this.planList = planList;
	}
	
	
}
