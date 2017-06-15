/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.smr.bl.task.ReportHistoryVWBL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.form.IGSMR0502Form;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表相关业务逻辑处现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR05BLImpl extends BaseBLImpl implements IGSMR05BL{
	
	private static Log log = LogFactory.getLog(IGSMR05BLImpl.class);

	/** 报表历史填报记录视图BL */
	protected ReportHistoryVWBL reportHistoryVWBL;
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/**
	 * 报表历史填报记录视图BL设定
	 * @param reportHistoryVWBL 报表历史填报记录视图BL
	 */
	public void setReportHistoryVWBL(ReportHistoryVWBL reportHistoryVWBL) {
		this.reportHistoryVWBL = reportHistoryVWBL;
	}
	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	/**
	 * 查询分组信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchRegulatoryHistoryListAction(IGSMR05DTO dto) throws BLException{
		log.debug("==============查询分组信息操作开始===============");
		//参数取得
		IGSMR0501Form form = dto.getIgsmr0501Form();
		//实例化查询条件
		ReportHistoryVWSearchCondImpl cond = new ReportHistoryVWSearchCondImpl();
		cond.setPdid(form.getPdid());
		cond.setPrtype(form.getPrtype());
		cond.setCurrentPrid(form.getCurrentPrid());
		List<ReportHistoryVWInfo> reportHistoryVWInfoList = reportHistoryVWBL.searchReportHistoryVWInfoList(cond);
		dto.setReportHistoryVWInfoList(reportHistoryVWInfoList);
		log.debug("==============查询分组信息操作结束===============");
		return dto;
	}
	
	/**
	 * 填报说明查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchReportDescAction(IGSMR05DTO dto) throws BLException {
		log.debug("===============填报说明查询操作开始===============");
		//dto参数取得
		IGSMR0502Form form = dto.getIgsmr0502Form();
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(form.getPdid());
		if(pd != null){
			form.setReportdesc(pd.getReportdesc());
		}
		log.debug("===============填报说明查询操作结束===============");
		return dto;
	}
}
