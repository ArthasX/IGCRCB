/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;

/**
  * 概述: 流程组定义表DAO实现
  * 功能描述: 流程组定义表DAO实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG480DAOImpl extends
		BaseHibernateDAOImpl<IG480Info> implements IG480DAO {
	private static String nextPgdid = "";
	/**
	 * 构造函数
	 */
	public IG480DAOImpl(){
		super(IG480TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<IG480Info> findAll() {
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
	public IG480Info findByPK(Serializable pk) {
		IG480Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG480SearchCond cond){
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
	public List<IG480Info> findByCond(final IG480SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);

		//流程组状态
		if(StringUtils.isEmpty(cond.getPgdstatus())){
			c.addOrder(Order.asc("pgdid"));
		} else {
			c.addOrder(Order.desc("pgdid"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG480SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程组定义ID
		if(StringUtils.isNotEmpty(cond.getPgdid_like())){
			c.add(Restrictions.like("pgdid", cond.getPgdid_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgddesc())){
			c.add(Restrictions.like("pgddesc", cond.getPgddesc()  + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgdname_like())){
			c.add(Restrictions.eq("pgdname", cond.getPgdname_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getPgdstatus())){
			c.add(Restrictions.eq("pgdstatus", cond.getPgdstatus()));
		}
		if(cond.getPtid()!=null&&cond.getPtid()>0){
			c.add(Restrictions.eq("ptid", cond.getPtid()));
		}
		return c;
	}
	
	/**
	 * PGDID主键值取得
	 * @param pgdid模板标识
	 * 
	 * @return PGDID主键值
	 */
	public String getPgdidSequenceNextValue(String firstsite,String pdsequence) {
		return StringUtils.leftPad(getSequenceNextValue(pdsequence) + "", IGPRDCONSTANTS.ID_PREFIX_LENGTH, firstsite)
				+ StringUtils.leftPad("1", IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	/**
	 * 流程组定义升版处理
	 * 
	 * @param pgdid 流程定义ID
	 */
	public void upgradeGroupProcessDefVersion(final String pgdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				SQLQuery q = session.createSQLQuery(
			//调用存储过程
			"{Call PRO_GROUPPROCESSDEFVERSION(?, ?, '0')}");
				q.setString(0, pgdid);
				q.setString(1, getPgdidUpgradeNextValue(pgdid));
				q.executeUpdate();
				session.clear();
				return null; 
			}
		};
		execute(action);
	}
	/**
	 * 升版后PGDID主键值取得
	 * 
	 * @return 升版后PGDID主键值
	 */
	private static String getPgdidUpgradeNextValue(String pgdid) {
		return pgdid.substring(0, IGPRDCONSTANTS.ID_PREFIX_LENGTH)
		+ StringUtils.leftPad(Integer.parseInt(pgdid.substring(
				IGPRDCONSTANTS.ID_PREFIX_LENGTH, IGPRDCONSTANTS.ID_PREFIX_LENGTH + IGPRDCONSTANTS.ID_VERSION_LENGTH)) + 1 + "", 
				IGPRDCONSTANTS.ID_VERSION_LENGTH, "0");
	}
	/**
	 * 流程组定义复制处理
	 * 
	 * @param pgdid 流程组定义ID
	 * @param pdsequence 序列定义
	 */
	public String copyGroupProcessDefVersion(final String pgdid,final String pdsequence) {
		nextPgdid = getPgdidSequenceNextValue(new String(new char[]{pgdid.charAt(0)}),pdsequence);
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				
				SQLQuery q = session.createSQLQuery(
						"{Call PRO_GROUPPROCESSDEFVERSION(?, ?, ?)}");
				q.setString(0, pgdid);
				q.setString(1, nextPgdid);
				q.setString(2,"1"); 
				int i = q.executeUpdate();
				session.clear();  
				return i; 
			}
		};
		execute(action);
		//新生成的pgdid 
		return nextPgdid; 
	}
}