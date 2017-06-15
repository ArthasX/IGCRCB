package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;

/**
 * ���ݷ�����ϢDAO�ӿ�
 * 
 */
public interface CodeCategoryDefTBDAO extends BaseHibernateDAO<CodeCategoryDefInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeCategoryDefInfo> findAll();

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public CodeCategoryDefInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeCategoryDefSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> findByCond(final CodeCategoryDefSearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> findByCondDescCiid(final CodeCategoryDefSearchCond cond, final int start, final int count);

}
