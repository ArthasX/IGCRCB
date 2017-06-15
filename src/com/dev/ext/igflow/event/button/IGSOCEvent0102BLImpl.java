/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.dev.ext.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * SOC服务请求"处理中"节点后处理设置IG337中ppproctime字段为null
 * </p>
 */
public class IGSOCEvent0102BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0102BLImpl.class);
	
	/** 流程跳转信息记录类 */
	private IG337BL ig337BL;
	
	/**
	 * 流程跳转信息记录类设定
	 * 
	 * @param ig337BL 流程跳转信息记录类
	 */
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/**
	 * 查询类功能API类设定
	 * 
	 * @param flowSearchBL 更新功能API类查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 按钮事件处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========处理中后处理设置时间处理开始========");
		String formValue = this.flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "处理状态");
		if(formValue.equals("处理中")){//状态未进行跃迁时处理IG337表中的数据
			//获取当前IG337表的实例
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());
			cond.setPpstatus("Y");
			List<IG337Info> infoList = ig337BL.searchIG337InfoRun(cond);
			
			if(infoList != null && infoList.size()>0){
				IG337TB ig337 = (IG337TB) infoList.get(0);
				ig337.setPpproctime(null);
				ig337BL.updateIG337Info(ig337);
			}
		}
		log.debug("========处理中后处理设置时间处理结束========");
	}
}