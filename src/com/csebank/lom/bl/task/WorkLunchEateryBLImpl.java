/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.csebank.lom.model.dao.WorkLunchEateryDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ʳ�óɱ���Ϣҵ���߼��ӿ�ʵ��
 */
public class WorkLunchEateryBLImpl extends BaseBLImpl implements WorkLunchEateryBL {
	
	/** WorkLunchEatery DAO */
	protected WorkLunchEateryDAO workLunchEateryDAO;
	
	public void setWorkLunchEateryDAO(
			WorkLunchEateryDAO workLunchEateryDAO) {
		this.workLunchEateryDAO = workLunchEateryDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkLunchEatery> searchWorkLunchEatery(WorkLunchEaterySearchCond cond, int start, int count){
		
		return workLunchEateryDAO.findByCond(cond,start,count);
	}

}
