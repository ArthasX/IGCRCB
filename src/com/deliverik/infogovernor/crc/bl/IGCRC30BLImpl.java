/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对外服务管理BL实现
 * </p>
 * 
 * @author zhangxinru
 */
public class IGCRC30BLImpl extends BaseBLImpl implements IGCRC30BL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC30BLImpl.class);

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;



	/**
	 * 流程处理BL设定
	 * 
	 * @param workFlowOperationBL
	 *            流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	
	/**
	 * 流程定义BL设定
	 * 
	 * @param workFlowDefinitionBL
	 *            流程定义BL
	 */
	public void setWorkFlowDefinitionBL(
			WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}


	/**
	 * 导出对外服务管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC30DTO getExcelDataList(IGCRC30DTO dto) throws BLException {
		log.debug("=================获取对外服务管理相应数据集开始=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if (StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())) {
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// 查询流程信息条件
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// 对外服务管理类型编号
		cond.setPrpdid(form.getPrpdid());
		this.copyProperties(cond,dto.getIgwkm0101form());
		// 查询流程信息
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0, form.getType()));

		// 查询表单信息条件
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// 对外服务类型编号
		processInfoCond.setPdid(form.getPrpdid());
		// 查询表单信息
		dto.setProcessInfoList(workFlowOperationBL.searchProcessInfoByCond(processInfoCond));

		// 查询参与人信息条件(暂无)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// 查询参与人信息
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));

		// 查询流状态定义信息条件
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// 对外服务类型编号
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// 查询流状态定义
		dto.setProcessStatusDefList(workFlowDefinitionBL.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================获取对外服务管理相应数据集结束=================");
		return dto;
	}

}
