/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
  * ����: ���ù�����DAOʵ��
  * ��������: ���ù�����DAOʵ��
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class InternalauditJobDAOImpl extends
		BaseHibernateDAOImpl<InternalauditJobInfo> implements InternalauditJobDAO {

	/**
	 * ���캯��
	 */
	public InternalauditJobDAOImpl(){
		super(InternalauditJobTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditJobInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditJobInfo findByPK(Serializable pk) {
		InternalauditJobInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InternalauditJobSearchCond cond){
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
	public List<InternalauditJobInfo> findByCond(final InternalauditJobSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(InternalauditJobSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��������
		if(StringUtils.isNotEmpty(cond.getIajName_like())){
			c.add(Expression.like("iajname", "%" + cond.getIajName_like() + "%"));
		}
		//��ȼƻ�
		if(StringUtils.isNotEmpty(cond.getIajYear_q())){
			c.add(Expression.eq("iajyear", cond.getIajYear_q()));
		}
		//������Ŀ
		if(0 != cond.getIajIapId_q()){
			c.add(Expression.eq("iajiapid", cond.getIajIapId_q()));
		}
		return c;
	}

}