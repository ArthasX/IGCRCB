package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG019Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG019DAO;

/**
 * <p>
 * �¼��ͷ����������̻���ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG019BLImpl extends BaseBLImpl implements IG019BL{
	
	/**�¼��ͷ����������̻���ͳ�Ʋ���*/
	protected IG019DAO ig019DAO;
	
	/**
	 * �����¼��ͷ����������̻���ͳ�Ʋ���
	 * @param ig019DAO Ig019DAO
	 */
	public void setIg019DAO(IG019DAO ig019DAO) {
		this.ig019DAO = ig019DAO;
	}

	/**
	 * �¼��ͷ����������̻���ͳ��(����������)
	 * 
	 * @return �¼��ͷ����������̻���ͳ���б�
	 * @throws BLException
	 */
	
	public List<IG019Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count) {
		return ig019DAO.findByCond(cond, start, count);
	}

	/**
	 * �¼��ͷ����������̻���ͳ�Ƹ���(����������)
	 * 
	 * @return �¼��ͷ����������̻���ͳ�Ƹ���
	 */
	public int getIG019Info(IG019SearchCond cond) {
		return ig019DAO.getSearchCount(cond);
	}
	
	

}
