/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeBL extends BaseBL{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(IncidentTypeSearchCond cond);
}
