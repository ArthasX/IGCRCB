/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;


/**
 * <p>
 * Ԥ�㼰���̷�����Ϣ��ͼҵ���߼��ӿ�
 * </p>
 */

public interface PbsummaryVWBL extends BaseBL{
	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼͳ��
	 * 
	 * @return Ԥ�㼰���̷�����Ϣ��ͼͳ���б�
	 */	
	public List<Pbsummary> searchPbsummary(final PbsummaryVWSearchCond cond, final int start, final int count);
}
