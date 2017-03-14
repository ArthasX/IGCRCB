/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EvaluationContentInfo;
import com.deliverik.infogovernor.drm.model.condition.EvaluationContentSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EvaluationContentTB;

/**
  * ����: ��Ŀ�ܱ���Ա������DAOʵ��
  * ��������: ��Ŀ�ܱ���Ա������DAOʵ��
  * ������¼: 2016/08/11
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EvaluationContentDAOImpl extends
		BaseHibernateDAOImpl<EvaluationContentInfo> implements EvaluationContentDAO {

	/**
	 * ���캯��
	 */
	public EvaluationContentDAOImpl(){
		super(EvaluationContentTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EvaluationContentInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EvaluationContentInfo findByPK(Serializable pk) {
		EvaluationContentInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EvaluationContentSearchCond cond){
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
	public List<EvaluationContentInfo> findByCond(final EvaluationContentSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EvaluationContentSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(cond.getPsdid()!=null&&!cond.getPsdid().isEmpty()){
			c.add(Expression.eq("psdid",cond.getPsdid()));
		}
		if(cond.getSortId()!=null){
			c.add(Expression.eq("sortId",cond.getSortId()));
		}
		if(cond.getFlowType()!=null){
			c.add(Expression.eq("flowType",cond.getFlowType()));
		}
		c.addOrder(Order.asc("sortId"));
		return c;
	}

}