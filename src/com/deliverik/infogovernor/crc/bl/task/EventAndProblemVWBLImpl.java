/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;
import com.deliverik.infogovernor.crc.model.condition.EventAndProblemVWSearchCond;
import com.deliverik.infogovernor.crc.model.dao.EventAndProblemVWDAO;

/**
 * ����: �¼����������ϲ�ѯҵ���߼�
 * ��������: �¼����������ϲ�ѯҵ���߼�
 * ������¼: 2017/08/02
 * �޸ļ�¼: 
 */
public class EventAndProblemVWBLImpl extends BaseBLImpl implements
		EventAndProblemVWBL {

	/** �������DAO�ӿ� */
	protected EventAndProblemVWDAO eventAndProblemVWDAO;
	
	
	
		
	public void setEventAndProblemVWDAO(EventAndProblemVWDAO eventAndProblemVWDAO) {
		this.eventAndProblemVWDAO = eventAndProblemVWDAO;
	}




	public List<EventAndProblemVWInfo> findByCond(
			EventAndProblemVWSearchCond cond, int start, int count) {
		return eventAndProblemVWDAO.findByCond(cond, start, count);
	}





	public int getSearchCount(EventAndProblemVWSearchCond cond) {
		return eventAndProblemVWDAO.getSearchCount(cond);
	}



}
