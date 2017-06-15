/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * 概述: PDF报表XML中表格式表单节点定义表DAO实现
  * 功能描述: PDF报表XML中表格式表单节点定义表DAO实现
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PdfTableNodeDAOImpl extends
		BaseHibernateDAOImpl<PdfTableNodeInfo> implements PdfTableNodeDAO {

	/**
	 * 构造函数
	 */
	public PdfTableNodeDAOImpl(){
		super(PdfTableNodeTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfTableNodeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfTableNodeInfo findByPK(Serializable pk) {
		PdfTableNodeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfTableNodeSearchCond cond){
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
	public List<PdfTableNodeInfo> findByCond(final PdfTableNodeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("nodetype"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PdfTableNodeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid())) {
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		if (StringUtils.isNotEmpty(cond.getDatabinding())) {
			c.add(Expression.eq("databinding", cond.getDatabinding()));
		}
		if (StringUtils.isNotEmpty(cond.getPdatabinding())) {
			c.add(Expression.eq("pdatabinding", cond.getPdatabinding()));
		}
		if (StringUtils.isNotEmpty(cond.getNodetype())) {
			c.add(Expression.eq("nodetype", cond.getNodetype()));
		}
		return c;
	}

}