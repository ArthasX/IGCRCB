/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.condition.DeptEentertainmentSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ���ŽӴ�ͳ��DAO�ӿ�
 *
 */
public interface DeptEentertainmentDAO extends BaseHibernateDAO<DeptEentertainment> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DeptEentertainment> findByCond(final DeptEentertainmentSearchCond cond, final int start, final int count);
	
	


}
