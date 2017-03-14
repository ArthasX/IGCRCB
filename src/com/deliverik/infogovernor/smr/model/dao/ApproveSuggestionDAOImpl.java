/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCond;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
  * ����: ���������DAOʵ��
  * ��������: ���������DAOʵ��
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ApproveSuggestionDAOImpl extends
		BaseHibernateDAOImpl<ApproveSuggestionInfo> implements ApproveSuggestionDAO {

	/**
	 * ���캯��
	 */
	public ApproveSuggestionDAOImpl(){
		super(ApproveSuggestionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ApproveSuggestionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ApproveSuggestionInfo findByPK(Serializable pk) {
		ApproveSuggestionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ApproveSuggestionSearchCond cond){
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
	public List<ApproveSuggestionInfo> findByCond(final ApproveSuggestionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ApproveSuggestionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������
		if(cond.getPrid_eq() != null && cond.getPrid_eq() != 0){
			c.add(Expression.eq("prid", cond.getPrid_eq()));
		}
		
		//���״̬
		if(StringUtils.isNotEmpty(cond.getPidid_eq())){
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		
		//���״̬
		if(StringUtils.isNotEmpty(cond.getStatus_eq())){
			c.add(Expression.eq("status", cond.getStatus_eq()));
		}
		
		//���״̬
		if(StringUtils.isNotEmpty(cond.getPsdcode_eq())){
			c.add(Expression.eq("psdcode", cond.getPsdcode_eq()));
		}
		//���ʽ���к�
		if(StringUtils.isNotEmpty(cond.getRownumber_eq())){
			c.add(Expression.eq("rownumber", cond.getRownumber_eq()));
		}
		return c;
	}

}