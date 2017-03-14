package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG003Info;
import com.deliverik.framework.workflow.prr.model.condition.IG003SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG003DAO;

/**
 * <p>
 * ������Ȼ���ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG003BLImpl extends BaseBLImpl implements IG003BL{
	
	/**������Ȼ���ͳ�Ʋ���*/
	protected IG003DAO ig003DAO;
	
	/**
	 * ����������Ȼ���ͳ�Ʋ���
	 * @param ig003DAO ProcessSummaryVWDAO
	 */
	public void setIg003DAO(IG003DAO ig003DAO) {
		this.ig003DAO = ig003DAO;
	}

	/**
	 * ������Ȼ���ͳ��
	 * 
	 * @return ������Ȼ���ͳ���б�
	 */
	
	public List<IG003Info> searchIG003Info(final IG003SearchCond cond, final int start, final int count) {
		return ig003DAO.findByCond(cond, start, count);
	}

}
