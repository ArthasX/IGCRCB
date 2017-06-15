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
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;

/**
  * 概述: 检查项查询DAO实现
  * 功能描述: 检查项查询DAO实现
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
public class CheckItemVWDAOImpl extends
		BaseHibernateDAOImpl<CheckItemVWInfo> implements CheckItemVWDAO {

	/**
	 * 构造函数
	 */
	public CheckItemVWDAOImpl(){
		super(CheckItemVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<CheckItemVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public CheckItemVWInfo findByPK(Serializable pk) {
		CheckItemVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckItemVWSearchCond cond){
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
	public List<CheckItemVWInfo> findByCond(final CheckItemVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("Check.Item").getQueryString());
				
				/**追加 风险名称 查询条件*/
				/**检查项频度*/
				if(StringUtils.isNotEmpty(cond.getCheckfrequency())){
					query.append(" and item.checkfrequency = '"+cond.getCheckfrequency()+"'");
				}
				
				/**检查项名称*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and item.einame like  '%"+cond.getEiname()+"%'");
				}
				/**风险管理人*/
				if(StringUtils.isNotEmpty(cond.getManagername())){
					query.append(" and item.managername = '"+cond.getManagername()+"'");
				}
				/**登记日*/
				if(StringUtils.isNotEmpty(cond.getStartdate()) && StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and item.eiinsdate between '"+cond.getStartdate()+"' and '"+cond.getEnddate()+"'");
				}
				/**编号*/
				if(StringUtils.isNotEmpty(cond.getBh())){
					query.append(" and item.eilabel like '%"+cond.getBh()+"%'");
				}
				/**主键*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and item.eiid = '"+cond.getEiid()+"'");
				}
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and item.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("item",CheckItemVW.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckItemVWInfo>)execute(action);
	}
	/**
	 * (安全信息 检查项)条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<CheckItemVWInfo> safeInfoFindByCond(final CheckItemVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("SafeInfoCheck.Item").getQueryString());
				
				/**追加 风险名称 查询条件*/
				/**检查项频度*/
				if(StringUtils.isNotEmpty(cond.getCheckfrequency())){
					query.append(" and item.checkfrequency = '"+cond.getCheckfrequency()+"'");
				}
				
				/**检查项名称*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and item.einame like  '%"+cond.getEiname()+"%'");
				}
				/**风险管理人*/
				if(StringUtils.isNotEmpty(cond.getManagername())){
					query.append(" and item.managername = '"+cond.getManagername()+"'");
				}
				/**登记日*/
//				if(StringUtils.isNotEmpty(cond.getStartdate()) || StringUtils.isNotEmpty(cond.getEnddate())){
//					query.append(" and item.eiinsdate between '"+cond.getStartdate()+"' and '"+cond.getEnddate()+"'");
//				}
				if(StringUtils.isNotEmpty(cond.getStartdate())){
					query.append(" and item.eiinsdate >= '").append(cond.getStartdate()).append("' ");
				}
				if(StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and item.eiinsdate <= '").append(cond.getEnddate()).append("' ");
				}
				/**编号*/
				if(StringUtils.isNotEmpty(cond.getBh())){
					query.append(" and item.eilabel like '%"+cond.getBh()+"%'");
				}
				/**主键*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and item.eiid = '"+cond.getEiid()+"'");
				}
				/**主键in*/
				if(StringUtils.isNotEmpty(cond.getEiid_NotIn())){
					query.append(" and item.eiid not in ("+ cond.getEiid_NotIn()+")");
				}
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and item.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//获取SQLQuery
				query.append(" order by eiupdtime desc");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("item",CheckItemVW.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckItemVWInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckItemVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}