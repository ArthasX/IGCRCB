/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCond;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;

/**
  * 概述: 培训任务表DAO实现
  * 功能描述: 培训任务表DAO实现
  * 创建记录: 2015/04/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class TrainmissionDAOImpl extends
		BaseHibernateDAOImpl<TrainmissionInfo> implements TrainmissionDAO {

	/**
	 * 构造函数
	 */
	public TrainmissionDAOImpl(){
		super(TrainmissionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<TrainmissionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public TrainmissionInfo findByPK(Serializable pk) {
		TrainmissionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final TrainmissionSearchCond cond){
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
	public List<TrainmissionInfo> findByCond(final TrainmissionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("tmid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(TrainmissionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getTpid()!=null&&cond.getTpid()!=0){
			c.add(Expression.eq("tpid", cond.getTpid()));
		}
		return c;
	}
	
	/**
	 * 根据 key执行指定的SQL
	 * @param sqlKeys SQL语句标识
	 * @param paramMap	查询条件
	 * @return List<Map<String, Object>> 结果集
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getList(final String [] sqlKeys, final Map<String, String> paramMap) {

        HibernateCallback action = new HibernateCallback() {

            /* (non-Javadoc)
             * @see org.springframework.orm.hibernate3.HibernateCallback#doInHibernate(org.hibernate.Session)
             */
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                buildSQL(sqlKeys, session, query);
                SQLQuery q = session.createSQLQuery(query.toString());
                q.setProperties(paramMap);
                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
                List<Map<String, Object>> list = q.list();
                session.clear();
                session.close();
                return list;
             } // end method doInHibernate 
         };
         return ((List<Map<String, Object>>) execute(action));
	} // end method getList
	
	/**
	 * 构建SQL语句
	 * @param sqlKeys
	 * @param session
	 * @param query
	 */
	private void buildSQL(final String[] sqlKeys, Session session, StringBuffer query) {
		for (String sqlKey : sqlKeys) {
			query.append(session.getNamedQuery(sqlKey).getQueryString()).append(" ");
		} // end for each 
	} // end method buildSQL 

}