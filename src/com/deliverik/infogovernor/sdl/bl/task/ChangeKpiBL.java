/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;
import com.deliverik.infogovernor.sdl.model.condition.ChangeKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_���KPIͳ�ƽӿ�
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public interface ChangeKpiBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ���KPIͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<ChangeKpi>
	 * @author maozhipeng@deliverik.com
	 */
	public List<ChangeKpi> searchChangeKpi(ChangeKpiSearchCond cond,int start, int count);
	
}
