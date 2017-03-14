/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.prr.model.EntityItemTempInfo;
import com.deliverik.infogovernor.prr.model.condition.EntityItemTempSearchCond;
import com.deliverik.infogovernor.prr.model.entity.EntityItemTempTB;

/**
  * ����: ������ʱ�豸��Ϣ��DAOʵ��
  * ��������: ������ʱ�豸��Ϣ��DAOʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class EntityItemTempDAOImpl extends BaseHibernateDAOImpl<EntityItemTempInfo> implements EntityItemTempDAO {

	/**
	 * ���캯��
	 */
	public EntityItemTempDAOImpl(){
		super(EntityItemTempTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EntityItemTempInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EntityItemTempInfo findByPK(Serializable pk) {
		EntityItemTempInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EntityItemTempSearchCond cond){
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
	public List<EntityItemTempInfo> findByCond(final EntityItemTempSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EntityItemTempSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ͬ���
		if( StringUtils.isNotEmpty(cond.getEitConNum())){
			c.add(Expression.eq("eitConNum", cond.getEitConNum()));
		}
		if( StringUtils.isNotEmpty(cond.getEitBClass())){
			c.add(Expression.eq("eitBClass", cond.getEitBClass()));
		}
		if( null != cond.getPrid()){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		return c;
	}

}