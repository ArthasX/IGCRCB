/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���DAO�ӿ�
  * ��������: PDF����XML�б��ʽ���ڵ㶨���DAO�ӿ�
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public interface PdfTableNodeDAO extends BaseHibernateDAO<PdfTableNodeInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfTableNodeInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfTableNodeInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfTableNodeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfTableNodeInfo> findByCond(
			final PdfTableNodeSearchCond cond, final int start,
			final int count);

}