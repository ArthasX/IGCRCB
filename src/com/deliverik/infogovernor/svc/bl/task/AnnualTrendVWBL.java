/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��BL�ӿ�
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWBL extends BaseBL{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchIncidentTypeData(AnnualTrendVWSearchCond cond);
}
