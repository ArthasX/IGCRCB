/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;
import com.deliverik.infogovernor.drm.model.entity.PlanVW;

/**
 * 
 */
public class PlanDAOImpl extends BaseHibernateDAOImpl<PlanInfo> implements PlanDAO {

	public PlanDAOImpl() {
		super(PlanVW.class);
	}

	@SuppressWarnings("unchecked")
	public List<PlanInfo> findByCond(PlanSearchCond cond,int start,int count){
		Session session = getSession();
		StringBuffer countSql = new StringBuffer();
		countSql.append("select distinct n.* from (select m.* from (");
		StringBuffer sql = new StringBuffer(session.getNamedQuery("PlanDAO.searchByCond").getQueryString());
		countSql.append(sql);
		getSQL(cond,countSql);
		if(StringUtils.isNotEmpty(cond.getSenceClassify())){
			countSql.append(" and senceclassify = '"+cond.getSenceClassify()+"' ");
		}
		countSql.append(") m");
		if(StringUtils.isNotEmpty(cond.getParticipants())){
			countSql.append(" join ig222 k on m.scepdid = SUBSTR(k.PSDID,1,7) AND k.USERID in(select userid from iguser where username like '%"+cond.getParticipants()+"%')");
		}
		if(StringUtils.isNotEmpty(cond.getAssesteiid())){
			countSql.append(" JOIN IG560 L ON m.scepdid = SUBSTR(L.PSDID,1,7) AND L.DFVALUE like '"+cond.getAssesteiid()+"%'");
		}
		countSql.append(" ) n where 1=1");
		if(StringUtils.isNotEmpty(cond.getEiinsdatestart())){
			countSql.append(" and  eiinsdate >='"+cond.getEiinsdatestart()+"'"); 
		}
		if(StringUtils.isNotEmpty(cond.getEiinsdatestart())){
			countSql.append(" and  eiinsdate <='"+cond.getEiinsdateend()+"'"); 
		}
//		if(StringUtils.isNotEmpty(cond.getEiname())){
//			countSql.append(" and einame like '%"+cond.getEiname()+"%'");
//		}
		SQLQuery q =session.createSQLQuery(countSql.toString());
		q.setProperties(cond);
		q.addEntity(PlanVW.class);
		setFetchPoint(q, start, count);
		return q.list();
	}


	/**
	 * 检索条件生成
	 * 
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(PlanSearchCond cond, StringBuffer query){
		if(cond.getEiid()!=null&&cond.getEiid()>0)
			query.append(" and t.eiid = :eiid");
		if(StringUtils.isNotEmpty(cond.getEiinsdate_ge()))
			query.append(" and eiinsdate >= :eiinsdate_ge");
		if(StringUtils.isNotEmpty(cond.getEiinsdate_le()))
			query.append(" and eiinsdate <= :eiinsdate_le");
		if(StringUtils.isNotEmpty(cond.getEilabel()))
			query.append(" and eilabel like '%'||:eilabel||'%'");
		if(StringUtils.isNotEmpty(cond.getEiname()))
			query.append(" and einame like '%'||:einame||'%'");
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding()))
			query.append(" and eiorgsyscoding = :eiorgsyscoding");
		if(StringUtils.isNotEmpty(cond.getEiorgsyscoding_like()))
			query.append("  and eiorgsyscoding like '%'||:eiorgsyscoding_like||'%'");
		if(StringUtils.isNotEmpty(cond.getEiuserid()))
			query.append(" and eiuserid = :eiuserid");
		if(StringUtils.isNotEmpty(cond.getEiusername()))
			query.append(" and eiusername like '%" + cond.getEiusername() + "%'");
		if(StringUtils.isNotEmpty(cond.getEsyscoding()))
			query.append(" and esyscoding = :esyscoding");
		if(StringUtils.isNotEmpty(cond.getPlanlevel()))
			query.append(" and planlevel = :planlevel");
		if(StringUtils.isNotEmpty(cond.getPlanmode()))
			query.append(" and planmode = :planmode");
		if(StringUtils.isNotEmpty(cond.getPlanprocessid()))
			query.append(" and planprocessid = :planprocessid");
		if(StringUtils.isNotEmpty(cond.getPlanstatus()))
			query.append(" and planstatus = :planstatus");
		if(StringUtils.isNotEmpty(cond.getPlansuccess()))
			query.append(" and plansuccess = :plansuccess");
		if(null!=cond.getIdsNotIn()&& cond.getIdsNotIn().length>0){
			query.append(" and t.eiid not in (:idsNotIn)");
		}
		if(StringUtils.isNotEmpty(cond.getEsyscoding_like()))
			query.append(" and esyscoding like '"+cond.getEsyscoding_like()+"%'");
		if(StringUtils.isNotEmpty(cond.getPlanContent())){
			query.insert(query.lastIndexOf("where")," , (select  eiid,civersion from soc0107 " +
					"where cid in('CM14001001008','CM14001001009','CM14001001010','CM14001001011','CM14001001012','CM14001001013','CM14001001014','CM14001001015') " +
					"and civalue like '%"+cond.getPlanContent()+"%') k " );
			query.append(" and t.eiid = k.eiid and t.eiversion = k.civersion");
		}
		if(cond.getPrid()!=null&&cond.getPrid()>0){
			query.append(" and eiid in (select eiid from ig731 where prid=:prid)");
		}
		if (cond.getPlanEiids() != null && cond.getPlanEiids().size() > 0) {
			query.append(" and eiid in (:planEiids)");
		}
	}

	public Integer getSearchCount(PlanSearchCond cond) {
		Session session = getSession();
		StringBuffer countSql = new StringBuffer();
		countSql.append("select count(*) from ( select distinct n.* from (select m.* from (");
		StringBuffer sql = new StringBuffer(session.getNamedQuery("PlanDAO.getSearchCount").getQueryString());
		countSql.append(sql);
		getSQL(cond,countSql);
		if(StringUtils.isNotEmpty(cond.getSenceClassify())){
			countSql.append(" and senceclassify = '"+cond.getSenceClassify()+"' ");
		}
		countSql.append(") m");
		if(StringUtils.isNotEmpty(cond.getParticipants())){
			countSql.append(" join ig222 k on m.scepdid = SUBSTR(k.PSDID,1,7) AND k.USERID in(select userid from iguser where username like '%"+cond.getParticipants()+"%')");
		}
		if(StringUtils.isNotEmpty(cond.getAssesteiid())){
			countSql.append(" JOIN IG560 L ON m.scepdid = SUBSTR(L.PSDID,1,7) AND L.DFVALUE like '"+cond.getAssesteiid()+"%'");
		}
		countSql.append(" ) n )");
		SQLQuery q =session.createSQLQuery(countSql.toString());
		q.setProperties(cond);
		return Integer.valueOf(q.uniqueResult().toString());
	}

}