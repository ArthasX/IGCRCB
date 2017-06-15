/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���DAOʵ��
  * ��������: PDF����XML�б��ʽ���ڵ㶨���DAOʵ��
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class PdfTableNodeDAOImpl extends
		BaseHibernateDAOImpl<PdfTableNodeInfo> implements PdfTableNodeDAO {

	/**
	 * ���캯��
	 */
	public PdfTableNodeDAOImpl(){
		super(PdfTableNodeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PdfTableNodeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PdfTableNodeInfo findByPK(Serializable pk) {
		PdfTableNodeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PdfTableNodeSearchCond cond){
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
	public List<PdfTableNodeInfo> findByCond(final PdfTableNodeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("nodetype"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(PdfTableNodeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid())) {
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		if (StringUtils.isNotEmpty(cond.getDatabinding())) {
			c.add(Expression.eq("databinding", cond.getDatabinding()));
		}
		if (StringUtils.isNotEmpty(cond.getPdatabinding())) {
			c.add(Expression.eq("pdatabinding", cond.getPdatabinding()));
		}
		if (StringUtils.isNotEmpty(cond.getNodetype())) {
			c.add(Expression.eq("nodetype", cond.getNodetype()));
		}
		return c;
	}

}