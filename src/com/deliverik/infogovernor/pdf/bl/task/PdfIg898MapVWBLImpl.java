/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.pdf.model.PdfIg898MapVWInfo;
import com.deliverik.infogovernor.pdf.model.condition.PdfIg898MapVWSearchCond;
import com.deliverik.infogovernor.pdf.model.dao.PdfIg898MapVWDAO;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWPK;
import com.deliverik.infogovernor.pdf.model.entity.PdfIg898MapVWTB;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图业务逻辑实现
  * 功能描述: 报表字段与流程公有表单值映射关系视图业务逻辑实现
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public class PdfIg898MapVWBLImpl extends BaseBLImpl implements
		PdfIg898MapVWBL {

	/** 报表字段与流程公有表单值映射关系视图DAO接口 */
	protected PdfIg898MapVWDAO pdfIg898MapVWDAO;
	
	/**
	 * 报表字段与流程公有表单值映射关系视图DAO接口设定
	 *
	 * @param pdfIg898MapVWDAO 报表字段与流程公有表单值映射关系视图DAO接口
	 */
	public void setPdfIg898MapVWDAO(PdfIg898MapVWDAO pdfIg898MapVWDAO) {
		this.pdfIg898MapVWDAO = pdfIg898MapVWDAO;
	}

	/**
	 * 报表字段与流程公有表单值映射关系视图实例取得
	 *
	 * @return 报表字段与流程公有表单值映射关系视图实例
	 */
	public PdfIg898MapVWTB getPdfIg898MapVWTBInstance() {
		return new PdfIg898MapVWTB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW() {
		return pdfIg898MapVWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public PdfIg898MapVWInfo searchPdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(PdfIg898MapVWSearchCond cond) {
		return pdfIg898MapVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW(
			PdfIg898MapVWSearchCond cond) {
		return pdfIg898MapVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PdfIg898MapVWInfo> searchPdfIg898MapVW(
			PdfIg898MapVWSearchCond cond, int start,
			int count) {
		return pdfIg898MapVWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public PdfIg898MapVWInfo registPdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		return pdfIg898MapVWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public PdfIg898MapVWInfo updatePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		checkExistInstance(new PdfIg898MapVWPK(instance.getPrid(), instance.getPidid(), instance.getPvcolpidid(), instance.getPvrownumber()));
		return pdfIg898MapVWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deletePdfIg898MapVWByPK(PdfIg898MapVWPK pk)
		throws BLException {
		pdfIg898MapVWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deletePdfIg898MapVW(PdfIg898MapVWInfo instance)
		throws BLException {
		pdfIg898MapVWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public PdfIg898MapVWInfo checkExistInstance(PdfIg898MapVWPK pk)
		throws BLException {
		PdfIg898MapVWInfo instance = pdfIg898MapVWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

    /**
     * 取得表格类型表单的行数
     *
     * @param cond 检索条件
     * @return 表格表单行数
     */
    public String getMaxRowNumber(PdfIg898MapVWSearchCond cond) throws BLException {
        return pdfIg898MapVWDAO.getMaxRowNumber(cond);
    }
}