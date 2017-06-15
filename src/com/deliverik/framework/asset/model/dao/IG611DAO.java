/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
  * ����: �ʲ�ģ������ȱʡֵDAO�ӿ�
  * ��������: �ʲ�ģ������ȱʡֵDAO�ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public interface IG611DAO extends BaseHibernateDAO<IG611Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG611Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG611Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG611SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG611Info> findByCond(
			final IG611SearchCond cond, final int start,
			final int count);
	
	/**
	 * �ʲ�����Ĭ��ֵȡ��
	 * 
	 * @param cond ��������
	 * @return �ʲ�����Ĭ��ֵ
	 */
	public  List<IG612Info> searchDefaultValue(final IG611SearchCond cond);
	
	/**
	 * �ʲ����Գ��ڻ���ѯ
	 * 
	 * @param cond ��������
	 * @return �ʲ�����
	 */
	public  List<IG612Info> searchDefaultLabel(final IG611SearchCond cond);

}