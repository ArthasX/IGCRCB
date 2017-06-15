/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:市局运维发起区局运维 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0203BLImpl implements WorkFlowEventHandlerBL{

	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 流程处理api */
	protected FlowOptBL flowOptBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/** 流BL */
	protected IG500BL ig500BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;
	
	/**
	 * 机构BL设定
	 * @param organizationBL 机构BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 流BL设定
	 * @param ig500BL 流BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * 查询类api设定
	 * @param flowSearchBL 查询类api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 流程处理api设定
	 * @param flowOptBL 流程处理api
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	/**
	 * 更新类api设定
	 * @param flowSetBL 更新类api
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
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String flag = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "是否是区局运维");
		if("是".equals(flag)){
			
			//流程相关发起人ID
			String userid = bean.getLogInfo().getExecutorid();
			//流程相关发起人角色ID
			Integer roleid = bean.getLogInfo().getExecutorRoleid();
			
			//查询区局待发起节点角色下的一个人	1031
			UserRoleBL userRoleBL = (UserRoleBL)WebApplicationSupport.getBean("userRoleBL");
			
			UserRoleSearchCondImpl userRoleSearchCondImpl = new UserRoleSearchCondImpl();
			
			userRoleSearchCondImpl.setRoleid(1031);
			
			List<UserRole> listOfUserRole = userRoleBL.searchUserRole(userRoleSearchCondImpl);
			
			//随便取一个人作为发起人	如果没有人则用当前节点德处理人代替
			if(CollectionUtils.isNotEmpty(listOfUserRole)){
				userid = listOfUserRole.get(0).getUserid();
				roleid = 1031;
			}
			
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(userid);//设置发起人ID
			logInfo.setExecutorRoleid(roleid);//设置发起人角色ID
			
			IG500BL ig500BL = (IG500BL)WebApplicationSupport.getBean("ig500BL");
			
			FlowOptBL flowOptBL = (FlowOptBL)WebApplicationSupport.getBean("flowOptBL");
			
			IG512BL ig512BL = (IG512BL)WebApplicationSupport.getBean("ig512BL");
			
			IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
			
			//发起区局流程
			ProcessRecord processRecord = new ProcessRecord(logInfo);//待发起时没有相应的流程处理日志
			processRecord.setCrtuserid(userid);//设置流程发起人ID
			processRecord.setDefid("01280");//设置流程定义ID省级流程ID为01060
			processRecord.setDefstatus("a");//设置流程状态_启动的才发起
			processRecord.setDescription(ig500Info.getPrdesc());//设置描述
			//没有需要初始化的表单
			//processRecord.setFormvalue(valueMap);//设置表单信息值
			processRecord.setRoleid(roleid);//设置流程发起人角色ID
			processRecord.setTitle(ig500Info.getPrtitle());//设置名称
			//发起相关省级流程
			int districtPrid = flowOptBL.initProcessAction(processRecord);
			
			IG512TB ig512TB = new IG512TB();
			//父流程prid
			ig512TB.setParprid(bean.getLogInfo().getPrid());
			//子流程prid
			ig512TB.setCldprid(districtPrid);
			//处理时间
			ig512TB.setPrrinstime(IGStringUtils.getCurrentDateTime());
			
			ig512BL.registIG512Info(ig512TB);
			
			
			
			
			
			
//			List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
//			ProcessRecord record = new ProcessRecord(bean.getLogInfo());
//			record.setCrtuserid(bean.getLogInfo().getExecutorid());
//			record.setDefid("0130001");
//			record.setTitle(processInfos.get(0).getPrtitle() + "下发的区局运维");
//			record.setDescription(processInfos.get(0).getPrtitle() + "下发的区局运维");
//			record.setRoleid(bean.getLogInfo().getExecutorRoleid());
//			Integer prid = flowOptBL.initProcessAction(record);
//			flowSetBL.setProcessRelation(bean.getLogInfo().getPrid(), prid);
			
			
			//String orgname = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "下发机构");
//			if(StringUtils.isNotEmpty(orgname)){
//				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
//				cond.setOrgname(orgname);
//				List<Organization> list = organizationBL.searchOrganization(cond);
//				if(list != null && list.size() > 0){
//					IG500Info ig500 = ig500BL.searchIG500InfoByKey(prid);
//					IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500);
//					ig500TB.setProrgid(list.get(0).getOrgsyscoding());
//					ig500TB.setProrgname(orgname);
//					ig500BL.updateIG500Info(ig500TB);
//				}
//			}
		}
	}

}
