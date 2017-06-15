/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCond;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
  * 概述: 演练计划条目DAO实现
  * 功能描述: 演练计划条目DAO实现
  * 创建记录: 2015/02/28
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class DrillplanitemDAOImpl extends
		BaseHibernateDAOImpl<DrillplanitemInfo> implements DrillplanitemDAO {

	/**
	 * 构造函数
	 */
	public DrillplanitemDAOImpl(){
		super(DrillplanitemTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
    public List<DrillplanitemInfo> findAll() {
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
    public DrillplanitemInfo findByPK(Serializable pk) {
		DrillplanitemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final DrillplanitemSearchCond cond){
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
	public List<DrillplanitemInfo> findByCond(final DrillplanitemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(DrillplanitemSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getDid()!=null&&0!=cond.getDid().intValue()){
		    c.add(Expression.eq("did", cond.getDid()));
		}
		return c;
	}

	/**查询演练基本信息*/
	public List<Map<String,Object>> searchDrillDetailByPrid(final String prid, final String flowType){
		 HibernateCallback action = new HibernateCallback() {
	            public Object doInHibernate(Session session) throws HibernateException,
	                    SQLException {
	                session.flush();
	                StringBuffer query = new StringBuffer();
	                if(flowType.equals("all")){
	                	query.append(session.getNamedQuery("DrillplanitemDAO.searchDrillDetailByAllPrid").getQueryString());
	                }else{
	                	query.append(session.getNamedQuery("DrillplanitemDAO.searchDrillDetailByEmPrid").getQueryString());
	                }
	                query.append(" and a.prid = "+ prid);
	                //获取SQLQuery
	                SQLQuery q = session.createSQLQuery(query.toString());
	                q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	        		q.addScalar("DRILLNAME", Hibernate.STRING);
	        		q.addScalar("OPENTIME", Hibernate.STRING);
	        		q.addScalar("CLOSETIME", Hibernate.STRING);
	        		q.addScalar("AUTHOR", Hibernate.STRING);
	        		q.addScalar("DRILLFORMALITY", Hibernate.STRING);
	        		q.addScalar("DRILLCONTENT", Hibernate.STRING);
	        		q.addScalar("DRILLOBJECTIVE", Hibernate.STRING);
//	        		q.addScalar("PLANNAME", Hibernate.STRING);
	        		q.addScalar("SENCENAME", Hibernate.STRING);
	        		q.addScalar("DEPARTMENT",Hibernate.STRING);
	                List<Map<String,Object>> list = q.list();
	                session.clear();
	                session.close();
	                return list;
	            }
	        };
	        return (List<Map<String,Object>>) execute(action);
	}
}