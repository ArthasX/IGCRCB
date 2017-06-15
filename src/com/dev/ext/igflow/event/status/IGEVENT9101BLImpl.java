/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 问题整改
 * @author Administrator
 *
 */
public class IGEVENT9101BLImpl extends BaseBLImpl implements
WorkFlowEventHandlerBL{
	
	 	/** 日志对象取得 */
		static Log log = LogFactory.getLog(IGEVENT9101BLImpl.class);
		
		/** 查询类功能API类 */
		private FlowSearchBL flowSearchBL;
		
		/** 用户角色处理BL */
		private UserRoleBL userRoleBL;
		
		/** 更新功能API类 */
		private FlowSetBL flowSetBL;
		
		/**
		 * 注入flowSearchBL
		 * 
		 * @param flowSearchBL
		 */
		public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
			this.flowSearchBL = flowSearchBL;
		}
		
		/**
		 * 注入用户角色处理BL
		 * 
		 * @param userRoleBL
		 */
		public void setUserRoleBL(UserRoleBL userRoleBL) {
			this.userRoleBL = userRoleBL;
		}
		
		/**
		 * 注入更新功能API类
		 * 
		 * @param flowSetBL
		 */
		public void setFlowSetBL(FlowSetBL flowSetBL) {
			this.flowSetBL = flowSetBL;
		}

		/**
		 * 前处理添加参与者
		 */
		public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
				throws BLException {
		    
		    log.debug("========问题整改前处理设置参与者处理开始========");
		    
		    //跃迁节点的参与者信息取得
			List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "待发起");
			
	        //日志参数信息设定
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //封装流程状态名称
	        participant.setStatusname("审批");
	        
	        //删除跃迁节点的原有参与者
	        flowSetBL.deleteStatusParticipant(participant);
	        
	        int oldroleid = 0;
	        
			for (ParticipantInfo ppInfo : pInfoList) {
			    
			    //跃迁节点的参与者roleid取得
			    int roleidF = ppInfo.getRoleid();   
			    
			    if (roleidF == oldroleid) {
			        continue;
			    } else {
			        oldroleid = roleidF;
			    }
			    
			    //封装查询条件对象设定
			    UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			    
			    //封装查询条件为角色id
			    cond.setRoleid(roleidF);
			    
			    //封装查询条件为角色负责人
			    //cond.setRolemanager(true);
			    
			    //获得角色负责人
			    List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(cond);

			    //迭代角色下用户信息
			    if (roleList != null && roleList.size() > 0) {

		            //设置跃迁节点的参与者
		            for(UserRoleInfo role :roleList){
		                
		                //日志参数信息设定
		                StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
		                
		                //封装流程状态名称
		                participants.setStatusname("审批");
		                
		                //封装流程处理人id
		                participants.setUserid(role.getUserid());
		                
		                //封装流程处理角色id
		                participants.setRoleid(roleidF);
		                
		                //参与角色和参与人添加
		                flowSetBL.setStatusParticipant(participants);
		            }
			    } else {
			        throw new BLException("IGPRR0102.E011", pInfoList.get(0)
		                    .getRolename());
			    }
			}

			log.debug("========问题整改前处理设置参与者处理结束========");

		}

		public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
				throws BLException {
			

		}
}
