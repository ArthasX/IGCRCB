/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
  * ����: ������������־DAOʵ��
  * ��������: ������������־DAOʵ��
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public class InitiateChangLogDAOImpl extends
		BaseHibernateDAOImpl<InitiateChangLogInfo> implements InitiateChangLogDAO {

	/**
	 * ���캯��
	 */
	public InitiateChangLogDAOImpl(){
		super(InitiateChangLogTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InitiateChangLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InitiateChangLogInfo findByPK(Serializable pk) {
		InitiateChangLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InitiateChangLogSearchCond cond){
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
	public List<InitiateChangLogInfo> findByCond(final InitiateChangLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(InitiateChangLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		/**�������ID��Ϊ�� �� ������ID*/
		if(cond.getPrid()!=0 ){
			c.add(Restrictions.eq("prid", cond.getPrid()));
		}
		return c;
	}

}