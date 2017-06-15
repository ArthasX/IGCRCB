package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCond;

/**
 * ������ϢDAO�ӿ�
 * 
 */
public interface CodeDetailTBDAO extends BaseHibernateDAO<CodeDetail> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeDetail> findAll();

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetail findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeDetailSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond, 
			final int start, final int count,int orderbyFlag);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeDetail> findByCond(final CodeDetailSearchCond cond,int orderbyFlag);

	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(final String ccid);
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid);
	
}
