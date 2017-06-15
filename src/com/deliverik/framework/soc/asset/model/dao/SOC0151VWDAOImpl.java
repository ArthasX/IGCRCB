/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;

/**
  * 概述: SOC0151VWDAO实现
  * 功能描述: SOC0151VWDAO实现
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class SOC0151VWDAOImpl extends
		BaseHibernateDAOImpl<SOC0151VWInfo> implements SOC0151VWDAO {

	/**
	 * 构造函数
	 */
	public SOC0151VWDAOImpl(){
		super(SOC0151VW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0151VWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0151VWInfo findByPK(Serializable pk) {
		SOC0151VWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0151VWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> findByCond(final SOC0151VWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ccdcategory"));
		c.addOrder(Order.asc("ccdid"));
		List<SOC0151VWInfo> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0151VWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//资产取值范围标识
		if(cond.getId()!=null&&cond.getId()>0){
			c.add(Expression.eq("id", cond.getId()));
		}	
		if (!StringUtils.isEmpty(cond.getCcdcategory())) {
			c.add(Expression.eq("ccdcategory", cond.getCcdcategory()));
		}
		// 资产取值范围状态
		if (!StringUtils.isEmpty(cond.getCcdstatus())) {
			c.add(Expression.eq("ccdstatus", cond.getCcdstatus()));
		}
		// 资产取值范围所属应用
		if (!StringUtils.isEmpty(cond.getCcdtype())) {
			c.add(Expression.eq("ccdtype", cond.getCcdtype()));
		}
		return c;
	}

	/**
	 * 获取取值范围下拉数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final SOC0151VWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String query = session.getNamedQuery("ConfigurationCodeDetailDAO.ConfigurationCodeDetailByVW").getQueryString();
				SQLQuery q = session.createSQLQuery(query);
				q.setProperties(cond);
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				List<ConfigurationCodeDetailBean> ccdList = new ArrayList<ConfigurationCodeDetailBean>();
				for(Object[] o : list){
					ConfigurationCodeDetailBean bean = new ConfigurationCodeDetailBean();
					bean.setCcdcategory(o[0].toString());
					bean.setCcdlabel(o[1].toString());
					ccdList.add(bean);
				}
				session.clear();
				return ccdList;
			}
		};
		return (List<ConfigurationCodeDetailBean>) execute(action);
	}
}