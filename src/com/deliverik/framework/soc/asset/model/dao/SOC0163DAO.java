package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;

/**
 * �ʲ�����ͼDAO�ӿ�
 * 
 * @author 
 */
public interface SOC0163DAO extends BaseHibernateDAO<SOC0163Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0163SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0163Info> findByCond(final SOC0163SearchCond cond, final int start, final int count);

	/**
	 * �������������豸�������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountForNetAsset(final SOC0163SearchCond cond);
	
	
	/**
	 * �������������豸����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0163Info> findByCondForNetAsset(final SOC0163SearchCond cond, final int start, final int count);
	
	
}
