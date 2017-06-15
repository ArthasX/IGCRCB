/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ʾ�ж���ʵ��DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IG110DAO extends BaseHibernateDAO<IG110Info>{

	/**
	 * ��������
	 * @param cond ��������
	 * @param start 
	 * @param count
	 * @return
	 */
	public List<IG110Info> findByCond(IG110SearchCond cond, int start, int count);

	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 */
	public String getNextId(String pdid);

	/**
	 * �������̶���idɾ����ʾ��
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid);

}
