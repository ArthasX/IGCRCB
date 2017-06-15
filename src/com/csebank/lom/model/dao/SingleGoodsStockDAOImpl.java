/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.csebank.lom.model.entity.SingleGoodsStockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 库存统计DAO实现
 *
 */
public class SingleGoodsStockDAOImpl extends BaseHibernateDAOImpl<SingleGoodsStock> implements SingleGoodsStockDAO {

	/**
	 * 构造函数
	 */
	public SingleGoodsStockDAOImpl(){
		super(SingleGoodsStockVW.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public List<SingleGoodsStock> getSearchCount(final SingleGoodsStockSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(!StringUtils.isEmpty(cond.getGoods()) && !StringUtils.isEmpty(cond.getEtime_from()) && !StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockFTG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && StringUtils.isEmpty(cond.getEtime_from()) && StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && !StringUtils.isEmpty(cond.getEtime_from()) && StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockFG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && StringUtils.isEmpty(cond.getEtime_from()) && !StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockTG").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("SingleGoodsStock",SingleGoodsStockVW.class);
				setFetchPoint(q, 0, 0);
				List<SingleGoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SingleGoodsStock>) execute(action);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SingleGoodsStock> findByCond(final SingleGoodsStockSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(!StringUtils.isEmpty(cond.getGoods()) && !StringUtils.isEmpty(cond.getEtime_from()) && !StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockFTG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && StringUtils.isEmpty(cond.getEtime_from()) && StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && !StringUtils.isEmpty(cond.getEtime_from()) && StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockFG").getQueryString());
				}else if(!StringUtils.isEmpty(cond.getGoods()) && StringUtils.isEmpty(cond.getEtime_from()) && !StringUtils.isEmpty(cond.getEtime_to())){
					query.append(session.getNamedQuery("SingleGoodsStockDAO.singleGoodsStockTG").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("SingleGoodsStock",SingleGoodsStockVW.class);
				setFetchPoint(q, start, count);
				List<SingleGoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<SingleGoodsStock>) execute(action);
	}

}
