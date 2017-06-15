/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG344VW;

/**
  * 概述: IG344DAO实现
  * 功能描述: IG344DAO实现
  * 创建记录: 2012/07/13
  * 修改记录: 
  */

public class IG344DAOImpl extends
		BaseHibernateDAOImpl<IG344Info> implements IG344DAO {

	/**
	 * 构造函数
	 */
	public IG344DAOImpl(){
		super(IG344VW.class);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG344Info> findByCond(final IG344SearchCond cond, final int start, final int count){
		return query(cond, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	@SuppressWarnings("unchecked")
	public List<IG344Info> query(final IG344SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws

			HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemRelationDetailVWDAO.searchEntityItemCount").getQueryString());
				//根据服务商编号查询
				if(StringUtils.isNotEmpty(cond.getEiid_q())){
					query.append(" and cldeiid = "+cond.getEiid_q());
				}
				//根据服务记录起始时间查询
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
					query.append(" and eiinsdate >= '" + cond.getBeginTime_q() +"'");
				}
				//根据服务记录中止时间查询
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
					query.append(" and eiinsdate <= '" + cond.getEndTime_q() +"'");
				}  
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG344VW.class);
				List<IG344Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG344Info>) execute(action);
	}

}