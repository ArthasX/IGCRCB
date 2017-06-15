/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.vim.igflow.event.status;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM07BL;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM07TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设置调整信息
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM0401BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 虚机调整信息BL */
	protected VIM07BL vim07BL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 虚机调整信息BL设定
	 * @param vim07BL 虚机调整信息BL
	 */
	public void setVim07BL(VIM07BL vim07bl) {
		this.vim07BL = vim07bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//查询表单值
		String value = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "调整信息");
		if(StringUtils.isNotEmpty(value)){
			String[] ids = value.split("#");
			if(ids != null && ids.length > 0){
				for(String id:ids){
					VIM07TB entity = (VIM07TB) vim07BL.searchVim07ByPK(Integer.valueOf(id));
					entity.setPrid(bean.getLogInfo().getPrid());
					vim07BL.updateVim07(entity);
				}
			}
		}
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
