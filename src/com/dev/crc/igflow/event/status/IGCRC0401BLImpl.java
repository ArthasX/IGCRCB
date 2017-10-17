/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * 变更流程 - （部门审批）节点前处理预置发起人角色 的部门负责人为部门审批节点的审批人
 *
 * @author wanglei
 *
 */
public class IGCRC0401BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

	/** 系统管理API类 */
	private SysManageBL sysManageBL;

	/** 部门审批 */
	private String CHANGE_STATUSNAME_BMSP = "部门审批";
	
	/** 生产变更执行*/
	private String CHANGE_EXECUTE_BMSP = "生产变更执行";

	/** 数据运行中心负责人 */
	private Integer roleid_1227 = 1227;

	/** 系统网络中心负责人 */
	private Integer roleid_1228 = 1228;

	/** 软件开发中心负责人 */
	private Integer roleid_1229 = 1229;

	/** 综合管理部负责人 */
	private Integer roleid_1230 = 1230;

	/** 质量管理岗 roleid */
	private Integer roleid_1220 = 1220;

	/* 20170807 快速变更 */
	/**
	 * 快速变更审批 roleid
	 */
	private Integer roleid_ks =Integer.parseInt(MessageResources.getMessageResources("ApplicationResources").getMessage("ROLEID_KS"));// 3043;
	/**
	 * 流程查询类API
	 */
	private FlowSearchBL flowSearchBL;
	private UserRoleBL userRoleBL;
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	/* 20170807 快速变更 */



	/**
	 * 注入更新功能API类
	 *
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param 系统管理API类
	 *            the sysManagerBL to set
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String changeType = flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "变更类别");
		if (changeType.equals("快速变更")) {
            //封装查询条件对象设定
            UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();

            //封装查询条件为角色id
            cond.setRoleid(roleid_ks);

            //根据roleid获得角色下的所有人
            List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(cond);

            if (userRoleInfoList == null || userRoleInfoList.size() == 0) {
                throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
            }
            else {
                for (UserRoleInfo userRoleInfo : userRoleInfoList) {
                		// 日志参数信息设定
                        StatusParticipant participants = new StatusParticipant(
                                bean.getLogInfo());
                        // 封装流程状态名称
                        participants.setStatusname(CHANGE_EXECUTE_BMSP);
                        // 封装流程处理人id
                        participants.setUserid(userRoleInfo.getUserid());
                        // 封装流程处理角色id
                        participants.setRoleid(roleid_ks);
                        // 参与角色和参与人添加
                        flowSetBL.setStatusParticipant(participants);
                }
            }
        }
	}

	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {

		log.debug("========变更流程部门审批前处理设置参与者处理开始========");

		// 日志参数信息设定
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());

		// 封装流程状态名称
		participant.setStatusname(CHANGE_STATUSNAME_BMSP);

		// 删除跃迁节点的原有参与者
		flowSetBL.deleteStatusParticipant(participant);

		// 设置部门审批人
		setParticipant(bean);

		log.debug("========变更流程部门审批前处理设置参与者处理结束========");
	}

	/**
	 * 设置审批人   20170809 增加了快读变更的类别
	 *
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// 变更类别
		String changeType = flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "变更类别");
		if (!changeType.equals("快速变更")) {
			List<UserInfo> userInfoList = new ArrayList<UserInfo>();
			List<UserInfo> userInfos = new ArrayList<UserInfo>();
			Integer roleid = null;
			// 根据发起人机构查询节点处理人，机构id=1227为数据运行中心负责人
			List<UserInfo> userInfoList1227 = this.sysManageBL.searchUserInfo(
					roleid_1227,
					this.sysManageBL.searchUserInfo(bean.getCrtuserid())
							.getOrgid());
			if (userInfoList1227 != null && userInfoList1227.size() != 0) {
				roleid = roleid_1227;
				userInfoList.addAll(userInfoList1227);
			}
			// 根据发起人机构查询节点处理人，机构id=1228为系统网络中心负责人
			List<UserInfo> userInfoList1228 = this.sysManageBL.searchUserInfo(
					roleid_1228,
					this.sysManageBL.searchUserInfo(bean.getCrtuserid())
							.getOrgid());
			if (userInfoList1228 != null && userInfoList1228.size() != 0) {
				roleid = roleid_1228;
				userInfoList.addAll(userInfoList1228);
			}
			// 根据发起人机构查询节点处理人，机构id=1229为软件开发中心负责人
			List<UserInfo> userInfoList1229 = this.sysManageBL.searchUserInfo(
					roleid_1229,
					this.sysManageBL.searchUserInfo(bean.getCrtuserid())
							.getOrgid());
			if (userInfoList1229 != null && userInfoList1229.size() != 0) {
				roleid = roleid_1229;
				userInfoList.addAll(userInfoList1229);
				// 查询所有质量管理岗的成员
				List<UserInfo> userInfoList1220 = this.sysManageBL
						.searchUserInfo(roleid_1220, "0002");
				userInfos.addAll(userInfoList1220);
			}
			// 根据发起人机构查询节点处理人，机构id=1230为综合管理部负责人
			List<UserInfo> userInfoList1230 = this.sysManageBL.searchUserInfo(
					roleid_1230,
					this.sysManageBL.searchUserInfo(bean.getCrtuserid())
							.getOrgid());
			if (userInfoList1230 != null && userInfoList1230.size() != 0) {
				roleid = roleid_1230;
				userInfoList.addAll(userInfoList1230);
			}
			if (userInfoList == null || userInfoList.size() == 0) {
				throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
			}
			for (UserInfo userInfo : userInfoList) {

				// 日志参数信息设定
				StatusParticipant participants = new StatusParticipant(
						bean.getLogInfo());

				// 封装流程状态名称
				participants.setStatusname(CHANGE_STATUSNAME_BMSP);

				// 封装流程处理人id
				participants.setUserid(userInfo.getUserid());

				// 封装流程处理角色id
				participants.setRoleid(roleid);

				// 参与角色和参与人添加
				flowSetBL.setStatusParticipant(participants);

			}
			// 如果发起人是软件开发中心人员 则将质量管理岗的所有人员加入部门审批处理人中
			if (userInfos != null && userInfos.size() > 0) {
				for (UserInfo userInfo : userInfos) {
					if (!bean.getCrtuserid().equals(userInfo.getUserid())) {// 如果发起人在处理人中,则去掉发起人
						// 日志参数信息设定
						StatusParticipant participants = new StatusParticipant(
								bean.getLogInfo());
						// 封装流程状态名称
						participants.setStatusname(CHANGE_STATUSNAME_BMSP);
						// 封装流程处理人id
						participants.setUserid(userInfo.getUserid());
						// 封装流程处理角色id
						participants.setRoleid(roleid_1220);
						// 参与角色和参与人添加
						flowSetBL.setStatusParticipant(participants);
					}
				}
			}
		} else {

	        //封装查询条件对象设定
	        UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();

	        //封装查询条件为角色id
	        cond.setRoleid(roleid_ks);

	        //根据roleid获得角色下的所有人
	        List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(cond);

			if (userRoleInfoList == null || userRoleInfoList.size() == 0) {
				throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
			}
			else {
				for (UserRoleInfo userRoleInfo : userRoleInfoList) {
					if (!bean.getCrtuserid().equals(userRoleInfo.getUserid())) {// 如果发起人在处理人中,则去掉发起人
						// 日志参数信息设定
						StatusParticipant participants = new StatusParticipant(
								bean.getLogInfo());
						// 封装流程状态名称
						participants.setStatusname(CHANGE_STATUSNAME_BMSP);
						// 封装流程处理人id
						participants.setUserid(userRoleInfo.getUserid());
						// 封装流程处理角色id
						participants.setRoleid(roleid_ks);
						// 参与角色和参与人添加
						flowSetBL.setStatusParticipant(participants);
					}
				}
			}
		}
	}
}
