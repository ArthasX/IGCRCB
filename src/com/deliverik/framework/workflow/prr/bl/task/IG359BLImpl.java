package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG359Info;
import com.deliverik.framework.workflow.prr.model.condition.IG359SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG359DAO;

/**
 * <p>
 * ����ʲ�����ͳ�ƻ���ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG359BLImpl extends BaseBLImpl implements IG359BL{
	
	/**����ʲ�����ͳ�ƻ���ͳ�Ʋ���*/
	protected IG359DAO ig359DAO;
	
	/**
	 * ��������ʲ�����ͳ�ƻ���ͳ�Ʋ���
	 * @param ig359DAO Ig359DAO
	 */
	public void setIg359DAO(IG359DAO ig359DAO) {
		this.ig359DAO = ig359DAO;
	}

	/**
	 * ����ʲ�����ͳ�ƻ���ͳ��
	 * 
	 * @return ����ʲ�����ͳ�ƻ���ͳ���б�
	 */
	
	public List<IG359Info> searchIG359Info(final IG359SearchCond cond, final int start, final int count) {
		return ig359DAO.findByCond(cond, start, count);
	}

}
