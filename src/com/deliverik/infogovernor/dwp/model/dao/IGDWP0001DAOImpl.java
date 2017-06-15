/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dwp.model.IGDWP0001Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0001SearchCond;
import com.deliverik.infogovernor.dwp.model.entity.IGDWP0001TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���ѯDAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0001DAOImpl extends BaseHibernateDAOImpl<IGDWP0001Info> implements IGDWP0001DAO{

	/**
	 * ���캯��
	 */
	public IGDWP0001DAOImpl(){
		super(IGDWP0001TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0001SearchCond cond){
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
	public List<IGDWP0001Info> findByCond(IGDWP0001SearchCond cond,int start, int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("startdate"));
		return findByCriteria(c, start, count);
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IGDWP0001SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getStartdate_from())) {
			c.add(Restrictions.ge("startdate", cond.getStartdate_from()));
		}
		if(StringUtils.isNotEmpty(cond.getStartdate_to())){
			c.add(Restrictions.le("startdate", cond.getStartdate_to()));
		}
		if(StringUtils.isNotEmpty(cond.getIsAddJob())){
			c.add(Restrictions.eq("isAddJob", cond.getIsAddJob()));
		}
		if(StringUtils.isNotEmpty(cond.getPuserid())){
			c.add(Restrictions.eq("puserid", cond.getPuserid()));
		}
		return c;
	}
}
