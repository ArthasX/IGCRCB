/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * ����: ������ϢDAOʵ��
  * ��������: ������ϢDAOʵ��
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class WorkinfoDAOImpl extends
		BaseHibernateDAOImpl<WorkinfoInfo> implements WorkinfoDAO {

	/**
	 * ���캯��
	 */
	public WorkinfoDAOImpl(){
		super(WorkinfoTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkinfoInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkinfoInfo findByPK(Serializable pk) {
		WorkinfoInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkinfoSearchCond cond){
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
	public List<WorkinfoInfo> findByCond(final WorkinfoSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkinfoSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getWorkName()))
			c.add(Expression.like("execname","%"+ cond.getWorkName()+"%"));
		if(StringUtils.isNotEmpty(cond.getExecName()))
			c.add(Expression.like("execname","%"+ cond.getExecName()+"%"));
		if(StringUtils.isNotEmpty(cond.getInitName()))
			c.add(Expression.like("execname","%"+ cond.getInitName()+"%"));
		return c;
	}

}