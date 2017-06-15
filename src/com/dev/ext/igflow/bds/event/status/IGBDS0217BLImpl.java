/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 预置处理人
 * </p>
 * 
 * @author zhangze@deliverik.com
 * @version 1.0
 */
public class IGBDS0217BLImpl implements WorkFlowEventHandlerBL{

	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/** userRole */
	protected UserRoleBL userRoleBL;
	
	/** ig500BL */
	protected IG500BL ig500BL;
	
	/** flowOptBL */
	protected FlowOptBL flowOptBL;
	
	/** ig512BL */
	protected IG512BL ig512BL;
	
	/**
	 * 查询类api设定
	 * @param flowSearchBL 查询类api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类api设定
	 * @param flowSetBL 更新类api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * userRole设定
	 * @param userRole
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * ig500BL设定
	 * @param ig500BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	
	/**
	 * flowOptBL 设定
	 * @param flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	
	/**
	 * ig512BL 设定
	 * @param ig512BL
	 */
	public void setIg512BL(IG512BL ig512BL) {
		this.ig512BL = ig512BL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		//流程相关发起人ID
		String userid = bean.getLogInfo().getExecutorid();
		//流程相关发起人角色ID
		Integer roleid = bean.getLogInfo().getExecutorRoleid();
		
		//查询市局待发起节点角色下的一个人	1029
		//UserRoleBL userRoleBL = (UserRoleBL)WebApplicationSupport.getBean("userRoleBL");
		
		UserRoleSearchCondImpl userRoleSearchCondImpl = new UserRoleSearchCondImpl();
		
		userRoleSearchCondImpl.setRoleid(1029);
		
		List<UserRole> listOfUserRole = userRoleBL.searchUserRole(userRoleSearchCondImpl);
		
		//随便取一个人作为发起人	如果没有人则用当前节点德处理人代替
		if(CollectionUtils.isNotEmpty(listOfUserRole)){
			userid = listOfUserRole.get(0).getUserid();
			roleid = 1029;
		}
		
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setExecutorid(userid);//设置发起人ID
		logInfo.setExecutorRoleid(roleid);//设置发起人角色ID
		//改为发起人s的username
		//String comment = "由县级"+ig500Info.getProrgname()+"的"+ig500Info.getPrusername()+"发起";
		//logInfo.setComment(comment);//设置日志内容
		
		//IG500BL ig500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
		
		//FlowOptBL flowOptBL = (FlowOptBL)WebApplicationSupport.getBean("flowOptBL");
		
		//IG512BL ig512BL = (IG512BL)WebApplicationSupport.getBean("ig512BL");
		
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		
		//发起市局流程
		ProcessRecord processRecord = new ProcessRecord(logInfo);//待发起时没有相应的流程处理日志
		processRecord.setCrtuserid(userid);//设置流程发起人ID
		processRecord.setDefid("01220");//设置流程定义ID省级流程ID为01060
		processRecord.setDefstatus("a");//设置流程状态_启动的才发起
		processRecord.setDescription(ig500Info.getPrdesc());//设置描述
		//没有需要初始化的表单
		//processRecord.setFormvalue(valueMap);//设置表单信息值
		processRecord.setRoleid(roleid);//设置流程发起人角色ID
		processRecord.setTitle(ig500Info.getPrtitle());//设置名称
		//发起相关省级流程
		int cityPrid = flowOptBL.initProcessAction(processRecord);
		
		IG512TB ig512TB = new IG512TB();
		//父流程prid
		ig512TB.setParprid(bean.getLogInfo().getPrid());
		//子流程prid
		ig512TB.setCldprid(cityPrid);
		//处理时间
		ig512TB.setPrrinstime(IGStringUtils.getCurrentDateTime());
		
		ig512BL.registIG512Info(ig512TB);
		
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
