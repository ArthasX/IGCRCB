/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCond;
import com.deliverik.infogovernor.sym.model.entity.CustomReportTB;
/**
 * 
 * @Description:订制报表实体DAO实现类
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("deprecation")
public class CustomReportDAOImpl extends BaseHibernateDAOImpl<CustomReport> implements CustomReportDAO {

	/**
	 * 构造函数
	 */
	public CustomReportDAOImpl(){
		super(CustomReportTB.class);
	}
	
	/**
	 *	查找所有
	 * @return 
	 */
	public List<CustomReport> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		List<CustomReport> ret = findByCriteria(c);
		return ret;
	}

	/**
	 *	按主键查找
	 * @param hpid
	 * @return 
	 */
	public CustomReport findByPK(Serializable crid){
		CustomReport hacProcess = super.findByPK(crid);
		if(hacProcess == null) return null;
		return hacProcess;
	}

	/**
	 *	按条件查找
	 * @return 
	 */
	public List<CustomReport> findByCond(final CustomReportSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ordernum"));
		List<CustomReport> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	public int getSearchCount(final CustomReportSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	protected DetachedCriteria getCriteria(CustomReportSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if( !StringUtils.isEmpty(cond.getUserid())){
			c.add(Restrictions.eq("userid", cond.getUserid()));
		}	
		if( cond.getRfdid()!=null&&cond.getRfdid()!=0){
			c.add(Restrictions.eq("rfdid", cond.getRfdid()));
		}
		if( cond.getOrdernum()!=null&&cond.getOrdernum()!=0){
			c.add(Restrictions.eq("ordernum", cond.getOrdernum()));
		}
		return c;
	}

}
