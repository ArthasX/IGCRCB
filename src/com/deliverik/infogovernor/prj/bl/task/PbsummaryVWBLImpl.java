/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;
import com.deliverik.infogovernor.prj.model.dao.PbsummaryVWDAO;


/**
 * <p>
 * Ԥ�㼰���̷�����Ϣ��ͼҵ���߼�ʵ��
 * </p>
 */
public class PbsummaryVWBLImpl extends BaseBLImpl implements PbsummaryVWBL{
	
	/**Ԥ�㼰���̷�����Ϣ��ͼDAO*/
	protected PbsummaryVWDAO pbsummaryVWDAO;

	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼDAO�趨
	 * @param pbsummaryVWDAO Ԥ�㼰���̷�����Ϣ��ͼDAO
	 */
	public void setPbsummaryVWDAO(PbsummaryVWDAO pbsummaryVWDAO) {
		this.pbsummaryVWDAO = pbsummaryVWDAO;
	}
	
	/**
	 * Ԥ�㼰���̷�����Ϣ��ͼͳ��
	 * 
	 * @return Ԥ�㼰���̷�����Ϣ��ͼͳ���б�
	 */	
	public List<Pbsummary> searchPbsummary(final PbsummaryVWSearchCond cond, final int start, final int count) {
		return pbsummaryVWDAO.findByCond(cond, start, count);
	}
}
