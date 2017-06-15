package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * �豸��ͼDAO�ӿ�
 * 
 * @author 
 */
public interface IG912DAO extends BaseHibernateDAO<IG912Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG912SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG912Info> findByCond(final IG912SearchCond cond, final int start, final int count);
}
