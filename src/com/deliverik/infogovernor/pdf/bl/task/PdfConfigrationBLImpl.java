/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfConfigrationInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfConfigrationSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfConfigrationDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfConfigrationTB;

/**
  * 概述: 报表对应BL及模板名称配置表业务逻辑实现
  * 功能描述: 报表对应BL及模板名称配置表业务逻辑实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfConfigrationBLImpl extends BaseBLImpl implements
		PdfConfigrationBL {

	/** 报表对应BL及模板名称配置表DAO接口 */
	protected PdfConfigrationDAO pdfConfigrationDAO;
	
	/**
	 * 报表对应BL及模板名称配置表DAO接口设定
	 *
	 * @param pdfConfigrationDAO 报表对应BL及模板名称配置表DAO接口
	 */
	public void setPdfConfigrationDAO(PdfConfigrationDAO pdfConfigrationDAO) {
		this.pdfConfigrationDAO = pdfConfigrationDAO;
	}

	/**
	 * 报表对应BL及模板名称配置表实例取得
	 *
	 * @return 报表对应BL及模板名称配置表实例
	 */
	public PdfConfigrationTB getPdfConfigrationTBInstance() {
		return new PdfConfigrationTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration() {
		return pdfConfigrationDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfConfigrationInfo searchPdfConfigrationByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfConfigrationSearchCond cond) {
		return pdfConfigrationDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration(
			PdfConfigrationSearchCond cond) {
		return pdfConfigrationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfConfigrationInfo> searchPdfConfigration(
			PdfConfigrationSearchCond cond, int start,
			int count) {
		return pdfConfigrationDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfConfigrationInfo registPdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		return pdfConfigrationDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfConfigrationInfo updatePdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		checkExistInstance(instance.getPdid());
		return pdfConfigrationDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfConfigrationByPK(String pk)
		throws BLException {
		pdfConfigrationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfConfigration(PdfConfigrationInfo instance)
		throws BLException {
		pdfConfigrationDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PdfConfigrationInfo checkExistInstance(String pk)
		throws BLException {
		PdfConfigrationInfo instance = pdfConfigrationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}