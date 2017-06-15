package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG160DAO;

/**
 * <p>
 * ���������Ա����ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG160BLImpl extends BaseBLImpl implements IG160BL{
	
	/**���������Ա����ͳ�Ʋ���*/
	protected IG160DAO ig160DAO;
	
	/**
	 * �������������Ա����ͳ�Ʋ���
	 * @param ig160DAO IG160DAO
	 */
	public void setIg160DAO(IG160DAO ig160DAO) {
		this.ig160DAO = ig160DAO;
	}

	/**
	 * ���������Ա����ͳ��
	 * 
	 * @return ���������Ա����ͳ���б�
	 */
	
	public List<IG160Info> searchIG160Info(final IG160SearchCond cond, final int start, final int count) {
		return ig160DAO.findByCond(cond, start, count);
	}

}
