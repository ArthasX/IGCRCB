/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWTB;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图DAO实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图DAO实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class PdfIg599MapVWDAOImpl extends
		BaseHibernateDAOImpl<PdfIg599MapVWInfo> implements PdfIg599MapVWDAO {

	/**
	 * 构造函数
	 */
	public PdfIg599MapVWDAOImpl(){
		super(PdfIg599MapVWTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfIg599MapVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfIg599MapVWInfo findByPK(Serializable pk) {
		PdfIg599MapVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfIg599MapVWSearchCond cond){
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
	public List<PdfIg599MapVWInfo> findByCond(final PdfIg599MapVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(PdfIg599MapVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getPrid()!=null&&cond.getPrid()>0) {
            c.add(Expression.eq("prid", cond.getPrid()));
        }
		c.add(Expression.isNotNull("databinding"));
		return c;
	}

}