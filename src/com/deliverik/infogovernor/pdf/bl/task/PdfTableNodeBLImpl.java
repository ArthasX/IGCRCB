/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfTableNodeInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfTableNodeSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfTableNodeDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodePK;
import com.deliverik.infogovernor.pdf.model.entity.PdfTableNodeTB;

/**
  * 概述: PDF报表XML中表格式表单节点定义表业务逻辑实现
  * 功能描述: PDF报表XML中表格式表单节点定义表业务逻辑实现
  * 创建记录: 2013/08/02
  * 修改记录: 
  */
public class PdfTableNodeBLImpl extends BaseBLImpl implements
		PdfTableNodeBL {

	/** PDF报表XML中表格式表单节点定义表DAO接口 */
	protected PdfTableNodeDAO pdfTableNodeDAO;
	
	/**
	 * PDF报表XML中表格式表单节点定义表DAO接口设定
	 *
	 * @param pdfTableNodeDAO PDF报表XML中表格式表单节点定义表DAO接口
	 */
	public void setPdfTableNodeDAO(PdfTableNodeDAO pdfTableNodeDAO) {
		this.pdfTableNodeDAO = pdfTableNodeDAO;
	}

	/**
	 * PDF报表XML中表格式表单节点定义表实例取得
	 *
	 * @return PDF报表XML中表格式表单节点定义表实例
	 */
	public PdfTableNodeTB getPdfTableNodeTBInstance() {
		return new PdfTableNodeTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode() {
		return pdfTableNodeDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfTableNodeInfo searchPdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfTableNodeSearchCond cond) {
		return pdfTableNodeDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfTableNodeInfo> searchPdfTableNode(
			PdfTableNodeSearchCond cond) {
		return pdfTableNodeDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return pdfTableNodeDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfTableNodeInfo registPdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		return pdfTableNodeDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfTableNodeInfo updatePdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		checkExistInstance(new PdfTableNodePK(instance.getPdid(), instance.getDatabinding()));
		return pdfTableNodeDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfTableNodeByPK(PdfTableNodePK pk)
		throws BLException {
		pdfTableNodeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfTableNode(PdfTableNodeInfo instance)
		throws BLException {
		pdfTableNodeDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PdfTableNodeInfo checkExistInstance(PdfTableNodePK pk)
		throws BLException {
		PdfTableNodeInfo instance = pdfTableNodeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}