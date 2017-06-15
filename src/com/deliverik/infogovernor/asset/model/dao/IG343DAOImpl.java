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
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCond;
import com.deliverik.infogovernor.asset.model.entity.IG343VW;

/**
  * 概述: IG343DAO实现
  * 功能描述: IG343DAO实现
  * 创建记录: 2012/07/12
  * 修改记录: 
  */
public class IG343DAOImpl extends
		BaseHibernateDAOImpl<IG343Info> implements IG343DAO {

	/**
	 * 构造函数
	 */
	public IG343DAOImpl(){
		super(IG343VW.class);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG343Info> findByCond(final IG343SearchCond cond, final int start, final int count){
		return query(cond, start, count);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG343Info> query(final IG343SearchCond cond, final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws

			HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(" select eiid,einame,civalue,(case when civalue>0 then civalue1/civalue else 0 end) as " +
							 " civalue1, civalue2,(case when civalue2>0 then civalue3/civalue2 else 0 end) as civalue3," +
							 " einame3,(case when einame3>0 then civalue4/einame3 else 0 end) as civalue4, " +
							 " civalue+civalue2+einame3 as sumcount,civalue1+civalue3+ civalue4 as sumstore from ( ");
				query.append(session.getNamedQuery("EntityItemRelationVWDAO.searchEntityItemCount")
						.getQueryString());
				//根据服务商名称查询
				if(StringUtils.isNotEmpty(cond.getEiname_like())){
					query.append(" and einame like '"+cond.getEiname_like()+"%'");
				}
				query.append(" and exists(select 1 from soc0118 ei where ei.eiid = vw.pareiid");
				//根据服务记录起始时间查询
				if(StringUtils.isNotEmpty(cond.getBeginTime_q())){
					query.append(" and ei.eiinsdate >= '" + cond.getBeginTime_q() +"'");
				}
				//根据服务记录中止时间查询
				if(StringUtils.isNotEmpty(cond.getEndTime_q())){
					query.append(" and ei.eiinsdate <= '" + cond.getEndTime_q() +"'");
				}  
				query.append(" ) group by eiid ,einame ) temp");		 
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("prcount",IG343VW.class);
				List<IG343Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG343Info>) execute(action);
	}

}