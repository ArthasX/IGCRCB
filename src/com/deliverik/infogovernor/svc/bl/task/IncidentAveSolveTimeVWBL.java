/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentAveSolveTimeSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�ƽ�����ʱ��ͳ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentAveSolveTimeVWBL extends BaseBL{

	/**
	 * ͳ�����ݲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<IncidentAveSolveTimeVWInfo> searchSolveTimeData(IncidentAveSolveTimeSearchCond cond);
}
