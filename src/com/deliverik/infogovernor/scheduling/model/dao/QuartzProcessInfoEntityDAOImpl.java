/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;
import com.deliverik.infogovernor.scheduling.model.entity.QuartzProcessInfoEntityTB;

/**
 * 
 * �����ʲ���ϵDAO�ӿ�ʵ��
 *
 */
@SuppressWarnings("deprecation")
public class QuartzProcessInfoEntityDAOImpl extends BaseHibernateDAOImpl<QuartzProcessInfoEntity> implements QuartzProcessInfoEntityDAO {
	

	/**
	 * ���캯��
	 */
	public QuartzProcessInfoEntityDAOImpl(){
		super(QuartzProcessInfoEntityTB.class);
	}
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<QuartzProcessInfoEntity> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qpieid"));
		List<QuartzProcessInfoEntity> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * ������������
	 * @param pieid ����
	 * @return �������
	 */
	public QuartzProcessInfoEntity findByPK(Serializable qpieid){
		
		QuartzProcessInfoEntity quartzProcessInfoEntity = super.findByPK(qpieid);
		
		if(quartzProcessInfoEntity == null) return null;

		return quartzProcessInfoEntity;
	}	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final QuartzProcessInfoEntitySearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<QuartzProcessInfoEntity> findByCond(final QuartzProcessInfoEntitySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<QuartzProcessInfoEntity> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(QuartzProcessInfoEntitySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		
		if( cond.getQprid() != null && cond.getQprid() != 0){
			c.add(Expression.eq("qprid", cond.getQprid()));
		}
		
		return c;
	}
}
