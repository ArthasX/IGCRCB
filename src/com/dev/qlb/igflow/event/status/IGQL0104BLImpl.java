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
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * 指派工作转派执行人前处理，将执行人添加到执行人审核节点
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0104BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0104BLImpl.class);
	
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
		log.debug("=====================将执行人添加到执行人审核节点处理开始=====================");
		//删除执行审核节点原有审核人
		List<ParticipantInfo>  dellist = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "执行审核");
		if(null != dellist && dellist.size() >0){
			for(ParticipantInfo info:dellist){
				StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
				participant.setStatusname("执行审核");
				participant.setRoleid(info.getRoleid());
				participant.setUserid(info.getUserid());
				flowSetBL.deleteStatusParticipant(participant);
			}
		}
		
		//查询当前状态
		List<ParticipantInfo>  list = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "执行");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("执行审核");
		for(ParticipantInfo info:list){
			participant.setRoleid(info.getRoleid());
			participant.setUserid(info.getUserid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		log.debug("=====================将执行人添加到执行人审核节点处理结束=====================");
	}
}
