/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.pub.igflow.event.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询角色下的所有人并设置成参与人
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPUB0102BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGPUB0102BLImpl.class);
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 角色BL设定
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 用户角色BL设定
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("=================设置执行人开始=================");
		//查询参与人定义
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());
		cond.setPsdid(bean.getAfstatus());
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(bean.getAfstatus());
		//查询参与者
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		//角色信息集合
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(IG337Info info:lst_ProcessParticipant){
			set.add(info.getPproleid());
			workFlowOperationBL.removeProcessParticipant(info);
		}
		String dateTime = IGStringUtils.getCurrentDateTime();
		Set<String> userSet = new HashSet<String>();
		//查询角色用户
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//参与者角色
			Role role = roleBL.searchRoleByKey(roleid);
			UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
			urcond.setRoleid(roleid);//角色ID
			//查询角色负责人
			List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(urcond);
			
			for(UserRoleInfo ur:lst_UserRole){
				if(!userSet.contains(ur.getUserid())){
					userSet.add(ur.getUserid());
					IG337TB instance = new IG337TB();
					instance.setPrid(bean.getLogInfo().getPrid());
					instance.setPsdid(psd.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
					instance.setPpinittime(dateTime);
					instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					instance.setPpuserid(ur.getUserid());
					instance.setPpusername(ur.getUsername());
					instance.setPporgid(ur.getOrgid());
					instance.setPporgname(ur.getOrgname());
					instance.setPproleid(role.getRoleid());
					instance.setPprolename(role.getRolename());
					workFlowOperationBL.addProcessParticipant(instance);
					
				}
			}
		}
		log.debug("=================设置执行人结束=================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
