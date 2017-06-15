/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;
import com.deliverik.infogovernor.ven.model.condition.MonitoringWorkSearchCond;
import com.deliverik.infogovernor.ven.model.entity.MonitoringWorkTB;

/**
  * 概述: 监测工作填报表DAO实现
  * 功能描述: 监测工作填报表DAO实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class MonitoringWorkDAOImpl extends
		BaseHibernateDAOImpl<MonitoringWorkInfo> implements MonitoringWorkDAO {

	/**
	 * 构造函数
	 */
	public MonitoringWorkDAOImpl(){
		super(MonitoringWorkTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<MonitoringWorkInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public MonitoringWorkInfo findByPK(Serializable pk) {
		MonitoringWorkInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final MonitoringWorkSearchCond cond){
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
	public List<MonitoringWorkInfo> findByCond(final MonitoringWorkSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(MonitoringWorkSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRmid() != null && !("0".equals(cond.getRmid()))) {
			c.add(Restrictions.eq("rmid", cond.getRmid()));
		}
		if (StringUtils.isNotEmpty(cond.getResult_isNotNull())){
			if("1".equals(cond.getResult_isNotNull())){
				c.add(Restrictions.isNotNull("result"));
			}
		}
		if (StringUtils.isNotEmpty(cond.getEiname())){
			c.add(Restrictions.sqlRestriction(" exists(select 1 from soc0118 t where t.eiid = this_.riid and t.einame like '%"+ cond.getEiname() +"%') "));
		}
		
		if (StringUtils.isNotEmpty(cond.getEilabel())){
			c.add(Restrictions.sqlRestriction(" exists(select 1 from soc0118 t where t.eiid = this_.riid and t.eilabel like '%"+ cond.getEilabel() +"%') "));
		}
		return c;
	}

}