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
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM3101ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;

/**
 * @功能描述：1.风险指标查询结果导出处理 2.风险指标自定义查询
 * @创建者： hujuwen
 * @创建时间：2014/07/26
 * 
 * @Version V1.0
 */
public class IGASM3101ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM3101ExcelBL {

	/** 日志对象 */
	private static final Log log = LogFactory
			.getLog(IGASM3101ExcelBLImpl.class);

	/** 风险sysconding默认值 */
	protected static final String SYSCODE = "999019";

	/**风险指标查询*/
	protected RiskIndexSearchVWBL riskIndexSearchVWBL;
	

	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * 获取导出相应信息编写Excel文件，并输出。
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================风险指标查询结果导出处理开始=================");
		// 实例化DTO
		IGASM3101ExcelDTO exceldto = (IGASM3101ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		// 获得查询到的list集合
		List<RiskIndexSearchVWInfo> processList = exceldto.getProcessList();
		// 写入各个单元格
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// 获取流程对象
				RiskIndexSearchVWInfo info = processList.get(i);
				// 填充风险领域
				addCell(0, i, info.getRiskly());
				// 填充风险域
				addCell(1, i, info.getRiskarea());
				// 填充风险项
				addCell(2, i, info.getRiskitem());
				// 填充指标编号
				addCell(3, i, info.getEilabel());
				// 填充指标名称
				addCell(4, i, info.getEiname());
				// 填充指标用途
				addCell(5, i, info.getIndexused());
				// 填充阀值
				addCell(6, i, info.getZbfz());
				// 填充是否关键指标
				addCell(7, i, info.getKeyindex());
				// 填充指标管理人
				addCell(8, i, info.getMgusername());
				// 填充指标责任部门
				addCell(9, i, info.getDutydepartment());
				// 填充指标责任人
				addCell(10, i, info.getDutyuser());
			}
		}
		log.debug("=================风险指标查询结果导出处理结束=================");
		return dto;
	}

	/**
	 * 风险指标自定义查询
	 * 
	 * @rerturn dto
	 */
	public IGASM31DTO searchRiskPointManagerAction(IGASM31DTO dto)
			throws BLException {

		IGASM3101Form form = dto.getIGASM3101FORM();
		/** 风险指标查询条件设定 */
		RiskIndexSearchVWSearchCondImpl cond  = new RiskIndexSearchVWSearchCondImpl();
		
		cond.setEiname(form.getEiname());//指标名称
		cond.setEilabel(form.getEilabel());//指标编号
		cond.setIndexused(form.getIndexused());//指标用途
		cond.setZbfz(form.getZbfz());//阀值
		cond.setDutyuser(form.getDutyuser());//指标责任人
		cond.setDutydepartment(form.getDutydepartment());//指标责任部门
		cond.setKeyindex(form.getKeyindex());//是否关键指标
		cond.setMguserid(form.getMguserid());//指标管理人
		cond.setEiStartDate(form.getEiStartDate());//登记日期开始
		cond.setEiEndDate(form.getEiEndDate());//登记日期结束
		cond.setEuStartDate(form.getEuStartDate());//更新日期开始
		cond.setEuEndDate(form.getEuEndDate());//更新日期结束
		/**设定风险分类 syscoding码*/
		if(null==form.getEsyscoding()||"".equals(form.getEsyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(form.getEsyscoding());
		}
		/** 调用taskBL查询 */
		List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList = riskIndexSearchVWBL.searchRiskIndexSearchVW(cond, 0, 0);
		dto.setSearchRiskIndexSearchVWList(searchRiskIndexSearchVWList);
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
