/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图DAO接口
  * 功能描述: 报表字段与流程公有表单值映射关系视图DAO接口
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public interface PdfIg898MapVWDAO extends BaseHibernateDAO<PdfIg898MapVWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfIg898MapVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfIg898MapVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final PdfIg898MapVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfIg898MapVWInfo> findByCond(
			final PdfIg898MapVWSearchCond cond, final int start,
			final int count);
	
    	/**
         * 取得表格类型表单的行数
         *
         * @param cond 检索条件
         * @return 表格表单行数
         */
        public String getMaxRowNumber(final PdfIg898MapVWSearchCond cond);
}