/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * 问题整改管理待发起的后置处理
 * @time 2014/06/18
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGFXK0601BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGFXK0601BLImpl.class);
	
	/** 查询类API */
	private FlowSearchBL flowSearchBL;
	
	/** 流程更新API */
	private FlowSetBL flowSetBL;
	
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 流程更新API设定
	 * @param flowSetBL 流程更新API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {		
	}

	/**
	 * 后处理
	 * 功能:
	 *     对下拉框 是否分分派进行赋值，控制流程是否需要进入分派节点
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================问题整改管理待发起的后置处理开始=====================");
		
		/** 获取整改计划执行的参与人列表 */
		List<ParticipantInfo> listExe = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "整改计划执行");
		
		/** 公有表单信息对象 */
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		
		/** 对是否分派表单赋值 */
		value.setFormname("是否分派");
		
		/** 判断整改计划执行的参与人列表是否人参与人，如果有，为是否分派下拉框赋值为2，表示不用分派；否则，赋值为1，表示需要分派 */
		if(listExe == null || listExe.isEmpty()){
			/** 不存在参与人，赋值为1 */
			value.setFormvalue("1");
		}else{
			/** 存在参与人，赋值为2 */
			value.setFormvalue("2");
		}
		
		/** 表单信息更新 */
		flowSetBL.setPublicProcessInfoValue(value);
		
		log.debug("=====================问题整改管理待发起的后置处理结束=====================");
	
	}
	
	
}
