package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ���������Ϣ��ͼDAO�ӿ�
 * 
 */
public interface IG002DAO extends BaseHibernateDAO<IG002Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG002SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG002Info> findByCond(final IG002SearchCond cond, final int start, final int count);
	
	public  List<IG002Info> findByCond(final IG002SearchCond cond);
	
	public  List<IG002Info> initFindByCond(final IG002SearchCond cond) ;
}
