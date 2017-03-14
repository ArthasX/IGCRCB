/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfFieldMapInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfFieldMapSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfFieldMapDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfFieldMapTB;

/**
  * 概述: PDF报表与流程表单映射表业务逻辑实现
  * 功能描述: PDF报表与流程表单映射表业务逻辑实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfFieldMapBLImpl extends BaseBLImpl implements
		PdfFieldMapBL {

	/** PDF报表与流程表单映射表DAO接口 */
	protected PdfFieldMapDAO pdfFieldMapDAO;
	
	/**
	 * PDF报表与流程表单映射表DAO接口设定
	 *
	 * @param pdfFieldMapDAO PDF报表与流程表单映射表DAO接口
	 */
	public void setPdfFieldMapDAO(PdfFieldMapDAO pdfFieldMapDAO) {
		this.pdfFieldMapDAO = pdfFieldMapDAO;
	}

	/**
	 * PDF报表与流程表单映射表实例取得
	 *
	 * @return PDF报表与流程表单映射表实例
	 */
	public PdfFieldMapTB getPdfFieldMapTBInstance() {
		return new PdfFieldMapTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap() {
		return pdfFieldMapDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfFieldMapInfo searchPdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfFieldMapSearchCond cond) {
		return pdfFieldMapDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap(
			PdfFieldMapSearchCond cond) {
		return pdfFieldMapDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfFieldMapInfo> searchPdfFieldMap(
			PdfFieldMapSearchCond cond, int start,
			int count) {
		return pdfFieldMapDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfFieldMapInfo registPdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		return pdfFieldMapDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfFieldMapInfo updatePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		checkExistInstance(new PdfFieldMapPK(instance.getPdid(), instance.getPidid()));
		return pdfFieldMapDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfFieldMapByPK(PdfFieldMapPK pk)
		throws BLException {
		pdfFieldMapDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfFieldMap(PdfFieldMapInfo instance)
		throws BLException {
		pdfFieldMapDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PdfFieldMapInfo checkExistInstance(PdfFieldMapPK pk)
		throws BLException {
		PdfFieldMapInfo instance = pdfFieldMapDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}