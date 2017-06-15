/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SynchronizationAlarmSystemVW;

/**
 * 概述:同步告警系统视图DAO实现
 * 功能描述: 同步告警系统视图DAO实现
 * 创建人：王磊
 * 创建记录: 2014/04/03
 * 修改记录: 
 */

public class SynchronizationAlarmSystemVWDAOImpl extends BaseHibernateDAOImpl<SynchronizationAlarmSystemVWInfo>
		implements SynchronizationAlarmSystemVWDAO {

	public SynchronizationAlarmSystemVWDAOImpl(){
		super(SynchronizationAlarmSystemVW.class);
	}

	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond){
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select row_number() OVER () as rid,ind.ilsid,ind.ilsname,ea.name as eaname ");
				query.append("from IndicatorLightsSystem ind  ");
				if("1".equals(cond.getItype())){
					query.append("right join ( ");
				}else{
					query.append("left join ( ");
				}
				query.append("select er.name from public.EAM_RESOURCE er ");
				query.append("left join public.eam_resource_group  erg on er.instance_id = erg.id ");
				query.append(" WHERE er.RESOURCE_TYPE_ID = 3 AND er.FSYSTEM = 0 AND erg.GROUPTYPE = 13 ");
				query.append(") ea on ind.ilsname = ea.name ");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("SynchronizationAlarmSystemVW",SynchronizationAlarmSystemVW.class);
				List<SynchronizationAlarmSystemVWInfo> list = q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<SynchronizationAlarmSystemVWInfo>)execute(action);
	}
}
