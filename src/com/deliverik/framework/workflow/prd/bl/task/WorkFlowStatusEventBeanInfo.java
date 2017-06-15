/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.igflow.parameter.WorkFlowLogInfo;

/**
 * 概述: 前后处理参数定义接口
 * 功能描述: 前后处理参数定义接口
 * 创建记录: 2012/04/13
 * 修改记录: 
 */
public interface WorkFlowStatusEventBeanInfo {
	
		/**
		 * 流程定义ID（包括版本信息）取得
		 * @return 流程定义ID（包括版本信息）
		 */
		public String getPdid();
		
		/**
		 * 处理按钮ID取得
		 * @return 处理按钮ID
		 */
		public String getPbdid();
		
		/**
		 * 跃迁前状态标识取得
		 * @return 跃迁前状态标识
		 */
		public String getBfstatus();
		
		/**
		 * 跃迁后状态标识取得
		 * @return 跃迁后状态标识
		 */
		public String getAfstatus();
		
		/**
		 * 流程发起者ID取得
		 * @return 流程发起者ID
		 */
		public String getCrtuserid();
		
		/**
		 * 流程发起角色ID取得
		 * @return 流程发起角色ID
		 */
		public Integer getCrtroleid();
		
		/**
		 * 动态分支编号取得
		 * @return psdnum 动态分支编号
		 */
		public Integer getPsdnum();
		
		/**
		 * 日志参数信息取得
		 * 
		 * @return 日志参数信息
		 */
		public WorkFlowLogInfo getLogInfo();

}
