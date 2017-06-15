package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;



/**
 * �ʲ���������Ϣ��ͼDAO�ӿ�
 * 
 */
public interface SOC0129DAO extends BaseHibernateDAO<SOC0129Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0129SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0129Info> findByCond(final SOC0129SearchCond cond, final int start, final int count);
	
	
	public  List<SOC0129Info> findByCond(final SOC0129SearchCond cond);
	
	/**
	 * �������ʲ���ѯ
	 * @param cond
	 * @return
	 */
	public List<SOC0129Info> findSoc0129ByCond(final SOC0129SearchCond cond);
	
	/**
	 * ������������  �����ʲ�ר��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0129Info> findByCondSoc0109(final SOC0129SearchCond cond, final int start, final int count);
}
