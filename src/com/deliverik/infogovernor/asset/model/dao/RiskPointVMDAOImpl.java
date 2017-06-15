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
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
  * 概述: 风险点查询DAO实现
  * 功能描述: 风险点查询DAO实现
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
public class RiskPointVMDAOImpl extends
		BaseHibernateDAOImpl<RiskPointVMInfo> implements RiskPointVMDAO {

	/**
	 * 构造函数
	 */
	public RiskPointVMDAOImpl(){
		super(RiskPointVM.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<RiskPointVMInfo> findAll() {
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
	public RiskPointVMInfo findByPK(Serializable pk) {
		RiskPointVMInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskPointVMSearchCond cond){
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
	public List<RiskPointVMInfo> findByCond(final RiskPointVMSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskPoint.search").getQueryString());
				
				/**追加 风险名称 查询条件*/
				
				/**根据ID*/
				if(StringUtils.isNotEmpty(cond.getEiid())){
					query.append(" and risk.eiid = '"+cond.getEiid()+"'");
				}
				/**风险名称*/
				if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and risk.einame like '%"+cond.getEiname()+"%'");
				}
				/**风险编号*/
				if(StringUtils.isNotEmpty(cond.getEilabel())){
					query.append(" and risk.eilabel like '%"+cond.getEilabel()+"%'");
				}
				
				/**风险等级*/
				if(StringUtils.isNotEmpty(cond.getGrad())){
					query.append(" and risk.grad = '"+cond.getGrad()+"'");
				}
				/**风险管理人*/
				if(StringUtils.isNotEmpty(cond.getMguserid())){
					query.append(" and risk.managername = '"+cond.getMguserid()+"'");
				}
				/**登记日*/
				if(StringUtils.isNotEmpty(cond.getStartdate())&&StringUtils.isNotEmpty(cond.getEnddate())){
					query.append(" and risk.eiinsdate between '"+cond.getStartdate()+"%' and  '"+cond.getEnddate()+"'");
				}
				/**发生可能性*/
				if(StringUtils.isNotEmpty(cond.getPoss())){
					query.append(" and risk.poss = '"+cond.getPoss()+"'");
				}
				
				/**风险标志*/
				if(StringUtils.isNotEmpty(cond.getRisksign())){
					query.append(" and risk.risksign = '"+cond.getRisksign()+"'");
				}
				
				//层次码 
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and risk.ESYSCODING like '"+cond.getSyscoding()+"%'");
				}
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("risk",RiskPointVM.class);
				setFetchPoint(q, start, count);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskPointVMInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskPointVMSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}