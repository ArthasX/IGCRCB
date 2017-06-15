/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.bl.task.CheckItemVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM2814ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;
import com.deliverik.infogovernor.asset.form.IGASM2814Form;
import com.deliverik.infogovernor.asset.model.CheckItemVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckItemVWSearchCondImpl;

/**
 * @功能描述：1.检查项查询结果导出处理 2.检查项自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/23
 * 
 * @Version V1.0
 */
public class IGASM2814ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM2814ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGASM2814ExcelBLImpl.class);
	/** 风险sysconding默认值 */
	protected static final String SYSCODE = "999018";

	/** 检查项资产查询 */
	protected CheckItemVWBL checkItemVWBL;

	/**
	 * 检查项资产查询设定
	 * 
	 * @param checkItemVWBL
	 *            检查项资产查询
	 */
	public void setCheckItemVWBL(CheckItemVWBL checkItemVWBL) {
		this.checkItemVWBL = checkItemVWBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================检查项查询结果导出处理开始=================");
		// 实例化DTO
		IGASM2814ExcelDTO exceldto = (IGASM2814ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<CheckItemVWInfo> itemList = exceldto.getItemList();
		// 写入各个单元格
		if (itemList != null && itemList.size() > 0) {
			for (int i = 0; i < itemList.size(); i++) {
				// 获取流程对象
				CheckItemVWInfo info = itemList.get(i);
				// 填充风险领域
				addCell(0, i, info.getRiskly());
				// 填充风险子域
				addCell(1, i, info.getRiskarea());
				// 填充风险项
				addCell(2, i, info.getRiskitem());
				// 填充编号
				addCell(3, i, info.getEilabel());
				// 填充风险点名称
				addCell(4, i, info.getEiname());
				// 填充风险点说明
				addCell(5, i, info.getEidesc());
				// 填充管理人
				addCell(6, i, info.getMguserid());
				// 填充登记日
				addCell(7, i, info.getEiinsdate());
				// 填充建议检查频度
				addCell(8, i, info.getCheckfrequency());
			}
		}
		log.debug("=================检查项查询结果导出处理结束=================");
		return dto;
	}

	/**
	 * 检查项自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto)
			throws BLException {

		IGASM2814Form form = dto.getIgasm2814form();
		/** 检查项查询条件设定 */
		CheckItemVWSearchCondImpl cond = new CheckItemVWSearchCondImpl();
		cond.setEiname(form.getEiname());
		cond.setManagername(form.getMguserid());
		cond.setBh(form.getEilabel());
		cond.setCheckfrequency(form.getCheckfrequency());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		/** 设定风险分类 syscoding码 */
		if (null == form.getSyscoding() || "".equals(form.getSyscoding())) {
			cond.setSyscoding(SYSCODE);
		} else {
			cond.setSyscoding(form.getSyscoding());
		}
		/** 检查项资产查询 */
		List<CheckItemVWInfo> itemList = this.checkItemVWBL.searchCheckItemVW(
				cond, 0, 0);
		/** 查询结果集set到dto */
		dto.setItemList(itemList);
		return dto;
	}
}
