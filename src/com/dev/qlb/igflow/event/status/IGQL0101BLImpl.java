/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.qlb.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * 变更一级审批后后处理
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0101BLImpl.class);
	
	/** 查询类API */
	private FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/** 系统类BL */
	protected SysManageBL sysManageBL;
	
	/**
	 * @param 系统类BL the sysManageBL to set
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * @param 更新功能API类 the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================变更一级审批后处理开始=====================");
		
		//表单值取得
//		String appL = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "当前审批人等级");
		//是否有审批人
		List<ParticipantInfo> list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "二级审批");
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		if(null != list){
			//跃迁到执行节点，并将合作人添加执行人中
			value.setFormname("当前审批人等级");
			value.setFormvalue("2");
			flowSetBL.setPublicProcessInfoValue(value);
		}else{
			//跃迁到执行节点，并将合作人添加执行人中
			value.setFormname("当前审批人等级");
			value.setFormvalue("0");
			flowSetBL.setPublicProcessInfoValue(value);
		}
		
		log.debug("=====================变更一级审批后处理结束=====================");
	}
}
