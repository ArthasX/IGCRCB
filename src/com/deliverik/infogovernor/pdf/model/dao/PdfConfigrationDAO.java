/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;

/**
  * ����: �����ӦBL��ģ���������ñ�DAO�ӿ�
  * ��������: �����ӦBL��ģ���������ñ�DAO�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfConfigrationDAO extends BaseHibernateDAO<PdfConfigrationInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfConfigrationInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfConfigrationInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfConfigrationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfConfigrationInfo> findByCond(
			final PdfConfigrationSearchCond cond, final int start,
			final int count);

}