/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;

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

public interface SdlSummaryBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: ͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<SdlSummary>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlSummary> searchSdlSummary(SdlSummarySearchCond cond, int start, int count);
	
}
