/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.OrganizationServiceVWInfo;
import com.deliverik.infogovernor.svc.model.condition.OrganizationServiceSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ŷ���ͳ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface OrganizationServiceBL extends BaseBL{

	/**
	 * ͳ�����ݼ���
	 * @param cond ��������
	 * @return
	 */
	public List<OrganizationServiceVWInfo> searchOrganizationService(OrganizationServiceSearchCond cond);
}
