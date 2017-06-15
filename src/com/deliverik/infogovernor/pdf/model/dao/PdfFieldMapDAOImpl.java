/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapTB;

/**
  * ����: PDF���������̱�ӳ���DAOʵ��
  * ��������: PDF���������̱�ӳ���DAOʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class PdfFieldMapDAOImpl extends
		BaseHibernateDAOImpl<PdfFieldMapInfo> implements PdfFieldMapDAO {

	/**
	 * ���캯��
	 */
	public PdfFieldMapDAOImpl(){
		super(PdfFieldMapTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfFieldMapInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfFieldMapInfo findByPK(Serializable pk) {
		PdfFieldMapInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfFieldMapSearchCond cond){
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
	public List<PdfFieldMapInfo> findByCond(final PdfFieldMapSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(PdfFieldMapSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	    if (StringUtils.isNotEmpty(cond.getPdid())) {
	        c.add(Expression.eq("pdid", cond.getPdid()));
	    }
	    if (StringUtils.isNotEmpty(cond.getFormtype())) {
	        c.add(Expression.eq("formtype", cond.getFormtype()));
	    }
		return c;
	}

}