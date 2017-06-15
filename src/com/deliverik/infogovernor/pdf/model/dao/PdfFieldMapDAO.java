/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;

/**
  * ����: PDF���������̱�ӳ���DAO�ӿ�
  * ��������: PDF���������̱�ӳ���DAO�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfFieldMapDAO extends BaseHibernateDAO<PdfFieldMapInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfFieldMapInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfFieldMapInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfFieldMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfFieldMapInfo> findByCond(
			final PdfFieldMapSearchCond cond, final int start,
			final int count);

}