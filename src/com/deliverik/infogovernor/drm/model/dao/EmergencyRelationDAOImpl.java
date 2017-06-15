/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EmergencyRelationTB;

/**
 * ���̹�ϵʵ��DAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class EmergencyRelationDAOImpl extends BaseHibernateDAOImpl<EmergencyRelationInfo> implements EmergencyRelationDAO {

	/** EmergencyRelation DAO */
	protected EmergencyRelationDAO EmergencyRelationDAO;
	/**
	 * ���캯��
	 */
	public EmergencyRelationDAOImpl(){
		super(EmergencyRelationTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<EmergencyRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("prrid"));
		List<EmergencyRelationInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param prrid ����
	 * @return �������
	 */
	public EmergencyRelationInfo findByPK(Serializable prrid) {

		EmergencyRelationInfo result = super.findByPK(prrid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyRelationSearchCond cond){
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
	public List<EmergencyRelationInfo> findByCond(final EmergencyRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("erid"));
		List<EmergencyRelationInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EmergencyRelationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��������ID
		if(cond.getParprid() != null && cond.getParprid() > 0){
			c.add(Expression.eq("parprid", cond.getParprid()));
		}
		//��������ID
		if(cond.getCldprid() != null && cond.getCldprid() > 0){
			c.add(Expression.eq("cldprid", cond.getCldprid()));
		}
		//������ϵ
		if(StringUtils.isNotBlank(cond.getRelatetype())){
			c.add(Restrictions.eq("relatetype", cond.getRelatetype()));
		}
		return c;
	}

}
