/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;



/**
 * �ʲ���������Ϣ��ͼDAO�ӿ�
 * 
 */
public interface SOC0606DAO extends BaseHibernateDAO<SOC0606Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0606SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0606Info> findByCond(final SOC0606SearchCond cond, final int start, final int count);
	
	public  List<SOC0606Info> findByCond(final SOC0606SearchCond cond);
	
	public  List<SOC0606Info> initFindByCond(final SOC0606SearchCond cond) ;
}
