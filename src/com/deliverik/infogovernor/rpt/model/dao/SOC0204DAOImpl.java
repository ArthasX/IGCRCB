/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0204Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0204SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0204TB;

/**
  * ����: �����Զ�����DAOʵ��
  * ��������: �����Զ�����DAOʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 2012/08/10 ��ReportCustomLinkDAOImpl�����޸�ΪSOC0204DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0204DAOImpl extends
		BaseHibernateDAOImpl<SOC0204Info> implements SOC0204DAO {

	/**
	 * ���캯��
	 */
	public SOC0204DAOImpl(){
		super(SOC0204TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0204Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0204Info findByPK(Serializable pk) {
		SOC0204Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0204SearchCond cond){
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
	public List<SOC0204Info> findByCond(final SOC0204SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getRclReportType_eq())){
	    	   c.add(Expression.eq("rclReportType", cond.getRclReportType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclObjName_eq())){
	    	   c.add(Expression.eq("rclObjName", cond.getRclObjName_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclTemName_eq())){
	    	   c.add(Expression.eq("rclTemName", cond.getRclTemName_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclTemDesc_eq())){
	    	   c.add(Expression.eq("rclTemDesc", cond.getRclTemDesc_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclRfdTitle_eq())){
	    	   c.add(Expression.eq("rclRfdTitle", cond.getRclRfdTitle_eq()));
	    }
		if(cond.getRclObjEiid_eq()!=null){
	    	   c.add(Expression.eq("rclObjEiid", cond.getRclObjEiid_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclObjType_eq())){
	    	   c.add(Expression.eq("rclObjType", cond.getRclObjType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclMode_eq())){
	    	   c.add(Expression.eq("rclMode", cond.getRclMode_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclCaType_eq())){
	    	   c.add(Expression.eq("rclCaType", cond.getRclCaType_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclMenuDefault_eq())){
	    	   c.add(Expression.eq("rclMenuDefault", cond.getRclMenuDefault_eq()));
	    }
		if(StringUtils.isNotEmpty(cond.getRclUserId_eq())){
	    	   c.add(Expression.eq("rclUserId", cond.getRclUserId_eq()));
	    }
		c.addOrder(Order.desc("rclObjType"));
		c.addOrder(Order.desc("rclTemName"));
		c.addOrder(Order.desc("rclCaType"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0204SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}