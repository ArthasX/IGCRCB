/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Ƽ�����ͳ�Ʒ���BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ScienceOperationReportBL extends BaseBL{

	/**
	 * ���ձ�ֵ��ѯ����ֵ��ռ������
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(ScienceOperationReportSearchCond cond);
}
