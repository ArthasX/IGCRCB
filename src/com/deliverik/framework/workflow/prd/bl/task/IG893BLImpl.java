package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCond;
import com.deliverik.framework.workflow.prd.model.dao.IG893DAO;

/**
 * <p>
 * ���̲����߱���Ȩ����ͼҵ���߼�ʵ��
 * </p>
 */
public class IG893BLImpl extends BaseBLImpl implements IG893BL{
	
	/** ���̲����߱���Ȩ����ͼ DAO*/
	protected IG893DAO ig893DAO;
	
	/**
	 * ���̲����߱���Ȩ����ͼDAO�趨
	 * @param ig893DAO���̲����߱���Ȩ����ͼDAO
	 */
	public void setIg893DAO(IG893DAO ig893DAO) {
		this.ig893DAO = ig893DAO;
	}

	/**
	 * ��ȡ���̲����߱���Ȩ��
	 * @param cond ��������
	 * @return ���̲����߱���Ȩ���б�
	 */
	public List<IG893Info> searchIG893Info(final IG893SearchCond cond) {
		return ig893DAO.findByCond(cond);
	}
}
