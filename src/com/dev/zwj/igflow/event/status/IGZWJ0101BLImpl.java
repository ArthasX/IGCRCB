/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.zwj.igflow.event.status;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 一般事件发候的相关表单预置
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0101BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL; 
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/** 系统类API */
	protected SysManageBL sysManageBL;
	
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 查询类API设定
	 * @param sysManageBL 查询类API
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) 
			throws BLException {
		//查询发起人信息
		UserInfo user = sysManageBL.searchUserInfo(bean.getCrtuserid());
		//查询报告人名称
		PublicProcessInfoValue value = new PublicProcessInfoValue(bean.getLogInfo());
		String formValue = null;
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "报告人姓名");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("报告人姓名");
			value.setFormvalue(user.getUsername());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "报告人联系方式");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("报告人联系方式");
			value.setFormvalue(user.getUsermobile());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "报告人邮件");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("报告人邮件");
			value.setFormvalue(user.getUseremail());
			flowSetBL.setPublicProcessInfoValue(value);
		}
		formValue = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "报告人科室");
		if(StringUtils.isEmpty(formValue)){
			value.setFormname("报告人科室");
			value.setFormvalue(user.getOrgid() + "_OrgTree_" + user.getOrgname());
			flowSetBL.setPublicProcessInfoValue(value);
		}
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
