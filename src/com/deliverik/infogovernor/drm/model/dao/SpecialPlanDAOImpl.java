/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 专项预案查询DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class SpecialPlanDAOImpl extends BaseHibernateDAOImpl<SOC0118VWInfo> implements SpecialPlanDAO{

	/**
	 * 构造方法
	 */
	public SpecialPlanDAOImpl(){
		super(SOC0118VW.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SpecialPlanSearchCond cond) {
		StringBuffer query = new StringBuffer();
		query.append("select count(1) from soc0118 s where s.esyscoding like '888001%' ");
		getSql(query,cond);
		Session session = getSession();
		session.flush();
		//创建查询对象
		SQLQuery q = session.createSQLQuery(query.toString());
		q.setProperties(cond);
		return getCount(q.list());
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始条数
	 * @param count 显示数量
	 * @return 检索结果
	 */
	public List<SOC0118VWInfo> search(SpecialPlanSearchCond cond,int start,int count){
		StringBuffer query = new StringBuffer();
		query.append("select 0 as id,s.* from soc0118 s where s.esyscoding like '888001%' ");
		getSql(query,cond);
		//获取连接对象
		Session session = getSession();
		session.flush();
		//创建查询对象
		SQLQuery q = session.createSQLQuery(query.toString());
		q.addEntity(SOC0118VW.class);
		setFetchPoint(q, start, count);
		q.setProperties(cond);
		return q.list();
	}

	/**
	 * 拼接查询条件
	 * @param query 查询语句
	 * @param cond 查询条件对象
	 */
	private void getSql(StringBuffer query, SpecialPlanSearchCond cond) {
		//预案名称
		if(StringUtils.isNotEmpty(cond.getEiname_like())){
			query.append(" and s.einame like '%'||:einame_like||'%'");
		}
		//关联业务系统
		if(cond.getUsinessSystemId() != null && cond.getUsinessSystemId() > 0){
			query.append(" and exists (select 1 from soc0119 r where r.pareiid = s.eiid and eirrelationcode = '080-040' and r.cldeiid = :usinessSystemId) ");
		}
		//场景ID
		if(cond.getSceneId() != null && cond.getSceneId() > 0){
			query.append(" and exists (select 1 from soc0119 r where r.pareiid = s.eiid and eirrelationcode = '080-060' and r.cldeiid = :sceneId) ");
		}
		//应急资源
		if(cond.getDrmResourceId() != null && cond.getDrmResourceId() > 0){
			query.append(" and exists (select 1 from soc0119 r left join soc0107 c on c.eiid = r.cldeiid and c.cid='CI600000001004' left join ig380 pd on pd.pdid = c.civalue left join ig560 dv on dv.pidid like pd.pdid || '___' where r.pareiid = s.eiid and eirrelationcode = '080-060' and dv.dfvalue like '0_");
			query.append(cond.getDrmResourceId());
			query.append("_SOC%' ) ");
		}
	}
}
