/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfIg599MapVWDAO extends BaseHibernateDAO<PdfIg599MapVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg599MapVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg599MapVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfIg599MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfIg599MapVWInfo> findByCond(
			final PdfIg599MapVWSearchCond cond, final int start,
			final int count);

}