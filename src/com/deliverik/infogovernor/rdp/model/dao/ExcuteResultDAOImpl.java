/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;

/**
  * ����: ExcuteResultDAOʵ��
  * ��������: ExcuteResultDAOʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ExcuteResultDAOImpl extends
		BaseHibernateDAOImpl<ExcuteResultInfo> implements ExcuteResultDAO {

	/**
	 * ���캯��
	 */
	public ExcuteResultDAOImpl(){
		super(ExcuteResultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ExcuteResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ExcuteResultInfo findByPK(Serializable pk) {
		ExcuteResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ExcuteResultSearchCond cond){
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
	public List<ExcuteResultInfo> findByCond(final ExcuteResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ExcuteResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTaskID_eq() != null){
			c.add(Expression.eq("taskid",cond.getTaskID_eq()));
		}
		return c;
	}

}