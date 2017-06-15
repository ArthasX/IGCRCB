/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ��������ʵ��DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG111DAO extends BaseHibernateDAO<IG111Info>{

	/**
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼҳ��
	 * @param count ÿҳ����
	 * @return �������
	 */
	public List<IG111Info> findByCond(IG111SearchCond cond, int start, int count);
	
	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 */
	public String getNextId(String pdid);

	/**
	 * �������̶���idɾ�� �Զ����ѯ����
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid);
}
