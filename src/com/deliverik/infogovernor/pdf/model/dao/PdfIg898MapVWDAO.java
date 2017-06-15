/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAO�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfIg898MapVWDAO extends BaseHibernateDAO<PdfIg898MapVWInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg898MapVWInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg898MapVWInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfIg898MapVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfIg898MapVWInfo> findByCond(
			final PdfIg898MapVWSearchCond cond, final int start,
			final int count);
	
    	/**
         * ȡ�ñ�����ͱ�������
         *
         * @param cond ��������
         * @return ��������
         */
        public String getMaxRowNumber(final PdfIg898MapVWSearchCond cond);
}