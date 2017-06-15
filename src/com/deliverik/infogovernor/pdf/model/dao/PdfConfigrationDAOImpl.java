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
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfConfigrationTB;

/**
  * ����: �����ӦBL��ģ���������ñ�DAOʵ��
  * ��������: �����ӦBL��ģ���������ñ�DAOʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class PdfConfigrationDAOImpl extends
		BaseHibernateDAOImpl<PdfConfigrationInfo> implements PdfConfigrationDAO {

	/**
	 * ���캯��
	 */
	public PdfConfigrationDAOImpl(){
		super(PdfConfigrationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfConfigrationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfConfigrationInfo findByPK(Serializable pk) {
		PdfConfigrationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfConfigrationSearchCond cond){
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
	public List<PdfConfigrationInfo> findByCond(final PdfConfigrationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(PdfConfigrationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid())) {
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		return c;
	}

}