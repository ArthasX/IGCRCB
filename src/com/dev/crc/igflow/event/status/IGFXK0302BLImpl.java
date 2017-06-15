/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.infogovernor.fxk.bl.IGFXK03BLType;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台-风险计划执行节点前处理
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @version 1.0
 */
public class IGFXK0302BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	protected IG898BL ig898BL;
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	public void setIg898BL(IG898BL ig898BL) {
		this.ig898BL = ig898BL;
	}
	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//表格式表单查询实例生成
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());	//流程信息主键(prid)
		cond.setPidname(IGFXK03BLType.RISK_TABLE_NAME); //查询的表格式表单名称
		
		//查询指定流程信息中的表格式表单“工作列表”的所有信息
		List<IG898Info> lst_ig898_job = ig898BL.searchIG898(cond);
		//遍历关联工作信息，如果关联工作中没有记录值，查询对应的工作提醒时间
		if(lst_ig898_job != null && lst_ig898_job.size() > 0){	//begin if3
			//封装工作列表集合和Map信息
			List<IG898Info> lst_job = new ArrayList<IG898Info>();
			
			//遍历流程的表格式表单
			for (IG898Info ig898Info : lst_ig898_job) {
				//封装关联工作的集合
				if(IGFXK03BLType.RISK_TABLE_NAME_COLNAMEUM_MANAGER.equals(ig898Info.getPvcolname())){
					lst_job.add(ig898Info);
				}
			}
			//获取负责人信息
			List<String> lst_user = new ArrayList<String>();
			for (IG898Info ig898Info : lst_job) {
				//获取发起人ID(负责人ID)
				//获取发起人角色ID(负责人角色ID)
				if(!lst_user.contains(ig898Info.getPvalue())){
					String userid = ig898Info.getPvalue().split("_user_")[0];
					Integer roleid = Integer.valueOf(ig898Info.getPvalue().split("_user_")[2]);
					StatusParticipant statusParticipantInfo = new StatusParticipant(bean.getLogInfo());
				    statusParticipantInfo.setRoleid(roleid);
				    statusParticipantInfo.setUserid(userid);
				    statusParticipantInfo.setStatusname("执行");
				    flowSetBL.setStatusParticipant(statusParticipantInfo);
				    
				    lst_user.add(ig898Info.getPvalue());
				}
				
			}
		}
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}
}
