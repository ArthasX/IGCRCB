package com.deliverik.framework.soc.asset.model.dao;

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

import com.deliverik.framework.soc.asset.model.dao.ConfigurationCodeDetailDAO;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;

/**
 * 资产下拉数据DAO实现
 * 
 */
@SuppressWarnings("deprecation")
public class ConfigurationCodeDetailDAOImpl extends BaseHibernateDAOImpl<ConfigurationCodeDetail> implements ConfigurationCodeDetailDAO {

	/**
	 * 构造函数
	 * 
	 */
	public ConfigurationCodeDetailDAOImpl(){
		super(ConfigurationCodeDetailTB.class);
	}

	public List<ConfigurationCodeDetail> findByCond(
			ConfigurationCodeDetailSearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
//		ProjectionList projectionList = Projections.projectionList();  
//		projectionList.add(Property.forName("ccdcategory").as("ccdcategory"));  
//		projectionList.add(Projections.property("ccdlabel").as("ccdlabel"));  
//		c.setProjection(Projections.distinct(projectionList));
		c.addOrder(Order.asc("ccdcategory"));
		c.addOrder(Order.asc("ccdid"));
		List<ConfigurationCodeDetail> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ConfigurationCodeDetailSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * 获取取值范围下拉数据
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ConfigurationCodeDetailBean> findConfigurationCodeDetailBean(final ConfigurationCodeDetailSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				String query = session.getNamedQuery("ConfigurationCodeDetailDAO.ConfigurationCodeDetail").getQueryString();
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
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ConfigurationCodeDetailSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//资产取值范围标识
		if( !StringUtils.isEmpty(cond.getCcdcategory())){
			c.add(Expression.eq("ccdcategory", cond.getCcdcategory()));
		}	
		//资产取值范围状态
		if( !StringUtils.isEmpty(cond.getCcdstatus())){
			c.add(Expression.eq("ccdstatus", cond.getCcdstatus()));
		}	
		// 资产取值范围所属应用
		if( !StringUtils.isEmpty(cond.getCcdtype())){
			c.add(Expression.eq("ccdtype", cond.getCcdtype()));
		}	
		return c;
	}
}
