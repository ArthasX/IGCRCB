/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.ServiceTopFiveVWInfo;
import com.deliverik.infogovernor.svc.model.condition.ServiceTopFiveSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���topͳ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ServiceTopFiveVWBL extends BaseBL{

	/**
	 * ͳ�����ݲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<ServiceTopFiveVWInfo> searchServiceDate(ServiceTopFiveSearchCond cond);
}
