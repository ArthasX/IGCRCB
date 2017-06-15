package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * �ʲ�����ͼDAO�ӿ�
 * 
 * @author 
 */
public interface IG688DAO extends BaseHibernateDAO<IG688Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG688SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG688Info> findByCond(final IG688SearchCond cond, final int start, final int count);
}
