/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_ͳ�ƽӿ�
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlYearSummaryBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<SdlYearSummary>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlYearSummary> searchSdlYearSummary(SdlYearSummarySearchCond cond, int start, int count);
	
}
