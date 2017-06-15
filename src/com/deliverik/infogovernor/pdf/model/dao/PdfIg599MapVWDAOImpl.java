/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWTB;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAOʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼDAOʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class PdfIg599MapVWDAOImpl extends
		BaseHibernateDAOImpl<PdfIg599MapVWInfo> implements PdfIg599MapVWDAO {

	/**
	 * ���캯��
	 */
	public PdfIg599MapVWDAOImpl(){
		super(PdfIg599MapVWTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfIg599MapVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfIg599MapVWInfo findByPK(Serializable pk) {
		PdfIg599MapVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfIg599MapVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PdfIg599MapVWInfo> findByCond(final PdfIg599MapVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(PdfIg599MapVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPrid()!=null&&cond.getPrid()>0) {
            c.add(Expression.eq("prid", cond.getPrid()));
        }
		c.add(Expression.isNotNull("databinding"));
		return c;
	}

}