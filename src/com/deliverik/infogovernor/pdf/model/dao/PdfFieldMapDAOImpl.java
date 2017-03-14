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
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapTB;

/**
  * 概述: PDF报表与流程表单映射表DAO实现
  * 功能描述: PDF报表与流程表单映射表DAO实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PdfFieldMapDAOImpl extends
		BaseHibernateDAOImpl<PdfFieldMapInfo> implements PdfFieldMapDAO {

	/**
	 * 构造函数
	 */
	public PdfFieldMapDAOImpl(){
		super(PdfFieldMapTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfFieldMapInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfFieldMapInfo findByPK(Serializable pk) {
		PdfFieldMapInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfFieldMapSearchCond cond){
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
	public List<PdfFieldMapInfo> findByCond(final PdfFieldMapSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PdfFieldMapSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	    if (StringUtils.isNotEmpty(cond.getPdid())) {
	        c.add(Expression.eq("pdid", cond.getPdid()));
	    }
	    if (StringUtils.isNotEmpty(cond.getFormtype())) {
	        c.add(Expression.eq("formtype", cond.getFormtype()));
	    }
		return c;
	}

}