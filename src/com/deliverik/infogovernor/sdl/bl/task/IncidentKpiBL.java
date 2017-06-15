/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.IncidentKpi;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_�¼�KPIͳ�ƽӿ�
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public interface IncidentKpiBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: �¼�KPIͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<IncidentKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<IncidentKpi> searchIncidentKpi(IncidentKpiSearchCond cond,int start, int count);
	
}
