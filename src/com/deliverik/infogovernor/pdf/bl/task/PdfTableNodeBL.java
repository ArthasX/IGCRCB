/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodePK;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * 概述: PDF报表XML中表格式表单节点定义表业务逻辑接口
  * 功能描述: PDF报表XML中表格式表单节点定义表业务逻辑接口
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
public interface PdfTableNodeBL extends BaseBL {

	/**
	 * PDF报表XML中表格式表单节点定义表实例取得
	 *
	 * @return PDF报表XML中表格式表单节点定义表实例
	 */
	public PdfTableNodeTB getPdfTableNodeTBInstance();

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfTableNodeInfo searchPdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException;

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfTableNodeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond, int start,
			int count);

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfTableNodeInfo registPdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfTableNodeInfo updatePdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException;

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfTableNode(PdfTableNodeInfo instance)
		throws BLException;

}