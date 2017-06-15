/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG111TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义实体DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IG111DAOImpl extends BaseHibernateDAOImpl<IG111Info> implements IG111DAO{

	/**
	 * 构造方法
	 */
	public IG111DAOImpl(){
		super(IG111TB.class);
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @param start 起始页码
	 * @param count 每页数量
	 * @return 检索结果
	 */
	public List<IG111Info> findByCond(IG111SearchCond cond, int start, int count) {
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG111SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		return c;
	}
	
	/**
	 * 取得下一个ID
	 * @param pdid 流程定义ID
	 * @return 实体ID
	 */
	@SuppressWarnings("rawtypes")
	public String getNextId(String pdid){
		String sql = "SELECT MAX(q.qid) FROM IG111TB q WHERE q.qid like :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

	/**
	 * 根据流程定义id删除 自定义查询条件
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) {
		String sql = "delete from ig111 where pdid = :pdid";
		SQLQuery q = getSession().createSQLQuery(sql);
		q.setParameter("pdid", pdid);
		q.executeUpdate();
	}
}
