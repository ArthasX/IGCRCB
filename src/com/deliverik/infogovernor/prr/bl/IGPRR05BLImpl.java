/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;

/**
 * 概述: 流程组BL
 * 功能描述: 流程组BL
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
public class IGPRR05BLImpl extends BaseBLImpl implements IGPRR05BL {
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGPRR05BLImpl.class);
	
	/** 流程组实例BL */
	protected IG483BL ig483BL;

	/**
	 * 流程组实例BL设定
	 * @param ig483BL 流程组实例BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}

	/**
	 * 流程组查询
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchGroupAction(IGPRR05DTO dto) throws BLException{
		log.debug("============流程组查询处理开始============");
		// 查询记录总数
		int totalCount = ig483BL.getSearchCount(dto.getIg483SearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		dto.setLst_IG483Info(this.ig483BL.searchIG483(dto.getIg483SearchCond(), pDto.getFromCount(), pDto.getPageDispCount()));
		log.debug("============流程组查询处理结束============");
		return dto;
	}
	
	/**
	 * 流程组查询
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchProcessAction(IGPRR05DTO dto) throws BLException{
		log.debug("============流程组成员查询处理开始============");
		dto.setLst_IG500Info(this.ig483BL.searchProcess(dto.getPgrid()));
		log.debug("============流程组成员查询处理结束============");
		return dto;
	}
}
