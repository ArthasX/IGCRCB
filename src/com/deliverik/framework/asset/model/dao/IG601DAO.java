package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ������ͼDAO�ӿ�
 * 
 * @author 
 */
public interface IG601DAO extends BaseHibernateDAO<IG601Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG601SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG601Info> findByCond(final IG601SearchCond cond, final int start, final int count);
}
