/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg599MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg599MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfIg599MapVWDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg599MapVWTB;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图业务逻辑实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图业务逻辑实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfIg599MapVWBLImpl extends BaseBLImpl implements
		PdfIg599MapVWBL {

	/** 报表字段与流程公有表单值映射关系视图DAO接口 */
	protected PdfIg599MapVWDAO pdfIg599MapVWDAO;
	
	/**
	 * 报表字段与流程公有表单值映射关系视图DAO接口设定
	 *
	 * @param pdfIg599MapVWDAO 报表字段与流程公有表单值映射关系视图DAO接口
	 */
	public void setPdfIg599MapVWDAO(PdfIg599MapVWDAO pdfIg599MapVWDAO) {
		this.pdfIg599MapVWDAO = pdfIg599MapVWDAO;
	}

	/**
	 * 报表字段与流程公有表单值映射关系视图实例取得
	 *
	 * @return 报表字段与流程公有表单值映射关系视图实例
	 */
	public PdfIg599MapVWTB getPdfIg599MapVWTBInstance() {
		return new PdfIg599MapVWTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW() {
		return pdfIg599MapVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfIg599MapVWInfo searchPdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfIg599MapVWSearchCond cond) {
		return pdfIg599MapVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW(
			PdfIg599MapVWSearchCond cond) {
		return pdfIg599MapVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfIg599MapVWInfo> searchPdfIg599MapVW(
			PdfIg599MapVWSearchCond cond, int start,
			int count) {
		return pdfIg599MapVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfIg599MapVWInfo registPdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		return pdfIg599MapVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfIg599MapVWInfo updatePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		checkExistInstance(new PdfIg599MapVWPK(instance.getPrid(), instance.getPidid()));
		return pdfIg599MapVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfIg599MapVWByPK(PdfIg599MapVWPK pk)
		throws BLException {
		pdfIg599MapVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfIg599MapVW(PdfIg599MapVWInfo instance)
		throws BLException {
		pdfIg599MapVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PdfIg599MapVWInfo checkExistInstance(PdfIg599MapVWPK pk)
		throws BLException {
		PdfIg599MapVWInfo instance = pdfIg599MapVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

}