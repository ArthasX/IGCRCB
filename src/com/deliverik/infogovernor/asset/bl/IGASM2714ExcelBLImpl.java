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
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.dto.IGASM2714ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;

/**
 * @功能描述：1.风险点查询结果导出处理 2.风险点自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/22
 * 
 * @Version V1.0
 */
public class IGASM2714ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM2714ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGASM2714ExcelBLImpl.class);

	/** 风险sysconding默认值 */
	protected static final String SYSCODE = "999017";

	/** 风险点查询TaskBl接口 */
	protected RiskPointVMBL riskPointVMBL;
	
	protected UserBL userBL;

	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================风险点查询结果导出处理开始=================");
		// 实例化DTO
		IGASM2714ExcelDTO exceldto = (IGASM2714ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<RiskPointVMInfo> processList = exceldto.getProcessList();
		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取流程对象
				RiskPointVMInfo info = processList.get(i);
				// 填充风险领域
				addCell(0, i, info.getRiskly());
				// 填充风险子域
				addCell(1, i, info.getRiskarea());
				// 填充风险项
				addCell(2, i, info.getRiskitem());
				// 填充风险点编号
				addCell(3, i, info.getEilabel());
				// 填充风险点名称
				addCell(4, i, info.getEiname());
				// 填充风险级别
				addCell(5, i, info.getLevels());
				// 填充风险严重等级
				addCell(6, i, info.getGrad());
				// 填充风险发生可能性
				addCell(7, i, info.getPoss());
				// 填充管理人
				addCell(8, i, info.getMguserid());
			}
		}

		log.debug("=================风险点查询结果导出处理结束=================");
		return dto;
	}

	/**
	 * 风险点自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)
			throws BLException {

		IGASM2713Form form = dto.getIgasm2713Form();
		/** 风险查询条件设定 */
		RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
		cond.setEilabel(form.getEilabel());
		cond.setEiname(form.getEiname());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		cond.setGrad(form.getGrad());
		cond.setPoss(form.getPoss());
		cond.setRisksign(form.getRisksign());
		cond.setMguserid(form.getMguserid());
		/** 设定风险分类 */
		if (null == form.getSyscoding() || "".equals(form.getSyscoding())) {
			cond.setSyscoding(SYSCODE);
		} else {
			cond.setSyscoding(form.getSyscoding());
		}
		/** 调用taskBL查询 */
		List<RiskPointVMInfo> riskList = riskPointVMBL.searchRiskPointVM(cond,
				0, 0);
		
		dto.setRiskList(riskList);
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
