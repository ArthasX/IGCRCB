/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;

/**
  * 概述: 风险指标查询DAO实现
  * 功能描述: 风险指标查询DAO实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class RiskIndexSearchVWDAOImpl extends
		BaseHibernateDAOImpl<RiskIndexSearchVWInfo> implements RiskIndexSearchVWDAO {

	/**
	 * 构造函数
	 */
	public RiskIndexSearchVWDAOImpl(){
		super(RiskIndexSearchVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskIndexSearchVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskIndexSearchVWInfo findByPK(Serializable pk) {
		RiskIndexSearchVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskIndexSearchVWSearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<RiskIndexSearchVWInfo> findByCond(final RiskIndexSearchVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskZB.SEARCH").getQueryString());
				
				/**追加 风险名称 查询条件*/
				
				/**根据ID*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and riskzb.eiid = '"+cond.getEiid()+"'");
				}
				/**根据ID*/
				if(StringUtils.isNotEmpty(cond.getEiid_NotIn())){
					query.append(" and riskzb.eiid not in ("+cond.getEiid_NotIn()+")");
				}
				/**根据ID*/
				if(StringUtils.isNotEmpty(cond.getEiid_In())){
					query.append(" and riskzb.eiid in ("+cond.getEiid_In()+")");
				}
				/**风险名称*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and riskzb.einame like '%"+cond.getEiname()+"%'");
				}
				/**风险编号*/
				if(StringUtils.isNotEmpty(cond.getEilabel())){
					query.append(" and riskzb.eilabel like '%"+cond.getEilabel()+"%'");
				}
				/**指标用途*/
				if(StringUtils.isNotEmpty(cond.getIndexused())){
					query.append(" and riskzb.indexused = '"+cond.getIndexused()+"'");
				}
				/**阀值*/
				if(StringUtils.isNotEmpty(cond.getZbfz())){
					query.append(" and riskzb.zbfz = '"+cond.getZbfz()+"'");
				}
				/**指标责任人*/
				if(StringUtils.isNotEmpty(cond.getDutyuser())){
					query.append(" and riskzb.dutyuser like '%"+cond.getDutyuser()+"%'");
				}
				/**指标责任部门*/
				if(StringUtils.isNotEmpty(cond.getDutydepartment())){
					query.append(" and riskzb.dutydepartment like '%"+cond.getDutydepartment()+"%'");
				}
				/**是否关键指标*/
				if(StringUtils.isNotEmpty(cond.getKeyindex())){
					query.append(" and riskzb.keyindex = '"+cond.getKeyindex()+"'");
				}
				/**指标管理人*/
				if(StringUtils.isNotEmpty(cond.getMguserid())){
					query.append(" and riskzb.mguserid = '"+cond.getMguserid()+"'");
				}
				/**登记日期*/
				if(StringUtils.isNotEmpty(cond.getEiStartDate())&&StringUtils.isNotEmpty(cond.getEiEndDate())){
					query.append(" and riskzb.eiinsdate between '"+cond.getEiStartDate()+"%' and  '"+cond.getEiEndDate()+"'");
				}
				/**更新日期*/
				if(StringUtils.isNotEmpty(cond.getEuStartDate())&&StringUtils.isNotEmpty(cond.getEuEndDate())){
					query.append(" and riskzb.eiupdtime between '"+cond.getEuStartDate()+"%' and  '"+cond.getEuEndDate()+"'");
				}
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("riskzb",RiskIndexSearchVW.class);
				
					setFetchPoint(q, start, count);
				
				List<RiskIndexSearchVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskIndexSearchVWInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskIndexSearchVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}