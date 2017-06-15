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

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.entity.GoodsStockVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 库存统计DAO实现
 *
 */
public class GoodsStockDAOImpl extends BaseHibernateDAOImpl<GoodsStock> implements GoodsStockDAO {

	/**
	 * 构造函数
	 */
	public GoodsStockDAOImpl(){
		super(GoodsStockVW.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsStock> getSearchCount(final GoodsStockSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isNotEmpty(cond.getGoods())){
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockAllDetail").getQueryString());
				}else{
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockDetail").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GoodsStock",GoodsStockVW.class);
				setFetchPoint(q, 0, 0);
				List<GoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};return (List<GoodsStock>) execute(action);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<GoodsStock> findByCond(final GoodsStockSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				if(StringUtils.isNotEmpty(cond.getFlag())){
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockAllDetail").getQueryString());
				}else{
					query.append(session.getNamedQuery("GoodsStockDAO.goodsStockDetail").getQueryString());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GoodsStock",GoodsStockVW.class);
				setFetchPoint(q, start, count);
				List<GoodsStock> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<GoodsStock>) execute(action);
	}

}
