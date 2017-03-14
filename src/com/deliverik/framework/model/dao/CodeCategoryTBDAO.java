package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;

/**
 * ���ݷ�����ϢDAO�ӿ�
 * 
 */
public interface CodeCategoryTBDAO extends BaseHibernateDAO<CodeCategoryInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeCategoryInfo> findAll();

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public CodeCategoryInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeCategorySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeCategoryInfo> findByCond(final CodeCategorySearchCond cond, final int start, final int count);

}
