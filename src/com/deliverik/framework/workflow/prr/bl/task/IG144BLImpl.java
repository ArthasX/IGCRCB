package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG019SearchCond;
import com.deliverik.framework.workflow.prr.model.dao.IG144DAO;

/**
 * <p>
 * �¼��ͷ����������̻���ͳ��ҵ���߼�ʵ��
 * </p>
 */
public class IG144BLImpl extends BaseBLImpl implements IG144BL{
	
	/**�¼��ͷ����������̻���ͳ�Ʋ���*/
	protected IG144DAO ig144DAO;
	
	/**
	 * �����¼��ͷ����������̻���ͳ�Ʋ���
	 * @param ig144DAO Ig144DAO
	 */
	public void setIg144DAO(IG144DAO ig144DAO) {
		this.ig144DAO = ig144DAO;
	}

	/**
	 * �¼����̻���ͳ��
	 * 
	 * @return �¼����̻���ͳ���б�
	 */
	
	public List<IG500Info> searchIG019Info(final IG019SearchCond cond, final int start, final int count) {
		return ig144DAO.findIncidentByCond(cond, start, count);
	}
	
	/**
	 * �¼����̻���ͳ�Ƹ���
	 * 
	 * @return �¼����̻���ͳ�Ƹ���
	 */
	public int getIG019Info(IG019SearchCond cond) {
		return ig144DAO.getIncidentSearchCount(cond);
	}
	
	/**
	 * �����������̻���ͳ��
	 * 
	 * @return �����������̻���ͳ���б�
	 */
	
	public List<IG500Info> searchServiceRequest(final IG019SearchCond cond, final int start, final int count) {
		return ig144DAO.findServiceRequestByCond(cond, start, count);
	}

	/**
	 * �����������̻���ͳ�Ƹ���
	 * 
	 * @return �����������̻���ͳ�Ƹ���
	 */
	public int getServiceRequestSearchCount(IG019SearchCond cond) {
		return ig144DAO.getServiceRequestSearchCount(cond);
	}
	
	

}
