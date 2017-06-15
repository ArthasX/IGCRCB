/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.dao;

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
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCond;
import com.deliverik.infogovernor.crc.model.entity.ChangeProcessVWTB;

/**
  * 概述: 变更流程DAO实现
  * 功能描述: 变更流程DAO实现
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ChangeProcessVWDAOImpl extends
		BaseHibernateDAOImpl<ChangeProcessVWInfo> implements ChangeProcessVWDAO {

	/**
	 * 构造函数
	 */
	public ChangeProcessVWDAOImpl(){
		super(ChangeProcessVWTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ChangeProcessVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ChangeProcessVWInfo findByPK(Serializable pk) {
		ChangeProcessVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ChangeProcessVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EntityItemIGCRC1401VWDAO.getSearchCount").getQueryString());
				query = getSQL(cond, query);
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				Integer count = getCount(q.list());
				session.clear();
				return count;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ChangeProcessVWInfo> findByCond(final ChangeProcessVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("EntityItemIGCRC1401VWDAO.getChangeProcess").getQueryString());
				
				query = getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("RCTB",ChangeProcessVWTB.class);

				setFetchPoint(q, start, count);

				List<ChangeProcessVWInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<ChangeProcessVWInfo>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ChangeProcessVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @param query sql
	 * @return 检索用检索条件类
	 */
	protected StringBuffer getSQL(ChangeProcessVWSearchCond cond, StringBuffer query){
		
		//工单号
		if(StringUtils.isNotBlank(cond.getPrserialnum_like())){
			query.append(" and a.prserialnum like '%" + cond.getPrserialnum_like() + "%'");
		}
		//变更名称
		if(StringUtils.isNotBlank(cond.getPrtitle_like())){
			query.append(" and a.prtitle like '%" + cond.getPrtitle_like() + "%'");
		}
		//变更类型
		if(StringUtils.isNotBlank(cond.getChangetype_like())){
			query.append(" and d.pivarvalue like '%" + cond.getChangetype_like() + "%'");
		}
		//更新平台
		if(StringUtils.isNotBlank(cond.getUpdateplatform_like())){
			query.append(" and c.pivarvalue like '%" + cond.getUpdateplatform_like() + "%'");
		}
		//工单状态
		if(StringUtils.isNotBlank(cond.getPrstatus())){
			query.append(" and a.prstatus = '" + cond.getPrstatus() + "'");
		}
		//变更类别
		if(StringUtils.isNotBlank(cond.getChangecategory())){
			query.append(" and f.pivarvalue = '" + cond.getChangecategory() + "'");
		}
		//发起时间
		if(StringUtils.isNotBlank(cond.getPropentime_begin())){
			query.append(" and a.propentime >= '" + cond.getPropentime_begin() + "'");
		}
		if(StringUtils.isNotBlank(cond.getPropentime_end())){
			query.append(" and a.propentime <= '" + cond.getPropentime_end() + "'");
		}
		//业务影响范围
		if(StringUtils.isNotBlank(cond.getBusinessscope())){
			query.append(" and g.pivarvalue = '" + cond.getBusinessscope() + "'");
		}
		//变更原因
		if(StringUtils.isNotBlank(cond.getChangereason_like())){
			query.append(" and e.pivarvalue like '%" + cond.getChangereason_like() + "%'");
		}
		//是否影响业务
		if(StringUtils.isNotBlank(cond.getIsinfluence())){
			query.append(" and h.pivarvalue = '" + cond.getIsinfluence() + "'");
		}
		//变更分类
		if(StringUtils.isNotBlank(cond.getChangeclassify())){
			query.append(" and b.pivarvalue = '" + cond.getChangeclassify() + "'");
		}
		//变更内容
		if(StringUtils.isNotBlank(cond.getChangecontent_like())){
			query.append(" and i.pivarvalue like '%" + cond.getChangecontent_like() + "%'");
		}
		//处理人
		if(StringUtils.isNotBlank(cond.getPpusername_like())){
			query.append(" and exists (select 1 from ig337 pp where a.prid = pp.prid and pp.ppusername like '%"+cond.getPpusername_like()+"%' ) ");
		}
		query.append(" order by propentime desc ");
		return query;
	}
}