/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfConfigrationTB;

/**
  * 概述: 报表对应BL及模板名称配置表DAO实现
  * 功能描述: 报表对应BL及模板名称配置表DAO实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PdfConfigrationDAOImpl extends
		BaseHibernateDAOImpl<PdfConfigrationInfo> implements PdfConfigrationDAO {

	/**
	 * 构造函数
	 */
	public PdfConfigrationDAOImpl(){
		super(PdfConfigrationTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfConfigrationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfConfigrationInfo findByPK(Serializable pk) {
		PdfConfigrationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfConfigrationSearchCond cond){
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
	public List<PdfConfigrationInfo> findByCond(final PdfConfigrationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PdfConfigrationSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getPdid())) {
            c.add(Expression.eq("pdid", cond.getPdid()));
        }
		return c;
	}

}