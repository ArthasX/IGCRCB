/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.annotation.IdGeneratorMethod;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * 概述: 缺省参与者按钮定义表DAO实现
  * 功能描述: 缺省参与者按钮定义表DAO实现
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG725DAOImpl extends
		BaseHibernateDAOImpl<IG725Info> implements IG725DAO {

	/**
	 * 构造函数
	 */
	public IG725DAOImpl(){
		super(IG725TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG725Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG725Info findByPK(Serializable pk) {
		IG725Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG725SearchCond cond){
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
	public List<IG725Info> findByCond(final IG725SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG725SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//状态ID
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		//按钮ID
		if(StringUtils.isNotEmpty(cond.getPbdid())){
			c.add(Expression.eq("pbdid", cond.getPbdid()));
		}
		//主键
		if(StringUtils.isNotEmpty(cond.getPdbdid_like())){
			c.add(Expression.like("pdbdid", cond.getPdbdid_like() + "%"));
		}
		return c;
	}
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	@SuppressWarnings("rawtypes")
	@IdGeneratorMethod("psdid")
	public String getPdbdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(p.pdbdid) FROM IG725TB p WHERE p.pdbdid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
}